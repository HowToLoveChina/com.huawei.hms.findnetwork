package p732w8;

import android.content.Context;
import android.os.AsyncTask;
import com.huawei.android.hicloud.cloudspace.bean.TotalStorageInfo;
import com.huawei.android.hicloud.cloudspace.manager.CloudStorageTaskCallback;
import p052cb.C1414k;
import p514o9.C11839m;
import p703v8.C13382s;

/* renamed from: w8.u */
/* loaded from: classes2.dex */
public class AsyncTaskC13570u extends AsyncTask<Void, Void, Void> {

    /* renamed from: e */
    public static AsyncTaskC13570u f61056e;

    /* renamed from: a */
    public Context f61057a;

    /* renamed from: b */
    public CloudStorageTaskCallback f61058b;

    /* renamed from: c */
    public C13382s f61059c = new C13382s();

    /* renamed from: d */
    public int f61060d = 0;

    public AsyncTaskC13570u(Context context, CloudStorageTaskCallback cloudStorageTaskCallback) {
        this.f61057a = context;
        this.f61058b = cloudStorageTaskCallback;
    }

    /* renamed from: b */
    public static AsyncTaskC13570u m81556b(Context context, CloudStorageTaskCallback cloudStorageTaskCallback) {
        if (f61056e == null || AsyncTask.Status.FINISHED.equals(f61056e.getStatus())) {
            f61056e = new AsyncTaskC13570u(context, cloudStorageTaskCallback);
        } else {
            AsyncTaskC13570u asyncTaskC13570u = f61056e;
            if (cloudStorageTaskCallback != asyncTaskC13570u.f61058b) {
                asyncTaskC13570u.f61058b = cloudStorageTaskCallback;
            }
        }
        return f61056e;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) throws C1414k {
        long jCurrentTimeMillis = System.currentTimeMillis();
        TotalStorageInfo totalStorageInfoM80361e = this.f61059c.m80361e();
        CloudStorageTaskCallback cloudStorageTaskCallback = this.f61058b;
        if (cloudStorageTaskCallback == null) {
            return null;
        }
        if (totalStorageInfoM80361e != null) {
            cloudStorageTaskCallback.mo15484a("total_size", totalStorageInfoM80361e, this.f61060d);
        } else {
            cloudStorageTaskCallback.mo15484a("total_size", null, this.f61060d);
        }
        C11839m.m70688i("GetTotalSizeTask", "requestId=" + this.f61060d + ", totalSize time=" + (System.currentTimeMillis() - jCurrentTimeMillis));
        return null;
    }

    @Override // android.os.AsyncTask
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r12) {
    }

    /* renamed from: d */
    public void m81559d(int i10) {
        C11839m.m70688i("GetTotalSizeTask", "setRequestId=" + i10);
        this.f61060d = i10;
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
    }
}
