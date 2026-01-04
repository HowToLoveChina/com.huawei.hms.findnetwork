package okhttp3.internal.connection;

import java.io.IOException;
import sx.C12875e;

/* renamed from: okhttp3.internal.connection.m */
/* loaded from: classes9.dex */
public final class C11939m extends RuntimeException {

    /* renamed from: a */
    public IOException f55433a;

    /* renamed from: b */
    public IOException f55434b;

    public C11939m(IOException iOException) {
        super(iOException);
        this.f55433a = iOException;
        this.f55434b = iOException;
    }

    /* renamed from: b */
    public void m71755b(IOException iOException) {
        C12875e.m77245b(this.f55433a, iOException);
        this.f55434b = iOException;
    }

    /* renamed from: c */
    public IOException m71756c() {
        return this.f55433a;
    }

    /* renamed from: d */
    public IOException m71757d() {
        return this.f55434b;
    }
}
