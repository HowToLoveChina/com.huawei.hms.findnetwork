package je;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.huawei.android.hicloud.clouddisk.logic.media.model.MediaDirectory;
import com.huawei.android.sync.R$string;
import com.huawei.hicloud.base.bean.ModuleItem;
import com.huawei.hicloud.request.cbs.bean.CBSDevice;
import com.huawei.hicloud.request.opengw.bean.LsRequest;
import fk.C9721b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p015ak.C0227m;
import p015ak.C0241z;
import p514o9.C11839m;
import p652t9.EnumC12999a;
import p709vj.C13452e;
import to.C13049a;

/* renamed from: je.a0 */
/* loaded from: classes3.dex */
public class C10777a0 {

    /* renamed from: a */
    public static final String[] f51513a = new String[0];

    /* renamed from: a */
    public static void m65614a(List<ModuleItem> list, List<ModuleItem> list2, List<ModuleItem> list3, String str, ModuleItem moduleItem, Context context) {
        if (str != null && str.equals(moduleItem.getDeviceID())) {
            moduleItem.setCurrent(true);
            moduleItem.setDisplayName(context.getResources().getString(R$string.cloudbackup_self_device_new_update, moduleItem.getName()));
            list.add(moduleItem);
        } else {
            if (moduleItem.getDeviceID() != null && !moduleItem.getDeviceID().isEmpty()) {
                list2.add(moduleItem);
                return;
            }
            Resources resources = context.getResources();
            int i10 = R$string.setting_other;
            moduleItem.setDisplayName(resources.getString(i10));
            moduleItem.setName(context.getResources().getString(i10));
            list3.add(moduleItem);
        }
    }

    /* renamed from: b */
    public static void m65615b(Map<String, MediaDirectory> map, Map<String, Object> map2) {
        String[] strArrSplit = map2.get("name").toString().split("/");
        if (strArrSplit.length != 5) {
            return;
        }
        long jM1688f = C0241z.m1688f(map2.get("space").toString());
        long jM1688f2 = C0241z.m1688f(map2.get("fileCount").toString());
        if (jM1688f <= 0 || jM1688f2 <= 0) {
            return;
        }
        String str = strArrSplit[2];
        map.put(str, new MediaDirectory(str, jM1688f, jM1688f2));
    }

