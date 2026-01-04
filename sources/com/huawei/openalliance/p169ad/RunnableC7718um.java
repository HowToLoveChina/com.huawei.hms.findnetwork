package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.views.PPSRewardView;
import java.lang.ref.WeakReference;

/* renamed from: com.huawei.openalliance.ad.um */
/* loaded from: classes8.dex */
public class RunnableC7718um implements Runnable {

    /* renamed from: a */
    private WeakReference<PPSRewardView> f35779a;

    public RunnableC7718um(PPSRewardView pPSRewardView) {
        this.f35779a = new WeakReference<>(pPSRewardView);
    }

    @Override // java.lang.Runnable
    public void run() {
        PPSRewardView pPSRewardView = this.f35779a.get();
        if (pPSRewardView == null) {
            return;
        }
        pPSRewardView.mo49491c(false);
    }
}
