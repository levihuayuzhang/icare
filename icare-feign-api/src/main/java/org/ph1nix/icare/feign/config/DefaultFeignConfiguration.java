package org.icare.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class DefaultFeignConfiguration {
    /**
     * Configurations of log level.
     *
     * @return logger level
     * @author Huayu Zhang
     */
    @Bean
    public Logger.Level logLevel() {
//        return Logger.Level.FULL;
        return Logger.Level.BASIC;
    }
}
