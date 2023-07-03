package org.huayuzhang.booking.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class DefaultFeignConfiguration {
    @Bean
    public Logger.Level logLevel() {

//        // for debugging
        return Logger.Level.FULL;

        // for performance
//        return Logger.Level.BASIC;
//        return Logger.Level.NONE;
    }
}
