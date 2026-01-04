package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.C7818dk;

@OuterVisible
/* loaded from: classes2.dex */
public class ExtandAppDownloadButtonStyle extends AppDownloadButtonStyle {
    @OuterVisible
    public ExtandAppDownloadButtonStyle(Context context) {
        super(context);
        boolean zM47592n = AbstractC7741ao.m47592n(context);
        this.normalStyle.setBackground(context.getResources().getDrawable(zM47592n ? C6849R.drawable.hiad_extand_landing_app_down_btn_normal_elderly : C6849R.drawable.hiad_extand_landing_app_down_btn_normal));
        this.normalStyle.setTextColor(context.getResources().getColor(C6849R.color.hiad_down_btn_white));
        this.processingStyle.setBackground(C7818dk.m48372b(context, zM47592n ? C6849R.drawable.hiad_extand_app_down_btn_processing_elderly : C6849R.drawable.hiad_extand_app_down_btn_processing));
        this.processingStyle.setTextColor(context.getResources().getColor(C6849R.color.hiad_emui_black));
        this.installingStyle.setBackground(context.getResources().getDrawable(zM47592n ? C6849R.drawable.hiad_extand_app_down_btn_installing_elderly : C6849R.drawable.hiad_extand_app_down_btn_installing));
        this.installingStyle.setTextColor(context.getResources().getColor(C6849R.color.hiad_app_down_installing_text));
        this.f36313a.setBackground(context.getResources().getDrawable(zM47592n ? C6849R.drawable.hiad_linked_app_down_btn_installing_elderly : C6849R.drawable.hiad_linked_app_down_btn_installing));
        this.f36313a.setTextColor(context.getResources().getColor(C6849R.color.hiad_emui_white));
    }
}
