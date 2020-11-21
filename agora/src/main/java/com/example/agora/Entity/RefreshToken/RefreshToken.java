package com.example.agora.Entity.RefreshToken;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RefreshToken")
public class RefreshToken {
    @Id
    private int userCode;

    @Length(max = 256)
    private String refreshToken;
}
