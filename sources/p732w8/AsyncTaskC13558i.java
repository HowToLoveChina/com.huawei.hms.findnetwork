package p732w8;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.huawei.android.hicloud.cloudspace.bean.SmsStorageQueryResult;
import com.huawei.android.hicloud.cloudspace.manager.CloudStorageTaskCallback;
import com.huawei.android.sync.R$string;
import com.huawei.hicloud.base.bean.ModuleItem;
import com.huawei.hicloud.request.cbs.bean.CBSDevCount;
import com.huawei.hicloud.request.cbs.bean.CBSDevice;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import ke.C11046a;
import p458lo.C11322a;
import p514o9.C11839m;
import p709vj.C13452e;

/* renamed from: w8.i */
/* loaded from: classes2.dex */
public class AsyncTaskC13558i extends AsyncTask<Void, Void, List<ModuleItem>> {

    /* renamed from: e */
    public static AsyncTaskC13558i f60973e;

    /* renamed from: a */
    public String f60974a;

    /* renamed from: b */
    public Context f60975b;

    /* renamed from: c */
    public Messenger f60976c;

    /* renamed from: d */
    public CloudStorageTaskCallback f60977d;

    public AsyncTaskC13558i(Context context, Messenger messenger, CloudStorageTaskCallback cloudStorageTaskCallback) {
        this.f60975b = context;
        this.f60976c = messenger;
        this.f60977d = cloudStorageTaskCallback;
    }

    /* renamed from: c */
    public static AsyncTaskC13558i m81505c(Context context, Messenger messenger, CloudStorageTaskCallback cloudStorageTaskCallback) {
        if (f60973e == null || AsyncTask.Status.FINISHED.equals(f60973e.getStatus())) {
            f60973e = new AsyncTaskC13558i(context, messenger, cloudStorageTaskCallback);
        } else {
            AsyncTaskC13558i asyncTaskC13558i = f60973e;
            if (messenger != asyncTaskC13558i.f60976c || cloudStorageTaskCallback != asyncTaskC13558i.f60977d) {
                if (cloudStorageTaskCallback != asyncTaskC13558i.f60977d) {
                    asyncTaskC13558i.f60977d = cloudStorageTaskCallback;
                }
                asyncTaskC13558i.f60976c = messenger;
            }
        }
        return f60973e;
    }

    /* renamed from: a */
    public int m81506a() {
        int num = 0;
        List<ModuleItem> listDoInBackground = doInBackground(new Void[0]);
        if (listDoInBackground == null) {
            return -1;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (ModuleItem moduleItem : listDoInBackground) {
            arrayList.add(moduleItem.getDeviceID());
            num += moduleItem.getNum();
        }
        SmsStorageQueryResult smsStorageQueryResult = new SmsStorageQueryResult();
        smsStorageQueryResult.setCount(num);
        smsStorageQueryResult.setDeviceIdList(arrayList);
        return smsStorageQueryResult.getCount();
    }

    @Override // android.os.AsyncTask
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public List<ModuleItem> doInBackground(Void... voidArr) {
        C11839m.m70688i("GetCallLogNumTask", "doInBackground");
        try {
            return m81508d("callLog");
        } catch (Exception e10) {
            C11839m.m70687e("GetCallLogNumTask", "doInBackground: " + e10.toString());
            return null;
        }
    }

    /* renamed from: d */
    public final List<ModuleItem> m81508d(String str) throws C9721b {
        List<CBSDevCount> listM68026j = new C11322a().m68026j(str);
        if (listM68026j.isEmpty()) {
            return null;
        }
        C11839m.m70686d("GetCallLogNumTask", "devCounts: " + listM68026j.size());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (CBSDevCount cBSDevCount : listM68026j) {
            int count = cBSDevCount.getCount();
            CBSDevice device = cBSDevCount.getDevice();
            if (count > 0) {
                ModuleItem moduleItem = new ModuleItem();
                moduleItem.setDeviceID(device.getDeviceId());
                String aliasName = device.getAliasName();
                if (aliasName == null || aliasName.trim().isEmpty()) {
                    aliasName = device.getTerminalType();
                }
                moduleItem.setNum(count);
                moduleItem.setName(aliasName);
                moduleItem.setDisplayName(aliasName);
                String str2 = this.f60974a;
                if (str2 != null && str2.equals(device.getDeviceId())) {
                    moduleItem.setCurrent(true);
                    moduleItem.setDisplayName(this.f60975b.getResources().getString(R$string.cloudbackup_self_device_new_update, aliasName));
                    arrayList.add(moduleItem);
                } else if (moduleItem.getDisplayName() == null || moduleItem.getDisplayName().isEmpty()) {
                    moduleItem.setDisplayName(this.f60975b.getResources().getString(R$string.setting_other));
                    arrayList3.add(moduleItem);
                } else {
                    arrayList2.add(moduleItem);
                }
            }
        }
        arrayList.addAll(arrayList2);
        arrayList.addAll(arrayList3);
        return arrayList;
    }

    @Override // android.os.AsyncTask
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(List<ModuleItem> list) throws RemoteException {
        int i10;
        C11839m.m70688i("GetCallLogNumTask", "onPostExecute");
        ArrayList<String> arrayList = new ArrayList<>();
        Message message = new Message();
        message.what = 1039;
        if (list == null) {
            message.arg1 = -5;
            C11839m.m70686d("GetCallLogNumTask", "MSG_QUERY_CALLLOG_COUNT_FINISH");
            i10 = -1;
        } else {
            message.arg1 = 0;
            int num = 0;
            for (ModuleItem moduleItem : list) {
                arrayList.add(moduleItem.getDeviceID());
                num += moduleItem.getNum();
            }
            SmsStorageQueryResult smsStorageQueryResult = new SmsStorageQueryResult();
            smsStorageQueryResult.setCount(num);
            smsStorageQueryResult.setDeviceIdList(arrayList);
            message.obj = smsStorageQueryResult;
            i10 = num;
        }
        Messenger messenger = this.f60976c;
        if (messenger != null) {
            C11046a.m66596d(messenger, message);
        }
        CloudStorageTaskCallback cloudStorageTaskCallback = this.f60977d;
        if (cloudStorageTaskCallback != null) {
            cloudStorageTaskCallback.mo15484a("calllog_num", Integer.valueOf(i10), 0);
        }
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        this.f60974a = C13452e.m80781L().m80950o();
    }
}
