package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.inter.data.C7304g;
import com.huawei.openalliance.p169ad.inter.data.PlacementMediaFile;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7752az;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8122o;

/* renamed from: com.huawei.openalliance.ad.nn */
/* loaded from: classes8.dex */
public class C7519nn extends C7336jj<InterfaceC8122o> implements InterfaceC7535oc<InterfaceC8122o> {

    /* renamed from: d */
    private Context f34921d;

    public C7519nn(Context context, InterfaceC8122o interfaceC8122o) {
        mo45316a((C7519nn) interfaceC8122o);
        this.f34921d = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m46163b(final PlacementMediaFile placementMediaFile) {
        if (placementMediaFile == null) {
            return;
        }
        C7752az.m47690a(this.f34921d, placementMediaFile.m44549b(), new C7752az.a() { // from class: com.huawei.openalliance.ad.nn.3
            @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
            /* renamed from: a */
            public void mo30231a() {
                AbstractC7185ho.m43823c("PlacementImageViewPresenter", "placement image load failed");
                AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.nn.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        C7519nn.this.mo45320d().mo50321a(null, null);
                    }
                });
            }

            @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
            /* renamed from: a */
            public void mo30232a(final Drawable drawable) {
                AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.nn.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        C7519nn.this.mo45320d().mo50321a(placementMediaFile, drawable);
                    }
                });
            }
        });
    }

    /* renamed from: a */
    public void m46164a(final PlacementMediaFile placementMediaFile) {
        if (placementMediaFile == null) {
            mo45320d().mo50321a(null, null);
        } else {
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.nn.1
                @Override // java.lang.Runnable
                public void run() {
                    if (placementMediaFile.m44548a(C7519nn.this.f34921d)) {
                        C7519nn.this.m46163b(placementMediaFile);
                    }
                }
            });
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7535oc
    /* renamed from: a */
    public void mo46165a(final C7304g c7304g) {
        if (c7304g != null) {
            AbstractC7834m.m48481b(new Runnable() { // from class: com.huawei.openalliance.ad.nn.2
                @Override // java.lang.Runnable
                public void run() {
                    PlacementMediaFile mediaFile = c7304g.getMediaFile();
                    C7653sb c7653sb = new C7653sb();
                    c7653sb.m47187d(mediaFile.getUrl());
                    c7653sb.m47184c(mediaFile.getSha256());
                    c7653sb.m47180b("placement");
                    c7653sb.m47181b(mediaFile.getCheckSha256() == 0);
                    c7653sb.m47185c(true);
                    c7653sb.m47169a(C7575pi.m46766a(c7304g));
                    C7654sc c7654scM47158a = new C7650rz(C7519nn.this.f34921d, c7653sb).m47158a();
                    if (c7654scM47158a != null) {
                        String strM41968c = C7019dh.m41937a(C7519nn.this.f34921d, Constants.NORMAL_CACHE).m41968c(c7654scM47158a.m47207a());
                        if (AbstractC7731ae.m47458b(strM41968c)) {
                            mediaFile.m44550b(strM41968c);
                            C7519nn.this.m46164a(mediaFile);
                            return;
                        }
                    }
                    C7519nn.this.m46164a((PlacementMediaFile) null);
                }
            });
        }
    }
}
