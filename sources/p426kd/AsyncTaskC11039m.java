package p426kd;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.sync.R$string;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.base.bean.ModuleItem;
import com.huawei.hicloud.request.cbs.bean.CBSDevCalllogSmsCount;
import com.huawei.hicloud.request.cbs.bean.CBSDevCount;
import com.huawei.hicloud.request.cbs.bean.CBSDevice;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import ke.C11046a;
import p458lo.C11322a;
import p516ob.C11845a;
import p709vj.C13452e;

/* renamed from: kd.m */
/* loaded from: classes3.dex */
public class AsyncTaskC11039m extends AsyncTask<Void, Void, List<ModuleItem>> {

    /* renamed from: i */
    public static AsyncTaskC11039m f52170i;

    /* renamed from: a */
    public String f52171a;

    /* renamed from: b */
    public String f52172b;

    /* renamed from: c */
    public Context f52173c;

    /* renamed from: d */
    public Messenger f52174d;

    /* renamed from: e */
    public List<CBSDevice> f52175e;

    /* renamed from: f */
    public int f52176f;

    /* renamed from: g */
    public boolean f52177g;

    /* renamed from: h */
    public boolean f52178h;

    public AsyncTaskC11039m(Context context, Messenger messenger) {
        this.f52173c = context;
        this.f52174d = messenger;
    }

    /* renamed from: c */
    public static AsyncTaskC11039m m66560c(Context context, Messenger messenger) {
        if (f52170i == null || AsyncTask.Status.FINISHED.equals(f52170i.getStatus())) {
            f52170i = new AsyncTaskC11039m(context, messenger);
        } else {
            AsyncTaskC11039m asyncTaskC11039m = f52170i;
            if (messenger != asyncTaskC11039m.f52174d) {
                asyncTaskC11039m.f52174d = messenger;
            }
        }
        return f52170i;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<ModuleItem> doInBackground(Void... voidArr) {
        try {
            return m66563d(NavigationUtils.SMS_SCHEMA_PREF);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public final CBSDevCalllogSmsCount m66562b(String str, C11322a c11322a) throws C9721b {
        List<CBSDevice> list = this.f52175e;
        return (list == null || !this.f52177g || list.isEmpty()) ? c11322a.m68025i(str, new ArrayList()) : c11322a.m68025i(str, this.f52175e);
    }

    /* renamed from: d */
    public final List<ModuleItem> m66563d(String str) throws C9721b {
        CBSDevCalllogSmsCount cBSDevCalllogSmsCountM66562b = m66562b(str, new C11322a());
        List<CBSDevCount> countRet = cBSDevCalllogSmsCountM66562b.getCountRet();
        this.f52175e = cBSDevCalllogSmsCountM66562b.getNotQuaryDeviceList();
        this.f52176f = cBSDevCalllogSmsCountM66562b.getResult();
        if (countRet == null || countRet.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (CBSDevCount cBSDevCount : countRet) {
            int count = cBSDevCount.getCount();
            CBSDevice device = cBSDevCount.getDevice();
            if (count > 0) {
                ModuleItem moduleItem = new ModuleItem();
                moduleItem.setModuleName(this.f52171a);
                moduleItem.setDeviceID(device.getDeviceId());
                moduleItem.setDeviceType(device.getDeviceType());
                String aliasName = device.getAliasName();
                String devDisplayName = device.getDevDisplayName();
                if (!TextUtils.isEmpty(devDisplayName)) {
                    aliasName = devDisplayName;
                } else if (TextUtils.isEmpty(aliasName)) {
                    aliasName = device.getTerminalType();
                }
                moduleItem.setNum(count);
                moduleItem.setName(aliasName);
                moduleItem.setDisplayName(aliasName);
                String str2 = this.f52172b;
                if (str2 != null && str2.equals(device.getDeviceId())) {
                    moduleItem.setCurrent(true);
                    moduleItem.setDisplayName(this.f52173c.getResources().getString(R$string.cloudbackup_self_device_new_update, aliasName));
                    arrayList.add(moduleItem);
                } else if (moduleItem.getDisplayName() == null || moduleItem.getDisplayName().isEmpty()) {
                    moduleItem.setDisplayName(this.f52173c.getResources().getString(R$string.setting_other));
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
        Message message = new Message();
        message.what = 1020;
        if (list == null) {
            message.arg1 = -5;
        } else {
            message.arg1 = 0;
            if (!CloudSyncUtil.m16007f0()) {
                C11845a.m70904A(NavigationUtils.SMS_SCHEMA_PREF, list, this.f52175e, this.f52176f, this.f52178h);
                Bundle bundle = new Bundle();
                bundle.putBoolean("fromBackup", this.f52178h);
                message.setData(bundle);
                C11845a.m70937x(this.f52171a, Long.valueOf(System.currentTimeMillis()));
            }
        }
        C11046a.m66596d(this.f52174d, message);
    }

    /* renamed from: f */
    public void m66565f(boolean z10) {
        this.f52178h = z10;
    }

    /* renamed from: g */
    public void m66566g(boolean z10) {
        this.f52177g = z10;
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        this.f52171a = "autosmslistkey";
        this.f52172b = C13452e.m80781L().m80950o();
        this.f52175e = C11845a.m70928o(NavigationUtils.SMS_SCHEMA_PREF);
    }
}
