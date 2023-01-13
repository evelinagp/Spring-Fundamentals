package com.example.examprepandreys.model.binding;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class UserRegisterBindingModel {
    private String username;
    private String email;
    private BigDecimal userBudget;
    private String password;
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }
    @NotBlank(message = "Username can not be empty str")
    @Size(min = 2, message = "Username length must be more than two characters")
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
    @Size (min = 2, message = "Password length must be more than two characters")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotBlank(message = "Password can not be empty str")
    @Size (min = 2, message = "Password length must be more than two characters")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Positive(message = "Must be a positive number")
    @NotNull(message = "Budget can not be empty field")
    public BigDecimal getUserBudget() {
        return userBudget;
    }

    public void setUserBudget(BigDecimal userBudget) {
        this.userBudget = userBudget;
    }
}
