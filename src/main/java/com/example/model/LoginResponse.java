package com.example.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {


    @Expose
    @SerializedName("message")
    public String message;
    @Expose
    @SerializedName("data")
    public DataEntity data;
    @Expose
    @SerializedName("status")
    public boolean status;

    public static class DataEntity {
        @Expose
        @SerializedName("user")
        public UserEntity user;
        @Expose
        @SerializedName("expires_at")
        public String expiresAt;
        @Expose
        @SerializedName("type")
        public String type;
        @Expose
        @SerializedName("token")
        public String token;
    }

    public static class UserEntity {
        @Expose
        @SerializedName("updated_at")
        public String updatedAt;
        @Expose
        @SerializedName("created_at")
        public String createdAt;
        @Expose
        @SerializedName("is_active")
        public int isActive;
        @Expose
        @SerializedName("is_delete")
        public int isDelete;
        @Expose
        @SerializedName("device_info")
        public String deviceInfo;
        @Expose
        @SerializedName("device_id")
        public String deviceId;
        @Expose
        @SerializedName("device_token")
        public String deviceToken;
        @Expose
        @SerializedName("gst_no")
        public String gstNo;
        @Expose
        @SerializedName("company_name")
        public String companyName;
        @Expose
        @SerializedName("phone")
        public String phone;
        @Expose
        @SerializedName("role")
        public String role;
        @Expose
        @SerializedName("email")
        public String email;
        @Expose
        @SerializedName("name")
        public String name;
        @Expose
        @SerializedName("id")
        public int id;
    }
}
