package com.huawei.openalliance.p169ad;

import android.content.DialogInterface;
import com.huawei.openalliance.p169ad.views.PPSRewardView;

/* renamed from: com.huawei.openalliance.ad.vi */
/* loaded from: classes8.dex */
public class DialogInterfaceOnCancelListenerC7863vi implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    private final PPSRewardView f36248a;

    public DialogInterfaceOnCancelListenerC7863vi(PPSRewardView pPSRewardView) {
        this.f36248a = pPSRewardView;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f36248a.m49607q();
    }
}
