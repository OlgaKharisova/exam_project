package ru.innopolis.entity.user;

import javax.persistence.*;

@Entity
public class Client extends Authorizable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @OneToOne
    private UserInfo userInfo;

    public Client() {
    }

    public Client(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public long getId() {
        return id;
    }

    public Client setId(long id) {
        this.id = id;
        return this;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

}
