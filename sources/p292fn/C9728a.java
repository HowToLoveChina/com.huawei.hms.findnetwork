package p292fn;

import android.text.TextUtils;
import cn.C1461a;
import com.google.gson.Gson;
import com.huawei.hicloud.bean.ATRequestSuppressionPolicy;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import java.util.Calendar;
import java.util.LinkedHashMap;
import p015ak.C0213f;
import p015ak.C0241z;
import p429kk.C11058a;
import p429kk.C11060c;
import p525ok.C11908a;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p681uj.C13194k;
import p681uj.InterfaceC13184a;
import p709vj.C13452e;
import tn.InterfaceC13043a;

/* renamed from: fn.a */
/* loaded from: classes6.dex */
public class C9728a implements InterfaceC13184a {

    /* renamed from: a */
    public boolean f47964a;

    /* renamed from: fn.a$b */
    public static class b {

        /* renamed from: a */
        public static C9728a f47965a = new C9728a();
    }

    /* renamed from: fn.a$c */
    public static class c extends AbstractC12367d {

        /* renamed from: a */
        public String f47966a;

        public c(String str) {
            this.f47966a = str;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07047"), "07047", C13452e.m80781L().m80971t0());
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("msg", this.f47966a);
                c11060cM66626a.m66636B("AT_SUPPRESS");
                c11060cM66626a.m66665u("0");
                InterfaceC13043a interfaceC13043aM80810H = C13452e.m80781L().m80810H();
                if (interfaceC13043aM80810H != null) {
                    interfaceC13043aM80810H.mo78693d(C0213f.m1377a(), c11060cM66626a, linkedHashMap);
                }
            } catch (Exception e10) {
                C1461a.m8358e("ATSuppressionManager", "report exception: " + e10.toString());
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.STOCK_ACTIVE;
        }
    }

    /* renamed from: f */
    public static C9728a m60681f() {
        return b.f47965a;
    }

    @Override // p681uj.InterfaceC13184a
    /* renamed from: a */
    public void mo60682a() throws C13194k {
        if (!"N".equalsIgnoreCase(C13452e.m80781L().m80790C())) {
            C1461a.m8359i("ATSuppressionManager", "pay user");
            return;
        }
        String strM80934k = C13452e.m80781L().m80934k();
        String strM80925i = C13452e.m80781L().m80925i();
        int iM80930j = C13452e.m80781L().m80930j();
        int iM80920h = C13452e.m80781L().m80920h();
        if (TextUtils.isEmpty(strM80934k) || TextUtils.isEmpty(strM80925i) || iM80930j == -1 || iM80920h == -1) {
            m60691k(false);
            strM80934k = C13452e.m80781L().m80934k();
            strM80925i = C13452e.m80781L().m80925i();
            iM80930j = C13452e.m80781L().m80930j();
            iM80920h = C13452e.m80781L().m80920h();
        }
        String str = strM80934k;
        String str2 = strM80925i;
        int i10 = iM80930j;
        int i11 = iM80920h;
        try {
            String[] strArrSplit = str.split(":");
            String[] strArrSplit2 = str2.split(":");
            if (strArrSplit.length == 2 && strArrSplit2.length == 2) {
                int iM1686d = C0241z.m1686d(strArrSplit[0], -1);
                int iM1686d2 = C0241z.m1686d(strArrSplit[1], -1);
                int iM1686d3 = C0241z.m1686d(strArrSplit2[0], -1);
                int iM1686d4 = C0241z.m1686d(strArrSplit2[1], -1);
                C1461a.m8359i("ATSuppressionManager", "startTime: " + str + ", endTime: " + str2 + ", suppressRate: " + i10 + ", suppressionDuration: " + i11);
                if (!m60684c(iM1686d, iM1686d2, iM1686d3, iM1686d4, i10, i11)) {
                    C1461a.m8360w("ATSuppressionManager", "om config illegal");
                    return;
                }
                if ((iM1686d == iM1686d3 && iM1686d2 == iM1686d4) || i10 == 100 || i11 == 1440) {
                    C1461a.m8358e("ATSuppressionManager", "om config, need suppress");
                    m60692l("om config, need suppress");
                    throw new C13194k(4004, "om config, need suppress");
                }
                if (i10 == 0 || i11 == 0) {
                    C1461a.m8360w("ATSuppressionManager", "om config, no suppress");
                } else {
                    m60687g(iM1686d, iM1686d2, iM1686d3, iM1686d4, str, str2, i10, i11);
                }
            }
        } catch (Exception e10) {
            C1461a.m8358e("ATSuppressionManager", "parse time exception: " + e10.toString());
        }
    }

