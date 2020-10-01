package com.example.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public abstract class AddVacancyResponse {

    @Expose
    @SerializedName("user_id")
    private int userId;
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
    @SerializedName("latitude")
    private String latitude;
    @Expose
    @SerializedName("longitude")
    private String longitude;
    @Expose
    @SerializedName("address")
    private String address;
    @Expose
    @SerializedName("machine_id")
    private String machineId;
    @Expose
    @SerializedName("job_opening")
    private String jobOpening;
    @Expose
    @SerializedName("cat_id")
    private String catId;
}
