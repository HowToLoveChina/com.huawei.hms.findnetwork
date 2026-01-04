package p752wu;

import com.google.flatbuffers.reflection.BaseType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import su.C12860b;

/* renamed from: wu.a */
/* loaded from: classes9.dex */
public final class C13639a {

    /* renamed from: a */
    public static final char[] f61331a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b */
    public static final char[] f61332b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    public static char[] m82007a(byte[] bArr, boolean z10) {
        return m82008b(bArr, z10 ? f61332b : f61331a);
    }

    /* renamed from: b */
    public static char[] m82008b(byte[] bArr, char[] cArr) {
        String str;
        char[] cArr2 = new char[0];
        if (bArr == null) {
            str = "encodeHex dataByte is null";
        } else if (cArr == null) {
            str = "encodeHex toDigits is null";
        } else {
            if (bArr.length <= 65535) {
                char[] cArr3 = new char[bArr.length << 1];
                int i10 = 0;
                for (byte b10 : bArr) {
                    int i11 = i10 + 1;
                    cArr3[i10] = cArr[(b10 & 240) >>> 4];
                    i10 += 2;
                    cArr3[i11] = cArr[b10 & BaseType.Obj];
                }
                return cArr3;
            }
            str = "encodeHex dataByte's length is too large";
        }
        C12860b.m77197a("HexUtil", str);
        return cArr2;
    }

    /* renamed from: c */
    public static String m82009c(byte[] bArr, boolean z10) {
        return new String(m82007a(bArr, z10));
    }

    /* renamed from: d */
    public static String m82010d(File file) throws IOException {
        FileInputStream fileInputStream;
        String str;
        if (file == null) {
            str = "getFileShaHex file is null";
        } else {
            if (file.exists()) {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (FileNotFoundException unused) {
                    C12860b.m77197a("HexUtil", "getFileShaHex FileNotFoundException");
                    fileInputStream = null;
                }
                try {
                    if (fileInputStream == null) {
                        return null;
                    }
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                        byte[] bArr = new byte[4096];
                        int i10 = fileInputStream.read(bArr);
                        if (i10 == -1) {
                            messageDigest.update(bArr, 0, 0);
                        } else {
                            do {
                                messageDigest.update(bArr, 0, i10);
                                i10 = fileInputStream.read(bArr);
                            } while (i10 != -1);
                        }
                        String strM82009c = m82009c(messageDigest.digest(), true);
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                            C12860b.m77197a("HexUtil", "getFileShaHex IOException");
                        }
                        return strM82009c;
                    } catch (IOException unused3) {
                        C12860b.m77197a("HexUtil", "getFileShaHex IOException");
                        try {
                            fileInputStream.close();
                            return "";
                        } catch (IOException unused4) {
                            C12860b.m77197a("HexUtil", "getFileShaHex IOException");
                            return "";
                        }
                    } catch (NoSuchAlgorithmException unused5) {
                        C12860b.m77197a("HexUtil", "getFileShaHex NoSuchAlgorithmException");
                        fileInputStream.close();
                        return "";
                    }
                } catch (Throwable th2) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused6) {
                        C12860b.m77197a("HexUtil", "getFileShaHex IOException");
                    }
                    throw th2;
                }
            }
            str = "getFileShaHex file not exit";
        }
        C12860b.m77197a("HexUtil", str);
        return null;
    }
}
