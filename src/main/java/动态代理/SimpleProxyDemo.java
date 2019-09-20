package 动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SimpleProxyDemo {

    public static void consumer(Interface anInterface){
           anInterface.doSomething();
           anInterface.somethingElse("bonobo");
    }

    public static void main(String[] args){
        RealObject realObject=new RealObject();
        //consumer(realObject);

        //Insert  a proxy   and call again
        Interface proxy = (Interface)Proxy.newProxyInstance(
                Interface.class.getClassLoader(), new Class[]{Interface.class}, new DynamicProxyHander((realObject)));
        consumer(proxy);
    }

}
class   DynamicProxyHander implements InvocationHandler{
    private Object proxied;
    public  DynamicProxyHander(Object proxied){
        this.proxied=proxied;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       /* System.out.println("*** proxy:"+proxy.getClass()+".method:"+method+".args:"+args);
        if(args!=null){
            for(Object arg:args){
              System.out.println(" "+arg);
            }
        }*/
        return method.invoke(proxied,args);
    }
}