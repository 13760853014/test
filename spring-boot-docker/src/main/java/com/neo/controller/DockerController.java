package com.neo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Slf4j
@RestController
public class DockerController {

    private static Integer random = new Random().nextInt(1000);

    private static Integer count = 0;

    @RequestMapping("/")
    public String index() {
        count ++;
        String result = "Hello Docker! random=%s , count=%s";
        return String.format(result, random, count);
    }

    @RequestMapping("/{time}")
    public String sleepTest(@PathVariable("time") Integer time) throws Exception {
        count ++;
        log.info(random + " begin sleep ---");
        Thread.sleep(time * 1000);
        log.info("end sleep +++");
        String result = "Hello Docker! random=%s ,Thread=%s, count=%s";
        return String.format(result, random, time, count);
    }
}