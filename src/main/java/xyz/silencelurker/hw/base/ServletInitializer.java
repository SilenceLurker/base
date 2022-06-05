package xyz.silencelurker.hw.base;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author Silence_Lurker
 */
public class ServletInitializer extends SpringBootServletInitializer {
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(BaseApplication.class);
    }
}
