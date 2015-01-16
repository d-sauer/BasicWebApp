package org.basewebapp.core.services.impl;

import org.basewebapp.core.models.entities.Blog;
import org.basewebapp.core.models.entities.BlogEntry;
import org.basewebapp.core.repositories.BlogEntryRepo;
import org.basewebapp.core.repositories.BlogRepo;
import org.basewebapp.core.services.BlogService;
import org.basewebapp.core.services.exceptions.BlogNotFoundException;
import org.basewebapp.core.services.util.BlogEntryList;
import org.basewebapp.core.services.util.BlogList;

public class BlogServiceImpl implements BlogService {

    private BlogRepo blogRepo;

    private BlogEntryRepo entryRepo;

    @Override
    public BlogEntry createBlogEntry(Long blogId, BlogEntry data) {
        Blog blog = blogRepo.findBlog(blogId);
        if(blog == null)
        {
            throw new BlogNotFoundException();
        }
        BlogEntry entry = entryRepo.createBlogEntry(data);
        entry.setBlog(blog);
        return entry;
    }

    @Override
    public BlogList findAllBlogs() {
        return new BlogList(blogRepo.findAllBlogs());
    }

    @Override
    public BlogEntryList findAllBlogEntries(Long blogId) {
        Blog blog = blogRepo.findBlog(blogId);
        if(blog == null)
        {
            throw new BlogNotFoundException();
        }
        return new BlogEntryList(blogId, entryRepo.findByBlogId(blogId));
    }

    @Override
    public Blog findBlog(Long id) {
        return blogRepo.findBlog(id);
    }
}
