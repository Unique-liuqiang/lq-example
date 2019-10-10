package adapter;

/**
 * --演示适配器模式
 * @author 86138
 */
public class AdaptorTest {

	public static void main(String[] args) {
		//CN220VInterface cn220VInterface = new CN220VInterfaceImpl();
		PowerAdaptor powerAdaptor = new PowerAdaptor();
		// 电饭煲
		//ElectricCooker cooker = new ElectricCooker(powerAdaptor);
		//cooker.cook();//使用了适配器,在220V的环境可以工作了。
	}

}
