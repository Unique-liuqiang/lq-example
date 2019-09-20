package myspringmvc.controller;

import myspringmvc.annotation.ExtController;
import myspringmvc.annotation.ExtRequestMapping;

@ExtController
@ExtRequestMapping("/index")
public class IndexController {

    @ExtRequestMapping("/test")
    public  String test(){
        System.out.println("手写SpringMvcDeom演示");
        return "index";
    }
}
