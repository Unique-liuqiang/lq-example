package javassist;

import java.lang.reflect.Method;

/**
 * 演示使用javaassist技术动态修改字节码文件
 */
public class Test001 {

	public static void main(String[] args) {
		try {
		    System.out.println(Thread.activeCount());
			ClassPool pool = ClassPool.getDefault();
			// 读取javassist.User
			CtClass userClass = pool.get("javassist.User");
			CtMethod method = new CtMethod(CtClass.voidType, "sum", new CtClass[] { CtClass.intType, CtClass.intType },
					userClass);
			method.setBody("{System.out.println(\"sun:\" + ($1 + $2));}");
			// 添加方法
			userClass.addMethod(method);
			userClass.writeFile("C:/test");
			// 动态执行方法
			Class clazz = userClass.toClass();
			Object newInstance = clazz.newInstance();

			Method sumMethod = clazz.getDeclaredMethod("sum", int.class, int.class);
			//System.out.println("开启事物");
			sumMethod.invoke(newInstance, 2, 5);
			// 使用 javassist 实现动态代理。
			//System.out.println("提交事物");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
