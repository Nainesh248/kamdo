package com.example.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.R;
public class UserAllRequestFragment extends Fragment {


    View rootView;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_user_all_request, container, false);
        init();
        return rootView;

    }

    private void init() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}