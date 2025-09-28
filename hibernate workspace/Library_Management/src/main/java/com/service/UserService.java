package com.service;

import com.dao.UserDAO;
import com.entity.User;

public class UserService {

    UserDAO ud = new UserDAO();
    
    public void addUser(String name, String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        ud.addUser(user);
    }
    
    public void getUserById(int userId) {
        User user = ud.getUserById(userId);
        if (user != null) {
           System.out.println(user);
        } else {
            System.out.println("User not found");
        }
    }
    
    public void updateUser(int userId, String name, String email) {
        User user = ud.getUserById(userId);
        if (user != null) {
            user.setName(name);
            user.setEmail(email);
            ud.updateUser(user);
        } else {
            System.out.println("User not found");
        }
    }
    
    public void borrowBook(int userId, int bookId) {
        ud.borrowBook(userId, bookId);
    }
    
    public void returnBook(int bookId) {
        ud.returnBook(bookId);
    }
}