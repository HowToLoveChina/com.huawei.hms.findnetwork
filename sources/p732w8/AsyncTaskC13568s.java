package p732w8;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.huawei.android.hicloud.cloudspace.manager.CloudStorageTaskCallback;
import com.huawei.android.hicloud.cloudspace.manager.DriveConfigQuotaNumRequestor;
import com.huawei.android.hicloud.cloudspace.manager.StructureNumRequestor;
import com.huawei.android.hicloud.cloudspace.manager.SyncConfigStructureNumRequestor;
import com.huawei.hicloud.bean.DriveConfigService;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.notification.syncconfig.IStructureNumFinished;
import com.huawei.hicloud.notification.syncconfig.StructureNumRet;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import ke.C11046a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;

/* renamed from: w8.s */
/* loaded from: classes2.dex */
public class AsyncTaskC13568s extends AsyncTask<Void, Void, StructureNumRet> implements IStructureNumFinished {

    /* renamed from: h */
    public static AsyncTaskC13568s f61033h;

    /* renamed from: a */
    public Context f61034a;

    /* renamed from: b */
    public Messenger f61035b;

    /* renamed from: c */
    public CloudStorageTaskCallback f61036c;

    /* renamed from: d */
    public String f61037d;

    /* renamed from: e */
    public List<SyncConfigService> f61038e;

    /* renamed from: f */
    public List<DriveConfigService> f61039f;

    /* renamed from: g */
    public CountDownLatch f61040g;

    /* renamed from: w8.s$a */
    public static class a extends AbstractC12367d {

        /* renamed from: a */
        public IStructureNumFinished f61041a;

        /* renamed from: b */
        public Context f61042b;

        /* renamed from: c */
        public CountDownLatch f61043c;

        public a(Context context, IStructureNumFinished iStructureNumFinished, CountDownLatch countDownLatch) {
            this.f61041a = iStructureNumFinished;
            this.f61042b = context;
            this.f61043c = countDownLatch;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            this.f61041a.onDriveConfigTaskFinished(new DriveConfigQuotaNumRequestor(this.f61042b).m15487b());
            this.f61043c.countDown();
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.DRIVE_CONFIG;
        }
    }

    /* renamed from: w8.s$b */
    public static class b extends AbstractC12367d {

        /* renamed from: a */
        public IStructureNumFinished f61044a;

        /* renamed from: b */
        public Context f61045b;

        /* renamed from: c */
        public CountDownLatch f61046c;

        public b(Context context, IStructureNumFinished iStructureNumFinished, CountDownLatch countDownLatch) {
            this.f61044a = iStructureNumFinished;
            this.f61045b = context;
            this.f61046c = countDownLatch;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            this.f61044a.onNormalTaskFinished(new StructureNumRequestor(this.f61045b).m15517l());
            this.f61046c.countDown();
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.SYNC_CONFIG;
        }
    }

    /* renamed from: w8.s$c */
    public static class c extends AbstractC12367d {

        /* renamed from: a */
        public IStructureNumFinished f61047a;

        /* renamed from: b */
        public Context f61048b;

        /* renamed from: c */
        public CountDownLatch f61049c;

        public c(Context context, IStructureNumFinished iStructureNumFinished, CountDownLatch countDownLatch) {
            this.f61047a = iStructureNumFinished;
            this.f61048b = context;
            this.f61049c = countDownLatch;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            this.f61047a.onSyncConfigTaskFinished(new SyncConfigStructureNumRequestor(this.f61048b).m15520b());
            this.f61049c.countDown();
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.SYNC_CONFIG;
        }
    }

    public AsyncTaskC13568s(Context context, Messenger messenger, CloudStorageTaskCallback cloudStorageTaskCallback) {
        this.f61034a = context;
        this.f61035b = messenger;
    }

    /* renamed from: b */
    public static AsyncTaskC13568s m81549b(Context context, Messenger messenger, CloudStorageTaskCallback cloudStorageTaskCallback) {
        if (f61033h == null || AsyncTask.Status.FINISHED.equals(f61033h.getStatus())) {
            f61033h = new AsyncTaskC13568s(context, messenger, cloudStorageTaskCallback);
        } else {
            AsyncTaskC13568s asyncTaskC13568s = f61033h;
            if (messenger != asyncTaskC13568s.f61035b || cloudStorageTaskCallback != asyncTaskC13568s.f61036c) {
                if (cloudStorageTaskCallback != asyncTaskC13568s.f61036c) {
                    asyncTaskC13568s.f61036c = cloudStorageTaskCallback;
                }
                asyncTaskC13568s.f61035b = messenger;
            }
        }
        return f61033h;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public StructureNumRet doInBackground(Void... voidArr) throws InterruptedException {
        C11839m.m70686d("GetStructureNumTask", "doInBackground");
        CountDownLatch countDownLatch = new CountDownLatch(3);
        this.f61040g = countDownLatch;
        this.f61037d = "";
        this.f61038e = null;
        this.f61039f = null;
        b bVar = new b(this.f61034a, this, countDownLatch);
        c cVar = new c(this.f61034a, this, this.f61040g);
        a aVar = new a(this.f61034a, this, this.f61040g);
        C12515a.m75110o().m75172d(bVar);
        C12515a.m75110o().m75172d(cVar);
        C12515a.m75110o().m75172d(aVar);
        try {
            this.f61040g.await();
        } catch (InterruptedException e10) {
            C11839m.m70687e("GetStructureNumTask", "GetStructureNumTask doInBackground exception:" + e10.toString());
        }
        StructureNumRet structureNumRet = new StructureNumRet();
        structureNumRet.setNumStr(this.f61037d);
        structureNumRet.setSyncConfigServices(this.f61038e);
        structureNumRet.setDriveConfigServices(this.f61039f);
        return structureNumRet;
    }

    @Override // android.os.AsyncTask
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(StructureNumRet structureNumRet) throws RemoteException {
        C11839m.m70686d("GetStructureNumTask", "onPostExecute");
        Message message = new Message();
        message.what = 1045;
        message.arg1 = 0;
        message.obj = structureNumRet;
        Messenger messenger = this.f61035b;
        if (messenger != null) {
            C11046a.m66596d(messenger, message);
        }
    }

    @Override // com.huawei.hicloud.notification.syncconfig.IStructureNumFinished
    public void onDriveConfigTaskFinished(List<DriveConfigService> list) {
        synchronized (this) {
            this.f61039f = list;
        }
    }

    @Override // com.huawei.hicloud.notification.syncconfig.IStructureNumFinished
    public void onNormalTaskFinished(String str) {
        synchronized (this) {
            this.f61037d = str;
        }
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
    }

    @Override // com.huawei.hicloud.notification.syncconfig.IStructureNumFinished
    public void onSyncConfigTaskFinished(List<SyncConfigService> list) {
        synchronized (this) {
            this.f61038e = list;
        }
    }
}
