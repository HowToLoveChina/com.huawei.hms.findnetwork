package p732w8;

import android.content.Context;
import android.os.AsyncTask;
import com.huawei.android.hicloud.cloudspace.manager.CloudStorageTaskCallback;
import p514o9.C11839m;
import p703v8.C13368e;
import p703v8.C13369f;

/* renamed from: w8.j */
/* loaded from: classes2.dex */
public class AsyncTaskC13559j extends AsyncTask<Void, Void, Void> {

    /* renamed from: e */
    public static AsyncTaskC13559j f60978e;

    /* renamed from: a */
    public Context f60979a;

    /* renamed from: b */
    public CloudStorageTaskCallback f60980b;

    /* renamed from: c */
    public C13369f f60981c = new C13369f();

    /* renamed from: d */
    public int f60982d = 0;

    public AsyncTaskC13559j(Context context, CloudStorageTaskCallback cloudStorageTaskCallback) {
        this.f60979a = context;
        this.f60980b = cloudStorageTaskCallback;
    }

    /* renamed from: b */
    public static AsyncTaskC13559j m81510b(Context context, CloudStorageTaskCallback cloudStorageTaskCallback) {
        if (f60978e == null || AsyncTask.Status.FINISHED.equals(f60978e.getStatus())) {
            f60978e = new AsyncTaskC13559j(context, cloudStorageTaskCallback);
        } else {
            AsyncTaskC13559j asyncTaskC13559j = f60978e;
            if (cloudStorageTaskCallback != asyncTaskC13559j.f60980b) {
                asyncTaskC13559j.f60980b = cloudStorageTaskCallback;
            }
        }
        return f60978e;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) throws Throwable {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (C13368e.m80184F().m80233W()) {
            if (!C13368e.m80184F().m80241f0()) {
                try {
                    C11839m.m70688i("GetDiskSizeTask", "requestId=" + this.f60982d + ",doInBackground wait usedsize");
                    C13368e.m80184F().m80233W().wait(30000L);
                } catch (InterruptedException e10) {
                    C11839m.m70688i("GetDiskSizeTask", "requestId=" + this.f60982d + ",InterruptedException : " + e10.toString());
                }
            }
        }
        long usedSize = C13368e.m80184F().m80226P().getUsedSize();
        if (usedSize == -1) {
            C11839m.m70687e("GetDiskSizeTask", "requestId=" + this.f60982d + ",get usedSize failed");
            this.f60980b.mo15484a("disk", null, this.f60982d);
            return null;
        }
        synchronized (C13368e.m80184F().m80232V()) {
            if (!C13368e.m80184F().m80240d0()) {
                try {
                    C13368e.m80184F().m80232V().wait(30000L);
                    C11839m.m70688i("GetDiskSizeTask", "requestId=" + this.f60982d + ",doInBackground wait backupzsize");
                } catch (InterruptedException e11) {
                    C11839m.m70688i("GetDiskSizeTask", "InterruptedException : " + e11.toString());
                }
            }
        }
        long backupUsedSize = C13368e.m80184F().m80226P().getBackupUsedSize();
        if (backupUsedSize == -1) {
            C11839m.m70687e("GetDiskSizeTask", "requestId=" + this.f60982d + ",get backupSize failed");
            this.f60980b.mo15484a("disk", null, this.f60982d);
            return null;
        }
        this.f60980b.mo15484a("disk", this.f60981c.m80269e(this.f60979a, usedSize, backupUsedSize), this.f60982d);
        C11839m.m70688i("GetDiskSizeTask", "requestId=" + this.f60982d + ", diskSize time=" + (System.currentTimeMillis() - jCurrentTimeMillis));
        return null;
    }

    @Override // android.os.AsyncTask
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r12) {
    }

    /* renamed from: d */
    public void m81513d(int i10) {
        C11839m.m70688i("GetDiskSizeTask", "setRequestId=" + i10);
        this.f60982d = i10;
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
    }
}
