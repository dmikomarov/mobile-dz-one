package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${env}.properties"})
public interface MobileConfig extends Config {

    @Key("user")
    String getUser();

    @Key("key")
    String getKey();

    @Key("app_url")
    String getAppUrl();

    @Key("device")
    String getDevice();

    @Key("os_version")
    String getOsVersion();

    @Key("project")
    String getProject();

    @Key("build")
    String getBuild();

    @Key("name")
    String getName();

    @Key("remote_url")
    String getRemoteUrl();

}
