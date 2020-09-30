package com.example.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddVacancyActivity extends AppCompatActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R.id.edt_category)
    EditText edtCategory;
    @BindView(R.id.edt_sub_cat)
    EditText edtSubCat;
    @BindView(R.id.edt_job_open)
    EditText edtJobOpen;
    @BindView(R.id.edt_vacancy_loc)
    EditText edtVacancyLoc;
    @BindView(R.id.edt_type_mach)
    EditText edtTypeMach;
    @BindView(R.id.edt_approx_sal)
    EditText edtApproxSal;
    @BindView(R.id.edt_salary_time)
    EditText edtSalaryTime;
    @BindView(R.id.edt_working_shift)
    EditText edtWorkingShift;
    @BindView(R.id.btn_add)
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vacancy);
        init();

    }

    private void init() {
        try {
            ButterKnife.bind(this);
            ivBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}