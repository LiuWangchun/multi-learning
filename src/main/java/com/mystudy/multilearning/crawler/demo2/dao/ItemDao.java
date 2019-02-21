package com.mystudy.multilearning.crawler.demo2.dao;

import com.mystudy.multilearning.crawler.demo2.pojo.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDao extends JpaRepository<Item, Long> {
}
