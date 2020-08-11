package nathan.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MapPropertySource;

import java.util.Map;

/**
 * @author nathan.z
 * @date 2020/6/7.
 */
public class FirstInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        MapPropertySource mapPropertySource = new MapPropertySource("firstInitializer"
                , Map.of("key1", "value1"));
        applicationContext.getEnvironment().getPropertySources().addLast(mapPropertySource);
        System.out.println("==========FirstInitializer===========");
    }
}
