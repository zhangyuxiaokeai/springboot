package com.atguigu.boot.controller;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {

    //car/2/owner/zhangsan
    @RequestMapping("/car/{id}/owner/{username}")
public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                 @PathVariable("username")String name,
                                 @PathVariable Map<String,String> pv,
                                 @RequestHeader("User-Agent") String userAgent,
                                 @RequestHeader Map<String,String> header,
                                 @RequestParam("age")Integer age,
                                 @RequestParam("inters")List<String> list,
                                 @RequestParam Map<String,String> params,
                                 @CookieValue("Idea-55747ddb")String _ga,
                                 @CookieValue("Idea-55747ddb")Cookie cookie) {
   Map<String,Object> map=new HashMap<>();
//    map.put("id",id);
//    map.put("username",name);
//    map.put("pv",pv);
//    //获取请求头
//    map.put("User-Agent",userAgent);
//    map.put("Header",header);

        map.put("age",age);
        map.put("inters",list);
        map.put("params",params);
        map.put("Idea-55747ddb",_ga);
        System.out.println(cookie);
        return map;
}
@RequestMapping("/login")
public Map postMethod(@RequestBody String context ,@RequestParam("username") String username){
    Map<String,Object> map=new HashMap<>();
    map.put("context",context);
    map.put("username",username);
    return map;
}
///cars/sell;low=34;barand=byd,audi,yd


    /*
    1.springboot默认是禁用了矩阵变量的功能
            手动开启：原理：对于整个路径的处理UrlPathHerlper进行解析
             removeSemicolonContent（移除分号内容））支持矩阵变量
    2.矩阵变量必须要有url路径变量才能被解析
     */
@GetMapping("/cars/{path}")
    public Map carsSell(@MatrixVariable("low") Integer low,
                        @MatrixVariable("brand") List <String> brand,
                        @PathVariable("path") String path){
    Map<String,Object> map=new HashMap<>();
    map.put("low",low);
    map.put("brand",brand);
    map.put("path",path);
    return map;
}
// /boss/1;age=10/2;age=20
@GetMapping("/boss/{bossId}/{empId}")
    public Map boss(@MatrixVariable(value = "age",pathVar =" bossId")Integer bossAge,
                    @MatrixVariable(value = "age",pathVar =" empId")Integer empAge){
    Map<String,Integer> map=new HashMap<>();
    map.put("bossAge",bossAge);
    map.put("empAge",empAge);
    return map;
}
}
