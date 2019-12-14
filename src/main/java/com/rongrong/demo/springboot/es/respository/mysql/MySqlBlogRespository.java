package com.rongrong.demo.springboot.es.respository.mysql;

import com.rongrong.demo.springboot.es.entity.mysql.MySqlBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * @author rongrong
 * @version 1.0
 * @description:
 * @date 2019/12/12 20:48
 */
public interface MySqlBlogRespository extends JpaRepository<MySqlBlog, Integer> {

    /**
     * 创建时间倒序查询博客
     *
     * @return
     */
    @Query("select e from MySqlBlog e order by e.createTime desc ")
    List<MySqlBlog> queryAll();

    /**
     * 模糊查询
     *
     * @param keyword
     * @return
     */
    @Query("select e from MySqlBlog e where e.title like concat('%',:keyword,'%') or e.content like concat('%',:keyword,'%')")
    List<MySqlBlog> queryBlogs(@Param("keyword") String keyword);


}
