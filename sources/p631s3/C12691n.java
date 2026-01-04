package p631s3;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: s3.n */
/* loaded from: classes.dex */
public final class C12691n {

    /* renamed from: a */
    public static final CopyOnWriteArrayList<InterfaceC12690m> f58212a = new CopyOnWriteArrayList<>();

    /* renamed from: a */
    public static InterfaceC12690m m76356a(String str) throws GeneralSecurityException {
        Iterator<InterfaceC12690m> it = f58212a.iterator();
        while (it.hasNext()) {
            InterfaceC12690m next = it.next();
            if (next.mo76354a(str)) {
                return next;
            }
        }
        throw new GeneralSecurityException("No KMS client does support: " + str);
    }
}
