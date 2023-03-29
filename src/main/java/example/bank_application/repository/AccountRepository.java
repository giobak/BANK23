package example.bank_application.repository;


import example.bank_application.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public abstract interface AccountRepository extends JpaRepository<Account, UUID> {

}
