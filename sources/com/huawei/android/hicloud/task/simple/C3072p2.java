package com.huawei.android.hicloud.task.simple;

import android.content.Context;
import android.os.Message;
import android.os.SystemClock;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupOptionInfo;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupUserInfo;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.process.task.BackupModuleInfoQueryLogic;
import com.huawei.android.hicloud.cloudbackup.process.task.GetOptionsInfoFromCloneTask;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import fk.C9721b;
import il.C10542o;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import p015ak.C0213f;
import p015ak.C0241z;
import p514o9.C11829c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p617rl.C12519c;
import p617rl.C12526j;
import p618rm.C12541c;
import p618rm.C12585q1;
import p709vj.C13452e;
import p711vl.C13465e;
import p848zl.C14333b;
import pm.C12176c;
import tl.C13026e;

/* renamed from: com.huawei.android.hicloud.task.simple.p2 */
/* loaded from: classes3.dex */
public class C3072p2 extends AbstractC12367d {

    /* renamed from: g */
    public static final String f13357g = "p2";

    /* renamed from: a */
    public final boolean f13358a;

    /* renamed from: e */
    public List<String> f13362e = new ArrayList();

    /* renamed from: d */
    public Context f13361d = C0213f.m1377a().getApplicationContext();

    /* renamed from: b */
    public C13465e f13359b = C13465e.m81052f();

    /* renamed from: c */
    public C13026e f13360c = new C13026e();

    /* renamed from: f */
    public boolean f13363f = ICBUtil.isSupportGallery(this.f13361d);

    public C3072p2(boolean z10) {
        this.f13358a = z10;
    }

