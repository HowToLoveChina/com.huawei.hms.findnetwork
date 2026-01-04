package p618rm;

import android.content.Context;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0213f;
import p510o5.C11818a;
import p514o9.C11829c;
import p514o9.C11839m;
import p617rl.C12526j;
import p848zl.C14333b;

/* renamed from: rm.c */
/* loaded from: classes6.dex */
public class C12541c {
    /* renamed from: a */
    public static List<String> m75486a(boolean z10) {
        C11839m.m70688i("BackupSystemModulesUtil", "getAppBlackList, isQueryAllModules: " + z10);
        ArrayList arrayList = new ArrayList();
        if (z10) {
            List<String> listM75386e = new C12526j().m75386e();
            arrayList.addAll(C2157a.m13200h());
            arrayList.addAll(C14333b.m85454J());
            arrayList.addAll(listM75386e);
        } else {
            arrayList.addAll(C2157a.m13200h());
        }
        return arrayList;
    }

    /* renamed from: b */
    public static List<String> m75487b(boolean z10, List<String> list, boolean z11, List<String> list2) {
        C11839m.m70688i("BackupSystemModulesUtil", "getDefaultSysShowModules");
        if (z10 && list == null) {
            C11839m.m70689w("BackupSystemModulesUtil", "virtual is null");
            list = new ArrayList<>();
        }
        Context contextM1377a = C0213f.m1377a();
        ArrayList arrayList = new ArrayList();
        if (z10) {
            arrayList.addAll(C14333b.m85476k());
            boolean z12 = list.contains("music") && arrayList.contains("music");
            arrayList.removeAll(list);
            if (z12) {
                arrayList.add("music");
            }
        } else {
            arrayList.add("baseData");
            arrayList.addAll(C14333b.m85452H());
        }
        arrayList.removeAll(m75486a(z10));
        arrayList.removeAll(C12590s0.m75727B0());
        if (z11 && !ICBUtil.isSupportGallery(contextM1377a)) {
            arrayList.remove(HNConstants.DataType.MEDIA);
        }
        if (!C11829c.m70546T0(contextM1377a)) {
            arrayList.remove(HNConstants.DataType.CONTACT);
            arrayList.remove("calllog");
            arrayList.remove("callRecorder");
            arrayList.remove("harassment");
        }
        if (C11818a.m70390h0(contextM1377a)) {
            arrayList.remove("HuaweiHiAi");
        }
        m75488c(contextM1377a, arrayList);
        if (!C11829c.m70523I0(contextM1377a)) {
            arrayList.remove(NavigationUtils.SMS_SCHEMA_PREF);
            arrayList.remove("chatSms");
        }
        if ("1".equals(new SettingOperator().queryUploadTargetStrategy()) || C0209d.m1273k1() || !C0209d.m1184K0(contextM1377a, Constants.HW_BROWSER_PACKAGE)) {
            arrayList.remove("huaweiBrowser");
        }
        if (list2 == null) {
            C11839m.m70689w("BackupSystemModulesUtil", "excludeList is null");
            list2 = new ArrayList<>();
        }
        Iterator<String> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.remove(it.next());
        }
        C11839m.m70688i("BackupSystemModulesUtil", "getDefaultSysShowModules size: " + arrayList.size());
        return arrayList;
    }

    /* renamed from: c */
    public static void m75488c(Context context, List<String> list) {
        if (!C0209d.m1184K0(context, "com.huawei.hicreate") || !C0209d.m1170F1()) {
            C11839m.m70688i("BackupSystemModulesUtil", "removeHiCreate: not installed or is non pad devices.");
            list.remove("HiCreate");
        } else {
            if (RestoreUtil.isHiCreateSupportClone()) {
                return;
            }
            C11839m.m70688i("BackupSystemModulesUtil", "removeHiCreate: not support clone.");
            list.remove("HiCreate");
        }
    }
}
