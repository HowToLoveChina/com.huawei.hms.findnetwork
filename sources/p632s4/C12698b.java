package p632s4;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.utils.BackupConstant;
import com.huawei.android.backup.service.utils.C2157a;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import p328h6.AbstractC10110j;
import p386j6.C10712b;
import p601r4.C12462b;
import p699v4.C13334c;
import p699v4.C13336e;
import p699v4.C13345n;
import p699v4.C13348q;

/* renamed from: s4.b */
/* loaded from: classes.dex */
public class C12698b {
    /* renamed from: a */
    public static boolean m76407a(File file, int i10) {
        int iM76451d = C12703g.m76451d(C13336e.m79997b(file));
        if (i10 == 504 || i10 == 505) {
            if (iM76451d != 504 && iM76451d != 505) {
                return false;
            }
        } else {
            if (iM76451d != i10) {
                return false;
            }
            C2111d.m12657m("CloneMediaFileUtil", "other mediaType");
        }
        return true;
    }

    /* renamed from: b */
    public static boolean m76408b(Context context, String str, String str2, ArrayList<String> arrayList) {
        boolean z10;
        if (context == null || arrayList == null || arrayList.isEmpty()) {
            C2111d.m12653i("CloneMediaFileUtil", "getRestoreDestPath param is null");
            z10 = false;
        } else {
            z10 = true;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return z10;
        }
        C2111d.m12653i("CloneMediaFileUtil", "getRestoreDestPath srcPath or srcRootPath isempty");
        return false;
    }

