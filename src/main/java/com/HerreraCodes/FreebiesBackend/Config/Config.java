package com.HerreraCodes.FreebiesBackend.Config;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@Configuration
public class Config {
    @Bean
    public RemoteWebDriver driver() {
        try {
            FirefoxOptions options = new FirefoxOptions();
            URL url =new URL("http://localhost:4444/wd/hub");
            return new RemoteWebDriver(url, options);
        } catch (MalformedURLException e) {
            System.out.println("Failed to create RemoteWebDriver");
            return null;
        }

    }
}
