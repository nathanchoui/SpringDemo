package personal.nathan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * <p>
 * Created by zhangwei on 2017/10/1.
 */
@RestController
public class Hello {

    public Hello() {
        System.out.println("initial hello");
    }

    @GetMapping("sayHello")
    public String sayHello(String name) {
        return String.format("Hello, %s", name == null ? "guest": name);
    }

}
