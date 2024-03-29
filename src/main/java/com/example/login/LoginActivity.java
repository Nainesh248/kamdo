package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.R;
import com.example.activity.HomeCompanyActivity;
import com.example.activity.UserHomeActivity;
import com.example.config.CommonFunctions;
import com.example.config.Constants;
import com.example.config.KamdoConfig;
import com.example.model.LoginResponse;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.tv_signin)
    TextView tvSignin;
    @BindView(R.id.iv3)
    ImageView iv3;
    @BindView(R.id.et_mobileno)
    EditText etMobileno;
    @BindView(R.id.fl_1)
    FrameLayout fl1;
    @BindView(R.id.iv_4)
    ImageView iv4;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.fl_2)
    FrameLayout fl2;
    @BindView(R.id.forget)
    TextView forget;
    @BindView(R.id.fl_3)
    FrameLayout fl3;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.ll_contain)
    LinearLayout llContain;
    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    @BindView(R.id.btn_comp)
    Button btnComp;
    @BindView(R.id.btn_user)
    Button btnUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

    }

    private void init() {
        try {
            ButterKnife.bind(this);
            btnComp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent comp=new Intent(LoginActivity.this,SignUpCompany.class);
                    startActivity(comp);
                }
            });
            btnUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent user=new Intent(LoginActivity.this, SignUp.class);
                    startActivity(user);
                }
            });
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loginClick();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loginClick() {
        try {
            if (etMobileno.getText().toString().trim().length() == 0) {
                Toast.makeText(this, getString(R.string.err_email_mobil), Toast.LENGTH_SHORT).show();
            } else if (etPassword.getText().toString().trim().length() == 0) {
                Toast.makeText(this, getString(R.string.err_pwd), Toast.LENGTH_SHORT).show();
            } else {
                loginUser(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loginUser(boolean b) {
        try {
            if (CommonFunctions.checkConnection(this)) {
                String url = KamdoConfig.WEBURL + KamdoConfig.login;
                Map<String, String> mParams = new HashMap<>();
                mParams.put(Constants.phone, etMobileno.getText().toString().trim());
                mParams.put(Constants.password, etPassword.getText().toString().trim());
                mParams.put(Constants.device_id, CommonFunctions.getDeviceUID(this));
                mParams.put(Constants.device_token, CommonFunctions.getPreference(this, Constants.device_token, "nofound"));
                mParams.put(Constants.type, Constants.android);
                mParams.put(Constants.device_info, CommonFunctions.getDeviceInfo(this));
                mParams.put(Constants.device_name, CommonFunctions.getDeviceMenufacture());
                Log.e("url", url);
                Log.e("mParams", mParams.toString());
                CommonFunctions.createProgressBar(this, getString(R.string.msg_please_wait));
                AndroidNetworking.post(url)
                        .addBodyParameter(mParams)
                        .setTag(url)
                        .setPriority(Priority.HIGH)
                        .build()
                        .getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    CommonFunctions.destroyProgressBar();
                                    Log.e("res", response.toString());
                                    Gson gson = new Gson();
                                    LoginResponse loginResponse = gson.fromJson(response.toString(), LoginResponse.class);
                                    if (loginResponse.status) {
                                        CommonFunctions.setPreference(LoginActivity.this, Constants.isLogin, true);
                                        CommonFunctions.setPreference(getApplicationContext(), Constants.userdata, gson.toJson(loginResponse));
                                        Toast.makeText(LoginActivity.this, loginResponse.message, Toast.LENGTH_LONG).show();
                                        CommonFunctions.changeactivity(LoginActivity.this, HomeCompanyActivity.class);
                                    } else {
                                        Toast.makeText(LoginActivity.this, loginResponse.message, Toast.LENGTH_LONG).show();
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onError(ANError anError) {
                                try {
                                    CommonFunctions.destroyProgressBar();
                                    Toast.makeText(LoginActivity.this, R.string.msg_server_error, Toast.LENGTH_SHORT).show();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
            }
        } catch (Exception e) {
            e.printStackTrace();
            CommonFunctions.destroyProgressBar();
        }
    }
}