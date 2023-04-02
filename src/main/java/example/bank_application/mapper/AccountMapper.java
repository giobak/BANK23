package example.bank_application.mapper;

import example.bank_application.dto.AccountDTO;
import example.bank_application.entity.Account;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountDTO toDto(Account account);


}