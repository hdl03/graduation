package com.san.graduation;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@ComponentScan("com.san.graduation")
@EnableAutoConfiguration//自动载入应用程序所需的所有Bean——这依赖于Spring Boot在类路径中的查找。
// TODO logging&access log//启用Spring MVC
@EnableWebMvc
//Servlet、Filter、Listener 可以直接通过 @WebServlet、@WebFilter、@WebListener 注解自动注册，无需其他代码。
@ServletComponentScan
//开启Feign功能
@EnableFeignClients
//加上这个注解，使得支持事务
@EnableTransactionManagement
@MapperScan(basePackages = "com.san.graduation.mapper")
public class GraduationAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraduationAppApplication.class, args);
	}


}
