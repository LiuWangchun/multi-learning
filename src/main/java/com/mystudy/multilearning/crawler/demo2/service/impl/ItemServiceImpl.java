package com.mystudy.multilearning.crawler.demo2.service.impl;

import com.mystudy.multilearning.crawler.demo2.dao.ItemDao;
import com.mystudy.multilearning.crawler.demo2.pojo.Item;
import com.mystudy.multilearning.crawler.demo2.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName ItemServiceImpl
 * @Description TODO
 * @Author MrLiu
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;

    @Override
    public List<Item> findAll(Item item) {
        Example example = Example.of(item);
        List list = this.itemDao.findAll(example);
        return list;
    }

    @Override
    @Transactional
    public void save(Item item) {
        itemDao.save(item);
    }
}
