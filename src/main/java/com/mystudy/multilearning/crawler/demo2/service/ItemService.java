package com.mystudy.multilearning.crawler.demo2.service;

import com.mystudy.multilearning.crawler.demo2.pojo.Item;

import java.util.List;

public interface ItemService {

    List<Item> findAll(Item item);

    void save(Item item);
}
