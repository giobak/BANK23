package example.bank_application.entity;

import example.bank_application.entity.enums.ManagerStatus;
import jakarta.persistence.*;
import lombok.*;

import java.security.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue
//    @GenericGenerator(name = "UUID",
//            strategy = "com.example.bank_application.generator.UuidTimeSequenceGenerator")
    @Column(name = "id")
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ManagerStatus status;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;


    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "products_managers",
            joinColumns = {@JoinColumn(name = "manager_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")})
    private Set<Product> products;
    @OneToMany(mappedBy = "manager", cascade = CascadeType.PERSIST)
    private Set<Client> clients;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager)) return false;
        Manager manager = (Manager) o;
        return firstName.equals(manager.firstName) && lastName.equals(manager.lastName) && clients.equals(manager.clients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, clients);
    }
}

