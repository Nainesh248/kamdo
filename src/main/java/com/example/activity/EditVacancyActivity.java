package com.example.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import com.example.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditVacancyActivity extends AppCompatActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R.id.edit_job_vac)
    TextView editJobVac;
    @BindView(R.id.tv_name)
    TextView tvName;
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
    @BindView(R.id.ll_contain)
    LinearLayout llContain;
    @BindView(R.id.nsv_reg)
    NestedScrollView nsvReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_vacancy);
        init();

    }

    private void init() {
        try {
            ButterKnife.bind(this);
            ivBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
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