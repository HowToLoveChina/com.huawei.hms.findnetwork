package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.huawei.openalliance.p169ad.AbstractC7014dc;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C7514ni;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8116i;

/* renamed from: com.huawei.openalliance.ad.views.q */
/* loaded from: classes2.dex */
public class C8147q extends AbstractC8143m implements InterfaceC8116i {

    /* renamed from: f */
    private ImageView f38077f;

    public C8147q(Context context, int i10) {
        super(context);
        m50460a(context);
        this.f37980a = new C7514ni(context, this, i10);
    }

    /* renamed from: a */
    private void m50460a(Context context) {
        View.inflate(context, C6849R.layout.hiad_view_image_ad, this);
        this.f38077f = (ImageView) findViewById(C6849R.id.iv_ad_content);
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8143m, com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8121n
    /* renamed from: e */
    public boolean mo50317e() {
        return true;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8116i
    /* renamed from: a */
    public void mo50307a(Drawable drawable) {
        AbstractC7185ho.m43820b("PPSImageView", "onAdImageLoaded - set image to view");
        this.f38077f.setImageDrawable(drawable);
        this.f37980a.mo46110a(this.f37983d);
        AbstractC7014dc.m41867a(drawable);
        AbstractC7014dc.m41866a((Bitmap) null);
    }
}
