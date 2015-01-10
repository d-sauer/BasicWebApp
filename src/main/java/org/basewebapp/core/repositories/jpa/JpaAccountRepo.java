package org.basewebapp.core.repositories.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.basewebapp.core.models.entities.Account;
import org.basewebapp.core.models.entities.Blog;
import org.basewebapp.core.repositories.AccountRepo;
import org.springframework.stereotype.Repository;

@Repository 
public class JpaAccountRepo implements AccountRepo {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Account findAccount(Long id) {
        return em.find(Account.class, id);
    }

    @Override
    public Account createAccount(Account data) {
        em.persist(data);
        return data;
    }

    @Override
    public Blog createBlog(Long accountId, Blog data) {
        // TODO Auto-generated method stub
        return null;
    }

}
