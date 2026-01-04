package p336he;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.hicloud.router.data.ExtraDeviceInfo;
import com.huawei.hicloud.router.data.UserBackupInfo;
import com.huawei.hicloud.sync.R$string;
import com.huawei.openalliance.p169ad.beans.parameter.RequestOptions;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;
import mk.C11477c;
import p514o9.C11839m;
import p514o9.C11842p;
import p783xp.C13843a;

/* renamed from: he.d */
/* loaded from: classes3.dex */
public class C10153d {

    /* renamed from: a */
    public static int f49462a = 25;

    /* renamed from: b */
    public static final Map<String, Boolean> f49463b = new HashMap();

    /* renamed from: c */
    public static final Map<String, Boolean> f49464c = new HashMap();

    /* renamed from: d */
    public static final Pattern f49465d = Pattern.compile("[a-zA-Z0-9_\\-]{12,200}");

    /* renamed from: e */
    public static final Pattern f49466e = Pattern.compile("[a-zA-Z0-9_\\-]{28}");

    /* renamed from: f */
    public static final Pattern f49467f = Pattern.compile("[a-zA-Z0-9_\\-]{33}");

    /* renamed from: a */
    public static Map<String, Boolean> m63237a() {
        return f49463b;
    }

    /* renamed from: b */
    public static Map<String, Boolean> m63238b() {
        return f49464c;
    }

    /* renamed from: c */
    public static synchronized int m63239c() {
        return f49462a;
    }

    /* renamed from: d */
    public static String m63240d(Context context, long j10) {
        if (context == null) {
            C11839m.m70687e("BackupUtils", "getLastBackupTime context is null");
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j10);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(System.currentTimeMillis());
        int i10 = calendar.get(1);
        int i11 = calendar2.get(1);
        int i12 = calendar.get(6);
        int i13 = calendar2.get(6);
        if (i10 != i11) {
            return C10159j.m63325a(context, j10, C11842p.m70824j());
        }
        if (i12 == i13) {
            return context.getString(R$string.temp_backup_today, C13843a.m83065Q(context, new Date(j10)));
        }
        if (i13 - i12 != 1) {
            return C10159j.m63325a(context, j10, C11842p.m70824j());
        }
        return context.getString(R$string.temp_backup_yesterday, C13843a.m83065Q(context, new Date(j10)));
    }

