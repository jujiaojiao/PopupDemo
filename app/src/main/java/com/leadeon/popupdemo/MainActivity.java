package com.leadeon.popupdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button show;
    private Button hidden;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = (Button) findViewById(R.id.show);
//        hidden = (Button) findViewById(R.id.hidden);
        show.setOnClickListener(this);
//        hidden.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        View inflate = LayoutInflater.from(this).inflate(R.layout.pupupwindow, null);
        final PopupWindow popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,false);
        switch (v.getId()) {
            case R.id.show:
                popupWindow.setFocusable(true);
//                popupWindow.showAsDropDown(hidden);
                int [] location = new int[2];
                Log.e("dfsafsadfsafdsafd", "onClick: "+location[0]+"  :::::::::::: " +location[1] );
                show.getLocationOnScreen(location);
                popupWindow.showAtLocation(show, Gravity.NO_GRAVITY,0,location[1]+popupWindow.getHeight()+show.getHeight());
                inflate.findViewById(R.id.hidden_item).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        popupWindow.showAtLocation();
                        popupWindow.dismiss();
                    }
                });
                break;
        }
    }
}
