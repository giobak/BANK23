package example.bank_application.entity;

import example.bank_application.entity.enums.AccountProductStatus;
import example.bank_application.entity.enums.AccountType;
import example.bank_application.entity.enums.CurrencyType;
import jakarta.persistence.*;
import lombok.*;

import java.security.Timestamp;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Account {


    @Id
    @GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)  //UUID????????
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private AccountType type;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private AccountProductStatus status;

    @Column(name = "balance")
    private double balance;

    @Column(name = "currency_code")
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyCode;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName="id")
    private Client client;

    @OneToMany(mappedBy = "debitAccount", cascade = CascadeType.ALL)
    private Set<Transaction> transactionDebits;

    @OneToMany(mappedBy = "creditAccount", cascade = CascadeType.ALL)
    private Set<Transaction> transactionCredits;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private Set<Agreement> agreements;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
