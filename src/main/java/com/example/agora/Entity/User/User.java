package com.example.agora.Entity.User;

import com.example.agora.Security.AuthorityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "User")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userCode;

    @Column(nullable = false, unique = true, length = 20)
    private String userId;

    @Column(nullable = false)
    private String userPw;

    @Column(nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private AuthorityType authorityType;
}
