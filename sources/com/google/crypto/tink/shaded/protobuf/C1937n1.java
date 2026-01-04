package com.google.crypto.tink.shaded.protobuf;

import java.util.List;

/* renamed from: com.google.crypto.tink.shaded.protobuf.n1 */
/* loaded from: classes.dex */
public class C1937n1 extends RuntimeException {
    private static final long serialVersionUID = -7466929953374883507L;

    /* renamed from: a */
    public final List<String> f9232a;

    public C1937n1(InterfaceC1951s0 interfaceC1951s0) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.f9232a = null;
    }

    /* renamed from: b */
    public C1903c0 m12057b() {
        return new C1903c0(getMessage());
    }
}
