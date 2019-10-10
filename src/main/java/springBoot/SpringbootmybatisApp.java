package springBoot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = {"springBoot.test1.mapper","springBoot.test2.mapper"})
public class SpringbootmybatisApp {
    
    public static void main(String[] args){
        SpringApplication.run(SpringbootmybatisApp.class);
    }
}
