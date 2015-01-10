package org.basewebapp.rest.resources.asm;

import org.basewebapp.core.entities.BlogEntry;
import org.basewebapp.rest.mvc.BlogEntryController;
import org.basewebapp.rest.resources.BlogEntryResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

public class BlogEntryResourceAsm extends ResourceAssemblerSupport<BlogEntry, BlogEntryResource>{


    public BlogEntryResourceAsm() {
        super(BlogEntryController.class, BlogEntryResource.class);
    }

    @Override
    public BlogEntryResource toResource(BlogEntry blogEntry) {
        BlogEntryResource resource = new BlogEntryResource();
        resource.setTitle(blogEntry.getTitle());
        
        // Creatin link for hateos
//        Link link = linkTo(methodOn(BlogEntryController.class).getBlogEntry(blogEntry.getId())).withSelfRel();
        // OR
        Link link = linkTo(BlogEntryController.class).slash(blogEntry.getId()).withSelfRel();
        
        resource.add(link.withSelfRel());
        
        return resource;
    }

}
