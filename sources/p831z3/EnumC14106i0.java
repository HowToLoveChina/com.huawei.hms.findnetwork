package p831z3;

import com.google.crypto.tink.shaded.protobuf.C1900b0;

/* renamed from: z3.i0 */
/* loaded from: classes.dex */
public enum EnumC14106i0 implements C1900b0.c {
    UNKNOWN_PREFIX(0),
    TINK(1),
    LEGACY(2),
    RAW(3),
    CRUNCHY(4),
    UNRECOGNIZED(-1);


    /* renamed from: h */
    public static final C1900b0.d<EnumC14106i0> f63107h = new C1900b0.d<EnumC14106i0>() { // from class: z3.i0.a
        @Override // com.google.crypto.tink.shaded.protobuf.C1900b0.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC14106i0 mo11497a(int i10) {
            return EnumC14106i0.m84621b(i10);
        }
    };

    /* renamed from: a */
    public final int f63109a;

    EnumC14106i0(int i10) {
        this.f63109a = i10;
    }

    /* renamed from: b */
    public static EnumC14106i0 m84621b(int i10) {
        if (i10 == 0) {
            return UNKNOWN_PREFIX;
        }
        if (i10 == 1) {
            return TINK;
        }
        if (i10 == 2) {
            return LEGACY;
        }
        if (i10 == 3) {
            return RAW;
        }
        if (i10 != 4) {
            return null;
        }
        return CRUNCHY;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.C1900b0.c
    /* renamed from: a0 */
    public final int mo11496a0() {
        if (this != UNRECOGNIZED) {
            return this.f63109a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
