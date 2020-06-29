package cn.yyn.bigwork.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig {
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            //配置资源拦截目标
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("/login.html","/","/user/login")
//                        .excludePathPatterns("/asserts/**")
//                        .excludePathPatterns("/webjars/**");
            }
            //配置资源别名路径
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("emp/main");
                registry.addViewController("/register.html").setViewName("register");
                registry.addViewController("/supplier_add.html").setViewName("emp/supplier/supplier_add");
            }
        };
        return webMvcConfigurer;
    }

//    @Bean
//    public LocaleResolver localeResolver(){
//        return new MyLocaleResolver();
//    }

}
