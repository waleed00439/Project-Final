package com.example.gamesonlinedatabase1.Modle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "username: can't be Empty !")
    @Column(columnDefinition = "varchar(20) unique not null")
    private String username;
    @NotEmpty(message = "password: can't be Empty")
    @Size(min = 6, message = "password: must to be than 6")
    private String password;
    @NotEmpty(message = "role: can't be Empty")
    @Pattern(regexp = "(USER|ADMIN)")
    private String role;
    @NotEmpty(message = "Email: can't be Empty")
    @Email
    @Column(columnDefinition = "varchar(20) unique not null")
    private String email;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.role));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
