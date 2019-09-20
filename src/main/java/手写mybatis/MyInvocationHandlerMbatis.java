package 手写mybatis;

import 手写mybatis.annotation.ExtInsert;
import 手写mybatis.annotation.ExtParam;
import 手写mybatis.annotation.ExtSelect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MyInvocationHandlerMbatis implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //System.out.println("使用动态代理技术拦截方法");
        ExtInsert extInsert = method.getDeclaredAnnotation(ExtInsert.class);
        if(extInsert!=null){
             return  extInsert(extInsert,proxy,method,args);
        }
        //2:查询的思路
        ExtSelect extSelect = method.getDeclaredAnnotation(ExtSelect.class);
        if(extSelect!=null){
            // 2. 获取注解上查询的SQL语句
            String selectSQL = extSelect.value();
            // 3. 获取方法上的参数,绑定在一起
            ConcurrentHashMap<Object, Object> paramsMap = paramsMap(proxy, method, args);
            // 4. 参数替换？传递方式
            List<String> sqlSelectParameter = SQLUtils.sqlSelectParameter(selectSQL);
            // 5.传递参数
            List<Object> sqlParams = new ArrayList<>();
            for (String parameterName : sqlSelectParameter) {
                Object parameterValue = paramsMap.get(parameterName);
                sqlParams.add(parameterValue);
            }
            // 6.将sql语句替换成?
            String newSql = SQLUtils.parameQuestion(selectSQL, sqlSelectParameter);
            System.out.println("newSQL:" + newSql + ",sqlParams:" + sqlParams.toString());

            // 5.调用jdbc代码底层执行sql语句
            // 6.使用反射机制实例对象### 获取方法返回的类型，进行实例化
            // 思路:
            // 1.使用反射机制获取方法的类型
            // 2.判断是否有结果集,如果有结果集，在进行初始化
            // 3.使用反射机制,给对象赋值

            ResultSet res = JDBCUtils.query(newSql, sqlParams);
            if(!res.next()){
               return  null;
            }
            res.previous();
            Class<?> returnType = method.getReturnType();
            Object newInstance = returnType.newInstance();
            while (res.next()) {
                Field[] declaredFields = returnType.getDeclaredFields();
                for(Field field:declaredFields){
                    String fieldName = field.getName();
                    Object fileldValue = res.getObject(fieldName);
                    field.set(newInstance,fileldValue);
                }
            }
            return newInstance;
        }
        return  null;
    }
    private Object extInsert(ExtInsert extInsert, Object proxy, Method method, Object[] args) {
        // 方法上存在@ExtInsert,获取他的SQL语句
        // 2. 获取SQL语句,获取注解Insert语句
        String insertSql = extInsert.value();
        // System.out.println("insertSql:" + insertSql);
        // 3. 获取方法的参数和SQL参数进行匹配
        // 定一个一个Map集合 KEY为@ExtParamValue,Value 结果为参数值
        ConcurrentHashMap<Object, Object> paramsMap = paramsMap(proxy, method, args);
        // 存放sql执行的参数---参数绑定过程
        String[] sqlInsertParameter = SQLUtils.sqlInsertParameter(insertSql);
        List<Object> sqlParams = sqlParams(sqlInsertParameter, paramsMap);
        // 4. 根据参数替换参数变为?
        String newSQL = SQLUtils.parameQuestion(insertSql, sqlInsertParameter);
        System.out.println("newSQL:" + newSQL + ",sqlParams:" + sqlParams.toString());
        // 5. 调用jdbc底层代码执行语句
        return JDBCUtils.insert(newSQL, false, sqlParams);
    }
    private List<Object> sqlParams(String[] sqlInsertParameter, ConcurrentHashMap<Object, Object> paramsMap) {
        List<Object> sqlParams = new ArrayList<>();
        for (String paramName : sqlInsertParameter) {
            Object paramValue = paramsMap.get(paramName);
            sqlParams.add(paramValue);
        }
        return sqlParams;
    }

    /**
     * 方法参数与实际参数相对应
     * @param proxy
     * @param method
     * @param args
     * @return
     */
    private ConcurrentHashMap<Object, Object> paramsMap(Object proxy, Method method, Object[] args) {
        ConcurrentHashMap<Object, Object> paramsMap = new ConcurrentHashMap<>();
        //获取方法上面的参数,方法上参数也是一个对象
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            ExtParam extParam = parameter.getDeclaredAnnotation(ExtParam.class);
            if (extParam != null) {
                // 参数名称
                String paramName = extParam.value();
                Object paramValue = args[i];
                // System.out.println(paramName + "," + paramValue);
                paramsMap.put(paramName, paramValue);
            }
        }
        return paramsMap;
    }

}
