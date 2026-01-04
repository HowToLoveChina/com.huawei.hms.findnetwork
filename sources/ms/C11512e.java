package ms;

import android.text.TextUtils;
import as.C1016d;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import p404js.InterfaceC10912a;
import p498ns.C11745a;
import p532os.C12025c;
import p588qr.C12390b;

/* renamed from: ms.e */
/* loaded from: classes8.dex */
public final class C11512e {

    /* renamed from: a */
    public InterfaceC11513f f53432a;

    public C11512e(InterfaceC10912a interfaceC10912a) throws NumberFormatException {
        InterfaceC11513f c11508a;
        int iM68713c = m68713c();
        if (iM68713c == 0) {
            c11508a = new C11508a(interfaceC10912a);
        } else if (iM68713c == 1) {
            c11508a = new C12025c(interfaceC10912a);
        } else {
            if (iM68713c != 2) {
                this.f53432a = new C11511d();
                return;
            }
            c11508a = new C11745a(interfaceC10912a);
        }
        this.f53432a = c11508a;
    }

    /* renamed from: c */
    public static int m68713c() throws NumberFormatException {
        int i10;
        String strM74462f = C12390b.m74456g().m74462f(JsbMapKeyNames.H5_LOC, "geo_position_type");
        C1016d.m6186f("ScanTask", "getConfig, model is " + strM74462f);
        if (TextUtils.isEmpty(strM74462f)) {
            i10 = 0;
        } else {
            try {
                i10 = Integer.parseInt(strM74462f);
            } catch (NumberFormatException unused) {
                C1016d.m6183c("ScanTask", "scan model parse fail, NumberFormatException");
            }
        }
        C1016d.m6186f("ScanTask", "final model is " + i10);
        return i10;
    }

    /* renamed from: a */
    public final void m68714a() {
        this.f53432a.mo68702c();
    }

    /* renamed from: b */
    public final void m68715b() {
        this.f53432a.mo68700a();
    }

    /* renamed from: d */
    public final void m68716d(long j10) {
        this.f53432a.mo68701b(j10);
    }
}
