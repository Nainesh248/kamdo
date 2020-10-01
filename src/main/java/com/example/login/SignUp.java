package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import com.example.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;


public class SignUp extends AppCompatActivity {

    @BindView(R.id.tv_registration)
    TextView tvRegistration;
    @BindView(R.id.iv_profile)
    CircleImageView ivProfile;
    @BindView(R.id.edt_name)
    EditText edtName;
    @BindView(R.id.edt_mobileno)
    EditText edtMobileno;
    @BindView(R.id.edt_gender)
    EditText edtGender;
    @BindView(R.id.edt_address)
    EditText edtAddress;
    @BindView(R.id.edt_village_address)
    EditText edtVillageAddress;
    @BindView(R.id.iv3)
    ImageView iv3;
    @BindView(R.id.et_mobileno)
    TextView etMobileno;
    @BindView(R.id.iv_adharcard)
    ImageView ivAdharcard;
    @BindView(R.id.fl_aadhar)
    FrameLayout flAadhar;
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
        setContentView(R.layout.activity_sign_up);

        init();
    }
    public void init(){
        try {
            ButterKnife.bind(this);
            tvLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(SignUp.this,LoginActivity.class);
                    startActivity(i);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}