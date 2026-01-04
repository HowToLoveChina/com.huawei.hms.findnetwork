package p029b5;

import com.huawei.android.backup.filelogic.utils.C2111d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p029b5.C1111d;
import p029b5.C1113f;
import p029b5.C1114g;
import p029b5.C1115h;
import p029b5.C1116i;

/* renamed from: b5.c */
/* loaded from: classes.dex */
public class C1110c extends AbstractC1109b {

    /* renamed from: b */
    public a f5282b;

    /* renamed from: c */
    public String f5283c;

    /* renamed from: d */
    public String f5284d;

    /* renamed from: e */
    public AbstractC1108a f5285e;

    /* renamed from: b5.c$a */
    public static class a {

        /* renamed from: a */
        public C1111d.a f5286a;

        /* renamed from: b */
        public C1115h.a f5287b;

        /* renamed from: c */
        public C1113f.a f5288c;

        /* renamed from: d */
        public C1114g.a f5289d;

        /* renamed from: e */
        public C1116i.b f5290e;
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: a */
    public void mo6625a() {
        C1113f.a aVar;
        List<C1113f.b> list;
        C1115h.a aVar2;
        List<C1115h.b> list2;
        C1111d.a aVar3;
        List<C1111d.b> list3;
        a aVar4 = this.f5282b;
        if (aVar4 != null && (aVar3 = aVar4.f5286a) != null && (list3 = aVar3.f5294a) != null) {
            C2111d.m12654j("AppControlStrategyParser", "endDocument: file parse end, blockList size is:", Integer.valueOf(list3.size()));
        }
        a aVar5 = this.f5282b;
        if (aVar5 != null && (aVar2 = aVar5.f5287b) != null && (list2 = aVar2.f5313a) != null) {
            C2111d.m12654j("AppControlStrategyParser", "endDocument: file parse end, grayList size is:", Integer.valueOf(list2.size()));
        }
        a aVar6 = this.f5282b;
        if (aVar6 == null || (aVar = aVar6.f5288c) == null || (list = aVar.f5300a) == null) {
            return;
        }
        C2111d.m12654j("AppControlStrategyParser", "endDocument: file parse end, dependsOnCpuListInfo size is:", Integer.valueOf(list.size()));
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: b */
    public void mo6626b(String str) {
        this.f5285e.mo6626b(str);
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: c */
    public void mo6627c(String str) {
        this.f5283c = str;
        AbstractC1108a abstractC1108a = this.f5285e;
        if (abstractC1108a != null && abstractC1108a.m6619k()) {
            this.f5285e.mo6627c(str);
            return;
        }
        if ("app-control-strategy".equals(str)) {
            C2111d.m12653i("AppControlStrategyParser", "tagName is app-control-strategy, not need to special handle.");
            return;
        }
        if ("block-list".equals(str)) {
            C1111d c1111d = new C1111d();
            this.f5285e = c1111d;
            c1111d.mo6618j(this.f5282b.f5286a, str);
            return;
        }
        if ("gray-list".equals(str)) {
            C1115h c1115h = new C1115h();
            this.f5285e = c1115h;
            c1115h.mo6618j(this.f5282b.f5287b, str);
            return;
        }
        if ("depends-on-cpu-list".equals(str)) {
            C1113f c1113f = new C1113f();
            this.f5285e = c1113f;
            c1113f.mo6618j(this.f5282b.f5288c, str);
        } else if ("gms-app-list".equals(str)) {
            C1114g c1114g = new C1114g();
            this.f5285e = c1114g;
            c1114g.mo6618j(this.f5282b.f5289d, str);
        } else if ("trust-list".equals(str)) {
            C1116i c1116i = new C1116i();
            this.f5285e = c1116i;
            c1116i.mo6618j(this.f5282b.f5290e, str);
        } else {
            C1112e c1112e = new C1112e();
            this.f5285e = c1112e;
            c1112e.mo6618j(this.f5282b.f5286a, str);
        }
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: d */
    public void mo6628d(String str) {
        this.f5285e.mo6628d(str);
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: e */
    public void mo6629e() {
        a aVar = new a();
        this.f5282b = aVar;
        aVar.f5286a = new C1111d.a();
        this.f5282b.f5286a.f5294a = new ArrayList();
        this.f5282b.f5287b = new C1115h.a();
        this.f5282b.f5287b.f5313a = new ArrayList();
        this.f5282b.f5288c = new C1113f.a();
        this.f5282b.f5288c.f5300a = new ArrayList();
        this.f5282b.f5289d = new C1114g.a();
        this.f5282b.f5289d.f5307a = new ArrayList();
        this.f5282b.f5290e = new C1116i.b();
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: g */
    public void mo6630g(Map<String, String> map) {
        if (!"app-control-strategy".equals(this.f5283c)) {
            this.f5285e.mo6630g(map);
        } else if (map != null) {
            this.f5284d = map.get("version");
        }
    }

    @Override // p029b5.InterfaceC1118k
    public int getVersion() {
        try {
            return Integer.parseInt(this.f5284d);
        } catch (NumberFormatException unused) {
            C2111d.m12648d("AppControlStrategyParser", "version in xml is not a number.");
            return -1;
        }
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: h */
    public Object mo6616h() {
        return this.f5282b;
    }
}
