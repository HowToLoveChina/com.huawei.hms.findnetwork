package com.huawei.phoneservice.feedbackcommon.utils;

import android.content.Context;
import android.os.Process;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes5.dex */
public class AsCache {
    public static final String FEED_BACK_CACHE_FILE_NAME = "feedback";
    private static final int MAX_COUNT = Integer.MAX_VALUE;
    private static final int MAX_SIZE = 50000000;
    private static final char SEPARATOR = ' ';
    private static final String TAG = "AsCache";
    public static final int TIME_DAY = 86400;
    public static final int TIME_HOUR = 3600;
    private static Map<String, AsCache> mInstanceMap = new HashMap();
    private C8647b mCache;

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.AsCache$b */
    public static class C8647b {

        /* renamed from: a */
        public final AtomicLong f40266a;

        /* renamed from: b */
        public final AtomicInteger f40267b;

        /* renamed from: c */
        public final long f40268c;

        /* renamed from: d */
        public final int f40269d;

        /* renamed from: e */
        public final Map<File, Long> f40270e;

        /* renamed from: f */
        public File f40271f;

        /* renamed from: g */
        public ThreadPoolExecutor f40272g;

        /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.AsCache$b$a */
        public class a implements ThreadFactory {
            public a() {
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(AsCache.TAG);
            }
        }

