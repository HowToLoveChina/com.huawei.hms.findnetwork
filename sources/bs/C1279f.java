package bs;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreConstans;
import com.huawei.hiar.ARImageMetadata;
import com.huawei.hms.network.embedded.C5976k;
import com.huawei.location.base.activity.constant.ActivityRecognitionConstants;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import es.C9548m;
import es.C9552q;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p531or.C11991a;

/* renamed from: bs.f */
/* loaded from: classes8.dex */
public final class C1279f {

    /* renamed from: f */
    public static boolean f5725f = false;

    /* renamed from: b */
    public int f5727b;

    /* renamed from: c */
    public int f5728c;

    /* renamed from: d */
    public long f5729d;

    /* renamed from: a */
    public Map<String, C1276c> f5726a = new ConcurrentHashMap();

    /* renamed from: e */
    public String f5730e = null;

    /* renamed from: bs.f$b */
    public static class b implements Comparator<File>, Serializable {
        private static final long serialVersionUID = 1;

        public b() {
        }

        @Override // java.util.Comparator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return (int) (file.lastModified() - file2.lastModified());
        }
    }

    /* renamed from: i */
    public static String m7564i() {
        return "writeTime,transId,provider,latitude,longitude,accuracy,locationTime,speed,sessionId,sourceType,locateType,vendorType,src,switchHd,floor,floorAcc,buildingId" + System.lineSeparator();
    }

    /* renamed from: p */
    public static boolean m7565p() {
        return f5725f;
    }

    /* renamed from: r */
    public static /* synthetic */ boolean m7566r(File file, String str) {
        return str.startsWith(ActivityRecognitionConstants.LOCATION_MODULE) && str.endsWith(".csv") && str.length() == 28 && "_".equals(String.valueOf(str.charAt(17)));
    }

    /* renamed from: s */
    public static /* synthetic */ boolean m7567s(File file, String str) {
        return str.startsWith(ActivityRecognitionConstants.LOCATION_MODULE) && str.endsWith(".log") && str.length() == 28 && "_".equals(String.valueOf(str.charAt(17)));
    }

    /* renamed from: x */
    public static void m7568x(boolean z10) {
        f5725f = z10;
    }

    /* renamed from: c */
    public final void m7569c(C1276c c1276c, String str) throws IOException {
        String strM7554b = c1276c.m7554b();
        String strM7553a = c1276c.m7553a();
        if (!TextUtils.isEmpty(strM7554b)) {
            if (new File(strM7553a, strM7554b).exists()) {
                return;
            } else {
                Log.i("LogWrite", "writeToFile file is not exit");
            }
        }
        File file = new File(strM7553a);
        if (file.exists()) {
            m7584v(file, c1276c, str);
            return;
        }
        Log.i("LogWrite", "beforeWriteCheck None of the paths exist--Create a path--Create a file");
        c1276c.m7560h(false);
        m7570d(strM7553a);
        m7571e(c1276c, m7582t(str), str);
    }

    /* renamed from: d */
    public final void m7570d(String str) {
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        try {
            if (file.mkdirs()) {
                Log.i("LogWrite", "createFolder success");
                return;
            }
        } catch (SecurityException unused) {
            Log.e("LogWrite", "createFolder SecurityException:");
        }
        Log.e("LogWrite", "createFolder fail");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0049 A[Catch: all -> 0x002b, TryCatch #0 {, blocks: (B:10:0x0027, B:15:0x0034, B:17:0x0049, B:18:0x004c, B:20:0x0059, B:22:0x0063, B:23:0x0075, B:24:0x0086, B:14:0x002d), top: B:30:0x0025, inners: #1 }] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m7571e(bs.C1276c r9, java.lang.String r10, java.lang.String r11) throws java.io.IOException {
        /*
            r8 = this;
            java.lang.String r0 = "createNewLogFile:File creation complete logFileName:"
            java.lang.String r1 = r9.m7553a()
            java.io.BufferedWriter r2 = r9.m7555c()
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L8a
            boolean r3 = android.text.TextUtils.isEmpty(r10)
            if (r3 == 0) goto L17
            goto L8a
        L17:
            java.io.File r3 = new java.io.File
            r3.<init>(r1, r10)
            java.io.FileOutputStream r4 = new java.io.FileOutputStream
            r5 = 1
            r4.<init>(r3, r5)
            java.lang.Class<bs.f> r6 = bs.C1279f.class
            monitor-enter(r6)
            if (r2 == 0) goto L34
            r2.close()     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            goto L34
        L2b:
            r8 = move-exception
            goto L88
        L2d:
            java.lang.String r2 = "LogWrite"
            java.lang.String r7 = "createNewLogFile IOException"
            android.util.Log.e(r2, r7)     // Catch: java.lang.Throwable -> L2b
        L34:
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch: java.lang.Throwable -> L2b
            java.nio.charset.Charset r7 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L2b
            r2.<init>(r4, r7)     // Catch: java.lang.Throwable -> L2b
            java.io.BufferedWriter r4 = new java.io.BufferedWriter     // Catch: java.lang.Throwable -> L2b
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L2b
            r9.m7561i(r4)     // Catch: java.lang.Throwable -> L2b
            boolean r2 = r9.m7557e()     // Catch: java.lang.Throwable -> L2b
            if (r2 == 0) goto L4c
            r8.m7574h(r1, r11)     // Catch: java.lang.Throwable -> L2b
        L4c:
            r9.m7559g(r10)     // Catch: java.lang.Throwable -> L2b
            bs.C1279f.f5725f = r5     // Catch: java.lang.Throwable -> L2b
            java.lang.String r8 = "location"
            boolean r8 = r11.equals(r8)     // Catch: java.lang.Throwable -> L2b
            if (r8 == 0) goto L75
            long r1 = r3.length()     // Catch: java.lang.Throwable -> L2b
            r3 = 0
            int r8 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r8 != 0) goto L75
            java.io.BufferedWriter r8 = r9.m7555c()     // Catch: java.lang.Throwable -> L2b
            java.lang.String r11 = m7564i()     // Catch: java.lang.Throwable -> L2b
            r8.append(r11)     // Catch: java.lang.Throwable -> L2b
            java.io.BufferedWriter r8 = r9.m7555c()     // Catch: java.lang.Throwable -> L2b
            r8.flush()     // Catch: java.lang.Throwable -> L2b
        L75:
            java.lang.String r8 = "LogWrite"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2b
            r9.<init>(r0)     // Catch: java.lang.Throwable -> L2b
            r9.append(r10)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> L2b
            android.util.Log.i(r8, r9)     // Catch: java.lang.Throwable -> L2b
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L2b
            return
        L88:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L2b
            throw r8
        L8a:
            java.lang.String r8 = "LogWrite"
            java.lang.String r9 = "createNewLogFile Exception"
            android.util.Log.e(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bs.C1279f.m7571e(bs.c, java.lang.String, java.lang.String):void");
    }

    /* renamed from: f */
    public final boolean m7572f(File[] fileArr, int i10) {
        if (fileArr != null && fileArr.length > 0) {
            try {
                if (i10 == -1) {
                    for (int length = fileArr.length - 1; length >= 0; length--) {
                        if (!fileArr[length].delete()) {
                            Log.e("LogWrite", "deleteFiles result false");
                            return false;
                        }
                    }
                } else {
                    for (int i11 = i10 - 1; i11 >= 0; i11--) {
                        if (!fileArr[i11].delete()) {
                            Log.e("LogWrite", "deleteFiles result false");
                            return false;
                        }
                    }
                }
                return true;
            } catch (SecurityException unused) {
                Log.e("LogWrite", "deleteFiles SecurityException");
            }
        }
        return false;
    }

    /* renamed from: g */
    public final void m7573g(C1274a c1274a, C1276c c1276c) throws IOException {
        String strM7578m = m7578m(c1274a);
        BufferedWriter bufferedWriterM7555c = c1276c.m7555c();
        if (bufferedWriterM7555c != null) {
            bufferedWriterM7555c.append((CharSequence) strM7578m);
            bufferedWriterM7555c.flush();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m7574h(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r0 = "LogWrite"
            java.io.File r1 = new java.io.File
            r1.<init>(r6)
            java.io.File[] r6 = r5.m7575j(r1, r7)
            if (r6 == 0) goto L95
            int r7 = r6.length
            if (r7 <= 0) goto L95
            bs.f$b r7 = new bs.f$b     // Catch: java.lang.IllegalArgumentException -> L1a
            r1 = 0
            r7.<init>()     // Catch: java.lang.IllegalArgumentException -> L1a
            java.util.Arrays.sort(r6, r7)     // Catch: java.lang.IllegalArgumentException -> L1a
            goto L1f
        L1a:
            java.lang.String r7 = "Arrays sort IllegalArgumentException"
            android.util.Log.e(r0, r7)
        L1f:
            int r7 = r6.length     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            int r7 = r7 + (-1)
            r7 = r6[r7]     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            long r1 = r5.m7577l(r7)     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            long r3 = r3 - r1
            long r1 = r5.f5729d     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            int r7 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r7 <= 0) goto L3d
            java.lang.String r7 = "filesNumAndUsefulCheck:The latest saved files are more than maxFileExpired delete all files"
            android.util.Log.i(r0, r7)     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            r7 = -1
            r5.m7572f(r6, r7)     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            goto L86
        L3d:
            int r7 = r6.length     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            int r7 = r7 + (-1)
        L40:
            if (r7 < 0) goto L86
            r1 = r6[r7]     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            long r1 = r5.m7577l(r1)     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            long r3 = r3 - r1
            long r1 = r5.f5729d     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 <= 0) goto L7a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            r1.<init>()     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            java.lang.String r2 = "filesNumAndUsefulCheck:delete the exceed file:"
            r1.append(r2)     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            r2 = r6[r7]     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            java.lang.String r2 = r2.getName()     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            r1.append(r2)     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            android.util.Log.i(r0, r1)     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            r1 = r6[r7]     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            boolean r1 = r1.delete()     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
            if (r1 != 0) goto L7a
            java.lang.String r1 = "filesNumAndUsefulCheck:delete the exceed file result false"
            android.util.Log.e(r0, r1)     // Catch: java.lang.Exception -> L7d java.lang.SecurityException -> L83
        L7a:
            int r7 = r7 + (-1)
            goto L40
        L7d:
            java.lang.String r7 = "filesNumAndUsefulCheck:Exception"
        L7f:
            android.util.Log.i(r0, r7)
            goto L86
        L83:
            java.lang.String r7 = "filesNumAndUsefulCheck:SecurityException"
            goto L7f
        L86:
            int r7 = r6.length
            int r1 = r5.f5727b
            if (r7 < r1) goto L95
            int r7 = r6.length
            int r7 = r7 - r1
            java.lang.String r1 = "createNewLogFile Exceeded the maximum number of files--Delete the earliest file."
            android.util.Log.i(r0, r1)
            r5.m7572f(r6, r7)
        L95:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bs.C1279f.m7574h(java.lang.String, java.lang.String):void");
    }

    /* renamed from: j */
    public final File[] m7575j(File file, String str) {
        return file.listFiles(str.equals(JsbMapKeyNames.H5_LOC) ? new FilenameFilter() { // from class: bs.d
            @Override // java.io.FilenameFilter
            public final boolean accept(File file2, String str2) {
                return C1279f.m7566r(file2, str2);
            }
        } : new FilenameFilter() { // from class: bs.e
            @Override // java.io.FilenameFilter
            public final boolean accept(File file2, String str2) {
                return C1279f.m7567s(file2, str2);
            }
        });
    }

    /* renamed from: k */
    public final C1276c m7576k(String str) {
        if (this.f5726a.containsKey(str)) {
            return this.f5726a.get(str);
        }
        C1276c c1276c = new C1276c();
        String str2 = this.f5730e;
        if (!str.equals("log") && str.equals(JsbMapKeyNames.H5_LOC)) {
            str2 = this.f5730e + C1281h.f5732b + C1281h.f5733c;
        }
        c1276c.m7558f(str2);
        this.f5726a.put(str, c1276c);
        return c1276c;
    }

    /* renamed from: l */
    public final long m7577l(File file) throws SecurityException {
        return file.lastModified();
    }

    /* renamed from: m */
    public final String m7578m(C1274a c1274a) {
        if (c1274a.m7545a().equals(JsbMapKeyNames.H5_LOC)) {
            Locale locale = Locale.ENGLISH;
            return (c1274a.m7547c() + System.lineSeparator());
        }
        Locale locale2 = Locale.ENGLISH;
        return m7579n() + ": " + c1274a.m7546b() + "/" + c1274a.m7548d() + ": " + (c1274a.m7547c() + System.lineSeparator() + Log.getStackTraceString(c1274a.m7549e()));
    }

    /* renamed from: n */
    public final String m7579n() {
        return C1275b.m7550a(Calendar.getInstance().getTime(), "yy-MM-dd HH:mm:ss.SSS");
    }

    /* renamed from: o */
    public void m7580o(int i10, String str, int i11, int i12) {
        boolean z10;
        this.f5728c = i10 > 0 ? Math.min(i10, 2) * ARImageMetadata.SHADING_MODE : C5976k.e.f27211b;
        this.f5727b = i11 > 0 ? Math.min(i11, 20) : 20;
        this.f5729d = i12 > 0 ? Math.min(i12, 5) * 86400000 : 432000000L;
        if (str != null) {
            this.f5730e = str;
            z10 = true;
        } else {
            z10 = false;
        }
        m7568x(z10);
        Log.i("LogWrite", "LogWrite init complete");
    }

    /* renamed from: q */
    public final boolean m7581q(String str, String str2, String str3) {
        File file = new File(str2, str3);
        return str.equals(JsbMapKeyNames.H5_LOC) ? file.length() > ((long) ARImageMetadata.SHADING_MODE) : file.length() > ((long) this.f5728c);
    }

    /* renamed from: t */
    public final String m7582t(String str) {
        String str2 = str.equals(JsbMapKeyNames.H5_LOC) ? ".csv" : ".log";
        return "Location." + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Calendar.getInstance().getTime()) + str2;
    }

    /* renamed from: u */
    public final void m7583u(C1276c c1276c) throws IOException {
        BufferedWriter bufferedWriterM7555c = c1276c.m7555c();
        String strM7553a = c1276c.m7553a();
        String strM7554b = c1276c.m7554b();
        if (bufferedWriterM7555c == null) {
            if (TextUtils.isEmpty(strM7553a) || TextUtils.isEmpty(strM7554b)) {
                Log.e("LogWrite", "openLogFile Exception");
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(new File(strM7553a, strM7554b), true);
            synchronized (C1279f.class) {
                c1276c.m7561i(new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8)));
            }
        }
    }

    /* renamed from: v */
    public final void m7584v(File file, C1276c c1276c, String str) throws IOException {
        boolean zM7556d = c1276c.m7556d();
        String strM7553a = c1276c.m7553a();
        if (zM7556d) {
            m7574h(strM7553a, str);
            c1276c.m7560h(false);
        }
        File[] fileArrM7575j = m7575j(file, str);
        if (fileArrM7575j == null) {
            Log.e("LogWrite", "beforeWriteCheck  existedFiles is null");
            return;
        }
        if (fileArrM7575j.length == 0) {
            Log.i("LogWrite", "beforeWriteCheck  Path Exist -- No File -- Create File");
            c1276c.m7560h(false);
            m7571e(c1276c, m7582t(str), str);
        } else {
            try {
                Arrays.sort(fileArrM7575j, new b());
            } catch (IllegalArgumentException unused) {
                Log.e("LogWrite", "beforeWriteCheck Arrays sort IllegalArgumentException");
            }
            c1276c.m7559g(fileArrM7575j[fileArrM7575j.length - 1].getName());
        }
    }

    /* renamed from: w */
    public boolean m7585w(String str) {
        String str2;
        if (str.startsWith("/data/user") || str.startsWith(BackupRestoreConstans.DATA_PATH) || str.startsWith("data/data/") || str.startsWith("data/user")) {
            return true;
        }
        if (!C9548m.m59619b(C11991a.m72145a(), "android.permission.READ_EXTERNAL_STORAGE")) {
            str2 = "READ_EXTERNAL_PERMISSION Permission check unPass";
        } else {
            if (C9548m.m59619b(C11991a.m72145a(), "android.permission.WRITE_EXTERNAL_STORAGE")) {
                return true;
            }
            str2 = "WRITE_EXTERNAL_PERMISSION Permission check unPass";
        }
        Log.e("LogWrite", str2);
        return false;
    }

    /* renamed from: y */
    public void m7586y() {
        synchronized (C1279f.class) {
            Iterator<Map.Entry<String, C1276c>> it = this.f5726a.entrySet().iterator();
            while (it.hasNext()) {
                C1276c value = it.next().getValue();
                if (value != null && value.m7555c() != null) {
                    try {
                        value.m7555c().close();
                    } catch (IOException unused) {
                        Log.e("LogWrite", "shutdown IOException");
                    }
                    value.m7561i(null);
                }
            }
        }
    }

    /* renamed from: z */
    public void m7587z(C1274a c1274a) {
        C1276c c1276cM7576k;
        if (f5725f) {
            String strM7545a = c1274a.m7545a();
            synchronized (C1279f.class) {
                try {
                    c1276cM7576k = m7576k(strM7545a);
                } catch (IOException unused) {
                    Log.e("LogWrite", "writeToFile IOException");
                }
                if (C9552q.m59643a() != 100 || m7585w(this.f5730e)) {
                    m7569c(c1276cM7576k, strM7545a);
                    if (TextUtils.isEmpty(c1276cM7576k.m7554b())) {
                        return;
                    }
                    if (m7581q(strM7545a, c1276cM7576k.m7553a(), c1276cM7576k.m7554b())) {
                        c1276cM7576k.m7560h(true);
                        m7571e(c1276cM7576k, m7582t(strM7545a), strM7545a);
                    } else {
                        m7583u(c1276cM7576k);
                    }
                    m7573g(c1274a, c1276cM7576k);
                }
            }
        }
    }
}
