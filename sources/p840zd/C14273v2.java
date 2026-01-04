package p840zd;

import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.android.backup.filelogic.utils.PmsCheckUtil;
import com.huawei.android.hicloud.cloudbackup.bean.BackupAppSwitchStatusBean;
import com.huawei.android.hicloud.cloudbackup.process.CloneService;
import com.huawei.android.hicloud.cloudbackup.process.task.QueryOmAppBackupScopeTask;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.cloudbackup.util.TransferedUtil;
import com.huawei.android.hicloud.p088ui.temporarybackup.TempBackupDataManager;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import fk.C9721b;
import hu.C10343b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.function.Function;
import java.util.function.Predicate;
import p015ak.C0213f;
import p015ak.C0214f0;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p617rl.C12526j;
import p617rl.C12534r;
import p618rm.C12586r;
import p618rm.C12590s0;
import p682ul.C13219m;

/* renamed from: zd.v2 */
/* loaded from: classes3.dex */
public class C14273v2 extends AbstractC12367d {

    /* renamed from: a */
    public final C14229k2 f63486a = new C14229k2();

    /* renamed from: b */
    public final CloneService f63487b = CloneService.getInstance();

    /* renamed from: c */
    public CountDownLatch f63488c;

    /* renamed from: d */
    public final Vector<BackupAppSwitchStatusBean> f63489d;

    /* renamed from: e */
    public final List<String> f63490e;

    /* renamed from: f */
    public Vector<String> f63491f;

    /* renamed from: g */
    public List<String> f63492g;

    /* renamed from: h */
    public C12534r f63493h;

    public C14273v2(CountDownLatch countDownLatch, List<String> list, Vector<String> vector, Vector<BackupAppSwitchStatusBean> vector2) {
        ArrayList arrayList = new ArrayList();
        this.f63490e = arrayList;
        this.f63488c = countDownLatch;
        this.f63489d = vector2;
        arrayList.addAll(list);
        this.f63491f = vector;
        this.f63492g = new C12526j().m75384d0();
    }

