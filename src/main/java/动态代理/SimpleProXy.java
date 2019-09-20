package 动态代理;

public class SimpleProXy implements Interface{

    private Interface proxied;

    public SimpleProXy(Interface proxied){
          this.proxied=proxied;
    }

    @Override
    public void doSomething() {
        System.out.println("SimpleProXy doSomething");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("SimpleProXy somethingElse"+arg);
        proxied.somethingElse(arg);
    }
}
