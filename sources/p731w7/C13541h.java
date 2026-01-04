package p731w7;

import android.os.Process;
import com.huawei.android.hicloud.album.service.hihttp.rest.OnResponseListener;
import com.huawei.android.hicloud.album.service.hihttp.rest.Response;
import java.util.concurrent.BlockingQueue;
import p031b7.C1120a;

/* renamed from: w7.h */
/* loaded from: classes2.dex */
public class C13541h extends Thread {

    /* renamed from: a */
    public final BlockingQueue<AbstractC13540g<?>> f60924a;

    /* renamed from: b */
    public final BlockingQueue<AbstractC13540g<?>> f60925b;

    /* renamed from: c */
    public volatile boolean f60926c = false;

    public C13541h(BlockingQueue<AbstractC13540g<?>> blockingQueue, BlockingQueue<AbstractC13540g<?>> blockingQueue2) {
        this.f60925b = blockingQueue;
        this.f60924a = blockingQueue2;
    }

    /* renamed from: a */
    public void m81465a() {
        this.f60926c = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws InterruptedException, SecurityException, IllegalArgumentException {
        Process.setThreadPriority(10);
        while (!this.f60926c) {
            try {
                AbstractC13540g<?> abstractC13540gTake = this.f60924a.take();
                int iMo81464G = abstractC13540gTake.mo81464G();
                OnResponseListener<?> onResponseListenerMo81463F = abstractC13540gTake.mo81463F();
                abstractC13540gTake.m81435r();
                C13537d.m81446h(iMo81464G, onResponseListenerMo81463F).m81450i().m81449g();
                Response responseM81473b = EnumC13547n.INSTANCE.m81473b(abstractC13540gTake);
                this.f60925b.remove(abstractC13540gTake);
                C13537d.m81446h(iMo81464G, onResponseListenerMo81463F).m81448f(responseM81473b).m81449g();
                abstractC13540gTake.m81430h();
                C13537d.m81446h(iMo81464G, onResponseListenerMo81463F).m81447e().m81449g();
            } catch (InterruptedException e10) {
                if (this.f60926c) {
                    return;
                }
                C1120a.m6676e("RequestDispatcher", "The request has interrupted! " + e10.toString());
            }
        }
    }
}