    /* renamed from: c */
    public static List<ModuleItem> m65616c(List<CBSDevice> list, String str, String str2, Context context) throws C9721b {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        String strM80950o = C13452e.m80781L().m80950o();
        C13049a c13049a = new C13049a(EnumC12999a.CLOUD_MORE, null);
        LsRequest lsRequest = new LsRequest();
        lsRequest.setServerPath("/Hicloud");
        lsRequest.setFields(new String[]{"name"});
        lsRequest.setType(2);
        lsRequest.setRecursive(1);
        List<Map<String, Object>> listM78718T = c13049a.m78718T(lsRequest);
        ArrayList arrayList4 = new ArrayList();
        Iterator<Map<String, Object>> it = listM78718T.iterator();
        while (it.hasNext()) {
            arrayList4.add("/Hicloud/" + it.next().get("name") + "/media/recording");
        }
        if (arrayList4.size() == 0) {
            C11839m.m70688i(str2, "getServerDirList done. requestPaths.size = 0");
            return arrayList;
        }
        List<Map<String, Object>> successList = c13049a.m78709H((String[]) arrayList4.toArray(f51513a), new String[]{"name", "space", "fileCount"}).getSuccessList();
        if (successList == null) {
            C11839m.m70687e(str2, "successList is null");
            return arrayList;
        }
        HashMap map = new HashMap();
        Iterator<Map<String, Object>> it2 = successList.iterator();
        while (it2.hasNext()) {
            m65615b(map, it2.next());
        }
        for (Map.Entry entry : map.entrySet()) {
            String str3 = (String) entry.getKey();
            ModuleItem moduleItem = new ModuleItem();
            if (!TextUtils.isEmpty(str)) {
                moduleItem.setModuleName(str);
            }
            moduleItem.setDeviceIdMD5(str3);
            moduleItem.setNum((int) ((MediaDirectory) entry.getValue()).m15454a());
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
                    m65614a(arrayList, arrayList2, arrayList3, strM80950o, moduleItem, context);
                }
            }
            m65614a(arrayList, arrayList2, arrayList3, strM80950o, moduleItem, context);
        }
        arrayList.addAll(arrayList2);
        arrayList.addAll(arrayList3);
        return arrayList;
    }

    /* renamed from: d */
    public static List<ModuleItem> m65617d(List<CBSDevice> list, String str, String str2, Context context) throws C9721b {
        boolean z10;
        C13049a c13049a = new C13049a(EnumC12999a.CLOUD_MORE, null);
        LsRequest lsRequest = new LsRequest();
        lsRequest.setServerPath("/RecordBackup");
        lsRequest.setFields(new String[]{"name"});
        char c10 = 2;
        lsRequest.setType(2);
        lsRequest.setRecursive(1);
        List<Map<String, Object>> listM78718T = c13049a.m78718T(lsRequest);
        ArrayList arrayList = new ArrayList();
        Iterator<Map<String, Object>> it = listM78718T.iterator();
        while (it.hasNext()) {
            arrayList.add("/RecordBackup/" + it.next().get("name"));
        }
        ArrayList arrayList2 = new ArrayList();
        if (arrayList.size() == 0) {
            return arrayList2;
        }
        String[] strArr = (String[]) arrayList.toArray(f51513a);
        String str3 = "space";
        List<Map<String, Object>> successList = c13049a.m78709H(strArr, new String[]{"name", "space", "fileCount"}).getSuccessList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        String strM80950o = C13452e.m80781L().m80950o();
        for (Map<String, Object> map : successList) {
            String[] strArrSplit = map.get("name").toString().split("/");
            if (strArrSplit.length == 3) {
                long jM1688f = C0241z.m1688f(map.get(str3).toString());
                String str4 = str3;
                long jM1688f2 = C0241z.m1688f(map.get("fileCount").toString());
                if (jM1688f <= 0 || jM1688f2 <= 0) {
                    z10 = true;
                } else {
                    String str5 = strArrSplit[c10];
                    ModuleItem moduleItem = new ModuleItem();
                    if (!TextUtils.isEmpty(str)) {
                        moduleItem.setModuleName(str);
                    }
                    moduleItem.setDeviceIdMD5(str5);
                    moduleItem.setNum((int) jM1688f2);
                    moduleItem.setSpace(jM1688f);
                    m65618e(list, str5, moduleItem);
                    if (strM80950o == null || !strM80950o.equals(moduleItem.getDeviceID())) {
                        z10 = true;
                        if (moduleItem.getDeviceID() == null || moduleItem.getDeviceID().isEmpty()) {
                            Resources resources = context.getResources();
                            int i10 = R$string.setting_other;
                            moduleItem.setDisplayName(resources.getString(i10));
                            moduleItem.setName(context.getResources().getString(i10));
                            arrayList4.add(moduleItem);
                        } else {
                            arrayList3.add(moduleItem);
                        }
                    } else {
                        z10 = true;
                        moduleItem.setCurrent(true);
                        moduleItem.setDisplayName(context.getResources().getString(R$string.cloudbackup_self_device_new, moduleItem.getName()));
                        arrayList2.add(moduleItem);
                    }
                }
                str3 = str4;
                c10 = 2;
            }
        }
        arrayList2.addAll(arrayList3);
        arrayList2.addAll(arrayList4);
        return arrayList2;
    }

    /* renamed from: e */
    public static void m65618e(List<CBSDevice> list, String str, ModuleItem moduleItem) {
        for (CBSDevice cBSDevice : list) {
            if (str.equals(C0227m.m1593f(cBSDevice.getDeviceId())) || str.equals(C0227m.m1592e(cBSDevice.getDeviceId()))) {
                moduleItem.setDeviceID(cBSDevice.getDeviceId());
                String devDisplayName = cBSDevice.getDevDisplayName();
                String aliasName = cBSDevice.getAliasName();
                if (TextUtils.isEmpty(devDisplayName)) {
                    devDisplayName = TextUtils.isEmpty(aliasName) ? cBSDevice.getTerminalType() : aliasName;
                }
                moduleItem.setName(devDisplayName);
                moduleItem.setDisplayName(devDisplayName);
                return;
            }
        }
    }
}
