package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.inter.listeners.RewardAdListener;
import com.huawei.openalliance.p169ad.utils.C7727aa;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.gp */
/* loaded from: classes8.dex */
public class C7159gp implements InterfaceC7155gl {

    /* renamed from: a */
    private Context f32953a;

    /* renamed from: b */
    private RewardAdListener f32954b;

    public C7159gp(Context context, RewardAdListener rewardAdListener) {
        this.f32953a = context.getApplicationContext();
        this.f32954b = rewardAdListener;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7155gl
    /* renamed from: a */
    public void mo43590a(int i10) {
        AbstractC7185ho.m43820b("RewardCallbackProc", "onAdFailed, errorCode:" + i10);
        RewardAdListener rewardAdListener = this.f32954b;
        if (rewardAdListener != null) {
            rewardAdListener.onAdFailed(i10);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7155gl
    /* renamed from: a */
    public void mo43591a(Map map) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onAdsLoaded, size:");
        sb2.append(map != null ? Integer.valueOf(map.size()) : null);
        sb2.append(", listener:");
        sb2.append(this.f32954b);
        AbstractC7185ho.m43820b("RewardCallbackProc", sb2.toString());
        RewardAdListener rewardAdListener = this.f32954b;
        if (rewardAdListener != null) {
            rewardAdListener.onAdsLoaded(map);
        }
        C7727aa.m47422a(this.f32953a, map);
    }
}
