package com.example.myproject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by wujiawu on 2017/5/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServerSideTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    /**
     * 简单的get请求
     * @throws Exception
     */
    @Test
    public void getTest() throws Exception {
        this.mockMvc.perform(get("/").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.hello").value("world"));
    }

    /**
     * 简单的post请求
     * @throws Exception
     */
    @Test
    public void postTest() throws Exception {

        MockHttpServletRequestBuilder createMessage = post("/")
                .param("foo", "1000")
                .param("bar", "2000");

        this.mockMvc.perform(createMessage.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.foo").value("foo1000"))
                .andExpect(jsonPath("$.bar").value("bar2000"));
    }


    /**
     * 使用yaml进行属性配置，替代传统的properties
     * @throws Exception
     */
    @Test
    public void yamlTest() throws Exception {
        this.mockMvc.perform(get("/yaml").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }


    /**
     * 使用 spring-data-jpa 进行数据库查询
     * @throws Exception
     */
    @Test
    public void jpaQueryTest() throws Exception {
        this.mockMvc.perform(get("/my-test?name=ok").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.id").value("123456"));
    }

    /**
     * 使用 spring-data-jpa 进行数据库插入操作
     * @throws Exception
     */
    @Test
    public void jpaInsertTest() throws Exception {

        String id = UUID.randomUUID().toString();

        MockHttpServletRequestBuilder createMessage = post("/my-test")
                .param("id", id)
                .param("name", "2000");

        this.mockMvc.perform(createMessage.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.id").value(id));
    }
}
