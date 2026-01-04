package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;

/* renamed from: com.google.crypto.tink.shaded.protobuf.c0 */
/* loaded from: classes.dex */
public class C1903c0 extends IOException {
    private static final long serialVersionUID = -1616151763072450476L;

    /* renamed from: a */
    public InterfaceC1951s0 f9091a;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.c0$a */
    public static class a extends C1903c0 {
        private static final long serialVersionUID = 3283890091615336259L;

        public a(String str) {
            super(str);
        }
    }

    public C1903c0(String str) {
        super(str);
        this.f9091a = null;
    }

    /* renamed from: b */
    public static C1903c0 m11502b() {
        return new C1903c0("Protocol message end-group tag did not match expected tag.");
    }

    /* renamed from: c */
    public static C1903c0 m11503c() {
        return new C1903c0("Protocol message contained an invalid tag (zero).");
    }

    /* renamed from: d */
    public static C1903c0 m11504d() {
        return new C1903c0("Protocol message had invalid UTF-8.");
    }

    /* renamed from: e */
    public static a m11505e() {
        return new a("Protocol message tag had invalid wire type.");
    }

    /* renamed from: f */
    public static C1903c0 m11506f() {
        return new C1903c0("CodedInputStream encountered a malformed varint.");
    }

    /* renamed from: g */
    public static C1903c0 m11507g() {
        return new C1903c0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* renamed from: h */
    public static C1903c0 m11508h() {
        return new C1903c0("Failed to parse the message.");
    }

    /* renamed from: j */
    public static C1903c0 m11509j() {
        return new C1903c0("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    /* renamed from: l */
    public static C1903c0 m11510l() {
        return new C1903c0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* renamed from: k */
    public C1903c0 m11511k(InterfaceC1951s0 interfaceC1951s0) {
        this.f9091a = interfaceC1951s0;
        return this;
    }
}
