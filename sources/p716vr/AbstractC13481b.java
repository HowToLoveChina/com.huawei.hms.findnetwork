package p716vr;

import android.text.TextUtils;
import as.C1016d;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import p785xr.C13851a;
import p820yr.C14037a;
import p820yr.C14038b;
import tr.InterfaceC13062f;

/* renamed from: vr.b */
/* loaded from: classes8.dex */
public abstract class AbstractC13481b implements InterfaceC13062f {
    /* renamed from: b */
    public C13851a m81164b(C13851a c13851a) throws IOException {
        C1016d.m6181a("authorization", "auth request start...");
        String str = new String(c13851a.m83122b(), StandardCharsets.UTF_8);
        String strM83150c = c13851a.m83125e().m83150c("X-Request-ID");
        String strM83150c2 = c13851a.m83125e().m83150c("X-CP-Info");
        C14038b.b bVarM84220d = new C14038b.b(c13851a.m83126f(), c13851a.m83121a(), c13851a.m83127g(), strM83150c).m84219c(str).m84220d(c13851a.m83128h());
        C14037a.a aVar = new C14037a.a();
        if (!TextUtils.isEmpty(strM83150c2)) {
            aVar.m84199b("X-CP-Info", strM83150c2);
        }
        bVarM84220d.m84218b(aVar.m84198a().m84197a());
        return mo81165c(c13851a, bVarM84220d.m84217a());
    }

    /* renamed from: c */
    public abstract C13851a mo81165c(C13851a c13851a, C14038b c14038b) throws IOException;
}
