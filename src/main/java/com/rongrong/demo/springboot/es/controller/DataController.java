package com.rongrong.demo.springboot.es.controller;

import com.rongrong.demo.springboot.es.entity.es.EsBlog;
import com.rongrong.demo.springboot.es.entity.mysql.MySqlBlog;
import com.rongrong.demo.springboot.es.respository.es.EsBlogRespository;
import com.rongrong.demo.springboot.es.respository.mysql.MySqlBlogRespository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * @author rongrong
 * @version 1.0
 * @description:
 * @date 2019/12/12 22:08
 */
@RestController
@Slf4j
public class DataController {

    @Autowired
    EsBlogRespository esBlogRespository;

    @Autowired
    MySqlBlogRespository mySqlBlogRespository;

    @GetMapping("/blogs")
    public Object blogs() {
        List<MySqlBlog> mySqlBlogs = mySqlBlogRespository.queryAll();
        return mySqlBlogs;
    }

    @PostMapping("/queryBlogs")
    public Object queryBlogs(@RequestBody Param param) {
        HashMap<String, Object> map = new HashMap<>();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        String type = param.getType();
        //使用mysql查询
        if ("mysql".equalsIgnoreCase(type)) {
            List<MySqlBlog> sqlBlogs = mySqlBlogRespository.queryBlogs(param.getKeyword());
            map.put("list", sqlBlogs);
            //使用es查询
        } else if ("es".equalsIgnoreCase(type)) {
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
            boolQueryBuilder.should(QueryBuilders.matchPhraseQuery("title", param.keyword));
            boolQueryBuilder.should(QueryBuilders.matchPhraseQuery("content", param.keyword));
            String s = boolQueryBuilder.toString();
            Page<EsBlog> search = (Page<EsBlog>) esBlogRespository.search(boolQueryBuilder);
            List<EsBlog> content = search.getContent();
            map.put("list", content);
        } else {
            return "我太难了！！！";
        }
        stopWatch.stop();
        long millis = stopWatch.getTotalTimeMillis();
        map.put("duration", millis);
        return map;
    }

    @GetMapping("/blog/{id}")
    public Object blog(@PathVariable Integer id) {
        Optional<MySqlBlog> byId = mySqlBlogRespository.findById(id);
        return byId.get();
    }


    @Data
    private static class Param {
        private String type;
        private String keyword;
    }
}
