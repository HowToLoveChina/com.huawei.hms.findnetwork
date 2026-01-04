package p681uj;

import p015ak.C0212e0;
import p015ak.C0213f;

/* renamed from: uj.e */
/* loaded from: classes5.dex */
public abstract class AbstractC13188e {

    /* renamed from: a */
    public int f59720a;

    public AbstractC13188e(int i10) {
        this.f59720a = i10;
    }

    /* renamed from: b */
    public final void m79241b() {
        mo65471l();
        m79245i();
        m79246j();
    }

    /* renamed from: c */
    public abstract String mo65468c();

    /* renamed from: d */
    public abstract String mo65469d();

    /* renamed from: e */
    public boolean m79242e() {
        return C0212e0.m1355e(C0213f.m1377a(), "at_traffic_control", "id_" + mo65468c() + "_failed", false);
    }

    /* renamed from: f */
    public abstract boolean mo65470f();

    /* renamed from: g */
    public void m79243g() {
        m79244h();
        if (this.f59720a == 1) {
            m79247k();
        }
    }

    /* renamed from: h */
    public void m79244h() {
        C0212e0.m1366p(C0213f.m1377a(), "at_traffic_control", "id_" + mo65468c() + "_failed", true);
    }

    /* renamed from: i */
    public void m79245i() {
        int iM1358h = C0212e0.m1358h(C0213f.m1377a(), "at_traffic_control", "retry_count_" + mo65468c(), 0);
        C0212e0.m1369s(C0213f.m1377a(), "at_traffic_control", "retry_count_" + mo65468c(), iM1358h + 1);
    }

    /* renamed from: j */
    public void m79246j() {
        C0212e0.m1366p(C0213f.m1377a(), "at_traffic_control", "id_" + mo65468c() + "_failed", false);
    }

    /* renamed from: k */
    public void m79247k() {
        if (m79242e()) {
            m79241b();
        }
    }

    /* renamed from: l */
    public abstract void mo65471l();
}
