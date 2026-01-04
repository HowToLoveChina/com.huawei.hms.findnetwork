package p840zd;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import com.google.gson.Gson;
import com.huawei.android.hicloud.cloudbackup.bean.BackupAppSwitchStatusBean;
import com.huawei.android.hicloud.cloudbackup.process.CloneService;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.cloudbackup.util.TransferedUtil;
import com.huawei.android.hicloud.p088ui.temporarybackup.TempBackupDataManager;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.constants.HNConstants;
import fk.C9721b;
import hk.C10279b;
import hu.C10343b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import p015ak.C0209d;
import p015ak.C0213f;
import p510o5.C11818a;
import p514o9.C11829c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p618rm.C12582p1;
import p618rm.C12590s0;
import p848zl.C14333b;

/* renamed from: zd.s2 */
/* loaded from: classes3.dex */
public class C14261s2 extends AbstractC12367d {

    /* renamed from: a */
    public final C14229k2 f63466a = new C14229k2();

    /* renamed from: b */
    public final CloneService f63467b = CloneService.getInstance();

    /* renamed from: c */
    public final CountDownLatch f63468c;

    /* renamed from: d */
    public final List<String> f63469d;

    /* renamed from: e */
    public final Vector<String> f63470e;

    /* renamed from: f */
    public final List<BackupAppSwitchStatusBean> f63471f;

    public C14261s2(CountDownLatch countDownLatch, List<String> list, Vector<String> vector, List<BackupAppSwitchStatusBean> list2) {
        ArrayList arrayList = new ArrayList();
        this.f63469d = arrayList;
        this.f63468c = countDownLatch;
        arrayList.addAll(list);
        this.f63470e = vector;
        this.f63471f = list2;
    }

    private BackupOptionItem generateSysItem(String str, String str2) throws C9721b {
        BackupOptionItem backupOptionItemQueryItem = TransferedUtil.queryItem(str2, this.f63466a);
        if (backupOptionItemQueryItem == null) {
            backupOptionItemQueryItem = new BackupOptionItem(str2, str);
            BackupOptionItem backupOptionItemQueryItem2 = TransferedUtil.queryItem(str, this.f63466a);
            if (backupOptionItemQueryItem2 != null) {
                backupOptionItemQueryItem.setOperateType(backupOptionItemQueryItem2.getOperateType());
            }
            backupOptionItemQueryItem.setBackupSwitch(true);
            this.f63466a.m78370E(backupOptionItemQueryItem);
        }
        return backupOptionItemQueryItem;
    }

