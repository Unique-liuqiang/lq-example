package springBoot.test1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import springBoot.pojo.TaskInitiateAssociation;
import springBoot.test1.mapper.UserMapper;
import springBoot.test1.service.UserSerice;


import java.util.List;

@Service
public class UserServiceImpl implements UserSerice {

     @Autowired
    private UserMapper userMapper;

    @Override
    public List<TaskInitiateAssociation> selectList() {
        System.out.println(userMapper);
        return userMapper.selectList("615cdb6b92324f4fa56fa2c37cc881bd");
        //return userMapper.selectList();
    }
}
