package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.android.sync.R$id;
import com.huawei.android.sync.R$layout;
import com.huawei.android.sync.R$string;
import p514o9.C11839m;
import sk.C12809f;

/* loaded from: classes3.dex */
public class HiCloudListTipsLayout extends LinearLayout {
    private static final String TAG = "HiCloudListTipsLayout";
    private TextView mTipsView;

    public HiCloudListTipsLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View.inflate(context, R$layout.list_tips_layout_sync, this);
        this.mTipsView = (TextView) C12809f.m76831d(this, R$id.success_time);
    }

    public void hideTips() {
        this.mTipsView.setVisibility(8);
    }

    public void setDefaultTips(String str) {
        this.mTipsView.setVisibility(0);
        this.mTipsView.setText(str);
    }

    public void setLoadingText(String str) throws Resources.NotFoundException {
        C11839m.m70686d(TAG, "setLoadingText : " + str);
        if (getResources() != null) {
            str = getResources().getString(R$string.general_append_handling2, str);
        }
        this.mTipsView.setVisibility(0);
        this.mTipsView.setText(str);
    }

    public void setNoTips() {
        C11839m.m70686d(TAG, "setNoTips");
        this.mTipsView.setVisibility(8);
    }

    public void setText(String str) {
        C11839m.m70686d(TAG, "setText : " + str);
        this.mTipsView.setVisibility(0);
        this.mTipsView.setText(str);
    }

    public void showTips() {
        this.mTipsView.setVisibility(0);
    }

    public void tipsViewSetMaxWidth(int i10) {
        this.mTipsView.setMaxWidth(i10);
    }
}
