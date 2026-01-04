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
import com.huawei.hicloud.base.bean.ModuleItem;
import com.huawei.hicloud.request.cbs.bean.CBSDevCalllogSmsCount;
import com.huawei.hicloud.request.cbs.bean.CBSDevCount;
import com.huawei.hicloud.request.cbs.bean.CBSDevice;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import ke.C11046a;
import p458lo.C11322a;
import p514o9.C11839m;
import p516ob.C11845a;
import p709vj.C13452e;

/* renamed from: kd.h */
/* loaded from: classes3.dex */
public class AsyncTaskC11034h extends AsyncTask<Void, Void, List<ModuleItem>> {

    /* renamed from: i */
    public static AsyncTaskC11034h f52129i;

    /* renamed from: a */
    public String f52130a;

    /* renamed from: b */
    public String f52131b;

    /* renamed from: c */
    public Context f52132c;

    /* renamed from: d */
    public Messenger f52133d;

    /* renamed from: e */
    public List<CBSDevice> f52134e;

    /* renamed from: f */
    public int f52135f;

    /* renamed from: g */
    public boolean f52136g;

    /* renamed from: h */
    public boolean f52137h;

    public AsyncTaskC11034h(Context context, Messenger messenger) {
        this.f52132c = context;
        this.f52133d = messenger;
    }

    /* renamed from: c */
    public static AsyncTaskC11034h m66524c(Context context, Messenger messenger) {
        if (f52129i == null || AsyncTask.Status.FINISHED.equals(f52129i.getStatus())) {
            f52129i = new AsyncTaskC11034h(context, messenger);
        } else {
            AsyncTaskC11034h asyncTaskC11034h = f52129i;
            if (messenger != asyncTaskC11034h.f52133d) {
                asyncTaskC11034h.f52133d = messenger;
            }
        }
        return f52129i;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<ModuleItem> doInBackground(Void... voidArr) {
        try {
            return m66527d("callLog");
        } catch (Exception e10) {
            C11839m.m70687e("GetCallLogTask", "doInBackground: " + e10.toString());
            return null;
        }
    }

    /* renamed from: b */
    public final CBSDevCalllogSmsCount m66526b(String str, C11322a c11322a) throws C9721b {
        List<CBSDevice> list = this.f52134e;
        return (list == null || !this.f52136g || list.isEmpty()) ? c11322a.m68025i(str, new ArrayList()) : c11322a.m68025i(str, this.f52134e);
    }

    /* renamed from: d */
    public final List<ModuleItem> m66527d(String str) throws C9721b {
        CBSDevCalllogSmsCount cBSDevCalllogSmsCountM66526b = m66526b(str, new C11322a());
        List<CBSDevCount> countRet = cBSDevCalllogSmsCountM66526b.getCountRet();
        this.f52134e = cBSDevCalllogSmsCountM66526b.getNotQuaryDeviceList();
        this.f52135f = cBSDevCalllogSmsCountM66526b.getResult();
        if (countRet == null || countRet.isEmpty()) {
            return null;
        }
        C11839m.m70686d("GetCallLogTask", "devCounts: " + countRet.size());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (CBSDevCount cBSDevCount : countRet) {
            int count = cBSDevCount.getCount();
            CBSDevice device = cBSDevCount.getDevice();
            if (count > 0) {
                ModuleItem moduleItem = new ModuleItem();
                moduleItem.setModuleName(this.f52130a);
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
                String str2 = this.f52131b;
                if (str2 != null && str2.equals(device.getDeviceId())) {
                    moduleItem.setCurrent(true);
                    moduleItem.setDisplayName(this.f52132c.getResources().getString(R$string.cloudbackup_self_device_new_update, aliasName));
                    arrayList.add(moduleItem);
                } else if (moduleItem.getDisplayName() == null || moduleItem.getDisplayName().isEmpty()) {
                    moduleItem.setDisplayName(this.f52132c.getResources().getString(R$string.setting_other));
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
        message.what = PlayerConstants.ErrorCode.MEDIA_SEEK_NO_AVAILABLE_SEGMENT;
        if (list == null) {
            message.arg1 = -5;
        } else {
            message.arg1 = 0;
            if (!CloudSyncUtil.m16007f0()) {
                C11845a.m70904A("calllog", list, this.f52134e, this.f52135f, this.f52137h);
                Bundle bundle = new Bundle();
                bundle.putBoolean("fromBackup", this.f52137h);
                message.setData(bundle);
                C11845a.m70937x(this.f52130a, Long.valueOf(System.currentTimeMillis()));
            }
        }
        C11046a.m66596d(this.f52133d, message);
    }

    /* renamed from: f */
    public void m66529f(boolean z10) {
        this.f52137h = z10;
    }

    /* renamed from: g */
    public void m66530g(boolean z10) {
        this.f52136g = z10;
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        this.f52130a = "autocallloglistkey";
        this.f52131b = C13452e.m80781L().m80950o();
        this.f52134e = C11845a.m70928o("calllog");
    }
}
