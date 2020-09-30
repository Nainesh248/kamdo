package com.example.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserNotificationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserNotificationFragment extends Fragment {
    public UserNotificationFragment() {
        // Required empty public constructor
    }
    public static UserNotificationFragment newInstance(String param1, String param2) {
        UserNotificationFragment fragment = new UserNotificationFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_notification, container, false);
    }
}