package com.huawei.android.hicloud.p088ui.temporarybackup;

import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.process.task.C2575c0;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupLanguageUtil;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import p015ak.C0213f;
import p015ak.C0226l0;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p618rm.C12580p;
import p618rm.C12590s0;
import p815ym.AbstractC14026a;
import p840zd.C14189a2;
import p840zd.C14225j2;
import p840zd.C14229k2;
import p848zl.C14333b;

/* loaded from: classes3.dex */
public class TempBackupDataManager {

    /* renamed from: d */
    public static final Object f18392d = new Object();

    /* renamed from: a */
    public final Set<CallBack> f18393a;

    /* renamed from: b */
    public volatile List<BackupOptionItem> f18394b;

    /* renamed from: c */
    public long f18395c;

    public interface CallBack {
        /* renamed from: a */
        void mo24516a(BackupOptionItem backupOptionItem, int i10);

        /* renamed from: b */
        void mo24517b(List<BackupOptionItem> list, long j10);
    }

    /* renamed from: com.huawei.android.hicloud.ui.temporarybackup.TempBackupDataManager$a */
    public class C4002a extends AbstractC12367d {
        public C4002a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C12590s0.m75735D0();
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.TEMP_BACKUP;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.temporarybackup.TempBackupDataManager$b */
    public class C4003b extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ CallBack f18397a;

        public C4003b(CallBack callBack) {
            this.f18397a = callBack;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e */
        public /* synthetic */ int m24520e(BackupOptionItem backupOptionItem, BackupOptionItem backupOptionItem2) {
            return TempBackupDataManager.this.m24511o(backupOptionItem, backupOptionItem2);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            synchronized (TempBackupDataManager.f18392d) {
                TempBackupDataManager.this.f18394b.sort(new Comparator() { // from class: zd.b1
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return this.f63365a.m24520e((BackupOptionItem) obj, (BackupOptionItem) obj2);
                    }
                });
                final CallBack callBack = this.f18397a;
                C0226l0.m1586f(new Runnable() { // from class: zd.c1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f63369a.m24521f(callBack);
                    }
                });
            }
        }

