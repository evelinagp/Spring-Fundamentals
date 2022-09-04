package com.example.examprepmusicdb.model.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {
    private String username;
    private String fullName;
    private String email;
    private String password;
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    @NotBlank(message = "Username can not be empty string.")
    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 characters.")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotBlank(message = "Full name can not be empty string.")
    @Size(min = 3, max = 20, message = "Full name length must be between 3 and 20 characters.")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @NotBlank(message = "Email can not be empty string.")
    @Email(message = "Must be valid email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotBlank(message = "Password can not be empty string.")
    @Size(min = 5, max = 20, message = "Password length must be between 5 and 20 characters.")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotBlank(message = "Password can not be empty string.")
    @Size(min = 5, max = 20, message = "Password length must be between 5 and 20 characters.")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
