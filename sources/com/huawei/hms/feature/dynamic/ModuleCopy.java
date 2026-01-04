package com.huawei.hms.feature.dynamic;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.feature.dynamic.p119f.C5334d;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes8.dex */
public class ModuleCopy {

    /* renamed from: a */
    public static final String f24645a = "ModuleCopy";

    /* renamed from: b */
    public static final int f24646b = 2048;

    /* renamed from: c */
    public static final int f24647c = 0;

    /* renamed from: d */
    public static final int f24648d = 1;

    /* renamed from: e */
    public static final String f24649e = "module_uri_path";

    /* renamed from: f */
    public static final String f24650f = "loader_uri_path";

    /* renamed from: g */
    public static final String f24651g = "dynamic_modules";

    /* renamed from: h */
    public static final String f24652h = ".apk";

    /* renamed from: com.huawei.hms.feature.dynamic.ModuleCopy$a */
    public static class RunnableC5319a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f24653a;

        public RunnableC5319a(String str) {
            this.f24653a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ModuleCopy.m31882c(this.f24653a);
            } catch (SecurityException unused) {
                Logger.m30744w(ModuleCopy.f24645a, "Delete file failed: SecurityException.");
            }
        }
    }

    /* renamed from: com.huawei.hms.feature.dynamic.ModuleCopy$b */
    public static class RunnableC5320b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String[] f24654a;

        /* renamed from: b */
        public final /* synthetic */ int f24655b;

        /* renamed from: c */
        public final /* synthetic */ String f24656c;

        public RunnableC5320b(String[] strArr, int i10, String str) {
            this.f24654a = strArr;
            this.f24655b = i10;
            this.f24656c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (String str : this.f24654a) {
                if (Integer.parseInt(str) < this.f24655b) {
                    Logger.m30740i(ModuleCopy.f24645a, "Delete low version:" + this.f24655b + " in modulePath.");
                    ModuleCopy.m31882c(this.f24656c + File.separator + str);
                }
            }
        }
    }

    /* renamed from: a */
    public static int m31874a(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            Logger.m30740i(f24645a, "No version dirs in module path, need mkdir.");
            return 0;
        }
        int iMax = 0;
        for (String str : strArr) {
            iMax = Math.max(Integer.parseInt(str), iMax);
        }
        return iMax;
    }

    /* renamed from: b */
    public static void m31881b(String str) {
        C5324c.m31883a(1, "DeleteFile").execute(new RunnableC5319a(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m31882c(java.lang.String r9) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r9)
            boolean r1 = r0.isDirectory()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L42
            java.lang.String[] r1 = r0.list()
            if (r1 == 0) goto L42
            java.lang.String[] r1 = r0.list()
            int r4 = r1.length
            r5 = r2
            r6 = r3
        L1a:
            if (r5 >= r4) goto L40
            r7 = r1[r5]
            if (r6 == 0) goto L3c
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r9)
            java.lang.String r8 = java.io.File.separator
            r6.append(r8)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            boolean r6 = m31882c(r6)
            if (r6 == 0) goto L3c
            r6 = r3
            goto L3d
        L3c:
            r6 = r2
        L3d:
            int r5 = r5 + 1
            goto L1a
        L40:
            if (r6 == 0) goto L49
        L42:
            boolean r9 = r0.delete()
            if (r9 == 0) goto L49
            r2 = r3
        L49:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.feature.dynamic.ModuleCopy.m31882c(java.lang.String):boolean");
    }

    public static void clearLowVersionModule(int i10, String str, String[] strArr, String str2) {
        C5324c.m31883a(1, str2).execute(new RunnableC5320b(strArr, i10, str));
    }

    public static void closeQuietly(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                Logger.m30737e(f24645a, "An exception occurred while closing the 'Closeable' object.");
            }
        }
    }

    public static void copyModule(Context context, Bundle bundle) {
        if (context == null || bundle == null) {
            Logger.m30737e(f24645a, "The context or module info bundle is null.");
            return;
        }
        boolean zM31879a = m31879a(bundle);
        m31878a(context, bundle, 0);
        if (zM31879a) {
            bundle.putString(InterfaceC5323b.f24691r, bundle.getString(InterfaceC5323b.f24687n));
        } else {
            m31878a(context, bundle, 1);
        }
    }

    public static String getProtectedPath(Context context) throws IOException {
        return context.createDeviceProtectedStorageContext().getDataDir().getCanonicalPath();
    }

    public static boolean isLocalModuleFile(Context context, String str) throws IOException {
        if (context == null || TextUtils.isEmpty(str)) {
            Logger.m30744w(f24645a, "context or filePath is null.");
            return false;
        }
        try {
            return new File(str).getCanonicalPath().startsWith(getProtectedPath(context) + File.separator + "dynamic_modules");
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean makeDirectory(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return true;
            }
            return file.mkdirs();
        } catch (Exception e10) {
            Logger.m30737e(f24645a, "makeDirectory Exception: " + e10.getMessage());
            return false;
        }
    }

    public static String trimLastSection(String str) {
        int iLastIndexOf = str.lastIndexOf(File.separator);
        return iLastIndexOf <= 0 ? str : str.substring(0, iLastIndexOf);
    }

    /* renamed from: a */
    public static String m31875a(Context context, Bundle bundle, int i10, Uri uri) {
        String str;
        String string;
        String strValueOf;
        StringBuilder sb2;
        String[] list;
        int iM31874a;
        if (i10 == 0) {
            str = "module_name";
            string = bundle.getString("module_name");
            strValueOf = String.valueOf(bundle.getInt(InterfaceC5323b.f24684k));
            sb2 = new StringBuilder();
        } else {
            str = InterfaceC5323b.f24689p;
            string = bundle.getString(InterfaceC5323b.f24689p);
            strValueOf = String.valueOf(bundle.getInt(InterfaceC5323b.f24690q));
            sb2 = new StringBuilder();
        }
        sb2.append(bundle.getString(str));
        sb2.append(".apk");
        String string2 = sb2.toString();
        try {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(getProtectedPath(context));
            String str2 = File.separator;
            sb3.append(str2);
            sb3.append("dynamic_modules");
            sb3.append(str2);
            sb3.append(string);
            String string3 = sb3.toString();
            String str3 = string3 + str2 + strValueOf;
            String str4 = str3 + str2 + string2;
            if (new File(string3).exists() && (iM31874a = m31874a((list = new File(string3).list()))) >= Integer.parseInt(strValueOf)) {
                clearLowVersionModule(iM31874a, string3, list, f24645a);
                return string3 + str2 + iM31874a + str2 + string2;
            }
            return m31876a(context, str3, uri, str4);
        } catch (IOException e10) {
            Logger.m30744w(f24645a, "request modulePath error: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static String m31876a(Context context, String str, Uri uri, String str2) throws Throwable {
        if (!makeDirectory(str)) {
            Logger.m30737e(f24645a, "makeDirectory return false");
            return null;
        }
        m31877a(context, uri, str2);
        if (C5334d.m31901b(context, str2)) {
            return str2;
        }
        Logger.m30744w(f24645a, "The coped module apk is invalid.");
        m31881b(str2);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* renamed from: a */
    public static void m31877a(Context context, Uri uri, String str) throws Throwable {
        InputStream inputStreamOpenInputStream;
        IOException e10;
        FileNotFoundException e11;
        InputStream inputStream;
        StringBuilder sb2;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            } catch (FileNotFoundException e12) {
                e11 = e12;
                inputStreamOpenInputStream = null;
            } catch (IOException e13) {
                e10 = e13;
                inputStreamOpenInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                inputStreamOpenInputStream = null;
            }
            try {
                if (inputStreamOpenInputStream == null) {
                    Logger.m30744w(f24645a, "Get input stream failed: null.");
                    closeQuietly(inputStreamOpenInputStream);
                    closeQuietly(null);
                    return;
                }
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str));
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int i10 = inputStreamOpenInputStream.read(bArr);
                        if (i10 == -1) {
                            closeQuietly(inputStreamOpenInputStream);
                            closeQuietly(bufferedOutputStream2);
                            return;
                        }
                        bufferedOutputStream2.write(bArr, 0, i10);
                    }
                } catch (FileNotFoundException e14) {
                    bufferedOutputStream = bufferedOutputStream2;
                    e11 = e14;
                    sb2 = new StringBuilder();
                    sb2.append("FileNotFoundException:");
                    sb2.append(e11.getMessage());
                    context = inputStreamOpenInputStream;
                    Logger.m30737e(f24645a, sb2.toString());
                    closeQuietly(context);
                    closeQuietly(bufferedOutputStream);
                } catch (IOException e15) {
                    bufferedOutputStream = bufferedOutputStream2;
                    e10 = e15;
                    sb2 = new StringBuilder();
                    sb2.append("IOException ");
                    sb2.append(e10.getMessage());
                    context = inputStreamOpenInputStream;
                    Logger.m30737e(f24645a, sb2.toString());
                    closeQuietly(context);
                    closeQuietly(bufferedOutputStream);
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream = bufferedOutputStream2;
                    inputStream = inputStreamOpenInputStream;
                    closeQuietly(inputStream);
                    closeQuietly(bufferedOutputStream);
                    throw th;
                }
            } catch (FileNotFoundException e16) {
                e11 = e16;
            } catch (IOException e17) {
                e10 = e17;
            } catch (Throwable th4) {
                th = th4;
                th = th;
                inputStream = inputStreamOpenInputStream;
                closeQuietly(inputStream);
                closeQuietly(bufferedOutputStream);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStream = context;
        }
    }

    /* renamed from: a */
    public static void m31878a(Context context, Bundle bundle, int i10) {
        String string = bundle.getString(i10 == 0 ? f24649e : f24650f);
        Logger.m30740i(f24645a, "path:" + string);
        String strM31875a = m31875a(context, bundle, i10, Uri.parse(string));
        if (TextUtils.isEmpty(strM31875a)) {
            Logger.m30744w(f24645a, "checkModulePath failed: null.");
        } else {
            bundle.putString(i10 == 0 ? InterfaceC5323b.f24687n : InterfaceC5323b.f24691r, strM31875a);
        }
    }

    /* renamed from: a */
    public static boolean m31879a(Bundle bundle) {
        return TextUtils.equals(bundle.getString(InterfaceC5323b.f24687n), bundle.getString(InterfaceC5323b.f24691r));
    }
}
