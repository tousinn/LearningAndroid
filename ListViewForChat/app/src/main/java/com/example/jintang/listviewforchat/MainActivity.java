package com.example.jintang.listviewforchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView msgListView;
    private EditText inputText;
    private Button send;
    private MsgAdapter adapter;
    private List<Msg> msgList = new ArrayList<Msg>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initMsgs();
        adapter = new MsgAdapter(MainActivity.this,R.layout.msg_item,msgList);
        msgListView = (ListView)findViewById(R.id.msg_list_view);
        msgListView.setAdapter(adapter);
        send =(Button)findViewById(R.id.Send);
        inputText = (EditText)findViewById(R.id.input_text);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = inputText.getText().toString();
                if(!"".equals(content)){
                    Msg msg = new Msg(Msg.TYPE_SENT,content);
                    msgList.add(msg);
                    adapter.notifyDataSetChanged();
                    msgListView.setSelection(msgList.size());
                    inputText.setText("");
                }
            }
        });

    }
    private void initMsgs(){
        Msg msg1 = new Msg(Msg.TYPE_RECEIVED,"Hello guy.");
        msgList.add(msg1);

        Msg msg2 = new Msg(Msg.TYPE_SENT, "Hello. Who is that?");
        msgList.add(msg2);


        Msg msg3 = new Msg(Msg.TYPE_RECEIVED,"This is Tom. Nice talking to you.");
        msgList.add(msg3);
    }

}
