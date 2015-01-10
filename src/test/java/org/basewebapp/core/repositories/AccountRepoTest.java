package org.basewebapp.core.repositories;

import javax.transaction.Transactional;

import org.basewebapp.core.models.entities.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/business-config.xml")
public class AccountRepoTest {

    @Autowired
    private AccountRepo repo;
    private Account acc;
    
    @Before
    @Transactional
    @Rollback(false)
    public void setup() {
        acc = new Account();
        acc.setName("user");
        acc.setPassword("pass");
        
        repo.createAccount(acc);
    }
    
    @Test
    public void test() {
        
    }

    @Test
    @Transactional
    public void testFind() {
        assertNotNull(repo.findAccount(acc.getId()));
    }
}
