package p491nd;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import ba.C1147a;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p015ak.C0227m;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p783xp.C13843a;

/* renamed from: nd.a */
/* loaded from: classes3.dex */
public class C11663a extends AbstractC12367d {

    /* renamed from: a */
    public CountDownLatch f54104a;

    /* renamed from: b */
    public Handler f54105b;

    /* renamed from: c */
    public String f54106c;

    /* renamed from: d */
    public String f54107d;

    /* renamed from: e */
    public String f54108e;

    /* renamed from: f */
    public List<C1147a> f54109f = new ArrayList();

    /* renamed from: g */
    public Handler f54110g = new a(Looper.getMainLooper());

    /* renamed from: nd.a$a */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (1 == message.what) {
                C11663a.this.f54109f.add((C1147a) message.obj);
                C11663a.this.f54104a.countDown();
            }
        }
    }

    public C11663a(Handler handler, String str, String str2, String str3) {
        this.f54105b = handler;
        this.f54106c = str;
        this.f54107d = str2;
        this.f54108e = str3;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        this.f54104a = new CountDownLatch(2);
        C13843a.m83085g(this.f54106c);
        C12515a.m75110o().m75175e(new C11664b(this.f54107d, this.f54106c + C0227m.m1593f(this.f54107d), null, this.f54110g, null), false);
        C12515a.m75110o().m75175e(new C11664b(this.f54108e, this.f54106c + C0227m.m1593f(this.f54108e), null, this.f54110g, null), false);
        try {
            if (this.f54104a.await(5000L, TimeUnit.MILLISECONDS)) {
                this.f54105b.obtainMessage(3, this.f54109f).sendToTarget();
                C11839m.m70688i("LoadDoubleIconManageTask", "LoadDoubleImageTask all task success");
            }
        } catch (InterruptedException e10) {
            C11839m.m70687e("LoadDoubleIconManageTask", "LoadDoubleImageTask doInBackground exception:" + e10.toString());
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.PPS_ICON_DOWNLOAD;
    }
}
