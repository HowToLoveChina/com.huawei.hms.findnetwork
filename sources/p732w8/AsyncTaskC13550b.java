package p732w8;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.request.cbs.bean.CBSBaseResp;
import fk.C9721b;
import ke.C11046a;
import p458lo.C11322a;
import p514o9.C11839m;
import p664u0.C13108a;

/* renamed from: w8.b */
/* loaded from: classes2.dex */
public class AsyncTaskC13550b extends AsyncTask<Void, Void, Boolean> {

    /* renamed from: c */
    public static AsyncTaskC13550b f60951c;

    /* renamed from: a */
    public Context f60952a;

    /* renamed from: b */
    public Messenger f60953b;

    public AsyncTaskC13550b(Context context, Messenger messenger) {
        this.f60952a = context;
        this.f60953b = messenger;
    }

    /* renamed from: c */
    public static AsyncTaskC13550b m81489c(Context context, Messenger messenger) {
        if (f60951c == null || AsyncTask.Status.FINISHED.equals(f60951c.getStatus())) {
            f60951c = new AsyncTaskC13550b(context, messenger);
        } else {
            AsyncTaskC13550b asyncTaskC13550b = f60951c;
            if (messenger != asyncTaskC13550b.f60953b) {
                asyncTaskC13550b.f60953b = messenger;
            }
        }
        return f60951c;
    }

    /* renamed from: a */
    public final boolean m81490a() throws C9721b {
        CBSBaseResp cBSBaseRespM68029m = new C11322a().m68029m(NavigationUtils.SMS_SCHEMA_PREF);
        if (cBSBaseRespM68029m != null && cBSBaseRespM68029m.getResult() == 0) {
            C11839m.m70688i("DeleteSmsRecordsTask", "deleteSMSRecord success");
            return true;
        }
        C13108a.m78878b(this.f60952a).m78881d(new Intent("com.huawei.hicloud.intent.action.ACTION_START_SPACE_USING_TRACK_REPROT"));
        C11839m.m70688i("DeleteSmsRecordsTask", "deleteSMSRecord failed");
        return false;
    }

    @Override // android.os.AsyncTask
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(Void... voidArr) {
        try {
            return Boolean.valueOf(m81490a());
        } catch (C9721b e10) {
            C11839m.m70687e("DeleteSmsRecordsTask", "doInBackground error:" + e10.toString());
            return Boolean.FALSE;
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) throws RemoteException {
        Message message = new Message();
        message.what = 1040;
        if (!bool.booleanValue()) {
            message.what = 1042;
        }
        C11046a.m66596d(this.f60953b, message);
    }
}
