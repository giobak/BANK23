package example.bank_application.service.impl;

import example.bank_application.dto.AccountDTO;
import example.bank_application.mapper.AccountMapper;
import example.bank_application.repository.AccountRepository;
import example.bank_application.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountMapper accountMapper;
    private final AccountRepository getAllAccountRepository;


    @Override
    public AccountDTO getAccountById(String uuid) {
        return accountMapper.toDto(getAllAccountRepository.findAllById(Collections.singleton(UUID.fromString(uuid))).get(Integer.parseInt(uuid)));
    }
}