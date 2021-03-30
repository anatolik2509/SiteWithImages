package ru.itis.antonov.images.site.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "account",
        uniqueConstraints = @UniqueConstraint(name = "unique_email_constraint", columnNames = {"email"}))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String email;
    private String password;
    private boolean isBanned = false;


    @Enumerated(value = EnumType.STRING)
    private State state = State.NON_CONFIRMED;

    @Enumerated(value = EnumType.STRING)
    private Role role = Role.USER;

    private String confirmCode;

    public enum State{
        CONFIRMED, NON_CONFIRMED
    }

    public enum Role{
        USER, ADMIN;
    }
}
