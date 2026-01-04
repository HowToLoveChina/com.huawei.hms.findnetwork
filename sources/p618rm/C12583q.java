package p618rm;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.PmsCheckUtil;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.bean.PmsMetaV3;
import com.huawei.android.hicloud.cloudbackup.process.util.TarFileUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.secure.android.common.util.SafeString;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import p015ak.C0213f;
import p015ak.C0221j;
import p514o9.C11839m;
import p848zl.C14333b;

/* renamed from: rm.q */
/* loaded from: classes6.dex */
public class C12583q {

    /* renamed from: a */
    public static final String f57951a = File.separator;

    /* renamed from: b */
    public static String f57952b;

    /* renamed from: c */
    public static String f57953c;

    /* renamed from: d */
    public static String f57954d;

    /* renamed from: e */
    public static String f57955e;

    /* renamed from: A */
    public static String m75647A(String str, int i10) {
        return m75658L(str, i10) + f57951a + "filesToTar.txt";
    }

    /* renamed from: B */
    public static String m75648B(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.startsWith(ICBUtil.RELATIVE_SDATA_PATH)) {
            return ICBUtil.RELATIVE_SDATA_PATH + f57951a;
        }
        if (str.startsWith("/udata")) {
            return "/udata" + f57951a;
        }
        if (str.startsWith("/external")) {
            return "/external" + f57951a;
        }
        if (str.startsWith("/uexternal")) {
            return "/uexternal" + f57951a;
        }
        if (str.startsWith(ICBUtil.RELATIVE_SDCARD_PATH)) {
            return ICBUtil.RELATIVE_SDCARD_PATH + f57951a;
        }
        if (str.startsWith(ICBUtil.RELATIVE_USB_PATH)) {
            return ICBUtil.RELATIVE_USB_PATH + f57951a;
        }
        if (str.startsWith(m75674j(0))) {
            return m75674j(0) + f57951a;
        }
        if (!str.startsWith(m75674j(1))) {
            return "";
        }
        return m75674j(1) + f57951a;
    }

    /* renamed from: C */
    public static String m75649C(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        String str2 = f57951a;
        sb2.append(str2);
        sb2.append("sparseUnzip");
        sb2.append(str2);
        return sb2.toString();
    }

    /* renamed from: D */
    public static String m75650D(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        String str2 = f57951a;
        sb2.append(str2);
        sb2.append("sparseZip");
        sb2.append(str2);
        return sb2.toString();
    }

    /* renamed from: E */
    public static String m75651E(String str, int i10) {
        return m75652F(str) + File.separator + i10;
    }

    /* renamed from: F */
    public static String m75652F(String str) {
        return str + File.separator + "splitApp";
    }

    /* renamed from: G */
    public static String m75653G(String str) {
        String strM75680p = m75680p(0);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(strM75680p);
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("splitApp");
        sb2.append(str2);
        sb2.append(str);
        return sb2.toString();
    }

    /* renamed from: H */
    public static boolean m75654H(int i10, String str, String str2) {
        String lowerCase = str.toLowerCase(Locale.getDefault());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(m75670f(i10, ICBUtil.ANDROID_DATA, str2));
        String str3 = File.separator;
        sb2.append(str3);
        if (lowerCase.startsWith(sb2.toString().toLowerCase(Locale.getDefault()))) {
            return true;
        }
        if (lowerCase.startsWith((m75670f(i10, ICBUtil.ANDROID_MEDIA, str2) + str3).toLowerCase(Locale.getDefault()))) {
            return true;
        }
        if (lowerCase.startsWith((m75670f(i10, ICBUtil.ANDROID_OBB, str2) + str3).toLowerCase(Locale.getDefault()))) {
            return true;
        }
        if (lowerCase.startsWith((m75670f(i10, ICBUtil.ANDROID_OBJ, str2) + str3).toLowerCase(Locale.getDefault()))) {
            return true;
        }
        return lowerCase.startsWith((m75670f(i10, ICBUtil.ANDROID_SANDBOX, str2) + str3).toLowerCase(Locale.getDefault()));
    }

    /* renamed from: I */
    public static String m75655I(String str, String str2) {
        String strM1512v = C0221j.m1512v();
        if (TextUtils.isEmpty(strM1512v)) {
            C0221j.m1478F(C0213f.m1377a());
        }
        if (TextUtils.isEmpty(strM1512v) || TextUtils.isEmpty(str)) {
            C11839m.m70688i("CloudBackupPathChangeUtil", "mainExternalPath2SeparaPath TextUtils.isEmpty(locationPcard) || TextUtils.isEmpty(path)");
            return str;
        }
        if (!str.startsWith(strM1512v)) {
            return str;
        }
        return str2 + str.substring(strM1512v.length());
    }

    /* renamed from: J */
    public static String m75656J(String str, int i10) {
        return m75657K(str, i10, true);
    }

    /* renamed from: K */
    public static String m75657K(String str, int i10, boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(m75674j(0));
        String str2 = f57951a;
        sb2.append(str2);
        sb2.append("data");
        sb2.append(str2);
        sb2.append("cache");
        sb2.append(str2);
        sb2.append(str);
        String string = sb2.toString();
        File fileM63442h = C10278a.m63442h(string);
        if (z10 && !fileM63442h.exists() && !fileM63442h.mkdirs()) {
            C11839m.m70688i("CloudBackupPathChangeUtil", "init pms breif meta data cache failed");
        }
        return string;
    }

    /* renamed from: L */
    public static String m75658L(String str, int i10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(m75674j(0));
        String str2 = f57951a;
        sb2.append(str2);
        sb2.append("pmsTar");
        sb2.append(str2);
        sb2.append(str);
        return sb2.toString();
    }

    /* renamed from: M */
    public static String m75659M(String str, int i10, int i11) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.startsWith(ICBUtil.RELATIVE_SDATA_PATH)) {
            return m75674j(i10) + str.substring(6);
        }
        if (str.startsWith("/udata")) {
            return m75674j(i10) + str.substring(6);
        }
        if (str.startsWith("/external")) {
            String strM1512v = C0221j.m1512v();
            if (i11 != 0) {
                strM1512v = C12568l.m75533b(i11);
            }
            return strM1512v + str.substring(9);
        }
        if (str.startsWith(ICBUtil.RELATIVE_SDCARD_PATH)) {
            String strM1514x = C0221j.m1514x();
            if (!TextUtils.isEmpty(strM1514x)) {
                return strM1514x + str.substring(7);
            }
            return C0221j.m1512v() + str;
        }
        if (!str.startsWith(ICBUtil.RELATIVE_USB_PATH)) {
            if (!str.startsWith("/data") || !str.contains("/cloudbackup")) {
                return str;
            }
            return m75674j(i10) + str.substring(str.indexOf("/cloudbackup") + 12);
        }
        String strM1474B = C0221j.m1474B();
        if (!TextUtils.isEmpty(strM1474B)) {
            return strM1474B + str.substring(4);
        }
        return C0221j.m1512v() + str;
    }

    /* renamed from: N */
    public static String m75660N(String str, int i10, String str2, int i11) {
        String strM75668d = m75668d(str, i10, i11);
        return (TextUtils.isEmpty(str2) || !C14333b.m85491z().contains(str2)) ? m75659M(strM75668d, i10, i11) : m75661O(strM75668d, i10, str2);
    }

    /* renamed from: O */
    public static String m75661O(String str, int i10, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.startsWith(ICBUtil.RELATIVE_SDATA_PATH)) {
            return m75674j(i10) + str.substring(6);
        }
        if (str.startsWith("/udata")) {
            return m75674j(i10) + str.substring(6);
        }
        if (str.startsWith("/external")) {
            return m75683s(str, str2, i10, "/external");
        }
        if (str.startsWith("/uexternal")) {
            C11839m.m70686d("CloudBackupPathChangeUtil", "clone path");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(m75674j(i10));
            String str3 = f57951a;
            sb2.append(str3);
            sb2.append(str2);
            sb2.append(str3);
            sb2.append(str2);
            String str4 = sb2.toString() + str.substring(10);
            C11839m.m70686d("CloudBackupPathChangeUtil", "clone media path: " + str4);
            return str4;
        }
        if (!str.startsWith(ICBUtil.RELATIVE_SDCARD_PATH)) {
            if (str.startsWith(ICBUtil.RELATIVE_USB_PATH)) {
                return m75683s(str, str2, i10, ICBUtil.RELATIVE_USB_PATH);
            }
            if (!str.startsWith("/data") || !str.contains("/cloudbackup")) {
                return str;
            }
            return m75674j(i10) + str.substring(str.indexOf("/cloudbackup") + 12);
        }
        C11839m.m70686d("CloudBackupPathChangeUtil", "sdcard path");
        StringBuilder sb3 = new StringBuilder();
        sb3.append(m75674j(i10));
        String str5 = f57951a;
        sb3.append(str5);
        sb3.append(str2);
        sb3.append(str5);
        sb3.append(str2);
        sb3.append("/SDCardClone");
        String str6 = sb3.toString() + str.substring(7);
        C11839m.m70686d("CloudBackupPathChangeUtil", "sd media path: " + str6);
        return str6;
    }

    /* renamed from: P */
    public static String m75662P(String str, int i10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(m75674j(0));
        String str2 = f57951a;
        sb2.append(str2);
        sb2.append(str);
        sb2.append(str2);
        sb2.append("tar");
        return sb2.toString();
    }

    /* renamed from: Q */
    public static Set<String> m75663Q(int i10, String str, int i11) {
        HashSet hashSet = new HashSet();
        File fileM63443i = C10278a.m63443i(m75674j(i10), str);
        m75666b(hashSet, fileM63443i.getAbsolutePath());
        m75666b(hashSet, C10279b.m63452a(fileM63443i));
        File fileM63442h = C10278a.m63442h(m75680p(i10) + f57951a + str);
        m75666b(hashSet, fileM63442h.getAbsolutePath());
        m75666b(hashSet, C10279b.m63452a(fileM63442h));
        m75666b(hashSet, C0221j.m1512v());
        if (i11 != 0) {
            m75666b(hashSet, C12568l.m75533b(i11));
        }
        m75666b(hashSet, C0221j.m1513w());
        m75666b(hashSet, C0221j.m1473A());
        return hashSet;
    }

    /* renamed from: R */
    public static String m75664R(String str, String str2, int i10) {
        String str3;
        if (!PmsCheckUtil.m12611e() || TextUtils.isEmpty(str)) {
            return str;
        }
        String strM75670f = m75670f(i10, "", "");
        if (!m75654H(i10, str, str2)) {
            return str;
        }
        String strM75678n = m75678n(str2, i10);
        if (TextUtils.isEmpty(strM75678n)) {
            str3 = str;
        } else {
            str3 = strM75678n + str.substring(strM75670f.length());
        }
        C11839m.m70686d("CloudBackupPathChangeUtil", "originPath = " + str + " ,path = " + str3);
        return str3;
    }

    /* renamed from: a */
    public static String m75665a(String str, int i10, int i11) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.startsWith(m75674j(i10))) {
            return ICBUtil.RELATIVE_SDATA_PATH + str.substring(m75674j(i10).length());
        }
        String strM1512v = C0221j.m1512v();
        String strM1514x = C0221j.m1514x();
        String strM1474B = C0221j.m1474B();
        if (i11 != 0) {
            strM1512v = C0221j.m1501k();
        }
        return (TextUtils.isEmpty(strM1512v) && TextUtils.isEmpty(strM1514x) && TextUtils.isEmpty(strM1474B)) ? str : (strM1512v == null || !str.startsWith(strM1512v)) ? (strM1514x == null || !str.startsWith(strM1514x)) ? (strM1474B == null || !str.startsWith(strM1474B)) ? str : m75667c(ICBUtil.RELATIVE_USB_PATH, str.substring(strM1474B.length())) : m75667c(ICBUtil.RELATIVE_SDCARD_PATH, str.substring(strM1514x.length())) : m75667c("/external", str.substring(strM1512v.length()));
    }

    /* renamed from: b */
    public static void m75666b(Set<String> set, String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        set.add(str);
    }

    /* renamed from: c */
    public static String m75667c(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str + File.separator;
        }
        return str + str2;
    }

    /* renamed from: d */
    public static String m75668d(String str, int i10, int i11) {
        String strM75665a = m75665a(str, i10, i11);
        if (strM75665a.startsWith(ICBUtil.RELATIVE_SDATA_PATH) || strM75665a.startsWith("/udata") || strM75665a.startsWith("/external") || strM75665a.startsWith("/uexternal") || strM75665a.startsWith(ICBUtil.RELATIVE_SDCARD_PATH) || strM75665a.startsWith(ICBUtil.RELATIVE_USB_PATH)) {
            return strM75665a;
        }
        if (strM75665a.startsWith("/data") && strM75665a.contains("/cloudbackup")) {
            return strM75665a;
        }
        C11839m.m70689w("CloudBackupPathChangeUtil", "checkPath relative path not right path = " + strM75665a);
        return "/external" + strM75665a;
    }

    /* renamed from: e */
    public static File m75669e(PmsMetaV3 pmsMetaV3) {
        String decodedPath = pmsMetaV3.getEncoded() == 1 ? ICBUtil.getDecodedPath(pmsMetaV3.getData()) : pmsMetaV3.getData();
        if (TextUtils.isEmpty(decodedPath)) {
            return null;
        }
        return C10278a.m63443i(m75674j(0), decodedPath);
    }

    /* renamed from: f */
    public static String m75670f(int i10, String str, String str2) {
        return (i10 == 0 ? C0221j.m1512v() : C0221j.m1501k()) + ICBUtil.ANDROID + str + str2;
    }

    /* renamed from: g */
    public static String m75671g() {
        String strM75682r = m75682r();
        if (strM75682r == null) {
            return "";
        }
        String strM1512v = C0221j.m1512v();
        String strM1513w = C0221j.m1513w();
        if (TextUtils.isEmpty(strM1513w) || !strM75682r.startsWith(strM1513w)) {
            return strM75682r + "/cloudbackup/";
        }
        return strM75682r.replaceFirst(strM1513w, strM1512v) + "/cloudbackup/";
    }

    /* renamed from: h */
    public static String m75672h() {
        return m75674j(0) + f57951a + "backup_android_temp";
    }

    /* renamed from: i */
    public static String m75673i(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(m75674j(0));
        String str2 = f57951a;
        sb2.append(str2);
        sb2.append("backup_android_temp");
        sb2.append(str2);
        sb2.append(str);
        sb2.append(str2);
        return sb2.toString();
    }

    /* renamed from: j */
    public static String m75674j(int i10) {
        if (i10 == 0) {
            String str = f57953c;
            if (str != null) {
                return str;
            }
            String str2 = m75675k() + f57951a + "cloudbackup";
            f57953c = str2;
            return str2;
        }
        String str3 = f57954d;
        if (str3 != null) {
            return str3;
        }
        String str4 = m75675k() + f57951a + "cloudrestore";
        f57954d = str4;
        return str4;
    }

    /* renamed from: k */
    public static String m75675k() {
        String str = f57952b;
        if (str != null) {
            return str;
        }
        if (m75676l() != null) {
            f57952b = C10279b.m63452a(C10278a.m63442h(C10279b.m63452a(m75676l().getFilesDir())));
        }
        return f57952b;
    }

    /* renamed from: l */
    public static Context m75676l() {
        return C0213f.m1377a();
    }

    /* renamed from: m */
    public static String m75677m(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(m75674j(0));
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("splitCreateAndroid");
        sb2.append(str2);
        sb2.append(str);
        return sb2.toString();
    }

    /* renamed from: n */
    public static String m75678n(String str, int i10) {
        String strM75671g = m75671g();
        if (TextUtils.isEmpty(strM75671g)) {
            return "";
        }
        return strM75671g + str + f57951a + str;
    }

    /* renamed from: o */
    public static String m75679o(String str, int i10) {
        String strM75671g = m75671g();
        if (TextUtils.isEmpty(strM75671g)) {
            return "";
        }
        return strM75671g + "twinappExternalCache/" + str + File.separator + i10;
    }

    /* renamed from: p */
    public static String m75680p(int i10) {
        return m75674j(i10) + f57951a + "data";
    }

    /* renamed from: q */
    public static String m75681q() {
        return m75674j(0) + File.separator + "dataWaitDelete";
    }

    /* renamed from: r */
    public static String m75682r() {
        String str = f57955e;
        if (str != null) {
            return str;
        }
        if (m75676l() != null) {
            f57955e = C10279b.m63452a(m75676l().getExternalCacheDir());
        }
        return f57955e;
    }

    /* renamed from: s */
    public static String m75683s(String str, String str2, int i10, String str3) {
        C11839m.m70686d("CloudBackupPathChangeUtil", "external path");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(m75674j(i10));
        String str4 = f57951a;
        sb2.append(str4);
        sb2.append(str2);
        sb2.append(str4);
        sb2.append(str2);
        String str5 = sb2.toString() + str.substring(str3.length());
        C11839m.m70686d("CloudBackupPathChangeUtil", "media temp path: " + str5);
        return str5;
    }

    /* renamed from: t */
    public static String m75684t() {
        return Environment.getExternalStorageDirectory().getPath();
    }

    /* renamed from: u */
    public static String m75685u(String str, int i10) {
        return m75688x() + File.separator + str + i10;
    }

    /* renamed from: v */
    public static String m75686v(String str, int i10, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(m75652F(str));
        String str3 = File.separator;
        sb2.append(str3);
        sb2.append(i10);
        sb2.append(str3);
        sb2.append(str2);
        return sb2.toString();
    }

    /* renamed from: w */
    public static String m75687w(String str, int i10) {
        return m75658L(str, i10) + f57951a + str + ".tar";
    }

    /* renamed from: x */
    public static String m75688x() {
        return m75674j(1) + File.separator + "tempPmsMove";
    }

    /* renamed from: y */
    public static String m75689y(String str, int i10) {
        return m75658L(str, i10) + f57951a + str + ".txt";
    }

    /* renamed from: z */
    public static String m75690z(PmsMetaV3 pmsMetaV3, TarFileUtil tarFileUtil) {
        File fileM75669e;
        String filePath = pmsMetaV3.getFilePath();
        if (TextUtils.isEmpty(filePath) || (fileM75669e = m75669e(pmsMetaV3)) == null) {
            return null;
        }
        return SafeString.substring(filePath, 0, filePath.indexOf(tarFileUtil.getRelativePath(C10279b.m63452a(fileM75669e))));
    }
}
