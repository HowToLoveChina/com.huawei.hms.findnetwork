package p519oe;

import androidx.lifecycle.AbstractC0780b0;
import androidx.lifecycle.C0801q;
import androidx.lifecycle.LiveData;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.util.LinkedHashMap;
import p654tb.C13002a;
import p654tb.C13003b;
import p654tb.C13004c;
import p654tb.C13005d;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p771xd.C13760d;
import p771xd.C13761e;
import p771xd.C13769m;
import p771xd.C13770n;
import p771xd.C13775s;

/* renamed from: oe.a */
/* loaded from: classes3.dex */
public class C11850a extends AbstractC0780b0 {

    /* renamed from: d */
    public final C0801q<Integer> f54865d = new C0801q<>();

    /* renamed from: e */
    public final C0801q<String> f54866e = new C0801q<>();

    /* renamed from: f */
    public final C0801q<String> f54867f = new C0801q<>();

    /* renamed from: g */
    public final C0801q<String> f54868g = new C0801q<>();

    /* renamed from: h */
    public final C0801q<String> f54869h = new C0801q<>();

    /* renamed from: i */
    public final C0801q<String> f54870i = new C0801q<>();

    /* renamed from: j */
    public final C0801q<Integer> f54871j = new C0801q<>(8);

    /* renamed from: f */
    public C0801q<Integer> m70946f() {
        return this.f54871j;
    }

    /* renamed from: g */
    public LiveData<String> m70947g() {
        return this.f54867f;
    }

    /* renamed from: h */
    public C0801q<String> m70948h() {
        return this.f54869h;
    }

    /* renamed from: i */
    public LiveData<Integer> m70949i() {
        return this.f54865d;
    }

    /* renamed from: j */
    public LiveData<String> m70950j() {
        return this.f54868g;
    }

    /* renamed from: k */
    public LiveData<String> m70951k() {
        return this.f54866e;
    }

    /* renamed from: l */
    public C0801q<String> m70952l() {
        return this.f54870i;
    }

    /* renamed from: m */
    public void m70953m() {
        C13003b c13003b = new C13003b();
        c13003b.m78183g(new C13005d(C13452e.m80781L().m80790C(), C13452e.m80781L().m80887a1()));
        C13769m c13769m = new C13769m();
        c13769m.m82679a(new C13770n(c13003b));
        c13769m.m82679a(new C13775s(c13003b));
        c13769m.m82679a(new C13760d(c13003b));
        c13769m.m82679a(new C13761e(c13003b));
        C13004c c13004cM82680b = c13769m.m82680b(c13003b);
        if (c13004cM82680b == null || !c13004cM82680b.m78190e() || !c13004cM82680b.m78189d()) {
            m70955o(8);
            return;
        }
        m70955o(0);
        C13002a c13002aM78187b = c13004cM82680b.m78187b();
        this.f54865d.mo4896n(Integer.valueOf(c13002aM78187b.m78169d()));
        this.f54866e.mo4896n(c13002aM78187b.m78170e());
        this.f54867f.mo4896n(c13002aM78187b.m78166a());
        this.f54868g.mo4896n(c13002aM78187b.m78168c());
        this.f54869h.mo4896n(c13002aM78187b.m78167b());
        this.f54870i.mo4896n(c13004cM82680b.m78188c());
        m70954n(c13004cM82680b.m78188c());
    }

    /* renamed from: n */
    public final void m70954n(String str) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("userSpaceState", str);
        C13227f.m79492i1().m79567R("space_remind_card_show", linkedHashMapM79497A);
        UBAAnalyze.m29947H("PVC", "space_remind_card_show", linkedHashMapM79497A);
    }

    /* renamed from: o */
    public void m70955o(int i10) {
        this.f54871j.mo4896n(Integer.valueOf(i10));
    }
}
