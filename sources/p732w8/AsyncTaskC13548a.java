package p732w8;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.huawei.hicloud.request.cbs.bean.CBSBaseResp;
import fk.C9721b;
import ke.C11046a;
import p458lo.C11322a;
import p514o9.C11839m;
import p664u0.C13108a;

/* renamed from: w8.a */
/* loaded from: classes2.dex */
public class AsyncTaskC13548a extends AsyncTask<Void, Void, Boolean> {

    /* renamed from: c */
    public static AsyncTaskC13548a f60941c;

    /* renamed from: a */
    public Context f60942a;

    /* renamed from: b */
    public Messenger f60943b;

    public AsyncTaskC13548a(Context context, Messenger messenger) {
        this.f60942a = context;
        this.f60943b = messenger;
    }

    /* renamed from: c */
    public static AsyncTaskC13548a m81474c(Context context, Messenger messenger) {
        if (f60941c == null || AsyncTask.Status.FINISHED.equals(f60941c.getStatus())) {
            f60941c = new AsyncTaskC13548a(context, messenger);
        } else {
            AsyncTaskC13548a asyncTaskC13548a = f60941c;
            if (messenger != asyncTaskC13548a.f60943b) {
                asyncTaskC13548a.f60943b = messenger;
            }
        }
        return f60941c;
    }

    /* renamed from: a */
    public final boolean m81475a() throws C9721b {
        CBSBaseResp cBSBaseRespM68029m = new C11322a().m68029m("callLog");
        if (cBSBaseRespM68029m != null && cBSBaseRespM68029m.getResult() == 0) {
            C11839m.m70688i("DeleteCalllogRecordsTask", "deleteCalllogRecord success");
            return true;
        }
        C13108a.m78878b(this.f60942a).m78881d(new Intent("com.huawei.hicloud.intent.action.ACTION_START_SPACE_USING_TRACK_REPROT"));
        C11839m.m70688i("DeleteCalllogRecordsTask", "deleteCalllogRecord failed");
        return false;
    }

    @Override // android.os.AsyncTask
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(Void... voidArr) {
        try {
            return Boolean.valueOf(m81475a());
        } catch (C9721b e10) {
            C11839m.m70687e("DeleteCalllogRecordsTask", "doInBackground error:" + e10.toString());
            return Boolean.FALSE;
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) throws RemoteException {
        Message message = new Message();
        message.what = 1043;
        if (!bool.booleanValue()) {
            message.what = 1044;
        }
        C11046a.m66596d(this.f60943b, message);
    }
}
