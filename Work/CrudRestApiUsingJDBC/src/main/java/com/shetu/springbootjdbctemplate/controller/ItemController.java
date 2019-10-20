package com.shetu.springbootjdbctemplate.controller;

import com.shetu.springbootjdbctemplate.dao.ItemRepository;
import com.shetu.springbootjdbctemplate.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    ItemRepository itemRepository;

    @RequestMapping("/getAllItems")
    @ResponseBody
    public List<Item> getAllItems() {
        return itemRepository.getAllItems();
    }

    @RequestMapping("/getItem")
    @ResponseBody
    public Item getItem(@RequestParam("itemId") int itemId) {
        return itemRepository.getItem(itemId);
    }

    @RequestMapping("/addItem")
    @ResponseBody
    public String addItem(@RequestParam("id") int id, @RequestParam("name") String name,
                          @RequestParam("category") String category) {
        if (itemRepository.addItem(id, name, category) >= 1) {
            return "Item Added successfully";
        } else {
            return "Something went wrong!";
        }
    }

    @RequestMapping("/deleteItem")
    @ResponseBody
    public String deleteItem(@RequestParam("itemId") int itemId){
        if(itemRepository.deleteItem(itemId)>=1){
            return "Item is deleted successfully";
        }else {
            return "Something went wrong";
        }
    }
}
