package com.huawei.openalliance.p169ad;

import android.content.DialogInterface;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k;

/* renamed from: com.huawei.openalliance.ad.uw */
/* loaded from: classes8.dex */
public class DialogInterfaceOnCancelListenerC7850uw implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    private final InterfaceC8118k f36221a;

    public DialogInterfaceOnCancelListenerC7850uw(InterfaceC8118k interfaceC8118k) {
        this.f36221a = interfaceC8118k;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f36221a.mo49501m();
    }
}
