package com.huawei.android.hicloud.p088ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.TextView;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.openalliance.p169ad.constant.Constants;
import p514o9.C11839m;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes3.dex */
public class ReturnCampaignActivityFloatView extends CampaignEntryFloatView {

    /* renamed from: o */
    public TextView f19549o;

    public ReturnCampaignActivityFloatView(Context context) {
        super(context);
    }

    /* renamed from: c */
    public final void m25808c(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (this.f19369j == null) {
            this.f19369j = (WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR);
        }
        this.f19369j.getDefaultDisplay().getMetrics(displayMetrics);
        this.f19367h = displayMetrics.widthPixels;
        this.f19368i = displayMetrics.heightPixels;
        this.f19365f = (int) C11842p.m70844o(context, 58);
        this.f19366g = (int) C11842p.m70844o(context, 41);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f19370k = layoutParams;
        layoutParams.gravity = 8388659;
        layoutParams.flags = 8;
        layoutParams.type = 2;
        layoutParams.format = 1;
        layoutParams.width = this.f19365f;
        layoutParams.height = this.f19366g;
        layoutParams.x = C11842p.m70765S0() ? (int) (this.f19367h - this.f19370k.width) : 0;
        this.f19370k.y = ((int) (this.f19368i - r4.height)) / 2;
    }

    public TextView getBackToTaskCenter() {
        return this.f19549o;
    }

    @Override // com.huawei.android.hicloud.p088ui.views.CampaignEntryFloatView
    /* renamed from: h */
    public void mo25681h(Context context) {
        LayoutInflater.from(context).inflate(R$layout.return_activity_center_float_layout, this);
        this.f19549o = (TextView) C12809f.m76831d(this, R$id.campaign_back_to_task_center_btn);
        if (C11842p.m70765S0()) {
            setBackground(context.getDrawable(R$drawable.return_campaign_center_background_rtl));
        } else {
            setBackground(context.getDrawable(R$drawable.return_campaign_center_background));
        }
        try {
            m25808c(context);
            this.f19369j.addView(this, this.f19370k);
        } catch (Exception e10) {
            C11839m.m70687e("ReturnCampaignActivityFloatView", "init Exception: " + e10.getMessage());
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.views.CampaignEntryFloatView
    public void setViewSide(float f10) {
        this.f19370k.x = C11842p.m70765S0() ? (int) (this.f19367h - this.f19370k.width) : 0;
    }

    public ReturnCampaignActivityFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ReturnCampaignActivityFloatView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
