package pm;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.android.hicloud.cloudbackup.process.task.C2575c0;
import com.huawei.android.hicloud.cloudbackup.process.task.C2612y;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupLanguageUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.base.bean.SyncItemInfo;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.request.basic.bean.CloudValuableAppDataBean;
import com.huawei.secure.android.common.util.SafeBase64;
import fk.C9721b;
import gp.C10028c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import p020ap.C1006a;
import p020ap.C1008c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p618rm.C12590s0;
import p618rm.C12597u1;
import p709vj.C13452e;
import p783xp.C13843a;
import p840zd.C14229k2;
import p848zl.C14333b;
import tl.C13026e;

/* renamed from: pm.w */
/* loaded from: classes6.dex */
public class C12196w extends AbstractC12367d {

    /* renamed from: e */
    public static final List<String> f56564e = Arrays.asList(NavigationUtils.SMS_SCHEMA_PREF, "thirdApp", "setting");

    /* renamed from: a */
    public final Map<String, Pair<Integer, Integer>> f56565a = C12597u1.m76027c();

    /* renamed from: b */
    public final c f56566b;

    /* renamed from: c */
    public final Context f56567c;

    /* renamed from: d */
    public int f56568d;

    /* renamed from: pm.w$b */
    public static class b implements Comparator<BackupOptionItem> {
        public b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(BackupOptionItem backupOptionItem, BackupOptionItem backupOptionItem2) {
            int iIndexOf = C12196w.f56564e.indexOf(backupOptionItem.getAppId());
            int iIndexOf2 = C12196w.f56564e.indexOf(backupOptionItem2.getAppId());
            if (iIndexOf == -1) {
                return 1;
            }
            if (iIndexOf2 == -1) {
                return -1;
            }
            return Integer.compare(iIndexOf, iIndexOf2);
        }
    }

    /* renamed from: pm.w$c */
    public interface c {
        /* renamed from: a */
        void mo65673a(CloudValuableAppDataBean cloudValuableAppDataBean);
    }

    public C12196w(Context context, c cVar, int i10) {
        this.f56567c = context;
        this.f56566b = cVar;
        this.f56568d = i10;
    }

    /* renamed from: r */
    public static /* synthetic */ void m73333r(BackupOptionItem backupOptionItem) {
        if (backupOptionItem.getAppId().equals("chatSms")) {
            backupOptionItem.setAppId(NavigationUtils.SMS_SCHEMA_PREF);
        } else if (backupOptionItem.getAppId().equals("callRecorder")) {
            backupOptionItem.setAppId("soundrecorder");
        }
    }

    /* renamed from: s */
    public static /* synthetic */ BackupOptionItem m73334s(BackupOptionItem backupOptionItem) {
        return backupOptionItem;
    }

    /* renamed from: t */
    public static /* synthetic */ BackupOptionItem m73335t(BackupOptionItem backupOptionItem, BackupOptionItem backupOptionItem2) {
        backupOptionItem.setDataBytes(backupOptionItem.getDataBytes() + backupOptionItem2.getDataBytes());
        return backupOptionItem;
    }

    /* renamed from: u */
    public static /* synthetic */ boolean m73336u(List list, BackupOptionItem backupOptionItem) {
        return backupOptionItem.getBackupSwitch() && !list.contains(backupOptionItem.getAppId());
    }

    /* renamed from: v */
    public static /* synthetic */ boolean m73337v(List list, BackupOptionItem backupOptionItem) {
        return list.contains(backupOptionItem.getAppId()) || ("thirdApp".equals(backupOptionItem.getAppId()) && list.contains("applistStrategy"));
    }

