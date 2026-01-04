package ax;

import java.io.IOException;
import p692uw.C13267j;
import tw.InterfaceC13086l;

/* renamed from: ax.g */
/* loaded from: classes9.dex */
public class C1037g {
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static <T> void m6256a(Appendable appendable, T t10, InterfaceC13086l<? super T, ? extends CharSequence> interfaceC13086l) throws IOException {
        C13267j.m79677e(appendable, "<this>");
        if (interfaceC13086l != null) {
            appendable.append(interfaceC13086l.mo5000c(t10));
            return;
        }
        if (t10 == 0 || (t10 instanceof CharSequence)) {
            appendable.append((CharSequence) t10);
        } else if (t10 instanceof Character) {
            appendable.append(((Character) t10).charValue());
        } else {
            appendable.append(String.valueOf(t10));
        }
    }
}
