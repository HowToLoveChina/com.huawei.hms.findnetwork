package p346hs;

import android.text.TextUtils;
import as.C1016d;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import es.C9551p;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import p301fy.C9797o;
import p301fy.C9802t;

/* renamed from: hs.b */
/* loaded from: classes8.dex */
public class C10337b implements InterfaceC10336a {

    /* renamed from: a */
    public boolean f50020a = m63655g();

    /* renamed from: e */
    public static boolean m63649e(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "isContainInvalidStr: name is null";
        } else if (str.contains(FeedbackWebConstants.INVALID_FILE_NAME_PRE) || str.contains("..\\")) {
            str2 = "isContainInvalidStr: ../ or ..\\";
        } else if (str.contains("..") || str.contains("./")) {
            str2 = "isContainInvalidStr: .. or ./";
        } else {
            if (!str.contains(".\\.\\") && !str.contains("%00")) {
                return false;
            }
            str2 = "isContainInvalidStr: .\\.\\ or %00";
        }
        C1016d.m6183c("Un7Z", str2);
        return true;
    }

    /* renamed from: f */
    public static boolean m63650f(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str) || m63649e(str)) {
            str3 = "zip file is not valid";
        } else if (TextUtils.isEmpty(str2) || m63649e(str2)) {
            str3 = "target directory is not valid";
        } else {
            if (m63651i(str, Constants.WEB_VIEW_CACHE_TOTAL_MAX_SIZE, 1000)) {
                return true;
            }
            str3 = "zip file contains invalid chars or too many files";
        }
        C1016d.m6183c("Un7Z", str3);
        return false;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:91:0x0070
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* renamed from: i */
    public static boolean m63651i(java.lang.String r11, long r12, int r14) {
        /*
            java.lang.String r0 = "close zipFile IOException "
            java.lang.String r1 = "Un7Z"
            r2 = 0
            r3 = 0
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L17 java.io.IOException -> L65
            r4.<init>(r11)     // Catch: java.lang.Throwable -> L17 java.io.IOException -> L65
            boolean r11 = r4.exists()     // Catch: java.lang.Throwable -> L17 java.io.IOException -> L65
            if (r11 != 0) goto L19
            java.lang.String r11 = "Decompress7zFromPath: has no .7zfile"
            as.C1016d.m6183c(r1, r11)     // Catch: java.lang.Throwable -> L17 java.io.IOException -> L65
            return r3
        L17:
            r11 = move-exception
            goto L74
        L19:
            fy.t r11 = new fy.t     // Catch: java.lang.Throwable -> L17 java.io.IOException -> L65
            r11.<init>(r4)     // Catch: java.lang.Throwable -> L17 java.io.IOException -> L65
            java.lang.Iterable r2 = r11.m60950u()     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L64
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L64
            r4 = 0
            r6 = r3
        L29:
            boolean r7 = r2.hasNext()     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L64
            r8 = 1
            if (r7 == 0) goto L5f
            java.lang.Object r7 = r2.next()     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L64
            fy.o r7 = (p301fy.C9797o) r7     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L64
            long r9 = r7.m60888j()     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L64
            long r4 = r4 + r9
            int r6 = r6 + r8
            java.lang.String r8 = r7.m60887i()     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L64
            boolean r8 = m63649e(r8)     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L64
            if (r8 != 0) goto L59
            if (r6 >= r14) goto L59
            int r8 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r8 > 0) goto L59
            long r7 = r7.m60888j()     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L64
            r9 = -1
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 != 0) goto L29
            goto L59
        L57:
            r12 = move-exception
            goto L76
        L59:
            java.lang.String r12 = "File name is invalid or too many files or too big"
            as.C1016d.m6183c(r1, r12)     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L64
            goto L60
        L5f:
            r3 = r8
        L60:
            r11.close()     // Catch: java.io.IOException -> L70
            goto L73
        L64:
            r2 = r11
        L65:
            java.lang.String r11 = "not a valid zip file, IOException"
            as.C1016d.m6183c(r1, r11)     // Catch: java.lang.Throwable -> L17
            if (r2 == 0) goto L73
            r2.close()     // Catch: java.io.IOException -> L70
            goto L73
        L70:
            as.C1016d.m6183c(r1, r0)
        L73:
            return r3
        L74:
            r12 = r11
            r11 = r2
        L76:
            if (r11 == 0) goto L7f
            r11.close()     // Catch: java.io.IOException -> L7c
            goto L7f
        L7c:
            as.C1016d.m6183c(r1, r0)
        L7f:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: p346hs.C10337b.m63651i(java.lang.String, long, int):boolean");
    }

    @Override // p346hs.InterfaceC10336a
    /* renamed from: a */
    public boolean mo63648a(String str, String str2) {
        return m63654d(str, str2, null, null);
    }

    /* renamed from: b */
    public final void m63652b(String str, C9797o c9797o, C9802t c9802t, List<String> list, List<String> list2) throws IOException {
        File file = new File(str, c9797o.m60887i());
        if (file.exists()) {
            try {
                C1016d.m6186f("Un7Z", "file is exists, do delete:" + file.delete());
            } catch (Exception unused) {
                C1016d.m6183c("Un7Z", "The file exists, but an exception occurred while deleting it");
            }
        } else {
            C1016d.m6186f("Un7Z", "file is not exists");
        }
        File parentFile = file.getParentFile();
        if (list != null && parentFile != null && !list.contains(parentFile.getName())) {
            return;
        }
        if (list2 != null && !list2.contains(c9797o.m60887i())) {
            return;
        }
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i10 = c9802t.read(bArr);
                if (i10 == -1) {
                    bufferedOutputStream.close();
                    C1016d.m6186f("Un7Z", "set read only result: " + file.setReadOnly());
                    return;
                }
                bufferedOutputStream.write(bArr, 0, i10);
            }
        } catch (Throwable th2) {
            try {
                bufferedOutputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    /* renamed from: c */
    public final void m63653c(String str, C9797o c9797o, List<String> list) {
        File file = new File(str, c9797o.m60887i());
        if ((list == null || list.contains(c9797o.m60887i())) && !file.exists()) {
            file.mkdirs();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:124:0x00b6
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v14, types: [hs.b] */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v9, types: [boolean] */
    /* renamed from: d */
    public boolean m63654d(java.lang.String r12, java.lang.String r13, java.util.List<java.lang.String> r14, java.util.List<java.lang.String> r15) {
        /*
            r11 = this;
            java.lang.String r0 = "SevenZFile close : IOException"
            boolean r1 = r11.m63656h(r12)
            r2 = 0
            java.lang.String r3 = "Un7Z"
            if (r1 != 0) goto L11
            java.lang.String r11 = "Decompress7zFromPath:  path or inputFile not support"
        Ld:
            as.C1016d.m6183c(r3, r11)
            return r2
        L11:
            boolean r1 = m63650f(r12, r13)
            if (r1 != 0) goto L1a
            java.lang.String r11 = "Decompress7zFromPath:  path or inputFile invalid"
            goto Ld
        L1a:
            java.lang.String r1 = java.io.File.separator
            boolean r4 = r13.endsWith(r1)
            if (r4 == 0) goto L39
            int r4 = r13.length()
            int r5 = r1.length()
            if (r4 <= r5) goto L39
            int r4 = r13.length()
            int r1 = r1.length()
            int r4 = r4 - r1
            java.lang.String r13 = r13.substring(r2, r4)
        L39:
            java.io.File r1 = new java.io.File
            r1.<init>(r12)
            boolean r12 = r1.exists()
            if (r12 != 0) goto L4b
            java.lang.String r12 = "Decompress7zFromPath: has no .7zfile"
            as.C1016d.m6183c(r3, r12)
            r12 = r2
            goto L4c
        L4b:
            r12 = 1
        L4c:
            r4 = 0
            fy.t r10 = new fy.t     // Catch: java.lang.Throwable -> La9 java.io.IOException -> Lab
            r10.<init>(r1)     // Catch: java.lang.Throwable -> La9 java.io.IOException -> Lab
        L52:
            fy.o r6 = r10.m60952x()     // Catch: java.lang.Throwable -> L8d java.io.IOException -> La7
            if (r6 == 0) goto La2
            java.lang.String r1 = r6.m60887i()     // Catch: java.lang.Throwable -> L8d java.io.IOException -> La7
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L8d java.io.IOException -> La7
            if (r4 == 0) goto L63
            goto L52
        L63:
            java.lang.String r4 = "\\\\"
            java.lang.String r5 = "/"
            java.lang.String r1 = r1.replaceAll(r4, r5)     // Catch: java.lang.Throwable -> L8d java.io.IOException -> La7
            java.text.Normalizer$Form r4 = java.text.Normalizer.Form.NFKC     // Catch: java.lang.Throwable -> L8d java.io.IOException -> La7
            java.lang.String r1 = java.text.Normalizer.normalize(r1, r4)     // Catch: java.lang.Throwable -> L8d java.io.IOException -> La7
            boolean r4 = m63649e(r1)     // Catch: java.lang.Throwable -> L8d java.io.IOException -> La7
            if (r4 == 0) goto L8f
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8d java.io.IOException -> La7
            r11.<init>()     // Catch: java.lang.Throwable -> L8d java.io.IOException -> La7
            java.lang.String r12 = "zipPath is a invalid path: "
            r11.append(r12)     // Catch: java.lang.Throwable -> L8d java.io.IOException -> La7
            r11.append(r1)     // Catch: java.lang.Throwable -> L8d java.io.IOException -> La7
            java.lang.String r11 = r11.toString()     // Catch: java.lang.Throwable -> L8d java.io.IOException -> La7
            as.C1016d.m6183c(r3, r11)     // Catch: java.lang.Throwable -> L8d java.io.IOException -> La7
            goto La3
        L8d:
            r11 = move-exception
            goto Lbb
        L8f:
            boolean r1 = r6.m60890l()     // Catch: java.lang.Throwable -> L8d java.io.IOException -> La7
            if (r1 == 0) goto L99
            r11.m63653c(r13, r6, r14)     // Catch: java.lang.Throwable -> L8d java.io.IOException -> La7
            goto L52
        L99:
            r4 = r11
            r5 = r13
            r7 = r10
            r8 = r14
            r9 = r15
            r4.m63652b(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L8d java.io.IOException -> La7
            goto L52
        La2:
            r2 = r12
        La3:
            r10.close()     // Catch: java.io.IOException -> Lb6
            goto Lb9
        La7:
            r4 = r10
            goto Lab
        La9:
            r11 = move-exception
            goto Lba
        Lab:
            java.lang.String r11 = "decompress7zFromPath : IOException"
            as.C1016d.m6183c(r3, r11)     // Catch: java.lang.Throwable -> La9
            if (r4 == 0) goto Lb9
            r4.close()     // Catch: java.io.IOException -> Lb6
            goto Lb9
        Lb6:
            as.C1016d.m6183c(r3, r0)
        Lb9:
            return r2
        Lba:
            r10 = r4
        Lbb:
            if (r10 == 0) goto Lc4
            r10.close()     // Catch: java.io.IOException -> Lc1
            goto Lc4
        Lc1:
            as.C1016d.m6183c(r3, r0)
        Lc4:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: p346hs.C10337b.m63654d(java.lang.String, java.lang.String, java.util.List, java.util.List):boolean");
    }

    /* renamed from: g */
    public final boolean m63655g() {
        return C9551p.m59639c(C9551p.m59638b("java.io.File"), "toPath", new Class[0]) != null;
    }

    /* renamed from: h */
    public boolean m63656h(String str) {
        return str.contains(".7z") && this.f50020a;
    }
}
