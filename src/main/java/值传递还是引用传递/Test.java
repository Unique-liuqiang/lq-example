package 值传递还是引用传递;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args){
       List<List<String>> fatherList=new LinkedList<>();
       List<String>  childList=new ArrayList<>();
       childList.add("1");
       fatherList.add(childList);
       childList.add("2");
        int size = fatherList.get(0).size();
        System.out.println(size);
        //Test<Test>[] a=new Test<Test>[10];
    }
}
