package com.example.chattytest;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * Created by 艾德米 on 2018/3/12.
 */

public class MessageItemAdapter extends RecyclerView.Adapter<MessageItemAdapter.VH>{

    List<MessageItem> mList;

    public MessageItemAdapter(List<MessageItem> items) {
        this.mList = items;

    }

    @Override
    public MessageItemAdapter.VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        VH vh = new VH(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(MessageItemAdapter.VH holder, int position) {
        holder.strMsg.setText(mList.get(position).getStrMsg());
        Log.d("position: ", String.valueOf(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        TextView strMsg;
        TextView fromUserName;
        public VH(View itemView) {
            super(itemView);

            strMsg = itemView.findViewById(R.id.strMsg);
        }
    }
}
