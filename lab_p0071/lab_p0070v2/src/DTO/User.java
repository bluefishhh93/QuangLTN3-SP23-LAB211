/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author xuant
 */
public class User {
    private String userName;
    private String password;
    private String catpcha;
    
    public User() {
    }

    public User(String userName, String password,String catpcha) {
        this.userName = userName;
        this.password = password;
        this.catpcha = catpcha;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCatpcha() {
        return catpcha;
    }

    public void setCatpcha(String catpcha) {
        this.catpcha = catpcha;
    }
    
}
