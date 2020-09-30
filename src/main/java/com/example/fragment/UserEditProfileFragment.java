package com.example.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserEditProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserEditProfileFragment extends Fragment {

    public UserEditProfileFragment() {
        // Required empty public constructor
    }

    public static UserEditProfileFragment newInstance(String param1, String param2) {
        UserEditProfileFragment fragment = new UserEditProfileFragment();
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
        return inflater.inflate(R.layout.fragment_user_edit_profile, container, false);
    }
}