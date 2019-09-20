package hotSwap;

import java.io.IOException;
import java.io.InputStream;

/**
 * 自定义类加载器
 */
public class Myclassloader  extends  ClassLoader{


    //传递一个class路径地址
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        //获取文件名称
        String fileName = name.substring(name.lastIndexOf(".") + 1);
        fileName=fileName+".class";
        //读取文件流
        InputStream is=this.getClass().getResourceAsStream(fileName);
        //读取字节
        try {
            byte[] bytes=new byte[is.available()];
            is.read(bytes);
            //将读取byte数组给jvm识别class对象
            return  defineClass(name,bytes,0,bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.findClass(name);
    }
}
