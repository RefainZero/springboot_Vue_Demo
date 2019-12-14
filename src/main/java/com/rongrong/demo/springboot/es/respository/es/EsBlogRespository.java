package com.rongrong.demo.springboot.es.respository.es;

import com.rongrong.demo.springboot.es.entity.es.EsBlog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author rongrong
 * @version 1.0
 * @description:
 * @date 2019/12/12 22:08
 */
public interface EsBlogRespository extends ElasticsearchRepository<EsBlog, Integer> {
}
