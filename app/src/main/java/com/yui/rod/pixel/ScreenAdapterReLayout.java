package com.yui.rod.pixel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
/**
 * 动态运行时适配：计算出不同手机的控件大小
 * */
public class ScreenAdapterReLayout extends RelativeLayout {
    private boolean flag;
    public ScreenAdapterReLayout(Context context) {
        super(context);
    }

    public ScreenAdapterReLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScreenAdapterReLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ScreenAdapterReLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if(!flag) {//因为onMeasure测量会走两遍，所以要加个判断，防止他走两遍影响我们自己的测量判断
            flag = true;
            //获取横竖方向等比
            float horizontalScale = Utils.getInstance(getContext()).getHorizontalScale();
            float verticaScale = Utils.getInstance(getContext()).getVerticaScale();

            int childCount = getChildCount();
            //遍历子View，修改子View的宽高
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.width = (int) (layoutParams.width * horizontalScale);//当前的子View的宽乘以宽比例得到新的宽。
                layoutParams.height = (int) (layoutParams.height * verticaScale);//当前的子View的高乘以高比例得到新的高。
                //外边距距离调整
                layoutParams.rightMargin = (int) (layoutParams.rightMargin * horizontalScale);//当前的子View的右边距乘以宽比例得到新的右边距。
                layoutParams.leftMargin = (int) (layoutParams.leftMargin * horizontalScale);//当前的子View的左边距乘以宽比例得到新的左边距。
                layoutParams.topMargin = (int) (layoutParams.topMargin * verticaScale);//当前的子View的上边距乘以宽比例得到新的上边距。
                layoutParams.bottomMargin = (int) (layoutParams.bottomMargin * verticaScale);//当前的子View的下边距乘以宽比例得到新的下边距。
                //内边距距离调整
                childAt.setPadding((int) (childAt.getPaddingLeft() * horizontalScale),
                        (int) (childAt.getPaddingTop() * verticaScale),
                        (int) (childAt.getPaddingRight() * horizontalScale),
                        (int) (childAt.getPaddingBottom() * verticaScale));
            }
        }



        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
