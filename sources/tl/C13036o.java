package tl;

import android.database.Cursor;
import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.gson.JsonSyntaxException;
import com.huawei.hicloud.router.data.ExtraDeviceInfo;
import com.huawei.hicloud.router.data.UserBackupInfo;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import ml.AbstractC11478a;
import p015ak.C0213f;
import p514o9.C11839m;
import p618rm.C12540b1;
import p682ul.C13216j;

/* renamed from: tl.o */
/* loaded from: classes6.dex */
public class C13036o extends AbstractC11478a<UserBackupInfo.UserDeviceInfo> {

    /* renamed from: tl.o$a */
    public class a extends TypeToken<List<ExtraDeviceInfo>> {
        public a() {
        }
    }

    public C13036o() {
        super(C13216j.m79427l(C13216j.c.TAG, null));
    }

    /* renamed from: a */
    public void m78561a(String str, String str2) {
        try {
            execSQL("delete from t_other_device_record where backupDeviceId = ? and data2 = ?;", new String[]{str, str2});
        } catch (C9721b e10) {
            C11839m.m70689w("OtherDeviceRecordOperator", "delete other_device_record error." + e10.getMessage());
        }
    }

    @Override // ml.AbstractC11478a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String[] getColumns(UserBackupInfo.UserDeviceInfo userDeviceInfo) {
        String[] strArr = new String[15];
        strArr[0] = TextUtils.isEmpty(userDeviceInfo.getDeviceName()) ? C0213f.m1377a().getString(R$string.setting_other) : userDeviceInfo.getDeviceName();
        strArr[1] = userDeviceInfo.getDeviceID();
        strArr[2] = String.valueOf(userDeviceInfo.getSize());
        strArr[3] = String.valueOf(userDeviceInfo.getLastbackupTime());
        strArr[4] = String.valueOf(userDeviceInfo.isCurrent() ? 1 : 0);
        strArr[5] = String.valueOf(userDeviceInfo.getDeviceType());
        strArr[6] = TextUtils.isEmpty(userDeviceInfo.getDevDisplayName()) ? C0213f.m1377a().getString(R$string.setting_other) : userDeviceInfo.getDevDisplayName();
        strArr[7] = TextUtils.isEmpty(userDeviceInfo.getDeviceCategory()) ? "phone" : userDeviceInfo.getDeviceCategory();
        strArr[8] = userDeviceInfo.getBackupDeviceId();
        strArr[9] = userDeviceInfo.isOnlyRefurbish() ? "1" : "0";
        strArr[10] = TextUtils.isEmpty(userDeviceInfo.getBakId()) ? "" : userDeviceInfo.getBakId();
        strArr[11] = userDeviceInfo.isHasOnlyRefurbishAndBackingUp() ? "1" : "0";
        strArr[12] = userDeviceInfo.getExtraDeviceInfos() != null ? C12540b1.m75485c(userDeviceInfo.getExtraDeviceInfos()) : "";
        strArr[13] = userDeviceInfo.isOnlyHarmonyNext() ? "1" : "0";
        strArr[14] = C4633d0.m28404a(userDeviceInfo.getTerminalType()) ? "" : userDeviceInfo.getTerminalType();
        return strArr;
    }

    @Override // ml.AbstractC11478a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public UserBackupInfo.UserDeviceInfo getObject(Cursor cursor) {
        UserBackupInfo.UserDeviceInfo userDeviceInfo = new UserBackupInfo.UserDeviceInfo();
        userDeviceInfo.setDeviceName(cursor.getString(0));
        userDeviceInfo.setDeviceID(cursor.getString(1));
        userDeviceInfo.setSize(cursor.getLong(2));
        userDeviceInfo.setLastbackupTime(cursor.getLong(3));
        userDeviceInfo.setCurrent(cursor.getInt(4) == 1);
        userDeviceInfo.setDeviceType(cursor.getInt(5));
        userDeviceInfo.setDevDisplayName(cursor.getString(6));
        userDeviceInfo.setDeviceCategory(cursor.getString(7));
        userDeviceInfo.setBackupDeviceId(cursor.getString(8));
        userDeviceInfo.setOnlyRefurbish("1".equals(cursor.getString(9)));
        userDeviceInfo.setTempBackUp(true ^ TextUtils.isEmpty(cursor.getString(10)));
        userDeviceInfo.setBakId(cursor.getString(10));
        userDeviceInfo.setHasOnlyRefurbishAndBackingUp("1".equals(cursor.getString(11)));
        try {
            userDeviceInfo.setExtraDeviceInfos((ArrayList) C12540b1.m75484b(cursor.getString(12), new a().getType()));
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("OtherDeviceRecordOperator", "JsonSyntaxException: " + e10.getMessage());
        }
        userDeviceInfo.setOnlyHarmonyNext("1".equals(cursor.getString(13)));
        userDeviceInfo.setTerminalType(cursor.getString(14));
        return userDeviceInfo;
    }

    public void clear() {
        try {
            execSQL("delete from t_other_device_record;");
        } catch (C9721b e10) {
            C11839m.m70689w("OtherDeviceRecordOperator", "clear other_device_record error." + e10.getMessage());
        }
    }

    /* renamed from: d */
    public List<UserBackupInfo.UserDeviceInfo> m78564d() {
        return m78565e(3);
    }

    /* renamed from: e */
    public List<UserBackupInfo.UserDeviceInfo> m78565e(int i10) {
        try {
            List<UserBackupInfo.UserDeviceInfo> listQuery = query("select deviceName, deviceId, size, lastbackupTime, isCurrent, deviceType, devDisplayName, deviceCategory, backupDeviceId, data1, data2, data3, data4, data5, terminalType from t_other_device_record where isCurrent = ? and (data2 is null or data2 = \"\") order by lastbackupTime desc limit ?", new String[]{String.valueOf(0), String.valueOf(i10)});
            if (listQuery.isEmpty()) {
                return null;
            }
            return listQuery;
        } catch (C9721b e10) {
            C11839m.m70689w("OtherDeviceRecordOperator", "query other_device_record error." + e10.getMessage());
            return null;
        }
    }

    /* renamed from: f */
    public List<UserBackupInfo.UserDeviceInfo> m78566f() {
        ArrayList arrayList = new ArrayList();
        List<UserBackupInfo.UserDeviceInfo> listM78568h = m78568h();
        if (listM78568h != null) {
            arrayList.addAll(listM78568h);
        }
        List<UserBackupInfo.UserDeviceInfo> listM78565e = m78565e(queryCount());
        if (listM78565e != null) {
            arrayList.addAll(listM78565e);
        }
        return arrayList;
    }

    /* renamed from: g */
    public List<UserBackupInfo.UserDeviceInfo> m78567g() {
        ArrayList arrayList = new ArrayList();
        List<UserBackupInfo.UserDeviceInfo> listM78572l = m78572l();
        if (listM78572l != null) {
            arrayList.addAll(listM78572l);
        }
        List<UserBackupInfo.UserDeviceInfo> listM78570j = m78570j(m78571k());
        if (listM78570j != null) {
            arrayList.addAll(listM78570j);
        }
        return arrayList;
    }

    /* renamed from: h */
    public List<UserBackupInfo.UserDeviceInfo> m78568h() {
        try {
            List<UserBackupInfo.UserDeviceInfo> listQuery = query("select deviceName, deviceId, size, lastbackupTime, isCurrent, deviceType, devDisplayName, deviceCategory, backupDeviceId, data1, data2, data3, data4, data5, terminalType from t_other_device_record where isCurrent = ? and (data2 is null or data2 = \"\") order by lastbackupTime desc limit ?", new String[]{String.valueOf(1), String.valueOf(3)});
            if (listQuery.isEmpty()) {
                return null;
            }
            return listQuery;
        } catch (C9721b e10) {
            C11839m.m70689w("OtherDeviceRecordOperator", "query current_device_record error." + e10.getMessage());
            return null;
        }
    }

    /* renamed from: i */
    public List<UserBackupInfo.UserDeviceInfo> m78569i() {
        return m78570j(3);
    }

    /* renamed from: j */
    public List<UserBackupInfo.UserDeviceInfo> m78570j(int i10) {
        try {
            List<UserBackupInfo.UserDeviceInfo> listQuery = query("select deviceName, deviceId, size, lastbackupTime, isCurrent, deviceType, devDisplayName, deviceCategory, backupDeviceId, data1, data2, data3, data4, data5, terminalType from t_other_device_record where isCurrent = ? and data2 is not null and data2 != \"\" order by lastbackupTime desc limit ?", new String[]{String.valueOf(0), String.valueOf(i10)});
            if (listQuery.isEmpty()) {
                return null;
            }
            return listQuery;
        } catch (C9721b e10) {
            C11839m.m70689w("OtherDeviceRecordOperator", "queryTemp other_device_record error." + e10.getMessage());
            return null;
        }
    }

    /* renamed from: k */
    public int m78571k() {
        try {
            Cursor cursorRawQuery = rawQuery("select count(backupDeviceId) from t_other_device_record where isCurrent = ? and data2 is not null and data2 != \"\";", new String[]{String.valueOf(0)});
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        int i10 = cursorRawQuery.getInt(0);
                        cursorRawQuery.close();
                        return i10;
                    }
                } finally {
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (C9721b e10) {
            C11839m.m70689w("OtherDeviceRecordOperator", "clear other_device_record error." + e10.getMessage());
        }
        return 0;
    }

    /* renamed from: l */
    public List<UserBackupInfo.UserDeviceInfo> m78572l() {
        try {
            List<UserBackupInfo.UserDeviceInfo> listQuery = query("select deviceName, deviceId, size, lastbackupTime, isCurrent, deviceType, devDisplayName, deviceCategory, backupDeviceId, data1, data2, data3, data4, data5, terminalType from t_other_device_record where isCurrent = ? and data2 is not null and data2 != \"\" order by lastbackupTime desc limit ?", new String[]{String.valueOf(1), String.valueOf(3)});
            if (listQuery.isEmpty()) {
                return null;
            }
            return listQuery;
        } catch (C9721b e10) {
            C11839m.m70689w("OtherDeviceRecordOperator", "queryTempCurrentDevice current_device_record error." + e10.getMessage());
            return null;
        }
    }

    /* renamed from: m */
    public void m78573m(List<UserBackupInfo.UserDeviceInfo> list) {
        try {
            batch("replace into t_other_device_record(deviceName, deviceId, size, lastbackupTime, isCurrent, deviceType, devDisplayName, deviceCategory, backupDeviceId, data1, data2, data3, data4, data5, terminalType) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", list);
        } catch (C9721b e10) {
            C11839m.m70689w("OtherDeviceRecordOperator", "replace other_device_record error." + e10.getMessage());
        }
    }

    /* renamed from: n */
    public void m78574n(UserBackupInfo.UserDeviceInfo userDeviceInfo) {
        try {
            ArrayList arrayList = new ArrayList();
            String[] strArr = new String[17];
            strArr[0] = TextUtils.isEmpty(userDeviceInfo.getDeviceName()) ? C0213f.m1377a().getString(R$string.setting_other) : userDeviceInfo.getDeviceName();
            strArr[1] = userDeviceInfo.getDeviceID();
            strArr[2] = String.valueOf(userDeviceInfo.getSize());
            strArr[3] = String.valueOf(userDeviceInfo.getLastbackupTime());
            strArr[4] = String.valueOf(userDeviceInfo.isCurrent() ? 1 : 0);
            strArr[5] = String.valueOf(userDeviceInfo.getDeviceType());
            strArr[6] = TextUtils.isEmpty(userDeviceInfo.getDevDisplayName()) ? C0213f.m1377a().getString(R$string.setting_other) : userDeviceInfo.getDevDisplayName();
            strArr[7] = TextUtils.isEmpty(userDeviceInfo.getDeviceCategory()) ? "phone" : userDeviceInfo.getDeviceCategory();
            strArr[8] = userDeviceInfo.getBackupDeviceId();
            strArr[9] = userDeviceInfo.isOnlyRefurbish() ? "1" : "0";
            String bakId = "";
            strArr[10] = TextUtils.isEmpty(userDeviceInfo.getBakId()) ? "" : userDeviceInfo.getBakId();
            strArr[11] = userDeviceInfo.isHasOnlyRefurbishAndBackingUp() ? "1" : "0";
            strArr[12] = C12540b1.m75485c(userDeviceInfo.getExtraDeviceInfos());
            strArr[13] = userDeviceInfo.isOnlyHarmonyNext() ? "1" : "0";
            strArr[14] = C4633d0.m28404a(userDeviceInfo.getTerminalType()) ? "" : userDeviceInfo.getTerminalType();
            strArr[15] = userDeviceInfo.getBackupDeviceId();
            if (!TextUtils.isEmpty(userDeviceInfo.getBakId())) {
                bakId = userDeviceInfo.getBakId();
            }
            strArr[16] = bakId;
            arrayList.add(strArr);
            execute("update t_other_device_record set deviceName = ?, deviceId = ?, size = ?, lastbackupTime = ?, isCurrent = ?, deviceType = ?, devDisplayName = ?, deviceCategory = ?, backupDeviceId = ?, data1 = ?, data2 = ?, data3 = ?, data4 = ?, data5 = ?, terminalType = ? where backupDeviceId = ? and data2 = ?;", arrayList);
        } catch (C9721b e10) {
            C11839m.m70689w("OtherDeviceRecordOperator", "replace other_device_record error." + e10.getMessage());
        }
    }

    public int queryCount() {
        try {
            Cursor cursorRawQuery = rawQuery("select count(backupDeviceId) from t_other_device_record where isCurrent = ? and (data2 is null or data2 = \"\");", new String[]{String.valueOf(0)});
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        int i10 = cursorRawQuery.getInt(0);
                        cursorRawQuery.close();
                        return i10;
                    }
                } finally {
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (C9721b e10) {
            C11839m.m70689w("OtherDeviceRecordOperator", "clear other_device_record error." + e10.getMessage());
        }
        return 0;
    }
}
