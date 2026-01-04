package com.huawei.android.hicloud.p088ui.extend;

import android.content.Context;
import android.content.res.Resources;
import com.huawei.hicloud.sync.R$color;
import com.huawei.hicloud.sync.R$drawable;
import p514o9.C11842p;

/* loaded from: classes3.dex */
public class GradientActionBarStyleEMUI5 extends AbstractC3943a {
    public GradientActionBarStyleEMUI5(Context context) {
        this.f18017a = C11842p.m70844o(context, 4);
        Resources resources = context.getResources();
        if (resources == null) {
            return;
        }
        this.f18018b = resources.getColor(R$color.transparent);
        this.f18020d = resources.getColor(R$color.hicloud_main_actionbar_title_color_init);
        this.f18022f = resources.getDrawable(R$drawable.ic_back_init);
        this.f18024h = resources.getDrawable(R$drawable.ic_service_init);
        this.f18026j = resources.getDrawable(R$drawable.ic_more_init);
        this.f18028l = resources.getDrawable(R$drawable.ic_sns_info_pic_5_0);
        this.f18019c = resources.getColor(R$color.hicloud_main_actionbar_background_color_scroll_5_0);
        this.f18021e = resources.getColor(R$color.hicloud_main_actionbar_title_color_scroll_5_0);
        this.f18023g = resources.getDrawable(R$drawable.ic_back_scroll_5_0);
        this.f18025i = resources.getDrawable(R$drawable.ic_service_scroll_5_0);
        this.f18027k = resources.getDrawable(R$drawable.ic_more_scroll_5_0);
        this.f18029m = resources.getDrawable(R$drawable.ic_sns_info_pic_blue);
    }
}
