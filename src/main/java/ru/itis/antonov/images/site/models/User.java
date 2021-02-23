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
@Table(name = "account")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String email;
    private String password;


    @Enumerated(value = EnumType.STRING)
    private State state;

    private String confirmCode;

    public enum State{
        CONFIRMED, NON_CONFIRMED
    }
}
