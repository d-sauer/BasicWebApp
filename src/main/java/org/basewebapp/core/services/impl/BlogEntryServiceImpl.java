package org.basewebapp.core.services.impl;

import org.basewebapp.core.models.entities.BlogEntry;
import org.basewebapp.core.repositories.BlogEntryRepo;
import org.basewebapp.core.services.BlogEntryService;

public class BlogEntryServiceImpl implements BlogEntryService {

    private BlogEntryRepo entryRepo;

    @Override
    public BlogEntry findBlogEntry(Long id) {
        return entryRepo.findBlogEntry(id);
    }

    @Override
    public BlogEntry deleteBlogEntry(Long id) {
        return entryRepo.deleteBlogEntry(id);
    }

    @Override
    public BlogEntry updateBlogEntry(Long id, BlogEntry data) {
        return entryRepo.updateBlogEntry(id, data);
    }
}
