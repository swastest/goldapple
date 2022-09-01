package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigurationCenter {
    public static RemoteConfigInterface configRemote = ConfigFactory.create(RemoteConfigInterface.class, System.getProperties());
    public static TestDataInterface configTestData = ConfigFactory.create(TestDataInterface.class, System.getProperties());
}
