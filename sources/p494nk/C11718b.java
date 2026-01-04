package p494nk;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.provider.Settings;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.hicloud.base.R$string;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hms.support.api.location.common.LocationConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p399jk.AbstractC10896a;

/* renamed from: nk.b */
/* loaded from: classes6.dex */
public class C11718b {

    /* renamed from: a */
    public static final int f54217a = Settings.Secure.getInt(C0213f.m1377a().getContentResolver(), "oem_installed_apps_runtime_permission_enable", 0);

    /* renamed from: b */
    public static final String[] f54218b = {"android.permission.WRITE_EXTERNAL_STORAGE"};

    /* renamed from: c */
    public static HashMap<String, Integer> f54219c = new HashMap<>();

    /* renamed from: d */
    public static HashMap<String, List<String>> f54220d = new HashMap<>();

    /* renamed from: e */
    public static final List<String> f54221e;

    /* renamed from: f */
    public static final List<String> f54222f;

    /* renamed from: nk.b$b */
    public static class b implements Comparator<Integer>, Serializable {
        private static final long serialVersionUID = 100;

        public b() {
        }

        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Integer num, Integer num2) {
            return num.intValue() - num2.intValue();
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        ArrayList arrayList = new ArrayList(Arrays.asList("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CALL_PHONE", "android.permission.ACCESS_FINE_LOCATION", "android.permission.WRITE_CONTACTS", "android.permission.READ_SMS", "android.permission.WRITE_CALL_LOG", "android.permission.WRITE_CALENDAR"));
        f54221e = arrayList;
        ArrayList arrayList2 = new ArrayList(Arrays.asList("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"));
        f54222f = arrayList2;
        f54219c.put("android.permission.WRITE_EXTERNAL_STORAGE", 0);
        f54219c.put("android.permission.READ_EXTERNAL_STORAGE", 0);
        f54219c.put("android.permission.CALL_PHONE", 1);
        f54219c.put("android.permission.READ_PHONE_NUMBERS", 1);
        f54219c.put("android.permission.READ_PHONE_STATE", 1);
        f54219c.put(LocationConstant.BACKGROUND_PERMISSION, 2);
        f54219c.put("android.permission.ACCESS_COARSE_LOCATION", 2);
        f54219c.put("android.permission.ACCESS_FINE_LOCATION", 2);
        f54219c.put("android.permission.READ_CONTACTS", 3);
        f54219c.put("android.permission.WRITE_CONTACTS", 3);
        f54219c.put("android.permission.READ_SMS", 4);
        f54219c.put("android.permission.READ_CALL_LOG", 5);
        f54219c.put("android.permission.WRITE_CALL_LOG", 5);
        f54219c.put("android.permission.READ_CALENDAR", 6);
        f54219c.put("android.permission.WRITE_CALENDAR", 6);
        f54220d.put("sync_contact", Arrays.asList("android.permission.WRITE_CONTACTS", "android.permission.READ_CONTACTS"));
        f54220d.put("sync_calendar", Arrays.asList("android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"));
        f54220d.put("sync_ablum", Arrays.asList("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"));
        f54220d.put(CloudBackupConstant.Command.PMS_CMD_BACKUP, arrayList2);
        f54220d.put("backup_sms", Arrays.asList("android.permission.READ_SMS"));
        f54220d.put("backup_contact", Arrays.asList("android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS"));
        f54220d.put("backup_calllog", Arrays.asList("android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG"));
        f54220d.put("backup_calendar", Arrays.asList("android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"));
        f54220d.put("cloud_disk_sms", Arrays.asList("android.permission.READ_SMS"));
        f54220d.put("cloud_disk_recording", Arrays.asList("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"));
        f54220d.put("cloud_disk_calllog", Arrays.asList("android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG"));
        f54220d.put("phone_finder", Arrays.asList("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.CALL_PHONE", "android.permission.READ_PHONE_NUMBERS", "android.permission.READ_PHONE_STATE"));
        if (C0209d.m1269j1() && m69901n()) {
            arrayList.add("com.android.permission.GET_INSTALLED_APPS");
            arrayList2.add("com.android.permission.GET_INSTALLED_APPS");
            f54219c.put("com.android.permission.GET_INSTALLED_APPS", 7);
            AbstractC10896a.m65887i("PermissionUtil", "Honor product,permissionsGroupNum size:" + f54219c.size());
        }
    }

