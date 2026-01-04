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

/* renamed from: w8.p */
/* loaded from: classes2.dex */
public class AsyncTaskC13565p extends AsyncTask<Void, Void, List<ModuleItem>> {

    /* renamed from: e */
    public static AsyncTaskC13565p f61017e;

    /* renamed from: f */
    public static final String[] f61018f = new String[0];

    /* renamed from: a */
    public Context f61019a;

    /* renamed from: b */
    public Messenger f61020b;

    /* renamed from: c */
    public CloudStorageTaskCallback f61021c;

    /* renamed from: d */
    public CountDownLatch f61022d;

    public AsyncTaskC13565p(Context context, Messenger messenger, CloudStorageTaskCallback cloudStorageTaskCallback, CountDownLatch countDownLatch) {
        this.f61019a = context;
        this.f61020b = messenger;
        this.f61021c = cloudStorageTaskCallback;
        this.f61022d = countDownLatch;
    }

    /* renamed from: c */
    public static AsyncTaskC13565p m81536c(Context context, Messenger messenger, CloudStorageTaskCallback cloudStorageTaskCallback, CountDownLatch countDownLatch) {
        if (f61017e == null || AsyncTask.Status.FINISHED.equals(f61017e.getStatus())) {
            f61017e = new AsyncTaskC13565p(context, messenger, cloudStorageTaskCallback, countDownLatch);
        } else {
            AsyncTaskC13565p asyncTaskC13565p = f61017e;
            if (messenger != asyncTaskC13565p.f61020b || cloudStorageTaskCallback != asyncTaskC13565p.f61021c) {
                if (cloudStorageTaskCallback != asyncTaskC13565p.f61021c) {
                    asyncTaskC13565p.f61021c = cloudStorageTaskCallback;
                }
                asyncTaskC13565p.f61020b = messenger;
            }
        }
        return f61017e;
    }

    /* renamed from: a */
    public int m81537a() {
        int num = 0;
        List<ModuleItem> listDoInBackground = doInBackground(new Void[0]);
        if (listDoInBackground == null) {
            return 0;
        }
        Iterator<ModuleItem> it = listDoInBackground.iterator();
        while (it.hasNext()) {
            num += it.next().getNum();
        }
        return num;
    }

    @Override // android.os.AsyncTask
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public List<ModuleItem> doInBackground(Void... voidArr) {
        C11839m.m70688i("GetRecordingNumTask", "GetRecordingNumTask doInBackground");
        try {
            if (C10028c.m62182c0().m62201D1()) {
                return m81539d(new C11322a().m68004K(), "recording");
            }
            C11839m.m70688i("GetRecordingNumTask", "recording disabled");
            return null;
        } catch (C9721b unused) {
            C11839m.m70686d("GetRecordingNumTask", "cbs queryDevice exception");
            return null;
        }
    }

    /* renamed from: d */
    public final List<ModuleItem> m81539d(List<CBSDevice> list, String str) throws C9721b {
        return C10028c.m62182c0().m62420y1() ? C10777a0.m65616c(list, null, "GetRecordingNumTask", this.f61019a) : C10777a0.m65617d(list, null, "GetRecordingNumTask", this.f61019a);
    }

    @Override // android.os.AsyncTask
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(List<ModuleItem> list) throws RemoteException {
        int num;
        C11839m.m70688i("GetRecordingNumTask", "GetRecordingNumTask onPostExecute");
        Message message = new Message();
        message.what = 1032;
        if (list == null || (list.isEmpty() && !C0209d.m1208S0(this.f61019a))) {
            C11839m.m70687e("GetRecordingNumTask", "resModule null");
            message.arg1 = -5;
            num = -1;
        } else {
            C11839m.m70686d("GetRecordingNumTask", "query success");
            message.arg1 = 0;
            Iterator<ModuleItem> it = list.iterator();
            num = 0;
            while (it.hasNext()) {
                num += it.next().getNum();
            }
            message.obj = Integer.valueOf(num);
        }
        Messenger messenger = this.f61020b;
        if (messenger != null) {
            C11046a.m66596d(messenger, message);
        }
        CloudStorageTaskCallback cloudStorageTaskCallback = this.f61021c;
        if (cloudStorageTaskCallback != null) {
            cloudStorageTaskCallback.mo15484a("record_num", Integer.valueOf(num), 0);
            CountDownLatch countDownLatch = this.f61022d;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
    }
}
