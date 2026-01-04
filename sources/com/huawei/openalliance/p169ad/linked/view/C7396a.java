package com.huawei.openalliance.p169ad.linked.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6982bz;

/* renamed from: com.huawei.openalliance.ad.linked.view.a */
/* loaded from: classes2.dex */
public class C7396a {

    /* renamed from: a */
    protected a f34355a = new a();

    /* renamed from: com.huawei.openalliance.ad.linked.view.a$a */
    public static class a {

        /* renamed from: a */
        protected Drawable f34356a;

        /* renamed from: b */
        protected int f34357b;

        /* renamed from: c */
        protected int f34358c = 12;
    }

    public C7396a(Context context) {
        a aVar;
        Resources resources;
        int i10;
        if (C6982bz.m41148a(context).mo41178g()) {
            aVar = this.f34355a;
            resources = context.getResources();
            i10 = C6849R.drawable.hiad_extand_landing_app_down_btn_normal_hm;
        } else {
            aVar = this.f34355a;
            resources = context.getResources();
            i10 = C6849R.drawable.hiad_extand_landing_app_down_btn_normal;
        }
        aVar.f34356a = resources.getDrawable(i10);
        this.f34355a.f34357b = context.getResources().getColor(C6849R.color.hiad_emui_white_no_night);
    }

    /* renamed from: a */
    public a m45520a() {
        return this.f34355a;
    }
}
