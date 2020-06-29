package cn.yyn.bigwork;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = {"cn.yyn.bigwork.dao"})
@SpringBootApplication
public class BigworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(BigworkApplication.class, args);
    }

}
