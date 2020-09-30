package com.example.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AllRequestFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AllRequestFragment extends Fragment {


    public AllRequestFragment() {
        // Required empty public constructor
    }
    public static AllRequestFragment newInstance(String param1, String param2) {
        AllRequestFragment fragment = new AllRequestFragment();
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
        return inflater.inflate(R.layout.fragment_all_request, container, false);
    }
}