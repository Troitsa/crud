package pojo;

public class User {
    private int id;
    private String name;
    private String password;
    private String login;

    public User(String name, String login, String password) {
        this.name = name;
        this.password = password;
        this.login = login;
    }

    public User(int id, String name, String login, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.login = login;
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
}
