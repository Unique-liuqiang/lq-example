package adapter;

public class JP110VInterfaceImpl implements JP110VInterface {

	@Override
	public void connect() {
       System.out.println("日本110V,接通电源,开始工作..");
	}

}
