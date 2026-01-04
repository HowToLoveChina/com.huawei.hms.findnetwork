package om;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.process.C2516c0;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupLanguageUtil;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.uiutil.NewHiSyncUtil;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.cloudbackup.p104v3.model.BackupItem;
import com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;
import p015ak.C0213f;
import p015ak.C0241z;
import p514o9.C11839m;
import p617rl.C12519c;
import p709vj.C13452e;
import p815ym.AbstractC14026a;
import p848zl.C14333b;
import sl.C12815f;

/* renamed from: om.c */
/* loaded from: classes6.dex */
public class C11963c {

    /* renamed from: a */
    public static final C11961a f55689a = new C11961a(34011);

    /* renamed from: b */
    public static final C11961a f55690b = new C11961a(34013);

    /* renamed from: b */
    public static void m71947b(CloudBackupStatus cloudBackupStatus, String str) {
        C11961a c11961aM71960o = m71960o(str);
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(c11961aM71960o.m71940a());
        BackupItem backupItemM71953h = m71953h("thirdAppData", copyOnWriteArrayList);
        if (cloudBackupStatus.mo29370Q()) {
            BackupItem backupItemM71953h2 = m71953h("baseData", copyOnWriteArrayList);
            if (backupItemM71953h2 == null) {
                C11839m.m70688i("BackupModuleProgressManager", "addAppdataAndRefreshBackupItem baseItem is null appId: " + cloudBackupStatus.m29870d());
                return;
            }
            BackupItem backupItemM71953h3 = m71953h("thirdApp", backupItemM71953h2.m29824I0());
            if (backupItemM71953h3 == null) {
                C11839m.m70688i("BackupModuleProgressManager", "addAppdataAndRefreshBackupItem thirdItem is null appId: " + cloudBackupStatus.m29870d());
                return;
            }
            if (m71953h(cloudBackupStatus.m29870d(), backupItemM71953h3.m29824I0()) == null) {
                C11839m.m70688i("BackupModuleProgressManager", "addAppdataAndRefreshBackupItem backupItem is null " + cloudBackupStatus.m29870d());
                return;
            }
        }
        BackupItem backupItem = new BackupItem();
        backupItem.mo29340B0(cloudBackupStatus.m29861N()).mo29313Y(cloudBackupStatus.m29870d()).mo29316a0(cloudBackupStatus.m29871e()).mo29318b0(cloudBackupStatus.m29872f()).m29857C0(cloudBackupStatus);
        backupItem.m29845d1("thirdAppData");
        if (backupItemM71953h == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(backupItem);
            BackupItem backupItem2 = new BackupItem();
            backupItem2.mo29313Y("thirdAppData").mo29318b0(1).mo29316a0(C2783d.m16079E(m71956k(), "thirdAppData")).mo29327g0(arrayList.size()).m29838W0(arrayList).m29851j1();
            copyOnWriteArrayList.add(backupItem2);
        } else {
            List<BackupItem> listM29824I0 = backupItemM71953h.m29824I0();
            if (m71952g(cloudBackupStatus.m29870d(), cloudBackupStatus.m29861N(), listM29824I0) != null) {
                C11839m.m70688i("BackupModuleProgressManager", "addAppdataAndRefreshBackupItem backupItem is not null appId: " + cloudBackupStatus.m29870d() + " uid: " + cloudBackupStatus.m29861N());
                return;
            }
            listM29824I0.add(backupItem);
            Collections.sort(listM29824I0, new C2516c0());
            new BackupItem().mo29327g0(listM29824I0.size()).m29851j1();
        }
        c11961aM71960o.m71944e(copyOnWriteArrayList);
        Message messageObtain = Message.obtain();
        messageObtain.what = 34012;
        CBCallBack.getInstance().sendMessage(messageObtain);
    }

