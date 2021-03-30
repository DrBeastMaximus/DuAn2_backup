package com.example.backend_final_project.Utils;

public class GlobalConstant {
    private static String username;
    private static int adminID;
    private static int role;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        GlobalConstant.username = username;
    }

    public static int getAdminID() {
        return adminID;
    }

    public static void setAdminID(int adminID) {
        GlobalConstant.adminID = adminID;
    }

    public static int getRole() {
        return role;
    }

    public static void setRole(int role) {
        GlobalConstant.role = role;
    }
}
