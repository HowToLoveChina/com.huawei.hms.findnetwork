package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.beans.metadata.VideoInfo;
import com.huawei.openalliance.p169ad.inter.data.C7302e;
import com.huawei.openalliance.p169ad.inter.data.ImageInfo;
import com.huawei.openalliance.p169ad.media.MediaPlayerAgent;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7752az;
import com.huawei.openalliance.p169ad.views.interfaces.INativeVideoView;
import com.huawei.openalliance.p169ad.views.interfaces.IPPSNativeView;

/* renamed from: com.huawei.openalliance.ad.nf */
/* loaded from: classes8.dex */
public class C7511nf extends AbstractC7493na<INativeVideoView> implements InterfaceC7529nx<INativeVideoView> {

    /* renamed from: h */
    private boolean f34879h;

    public C7511nf(Context context, INativeVideoView iNativeVideoView) {
        super(context);
        this.f34879h = false;
        mo45316a((C7511nf) iNativeVideoView);
        this.f34190b = new C7560ou(context, new C7665sn(context, 3));
    }

    /* renamed from: a */
    private void m46090a() {
        ContentRecord contentRecord = this.f34189a;
        if (contentRecord == null || contentRecord.m41419S() == null) {
            return;
        }
        AbstractC7185ho.m43820b("NativeVideoViewPresenter", "online stream error, direct cache video.");
        VideoInfo videoInfoM41419S = this.f34189a.m41419S();
        C7076dt.m42678h().m42680a(new C7074dr(videoInfoM41419S.m40471a(), videoInfoM41419S.m40481c(), videoInfoM41419S.m40496i() == 0, videoInfoM41419S.m40493g(), null, true, 1, this.f34189a.m41588n(), this.f34189a.m41585m(), 3, false, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m46092b(final ImageInfo imageInfo) {
        if (imageInfo == null) {
            return;
        }
        C7752az.m47690a(((AbstractC7493na) this).f34758d, imageInfo.getUrl(), new C7752az.a() { // from class: com.huawei.openalliance.ad.nf.2
            @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
            /* renamed from: a */
            public void mo30231a() {
                AbstractC7185ho.m43823c("NativeVideoViewPresenter", "video cover image load failed");
            }

            @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
            /* renamed from: a */
            public void mo30232a(final Drawable drawable) {
                AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.nf.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ((INativeVideoView) C7511nf.this.mo45320d()).onPreviewImageLoaded(imageInfo, drawable);
                    }
                });
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7529nx
    /* renamed from: a */
    public void mo46093a(int i10, int i11) {
        m46090a();
        if (this.f34879h) {
            return;
        }
        this.f34879h = true;
        new C6922c(((AbstractC7493na) this).f34758d).m39073a(this.f34189a, i10, i11);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7529nx
    /* renamed from: a */
    public void mo46094a(int i10, int i11, long j10, IPPSNativeView iPPSNativeView, C7302e c7302e) {
        if (iPPSNativeView == null || c7302e == null || c7302e.m44790Y() || c7302e.m44659q() == null || c7302e.m44659q().intValue() == 0) {
            return;
        }
        Integer numM44659q = c7302e.m44659q();
        if (numM44659q.intValue() == 2 && c7302e.m44661r() != null && c7302e.m44661r().intValue() >= 0) {
            int iIntValue = c7302e.m44661r().intValue();
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("NativeVideoViewPresenter", "reportAdShowEvent play percentage: %s  minEffectiveVideoPlayProgress：%s", Integer.valueOf(i10), c7302e.m44661r());
            }
            if (i10 < iIntValue) {
                return;
            }
        } else {
            if (numM44659q.intValue() != 1) {
                return;
            }
            long j11 = i11 - j10;
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("NativeVideoViewPresenter", "reportAdShowEvent has playing time: %s  playTime: %s  videoStartPlayTime: %s", Long.valueOf(j11), Integer.valueOf(i11), Long.valueOf(j10));
            }
            if (j11 < c7302e.getMinEffectiveShowTime()) {
                return;
            }
        }
        iPPSNativeView.mo49347a(null);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7529nx
    /* renamed from: a */
    public void mo46095a(final ImageInfo imageInfo) {
        if (imageInfo == null) {
            return;
        }
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.nf.3
            @Override // java.lang.Runnable
            public void run() {
                if (imageInfo.m44477b(((AbstractC7493na) C7511nf.this).f34758d)) {
                    C7511nf.this.m46092b(imageInfo);
                }
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7529nx
    /* renamed from: a */
    public void mo46096a(final com.huawei.openalliance.p169ad.inter.data.VideoInfo videoInfo) {
        if (videoInfo == null) {
            return;
        }
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.nf.1
            @Override // java.lang.Runnable
            public void run() {
                final boolean zM44570b = videoInfo.m44570b(((AbstractC7493na) C7511nf.this).f34758d);
                AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.nf.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ((INativeVideoView) C7511nf.this.mo45320d()).onCheckVideoHashResult(videoInfo, zM44570b);
                    }
                });
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7529nx
    /* renamed from: a */
    public void mo46097a(C7302e c7302e) {
        this.f34189a = C7570pd.m46698a(c7302e);
        Context context = ((AbstractC7493na) this).f34758d;
        this.f34190b = new C7560ou(context, new C7665sn(context, 3), this.f34189a);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7529nx
    /* renamed from: a */
    public void mo46098a(IPPSNativeView iPPSNativeView, C7302e c7302e) {
        if (iPPSNativeView == null || c7302e == null || c7302e.m44790Y() || c7302e.m44659q() == null) {
            return;
        }
        Integer numM44659q = c7302e.m44659q();
        int iIntValue = numM44659q.intValue();
        if (iIntValue == 1 || iIntValue == 2) {
            AbstractC7185ho.m43821b("NativeVideoViewPresenter", "reportAdShowEvent Media Play over reportAdShowEvent by customExposureType: %s", numM44659q);
            iPPSNativeView.mo49347a(null);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7529nx
    /* renamed from: a */
    public void mo46099a(boolean z10) {
        InterfaceC7615qq interfaceC7615qq = this.f34190b;
        if (interfaceC7615qq == null) {
            return;
        }
        interfaceC7615qq.mo46615b(z10);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7529nx
    /* renamed from: a */
    public boolean mo46100a(MediaPlayerAgent mediaPlayerAgent, C7302e c7302e) {
        return false;
    }
}
