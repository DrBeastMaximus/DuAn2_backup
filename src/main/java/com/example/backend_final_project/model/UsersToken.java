package com.example.backend_final_project.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Users_Token")
public class UsersToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int Id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User User;

    @Column(name = "account_status")
    private int AccountStatus;

    @Column(name = "email_confirm_token")
    private String EmailConfirmToken;

    @Column(name = "password_reminder_token")
    private String PasswordReminderToken;

    @Column(name = "registration_time")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "ysyyy/MM/dd")
    private Date RegistrationTime;

    @Column(name = "password_reminder_expire")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "ysyyy/MM/dd")
    private Date PasswordReminderExpire;


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User user) {
        this.User = user;
    }

    public int getAccountStatus() {
        return AccountStatus;
    }

    public void setAccountStatus(int accountStatus) {
        AccountStatus = accountStatus;
    }

    public String getEmailConfirmToken() {
        return EmailConfirmToken;
    }

    public void setEmailConfirmToken(String emailConfirmToken) {
        EmailConfirmToken = emailConfirmToken;
    }

    public String getPasswordReminderToken() {
        return PasswordReminderToken;
    }

    public void setPasswordReminderToken(String passwordReminderToken) {
        PasswordReminderToken = passwordReminderToken;
    }

    public Date getRegistrationTime() {
        return RegistrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        RegistrationTime = registrationTime;
    }

    public Date getPasswordReminderExpire() {
        return PasswordReminderExpire;
    }

    public void setPasswordReminderExpire(Date passwordReminderExpire) {
        PasswordReminderExpire = passwordReminderExpire;
    }

    public UsersToken(int id, User user, int accountStatus, String email_confirm_token, String password_reminder_token, Date registration_time, Date password_reminder_expire) {
        Id=id;
        User=user;
        AccountStatus=accountStatus;
        EmailConfirmToken=email_confirm_token;
        PasswordReminderToken=password_reminder_token;
        RegistrationTime=registration_time;
        PasswordReminderExpire=password_reminder_expire;
    }
    public UsersToken() {
    }
}
