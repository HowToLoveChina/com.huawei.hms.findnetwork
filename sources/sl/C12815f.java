package sl;

import android.database.Cursor;
import com.huawei.hianalytics.core.storage.Event;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.cloudbackup.store.manager.CloudBackupStatusDBHelper;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import ml.AbstractC11478a;
import p514o9.C11839m;
import p682ul.C13216j;

/* renamed from: sl.f */
/* loaded from: classes6.dex */
public class C12815f extends AbstractC11478a<CloudBackupStatus> {

    /* renamed from: a */
    public String f58535a;

    public C12815f() {
        this(true, null);
    }

    /* renamed from: a */
    public void m76922a() throws C9721b {
        execSQL(String.format(Locale.ENGLISH, "update %s set status = ?,sdcardTime = ? ,updateTime = ? ,dataTime = ? where status in(?,?,?)", getTableName()), new String[]{String.valueOf(0), String.valueOf(0), String.valueOf(0), String.valueOf(0), String.valueOf(1), String.valueOf(2), String.valueOf(3)});
    }

    /* renamed from: b */
    public void m76923b(String str) throws C9721b {
        execSQL(String.format(Locale.ENGLISH, "delete from %s where appId = ?;", getTableName()), new String[]{str});
    }

    public void batchReplace(List<CloudBackupStatus> list) throws C9721b {
        if (list == null || list.isEmpty()) {
            return;
        }
        batch(String.format(Locale.ENGLISH, "replace into %s(appId, uid, appName, appType, itemTotal, dataBytes, codeBytes, backup_switch, backup_data, attachBytes, alreadyCount, itemCount, alreadyBytes, increase, scenceId, backupType, status, type, dataTime, briefTime, sdcardTime, updateTime, record_id, quotaType, properties, oriBackupAppName, splitApkType, androidDataStrategy, data1, data2, data3, data4, data5, data6, progressPower, data7, data8, data9, data10, data11, data12) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", getTableName()), list);
    }

    /* renamed from: c */
    public void m76924c(String str, int i10) throws C9721b {
        execSQL(String.format(Locale.ENGLISH, "delete from %s where appId = ? and uid = ?;", getTableName()), new String[]{str, String.valueOf(i10)});
    }

    public void clear() {
        try {
            delete(getTableName(), null, null);
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupStatusOperator", "delete backup modules error." + e10.getMessage());
        }
    }

