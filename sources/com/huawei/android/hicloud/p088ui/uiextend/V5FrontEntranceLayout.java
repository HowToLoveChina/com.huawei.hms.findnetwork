package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import p015ak.C0209d;
import p015ak.C0213f;
import p514o9.C11839m;
import sk.C12809f;

/* loaded from: classes3.dex */
public class V5FrontEntranceLayout extends RelativeLayout {
    private static final String TAG = "V5FrontEntranceLayout";
    private TextView mDescTextView;
    private Button mJumpButton;
    private TextView mRecommendDescTextView;
    private TextView mTitleTextView;

    public V5FrontEntranceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    private void initView(Context context) {
        if (C0209d.m1195O(C0213f.m1377a()) > 1.75f) {
            View.inflate(context, R$layout.v5_front_entrance_layout_large, this);
        } else {
            View.inflate(context, R$layout.v5_front_entrance_layout, this);
        }
        this.mTitleTextView = (TextView) C12809f.m76831d(this, R$id.v5_title_text);
        this.mRecommendDescTextView = (TextView) C12809f.m76831d(this, R$id.v5_recommend_desc_text);
        this.mDescTextView = (TextView) C12809f.m76831d(this, R$id.v5_desc_text);
        this.mJumpButton = (Button) C12809f.m76831d(this, R$id.v5_jump_button);
    }

    public void showView(String str, String str2, String str3, String str4, View.OnClickListener onClickListener) {
        this.mTitleTextView.setText(str);
        this.mDescTextView.setText(str3);
        if (TextUtils.isEmpty(str4) || onClickListener == null) {
            this.mJumpButton.setVisibility(8);
        } else {
            this.mJumpButton.setVisibility(0);
            this.mJumpButton.setText(str4);
            this.mJumpButton.setOnClickListener(onClickListener);
        }
        if (TextUtils.isEmpty(str2)) {
            C11839m.m70686d(TAG, "showView mRecommendDescTextView gone");
            this.mRecommendDescTextView.setVisibility(8);
        } else {
            C11839m.m70686d(TAG, "showView mRecommendDescTextView show");
            this.mRecommendDescTextView.setVisibility(0);
            this.mRecommendDescTextView.setText(str2);
        }
    }
}
