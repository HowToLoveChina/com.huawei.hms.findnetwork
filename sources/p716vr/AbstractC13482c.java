package p716vr;

import android.text.TextUtils;
import as.C1016d;
import es.C9538c;
import java.io.IOException;
import p531or.C11991a;
import p688ur.C13244d;
import p688ur.C13245e;
import p785xr.C13851a;
import tr.C13065i;
import tr.InterfaceC13062f;

/* renamed from: vr.c */
/* loaded from: classes8.dex */
public abstract class AbstractC13482c implements InterfaceC13062f {
    /* renamed from: f */
    public static String m81166f() {
        String property = System.getProperty("http.agent");
        if (TextUtils.isEmpty(property)) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        int length = property.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = property.charAt(i10);
            if (cCharAt <= 31 || cCharAt >= 127) {
                sb2.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                sb2.append(cCharAt);
            }
        }
        return sb2.toString();
    }

    @Override // tr.InterfaceC13062f
    /* renamed from: a */
    public C13065i mo78788a(InterfaceC13062f.a aVar) throws C13245e, C13244d, IOException {
        C13851a.a aVarM83129i = aVar.request().m83129i();
        m81167b(aVarM83129i);
        mo81168c(aVarM83129i);
        mo81169d(aVarM83129i);
        return aVar.mo78789a(aVarM83129i.m83141k());
    }

    /* renamed from: b */
    public final void m81167b(C13851a.a aVar) {
        m81170e(aVar, "X-Device-Type", Integer.toString(C9538c.m59567f(C11991a.m72145a())));
        m81170e(aVar, "X-PhoneModel", C9538c.m59568g());
    }

    /* renamed from: c */
    public abstract void mo81168c(C13851a.a aVar);

    /* renamed from: d */
    public abstract void mo81169d(C13851a.a aVar);

    /* renamed from: e */
    public void m81170e(C13851a.a aVar, String str, String str2) {
        try {
            aVar.m83139i(str, str2);
        } catch (IllegalArgumentException | NullPointerException unused) {
            C1016d.m6181a("CommonHeadsInterceptor", "add head failed : key or value is null or illegal");
        }
    }
}