    /* renamed from: c */
    public static Set<String> m76409c(File file) {
        File[] fileArrListFiles;
        HashSet hashSet = new HashSet(16);
        if (file != null && file.exists() && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                hashSet.add(C13334c.m79991x(file2));
                if (file2.exists() && file2.isDirectory()) {
                    Set<String> setM76409c = m76409c(file2);
                    if (setM76409c.size() > 0) {
                        hashSet.addAll(setM76409c);
                    }
                }
            }
        }
        return hashSet;
    }

    /* renamed from: d */
    public static List<C12702f> m76410d(Context context, Set<String> set, boolean z10, C12697a c12697a) {
        ArrayList arrayList = new ArrayList(10);
        if (context != null && c12697a != null && set != null) {
            for (String str : set) {
                C12702f c12702f = new C12702f(str);
                c12702f.m76446m(c12697a.m76405f());
                c12702f.m76443j(c12697a.m76400a());
                File fileM74717a = C12462b.m74717a(str);
                arrayList.add(c12702f);
                if (!fileM74717a.exists()) {
                    c12702f.m76447n(2);
                } else if (fileM74717a.isDirectory()) {
                    c12702f.m76444k(true);
                    String strM76414h = m76414h(fileM74717a, true, context, c12697a);
                    if (TextUtils.isEmpty(strM76414h)) {
                        C2111d.m12646b("CloneMediaFileUtil", "destPath is empty, no need to restore");
                        arrayList.remove(c12702f);
                    } else {
                        c12702f.m76442i(strM76414h);
                        if (C12462b.m74717a(strM76414h).exists()) {
                            c12702f.m76447n(0);
                        } else {
                            c12702f.m76447n(5);
                        }
                    }
                } else if (!z10 || m76407a(fileM74717a, c12697a.m76401b())) {
                    String name = fileM74717a.getName();
                    c12702f.m76445l(name);
                    String strM76414h2 = m76414h(fileM74717a, false, context, c12697a);
                    if (TextUtils.isEmpty(strM76414h2)) {
                        C2111d.m12646b("CloneMediaFileUtil", "destPath is empty, no need to restore");
                        arrayList.remove(c12702f);
                    } else {
                        c12702f.m76442i(strM76414h2);
                        m76421o(strM76414h2, name, fileM74717a, c12702f);
                    }
                } else {
                    c12702f.m76447n(3);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public static String m76411e(Context context, String str, String str2, Bundle bundle) {
        if (context != null && !TextUtils.isEmpty(str2) && !C13348q.m80081a(bundle)) {
            return AbstractC10110j.m62979u(str.substring(str2.length()), bundle);
        }
        C2111d.m12648d("CloneMediaFileUtil", "context srcRootPath or restorePathBundle is empty.");
        return null;
    }

    /* renamed from: f */
    public static String m76412f(ArrayList<String> arrayList, String str, String str2, String str3) {
        if (C13348q.m80082b(arrayList)) {
            return str;
        }
        String str4 = arrayList.get(0);
        if (!str3.startsWith(str4)) {
            C2111d.m12657m("CloneMediaFileUtil", "getCompatiblePath old and new is not same");
            return str;
        }
        return str2 + str3.substring(str4.length());
    }

    /* renamed from: g */
    public static String m76413g(Context context, String str, String str2, ArrayList<String> arrayList) {
        if (!m76408b(context, str, str2, arrayList) || str.contains("/SDCardClone")) {
            return null;
        }
        if (arrayList.size() == 0) {
            C2111d.m12648d("CloneMediaFileUtil", "there is no restore path.");
            return null;
        }
        String str3 = arrayList.get(0);
        if (TextUtils.isEmpty(str3)) {
            C2111d.m12648d("CloneMediaFileUtil", "restoreInternPath is empty.");
            return null;
        }
        return str3 + str.substring(str2.length());
    }

    /* renamed from: h */
    public static String m76414h(File file, boolean z10, Context context, C12697a c12697a) throws IOException {
        String canonicalPath;
        if (file == null || c12697a == null) {
            C2111d.m12653i("CloneMediaFileUtil", "getDestFilePath srcFile is null");
            return null;
        }
        if (z10) {
            try {
                canonicalPath = file.getCanonicalPath();
            } catch (IOException unused) {
                C2111d.m12648d("CloneMediaFileUtil", "get secFile error");
                canonicalPath = null;
            }
        } else {
            canonicalPath = file.getParent();
        }
        if (canonicalPath == null) {
            return null;
        }
        return m76415i(context, canonicalPath, c12697a);
    }

    /* renamed from: i */
    public static String m76415i(Context context, String str, C12697a c12697a) {
        String strM76419m;
        String strM76400a = c12697a.m76400a();
        String strM76405f = c12697a.m76405f();
        String strM76402c = c12697a.m76402c();
        if (C2157a.m13203k().contains(strM76402c) && !BackupConstant.m13139m().contains(strM76402c)) {
            if ("desktopMyFile".equals(strM76402c)) {
                strM76419m = m76413g(context, str, strM76405f, c12697a.m76404e());
            } else {
                if (BackupConstant.m13148v().contains(strM76402c)) {
                    return m76411e(context, str, c12697a.m76405f(), c12697a.m76403d());
                }
                strM76419m = m76419m(context, str, strM76405f, c12697a.m76404e(), c12697a.m76406g());
            }
            if (strM76419m != null) {
                return strM76419m;
            }
        }
        if (BackupObject.isRecordModule(strM76402c)) {
            return m76417k(strM76402c, strM76400a, str, c12697a);
        }
        String strM76418l = m76418l(str, strM76405f);
        if (TextUtils.isEmpty(str) || !str.contains("/SDCardClone") || TextUtils.isEmpty(strM76405f) || strM76405f.contains("/SDCardClone") || TextUtils.isEmpty(strM76418l)) {
            return strM76400a + strM76418l;
        }
        return C10712b.m65388a(context, strM76400a) + strM76418l.substring(strM76418l.lastIndexOf("/SDCardClone") + 12);
    }

    /* renamed from: j */
    public static String m76416j(String str, String str2, C12697a c12697a) {
        String strSubstring = str2.substring(c12697a.m76405f().length());
        if (strSubstring.startsWith("/SDCardClone")) {
            strSubstring = strSubstring.substring(12);
        }
        if (strSubstring.startsWith("/Sounds")) {
            strSubstring = strSubstring.substring(7);
        } else if (strSubstring.startsWith("/Recordings")) {
            strSubstring = strSubstring.substring(11);
        } else {
            C2111d.m12646b("CloneMediaFileUtil", "no need process");
        }
        return str + C12703g.m76450c() + strSubstring;
    }

    /* renamed from: k */
    public static String m76417k(String str, String str2, String str3, C12697a c12697a) {
        if (!str.equals("callRecorder")) {
            return m76416j(str2, str3, c12697a);
        }
        return str2 + C12703g.m76449b();
    }

    /* renamed from: l */
    public static String m76418l(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return str.substring(str2.length());
    }

    /* renamed from: m */
    public static String m76419m(Context context, String str, String str2, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        String str3;
        if (!m76408b(context, str, str2, arrayList)) {
            return null;
        }
        String strM80072k = C13345n.m80072k(context, 2);
        if (!str.contains("/SDCardClone")) {
            String str4 = arrayList.get(0);
            if (str4 == null) {
                C2111d.m12653i("CloneMediaFileUtil", "getRestoreDestPath is get internal restore path  error");
                return null;
            }
            String str5 = strM80072k + str.substring(str2.length()) + File.separator;
            if (str5.contains(str4)) {
                return null;
            }
            return m76412f(arrayList2, null, str4, str5);
        }
        if (str2.contains("/SDCardClone")) {
            str3 = str2;
        } else {
            str3 = str2 + "/SDCardClone";
        }
        if (arrayList.size() <= 1) {
            return null;
        }
        String str6 = arrayList.get(1);
        if (!str6.startsWith(strM80072k)) {
            return m76420n(context, str6, str, str2);
        }
        return strM80072k + str.substring(str3.length());
    }

    /* renamed from: n */
    public static String m76420n(Context context, String str, String str2, String str3) {
        if (!C13345n.m80074m(context, 3)) {
            C2111d.m12653i("CloneMediaFileUtil", "getRestoreDestPath is get sdcardfile restore to sd sdcard not exist");
            return null;
        }
        String strM80072k = C13345n.m80072k(context, 3);
        if (!str.startsWith(strM80072k)) {
            C2111d.m12653i("CloneMediaFileUtil", "getRestoreDestPath is get sdcardfile restore to sd path error");
            return null;
        }
        return strM80072k + str2.substring(str3.length());
    }

    /* renamed from: o */
    public static void m76421o(String str, String str2, File file, C12702f c12702f) {
        File fileM74717a = C12462b.m74717a(str + File.separator + str2);
        if (!fileM74717a.exists()) {
            c12702f.m76447n(4);
        } else if (file.length() == fileM74717a.length()) {
            c12702f.m76447n(0);
        } else {
            c12702f.m76447n(1);
        }
    }
}