    @Override // ml.AbstractC11478a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public String[] getColumns(CloudBackupStatus cloudBackupStatus) {
        return new String[]{cloudBackupStatus.m29870d(), String.valueOf(cloudBackupStatus.m29861N()), cloudBackupStatus.m29871e(), String.valueOf(cloudBackupStatus.m29872f()), String.valueOf(cloudBackupStatus.m29877l()), String.valueOf(cloudBackupStatus.m29875i()), String.valueOf(cloudBackupStatus.m29874h()), String.valueOf(cloudBackupStatus.m29353I0()), String.valueOf(cloudBackupStatus.m29351H0()), String.valueOf(cloudBackupStatus.m29873g()), String.valueOf(cloudBackupStatus.m29869c()), String.valueOf(cloudBackupStatus.m29876j()), String.valueOf(cloudBackupStatus.m29868a()), String.valueOf(cloudBackupStatus.m29389Z0()), String.valueOf(cloudBackupStatus.m29858I()), String.valueOf(cloudBackupStatus.m29355J0()), String.valueOf(cloudBackupStatus.m29859L()), String.valueOf(cloudBackupStatus.m29860M()), String.valueOf(cloudBackupStatus.m29385X0()), String.valueOf(cloudBackupStatus.m29358K0()), String.valueOf(cloudBackupStatus.m29402f1()), String.valueOf(cloudBackupStatus.m29404g1()), cloudBackupStatus.m29398d1(), String.valueOf(cloudBackupStatus.m29396c1()), cloudBackupStatus.m29393b1(), cloudBackupStatus.mo29421n(), cloudBackupStatus.mo29357K(), cloudBackupStatus.m29345E0(), cloudBackupStatus.m29360L0(), cloudBackupStatus.m29368P0(), cloudBackupStatus.m29371Q0(), cloudBackupStatus.m29373R0(), cloudBackupStatus.m29375S0(), cloudBackupStatus.m29377T0(), String.valueOf(cloudBackupStatus.m29391a1()), cloudBackupStatus.m29379U0(), cloudBackupStatus.m29381V0(), cloudBackupStatus.m29383W0(), cloudBackupStatus.m29362M0(), cloudBackupStatus.m29364N0(), cloudBackupStatus.m29366O0()};
    }

    @Override // ml.AbstractC11478a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public CloudBackupStatus getObject(Cursor cursor) {
        CloudBackupStatus cloudBackupStatus = new CloudBackupStatus();
        cloudBackupStatus.mo29313Y(cursor.getString(cursor.getColumnIndex("appId"))).mo29340B0(cursor.getInt(cursor.getColumnIndex("uid"))).mo29316a0(cursor.getString(cursor.getColumnIndex("appName"))).mo29318b0(cursor.getInt(cursor.getColumnIndex("appType"))).mo29327g0(cursor.getInt(cursor.getColumnIndex("itemTotal"))).mo29323e0(cursor.getLong(cursor.getColumnIndex("dataBytes"))).mo29321d0(cursor.getLong(cursor.getColumnIndex("codeBytes"))).m29454z1(cursor.getInt(cursor.getColumnIndex("backup_switch"))).m29453y1(cursor.getInt(cursor.getColumnIndex("backup_data"))).mo29395c0(cursor.getLong(cursor.getColumnIndex("attachBytes"))).mo29310W(cursor.getInt(cursor.getColumnIndex("alreadyCount"))).mo29325f0(cursor.getInt(cursor.getColumnIndex("itemCount"))).mo29308V(cursor.getLong(cursor.getColumnIndex("alreadyBytes"))).m29378T1(cursor.getInt(cursor.getColumnIndex("increase"))).mo29449x0(cursor.getInt(cursor.getColumnIndex("scenceId"))).m29341B1(cursor.getInt(cursor.getColumnIndex("backupType"))).mo29338z0(cursor.getInt(cursor.getColumnIndex("status"))).mo29289A0(cursor.getInt(cursor.getColumnIndex("type"))).m29436s2(cursor.getLong(cursor.getColumnIndex("updateTime"))).m29423n2(cursor.getLong(cursor.getColumnIndex("sdcardTime"))).m29374R1(cursor.getLong(cursor.getColumnIndex("dataTime"))).m29342C1(cursor.getLong(cursor.getColumnIndex("briefTime"))).m29405g2(cursor.getString(cursor.getColumnIndex("record_id"))).m29403f2(cursor.getInt(cursor.getColumnIndex("quotaType"))).m29401e2(cursor.getString(cursor.getColumnIndex(Event.EventConstants.PROPERTIES))).mo29413k0(cursor.getString(cursor.getColumnIndex("oriBackupAppName"))).mo29452y0(cursor.getString(cursor.getColumnIndex("splitApkType"))).m29432r1(cursor.getString(cursor.getColumnIndex("androidDataStrategy"))).m29346E1(cursor.getString(cursor.getColumnIndex("data1"))).m29354I1(cursor.getString(cursor.getColumnIndex("data2"))).m29356J1(cursor.getString(cursor.getColumnIndex("data3"))).m29359K1(cursor.getString(cursor.getColumnIndex("data4"))).m29361L1(cursor.getString(cursor.getColumnIndex("data5"))).m29363M1(cursor.getString(cursor.getColumnIndex("data6"))).m29399d2(cursor.getInt(cursor.getColumnIndex("progressPower"))).m29365N1(cursor.getString(cursor.getColumnIndex("data7"))).m29367O1(cursor.getString(cursor.getColumnIndex("data8"))).m29369P1(cursor.getString(cursor.getColumnIndex("data9"))).m29348F1(cursor.getString(cursor.getColumnIndex("data10"))).m29350G1(cursor.getString(cursor.getColumnIndex("data11"))).m29352H1(cursor.getString(cursor.getColumnIndex("data12")));
        return cloudBackupStatus;
    }

    /* renamed from: f */
    public void m76927f() {
        try {
            execSQL(CloudBackupStatusDBHelper.f22413a);
            if (!isTableExist("app_backup_status")) {
                C11839m.m70688i("CloudBackupStatusOperator", "onUpgradeAppTwin old table not exist");
                return;
            }
            execSQL("replace into t_backup_status select appId, 0 as uid, appName, appType, itemTotal, dataBytes, codeBytes, backup_switch, data_flag as backup_data, 0 as attachBytes, alreadyCount, itemCount, alreadyBytes, 0 as increase, 0 as scenceId, 0 as backupType,  status, type, date_invalid as dataTime, 0 as briefTime, date_modify as sdcardTime, date_create as updateTime, record_id, 0 as quotaType, '' as properties, data1, data2, data3, data4, data5, data6 from app_backup_status where status >= 5");
            execSQL("replace into t_backup_status select appId, 0 as uid, appName, appType, itemTotal, dataBytes, codeBytes, backup_switch, data_flag as backup_data, 0 as attachBytes, alreadyCount, itemCount, alreadyBytes, 0 as increase, 0 as scenceId, 0 as backupType,  0 as status, -1 as type, 0 as dataTime, 0 as briefTime, 0 as sdcardTime, 0 as updateTime, record_id, 0 as quotaType, '' as properties, data1, data2, data3, data4, data5, data6 from app_backup_status where status < 5");
            drop("app_backup_status");
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupStatusOperator", "onUpgradeAppTwin error: " + e10.getMessage());
        }
    }

    /* renamed from: g */
    public CloudBackupStatus m76928g(String str) throws C9721b {
        List<CloudBackupStatus> listQuery = query(String.format(Locale.ENGLISH, "select appId, uid, appName, appType, itemTotal, dataBytes, codeBytes, backup_switch, backup_data, attachBytes, alreadyCount, itemCount, alreadyBytes, increase, scenceId, backupType, status, type, dataTime, briefTime, sdcardTime, updateTime, record_id, quotaType, properties, oriBackupAppName, splitApkType, androidDataStrategy, data1, data2, data3, data4, data5, data6, progressPower, data7, data8, data9, data10, data11, data12 from %s where appId = ?;", getTableName()), new String[]{str});
        if (listQuery.isEmpty()) {
            return null;
        }
        return listQuery.get(0);
    }

    public String getTableName() {
        return this.f58535a;
    }

    /* renamed from: h */
    public CloudBackupStatus m76929h(String str, int i10) throws C9721b {
        List<CloudBackupStatus> listQuery = query(String.format(Locale.ENGLISH, "select appId, uid, appName, appType, itemTotal, dataBytes, codeBytes, backup_switch, backup_data, attachBytes, alreadyCount, itemCount, alreadyBytes, increase, scenceId, backupType, status, type, dataTime, briefTime, sdcardTime, updateTime, record_id, quotaType, properties, oriBackupAppName, splitApkType, androidDataStrategy, data1, data2, data3, data4, data5, data6, progressPower, data7, data8, data9, data10, data11, data12 from %s where appId = ? and uid = ?;", getTableName()), new String[]{str, String.valueOf(i10)});
        if (listQuery.isEmpty()) {
            return null;
        }
        return listQuery.get(0);
    }

    /* renamed from: i */
    public List<CloudBackupStatus> m76930i() {
        try {
            return query(String.format(Locale.ENGLISH, "select appId, uid, appName, appType, itemTotal, dataBytes, codeBytes, backup_switch, backup_data, attachBytes, alreadyCount, itemCount, alreadyBytes, increase, scenceId, backupType, status, type, dataTime, briefTime, sdcardTime, updateTime, record_id, quotaType, properties, oriBackupAppName, splitApkType, androidDataStrategy, data1, data2, data3, data4, data5, data6, progressPower, data7, data8, data9, data10, data11, data12 from %s;", getTableName()), null);
        } catch (C9721b unused) {
            return new ArrayList();
        }
    }

    /* renamed from: j */
    public List<CloudBackupStatus> m76931j() throws C9721b {
        return query(String.format(Locale.ENGLISH, "select appId, uid, appName, appType, itemTotal, dataBytes, codeBytes, backup_switch, backup_data, attachBytes, alreadyCount, itemCount, alreadyBytes, increase, scenceId, backupType, status, type, dataTime, briefTime, sdcardTime, updateTime, record_id, quotaType, properties, oriBackupAppName, splitApkType, androidDataStrategy, data1, data2, data3, data4, data5, data6, progressPower, data7, data8, data9, data10, data11, data12 from %s;", getTableName()), null);
    }

    /* renamed from: k */
    public List<CloudBackupStatus> m76932k() throws C9721b {
        return query(String.format(Locale.ENGLISH, "select appId, uid, appName, appType, itemTotal, dataBytes, codeBytes, backup_switch, backup_data, attachBytes, alreadyCount, itemCount, alreadyBytes, increase, scenceId, backupType, status, type, dataTime, briefTime, sdcardTime, updateTime, record_id, quotaType, properties, oriBackupAppName, splitApkType, androidDataStrategy, data1, data2, data3, data4, data5, data6, progressPower, data7, data8, data9, data10, data11, data12 from %s;", getTableName()), new String[0]);
    }

    /* renamed from: l */
    public List<CloudBackupStatus> m76933l(String str) throws C9721b {
        return query(String.format(Locale.ENGLISH, "select appId, uid, appName, appType, itemTotal, dataBytes, codeBytes, backup_switch, backup_data, attachBytes, alreadyCount, itemCount, alreadyBytes, increase, scenceId, backupType, status, type, dataTime, briefTime, sdcardTime, updateTime, record_id, quotaType, properties, oriBackupAppName, splitApkType, androidDataStrategy, data1, data2, data3, data4, data5, data6, progressPower, data7, data8, data9, data10, data11, data12 from %s where appId = ?;", getTableName()), new String[]{str});
    }

    /* renamed from: m */
    public void m76934m(CloudBackupStatus cloudBackupStatus) throws C9721b {
        batchReplace(Collections.singletonList(cloudBackupStatus));
    }

    /* renamed from: n */
    public void m76935n(long j10, String str, int i10) {
        try {
            execSQL(String.format(Locale.ENGLISH, "update %s set sdcardTime = ? where appId = ? and uid = ?;", getTableName()), new String[]{String.valueOf(j10), str, String.valueOf(i10)});
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupStatusOperator", "updateBackupDateModify error: " + str + e10.getMessage());
        }
    }

    /* renamed from: o */
    public void m76936o(String str, int i10, String str2) {
        try {
            execSQL(String.format(Locale.ENGLISH, "update %s set properties = ? where appId = ? and uid = ?;", getTableName()), new String[]{String.valueOf(str2), str, String.valueOf(i10)});
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupStatusOperator", "updateBackupProperties error: " + str + e10.getMessage());
        }
    }

    public C12815f(String str) {
        this(true, str);
    }

    public C12815f(boolean z10, String str) {
        super(C13216j.m79427l(C13216j.c.STATUS, null));
        if ("Refurbishment".equalsIgnoreCase(str)) {
            this.f58535a = "t_backup_status_refurbish";
        } else if ("interim".equalsIgnoreCase(str)) {
            this.f58535a = "t_backup_status_tempbackup";
        } else {
            this.f58535a = "t_backup_status";
        }
        if (!z10 || isTableExist("t_backup_status")) {
            return;
        }
        try {
            C11839m.m70688i("CloudBackupStatusOperator", "table not exist, create table");
            execSQL(CloudBackupStatusDBHelper.f22413a);
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupStatusOperator", "create table error: " + e10.getMessage());
        }
    }
}
