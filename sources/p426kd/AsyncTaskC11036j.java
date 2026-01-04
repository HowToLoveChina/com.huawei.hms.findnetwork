package p426kd;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.android.hicloud.clouddisk.logic.media.model.MediaDirectory;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.sync.R$string;
import com.huawei.hicloud.base.bean.ModuleItem;
import com.huawei.hicloud.request.cbs.bean.CBSDevice;
import com.huawei.hicloud.request.opengw.bean.LsRequest;
import fk.C9721b;
import gp.C10028c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ke.C11046a;
import p015ak.C0209d;
import p015ak.C0227m;
import p015ak.C0241z;
import p458lo.C11322a;
import p514o9.C11839m;
import p516ob.C11845a;
import p652t9.EnumC12999a;
import p709vj.C13452e;
import to.C13049a;

/* renamed from: kd.j */
/* loaded from: classes3.dex */
public class AsyncTaskC11036j extends AsyncTask<Void, Void, List<ModuleItem>> {

    /* renamed from: d */
    public static AsyncTaskC11036j f52149d;

    /* renamed from: e */
    public static final String[] f52150e = new String[0];

    /* renamed from: a */
    public String f52151a;

    /* renamed from: b */
    public Context f52152b;

    /* renamed from: c */
    public Messenger f52153c;

    public AsyncTaskC11036j(Context context, Messenger messenger) {
        this.f52152b = context;
        this.f52153c = messenger;
    }

    /* renamed from: d */
    public static AsyncTaskC11036j m66538d(Context context, Messenger messenger) {
        if (f52149d == null || AsyncTask.Status.FINISHED.equals(f52149d.getStatus())) {
            f52149d = new AsyncTaskC11036j(context, messenger);
        } else {
            AsyncTaskC11036j asyncTaskC11036j = f52149d;
            if (messenger != asyncTaskC11036j.f52153c) {
                asyncTaskC11036j.f52153c = messenger;
            }
        }
        return f52149d;
    }

    /* renamed from: a */
    public final void m66539a(List<ModuleItem> list, List<ModuleItem> list2, List<ModuleItem> list3, String str, ModuleItem moduleItem) {
        if (str != null && str.equals(moduleItem.getDeviceID())) {
            moduleItem.setCurrent(true);
            moduleItem.setDisplayName(this.f52152b.getResources().getString(R$string.cloudbackup_self_device_new_update, moduleItem.getName()));
            list.add(moduleItem);
        } else {
            if (moduleItem.getDeviceID() != null && !moduleItem.getDeviceID().isEmpty()) {
                list2.add(moduleItem);
                return;
            }
            Resources resources = this.f52152b.getResources();
            int i10 = R$string.setting_other;
            moduleItem.setDisplayName(resources.getString(i10));
            moduleItem.setName(this.f52152b.getResources().getString(i10));
            list3.add(moduleItem);
        }
    }

    /* renamed from: b */
    public final void m66540b(List<String> list, Map<String, Object> map) {
        String str;
        if (C10028c.m62182c0().m62420y1()) {
            str = "/Hicloud/" + map.get("name") + "/sysdata/phonemanager.db";
        } else {
            str = "/BlockedBackup/" + map.get("name") + "/phonemanager.db";
        }
        list.add(str);
    }

    @Override // android.os.AsyncTask
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public List<ModuleItem> doInBackground(Void... voidArr) {
        try {
            List<CBSDevice> listM68004K = new C11322a().m68004K();
            return C10028c.m62182c0().m62420y1() ? m66543f(listM68004K, "phonemanager") : m66542e(listM68004K, "phonemanager");
        } catch (Exception e10) {
            C11839m.m70687e("GetInterceptionTask", "doInBackground: " + e10.toString());
            return null;
        }
    }

