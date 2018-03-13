package com.example.chattytest;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


        init();


    }

    /**
     *  初始化聊天信息，设置收发信人信息
     * */
    private void init() {
        mRecyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);

        List<MessageItem> items = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MessageItem item = new MessageItem();
            String msg = "这是第"+i+"条信息";
            item.setStrMsg(msg);
            items.add(item);
        }
        Log.d("items.size():", String.valueOf(items.size()));
        mRecyclerView.setAdapter(new MessageItemAdapter(items));

    }


}
