package com.atguigu.boot;

import ch.qos.logback.core.db.DBHelper;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import com.atguigu.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**主程序类
 * 这是一个springboot:这是一个springboot应用
 */
@SpringBootApplication(scanBasePackages = "com.atguigu")
//@SpringBootConfiguration(表示配置类)
//@EnableAutoConfiguration
//@ComponentScan( "com.atguigu")（扫描注解）
public class MainApplication {
    public static void main(String[] args) {
        //返回ioc容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        //查看容器里的组件
        String[] names = run.getBeanDefinitionNames();
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }

//        //3.从容器中获取组件
//        Pet tom1 = run.getBean("tom", Pet.class);
//        Pet tom2 = run.getBean("tom", Pet.class);
//        boolean equals = tom1==tom2;
//        User user01 = run.getBean("user01", User.class);
//
//        //配置类本身也是组件
//        /*
//        @Configuration(proxyBeanMethods = true)代理对象调用方法，springboot总会检查这个组件是否在容器
//        保证我吃单实例
//         */
//        MyConfig bean = run.getBean(MyConfig.class);
//
//        User user = bean.user01();
//        User user1 = bean.user01();
//        System.out.println(user == user1);
//
//        System.out.println("*******************************************");
//        User user011 = run.getBean("user01", User.class);
//        Pet tom01 = run.getBean("tom", Pet.class);
//        System.out.println(user011.getPet() == tom01);
//
//
//        System.out.println("*******************************2..************");
//        //5.获取组件
//        String[] beanNamesForType = run.getBeanNamesForType(User.class);
//        for (String s:beanNamesForType){
//            System.out.println(s);
//        }
//        DBHelper bean1 = run.getBean(DBHelper.class);
//        System.out.println(bean1);

        boolean tom = run.containsBean("tom2");
        System.out.println("容器中tom组件："+tom);

        boolean user01 = run.containsBean("user01");
        System.out.println("容器中user组件："+user01);

        System.out.println(run.getBeanDefinitionCount());
    }
}
