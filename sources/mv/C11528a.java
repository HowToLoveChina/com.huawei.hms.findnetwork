package mv;

/* renamed from: mv.a */
/* loaded from: classes9.dex */
public final class SafeBytes {
    /* renamed from: a */
    public static byte[] doClone(byte[] bArr) {
        return bArr == null ? new byte[0] : (byte[]) bArr.clone();
    }
}
