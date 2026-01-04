package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.openalliance.p169ad.views.AbstractC8104h;

/* renamed from: com.huawei.openalliance.ad.tq */
/* loaded from: classes8.dex */
public class C7695tq extends AbstractC7696tr {
    public C7695tq(Context context, int[] iArr, int[] iArr2) {
        super(context, iArr, iArr2);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7696tr
    /* renamed from: a */
    public void mo47289a() {
        this.f35719c = (RelativeLayout) findViewById(C6849R.id.haid_advertiser_info_dialog_root);
        this.f35727k = findViewById(C6849R.id.margin_view);
        this.f35728l = findViewById(C6849R.id.anchor_view);
        this.f35723g = (AbstractC8104h) findViewById(C6849R.id.top_advertiser_view);
        this.f35729m = (ImageView) findViewById(C6849R.id.top_advertiser_iv);
        this.f35724h = (AbstractC8104h) findViewById(C6849R.id.bottom_advertiser_view);
        this.f35730n = (ImageView) findViewById(C6849R.id.bottom_advertiser_iv);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7696tr
    public int getLayoutId() {
        return C6849R.layout.hiad_advertiser_info_dialog;
    }
}
