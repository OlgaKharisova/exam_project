package ru.innopolis.entity.user;


import javax.persistence.*;

@Entity
public class Manager extends Authorizable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @OneToOne
    private UserInfo userInfo;

    public Manager() {
    }

    public Manager(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

}
