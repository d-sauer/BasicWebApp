package org.basewebapp.core.repositories;

import org.basewebapp.core.models.entities.Account;
import org.basewebapp.core.models.entities.Blog;

public interface AccountRepo {
    public Account findAccount(Long id);

    public Account createAccount(Account data);

    public Blog createBlog(Long accountId, Blog data);
}
