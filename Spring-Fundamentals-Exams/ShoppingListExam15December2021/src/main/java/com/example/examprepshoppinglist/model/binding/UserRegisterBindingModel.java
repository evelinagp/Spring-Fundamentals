package com.example.examprepshoppinglist.model.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {
    private String username;
    private String email;
    private String password;
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }
    @NotBlank(message = "Username can not be empty str")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotBlank
    @Email(message = "Email must be valid")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotBlank(message = "Password can not be empty str")
    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotBlank(message = "Password can not be empty str")
    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
