package com.huawei.openalliance.p169ad;

import android.content.res.Resources;
import android.view.View;
import com.huawei.openalliance.p169ad.views.PPSRewardView;

/* renamed from: com.huawei.openalliance.ad.vd */
/* loaded from: classes8.dex */
public class ViewOnClickListenerC7858vd implements View.OnClickListener {

    /* renamed from: a */
    private final PPSRewardView f36239a;

    public ViewOnClickListenerC7858vd(PPSRewardView pPSRewardView) {
        this.f36239a = pPSRewardView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException {
        if (C6849R.id.reward_close == view.getId()) {
            this.f36239a.m49600d(true);
        } else if (C6849R.id.reward_mute_icon == view.getId()) {
            this.f36239a.m49602i();
        }
    }
}
