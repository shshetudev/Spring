package com.shetu.springbootjdbctemplate.dao;

import com.shetu.springbootjdbctemplate.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepository {
    @Autowired
    JdbcTemplate template;

    /*Getting all items from table*/
    public List<Item> getAllItems(){
        List<Item> items = template.query("select id,name,category from item",(result,rowNum)->new Item(
                result.getInt("id"),result.getString("name"),
                result.getString("category")
        ));
        return items;
    }
    /*Getting a specific item by item id from table*/
    public Item getItem(int itemId){
        String query = "select * form item where id=?";
        Item item = template.queryForObject(query,new Object[]{itemId},new BeanPropertyRowMapper<>(Item.class));
        return item;
    }
    /*Adding an item into database table*/
    public int addItem(int id,String name,String category){
        String query ="insert into item values(?,?,?)";
        return template.update(query,id,name,category);
    }
    /*delete an item from database*/
    public int deleteItem(int id){
        String query="delete from item where id=?";
        return template.update(query,id);
    }
}
