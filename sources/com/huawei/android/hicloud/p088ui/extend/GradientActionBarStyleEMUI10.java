package com.huawei.android.hicloud.p088ui.extend;

import android.content.Context;
import android.content.res.Resources;
import com.huawei.hicloud.sync.R$color;
import com.huawei.hicloud.sync.R$drawable;
import p514o9.C11842p;

/* loaded from: classes3.dex */
public class GradientActionBarStyleEMUI10 extends AbstractC3943a {
    public GradientActionBarStyleEMUI10(Context context) {
        this.f18017a = C11842p.m70844o(context, 12);
        Resources resources = context.getResources();
        if (resources == null) {
            return;
        }
        this.f18018b = resources.getColor(R$color.transparent);
        int i10 = R$color.hicloud_main_actionbar_title_color_scroll_10_0;
        this.f18020d = resources.getColor(i10);
        int i11 = R$drawable.ic_back_scroll_10_0;
        this.f18022f = resources.getDrawable(i11);
        int i12 = R$drawable.ic_service_scroll_10_0;
        this.f18024h = resources.getDrawable(i12);
        int i13 = R$drawable.ic_more_scroll_10_0;
        this.f18026j = resources.getDrawable(i13);
        int i14 = R$drawable.ic_sns_info_pic_10_0;
        this.f18028l = resources.getDrawable(i14);
        this.f18019c = resources.getColor(R$color.hicloud_main_actionbar_background_color_scroll_10_0);
        this.f18021e = resources.getColor(i10);
        this.f18023g = resources.getDrawable(i11);
        this.f18025i = resources.getDrawable(i12);
        this.f18027k = resources.getDrawable(i13);
        this.f18029m = resources.getDrawable(i14);
    }
}
