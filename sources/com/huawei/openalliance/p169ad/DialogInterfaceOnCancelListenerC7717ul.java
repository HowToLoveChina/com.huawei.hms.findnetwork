package com.huawei.openalliance.p169ad;

import android.content.DialogInterface;
import com.huawei.openalliance.p169ad.views.PPSRewardView;
import java.lang.ref.WeakReference;

/* renamed from: com.huawei.openalliance.ad.ul */
/* loaded from: classes8.dex */
public class DialogInterfaceOnCancelListenerC7717ul implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    private WeakReference<PPSRewardView> f35778a;

    public DialogInterfaceOnCancelListenerC7717ul(PPSRewardView pPSRewardView) {
        this.f35778a = new WeakReference<>(pPSRewardView);
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        PPSRewardView pPSRewardView = this.f35778a.get();
        if (pPSRewardView != null) {
            pPSRewardView.resumeView();
            pPSRewardView.mo49482a("130");
            pPSRewardView.setAdDialog(null);
        }
    }
}
