package p514o9;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;

/* renamed from: o9.i */
/* loaded from: classes3.dex */
public class C11835i {
    /* renamed from: a */
    public static String m70637a(boolean z10, String str) {
        if (z10) {
            return "/CloudDisk";
        }
        return "/CloudDisk/.../" + str;
    }

    /* renamed from: b */
    public static void m70638b(File file, File file2) throws FileNotFoundException {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (!file.exists()) {
            throw new FileNotFoundException("Source does not exist");
        }
    }

    /* renamed from: c */
    public static String m70639c(File file, File file2) throws IOException {
        ArrayList arrayList;
        File[] fileArrListFiles;
        m70638b(file, file2);
        if (!file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is not a directory");
        }
        if (C10279b.m63452a(file).equals(C10279b.m63452a(file2))) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        }
        if (!C10279b.m63452a(file2).startsWith(C10279b.m63452a(file)) || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length <= 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(fileArrListFiles.length);
            for (File file3 : fileArrListFiles) {
                arrayList.add(C10279b.m63452a(C10278a.m63441g(file2, file3.getName())));
            }
        }
        return m70644h(file, file2, arrayList);
    }

    /* renamed from: d */
    public static boolean m70640d(File file, File file2) {
        if (file2.exists()) {
            C11839m.m70688i("FileUtil", "dest file already exist, delete first, result = " + file2.delete());
        }
        return m70657u(file, file2, 0L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.io.Closeable, java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.io.Closeable] */
    /* renamed from: e */
    public static boolean m70641e(String str, String str2, boolean z10) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        ?? M63444j;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C11839m.m70687e("FileUtil", "srcFileName or || destFileName is empty");
            return false;
        }
        ?? M63442h = C10278a.m63442h(str);
        if (!M63442h.exists()) {
            C11839m.m70687e("FileUtil", "srcFile not exist");
            return false;
        }
        if (!M63442h.isFile()) {
            C11839m.m70687e("FileUtil", "srcFile not file");
            return false;
        }
        File fileM63442h = C10278a.m63442h(str2);
        if (!fileM63442h.exists()) {
            File parentFile = fileM63442h.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                C11839m.m70688i("FileUtil", "copyFileByStream parentFile mkdirs failed");
                return false;
            }
        } else if (z10) {
            C11839m.m70688i("FileUtil", "copyFileByStream deleteResult is:" + fileM63442h.delete());
        }
        FileOutputStream fileOutputStreamM63445k = null;
        try {
            try {
                M63444j = C10278a.m63444j(M63442h);
            } catch (FileNotFoundException e10) {
                e = e10;
                fileOutputStream2 = null;
            } catch (IOException e11) {
                e = e11;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                M63442h = 0;
            }
            try {
                fileOutputStreamM63445k = C10278a.m63445k(fileM63442h);
                byte[] bArr = new byte[1024];
                while (true) {
                    int i10 = M63444j.read(bArr);
                    if (i10 == -1) {
                        C0209d.m1263i(M63444j);
                        C0209d.m1263i(fileOutputStreamM63445k);
                        return true;
                    }
                    fileOutputStreamM63445k.write(bArr, 0, i10);
                }
            } catch (FileNotFoundException e12) {
                e = e12;
                FileOutputStream fileOutputStream3 = fileOutputStreamM63445k;
                fileOutputStreamM63445k = M63444j;
                fileOutputStream2 = fileOutputStream3;
                C11839m.m70687e("FileUtil", "copyFileByStream error1: " + e.getMessage());
                C0209d.m1263i(fileOutputStreamM63445k);
                C0209d.m1263i(fileOutputStream2);
                return false;
            } catch (IOException e13) {
                e = e13;
                FileOutputStream fileOutputStream4 = fileOutputStreamM63445k;
                fileOutputStreamM63445k = M63444j;
                fileOutputStream = fileOutputStream4;
                C11839m.m70687e("FileUtil", "copyFileByStream error: " + e.getMessage());
                C0209d.m1263i(fileOutputStreamM63445k);
                C0209d.m1263i(fileOutputStream);
                return false;
            } catch (Throwable th3) {
                th = th3;
                FileOutputStream fileOutputStream5 = fileOutputStreamM63445k;
                fileOutputStreamM63445k = M63444j;
                M63442h = fileOutputStream5;
                C0209d.m1263i(fileOutputStreamM63445k);
                C0209d.m1263i(M63442h);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* renamed from: f */
    public static boolean m70642f(File file) {
        File[] fileArrM63440f;
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isDirectory() && (fileArrM63440f = C10278a.m63440f(file)) != null) {
            for (File file2 : fileArrM63440f) {
                m70642f(file2);
            }
        }
        return file.delete();
    }

    /* renamed from: g */
    public static boolean m70643g(String str) {
        if (str == null) {
            return false;
        }
        return m70642f(C10278a.m63442h(str));
    }

    /* renamed from: h */
    public static String m70644h(File file, File file2, List<String> list) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            throw new IOException("doCopyDirectory occours error list contents of " + file);
        }
        if (file2.exists()) {
            if (!file2.isDirectory()) {
                throw new IOException("doCopyDirectory occours error destination '" + file2 + "' exists but is not a directory");
            }
        } else if (!file2.mkdirs() && !file2.isDirectory()) {
            throw new IOException("doCopyDirectory occours error destination '" + file2 + "' directory cannot be created");
        }
        if (!file2.canWrite()) {
            throw new IOException("doCopyDirectory occours error destination '" + file2 + "' cannot be written to");
        }
        String strM63452a = "";
        for (File file3 : fileArrListFiles) {
            File fileM63441g = C10278a.m63441g(file2, file3.getName());
            if (list == null || !list.contains(C10279b.m63452a(file3))) {
                if (file3.isDirectory()) {
                    String strM70644h = m70644h(file3, fileM63441g, list);
                    if (!TextUtils.isEmpty(strM70644h)) {
                        strM63452a = strM70644h;
                    }
                } else if (!m70640d(file3, fileM63441g)) {
                    strM63452a = C10279b.m63452a(file3);
                } else if (!file3.delete()) {
                    C11839m.m70688i("FileUtil", "doCopyDirectory delete src error");
                }
            }
        }
        return strM63452a;
    }

    /* renamed from: i */
    public static File m70645i(Context context) {
        return m70647k(m70649m(context));
    }

    /* renamed from: j */
    public static File m70646j(Context context) {
        return m70647k("mounted".equals(Environment.getExternalStorageState()) ? context.getExternalCacheDir() : context.getCacheDir());
    }

    /* renamed from: k */
    public static File m70647k(File file) {
        String strM63452a = C10279b.m63452a(file);
        if (TextUtils.isEmpty(strM63452a) || TextUtils.isEmpty(file.getName())) {
            C11839m.m70688i("FileUtil", "getBaseCacheDir path is empty");
            strM63452a = "/data/data/com.huawei.hidisk/cache/";
        }
        File fileM63443i = C10278a.m63443i(strM63452a, ".core");
        if (!fileM63443i.exists()) {
            if (fileM63443i.mkdirs()) {
                C11839m.m70688i("FileUtil", "external parent create success.");
            } else {
                C11839m.m70686d("FileUtil", "external parent create failed.");
            }
        }
        return fileM63443i;
    }

    /* renamed from: l */
    public static String m70648l(File file) {
        if (file == null) {
            return "";
        }
        String name = file.getName();
        return !name.contains(".") ? "" : name.substring(name.lastIndexOf(".") + 1);
    }

    /* renamed from: m */
    public static File m70649m(Context context) {
        return ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) ? context.getExternalCacheDir() : context.getCacheDir();
    }

    /* renamed from: n */
    public static boolean m70650n(File file) throws IOException {
        if (!file.exists()) {
            return false;
        }
        try {
            C0209d.m1263i(new FileInputStream(file));
            return true;
        } catch (FileNotFoundException unused) {
            C0209d.m1263i(null);
            return false;
        } catch (Throwable th2) {
            C0209d.m1263i(null);
            throw th2;
        }
    }

    /* renamed from: o */
    public static boolean m70651o(File file) {
        try {
            if (file.getParent() != null) {
                File parentFile = file.getParentFile();
                if (parentFile == null) {
                    C11839m.m70689w("FileUtil", "parentFile is null");
                    return false;
                }
                file = C10278a.m63441g(parentFile.getCanonicalFile(), file.getName());
            }
            return !file.getCanonicalFile().equals(file.getAbsoluteFile());
        } catch (Exception unused) {
            C11839m.m70687e("FileUtil", "isSymlink exception");
            return false;
        }
    }

    /* renamed from: p */
    public static String m70652p(File file, File file2) throws IOException {
        if (!file.isDirectory()) {
            throw new IOException("Source '" + file + "' is not a directory");
        }
        if (file2.exists() && !m70642f(file2)) {
            throw new IOException("Source '" + file2 + "' is exists");
        }
        boolean zRenameTo = file.renameTo(file2);
        C11839m.m70688i("FileUtil", "moveDirectory rename: " + zRenameTo);
        if (zRenameTo) {
            return "";
        }
        if (file2.getCanonicalPath().startsWith(file.getCanonicalPath() + File.separator)) {
            throw new IOException("Cannot move directory: " + file + " to a subdirectory of itself: " + file2);
        }
        String strM70639c = m70639c(file, file2);
        m70642f(file);
        if (!file.exists()) {
            return strM70639c;
        }
        throw new IOException("Failed to delete original directory '" + file + "' after copy to '" + file2 + "'");
    }

    /* renamed from: q */
    public static void m70653q(String str, String str2) throws C9721b {
        C11839m.m70688i("FileUtil", "moveDirectory start srcDirPath = " + str + " ,destDirPath = " + str2);
        File fileM63442h = C10278a.m63442h(str);
        File fileM63442h2 = C10278a.m63442h(str2);
        if (!fileM63442h.exists()) {
            C11839m.m70688i("FileUtil", "moveDirectory no exists");
            return;
        }
        String[] list = fileM63442h.list();
        if (list == null) {
            C11839m.m70688i("FileUtil", "moveDirectory list is null");
            return;
        }
        if (list.length <= 0) {
            C11839m.m70688i("FileUtil", "moveDirectory no content");
            return;
        }
        try {
            m70652p(fileM63442h, fileM63442h2);
            C11839m.m70688i("FileUtil", "moveDirectory end");
        } catch (Exception e10) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "moveDirectory error: " + e10.toString());
        }
    }

    /* renamed from: r */
    public static boolean m70654r(File file, File file2) {
        if (file == null) {
            C11839m.m70689w("FileUtil", "srcFile null");
            return false;
        }
        if (file2 == null) {
            C11839m.m70689w("FileUtil", "destFile null");
            return false;
        }
        if (!file.exists()) {
            C11839m.m70689w("FileUtil", "srcFile does not exist ");
            return false;
        }
        if (file.isDirectory()) {
            C11839m.m70689w("FileUtil", "srcFile is a directory ");
            return false;
        }
        if (file2.exists()) {
            C11839m.m70689w("FileUtil", "destFile already exists");
            return false;
        }
        if (file2.isDirectory()) {
            C11839m.m70689w("FileUtil", "destFile is a directory");
            return false;
        }
        if (file.renameTo(file2)) {
            return true;
        }
        C11839m.m70689w("FileUtil", "srcFile.renameTo failed try another way");
        return m70655s(file, file2, 0L);
    }

    /* renamed from: s */
    public static boolean m70655s(File file, File file2, long j10) throws Throwable {
        boolean zM70657u = m70657u(file, file2, j10);
        if (!file.delete()) {
            C11839m.m70689w("FileUtil", "Failed to delete original srcFile after move");
        }
        if (zM70657u) {
            return true;
        }
        if (file2.delete()) {
            return false;
        }
        C11839m.m70689w("FileUtil", "Failed to delete original destFile after move fail");
        return false;
    }

    /* renamed from: t */
    public static boolean m70656t(String str, String str2) {
        try {
            return C10278a.m63442h(str).renameTo(C10278a.m63442h(str2));
        } catch (Exception e10) {
            C11839m.m70687e("FileUtil", "rename fileName failed:" + e10.getMessage());
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.io.Closeable, java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v13, types: [java.io.Closeable, java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.io.Closeable] */
    /* renamed from: u */
    public static boolean m70657u(File file, File file2, long j10) throws Throwable {
        FileChannel fileChannel;
        FileChannel fileChannel2;
        FileChannel fileChannel3;
        FileChannel fileChannel4;
        FileChannel channel;
        ?? M63444j;
        ?? M63448n;
        FileChannel fileChannel5;
        FileChannel fileChannel6;
        FileChannel fileChannel7;
        if (file == null || file2 == null) {
            return false;
        }
        FileChannel channel2 = null;
        try {
            try {
                M63444j = C10278a.m63444j(file);
            } catch (FileNotFoundException e10) {
                e = e10;
                M63444j = 0;
                M63448n = 0;
            } catch (IOException e11) {
                e = e11;
                fileChannel3 = null;
                fileChannel4 = null;
                channel = null;
            } catch (Throwable th2) {
                th = th2;
                fileChannel = null;
                fileChannel2 = null;
            }
            try {
                M63448n = C10278a.m63448n(file2, "rw");
                try {
                    channel = M63444j.getChannel();
                } catch (FileNotFoundException e12) {
                    e = e12;
                    channel = null;
                } catch (IOException e13) {
                    e = e13;
                    channel = null;
                    fileChannel7 = M63448n;
                    channel2 = M63444j;
                    fileChannel3 = channel;
                    fileChannel4 = fileChannel7;
                    try {
                        C11839m.m70687e("FileUtil", "transfer IOException: " + e.getMessage());
                        C0209d.m1263i(fileChannel3);
                        C0209d.m1263i(fileChannel4);
                        C0209d.m1263i(channel);
                        C0209d.m1263i(channel2);
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        FileChannel fileChannel8 = fileChannel3;
                        fileChannel6 = channel2;
                        channel2 = fileChannel8;
                        fileChannel5 = fileChannel4;
                        C0209d.m1263i(channel2);
                        C0209d.m1263i(fileChannel5);
                        C0209d.m1263i(channel);
                        C0209d.m1263i(fileChannel6);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    channel = null;
                    fileChannel6 = M63444j;
                    fileChannel5 = M63448n;
                    C0209d.m1263i(channel2);
                    C0209d.m1263i(fileChannel5);
                    C0209d.m1263i(channel);
                    C0209d.m1263i(fileChannel6);
                    throw th;
                }
            } catch (FileNotFoundException e14) {
                e = e14;
                M63448n = 0;
                M63444j = M63444j;
                channel = M63448n;
                C11839m.m70687e("FileUtil", "transfer FileNotFoundException: " + e.getMessage());
                C0209d.m1263i(channel2);
                C0209d.m1263i(M63448n);
                C0209d.m1263i(channel);
                C0209d.m1263i(M63444j);
                return false;
            } catch (IOException e15) {
                e = e15;
                fileChannel7 = null;
                channel = null;
            } catch (Throwable th5) {
                th = th5;
                fileChannel2 = null;
                fileChannel = M63444j;
                channel = fileChannel2;
                fileChannel6 = fileChannel;
                fileChannel5 = fileChannel2;
                C0209d.m1263i(channel2);
                C0209d.m1263i(fileChannel5);
                C0209d.m1263i(channel);
                C0209d.m1263i(fileChannel6);
                throw th;
            }
            try {
                channel2 = M63448n.getChannel();
                long size = channel.size();
                long j11 = 0;
                while (j11 < size) {
                    long jTransferFrom = channel2.transferFrom(channel, j10 + j11, Math.min(size - j11, 31457280L));
                    if (jTransferFrom == 0) {
                        break;
                    }
                    j11 += jTransferFrom;
                }
                C0209d.m1263i(channel2);
                C0209d.m1263i(M63448n);
                C0209d.m1263i(channel);
                C0209d.m1263i(M63444j);
                return true;
            } catch (FileNotFoundException e16) {
                e = e16;
                C11839m.m70687e("FileUtil", "transfer FileNotFoundException: " + e.getMessage());
                C0209d.m1263i(channel2);
                C0209d.m1263i(M63448n);
                C0209d.m1263i(channel);
                C0209d.m1263i(M63444j);
                return false;
            } catch (IOException e17) {
                e = e17;
                fileChannel3 = channel2;
                channel2 = M63444j;
                fileChannel4 = M63448n;
                C11839m.m70687e("FileUtil", "transfer IOException: " + e.getMessage());
                C0209d.m1263i(fileChannel3);
                C0209d.m1263i(fileChannel4);
                C0209d.m1263i(channel);
                C0209d.m1263i(channel2);
                return false;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
