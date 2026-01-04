package p009a8;

import java.util.Arrays;
import p031b7.C1120a;

/* renamed from: a8.n */
/* loaded from: classes2.dex */
public class C0076n {

    /* renamed from: g */
    public static final Integer[] f285g = {6, 8, 32, 33};

    /* renamed from: a */
    public int f286a;

    /* renamed from: b */
    public boolean f287b;

    /* renamed from: c */
    public long f288c;

    /* renamed from: d */
    public boolean f289d;

    /* renamed from: e */
    public boolean f290e;

    /* renamed from: f */
    public long f291f;

    /* renamed from: a8.n$b */
    public static class b {

        /* renamed from: a */
        public static C0076n f292a = new C0076n();
    }

    /* renamed from: a */
    public static C0076n m619a() {
        return b.f292a;
    }

    /* renamed from: b */
    public long m620b() {
        return this.f288c;
    }

    /* renamed from: c */
    public void m621c(int i10) {
        C1120a.m6677i("SyncTypeManager", "initData syncType:" + i10);
        m619a().m629k(i10);
        m619a().m630l(0L);
        m619a().m625g(false);
        m619a().m624f(false);
        m619a().m628j(false);
    }

    /* renamed from: d */
    public boolean m622d(int i10) {
        C1120a.m6677i("SyncTypeManager", "syncType is:" + i10);
        return !Arrays.asList(f285g).contains(Integer.valueOf(i10));
    }

    /* renamed from: e */
    public boolean m623e() {
        return this.f287b;
    }

    /* renamed from: f */
    public void m624f(boolean z10) {
        this.f290e = z10;
    }

    /* renamed from: g */
    public void m625g(boolean z10) {
        this.f289d = z10;
    }

    /* renamed from: h */
    public void m626h(long j10) {
        this.f291f = j10;
    }

    /* renamed from: i */
    public void m627i(long j10) {
        C1120a.m6677i("SyncTypeManager", "setNotifyData needSpace: " + j10);
        m619a().m628j(true);
        m619a().m630l(j10);
        m619a().m626h(j10);
    }

    /* renamed from: j */
    public void m628j(boolean z10) {
        this.f287b = z10;
    }

    /* renamed from: k */
    public synchronized void m629k(int i10) {
        this.f286a = i10;
    }

    /* renamed from: l */
    public void m630l(long j10) {
        this.f288c = j10;
    }

    public C0076n() {
        this.f287b = false;
        this.f289d = false;
        this.f290e = false;
        this.f291f = 0L;
    }
}
