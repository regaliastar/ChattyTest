package com.example.chattytest;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 艾德米 on 2018/3/12.
 */

public class MessageItemAdapter extends RecyclerView.Adapter<MessageItemAdapter.VH>{

    List<MessageItem> mList;

    View view;

    public MessageItemAdapter(List<MessageItem> items) {
        this.mList = items;

    }

    public MessageItemAdapter() {
        mList = new ArrayList<>();
    }

    @Override
    public MessageItemAdapter.VH onCreateViewHolder(ViewGroup parent, int viewType) {
        view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        VH vh = new VH(view);
//        Log.d("viewType: ", String.valueOf(viewType));
        return vh;
    }

    @Override
    public void onBindViewHolder(MessageItemAdapter.VH holder, int position) {

        switch (mList.get(position).getTAG()){
            case 0:
                //隐藏对方
                Log.d("case 0: position", String.valueOf(position));
                Log.d("mList.toString:",mList.toString());
                LinearLayout LL = (LinearLayout)view.findViewById(R.id.receiver_layout);
                LL.setVisibility(View.GONE);

                holder.send_strMsg.setText(mList.get(position).getStrMsg());
                holder.send_avatar.setImageResource(mList.get(position).getFromUserAvatar());
                break;
            case 1:
                //隐藏自己
                Log.d("case 1: position", String.valueOf(position));
                RelativeLayout RL = view.findViewById(R.id.sender_layout);
                RL.setVisibility(View.GONE);

                holder.receive_strMsg.setText(mList.get(position).getStrMsg());
                holder.send_avatar.setImageResource(mList.get(position).getFromUserAvatar());
                break;
            default:
                break;
        }


//        Log.d("position: ", String.valueOf(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        TextView receive_strMsg;
        TextView send_strMsg;
        ImageView receive_avatar;
        ImageView send_avatar;
        public VH(View itemView) {
            super(itemView);

            receive_strMsg = (TextView) itemView.findViewById(R.id.receive_strMsg);
            send_strMsg = (TextView) itemView.findViewById(R.id.send_strMsg);
            receive_avatar = itemView.findViewById(R.id.receiver_avatar);
            send_avatar = itemView.findViewById(R.id.send_avatar);
        }
    }

    public void add(MessageItem item) {
//        Log.d("add", String.valueOf(mList.size()));
        mList.add(mList.size(), item);
        notifyItemInserted(mList.size());
    }
}
