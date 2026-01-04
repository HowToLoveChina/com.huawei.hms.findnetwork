package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.inter.data.C7305h;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.views.interfaces.IRewardVideoView;

/* renamed from: com.huawei.openalliance.ad.nq */
/* loaded from: classes8.dex */
public class C7522nq extends AbstractC7493na<IRewardVideoView> implements InterfaceC7538of<IRewardVideoView> {
    public C7522nq(Context context, IRewardVideoView iRewardVideoView) {
        super(context);
        mo45316a((C7522nq) iRewardVideoView);
        this.f34190b = new C7560ou(context, new C7667sp(context));
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7538of
    /* renamed from: a */
    public void mo46196a(int i10) {
        new C6922c(((AbstractC7493na) this).f34758d).m39121c(this.f34189a, i10);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7538of
    /* renamed from: a */
    public void mo46197a(Context context, long j10, long j11, int i10) {
        new C6922c(context).m39075a(this.f34189a, j10, j11, i10);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7538of
    /* renamed from: a */
    public void mo46198a(final VideoInfo videoInfo) {
        if (videoInfo == null) {
            return;
        }
        AbstractC7185ho.m43820b("RewardVideoViewPresenter", "checkVideoHash");
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.nq.1
            @Override // java.lang.Runnable
            public void run() {
                if (AbstractC7806cz.m48181j(videoInfo.getVideoDownloadUrl()) || videoInfo.m44570b(((AbstractC7493na) C7522nq.this).f34758d)) {
                    AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.nq.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ((IRewardVideoView) C7522nq.this.mo45320d()).onCheckVideoHashResult(videoInfo, true);
                        }
                    });
                }
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7538of
    /* renamed from: a */
    public void mo46199a(C7305h c7305h) {
        this.f34189a = C7580pn.m46793a(c7305h);
        Context context = ((AbstractC7493na) this).f34758d;
        this.f34190b = new C7560ou(context, new C7667sp(context), this.f34189a);
    }
}
