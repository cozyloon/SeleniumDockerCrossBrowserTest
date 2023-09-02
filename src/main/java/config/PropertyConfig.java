package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config.properties"
})
public interface PropertyConfig extends Config {
    @Key("url")
    String webUrl();

    @Key("username")
    String username();

    @Key("password")
    String password();
}
