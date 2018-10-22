package ru.innopolis.entity.user;

import ru.innopolis.enums.Role;

import javax.persistence.*;

@Entity
public class Credentials {

    @Id
    private String email;

    private String passwordEncrypted;

    private Role role;
//
//    @OneToOne
//    private Authorizable user;

    public Credentials() {
    }

    public Credentials(String email, String passwordEncrypted, Role role, Authorizable user) {
        this.email = email;
        this.passwordEncrypted = passwordEncrypted;
        this.role = role;
//        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordEncrypted() {
        return passwordEncrypted;
    }

    public void setPasswordEncrypted(String passwordEncrypted) {
        this.passwordEncrypted = passwordEncrypted;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}