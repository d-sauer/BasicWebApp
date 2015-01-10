package org.basewebapp.rest.mvc;

import org.basewebapp.core.entities.BlogEntry;
import org.basewebapp.core.services.BlogEntryService;
import org.basewebapp.rest.resources.BlogEntryResource;
import org.basewebapp.rest.resources.asm.BlogEntryResourceAsm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/rest/blog-entries")
public class BlogEntryController {

    private BlogEntryService blogEntryService;
    
    public BlogEntryController(BlogEntryService service) {
        this.blogEntryService = service;
    }
    
    @RequestMapping(value = "/{blogEntryId}", method = RequestMethod.GET)
    public ResponseEntity<BlogEntryResource> getBlogEntry(@PathVariable Long blogEntryId) {
        BlogEntry entry = blogEntryService.find(blogEntryId);
        if (entry != null) {
            BlogEntryResource res = new BlogEntryResourceAsm().toResource(entry);
            return new ResponseEntity<BlogEntryResource>(res, HttpStatus.OK);
        }
        
        return new ResponseEntity<BlogEntryResource>(HttpStatus.NOT_FOUND);
        
    }
    
}