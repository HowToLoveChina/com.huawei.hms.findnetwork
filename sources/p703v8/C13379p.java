package p703v8;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.huawei.android.hicloud.cloudspace.bean.BackupCacheInfo;
import com.huawei.android.hicloud.cloudspace.bean.BackupStorageInfo;
import com.huawei.android.hicloud.cloudspace.bean.CBSpaceDetail;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0213f;
import p015ak.C0214f0;
import p514o9.C11839m;

/* renamed from: v8.p */
/* loaded from: classes2.dex */
public class C13379p {

    /* renamed from: b */
    public static C13379p f60297b = new C13379p();

    /* renamed from: a */
    public SharedPreferences f60298a = C0214f0.m1382b(C0213f.m1377a(), "storage_cache_sp", 0);

    /* renamed from: f */
    public static C13379p m80310f() {
        return f60297b;
    }

    /* renamed from: a */
    public void m80311a(BackupStorageInfo backupStorageInfo) {
        String json;
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("StorageInfoCacheSpManager", "cacheBackupStorageInfo fail, context is null");
            return;
        }
        if (this.f60298a == null) {
            this.f60298a = C0214f0.m1382b(contextM1377a, "storage_cache_sp", 0);
        }
        try {
            json = new Gson().toJson(m80313c(backupStorageInfo));
        } catch (Exception e10) {
            C11839m.m70687e("StorageInfoCacheSpManager", "cacheBackupStorageInfo exception, e: " + e10.toString());
            json = "";
        }
        this.f60298a.edit().putString("backup_storage_cache", json).commit();
        m80317h(System.currentTimeMillis());
    }

    /* renamed from: b */
    public synchronized void m80312b() {
        try {
            if (this.f60298a == null) {
                this.f60298a = C0214f0.m1382b(C0213f.m1377a(), "storage_cache_sp", 0);
            }
            this.f60298a.edit().clear().commit();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: c */
    public BackupCacheInfo m80313c(BackupStorageInfo backupStorageInfo) {
        BackupCacheInfo backupCacheInfo = new BackupCacheInfo();
        backupCacheInfo.setBackupUsedSize(backupStorageInfo.getBackupUsedSize());
        backupCacheInfo.setDeviceCategorys(m80315e(backupStorageInfo.getBackupDetails()));
        return backupCacheInfo;
    }

    /* renamed from: d */
    public BackupCacheInfo m80314d() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("StorageInfoCacheSpManager", "getCachedBackupStorageInfo fail, context is null");
            return null;
        }
        if (this.f60298a == null) {
            this.f60298a = C0214f0.m1382b(contextM1377a, "storage_cache_sp", 0);
        }
        try {
            return (BackupCacheInfo) new Gson().fromJson(this.f60298a.getString("backup_storage_cache", ""), BackupCacheInfo.class);
        } catch (Exception e10) {
            C11839m.m70687e("StorageInfoCacheSpManager", "getCachedBackupStorageInfo exception, e: " + e10.toString());
            return null;
        }
    }

    /* renamed from: e */
    public List<String> m80315e(List<CBSpaceDetail> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (CBSpaceDetail cBSpaceDetail : list) {
                if (cBSpaceDetail.getSize() > 0) {
                    arrayList.add(cBSpaceDetail.getDeviceCategory());
                }
            }
        }
        return arrayList;
    }

    /* renamed from: g */
    public boolean m80316g() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("StorageInfoCacheSpManager", "isCacheValid fail, context is null");
            return false;
        }
        if (this.f60298a == null) {
            this.f60298a = C0214f0.m1382b(contextM1377a, "storage_cache_sp", 0);
        }
        return System.currentTimeMillis() - this.f60298a.getLong("last_update_time", 0L) <= 86400000;
    }

    /* renamed from: h */
    public final void m80317h(long j10) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("StorageInfoCacheSpManager", "setLastUpdateTime fail, context is null");
            return;
        }
        if (this.f60298a == null) {
            this.f60298a = C0214f0.m1382b(contextM1377a, "storage_cache_sp", 0);
        }
        this.f60298a.edit().putLong("last_update_time", j10).commit();
    }
}
