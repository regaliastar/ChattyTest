package com.example.chattytest;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    MessageItemAdapter mMessageItemAdapter;
    EditText msgText;
    Button send_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        init();
        Log.d("ChatActivity","onCreate");
        send_btn = findViewById(R.id.send);
        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("点击发送","onClick -> sendMsg()");
                sendMsg();

            }
        });

    }

    /**
     *  初始化recyclerView聊天信息，设置收发信人
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
//        Log.d("items.size():", String.valueOf(items.size()));
        mRecyclerView.setAdapter(mMessageItemAdapter = new MessageItemAdapter(items));

    }

    /**
     * 点击发送按钮后，发送信息
     * 传递MessageItem到showMsg方法
     * */
    private void sendMsg(){
        MessageItem item = new MessageItem();
        msgText = findViewById(R.id.edit);

        String msg = msgText.getText().toString();
        msgText.setText("");

        // 设置 item 的属性：发送者、接受者、消息值
        item.setStrMsg(msg);
        item.setFromUser("me");

        showMsg(item);
    }

    /**
     * 从服务器接收到对方发送的信息
     * 传递MessageItem到showMsg方法
     * */
    private void receiveMsg(MessageItem item){

    }

    /**
     * 将信息展示在界面上
     * */
    private void showMsg(MessageItem item){
        //登录的用户名应该从全局方法得到，这里只是为了测试
        String LOGIN_USER = "me";
        switch (item.getFromUser()){
            case "me":
                Log.d("showMsg: ","case me");
                mMessageItemAdapter.add(item);
                
                mRecyclerView.smoothScrollToPosition(mMessageItemAdapter.mList.size());
                break;
            default:

        }
    }

}
