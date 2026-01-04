package p852zq;

import android.app.PendingIntent;
import com.huawei.location.router.interfaces.IRouterCallback;

/* renamed from: zq.c */
/* loaded from: classes8.dex */
public class C14362c {

    /* renamed from: a */
    public PendingIntent f63711a;

    /* renamed from: b */
    public IRouterCallback f63712b;

    /* renamed from: a */
    public final IRouterCallback m85539a() {
        return this.f63712b;
    }

    /* renamed from: b */
    public final PendingIntent m85540b() {
        return this.f63711a;
    }

    /* renamed from: c */
    public final void m85541c(PendingIntent pendingIntent) {
        this.f63711a = pendingIntent;
    }

    /* renamed from: d */
    public final void m85542d(IRouterCallback iRouterCallback) {
        this.f63712b = iRouterCallback;
    }
}
