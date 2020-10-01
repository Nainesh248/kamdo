package com.example.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public abstract class SignUpResponse {

    @Expose
    @SerializedName("messages")
    private List<String> messages;
    @Expose
    @SerializedName("status")
    private String status;
}
