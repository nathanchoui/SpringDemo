package personal.nathan.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import personal.nathan.service.HelloService;

import java.awt.*;

/**
 * Description:
 * <p>
 * Created by zhangwei on 2017/10/1.
 */
@RestController
@Slf4j
public class Hello {

    @Autowired
    private HelloService helloService;

    public Hello() {
        log.info("Awesome!!!");
        System.out.println("initial hello");
    }

    @GetMapping("sayHello")
    public String sayHello(String name) {
        return helloService.sayHello(name);
    }

}
