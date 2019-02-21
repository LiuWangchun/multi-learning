package com.mystudy.multilearning;

import com.mystudy.multilearning.crawler.demo2.task.ItemTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MultiLearningApplication.class)
public class MultiLearningApplicationTests {

    @Autowired
    ItemTask itemTask;

    @Test
    public void contextTest() throws IOException {
        itemTask.process();
    }

}
