package com.HerreraCodes.FreebiesBackend.Service;

import com.HerreraCodes.FreebiesBackend.Enum.Links;
import com.HerreraCodes.FreebiesBackend.Model.Item;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Component
public class Scraper {
    @Autowired
    private static RemoteWebDriver driver;

    @Autowired
    public Scraper(RemoteWebDriver driver) {
        this.driver = driver;
    }
    public List<Item> scrapeData(String category, String zipCode)throws InterruptedException{
        //list for my items
        List<Item>  itemArrayList=new ArrayList<>();


        System.out.println("going to url");
        String url=Links.linkp1.getLink()+zipCode+"/"+category+Links.linkp2.getLink();
        driver.get(url);
        //remove for now might add later
//        System.out.println("removing box");
//        driver.findElement(new By.ByCssSelector(".x92rtbv.x10l6tqk.x1tk7jg1.x1vjfegm")).click();
//
        //Wont need this anymore for new code but can edit to select range default is 40mi
//        System.out.println("selecting zipcode");
//        driver.findElement(new By.ByCssSelector(".x1i10hfl.x1qjc9v5.xjbqb8w.xjqpnuy.xa49m3k.xqeqjp1.x2hbi6w.x13fuv20.xu3j5b3.x1q0q8m5.x26u7qi.x972fbf.xcfux6l.x1qhh985.xm0m39n.x9f619.x1ypdohk.xdl72j9.x2lah0s.xe8uvvx.x11i5rnm.xat24cr.x1mh8g0r.x2lwn1j.xeuugli.xexx8yu.x4uap5.x18d9i69.xkhd6sd.x1n2onr6.x16tdsg8.x1hl2dhg.xggy1nq.x1ja2u2z.x1t137rt.x1o1ewxj.x3x9cwd.x1e5q0jg.x13rtm0m.x1q0g3np.x87ps6o.x1lku1pv.x78zum5.x1a2a7pz.x1xmf6yo\n")).click();
//        driver.findElement(new By.ByCssSelector(".xjbqb8w.x1iyjqo2.x193iq5w.xeuugli.x1n2onr6")).click();
//        driver.findElement(new By.ByCssSelector(".x1i10hfl.xggy1nq.x1s07b3s.x1kdt53j.x1a2a7pz.xjbqb8w.x1ejq31n.xd10rxx.x1sy0etr.x17r0tee.x9f619.xzsf02u.x1uxerd5.x1fcty0u.x132q4wb.x1a8lsjc.x1pi30zi.x1swvt13.x9desvi.xh8yej3")).sendKeys(zipCode);
//        try {
//            Thread.sleep(1000); // Waits for 500 milliseconds (half a second)
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        driver.findElement(new By.ByCssSelector(".x1i10hfl.xggy1nq.x1s07b3s.x1kdt53j.x1a2a7pz.xjbqb8w.x1ejq31n.xd10rxx.x1sy0etr.x17r0tee.x9f619.xzsf02u.x1uxerd5.x1fcty0u.x132q4wb.x1a8lsjc.x1pi30zi.x1swvt13.x9desvi.xh8yej3")).sendKeys(Keys.ARROW_DOWN);
//        driver.findElement(new By.ByCssSelector(".x1i10hfl.xggy1nq.x1s07b3s.x1kdt53j.x1a2a7pz.xjbqb8w.x1ejq31n.xd10rxx.x1sy0etr.x17r0tee.x9f619.xzsf02u.x1uxerd5.x1fcty0u.x132q4wb.x1a8lsjc.x1pi30zi.x1swvt13.x9desvi.xh8yej3")).sendKeys(Keys.ENTER);
//        try {
//            Thread.sleep(1000); // Waits for 500 milliseconds (half a second)
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        driver.findElement(new By.ByXPath("/html/body/div[1]/div/div[1]/div/div[5]/div/div/div[1]/div/div[2]/div/div/div/div[4]/div/div[2]/div/div/div/div/div/div/div[1]/div/span/span")).click();
//        try {
//            Thread.sleep(2000); // Waits for 500 milliseconds (half a second)
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //getting items
        System.out.println("scraping items");
        List<WebElement> WebElement2 =driver.findElements(By.cssSelector(".x1i10hfl.xjbqb8w.x1ejq31n.xd10rxx.x1sy0etr.x17r0tee.x972fbf.xcfux6l.x1qhh985.xm0m39n.x9f619.x1ypdohk.xt0psk2.xe8uvvx.xdj266r.x11i5rnm.xat24cr.x1mh8g0r.xexx8yu.x4uap5.x18d9i69.xkhd6sd.x16tdsg8.x1hl2dhg.xggy1nq.x1a2a7pz.x1heor9g.x1sur9pj.xkrqix3.x1lku1pv"));
        System.out.println("found web element");
            for (WebElement element : WebElement2) {
                try {
                    System.out.println("found element in element");
                    Item item = new Item();
                    item.setCategory(category);
                    String[] lines = element.getText().split("\n");
                    try {
                        item.setPrice(lines[0]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        // Handle ArrayIndexOutOfBoundsException
                    }
                    try {
                        item.setName(lines[1]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                    try {
                        item.setLocation(lines[2]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                    item.setDescription(element.getDomProperty("href"));
                    String outerHtml = element.getDomProperty("outerHTML");
                    // Extract the image link using a regular expression
                    Pattern imgPattern = Pattern.compile("<img\\s+.*?src\\s*=\\s*['\"]([^'\"]+)['\"].*?>");
                    Matcher imgMatcher = imgPattern.matcher(outerHtml);
                    if (imgMatcher.find()) {
                        String imageLink = imgMatcher.group(1);
                        imageLink = imageLink.replace("&amp;", "&");
                        item.setImage(imageLink);
                        itemArrayList.add(item);
                    }

                } catch (StaleElementReferenceException e) {
                    System.out.println("stale element caught");
                }
            }

        return itemArrayList;
    }
}
