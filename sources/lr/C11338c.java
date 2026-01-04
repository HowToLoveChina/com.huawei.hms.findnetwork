package lr;

import android.location.Location;
import android.location.LocationListener;
import as.C1016d;
import es.C9551p;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import p852zq.AbstractC14365f;

/* renamed from: lr.c */
/* loaded from: classes8.dex */
public final class C11338c {

    /* renamed from: a */
    public C11337b f53037a;

    /* renamed from: b */
    public final CopyOnWriteArrayList<a> f53038b = new CopyOnWriteArrayList<>();

    /* renamed from: c */
    public boolean f53039c = false;

    /* renamed from: lr.c$a */
    public static class a {

        /* renamed from: a */
        public final long f53040a;

        /* renamed from: b */
        public final float f53041b;

        /* renamed from: c */
        public final LocationListener f53042c;

        /* renamed from: d */
        public long f53043d = 0;

        /* renamed from: e */
        public C14506a f53044e = new C14506a();

        public a(long j10, float f10, AbstractC14365f abstractC14365f) {
            this.f53040a = j10;
            this.f53041b = f10;
            this.f53042c = abstractC14365f;
        }

        /* renamed from: b */
        public final void m68127b(Location location) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jAbs = Math.abs(jCurrentTimeMillis - this.f53043d);
            if (jAbs < this.f53040a) {
                C1016d.m6181a("SdmProvider", "not need, interval check failed. timeDiff:" + jAbs);
                return;
            }
            C14506a c14506a = new C14506a(location.getLatitude(), location.getLongitude());
            float fM68128a = C14506a.m68128a(this.f53044e, c14506a);
            if (fM68128a < this.f53041b) {
                C1016d.m6181a("SdmProvider", "not need, distance check failed. distanceDiff:" + fM68128a);
            } else {
                this.f53043d = jCurrentTimeMillis;
                this.f53044e = c14506a;
                this.f53042c.onLocationChanged(location);
            }
        }

        /* renamed from: lr.c$a$a, reason: collision with other inner class name */
        public static class C14506a {

            /* renamed from: a */
            public final double f53045a;

            /* renamed from: b */
            public final double f53046b;

            public C14506a() {
                this(0.0d, 0.0d);
            }

            /* renamed from: a */
            public static float m68128a(C14506a c14506a, C14506a c14506a2) {
                float[] fArr = new float[1];
                double d10 = c14506a.f53045a;
                double d11 = c14506a2.f53046b;
                Location.distanceBetween(d10, d11, c14506a2.f53045a, d11, fArr);
                return fArr[0];
            }

            public C14506a(double d10, double d11) {
                this.f53045a = d10;
                this.f53046b = d11;
            }
        }
    }

    public C11338c() {
        this.f53037a = null;
        if (m68123c()) {
            this.f53037a = new C11337b();
        }
    }

    /* renamed from: a */
    public static void m68122a(C11338c c11338c, Location location) {
        Iterator<a> it = c11338c.f53038b.iterator();
        while (it.hasNext()) {
            it.next().m68127b(location);
        }
    }

    /* renamed from: c */
    public static boolean m68123c() {
        if (C9551p.m59641e("com.huawei.location.sdm.Sdm")) {
            C1016d.m6186f("SdmProvider", "support sdm");
            return true;
        }
        C1016d.m6190j("SdmProvider", "not support sdm");
        return false;
    }

    /* renamed from: b */
    public final void m68124b(AbstractC14365f abstractC14365f) {
        Iterator<a> it = this.f53038b.iterator();
        a aVar = null;
        while (it.hasNext()) {
            a next = it.next();
            if (next.f53042c == abstractC14365f) {
                aVar = next;
            }
        }
        if (aVar == null || !this.f53038b.remove(aVar)) {
            C1016d.m6181a("SdmProvider", "not need remove");
            return;
        }
        if (this.f53039c && this.f53038b.isEmpty()) {
            this.f53037a.m68119a();
            this.f53039c = false;
        }
        C1016d.m6186f("SdmProvider", "remove success");
    }

    /* renamed from: d */
    public final boolean m68125d(long j10, float f10, AbstractC14365f abstractC14365f) {
        C11337b c11337b = this.f53037a;
        if (c11337b == null) {
            C1016d.m6181a("SdmProvider", "not support sdm");
            return false;
        }
        if (!c11337b.m68121c(j10, f10)) {
            return false;
        }
        Iterator<a> it = this.f53038b.iterator();
        a aVar = null;
        while (it.hasNext()) {
            a next = it.next();
            if (next.f53042c == abstractC14365f) {
                aVar = next;
            }
        }
        if (aVar != null && this.f53038b.remove(aVar)) {
            C1016d.m6190j("SdmProvider", "duplicate request");
        }
        this.f53038b.add(new a(j10, f10, abstractC14365f));
        if (!this.f53039c && !this.f53038b.isEmpty()) {
            this.f53037a.m68120b(new C11339d(this));
            this.f53039c = true;
        }
        C1016d.m6186f("SdmProvider", "request success");
        return true;
    }
}
