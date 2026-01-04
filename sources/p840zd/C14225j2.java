package p840zd;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.PmsCheckUtil;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.CloneService;
import com.huawei.android.hicloud.cloudbackup.process.task.QueryOmAppBackupScopeTask;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.cloudbackup.util.TransferedUtil;
import com.huawei.android.hicloud.p088ui.activity.C3765j1;
import com.huawei.android.hicloud.p088ui.temporarybackup.TempBackupDataManager;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.constants.HNConstants;
import fk.C9721b;
import hu.C10343b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import p015ak.C0213f;
import p015ak.C0241z;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p617rl.C12519c;
import p617rl.C12526j;
import p617rl.C12534r;
import p618rm.C12541c;
import p618rm.C12586r;
import p618rm.C12590s0;
import p682ul.C13219m;
import p711vl.C13465e;
import p815ym.AbstractC14026a;
import p848zl.C14333b;

/* renamed from: zd.j2 */
/* loaded from: classes3.dex */
public class C14225j2 extends AbstractC12367d {

    /* renamed from: a */
    public List<String> f63413a = new ArrayList();

    /* renamed from: b */
    public final C14229k2 f63414b = new C14229k2();

    /* renamed from: c */
    public final List<String> f63415c = new C12526j().m75384d0();

    /* renamed from: d */
    public final List<String> f63416d = new C12526j().m75387e0();

    /* renamed from: e */
    public C12534r f63417e;

