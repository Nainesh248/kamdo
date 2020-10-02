package com.example.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public abstract class NotificationResponse {

    @Expose
    @SerializedName("message")
    private String message;
    @Expose
    @SerializedName("data")
    private DataEntity data;
    @Expose
    @SerializedName("status")
    private String status;

    public static class DataEntity {
        @Expose
        @SerializedName("id")
        private int id;
        @Expose
        @SerializedName("created_at")
        private String createdAt;
        @Expose
        @SerializedName("updated_at")
        private String updatedAt;
        @Expose
        @SerializedName("vacancy_id")
        private String vacancyId;
        @Expose
        @SerializedName("user_id")
        private String userId;
    }
}
