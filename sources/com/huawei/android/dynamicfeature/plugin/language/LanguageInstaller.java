package com.huawei.android.dynamicfeature.plugin.language;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import p250e7.C9419a;
import p250e7.C9420b;
import p250e7.C9421c;

@TargetApi(21)
/* loaded from: classes2.dex */
public class LanguageInstaller {

    /* renamed from: e */
    public static final String f11467e = "LanguageInstaller";

    /* renamed from: a */
    public Context f11468a;

    /* renamed from: b */
    public C2398f f11469b;

    /* renamed from: c */
    public C9420b.a f11470c;

    /* renamed from: d */
    public Set<String> f11471d = new HashSet();

    public LanguageInstaller(Context context) {
        this.f11470c = C9420b.m59088b(context);
        this.f11469b = C2398f.m14996d(context, "hw");
        this.f11468a = context;
    }

    /* renamed from: f */
    public static Set<String> m14966f(Context context) {
        if (context instanceof ContextWrapper) {
            ContextWrapper contextWrapper = (ContextWrapper) context;
            if (contextWrapper.getBaseContext() != null) {
                context = contextWrapper.getBaseContext();
            }
        }
        String str = f11467e;
        C9419a.m59080f(str, "getDeviceLanguageTags context is:" + context.getPackageName());
        HashSet hashSet = new HashSet();
        boolean zM14967g = m14967g();
        int i10 = Build.VERSION.SDK_INT;
        LocaleList locales = context.getResources().getConfiguration().getLocales();
        String strM14968h = m14968h(Locale.forLanguageTag(locales.get(0).getLanguage()).getLanguage(), locales.get(0).getCountry(), locales.get(0).getScript(), zM14967g);
        hashSet.add(strM14968h);
        C9419a.m59080f(str, "getDeviceLanguageTags languageTags:" + strM14968h + " SDK version is :" + i10);
        return hashSet;
    }

    /* renamed from: g */
    public static boolean m14967g() {
        return C2403k.m15009d().equals(FaqConstants.DISABLE_HA_REPORT);
    }

    /* renamed from: h */
    public static String m14968h(String str, String str2, String str3, boolean z10) {
        if (!z10) {
            C9419a.m59080f(f11467e, "isRegionCompress is false, return Language only");
            return str;
        }
        if ("zh".equals(str) && ("HK".equals(str2) || "TW".equals(str2))) {
            return str + "-" + str2;
        }
        if ("zh".equals(str) && "Hant".equals(str3)) {
            return "zh-HK";
        }
        if (FaqConstants.DEFAULT_ISO_LANGUAGE.equals(str) && ("AU".equals(str2) || "CA".equals(str2) || "GB".equals(str2) || "US".equals(str2))) {
            return str + "-" + str2;
        }
        if ("zz".equals(str)) {
            return "zz-ZX";
        }
        if ("bo".equals(str)) {
            return "bo-CN";
        }
        if ("es".equals(str) && "US".equals(str2)) {
            return "es-US";
        }
        if (!"my".equals(str) || (!"ZG".equals(str2) && !"MM".equals(str2))) {
            return ("my".equals(str) && "Qaag".equals(str3)) ? "my-Qaag" : ("pt".equals(str) && "PT".equals(str2)) ? "pt-PT" : ("sr".equals(str) && "Latn".equals(str3)) ? "sr-Latn" : ("jv".equals(str) && "Latn".equals(str3)) ? "jv-Latn" : str;
        }
        return str + "-" + str2;
    }

