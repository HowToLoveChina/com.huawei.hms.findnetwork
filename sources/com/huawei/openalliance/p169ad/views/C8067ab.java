package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;

/* renamed from: com.huawei.openalliance.ad.views.ab */
/* loaded from: classes2.dex */
public class C8067ab extends AppDownloadButtonStyle {
    public C8067ab(Context context) {
        super(context);
        this.normalStyle.setBackground(context.getResources().getDrawable(AbstractC7741ao.m47592n(context) ? C6849R.drawable.hiad_extand_landing_app_down_btn_pre_scan_elderly : C6849R.drawable.hiad_extand_landing_app_down_btn_pre_scan));
        this.normalStyle.setTextColor(context.getResources().getColor(C6849R.color.hiad_emui_accent));
    }
}
