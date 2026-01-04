package com.huawei.hms.feature.dynamic;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.common.util.ExtractNativeUtils;
import com.huawei.hms.common.util.Logger;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes8.dex */
public class AssetLoadManager {

    /* renamed from: a */
    public static final String f24589a = "AssetLoadManager";

    /* renamed from: b */
    public static final String f24590b = "dynamic_modules";

    /* renamed from: c */
    public static final String f24591c = ".apk";

    /* renamed from: d */
    public static final String f24592d = "com.huawei.hms.feature.dynamic.descriptors.";

    /* renamed from: e */
    public static final String f24593e = ".AssetModuleDescriptor";

    /* renamed from: a */
    public static int m31840a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            Logger.m30737e(f24589a, "Invalid context or moduleName.");
            return 0;
        }
        try {
            return context.getClassLoader().loadClass(f24592d + str + f24593e).getDeclaredField("MODULE_VERSION").getInt(null);
        } catch (ClassNotFoundException unused) {
            Logger.m30744w(f24589a, "Cannot get the class of module descriptor for " + str);
            return 0;
        } catch (Exception e10) {
            Logger.m30745w(f24589a, "Get local asset module info failed.", e10);
            return 0;
        }
    }

    /* renamed from: b */
    public static Bundle m31843b(Context context, String str) throws Throwable {
        try {
            String[] list = context.getAssets().list("dynamic_modules" + File.separator + str);
            if (list != null && list.length != 0) {
                String str2 = list[0];
                int iM31840a = m31840a(context, str);
                String strM31842a = m31842a(context, str, iM31840a, str2);
                if (!TextUtils.isEmpty(strM31842a) && new File(strM31842a).exists()) {
                    if (ExtractNativeUtils.m30726a(context, strM31842a) && ExtractNativeUtils.m30723a(new File(strM31842a), ModuleCopy.trimLastSection(strM31842a)) != 0) {
                        Logger.m30744w(f24589a, "Extract native to current dir failed.");
                        return new Bundle();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("module_name", str);
                    bundle.putString(InterfaceC5323b.f24687n, strM31842a);
                    bundle.putInt(InterfaceC5323b.f24686m, iM31840a);
                    Logger.m30740i(f24589a, "Get dynamic module info from asset success: ModuleName:" + str + ", ModuleVersion:" + iM31840a + ", ModulePath:" + strM31842a);
                    return bundle;
                }
                Logger.m30744w(f24589a, "Decompress module from assets failed.");
                return new Bundle();
            }
            Logger.m30744w(f24589a, "No module apk in asset path.");
            return new Bundle();
        } catch (Exception e10) {
            Logger.m30741i(f24589a, "getModuleFromAsset failed.", e10);
            return new Bundle();
        }
    }

    public static Bundle getAssetModuleInfo(Context context, String str) throws Throwable {
        if (context == null || TextUtils.isEmpty(str)) {
            Logger.m30744w(f24589a, "The context or moduleName is null.");
            return new Bundle();
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(ModuleCopy.getProtectedPath(context));
            String str2 = File.separator;
            sb2.append(str2);
            sb2.append("dynamic_modules");
            sb2.append(str2);
            sb2.append(str);
            File file = new File(sb2.toString());
            if (file.exists()) {
                Bundle bundleM31841a = m31841a(context, file, str);
                if (bundleM31841a.getInt(InterfaceC5323b.f24686m) > 0) {
                    Logger.m30740i(f24589a, "Successfully get module info from decompressed asset path.");
                    return bundleM31841a;
                }
            }
            Bundle bundleM31843b = m31843b(context, str);
            if (bundleM31843b.getInt(InterfaceC5323b.f24686m) > 0) {
                Logger.m30740i(f24589a, "Successfully get module info from asset.");
                return bundleM31843b;
            }
        } catch (Exception e10) {
            Logger.m30741i(f24589a, "getDataModuleInfo failed.", e10);
        }
        return new Bundle();
    }

    /* renamed from: a */
    public static Bundle m31841a(Context context, File file, String str) throws IOException {
        String[] list = file.list();
        if (list == null || list.length == 0) {
            Logger.m30744w(f24589a, "No version in module path.");
            return new Bundle();
        }
        int iMax = 0;
        for (String str2 : list) {
            iMax = Math.max(Integer.parseInt(str2), iMax);
        }
        if (iMax == 0) {
            Logger.m30744w(f24589a, "Cannot get module version path.");
            return new Bundle();
        }
        try {
            String canonicalPath = file.getCanonicalPath();
            ModuleCopy.clearLowVersionModule(iMax, canonicalPath, list, f24589a);
            if (m31840a(context, str) > iMax) {
                Logger.m30740i(f24589a, "There is a higher loader version in assets.");
                return new Bundle();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(canonicalPath);
            String str3 = File.separator;
            sb2.append(str3);
            sb2.append(iMax);
            sb2.append(str3);
            sb2.append(str);
            sb2.append(".apk");
            String string = sb2.toString();
            if (!new File(string).exists()) {
                Logger.m30744w(f24589a, "Cannot find module apk in asset decompressed path.");
                return new Bundle();
            }
            Bundle bundle = new Bundle();
            bundle.putString("module_name", str);
            bundle.putString(InterfaceC5323b.f24687n, string);
            bundle.putInt(InterfaceC5323b.f24686m, iMax);
            Logger.m30740i(f24589a, "Get module info from decompressed asset path success: ModuleName:" + str + ", ModuleVersion:" + iMax + ", ModulePath:" + string);
            return bundle;
        } catch (IOException e10) {
            Logger.m30744w(f24589a, "request modulePath error: " + e10.getMessage());
            return new Bundle();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [int] */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.io.Closeable, java.io.InputStream] */
    /* renamed from: a */
    public static String m31842a(Context context, String str, int i10, String str2) throws Throwable {
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream;
        Closeable closeable;
        Closeable closeable2;
        String str3;
        String str4;
        Closeable closeable3 = null;
        try {
            try {
                AssetManager assets = context.getAssets();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("dynamic_modules");
                str3 = File.separator;
                sb2.append(str3);
                sb2.append(str);
                sb2.append(str3);
                sb2.append((String) str2);
                str2 = assets.open(sb2.toString());
            } catch (Exception e10) {
                e = e10;
                str2 = 0;
            } catch (Throwable th2) {
                th = th2;
                str2 = 0;
            }
            try {
                bufferedInputStream = new BufferedInputStream(str2);
                try {
                    str4 = ModuleCopy.getProtectedPath(context) + str3 + "dynamic_modules" + str3 + str + str3 + ((int) i10);
                } catch (Exception e11) {
                    e = e11;
                    fileOutputStream = null;
                    closeable = str2;
                } catch (Throwable th3) {
                    th = th3;
                    ModuleCopy.closeQuietly(bufferedInputStream);
                    ModuleCopy.closeQuietly(closeable3);
                    ModuleCopy.closeQuietly(str2);
                    throw th;
                }
            } catch (Exception e12) {
                e = e12;
                fileOutputStream = null;
                bufferedInputStream = null;
                closeable = str2;
                Logger.m30745w(f24589a, "Cannot find module:" + str + " in assets.", e);
                ModuleCopy.closeQuietly(bufferedInputStream);
                ModuleCopy.closeQuietly(fileOutputStream);
                closeable2 = closeable;
                ModuleCopy.closeQuietly(closeable2);
                return null;
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
                ModuleCopy.closeQuietly(bufferedInputStream);
                ModuleCopy.closeQuietly(closeable3);
                ModuleCopy.closeQuietly(str2);
                throw th;
            }
            if (!new File(str4).exists() && !new File(str4).mkdirs()) {
                Logger.m30744w(f24589a, "mkdirs local loaderPath failed.");
                ModuleCopy.closeQuietly(bufferedInputStream);
                ModuleCopy.closeQuietly(null);
                closeable2 = str2;
                ModuleCopy.closeQuietly(closeable2);
                return null;
            }
            String str5 = str4 + str3 + str + ".apk";
            fileOutputStream = new FileOutputStream(str5);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i11 = bufferedInputStream.read(bArr, 0, 4096);
                    if (i11 == -1) {
                        Logger.m30740i(f24589a, "Decompress module:" + str + " from assets success.");
                        ModuleCopy.closeQuietly(bufferedInputStream);
                        ModuleCopy.closeQuietly(fileOutputStream);
                        ModuleCopy.closeQuietly(str2);
                        return str5;
                    }
                    fileOutputStream.write(bArr, 0, i11);
                }
            } catch (Exception e13) {
                e = e13;
                closeable = str2;
                Logger.m30745w(f24589a, "Cannot find module:" + str + " in assets.", e);
                ModuleCopy.closeQuietly(bufferedInputStream);
                ModuleCopy.closeQuietly(fileOutputStream);
                closeable2 = closeable;
                ModuleCopy.closeQuietly(closeable2);
                return null;
            }
        } catch (Throwable th5) {
            th = th5;
            closeable3 = i10;
        }
    }
}