    /* renamed from: e */
    public final List<ModuleItem> m66542e(List<CBSDevice> list, String str) throws C9721b {
        C11839m.m70688i("GetInterceptionTask", "getNmdSysDataCount");
        LsRequest lsRequest = new LsRequest();
        lsRequest.setFields(new String[]{"name"});
        lsRequest.setServerPath("/BlockedBackup");
        char c10 = 2;
        lsRequest.setType(2);
        lsRequest.setRecursive(1);
        C13049a c13049a = new C13049a(EnumC12999a.CLOUD_MORE, null);
        List<Map<String, Object>> listM78718T = c13049a.m78718T(lsRequest);
        ArrayList arrayList = new ArrayList();
        Iterator<Map<String, Object>> it = listM78718T.iterator();
        while (it.hasNext()) {
            arrayList.add("/BlockedBackup/" + it.next().get("name") + "/phonemanager.db");
        }
        ArrayList arrayList2 = new ArrayList();
        if (arrayList.size() == 0) {
            C11839m.m70688i("GetInterceptionTask", "getServerDirList done. requestPaths.size = 0");
            return arrayList2;
        }
        List<Map<String, Object>> successList = c13049a.m78709H((String[]) arrayList.toArray(f52150e), new String[]{"name", "size", "itemcount"}).getSuccessList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        String strM80950o = C13452e.m80781L().m80950o();
        for (Map<String, Object> map : successList) {
            String[] strArrSplit = map.get("name").toString().split("/");
            if (strArrSplit.length == 4) {
                long jM1688f = C0241z.m1688f(map.get("size").toString());
                ArrayList arrayList5 = arrayList3;
                long jM1688f2 = C0241z.m1688f(map.get("itemcount").toString());
                if (jM1688f <= 0 || jM1688f2 <= 0) {
                    arrayList3 = arrayList5;
                } else {
                    String str2 = strArrSplit[c10];
                    ModuleItem moduleItem = new ModuleItem();
                    moduleItem.setModuleName(this.f52151a);
                    moduleItem.setDeviceIdMD5(str2);
                    moduleItem.setNum((int) jM1688f2);
                    moduleItem.setSpace(jM1688f);
                    m66545h(list, str2, moduleItem);
                    if (strM80950o != null && strM80950o.equals(moduleItem.getDeviceID())) {
                        moduleItem.setCurrent(true);
                        moduleItem.setDisplayName(this.f52152b.getResources().getString(R$string.cloudbackup_self_device_new, moduleItem.getName()));
                        arrayList2.add(moduleItem);
                        arrayList3 = arrayList5;
                    } else if (moduleItem.getDeviceID() == null || moduleItem.getDeviceID().isEmpty()) {
                        arrayList3 = arrayList5;
                        Resources resources = this.f52152b.getResources();
                        int i10 = R$string.setting_other;
                        moduleItem.setDisplayName(resources.getString(i10));
                        moduleItem.setName(this.f52152b.getResources().getString(i10));
                        arrayList4.add(moduleItem);
                    } else {
                        arrayList3 = arrayList5;
                        arrayList3.add(moduleItem);
                    }
                }
                c10 = 2;
            }
        }
        arrayList2.addAll(arrayList3);
        arrayList2.addAll(arrayList4);
        return arrayList2;
    }

