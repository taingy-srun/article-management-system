package com.article.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.article.repository.mybatis")
public class MybatisConfiguration {

}
