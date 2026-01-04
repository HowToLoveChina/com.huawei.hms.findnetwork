package p558pu;

import android.content.pm.PackageManager;
import com.huawei.wearengine.C8887d;

/* renamed from: pu.d */
/* loaded from: classes9.dex */
public class RunnableC12229d implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ C8887d f56607a;

    public RunnableC12229d(C8887d c8887d) {
        this.f56607a = c8887d;
    }

    @Override // java.lang.Runnable
    public void run() throws PackageManager.NameNotFoundException {
        C8887d.m56509s(this.f56607a);
        C8887d.m56510u(this.f56607a);
        C8887d.m56511v(this.f56607a);
        synchronized (C8887d.f45273j) {
            this.f56607a.f45281g = true;
            C8887d.f45273j.notifyAll();
        }
        C8887d.m56512w(this.f56607a);
    }
}
