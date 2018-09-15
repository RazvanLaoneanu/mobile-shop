package SDAcademy.mobile.shop.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {

    @ManyToMany(fetch=FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH} )
    @JoinTable(name="phone_user", joinColumns=@JoinColumn(name="id_user"),inverseJoinColumns=@JoinColumn(name="id_phone"))
    private List<Phone> phone;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_user")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="password")
    private String password;

    @Column(name="admin")
    private boolean admin;

    public User(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin(){
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", password='" + password + '\'' + ", admin=" + admin + '}';
    }
}
