package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.beans.metadata.MediaFile;
import com.huawei.openalliance.p169ad.inter.data.C7304g;
import com.huawei.openalliance.p169ad.inter.data.PlacementMediaFile;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.views.interfaces.IPlacementVideoView;

/* renamed from: com.huawei.openalliance.ad.no */
/* loaded from: classes8.dex */
public class C7520no extends AbstractC7493na<IPlacementVideoView> implements InterfaceC7536od<IPlacementVideoView> {
    public C7520no(Context context, IPlacementVideoView iPlacementVideoView) {
        super(context == null ? context : context.getApplicationContext());
        mo45316a((C7520no) iPlacementVideoView);
        context = context != null ? context.getApplicationContext() : context;
        this.f34190b = new C7560ou(context, new C7666so(context));
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7536od
    /* renamed from: a */
    public void mo46166a() {
        ContentRecord contentRecord = this.f34189a;
        if (contentRecord == null || contentRecord.m41421T() == null) {
            return;
        }
        try {
            AbstractC7185ho.m43820b("PlacementVideoViewPresenter", "online stream error, direct cache video.");
            MediaFile mediaFileM41421T = this.f34189a.m41421T();
            C7076dt.m42678h().m42680a(new C7074dr(mediaFileM41421T.m40255e(), (int) mediaFileM41421T.m40253d(), mediaFileM41421T.m40258g() == 0, mediaFileM41421T.m40257f(), null, true, 1, this.f34189a.m41588n(), this.f34189a.m41585m(), 60, false, 0));
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("PlacementVideoViewPresenter", "direct cache ex: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7536od
    /* renamed from: b */
    public void mo46170b(String str) {
        this.f34761g = str;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7536od
    /* renamed from: a */
    public void mo46167a(long j10, int i10) {
        new C6922c(((AbstractC7493na) this).f34758d).m39073a(this.f34189a, j10, i10);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7536od
    /* renamed from: a */
    public void mo46168a(final PlacementMediaFile placementMediaFile) {
        if (placementMediaFile == null) {
            return;
        }
        AbstractC7185ho.m43820b("PlacementVideoViewPresenter", "checkVideoHash");
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.no.1
            @Override // java.lang.Runnable
            public void run() {
                if (2 == placementMediaFile.getPlayMode() || placementMediaFile.m44548a(((AbstractC7493na) C7520no.this).f34758d)) {
                    AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.no.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ((IPlacementVideoView) C7520no.this.mo45320d()).onCheckVideoHashResult(placementMediaFile, true);
                        }
                    });
                }
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7536od
    /* renamed from: a */
    public void mo46169a(C7304g c7304g) {
        this.f34189a = C7575pi.m46766a(c7304g);
        Context context = ((AbstractC7493na) this).f34758d;
        this.f34190b = new C7560ou(context, new C7666so(context), this.f34189a);
        if (c7304g != null) {
            ((AbstractC7493na) this).f34760f = Integer.valueOf(c7304g.getSequence());
        }
    }
}
