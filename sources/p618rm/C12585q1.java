package p618rm;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import ck.C1443a;
import com.huawei.android.hicloud.cloudbackup.bean.TwinAppControl;
import com.huawei.android.hicloud.cloudbackup.process.task.QueryOmAppBackupScopeTask;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreConstans;
import com.huawei.android.hicloud.cloudbackup.process.util.FileCategoryUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import fk.C9721b;
import hk.C10278a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import p015ak.C0209d;
import p015ak.C0241z;
import p514o9.C11839m;
import p616rk.C12515a;
import p617rl.C12519c;
import p617rl.C12526j;
import p711vl.C13466f;

/* renamed from: rm.q1 */
/* loaded from: classes6.dex */
public class C12585q1 {

    /* renamed from: a */
    public static final Object f57956a = new Object();

    /* renamed from: b */
    public static HashMap<String, Pattern> f57957b = new HashMap<>();

    /* renamed from: c */
    public static volatile boolean f57958c;

    /* renamed from: a */
    public static boolean m75691a(String str) {
        try {
            if (m75692b()) {
                return true;
            }
            CloudBackupReport.reportOmError("checkAppOmConfigApp failed, from: " + str);
            C11839m.m70688i("OMConfigureUtil", "checkAppOmConfigApp appList is empty");
            new QueryOmAppBackupScopeTask(true).readConfigFile();
            return m75692b();
        } catch (Exception e10) {
            C11839m.m70687e("OMConfigureUtil", "checkAppOmConfigApp error: " + e10.toString());
            CloudBackupReport.reportOmError("checkAppOmConfigApp error: " + e10 + ", from: " + str);
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m75692b() {
        try {
            List<String> listM75297h = new C12519c().m75297h(0);
            C11839m.m70688i("OMConfigureUtil", "app list size " + listM75297h.size() + " config state " + C13466f.m81073d().m81077e("backup_read_om_config_state", -1));
            return listM75297h.size() > 0;
        } catch (C9721b e10) {
            C11839m.m70687e("OMConfigureUtil", "checkAppOmConfigApp error: " + e10.toString());
            return false;
        }
    }

    /* renamed from: c */
    public static void m75693c() {
        synchronized (f57956a) {
            C11839m.m70688i("OMConfigureUtil", "clearPatternHashMap");
            f57957b.clear();
        }
    }

    /* renamed from: d */
    public static List<String> m75694d(List<String> list, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String strReplace = it.next().replace("${packagename}", str);
            if (!strReplace.startsWith(BackupRestoreConstans.DATA_PATH) && !strReplace.startsWith("REG:")) {
                strReplace = ICBUtil.convertToAbsolutePath(strReplace, str2);
            }
            arrayList.add(strReplace);
        }
        return arrayList;
    }

    /* renamed from: e */
    public static Pattern m75695e(String str) {
        synchronized (f57956a) {
            try {
                Pattern pattern = f57957b.get(str);
                if (pattern != null) {
                    return pattern;
                }
                Pattern patternCompile = Pattern.compile(str, 2);
                f57957b.put(str, patternCompile);
                return patternCompile;
            } catch (Exception e10) {
                C11839m.m70687e("OMConfigureUtil", "get pattern error: " + e10.toString());
                return null;
            }
        }
    }

    /* renamed from: f */
    public static void m75696f() {
        f57958c = m75708r();
        C11839m.m70688i("OMConfigureUtil", "initMatchV1OSVersRegex  initAppTwinStatus " + f57958c);
    }

    /* renamed from: g */
    public static boolean m75697g(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(BackupRestoreConstans.DATA_PATH) || str.startsWith("REG:/data/data/") || str.startsWith("REG:^/data/data/");
    }

    /* renamed from: h */
    public static boolean m75698h(long j10, List<String> list) {
        if (list == null || list.isEmpty()) {
            C11839m.m70688i("OMConfigureUtil", " versionCode is not filtered.");
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (Pattern.matches(it.next(), String.valueOf(j10))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: i */
    public static boolean m75699i(long j10, String str, String str2, List<String> list) {
        return (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) ? m75698h(j10, list) : (TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) ? (!TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? j10 >= C0241z.m1688f(str) && j10 <= C0241z.m1688f(str2) : j10 <= C0241z.m1688f(str2) : j10 >= C0241z.m1688f(str);
    }

    /* renamed from: j */
    public static boolean m75700j(int i10) {
        long jM1685c = C0241z.m1685c(C1443a.f6213a);
        C11839m.m70688i("OMConfigureUtil", "currentVersion: " + jM1685c + ", minClientVersion = " + i10);
        return jM1685c >= ((long) i10);
    }

    /* renamed from: k */
    public static boolean m75701k(List<String> list) {
        if (list == null || list.isEmpty()) {
            C11839m.m70688i("OMConfigureUtil", "deviceList is empty, default match effect device");
            return true;
        }
        if (list.contains("*")) {
            C11839m.m70688i("OMConfigureUtil", "deviceList contains *, match effect device");
            return true;
        }
        String str = Build.MODEL;
        C11839m.m70688i("OMConfigureUtil", "currentDeviceType: " + str);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next().replaceAll("\\*", ""))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: l */
    public static boolean m75702l(List<String> list) {
        if (list == null || list.isEmpty()) {
            C11839m.m70688i("OMConfigureUtil", "gradeList is empty, default match effect grade");
            return true;
        }
        if (list.contains("*")) {
            C11839m.m70688i("OMConfigureUtil", "gradeList contains *, match effect package");
            return true;
        }
        String strM81079g = C13466f.m81073d().m81079g("gradeCode", "");
        C11839m.m70688i("OMConfigureUtil", "currentGradeCode: " + strM81079g);
        return list.contains(strM81079g);
    }

    /* renamed from: m */
    public static boolean m75703m(List<String> list) {
        if (list == null || list.isEmpty()) {
            C11839m.m70688i("OMConfigureUtil", "isMatchEmuiVersion emuiVsionList is null");
            return false;
        }
        String strM1186L = C0209d.m1186L();
        C11839m.m70688i("OMConfigureUtil", "currentEmuiVersion: " + strM1186L);
        for (String str : list) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(strM1186L) && (str.equals(strM1186L) || strM1186L.contains(str))) {
                C11839m.m70688i("OMConfigureUtil", "isMatchEmuiVersion result = true, om version = " + str);
                return true;
            }
        }
        C11839m.m70688i("OMConfigureUtil", "isMatchEmuiVersion result = false");
        return false;
    }

    /* renamed from: n */
    public static boolean m75704n(String str, List<Integer> list) {
        File fileM63442h = C10278a.m63442h(str);
        if (fileM63442h.isDirectory()) {
            return true;
        }
        return list.contains(Integer.valueOf(FileCategoryUtil.getFileCategory(C12538b.m75479b(fileM63442h).m73355a())));
    }

    /* renamed from: o */
    public static boolean m75705o(String str) {
        if (str == null) {
            C11839m.m70688i("OMConfigureUtil", "configure osVersRegex is null, return false");
            return false;
        }
        String strM1149A0 = C0209d.m1149A0();
        C11839m.m70688i("OMConfigureUtil", "configure osVersRegex: " + str + "current osVersion: " + strM1149A0);
        try {
            return Pattern.matches(str, strM1149A0);
        } catch (PatternSyntaxException e10) {
            C11839m.m70687e("OMConfigureUtil", "pattern syntax exception: " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: p */
    public static boolean m75706p(String str, String str2) {
        Pattern patternM75695e;
        return (TextUtils.isEmpty(str2) || (patternM75695e = m75695e(str2)) == null || !patternM75695e.matcher(str).matches()) ? false : true;
    }

    /* renamed from: q */
    public static boolean m75707q(String str, List<String> list, boolean z10) {
        Pattern patternM75695e;
        for (String str2 : list) {
            String str3 = str.endsWith("/") ? str : str + "/";
            if (str3.startsWith(str2)) {
                return true;
            }
            if (z10 && str2.startsWith("REG:")) {
                String strSubstring = str2.substring(4);
                if (!TextUtils.isEmpty(strSubstring) && (patternM75695e = m75695e(strSubstring)) != null) {
                    if (patternM75695e.matcher(str).matches()) {
                        return true;
                    }
                }
            }
            if (str3.startsWith(SplitAppUtil.STORAGE_EMULATED) && !str3.startsWith("/storage/emulated/0/") && str2.startsWith("/storage/emulated/0/") && str3.contains(str2.substring(20))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: r */
    public static boolean m75708r() {
        TwinAppControl twinAppControlM75375Z0 = new C12526j().m75375Z0();
        if (twinAppControlM75375Z0 != null) {
            return m75705o(twinAppControlM75375Z0.getV1OSVersRegex());
        }
        C11839m.m70688i("OMConfigureUtil", "isMatchTwinAppControl twinAppControl is empty");
        return false;
    }

    /* renamed from: s */
    public static void m75709s() {
        boolean zM75158X0 = C12515a.m75110o().m75158X0(QueryOmAppBackupScopeTask.class.getName());
        while (zM75158X0) {
            SystemClock.sleep(500L);
            zM75158X0 = C12515a.m75110o().m75158X0(QueryOmAppBackupScopeTask.class.getName());
            C11839m.m70688i("OMConfigureUtil", "wait QueryOmAppBackupScopeTask");
        }
    }
}
