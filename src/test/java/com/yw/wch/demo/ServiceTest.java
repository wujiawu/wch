package com.yw.wch.demo;

import com.google.common.collect.ImmutableMap;
import com.yw.wch.entity.Demo;
import com.yw.wch.service.DemoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by wujiawu on 2017/5/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles({"dev"})
@SpringBootTest
public class ServiceTest {
    @Autowired
    private DemoService demoService;

    /**
     * 动态组合查询
     * @throws Exception
     */
    @Test
    public void searchTest() throws Exception {
        ImmutableMap<String, Object> qs = ImmutableMap.of("EQ_name", "ok", "LIKE_descr", "asd");
        List<Demo> demoList = demoService.search(qs);
        assert demoList.size() == 1;
    }


}
