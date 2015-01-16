package org.basewebapp.core.services.impl;

import org.basewebapp.core.models.entities.Account;
import org.basewebapp.core.models.entities.Blog;
import org.basewebapp.core.repositories.AccountRepo;
import org.basewebapp.core.repositories.BlogRepo;
import org.basewebapp.core.services.AccountService;
import org.basewebapp.core.services.exceptions.AccountDoesNotExistException;
import org.basewebapp.core.services.exceptions.AccountExistsException;
import org.basewebapp.core.services.exceptions.BlogExistsException;
import org.basewebapp.core.services.util.AccountList;
import org.basewebapp.core.services.util.BlogList;

public class AccountServiceImpl implements AccountService {

    private AccountRepo accountRepo;

    private BlogRepo blogRepo;

    @Override
    public Account findAccount(Long id) {
        return accountRepo.findAccount(id);
    }

    @Override
    public Account createAccount(Account data) {
        Account account = accountRepo.findAccountByName(data.getName());
        if(account != null)
        {
            throw new AccountExistsException();
        }
        return accountRepo.createAccount(data);
    }

    @Override
    public Blog createBlog(Long accountId, Blog data) {
        Blog blogSameTitle = blogRepo.findBlogByTitle(data.getTitle());

        if(blogSameTitle != null)
        {
            throw new BlogExistsException();
        }

        Account account = accountRepo.findAccount(accountId);
        if(account == null)
        {
            throw new AccountDoesNotExistException();
        }

        Blog createdBlog = blogRepo.createBlog(data);

        createdBlog.setOwner(account);

        return createdBlog;
    }

    @Override
    public BlogList findBlogsByAccount(Long accountId) {
        Account account = accountRepo.findAccount(accountId);
        if(account == null)
        {
            throw new AccountDoesNotExistException();
        }
        return new BlogList(blogRepo.findBlogsByAccount(accountId));
    }

    @Override
    public AccountList findAllAccounts() {
        return new AccountList(accountRepo.findAllAccounts());
    }

    @Override
    public Account findByAccountName(String name) {
        return accountRepo.findAccountByName(name);
    }
}