    /* renamed from: b */
    public final long m60683b(long j10, long j11) {
        return (j10 - j11) / 60000;
    }

    /* renamed from: c */
    public final boolean m60684c(int i10, int i11, int i12, int i13, int i14, int i15) {
        return i10 >= 0 && i10 <= 23 && i11 >= 0 && i11 <= 59 && i12 >= 0 && i12 <= 23 && i13 >= 0 && i13 <= 59 && i14 >= 0 && i14 <= 100 && i15 >= 0 && i15 <= 1440;
    }

    /* renamed from: d */
    public final int m60685d() {
        try {
            return C11908a.m71442a().nextInt(99) + 1;
        } catch (Exception e10) {
            C1461a.m8358e("ATSuppressionManager", "generateRandomInt exception: " + e10.toString());
            return -1;
        }
    }

    /* renamed from: e */
    public final ATRequestSuppressionPolicy m60686e() {
        try {
            HiCloudSysParamMap hiCloudSysParamMapM60758q = C9733f.m60705z().m60758q();
            if (hiCloudSysParamMapM60758q == null) {
                return null;
            }
            String aTRequestSuppressionPolicy = hiCloudSysParamMapM60758q.getATRequestSuppressionPolicy();
            if (TextUtils.isEmpty(aTRequestSuppressionPolicy)) {
                return null;
            }
            return (ATRequestSuppressionPolicy) new Gson().fromJson(aTRequestSuppressionPolicy, ATRequestSuppressionPolicy.class);
        } catch (Exception e10) {
            C1461a.m8358e("ATSuppressionManager", "getATRequestSuppressionPolicy exception: " + e10.toString());
            return null;
        }
    }

    /* renamed from: g */
    public final void m60687g(int i10, int i11, int i12, int i13, String str, String str2, int i14, int i15) throws C13194k {
        Calendar calendar = Calendar.getInstance();
        int i16 = calendar.get(11);
        int i17 = calendar.get(12);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jM80915g = C13452e.m80781L().m80915g();
        if (jM80915g != 0) {
            long jM60683b = m60683b(jCurrentTimeMillis, jM80915g);
            C1461a.m8359i("ATSuppressionManager", "atSuppressionBeginTime: " + jM80915g + ", diffMinute: " + jM60683b);
            if (jM60683b > i15) {
                C13452e.m80781L().m80796D1(0L);
                return;
            }
        } else {
            int iM60685d = m60685d();
            C1461a.m8359i("ATSuppressionManager", "randomNum: " + iM60685d);
            if (iM60685d == -1 || iM60685d > i14) {
                return;
            }
        }
        if (i10 == i12) {
            m60688h(i10, i11, i12, i13, i16, i17, jCurrentTimeMillis);
        } else if (i10 < i12) {
            m60689i(i10, i11, i12, i13, i16, i17, jCurrentTimeMillis);
        } else {
            m60690j(i10, i11, i12, i13, i16, i17, jCurrentTimeMillis);
        }
        C1461a.m8359i("ATSuppressionManager", "not suppress");
        C13452e.m80781L().m80796D1(0L);
    }

