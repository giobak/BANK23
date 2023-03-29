package example.bank_application.service;

import example.bank_application.dto.AccountDTO;

public interface AccountService {


    AccountDTO getAccountById(String uuid);
}
