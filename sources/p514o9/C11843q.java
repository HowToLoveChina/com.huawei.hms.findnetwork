package p514o9;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import p052cb.C1413j;

/* renamed from: o9.q */
/* loaded from: classes3.dex */
public class C11843q {
    /* renamed from: a */
    public static void m70893a(FileInputStream fileInputStream, BufferedOutputStream bufferedOutputStream, ZipInputStream zipInputStream, FileOutputStream fileOutputStream) throws IOException {
        C11837k.m70680c(fileInputStream);
        C11837k.m70681d(bufferedOutputStream);
        C11837k.m70680c(zipInputStream);
        C11837k.m70681d(fileOutputStream);
    }

    /* renamed from: b */
    public static String m70894b(String str) {
        String str2 = File.separator;
        return (!str.endsWith(str2) || str.length() <= str2.length()) ? str : str.substring(0, str.length() - str2.length());
    }

    /* renamed from: c */
    public static boolean m70895c(String str, String str2, long j10, int i10) throws C1413j {
        if (TextUtils.isEmpty(str) || str.contains(FeedbackWebConstants.INVALID_FILE_NAME_PRE) || str.contains("..\\")) {
            C11839m.m70687e("ZipUtil", "zip file is not valid");
            return false;
        }
        if (TextUtils.isEmpty(str2) || str2.contains(FeedbackWebConstants.INVALID_FILE_NAME_PRE) || str2.contains("..\\")) {
            C11839m.m70687e("ZipUtil", "target directory is not valid");
            return false;
        }
        if (m70896d(str, j10, i10)) {
            return true;
        }
        C11839m.m70687e("ZipUtil", "zip file contains valid chars or too many files");
        throw new C1413j("unsecure zipfile!");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:18:0x0046
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    public static boolean m70896d(java.lang.String r17, long r18, int r20) {
        /*
            java.lang.String r1 = "close zipFile IOException "
            java.lang.String r2 = "ZipUtil"
            r3 = 0
            r4 = 0
            java.util.zip.ZipFile r5 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            r0 = r17
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            java.util.Enumeration r0 = r5.entries()     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3e
            r6 = 0
            r3 = r4
        L14:
            boolean r8 = r0.hasMoreElements()     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3e
            r9 = 1
            if (r8 == 0) goto L41
            java.lang.Object r8 = r0.nextElement()     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3e
            r16 = r8
            java.util.zip.ZipEntry r16 = (java.util.zip.ZipEntry) r16     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3e
            long r10 = r16.getSize()     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3e
            long r6 = r6 + r10
            int r3 = r3 + r9
            r10 = r18
            r12 = r20
            r13 = r3
            r14 = r6
            boolean r8 = m70901i(r10, r12, r13, r14, r16)     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3e
            if (r8 == 0) goto L14
            java.lang.String r0 = "File name is invalid or too many files or too big"
            p514o9.C11839m.m70687e(r2, r0)     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3e
            goto L42
        L3b:
            r0 = move-exception
            r3 = r5
            goto L6b
        L3e:
            r0 = move-exception
            r3 = r5
            goto L4d
        L41:
            r4 = r9
        L42:
            r5.close()     // Catch: java.io.IOException -> L46
            goto L6a
        L46:
            p514o9.C11839m.m70687e(r2, r1)
            goto L6a
        L4a:
            r0 = move-exception
            goto L6b
        L4c:
            r0 = move-exception
        L4d:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4a
            r5.<init>()     // Catch: java.lang.Throwable -> L4a
            java.lang.String r6 = "not a valid zip file"
            r5.append(r6)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L4a
            r5.append(r0)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Throwable -> L4a
            p514o9.C11839m.m70687e(r2, r0)     // Catch: java.lang.Throwable -> L4a
            if (r3 == 0) goto L6a
            r3.close()     // Catch: java.io.IOException -> L46
        L6a:
            return r4
        L6b:
            if (r3 == 0) goto L74
            r3.close()     // Catch: java.io.IOException -> L71
            goto L74
        L71:
            p514o9.C11839m.m70687e(r2, r1)
        L74:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p514o9.C11843q.m70896d(java.lang.String, long, int):boolean");
    }

    /* renamed from: e */
    public static boolean m70897e(File file) {
        if (file == null) {
            C11839m.m70687e("ZipUtil", "File is null");
            return true;
        }
        if (file.isFile()) {
            if (file.delete()) {
                return true;
            }
            C11839m.m70687e("ZipUtil", "delete file error");
            return false;
        }
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                C11839m.m70686d("ZipUtil", "delete result:" + file.delete());
            } else {
                for (File file2 : fileArrListFiles) {
                    m70897e(file2);
                }
                C11839m.m70686d("ZipUtil", "delete1 result:" + file.delete());
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x011c  */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m70898f(java.lang.String r10, java.lang.String r11, long r12, int r14, boolean r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p514o9.C11843q.m70898f(java.lang.String, java.lang.String, long, int, boolean):boolean");
    }

    /* renamed from: g */
    public static boolean m70899g(String str, String str2, boolean z10) throws C1413j {
        return m70898f(str, str2, Constants.WEB_VIEW_CACHE_TOTAL_MAX_SIZE, 500, z10);
    }

    /* renamed from: h */
    public static boolean m70900h(List<File> list) {
        try {
            Iterator<File> it = list.iterator();
            while (it.hasNext()) {
                m70897e(it.next());
            }
            return true;
        } catch (Exception e10) {
            C11839m.m70687e("ZipUtil", "unzip fail delete file failed" + e10.getMessage());
            return false;
        }
    }

    /* renamed from: i */
    public static boolean m70901i(long j10, int i10, int i11, long j11, ZipEntry zipEntry) {
        return zipEntry.getName().contains(FeedbackWebConstants.INVALID_FILE_NAME_PRE) || zipEntry.getName().contains("..\\") || i11 >= i10 || j11 > j10 || zipEntry.getSize() == -1;
    }
}
