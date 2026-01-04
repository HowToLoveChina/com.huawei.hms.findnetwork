package com.huawei.hms.push;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* renamed from: com.huawei.hms.push.f */
/* loaded from: classes8.dex */
public class HandlerC6287f extends Handler {

    /* renamed from: a */
    private WeakReference<a> f29667a;

    /* renamed from: com.huawei.hms.push.f$a */
    public interface a {
        /* renamed from: a */
        void mo36482a(Message message);
    }

    public HandlerC6287f(a aVar) {
        this.f29667a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        a aVar = this.f29667a.get();
        if (aVar != null) {
            aVar.mo36482a(message);
        }
    }
}
