package org.basewebapp.rest.resources.asm;

import java.util.List;

import org.basewebapp.core.services.util.AccountList;
import org.basewebapp.rest.mvc.AccountController;
import org.basewebapp.rest.resources.AccountListResource;
import org.basewebapp.rest.resources.AccountResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class AccountListResourceAsm extends ResourceAssemblerSupport<AccountList, AccountListResource> {

    public AccountListResourceAsm() {
        super(AccountController.class, AccountListResource.class);
    }

    @Override
    public AccountListResource toResource(AccountList accountList) {
        List<AccountResource> resList = new AccountResourceAsm().toResources(accountList.getAccounts());
        AccountListResource finalRes = new AccountListResource();
        finalRes.setAccounts(resList);
        return finalRes;
    }
}
