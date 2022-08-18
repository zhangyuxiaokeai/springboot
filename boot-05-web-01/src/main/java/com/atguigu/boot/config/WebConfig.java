package com.atguigu.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.util.List;

@Configuration(proxyBeanMethods = false)
public class WebConfig/* implements WebMvcConfigurer*/ {
@Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
        HiddenHttpMethodFilter methodFilter = new HiddenHttpMethodFilter();
        methodFilter.setMethodParam("_m");
        return methodFilter;
    }

   // @Bean //WenMvcConfigurer

    //第一种方法实现WebMvcConfigurer接口并重写configurePathMatch
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        UrlPathHelper urlPathHelper = new UrlPathHelper();
//        //不移除：后面的内容，矩阵功能就有可能生效
//        urlPathHelper.setRemoveSemicolonContent(false);
//        configurer.setUrlPathHelper(urlPathHelper);
//    }



    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
   return new WebMvcConfigurer(){

       //第二种实现矩阵变量
       @Override
       public void configurePathMatch(PathMatchConfigurer configurer) {
           UrlPathHelper urlPathHelper = new UrlPathHelper();
        //不移除：后面的内容，矩阵功能就有可能生效
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
       }
   };
    }
}
