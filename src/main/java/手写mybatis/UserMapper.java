package 手写mybatis;

import javassist.User;

import 手写mybatis.annotation.ExtInsert;
import 手写mybatis.annotation.ExtParam;
import 手写mybatis.annotation.ExtSelect;


public interface UserMapper {

	@ExtInsert("insert into user(userName,userAge) values(#{userName},#{userAge})")
	public int insertUser(@ExtParam("userName") String userName, @ExtParam("userAge") Integer userAge);

	@ExtSelect("select * from User where userName=#{userName} and userAge=#{userAge} ")
    User selectUser(@ExtParam("userName") String name, @ExtParam("userAge") Integer userAge);

}