    /* renamed from: e */
    private void m85093e(C14229k2 c14229k2) {
        if (c14229k2 == null) {
            c14229k2 = new C14229k2();
        }
        List<BackupOptionItem> listM78397u = c14229k2.m78397u();
        if (listM78397u == null) {
            C11839m.m70688i("TempBackupThirdAppModuleTask", "tempModulesList is null");
            return;
        }
        ArrayList arrayList = new ArrayList(listM78397u);
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
            Optional<BackupOptionItem> optionalFindFirst = listM78397u.stream().filter(new Predicate() { // from class: zd.u2
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return C14273v2.m85095g(str, (BackupOptionItem) obj);
                }
            }).findFirst();
            if (!optionalFindFirst.isPresent()) {
                C11839m.m70688i("TempBackupThirdAppModuleTask", "firstItem is null");
            } else if (optionalFindFirst.get().getBackupSwitch()) {
                C11839m.m70688i("TempBackupThirdAppModuleTask", "backupSwitch is true,not need deal");
            } else {
                List<BackupOptionItem> list = (List) map.get(str);
                if (list == null) {
                    C11839m.m70688i("TempBackupThirdAppModuleTask", "splitItems is null");
                } else {
                    for (BackupOptionItem backupOptionItem2 : list) {
                        c14229k2.m78377L(false, backupOptionItem2.getAppId(), backupOptionItem2.getOperateType(), Long.valueOf(backupOptionItem2.getOperateTime()));
                    }
                }
            }
        }
    }

    /* renamed from: f */
    private BackupOptionItem m85094f(String str, int i10, String str2, String str3) throws C9721b {
        BackupOptionItem backupOptionItemQueryItem = TransferedUtil.queryItem(str, i10, this.f63486a);
        if (backupOptionItemQueryItem == null) {
            backupOptionItemQueryItem = new BackupOptionItem(str, "thirdAppData");
            backupOptionItemQueryItem.setUid(i10);
            backupOptionItemQueryItem.setSplitApkType(str2);
            backupOptionItemQueryItem.setOriBackupAppName(str3);
            this.f63486a.m78370E(backupOptionItemQueryItem);
        }
        if (backupOptionItemQueryItem.getOperateType() != 1) {
            backupOptionItemQueryItem.setBackupSwitch(this.f63492g.contains(str));
            this.f63486a.m78377L(backupOptionItemQueryItem.getBackupSwitch(), str, backupOptionItemQueryItem.getOperateType(), null);
        }
        return backupOptionItemQueryItem;
    }

    /* renamed from: g */
    public static /* synthetic */ boolean m85095g(String str, BackupOptionItem backupOptionItem) {
        return str.equals(backupOptionItem.getAppId());
    }

    private void getThirdAppDataModule() throws C9721b, PackageManager.NameNotFoundException {
        C11839m.m70688i("TempBackupThirdAppModuleTask", "getThirdAppDataModule enter");
        Bundle backupModuleInfo = this.f63487b.getBackupModuleInfo("app", false);
        if (backupModuleInfo == null) {
            C11839m.m70688i("TempBackupThirdAppModuleTask", "app bundle is null");
            return;
        }
        Object objM63680b = new C10343b(backupModuleInfo).m63680b("app");
        if (!(objM63680b instanceof Bundle)) {
            C11839m.m70688i("TempBackupThirdAppModuleTask", "app value is null or not instanceof bundle");
            return;
        }
        ArrayList<String> arrayListM63696r = new C10343b((Bundle) objM63680b).m63696r("AppPackageList");
        if (arrayListM63696r == null) {
            arrayListM63696r = new ArrayList<>();
        }
        HashSet hashSet = new HashSet(arrayListM63696r);
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), "backup_clone_app_sp", 0);
        if (sharedPreferencesM1382b != null) {
            sharedPreferencesM1382b.edit().clear().apply();
            sharedPreferencesM1382b.edit().putStringSet("backup_clone_third_app_list", hashSet).apply();
        }
        arrayListM63696r.removeAll(this.f63490e);
        arrayListM63696r.removeAll(C12590s0.m75727B0());
        Map<String, C13219m<String, Integer, Integer>> mapInit3rdAppTwinsList = SplitAppUtil.init3rdAppTwinsList(arrayListM63696r, new Function() { // from class: zd.t2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f63477a.m85096h((String) obj);
            }
        });
        arrayListM63696r.addAll(mapInit3rdAppTwinsList.keySet());
        arrayListM63696r.removeAll(this.f63490e);
        List<String> listM78398v = this.f63486a.m78398v("thirdAppData");
        listM78398v.removeAll(arrayListM63696r);
        C11839m.m70688i("TempBackupThirdAppModuleTask", "wait delete app ids = " + Arrays.toString(listM78398v.toArray()));
        this.f63486a.m78387h(listM78398v);
        C11839m.m70688i("TempBackupThirdAppModuleTask", "getThirdAppDataModule exit");
        getThirdAppOptionsInfo(arrayListM63696r, mapInit3rdAppTwinsList);
        this.f63491f.addAll(arrayListM63696r);
    }

    private void getThirdAppOptionsInfo(List<String> list, Map<String, C13219m<String, Integer, Integer>> map) throws C9721b, PackageManager.NameNotFoundException {
        String strValueOf;
        int iIntValue;
        String strM79449b;
        C11839m.m70688i("TempBackupThirdAppModuleTask", "begin getThirdAppOptionsInfo: " + Arrays.toString(list.toArray()));
        if (list.isEmpty()) {
            C11839m.m70689w("TempBackupThirdAppModuleTask", "app modules from clone is empty.");
            return;
        }
        PackageManager packageManager = C0213f.m1377a().getPackageManager();
        for (String str : list) {
            C13219m<String, Integer, Integer> c13219m = map.get(str);
            if (c13219m != null) {
                strM79449b = c13219m.m79449b();
                strValueOf = String.valueOf(c13219m.m79450c());
                iIntValue = c13219m.m79451d().intValue();
            } else {
                strValueOf = "0";
                iIntValue = 0;
                strM79449b = str;
            }
            boolean zM75158X0 = C12515a.m75110o().m75158X0(QueryOmAppBackupScopeTask.class.getName());
            while (zM75158X0) {
                SystemClock.sleep(500L);
                zM75158X0 = C12515a.m75110o().m75158X0(QueryOmAppBackupScopeTask.class.getName());
                C11839m.m70689w("TempBackupThirdAppModuleTask", "wait QueryOmAppBackupScopeTask appId " + str);
            }
            long versionCode = ICBUtil.getVersionCode(packageManager, strM79449b);
            String appName = ICBUtil.getAppName(packageManager, strM79449b, strValueOf);
            if (new CloudBackupAppDataUtil(strM79449b, C12586r.m75711b(), versionCode, false, true).isAppDataAble() && PmsCheckUtil.m12611e()) {
                m85097j("thirdAppData", str, iIntValue, strValueOf, strM79449b, appName);
            } else {
                this.f63486a.m78386g(str);
            }
        }
        m85093e(this.f63486a);
        TempBackupDataManager.m24501i().m24505g(this.f63486a.m78399w("thirdAppData"));
        C11839m.m70688i("TempBackupThirdAppModuleTask", "app data module load end. ");
    }

    private void initConfig() {
        this.f63493h = C12534r.m75443g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.util.concurrent.CountDownLatch] */
    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        C11839m.m70688i("TempBackupThirdAppModuleTask", "TempBackupThirdAppModuleTask start");
        try {
            try {
                initConfig();
                getThirdAppDataModule();
                new C14204e1(this.f63489d).run();
                new C14186a().run();
            } catch (C9721b e10) {
                C11839m.m70687e("TempBackupThirdAppModuleTask", "TempBackupThirdAppModuleTask error: " + e10.getMessage());
            }
        } finally {
            C11839m.m70688i("TempBackupThirdAppModuleTask", "TempBackupThirdAppModuleTask end");
            this.f63488c.countDown();
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.OPTIONS_SIZE_TASK;
    }

    /* renamed from: h */
    public final /* synthetic */ Boolean m85096h(String str) {
        return Boolean.valueOf(this.f63493h.m75451m(str, "3"));
    }

    /* renamed from: j */
    public final void m85097j(String str, String str2, int i10, String str3, String str4, String str5) throws C9721b {
        if (SplitAppUtil.isSplitApp(str3)) {
            this.f63486a.m78369D(str, str2, i10, str3, str4, str5, this.f63492g.contains(str2));
            return;
        }
        BackupOptionItem backupOptionItemM85094f = m85094f(str2, i10, str3, str4);
        backupOptionItemM85094f.setParent(str);
        backupOptionItemM85094f.setBackupData(true);
        if (!TextUtils.isEmpty(str5)) {
            str2 = str5;
        }
        backupOptionItemM85094f.setAppName(str2);
        this.f63486a.m78382Q(backupOptionItemM85094f);
        C11839m.m70688i("TempBackupThirdAppModuleTask", "appId: " + backupOptionItemM85094f.getAppId() + " match om config, backup app data. ");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getThirdAppOptionsInfo");
        sb2.append(new Gson().toJson(backupOptionItemM85094f));
        C11839m.m70688i("TempBackupThirdAppModuleTask", sb2.toString());
    }
}
