package org.basewebapp.mvc;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

public class BlogEntryControllerTest {

    @InjectMocks
    private BlogEntryController controller;
    
    private MockMvc mockMvc;
    
    @Before
    public void setup() {
        // Mimics the configuration defined under WEB-INF/mvc-dispatcher-servlet.xml
        // ref.: http://myshittycode.com/2014/01/17/mockmvc-circular-view-path-view-would-dispatch-back-to-the-current-handler-url-view-again/
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/view/");
        viewResolver.setSuffix(".jsp");
        
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                                 .setViewResolvers(viewResolver)
                                 .build();
    }       
    
    @Test
    public void test() throws Exception {
        mockMvc.perform(get("/test")).andDo(print());
    }

    @Test
    public void test2() throws Exception {
        mockMvc.perform(get("/test2")).andDo(print());
    }

    @Test
    public void test2B() throws Exception {
        mockMvc.perform(get("/test2B")).andDo(print());
    }

    @Test
    public void test3() throws Exception {
        mockMvc.perform(post("/test3")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\" : \"Blog title 3\"}")).andDo(print());
    }

    @Test
    public void test3B() throws Exception {
        mockMvc.perform(post("/test3")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\" : \"Blog title 3\"}"))
                .andExpect(jsonPath("$.title", is("Blog title 3")))
                .andDo(print());
    }
}
