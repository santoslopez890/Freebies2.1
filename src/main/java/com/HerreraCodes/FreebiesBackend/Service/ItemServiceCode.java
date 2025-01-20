package com.HerreraCodes.FreebiesBackend.Service;

import com.HerreraCodes.FreebiesBackend.Model.Item;
import com.HerreraCodes.FreebiesBackend.Repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceCode implements ItemService {
    @Autowired
    private ItemRepo itemRepo;

    @Override
    public Item saveItem(Item item) {
        return itemRepo.save(item);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepo.findAll();
    }
}
