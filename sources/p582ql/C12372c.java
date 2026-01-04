package p582ql;

import android.database.Cursor;
import com.huawei.hicloud.cloudbackup.store.database.report.CloudBackupReport;
import fk.C9721b;
import java.util.Collections;
import java.util.List;
import ml.AbstractC11478a;
import p514o9.C11839m;
import p682ul.C13216j;

/* renamed from: ql.c */
/* loaded from: classes6.dex */
public class C12372c extends AbstractC11478a<CloudBackupReport> {
    public C12372c() {
        super(C13216j.m79427l(C13216j.c.STATUS, null));
    }

    /* renamed from: a */
    public void m74418a(String str) throws C9721b {
        execSQL("delete from t_backup_static where appId = ?;", new String[]{str});
    }

    @Override // ml.AbstractC11478a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String[] getColumns(CloudBackupReport cloudBackupReport) {
        return new String[]{cloudBackupReport.m29870d(), cloudBackupReport.m29871e(), String.valueOf(cloudBackupReport.m29872f()), cloudBackupReport.m29291E0(), cloudBackupReport.m29290D0(), String.valueOf(cloudBackupReport.m29859L()), String.valueOf(cloudBackupReport.m29860M()), String.valueOf(cloudBackupReport.m29302P0()), String.valueOf(cloudBackupReport.m29303Q0()), String.valueOf(cloudBackupReport.m29297K0()), String.valueOf(cloudBackupReport.m29301O0()), String.valueOf(cloudBackupReport.m29300N0()), String.valueOf(cloudBackupReport.m29298L0()), String.valueOf(cloudBackupReport.m29299M0()), cloudBackupReport.m29292F0(), cloudBackupReport.m29293G0(), cloudBackupReport.m29294H0(), cloudBackupReport.m29295I0(), cloudBackupReport.m29296J0()};
    }

    public void batchReplace(List<CloudBackupReport> list) throws C9721b {
        if (list == null || list.isEmpty()) {
            return;
        }
        batch("replace into t_backup_static(appId,appName,appType,appVersionName,appVersionCode,status,type,startTime,updateTime,endTime,returnCode,increase,estimateIncrease1,estimateIncrease2,data1,data2,data3,data4,data5) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", list);
    }

    @Override // ml.AbstractC11478a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public CloudBackupReport getObject(Cursor cursor) {
        CloudBackupReport cloudBackupReport = new CloudBackupReport();
        cloudBackupReport.mo29313Y(cursor.getString(cursor.getColumnIndex("appId"))).mo29316a0(cursor.getString(cursor.getColumnIndex("appName"))).mo29318b0(cursor.getInt(cursor.getColumnIndex("appType"))).m29312X0(cursor.getString(cursor.getColumnIndex("appVersionName"))).m29311W0(cursor.getString(cursor.getColumnIndex("appVersionCode"))).mo29338z0(cursor.getInt(cursor.getColumnIndex("status"))).mo29289A0(cursor.getInt(cursor.getColumnIndex("type"))).m29334m1(cursor.getLong(cursor.getColumnIndex("startTime"))).m29337p1(cursor.getLong(cursor.getColumnIndex("updateTime"))).m29326f1(cursor.getLong(cursor.getColumnIndex("endTime"))).m29333l1(cursor.getInt(cursor.getColumnIndex("returnCode"))).m29330i1(cursor.getLong(cursor.getColumnIndex("increase"))).m29328g1(cursor.getLong(cursor.getColumnIndex("estimateIncrease1"))).m29329h1(cursor.getLong(cursor.getColumnIndex("estimateIncrease2"))).m29315Z0(cursor.getString(cursor.getColumnIndex("data1"))).m29317a1(cursor.getString(cursor.getColumnIndex("data2"))).m29319b1(cursor.getString(cursor.getColumnIndex("data3"))).m29320c1(cursor.getString(cursor.getColumnIndex("data4"))).m29322d1(cursor.getString(cursor.getColumnIndex("data5")));
        return cloudBackupReport;
    }

    public void clear() {
        try {
            delete("t_backup_static", null, null);
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupReportOperator", "delete backup static error." + e10.getMessage());
        }
    }

    /* renamed from: d */
    public CloudBackupReport m74421d(String str) throws C9721b {
        List<CloudBackupReport> listQuery = query("select appId,appName,appType,appVersionName,appVersionCode,status,type,startTime,updateTime,endTime,returnCode,increase,estimateIncrease1,estimateIncrease2,data1,data2,data3,data4,data5 from t_backup_static where appId = ?;", new String[]{str});
        if (listQuery.isEmpty()) {
            return null;
        }
        return listQuery.get(0);
    }

    /* renamed from: e */
    public void m74422e(CloudBackupReport cloudBackupReport) throws C9721b {
        batchReplace(Collections.singletonList(cloudBackupReport));
    }
}
