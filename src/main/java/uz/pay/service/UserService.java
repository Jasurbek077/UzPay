package uz.pay.service;

import uz.pay.model.User;
import uz.pay.utility.FileUtility;

import java.util.List;

public class UserService {

    private static final String USER_FILE = "./files/users/json";
    private final List<User> users;

    public UserService() {
        this.users = FileUtility.loadFileFromJson(USER_FILE, User.class);
    }

    public String registerUser(User user) {
        for (User u : users) {
            if (user.getName().equals(u.getName())) {
                return "Username is already in registered";
            }
        }
        users.add(user);
        FileUtility.saveFileToJson(USER_FILE, users);
        return  "User registered successfully";
    }

    public User loginUser(User user) {
        for (User u : users) {
            if (u.getName().equals(user.getName()) && u.getPassword().equals(user.getPassword())) {
                System.out.println("User logged in successfully");
                return u;
            }
        }
        System.out.println("Login Failed. Try again!");
        return null;
    }


    public User getUsername(String username){
        for (User user : users) {
            if(user.getName().equals(username)){
                return user;
            }
        }
        return null;
    }



}
