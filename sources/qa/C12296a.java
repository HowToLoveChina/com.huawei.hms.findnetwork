package qa;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import p514o9.C11839m;
import p607ra.C12482d;
import p607ra.C12483e;

/* renamed from: qa.a */
/* loaded from: classes3.dex */
public class C12296a {

    /* renamed from: h */
    public static AtomicInteger f56963h = new AtomicInteger(0);

    /* renamed from: a */
    public final Object f56964a;

    /* renamed from: b */
    public AtomicInteger f56965b;

    /* renamed from: c */
    public final BlockingQueue<C12482d> f56966c;

    /* renamed from: d */
    public final Map<String, C12482d> f56967d;

    /* renamed from: e */
    public HashSet<String> f56968e;

    /* renamed from: f */
    public final List<C12483e> f56969f;

    /* renamed from: g */
    public final ReentrantLock f56970g;

    /* renamed from: qa.a$b */
    public static class b {

        /* renamed from: a */
        public static C12296a f56971a = new C12296a();
    }

    public /* synthetic */ C12296a(a aVar) {
        this();
    }

    /* renamed from: e */
    public static C12296a m73898e() {
        return b.f56971a;
    }

    /* renamed from: a */
    public void m73899a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f56968e.add(str);
    }

    /* renamed from: b */
    public void m73900b(String str) {
        C12482d c12482dRemove = this.f56967d.remove(str);
        if (c12482dRemove != null) {
            c12482dRemove.cancel(true);
            this.f56966c.remove(c12482dRemove);
        }
    }

    /* renamed from: c */
    public void m73901c(String str, C12482d c12482d) {
        if (TextUtils.isEmpty(str) || c12482d == null) {
            return;
        }
        synchronized (this.f56964a) {
            try {
                if (!this.f56968e.contains(str)) {
                    m73900b(str);
                }
                c12482d.m74960h(-this.f56965b.incrementAndGet());
                this.f56966c.add(c12482d);
                this.f56967d.put(str, c12482d);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: d */
    public int m73902d() {
        return this.f56969f.size();
    }

    /* renamed from: f */
    public final void m73903f(int i10) {
        f56963h.set(0);
        String str = new SimpleDateFormat(Constants.TIME_FORMAT_WITHOUT_MILLS, Locale.getDefault()).format(new Date());
        for (int i11 = 0; i11 < i10; i11++) {
            C12483e c12483e = new C12483e(this.f56966c, "ThumbTask(" + str + ")-" + f56963h.incrementAndGet());
            this.f56969f.add(c12483e);
            c12483e.start();
        }
    }

    /* renamed from: g */
    public void m73904g(String str) {
        this.f56967d.remove(str);
    }

    /* renamed from: h */
    public void m73905h(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f56968e.remove(str);
    }

    /* renamed from: i */
    public void m73906i(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("illegal size");
        }
        try {
            this.f56970g.lock();
            int size = this.f56969f.size();
            if (i10 == size) {
                C11839m.m70689w("ThumbDownloadManager", "same size ignore");
                return;
            }
            for (int i11 = 0; i11 < this.f56969f.size(); i11++) {
                C12483e c12483e = this.f56969f.get(i11);
                if (c12483e != null) {
                    c12483e.m74961a();
                }
            }
            this.f56969f.clear();
            m73903f(i10);
            C11839m.m70688i("ThumbDownloadManager", "resetPoolSize old: " + size + ", now: " + this.f56969f.size());
        } finally {
            this.f56970g.unlock();
        }
    }

    public C12296a() {
        this.f56964a = new Object();
        this.f56965b = new AtomicInteger(0);
        this.f56966c = new PriorityBlockingQueue();
        this.f56967d = new ConcurrentHashMap();
        this.f56968e = new HashSet<>();
        this.f56969f = new ArrayList();
        this.f56970g = new ReentrantLock();
        m73903f(10);
    }
}
