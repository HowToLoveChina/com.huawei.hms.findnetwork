package p831z3;

import com.google.crypto.tink.shaded.protobuf.C1900b0;

/* renamed from: z3.u */
/* loaded from: classes.dex */
public enum EnumC14121u implements C1900b0.c {
    UNKNOWN_HASH(0),
    SHA1(1),
    SHA384(2),
    SHA256(3),
    SHA512(4),
    UNRECOGNIZED(-1);


    /* renamed from: h */
    public static final C1900b0.d<EnumC14121u> f63130h = new C1900b0.d<EnumC14121u>() { // from class: z3.u.a
        @Override // com.google.crypto.tink.shaded.protobuf.C1900b0.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC14121u mo11497a(int i10) {
            return EnumC14121u.m84718b(i10);
        }
    };

    /* renamed from: a */
    public final int f63132a;

    EnumC14121u(int i10) {
        this.f63132a = i10;
    }

    /* renamed from: b */
    public static EnumC14121u m84718b(int i10) {
        if (i10 == 0) {
            return UNKNOWN_HASH;
        }
        if (i10 == 1) {
            return SHA1;
        }
        if (i10 == 2) {
            return SHA384;
        }
        if (i10 == 3) {
            return SHA256;
        }
        if (i10 != 4) {
            return null;
        }
        return SHA512;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.C1900b0.c
    /* renamed from: a0 */
    public final int mo11496a0() {
        if (this != UNRECOGNIZED) {
            return this.f63132a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
