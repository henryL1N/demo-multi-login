package com.example.demo.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Henry Lin badcop@163.com
 */
@RestController
@RequestMapping("/")
public class Home {

    @GetMapping
    String home() {
        return "hello";
    }
}
