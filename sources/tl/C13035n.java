package tl;

import android.database.Cursor;
import com.huawei.hicloud.cloudbackup.store.database.tags.CloudRestoreStatus;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ml.AbstractC11478a;
import p514o9.C11839m;
import p682ul.C13216j;

/* renamed from: tl.n */
/* loaded from: classes6.dex */
public class C13035n extends AbstractC11478a<CloudRestoreStatus> {
    public C13035n() {
        super(C13216j.m79427l(C13216j.c.TAG, null));
    }

    @Override // ml.AbstractC11478a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String[] getColumns(CloudRestoreStatus cloudRestoreStatus) {
        return new String[]{cloudRestoreStatus.getAppId(), cloudRestoreStatus.getAppName(), String.valueOf(cloudRestoreStatus.getAppType()), String.valueOf(cloudRestoreStatus.getAction()), String.valueOf(cloudRestoreStatus.getStatus()), String.valueOf(cloudRestoreStatus.getType()), String.valueOf(cloudRestoreStatus.getCurrent()), String.valueOf(cloudRestoreStatus.getCount()), String.valueOf(cloudRestoreStatus.getSize()), cloudRestoreStatus.m29538f(), cloudRestoreStatus.getVersionName(), String.valueOf(cloudRestoreStatus.getVersionCode()), String.valueOf(cloudRestoreStatus.getAsize()), String.valueOf(cloudRestoreStatus.getVersion()), String.valueOf(cloudRestoreStatus.m29549v()), cloudRestoreStatus.m29539i(), cloudRestoreStatus.m29540p(), cloudRestoreStatus.m29522L(), cloudRestoreStatus.m29524M(), cloudRestoreStatus.m29509A(), cloudRestoreStatus.m29520K(), String.valueOf(cloudRestoreStatus.m29526N()), cloudRestoreStatus.getData1(), cloudRestoreStatus.m29542q(), cloudRestoreStatus.m29543r(), cloudRestoreStatus.m29544s(), cloudRestoreStatus.m29546t()};
    }

    @Override // ml.AbstractC11478a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public CloudRestoreStatus getObject(Cursor cursor) {
        CloudRestoreStatus cloudRestoreStatus = new CloudRestoreStatus();
        cloudRestoreStatus.setAppId(cursor.getString(0)).setAppName(cursor.getString(1)).setAppType(cursor.getInt(2)).setAction(cursor.getInt(3)).setStatus(cursor.getInt(4)).setType(cursor.getInt(5)).setCurrent(cursor.getInt(6)).setCount(cursor.getInt(7)).setSize(cursor.getLong(8)).m29534U(cursor.getString(9)).m29527N0(cursor.getString(10)).m29525M0(cursor.getInt(11)).setAsize(cursor.getLong(12)).m29523L0(cursor.getInt(13)).m29512C0(cursor.getInt(14)).m29535V(cursor.getString(15)).m29547t0(cursor.getString(16)).m29515F0(cursor.getString(17)).m29516G0(cursor.getString(18)).m29513D0(cursor.getString(19)).m29514E0(cursor.getString(20)).m29517H0(cursor.getInt(21)).m29552x0(cursor.getString(22)).m29553y0(cursor.getString(23)).m29554z0(cursor.getString(24)).m29510A0(cursor.getString(25)).m29511B0(cursor.getString(26));
        return cloudRestoreStatus;
    }

    public void batchReplace(List<CloudRestoreStatus> list) throws C9721b {
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<CloudRestoreStatus> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(getColumns(it.next()));
        }
        execute("replace into app_restore_status(appId, appName, appType, action, status, type, current, count, size, aid, versionName, versionCode, asize, version, flag, apath, aurl, iconPath, iconUrl, iconId, iconLocal, launchFlag, data1, data2, data3, data4, data5) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", arrayList);
    }

    /* renamed from: c */
    public List<CloudRestoreStatus> m78551c() throws C9721b {
        return query("select appId, appName, appType, action, status, type, current, count, size, aid, versionName, versionCode, asize, version, flag, apath, aurl, iconPath, iconUrl, iconId, iconLocal, launchFlag, data1, data2, data3, data4, data5 from app_restore_status where appType > 0;", null);
    }

    public void clear() {
        try {
            delete("app_restore_status", null, null);
        } catch (C9721b e10) {
            C11839m.m70689w("CloudRestoreStatusOperator", "clear restore status error." + e10.getMessage());
        }
    }

    /* renamed from: d */
    public List<CloudRestoreStatus> m78552d() throws C9721b {
        return query("select appId, appName, appType, action, status, type, current, count, size, aid, versionName, versionCode, asize, version, flag, apath, aurl, iconPath, iconUrl, iconId, iconLocal, launchFlag, data1, data2, data3, data4, data5 from app_restore_status;", null);
    }

    /* renamed from: e */
    public List<CloudRestoreStatus> m78553e() {
        try {
            return query("select appId, appName, appType, action, status, type, current, count, size, aid, versionName, versionCode, asize, version, flag, apath, aurl, iconPath, iconUrl, iconId, iconLocal, launchFlag, data1, data2, data3, data4, data5 from app_restore_status;", null);
        } catch (C9721b e10) {
            C11839m.m70689w("CloudRestoreStatusOperator", "query all restore status error: " + e10.toString());
            return new ArrayList();
        }
    }

    /* renamed from: f */
    public CloudRestoreStatus m78554f(String str) {
        List arrayList = new ArrayList();
        try {
            arrayList = query("select appId, appName, appType, action, status, type, current, count, size, aid, versionName, versionCode, asize, version, flag, apath, aurl, iconPath, iconUrl, iconId, iconLocal, launchFlag, data1, data2, data3, data4, data5 from app_restore_status where appId = ?;", new String[]{str});
        } catch (C9721b e10) {
            C11839m.m70689w("CloudRestoreStatusOperator", "query restore status error: " + e10.toString());
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (CloudRestoreStatus) arrayList.get(0);
    }

    /* renamed from: g */
    public List<CloudRestoreStatus> m78555g(int i10) {
        try {
            return query("select appId, appName, appType, action, status, type, current, count, size, aid, versionName, versionCode, asize, version, flag, apath, aurl, iconPath, iconUrl, iconId, iconLocal, launchFlag, data1, data2, data3, data4, data5 from app_restore_status where status = ?;", new String[]{String.valueOf(i10)});
        } catch (C9721b e10) {
            C11839m.m70689w("CloudRestoreStatusOperator", "query restore by status error: " + e10.toString());
            return new ArrayList();
        }
    }

    /* renamed from: h */
    public void m78556h(CloudRestoreStatus cloudRestoreStatus) {
        if (cloudRestoreStatus == null) {
            C11839m.m70689w("CloudRestoreStatusOperator", "update status is null.");
        } else {
            m78558j(cloudRestoreStatus.getAppId(), cloudRestoreStatus.getStatus(), cloudRestoreStatus.getType());
        }
    }

    /* renamed from: i */
    public void m78557i(CloudRestoreStatus cloudRestoreStatus, int i10, int i11) {
        cloudRestoreStatus.setStatus(i10).setType(i11);
        m78558j(cloudRestoreStatus.getAppId(), i10, i11);
    }

    /* renamed from: j */
    public void m78558j(String str, int i10, int i11) {
        try {
            execSQL("update app_restore_status set status = ?, type = ? where appId = ?;", new String[]{String.valueOf(i10), String.valueOf(i11), str});
        } catch (C9721b e10) {
            C11839m.m70689w("CloudRestoreStatusOperator", "update restore status error." + e10.getMessage());
        }
    }

    /* renamed from: k */
    public void m78559k(String str, String str2) {
        try {
            execSQL("update app_restore_status set iconlocal = ? where appId = ?;", new String[]{str2, str});
        } catch (C9721b e10) {
            C11839m.m70689w("CloudRestoreStatusOperator", "update restore status error." + e10.getMessage());
        }
    }

    /* renamed from: l */
    public void m78560l(CloudRestoreStatus cloudRestoreStatus) {
        try {
            execSQL("update app_restore_status set current = ? where appId = ?;", new String[]{String.valueOf(cloudRestoreStatus.getCurrent()), cloudRestoreStatus.getAppId()});
        } catch (C9721b e10) {
            C11839m.m70689w("CloudRestoreStatusOperator", "update restore status error." + e10.getMessage());
        }
    }
}
