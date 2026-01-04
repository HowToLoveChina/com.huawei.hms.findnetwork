package p831z3;

import com.google.crypto.tink.shaded.protobuf.C1900b0;

/* renamed from: z3.z */
/* loaded from: classes.dex */
public enum EnumC14126z implements C1900b0.c {
    UNKNOWN_STATUS(0),
    ENABLED(1),
    DISABLED(2),
    DESTROYED(3),
    UNRECOGNIZED(-1);


    /* renamed from: g */
    public static final C1900b0.d<EnumC14126z> f63151g = new C1900b0.d<EnumC14126z>() { // from class: z3.z.a
        @Override // com.google.crypto.tink.shaded.protobuf.C1900b0.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC14126z mo11497a(int i10) {
            return EnumC14126z.m84762b(i10);
        }
    };

    /* renamed from: a */
    public final int f63153a;

    EnumC14126z(int i10) {
        this.f63153a = i10;
    }

    /* renamed from: b */
    public static EnumC14126z m84762b(int i10) {
        if (i10 == 0) {
            return UNKNOWN_STATUS;
        }
        if (i10 == 1) {
            return ENABLED;
        }
        if (i10 == 2) {
            return DISABLED;
        }
        if (i10 != 3) {
            return null;
        }
        return DESTROYED;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.C1900b0.c
    /* renamed from: a0 */
    public final int mo11496a0() {
        if (this != UNRECOGNIZED) {
            return this.f63153a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
