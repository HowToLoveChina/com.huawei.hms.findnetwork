package p389j9;

import p020ap.C1007b;
import p514o9.C11839m;
import p681uj.AbstractC13188e;
import p681uj.C13187d;
import p681uj.InterfaceC13186c;

/* renamed from: j9.h */
/* loaded from: classes3.dex */
public class C10742h extends AbstractC13188e implements InterfaceC13186c {

    /* renamed from: b */
    public C13187d f51389b;

    public C10742h(int i10) {
        super(i10);
        this.f51389b = new C13187d(this);
    }

    @Override // p681uj.InterfaceC13186c
    /* renamed from: a */
    public boolean mo65472a() {
        return false;
    }

    @Override // p681uj.AbstractC13188e
    /* renamed from: c */
    public String mo65468c() {
        return "com.huawei.hidisk.initparam";
    }

    @Override // p681uj.AbstractC13188e
    /* renamed from: d */
    public String mo65469d() {
        return "com.huawei.hidisk.common";
    }

    @Override // p681uj.InterfaceC13186c
    public void execute() {
        C11839m.m70688i("InitParamTrafficProcessor", "execute");
        C1007b.m5980s().m5989I();
    }

    @Override // p681uj.AbstractC13188e
    /* renamed from: f */
    public boolean mo65470f() {
        return false;
    }

    @Override // p681uj.AbstractC13188e
    /* renamed from: l */
    public void mo65471l() {
        C11839m.m70688i("InitParamTrafficProcessor", "InitParamTrafficProcessor retryInternal");
        this.f51389b.m79239c();
    }
}