    /* renamed from: c */
    public static List<BackupItem> m71948c(List<BackupItem> list, List<BackupItem> list2, List<BackupItem> list3, List<BackupItem> list4, C11961a c11961a) {
        ArrayList arrayList = new ArrayList();
        if (!list3.isEmpty()) {
            Collections.sort(list3, new C2516c0());
            BackupItem backupItem = new BackupItem();
            backupItem.mo29313Y("thirdApp").mo29318b0(1).mo29316a0(C2783d.m16079E(m71956k(), "thirdApp")).mo29327g0(list3.size()).m29838W0(list3).m29851j1();
            list2.add(backupItem);
        }
        if (!list2.isEmpty()) {
            list2.sort(new C2516c0());
            if (c11961a.m71943d()) {
                BackupItem backupItem2 = new BackupItem();
                backupItem2.mo29313Y("baseData").mo29318b0(0).mo29316a0(C2783d.m16079E(m71956k(), "baseData")).mo29327g0(list2.size()).m29838W0(list2).m29851j1();
                arrayList.add(backupItem2);
            } else {
                arrayList.addAll(list2);
            }
        }
        Collections.sort(list, new C2516c0());
        arrayList.addAll(list);
        if (!list4.isEmpty()) {
            Collections.sort(list4, new C2516c0());
            BackupItem backupItem3 = new BackupItem();
            backupItem3.mo29313Y("thirdAppData").mo29318b0(1).mo29316a0(C2783d.m16079E(m71956k(), "thirdAppData")).mo29327g0(list4.size()).m29838W0(list4).m29851j1();
            arrayList.add(backupItem3);
        }
        return arrayList;
    }

