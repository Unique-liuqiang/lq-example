package 适配器方法惯用法;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class AdapterMethodIom {
    public static void main(String[] args){
      ReversibleArrayList<String> ral=new ReversibleArrayList<String>(Arrays.asList("To be or not to be".split(" ")));
      File file =new File("");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(String s:ral){
             System.out.print(s+" ");
      }
      System.out.println();
      for(String s:ral.reversed()){
         System.out.print(s+" ");
      }
    }
}
