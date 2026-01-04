package p781xn;

import android.content.Context;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.util.LinkedHashMap;
import p015ak.C0209d;
import p015ak.C0211e;
import p015ak.C0213f;
import p399jk.AbstractC10896a;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;

/* renamed from: xn.e */
/* loaded from: classes6.dex */
public class C13841e extends AbstractC12367d {

    /* renamed from: a */
    public boolean f62075a;

    /* renamed from: b */
    public String f62076b;

    /* renamed from: c */
    public long f62077c;

    /* renamed from: d */
    public String f62078d;

    /* renamed from: e */
    public String f62079e;

    /* renamed from: f */
    public String f62080f;

    /* renamed from: g */
    public LinkedHashMap<String, String> f62081g;

    /* renamed from: h */
    public int f62082h;

    /* renamed from: i */
    public int f62083i;

    public C13841e(String str, String str2, String str3, String str4, LinkedHashMap<String, String> linkedHashMap, int i10, int i11) {
        this.f62075a = false;
        this.f62077c = 0L;
        this.f62076b = str;
        this.f62078d = str2;
        this.f62079e = str3;
        this.f62080f = str4;
        this.f62081g = new LinkedHashMap<>();
        if (linkedHashMap != null) {
            try {
                if (linkedHashMap.size() > 0) {
                    this.f62081g.putAll(linkedHashMap);
                }
            } catch (Exception e10) {
                AbstractC10896a.m65886e("UBAReport", "putAll exception: " + e10.toString());
            }
        }
        this.f62082h = i10;
        this.f62083i = i11;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00ac  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m83009c() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p781xn.C13841e.m83009c():void");
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws Throwable {
        if (!this.f62075a) {
            m83009c();
            return;
        }
        if (UBAAnalyze.m29984j()) {
            AbstractC10896a.m65887i("UBAReport", "currentCacheNum > 0");
            UBAAnalyze.m29997q0();
        }
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            AbstractC10896a.m65886e("UBAReport", "context is null");
            return;
        }
        if (UBAAnalyze.m29985k() && C0209d.m1333z1(contextM1377a) && UBAAnalyze.m29987l() && C0211e.m1344c().m1346b() != null) {
            AbstractC10896a.m65887i("UBAReport", "currentDataBaseNum > 0");
            UBAAnalyze.m29988l0();
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.UBA_REPORT;
    }

    public C13841e(String str, long j10, String str2, String str3, String str4, LinkedHashMap<String, String> linkedHashMap, int i10, int i11) {
        this.f62075a = false;
        this.f62076b = str;
        this.f62077c = j10;
        this.f62078d = str2;
        this.f62079e = str3;
        this.f62080f = str4;
        this.f62081g = new LinkedHashMap<>();
        if (linkedHashMap != null) {
            try {
                if (linkedHashMap.size() > 0) {
                    this.f62081g.putAll(linkedHashMap);
                }
            } catch (Exception e10) {
                AbstractC10896a.m65886e("UBAReport", "putAll exception: " + e10.toString());
            }
        }
        this.f62082h = i10;
        this.f62083i = i11;
    }

    public C13841e() {
        this.f62077c = 0L;
        this.f62075a = true;
    }
}
