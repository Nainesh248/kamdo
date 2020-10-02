package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.R;
import com.example.activity.HomeCompanyActivity;
import com.example.config.CommonFunctions;
import com.example.config.Constants;
import com.example.config.KamdoConfig;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class SignUpCompany extends AppCompatActivity {

    @BindView(R.id.tv_registration)
    TextView tvRegistration;
    @BindView(R.id.iv_profile)
    CircleImageView ivProfile;
    @BindView(R.id.edt_Cname)
    EditText edtCname;
    @BindView(R.id.edt_gstno)
    EditText edtGstno;
    @BindView(R.id.edt_mobileno)
    EditText edtMobileno;
    @BindView(R.id.edt_address)
    EditText edtAddress;
    @BindView(R.id.edt_faddress)
    EditText edtFaddress;
    @BindView(R.id.edt_description)
    EditText edtDescription;
    @BindView(R.id.edt_password)
    EditText edtPassword;
    @BindView(R.id.edt_conpassword)
    EditText edtConpassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.ll_contain)
    LinearLayout llContain;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.nsv_reg)
    NestedScrollView nsvReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_company);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        try {
            ButterKnife.bind(this);
            tvLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(SignUpCompany.this, LoginActivity.class);
                    startActivity(intent);
                }
            });
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    singup();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void singup() {
        try {
            if (CommonFunctions.checkConnection(this)) {
                if (edtCname.getText().toString().length() == 0) {
                    Toast.makeText(this, R.string.err_cname, Toast.LENGTH_SHORT).show();
                    edtCname.requestFocus();
                    return;
                }  else if (edtGstno.getText().toString().length() == 0) {

                    Toast.makeText(this, R.string.err_gstno, Toast.LENGTH_SHORT).show();
                    edtGstno.requestFocus();
                    return;
                } else if (edtMobileno.getText().toString().length() == 0 || edtMobileno.getText().toString().length() < 10) {

                    Toast.makeText(this, R.string.err_mobil, Toast.LENGTH_SHORT).show();
                    edtMobileno.requestFocus();
                    return;
                }else if (edtAddress.getText().toString().length() == 0) {

                    Toast.makeText(this, R.string.err_address, Toast.LENGTH_SHORT).show();
                    edtAddress.requestFocus();
                    return;
                } else if (edtFaddress.getText().toString().length() < 6) {

                    Toast.makeText(this, R.string.err_vaddress, Toast.LENGTH_SHORT).show();
                    edtFaddress.requestFocus();
                    return;
                } else if (edtDescription.getText().toString().length() < 6) {

                    Toast.makeText(this, R.string.err_des, Toast.LENGTH_SHORT).show();
                    edtDescription.requestFocus();
                    return;
                }else if (edtPassword.getText().toString().length() == 0) {

                    Toast.makeText(this, R.string.err_pwd, Toast.LENGTH_SHORT).show();
                    edtPassword.requestFocus();
                    return;
                } else if (edtPassword.getText().toString().length() < 6) {

                    Toast.makeText(this, R.string.err_pwd1, Toast.LENGTH_SHORT).show();
                    edtPassword.requestFocus();
                    return;
                } else if (edtConpassword.getText().toString().length() == 0) {

                    Toast.makeText(this, R.string.err_cpwd, Toast.LENGTH_SHORT).show();
                    edtConpassword.requestFocus();
                    return;
                } else if (edtConpassword.getText().toString().length() < 6) {

                    Toast.makeText(this, R.string.err_cpwd1, Toast.LENGTH_SHORT).show();
                    edtConpassword.requestFocus();
                    return;
                } else {
                    Intent otp = new Intent(SignUpCompany.this, LoginActivity.class);
                    companysighup();
                    startActivity(otp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void companysighup() {
        try {
            if (CommonFunctions.checkConnection(SignUpCompany.this)) {
                String url = KamdoConfig.WEBURL + KamdoConfig.register;
                Map<String, String> mParams = new HashMap<>();
                mParams.put(Constants.company_name, edtCname.getText().toString().trim());
                mParams.put(Constants.gst_no, edtMobileno.getText().toString().trim());
                mParams.put(Constants.phone, edtMobileno.getText().toString().trim());
                mParams.put(Constants.address_1, edtAddress.getText().toString().trim());
                mParams.put(Constants.address_2, edtFaddress.getText().toString().trim());
                mParams.put(Constants.description, edtDescription.getText().toString().trim());
                mParams.put(Constants.password, edtPassword.getText().toString().trim());
                mParams.put(Constants.confirmPassword, edtConpassword.getText().toString().trim());
                mParams.put(Constants.type, Constants.android);
                Log.e("url", url);
                Log.e("mParams", mParams.toString());
                CommonFunctions.createProgressBar(SignUpCompany.this, getString(R.string.msg_please_wait));
                AndroidNetworking.post(url)
                        .addBodyParameter(mParams)
                        .setTag(url)
                        .addHeaders(Constants.Authorization, CommonFunctions.getloginresponse(this).data.token)
                        .setPriority(Priority.HIGH)
                        .build()
                        .getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    CommonFunctions.destroyProgressBar();
                                    Log.e("res", response.toString());
                                    Toast.makeText(SignUpCompany.this, response.getString(Constants.message), Toast.LENGTH_SHORT).show();
                                    CommonFunctions.changeactivity(SignUpCompany.this, LoginActivity.class);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onError(ANError anError) {
                                try {
                                    Log.e("TAG", anError.getErrorDetail());
                                    CommonFunctions.destroyProgressBar();
                                    Toast.makeText(SignUpCompany.this, R.string.msg_server_error, Toast.LENGTH_SHORT).show();
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


}