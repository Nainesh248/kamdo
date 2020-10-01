package com.example.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class EditProfileFragment extends Fragment {
    View rootView;
    @BindView(R.id.iv_add_address)
    ImageView ivAddAddress;
    @BindView(R.id.rl_gst)
    RelativeLayout rlGst;
    @BindView(R.id.iv_profile)
    CircleImageView ivProfile;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_companyname)
    TextView tvCompanyname;
    @BindView(R.id.rl_profile)
    RelativeLayout rlProfile;
    @BindView(R.id.introduction)
    TextView introduction;
    @BindView(R.id.tv_introduction)
    TextView tvIntroduction;
    @BindView(R.id.rl_intro)
    RelativeLayout rlIntro;
    @BindView(R.id.detail)
    TextView detail;
    @BindView(R.id.cname)
    TextView cname;
    @BindView(R.id.edt_cname)
    EditText edtCname;
    @BindView(R.id.ctype)
    TextView ctype;
    @BindView(R.id.edt_ctype)
    EditText edtCtype;
    @BindView(R.id.gstno)
    TextView gstno;
    @BindView(R.id.edt_gstno)
    EditText edtGstno;
    @BindView(R.id.address)
    TextView address;
    @BindView(R.id.edt_address)
    EditText edtAddress;
    @BindView(R.id.f_address)
    TextView fAddress;
    @BindView(R.id.edt_fac_address)
    EditText edtFacAddress;
    @BindView(R.id.rl_faddress)
    RelativeLayout rlFaddress;
    @BindView(R.id.rl_detail)
    RelativeLayout rlDetail;
    @BindView(R.id.tv_save)
    Button tvSave;
    @BindView(R.id.edt_add_address)
    EditText edtNewAddress;
    @BindView(R.id.tv_add_address)
    TextView tvAddAddress;
    @BindView(R.id.iv_remove_address)
    ImageView ivRemoveAddress;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_edit_profile, container, false);
        init();
        return rootView;

    }

    private void init() {
        try {
            ButterKnife.bind(this, rootView);
            ivAddAddress.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    edtNewAddress.setVisibility(View.VISIBLE);
                    tvAddAddress.setVisibility(View.GONE);
                    ivRemoveAddress.setVisibility(View.VISIBLE);
                    ivAddAddress.setVisibility(View.GONE);

                }
            });
            ivRemoveAddress.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ivAddAddress.setVisibility(View.VISIBLE);
                    ivRemoveAddress.setVisibility(View.GONE);
                    edtNewAddress.setVisibility(View.GONE);
                    tvAddAddress.setVisibility(View.VISIBLE);

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}