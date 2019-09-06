package pojo;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String name;
    private String password;
    private String login;
    private String role;


    public User(String name, String login, String password) {
        this.name = name;
        this.password = password;
        this.login = login;
    }

    public User(int id, String name, String login, String password, String role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.login = login;
        this.role = role;
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
