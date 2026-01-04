package p732w8;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.huawei.android.hicloud.cloudspace.util.IFamilyShareInfoAndDetailFinish;
import com.huawei.hicloud.base.bean.FamilyDetailInfoResult;
import com.huawei.hicloud.base.bean.FamilyShareInfoAndDetailResult;
import com.huawei.hicloud.base.bean.FamilyShareInfoResult;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p514o9.C11839m;
import p616rk.C12515a;
import p732w8.AsyncTaskC13562m;

/* renamed from: w8.e */
/* loaded from: classes2.dex */
public class AsyncTaskC13554e extends AsyncTask<Void, Void, FamilyShareInfoAndDetailResult> implements IFamilyShareInfoAndDetailFinish {

    /* renamed from: e */
    public static AsyncTaskC13554e f60958e;

    /* renamed from: a */
    public Handler f60959a;

    /* renamed from: b */
    public CountDownLatch f60960b;

    /* renamed from: c */
    public FamilyDetailInfoResult f60961c;

    /* renamed from: d */
    public FamilyShareInfoResult f60962d;

    public AsyncTaskC13554e(Handler handler) {
        this.f60959a = handler;
    }

    /* renamed from: d */
    public static AsyncTaskC13554e m81494d(Handler handler) {
        if (f60958e == null || AsyncTask.Status.FINISHED.equals(f60958e.getStatus())) {
            f60958e = new AsyncTaskC13554e(handler);
        } else {
            AsyncTaskC13554e asyncTaskC13554e = f60958e;
            if (handler != asyncTaskC13554e.f60959a) {
                asyncTaskC13554e.f60959a = handler;
            }
        }
        return f60958e;
    }

    @Override // com.huawei.android.hicloud.cloudspace.util.IFamilyShareInfoAndDetailFinish
    /* renamed from: a */
    public void mo15522a(FamilyDetailInfoResult familyDetailInfoResult) {
        synchronized (this) {
            this.f60961c = familyDetailInfoResult;
        }
    }

    @Override // com.huawei.android.hicloud.cloudspace.util.IFamilyShareInfoAndDetailFinish
    /* renamed from: b */
    public void mo15523b(FamilyShareInfoResult familyShareInfoResult) {
        synchronized (this) {
            this.f60962d = familyShareInfoResult;
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public FamilyShareInfoAndDetailResult doInBackground(Void... voidArr) {
        C11839m.m70688i("ExclusiveGetFamilyShareInfoTask", "doInBackground start");
        CountDownLatch countDownLatch = new CountDownLatch(2);
        this.f60960b = countDownLatch;
        this.f60962d = null;
        this.f60961c = null;
        AsyncTaskC13562m.b bVar = new AsyncTaskC13562m.b(this, countDownLatch);
        AsyncTaskC13562m.a aVar = new AsyncTaskC13562m.a(this, this.f60960b);
        C12515a.m75110o().m75172d(bVar);
        C12515a.m75110o().m75172d(aVar);
        try {
            if (this.f60960b.await(20000L, TimeUnit.MILLISECONDS)) {
                C11839m.m70688i("ExclusiveGetFamilyShareInfoTask", "ExclusiveGetFamilyShareInfoTask getfamilyshareinfo and detail request all task success");
            } else {
                C11839m.m70688i("ExclusiveGetFamilyShareInfoTask", "ExclusiveGetFamilyShareInfoTask getfamilyshareinfo and detail request timeout");
            }
        } catch (InterruptedException e10) {
            C11839m.m70687e("ExclusiveGetFamilyShareInfoTask", "ExclusiveGetFamilyShareInfoTask doInBackground exception:" + e10.toString());
        }
        FamilyShareInfoAndDetailResult familyShareInfoAndDetailResult = new FamilyShareInfoAndDetailResult();
        familyShareInfoAndDetailResult.setFamilyShareInfoResult(this.f60962d);
        familyShareInfoAndDetailResult.setFamilyDetailInfoResult(this.f60961c);
        C11839m.m70688i("ExclusiveGetFamilyShareInfoTask", "doInBackground end");
        return familyShareInfoAndDetailResult;
    }

    @Override // android.os.AsyncTask
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(FamilyShareInfoAndDetailResult familyShareInfoAndDetailResult) {
        C11839m.m70688i("ExclusiveGetFamilyShareInfoTask", "ExclusiveGetFamilyShareInfoTask onPostExecute");
        Message messageObtain = Message.obtain(this.f60959a);
        messageObtain.what = 2013;
        messageObtain.obj = familyShareInfoAndDetailResult;
        this.f60959a.sendMessage(messageObtain);
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
    }
}