    /* renamed from: j */
    public static String[] m69900j(String str) {
        str.hashCode();
        switch (str) {
            case "android.permission.READ_CALENDAR":
            case "android.permission.WRITE_CALENDAR":
                return new String[]{"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};
            case "android.permission.READ_CALL_LOG":
            case "android.permission.WRITE_CALL_LOG":
                return new String[]{"android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG"};
            case "android.permission.READ_PHONE_NUMBERS":
            case "android.permission.READ_PHONE_STATE":
                return new String[]{"android.permission.READ_PHONE_NUMBERS", "android.permission.READ_PHONE_STATE"};
            case "android.permission.READ_EXTERNAL_STORAGE":
            case "android.permission.WRITE_EXTERNAL_STORAGE":
                return new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
            case "android.permission.WRITE_CONTACTS":
            case "android.permission.READ_CONTACTS":
                return new String[]{"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS"};
            default:
                AbstractC10896a.m65888w("PermissionUtil", "filterPermissions not match");
                return new String[]{str};
        }
    }

    /* renamed from: n */
    public static boolean m69901n() throws PackageManager.NameNotFoundException {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("flag is:");
            int i10 = f54217a;
            sb2.append(i10);
            AbstractC10896a.m65887i("PermissionUtil", sb2.toString());
            if (i10 == 1) {
                return true;
            }
            PermissionInfo permissionInfo = C0213f.m1377a().getPackageManager().getPermissionInfo("com.android.permission.GET_INSTALLED_APPS", 0);
            AbstractC10896a.m65887i("PermissionUtil", "permission type is:" + permissionInfo.getProtection());
            return permissionInfo.getProtection() == 1;
        } catch (PackageManager.NameNotFoundException e10) {
            AbstractC10896a.m65887i("PermissionUtil", "getInstalledAppsPermission error:" + e10.getMessage());
            return false;
        }
    }

    /* renamed from: o */
    public static /* synthetic */ void m69902o(Activity activity, String str) {
        if (str != null) {
            C0212e0.m1365o(activity, "sp_permission", str, true);
        }
    }

    /* renamed from: b */
    public List<String> m69903b(Activity activity, List<String> list) {
        return m69904c(activity, list);
    }

