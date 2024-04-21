package com.springvalidation.Entity;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class LoginData {

    @NotEmpty(message = "username can not be empty.")
    @Size(min = 2, max = 14, message = "username should be in between 2 to 14 characters.")
    private String userName;

    @Email(regexp = "^(?!\\.)[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email!")
    private String email;

    @AssertTrue
    private boolean tnc;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "LoginData [userName=" + userName + ", email=" + email + "]";
    }

    public boolean isTnc() {
        return tnc;
    }

    public void setTnc(boolean tnc) {
        this.tnc = tnc;
    }

}
