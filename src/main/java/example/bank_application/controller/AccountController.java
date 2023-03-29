package example.bank_application.controller;


import example.bank_application.dto.AccountDTO;
import example.bank_application.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/{uuid}")
    public AccountDTO getAccountById(@PathVariable String uuid) {
        return accountService.getAccountById(uuid);
    }
}
