package p035bk;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import p399jk.AbstractC10896a;

/* renamed from: bk.a */
/* loaded from: classes6.dex */
public class C1248a {
    /* renamed from: a */
    public static Bitmap m7470a(byte[] bArr, int i10, int i11) {
        return m7471b(bArr, i10, i11, null);
    }

    /* renamed from: b */
    public static Bitmap m7471b(byte[] bArr, int i10, int i11, BitmapFactory.Options options) {
        if (bArr == null || bArr.length == 0) {
            AbstractC10896a.m65888w("BitmapUtils", "decodeByteArray data is null or empty!");
            return null;
        }
        try {
            return BitmapFactory.decodeByteArray(bArr, i10, i11, options);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BitmapUtils", "decodeByteArray, Exception: " + e10);
            return null;
        } catch (OutOfMemoryError e11) {
            AbstractC10896a.m65886e("BitmapUtils", "decodeByteArray OutOfMemoryError: " + e11);
            return null;
        }
    }

    /* renamed from: c */
    public static Bitmap m7472c(String str) {
        try {
            return BitmapFactory.decodeFile(str, null);
        } catch (OutOfMemoryError e10) {
            AbstractC10896a.m65886e("BitmapUtils", "decodeStream OutOfMemoryError: " + e10);
            return null;
        }
    }

    /* renamed from: d */
    public static Bitmap m7473d(String str, BitmapFactory.Options options) {
        try {
            return BitmapFactory.decodeFile(str, options);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BitmapUtils", "decodeFile, Exception: " + e10);
            return null;
        } catch (OutOfMemoryError e11) {
            AbstractC10896a.m65886e("BitmapUtils", "decodeFile OutOfMemoryError: " + e11);
            return null;
        }
    }

    /* renamed from: e */
    public static Bitmap m7474e(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options) {
        if (fileDescriptor == null) {
            AbstractC10896a.m65888w("BitmapUtils", "decodeFileDescriptor fd is null");
            return null;
        }
        try {
            return BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BitmapUtils", "decodeFileDescriptor, Exception: " + e10);
            return null;
        } catch (OutOfMemoryError e11) {
            AbstractC10896a.m65886e("BitmapUtils", "decodeFileDescriptor OutOfMemoryError: " + e11);
            return null;
        }
    }

    /* renamed from: f */
    public static Bitmap m7475f(InputStream inputStream) {
        try {
            return BitmapFactory.decodeStream(inputStream, null, null);
        } catch (OutOfMemoryError e10) {
            AbstractC10896a.m65886e("BitmapUtils", "decodeStream OutOfMemoryError: " + e10);
            return null;
        }
    }

    /* renamed from: g */
    public static Bitmap m7476g(InputStream inputStream, Rect rect, BitmapFactory.Options options) throws IOException {
        StringBuilder sb2;
        try {
            try {
                try {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream, rect, options);
                    try {
                        inputStream.close();
                        return bitmapDecodeStream;
                    } catch (IOException e10) {
                        AbstractC10896a.m65886e("BitmapUtils", "decodeStream, Exception: " + e10);
                        return bitmapDecodeStream;
                    }
                } catch (Exception e11) {
                    AbstractC10896a.m65886e("BitmapUtils", "decodeStream, Exception: " + e11);
                    try {
                        inputStream.close();
                    } catch (IOException e12) {
                        e = e12;
                        sb2 = new StringBuilder();
                        sb2.append("decodeStream, Exception: ");
                        sb2.append(e);
                        AbstractC10896a.m65886e("BitmapUtils", sb2.toString());
                        return null;
                    }
                    return null;
                }
            } catch (OutOfMemoryError e13) {
                AbstractC10896a.m65886e("BitmapUtils", "decodeStream OutOfMemoryError: " + e13);
                try {
                    inputStream.close();
                } catch (IOException e14) {
                    e = e14;
                    sb2 = new StringBuilder();
                    sb2.append("decodeStream, Exception: ");
                    sb2.append(e);
                    AbstractC10896a.m65886e("BitmapUtils", sb2.toString());
                    return null;
                }
                return null;
            }
        } catch (Throwable th2) {
            try {
                inputStream.close();
            } catch (IOException e15) {
                AbstractC10896a.m65886e("BitmapUtils", "decodeStream, Exception: " + e15);
            }
            throw th2;
        }
    }

    /* renamed from: h */
    public static Bitmap m7477h(Resources resources, int i10) {
        if (resources == null) {
            AbstractC10896a.m65888w("BitmapUtils", "getBitmapFormResource res is null!");
            return null;
        }
        try {
            return BitmapFactory.decodeResource(resources, i10);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BitmapUtils", "decodeResource, Exception: " + e10);
            return null;
        } catch (OutOfMemoryError e11) {
            AbstractC10896a.m65886e("BitmapUtils", "decodeResource OutOfMemoryError: " + e11);
            return null;
        }
    }
}
