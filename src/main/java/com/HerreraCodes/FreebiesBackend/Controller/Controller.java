package com.HerreraCodes.FreebiesBackend.Controller;
import com.HerreraCodes.FreebiesBackend.Model.Item;
import com.HerreraCodes.FreebiesBackend.Service.ItemService;
import com.HerreraCodes.FreebiesBackend.Service.Scraper;
import com.HerreraCodes.FreebiesBackend.Service.ZipCodeEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")

public class Controller {
    private final Scraper scraper;
    private final ZipCodeEncoder zipcodeEncoder;

    @Autowired
    private ItemService itemService;
    @Autowired
    public Controller(Scraper scraper, ZipCodeEncoder zipcodeEncoder) {
        this.scraper = scraper;
        this.zipcodeEncoder = zipcodeEncoder;
    }


    @PostMapping("/add")
    public String add(@RequestBody Item item){
        itemService.saveItem(item);
        return "new item added";
    }
    @GetMapping("/getItems")
    public List<Item> getItems(){
        return itemService.getAllItems();
    }
    @GetMapping("/scrape/")
    public List<Item> scrape(@RequestParam String cat,@RequestParam String zip) throws InterruptedException {
        String encodedZip = zipcodeEncoder.getEncodedZip(zip);
        System.out.println("it hit it");
        return scraper.scrapeData(cat,encodedZip);
    }
    @GetMapping("/scrapedb/")
    public String scrapedb(@RequestParam String cat,@RequestParam String zip) throws InterruptedException {
        System.out.println("it hit it");
for (Item item:scraper.scrapeData(cat,zip)){
    itemService.saveItem(item);
}
        return "Items saved to db";
    }

}
