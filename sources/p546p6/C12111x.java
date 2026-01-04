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

/* renamed from: p6.x */
/* loaded from: classes2.dex */
public class C12111x {

    /* renamed from: g */
    public static AtomicInteger f56166g = new AtomicInteger(0);

    /* renamed from: a */
    public final Object f56167a;

    /* renamed from: b */
    public AtomicInteger f56168b;

    /* renamed from: c */
    public final BlockingQueue<C2334o<Object>> f56169c;

    /* renamed from: d */
    public final Map<String, C2334o<Object>> f56170d;

    /* renamed from: e */
    public final List<C2335p> f56171e;

    /* renamed from: f */
    public final ReentrantLock f56172f;

    /* renamed from: p6.x$b */
    public static class b {

        /* renamed from: a */
        public static C12111x f56173a = new C12111x();
    }

    /* renamed from: e */
    public static C12111x m72537e() {
        return b.f56173a;
    }

    /* renamed from: a */
    public void m72538a(String str) {
        C2334o<Object> c2334oRemove = this.f56170d.remove(str);
        if (c2334oRemove != null) {
            c2334oRemove.cancel(true);
            this.f56169c.remove(c2334oRemove);
        }
    }

    /* renamed from: b */
    public void m72539b() {
        this.f56169c.clear();
        this.f56170d.clear();
        this.f56168b.set(0);
    }

    /* renamed from: c */
    public void m72540c(String str, C2334o<Object> c2334o) {
        if (TextUtils.isEmpty(str) || c2334o == null) {
            return;
        }
        synchronized (this.f56167a) {
            try {
                if (this.f56170d.containsKey(str)) {
                    AbstractC2324e abstractC2324eM14676e = c2334o.m14676e();
                    if (abstractC2324eM14676e != null) {
                        HashMap map = new HashMap();
                        map.put("code", "12");
                        abstractC2324eM14676e.handle(map);
                    }
                } else {
                    c2334o.m14681p(this.f56168b.incrementAndGet());
                    this.f56169c.add(c2334o);
                    this.f56170d.put(str, c2334o);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: d */
    public void m72541d(String str, C2334o<Object> c2334o) {
        if (TextUtils.isEmpty(str) || c2334o == null) {
            return;
        }
        synchronized (this.f56167a) {
            m72538a(str);
            c2334o.m14681p(-this.f56168b.incrementAndGet());
            this.f56169c.add(c2334o);
            this.f56170d.put(str, c2334o);
        }
    }

    /* renamed from: f */
    public int m72542f() {
        return this.f56169c.size();
    }

    /* renamed from: g */
    public final void m72543g(int i10) {
        f56166g.set(0);
        String str = new SimpleDateFormat(Constants.TIME_FORMAT_WITHOUT_MILLS, Locale.getDefault()).format(new Date());
        for (int i11 = 0; i11 < i10; i11++) {
            String str2 = "ThumbTask(" + str + ")-" + f56166g.incrementAndGet();
            C2335p c2335p = new C2335p(this.f56169c, str2);
            this.f56171e.add(c2335p);
            c2335p.setName(str2);
            c2335p.start();
        }
    }

    /* renamed from: h */
    public void m72544h(String str) {
        this.f56170d.remove(str);
    }

    public C12111x() {
        this.f56167a = new Object();
        this.f56168b = new AtomicInteger(0);
        this.f56169c = new PriorityBlockingQueue();
        this.f56170d = new ConcurrentHashMap();
        this.f56171e = new ArrayList();
        this.f56172f = new ReentrantLock();
        m72543g(10);
    }
}
