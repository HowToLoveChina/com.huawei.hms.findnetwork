package androidx.lifecycle;

import android.content.Context;
import java.util.Collections;
import java.util.List;
import p794y0.C13898a;
import p794y0.InterfaceC13899b;

/* loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements InterfaceC13899b<InterfaceC0796l> {
    @Override // p794y0.InterfaceC13899b
    /* renamed from: a */
    public List<Class<? extends InterfaceC13899b<?>>> mo4189a() {
        return Collections.emptyList();
    }

    @Override // p794y0.InterfaceC13899b
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC0796l mo4190b(Context context) {
        if (!C13898a.m83303e(context).m83309g(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily. \nPlease ensure that you have: \n<meta-data\n    android:name='androidx.lifecycle.ProcessLifecycleInitializer' \n    android:value='androidx.startup' /> \nunder InitializationProvider in your AndroidManifest.xml");
        }
        C0793i.m4956a(context);
        C0804t.m4979k(context);
        return C0804t.m4978j();
    }
}
