package org.icare.doctor.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * configure properties example for dateformat
 *
 * @author Huayu Zhang
 */
@Data
@Component
@ConfigurationProperties(prefix = "pattern1")
public class PatternProperties {
    private String dateformat; // dateformat pattern
    private String envSharedValue; // all environment shared value, for debugging
}
