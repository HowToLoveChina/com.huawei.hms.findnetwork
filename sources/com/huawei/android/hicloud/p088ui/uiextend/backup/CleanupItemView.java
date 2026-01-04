package com.huawei.android.hicloud.p088ui.uiextend.backup;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$styleable;
import p514o9.C11839m;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CleanupItemView extends RelativeLayout {
    private static final String TAG = "CleanupItemView";
    private ImageView mIconView;
    protected Drawable mImg;
    private TextView mSbuTitleView;
    private String mSubTitle;
    private String mTitle;
    private TextView mTitleView;

    public CleanupItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.cleanup_item_attr);
        initView(context);
        initAttribute(typedArrayObtainStyledAttributes);
    }

    private void initAttribute(TypedArray typedArray) {
        if (typedArray != null) {
            this.mTitle = typedArray.getString(R$styleable.cleanup_item_attr_cleanup_item_title);
            this.mSubTitle = typedArray.getString(R$styleable.cleanup_item_attr_cleanup_sub_title);
            this.mImg = typedArray.getDrawable(R$styleable.cleanup_item_attr_cleanup_item_img);
            C11839m.m70688i(TAG, "mTitle: " + this.mTitle);
            C11839m.m70688i(TAG, "mSubTitle: " + this.mSubTitle);
            C11839m.m70688i(TAG, "mImg: " + this.mImg);
            this.mTitleView.setText(this.mTitle);
            this.mSbuTitleView.setText(this.mSubTitle);
            this.mIconView.setImageDrawable(this.mImg);
            typedArray.recycle();
        }
    }

    private void initView(Context context) {
        View.inflate(context, R$layout.cleanup_item, this);
        this.mIconView = (ImageView) C12809f.m76831d(this, R$id.cleanup_item_icon);
        this.mTitleView = (TextView) C12809f.m76831d(this, R$id.cleanup_item_tile);
        this.mSbuTitleView = (TextView) C12809f.m76831d(this, R$id.cleanup_item_sub_tile);
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        this.mTitleView.setEnabled(z10);
        this.mSbuTitleView.setEnabled(z10);
        if (z10) {
            setAlpha(1.0f);
        } else {
            setAlpha(0.6f);
        }
    }

    public void setSubTitleText(CharSequence charSequence) {
        this.mSbuTitleView.setText(charSequence);
        this.mSbuTitleView.setContentDescription(charSequence);
    }

    public void setTitleText(CharSequence charSequence) {
        this.mTitleView.setText(charSequence);
        this.mTitleView.setContentDescription(charSequence);
    }
}
