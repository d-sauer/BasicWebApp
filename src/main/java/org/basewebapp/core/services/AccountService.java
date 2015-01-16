package org.basewebapp.core.services;

import org.basewebapp.core.models.entities.Account;
import org.basewebapp.core.models.entities.Blog;
import org.basewebapp.core.services.util.AccountList;
import org.basewebapp.core.services.util.BlogList;

public interface AccountService {
    public Account findAccount(Long id);
    public Account createAccount(Account data);
    public Blog createBlog(Long accountId, Blog data);
    public BlogList findBlogsByAccount(Long accountId);
    public AccountList findAllAccounts();
    public Account findByAccountName(String name);
}
