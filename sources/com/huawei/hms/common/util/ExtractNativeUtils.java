package com.huawei.hms.common.util;

import android.content.Context;
import com.huawei.hms.feature.dynamic.ModuleCopy;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes8.dex */
public class ExtractNativeUtils {

    /* renamed from: a */
    public static final String f23535a = "ExtractNativeUtils";

    /* renamed from: b */
    public static final int f23536b = 0;

    /* renamed from: c */
    public static final int f23537c = -1;

    /* renamed from: d */
    public static final int f23538d = 50;

    /* renamed from: e */
    public static final int f23539e = 52428800;

    /* renamed from: f */
    public static final Pattern f23540f = Pattern.compile("lib/([^/]+)/(.*\\.so)$");

    /* renamed from: com.huawei.hms.common.util.ExtractNativeUtils$b */
    public static class C5155b {

        /* renamed from: a */
        public String f23541a;

        /* renamed from: b */
        public ZipEntry f23542b;

        /* renamed from: c */
        public String f23543c;

        public C5155b(ZipEntry zipEntry, String str, String str2) {
            this.f23542b = zipEntry;
            this.f23541a = str;
            this.f23543c = str2;
        }
    }

    /* renamed from: a */
    public static int m30723a(File file, String str) throws Throwable {
        Logger.m30740i(f23535a, "begin extractNativeLibrary");
        int i10 = 0;
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(file);
                try {
                    try {
                        Enumeration<? extends ZipEntry> enumerationEntries = zipFile2.entries();
                        HashMap map = new HashMap();
                        int iM30724a = m30724a(enumerationEntries, (HashMap<String, HashSet<C5155b>>) map, 0);
                        if (iM30724a == -1) {
                            Logger.m30737e(f23535a, "Unsafe zip name!");
                            try {
                                zipFile2.close();
                            } catch (IOException e10) {
                                Logger.m30738e(f23535a, "IOException:", e10);
                            }
                            return -1;
                        }
                        if (iM30724a > 50) {
                            Logger.m30737e(f23535a, "the total number is larger than the max");
                            try {
                                zipFile2.close();
                            } catch (IOException e11) {
                                Logger.m30738e(f23535a, "IOException:", e11);
                            }
                            return -1;
                        }
                        Iterator it = map.keySet().iterator();
                        int iM30725a = 0;
                        while (it.hasNext()) {
                            try {
                                Set<C5155b> set = (Set) map.get((String) it.next());
                                if (set == null) {
                                    Logger.m30737e(f23535a, "Get nativeZipEntries failed.");
                                    try {
                                        zipFile2.close();
                                    } catch (IOException e12) {
                                        Logger.m30738e(f23535a, "IOException:", e12);
                                    }
                                    return -1;
                                }
                                for (C5155b c5155b : set) {
                                    String str2 = str + File.separator + c5155b.f23543c;
                                    ModuleCopy.makeDirectory(str2);
                                    new File(str2).setExecutable(true, false);
                                    iM30725a = m30725a(zipFile2, c5155b, str2);
                                    if (iM30725a != 0) {
                                        try {
                                            zipFile2.close();
                                        } catch (IOException e13) {
                                            Logger.m30738e(f23535a, "IOException:", e13);
                                        }
                                        return iM30725a;
                                    }
                                    new File(str2, c5155b.f23541a).setReadable(true, false);
                                }
                            } catch (IOException e14) {
                                e = e14;
                                i10 = iM30725a;
                                zipFile = zipFile2;
                                Logger.m30738e(f23535a, "catch IOException ", e);
                                if (zipFile != null) {
                                    try {
                                        zipFile.close();
                                    } catch (IOException e15) {
                                        e = e15;
                                        iM30725a = i10;
                                        Logger.m30738e(f23535a, "IOException:", e);
                                        return iM30725a;
                                    }
                                }
                                return i10;
                            }
                        }
                        try {
                            zipFile2.close();
                            return iM30725a;
                        } catch (IOException e16) {
                            e = e16;
                            Logger.m30738e(f23535a, "IOException:", e);
                            return iM30725a;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        zipFile = zipFile2;
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException e17) {
                                Logger.m30738e(f23535a, "IOException:", e17);
                            }
                        }
                        throw th;
                    }
                } catch (IOException e18) {
                    e = e18;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e19) {
            e = e19;
        }
    }

    /* renamed from: a */
    public static int m30724a(Enumeration enumeration, HashMap<String, HashSet<C5155b>> map, int i10) {
        while (enumeration.hasMoreElements()) {
            Object objNextElement = enumeration.nextElement();
            if (objNextElement != null && (objNextElement instanceof ZipEntry)) {
                ZipEntry zipEntry = (ZipEntry) objNextElement;
                String name = zipEntry.getName();
                if (name.contains(FeedbackWebConstants.INVALID_FILE_NAME_PRE)) {
                    Logger.m30737e(f23535a, "Unsafe zip name!");
                    return -1;
                }
                Matcher matcher = f23540f.matcher(name);
                if (matcher.matches()) {
                    String strGroup = matcher.group(1);
                    String strGroup2 = matcher.group(2);
                    HashSet<C5155b> hashSet = map.get(strGroup);
                    if (hashSet == null) {
                        hashSet = new HashSet<>();
                        map.put(strGroup, hashSet);
                    }
                    hashSet.add(new C5155b(zipEntry, strGroup2, strGroup));
                    i10++;
                }
            }
        }
        return i10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x002d, code lost:
    
        com.huawei.hms.common.util.Logger.m30737e(com.huawei.hms.common.util.ExtractNativeUtils.f23535a, "so file too big , " + r10.f23543c + " , " + r10.f23541a);
     */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x00a4 -> B:77:0x00a7). Please report as a decompilation issue!!! */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m30725a(java.util.zip.ZipFile r9, com.huawei.hms.common.util.ExtractNativeUtils.C5155b r10, java.lang.String r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 193
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.common.util.ExtractNativeUtils.m30725a(java.util.zip.ZipFile, com.huawei.hms.common.util.ExtractNativeUtils$b, java.lang.String):int");
    }

    /* renamed from: a */
    public static boolean m30726a(Context context, String str) {
        try {
            if ((context.getPackageManager().getPackageArchiveInfo(str, 128).applicationInfo.flags & HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK) == 268435456) {
                Logger.m30740i(f23535a, "The extract-native-flag has set, need to extract.");
                return true;
            }
            Logger.m30740i(f23535a, "The extract-native-flag has not set, No need to extract.");
            return false;
        } catch (Exception unused) {
            Logger.m30744w(f23535a, "Get package name failed: name not found.");
            return true;
        }
    }
}
