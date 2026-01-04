package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.huawei.openalliance.p169ad.utils.AbstractC7802cv;
import com.huawei.openalliance.p169ad.utils.C7752az;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8116i;

/* renamed from: com.huawei.openalliance.ad.ni */
/* loaded from: classes8.dex */
public class C7514ni extends AbstractC7513nh<InterfaceC8116i> implements InterfaceC7530ny {
    public C7514ni(Context context, InterfaceC8116i interfaceC8116i, int i10) {
        super(context, interfaceC8116i, i10);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7513nh
    /* renamed from: b */
    public void mo46119b(String str) {
        ((InterfaceC8116i) mo45320d()).mo50316d();
        AbstractC7185ho.m43820b("PPSImageViewPresenter", "onMaterialLoaded - begin to load image");
        C7752az.m47691a(((AbstractC7513nh) this).f34896d, str, new C7752az.a() { // from class: com.huawei.openalliance.ad.ni.1
            @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
            /* renamed from: a */
            public void mo30231a() {
                AbstractC7185ho.m43820b("PPSImageViewPresenter", "onMaterialLoaded - image load failed");
                AbstractC7802cv.m48128a(((AbstractC7513nh) C7514ni.this).f34896d.getApplicationContext(), new Runnable() { // from class: com.huawei.openalliance.ad.ni.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ((InterfaceC8116i) C7514ni.this.mo45320d()).mo50309a(-9);
                    }
                });
                C7514ni c7514ni = C7514ni.this;
                c7514ni.m46117b(c7514ni.f34189a);
            }

            @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
            /* renamed from: a */
            public void mo30232a(final Drawable drawable) {
                AbstractC7185ho.m43820b("PPSImageViewPresenter", "onMaterialLoaded - image load success");
                AbstractC7802cv.m48128a(((AbstractC7513nh) C7514ni.this).f34896d.getApplicationContext(), new Runnable() { // from class: com.huawei.openalliance.ad.ni.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ((InterfaceC8116i) C7514ni.this.mo45320d()).mo50307a(drawable);
                        ((InterfaceC8116i) C7514ni.this.mo45320d()).mo50314c();
                    }
                });
            }
        }, this.f34189a);
    }
}
