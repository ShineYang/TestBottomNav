package com.shineyang.testbottomnav;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shineyang.testbottomnav.fragment.Fragment1;
import com.shineyang.testbottomnav.fragment.Fragment2;
import com.shineyang.testbottomnav.fragment.Fragment3;
import com.shineyang.testbottomnav.fragment.Fragment4;

public class MainActivity extends FragmentActivity implements View.OnClickListener {


    private Fragment1 fragment1 = new Fragment1();
    private Fragment2 fragment2 = new Fragment2();
    private Fragment3 fragment3 = new Fragment3();
    private Fragment4 fragment4 = new Fragment4();

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    private Fragment mfrom = fragment1;// 默认显示控制第一个默认的界面 为 第一个 为后面 交换界面初始化 参数

    private ImageView iv_quick_buy;//快速购买
    private ImageView iv_map;//地铁图
    private ImageView iv_history;//购票记录
    private ImageView iv_me;//我

    private LinearLayout ly_quick_buy;//快速购买
    private LinearLayout ly_map;//地铁图
    private LinearLayout ly_history;//购票记录
    private LinearLayout ly_me;//我


    private TextView tv_quick_buy;//快速购买
    private TextView tv_map;//地铁图
    private TextView tv_history;//购票记录
    private TextView tv_me;//我


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTabBarView();
        addDefaultFragment();
    }

    public void onSaveInstanceState(Bundle outState) {
        //注释掉以防view重叠
        //super.onSaveInstanceState(outState, outPersistentState);
    }

    /**
     * 初始化视图
     */
    public void initTabBarView() {
        iv_quick_buy = (ImageView) findViewById(R.id.iv_quick_buy);
        iv_map = (ImageView) findViewById(R.id.iv_map);
        iv_history = (ImageView) findViewById(R.id.iv_buy_history);
        iv_me = (ImageView) findViewById(R.id.iv_me);

        ly_quick_buy = (LinearLayout) findViewById(R.id.ly_btn_quick_buy);
        ly_map = (LinearLayout) findViewById(R.id.ly_btn_map);
        ly_history = (LinearLayout) findViewById(R.id.ly_btn_buy_history);
        ly_me = (LinearLayout) findViewById(R.id.ly_btn_me);


        tv_quick_buy = (TextView) findViewById(R.id.tv_btn_quick_buy);
        tv_map = (TextView) findViewById(R.id.tv_btn_map);
        tv_history = (TextView) findViewById(R.id.tv_btn_buy_history);
        tv_me = (TextView) findViewById(R.id.tv_btn_me);

        ly_quick_buy.setOnClickListener(this);
        ly_map.setOnClickListener(this);
        ly_history.setOnClickListener(this);
        ly_me.setOnClickListener(this);
    }

    /**
     * 添加默认显示的Fragment
     */
    public void addDefaultFragment() {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frag_content, fragment1);
        fragmentTransaction.commit();

    }


    /**
     * 控制从activity
     */
    public void switchContent(Fragment from, Fragment to) {

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        if (!to.isAdded()) { // 先判断是否被add过
            fragmentTransaction.hide(from).add(R.id.frag_content, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
            Log.i("status", "===没有添加过===");
        } else {
            fragmentTransaction.hide(from).show(to).commit(); // 隐藏当前的fragment，显示下一个
            Log.i("status", "===添加过===");
        }
    }

    /**
     * 修改快速购票按钮样式
     */

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void changeQuickMenu() {
        iv_quick_buy.setBackground(getResources().getDrawable(R.drawable.ic_quick_blue));
        iv_map.setBackground(getResources().getDrawable(R.drawable.ic_map_grey));
        iv_history.setBackground(getResources().getDrawable(R.drawable.ic_buy_grey));
        iv_me.setBackground(getResources().getDrawable(R.drawable.ic_me_grey));

        tv_quick_buy.setTextColor(getResources().getColor(R.color.selected_blue));
        tv_map.setTextColor(getResources().getColor(R.color.grey_800));
        tv_history.setTextColor(getResources().getColor(R.color.grey_800));
        tv_me.setTextColor(getResources().getColor(R.color.grey_800));


    }

    /**
     * 修改地铁图按钮样式
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void changeMapMenu() {
        iv_quick_buy.setBackground(getResources().getDrawable(R.drawable.ic_quick_grey));
        iv_map.setBackground(getResources().getDrawable(R.drawable.ic_map_blue));
        iv_history.setBackground(getResources().getDrawable(R.drawable.ic_buy_grey));
        iv_me.setBackground(getResources().getDrawable(R.drawable.ic_me_grey));

        tv_quick_buy.setTextColor(getResources().getColor(R.color.grey_800));
        tv_map.setTextColor(getResources().getColor(R.color.selected_blue));
        tv_history.setTextColor(getResources().getColor(R.color.grey_800));
        tv_me.setTextColor(getResources().getColor(R.color.grey_800));
    }

    /**
     * 修改购票记录按钮样式
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void changeHistoryMenu() {
        iv_quick_buy.setBackground(getResources().getDrawable(R.drawable.ic_quick_grey));
        iv_map.setBackground(getResources().getDrawable(R.drawable.ic_map_grey));
        iv_history.setBackground(getResources().getDrawable(R.drawable.ic_buy_blue));
        iv_me.setBackground(getResources().getDrawable(R.drawable.ic_me_grey));

        tv_quick_buy.setTextColor(getResources().getColor(R.color.grey_800));
        tv_map.setTextColor(getResources().getColor(R.color.grey_800));
        tv_history.setTextColor(getResources().getColor(R.color.selected_blue));
        tv_me.setTextColor(getResources().getColor(R.color.grey_800));
    }

    /**
     * 修改我的按钮样式
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void changeMeMenu() {
        iv_quick_buy.setBackground(getResources().getDrawable(R.drawable.ic_quick_grey));
        iv_map.setBackground(getResources().getDrawable(R.drawable.ic_map_grey));
        iv_history.setBackground(getResources().getDrawable(R.drawable.ic_buy_grey));
        iv_me.setBackground(getResources().getDrawable(R.drawable.ic_me_blue));

        tv_quick_buy.setTextColor(getResources().getColor(R.color.grey_800));
        tv_map.setTextColor(getResources().getColor(R.color.grey_800));
        tv_history.setTextColor(getResources().getColor(R.color.grey_800));
        tv_me.setTextColor(getResources().getColor(R.color.selected_blue));
    }

    /**
     * 底部菜单栏点击事件
     */

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ly_btn_quick_buy:
                Log.i("button1", "button1 click");

                changeQuickMenu();
                switchContent(mfrom, fragment1);
                mfrom = fragment1;
                break;
            case R.id.ly_btn_map:
                changeMapMenu();
                switchContent(mfrom, fragment2);
                mfrom = fragment2;
                break;
            case R.id.ly_btn_buy_history:
                changeHistoryMenu();
                switchContent(mfrom, fragment3);
                mfrom = fragment3;
                break;
            case R.id.ly_btn_me:
                changeMeMenu();
                switchContent(mfrom, fragment4);
                mfrom = fragment4;
                break;
            default:
                break;

        }
    }
}
