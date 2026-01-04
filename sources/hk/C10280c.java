package hk;

import android.content.Context;
import android.text.TextUtils;
import com.google.flatbuffers.reflection.BaseType;
import com.huawei.hiar.ARImageMetadata;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import p399jk.AbstractC10896a;

/* renamed from: hk.c */
/* loaded from: classes6.dex */
public class C10280c {
    /* renamed from: a */
    public static String m63453a(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[bArr.length * 2];
        int i10 = 0;
        for (byte b10 : bArr) {
            int i11 = i10 + 1;
            cArr2[i10] = cArr[(b10 >>> 4) & 15];
            i10 += 2;
            cArr2[i11] = cArr[b10 & BaseType.Obj];
        }
        return new String(cArr2);
    }

    /* renamed from: b */
    public static boolean m63454b(File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list == null) {
                return file.delete();
            }
            for (String str : list) {
                if (!m63454b(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.io.RandomAccessFile] */
    /* renamed from: c */
    public static void m63455c(Context context, String str, String str2) throws Throwable {
        StringBuilder sb2;
        InputStream inputStreamOpen;
        AbstractC10896a.m65887i("FileUtil", "extractLocalFile extract " + str);
        if (context == 0) {
            AbstractC10896a.m65886e("FileUtil", "extractLocalFile mContext is null.");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            AbstractC10896a.m65886e("FileUtil", "extractLocalFile fileName is empty.");
            return;
        }
        InputStream inputStream = null;
        try {
            try {
                inputStreamOpen = context.getAssets().open(str);
            } catch (IOException e10) {
                e = e10;
                context = 0;
            } catch (Exception e11) {
                e = e11;
                context = 0;
            } catch (Throwable th2) {
                th = th2;
                context = 0;
            }
            try {
                if (inputStreamOpen == null) {
                    AbstractC10896a.m65887i("FileUtil", "extractLocalFile inputStream is null");
                    if (inputStreamOpen != null) {
                        try {
                            inputStreamOpen.close();
                            return;
                        } catch (IOException e12) {
                            AbstractC10896a.m65886e("FileUtil", "IOException exception:" + e12.toString());
                            return;
                        }
                    }
                    return;
                }
                RandomAccessFile randomAccessFileM63449o = C10278a.m63449o(str2, "rw");
                randomAccessFileM63449o.seek(0L);
                byte[] bArr = new byte[ARImageMetadata.SHADING_MODE];
                while (true) {
                    int i10 = inputStreamOpen.read(bArr);
                    if (i10 == -1) {
                        try {
                            inputStreamOpen.close();
                            randomAccessFileM63449o.close();
                            return;
                        } catch (IOException e13) {
                            e = e13;
                            sb2 = new StringBuilder();
                            sb2.append("IOException exception:");
                            sb2.append(e.toString());
                            AbstractC10896a.m65886e("FileUtil", sb2.toString());
                            return;
                        }
                    }
                    randomAccessFileM63449o.write(bArr, 0, i10);
                }
            } catch (IOException e14) {
                e = e14;
                inputStream = inputStreamOpen;
                context = 0;
                AbstractC10896a.m65886e("FileUtil", "extractLocalFile get assert file fail msg:" + e.getMessage());
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e15) {
                        e = e15;
                        sb2 = new StringBuilder();
                        sb2.append("IOException exception:");
                        sb2.append(e.toString());
                        AbstractC10896a.m65886e("FileUtil", sb2.toString());
                        return;
                    }
                }
                if (context != 0) {
                    context.close();
                }
            } catch (Exception e16) {
                e = e16;
                inputStream = inputStreamOpen;
                context = 0;
                AbstractC10896a.m65886e("FileUtil", "extractLocalFile exception:" + e.toString());
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e17) {
                        e = e17;
                        sb2 = new StringBuilder();
                        sb2.append("IOException exception:");
                        sb2.append(e.toString());
                        AbstractC10896a.m65886e("FileUtil", sb2.toString());
                        return;
                    }
                }
                if (context != 0) {
                    context.close();
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = inputStreamOpen;
                context = 0;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e18) {
                        AbstractC10896a.m65886e("FileUtil", "IOException exception:" + e18.toString());
                        throw th;
                    }
                }
                if (context != 0) {
                    context.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* renamed from: d */
    public static String m63456d(String str) {
        if (str == null) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        for (char c10 : str.toCharArray()) {
            if (m63458f(c10)) {
                sb2.append(c10);
            }
        }
        return sb2.toString();
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0024: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:10:0x0024 */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m63457e(java.lang.String r10, java.lang.String r11) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "Close FileInputStream failed!"
            java.lang.String r1 = "FileUtil"
            r2 = 0
            java.security.MessageDigest r11 = java.security.MessageDigest.getInstance(r11)     // Catch: java.lang.Throwable -> L46 java.lang.IndexOutOfBoundsException -> L49 java.lang.IllegalArgumentException -> L4c java.io.IOException -> L4f java.io.FileNotFoundException -> L52 java.security.NoSuchAlgorithmException -> L54
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L46 java.lang.IndexOutOfBoundsException -> L49 java.lang.IllegalArgumentException -> L4c java.io.IOException -> L4f java.io.FileNotFoundException -> L52 java.security.NoSuchAlgorithmException -> L54
            r3.<init>(r10)     // Catch: java.lang.Throwable -> L46 java.lang.IndexOutOfBoundsException -> L49 java.lang.IllegalArgumentException -> L4c java.io.IOException -> L4f java.io.FileNotFoundException -> L52 java.security.NoSuchAlgorithmException -> L54
            r10 = 1024(0x400, float:1.435E-42)
            byte[] r10 = new byte[r10]     // Catch: java.lang.Throwable -> L23 java.lang.IndexOutOfBoundsException -> L27 java.lang.IllegalArgumentException -> L29 java.io.IOException -> L2b java.security.NoSuchAlgorithmException -> L2d java.io.FileNotFoundException -> L9c
            r4 = 0
            r6 = r4
        L15:
            int r8 = r3.read(r10)     // Catch: java.lang.Throwable -> L23 java.lang.IndexOutOfBoundsException -> L27 java.lang.IllegalArgumentException -> L29 java.io.IOException -> L2b java.security.NoSuchAlgorithmException -> L2d java.io.FileNotFoundException -> L9c
            r9 = -1
            if (r8 == r9) goto L30
            r9 = 0
            r11.update(r10, r9, r8)     // Catch: java.lang.Throwable -> L23 java.lang.IndexOutOfBoundsException -> L27 java.lang.IllegalArgumentException -> L29 java.io.IOException -> L2b java.security.NoSuchAlgorithmException -> L2d java.io.FileNotFoundException -> L9c
            long r8 = (long) r8     // Catch: java.lang.Throwable -> L23 java.lang.IndexOutOfBoundsException -> L27 java.lang.IllegalArgumentException -> L29 java.io.IOException -> L2b java.security.NoSuchAlgorithmException -> L2d java.io.FileNotFoundException -> L9c
            long r6 = r6 + r8
            goto L15
        L23:
            r10 = move-exception
            r2 = r3
            goto Lbc
        L27:
            r10 = move-exception
            goto L57
        L29:
            r10 = move-exception
            goto L6e
        L2b:
            r10 = move-exception
            goto L85
        L2d:
            r10 = move-exception
            goto La4
        L30:
            int r10 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r10 <= 0) goto L3c
            byte[] r10 = r11.digest()     // Catch: java.lang.Throwable -> L23 java.lang.IndexOutOfBoundsException -> L27 java.lang.IllegalArgumentException -> L29 java.io.IOException -> L2b java.security.NoSuchAlgorithmException -> L2d java.io.FileNotFoundException -> L9c
            java.lang.String r2 = m63453a(r10)     // Catch: java.lang.Throwable -> L23 java.lang.IndexOutOfBoundsException -> L27 java.lang.IllegalArgumentException -> L29 java.io.IOException -> L2b java.security.NoSuchAlgorithmException -> L2d java.io.FileNotFoundException -> L9c
        L3c:
            r3.close()     // Catch: java.io.IOException -> L41
            goto Lbb
        L41:
            p399jk.AbstractC10896a.m65886e(r1, r0)
            goto Lbb
        L46:
            r10 = move-exception
            goto Lbc
        L49:
            r10 = move-exception
            r3 = r2
            goto L57
        L4c:
            r10 = move-exception
            r3 = r2
            goto L6e
        L4f:
            r10 = move-exception
            r3 = r2
            goto L85
        L52:
            r3 = r2
            goto L9c
        L54:
            r10 = move-exception
            r3 = r2
            goto La4
        L57:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L23
            r11.<init>()     // Catch: java.lang.Throwable -> L23
            java.lang.String r4 = "getFileHashData IndexOutOfBoundsException"
            r11.append(r4)     // Catch: java.lang.Throwable -> L23
            r11.append(r10)     // Catch: java.lang.Throwable -> L23
            java.lang.String r10 = r11.toString()     // Catch: java.lang.Throwable -> L23
            p399jk.AbstractC10896a.m65886e(r1, r10)     // Catch: java.lang.Throwable -> L23
            if (r3 == 0) goto Lbb
            goto L3c
        L6e:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L23
            r11.<init>()     // Catch: java.lang.Throwable -> L23
            java.lang.String r4 = "getFileHashData IllegalArgumentException"
            r11.append(r4)     // Catch: java.lang.Throwable -> L23
            r11.append(r10)     // Catch: java.lang.Throwable -> L23
            java.lang.String r10 = r11.toString()     // Catch: java.lang.Throwable -> L23
            p399jk.AbstractC10896a.m65886e(r1, r10)     // Catch: java.lang.Throwable -> L23
            if (r3 == 0) goto Lbb
            goto L3c
        L85:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L23
            r11.<init>()     // Catch: java.lang.Throwable -> L23
            java.lang.String r4 = "getFileHashData IOException"
            r11.append(r4)     // Catch: java.lang.Throwable -> L23
            r11.append(r10)     // Catch: java.lang.Throwable -> L23
            java.lang.String r10 = r11.toString()     // Catch: java.lang.Throwable -> L23
            p399jk.AbstractC10896a.m65886e(r1, r10)     // Catch: java.lang.Throwable -> L23
            if (r3 == 0) goto Lbb
            goto L3c
        L9c:
            java.lang.String r10 = "getFileHashData FileNotFoundException"
            p399jk.AbstractC10896a.m65886e(r1, r10)     // Catch: java.lang.Throwable -> L23
            if (r3 == 0) goto Lbb
            goto L3c
        La4:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L23
            r11.<init>()     // Catch: java.lang.Throwable -> L23
            java.lang.String r4 = "getFileHashData NoSuchAlgorithmException"
            r11.append(r4)     // Catch: java.lang.Throwable -> L23
            r11.append(r10)     // Catch: java.lang.Throwable -> L23
            java.lang.String r10 = r11.toString()     // Catch: java.lang.Throwable -> L23
            p399jk.AbstractC10896a.m65886e(r1, r10)     // Catch: java.lang.Throwable -> L23
            if (r3 == 0) goto Lbb
            goto L3c
        Lbb:
            return r2
        Lbc:
            if (r2 == 0) goto Lc5
            r2.close()     // Catch: java.io.IOException -> Lc2
            goto Lc5
        Lc2:
            p399jk.AbstractC10896a.m65886e(r1, r0)
        Lc5:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: hk.C10280c.m63457e(java.lang.String, java.lang.String):java.lang.String");
    }

    /* renamed from: f */
    public static boolean m63458f(char c10) {
        return ((c10 >= 0 && c10 <= 31) || c10 == '\"' || c10 == '*' || c10 == '/' || c10 == ':' || c10 == '<' || c10 == '\\' || c10 == '|' || c10 == 127 || c10 == '>' || c10 == '?') ? false : true;
    }

    /* renamed from: g */
    public static boolean m63459g(String str) {
        if (str == null) {
            return true;
        }
        for (char c10 : str.toCharArray()) {
            if (!m63458f(c10)) {
                return false;
            }
        }
        return true;
    }
}