    /* renamed from: c */
    public List<String> m69904c(Context context, List<String> list) {
        if (list == null) {
            AbstractC10896a.m65888w("PermissionUtil", "permissions is null");
            return new ArrayList();
        }
        if (context == null) {
            AbstractC10896a.m65887i("PermissionUtil", "checkPermissionsGranted activity null");
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (context.checkSelfPermission(str) != 0) {
                AbstractC10896a.m65887i("PermissionUtil", "checkPermissions " + str + " not granted");
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    public String m69905d(List<String> list, Activity activity) {
        if (activity == null || list == null || list.size() == 0) {
            AbstractC10896a.m65887i("PermissionUtil", "getDialogString param null");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            Integer num = f54219c.get(it.next());
            AbstractC10896a.m65887i("PermissionUtil", "getDialogString permissionNum is:" + num + ",permissionsGroupNum map size is:" + f54219c.size());
            hashSet.add(num);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            arrayList2.add((Integer) it2.next());
        }
        Collections.sort(arrayList2, new b());
        Iterator it3 = hashSet.iterator();
        while (it3.hasNext()) {
            Integer num2 = (Integer) it3.next();
            String strM69910i = m69910i(f54221e.get(num2.intValue()), activity);
            AbstractC10896a.m65887i("PermissionUtil", "permission is:" + num2 + ",name is:" + strM69910i);
            arrayList.add(strM69910i);
        }
        return m69912l(activity, arrayList);
    }

    /* renamed from: e */
    public String m69906e(List<String> list, Activity activity) {
        if (activity == null || list == null || list.size() == 0) {
            AbstractC10896a.m65887i("PermissionUtil", "getDialogString param null");
            return null;
        }
        String str = "";
        for (String str2 : list) {
            boolean z10 = true;
            boolean z11 = "android.permission.READ_CALENDAR".equals(str2) || "android.permission.WRITE_CALENDAR".equals(str2);
            if (!"android.permission.READ_CONTACTS".equals(str2) && !"android.permission.WRITE_CONTACTS".equals(str2)) {
                z10 = false;
            }
            if (z11) {
                str = "calendar";
            } else if (z10) {
                str = "addressbook";
            }
        }
        return str;
    }

    /* renamed from: f */
    public List<String> m69907f(List<String> list) {
        HashSet hashSet = new HashSet();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            List<String> listM69908g = m69908g(it.next());
            if (listM69908g != null && listM69908g.size() > 0) {
                hashSet.addAll(listM69908g);
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(hashSet);
        return arrayList;
    }

    /* renamed from: g */
    public final List<String> m69908g(String str) {
        str.hashCode();
        switch (str) {
            case "cloud_disk_recording":
                return m69911k("cloud_disk_recording");
            case "sync_ablum":
                return m69911k("sync_ablum");
            case "backup":
                return m69911k(CloudBackupConstant.Command.PMS_CMD_BACKUP);
            case "backup_sms":
                return m69911k("backup_sms");
            case "phone_finder":
                return m69911k("phone_finder");
            case "cloud_disk_sms":
                return m69911k("cloud_disk_sms");
            case "sync_contact":
                return m69911k("sync_contact");
            case "cloud_disk_calllog":
                return m69911k("cloud_disk_calllog");
            case "sync_calendar":
                return m69911k("sync_calendar");
            case "backup_calllog":
                return m69911k("backup_calllog");
            case "backup_contact":
                return m69911k("backup_contact");
            case "backup_calendar":
                return m69911k("backup_calendar");
            default:
                return null;
        }
    }

    /* renamed from: h */
    public List<String> m69909h(String str) {
        if (str.equals("addressbook")) {
            return m69911k("sync_contact");
        }
        if (str.equals("calendar")) {
            return m69911k("sync_calendar");
        }
        if (str.equals(HNConstants.DataType.MEDIA)) {
            return m69911k("sync_ablum");
        }
        if (str.equals("autocallloglistkey")) {
            return m69911k("cloud_disk_calllog");
        }
        if (str.equals("autorecordingkey")) {
            return m69911k("cloud_disk_recording");
        }
        if (str.equals("autosmslistkey")) {
            return m69911k("cloud_disk_sms");
        }
        if (str.equals("cloud_disk_download_calllog")) {
            return m69911k("cloud_disk_calllog");
        }
        if (str.equals("cloud_disk_download_recording")) {
            return m69911k("cloud_disk_recording");
        }
        if (str.equals("cloud_disk_download_sms")) {
            return m69911k("cloud_disk_sms");
        }
        if (!str.equals(CloudBackupConstant.Command.PMS_CMD_BACKUP)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(f54220d.get(CloudBackupConstant.Command.PMS_CMD_BACKUP));
        arrayList.addAll(f54220d.get("backup_calendar"));
        arrayList.addAll(f54220d.get("backup_contact"));
        arrayList.addAll(f54220d.get("backup_calllog"));
        arrayList.addAll(f54220d.get("backup_sms"));
        return arrayList;
    }

    /* renamed from: i */
    public String m69910i(String str, Activity activity) {
        AbstractC10896a.m65887i("PermissionUtil", "getPermissionName enter,permission is:" + str);
        str.hashCode();
        switch (str) {
            case "android.permission.READ_SMS":
                return activity.getString(R$string.hicloud_permission_sms);
            case "android.permission.READ_CALENDAR":
            case "android.permission.WRITE_CALENDAR":
                return activity.getString(R$string.hicloud_permission_calendar);
            case "android.permission.READ_CALL_LOG":
            case "android.permission.WRITE_CALL_LOG":
                return activity.getString(R$string.hicloud_permission_call_log);
            case "android.permission.ACCESS_FINE_LOCATION":
            case "android.permission.ACCESS_COARSE_LOCATION":
            case "android.permission.ACCESS_BACKGROUND_LOCATION":
                return activity.getString(R$string.hicloud_permission_location);
            case "com.android.permission.GET_INSTALLED_APPS":
                return activity.getString(R$string.hicloud_permission_applist);
            case "android.permission.READ_PHONE_NUMBERS":
            case "android.permission.READ_PHONE_STATE":
            case "android.permission.CALL_PHONE":
                return activity.getString(R$string.hicloud_permission_phone);
            case "android.permission.READ_EXTERNAL_STORAGE":
            case "android.permission.WRITE_EXTERNAL_STORAGE":
                return activity.getString(R$string.hicloud_permission_storage);
            case "android.permission.WRITE_CONTACTS":
            case "android.permission.READ_CONTACTS":
                return activity.getString(R$string.hicloud_permission_contacts);
            default:
                return "";
        }
    }

    /* renamed from: k */
    public List<String> m69911k(String str) {
        return f54220d.get(str);
    }

    /* renamed from: l */
    public final String m69912l(Activity activity, List<String> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        int size = list.size();
        AbstractC10896a.m65887i("PermissionUtil", "permissionNames are:" + list);
        switch (size) {
            case 1:
                return activity.getString(R$string.hicloud_check_permission_tips_1, list.get(0));
            case 2:
                return activity.getString(R$string.hicloud_check_permission_tips_2, list.get(0), list.get(1));
            case 3:
                return activity.getString(R$string.hicloud_check_permission_tips_3, list.get(0), list.get(1), list.get(2));
            case 4:
                return activity.getString(R$string.hicloud_check_permission_tips_4, list.get(0), list.get(1), list.get(2), list.get(3));
            case 5:
                return activity.getString(R$string.hicloud_check_permission_tips_5, list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));
            case 6:
                return activity.getString(R$string.hicloud_check_permission_tips_6, list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5));
            case 7:
                return activity.getString(R$string.hicloud_check_permission_tips_7, list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6));
            case 8:
                return activity.getString(R$string.hicloud_check_permission_tips_8, list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6), list.get(7));
            default:
                return null;
        }
    }

    /* renamed from: m */
    public boolean m69913m(Activity activity, String str) {
        if (activity == null) {
            return false;
        }
        boolean z10 = !activity.shouldShowRequestPermissionRationale(str);
        boolean zM1354d = C0212e0.m1354d(activity, "sp_permission", str, false);
        AbstractC10896a.m65887i("PermissionUtil", "isAlertForbid, permission is: " + str + ", isNotForbidden: " + z10 + ", isRequested: " + zM1354d);
        return z10 && zM1354d;
    }

    /* renamed from: p */
    public void m69914p(final Activity activity, String[] strArr, int i10) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        Arrays.stream(strArr).forEach(new Consumer() { // from class: nk.a
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C11718b.m69902o(activity, (String) obj);
            }
        });
        activity.requestPermissions(strArr, i10);
    }
}
