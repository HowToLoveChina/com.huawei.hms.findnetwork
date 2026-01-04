package p572qb;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import fk.C9721b;
import java.util.HashMap;
import p015ak.C0213f;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p608rb.C12485a;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;

/* renamed from: qb.a */
/* loaded from: classes3.dex */
public class C12297a {

    /* renamed from: h */
    public static final HashMap<String, C12485a> f56972h = new HashMap<>();

    /* renamed from: a */
    public long f56973a;

    /* renamed from: b */
    public long f56974b;

    /* renamed from: c */
    public long f56975c;

    /* renamed from: d */
    public d f56976d;

    /* renamed from: e */
    public d f56977e;

    /* renamed from: f */
    public d f56978f;

    /* renamed from: g */
    public Handler f56979g;

    /* renamed from: qb.a$b */
    public static class b extends AbstractC12367d {

        /* renamed from: a */
        public final String f56980a;

        public b(String str) {
            this.f56980a = str;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C11839m.m70688i("CloudAlbumPowerKitManager", "AsyncApplyTask");
            C12297a.m73908c().m73916i(this.f56980a);
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.ALBUM_FIX;
        }
    }

    /* renamed from: qb.a$c */
    public static class c {

        /* renamed from: a */
        public static final C12297a f56981a = new C12297a();
    }

    /* renamed from: qb.a$d */
    public static class d implements Runnable {

        /* renamed from: a */
        public final String f56982a;

        public d(String str) {
            this.f56982a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            C12515a.m75110o().m75175e(new b(this.f56982a), false);
        }
    }

    /* renamed from: c */
    public static C12297a m73908c() {
        return c.f56981a;
    }

    /* renamed from: a */
    public synchronized void m73909a(String str, C12485a c12485a) {
        try {
            if (!TextUtils.isEmpty(str) && c12485a != null) {
                HashMap<String, C12485a> map = f56972h;
                if (!map.containsKey(str)) {
                    C11839m.m70688i("CloudAlbumPowerKitManager", "applyPowerKit add applyType:" + str);
                    map.put(str, c12485a);
                } else {
                    if (!m73913f(str)) {
                        C11839m.m70688i("CloudAlbumPowerKitManager", "applyPowerKit no need applyType:" + str);
                        return;
                    }
                    C11839m.m70688i("CloudAlbumPowerKitManager", "applyPowerKit update applyType:" + str);
                }
                C12315j.m74059f().m74060c("com.huawei.hidisk", m73910b(str), str);
                m73914g(str);
                m73917j(str);
                return;
            }
            C11839m.m70687e("CloudAlbumPowerKitManager", "applyPowerKit applyType is null or apply is null");
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: b */
    public final long m73910b(String str) {
        return "auto-album-sync_apply".equals(str) ? 900000L : 1800000L;
    }

    /* renamed from: d */
    public final long m73911d(String str) {
        return "auto-album-sync_apply".equals(str) ? 600000L : 1200000L;
    }

    /* renamed from: e */
    public final d m73912e(String str) {
        if ("auto-album-sync_apply".equals(str)) {
            if (this.f56976d == null) {
                this.f56976d = new d("auto-album-sync_apply");
            }
            return this.f56976d;
        }
        if ("user-sync_apply".equals(str)) {
            if (this.f56977e == null) {
                this.f56977e = new d("user-sync_apply");
            }
            return this.f56977e;
        }
        if (!"user-download_apply".equals(str)) {
            return null;
        }
        if (this.f56978f == null) {
            this.f56978f = new d("user-download_apply");
        }
        return this.f56978f;
    }

    /* renamed from: f */
    public boolean m73913f(String str) {
        return "auto-album-sync_apply".equals(str) ? System.currentTimeMillis() - this.f56973a > 600000 : "user-sync_apply".equals(str) ? System.currentTimeMillis() - this.f56974b > 1200000 : "user-download_apply".equals(str) && System.currentTimeMillis() - this.f56975c > 1200000;
    }

    /* renamed from: g */
    public final void m73914g(String str) {
        if ("auto-album-sync_apply".equals(str)) {
            this.f56973a = System.currentTimeMillis();
        } else if ("user-sync_apply".equals(str)) {
            this.f56974b = System.currentTimeMillis();
        } else if ("user-download_apply".equals(str)) {
            this.f56975c = System.currentTimeMillis();
        }
    }

    /* renamed from: h */
    public synchronized void m73915h(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("CloudAlbumPowerKitManager", "removeApply applyType is null");
            return;
        }
        HashMap<String, C12485a> map = f56972h;
        if (map.containsKey(str)) {
            map.remove(str);
            C12315j.m74059f().m74071o("com.huawei.hidisk", str);
        } else {
            C11839m.m70688i("CloudAlbumPowerKitManager", "no need removeApply:" + str);
        }
    }

    /* renamed from: i */
    public synchronized void m73916i(String str) {
        HashMap<String, C12485a> map = f56972h;
        if (!map.containsKey(str)) {
            C11839m.m70688i("CloudAlbumPowerKitManager", "startApplyTask applyType: " + str + " has removed");
            return;
        }
        C12485a c12485a = map.get(str);
        if (c12485a != null && c12485a.mo7208a(C0213f.m1377a())) {
            C11839m.m70688i("CloudAlbumPowerKitManager", "startApplyTask applyType: " + str);
            C12315j.m74059f().m74060c("com.huawei.hidisk", m73910b(str), str);
            m73914g(str);
            m73917j(str);
            return;
        }
        C11839m.m70688i("CloudAlbumPowerKitManager", "startApplyTask applyType: " + str + " no need apply again");
    }

    /* renamed from: j */
    public final void m73917j(String str) {
        d dVarM73912e = m73912e(str);
        if (dVarM73912e == null) {
            return;
        }
        if (this.f56979g == null) {
            this.f56979g = new Handler(Looper.getMainLooper());
        }
        this.f56979g.removeCallbacks(dVarM73912e);
        long jM73911d = m73911d(str);
        C11839m.m70688i("CloudAlbumPowerKitManager", "startTimerTask applyType:" + str + ", duration:" + jM73911d);
        this.f56979g.postDelayed(dVarM73912e, jM73911d);
    }

    public C12297a() {
        this.f56973a = 0L;
        this.f56974b = 0L;
        this.f56975c = 0L;
    }
}
