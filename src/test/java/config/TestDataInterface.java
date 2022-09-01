package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:properties/testData.properties")
public interface TestDataInterface extends Config {
    String url();
}
