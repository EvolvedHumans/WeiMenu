package com.example.weimenu;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

/**
 * @name: 杨帆
 * @Time: 2020年 11月 01日 17时 08分
 * @Data: 实现微信右上角弹出的菜单
 * @TechnicalPoints：本实例主要使用PopupWindow类及其构造方法、View.OnTouchListener接口中的OnTouch事件，实现微信右上角弹出菜单的运行效果
 * @Doubt：点击按钮后显示出群聊等菜单按钮，再点击按钮无法启动他的触发事件响应(留下的疑惑)
 */
public class MainActivity extends AppCompatActivity{

    PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.menu);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取Menu中的View布局
                View popupWindow_view = getLayoutInflater().inflate(R.layout.mune,null,false);

                //创建PopupWindow 实例，设置菜单宽度和高度为包裹其自身内容
                popupWindow =new PopupWindow
                        (popupWindow_view, ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT,true);

                //设置Menu在按钮下面
                popupWindow.showAsDropDown(findViewById(R.id.menu),0,0);

                Button button1 = popupWindow_view.findViewById(R.id.buttonPanel);
                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.e("进入了","进来了");
                    }
                });

            }
        });

    }

}