    /* renamed from: f */
    public final List<ModuleItem> m66543f(List<CBSDevice> list, String str) throws C9721b {
        List<ModuleItem> arrayList = new ArrayList<>();
        List<ModuleItem> arrayList2 = new ArrayList<>();
        List<ModuleItem> arrayList3 = new ArrayList<>();
        String strM80950o = C13452e.m80781L().m80950o();
        C13049a c13049a = new C13049a(EnumC12999a.CLOUD_MORE, null);
        LsRequest lsRequest = new LsRequest();
        lsRequest.setServerPath("/Hicloud");
        lsRequest.setFields(new String[]{"name"});
        lsRequest.setType(2);
        lsRequest.setRecursive(1);
        List<Map<String, Object>> listM78718T = c13049a.m78718T(lsRequest);
        List<String> arrayList4 = new ArrayList<>();
        Iterator<Map<String, Object>> it = listM78718T.iterator();
        while (it.hasNext()) {
            m66540b(arrayList4, it.next());
        }
        if (arrayList4.size() == 0) {
            C11839m.m70688i("GetInterceptionTask", "getSysDataCount getServerDirList done. requestPaths.size = 0");
            return arrayList;
        }
        List<Map<String, Object>> successList = c13049a.m78709H((String[]) arrayList4.toArray(f52150e), new String[]{"name", "size", "itemcount"}).getSuccessList();
        if (successList == null) {
            C11839m.m70687e("GetInterceptionTask", "getSysDataCount successList is null");
            return arrayList;
        }
        HashMap map = new HashMap();
        for (Map<String, Object> map2 : successList) {
            String[] strArrSplit = map2.get("name").toString().split("/");
            if (strArrSplit.length == 5) {
                String string = map2.get("size").toString();
                String string2 = map2.get("itemcount").toString();
                String str2 = strArrSplit[2];
                map.put(str2, new MediaDirectory(str2, C0241z.m1688f(string), C0241z.m1688f(string2)));
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            String str3 = (String) entry.getKey();
            ModuleItem moduleItem = new ModuleItem();
            moduleItem.setModuleName(this.f52151a);
            moduleItem.setDeviceIdMD5(str3);
            long jM15454a = ((MediaDirectory) entry.getValue()).m15454a();
            if (jM15454a > 0) {
                moduleItem.setNum((int) jM15454a);
                moduleItem.setSpace(((MediaDirectory) entry.getValue()).m15455c());
                for (CBSDevice cBSDevice : list) {
                    if (str3.equals(C0227m.m1592e(cBSDevice.getDeviceId())) || str3.equals(C0227m.m1593f(cBSDevice.getDeviceId()))) {
                        moduleItem.setDeviceID(cBSDevice.getDeviceId());
                        String aliasName = cBSDevice.getAliasName();
                        String devDisplayName = cBSDevice.getDevDisplayName();
                        if (!TextUtils.isEmpty(devDisplayName)) {
                            aliasName = devDisplayName;
                        } else if (TextUtils.isEmpty(aliasName)) {
                            aliasName = cBSDevice.getTerminalType();
                        }
                        moduleItem.setName(aliasName);
                        moduleItem.setDisplayName(aliasName);
                        m66539a(arrayList, arrayList2, arrayList3, strM80950o, moduleItem);
                    }
                }
                m66539a(arrayList, arrayList2, arrayList3, strM80950o, moduleItem);
            }
        }
        arrayList.addAll(arrayList2);
        arrayList.addAll(arrayList3);
        return arrayList;
    }

    @Override // android.os.AsyncTask
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(List<ModuleItem> list) throws RemoteException {
        Message message = new Message();
        message.what = 1024;
        if (list == null || (list.isEmpty() && !C0209d.m1208S0(this.f52152b))) {
            message.arg1 = -5;
        } else {
            message.arg1 = 0;
            if (!CloudSyncUtil.m16016i0(this.f52151a) && !CloudSyncUtil.m16007f0()) {
                C11845a.m70908E("phonemanager", list);
                C11845a.m70937x(this.f52151a, Long.valueOf(System.currentTimeMillis()));
            }
        }
        C11046a.m66596d(this.f52153c, message);
    }

    /* renamed from: h */
    public final void m66545h(List<CBSDevice> list, String str, ModuleItem moduleItem) {
        for (CBSDevice cBSDevice : list) {
            if (str.equals(C0227m.m1593f(cBSDevice.getDeviceId())) || str.equals(C0227m.m1592e(cBSDevice.getDeviceId()))) {
                moduleItem.setDeviceID(cBSDevice.getDeviceId());
                String aliasName = cBSDevice.getAliasName();
                String devDisplayName = cBSDevice.getDevDisplayName();
                if (!TextUtils.isEmpty(devDisplayName)) {
                    aliasName = devDisplayName;
                } else if (TextUtils.isEmpty(aliasName)) {
                    aliasName = cBSDevice.getTerminalType();
                }
                moduleItem.setName(aliasName);
                moduleItem.setDisplayName(aliasName);
                return;
            }
        }
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        this.f52151a = "autophonemanagerkey";
    }
}