    /* renamed from: A */
    public static /* synthetic */ void m85061A(List list, final BackupOptionItem backupOptionItem) {
        list.stream().filter(new Predicate() { // from class: zd.e2
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C14225j2.m85075y(backupOptionItem, (BackupOptionItem) obj);
            }
        }).findFirst().ifPresent(new Consumer() { // from class: zd.f2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C14225j2.m85076z(backupOptionItem, (BackupOptionItem) obj);
            }
        });
    }

    /* renamed from: B */
    public static /* synthetic */ boolean m85062B(List list, BackupOptionItem backupOptionItem) {
        return list.contains(backupOptionItem.getAppId());
    }

    private void dealSplitApp(List<BackupOptionItem> list) {
        if (list == null) {
            C11839m.m70688i("TempBackupModuleListTask", "tempModulesList is null");
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        HashMap map = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            BackupOptionItem backupOptionItem = (BackupOptionItem) it.next();
            if (backupOptionItem != null && SplitAppUtil.hasSplitAppSuffix(backupOptionItem.getAppId())) {
                String splitAppType = SplitAppUtil.getSplitAppType(backupOptionItem.getAppId());
                backupOptionItem.setOriBackupAppName(SplitAppUtil.getSplitOriAppId(backupOptionItem.getAppId()));
                backupOptionItem.setSplitApkType(splitAppType);
                List arrayList2 = map.get(backupOptionItem.getOriBackupAppName()) != null ? (List) map.get(backupOptionItem.getOriBackupAppName()) : new ArrayList();
                if (arrayList2 != null) {
                    arrayList2.add(backupOptionItem);
                    map.put(backupOptionItem.getOriBackupAppName(), arrayList2);
                }
                it.remove();
            }
        }
        if (map.isEmpty()) {
            return;
        }
        for (final String str : map.keySet()) {
            Optional<BackupOptionItem> optionalFindFirst = list.stream().filter(new Predicate() { // from class: zd.g2
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return C14225j2.m85072t(str, (BackupOptionItem) obj);
                }
            }).findFirst();
            if (!optionalFindFirst.isPresent()) {
                C11839m.m70688i("TempBackupModuleListTask", "firstItem is null");
            } else if (optionalFindFirst.get().getBackupSwitch()) {
                C11839m.m70688i("TempBackupModuleListTask", "backupSwitch is true,not need deal");
            } else if (((List) map.get(str)) == null) {
                C11839m.m70688i("TempBackupModuleListTask", "splitItems is null");
            } else {
                list.stream().filter(new Predicate() { // from class: zd.h2
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return C14225j2.m85073u(str, (BackupOptionItem) obj);
                    }
                }).forEach(new Consumer() { // from class: zd.i2
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        ((BackupOptionItem) obj).setBackupSwitch(false);
                    }
                });
            }
        }
    }

    private void initConfig() {
        this.f63417e = C12534r.m75443g();
    }

    /* renamed from: m */
    public static List<String> m85071m() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(C14333b.m85454J());
        arrayList.addAll(new C12526j().m75386e());
        arrayList.addAll(C2157a.m13200h());
        C11839m.m70688i("TempBackupModuleListTask", "appBlackList: " + Arrays.toString(arrayList.toArray()));
        return arrayList;
    }

    /* renamed from: t */
    public static /* synthetic */ boolean m85072t(String str, BackupOptionItem backupOptionItem) {
        return str.equals(backupOptionItem.getAppId());
    }

    /* renamed from: u */
    public static /* synthetic */ boolean m85073u(String str, BackupOptionItem backupOptionItem) {
        return str.equals(backupOptionItem.getOriBackupAppName());
    }

    /* renamed from: y */
    public static /* synthetic */ boolean m85075y(BackupOptionItem backupOptionItem, BackupOptionItem backupOptionItem2) {
        return TextUtils.equals(backupOptionItem.getAppId(), backupOptionItem2.getAppId());
    }

    /* renamed from: z */
    public static /* synthetic */ void m85076z(BackupOptionItem backupOptionItem, BackupOptionItem backupOptionItem2) {
        backupOptionItem.setOperateType(backupOptionItem2.getOperateType());
        backupOptionItem.setBackupSwitch(backupOptionItem2.getBackupSwitch());
        backupOptionItem.setOperateTime(backupOptionItem2.getOperateTime());
    }

    /* renamed from: C */
    public final /* synthetic */ Boolean m85077C(String str) {
        return Boolean.valueOf(this.f63417e.m75451m(str, "3"));
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        initConfig();
        long jM81062k = C13465e.m81052f().m81062k();
        long jAbs = Math.abs(System.currentTimeMillis() - jM81062k);
        C11839m.m70688i("TempBackupModuleListTask", "lastTime: " + jM81062k + ", differentialTime: " + jAbs);
        if (jAbs >= 604800000 || AbstractC14026a.m84159a(this.f63414b.m78397u())) {
            C11839m.m70688i("TempBackupModuleListTask", "option items in sp is invalid");
            m85081p();
        } else {
            C11839m.m70688i("TempBackupModuleListTask", "option items in sp is valid, no need to scan module");
            m85080o();
        }
        if (!C12515a.m75110o().m75158X0(C14189a2.class.getName())) {
            C11839m.m70688i("TempBackupModuleListTask", "start temp backup module data task");
            C12515a.m75110o().m75172d(new C14189a2());
        }
        C11839m.m70688i("TempBackupModuleListTask", "ShowBackupOptionListTask end.");
    }

    /* renamed from: l */
    public final BackupOptionItem m85078l(String str, int i10, String str2, String str3) {
        BackupOptionItem backupOptionItemQueryItem = TransferedUtil.queryItem(str, 0, this.f63414b);
        if (backupOptionItemQueryItem != null) {
            if (backupOptionItemQueryItem.getOperateType() == 1) {
                return backupOptionItemQueryItem;
            }
            backupOptionItemQueryItem.setBackupSwitch(this.f63415c.contains(str));
            return backupOptionItemQueryItem;
        }
        BackupOptionItem backupOptionItem = new BackupOptionItem(str, "thirdAppData");
        backupOptionItem.setBackupSwitch(this.f63415c.contains(str));
        backupOptionItem.setUid(i10);
        backupOptionItem.setSplitApkType(str2);
        backupOptionItem.setOriBackupAppName(str3);
        return backupOptionItem;
    }

    /* renamed from: n */
    public final List<BackupOptionItem> m85079n(List<String> list, Map<String, C13219m<String, Integer, Integer>> map) throws C9721b, PackageManager.NameNotFoundException {
        String strValueOf;
        int iIntValue;
        String str;
        PackageManager packageManager = C0213f.m1377a().getPackageManager();
        ArrayList arrayList = new ArrayList();
        for (String str2 : list) {
            C13219m<String, Integer, Integer> c13219m = map.get(str2);
            if (c13219m != null) {
                String strM79449b = c13219m.m79449b();
                strValueOf = String.valueOf(c13219m.m79450c());
                iIntValue = c13219m.m79451d().intValue();
                str = strM79449b;
            } else {
                strValueOf = "0";
                iIntValue = 0;
                str = str2;
            }
            String str3 = strValueOf;
            boolean zM75158X0 = C12515a.m75110o().m75158X0(QueryOmAppBackupScopeTask.class.getName());
            while (zM75158X0) {
                SystemClock.sleep(500L);
                zM75158X0 = C12515a.m75110o().m75158X0(QueryOmAppBackupScopeTask.class.getName());
                C11839m.m70688i("TempBackupModuleListTask", "initTempBackup3rdAppDataItemsList wait QueryOmAppBackupScopeTask appId " + str2);
            }
            long versionCode = ICBUtil.getVersionCode(packageManager, str);
            String appName = ICBUtil.getAppName(packageManager, str, str3);
            if (new CloudBackupAppDataUtil(str, C12586r.m75711b(), versionCode, false, true).isAppDataAble() && PmsCheckUtil.m12611e()) {
                BackupOptionItem backupOptionItemM85078l = m85078l(str2, iIntValue, str3, str);
                backupOptionItemM85078l.setParent("thirdAppData");
                backupOptionItemM85078l.setBackupData(true);
                if (!TextUtils.isEmpty(appName)) {
                    str2 = appName;
                }
                backupOptionItemM85078l.setAppName(str2);
                arrayList.add(backupOptionItemM85078l);
            }
        }
        C11839m.m70688i("TempBackupModuleListTask", "backupOptionItems: " + Arrays.toString(arrayList.toArray()));
        return arrayList;
    }

    /* renamed from: o */
    public void m85080o() throws C9721b {
        C11839m.m70688i("TempBackupModuleListTask", "initOptionShowFromCache enter");
        this.f63414b.m78387h(C12590s0.m75727B0());
        ArrayList arrayList = new ArrayList();
        List<String> listM75487b = C12541c.m75487b(false, null, false, m85071m());
        ArrayList arrayList2 = new ArrayList();
        C12519c c12519c = new C12519c();
        List<String> listM75297h = c12519c.m75297h(2);
        this.f63413a = listM75297h;
        boolean zContains = listM75297h.contains("music");
        for (String str : listM75487b) {
            BackupOptionItem backupOptionItemM85087T = this.f63414b.m85087T(str);
            if (str.equals("music") && zContains) {
                backupOptionItemM85087T.setParent("virtualApp");
            }
            arrayList.add(backupOptionItemM85087T);
        }
        this.f63413a.removeAll(C14333b.m85476k());
        String str2 = C0213f.m1377a().getFilesDir() + "/cloudbackup";
        for (String str3 : this.f63413a) {
            if (new CloudBackupAppDataUtil(str3, str2, 0L, false, true).isAppDataAble()) {
                BackupOptionItem backupOptionItemM78401y = this.f63414b.m78401y(str3);
                if (backupOptionItemM78401y == null) {
                    backupOptionItemM78401y = new BackupOptionItem(str3, "virtualApp");
                    backupOptionItemM78401y.setBackupSwitch(true);
                    backupOptionItemM78401y.setBackupData(true);
                }
                backupOptionItemM78401y.setShowType(C0241z.m1685c(c12519c.m75305p(str3)));
                arrayList2.add(backupOptionItemM78401y);
            }
        }
        if (zContains) {
            this.f63413a.add("music");
        }
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(arrayList);
        arrayList3.addAll(arrayList2);
        List<BackupOptionItem> listM78399w = this.f63414b.m78399w("thirdAppData");
        if (listM78399w != null) {
            listM78399w.sort(new C3765j1());
            arrayList3.addAll(listM78399w);
        }
        C11839m.m70688i("TempBackupModuleListTask", "initOptionShowFromCache exit");
        TempBackupDataManager.m24501i().m24513q(arrayList3);
    }

    /* renamed from: p */
    public final void m85081p() {
        C11839m.m70688i("TempBackupModuleListTask", "initOptionDataFromModule enter");
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.addAll(m85084s());
            arrayList.addAll(0, m85082q());
            arrayList.addAll(m85083r());
            final List<BackupOptionItem> listM78397u = this.f63414b.m78397u();
            this.f63414b.clear();
            if (listM78397u != null) {
                arrayList.forEach(new Consumer() { // from class: zd.b2
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        C14225j2.m85061A(listM78397u, (BackupOptionItem) obj);
                    }
                });
            }
            final List<String> listM75727B0 = C12590s0.m75727B0();
            arrayList.removeIf(new Predicate() { // from class: zd.c2
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return C14225j2.m85062B(listM75727B0, (BackupOptionItem) obj);
                }
            });
            dealSplitApp(arrayList);
            this.f63414b.m78383d(arrayList);
            this.f63414b.m78387h(listM75727B0);
        } catch (C9721b e10) {
            C11839m.m70688i("TempBackupModuleListTask", "init temp back data error, " + e10.getMessage());
        }
        C11839m.m70688i("TempBackupModuleListTask", "initOptionDataFromModule exit");
        TempBackupDataManager.m24501i().m24513q(arrayList);
    }

    /* renamed from: q */
    public final List<BackupOptionItem> m85082q() {
        ArrayList arrayList = new ArrayList();
        for (String str : C12541c.m75487b(false, null, false, m85071m())) {
            BackupOptionItem backupOptionItem = new BackupOptionItem(str);
            if ("music".equals(str) || HNConstants.DataType.MEDIA.equals(str)) {
                backupOptionItem.setBackupSwitch(this.f63416d.contains(str));
            } else {
                backupOptionItem.setBackupSwitch(true);
            }
            if (backupOptionItem.getAppId().equals("music") && this.f63413a.contains("music")) {
                backupOptionItem.setParent("virtualApp");
            }
            arrayList.add(backupOptionItem);
        }
        C11839m.m70688i("TempBackupModuleListTask", "init system items: " + Arrays.toString(arrayList.toArray()));
        return arrayList;
    }

    /* renamed from: r */
    public final List<BackupOptionItem> m85083r() throws C9721b, PackageManager.NameNotFoundException {
        C11839m.m70688i("TempBackupModuleListTask", "initTempBackup3rdAppDataItemsList enter");
        if (CBAccess.hasTaskWorking()) {
            C11839m.m70688i("TempBackupModuleListTask", "init temp backup third app in backup or restore, return.");
            return new ArrayList();
        }
        Bundle backupModuleInfo = CloneService.getInstance().getBackupModuleInfo("app", false);
        if (backupModuleInfo == null) {
            C11839m.m70689w("TempBackupModuleListTask", "app bundle is null");
            return new ArrayList();
        }
        Bundle bundle = (Bundle) new C10343b(backupModuleInfo).m63680b("app");
        if (bundle == null) {
            C11839m.m70689w("TempBackupModuleListTask", "app value is null");
            return new ArrayList();
        }
        ArrayList<String> arrayListM63696r = new C10343b(bundle).m63696r("AppPackageList");
        if (AbstractC14026a.m84159a(arrayListM63696r)) {
            C11839m.m70689w("TempBackupModuleListTask", "app modules is null");
            return new ArrayList();
        }
        arrayListM63696r.removeAll(m85071m());
        Map<String, C13219m<String, Integer, Integer>> mapInit3rdAppTwinsList = SplitAppUtil.init3rdAppTwinsList(arrayListM63696r, new Function() { // from class: zd.d2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f63385a.m85077C((String) obj);
            }
        });
        arrayListM63696r.addAll(mapInit3rdAppTwinsList.keySet());
        arrayListM63696r.removeAll(m85071m());
        C11839m.m70688i("TempBackupModuleListTask", "third app module list from clone: " + Arrays.toString(arrayListM63696r.toArray()));
        List<BackupOptionItem> listM85079n = m85079n(arrayListM63696r, mapInit3rdAppTwinsList);
        C11839m.m70688i("TempBackupModuleListTask", "initTempBackup3rdAppDataItemsList exit");
        return listM85079n;
    }

    /* renamed from: s */
    public final List<BackupOptionItem> m85084s() {
        ArrayList arrayList = new ArrayList();
        try {
            C12519c c12519c = new C12519c();
            List<String> listM75297h = c12519c.m75297h(2);
            this.f63413a = listM75297h;
            boolean zContains = listM75297h.contains("music");
            this.f63413a.removeAll(C14333b.m85476k());
            String str = C0213f.m1377a().getFilesDir() + "/cloudbackup";
            for (String str2 : this.f63413a) {
                int iM1685c = C0241z.m1685c(c12519c.m75305p(str2));
                C12519c c12519c2 = c12519c;
                if (new CloudBackupAppDataUtil(str2, str, 0L, true, false).isAppDataAble()) {
                    BackupOptionItem backupOptionItem = new BackupOptionItem(str2, "virtualApp");
                    BackupOptionItem backupOptionItemQueryItem = TransferedUtil.queryItem(str2, this.f63414b);
                    if (backupOptionItemQueryItem == null || backupOptionItemQueryItem.getOperateType() == 0) {
                        backupOptionItem.setBackupSwitch(this.f63416d.contains(str2));
                    } else {
                        backupOptionItem.setBackupSwitch(backupOptionItemQueryItem.getBackupSwitch());
                    }
                    backupOptionItem.setBackupData(true);
                    backupOptionItem.setShowType(iM1685c);
                    arrayList.add(backupOptionItem);
                }
                c12519c = c12519c2;
            }
            if (zContains) {
                this.f63413a.add("music");
            }
        } catch (C9721b e10) {
            C11839m.m70687e("TempBackupModuleListTask", "query virtual app list error: " + e10.getMessage());
        }
        C11839m.m70688i("TempBackupModuleListTask", "init virtual items: " + Arrays.toString(arrayList.toArray()));
        return arrayList;
    }
}
