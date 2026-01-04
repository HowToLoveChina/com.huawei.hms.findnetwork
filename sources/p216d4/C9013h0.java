package p216d4;

import android.content.Context;
import com.huawei.ads.adsrec.C2093e;
import com.huawei.ads.adsrec.p066db.table.AdIECImpRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import p247e4.C9406b;
import p384j4.AbstractC10706e;
import p405jt.AbstractC10915a;

/* renamed from: d4.h0 */
/* loaded from: classes.dex */
public class C9013h0 implements Comparable<C9013h0> {

    /* renamed from: a */
    public final Context f45632a;

    /* renamed from: b */
    public final String f45633b;

    /* renamed from: d */
    public final long f45635d;

    /* renamed from: e */
    public final C9027o0 f45636e;

    /* renamed from: f */
    public volatile Map<String, d> f45637f;

    /* renamed from: g */
    public final AtomicBoolean f45638g = new AtomicBoolean(true);

    /* renamed from: h */
    public final AtomicInteger f45639h = new AtomicInteger(0);

    /* renamed from: c */
    public volatile long f45634c = System.currentTimeMillis();

    /* renamed from: d4.h0$b */
    public static class b {

        /* renamed from: a */
        public final C9406b f45640a;

        /* renamed from: b */
        public final long f45641b;

        public b(C9406b c9406b, long j10) {
            this.f45640a = c9406b;
            this.f45641b = j10;
        }

        /* renamed from: a */
        public C9406b m56907a() {
            return this.f45640a;
        }

        /* renamed from: b */
        public long m56908b() {
            return this.f45641b;
        }
    }

    /* renamed from: d4.h0$c */
    public static class c {

        /* renamed from: a */
        public final List<b> f45642a;

        /* renamed from: b */
        public final List<b> f45643b;

        public c() {
            this.f45642a = new ArrayList();
            this.f45643b = new ArrayList();
        }

        /* renamed from: a */
        public List<b> m56909a() {
            return this.f45642a;
        }

        /* renamed from: b */
        public void m56910b(C9406b c9406b, long j10) {
            (c9406b.m58981n() == 0 ? this.f45642a : this.f45643b).add(new b(c9406b, j10));
        }

        /* renamed from: c */
        public List<b> m56911c() {
            return this.f45643b;
        }

        /* renamed from: d */
        public boolean m56912d() {
            return this.f45642a.isEmpty() && this.f45643b.isEmpty();
        }
    }

    /* renamed from: d4.h0$d */
    public static class d {

        /* renamed from: a */
        public final String f45644a;

        /* renamed from: b */
        public final String f45645b;

        /* renamed from: c */
        public long f45646c;

        /* renamed from: d */
        public long f45647d;

        /* renamed from: e */
        public boolean f45648e;

        public d(String str, String str2, long j10, boolean z10) {
            this.f45644a = str;
            this.f45645b = str2;
            this.f45646c = z10 ? j10 : 0L;
            this.f45647d = j10;
            this.f45648e = z10;
        }

        /* renamed from: b */
        public boolean m56914b(long j10, long j11) {
            return this.f45647d + j11 < j10;
        }

        /* renamed from: c */
        public String[] m56915c() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (!this.f45648e) {
                return new String[]{this.f45644a, this.f45645b, String.valueOf(this.f45647d), String.valueOf(jCurrentTimeMillis)};
            }
            long j10 = this.f45647d;
            if (j10 == this.f45646c) {
                return null;
            }
            return new String[]{String.valueOf(j10), String.valueOf(jCurrentTimeMillis), this.f45644a, this.f45645b};
        }

        /* renamed from: d */
        public boolean m56916d() {
            return this.f45648e;
        }

        /* renamed from: e */
        public void m56917e() {
            this.f45646c = this.f45647d;
            this.f45648e = true;
        }

