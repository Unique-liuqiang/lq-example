package springBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springBoot.pojo.EquityAssets;
import springBoot.pojo.TaskInitiateAssociation;
import springBoot.test1.service.UserSerice;
import springBoot.test2.service.ODSEquitySerice;


import java.util.List;

@RestController
public class TestController {

    @Autowired
    private UserSerice userSerice;

    @Autowired
    private ODSEquitySerice odsEquitySerice;

     @RequestMapping("/selectList")
    private List<TaskInitiateAssociation> selectList(){
        return userSerice.selectList();
    }

    @RequestMapping("/selectList2")
    private List<EquityAssets> selectList2(){
        return odsEquitySerice.selectEquityPerson();
    }

}
