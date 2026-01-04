package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;

/* renamed from: com.huawei.openalliance.ad.i */
/* loaded from: classes8.dex */
public abstract class AbstractC7206i extends AbstractC7326j {
    public AbstractC7206i(String str) {
        super(str);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7326j, com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo38573a(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("CmdBaseAdRequest", "paramContent: %s", str);
        }
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.i.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AbstractC7206i.this.mo43898b(context, str, remoteCallResultCallback);
                } catch (Throwable th2) {
                    AbstractC7185ho.m43813a(5, "CmdBaseAdRequest", "executeInNetworkThread exception", th2);
                    AbstractC7326j.m45216a(remoteCallResultCallback, AbstractC7206i.this.f34112a, -1, th2.getClass().getSimpleName() + ":" + th2.getMessage(), true);
                }
            }
        });
    }

    /* renamed from: b */
    public abstract void mo43898b(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback);

    /* renamed from: c */
    public String m43899c(String str) {
        return str;
    }
}
