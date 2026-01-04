package sl;

import android.database.Cursor;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudRestoreStatusV3;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import ml.AbstractC11478a;
import p514o9.C11839m;
import p682ul.C13216j;

/* renamed from: sl.g */
/* loaded from: classes6.dex */
public class C12816g extends AbstractC11478a<CloudRestoreStatusV3> {
    public C12816g() {
        this(true);
    }

    @Override // ml.AbstractC11478a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String[] getColumns(CloudRestoreStatusV3 cloudRestoreStatusV3) {
        return new String[]{cloudRestoreStatusV3.m29503v(), cloudRestoreStatusV3.getAppId(), cloudRestoreStatusV3.getAppName(), String.valueOf(cloudRestoreStatusV3.getAppType()), String.valueOf(cloudRestoreStatusV3.getAction()), String.valueOf(cloudRestoreStatusV3.getStatus()), String.valueOf(cloudRestoreStatusV3.getType()), String.valueOf(cloudRestoreStatusV3.getCurrent()), String.valueOf(cloudRestoreStatusV3.getCount()), String.valueOf(cloudRestoreStatusV3.getSize()), String.valueOf(cloudRestoreStatusV3.getAsize()), String.valueOf(cloudRestoreStatusV3.m29476P()), String.valueOf(cloudRestoreStatusV3.m29498s()), String.valueOf(cloudRestoreStatusV3.m29492f()), cloudRestoreStatusV3.getVersionName(), String.valueOf(cloudRestoreStatusV3.getVersionCode()), String.valueOf(cloudRestoreStatusV3.m29466K()), cloudRestoreStatusV3.m29500t(), String.valueOf(cloudRestoreStatusV3.m29455A()), cloudRestoreStatusV3.m29474O(), cloudRestoreStatusV3.getMessage(), String.valueOf(cloudRestoreStatusV3.getUid()), cloudRestoreStatusV3.m29472N(), String.valueOf(m76940d(cloudRestoreStatusV3.isCompatible())), String.valueOf(m76940d(cloudRestoreStatusV3.isHarmonyNext())), String.valueOf(cloudRestoreStatusV3.getAppShowType()), cloudRestoreStatusV3.getAggVirtualAppId(), cloudRestoreStatusV3.getOriBackupAppName(), cloudRestoreStatusV3.getSplitApkType(), cloudRestoreStatusV3.getData1(), cloudRestoreStatusV3.m29493i(), cloudRestoreStatusV3.m29494p(), cloudRestoreStatusV3.m29496q(), cloudRestoreStatusV3.m29497r()};
    }

    @Override // ml.AbstractC11478a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public CloudRestoreStatusV3 getObject(Cursor cursor) {
        CloudRestoreStatusV3 cloudRestoreStatusV3 = new CloudRestoreStatusV3();
        cloudRestoreStatusV3.m29463H0(cursor.getString(0)).setAppId(cursor.getString(1)).setAppName(cursor.getString(2)).setAppType(cursor.getInt(3)).setAction(cursor.getInt(4)).setStatus(cursor.getInt(5)).setType(cursor.getInt(6)).setCurrent(cursor.getInt(7)).setCount(cursor.getInt(8)).setSize(cursor.getLong(9)).setAsize(cursor.getLong(10)).m29475O0(cursor.getInt(11)).m29460E0(cursor.getInt(12)).m29504v0(cursor.getInt(13)).m29489V0(cursor.getString(14)).m29487U0(cursor.getInt(15)).m29465J0(cursor.getInt(16)).m29462G0(cursor.getString(17)).m29464I0(cursor.getInt(18)).m29473N0(cursor.getString(19)).m29467K0(cursor.getString(20)).setUid(cursor.getInt(21)).m29471M0(cursor.getString(22)).setCompatible(m76941e(cursor.getInt(23))).setHarmonyNext(m76941e(cursor.getInt(24))).setAppShowType(cursor.getInt(25)).setAggVirtualAppId(cursor.getString(26)).setOriBackupAppName(cursor.getString(27)).setSplitApkType(cursor.getString(28)).m29508z0(cursor.getString(29)).m29456A0(cursor.getString(30)).m29457B0(cursor.getString(31)).m29458C0(cursor.getString(32)).m29459D0(cursor.getString(33));
        return cloudRestoreStatusV3;
    }

    public void batchReplace(List<CloudRestoreStatusV3> list) throws C9721b {
        if (list == null || list.isEmpty()) {
            return;
        }
        batch("replace into t_restore_status_v3(id, appId, appName, appType, action, status, type, current, count, size, asize, showType, dataType, attachmentCount, versionName, versionCode, localVersion, iconLocal, launchFlag, retCode, message, uid, properties, isCompatible, isHarmonyNext, appShowType, aggVirtualAppId, oriBackupAppName, splitApkType, data1, data2, data3, data4, data5)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", list);
    }

    /* renamed from: c */
    public void m76939c() {
        try {
            execSQL("create table if not exists t_restore_status_v3(id text,appId text not null,appName text,appType integer not null default 0,action integer not null default 0,status integer not null default 0,type integer not null default 0,current integer,count integer,size integer,asize integer,showType integer not null default 0,dataType integer not null default 0,attachmentCount integer,versionName text,versionCode integer,localVersion integer,iconLocal text,launchFlag integer,retCode text,message text,uid integer not null default 0,subStatus text,properties text,isCompatible integer,isHarmonyNext integer,appShowType integer,aggVirtualAppId text,oriBackupAppName text,splitApkType text,data1 text, data2 text, data3 text, data4 text, data5 text,primary key (appId, uid));");
            if (!isTableExist("app_restore_status_v3")) {
                C11839m.m70688i("RestoreStatusV3Operator", "onUpgradeAppTwin old table not exist");
            } else {
                execSQL("replace into t_restore_status_v3 select id, appId, appName, appType, action, status, type, current, count, size, asize, showType, dataType, attachmentCount, versionName, versionCode, localVersion, iconLocal, launchFlag, retCode, message, 0 as uid, data1, data2, data3, data4, data5 from app_restore_status_v3");
                drop("app_restore_status_v3");
            }
        } catch (C9721b e10) {
            C11839m.m70687e("RestoreStatusV3Operator", "onUpgradeAppTwin error: " + e10.getMessage());
        }
    }

    public void clear() {
        try {
            delete("t_restore_status_v3", null, null);
        } catch (C9721b e10) {
            C11839m.m70689w("RestoreStatusV3Operator", "clear restore status error." + e10.getMessage());
        }
    }

    /* renamed from: d */
    public final int m76940d(boolean z10) {
        return z10 ? 1 : 0;
    }

    /* renamed from: e */
    public final boolean m76941e(int i10) {
        return i10 == 1;
    }

    /* renamed from: f */
    public List<CloudRestoreStatusV3> m76942f(String str) throws C9721b {
        return query("select id, appId, appName, appType, action, status, type, current, count, size, asize, showType, dataType, attachmentCount, versionName, versionCode, localVersion, iconLocal, launchFlag, retCode, message, uid, properties, isCompatible, isHarmonyNext, appShowType, aggVirtualAppId, oriBackupAppName, splitApkType, data1, data2, data3, data4, data5 from t_restore_status_v3 where appId = ? order by uid;", new String[]{str});
    }

    /* renamed from: g */
    public List<CloudRestoreStatusV3> m76943g(String str, int i10) throws C9721b {
        return query("select id, appId, appName, appType, action, status, type, current, count, size, asize, showType, dataType, attachmentCount, versionName, versionCode, localVersion, iconLocal, launchFlag, retCode, message, uid, properties, isCompatible, isHarmonyNext, appShowType, aggVirtualAppId, oriBackupAppName, splitApkType, data1, data2, data3, data4, data5 from t_restore_status_v3 where appId = ? and uid = ?;", new String[]{str, String.valueOf(i10)});
    }

    /* renamed from: h */
    public List<CloudRestoreStatusV3> m76944h() throws C9721b {
        return query("select id, appId, appName, appType, action, status, type, current, count, size, asize, showType, dataType, attachmentCount, versionName, versionCode, localVersion, iconLocal, launchFlag, retCode, message, uid, properties, isCompatible, isHarmonyNext, appShowType, aggVirtualAppId, oriBackupAppName, splitApkType, data1, data2, data3, data4, data5 from t_restore_status_v3 where appType = ? or appType = ? or appType = ?;", new String[]{String.valueOf(4), String.valueOf(6), String.valueOf(7)});
    }

    /* renamed from: i */
    public List<CloudRestoreStatusV3> m76945i() throws C9721b {
        return query("select id, appId, appName, appType, action, status, type, current, count, size, asize, showType, dataType, attachmentCount, versionName, versionCode, localVersion, iconLocal, launchFlag, retCode, message, uid, properties, isCompatible, isHarmonyNext, appShowType, aggVirtualAppId, oriBackupAppName, splitApkType, data1, data2, data3, data4, data5 from t_restore_status_v3;", null);
    }

    /* renamed from: j */
    public List<CloudRestoreStatusV3> m76946j() {
        try {
            return query("select id, appId, appName, appType, action, status, type, current, count, size, asize, showType, dataType, attachmentCount, versionName, versionCode, localVersion, iconLocal, launchFlag, retCode, message, uid, properties, isCompatible, isHarmonyNext, appShowType, aggVirtualAppId, oriBackupAppName, splitApkType, data1, data2, data3, data4, data5 from t_restore_status_v3;", null);
        } catch (C9721b e10) {
            C11839m.m70689w("RestoreStatusV3Operator", "query all restore status error: " + e10.toString());
            return new ArrayList();
        }
    }

    /* renamed from: k */
    public CloudRestoreStatusV3 m76947k(String str) {
        List arrayList = new ArrayList();
        try {
            arrayList = query("select id, appId, appName, appType, action, status, type, current, count, size, asize, showType, dataType, attachmentCount, versionName, versionCode, localVersion, iconLocal, launchFlag, retCode, message, uid, properties, isCompatible, isHarmonyNext, appShowType, aggVirtualAppId, oriBackupAppName, splitApkType, data1, data2, data3, data4, data5 from t_restore_status_v3 where appId = ? order by uid;", new String[]{str});
        } catch (C9721b e10) {
            C11839m.m70689w("RestoreStatusV3Operator", "query restore status by appId error: " + e10.toString());
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (CloudRestoreStatusV3) arrayList.get(0);
    }

    /* renamed from: l */
    public CloudRestoreStatusV3 m76948l(String str, int i10) {
        try {
            List<CloudRestoreStatusV3> listM76943g = m76943g(str, i10);
            if (listM76943g.isEmpty()) {
                return null;
            }
            return listM76943g.get(0);
        } catch (C9721b e10) {
            C11839m.m70687e("RestoreStatusV3Operator", "queryByAppIdAndUid query error: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: m */
    public List<CloudRestoreStatusV3> m76949m(String str) {
        List<CloudRestoreStatusV3> arrayList = new ArrayList<>();
        try {
            arrayList = query("select id, appId, appName, appType, action, status, type, current, count, size, asize, showType, dataType, attachmentCount, versionName, versionCode, localVersion, iconLocal, launchFlag, retCode, message, uid, properties, isCompatible, isHarmonyNext, appShowType, aggVirtualAppId, oriBackupAppName, splitApkType, data1, data2, data3, data4, data5 from t_restore_status_v3 where oriBackupAppName = ? order by uid;", new String[]{str});
        } catch (C9721b e10) {
            C11839m.m70689w("RestoreStatusV3Operator", "query restore status by oriAppId error: " + e10.toString());
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    /* renamed from: n */
    public List<CloudRestoreStatusV3> m76950n(int i10) {
        try {
            return query("select id, appId, appName, appType, action, status, type, current, count, size, asize, showType, dataType, attachmentCount, versionName, versionCode, localVersion, iconLocal, launchFlag, retCode, message, uid, properties, isCompatible, isHarmonyNext, appShowType, aggVirtualAppId, oriBackupAppName, splitApkType, data1, data2, data3, data4, data5 from t_restore_status_v3 where status = ?;", new String[]{String.valueOf(i10)});
        } catch (C9721b e10) {
            C11839m.m70689w("RestoreStatusV3Operator", "query restore status by status error: " + e10.toString());
            return new ArrayList();
        }
    }

    /* renamed from: o */
    public List<CloudRestoreStatusV3> m76951o(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            return m76942f(str);
        } catch (C9721b e10) {
            C11839m.m70687e("RestoreStatusV3Operator", "queryWithOutException query error: " + e10.getMessage());
            return arrayList;
        }
    }

    /* renamed from: p */
    public void m76952p(CloudRestoreStatusV3 cloudRestoreStatusV3) throws C9721b {
        execSQL("replace into t_restore_status_v3(id, appId, appName, appType, action, status, type, current, count, size, asize, showType, dataType, attachmentCount, versionName, versionCode, localVersion, iconLocal, launchFlag, retCode, message, uid, properties, isCompatible, isHarmonyNext, appShowType, aggVirtualAppId, oriBackupAppName, splitApkType, data1, data2, data3, data4, data5)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", getColumns(cloudRestoreStatusV3));
    }

    /* renamed from: q */
    public void m76953q(String str, String str2) {
        try {
            execSQL("update t_restore_status_v3 set iconlocal = ? where appId = ?;", new String[]{str2, str});
        } catch (C9721b e10) {
            C11839m.m70689w("RestoreStatusV3Operator", "update restore status error." + e10.getMessage());
        }
    }

    /* renamed from: r */
    public void m76954r(CloudRestoreStatusV3 cloudRestoreStatusV3) {
        try {
            execSQL("update t_restore_status_v3 set current = ? where appId = ?and uid = ?;", new String[]{String.valueOf(cloudRestoreStatusV3.getCurrent()), cloudRestoreStatusV3.getAppId(), String.valueOf(cloudRestoreStatusV3.getUid())});
        } catch (C9721b e10) {
            C11839m.m70689w("RestoreStatusV3Operator", "update restore status error." + e10.getMessage());
        }
    }

    /* renamed from: s */
    public void m76955s(String str, String str2, String str3) {
        try {
            execSQL("update t_restore_status_v3 set retCode = ?, message = ? where appId = ?;", new String[]{str2, str3, str});
        } catch (C9721b e10) {
            C11839m.m70689w("RestoreStatusV3Operator", "update restore failed reason. " + e10.getMessage());
        }
    }

    /* renamed from: t */
    public void m76956t(CloudRestoreStatusV3 cloudRestoreStatusV3, C9721b c9721b) {
        if (c9721b == null) {
            C11839m.m70688i("RestoreStatusV3Operator", "updateRetCode: the exception is null");
            return;
        }
        if (c9721b.m60659c() == 3922 && c9721b.m60663g() == 4041) {
            C11839m.m70688i("RestoreStatusV3Operator", "updateRetCode:" + c9721b.m60663g() + ", appId:" + cloudRestoreStatusV3.getAppId());
            cloudRestoreStatusV3.m29473N0(String.valueOf(4041));
            m76955s(cloudRestoreStatusV3.getAppId(), String.valueOf(4041), "server source not exist");
        }
    }

    /* renamed from: u */
    public void m76957u(CloudRestoreStatusV3 cloudRestoreStatusV3) {
        if (cloudRestoreStatusV3 == null) {
            C11839m.m70689w("RestoreStatusV3Operator", "update status is null.");
        } else {
            m76959w(cloudRestoreStatusV3.getAppId(), cloudRestoreStatusV3.getStatus(), cloudRestoreStatusV3.getUid(), cloudRestoreStatusV3.getType(), cloudRestoreStatusV3.getSubStatus());
        }
    }

    /* renamed from: v */
    public void m76958v(CloudRestoreStatusV3 cloudRestoreStatusV3, int i10, int i11) {
        cloudRestoreStatusV3.setStatus(i10).setType(i11);
        m76959w(cloudRestoreStatusV3.getAppId(), i10, cloudRestoreStatusV3.getUid(), i11, cloudRestoreStatusV3.getSubStatus());
    }

    /* renamed from: w */
    public void m76959w(String str, int i10, int i11, int i12, String str2) {
        try {
            execSQL("update t_restore_status_v3 set status = ?, type = ? , subStatus = ? where appId = ? and uid = ?;", new String[]{String.valueOf(i10), String.valueOf(i12), str2, str, String.valueOf(i11)});
        } catch (C9721b e10) {
            C11839m.m70689w("RestoreStatusV3Operator", "update restore status error." + e10.getMessage());
        }
    }

    public C12816g(boolean z10) {
        super(C13216j.m79427l(C13216j.c.STATUS, null));
        if (!z10 || isTableExist("t_restore_status_v3")) {
            return;
        }
        try {
            C11839m.m70688i("RestoreStatusV3Operator", "table not exist, create table");
            execSQL("create table if not exists t_restore_status_v3(id text,appId text not null,appName text,appType integer not null default 0,action integer not null default 0,status integer not null default 0,type integer not null default 0,current integer,count integer,size integer,asize integer,showType integer not null default 0,dataType integer not null default 0,attachmentCount integer,versionName text,versionCode integer,localVersion integer,iconLocal text,launchFlag integer,retCode text,message text,uid integer not null default 0,subStatus text,properties text,isCompatible integer,isHarmonyNext integer,appShowType integer,aggVirtualAppId text,oriBackupAppName text,splitApkType text,data1 text, data2 text, data3 text, data4 text, data5 text,primary key (appId, uid));");
        } catch (C9721b e10) {
            C11839m.m70687e("RestoreStatusV3Operator", "create table error: " + e10.getMessage());
        }
    }
}