    /* renamed from: y */
    public static /* synthetic */ boolean m73338y(List list, BackupOptionItem backupOptionItem) {
        return !list.contains(backupOptionItem);
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        if (this.f56567c == null) {
            C11839m.m70689w("CloudValuableDataTask", "context is null");
            m73342o(null);
            return;
        }
        boolean z10 = this.f56568d == 0;
        ArrayList<CloudValuableAppDataBean.AppInfo> arrayList = new ArrayList<>(this.f56568d);
        CloudValuableAppDataBean cloudValuableAppDataBean = new CloudValuableAppDataBean();
        final List<String> listM6037B = C1008c.m6035v().m6037B(this.f56567c);
        final List<SyncItemInfo> arrayList2 = new ArrayList<>();
        final List<SyncItemInfo> arrayList3 = new ArrayList<>();
        final C10028c c10028cM62183d0 = C10028c.m62183d0(this.f56567c);
        for (Map.Entry<String, Pair<Integer, Integer>> entry : this.f56565a.entrySet()) {
            String key = entry.getKey();
            if ("atlas".equals(key) ? C1006a.m5936k().m5975v(this.f56567c) : c10028cM62183d0.m62388s(key)) {
                SyncItemInfo syncItemInfo = new SyncItemInfo();
                syncItemInfo.setId(key);
                syncItemInfo.setChecked(true);
                syncItemInfo.setTitle(this.f56567c.getString(((Integer) entry.getValue().first).intValue()));
                syncItemInfo.setImage(this.f56567c.getDrawable(((Integer) entry.getValue().second).intValue()));
                if (listM6037B.contains(key)) {
                    arrayList2.add(syncItemInfo);
                } else {
                    arrayList3.add(syncItemInfo);
                }
            }
        }
        NotifyUtil.getShownSyncServiceItems(this.f56567c).forEach(new Consumer() { // from class: pm.p
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f56556a.m73344q(listM6037B, c10028cM62183d0, arrayList2, arrayList3, (SyncConfigService) obj);
            }
        });
        int size = arrayList2.size() + arrayList3.size();
        cloudValuableAppDataBean.setSyncBaseNum(arrayList3.size());
        cloudValuableAppDataBean.setSyncFullNum(arrayList2.size());
        boolean zM62330g1 = C10028c.m62182c0().m62330g1(C13452e.m80781L().m80790C());
        ArrayList arrayList4 = new ArrayList(((Map) new C13026e().m78397u().stream().peek(new Consumer() { // from class: pm.q
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C12196w.m73333r((BackupOptionItem) obj);
            }
        }).collect(Collectors.toMap(new C2575c0(), new Function() { // from class: pm.r
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return C12196w.m73334s((BackupOptionItem) obj);
            }
        }, new BinaryOperator() { // from class: pm.s
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return C12196w.m73335t((BackupOptionItem) obj, (BackupOptionItem) obj2);
            }
        }))).values());
        final List<String> listM76026b = C12597u1.m76026b();
        final List<String> listM73271n = C12176c.m73271n(null);
        List list = (List) arrayList4.stream().filter(new Predicate() { // from class: pm.t
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C12196w.m73336u(listM76026b, (BackupOptionItem) obj);
            }
        }).collect(Collectors.toList());
        final List list2 = (List) list.stream().filter(new Predicate() { // from class: pm.u
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C12196w.m73337v(listM73271n, (BackupOptionItem) obj);
            }
        }).sorted(new b()).collect(Collectors.toList());
        List<BackupOptionItem> list3 = (List) list.stream().filter(new Predicate() { // from class: pm.v
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C12196w.m73338y(list2, (BackupOptionItem) obj);
            }
        }).sorted(Comparator.comparingLong(new C2612y()).reversed()).collect(Collectors.toList());
        if (zM62330g1) {
            cloudValuableAppDataBean.setBackupBaseNum(list2.size());
            size += list2.size();
        }
        cloudValuableAppDataBean.setBackupFullNum(list3.size());
        cloudValuableAppDataBean.setAppCount(size + list3.size());
        m73341n(z10, arrayList, arrayList2, arrayList3, list3);
        cloudValuableAppDataBean.setAppListTop(arrayList);
        m73342o(cloudValuableAppDataBean);
    }

    /* renamed from: l */
    public final boolean m73339l(boolean z10, ArrayList<CloudValuableAppDataBean.AppInfo> arrayList, List<BackupOptionItem> list, int i10) {
        if (z10) {
            return z10;
        }
        for (BackupOptionItem backupOptionItem : list) {
            CloudValuableAppDataBean.AppInfo appInfo = new CloudValuableAppDataBean.AppInfo();
            appInfo.setAppId(backupOptionItem.getPackageName());
            appInfo.setPackageName(m73343p(this.f56567c, backupOptionItem));
            appInfo.setIcon("data:image/png;base64," + SafeBase64.encodeToString(C13843a.m83081d(backupOptionItem.getParent().equals("virtualApp") ? ICBUtil.drawable2Bitmap(CloudBackup3rdIconUtil.getDrawable(backupOptionItem.getAppId(), null)) : C14333b.m85483r().containsKey(backupOptionItem.getAppId()) ? ICBUtil.drawable2Bitmap(CloudBackup3rdIconUtil.getDrawable(backupOptionItem.getAppId())) : ICBUtil.drawable2Bitmap(CloudBackup3rdIconUtil.get3rdDrawable(backupOptionItem.getAppId())), i10, Bitmap.CompressFormat.PNG), 0));
            arrayList.add(appInfo);
            if (arrayList.size() >= this.f56568d) {
                return true;
            }
        }
        return z10;
    }

    /* renamed from: m */
    public final boolean m73340m(boolean z10, ArrayList<CloudValuableAppDataBean.AppInfo> arrayList, List<SyncItemInfo> list, int i10) {
        if (z10) {
            return z10;
        }
        for (SyncItemInfo syncItemInfo : list) {
            CloudValuableAppDataBean.AppInfo appInfo = new CloudValuableAppDataBean.AppInfo();
            appInfo.setAppId(syncItemInfo.getId());
            appInfo.setPackageName(syncItemInfo.getTitle());
            appInfo.setIcon("data:image/png;base64," + SafeBase64.encodeToString(C13843a.m83081d(ICBUtil.drawable2Bitmap(syncItemInfo.getImage()), i10, Bitmap.CompressFormat.PNG), 0));
            arrayList.add(appInfo);
            if (arrayList.size() >= this.f56568d) {
                return true;
            }
        }
        return z10;
    }

    /* renamed from: n */
    public final void m73341n(boolean z10, ArrayList<CloudValuableAppDataBean.AppInfo> arrayList, List<SyncItemInfo> list, List<SyncItemInfo> list2, List<BackupOptionItem> list3) {
        m73339l(m73340m(m73339l(m73340m(z10, arrayList, list, 64), arrayList, list3, 64), arrayList, list2, 64), arrayList, list3, 64);
    }

    /* renamed from: o */
    public final void m73342o(CloudValuableAppDataBean cloudValuableAppDataBean) {
        c cVar = this.f56566b;
        if (cVar == null) {
            C11839m.m70689w("CloudValuableDataTask", "callBack is null");
        } else {
            cVar.mo65673a(cloudValuableAppDataBean);
        }
    }

    /* renamed from: p */
    public final String m73343p(Context context, BackupOptionItem backupOptionItem) {
        String appId = backupOptionItem.getAppId();
        String appName = backupOptionItem.getAppName();
        return backupOptionItem.getParent().equals("virtualApp") ? TextUtils.isEmpty(appName) ? CloudBackupLanguageUtil.getVirtualName(appId) : appName : C14333b.m85483r().containsKey(appId) ? TextUtils.isEmpty(appName) ? C2783d.m16079E(context, appId) : appName : TextUtils.isEmpty(appName) ? C14333b.f63653e.containsKey(appId) ? C2783d.m16079E(context, appId) : C12590s0.m75884o0(backupOptionItem, new C14229k2(), context) : appName;
    }

    /* renamed from: q */
    public final /* synthetic */ void m73344q(List list, C10028c c10028c, List list2, List list3, SyncConfigService syncConfigService) {
        C11839m.m70688i("CloudValuableDataTask", "getShownSyncServiceItems service = " + syncConfigService.toString());
        if (this.f56565a.containsKey(syncConfigService.getId())) {
            return;
        }
        if (C13452e.m80781L().m80791C0() && list.contains(syncConfigService.getId())) {
            return;
        }
        if (c10028c.m62388s(syncConfigService.getId()) || syncConfigService.getSwitchStatus()) {
            SyncItemInfo syncItemInfo = new SyncItemInfo();
            syncItemInfo.setId(syncConfigService.getId());
            syncItemInfo.setChecked(true);
            syncItemInfo.setSwitchStatus(true);
            syncItemInfo.setSyncConfig(true);
            syncItemInfo.setTitle(syncConfigService.getTitleText());
            syncItemInfo.setSubUser(syncConfigService.isSubUser());
            syncItemInfo.setImage(syncConfigService.getIconDrawable());
            if (list.contains(syncConfigService.getId())) {
                list2.add(syncItemInfo);
            } else {
                list3.add(syncItemInfo);
            }
        }
    }
}
