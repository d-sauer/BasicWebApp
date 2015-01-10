package org.basewebapp.core.services;

import org.basewebapp.core.models.entities.Account;
import org.basewebapp.core.models.entities.Blog;

public interface AccountService {
    public Account findAccount(Long id);

    public Account createAccount(Account data);

    public Blog createBlog(Long accountId, Blog data);
}
