package IOC;

/**
 * @author 86138
 */

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 实现注解形式的IOC容器
 */
public class ClassPathXmlApplicationContext {

    //扫包范围
    private String packageName;

    ConcurrentHashMap<String, Object> initBean = null;

    public ClassPathXmlApplicationContext(String packageName){
        this.packageName=packageName;
        //初始化map
        //初始化bean
        //初始化bean属性
    }

     public Object getBean(String beanId)throws Exception{
        //使用反射机制获取该包下存在extService注解的类
         List<Class> classExisService = findClassExisService();
         if(classExisService==null||classExisService.isEmpty()){
             throw new Exception("没有需要初始化的bean");
         }
         //初始化bean
         initBean=initBean(classExisService);

         if(initBean==null||initBean.isEmpty()){
             throw new Exception("初始化bean为空!");
         }
         Object o = initBean.get(beanId);
         attriAssign(o);
         return o;
     }

    /**
     * 使用反射机制获取该包下存在extService注解的类
     * @return
     */
    private List<Class> findClassExisService() throws Exception {
        if (StringUtils.isEmpty(packageName)) {
            throw new Exception("扫包地址不能为空!");
        }
        //使用反射技术获取当前包下所有的类
        List<Class<?>> classesByPackageName = com.itmayiedu.extspringmvc.utils.ClassUtil.getClasses(packageName);
        //存放类上有beanz注入注解
        List<Class> exisClassesAnnotation = new ArrayList<Class>();
        // 4.判断该类上属否存在注解
        for (Class classInfo : classesByPackageName) {
            ExtService extService = (ExtService) classInfo.getDeclaredAnnotation(ExtService.class);
            if (extService != null) {
                exisClassesAnnotation.add(classInfo);
                continue;
            }
        }
        return exisClassesAnnotation;
    }

    // 初始化bean对象
    public ConcurrentHashMap<String, Object> initBean(List<Class> listClassesAnnotation)
            throws InstantiationException, IllegalAccessException {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap<String, Object>();
        for (Class classInfo : listClassesAnnotation) {
            // 初始化对象
            Object newInstance = classInfo.newInstance();
            // 获取父类名称
            String beanId = toLowerCaseFirstOne(classInfo.getSimpleName());
            concurrentHashMap.put(beanId, newInstance);
        }
        return concurrentHashMap;
    }

    // 首字母转小写
    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }


    // 使用反射读取类的属性,赋值信息
    public void attriAssign(Object object) throws IllegalArgumentException, IllegalAccessException {
        // 1.获取类的属性是否存在 获取bean注解
        Class<? extends Object> classInfo = object.getClass();
        Field[] declaredFields = classInfo.getDeclaredFields();
        for (Field field : declaredFields) {
            // 属性名称
            String name = field.getName();
            // 2.使用属性名称查找bean容器赋值
            Object bean = initBean.get(name);
            if (bean != null) {
                // 私有访问允许访问
                field.setAccessible(true);
                // 给属性赋值
                field.set(object, bean);
                continue;
            }
        }

    }
}
