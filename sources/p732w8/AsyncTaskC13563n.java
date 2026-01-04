package p732w8;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.cloudspace.manager.CloudStorageTaskCallback;
import com.huawei.android.hicloud.commonlib.space.QuotaDetail;
import com.huawei.android.hicloud.commonlib.space.QuotaUsedInfoRsp;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import fk.C9721b;
import je.C10812z;
import ke.C11046a;
import p015ak.C0209d;
import p514o9.C11839m;
import p652t9.EnumC12999a;
import p783xp.C13843a;
import to.C13049a;

/* renamed from: w8.n */
/* loaded from: classes2.dex */
public class AsyncTaskC13563n extends AsyncTask<Void, Void, Integer> {

    /* renamed from: e */
    public static AsyncTaskC13563n f60996e;

    /* renamed from: a */
    public Context f60997a;

    /* renamed from: b */
    public Messenger f60998b;

    /* renamed from: c */
    public CloudStorageTaskCallback f60999c;

    /* renamed from: d */
    public String f61000d;

    public AsyncTaskC13563n(Context context, Messenger messenger, CloudStorageTaskCallback cloudStorageTaskCallback, String str) {
        this.f60997a = context;
        this.f60998b = messenger;
        this.f60999c = cloudStorageTaskCallback;
        this.f61000d = str;
    }

    /* renamed from: c */
    public static AsyncTaskC13563n m81517c(Context context, Messenger messenger, CloudStorageTaskCallback cloudStorageTaskCallback, String str) {
        if (f60996e == null || AsyncTask.Status.FINISHED.equals(f60996e.getStatus())) {
            f60996e = new AsyncTaskC13563n(context, messenger, cloudStorageTaskCallback, str);
        } else {
            AsyncTaskC13563n asyncTaskC13563n = f60996e;
            if (messenger != asyncTaskC13563n.f60998b || cloudStorageTaskCallback != asyncTaskC13563n.f60999c) {
                if (cloudStorageTaskCallback != asyncTaskC13563n.f60999c) {
                    asyncTaskC13563n.f60999c = cloudStorageTaskCallback;
                }
                asyncTaskC13563n.f60998b = messenger;
            }
        }
        return f60996e;
    }

    /* renamed from: a */
    public int m81518a() {
        return doInBackground(new Void[0]).intValue();
    }

    @Override // android.os.AsyncTask
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer doInBackground(Void... voidArr) {
        C11839m.m70688i("GetNotepadNumTask", "doInBackground");
        return Integer.valueOf(m81520d());
    }

    /* renamed from: d */
    public final int m81520d() {
        String str;
        Context context = this.f60997a;
        String strM1240c0 = C0209d.m1240c0(context, C13843a.m83050B(context));
        C11839m.m70688i("GetNotepadNumTask", "getQuotaNotepadNum :" + strM1240c0);
        C13049a c13049a = new C13049a(EnumC12999a.CLOUD_SYNC, C10812z.m65832a("03007"));
        StringBuffer stringBuffer = new StringBuffer("collection=private and kind in [");
        try {
            if (TextUtils.isEmpty(strM1240c0)) {
                stringBuffer.append("note");
                stringBuffer.append("] and (trashed=true or trashed=false)");
                str = new String(stringBuffer);
            } else {
                stringBuffer.append(strM1240c0);
                stringBuffer.append("] and (trashed=true or trashed=false)");
                str = new String(stringBuffer);
            }
            String strM78761z = c13049a.m78761z(DriveSyncUtil.m17958C("notepad"), str);
            C11839m.m70686d("GetNotepadNumTask", "getQuotaNotepadNum notepad response =" + strM78761z);
            if (!TextUtils.isEmpty(strM78761z)) {
                return m81522f((QuotaUsedInfoRsp) new Gson().fromJson(strM78761z, QuotaUsedInfoRsp.class));
            }
            C11839m.m70688i("GetNotepadNumTask", "quotausedinfo reponse is null");
            return -1;
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("GetNotepadNumTask", "getQuotaNotepadNum JsonSyntaxEx:" + e10.toString());
            return -1;
        } catch (C9721b e11) {
            C11839m.m70687e("GetNotepadNumTask", "getQuotaNotepadNum exception:" + e11.toString());
            return -1;
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Integer num) throws RemoteException {
        C11839m.m70688i("GetNotepadNumTask", "onPostExecute");
        Message message = new Message();
        message.what = 1033;
        if (num.intValue() == -1) {
            C11839m.m70687e("GetNotepadNumTask", "NUM_TASK_EXECUTE_FAIL");
            message.arg1 = -5;
        } else {
            message.arg1 = 0;
            message.obj = num;
        }
        Messenger messenger = this.f60998b;
        if (messenger != null) {
            C11046a.m66596d(messenger, message);
        }
        CloudStorageTaskCallback cloudStorageTaskCallback = this.f60999c;
        if (cloudStorageTaskCallback != null) {
            cloudStorageTaskCallback.mo15484a("notepad_num", num, 0);
        }
    }

    /* renamed from: f */
    public final int m81522f(QuotaUsedInfoRsp quotaUsedInfoRsp) {
        QuotaDetail[] quotaDetails = quotaUsedInfoRsp.getQuotaDetails();
        if (quotaUsedInfoRsp.getRetCode() != 0) {
            C11839m.m70688i("GetNotepadNumTask", "quotausedinfo request failed");
            return -1;
        }
        C11839m.m70688i("GetNotepadNumTask", "getQuotaUsedInfo request success");
        if (quotaDetails.length <= 0) {
            C11839m.m70688i("GetNotepadNumTask", "quotausedinfo request length is 0");
            return -1;
        }
        int recordsCount = 0;
        int recordsCount2 = 0;
        for (QuotaDetail quotaDetail : quotaDetails) {
            if (quotaDetail != null) {
                if (quotaDetail.isTrashed()) {
                    recordsCount += quotaDetail.getRecordsCount();
                } else {
                    recordsCount2 += quotaDetail.getRecordsCount();
                }
            }
        }
        C11839m.m70686d("GetNotepadNumTask", " recyclerecordsCount :" + recordsCount);
        C11839m.m70686d("GetNotepadNumTask", " recordsCount :" + recordsCount2);
        return recordsCount2;
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
    }
}
