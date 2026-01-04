package p244e1;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import p381j1.C10650d1;
import p381j1.C10664i0;
import p381j1.EnumC10653e1;
import p381j1.InterfaceC10658g0;

/* renamed from: e1.f */
/* loaded from: classes.dex */
public class C9382f implements InterfaceC10658g0 {

    /* renamed from: c */
    public static String f46794c = "/**/";

    /* renamed from: a */
    public String f46795a;

    /* renamed from: b */
    public final List<Object> f46796b = new ArrayList();

    public C9382f() {
    }

    @Override // p381j1.InterfaceC10658g0
    /* renamed from: a */
    public void mo58798a(C10664i0 c10664i0, Object obj, Type type, int i10) throws IOException {
        C10650d1 c10650d1 = c10664i0.f51258k;
        int i11 = EnumC10653e1.BrowserSecure.f51248a;
        if ((i10 & i11) != 0 || c10650d1.m65236v(i11)) {
            c10650d1.write(f46794c);
        }
        c10650d1.write(this.f46795a);
        c10650d1.write(40);
        for (int i12 = 0; i12 < this.f46796b.size(); i12++) {
            if (i12 != 0) {
                c10650d1.write(44);
            }
            c10664i0.m65262G(this.f46796b.get(i12));
        }
        c10650d1.write(41);
    }

    /* renamed from: b */
    public void m58799b(Object obj) {
        this.f46796b.add(obj);
    }

    public String toString() {
        return AbstractC9377a.m58774x(this);
    }

    public C9382f(String str) {
        this.f46795a = str;
    }
}
