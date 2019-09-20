package ThreadLocal;

/**
 * 演示thread线程局部变量的特性,每个线程特有的
 */
  class Res {

      //private   Integer count =0;

      public ThreadLocal<Integer> threadLocal1=new ThreadLocal<Integer>(){
          @Override
          protected Integer initialValue() {
              return 0;
          }
      };

      public  Integer getNumber(){
          int count = threadLocal1.get() + 1;
          threadLocal1.set(count);
          return count;
      }
   }

     public class Test extends  Thread{

          private  Res res;

          public Test(Res res ,String threadName){
              super(threadName);
              this.res=res;
          }
         @Override
         public void run() {
             for (int i = 0; i < 3; i++) {
                 System.out.println(Thread.currentThread().getName() + "," + res.getNumber());
             }
         }
         
         public static void main(String[] args){
             Res res=new Res();
             Test test1=new Test(res,"线程01");
             Test test2=new Test(res,"线程02");
             test1.start();
             test2.start();
         }
     }
