package com.power.doc.controller;

import com.power.doc.entity.SimpleUser;
import com.power.doc.enums.SimpleEnum;
import org.springframework.web.bind.annotation.*;

/**
 * 枚举参数测试
 * @author yu 2019/11/28.
 */
@RestController
public class EnumController {

    /**
     * 获取枚举参数
     * @param simpleEnum 简单枚举
     * @return
     */
    @GetMapping(value = "/enum")
    public String test(SimpleEnum simpleEnum){
        System.out.println(simpleEnum.name());
        return "hello apiNote";
    }

    /**
     * 获取枚举参数
     * @param simpleEnum 简单枚举
     * @return
     */
    @GetMapping(value = "/enum/{simpleEnum}")
    public String testEnumPathVal(@PathVariable SimpleEnum simpleEnum){
        System.out.println(simpleEnum.name());
        return "hello apiNote";
    }
}
