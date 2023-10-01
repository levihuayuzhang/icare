package org.ph1nix.patient.config;

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
@ConfigurationProperties(prefix = "pattern")
public class PatternProperties {
    private String dateformat; // dateformat pattern
    private String envSharedValue; // all environment shared value, for debugging
}