    /* renamed from: e */
    public static List<UserBackupInfo.UserDeviceInfo> m63241e(List<UserBackupInfo.UserDeviceInfo> list) {
        Long l10;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        for (UserBackupInfo.UserDeviceInfo userDeviceInfo : list) {
            String backupDeviceId = userDeviceInfo.getBackupDeviceId();
            if (userDeviceInfo.getBakId() == null || !userDeviceInfo.isTempBackUp()) {
                if (userDeviceInfo.isOnlyRefurbish()) {
                    map3.put(backupDeviceId, Long.valueOf(userDeviceInfo.getLastbackupTime()));
                }
                if (map.containsKey(backupDeviceId)) {
                    UserBackupInfo.UserDeviceInfo userDeviceInfo2 = (UserBackupInfo.UserDeviceInfo) map.get(backupDeviceId);
                    if (userDeviceInfo2.getLastbackupTime() < userDeviceInfo.getLastbackupTime() && !userDeviceInfo.isHasRefurbish()) {
                        userDeviceInfo2.setLastbackupTime(userDeviceInfo.getLastbackupTime());
                    }
                    if (!userDeviceInfo.isOnlyRefurbish()) {
                        userDeviceInfo2.setOnlyRefurbish(false);
                    }
                    userDeviceInfo2.setOnlyHarmonyNext(userDeviceInfo.isOnlyHarmonyNext());
                    userDeviceInfo2.setTerminalType(userDeviceInfo.getTerminalType());
                    m63244h(userDeviceInfo2, userDeviceInfo.getExtraDeviceInfos());
                } else {
                    map.put(backupDeviceId, userDeviceInfo);
                }
            } else {
                map2.put(backupDeviceId, userDeviceInfo);
            }
        }
        Iterator it = map.entrySet().iterator();
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            UserBackupInfo.UserDeviceInfo userDeviceInfo3 = (UserBackupInfo.UserDeviceInfo) ((Map.Entry) it.next()).getValue();
            if (userDeviceInfo3 != null && (userDeviceInfo3.getSize() > 0 || userDeviceInfo3.isHasRefurbish() || userDeviceInfo3.getLastbackupTime() > 0)) {
                if (userDeviceInfo3.isOnlyRefurbish() && (l10 = (Long) map3.get(userDeviceInfo3.getBackupDeviceId())) != null) {
                    userDeviceInfo3.setLastbackupTime(l10.longValue());
                }
                userDeviceInfo3.setDeviceName(C11477c.m68636f(userDeviceInfo3.getDeviceName()));
                userDeviceInfo3.setDevDisplayName(C11477c.m68636f(userDeviceInfo3.getDevDisplayName()));
                userDeviceInfo3.setDeviceID(C11477c.m68636f(userDeviceInfo3.getDeviceID()));
                arrayList.add(userDeviceInfo3);
            }
        }
        Iterator it2 = map2.entrySet().iterator();
        while (it2.hasNext()) {
            UserBackupInfo.UserDeviceInfo userDeviceInfo4 = (UserBackupInfo.UserDeviceInfo) ((Map.Entry) it2.next()).getValue();
            if (userDeviceInfo4 != null && (userDeviceInfo4.getSize() > 0 || userDeviceInfo4.getLastbackupTime() > 0)) {
                userDeviceInfo4.setDeviceName(C11477c.m68636f(userDeviceInfo4.getDeviceName()));
                userDeviceInfo4.setDevDisplayName(C11477c.m68636f(userDeviceInfo4.getDevDisplayName()));
                userDeviceInfo4.setDeviceID(C11477c.m68636f(userDeviceInfo4.getDeviceID()));
                arrayList.add(userDeviceInfo4);
            }
        }
        return arrayList;
    }

    /* renamed from: f */
    public static boolean m63242f(String str) {
        try {
            return (!TextUtils.isEmpty(str) ? UUID.fromString(str) : null) != null;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    /* renamed from: g */
    public static synchronized void m63243g(int i10) {
        f49462a = i10;
    }

    /* renamed from: h */
    public static void m63244h(UserBackupInfo.UserDeviceInfo userDeviceInfo, ArrayList<ExtraDeviceInfo> arrayList) {
        if (userDeviceInfo == null || userDeviceInfo.getExtraDeviceInfos() == null || arrayList == null) {
            return;
        }
        userDeviceInfo.getExtraDeviceInfos().addAll(arrayList);
    }

    /* renamed from: i */
    public static boolean m63245i(String str) {
        if (TextUtils.isEmpty(str) || !m63247k(str)) {
            return false;
        }
        String strSubstring = str.substring(0, 1);
        return ((strSubstring.equals("D") || strSubstring.equals("I") || strSubstring.equals(RequestOptions.AD_CONTENT_CLASSIFICATION_J)) ? f49465d : strSubstring.equals("E") ? f49466e : f49467f).matcher(str).matches();
    }

    /* renamed from: j */
    public static boolean m63246j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("^[a-f0-9]{32}\\.tar$").matcher(str).matches();
    }

    /* renamed from: k */
    public static boolean m63247k(String str) {
        return str.startsWith("A") || str.startsWith(CloudBackupConstant.UserPackageInfo.ONE_T_MEMBER) || str.startsWith("C") || str.startsWith("D") || str.startsWith("E") || str.startsWith("F") || str.startsWith("H") || str.startsWith("I") || str.startsWith(RequestOptions.AD_CONTENT_CLASSIFICATION_J);
    }
}
