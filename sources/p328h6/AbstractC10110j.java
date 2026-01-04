package p328h6;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.utils.BackupConstant;
import com.huawei.hiar.ARImageMetadata;
import gy.C10064c;
import gy.C10065d;
import gy.C10067f;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import p006a5.C0047b;
import p386j6.C10713c;
import p601r4.C12462b;
import p601r4.C12463c;
import p601r4.C12464d;
import p632s4.C12703g;
import p699v4.C13334c;
import p699v4.C13339h;
import p699v4.C13341j;
import p699v4.C13348q;

/* renamed from: h6.j */
/* loaded from: classes.dex */
public abstract class AbstractC10110j {

    /* renamed from: a */
    public static AtomicInteger f49329a = new AtomicInteger(0);

    /* renamed from: b */
    public static volatile int f49330b = -1;

    /* renamed from: A */
    public static int m62951A(String str) {
        if (str.startsWith("/storage/emulated")) {
            return 3;
        }
        return str.startsWith("storage/emulated") ? 2 : 1;
    }

    /* renamed from: B */
    public static int m62952B(String str) {
        int iLastIndexOf = str.lastIndexOf("_");
        int iLastIndexOf2 = (str.endsWith("#TwinApp.tar") || str.endsWith("#Sdcard.tar")) ? str.lastIndexOf("#") : str.lastIndexOf(".");
        if (iLastIndexOf2 < 0) {
            return 0;
        }
        try {
            return Integer.parseInt(str.substring(iLastIndexOf + 1, iLastIndexOf2));
        } catch (NumberFormatException unused) {
            C2111d.m12648d("TarUtils", "getTarFileCount parse number exception");
            return 0;
        }
    }

    /* renamed from: C */
    public static String m62953C(C10108h c10108h) {
        return (System.currentTimeMillis() + "_" + new SecureRandom().nextInt(100000) + c10108h.m62946c()) + "_" + c10108h.m62945b().size() + (c10108h.m62948e() ? "#TwinApp.tar" : c10108h.m62947d() ? "#Sdcard.tar" : ".tar") + ".hwtmp";
    }

    /* renamed from: D */
    public static String m62954D(String str) {
        int iIncrementAndGet = f49329a.incrementAndGet() / 500;
        if (iIncrementAndGet != f49330b) {
            f49330b = iIncrementAndGet;
            C2111d.m12654j("TarUtils", "new sub dir ", Integer.valueOf(iIncrementAndGet));
        }
        return str + File.separator + "sub" + iIncrementAndGet;
    }

    /* renamed from: E */
    public static int m62955E(String str, String str2, int i10) {
        int iIndexOf = str.indexOf(str2, 0);
        while (true) {
            int i11 = i10 - 1;
            if (i10 <= 0 || iIndexOf == -1) {
                break;
            }
            iIndexOf = str.indexOf(str2, iIndexOf + 1);
            i10 = i11;
        }
        return iIndexOf;
    }

    /* renamed from: F */
    public static String m62956F(String str) {
        int iM62955E = m62955E(str, File.separator, m62951A(str));
        return iM62955E != -1 ? str.substring(iM62955E) : str;
    }

    /* renamed from: G */
    public static void m62957G(Context context, String str) throws InterruptedException {
        C10102b.m62917b(context, str);
        ContentResolver contentResolver = context.getContentResolver();
        ContentValues contentValues = new ContentValues();
        contentValues.put("moduleName", str);
        contentValues.put("tarOver", (Integer) 1);
        contentResolver.update(C10106f.f49315a, contentValues, "moduleName = ?", new String[]{str});
    }

    /* renamed from: H */
    public static void m62958H(boolean z10, C10112l c10112l, ArrayList<String> arrayList, String str) {
        if (z10 || c10112l == null || BackupObject.isWechatRecord(c10112l.m62993c())) {
            return;
        }
        arrayList.add(m62956F(str));
    }

