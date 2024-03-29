package IOC;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.util.List;


/**
 *实现IOC容器,xml版本形式(spring版本是使用ConcurrentHashMap容器装载bean)
 */
public class ClassPathXmlApplicationContextByxml {

    //xml路径地址
    private  String xmlPath;



    public ClassPathXmlApplicationContextByxml(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    public Object getBean(String beanId) throws Exception {
        // 1. 读取配置文件
        List<Element> elements = readerXml();
        if (elements == null) {
            throw new Exception("该配置文件没有子元素");
        }
        // 2. 使用beanId查找对应的class地址
        String beanClass = findXmlByIDClass(elements, beanId);
        if (StringUtils.isEmpty(beanClass)) {
            throw new Exception("未找到对应的class地址");
        }
        // 3. 使用反射机制初始化,对象
        Class<?> forName = Class.forName(beanClass);
        return forName.newInstance();
    }
    // 读取配置文件信息
    public List<Element> readerXml() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        if (StringUtils.isEmpty(xmlPath)) {
            new Exception("xml路径为空...");
        }
        Document read = saxReader.read(getClassXmlInputStream(xmlPath));
        // 获取根节点信息
        Element rootElement = read.getRootElement();
        // 获取子节点
        List<Element> elements = rootElement.elements();
        if (elements == null || elements.isEmpty()) {
            return null;
        }
        return elements;
    }

    // 使用beanid查找该Class地址
    public String findXmlByIDClass(List<Element> elements, String beanId) throws Exception {
        for (Element element : elements) {
            // 读取节点上是否有value
            String beanIdValue = element.attributeValue("id");
            if (beanIdValue == null) {
                throw new Exception("使用该beanId未查找到元素");
            }
            if (!beanIdValue.equals(beanId)) {
                continue;
            }
            // 获取Class地址属性
            String classPath = element.attributeValue("class");
            if (!StringUtils.isEmpty(classPath)) {
                return classPath;
            }
        }
        return null;
    }

    // 读取xml配置文件
    public InputStream getClassXmlInputStream(String xmlPath) {
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(xmlPath);
        return resourceAsStream;
    }
   
    public static void main(String[] args) throws Exception {
        //ClassPathXmlApplicationContextByxml classPathXmlApplicationContext=new ClassPathXmlApplicationContextByxml("spring2.xml");
        ClassPathXmlApplicationContext classPathXmlApplicationContext=new ClassPathXmlApplicationContext("spring2.xml");
        Object userService = classPathXmlApplicationContext.getBean("userService");
        System.out.println(userService);
    }

}
