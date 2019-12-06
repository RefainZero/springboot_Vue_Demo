package com.demo.hellow;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rongrong
 * @version 1.0
 * @description:
 * @date 2019/12/6 20:59
 */
@RestController
public class HelloCotroller {

    @GetMapping("/hellow")
    public String hello(){
        return "hellow world!!";
    }


}
