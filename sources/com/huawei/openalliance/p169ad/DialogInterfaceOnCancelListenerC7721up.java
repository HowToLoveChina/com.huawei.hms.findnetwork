package com.huawei.openalliance.p169ad;

import android.content.DialogInterface;
import com.huawei.openalliance.p169ad.constant.RewardMethods;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8117j;

/* renamed from: com.huawei.openalliance.ad.up */
/* loaded from: classes8.dex */
public class DialogInterfaceOnCancelListenerC7721up implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    private InterfaceC8117j f35787a;

    public DialogInterfaceOnCancelListenerC7721up(InterfaceC8117j interfaceC8117j) {
        this.f35787a = interfaceC8117j;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f35787a.mo49499k();
        this.f35787a.setDownloadDialog(null);
        this.f35787a.mo49482a("130");
        this.f35787a.mo49487b(RewardMethods.SHOW_DOWNLOAD_CONFIRM);
        this.f35787a.resumeView();
    }
}
