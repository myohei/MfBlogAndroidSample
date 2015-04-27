package com.moneyforward.mfblogsmple.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.IntDef;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.moneyforward.mfblogsmple.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ShadowableFrameLayout extends FrameLayout {

    private static final int FLAG_SHADOW_NON = 0;
    private static final int FLAG_SHADOW_TOP = 1;
    private static final int FLAG_SHADOW_BOTTOM = 2;
    private static final int FLAG_SHADOW_BOTH = 4;

    @IntDef({FLAG_SHADOW_NON, FLAG_SHADOW_TOP, FLAG_SHADOW_BOTTOM, FLAG_SHADOW_BOTH})
    public @interface ShadowFlag {
    }

    @InjectView(R.id.shadow_top)
    View mShadowTop;
    @InjectView(R.id.shadow_bottom)
    View mShadowBottom;

    public ShadowableFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShadowableFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ShadowableFrameLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context, attrs, defStyleAttr);
    }

    /**
     * initview.
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    private void initView(Context context, AttributeSet attrs, int defStyleAttr) {
        final TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.ShadowableFrameLayout, defStyleAttr, 0);
        @ShadowFlag final int flag = array.getInt(R.styleable.ShadowableFrameLayout_shadow, 0);
        array.recycle();
        final View view = LayoutInflater.from(context).inflate(R.layout.view_shadow_wapper, this, true);
        // layoutファイルなくてもいけるんだけど、shadowを作るのが面倒…
        ButterKnife.inject(this, view);
        setShadow(flag);
    }

    /**
     * Shadow
     *
     * @param flag
     */
    public void setShadow(@ShadowFlag int flag) {
        switch (flag) {
            case FLAG_SHADOW_TOP:
                mShadowTop.setVisibility(VISIBLE);
                mShadowBottom.setVisibility(GONE);
                break;
            case FLAG_SHADOW_BOTTOM:
                mShadowTop.setVisibility(GONE);
                mShadowBottom.setVisibility(VISIBLE);
                break;
            case FLAG_SHADOW_BOTH:
                mShadowTop.setVisibility(VISIBLE);
                mShadowBottom.setVisibility(VISIBLE);
                break;
            case FLAG_SHADOW_NON:
            default:
                mShadowTop.setVisibility(GONE);
                mShadowBottom.setVisibility(GONE);
                break;
        }
    }
}
