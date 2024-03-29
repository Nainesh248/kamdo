package com.example.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public abstract class AddVacancyResponse {

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
        @SerializedName("working_time")
        private String workingTime;
        @Expose
        @SerializedName("salary_time")
        private String salaryTime;
        @Expose
        @SerializedName("approx_salary")
        private String approxSalary;
        @Expose
        @SerializedName("cat_id")
        private String catId;
        @Expose
        @SerializedName("machine_id")
        private String machineId;
        @Expose
        @SerializedName("job_opening")
        private String jobOpening;
        @Expose
        @SerializedName("address")
        private String address;
        @Expose
        @SerializedName("user_id")
        private String userId;
    }
}
