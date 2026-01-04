package p680ui;

import java.io.IOException;
import ki.C11055a;

/* renamed from: ui.f */
/* loaded from: classes.dex */
public final class C13182f {
    /* renamed from: a */
    public static String m79231a(InterfaceC13180d<?> interfaceC13180d) {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('{');
            boolean z10 = true;
            for (String str : interfaceC13180d.keySet()) {
                if (z10) {
                    z10 = false;
                } else {
                    sb2.append(", ");
                }
                sb2.append(str);
                sb2.append('=');
                sb2.append(interfaceC13180d.mo79229c(str));
            }
            sb2.append('}');
            return sb2.toString();
        } catch (IOException e10) {
            throw new C11055a(e10);
        }
    }
}
