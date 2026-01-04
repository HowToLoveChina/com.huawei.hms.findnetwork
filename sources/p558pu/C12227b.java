package p558pu;

import su.C12859a;
import su.C12860b;

/* renamed from: pu.b */
/* loaded from: classes9.dex */
public class C12227b extends RuntimeException {

    /* renamed from: a */
    public int f56606a;

    public C12227b(int i10) {
        super(C12859a.m77196c(i10));
        this.f56606a = i10;
    }

    /* renamed from: b */
    public static C12227b m73420b(IllegalStateException illegalStateException) {
        if (illegalStateException != null) {
            return new C12227b(C12859a.m77194a(illegalStateException.getMessage()));
        }
        C12860b.m77197a("WearEngineException", "convertIllegalStateException IllegalStateException is null");
        return new C12227b(1);
    }

    /* renamed from: c */
    public int m73421c() {
        return this.f56606a;
    }
}
