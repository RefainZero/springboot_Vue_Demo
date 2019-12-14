package com.rongrong.demo.springboot.es;

import com.rongrong.demo.springboot.es.entity.es.EsBlog;
import com.rongrong.demo.springboot.es.respository.es.EsBlogRespository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;

@SpringBootTest
class SpringbootEsApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    EsBlogRespository esBlogRespository;

    @Test
    public void testEs() {
        Iterable<EsBlog> all = esBlogRespository.findAll();
        Iterator<EsBlog> iterator = all.iterator();
        for (EsBlog esBlog : all) {
            System.out.println(esBlog.toString());
        }
        EsBlog esBlog = iterator.next();
        System.out.println("【es集成springboot】esBlog={}" + esBlog);

    }

}
