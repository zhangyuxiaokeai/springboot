package com.atguigu.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.atguigu.boot.bean.Car;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 配置类里面使用的@Bean标注在方法上给容器注册组件，默认也是单实例的
 *2.//配置类本身也是组件
 * proxyBeanMethod是：代理Bean的方法
 *FULL(proxyBeanMethods = true)
 * Lite(proxyBeanMethods = false)
 *
 *@Import //@Import({User.class, DBHelper.class})
 *      给容器中自动创建这两个类型的组件,默认组件的名字就是全类名
 */

@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = false)//告诉springboot这是一个配置类==配置文件
//@ConditionalOnBean(name = "tom")
@ConditionalOnMissingBean(name = "tom")
@EnableConfigurationProperties(Car.class)//1.开启car的属性配置功能2.把car这个组件自动注入到容器中
public class MyConfig {

    /**
     * 外部无论对这个组件出册方法调用多少次获取的都是之前容器中的单实例对象
     * @return
     */
    @ConditionalOnBean(name = "tom2")
    @Bean //给容器中添加组件，以方法名名作为组件的id，返回类型就是组件类型，方法返回的就是组件在容器中的实例
    public User user01(){
        User zhangsan = new User("zhangsan", 18);
        //useru数组依赖了pet组件
        zhangsan.setPet(tomcatPet());
        return zhangsan;
    }
    @Bean("tom2")
    public Pet tomcatPet(){
        return new Pet("tomcat");
    }
}