    /* renamed from: d */
    public static List<BackupItem> m71949d(List<CloudBackupStatus> list, C11961a c11961a) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList<String> arrayListM71942c = c11961a.m71942c();
        arrayListM71942c.clear();
        BackupItem backupItemM71963r = null;
        BackupItem backupItemM71963r2 = null;
        for (CloudBackupStatus cloudBackupStatus : list) {
            String strM29870d = cloudBackupStatus.m29870d();
            int iM29872f = cloudBackupStatus.m29872f();
            if ((cloudBackupStatus.m29860M() == 4 || cloudBackupStatus.m29860M() == 1) && cloudBackupStatus.m29858I() == 3) {
                cloudBackupStatus.mo29289A0(0);
            }
            if (iM29872f == 0) {
                BackupItem backupItem = new BackupItem();
                backupItem.mo29313Y(strM29870d).mo29316a0(C2783d.m16079E(m71956k(), strM29870d)).mo29318b0(0).m29857C0(cloudBackupStatus);
                if (C14333b.m85482q().contains(strM29870d)) {
                    backupItem.m29845d1("baseData");
                    arrayList2.add(backupItem);
                } else if (NavigationUtils.SMS_SCHEMA_PREF.equals(strM29870d) || "chatSms".equals(strM29870d)) {
                    backupItemM71963r = m71963r(arrayList, backupItemM71963r, backupItem, NavigationUtils.SMS_SCHEMA_PREF);
                } else if ("soundrecorder".equals(strM29870d) || "callRecorder".equals(strM29870d)) {
                    backupItemM71963r2 = m71963r(arrayList, backupItemM71963r2, backupItem, "soundrecorder");
                } else {
                    arrayList.add(backupItem);
                }
            } else if (iM29872f != 2) {
                String strM29871e = cloudBackupStatus.m29871e();
                int iM29861N = cloudBackupStatus.m29861N();
                if (strM29871e.isEmpty()) {
                    strM29871e = NewHiSyncUtil.m25632b(strM29870d);
                }
                if (cloudBackupStatus.m29862O()) {
                    BackupItem backupItem2 = new BackupItem();
                    backupItem2.mo29340B0(iM29861N).mo29313Y(strM29870d).mo29316a0(strM29871e).mo29318b0(iM29872f).m29857C0(cloudBackupStatus);
                    backupItem2.m29845d1("thirdAppData");
                    arrayList4.add(backupItem2);
                    arrayListM71942c.add(strM29870d);
                }
                BackupItem backupItem3 = new BackupItem();
                backupItem3.mo29340B0(iM29861N).mo29313Y(strM29870d).mo29316a0(strM29871e).mo29318b0(iM29872f).m29857C0(cloudBackupStatus);
                backupItem3.m29845d1("thirdApp");
                arrayList3.add(backupItem3);
            } else {
                BackupItem backupItem4 = new BackupItem();
                int iM1685c = C0241z.m1685c(new C12519c().m75305p(strM29870d));
                if (cloudBackupStatus.m29860M() != -1 && cloudBackupStatus.m29860M() != 7 && cloudBackupStatus.m29860M() != 6) {
                    cloudBackupStatus.mo29289A0(0);
                }
                backupItem4.mo29313Y(strM29870d).mo29316a0(CloudBackupLanguageUtil.getVirtualName(strM29870d)).mo29318b0(2).m29857C0(cloudBackupStatus);
                backupItem4.m29847f1(iM1685c);
                arrayList.add(backupItem4);
            }
        }
        return m71948c(arrayList, arrayList2, arrayList3, arrayList4, c11961a);
    }

    /* renamed from: e */
    public static void m71950e() {
        f55690b.m71940a().clear();
        f55689a.m71940a().clear();
    }

    /* renamed from: f */
    public static void m71951f(String str) {
        m71960o(str).m71940a().clear();
    }

    /* renamed from: g */
    public static BackupItem m71952g(String str, int i10, List<BackupItem> list) {
        if (list != null && !list.isEmpty()) {
            for (BackupItem backupItem : list) {
                if (backupItem.m29870d().equals(str) && backupItem.m29861N() == i10) {
                    return backupItem;
                }
            }
        }
        return null;
    }

    /* renamed from: h */
    public static BackupItem m71953h(String str, List<BackupItem> list) {
        if (list != null && !list.isEmpty()) {
            for (BackupItem backupItem : list) {
                if (backupItem.m29870d().equals(str)) {
                    return backupItem;
                }
            }
        }
        return null;
    }

    /* renamed from: i */
    public static List<BackupItem> m71954i(String str) {
        ArrayList arrayList = new ArrayList();
        m71955j(arrayList, m71960o(str).m71940a());
        return arrayList;
    }

    /* renamed from: j */
    public static void m71955j(List<BackupItem> list, List<BackupItem> list2) {
        for (BackupItem backupItem : list2) {
            if (!"thirdAppData".equals(backupItem.m29870d())) {
                if (backupItem.m29824I0() == null || backupItem.m29824I0().isEmpty()) {
                    list.add(backupItem);
                } else {
                    m71955j(list, backupItem.m29824I0());
                }
            }
        }
    }

    /* renamed from: k */
    public static Context m71956k() {
        return C0213f.m1377a();
    }

    /* renamed from: l */
    public static BackupItem m71957l(String str, C11961a c11961a) {
        List<BackupItem> listM71940a = c11961a.m71940a();
        if (c11961a.m71943d() && C14333b.m85482q().contains(str)) {
            return m71953h("baseData", listM71940a);
        }
        if ("chatSms".equals(str)) {
            str = NavigationUtils.SMS_SCHEMA_PREF;
        }
        if ("callRecorder".equals(str)) {
            str = "soundrecorder";
        }
        return m71953h(str, listM71940a);
    }

    /* renamed from: m */
    public static BackupItem m71958m(String str, int i10, List<BackupItem> list) {
        if (list == null) {
            return null;
        }
        for (BackupItem backupItem : list) {
            List<BackupItem> listM29824I0 = backupItem.m29824I0();
            if (listM29824I0 != null) {
                BackupItem backupItemM71958m = m71958m(str, i10, listM29824I0);
                if (backupItemM71958m != null) {
                    return backupItemM71958m;
                }
            } else if (str.equals(backupItem.m29870d()) && i10 == backupItem.m29861N()) {
                return backupItem;
            }
        }
        return null;
    }

    /* renamed from: n */
    public static List<BackupItem> m71959n(String str) {
        return new ArrayList(m71960o(str).m71940a());
    }

    /* renamed from: o */
    public static C11961a m71960o(String str) {
        return TextUtils.equals(str, "interim") ? f55690b : f55689a;
    }

    /* renamed from: p */
    public static synchronized void m71961p(String str) {
        try {
            C11961a c11961aM71960o = m71960o(str);
            List<BackupItem> listM71940a = c11961aM71960o.m71940a();
            if (listM71940a.isEmpty()) {
                C11839m.m70686d("BackupModuleProgressManager", "initBackupItems");
                c11961aM71960o.m71945f(str.equals("Refurbishment") || str.equals("interim") || !C13452e.m80781L().m80887a1());
                C14333b.m85463S(new C12519c().m75301l());
                List<BackupItem> listM71949d = m71949d(new ArrayList(new C12815f(str).m76930i()), c11961aM71960o);
                listM71940a.clear();
                listM71940a.addAll(listM71949d);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: q */
    public static /* synthetic */ boolean m71962q(BackupItem backupItem) {
        return backupItem != null && "thirdApp".equals(backupItem.m29870d());
    }

    /* renamed from: r */
    public static BackupItem m71963r(List<BackupItem> list, BackupItem backupItem, BackupItem backupItem2, String str) {
        if (backupItem != null) {
            List<BackupItem> listM29824I0 = backupItem.m29824I0();
            listM29824I0.add(backupItem2);
            Collections.sort(listM29824I0, new C2516c0());
            backupItem.m29851j1();
            return backupItem;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(backupItem2);
        BackupItem backupItem3 = new BackupItem();
        backupItem3.mo29313Y(str).mo29316a0(C2783d.m16079E(m71956k(), str)).mo29318b0(0).m29838W0(arrayList).m29851j1();
        list.add(backupItem3);
        return backupItem3;
    }

    /* renamed from: s */
    public static void m71964s(String str, int i10, String str2) {
        m71965t(str, i10, str2);
        Message messageObtain = Message.obtain();
        messageObtain.what = 34012;
        CBCallBack.getInstance().sendMessage(messageObtain);
    }

    /* renamed from: t */
    public static void m71965t(String str, int i10, String str2) {
        if (C4633d0.m28404a(str)) {
            return;
        }
        C11961a c11961aM71960o = m71960o(str2);
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(c11961aM71960o.m71940a());
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            BackupItem backupItem = (BackupItem) it.next();
            if (backupItem != null) {
                if (str.equals(backupItem.m29870d())) {
                    C11839m.m70686d("BackupModuleProgressManager", "remove this back item, appId: " + str + " uid: " + i10);
                    copyOnWriteArrayList.remove(backupItem);
                } else if ("baseData".equals(backupItem.m29870d())) {
                    Optional<BackupItem> optionalFindFirst = backupItem.m29824I0().parallelStream().filter(new Predicate() { // from class: om.b
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            return C11963c.m71962q((BackupItem) obj);
                        }
                    }).findFirst();
                    if (optionalFindFirst.isPresent()) {
                        BackupItem backupItem2 = optionalFindFirst.get();
                        m71967v(str, i10, backupItem2);
                        if (AbstractC14026a.m84159a(backupItem2.m29824I0()) && !C4633d0.m28404a(backupItem2.m29870d())) {
                            m71967v(backupItem2.m29870d(), i10, backupItem);
                        }
                    }
                } else if ("thirdAppData".equals(backupItem.m29870d())) {
                    m71967v(str, i10, backupItem);
                    if (AbstractC14026a.m84159a(backupItem.m29824I0())) {
                        C11839m.m70686d("BackupModuleProgressManager", "remove third app data, appId: " + str + " uid: " + i10);
                        copyOnWriteArrayList.remove(backupItem);
                    }
                } else if ("thirdApp".equals(backupItem.m29870d())) {
                    m71967v(str, i10, backupItem);
                    if (AbstractC14026a.m84159a(backupItem.m29824I0())) {
                        C11839m.m70686d("BackupModuleProgressManager", "remove third app, appId: " + str + " uid: " + i10);
                        copyOnWriteArrayList.remove(backupItem);
                    }
                }
            }
        }
        c11961aM71960o.m71944e(copyOnWriteArrayList);
    }

    /* renamed from: u */
    public static void m71966u(String str, int i10, String str2) {
        if (C4633d0.m28404a(str)) {
            return;
        }
        C11961a c11961aM71960o = m71960o(str2);
        if (c11961aM71960o.m71942c().contains(str)) {
            ArrayList arrayList = new ArrayList(c11961aM71960o.m71940a());
            Iterator<BackupItem> it = arrayList.iterator();
            while (it.hasNext()) {
                BackupItem next = it.next();
                if (next != null && "thirdAppData".equals(next.m29870d())) {
                    m71967v(str, i10, next);
                    if (next.m29824I0() == null || next.m29824I0().isEmpty()) {
                        C11839m.m70686d("BackupModuleProgressManager", "remove third app data, appId: " + str + " uid: " + i10);
                        it.remove();
                    }
                }
            }
            c11961aM71960o.m71944e(arrayList);
            Message messageObtain = Message.obtain();
            messageObtain.what = 34012;
            CBCallBack.getInstance().sendMessage(messageObtain);
        }
    }

    /* renamed from: v */
    public static void m71967v(String str, int i10, BackupItem backupItem) {
        if (i10 == 0) {
            m71968w(str, backupItem);
            return;
        }
        List<BackupItem> listM29824I0 = backupItem.m29824I0();
        if (listM29824I0 == null || listM29824I0.isEmpty()) {
            C11839m.m70688i("BackupModuleProgressManager", "childList is null or size is 0.");
            return;
        }
        C11839m.m70688i("BackupModuleProgressManager", "removeItemFromList = size: " + listM29824I0.size());
        ArrayList arrayList = new ArrayList(listM29824I0);
        Iterator<BackupItem> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            BackupItem next = it.next();
            if (str.equals(next.m29870d()) && i10 == next.m29861N()) {
                C11839m.m70686d("BackupModuleProgressManager", "remove backup item appId: " + str + " uid: " + i10);
                it.remove();
                break;
            }
        }
        backupItem.m29838W0(arrayList);
        backupItem.m29851j1();
    }

    /* renamed from: w */
    public static void m71968w(String str, BackupItem backupItem) {
        List<BackupItem> listM29824I0 = backupItem.m29824I0();
        if (listM29824I0 == null || listM29824I0.isEmpty()) {
            C11839m.m70688i("BackupModuleProgressManager", "childList is null or size is 0.");
            return;
        }
        C11839m.m70688i("BackupModuleProgressManager", "removeItemFromList = size: " + listM29824I0.size());
        ArrayList arrayList = new ArrayList(listM29824I0);
        Iterator<BackupItem> it = arrayList.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().m29870d())) {
                C11839m.m70686d("BackupModuleProgressManager", "remove backup item appId: " + str);
                it.remove();
            }
        }
        backupItem.m29838W0(arrayList);
        backupItem.m29851j1();
    }

    /* renamed from: x */
    public static void m71969x(BackupItem backupItem, BackupStatus backupStatus) {
        if (backupItem != null) {
            List<BackupItem> listM29824I0 = backupItem.m29824I0();
            if (listM29824I0 != null && !listM29824I0.isEmpty()) {
                String strM29870d = backupStatus.m29870d();
                int iM29861N = backupStatus.m29861N();
                Iterator<BackupItem> it = listM29824I0.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    BackupItem next = it.next();
                    if (strM29870d.equals(next.m29870d()) && iM29861N == next.m29861N()) {
                        next.m29857C0(backupStatus);
                        next.m29851j1();
                        if (!"soundrecorder".equals(strM29870d) && !"callRecorder".equals(strM29870d) && !NavigationUtils.SMS_SCHEMA_PREF.equals(strM29870d) && !"chatSms".equals(strM29870d)) {
                            C11965e.m71974f().m71988q(next);
                        }
                    }
                }
            } else {
                backupItem.m29857C0(backupStatus);
            }
            backupItem.m29851j1();
            C11965e.m71974f().m71988q(backupItem);
        }
    }

    /* renamed from: y */
    public static void m71970y(BackupStatus backupStatus, String str) {
        C11839m.m70686d("BackupModuleProgressManager", "updateInner status = " + backupStatus.toString());
        String strM29870d = backupStatus.m29870d();
        int iM29872f = backupStatus.m29872f();
        C11961a c11961aM71960o = m71960o(str);
        List<BackupItem> listM71940a = c11961aM71960o.m71940a();
        if (iM29872f == 0) {
            m71969x(m71957l(strM29870d, c11961aM71960o), backupStatus);
        } else if (iM29872f != 2) {
            m71971z(backupStatus, c11961aM71960o);
        } else {
            m71969x(m71953h(strM29870d, listM71940a), backupStatus);
        }
    }

    /* renamed from: z */
    public static void m71971z(BackupStatus backupStatus, C11961a c11961a) {
        List<BackupItem> listM71940a = c11961a.m71940a();
        if (!c11961a.m71943d()) {
            m71969x(m71953h("thirdApp", listM71940a), backupStatus);
            m71969x(m71953h("thirdAppData", listM71940a), backupStatus);
            return;
        }
        BackupItem backupItemM71953h = m71953h("baseData", listM71940a);
        if (backupItemM71953h != null) {
            m71969x(m71953h("thirdApp", backupItemM71953h.m29824I0()), backupStatus);
            backupItemM71953h.m29851j1();
            C11965e.m71974f().m71988q(backupItemM71953h);
            m71969x(m71953h("thirdAppData", listM71940a), backupStatus);
        }
    }
}
