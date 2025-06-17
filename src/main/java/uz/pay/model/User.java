package uz.pay.model;

import lombok.Data;

import java.util.UUID;
@Data
public class User {
    private UUID id;
    private String name;
    private String password;

    public User() {
    }



    public User(String name, String password) {
        this();
        this.id = UUID.randomUUID();
        this.name = name;
        this.password = password;
    }
}
