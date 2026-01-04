package ls;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import as.C1016d;
import com.huawei.location.nlp.network.request.cell.CellSourceInfo;
import com.huawei.location.nlp.network.request.wifi.WifiInfo;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import p588qr.C12390b;

/* renamed from: ls.a */
/* loaded from: classes8.dex */
public final class C11340a {

    /* renamed from: g */
    public static final byte[] f53048g = new byte[0];

    /* renamed from: h */
    public static volatile C11340a f53049h;

    /* renamed from: a */
    public long f53050a;

    /* renamed from: b */
    public long f53051b;

    /* renamed from: c */
    public List<CellSourceInfo> f53052c = new ArrayList();

    /* renamed from: d */
    public List<WifiInfo> f53053d = new ArrayList();

    /* renamed from: e */
    public long f53054e = 0;

    /* renamed from: f */
    public long f53055f = 0;

    public C11340a() {
        this.f53050a = 30000L;
        this.f53051b = 30000L;
        String strM74462f = C12390b.m74456g().m74462f(JsbMapKeyNames.H5_LOC, "valid_wifi_position_time");
        if (!TextUtils.isEmpty(strM74462f)) {
            C1016d.m6181a("NLPCacheManger", "get valid wifi time " + strM74462f);
            this.f53050a = TimeUnit.SECONDS.toMillis((long) Integer.parseInt(strM74462f));
        }
        String strM74462f2 = C12390b.m74456g().m74462f(JsbMapKeyNames.H5_LOC, "valid_cell_position_time");
        if (TextUtils.isEmpty(strM74462f2)) {
            return;
        }
        C1016d.m6181a("NLPCacheManger", "get valid cell time " + strM74462f2);
        this.f53051b = TimeUnit.SECONDS.toMillis((long) Integer.parseInt(strM74462f2));
    }

    /* renamed from: g */
    public static C11340a m68129g() {
        if (f53049h == null) {
            synchronized (f53048g) {
                try {
                    if (f53049h == null) {
                        f53049h = new C11340a();
                    }
                } finally {
                }
            }
        }
        return f53049h;
    }

    /* renamed from: a */
    public final List<WifiInfo> m68130a() {
        return this.f53053d;
    }

    /* renamed from: b */
    public final synchronized List<CellSourceInfo> m68131b() {
        return this.f53052c;
    }

    /* renamed from: c */
    public final synchronized long m68132c() {
        return this.f53055f;
    }

    /* renamed from: d */
    public final void m68133d(Pair<Long, List<WifiInfo>> pair) {
        this.f53054e = ((Long) pair.first).longValue();
        this.f53053d = (List) pair.second;
    }

    /* renamed from: e */
    public final boolean m68134e() {
        List<WifiInfo> list = this.f53053d;
        if (list != null && !list.isEmpty()) {
            return SystemClock.elapsedRealtime() - this.f53054e < this.f53050a;
        }
        C1016d.m6183c("NLPCacheManger", "wifiInfoList is empty");
        return false;
    }

    /* renamed from: f */
    public final long m68135f() {
        return TimeUnit.MILLISECONDS.toNanos(this.f53054e);
    }

    /* renamed from: h */
    public final synchronized void m68136h(Pair<Long, List<CellSourceInfo>> pair) {
        this.f53055f = ((Long) pair.first).longValue();
        this.f53052c = (List) pair.second;
    }

    /* renamed from: i */
    public final synchronized boolean m68137i() {
        List<CellSourceInfo> list = this.f53052c;
        if (list != null && !list.isEmpty()) {
            return SystemClock.elapsedRealtime() - (this.f53055f / 1000000) < this.f53051b;
        }
        C1016d.m6183c("NLPCacheManger", "cellInfoList is empty");
        return false;
    }
}
