package com.hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
public class MappingController {

    /**
     * PathVariable 사용
     * 변수 명이 같으면 생략 가능
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String userId) {
        log.debug("mappingPath userId={}", userId);
        return "OK";
    }
}
