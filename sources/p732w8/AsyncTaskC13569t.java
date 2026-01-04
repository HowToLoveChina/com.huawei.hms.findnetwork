package p732w8;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.huawei.android.hicloud.cloudspace.manager.CloudStorageTaskCallback;
import com.huawei.hicloud.base.bean.ModuleItem;
import com.huawei.hicloud.request.cbs.bean.CBSDevice;
import fk.C9721b;
import gp.C10028c;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import je.C10777a0;
import ke.C11046a;
import p015ak.C0209d;
import p458lo.C11322a;
import p514o9.C11839m;

/* renamed from: w8.t */
/* loaded from: classes2.dex */
public class AsyncTaskC13569t extends AsyncTask<Void, Void, List<ModuleItem>> {

    /* renamed from: e */
    public static AsyncTaskC13569t f61050e;

    /* renamed from: f */
    public static final String[] f61051f = new String[0];

    /* renamed from: a */
    public Context f61052a;

    /* renamed from: b */
    public Messenger f61053b;

    /* renamed from: c */
    public CloudStorageTaskCallback f61054c;

    /* renamed from: d */
    public CountDownLatch f61055d;

    public AsyncTaskC13569t(Context context, Messenger messenger, CloudStorageTaskCallback cloudStorageTaskCallback, CountDownLatch countDownLatch) {
        this.f61052a = context;
        this.f61053b = messenger;
        this.f61054c = cloudStorageTaskCallback;
        this.f61055d = countDownLatch;
    }

    /* renamed from: b */
    public static AsyncTaskC13569t m81552b(Context context, Messenger messenger, CloudStorageTaskCallback cloudStorageTaskCallback, CountDownLatch countDownLatch) {
        if (f61050e == null || AsyncTask.Status.FINISHED.equals(f61050e.getStatus())) {
            f61050e = new AsyncTaskC13569t(context, messenger, cloudStorageTaskCallback, countDownLatch);
        } else {
            AsyncTaskC13569t asyncTaskC13569t = f61050e;
            if (messenger != asyncTaskC13569t.f61053b || cloudStorageTaskCallback != asyncTaskC13569t.f61054c) {
                if (cloudStorageTaskCallback != asyncTaskC13569t.f61054c) {
                    asyncTaskC13569t.f61054c = cloudStorageTaskCallback;
                }
                asyncTaskC13569t.f61053b = messenger;
            }
        }
        return f61050e;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<ModuleItem> doInBackground(Void... voidArr) {
        C11839m.m70688i("GetStructureRecordingNumTask", "GetStructureRecordingNumTask doInBackground");
        try {
            if (C10028c.m62182c0().m62201D1()) {
                return m81554c(new C11322a().m68004K(), "recording");
            }
            C11839m.m70688i("GetStructureRecordingNumTask", "recording disabled");
            return null;
        } catch (C9721b unused) {
            C11839m.m70686d("GetStructureRecordingNumTask", "cbs queryDevice exception");
            return null;
        }
    }

    /* renamed from: c */
    public final List<ModuleItem> m81554c(List<CBSDevice> list, String str) throws C9721b {
        return C10028c.m62182c0().m62420y1() ? C10777a0.m65616c(list, null, "GetStructureRecordingNumTask", this.f61052a) : C10777a0.m65617d(list, null, "GetStructureRecordingNumTask", this.f61052a);
    }

    @Override // android.os.AsyncTask
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(List<ModuleItem> list) throws RemoteException {
        int num;
        C11839m.m70688i("GetStructureRecordingNumTask", "GetStructureRecordingNumTask onPostExecute");
        Message message = new Message();
        message.what = 1032;
        if (list == null || (list.isEmpty() && !C0209d.m1208S0(this.f61052a))) {
            C11839m.m70687e("GetStructureRecordingNumTask", "resModule null");
            message.arg1 = -5;
            num = -1;
        } else {
            C11839m.m70686d("GetStructureRecordingNumTask", "query success");
            message.arg1 = 0;
            Iterator<ModuleItem> it = list.iterator();
            num = 0;
            while (it.hasNext()) {
                num += it.next().getNum();
            }
            message.obj = Integer.valueOf(num);
        }
        Messenger messenger = this.f61053b;
        if (messenger != null) {
            C11046a.m66596d(messenger, message);
        }
        CloudStorageTaskCallback cloudStorageTaskCallback = this.f61054c;
        if (cloudStorageTaskCallback != null) {
            cloudStorageTaskCallback.mo15484a("record_num", Integer.valueOf(num), 0);
            CountDownLatch countDownLatch = this.f61055d;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            } else {
                C11839m.m70687e("GetStructureRecordingNumTask", "mLatch is null");
            }
        }
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
    }
}
