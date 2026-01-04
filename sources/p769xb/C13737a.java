package p769xb;

import com.huawei.hicloud.service.C5023q;
import p581qk.AbstractC12367d;
import p805yb.C13933c;

/* renamed from: xb.a */
/* loaded from: classes3.dex */
public class C13737a extends AbstractC12367d {

    /* renamed from: c */
    public static final Object f61750c = new Object();

    /* renamed from: a */
    public C5023q f61751a;

    /* renamed from: b */
    public String f61752b;

    public C13737a(String str) {
        this.f61752b = str;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        synchronized (f61750c) {
            try {
                if (this.f61752b.equals("get_version")) {
                    this.f61751a = new C5023q(null);
                    C13933c.m83668n().m83688v(this.f61751a);
                    C13933c.m83668n().m83676h();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
