package p546p6;

import android.text.TextUtils;
import com.huawei.android.p069cg.request.threadpool.AbstractC2324e;
import com.huawei.android.p069cg.request.threadpool.C2334o;
import com.huawei.android.p069cg.request.threadpool.C2335p;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: p6.r */
/* loaded from: classes2.dex */
public class C12105r {

    /* renamed from: g */
    public static AtomicInteger f56129g = new AtomicInteger(0);

    /* renamed from: a */
    public final Object f56130a;

    /* renamed from: b */
    public AtomicInteger f56131b;

    /* renamed from: c */
    public final BlockingQueue<C2334o<Object>> f56132c;

    /* renamed from: d */
    public final Map<String, C2334o<Object>> f56133d;

    /* renamed from: e */
    public final List<C2335p> f56134e;

    /* renamed from: f */
    public final ReentrantLock f56135f;

    /* renamed from: p6.r$b */
    public static class b {

        /* renamed from: a */
        public static C12105r f56136a = new C12105r();
    }

    public /* synthetic */ C12105r(a aVar) {
        this();
    }

    /* renamed from: e */
    public static C12105r m72501e() {
        return b.f56136a;
    }

    /* renamed from: a */
    public void m72502a(String str) {
        C2334o<Object> c2334oRemove = this.f56133d.remove(str);
        if (c2334oRemove != null) {
            c2334oRemove.cancel(true);
            this.f56132c.remove(c2334oRemove);
        }
    }

    /* renamed from: b */
    public void m72503b() {
        this.f56132c.clear();
        this.f56133d.clear();
        this.f56131b.set(0);
    }

    /* renamed from: c */
    public void m72504c(String str, C2334o<Object> c2334o) {
        if (TextUtils.isEmpty(str) || c2334o == null) {
            return;
        }
        synchronized (this.f56130a) {
            try {
                if (this.f56133d.containsKey(str)) {
                    AbstractC2324e abstractC2324eM14676e = c2334o.m14676e();
                    if (abstractC2324eM14676e != null) {
                        HashMap map = new HashMap();
                        map.put("code", "12");
                        abstractC2324eM14676e.handle(map);
                    }
                } else {
                    c2334o.m14681p(this.f56131b.incrementAndGet());
                    this.f56132c.add(c2334o);
                    this.f56133d.put(str, c2334o);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: d */
    public void m72505d(String str, C2334o<Object> c2334o) {
        if (TextUtils.isEmpty(str) || c2334o == null) {
            return;
        }
        synchronized (this.f56130a) {
            m72502a(str);
            c2334o.m14681p(-this.f56131b.incrementAndGet());
            this.f56132c.add(c2334o);
            this.f56133d.put(str, c2334o);
        }
    }

    /* renamed from: f */
    public final void m72506f(int i10) {
        f56129g.set(0);
        String str = new SimpleDateFormat(Constants.TIME_FORMAT_WITHOUT_MILLS, Locale.getDefault()).format(new Date());
        for (int i11 = 0; i11 < i10; i11++) {
            String str2 = "ThumbTask(" + str + ")-" + f56129g.incrementAndGet();
            C2335p c2335p = new C2335p(this.f56132c, str2);
            this.f56134e.add(c2335p);
            c2335p.setName(str2);
            c2335p.start();
        }
    }

    /* renamed from: g */
    public void m72507g(String str) {
        this.f56133d.remove(str);
    }

    public C12105r() {
        this.f56130a = new Object();
        this.f56131b = new AtomicInteger(0);
        this.f56132c = new PriorityBlockingQueue();
        this.f56133d = new ConcurrentHashMap();
        this.f56134e = new ArrayList();
        this.f56135f = new ReentrantLock();
        m72506f(5);
    }
}
