package com.huawei.openalliance.p169ad;

import android.view.View;
import com.huawei.openalliance.p169ad.InterfaceC7337jk;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.jj */
/* loaded from: classes8.dex */
public class C7336jj<V extends InterfaceC7337jk> {

    /* renamed from: a */
    protected ContentRecord f34189a;

    /* renamed from: b */
    protected InterfaceC7615qq f34190b;

    /* renamed from: c */
    protected InterfaceC7615qq f34191c;

    /* renamed from: d */
    private V f34192d;

    /* renamed from: e */
    private Map<String, Boolean> f34193e = new HashMap();

    /* renamed from: f */
    private String f34194f;

    /* renamed from: a */
    public void m45313a(long j10) {
        ContentRecord contentRecord = this.f34189a;
        if (contentRecord == null) {
            return;
        }
        contentRecord.m41560g(j10);
        this.f34190b.mo46590a(this.f34189a);
    }

    /* renamed from: b */
    public void m45319b(long j10) {
        ContentRecord contentRecord = this.f34189a;
        if (contentRecord == null) {
            AbstractC7185ho.m43820b("BasePresenter", "contentRecord is null");
        } else if (contentRecord.m41577k() != null && this.f34189a.m41577k().equals(this.f34194f)) {
            AbstractC7185ho.m43821b("BasePresenter", "Duplicate escalation videoTime event for %s", this.f34189a.m41577k());
        } else {
            this.f34190b.mo46580a(j10);
            this.f34194f = this.f34189a.m41577k();
        }
    }

    /* renamed from: d */
    public V mo45320d() {
        return this.f34192d;
    }

    /* renamed from: e */
    public void m45321e() {
        Map<String, Boolean> map = this.f34193e;
        if (map == null) {
            return;
        }
        map.clear();
    }

    /* renamed from: f */
    public String m45322f() {
        return AbstractC7811dd.m48288a(mo45320d());
    }

    /* renamed from: g */
    public String m45323g() {
        V v10 = this.f34192d;
        if (v10 instanceof View) {
            return C8190vl.m50727b((View) v10);
        }
        return null;
    }

    /* renamed from: b */
    private boolean m45312b(String str) {
        return this.f34193e.containsKey(str) && this.f34193e.get(str).booleanValue();
    }

    /* renamed from: a */
    public void m45314a(long j10, int i10, int i11, int i12) {
        C7559ot c7559ot = new C7559ot();
        c7559ot.m46491b(Integer.valueOf(i11));
        c7559ot.m46489a(Integer.valueOf(i12));
        this.f34190b.mo46582a(j10, i10, c7559ot);
    }

    /* renamed from: a */
    public void m45315a(long j10, long j11) {
        String str;
        ContentRecord contentRecord = this.f34189a;
        if (contentRecord == null || !contentRecord.m41462aN()) {
            return;
        }
        if (j10 >= j11) {
            str = "complete";
            if (m45312b("complete")) {
                return;
            } else {
                this.f34190b.mo46638u();
            }
        } else {
            long j12 = j11 / 4;
            if (j10 > 3 * j12) {
                str = "thirdQuartile";
                if (m45312b("thirdQuartile")) {
                    return;
                } else {
                    this.f34190b.mo46636s();
                }
            } else if (j10 > j11 / 2) {
                str = "midpoint";
                if (m45312b("midpoint")) {
                    return;
                } else {
                    this.f34190b.mo46635r();
                }
            } else if (j10 > j12) {
                str = "firstQuartile";
                if (m45312b("firstQuartile")) {
                    return;
                } else {
                    this.f34190b.mo46634q();
                }
            } else {
                if (j10 <= 0) {
                    return;
                }
                str = "start";
                if (m45312b("start")) {
                    return;
                } else {
                    this.f34190b.mo46637t();
                }
            }
        }
        this.f34193e.put(str, Boolean.TRUE);
    }

    /* renamed from: a */
    public void mo45316a(V v10) {
        this.f34192d = v10;
    }

    /* renamed from: a */
    public void m45317a(InterfaceC7615qq interfaceC7615qq) {
        this.f34191c = interfaceC7615qq;
    }

    /* renamed from: a */
    public void mo45318a(String str) {
        ContentRecord contentRecord = this.f34189a;
        if (contentRecord == null) {
            return;
        }
        contentRecord.m41536c(str);
        this.f34190b.mo46590a(this.f34189a);
        m45321e();
    }
}