    /* renamed from: i */
    public static String m14969i(Locale locale, boolean z10) {
        return m14968h(Locale.getDefault().getLanguage(), Locale.getDefault().getCountry(), Locale.getDefault().getScript(), z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:143:0x00ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x00fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:162:? A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:115:0x00bf -> B:153:0x00eb). Please report as a decompilation issue!!! */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m14970a(java.lang.String r11, java.io.InputStream r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.dynamicfeature.plugin.language.LanguageInstaller.m14970a(java.lang.String, java.io.InputStream):void");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:72:0x00b1 -> B:85:0x00c3). Please report as a decompilation issue!!! */
    /* renamed from: b */
    public final void m14971b(String str, String str2) throws Throwable {
        ZipFile zipFile = null;
        try {
            try {
                try {
                    File file = new File(this.f11469b.m14999f(), str + "decompressed-langs.zip");
                    if (!file.exists()) {
                        C2403k.m15007b(this.f11468a);
                    }
                    ZipFile zipFile2 = new ZipFile(file);
                    try {
                        String str3 = f11467e;
                        C9419a.m59080f(str3, "copyLanguageFromZip copy " + str + str2 + " .lpk");
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(TextUtils.isEmpty(str) ? "base-" : str);
                        sb2.append(str2);
                        sb2.append(".lpk");
                        ZipEntry entry = zipFile2.getEntry(sb2.toString());
                        if (entry != null) {
                            m14970a(str + str2, zipFile2.getInputStream(entry));
                        } else {
                            C9419a.m59081g(str3, str + str2 + ".lpk does not exist.");
                        }
                        zipFile2.close();
                    } catch (IOException e10) {
                        e = e10;
                        zipFile = zipFile2;
                        C9419a.m59082h(f11467e, "copy language from asset failed", e);
                        if (zipFile != null) {
                            zipFile.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        zipFile = zipFile2;
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException e11) {
                                C9419a.m59082h(f11467e, "compressed file close failed", e11);
                            }
                        }
                        throw th;
                    }
                } catch (IOException e12) {
                    e = e12;
                }
            } catch (IOException e13) {
                C9419a.m59082h(f11467e, "compressed file close failed", e13);
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: c */
    public final void m14972c(String str) throws Throwable {
        try {
            m14970a(str, this.f11468a.getAssets().open("langs/base-" + str + ".lpk"));
        } catch (IOException e10) {
            C9419a.m59082h(f11467e, "copy language from apk assets file failed", e10);
        }
    }

    /* renamed from: d */
    public void m14973d(String str) throws Throwable {
        if (!C2403k.m15008c().equals("single-lang")) {
            if (C2403k.m15008c().equals("all-langs")) {
                C9419a.m59080f(f11467e, "copy language option : all-langs");
                m14974e(str);
                return;
            } else {
                C9419a.m59080f(f11467e, "copy language option : nopress");
                m14972c(str);
                return;
            }
        }
        String str2 = f11467e;
        C9419a.m59080f(str2, "copy language option : single-lang");
        C2403k.m15007b(this.f11468a);
        File fileM14999f = this.f11469b.m14999f();
        if (fileM14999f == null) {
            C9419a.m59081g(str2, "verified-splits not exist");
            return;
        }
        File[] fileArrListFiles = fileM14999f.listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            C9419a.m59081g(str2, "verified-splits is empty");
            return;
        }
        for (File file : fileArrListFiles) {
            if (file != null && !TextUtils.isEmpty(file.getName()) && file.getName().endsWith("decompressed-langs.zip")) {
                m14971b(file.getName().substring(0, file.getName().indexOf("decompressed-langs.zip")), str);
            }
        }
    }

    /* renamed from: e */
    public final void m14974e(String str) {
        File file = new File(this.f11469b.m14999f(), "config." + str + ".lpk");
        if (file.exists()) {
            C9419a.m59076b(f11467e, str + " is installed");
            return;
        }
        C2403k.m15006a(this.f11468a, file, "langs/base-" + str + ".lpk.br");
    }

    /* renamed from: j */
    public void m14975j() {
        m14978m();
        m14977l();
    }

    /* renamed from: k */
    public final boolean m14976k(String str) {
        ArrayList arrayList = new ArrayList();
        String[] strArr = this.f11470c.f47085a;
        if (strArr != null) {
            arrayList.addAll(Arrays.asList(strArr));
        }
        boolean zM14967g = m14967g();
        if (!arrayList.contains(str) && !C9421c.m59093c(str, zM14967g)) {
            return false;
        }
        C9419a.m59080f(f11467e, str + " has been installed");
        return true;
    }

    /* renamed from: l */
    public void m14977l() {
        File fileM14999f = this.f11469b.m14999f();
        if (fileM14999f == null) {
            C9419a.m59077c(f11467e, "splitsDir is null");
            return;
        }
        File[] fileArrListFiles = fileM14999f.listFiles();
        if (fileArrListFiles == null) {
            C9419a.m59077c(f11467e, "files dir has no language lpk");
            return;
        }
        for (File file : fileArrListFiles) {
            if (file.isFile() && file.getName().endsWith(".lpk")) {
                C2404l.m15011a(this.f11468a, file);
            }
        }
    }

    /* renamed from: m */
    public void m14978m() throws Throwable {
        try {
            for (String str : m14966f(this.f11468a)) {
                if (!m14976k(str)) {
                    m14973d(str);
                }
            }
        } catch (Exception e10) {
            C9419a.m59077c(f11467e, "get device language failed:" + e10.getMessage());
        }
    }
}
