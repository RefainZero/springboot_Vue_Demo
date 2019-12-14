package com.rongrong.demo.springboot.es.controller;

import com.rongrong.demo.springboot.es.entity.mysql.MySqlBlog;
import com.rongrong.demo.springboot.es.respository.mysql.MySqlBlogRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author rongrong
 * @version 1.0
 * @description:
 * @date 2019/12/12 20:50
 */
@Controller
public class IndexController {

    @Autowired
    MySqlBlogRespository mySqlBlogRespository;

    @RequestMapping("/")
    public String index() {
        List<MySqlBlog> all = mySqlBlogRespository.findAll();
        return "index.html";
    }
}
