package com.huawei.android.dynamicfeature.plugin.language;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import p250e7.C9419a;

/* renamed from: com.huawei.android.dynamicfeature.plugin.language.f */
/* loaded from: classes2.dex */
public class C2398f {

    /* renamed from: c */
    public static final String f11479c = "f";

    /* renamed from: d */
    public static volatile C2398f f11480d;

    /* renamed from: a */
    public File f11481a;

    /* renamed from: b */
    public long f11482b;

    public C2398f(Context context, String str) {
        this.f11482b = -1L;
        Context contextM14991b = C2396d.m14991b(context);
        try {
            this.f11481a = new File(contextM14991b.getFilesDir().getCanonicalPath() + File.separator + str);
            this.f11482b = (long) contextM14991b.getPackageManager().getPackageInfo(contextM14991b.getPackageName(), 128).versionCode;
        } catch (PackageManager.NameNotFoundException e10) {
            C9419a.m59083i(f11479c, "get package info NameNotFoundException:", e10.getMessage());
        } catch (IOException e11) {
            C9419a.m59083i(f11479c, "getCanonicalPath IOException:", e11.getMessage());
        } catch (Exception e12) {
            C9419a.m59083i(f11479c, "get package info Exception:", e12.getMessage());
        }
    }

    /* renamed from: b */
    public static void m14994b(File file) {
        File[] fileArrListFiles;
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                m14994b(file2);
            }
        }
        if (!file.exists() || file.delete()) {
            return;
        }
        C9419a.m59076b(f11479c, "failed to delete " + file.getName());
    }

    /* renamed from: c */
    public static File m14995c(File file) throws IOException {
        String canonicalPath;
        if (file.exists()) {
            if (file.isDirectory()) {
                return file;
            }
            C9419a.m59081g(f11479c, "File input must be directory when it exists, need delete");
            m14994b(file);
            return null;
        }
        if (!file.mkdirs()) {
            try {
                canonicalPath = file.getCanonicalPath();
            } catch (IOException e10) {
                C9419a.m59077c(f11479c, "getDir file getCanonicalPath IOException: " + e10.getMessage());
                canonicalPath = null;
            }
            if (!TextUtils.isEmpty(canonicalPath)) {
                C9419a.m59076b(f11479c, "Unable to create directory: " + canonicalPath);
                return null;
            }
        }
        return file;
    }

    /* renamed from: d */
    public static C2398f m14996d(Context context, String str) {
        if (f11480d == null) {
            synchronized (C2398f.class) {
                try {
                    if (f11480d == null) {
                        f11480d = new C2398f(context, str);
                    }
                } finally {
                }
            }
        }
        return f11480d;
    }

    /* renamed from: a */
    public final void m14997a() {
        String[] list;
        File fileM14998e = m14998e();
        if (fileM14998e == null || (list = fileM14998e.list()) == null) {
            return;
        }
        C9419a.m59080f(f11479c, "begin clean old  VersionSplits ...");
        for (String str : list) {
            if (!TextUtils.equals(str, String.valueOf(this.f11482b))) {
                C9419a.m59076b(f11479c, "begin clean old  VersionSplits " + str);
                m14994b(new File(fileM14998e, str));
            }
        }
    }

    /* renamed from: e */
    public File m14998e() {
        return m14995c(new File(this.f11481a, "splitcompat"));
    }

    /* renamed from: f */
    public File m14999f() {
        return m14995c(new File(m15000g(), "verified-splits"));
    }

    /* renamed from: g */
    public File m15000g() {
        return m14995c(new File(m14998e(), Long.toString(this.f11482b)));
    }
}
