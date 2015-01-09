package org.basewebapp.mvc;

import org.basewebapp.entities.BlogEntry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BlogEntryController {

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    @RequestMapping("/test2")
    public ResponseEntity<Object> test2() {
        BlogEntry blogEntry = new BlogEntry();
        blogEntry.setTitle("Test blog entry");
    
        return new ResponseEntity<Object>(blogEntry, HttpStatus.OK);
    }

    @RequestMapping("/test2B")
    public @ResponseBody BlogEntry test2B() {
        BlogEntry blogEntry = new BlogEntry();
        blogEntry.setTitle("Test blog entry");
        
        return blogEntry;
    }

    @RequestMapping(value = "/test3", method = RequestMethod.POST)
    public @ResponseBody BlogEntry test3(@RequestBody BlogEntry blogEntry) {
        
        
        return blogEntry;
    }
    
}
