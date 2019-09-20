package myspringmvc.servlet;


import myspringmvc.annotation.ExtController;
import myspringmvc.annotation.ExtRequestMapping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class ExtDispatcherServlet extends HttpServlet {

    // mvc bean key=beanid ,value=对象
    private ConcurrentHashMap<String, Object> mvcBeans = new ConcurrentHashMap<>();
    // mvc 请求方法 key=requestUrl,value=对象
    private ConcurrentHashMap<String, Object> mvcBeanUrl = new ConcurrentHashMap<>();
    // mvc 请求方法 key=requestUrl,value=方法
    private ConcurrentHashMap<String, String> mvcMethodUrl = new ConcurrentHashMap<>();
    private Object o;

    @Override
    public void init() throws ServletException {
        //查找包下所有的Class
        List<Class<?>> classes = com.itmayiedu.extspringmvc.utils.ClassUtil.getClasses("myspringmvc.controller");
        try {
            //初始化带有ExtControlle注解的类
            finalClassMvcBeans(classes);
            //初始化url与对应类
            handlerMapping(mvcBeans);

        } catch (Exception e){

        }
    }

    private void handlerMapping(ConcurrentHashMap<String, Object> mvcBeans) {
        for(Map.Entry entry:mvcBeans.entrySet()){
            Object value = entry.getValue();
            ExtRequestMapping extRequestMapping = value.getClass().getDeclaredAnnotation(ExtRequestMapping.class);
            //获取类上的url
            String url = null;
            if(extRequestMapping!=null){
                url=extRequestMapping.value();
            }
            //获取方法上的URL
            for (Method method : value.getClass().getMethods()) {
                ExtRequestMapping declaredAnnotation = method.getDeclaredAnnotation(ExtRequestMapping.class);
                if(declaredAnnotation!=null){
                     url=url+declaredAnnotation.value();
                     mvcBeanUrl.put(url,value);
                     mvcMethodUrl.put(url,method.getName());
                }
            }
        }
    }

    private void finalClassMvcBeans(List<Class<?>> classes) throws IllegalAccessException, InstantiationException {

        for(Class clazz:classes){
            Annotation annotation = clazz.getDeclaredAnnotation(ExtController.class);
            if(annotation!=null){
                Object o = clazz.newInstance();
                String beanId = com.itmayiedu.extspringmvc.utils.ClassUtil.toLowerCaseFirstOne(clazz.getSimpleName());
                mvcBeans.put(beanId,o);
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
            Object o = mvcBeanUrl.get(requestURI);
        if(o == null){
               response.getWriter().println("http"+requestURI+"not found 404");
               return;
        }
        String methodName = mvcMethodUrl.get(requestURI);
        if(methodName == null){
            response.getWriter().println("http"+requestURI+"not found 404");
              return;
        }
        try {
            Method method = o.getClass().getMethod(methodName);
            String returnMsg = (String)method.invoke(o);
            System.out.println(returnMsg);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
