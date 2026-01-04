package p711vl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huawei.android.hicloud.cloudbackup.bean.BackupCardInfo;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupState;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.hicloud.router.data.UserBackupInfo;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mk.C11477c;
import p015ak.C0214f0;
import p015ak.C0241z;
import p514o9.C11839m;

/* renamed from: vl.a */
/* loaded from: classes6.dex */
public class C13461a {

    /* renamed from: a */
    public Context f60635a;

    /* renamed from: b */
    public SharedPreferences f60636b;

    /* renamed from: vl.a$b */
    public static class b {

        /* renamed from: a */
        public static final C13461a f60637a = new C13461a();
    }

    /* renamed from: vl.a$c */
    public static class c extends TypeToken<List<Map<String, String>>> {
        public c() {
        }
    }

    /* renamed from: d */
    public static C13461a m81002d(Context context) {
        if (b.f60637a.f60636b == null || b.f60637a.f60635a == null) {
            b.f60637a.m81009h(context);
        }
        return b.f60637a;
    }

    /* renamed from: a */
    public void m81003a() {
        SharedPreferences sharedPreferences = this.f60636b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().clear().commit();
        }
    }

    /* renamed from: b */
    public BackupCardInfo m81004b() {
        try {
            SharedPreferences sharedPreferences = this.f60636b;
            if (sharedPreferences == null) {
                return null;
            }
            String string = sharedPreferences.getString("cloud_backup_base_card_info", "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return (BackupCardInfo) new Gson().fromJson(string, BackupCardInfo.class);
        } catch (Exception e10) {
            C11839m.m70688i("BackupDeviceSp", "getBackupCardInfo error: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: c */
    public CloudBackupState m81005c() {
        try {
            CloudBackupState cloudBackupState = (CloudBackupState) new Gson().fromJson(m81006e("cloudBackupState", ""), CloudBackupState.class);
            if (cloudBackupState != null) {
                return cloudBackupState;
            }
            return null;
        } catch (Exception e10) {
            C11839m.m70688i("BackupDeviceSp", "getUserDeviceInfo json error " + e10.toString());
            return null;
        }
    }

    /* renamed from: e */
    public String m81006e(String str, String str2) {
        SharedPreferences sharedPreferences = this.f60636b;
        return sharedPreferences != null ? sharedPreferences.getString(str, str2) : "";
    }

    /* renamed from: f */
    public List<UserBackupInfo.UserDeviceInfo> m81007f() {
        ArrayList arrayList = new ArrayList();
        try {
            List<Map> list = (List) new Gson().fromJson(m81006e("tempBackupDeviceInfo", ""), new c().getType());
            if (list == null) {
                C11839m.m70688i("BackupDeviceSp", "getTempDeviceInfo userDeviceInfoMap is null");
                return arrayList;
            }
            for (Map map : list) {
                UserBackupInfo.UserDeviceInfo userDeviceInfo = new UserBackupInfo.UserDeviceInfo();
                String strM68633c = C11477c.m68633c((String) map.get("devDisplayName"));
                if (TextUtils.isEmpty(strM68633c)) {
                    strM68633c = (String) map.get("devDisplayName");
                }
                userDeviceInfo.setDevDisplayName(strM68633c);
                userDeviceInfo.setBackupDeviceId((String) map.get(CloudBackupConstant.BACKUP_DEVICE_ID));
                userDeviceInfo.setDeviceCategory((String) map.get("deviceCategory"));
                userDeviceInfo.setDeviceType(C0241z.m1685c((String) map.get(JsbMapKeyNames.H5_DEVICE_TYPE)));
                userDeviceInfo.setCurrent(Boolean.valueOf((String) map.get("isCurrent")).booleanValue());
                userDeviceInfo.setLastbackupTime(C0241z.m1688f((String) map.get("lastbackupTime")));
                String strM68633c2 = C11477c.m68633c((String) map.get("deviceId"));
                if (TextUtils.isEmpty(strM68633c2)) {
                    strM68633c2 = (String) map.get("deviceId");
                }
                userDeviceInfo.setDeviceID(strM68633c2);
                userDeviceInfo.setSize(C0241z.m1688f((String) map.get("size")));
                String strM68633c3 = C11477c.m68633c((String) map.get("deviceName"));
                if (TextUtils.isEmpty(strM68633c3)) {
                    strM68633c3 = (String) map.get("deviceName");
                }
                userDeviceInfo.setDeviceName(strM68633c3);
                arrayList.add(userDeviceInfo);
            }
            return arrayList;
        } catch (Exception e10) {
            C11839m.m70688i("BackupDeviceSp", "getTempDeviceInfo json error " + e10.getMessage());
            return arrayList;
        }
    }

    /* renamed from: g */
    public List<UserBackupInfo.UserDeviceInfo> m81008g() {
        ArrayList arrayList = new ArrayList();
        try {
            List<Map> list = (List) new Gson().fromJson(m81006e("backupDeviceInfo", ""), new c().getType());
            if (list == null) {
                C11839m.m70688i("BackupDeviceSp", "userDeviceInfoMap  is null");
                return arrayList;
            }
            for (Map map : list) {
                UserBackupInfo.UserDeviceInfo userDeviceInfo = new UserBackupInfo.UserDeviceInfo();
                String strM68633c = C11477c.m68633c((String) map.get("devDisplayName"));
                if (TextUtils.isEmpty(strM68633c)) {
                    strM68633c = (String) map.get("devDisplayName");
                }
                userDeviceInfo.setDevDisplayName(strM68633c);
                userDeviceInfo.setBackupDeviceId((String) map.get(CloudBackupConstant.BACKUP_DEVICE_ID));
                userDeviceInfo.setDeviceCategory((String) map.get("deviceCategory"));
                userDeviceInfo.setDeviceType(C0241z.m1685c((String) map.get(JsbMapKeyNames.H5_DEVICE_TYPE)));
                userDeviceInfo.setCurrent(Boolean.valueOf((String) map.get("isCurrent")).booleanValue());
                userDeviceInfo.setLastbackupTime(C0241z.m1688f((String) map.get("lastbackupTime")));
                String strM68633c2 = C11477c.m68633c((String) map.get("deviceId"));
                if (TextUtils.isEmpty(strM68633c2)) {
                    strM68633c2 = (String) map.get("deviceId");
                }
                userDeviceInfo.setDeviceID(strM68633c2);
                userDeviceInfo.setSize(C0241z.m1688f((String) map.get("size")));
                String strM68633c3 = C11477c.m68633c((String) map.get("deviceName"));
                if (TextUtils.isEmpty(strM68633c3)) {
                    strM68633c3 = (String) map.get("deviceName");
                }
                userDeviceInfo.setDeviceName(strM68633c3);
                arrayList.add(userDeviceInfo);
            }
            return arrayList;
        } catch (Exception e10) {
            C11839m.m70688i("BackupDeviceSp", "getUserDeviceInfo json error " + e10.toString());
            return arrayList;
        }
    }

    /* renamed from: h */
    public final void m81009h(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f60635a = applicationContext;
        this.f60636b = C0214f0.m1382b(applicationContext, "backupdevicesp", 0);
    }

    /* renamed from: i */
    public void m81010i(BackupCardInfo backupCardInfo) {
        SharedPreferences sharedPreferences = this.f60636b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("cloud_backup_base_card_info", new Gson().toJson(backupCardInfo));
            editorEdit.commit();
        }
    }

    /* renamed from: j */
    public void m81011j(List<UserBackupInfo.UserDeviceInfo> list) {
        SharedPreferences sharedPreferences = this.f60636b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("backupDeviceInfo", new Gson().toJson(list));
            editorEdit.commit();
        }
    }

    /* renamed from: k */
    public void m81012k(CloudBackupState cloudBackupState) {
        SharedPreferences sharedPreferences = this.f60636b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("cloudBackupState", new Gson().toJson(cloudBackupState));
            editorEdit.commit();
        }
    }

    /* renamed from: l */
    public void m81013l(List<UserBackupInfo.UserDeviceInfo> list) {
        SharedPreferences sharedPreferences = this.f60636b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("tempBackupDeviceInfo", new Gson().toJson(list));
            editorEdit.commit();
        }
    }

    public C13461a() {
        this.f60635a = null;
        this.f60636b = null;
    }
}