        /* renamed from: f */
        public final /* synthetic */ void m24521f(CallBack callBack) {
            callBack.mo24517b(TempBackupDataManager.this.f18394b, 0L);
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.TEMP_BACKUP;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.temporarybackup.TempBackupDataManager$c */
    public static class C4004c {

        /* renamed from: a */
        public static final TempBackupDataManager f18399a = new TempBackupDataManager(null);
    }

    public /* synthetic */ TempBackupDataManager(C4002a c4002a) {
        this();
    }

    /* renamed from: i */
    public static TempBackupDataManager m24501i() {
        return C4004c.f18399a;
    }

    /* renamed from: r */
    public static int m24503r(List<BackupOptionItem> list, BackupOptionItem backupOptionItem) {
        for (BackupOptionItem backupOptionItem2 : list) {
            if (backupOptionItem != null && backupOptionItem2.getAppId() != null && TextUtils.equals(backupOptionItem2.getAppId(), backupOptionItem.getAppId())) {
                int iIndexOf = list.indexOf(backupOptionItem2);
                backupOptionItem2.setAppName(backupOptionItem.getAppName());
                backupOptionItem2.setParent(backupOptionItem.getParent());
                backupOptionItem2.setDisable(backupOptionItem.isDisable());
                backupOptionItem2.setBackupData(backupOptionItem.isBackupData());
                backupOptionItem2.setIsDataEnable(backupOptionItem.getIsDataEnable());
                backupOptionItem2.setCodeBytes(backupOptionItem.getCodeBytes());
                backupOptionItem2.setDataBytes(backupOptionItem.getDataBytes());
                backupOptionItem2.setSwitchCount(backupOptionItem.getSwitchCount());
                backupOptionItem2.setItemTotal(backupOptionItem.getItemTotal());
                backupOptionItem2.setTotalIncrease(backupOptionItem.getTotalIncrease());
                backupOptionItem2.setCurrentIncrease(backupOptionItem.getCurrentIncrease());
                backupOptionItem2.setData1(backupOptionItem.getData1());
                backupOptionItem2.setLoadDataSucceed(backupOptionItem.isLoadDataSucceed());
                backupOptionItem2.setSplitApkType(backupOptionItem.getSplitApkType());
                backupOptionItem2.setOriBackupAppName(backupOptionItem.getOriBackupAppName());
                return iIndexOf;
            }
        }
        return -1;
    }

    /* renamed from: f */
    public void m24504f(final BackupOptionItem backupOptionItem) {
        C11839m.m70688i("TempBackupDataManager", "callbackDataItem enter, backupOptionItem: " + backupOptionItem.toString());
        synchronized (f18392d) {
            try {
                C11839m.m70688i("TempBackupDataManager", "callbackDataItem start");
                backupOptionItem.setLoadDataSucceed(true);
                final int iM24503r = m24503r(this.f18394b, backupOptionItem);
                for (final CallBack callBack : this.f18393a) {
                    if (callBack != null) {
                        C0226l0.m1586f(new Runnable() { // from class: zd.y0
                            @Override // java.lang.Runnable
                            public final void run() {
                                callBack.mo24516a(backupOptionItem, iM24503r);
                            }
                        });
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: g */
    public void m24505g(List<BackupOptionItem> list) {
        C11839m.m70688i("TempBackupDataManager", "callbackDataItems enter, thirdAppDatas: " + Arrays.toString(list.toArray()));
        synchronized (f18392d) {
            C11839m.m70688i("TempBackupDataManager", "callbackDataItems start");
            m24514s(list);
        }
    }

    /* renamed from: h */
    public List<BackupOptionItem> m24506h() {
        return this.f18394b;
    }

    /* renamed from: j */
    public void m24507j(CallBack callBack) {
        C11839m.m70688i("TempBackupDataManager", "getTempBackupData enter, callback: " + callBack);
        synchronized (f18392d) {
            try {
                C11839m.m70688i("TempBackupDataManager", "getTempBackupData start");
                if (callBack != null) {
                    this.f18393a.add(callBack);
                }
                boolean zM75158X0 = C12515a.m75110o().m75158X0(C14225j2.class.getName());
                boolean zM75158X02 = C12515a.m75110o().m75158X0(C14189a2.class.getName());
                if (!zM75158X0 && !zM75158X02) {
                    C12515a.m75110o().m75172d(new C14225j2());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (callBack == null || AbstractC14026a.m84159a(this.f18394b)) {
            return;
        }
        this.f18395c = 0L;
        C12515a.m75110o().m75172d(new C4003b(callBack));
    }

    /* renamed from: k */
    public void m24508k() {
        C11839m.m70688i("TempBackupDataManager", "initTempBackupData enter");
        m24501i().m24507j(null);
        C12515a.m75110o().m75172d(new C4002a());
    }

    /* renamed from: m */
    public final /* synthetic */ void m24509m(C14229k2 c14229k2, BackupOptionItem backupOptionItem) {
        BackupOptionItem backupOptionItemM78401y = c14229k2.m78401y(backupOptionItem.getAppId());
        if (backupOptionItemM78401y != null) {
            backupOptionItem.setBackupSwitch(backupOptionItemM78401y.getBackupSwitch());
            backupOptionItem.setOperateTime(backupOptionItemM78401y.getOperateTime());
            backupOptionItem.setOperateType(backupOptionItemM78401y.getOperateType());
        }
        this.f18395c += backupOptionItem.getCodeBytes() + backupOptionItem.getDataBytes();
    }

    /* renamed from: n */
    public final /* synthetic */ void m24510n(CallBack callBack, List list) {
        callBack.mo24517b(list, this.f18395c);
    }

    /* renamed from: o */
    public int m24511o(BackupOptionItem backupOptionItem, BackupOptionItem backupOptionItem2) {
        if (TextUtils.equals(backupOptionItem.getAppId(), "baseData")) {
            return -1;
        }
        if (TextUtils.equals(backupOptionItem2.getAppId(), "baseData")) {
            return 1;
        }
        return C12580p.m75566D(backupOptionItem, backupOptionItem2);
    }

    /* renamed from: p */
    public void m24512p(List<BackupOptionItem> list) {
        if (!AbstractC14026a.m84159a(list)) {
            this.f18394b = list;
        }
        final C14229k2 c14229k2 = new C14229k2();
        this.f18394b.forEach(new Consumer() { // from class: zd.x0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f63502a.m24509m(c14229k2, (BackupOptionItem) obj);
            }
        });
        C11839m.m70688i("TempBackupDataManager", "queryComplete enter totalSize: " + this.f18395c + ", size: " + this.f18394b.size());
        m24513q(this.f18394b);
    }

    /* renamed from: q */
    public void m24513q(final List<BackupOptionItem> list) {
        C11839m.m70688i("TempBackupDataManager", "refreshData enter, backupOptionItemList: " + Arrays.toString(list.toArray()));
        synchronized (f18392d) {
            try {
                C11839m.m70688i("TempBackupDataManager", "refreshData start");
                this.f18394b = list;
                for (BackupOptionItem backupOptionItem : this.f18394b) {
                    if (TextUtils.isEmpty(backupOptionItem.getAppName())) {
                        String appId = backupOptionItem.getAppId();
                        if (backupOptionItem.getParent().equals("virtualApp")) {
                            backupOptionItem.setAppName(CloudBackupLanguageUtil.getVirtualName(appId));
                        } else if (C14333b.m85483r().containsKey(appId)) {
                            backupOptionItem.setAppName(C2783d.m16079E(C0213f.m1377a(), appId));
                        } else {
                            backupOptionItem.setAppName(C14333b.f63653e.containsKey(appId) ? C2783d.m16079E(C0213f.m1377a(), appId) : C12590s0.m75884o0(backupOptionItem, new C14229k2(), C0213f.m1377a()));
                        }
                    }
                }
                this.f18394b.sort(new Comparator() { // from class: zd.z0
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return this.f63511a.m24511o((BackupOptionItem) obj, (BackupOptionItem) obj2);
                    }
                });
                for (final CallBack callBack : this.f18393a) {
                    if (callBack != null) {
                        C0226l0.m1586f(new Runnable() { // from class: zd.a1
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f63355a.m24510n(callBack, list);
                            }
                        });
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: s */
    public void m24514s(List<BackupOptionItem> list) {
        if (AbstractC14026a.m84159a(list)) {
            C11839m.m70688i("TempBackupDataManager", "thirdAppDatas is empty");
            return;
        }
        List list2 = (List) list.stream().map(new C2575c0()).collect(Collectors.toList());
        Iterator<BackupOptionItem> it = this.f18394b.iterator();
        while (it.hasNext()) {
            BackupOptionItem next = it.next();
            if (list2.contains(next.getAppId())) {
                it.remove();
            } else if ("thirdAppData".equals(next.getParent()) && !list2.contains(next.getAppId())) {
                it.remove();
            }
        }
        this.f18394b.addAll(list);
    }

    /* renamed from: t */
    public void m24515t(CallBack callBack) {
        this.f18393a.remove(callBack);
    }

    public TempBackupDataManager() {
        this.f18393a = new LinkedHashSet();
        this.f18394b = new ArrayList();
        this.f18395c = 0L;
    }
}