        /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.AsCache$b$b */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                File[] fileArrListFiles = C8647b.this.f40271f.listFiles();
                if (fileArrListFiles != null) {
                    int iM53325a = 0;
                    int i10 = 0;
                    for (File file : fileArrListFiles) {
                        iM53325a = (int) (iM53325a + C8647b.this.m53325a(file));
                        i10++;
                        C8647b.this.f40270e.put(file, Long.valueOf(file.lastModified()));
                    }
                    C8647b.this.f40266a.set(iM53325a);
                    C8647b.this.f40267b.set(i10);
                }
            }
        }

        public C8647b(File file, long j10, int i10) {
            this.f40270e = Collections.synchronizedMap(new HashMap());
            this.f40271f = file;
            this.f40268c = j10;
            this.f40269d = i10;
            this.f40266a = new AtomicLong();
            this.f40267b = new AtomicInteger();
            this.f40272g = new ThreadPoolExecutor(2, 4, 100L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(2), new a());
            m53327e();
        }

        /* renamed from: a */
        public final long m53325a(File file) {
            if (file == null) {
                return 0L;
            }
            return file.length();
        }

        /* renamed from: c */
        public final File m53326c(String str) {
            File fileM53329j = m53329j(str);
            long jCurrentTimeMillis = System.currentTimeMillis();
            Long lValueOf = Long.valueOf(jCurrentTimeMillis);
            fileM53329j.setLastModified(jCurrentTimeMillis);
            this.f40270e.put(fileM53329j, lValueOf);
            return fileM53329j;
        }

        /* renamed from: e */
        public final void m53327e() {
            this.f40272g.execute(new b());
        }

        /* renamed from: g */
        public final long m53328g() {
            File key;
            if (this.f40270e.isEmpty()) {
                return 0L;
            }
            Set<Map.Entry<File, Long>> setEntrySet = this.f40270e.entrySet();
            synchronized (this.f40270e) {
                try {
                    key = null;
                    Long value = null;
                    for (Map.Entry<File, Long> entry : setEntrySet) {
                        if (key == null) {
                            key = entry.getKey();
                            value = entry.getValue();
                        } else {
                            Long value2 = entry.getValue();
                            if (value2.longValue() < value.longValue()) {
                                key = entry.getKey();
                                value = value2;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            long jM53325a = m53325a(key);
            if (key != null && key.delete()) {
                this.f40270e.remove(key);
            }
            return jM53325a;
        }

        /* renamed from: j */
        public final File m53329j(String str) {
            return new File(this.f40271f, str.hashCode() + "");
        }

        /* renamed from: l */
        public final void m53330l(File file) {
            int iAddAndGet = this.f40267b.get();
            while (iAddAndGet + 1 > this.f40269d) {
                this.f40266a.addAndGet(-m53328g());
                iAddAndGet = this.f40267b.addAndGet(-1);
            }
            this.f40267b.addAndGet(1);
            long jM53325a = m53325a(file);
            long jAddAndGet = this.f40266a.get();
            while (jAddAndGet + jM53325a > this.f40268c) {
                jAddAndGet = this.f40266a.addAndGet(-m53328g());
            }
            this.f40266a.addAndGet(jM53325a);
            long jCurrentTimeMillis = System.currentTimeMillis();
            Long lValueOf = Long.valueOf(jCurrentTimeMillis);
            file.setLastModified(jCurrentTimeMillis);
            this.f40270e.put(file, lValueOf);
        }

        /* renamed from: o */
        public final boolean m53331o(String str) {
            return m53326c(str).delete();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.AsCache$c */
    public static class C8648c {
        /* renamed from: a */
        public static int m53332a(byte[] bArr, char c10) {
            for (int i10 = 0; i10 < bArr.length; i10++) {
                if (bArr[i10] == c10) {
                    return i10;
                }
            }
            return -1;
        }

        /* renamed from: b */
        public static String m53333b(int i10) {
            String str = System.currentTimeMillis() + "";
            while (str.length() < 13) {
                str = "0" + str;
            }
            return str + "-" + i10 + AsCache.SEPARATOR;
        }

        /* renamed from: e */
        public static byte[] m53336e(byte[] bArr, int i10, int i11) {
            int i12 = i11 - i10;
            if (i12 >= 0) {
                byte[] bArr2 = new byte[i12];
                System.arraycopy(bArr, i10, bArr2, 0, Math.min(bArr.length - i10, i12));
                return bArr2;
            }
            throw new IllegalArgumentException(i10 + " > " + i11);
        }

        /* renamed from: f */
        public static String[] m53337f(byte[] bArr) {
            return m53340i(bArr) ? new String[]{new String(m53336e(bArr, 0, 13)), new String(m53336e(bArr, 14, m53332a(bArr, AsCache.SEPARATOR)))} : new String[0];
        }

        /* renamed from: g */
        public static String m53338g(int i10, String str) {
            return m53333b(i10) + str;
        }

        /* renamed from: i */
        public static boolean m53340i(byte[] bArr) {
            return bArr != null && bArr.length > 15 && bArr[13] == 45 && m53332a(bArr, AsCache.SEPARATOR) > 14;
        }

        /* renamed from: j */
        public static String m53341j(String str) {
            return (str == null || !m53340i(m53343l(str))) ? str : str.substring(str.indexOf(32) + 1, str.length());
        }

        /* renamed from: k */
        public static boolean m53342k(byte[] bArr) {
            String[] strArrM53337f = m53337f(bArr);
            if (strArrM53337f == null || strArrM53337f.length != 2) {
                return false;
            }
            String strSubstring = strArrM53337f[0];
            while (strSubstring.startsWith("0")) {
                strSubstring = strSubstring.substring(1);
            }
            return System.currentTimeMillis() > Long.parseLong(strSubstring) + (Long.parseLong(strArrM53337f[1]) * 1000);
        }

        /* renamed from: l */
        public static byte[] m53343l(String str) throws Throwable {
            try {
                return str.getBytes("utf-8");
            } catch (UnsupportedEncodingException e10) {
                FaqLogger.m51840e(AsCache.TAG, "UnsupportedEncodingException " + e10.getMessage());
                return new byte[0];
            }
        }

        /* renamed from: m */
        public static boolean m53344m(String str) {
            return m53342k(m53343l(str));
        }
    }

    private AsCache(File file, long j10, int i10) throws IOException {
        if (file.exists() || file.mkdirs()) {
            this.mCache = new C8647b(file, j10, i10);
            return;
        }
        throw new IOException("can't make dirs in " + file.getCanonicalPath());
    }

    public static AsCache get(Context context, String str) throws IOException, RuntimeException {
        return get(new File(context.getCacheDir(), str), 50000000L, Integer.MAX_VALUE);
    }

    private static String myPid() {
        return "_" + Process.myPid();
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getAsString(java.lang.String r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.String r0 = "AsCache"
            java.lang.String r1 = "getAsString failed "
            com.huawei.phoneservice.feedbackcommon.utils.AsCache$b r2 = r6.mCache
            java.io.File r2 = com.huawei.phoneservice.feedbackcommon.utils.AsCache.C8647b.m53320i(r2, r7)
            boolean r3 = r2.exists()
            r4 = 0
            if (r3 != 0) goto L12
            return r4
        L12:
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7b
            java.io.FileReader r5 = new java.io.FileReader     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7b
            r5.<init>(r2)     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7b
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2e
            r2.<init>()     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2e
        L21:
            java.lang.String r5 = r3.readLine()     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2e
            if (r5 == 0) goto L30
            r2.append(r5)     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2e
            goto L21
        L2b:
            r6 = move-exception
            goto Lb4
        L2e:
            r6 = move-exception
            goto L7d
        L30:
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2e
            boolean r5 = com.huawei.phoneservice.feedbackcommon.utils.AsCache.C8648c.m53335d(r2)     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2e
            if (r5 != 0) goto L5a
            java.lang.String r6 = com.huawei.phoneservice.feedbackcommon.utils.AsCache.C8648c.m53339h(r2)     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2e
            r3.close()     // Catch: java.io.IOException -> L42
            goto L59
        L42:
            r7 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r7 = r7.getMessage()
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            com.huawei.phoneservice.faq.base.util.FaqLogger.m51840e(r0, r7)
        L59:
            return r6
        L5a:
            r3.close()     // Catch: java.io.IOException -> L5e
            goto L75
        L5e:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r1 = r2.getMessage()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.huawei.phoneservice.faq.base.util.FaqLogger.m51840e(r0, r1)
        L75:
            r6.remove(r7)
            return r4
        L79:
            r6 = move-exception
            goto Lb3
        L7b:
            r6 = move-exception
            r3 = r4
        L7d:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb1
            r7.<init>()     // Catch: java.lang.Throwable -> Lb1
            r7.append(r1)     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r6 = r6.getMessage()     // Catch: java.lang.Throwable -> Lb1
            r7.append(r6)     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r6 = r7.toString()     // Catch: java.lang.Throwable -> Lb1
            com.huawei.phoneservice.faq.base.util.FaqLogger.m51840e(r0, r6)     // Catch: java.lang.Throwable -> Lb1
            if (r3 == 0) goto Lb0
            r3.close()     // Catch: java.io.IOException -> L99
            goto Lb0
        L99:
            r6 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r1)
            java.lang.String r6 = r6.getMessage()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.huawei.phoneservice.faq.base.util.FaqLogger.m51840e(r0, r6)
        Lb0:
            return r4
        Lb1:
            r6 = move-exception
            r4 = r3
        Lb3:
            r3 = r4
        Lb4:
            if (r3 == 0) goto Ld1
            r3.close()     // Catch: java.io.IOException -> Lba
            goto Ld1
        Lba:
            r7 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r7 = r7.getMessage()
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            com.huawei.phoneservice.faq.base.util.FaqLogger.m51840e(r0, r7)
        Ld1:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.phoneservice.feedbackcommon.utils.AsCache.getAsString(java.lang.String):java.lang.String");
    }

    public void put(Context context, String str, String str2) throws Throwable {
        FileWriter fileWriter;
        File file = new File(context.getCacheDir(), "feedback");
        if (!file.exists()) {
            file.mkdirs();
        }
        File fileM53329j = this.mCache.m53329j(str);
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(fileM53329j);
            try {
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter, 1024);
                    try {
                        bufferedWriter2.write(str2);
                        bufferedWriter2.flush();
                        fileWriter.flush();
                        try {
                            bufferedWriter2.close();
                        } catch (IOException e10) {
                            FaqLogger.m51840e(TAG, e10.getMessage());
                        }
                    } catch (IOException e11) {
                        e = e11;
                        bufferedWriter = bufferedWriter2;
                        FaqLogger.m51840e(TAG, "put failed " + e.getMessage());
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e12) {
                                FaqLogger.m51840e(TAG, e12.getMessage());
                            }
                        }
                        if (fileWriter != null) {
                            fileWriter.close();
                        }
                        this.mCache.m53330l(fileM53329j);
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e13) {
                                FaqLogger.m51840e(TAG, e13.getMessage());
                            }
                        }
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (IOException e14) {
                                FaqLogger.m51840e(TAG, e14.getMessage());
                            }
                        }
                        this.mCache.m53330l(fileM53329j);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException e15) {
                e = e15;
            }
        } catch (IOException e16) {
            e = e16;
            fileWriter = null;
        } catch (Throwable th4) {
            th = th4;
            fileWriter = null;
        }
        try {
            fileWriter.close();
        } catch (IOException e17) {
            FaqLogger.m51840e(TAG, e17.getMessage());
        }
        this.mCache.m53330l(fileM53329j);
    }

    public boolean remove(String str) {
        return this.mCache.m53331o(str);
    }

    public static AsCache get(File file, long j10, int i10) throws IOException, RuntimeException {
        AsCache asCache = mInstanceMap.get(file.getAbsoluteFile() + myPid());
        if (asCache != null) {
            return asCache;
        }
        AsCache asCache2 = new AsCache(file, j10, i10);
        mInstanceMap.put(file.getCanonicalPath() + myPid(), asCache2);
        return asCache2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Writer] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.Writer] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.FileWriter, java.io.Writer] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void put(java.lang.String r7, java.lang.String r8) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.String r0 = "AsCache"
            com.huawei.phoneservice.feedbackcommon.utils.AsCache$b r1 = r6.mCache
            java.io.File r7 = com.huawei.phoneservice.feedbackcommon.utils.AsCache.C8647b.m53316b(r1, r7)
            r1 = 0
            java.io.FileWriter r2 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f
            java.io.BufferedWriter r3 = new java.io.BufferedWriter     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            r4 = 1024(0x400, float:1.435E-42)
            r3.<init>(r2, r4)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            r3.write(r8)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L32
            r3.flush()     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L32
            r2.flush()     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L32
            r3.close()     // Catch: java.io.IOException -> L22
            goto L2a
        L22:
            r8 = move-exception
            java.lang.String r8 = r8.getMessage()
            com.huawei.phoneservice.faq.base.util.FaqLogger.m51840e(r0, r8)
        L2a:
            r2.close()     // Catch: java.io.IOException -> L2e
            goto L71
        L2e:
            r8 = move-exception
            goto L6a
        L30:
            r8 = move-exception
            goto L34
        L32:
            r8 = move-exception
            goto L36
        L34:
            r1 = r3
            goto L7e
        L36:
            r1 = r3
            goto L41
        L38:
            r8 = move-exception
            goto L7e
        L3a:
            r8 = move-exception
            goto L41
        L3c:
            r8 = move-exception
            r2 = r1
            goto L7b
        L3f:
            r8 = move-exception
            r2 = r1
        L41:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L77
            r3.<init>()     // Catch: java.lang.Throwable -> L77
            java.lang.String r4 = "put failed "
            r3.append(r4)     // Catch: java.lang.Throwable -> L77
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Throwable -> L77
            r3.append(r8)     // Catch: java.lang.Throwable -> L77
            java.lang.String r8 = r3.toString()     // Catch: java.lang.Throwable -> L77
            com.huawei.phoneservice.faq.base.util.FaqLogger.m51840e(r0, r8)     // Catch: java.lang.Throwable -> L77
            if (r1 == 0) goto L67
            r1.close()     // Catch: java.io.IOException -> L5f
            goto L67
        L5f:
            r8 = move-exception
            java.lang.String r8 = r8.getMessage()
            com.huawei.phoneservice.faq.base.util.FaqLogger.m51840e(r0, r8)
        L67:
            if (r2 == 0) goto L71
            goto L2a
        L6a:
            java.lang.String r8 = r8.getMessage()
            com.huawei.phoneservice.faq.base.util.FaqLogger.m51840e(r0, r8)
        L71:
            com.huawei.phoneservice.feedbackcommon.utils.AsCache$b r6 = r6.mCache
            com.huawei.phoneservice.feedbackcommon.utils.AsCache.C8647b.m53318f(r6, r7)
            return
        L77:
            r8 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
        L7b:
            r5 = r2
            r2 = r1
            r1 = r5
        L7e:
            if (r1 == 0) goto L8c
            r1.close()     // Catch: java.io.IOException -> L84
            goto L8c
        L84:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()
            com.huawei.phoneservice.faq.base.util.FaqLogger.m51840e(r0, r1)
        L8c:
            if (r2 == 0) goto L9a
            r2.close()     // Catch: java.io.IOException -> L92
            goto L9a
        L92:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()
            com.huawei.phoneservice.faq.base.util.FaqLogger.m51840e(r0, r1)
        L9a:
            com.huawei.phoneservice.feedbackcommon.utils.AsCache$b r6 = r6.mCache
            com.huawei.phoneservice.feedbackcommon.utils.AsCache.C8647b.m53318f(r6, r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.phoneservice.feedbackcommon.utils.AsCache.put(java.lang.String, java.lang.String):void");
    }

    public void put(String str, String str2, int i10) throws Throwable {
        put(str, C8648c.m53338g(i10, str2));
    }
}
