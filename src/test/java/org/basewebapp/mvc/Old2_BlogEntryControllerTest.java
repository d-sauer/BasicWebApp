package org.basewebapp.mvc;

import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.basewebapp.core.models.entities.BlogEntry;
import org.basewebapp.core.services.BlogEntryService;
import org.basewebapp.rest.mvc.Old2_BlogEntryController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Deprecated
public class Old2_BlogEntryControllerTest {

    @InjectMocks
    private Old2_BlogEntryController controller;
    
    @Mock
    private BlogEntryService service;
    
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
    public void getExistingBlogEntry() throws Exception {
        // define simulated blog entry that service will find it
        BlogEntry blogEntry = new BlogEntry();
        blogEntry.setId(1L);
        blogEntry.setTitle("Test title");
        
        // simulate service method
        when(service.findBlogEntry(1L)).thenReturn(blogEntry);
        
        // send request
        ResultActions result = mockMvc.perform(get("/rest/blog-entries/1"));
        result.andDo(print())
               .andExpect(jsonPath("$.title", is(blogEntry.getTitle())))
               .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/blog-entries/1"))))
               .andExpect(status().isOk());
    }

    @Test
    public void getNotExistingBlogEntry() throws Exception {
        // simulate service method
        when(service.findBlogEntry(1L)).thenReturn(null);
        
        // send request
        ResultActions result = mockMvc.perform(get("/rest/blog-entries/1"));
        result.andExpect(status().isNotFound());
    }
    
}
