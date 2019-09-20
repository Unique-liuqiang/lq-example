package 手写mybatis;

import java.lang.reflect.Proxy;

public class SqlSession {

    //加载mapper接口
    public static  <T> T getMapper(Class clazz){
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new MyInvocationHandlerMbatis());
    }
    
    public static void main(String[] args){
        UserMapper mapper = SqlSession.getMapper(UserMapper.class);
        int lq = mapper.insertUser("lq", 18);
        System.out.println(lq);
    }
}
