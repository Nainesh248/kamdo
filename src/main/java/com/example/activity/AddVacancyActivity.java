package com.example.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.R;
import com.example.config.CommonFunctions;
import com.example.config.Constants;
import com.example.config.KamdoConfig;
import com.example.model.LoginResponse;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

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
    String id;
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
            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addvacnacy();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addvacnacy() {
        try {
            if (edtCategory.getText().toString().trim().length() == 0) {
                Toast.makeText(AddVacancyActivity.this, getString(R.string.err_addcat), Toast.LENGTH_SHORT).show();
            } else if (edtSubCat.getText().toString().trim().length() == 0) {
                Toast.makeText(AddVacancyActivity.this, getString(R.string.err_subcat), Toast.LENGTH_SHORT).show();
            } else if (edtJobOpen.getText().toString().trim().length() == 0) {
                Toast.makeText(AddVacancyActivity.this, getString(R.string.err_job_open), Toast.LENGTH_SHORT).show();
            } else if (edtVacancyLoc.getText().toString().trim().length() == 0) {
                Toast.makeText(AddVacancyActivity.this, getString(R.string.err_vac_loc), Toast.LENGTH_SHORT).show();
            } else if (edtTypeMach.getText().toString().trim().length() == 0) {
                Toast.makeText(AddVacancyActivity.this, getString(R.string.err_typ_mach), Toast.LENGTH_SHORT).show();
            } else if (edtApproxSal.getText().toString().trim().length() == 0) {
                Toast.makeText(AddVacancyActivity.this, getString(R.string.err_aprox_sal), Toast.LENGTH_SHORT).show();
            } else if (edtSalaryTime.getText().toString().trim().length() == 0) {
                Toast.makeText(AddVacancyActivity.this, getString(R.string.err_salary), Toast.LENGTH_SHORT).show();
            } else if (edtWorkingShift.getText().toString().trim().length() == 0) {
                Toast.makeText(AddVacancyActivity.this, getString(R.string.err_work_shift), Toast.LENGTH_SHORT).show();
            } else {
                vacancydd();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void vacancydd() {
        try {
            if (CommonFunctions.checkConnection(AddVacancyActivity.this)) {
                String url = KamdoConfig.WEBURL + KamdoConfig.add_vacancy;
                Map<String, String> mParams = new HashMap<>();
                mParams.put(Constants.cat_id, edtCategory.getText().toString().trim());
                mParams.put(Constants.subcategory, edtSubCat.getText().toString().trim());
                mParams.put(Constants.job_opening, edtJobOpen.getText().toString().trim());
                mParams.put(Constants.address, edtVacancyLoc.getText().toString().trim());
                mParams.put(Constants.machine_id, edtTypeMach.getText().toString().trim());
                mParams.put(Constants.approx_salary, edtApproxSal.getText().toString().trim());
                mParams.put(Constants.salary_time, edtSalaryTime.getText().toString().trim());
                mParams.put(Constants.working_time, edtWorkingShift.getText().toString().trim());
                mParams.put(Constants.user_id,id);
                Log.e("url", url);
                Log.e("mParams", mParams.toString());
                CommonFunctions.createProgressBar(AddVacancyActivity.this, getString(R.string.msg_please_wait));
                AndroidNetworking.post(url)
                        .addBodyParameter(mParams)
                        .setTag(url)
                        .addHeaders(Constants.Authorization,CommonFunctions.getloginresponse(this).data.token)
                        .setPriority(Priority.HIGH)
                        .build()
                    .getAsJSONObject(new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                CommonFunctions.destroyProgressBar();
                                Log.e("res", response.toString());
                                Toast.makeText(AddVacancyActivity.this, response.getString(Constants.message), Toast.LENGTH_SHORT).show();

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onError(ANError anError) {
                            try {
                                Log.e("TAG", anError.getErrorDetail());
                                CommonFunctions.destroyProgressBar();
                                Toast.makeText(AddVacancyActivity.this, R.string.msg_server_error, Toast.LENGTH_SHORT).show();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
            }
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