    /* renamed from: h */
    public final void m60688h(int i10, int i11, int i12, int i13, int i14, int i15, long j10) throws C13194k {
        if (i11 < i13) {
            if (i14 != i10 || i15 < i11 || i15 > i13) {
                return;
            }
            C13452e.m80781L().m80796D1(j10);
            C1461a.m8358e("ATSuppressionManager", "AT suppress branch one");
            m60692l("AT suppress branch one");
            throw new C13194k(4004, "AT suppress branch one");
        }
        if (i14 != i10) {
            C13452e.m80781L().m80796D1(j10);
            C1461a.m8358e("ATSuppressionManager", "AT suppress branch two");
            m60692l("AT suppress branch two");
            throw new C13194k(4004, "AT suppress branch two");
        }
        if (i15 < i13 || i15 > i11) {
            C13452e.m80781L().m80796D1(j10);
            C1461a.m8358e("ATSuppressionManager", "AT suppress branch three");
            m60692l("AT suppress branch three");
            throw new C13194k(4004, "AT suppress branch three");
        }
    }

    /* renamed from: i */
    public final void m60689i(int i10, int i11, int i12, int i13, int i14, int i15, long j10) throws C13194k {
        if (i14 == i10) {
            if (i15 < i11) {
                return;
            }
            C13452e.m80781L().m80796D1(j10);
            C1461a.m8358e("ATSuppressionManager", "AT suppress branch four");
            m60692l("AT suppress branch four");
            throw new C13194k(4004, "AT suppress branch four");
        }
        if (i14 == i12) {
            if (i15 >= i13) {
                return;
            }
            C13452e.m80781L().m80796D1(j10);
            C1461a.m8358e("ATSuppressionManager", "AT suppress branch five");
            m60692l("AT suppress branch five");
            throw new C13194k(4004, "AT suppress branch five");
        }
        if (i14 <= i10 || i14 >= i12) {
            return;
        }
        C13452e.m80781L().m80796D1(j10);
        C1461a.m8358e("ATSuppressionManager", "AT suppress branch six");
        m60692l("AT suppress branch six");
        throw new C13194k(4004, "AT suppress branch six");
    }

    /* renamed from: j */
    public final void m60690j(int i10, int i11, int i12, int i13, int i14, int i15, long j10) throws C13194k {
        if (i14 == i10) {
            if (i15 < i11) {
                return;
            }
            C13452e.m80781L().m80796D1(j10);
            C1461a.m8358e("ATSuppressionManager", "AT suppress branch seven");
            m60692l("AT suppress branch seven");
            throw new C13194k(4004, "AT suppress branch seven");
        }
        if (i14 == i12) {
            if (i15 >= i13) {
                return;
            }
            C13452e.m80781L().m80796D1(j10);
            C1461a.m8358e("ATSuppressionManager", "AT suppress branch eight");
            m60692l("AT suppress branch eight");
            throw new C13194k(4004, "AT suppress branch eight");
        }
        if (i14 < i12 || i14 > i10) {
            C13452e.m80781L().m80796D1(j10);
            C1461a.m8358e("ATSuppressionManager", "AT suppress branch nine");
            m60692l("AT suppress branch nine");
            throw new C13194k(4004, "AT suppress branch nine");
        }
    }

    /* renamed from: k */
    public void m60691k(boolean z10) {
        if (z10 || !this.f47964a) {
            this.f47964a = true;
            ATRequestSuppressionPolicy aTRequestSuppressionPolicyM60686e = m60686e();
            if (aTRequestSuppressionPolicyM60686e == null) {
                C1461a.m8358e("ATSuppressionManager", "atRequestSuppressionPolicy is null");
                return;
            }
            String startTime = aTRequestSuppressionPolicyM60686e.getStartTime();
            String endTime = aTRequestSuppressionPolicyM60686e.getEndTime();
            int suppressRate = aTRequestSuppressionPolicyM60686e.getSuppressRate();
            int suppressDuration = aTRequestSuppressionPolicyM60686e.getSuppressDuration();
            C13452e.m80781L().m80812H1(startTime);
            C13452e.m80781L().m80804F1(endTime);
            C13452e.m80781L().m80808G1(suppressRate);
            C13452e.m80781L().m80800E1(suppressDuration);
        }
    }

    /* renamed from: l */
    public final void m60692l(String str) {
        C12515a.m75110o().m75172d(new c(str));
    }

    public C9728a() {
        this.f47964a = false;
    }
}
