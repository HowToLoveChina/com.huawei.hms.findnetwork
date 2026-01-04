package p732w8;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.huawei.android.hicloud.cloudspace.bean.SmsStorageQueryResult;
import com.huawei.android.hicloud.cloudspace.manager.CloudStorageTaskCallback;
import com.huawei.android.sync.R$string;
import com.huawei.fastengine.fastview.NavigationUtils;
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

/* renamed from: w8.r */
/* loaded from: classes2.dex */
public class AsyncTaskC13567r extends AsyncTask<Void, Void, List<ModuleItem>> {

    /* renamed from: e */
    public static AsyncTaskC13567r f61028e;

    /* renamed from: a */
    public String f61029a;

    /* renamed from: b */
    public Context f61030b;

    /* renamed from: c */
    public Messenger f61031c;

    /* renamed from: d */
    public CloudStorageTaskCallback f61032d;

    public AsyncTaskC13567r(Context context, Messenger messenger, CloudStorageTaskCallback cloudStorageTaskCallback) {
        this.f61030b = context;
        this.f61031c = messenger;
        this.f61032d = cloudStorageTaskCallback;
    }

    /* renamed from: c */
    public static AsyncTaskC13567r m81544c(Context context, Messenger messenger, CloudStorageTaskCallback cloudStorageTaskCallback) {
        if (f61028e == null || AsyncTask.Status.FINISHED.equals(f61028e.getStatus())) {
            f61028e = new AsyncTaskC13567r(context, messenger, cloudStorageTaskCallback);
        } else {
            AsyncTaskC13567r asyncTaskC13567r = f61028e;
            if (messenger != asyncTaskC13567r.f61031c || cloudStorageTaskCallback != asyncTaskC13567r.f61032d) {
                if (cloudStorageTaskCallback != asyncTaskC13567r.f61032d) {
                    asyncTaskC13567r.f61032d = cloudStorageTaskCallback;
                }
                asyncTaskC13567r.f61031c = messenger;
            }
        }
        return f61028e;
    }

    /* renamed from: a */
    public int m81545a() {
        C11839m.m70688i("GetSmsNumTask", "asyncDoInBackground");
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
        try {
            return m81547d(NavigationUtils.SMS_SCHEMA_PREF);
        } catch (C9721b unused) {
            return null;
        }
    }

    /* renamed from: d */
    public final List<ModuleItem> m81547d(String str) throws C9721b {
        List<CBSDevCount> listM68026j = new C11322a().m68026j(str);
        if (listM68026j.isEmpty()) {
            return null;
        }
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
                String str2 = this.f61029a;
                if (str2 != null && str2.equals(device.getDeviceId())) {
                    moduleItem.setCurrent(true);
                    moduleItem.setDisplayName(this.f61030b.getResources().getString(R$string.cloudbackup_self_device_new_update, aliasName));
                    arrayList2.add(moduleItem);
                } else if (moduleItem.getDisplayName() == null || moduleItem.getDisplayName().isEmpty()) {
                    moduleItem.setDisplayName(this.f61030b.getResources().getString(R$string.setting_other));
                    arrayList3.add(moduleItem);
                } else {
                    arrayList.add(moduleItem);
                }
            }
        }
        arrayList2.addAll(arrayList);
        arrayList2.addAll(arrayList3);
        return arrayList2;
    }

    @Override // android.os.AsyncTask
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(List<ModuleItem> list) throws RemoteException {
        int i10;
        C11839m.m70688i("GetSmsNumTask", "onPostExecute");
        ArrayList<String> arrayList = new ArrayList<>();
        Message message = new Message();
        message.what = 1038;
        if (list == null) {
            message.arg1 = -5;
            C11839m.m70687e("GetSmsNumTask", "MSG_QUERY_SMS_COUNT_FINISH");
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
        Messenger messenger = this.f61031c;
        if (messenger != null) {
            C11046a.m66596d(messenger, message);
        }
        CloudStorageTaskCallback cloudStorageTaskCallback = this.f61032d;
        if (cloudStorageTaskCallback != null) {
            cloudStorageTaskCallback.mo15484a("sms_num", Integer.valueOf(i10), 0);
        }
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        this.f61029a = C13452e.m80781L().m80950o();
    }
}
