package com.google.crypto.tink.shaded.protobuf;

import com.huawei.openalliance.p169ad.constant.Constants;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.crypto.tink.shaded.protobuf.b0 */
/* loaded from: classes.dex */
public final class C1900b0 {

    /* renamed from: a */
    public static final Charset f9085a = Charset.forName(Constants.UTF_8);

    /* renamed from: b */
    public static final Charset f9086b = Charset.forName("ISO-8859-1");

    /* renamed from: c */
    public static final byte[] f9087c;

    /* renamed from: d */
    public static final ByteBuffer f9088d;

    /* renamed from: e */
    public static final AbstractC1923j f9089e;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.b0$a */
    public interface a extends i<Boolean> {
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.b0$b */
    public interface b extends i<Double> {
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.b0$c */
    public interface c {
        /* renamed from: a0 */
        int mo11496a0();
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.b0$d */
    public interface d<T extends c> {
        /* renamed from: a */
        T mo11497a(int i10);
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.b0$e */
    public interface e {
        /* renamed from: a */
        boolean m11498a(int i10);
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.b0$f */
    public interface f extends i<Float> {
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.b0$g */
    public interface g extends i<Integer> {
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.b0$h */
    public interface h extends i<Long> {
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.b0$i */
    public interface i<E> extends List<E>, RandomAccess {
        /* renamed from: b0 */
        boolean mo11499b0();

        /* renamed from: s */
        void mo11500s();

        /* renamed from: v */
        i<E> mo11479v(int i10);
    }

    static {
        byte[] bArr = new byte[0];
        f9087c = bArr;
        f9088d = ByteBuffer.wrap(bArr);
        f9089e = AbstractC1923j.m11721f(bArr);
    }

    /* renamed from: a */
    public static <T> T m11486a(T t10) {
        t10.getClass();
        return t10;
    }

    /* renamed from: b */
    public static <T> T m11487b(T t10, String str) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(str);
    }

    /* renamed from: c */
    public static int m11488c(boolean z10) {
        return z10 ? 1231 : 1237;
    }

    /* renamed from: d */
    public static int m11489d(byte[] bArr) {
        return m11490e(bArr, 0, bArr.length);
    }

    /* renamed from: e */
    public static int m11490e(byte[] bArr, int i10, int i11) {
        int iM11494i = m11494i(i11, bArr, i10, i11);
        if (iM11494i == 0) {
            return 1;
        }
        return iM11494i;
    }

    /* renamed from: f */
    public static int m11491f(long j10) {
        return (int) (j10 ^ (j10 >>> 32));
    }

    /* renamed from: g */
    public static boolean m11492g(byte[] bArr) {
        return C1955t1.m12222m(bArr);
    }

    /* renamed from: h */
    public static Object m11493h(Object obj, Object obj2) {
        return ((InterfaceC1951s0) obj).mo12138d().mo11466h((InterfaceC1951s0) obj2).mo12143I();
    }

    /* renamed from: i */
    public static int m11494i(int i10, byte[] bArr, int i11, int i12) {
        for (int i13 = i11; i13 < i11 + i12; i13++) {
            i10 = (i10 * 31) + bArr[i13];
        }
        return i10;
    }

    /* renamed from: j */
    public static String m11495j(byte[] bArr) {
        return new String(bArr, f9085a);
    }
}
