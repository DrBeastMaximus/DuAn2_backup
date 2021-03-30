package com.example.backend_final_project.Utils;

public class GlobalConstant {
    private static String username=null;
    private static int adminID=0;
    private static int role=-1;

    public static void returnDefault(){
        GlobalConstant.setAdminID(0);
        GlobalConstant.setRole(-1);
        GlobalConstant.setUsername(null);
    }

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
