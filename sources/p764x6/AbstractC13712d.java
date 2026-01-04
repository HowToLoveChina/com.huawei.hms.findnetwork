package p764x6;

import fk.C9721b;
import p012ab.C0086a;
import p031b7.C1120a;
import p283fa.C9678a;
import p283fa.C9679b;
import p681uj.C13194k;
import p681uj.C13195l;
import p681uj.C13199p;
import p804ya.C13924a;

/* renamed from: x6.d */
/* loaded from: classes2.dex */
public abstract class AbstractC13712d<T> extends AbstractC13709a<T> {

    /* renamed from: a */
    public int f61707a;

    /* renamed from: b */
    public C13924a f61708b;

    /* renamed from: c */
    public C0086a f61709c;

    /* renamed from: d */
    public String f61710d;

    /* renamed from: e */
    public boolean f61711e = true;

    public AbstractC13712d() {
        C13924a c13924aM60445d = C9678a.m60442e().m60445d();
        this.f61708b = c13924aM60445d;
        if (c13924aM60445d == null) {
            C1120a.m6676e("CloudPhotoDriveExecutor", "cloudPhoto null");
        } else {
            this.f61709c = C9679b.m60452d().m60455e();
            this.f61707a = 200;
        }
    }

    @Override // p764x6.AbstractC13709a
    /* renamed from: a */
    public void mo80117a() {
    }

    @Override // p764x6.AbstractC13709a
    /* renamed from: b */
    public String mo80118b() throws C13199p {
        try {
            return C13195l.m79272J().m79290C("com.huawei.hidisk.cloudAlbum", "CloudPhoto", "");
        } catch (C13194k e10) {
            C1120a.m6676e("CloudPhotoDriveExecutor", "CloudPhotoDriveExecutor: " + e10.getMessage());
            return null;
        }
    }

    @Override // p764x6.AbstractC13709a
    /* renamed from: c */
    public int mo80119c() {
        return this.f61707a;
    }

    @Override // p764x6.AbstractC13709a
    /* renamed from: d */
    public T mo77941d(Class<T> cls) throws Exception {
        return null;
    }

    @Override // p764x6.AbstractC13709a
    /* renamed from: e */
    public String mo80120e() throws Exception {
        if (!mo82453g() || (this.f61708b != null && this.f61709c != null)) {
            return mo77942h();
        }
        C1120a.m6678w("CloudPhotoDriveExecutor", "Drive has not been initialized");
        throw new C9721b(4001, "drive has not been initialized");
    }

    @Override // p764x6.AbstractC13709a
    /* renamed from: f */
    public void mo80121f(boolean z10) {
    }

    /* renamed from: g */
    public boolean mo82453g() {
        return this.f61711e;
    }

    /* renamed from: h */
    public String mo77942h() throws Exception {
        return "";
    }

    /* renamed from: i */
    public void m82456i(String str) {
        this.f61710d = str;
    }

    /* renamed from: j */
    public void mo82454j(boolean z10) {
        this.f61711e = z10;
    }

    public AbstractC13712d(String str) {
        C13924a c13924aM60445d = C9678a.m60442e().m60445d();
        this.f61708b = c13924aM60445d;
        if (c13924aM60445d == null) {
            C1120a.m6676e("CloudPhotoDriveExecutor", "cloudPhoto null");
            return;
        }
        this.f61709c = C9679b.m60452d().m60455e();
        this.f61707a = 200;
        this.f61710d = str;
    }
}
