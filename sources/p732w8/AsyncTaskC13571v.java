package p732w8;

import android.os.AsyncTask;
import com.huawei.android.hicloud.cloudspace.manager.CloudStorageTaskCallback;
import p514o9.C11839m;
import p703v8.C13383t;

/* renamed from: w8.v */
/* loaded from: classes2.dex */
public class AsyncTaskC13571v extends AsyncTask<Void, Void, Void> {

    /* renamed from: d */
    public static AsyncTaskC13571v f61061d;

    /* renamed from: a */
    public CloudStorageTaskCallback f61062a;

    /* renamed from: b */
    public C13383t f61063b = new C13383t();

    /* renamed from: c */
    public int f61064c = 0;

    public AsyncTaskC13571v(CloudStorageTaskCallback cloudStorageTaskCallback) {
        this.f61062a = cloudStorageTaskCallback;
    }

    /* renamed from: b */
    public static AsyncTaskC13571v m81560b(CloudStorageTaskCallback cloudStorageTaskCallback) {
        if (f61061d == null || AsyncTask.Status.FINISHED.equals(f61061d.getStatus())) {
            f61061d = new AsyncTaskC13571v(cloudStorageTaskCallback);
        } else {
            AsyncTaskC13571v asyncTaskC13571v = f61061d;
            if (cloudStorageTaskCallback != asyncTaskC13571v.f61062a) {
                asyncTaskC13571v.f61062a = cloudStorageTaskCallback;
            }
        }
        return f61061d;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) throws NumberFormatException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f61062a.mo15484a("used_size", Long.valueOf(this.f61063b.m80362e()), this.f61064c);
        C11839m.m70688i("GetUsedSizeTask", "requestId=" + this.f61064c + ", usedSize time=" + (System.currentTimeMillis() - jCurrentTimeMillis));
        return null;
    }

    @Override // android.os.AsyncTask
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r12) {
    }

    /* renamed from: d */
    public void m81563d(int i10) {
        C11839m.m70688i("GetUsedSizeTask", "setRequestId=" + i10);
        this.f61064c = i10;
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
    }
}
