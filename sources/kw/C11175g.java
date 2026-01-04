package kw;

import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.util.Arrays;
import java.util.List;
import p692uw.C13267j;

/* renamed from: kw.g */
/* loaded from: classes9.dex */
public class C11175g extends C11173f {
    /* renamed from: b */
    public static <T> List<T> m67142b(T[] tArr) {
        C13267j.m79677e(tArr, "<this>");
        List<T> listM67157a = C11179i.m67157a(tArr);
        C13267j.m79676d(listM67157a, "asList(this)");
        return listM67157a;
    }

    /* renamed from: c */
    public static byte[] m67143c(byte[] bArr, byte[] bArr2, int i10, int i11, int i12) {
        C13267j.m79677e(bArr, "<this>");
        C13267j.m79677e(bArr2, JsbMapKeyNames.H5_CLICK_DEST);
        System.arraycopy(bArr, i11, bArr2, i10, i12 - i11);
        return bArr2;
    }

    /* renamed from: d */
    public static final <T> T[] m67144d(T[] tArr, T[] tArr2, int i10, int i11, int i12) {
        C13267j.m79677e(tArr, "<this>");
        C13267j.m79677e(tArr2, JsbMapKeyNames.H5_CLICK_DEST);
        System.arraycopy(tArr, i11, tArr2, i10, i12 - i11);
        return tArr2;
    }

    /* renamed from: e */
    public static /* synthetic */ byte[] m67145e(byte[] bArr, byte[] bArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = bArr.length;
        }
        return m67143c(bArr, bArr2, i10, i11, i12);
    }

    /* renamed from: f */
    public static /* synthetic */ Object[] m67146f(Object[] objArr, Object[] objArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = objArr.length;
        }
        return m67144d(objArr, objArr2, i10, i11, i12);
    }

    /* renamed from: g */
    public static byte[] m67147g(byte[] bArr, int i10, int i11) {
        C13267j.m79677e(bArr, "<this>");
        C11171e.m67134a(i11, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i10, i11);
        C13267j.m79676d(bArrCopyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return bArrCopyOfRange;
    }
}
