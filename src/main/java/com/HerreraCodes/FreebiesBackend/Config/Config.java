package com.HerreraCodes.FreebiesBackend.Config;

import jakarta.annotation.PreDestroy;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@Configuration
public class Config {
    private RemoteWebDriver driver;
    @Bean
    public RemoteWebDriver driver() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("firefox");
            URL url =new URL("http://selenium-hub:4444/wd/hub");
            driver=new RemoteWebDriver(url, capabilities);
            return driver;
        } catch (MalformedURLException e) {
            System.out.println("Failed to create RemoteWebDriver");
            return null;
        }

    }
    @PreDestroy
    public void quitWebDriver() {
        if (driver != null) {
            System.out.println("Closing WebDriver...");
            driver.quit();
        }
    }
}