    private List<String> getChildModuleList(String str) throws C9721b {
        ArrayList arrayList = new ArrayList();
        Context contextM1377a = C0213f.m1377a();
        if (HNConstants.DataType.CONTACT.equals(str)) {
            if (C11829c.m70546T0(contextM1377a)) {
                arrayList.add(str);
            }
        } else if ("HuaweiHiAi".equals(str)) {
            if (!C11818a.m70390h0(contextM1377a)) {
                arrayList.add(str);
            }
        } else if ("HiCreate".equals(str)) {
            if (C0209d.m1184K0(contextM1377a, "com.huawei.hicreate")) {
                arrayList.add(str);
            }
        } else if (NavigationUtils.SMS_SCHEMA_PREF.equals(str)) {
            if (C11829c.m70523I0(contextM1377a)) {
                arrayList.add(NavigationUtils.SMS_SCHEMA_PREF);
                arrayList.add("chatSms");
            }
        } else if ("calllog".equals(str)) {
            if (C11829c.m70546T0(contextM1377a)) {
                arrayList.add(str);
            }
        } else if ("soundrecorder".equals(str)) {
            arrayList.add("soundrecorder");
            if (C11829c.m70546T0(contextM1377a)) {
                arrayList.add("callRecorder");
            }
        } else if ("baseData".equals(str)) {
            ArrayList arrayList2 = new ArrayList(C14333b.m85482q());
            if (!C11829c.m70546T0(contextM1377a)) {
                arrayList2.remove("harassment");
            }
            final List<String> listM75727B0 = C12590s0.m75727B0();
            arrayList.addAll((Collection) arrayList2.parallelStream().filter(new Predicate() { // from class: zd.r2
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return this.f63461a.m85090e(listM75727B0, (String) obj);
                }
            }).collect(Collectors.toList()));
        } else {
            arrayList.add(str);
        }
        C11839m.m70688i("TempBackupSystemModuleTask", " clone  getChildModuleList: " + arrayList.toString());
        return arrayList;
    }

    private BackupOptionItem getSystemOptionsInfo(String str, String str2, Bundle bundle) throws C9721b {
        int iM63686h;
        BackupOptionItem backupOptionItemGenerateSysItem = generateSysItem(str, str2);
        long jM63688j = 0;
        boolean zM63681c = false;
        if (bundle == null && !str2.equals(HNConstants.DataType.CONTACT)) {
            C11839m.m70688i("TempBackupSystemModuleTask", "bundle is null, not support clone, appId: " + str2);
            if ("chatSms".equals(str2)) {
                backupOptionItemGenerateSysItem.setItemTotal(0);
                backupOptionItemGenerateSysItem.setDataBytes(0L);
            }
            backupOptionItemGenerateSysItem.setIsDataEnable(-1);
            return backupOptionItemGenerateSysItem;
        }
        C10343b c10343b = new C10343b(bundle);
        if (HNConstants.DataType.CONTACT.equals(str2)) {
            Iterator<String> it = c10343b.m63697s().iterator();
            iM63686h = 0;
            while (it.hasNext()) {
                Bundle bundleM63684f = c10343b.m63684f(it.next());
                if (bundleM63684f != null) {
                    C10343b c10343b2 = new C10343b(bundleM63684f);
                    if ("Phone".equals(c10343b2.m63694p("AccountName"))) {
                        iM63686h = c10343b2.m63686h("ModuleCount");
                        jM63688j = c10343b2.m63688j("ModuleSize");
                    }
                }
            }
        } else {
            zM63681c = c10343b.m63681c("isSupportClone");
            iM63686h = c10343b.m63686h("ModuleCount");
            jM63688j = c10343b.m63688j("ModuleSize");
        }
        C11839m.m70688i("TempBackupSystemModuleTask", "getSystemOptionsInfo, appId: " + str2 + " isSupportClone:" + zM63681c + ", count: " + iM63686h + ", data size: " + jM63688j);
        backupOptionItemGenerateSysItem.setParent(str);
        backupOptionItemGenerateSysItem.setItemTotal(iM63686h);
        backupOptionItemGenerateSysItem.setDataBytes(jM63688j);
        backupOptionItemGenerateSysItem.setIsDataEnable(2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getSystemOptionsInfo");
        sb2.append(new Gson().toJson(backupOptionItemGenerateSysItem));
        C11839m.m70688i("TempBackupSystemModuleTask", sb2.toString());
        return backupOptionItemGenerateSysItem;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        C11839m.m70688i("TempBackupSystemModuleTask", "TempBackupSystemModuleTask start");
        try {
            try {
                for (String str : C14333b.m85457M()) {
                    List<String> childModuleList = getChildModuleList(str);
                    if (!childModuleList.isEmpty()) {
                        m85089d(str, childModuleList);
                    }
                    BackupOptionItem backupOptionItemQueryParentItem = ICBUtil.queryParentItem(str, this.f63466a);
                    C11839m.m70688i("TempBackupSystemModuleTask", "parentItem: " + backupOptionItemQueryParentItem.getAppId() + ", data enable: " + backupOptionItemQueryParentItem.isDataEnable());
                    TempBackupDataManager.m24501i().m24504f(backupOptionItemQueryParentItem);
                    this.f63470e.addAll(childModuleList);
                }
                initMusicSize();
                TempBackupDataManager.m24501i().m24504f(ICBUtil.queryParentItem("music", this.f63466a));
                this.f63470e.add("music");
                initGallerySize();
                TempBackupDataManager.m24501i().m24504f(ICBUtil.queryParentItem(HNConstants.DataType.MEDIA, this.f63466a));
                this.f63470e.add(HNConstants.DataType.MEDIA);
            } catch (C9721b e10) {
                C11839m.m70687e("TempBackupSystemModuleTask", "TempBackupSystemModuleTask error: " + e10.getMessage());
            }
            C11839m.m70688i("TempBackupSystemModuleTask", "TempBackupSystemModuleTask end");
            this.f63468c.countDown();
        } catch (Throwable th2) {
            C11839m.m70688i("TempBackupSystemModuleTask", "TempBackupSystemModuleTask end");
            this.f63468c.countDown();
            throw th2;
        }
    }

    /* renamed from: d */
    public final void m85089d(String str, List<String> list) throws C9721b {
        C11839m.m70688i("TempBackupSystemModuleTask", "get system item list: " + Arrays.toString(list.toArray()));
        for (String str2 : list) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            C11839m.m70688i("TempBackupSystemModuleTask", "appId: " + str2);
            Bundle backupModuleInfo = this.f63467b.getBackupModuleInfo(str2, false);
            if (backupModuleInfo == null) {
                C11839m.m70688i("TempBackupSystemModuleTask", "get backup module info from clone is time out, appId: " + str2);
                backupModuleInfo = new Bundle();
            }
            BackupOptionItem systemOptionsInfo = getSystemOptionsInfo(str, str2, new C10343b(backupModuleInfo).m63684f(str2));
            this.f63466a.m78382Q(systemOptionsInfo);
            if (!C14333b.m85457M().contains(systemOptionsInfo.getAppId())) {
                TempBackupDataManager.m24501i().m24504f(systemOptionsInfo);
            }
            CloudBackupReport.collectModuleInfo(this.f63471f, str2, systemOptionsInfo, jCurrentTimeMillis);
            C11839m.m70688i("TempBackupSystemModuleTask", "appId: " + str2 + ", get system item from module info end");
        }
    }

    /* renamed from: e */
    public final /* synthetic */ boolean m85090e(List list, String str) {
        return (this.f63469d.contains(str) || list.contains(str)) ? false : true;
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.OPTIONS_SIZE_TASK;
    }

    public String getLocation() {
        return C10279b.m63452a(C0213f.m1377a().getFilesDir());
    }

    public final void initGallerySize() throws Throwable {
        long jCurrentTimeMillis = System.currentTimeMillis();
        C11839m.m70688i("TempBackupSystemModuleTask", "get GallerySize start.");
        Pair<Integer, Long> pairM75844e0 = C12590s0.m75844e0(false, true);
        BackupOptionItem backupOptionItemGenerateSysItem = generateSysItem(HNConstants.DataType.MEDIA, HNConstants.DataType.MEDIA);
        backupOptionItemGenerateSysItem.setParent(HNConstants.DataType.MEDIA);
        backupOptionItemGenerateSysItem.setDataBytes(((Long) pairM75844e0.second).longValue());
        backupOptionItemGenerateSysItem.setItemTotal(((Integer) pairM75844e0.first).intValue());
        backupOptionItemGenerateSysItem.setIsDataEnable(2);
        this.f63466a.m78382Q(backupOptionItemGenerateSysItem);
        CloudBackupReport.collectModuleInfo(this.f63471f, HNConstants.DataType.MEDIA, backupOptionItemGenerateSysItem, jCurrentTimeMillis);
        C11839m.m70688i("TempBackupSystemModuleTask", "get GallerySize end. gallery dataSize = " + backupOptionItemGenerateSysItem.getDataBytes() + "count = " + backupOptionItemGenerateSysItem.getItemTotal());
    }

    public final void initMusicSize() throws C9721b {
        int count;
        long size;
        C11839m.m70688i("TempBackupSystemModuleTask", "initMusicSize start.");
        long jCurrentTimeMillis = System.currentTimeMillis();
        C11839m.m70688i("TempBackupSystemModuleTask", "compute music size in v3 procedure");
        SnapshotBackupMeta snapshotBackupMetaM75634r = new C12582p1(getLocation(), C0213f.m1377a()).m75634r();
        if (snapshotBackupMetaM75634r != null) {
            count = (int) snapshotBackupMetaM75634r.getCount();
            size = snapshotBackupMetaM75634r.getSize();
        } else {
            count = 0;
            size = 0;
        }
        BackupOptionItem backupOptionItemGenerateSysItem = generateSysItem("music", "music");
        backupOptionItemGenerateSysItem.setParent("music");
        backupOptionItemGenerateSysItem.setDataBytes(size);
        backupOptionItemGenerateSysItem.setItemTotal(count);
        backupOptionItemGenerateSysItem.setIsDataEnable(2);
        this.f63466a.m78382Q(backupOptionItemGenerateSysItem);
        CloudBackupReport.collectModuleInfo(this.f63471f, "music", backupOptionItemGenerateSysItem, jCurrentTimeMillis);
        C11839m.m70688i("TempBackupSystemModuleTask", "initMusicSize end. music size = " + backupOptionItemGenerateSysItem.getDataBytes() + ", music count = " + backupOptionItemGenerateSysItem.getItemTotal() + ", time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }
}
