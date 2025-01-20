package com.HerreraCodes.FreebiesBackend.Service;

import com.HerreraCodes.FreebiesBackend.Model.Item;

import java.util.List;

public interface ItemService {
    public Item saveItem(Item item);
    public List<Item> getAllItems();
}
