package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.openalliance.p169ad.C6849R;

/* renamed from: com.huawei.openalliance.ad.views.ag */
/* loaded from: classes2.dex */
public class C8072ag extends AutoScaleSizeRelativeLayout {

    /* renamed from: a */
    private ImageView f37502a;

    public C8072ag(Context context) {
        super(context);
        m49995a(context);
    }

    /* renamed from: a */
    private void m49995a(Context context) {
        ((RelativeLayout) LayoutInflater.from(context).inflate(C6849R.layout.hiad_splash_icon_close_view, this)).setBackgroundColor(0);
        this.f37502a = (ImageView) findViewById(C6849R.id.icon_close);
    }

    public ImageView getCloseBtn() {
        return this.f37502a;
    }
}
