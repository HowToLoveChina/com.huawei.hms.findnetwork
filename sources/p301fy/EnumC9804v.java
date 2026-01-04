package p301fy;

import com.huawei.hms.network.okhttp.PublicSuffixDatabase;
import java.util.Arrays;

/* renamed from: fy.v */
/* loaded from: classes9.dex */
public enum EnumC9804v {
    COPY(new byte[]{0}),
    LZMA(new byte[]{3, 1, 1}),
    LZMA2(new byte[]{PublicSuffixDatabase.f29565i}),
    DEFLATE(new byte[]{4, 1, 8}),
    DEFLATE64(new byte[]{4, 1, 9}),
    BZIP2(new byte[]{4, 2, 2}),
    AES256SHA256(new byte[]{6, -15, 7, 1}),
    BCJ_X86_FILTER(new byte[]{3, 3, 1, 3}),
    BCJ_PPC_FILTER(new byte[]{3, 3, 2, 5}),
    BCJ_IA64_FILTER(new byte[]{3, 3, 4, 1}),
    BCJ_ARM_FILTER(new byte[]{3, 3, 5, 1}),
    BCJ_ARM_THUMB_FILTER(new byte[]{3, 3, 7, 1}),
    BCJ_SPARC_FILTER(new byte[]{3, 3, 8, 5}),
    DELTA_FILTER(new byte[]{3});


    /* renamed from: a */
    public final byte[] f48217a;

    EnumC9804v(byte[] bArr) {
        this.f48217a = bArr;
    }

    /* renamed from: e */
    public static EnumC9804v m60983e(byte[] bArr) {
        for (EnumC9804v enumC9804v : (EnumC9804v[]) EnumC9804v.class.getEnumConstants()) {
            if (Arrays.equals(enumC9804v.f48217a, bArr)) {
                return enumC9804v;
            }
        }
        return null;
    }
}
