package p732w8;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudspace.bean.BackupCacheInfo;
import com.huawei.android.hicloud.cloudspace.bean.BackupStorageInfo;
import com.huawei.android.hicloud.cloudspace.manager.CloudStorageTaskCallback;
import p015ak.C0213f;
import p514o9.C11839m;
import p664u0.C13108a;
import p703v8.C13365b;
import p703v8.C13379p;

/* renamed from: w8.h */
/* loaded from: classes2.dex */
public class AsyncTaskC13557h extends AsyncTask<Void, Void, Void> {

    /* renamed from: f */
    public static AsyncTaskC13557h f60967f;

    /* renamed from: a */
    public CloudStorageTaskCallback f60968a;

    /* renamed from: b */
    public C13365b f60969b = new C13365b();

    /* renamed from: c */
    public int f60970c = 0;

    /* renamed from: d */
    public boolean f60971d = false;

    /* renamed from: e */
    public boolean f60972e = false;

    public AsyncTaskC13557h(Context context, CloudStorageTaskCallback cloudStorageTaskCallback) {
        this.f60968a = cloudStorageTaskCallback;
    }

    /* renamed from: b */
    public static AsyncTaskC13557h m81498b(Context context, CloudStorageTaskCallback cloudStorageTaskCallback) {
        if (f60967f == null || AsyncTask.Status.FINISHED.equals(f60967f.getStatus())) {
            f60967f = new AsyncTaskC13557h(context, cloudStorageTaskCallback);
        } else {
            AsyncTaskC13557h asyncTaskC13557h = f60967f;
            if (cloudStorageTaskCallback != asyncTaskC13557h.f60968a) {
                asyncTaskC13557h.f60968a = cloudStorageTaskCallback;
            }
        }
        return f60967f;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        BackupCacheInfo backupCacheInfoM80314d;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.f60971d) {
            C11839m.m70688i("GetBackupSizeTask", "requestId=" + this.f60970c + ", use cache");
            backupCacheInfoM80314d = C13379p.m80310f().m80314d();
        } else {
            backupCacheInfoM80314d = null;
        }
        if (backupCacheInfoM80314d != null) {
            C11839m.m70688i("GetBackupSizeTask", "onTaskFinishWithCache");
            this.f60968a.mo15485b(CloudBackupConstant.Command.PMS_CMD_BACKUP, backupCacheInfoM80314d, this.f60970c);
        } else {
            BackupStorageInfo backupStorageInfoM80169n = this.f60969b.m80169n();
            this.f60968a.mo15484a(CloudBackupConstant.Command.PMS_CMD_BACKUP, backupStorageInfoM80169n, this.f60970c);
            if (this.f60972e && backupStorageInfoM80169n != null) {
                m81501d();
            }
        }
        C11839m.m70688i("GetBackupSizeTask", "requestId=" + this.f60970c + ", backupSize time=" + (System.currentTimeMillis() - jCurrentTimeMillis));
        return null;
    }

    @Override // android.os.AsyncTask
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r12) {
    }

    /* renamed from: d */
    public final void m81501d() {
        Intent intent = new Intent();
        intent.setAction("com.huawei.hicloud.BACKUP_STORAGE_QUERY_SUCCESS");
        C13108a.m78878b(C0213f.m1377a()).m78881d(intent);
    }

    /* renamed from: e */
    public void m81502e(boolean z10) {
        C11839m.m70688i("GetBackupSizeTask", "setCacheFlag=" + z10);
        this.f60971d = z10;
    }

    /* renamed from: f */
    public void m81503f(int i10) {
        C11839m.m70688i("GetBackupSizeTask", "setRequestId=" + i10);
        this.f60970c = i10;
    }

    /* renamed from: g */
    public void m81504g(boolean z10) {
        this.f60972e = z10;
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
    }
}
