package com.rongrong.demo.springboot.es.entity.mysql;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


/**
 * @author rongrong
 * @version 1.0
 * @description:
 * @date 2019/12/12 20:40
 */
@Data
@Table(name = "t_blog")
@Entity
public class MySqlBlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String author;
    @Column(columnDefinition = "mediumtext")
    private String content;
    private Date createTime;
    private Date updateTime;


}
