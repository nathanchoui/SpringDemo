package personal.nathan.service;

import org.springframework.stereotype.Service;

/**
 * Created by za-zhangwei002 on 19-9-22.
 */
@Service
public class HelloServiceImpl implements HelloService{
    @Override
    public String sayHello(String name) {
        return String.format("Hello, %s", name == null ? "guest": name);
    }
}
