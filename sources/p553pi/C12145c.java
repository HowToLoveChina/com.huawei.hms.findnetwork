package p553pi;

import com.huawei.cloud.base.http.C4612o;
import com.huawei.cloud.base.http.C4615r;
import com.huawei.cloud.base.http.InterfaceC4610m;
import com.huawei.cloud.base.http.InterfaceC4620w;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.InterfaceC4629b0;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import p553pi.C12144b;

/* renamed from: pi.c */
/* loaded from: classes.dex */
public class C12145c implements InterfaceC4610m, InterfaceC4620w {

    /* renamed from: e */
    public static final Logger f56344e = Logger.getLogger(C12145c.class.getName());

    /* renamed from: a */
    public long f56345a = 1;

    /* renamed from: b */
    public final C12144b.b f56346b;

    /* renamed from: c */
    public final InterfaceC4610m f56347c;

    /* renamed from: d */
    public final InterfaceC4620w f56348d;

    public C12145c(C12144b.b bVar, C4612o c4612o) {
        this.f56346b = (C12144b.b) C4627a0.m28391d(bVar);
        this.f56347c = c4612o.m28278j();
        this.f56348d = c4612o.m28287s();
        c4612o.m28294z(this);
        c4612o.m28267H(this);
    }

    /* renamed from: c */
    public static boolean m72857c(C4615r c4615r) {
        int iM28311h = c4615r.m28311h();
        return iM28311h == 401 || iM28311h == 429 || iM28311h == 500 || iM28311h == 502 || iM28311h == 503 || iM28311h == 504;
    }

    @Override // com.huawei.cloud.base.http.InterfaceC4610m
    /* renamed from: a */
    public boolean mo28245a(C4612o c4612o, boolean z10) throws IOException {
        InterfaceC4610m interfaceC4610m = this.f56347c;
        boolean zMo28245a = interfaceC4610m != null ? interfaceC4610m.mo28245a(c4612o, z10) : true;
        if (zMo28245a) {
            try {
                this.f56346b.m72853j();
            } catch (IOException e10) {
                f56344e.log(Level.WARNING, "exception thrown while calling server callback" + e10.getMessage());
            }
        }
        return zMo28245a;
    }

    @Override // com.huawei.cloud.base.http.InterfaceC4620w
    /* renamed from: b */
    public boolean mo28334b(C4612o c4612o, C4615r c4615r, boolean z10) throws IOException {
        InterfaceC4620w interfaceC4620w = this.f56348d;
        if (interfaceC4620w != null) {
            interfaceC4620w.mo28334b(c4612o, c4615r, z10);
        }
        boolean zM72857c = m72857c(c4615r);
        if (z10 && zM72857c) {
            try {
                this.f56346b.m72853j();
                InterfaceC4629b0.f21264a.mo28401a(this.f56345a * 10000);
                this.f56345a++;
                return true;
            } catch (Exception e10) {
                f56344e.log(Level.WARNING, "exception thrown while calling server callback" + e10.getMessage());
            }
        }
        return false;
    }
}
