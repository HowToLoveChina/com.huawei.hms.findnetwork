package p505o0;

import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.system.ErrnoException;
import android.system.Os;
import java.io.FileDescriptor;

/* renamed from: o0.b */
/* loaded from: classes.dex */
public class C11785b {

    /* renamed from: o0.b$a */
    public static class a {
        /* renamed from: a */
        public static void m70242a(FileDescriptor fileDescriptor) throws ErrnoException {
            Os.close(fileDescriptor);
        }

        /* renamed from: b */
        public static FileDescriptor m70243b(FileDescriptor fileDescriptor) throws ErrnoException {
            return Os.dup(fileDescriptor);
        }

        /* renamed from: c */
        public static long m70244c(FileDescriptor fileDescriptor, long j10, int i10) throws ErrnoException {
            return Os.lseek(fileDescriptor, j10, i10);
        }
    }

    /* renamed from: o0.b$b */
    public static class b {
        /* renamed from: a */
        public static void m70245a(MediaMetadataRetriever mediaMetadataRetriever, MediaDataSource mediaDataSource) throws IllegalArgumentException {
            mediaMetadataRetriever.setDataSource(mediaDataSource);
        }
    }

    /* renamed from: a */
    public static String m70239a(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b10 : bArr) {
            sb2.append(String.format("%02x", Byte.valueOf(b10)));
        }
        return sb2.toString();
    }

    /* renamed from: b */
    public static long[] m70240b(Object obj) {
        if (!(obj instanceof int[])) {
            if (obj instanceof long[]) {
                return (long[]) obj;
            }
            return null;
        }
        int[] iArr = (int[]) obj;
        long[] jArr = new long[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            jArr[i10] = iArr[i10];
        }
        return jArr;
    }

    /* renamed from: c */
    public static boolean m70241c(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length < bArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 < bArr2.length; i10++) {
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
        }
        return true;
    }
}
