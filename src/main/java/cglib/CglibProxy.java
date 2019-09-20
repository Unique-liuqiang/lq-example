package cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor{
	private Object targetObject;

	public Object getInstance(Object target) {
		this.targetObject = target;
		// 操作字节码 生成虚拟子类(利用字类重写父类方法的特性)
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(target.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}

	@Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("开启事物");
		Object invoke = proxy.invoke(targetObject, args);
		System.out.println("提交事物");
		return invoke;
	}

	// 日志 控制层打印日誌 AOP技术 环绕通知 方之前和之后进行拦截参数打印。
	// 1. CGLIB 没有依赖接口关系 字节码 ASM 2.jdk 反射技术

	public static void main(String[] args) {
		CglibProxy cglibProxy = new CglibProxy();
		UserDaoImpl userDaoImpl = (UserDaoImpl) cglibProxy.getInstance(new UserDaoImpl());
		userDaoImpl.insert();
		// 怎么判断一个类是否实现接口？
	}

}
