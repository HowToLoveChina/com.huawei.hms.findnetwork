package p732w8;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.android.hicloud.cbs.bean.CBSSmsCalllogValues;
import com.huawei.android.hicloud.cloudspace.manager.CloudStorageTaskCallback;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.request.cbs.bean.CBSSmsCalllogCountResp;
import fk.C9721b;
import gp.C10028c;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import ke.C11046a;
import p015ak.C0241z;
import p458lo.C11322a;
import p514o9.C11839m;

/* renamed from: w8.q */
/* loaded from: classes2.dex */
public class AsyncTaskC13566q extends AsyncTask<Void, Void, Map<String, Integer>> {

    /* renamed from: e */
    public static AsyncTaskC13566q f61023e;

    /* renamed from: a */
    public Context f61024a;

    /* renamed from: b */
    public Messenger f61025b;

    /* renamed from: c */
    public CloudStorageTaskCallback f61026c;

    /* renamed from: d */
    public CountDownLatch f61027d;

    public AsyncTaskC13566q(Context context, Messenger messenger, CloudStorageTaskCallback cloudStorageTaskCallback, CountDownLatch countDownLatch) {
        this.f61024a = context;
        this.f61025b = messenger;
        this.f61026c = cloudStorageTaskCallback;
        this.f61027d = countDownLatch;
    }

    /* renamed from: b */
    public static AsyncTaskC13566q m81541b(Context context, Messenger messenger, CloudStorageTaskCallback cloudStorageTaskCallback, CountDownLatch countDownLatch) {
        if (f61023e == null || AsyncTask.Status.FINISHED.equals(f61023e.getStatus())) {
            f61023e = new AsyncTaskC13566q(context, messenger, cloudStorageTaskCallback, countDownLatch);
        } else {
            AsyncTaskC13566q asyncTaskC13566q = f61023e;
            if (messenger != asyncTaskC13566q.f61025b || cloudStorageTaskCallback != asyncTaskC13566q.f61026c) {
                if (cloudStorageTaskCallback != asyncTaskC13566q.f61026c) {
                    asyncTaskC13566q.f61026c = cloudStorageTaskCallback;
                }
                asyncTaskC13566q.f61025b = messenger;
            }
        }
        return f61023e;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Map<String, Integer> doInBackground(Void... voidArr) {
        try {
            if (!C10028c.m62182c0().m62315d1() && !C10028c.m62182c0().m62390s1()) {
                C11839m.m70688i("GetSmsAndCalllogNumTask", "calllog and message disabled");
                return null;
            }
            CBSSmsCalllogCountResp cBSSmsCalllogCountRespM68012S = new C11322a().m68012S();
            if (cBSSmsCalllogCountRespM68012S == null) {
                C11839m.m70687e("GetSmsAndCalllogNumTask", "smsAndCalllogCountReq failed");
                return null;
            }
            CBSSmsCalllogValues values = cBSSmsCalllogCountRespM68012S.getValues();
            HashMap map = new HashMap();
            if (values == null) {
                return null;
            }
            if (!TextUtils.isEmpty(values.getSms())) {
                map.put(NavigationUtils.SMS_SCHEMA_PREF, Integer.valueOf(C0241z.m1685c(values.getSms())));
            }
            if (!TextUtils.isEmpty(values.getCalllog())) {
                map.put("callLog", Integer.valueOf(C0241z.m1685c(values.getCalllog())));
            }
            return map;
        } catch (C9721b unused) {
            return null;
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Map<String, Integer> map) throws RemoteException {
        C11839m.m70688i("GetSmsAndCalllogNumTask", "onPostExecute");
        Message message = new Message();
        message.what = 1048;
        if (map == null) {
            message.arg1 = -5;
            C11839m.m70687e("GetSmsAndCalllogNumTask", "MSG_QUERY_SMS_COUNT_FINISH");
        } else {
            message.arg1 = 0;
            message.obj = map;
        }
        Messenger messenger = this.f61025b;
        if (messenger != null) {
            C11046a.m66596d(messenger, message);
        }
        CloudStorageTaskCallback cloudStorageTaskCallback = this.f61026c;
        if (cloudStorageTaskCallback != null) {
            cloudStorageTaskCallback.mo15484a("sms_calllog_num", map, 0);
            CountDownLatch countDownLatch = this.f61027d;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            } else {
                C11839m.m70687e("GetSmsAndCalllogNumTask", "mLatch is null");
            }
        }
    }
}
