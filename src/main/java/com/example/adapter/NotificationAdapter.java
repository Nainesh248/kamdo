package com.example.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.R;
import com.example.config.KamdoConfig;
import com.example.model.NotificationResponse;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {
    @BindView(R.id.iv_user_profile)
    CircleImageView ivUserProfile;
    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.tv_noti)
    TextView tvNoti;
    @BindView(R.id.click)
    TextView click;
    @BindView(R.id.rl_edit)
    RelativeLayout rlEdit;
    private Activity activity;

    List<NotificationResponse.DataEntity> dataEntity = new ArrayList<>();

    AdapterCallback adapterCallback;
    String def_lang;
    NotificationResponse homeData;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification, parent, false);
        return new MyViewHolder(itemView);
    }

    public NotificationAdapter(Activity mContext, List<NotificationResponse.DataEntity> dataEntity, NotificationResponse homeData, AdapterCallback adapterCallback1, String lang) {
        this.activity = mContext;
        this.dataEntity = dataEntity;

        this.adapterCallback = adapterCallback1;
        this.def_lang = lang;
        this.homeData = homeData;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        try {
            final NotificationResponse.DataEntity dataEntitytemp = dataEntity.get(position);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvUsername;
        TextView tvNoti;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public class AdapterCallback {
    }
}