    /* renamed from: g */
    private void m18374g(CloudBackupOptionInfo cloudBackupOptionInfo) {
        if (C13452e.m80781L().m80887a1()) {
            C11839m.m70688i(f13357g, "New business, filter AppOptionInfo.");
            final List<String> listM73271n = C12176c.m73271n(null);
            cloudBackupOptionInfo.getVirtualItemList().removeIf(new Predicate() { // from class: com.huawei.android.hicloud.task.simple.m2
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return C3072p2.m18376l(listM73271n, (BackupOptionItem) obj);
                }
            });
            cloudBackupOptionInfo.getThirdAppItemList().removeIf(new Predicate() { // from class: com.huawei.android.hicloud.task.simple.n2
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return C3072p2.m18377m(listM73271n, (BackupOptionItem) obj);
                }
            });
            cloudBackupOptionInfo.getSystemItemList().removeIf(new Predicate() { // from class: com.huawei.android.hicloud.task.simple.o2
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return C3072p2.m18378n(listM73271n, (BackupOptionItem) obj);
                }
            });
        }
    }

    /* renamed from: h */
    private List<String> m18375h() {
        final List<String> listM75386e = new C12526j().m75386e();
        ArrayList arrayList = new ArrayList(C14333b.m85482q());
        if (!C11829c.m70546T0(this.f13361d)) {
            arrayList.remove("harassment");
        }
        return (List) arrayList.parallelStream().filter(new Predicate() { // from class: com.huawei.android.hicloud.task.simple.l2
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C3072p2.m18379o(listM75386e, (String) obj);
            }
        }).collect(Collectors.toList());
    }

    /* renamed from: l */
    public static /* synthetic */ boolean m18376l(List list, BackupOptionItem backupOptionItem) {
        return list.contains(backupOptionItem.getAppId());
    }

    /* renamed from: m */
    public static /* synthetic */ boolean m18377m(List list, BackupOptionItem backupOptionItem) {
        return list.contains(backupOptionItem.getAppId());
    }

    /* renamed from: n */
    public static /* synthetic */ boolean m18378n(List list, BackupOptionItem backupOptionItem) {
        return list.contains(backupOptionItem.getAppId()) || "baseData".equals(backupOptionItem.getAppId());
    }

    /* renamed from: o */
    public static /* synthetic */ boolean m18379o(List list, String str) {
        return !list.contains(str);
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        C12585q1.m75691a(f13357g);
        long jM81056d = this.f13359b.m81056d(false);
        long jCurrentTimeMillis = System.currentTimeMillis() - jM81056d;
        boolean zM75158X0 = C12515a.m75110o().m75158X0(GetOptionsInfoFromCloneTask.class.getName());
        int i10 = 0;
        while (zM75158X0 && !GetOptionsInfoFromCloneTask.isOptionTaskInitAppDataEnd()) {
            SystemClock.sleep(1000L);
            i10++;
            if (i10 >= 3) {
                break;
            }
        }
        if (jCurrentTimeMillis < 604800000 || zM75158X0) {
            C11839m.m70688i(f13357g, "option items in sp is valid, no need to scan files, lastTime: " + jM81056d);
            m18381k();
        } else {
            C11839m.m70688i(f13357g, "option items in sp is invalid, lastTime: " + jM81056d + " , millis: " + jCurrentTimeMillis);
            m18380j();
        }
        CloudBackupUserInfo cloudBackupUserInfoM64691s1 = null;
        if (!this.f13358a) {
            sendMessageToUI(33033, null);
            C11839m.m70686d(f13357g, "no need get options info from clone task.");
            return;
        }
        try {
            cloudBackupUserInfoM64691s1 = new C10542o().m64691s1();
        } catch (Exception e10) {
            C11839m.m70687e(f13357g, "ShowBackupOptionListTask,  queryLastRecordDetails e : " + e10.getMessage());
        }
        C12515a.m75110o().m75172d(new GetOptionsInfoFromCloneTask(false, cloudBackupUserInfoM64691s1));
        C11839m.m70688i(f13357g, "ShowBackupOptionListTask end.");
    }

    /* renamed from: j */
    public final void m18380j() {
        String str = f13357g;
        C11839m.m70688i(str, "initOptionShow");
        CloudBackupOptionInfo appOptionInfo = new BackupModuleInfoQueryLogic(this.f13361d, false, BackupModuleInfoQueryLogic.BackupType.STANDARD, str).getAppOptionInfo();
        m18374g(appOptionInfo);
        sendMessageToUI(33008, appOptionInfo);
    }

    /* renamed from: k */
    public final void m18381k() throws C9721b {
        List<BackupOptionItem> listM78397u = this.f13360c.m78397u();
        if (listM78397u == null || listM78397u.isEmpty()) {
            C11839m.m70688i(f13357g, "no option cache, init option show");
            m18380j();
            return;
        }
        C11839m.m70688i(f13357g, "initOptionShowFromCache");
        ArrayList arrayList = new ArrayList();
        List<String> listM75487b = C12541c.m75487b(false, null, true, C14333b.m85449E());
        ArrayList arrayList2 = new ArrayList();
        C12519c c12519c = new C12519c();
        List<String> listM75297h = c12519c.m75297h(1);
        this.f13362e = listM75297h;
        boolean zContains = listM75297h.contains("music");
        List<String> listM73271n = C13452e.m80781L().m80887a1() ? C12176c.m73271n(null) : null;
        for (String str : listM75487b) {
            BackupOptionItem backupOptionItemQueryParentItem = ICBUtil.queryParentItem(str, false);
            if (str.equals("music") && zContains) {
                backupOptionItemQueryParentItem.setParent("virtualApp");
            }
            if (listM73271n != null && "baseData".equals(str)) {
                for (String str2 : m18375h()) {
                    if (!listM73271n.contains(str2)) {
                        BackupOptionItem backupOptionItemM78401y = this.f13360c.m78401y(str2);
                        if (backupOptionItemM78401y == null) {
                            C11839m.m70688i(f13357g, "childItem is null, appId: " + str2);
                        } else {
                            arrayList.add(backupOptionItemM78401y);
                            C11839m.m70688i(f13357g, "add child item: " + backupOptionItemM78401y.getAppId() + ", switch: " + backupOptionItemM78401y.getBackupSwitch());
                        }
                    }
                }
            }
            arrayList.add(backupOptionItemQueryParentItem);
        }
        this.f13362e.removeAll(C14333b.m85476k());
        String str3 = this.f13361d.getFilesDir() + "/cloudbackup";
        for (String str4 : this.f13362e) {
            if (new CloudBackupAppDataUtil(str4, str3, 0L, false, false).isAppDataAble()) {
                BackupOptionItem backupOptionItemM78401y2 = this.f13360c.m78401y(str4);
                if (backupOptionItemM78401y2 == null) {
                    backupOptionItemM78401y2 = new BackupOptionItem(str4, "virtualApp");
                    backupOptionItemM78401y2.setBackupSwitch(true);
                    backupOptionItemM78401y2.setBackupData(true);
                }
                backupOptionItemM78401y2.setShowType(C0241z.m1685c(c12519c.m75305p(str4)));
                arrayList2.add(backupOptionItemM78401y2);
            }
        }
        if (zContains) {
            this.f13362e.add("music");
        }
        CloudBackupOptionInfo cloudBackupOptionInfo = new CloudBackupOptionInfo();
        cloudBackupOptionInfo.setCacheData(true);
        cloudBackupOptionInfo.setSystemItemList(arrayList);
        cloudBackupOptionInfo.setVirtualItemList(arrayList2);
        cloudBackupOptionInfo.setAppDataModule(ICBUtil.queryAppDataItem(false));
        cloudBackupOptionInfo.setThirdAppItemList(this.f13360c.m78399w("thirdAppData"));
        cloudBackupOptionInfo.setVirtuals(this.f13362e);
        m18374g(cloudBackupOptionInfo);
        sendMessageToUI(33008, cloudBackupOptionInfo);
    }

    public final void sendMessageToUI(int i10, Object obj) {
        Message message = new Message();
        message.what = i10;
        if (obj != null) {
            message.obj = obj;
        }
        CBCallBack.getInstance().sendMessage(message);
    }
}
