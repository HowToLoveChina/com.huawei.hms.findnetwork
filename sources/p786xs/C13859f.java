package p786xs;

import android.text.TextUtils;
import as.C1016d;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* renamed from: xs.f */
/* loaded from: classes8.dex */
public final class C13859f {
    /* renamed from: a */
    public static String m83174a(String str) throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream(m83176c(str));
            try {
                byte[] bArr = new byte[1024];
                StringBuilder sb2 = new StringBuilder();
                while (true) {
                    int i10 = fileInputStream.read(bArr);
                    if (i10 == -1) {
                        String string = sb2.toString();
                        fileInputStream.close();
                        return string;
                    }
                    sb2.append(new String(bArr, 0, i10, StandardCharsets.UTF_8));
                }
            } finally {
            }
        } catch (IOException unused) {
            C1016d.m6183c("FileUtils", "read data from file failed");
            return null;
        }
    }

    /* renamed from: b */
    public static boolean m83175b(String str, String str2) {
        File file = new File(m83176c(str + File.separator + str2));
        if (file.exists() || file.mkdirs()) {
            return false;
        }
        C1016d.m6181a("FileUtils", " not exists!!!");
        return true;
    }

    /* renamed from: c */
    public static String m83176c(String str) {
        if (str == null || "".equals(str.trim())) {
            return str;
        }
        if (str.contains(FeedbackWebConstants.INVALID_FILE_NAME_PRE)) {
            str = str.trim().replaceAll("\\.\\./", "");
        }
        return str.contains("..\\") ? str.trim().replaceAll("\\.\\.\\\\", "") : str;
    }

    /* renamed from: d */
    public static String m83177d(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            C1016d.m6186f("FileUtils", "Failed to combine paths, the local dir is empty");
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            C1016d.m6186f("FileUtils", "Failed to combine paths, the download Url is empty");
            return null;
        }
        int iLastIndexOf = str2.lastIndexOf(File.separator);
        if (iLastIndexOf < 0 || iLastIndexOf == str2.length() - 1) {
            C1016d.m6186f("FileUtils", "Failed to combine paths, The download url is abnormal.");
            return null;
        }
        String strSubstring = str2.substring(iLastIndexOf + 1);
        if (!Pattern.compile("[a-zA-Z0-9\\.\\-\\_]+").matcher(strSubstring).matches()) {
            C1016d.m6186f("FileUtils", "Failed to combine paths, The file path contains invalid characters.");
            return null;
        }
        return str + strSubstring;
    }

    /* renamed from: e */
    public static void m83178e(int i10, String str) {
        String str2;
        File file = new File(str);
        if (file.exists()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length >= i10) {
                Arrays.sort(fileArrListFiles, new C13854a());
                for (int i11 = i10 - 1; i11 < fileArrListFiles.length; i11++) {
                    if (!fileArrListFiles[i11].delete()) {
                        C1016d.m6181a("FileUtils", "file delete fail");
                    }
                }
                return;
            }
            str2 = "The number of files does not exceed the limit.";
        } else {
            str2 = "The directory does not exist.";
        }
        C1016d.m6183c("FileUtils", str2);
    }

    /* renamed from: f */
    public static void m83179f(File file, String str) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i10 = byteArrayInputStream.read(bArr);
                        if (i10 == -1) {
                            fileOutputStream.close();
                            byteArrayInputStream.close();
                            return;
                        }
                        fileOutputStream.write(bArr, 0, i10);
                    }
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            C1016d.m6183c("FileUtils", "write data to file failed");
        }
    }

    /* renamed from: g */
    public static boolean m83180g(File file, ZipInputStream zipInputStream) throws IOException {
        byte[] bArr = new byte[1024];
        if (file.exists() || !file.createNewFile()) {
            return false;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                int i10 = zipInputStream.read(bArr);
                boolean z10 = false;
                while (i10 != -1) {
                    fileOutputStream.write(bArr, 0, i10);
                    i10 = zipInputStream.read(bArr);
                    z10 = true;
                }
                fileOutputStream.close();
                return z10;
            } finally {
            }
        } catch (IOException unused) {
            C1016d.m6183c("FileUtils", "zip fos error is: ");
            return false;
        }
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0053: MOVE (r3 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:25:0x0053 */
    /* renamed from: h */
    public static boolean m83181h(String str, String str2, String str3) throws Throwable {
        boolean z10;
        String str4;
        FileInputStream fileInputStream;
        ZipInputStream zipInputStream;
        boolean z11;
        File file = new File(str2);
        boolean z12 = false;
        if (!file.exists() && !file.mkdirs()) {
            C1016d.m6181a("FileUtils", " not exists!!!");
            return false;
        }
        try {
            try {
                try {
                    fileInputStream = new FileInputStream(new File(m83176c(str)));
                    try {
                        try {
                            zipInputStream = new ZipInputStream(fileInputStream);
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                fileInputStream.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        fileInputStream.close();
                        throw th;
                    }
                } catch (FileNotFoundException unused) {
                    z12 = z10;
                    str4 = "zip error: file not found";
                    C1016d.m6183c("FileUtils", str4);
                    C1016d.m6186f("FileUtils", "The unzip file is decompressed: " + z12);
                    return z12;
                }
            } catch (IOException unused2) {
                str4 = "zip error";
                C1016d.m6183c("FileUtils", str4);
                C1016d.m6186f("FileUtils", "The unzip file is decompressed: " + z12);
                return z12;
            }
        } catch (FileNotFoundException unused3) {
            str4 = "zip error: file not found";
            C1016d.m6183c("FileUtils", str4);
            C1016d.m6186f("FileUtils", "The unzip file is decompressed: " + z12);
            return z12;
        }
        try {
            boolean zM83175b = false;
            for (ZipEntry nextEntry = zipInputStream.getNextEntry(); nextEntry != null; nextEntry = zipInputStream.getNextEntry()) {
                try {
                    String name = nextEntry.getName();
                    if (name.contains(FeedbackWebConstants.INVALID_FILE_NAME_PRE)) {
                        C1016d.m6183c("FileUtils", " is not security!!!");
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    if (!z11) {
                        zipInputStream.close();
                        fileInputStream.close();
                        return false;
                    }
                    zM83175b = nextEntry.isDirectory() ? m83175b(str2, name) : m83180g(new File(m83176c(str2 + File.separator + str3)), zipInputStream);
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        zipInputStream.close();
                    } catch (Throwable th6) {
                        th.addSuppressed(th6);
                    }
                    throw th;
                }
            }
            zipInputStream.close();
            fileInputStream.close();
            z12 = zM83175b;
            C1016d.m6186f("FileUtils", "The unzip file is decompressed: " + z12);
            return z12;
        } catch (Throwable th7) {
            th = th7;
        }
    }
}