    /* renamed from: a */
    public static void m62959a(C10112l c10112l, String str, String str2) {
        if (c10112l == null || str == null || !BackupObject.isMediaModule(c10112l.m62993c())) {
            return;
        }
        if (BackupObject.isPhotoModule(c10112l.m62993c())) {
            if (str.startsWith("storage/emulated/0")) {
                C0047b.m173a(File.separator + str, str2, 0);
            } else {
                C0047b.m173a(File.separator + str, str2, 1);
            }
        }
        C13341j.m80034a(c10112l.m62992b(), c10112l.m62993c(), str2);
    }

    /* renamed from: b */
    public static boolean m62960b(File file, C10067f c10067f, String str) throws IOException {
        if (file == null) {
            return false;
        }
        return file.isDirectory() ? m62962d(file, c10067f, str) : m62964f(file, c10067f, str);
    }

    /* renamed from: c */
    public static boolean m62961c(File file, C10067f c10067f, String str, String str2) throws IOException {
        if (file == null) {
            return false;
        }
        return file.isDirectory() ? m62963e(file, c10067f, str, str2) : m62964f(file, c10067f, str);
    }

    /* renamed from: d */
    public static boolean m62962d(File file, C10067f c10067f, String str) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        boolean z10 = true;
        if (fileArrListFiles.length < 1) {
            c10067f.m62640D(new C10064c(str + file.getName() + File.separator));
            c10067f.m62654s();
        }
        for (File file2 : fileArrListFiles) {
            if (!m62960b(file2, c10067f, str + file.getName() + File.separator)) {
                z10 = false;
            }
        }
        return z10;
    }

    /* renamed from: e */
    public static boolean m62963e(File file, C10067f c10067f, String str, String str2) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            C2111d.m12648d("TarUtils", "app archiveDir fail, files is null.");
            return false;
        }
        boolean z10 = true;
        if (fileArrListFiles.length < 1) {
            c10067f.m62640D(new C10064c(str + file.getName() + File.separator));
            c10067f.m62654s();
        }
        for (File file2 : fileArrListFiles) {
            if (C13334c.m79991x(file2).contains(str2)) {
                if (!m62960b(file2, c10067f, str + file.getName() + File.separator)) {
                    z10 = false;
                }
            }
        }
        return z10;
    }

    /* renamed from: f */
    public static boolean m62964f(File file, C10067f c10067f, String str) throws Throwable {
        if (c10067f == null) {
            return false;
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                C10064c c10064c = new C10064c(str + file.getName());
                c10064c.m62592l0(file.length());
                c10067f.m62640D(c10064c);
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(C12463c.m74719a(file));
                try {
                    byte[] bArr = new byte[ARImageMetadata.SHADING_MODE];
                    while (true) {
                        int i10 = bufferedInputStream2.read(bArr, 0, ARImageMetadata.SHADING_MODE);
                        if (i10 == -1) {
                            try {
                                bufferedInputStream2.close();
                                c10067f.m62654s();
                                return true;
                            } catch (IOException unused) {
                                C2111d.m12648d("TarUtils", "TarArchiveOutputStream close fail");
                                return true;
                            }
                        }
                        c10067f.write(bArr, 0, i10);
                    }
                } catch (IOException unused2) {
                    bufferedInputStream = bufferedInputStream2;
                    C2111d.m12648d("TarUtils", "archiveFile file IOException");
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused3) {
                            C2111d.m12648d("TarUtils", "TarArchiveOutputStream close fail");
                            return false;
                        }
                    }
                    c10067f.m62654s();
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused4) {
                            C2111d.m12648d("TarUtils", "TarArchiveOutputStream close fail");
                            throw th;
                        }
                    }
                    c10067f.m62654s();
                    throw th;
                }
            } catch (IOException unused5) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: g */
    public static int m62965g(int i10, int i11, C10112l c10112l) {
        if (c10112l == null) {
            return 0;
        }
        String strM62996f = c10112l.m62996f();
        return (c10112l.m62998h() ? m62983y(strM62996f) : m62952B(strM62996f)) - (i10 - i11);
    }

    /* renamed from: h */
    public static String m62966h(String str, String str2) {
        return (str2.contains("com.hicloud.android.clone") && str.contains("com.hihonor.android.clone")) ? str2.replace("com.hicloud.android.clone", "com.hihonor.android.clone") : (str2.contains("com.hihonor.android.clone") && str.contains("com.hicloud.android.clone")) ? str2.replace("com.hihonor.android.clone", "com.hicloud.android.clone") : str2;
    }

    /* renamed from: i */
    public static String m62967i(String str, String str2, C10112l c10112l) {
        return str2.startsWith("storage/emulated/0") ? (str.equals("/storage/emulated/0") || c10112l == null) ? str2 : (BackupObject.isMediaModule(c10112l.m62993c()) || BackupConstant.m13148v().contains(c10112l.m62993c())) ? m62981w(str, str2) : str2 : str2.startsWith("storage/emulated") ? m62977s(str2, str, 2) : m62977s(str2, str, 1);
    }

    /* renamed from: j */
    public static boolean m62968j(String str) {
        File file = new File(str + "/Huawei/CloudClone/.TempDir");
        if (file.exists()) {
            return true;
        }
        boolean zMkdirs = file.mkdirs();
        if (file.exists()) {
            C2111d.m12653i("TarUtils", "tempDir is existed");
            return true;
        }
        if (!zMkdirs) {
            C2111d.m12653i("TarUtils", "checkTempDir error");
        }
        return zMkdirs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* renamed from: k */
    public static boolean m62969k(File file, C10065d c10065d) throws Throwable {
        boolean z10 = false;
        ?? r12 = 0;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(C12464d.m74720a(file));
                try {
                    byte[] bArr = new byte[ARImageMetadata.SHADING_MODE];
                    while (true) {
                        int i10 = c10065d.read(bArr, 0, ARImageMetadata.SHADING_MODE);
                        if (i10 == -1) {
                            break;
                        }
                        bufferedOutputStream2.write(bArr, 0, i10);
                    }
                    C13339h.m80014a(bufferedOutputStream2);
                    z10 = true;
                    r12 = bArr;
                } catch (IOException unused) {
                    bufferedOutputStream = bufferedOutputStream2;
                    C2111d.m12648d("TarUtils", "deArchiveFile exception");
                    r12 = bufferedOutputStream;
                    if (bufferedOutputStream != null) {
                        C13339h.m80014a(bufferedOutputStream);
                        r12 = bufferedOutputStream;
                    }
                    return z10;
                } catch (Throwable th2) {
                    th = th2;
                    r12 = bufferedOutputStream2;
                    if (r12 != 0) {
                        C13339h.m80014a(r12);
                    }
                    throw th;
                }
            } catch (IOException unused2) {
            }
            return z10;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: l */
    public static boolean m62970l(File file, C10065d c10065d, C10112l c10112l) throws Throwable {
        File fileM74717a = C12462b.m74717a(c10112l.m62991a() + "/Huawei/CloudClone/.TempDir" + File.separator + "temp.tmp" + Thread.currentThread().getId());
        boolean zM62969k = m62969k(fileM74717a, c10065d);
        String strM79991x = C13334c.m79991x(file);
        C13341j.m80047n(c10112l.m62992b(), strM79991x, c10112l.m62993c(), C13334c.m79991x(fileM74717a));
        if (!fileM74717a.renameTo(C12462b.m74717a(strM79991x))) {
            C2111d.m12648d("TarUtils", "temp file rename fail!");
        }
        return zM62969k;
    }

    /* renamed from: m */
    public static int m62971m(String str, C10065d c10065d, C10112l c10112l, Bundle bundle) throws IOException {
        return m62973o(str, c10065d, false, c10112l, bundle);
    }

    /* renamed from: n */
    public static int m62972n(String str, C10065d c10065d, boolean z10) throws IOException {
        return m62973o(str, c10065d, z10, null, null);
    }

    /* renamed from: o */
    public static int m62973o(String str, C10065d c10065d, boolean z10, C10112l c10112l, Bundle bundle) throws IOException {
        int i10;
        boolean z11 = false;
        if (c10065d == null) {
            return 0;
        }
        if (!z10 && !m62968j(str)) {
            return 0;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        long length = 0;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            C10064c c10064cM62615A = c10065d.m62615A();
            if (c10064cM62615A == null) {
                if (!z10 && bundle != null) {
                    bundle.putLong("SUCCESS_FILE_SIZE", length);
                    bundle.putStringArrayList("key_media_file_path_list", arrayList);
                }
                C2111d.m12654j("TarUtils", "entry num is ", Integer.valueOf(i11), ",success count is ", Integer.valueOf(i12));
                return m62965g(i11, i12, c10112l);
            }
            i11++;
            String strM62607t = c10064cM62615A.m62607t();
            long jM62611w = c10064cM62615A.m62611w();
            String strM62982x = m62982x(str, z10, strM62607t, c10112l != null ? c10112l.m62998h() : z11, c10112l);
            if (TextUtils.isEmpty(strM62982x)) {
                C2111d.m12646b("TarUtils", "destPath is empty.");
            } else {
                File fileM74717a = C12462b.m74717a(strM62982x);
                if (!fileM74717a.exists()) {
                    i10 = i11;
                    m62976r(fileM74717a);
                } else if (fileM74717a.length() == jM62611w) {
                    i12++;
                    length += fileM74717a.length();
                    m62958H(z10, c10112l, arrayList, strM62607t);
                } else {
                    fileM74717a = m62978t(0, fileM74717a, fileM74717a.getName());
                    if (c10112l == null || z10) {
                        i10 = i11;
                    } else {
                        String strM62993c = c10112l.m62993c();
                        String strM62997g = c10112l.m62997g();
                        StringBuilder sb2 = new StringBuilder();
                        i10 = i11;
                        sb2.append(File.separator);
                        sb2.append(strM62607t);
                        C0047b.m178f(strM62993c, strM62997g, sb2.toString(), C13334c.m79991x(fileM74717a));
                    }
                }
                if (c10064cM62615A.m62614z()) {
                    C2111d.m12653i("TarUtils", "entry is dir");
                    if (!fileM74717a.mkdirs()) {
                        C2111d.m12648d("TarUtils", "dirFile: mkdir failure");
                        return i12;
                    }
                } else {
                    if (m62974p(z10, fileM74717a, c10065d, c10112l)) {
                        m62959a(c10112l, strM62607t, fileM74717a.getCanonicalPath());
                        i12++;
                        length += fileM74717a.length();
                        m62958H(z10, c10112l, arrayList, strM62607t);
                    } else {
                        C2111d.m12648d("TarUtils", "deArchiveFile fail , desFile path is " + fileM74717a.getCanonicalPath());
                    }
                    m62975q(fileM74717a, null);
                }
                i11 = i10;
            }
            z11 = false;
        }
    }

    /* renamed from: p */
    public static boolean m62974p(boolean z10, File file, C10065d c10065d, C10112l c10112l) {
        return z10 ? m62969k(file, c10065d) : m62970l(file, c10065d, c10112l);
    }

    /* renamed from: q */
    public static void m62975q(File file, File file2) {
        if (file2 == null || file.length() != file2.length() || file2.delete()) {
            return;
        }
        C2111d.m12648d("TarUtils", "delete fail");
    }

    /* renamed from: r */
    public static void m62976r(File file) {
        File parentFile = file.getParentFile();
        if (parentFile.exists()) {
            return;
        }
        m62976r(parentFile);
        if (parentFile.mkdir()) {
            return;
        }
        C2111d.m12648d("TarUtils", "parentFile: mkdir failure");
    }

    /* renamed from: s */
    public static String m62977s(String str, String str2, int i10) {
        int iM62955E = m62955E(str, File.separator, i10);
        if (iM62955E == -1) {
            C2111d.m12648d("TarUtils", "generateDestFileFromOrigFile get index fail");
            return str2 + str;
        }
        return str2 + str.substring(iM62955E);
    }

    /* renamed from: t */
    public static File m62978t(int i10, File file, String str) {
        File fileM74718b = C12462b.m74718b(file.getParent(), i10 > 0 ? String.format(Locale.ROOT, "Copy(%s) %s", String.valueOf(i10), str) : String.format(Locale.ROOT, "Copy %s", str));
        return fileM74718b.exists() ? m62978t(i10 + 1, file, str) : fileM74718b;
    }

    /* renamed from: u */
    public static String m62979u(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str) || C13348q.m80081a(bundle)) {
            return "";
        }
        ArrayList<String> arrayListM65401k = C10713c.m65401k(bundle, "support_sub_dir_list");
        for (String str2 : bundle.keySet()) {
            if (!TextUtils.isEmpty(str2) && str.startsWith(str2)) {
                String strM65400j = C10713c.m65400j(bundle, str2);
                if (strM65400j == null) {
                    return "";
                }
                if (arrayListM65401k.contains(strM65400j)) {
                    strM65400j = m62954D(strM65400j);
                }
                if (str2.equals(strM65400j)) {
                    return str;
                }
                return strM65400j + str.substring(str2.length());
            }
        }
        return "";
    }

    /* renamed from: v */
    public static String m62980v(String str, C10112l c10112l) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith("storage/")) {
            str = File.separator + str;
        }
        return m62979u(str, c10112l.m62995e());
    }

    /* renamed from: w */
    public static String m62981w(String str, String str2) {
        return str + str2.substring(18);
    }

    /* renamed from: x */
    public static String m62982x(String str, boolean z10, String str2, boolean z11, C10112l c10112l) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C2111d.m12648d("TarUtils", "basePath or entryPath is empty.");
            return null;
        }
        if (c10112l != null && BackupObject.isRecordModule(c10112l.m62993c())) {
            return m62984z(c10112l.m62993c(), str, str2);
        }
        if (c10112l != null && BackupConstant.m13148v().contains(c10112l.m62993c()) && !"desktopMyFile".equals(c10112l.m62993c())) {
            return m62980v(str2, c10112l);
        }
        if (z10) {
            return m62966h(str, str2);
        }
        if (!z11) {
            return m62967i(str, str2, c10112l);
        }
        if (TextUtils.isEmpty(str2) || !str2.startsWith("pictures/")) {
            return str;
        }
        return str + str2.substring(8);
    }

    /* renamed from: y */
    public static int m62983y(String str) {
        int iLastIndexOf;
        int iLastIndexOf2 = str.lastIndexOf("_");
        if (iLastIndexOf2 < 0 || (iLastIndexOf = str.lastIndexOf("_", iLastIndexOf2 - 1)) < 0) {
            return 0;
        }
        try {
            return Integer.parseInt(str.substring(iLastIndexOf + 1, iLastIndexOf2));
        } catch (NumberFormatException unused) {
            C2111d.m12648d("TarUtils", "getIosTarFileCount parse number exception");
            return 0;
        }
    }

    /* renamed from: z */
    public static String m62984z(String str, String str2, String str3) {
        if (!str.equals("callRecorder")) {
            String str4 = str2 + C12703g.m76450c();
            return str3.startsWith("storage/emulated/0") ? m62977s(str3, str4, 3) : m62977s(str3, str4, 2);
        }
        return (str2 + C12703g.m76449b()) + File.separator + new File(str3).getName();
    }
}
