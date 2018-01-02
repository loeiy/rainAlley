package com.alley.rain;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
//@MapperScan("com.alley.rain.dao")//将项目中对应的mapper类的路径加进来就可以了(如果此文件没有在根目录下，获取bean的方式会有先后顺序)
public class RainApplication extends SpringBootServletInitializer {
	//程序启动入口
	//启动嵌入式的Tomcat并初始化Spring环境及其各Spring组件  121
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RainApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(RainApplication.class, args);
	}
}
