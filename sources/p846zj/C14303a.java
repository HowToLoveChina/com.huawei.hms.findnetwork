package p846zj;

import com.huawei.hicloud.notification.constants.NotifyConstants;
import p015ak.C0212e0;
import p015ak.C0213f;
import p399jk.AbstractC10896a;

/* renamed from: zj.a */
/* loaded from: classes5.dex */
public class C14303a {

    /* renamed from: a */
    public static final C14303a f63561a = new C14303a();

    /* renamed from: a */
    public static C14303a m85185a() {
        return f63561a;
    }

    /* renamed from: b */
    public long m85186b() {
        return C0212e0.m1360j(C0213f.m1377a(), "account_common", "client_version", 0L);
    }

    /* renamed from: c */
    public int m85187c() {
        return C0212e0.m1358h(C0213f.m1377a(), "account_common", "red_point_count", 0);
    }

    /* renamed from: d */
    public long m85188d() {
        return C0212e0.m1360j(C0213f.m1377a(), "account_common", "set_red_point_update_time", 0L);
    }

    /* renamed from: e */
    public long m85189e() {
        return C0212e0.m1360j(C0213f.m1377a(), "account_common", "desktop_notify_time", 0L);
    }

    /* renamed from: f */
    public long m85190f() {
        return C0212e0.m1360j(C0213f.m1377a(), "account_common", NotifyConstants.ST_INVALID_NOTIFY_TIME, 0L);
    }

    /* renamed from: g */
    public boolean m85191g() {
        return C0212e0.m1355e(C0213f.m1377a(), "account_common", "is_network_term_agreed", false);
    }

    /* renamed from: h */
    public boolean m85192h() {
        return C0212e0.m1355e(C0213f.m1377a(), "account_common", "red_point_flag", false);
    }

    /* renamed from: i */
    public void m85193i(boolean z10) {
        AbstractC10896a.m65887i("AccountCommonSp", "setAgreedNetworkTerm: " + z10);
        C0212e0.m1366p(C0213f.m1377a(), "account_common", "is_network_term_agreed", z10);
    }

    /* renamed from: j */
    public void m85194j(boolean z10) {
        AbstractC10896a.m65887i("AccountCommonSp", "setRedPointFlag: " + z10);
        C0212e0.m1366p(C0213f.m1377a(), "account_common", "red_point_flag", z10);
    }

    /* renamed from: k */
    public void m85195k() {
        AbstractC10896a.m65885d("AccountCommonSp", "setRedPointUpdateTime");
        C0212e0.m1371u(C0213f.m1377a(), "account_common", "set_red_point_update_time", System.currentTimeMillis());
    }

    /* renamed from: l */
    public void m85196l(long j10) {
        C0212e0.m1371u(C0213f.m1377a(), "account_common", "desktop_notify_time", j10);
    }

    /* renamed from: m */
    public void m85197m(long j10) {
        C0212e0.m1371u(C0213f.m1377a(), "account_common", NotifyConstants.ST_INVALID_NOTIFY_TIME, j10);
    }

    /* renamed from: n */
    public void m85198n(long j10) {
        AbstractC10896a.m65887i("AccountCommonSp", "updateClientVersion: " + j10);
        C0212e0.m1371u(C0213f.m1377a(), "account_common", "client_version", j10);
    }

    /* renamed from: o */
    public void m85199o() {
        int iM85187c = m85187c() + 1;
        AbstractC10896a.m65885d("AccountCommonSp", "updateRedPointCount: " + iM85187c);
        C0212e0.m1369s(C0213f.m1377a(), "account_common", "red_point_count", iM85187c);
    }
}
