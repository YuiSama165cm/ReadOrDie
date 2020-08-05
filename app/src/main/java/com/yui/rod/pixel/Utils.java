package com.yui.rod.pixel;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
/**
 * 动态运行时适配
 * 屏幕适配（测量出实际手机与设计稿的比例）
 *
 *      此处为分别计算高度宽度的比例。
 *
 *      如有需要，也可以只计算宽度或高度的比例，然后以其中一个为基准布局。
 * */
public class Utils {
    private static Utils utils;
    private Context mContext;
    //这里是设计稿参考宽高:  因为这边用的是px的值，所以在xml中标注的也要用px，如果用dp会被系统转成px导致适配出问题
    private static final float STANDARD_WIDTH = 375;
    private static final float STANDARD_HEIGHT = 812;

    //这里是屏幕显示宽高
    private int mDisplayWidth;
    private int mDisplayHeight;

    public static Utils getInstance(Context context){//单例
        if(utils == null){
            utils = new Utils(context);
        }
        return utils;
    }

    public Utils(Context context){
        this.mContext = context;
        //获取屏幕高度
        if(mDisplayWidth == 0 || mDisplayHeight == 0){
            WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            if (windowManager != null){
                //宽高获取
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                //判断当前的屏幕处于横竖屏状态
                if(displayMetrics.widthPixels > displayMetrics.heightPixels){//横屏状态
                    mDisplayWidth = displayMetrics.heightPixels;//获取到当前屏幕宽度（横屏状态横竖切换）
                    mDisplayHeight = displayMetrics.widthPixels - getStatusBarHeight(context);//获取到当前屏幕高度（横屏状态横竖切换）（要去掉状态栏高度）

                } else{//竖屏状态
                    mDisplayWidth = displayMetrics.widthPixels;//获取到当前屏幕宽度
                    mDisplayHeight = displayMetrics.heightPixels - getStatusBarHeight(context);//获取到当前屏幕高度(要去掉状态栏高度)
                }

            }

        }
    }

    //获取状态栏高度
    public int getStatusBarHeight(Context context){
        int resId = context.getResources().getIdentifier(
                "status_bar_height","demen","android");

        if(resId > 0){
            return context.getResources().getDimensionPixelOffset(resId);//获取高度
        }
        return 0;
    }
    /**
     * 加入其它计算刘海屏高度的内容
     * */
    //判断底部虚拟按钮高度
    //判断刘海屏

    //获取水平方向的缩放比例
    public float getHorizontalScale(){
        return mDisplayWidth / STANDARD_WIDTH;
    }

    //获取垂直方向的缩放比例
    public float getVerticaScale(){
        return mDisplayHeight / (STANDARD_HEIGHT - getStatusBarHeight(mContext));//缩放的时候，参考尺寸的高也要减去状态栏
    }
}
