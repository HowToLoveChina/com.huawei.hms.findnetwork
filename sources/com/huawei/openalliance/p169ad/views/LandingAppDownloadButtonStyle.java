package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.utils.C7818dk;

@OuterVisible
/* loaded from: classes2.dex */
public class LandingAppDownloadButtonStyle extends AppDownloadButtonStyle {
    @OuterVisible
    public LandingAppDownloadButtonStyle(Context context) {
        super(context);
        this.normalStyle.setBackground(context.getResources().getDrawable(C6849R.drawable.hiad_landing_app_down_btn_normal));
        this.normalStyle.setTextColor(context.getResources().getColor(C6849R.color.hiad_emui_white));
        this.processingStyle.setBackground(C7818dk.m48372b(context, C6849R.drawable.hiad_app_down_btn_processing));
        this.processingStyle.setTextColor(context.getResources().getColor(C6849R.color.hiad_app_down_processing_landing_page_text));
    }
}
