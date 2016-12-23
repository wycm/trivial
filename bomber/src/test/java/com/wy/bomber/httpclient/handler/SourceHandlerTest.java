package com.wy.bomber.httpclient.handler;

import com.wy.bomber.handler.SourceHandler;
import com.wy.bomber.handler.SourceTask;
import com.wy.bomber.httpclient.util.HttpClientUtil;
import com.wy.bomber.pojo.Source;
import com.wy.bomber.service.SourceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;

/**
 * Created by root on 11/2/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SourceHandlerTest {
    @Autowired
    private SourceHandler sourceHandler;

    @Autowired
    private SourceService sourceService;

    @Test
    public void testHandleSource(){
        List<Source> list = sourceService.findAllAvailable();
        for(Source source : list) {
            sourceHandler.handleSource(source, "13088280860");
        }
        System.out.println("running 5 minutes");
        try {
            Thread.sleep(1000 * 60 * 5);
            SourceTask.isStop = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