        /* renamed from: f */
        public void m56918f() {
            this.f45647d = this.f45646c;
        }
    }

    public C9013h0(Context context, String str, long j10) {
        this.f45632a = context;
        this.f45633b = str;
        this.f45635d = j10;
        this.f45636e = C9027o0.m56955b(context);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C9013h0 c9013h0) {
        return this.f45634c > c9013h0.f45634c ? -1 : 0;
    }

    /* renamed from: b */
    public final Map<String, List<C9406b>> m56891b(c cVar) {
        Map<String, List<C9406b>> mapM56892e;
        synchronized (this) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            mapM56892e = m56892e(cVar, jCurrentTimeMillis, m56893f(cVar, jCurrentTimeMillis));
        }
        return mapM56892e;
    }

    /* renamed from: e */
    public final Map<String, List<C9406b>> m56892e(c cVar, long j10, Set<String> set) {
        List<b> listM56911c = cVar.m56911c();
        if (AbstractC10706e.m65374a(listM56911c)) {
            return null;
        }
        if (this.f45637f == null) {
            m56894h();
        }
        HashMap map = new HashMap();
        for (b bVar : listM56911c) {
            C9406b c9406bM56907a = bVar.m56907a();
            if (set.contains(c9406bM56907a.m58977j())) {
                m56897p(j10, map, c9406bM56907a);
            } else {
                m56898q(j10, map, c9406bM56907a, bVar.m56908b());
            }
        }
        return map;
    }

    /* renamed from: f */
    public final Set<String> m56893f(c cVar, long j10) {
        HashSet hashSet = new HashSet();
        Iterator<b> it = cVar.m56909a().iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().m56907a().m58977j());
        }
        return hashSet;
    }

    /* renamed from: h */
    public final void m56894h() {
        this.f45637f = new ConcurrentHashMap();
        List<AdIECImpRecord> listMo12529a = new C2093e(this.f45632a).mo12529a(this.f45633b);
        if (AbstractC10706e.m65374a(listMo12529a)) {
            return;
        }
        for (AdIECImpRecord adIECImpRecord : listMo12529a) {
            this.f45637f.put(adIECImpRecord.m12484t(), new d(this.f45633b, adIECImpRecord.m12484t(), adIECImpRecord.m12488x(), true));
        }
    }

    /* renamed from: i */
    public final void m56895i(long j10) {
        this.f45634c = j10;
        this.f45638g.set(false);
    }

    /* renamed from: k */
    public final void m56896k(long j10, String str) {
        d dVar = this.f45637f.get(str);
        if (dVar == null) {
            this.f45637f.put(str, new d(this.f45633b, str, j10, false));
        } else {
            dVar.f45647d = j10;
        }
        m56895i(j10);
    }

    /* renamed from: p */
    public final void m56897p(long j10, Map<String, List<C9406b>> map, C9406b c9406b) {
        m56896k(j10, c9406b.m58977j());
        m56901t(map, c9406b);
    }

    /* renamed from: q */
    public final void m56898q(long j10, Map<String, List<C9406b>> map, C9406b c9406b, long j11) {
        String strM58977j = c9406b.m58977j();
        d dVar = this.f45637f.get(strM58977j);
        if (dVar == null || dVar.m56914b(j10, j11)) {
            m56896k(j10, strM58977j);
        } else {
            m56901t(map, c9406b);
        }
    }

    /* renamed from: r */
    public void m56899r(List<C9031r> list) {
        if (AbstractC10706e.m65374a(list)) {
            return;
        }
        c cVar = new c();
        Iterator<C9031r> it = list.iterator();
        while (it.hasNext()) {
            long jM56963i = this.f45636e.m56963i(r2.m56976q()) * 60000;
            List<C9406b> listM56974o = it.next().m56974o();
            if (listM56974o != null) {
                Iterator<C9406b> it2 = listM56974o.iterator();
                while (it2.hasNext()) {
                    cVar.m56910b(it2.next(), jM56963i);
                }
            }
        }
        if (cVar.m56912d()) {
            AbstractC10915a.m65978j("RTFilter", "not to filter");
        } else {
            m56900s(list, m56891b(cVar));
        }
    }

    /* renamed from: s */
    public final void m56900s(List<C9031r> list, Map<String, List<C9406b>> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (C9031r c9031r : list) {
            String strM56976q = c9031r.m56976q();
            List<C9406b> listM56974o = c9031r.m56974o();
            List<C9406b> list2 = map.get(strM56976q);
            if (!AbstractC10706e.m65374a(listM56974o) && !AbstractC10706e.m65374a(list2)) {
                ArrayList arrayList = new ArrayList();
                for (C9406b c9406b : listM56974o) {
                    if (!list2.contains(c9406b)) {
                        arrayList.add(c9406b);
                    }
                }
                c9031r.m56969j(arrayList);
            }
        }
    }

    /* renamed from: t */
    public final void m56901t(Map<String, List<C9406b>> map, C9406b c9406b) {
        String strM58982o = c9406b.m58982o();
        List<C9406b> arrayList = map.get(strM58982o);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            map.put(strM58982o, arrayList);
        }
        arrayList.add(c9406b);
    }

    /* renamed from: u */
    public void m56902u(Set<String> set) {
        if (this.f45637f == null || AbstractC10706e.m65374a(set)) {
            return;
        }
        synchronized (this) {
            try {
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    d dVar = this.f45637f.get(it.next());
                    if (dVar == null) {
                        AbstractC10915a.m65978j("RTFilter", "content not in map");
                    } else {
                        dVar.m56918f();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: v */
    public void m56903v() {
        this.f45639h.decrementAndGet();
    }

    /* renamed from: w */
    public void m56904w() {
        this.f45639h.incrementAndGet();
    }

    /* renamed from: x */
    public boolean m56905x() {
        if (this.f45637f == null) {
            return true;
        }
        synchronized (this) {
            try {
                m56906y();
                if (this.f45639h.get() > 0) {
                    return false;
                }
                if (this.f45635d + this.f45634c > System.currentTimeMillis()) {
                    return false;
                }
                this.f45637f.clear();
                this.f45637f = null;
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: y */
    public final void m56906y() {
        if (this.f45638g.compareAndSet(false, true)) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<Map.Entry<String, d>> it = this.f45637f.entrySet().iterator();
            while (it.hasNext()) {
                d value = it.next().getValue();
                String[] strArrM56915c = value.m56915c();
                if (strArrM56915c != null) {
                    if (value.m56916d()) {
                        arrayList2.add(strArrM56915c);
                    } else {
                        arrayList.add(strArrM56915c);
                    }
                    value.m56917e();
                }
            }
            C2093e c2093e = new C2093e(this.f45632a);
            if (!AbstractC10706e.m65374a(arrayList)) {
                arrayList.size();
                c2093e.mo12535b(arrayList);
            }
            if (AbstractC10706e.m65374a(arrayList2)) {
                return;
            }
            arrayList2.size();
            c2093e.mo12530a(arrayList2);
        }
    }
}
