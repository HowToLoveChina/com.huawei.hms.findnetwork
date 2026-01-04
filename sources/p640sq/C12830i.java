package p640sq;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* renamed from: sq.i */
/* loaded from: classes8.dex */
public final class C12830i {
    /* renamed from: a */
    public static void m77067a(File file) {
        if (!file.exists()) {
            C12836o.m77099d("FileUtils", "files is not existence.", true);
            return;
        }
        if (!file.isDirectory()) {
            C12836o.m77099d("FileUtils", "files is not directory.", true);
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            C12836o.m77099d("FileUtils", "fileList is null.", true);
            return;
        }
        for (File file2 : fileArrListFiles) {
            boolean zDelete = file2.delete();
            C12836o.m77099d("FileUtils", "result is " + zDelete, true);
            if (!zDelete) {
                return;
            }
        }
    }

    /* renamed from: b */
    public static void m77068b(FileOutputStream fileOutputStream, FileInputStream fileInputStream, InputStream inputStream) throws IOException {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e10) {
                C12836o.m77099d("FileUtils", "fileOutputStream IOException" + e10.getClass().getSimpleName(), true);
            }
        }
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e11) {
                C12836o.m77099d("FileUtils", "fileInputStream IOException" + e11.getClass().getSimpleName(), true);
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e12) {
                C12836o.m77099d("FileUtils", "inputStream IOException" + e12.getClass().getSimpleName(), true);
            }
        }
    }

    /* renamed from: c */
    public static void m77069c(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e10) {
                C12836o.m77099d("FileUtils", "close InputStream error!" + e10.getClass().getSimpleName(), true);
            }
        }
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e11) {
                C12836o.m77099d("FileUtils", "close OutputStream error!" + e11.getClass().getSimpleName(), true);
            }
        }
    }

    /* renamed from: d */
    public static void m77070d(String str) {
        m77067a(new File(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v16, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* renamed from: e */
    public static void m77071e(String str, String str2, byte[] bArr) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        File file;
        if (str == 0 || TextUtils.isEmpty(str) || str2 == null || TextUtils.isEmpty(str2) || bArr == null) {
            C12836o.m77099d("FileUtils", "parameter is null.", true);
            return;
        }
        try {
            try {
                file = new File((String) str);
            } catch (FileNotFoundException unused) {
                fileOutputStream2 = null;
            } catch (IOException unused2) {
                fileOutputStream2 = null;
            } catch (Exception e10) {
                e = e10;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                m77068b(fileOutputStream, null, null);
                throw th;
            }
            if (!file.exists() && !file.mkdirs()) {
                C12836o.m77099d("FileUtils", "file is not existence.", true);
                m77068b(null, null, null);
                return;
            }
            String str3 = ((String) str) + str2;
            if (!m77076j(str3)) {
                C12836o.m77099d("FileUtils", "file path is invalid.", true);
                str = 0;
                m77068b(str, null, null);
            }
            fileOutputStream2 = new FileOutputStream(new File(str3));
            try {
                fileOutputStream2.write(bArr);
                fileOutputStream2.flush();
                str = fileOutputStream2;
            } catch (FileNotFoundException unused3) {
                C12836o.m77099d("FileUtils", "FileNotFoundException", true);
                str = fileOutputStream2;
                m77068b(str, null, null);
            } catch (IOException unused4) {
                C12836o.m77099d("FileUtils", "IOException", true);
                str = fileOutputStream2;
                m77068b(str, null, null);
            } catch (Exception e11) {
                fileOutputStream = fileOutputStream2;
                e = e11;
                try {
                    C12836o.m77099d("FileUtils", "Exception:" + e.getClass().getSimpleName(), true);
                    m77068b(fileOutputStream, null, null);
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    m77068b(fileOutputStream, null, null);
                    throw th;
                }
            }
            m77068b(str, null, null);
        } catch (Throwable th4) {
            fileOutputStream = str;
            th = th4;
            m77068b(fileOutputStream, null, null);
            throw th;
        }
    }

    /* renamed from: f */
    public static InputStream m77072f(String str) throws Throwable {
        FileInputStream fileInputStream;
        if (!m77075i(str)) {
            return null;
        }
        File file = new File(str);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        try {
            try {
                fileInputStream = new FileInputStream(file);
                while (true) {
                    try {
                        int i10 = fileInputStream.read(bArr);
                        if (i10 == -1) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                            m77068b(null, fileInputStream, byteArrayInputStream);
                            return byteArrayInputStream;
                        }
                        byteArrayOutputStream.write(bArr, 0, i10);
                    } catch (FileNotFoundException unused) {
                        C12836o.m77099d("FileUtils", "FileNotFoundException", true);
                        m77068b(null, fileInputStream, null);
                        return null;
                    } catch (IOException unused2) {
                        C12836o.m77099d("FileUtils", "IOException", true);
                        m77068b(null, fileInputStream, null);
                        return null;
                    } catch (IndexOutOfBoundsException unused3) {
                        C12836o.m77099d("FileUtils", "IndexOutOfBoundsException", true);
                        m77068b(null, fileInputStream, null);
                        return null;
                    }
                }
            } catch (FileNotFoundException unused4) {
                fileInputStream = null;
            } catch (IOException unused5) {
                fileInputStream = null;
            } catch (IndexOutOfBoundsException unused6) {
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                m77068b(null, null, null);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            m77068b(null, null, null);
            throw th;
        }
    }

    /* renamed from: g */
    public static boolean m77073g(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            C12836o.m77097b("FileUtils", "file not exist", true);
            return false;
        }
    }

    /* renamed from: h */
    public static String m77074h(String str) throws Throwable {
        FileInputStream fileInputStream;
        try {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (FileNotFoundException e10) {
                e = e10;
                fileInputStream = null;
            } catch (UnsupportedEncodingException e11) {
                e = e11;
                fileInputStream = null;
            } catch (IOException e12) {
                e = e12;
                fileInputStream = null;
            } catch (Exception e13) {
                e = e13;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                m77069c(null, null);
                throw th;
            }
            try {
                int iAvailable = fileInputStream.available();
                byte[] bArr = new byte[iAvailable];
                if (iAvailable != fileInputStream.read(bArr)) {
                    C12836o.m77099d("FileUtils", "readFile length is error.", true);
                }
                String str2 = new String(bArr, Constants.UTF_8);
                m77069c(fileInputStream, null);
                return str2;
            } catch (FileNotFoundException e14) {
                e = e14;
                C12836o.m77099d("FileUtils", "FileNotFoundException " + e.getClass().getSimpleName(), true);
                m77069c(fileInputStream, null);
                return "";
            } catch (UnsupportedEncodingException e15) {
                e = e15;
                C12836o.m77099d("FileUtils", "UnsupportedEncodingException " + e.getClass().getSimpleName(), true);
                m77069c(fileInputStream, null);
                return "";
            } catch (IOException e16) {
                e = e16;
                C12836o.m77099d("FileUtils", "IOException " + e.getClass().getSimpleName(), true);
                m77069c(fileInputStream, null);
                return "";
            } catch (Exception e17) {
                e = e17;
                C12836o.m77099d("FileUtils", "Exception " + e.getClass().getSimpleName(), true);
                m77069c(fileInputStream, null);
                return "";
            }
        } catch (Throwable th3) {
            th = th3;
            m77069c(null, null);
            throw th;
        }
    }

    /* renamed from: i */
    public static boolean m77075i(String str) {
        return new File(str).exists();
    }

    /* renamed from: j */
    public static boolean m77076j(String str) throws IllegalArgumentException, UnsupportedEncodingException {
        if (TextUtils.isEmpty(str)) {
            C12836o.m77099d("FileUtils", "filePath is empty.", true);
            return false;
        }
        String strDecode = URLDecoder.decode(str, "utf-8");
        return (strDecode.contains(FeedbackWebConstants.INVALID_FILE_NAME_PRE) || strDecode.contains("./") || strDecode.contains("%00") || strDecode.contains("..")) ? false : true;
    }
}
