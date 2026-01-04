package com.huawei.android.hicloud.task.simple;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupOptionInfo;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.task.GetBackupCardInfoTask;
import com.huawei.android.hicloud.cloudbackup.process.task.GetOptionsInfoFromCloneTask;
import com.huawei.android.hicloud.cloudbackup.process.util.C2629f;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.uiadapter.BackupOptionThirdIconAdapter;
import com.huawei.android.p073ds.R$dimen;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hms.network.embedded.C5863b6;
import com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar;
import es.C9537b;
import fk.C9721b;
import gp.C10028c;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0226l0;
import p015ak.C0241z;
import p514o9.C11829c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p617rl.C12519c;
import p617rl.C12526j;
import p618rm.C12541c;
import p618rm.C12580p;
import p618rm.C12597u1;
import p709vj.C13452e;
import p711vl.C13465e;
import p815ym.AbstractC14026a;
import p848zl.C14333b;
import pm.C12176c;
import sk.C12809f;
import tl.C13026e;

/* loaded from: classes3.dex */
public class CloudBackupOptionTask extends AbstractC12367d {

    /* renamed from: a */
    public final TextView f13081a;

    /* renamed from: b */
    public final LinearLayout f13082b;

    /* renamed from: c */
    public HwProgressBar f13083c;

    /* renamed from: d */
    public ImageView f13084d;

    /* renamed from: e */
    public NotchFitRelativeLayout f13085e;

    /* renamed from: i */
    public Context f13089i;

    /* renamed from: k */
    public BackupCallback f13091k;

    /* renamed from: f */
    public int f13086f = 0;

    /* renamed from: g */
    public int f13087g = 0;

    /* renamed from: h */
    public List<BackupOptionItem> f13088h = new ArrayList();

    /* renamed from: j */
    public List<String> f13090j = new ArrayList();

    /* renamed from: l */
    public ArrayList<BackupOptionItem> f13092l = new ArrayList<>();

    /* renamed from: m */
    public C13026e f13093m = new C13026e();

    /* renamed from: n */
    public List<String> f13094n = null;

    public interface BackupCallback {
        /* renamed from: a */
        void mo18098a();

        void onSuccess();
    }

    public CloudBackupOptionTask(Context context, NotchFitRelativeLayout notchFitRelativeLayout) {
        this.f13085e = notchFitRelativeLayout;
        this.f13082b = (LinearLayout) C12809f.m76831d(notchFitRelativeLayout, R$id.ll_option_des_view);
        this.f13081a = (TextView) C12809f.m76831d(notchFitRelativeLayout, R$id.tv_option_des);
        this.f13083c = (HwProgressBar) C12809f.m76831d(notchFitRelativeLayout, R$id.backup_progress_loading);
        this.f13084d = (ImageView) C12809f.m76831d(notchFitRelativeLayout, R$id.iv_option_arrow);
        this.f13089i = context;
    }

    /* renamed from: G */
    public static /* synthetic */ boolean m18055G(String str, BackupOptionItem backupOptionItem) {
        return str.equalsIgnoreCase(backupOptionItem.getAppId());
    }

    /* renamed from: H */
    public static /* synthetic */ int m18056H(BackupOptionItem backupOptionItem, BackupOptionItem backupOptionItem2) {
        return C12580p.m75586t(backupOptionItem.getAppId(), backupOptionItem2.getAppId());
    }

    /* renamed from: I */
    public static /* synthetic */ boolean m18057I(List list, BackupOptionItem backupOptionItem) {
        return list.contains(backupOptionItem.getAppId()) || "baseData".equals(backupOptionItem.getAppId());
    }

    /* renamed from: J */
    public static /* synthetic */ boolean m18058J(List list, BackupOptionItem backupOptionItem) {
        return list.contains(backupOptionItem.getAppId());
    }

    /* renamed from: K */
    public static /* synthetic */ boolean m18059K(List list, BackupOptionItem backupOptionItem) {
        return list.contains(backupOptionItem.getAppId());
    }

    /* renamed from: M */
    public static /* synthetic */ boolean m18061M(List list, String str) {
        return !list.contains(str);
    }

    /* renamed from: t */
    public static ArrayList<BackupOptionItem> m18076t(CloudBackupOptionInfo cloudBackupOptionInfo, List<BackupOptionItem> list) {
        List<BackupOptionItem> systemItemList = cloudBackupOptionInfo.getSystemItemList();
        List<BackupOptionItem> virtualItemList = cloudBackupOptionInfo.getVirtualItemList();
        List<BackupOptionItem> thirdAppItemList = cloudBackupOptionInfo.getThirdAppItemList();
        ArrayList<BackupOptionItem> arrayList = new ArrayList<>();
        if (C13452e.m80781L().m80887a1()) {
            arrayList.addAll(list);
        }
        arrayList.addAll(systemItemList);
        arrayList.addAll(virtualItemList);
        arrayList.addAll(thirdAppItemList);
        arrayList.sort(new Comparator() { // from class: com.huawei.android.hicloud.task.simple.n
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C12580p.m75575i((BackupOptionItem) obj, (BackupOptionItem) obj2);
            }
        });
        return arrayList;
    }

    /* renamed from: A */
    public int m18077A() {
        return this.f13086f;
    }

    /* renamed from: B */
    public final void m18078B(List<BackupOptionItem> list) throws C9721b {
        boolean z10;
        boolean z11 = false;
        this.f13086f = 0;
        this.f13087g = 0;
        this.f13088h.clear();
        ArrayList arrayList = new ArrayList(this.f13090j);
        arrayList.addAll(C14333b.m85449E());
        boolean z12 = true;
        List<String> listM75487b = C12541c.m75487b(false, null, true, arrayList);
        boolean zContains = listM75487b.contains("huaweiBrowser");
        if (C13452e.m80781L().m80887a1()) {
            if (C9537b.m59560a(this.f13092l)) {
                C11839m.m70687e("CloudBackupOptionTask", "baseDataList is null");
            } else {
                this.f13086f += this.f13092l.size();
                this.f13087g += (int) this.f13092l.stream().filter(new C2629f()).count();
                this.f13088h.addAll(this.f13092l);
                if (C13452e.m80781L().m80791C0()) {
                    C11839m.m70688i("CloudBackupOptionTask", "initBasicBackupOptionItems switchCount = " + this.f13086f + " selectedCount = " + this.f13087g);
                    C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.task.simple.q
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f13364a.m18083N();
                        }
                    });
                    C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.task.simple.r
                        @Override // java.lang.Runnable
                        public final void run() throws Resources.NotFoundException {
                            this.f13370a.m18088T();
                        }
                    });
                    return;
                }
            }
        }
        boolean z13 = false;
        boolean z14 = false;
        for (BackupOptionItem backupOptionItem : list) {
            String parent = backupOptionItem.getParent();
            String appId = backupOptionItem.getAppId();
            boolean backupSwitch = backupOptionItem.getBackupSwitch();
            List<String> list2 = this.f13094n;
            if (list2 != null && list2.contains(appId)) {
                C11839m.m70688i("CloudBackupOptionTask", "white base appId: " + appId);
            } else if (zContains || !TextUtils.equals(appId, "huaweiBrowser")) {
                if ("baseData".equals(parent)) {
                    if (C13452e.m80781L().m80887a1()) {
                        C11839m.m70688i("CloudBackupOptionTask", "There is no base data in new business mode.");
                        List<String> list3 = this.f13094n;
                        if (list3 != null && !list3.contains(appId)) {
                            z10 = true;
                            this.f13086f++;
                            this.f13088h.add(backupOptionItem);
                            if (backupSwitch) {
                                this.f13087g++;
                            }
                        }
                    } else {
                        if (!z11) {
                            this.f13086f++;
                            this.f13088h.add(backupOptionItem);
                            this.f13087g++;
                            z11 = true;
                        }
                        C11839m.m70688i("CloudBackupOptionTask", "initBackupOptionItems = BASEDATA " + appId + " switchStatus = " + backupSwitch + " initBaseCount = " + z11);
                    }
                    z10 = true;
                } else if (NavigationUtils.SMS_SCHEMA_PREF.equals(parent) || "chatSms".equals(parent)) {
                    if (z13) {
                        z10 = true;
                    } else {
                        z10 = true;
                        this.f13086f++;
                        this.f13088h.add(backupOptionItem);
                        if (backupSwitch) {
                            this.f13087g++;
                        }
                        z13 = true;
                    }
                    C11839m.m70688i("CloudBackupOptionTask", "initBackupOptionItems = SMS" + appId + " switchStatus = " + backupSwitch + " initSms = " + z13);
                } else {
                    if ("callRecorder".equals(parent) || "soundrecorder".equals(parent)) {
                        if (!z14) {
                            this.f13086f++;
                            this.f13088h.add(backupOptionItem);
                            if (backupSwitch) {
                                this.f13087g++;
                            }
                            z14 = true;
                        }
                        C11839m.m70686d("CloudBackupOptionTask", "initBackupOptionItems = CALLRECORDER" + appId + " switchStatus = " + backupSwitch + " initRecord = " + z14);
                    } else if (C4633d0.m28404a(parent)) {
                        C11839m.m70687e("CloudBackupOptionTask", "initBackupOptionItems parent is null, appid = " + appId);
                    } else {
                        this.f13086f++;
                        this.f13088h.add(backupOptionItem);
                        if (backupSwitch) {
                            this.f13087g++;
                        }
                        C11839m.m70686d("CloudBackupOptionTask", "initBackupOptionItems = switchCount" + appId + " switchStatus = " + backupSwitch);
                    }
                    z10 = true;
                }
                z12 = z10;
            } else {
                C11839m.m70688i("CloudBackupOptionTask", "browser not support backup");
            }
            z10 = z12;
            z12 = z10;
        }
        C11839m.m70688i("CloudBackupOptionTask", "initBackupOptionItems switchCount = " + this.f13086f + " selectedCount = " + this.f13087g);
        m18080D(listM75487b);
        C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.task.simple.r
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                this.f13370a.m18088T();
            }
        });
    }

    /* renamed from: C */
    public final void m18079C(List<BackupOptionItem> list) {
        if (list == null) {
            C11839m.m70689w("CloudBackupOptionTask", "baseDataList is null");
            return;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
        for (BackupOptionItem backupOptionItem : list) {
            if (backupOptionItem != null) {
                if (C14333b.f63654f.contains(backupOptionItem.getAppId())) {
                    copyOnWriteArrayList.add(backupOptionItem);
                } else {
                    copyOnWriteArrayList2.add(backupOptionItem);
                }
            }
        }
        final boolean zM62303a1 = C10028c.m62182c0().m62303a1();
        copyOnWriteArrayList2.forEach(new Consumer() { // from class: com.huawei.android.hicloud.task.simple.o
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f13342a.m18084O(zM62303a1, (BackupOptionItem) obj);
            }
        });
        copyOnWriteArrayList2.sort(new Comparator() { // from class: com.huawei.android.hicloud.task.simple.p
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C12580p.m75575i((BackupOptionItem) obj, (BackupOptionItem) obj2);
            }
        });
        this.f13092l.clear();
        this.f13092l.addAll(copyOnWriteArrayList2);
        if (AbstractC14026a.m84159a(copyOnWriteArrayList)) {
            return;
        }
        BackupOptionItem backupOptionItem2 = new BackupOptionItem();
        backupOptionItem2.setBackupSwitch(true);
        backupOptionItem2.setAppId("basic_system_data");
        this.f13092l.add(0, backupOptionItem2);
    }

    /* renamed from: D */
    public final void m18080D(List<String> list) throws C9721b {
        C11839m.m70688i("CloudBackupOptionTask", "initOptionShowFromCache");
        C13026e c13026e = new C13026e();
        List<BackupOptionItem> arrayList = new ArrayList<>();
        List<BackupOptionItem> arrayList2 = new ArrayList<>();
        C12519c c12519c = new C12519c();
        List<String> listM75297h = c12519c.m75297h(1);
        List arrayList3 = new ArrayList();
        if (C13452e.m80781L().m80887a1()) {
            arrayList3 = C12176c.m73271n(null);
        }
        boolean zContains = listM75297h.contains("music");
        for (String str : list) {
            BackupOptionItem backupOptionItemQueryParentItem = ICBUtil.queryParentItem(str, false);
            if (str.equals("music") && zContains) {
                backupOptionItemQueryParentItem.setParent("virtualApp");
            }
            if (arrayList3.size() != 0 && "baseData".equals(str)) {
                for (String str2 : m18094u()) {
                    if (!arrayList3.contains(str2)) {
                        BackupOptionItem backupOptionItemM78401y = c13026e.m78401y(str2);
                        arrayList.add(backupOptionItemM78401y);
                        C11839m.m70688i("CloudBackupOptionTask", "add child item: " + backupOptionItemM78401y.getAppId() + ", switch: " + backupOptionItemM78401y.getBackupSwitch());
                    }
                }
            }
            arrayList.add(backupOptionItemQueryParentItem);
        }
        listM75297h.removeAll(C14333b.m85476k());
        String str3 = this.f13089i.getFilesDir() + "/cloudbackup";
        for (String str4 : listM75297h) {
            if (new CloudBackupAppDataUtil(str4, str3, 0L, false, false).isAppDataAble()) {
                BackupOptionItem backupOptionItemM78401y2 = c13026e.m78401y(str4);
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
            listM75297h.add("music");
        }
        CloudBackupOptionInfo cloudBackupOptionInfo = new CloudBackupOptionInfo();
        cloudBackupOptionInfo.setCacheData(true);
        cloudBackupOptionInfo.setSystemItemList(arrayList);
        cloudBackupOptionInfo.setVirtualItemList(arrayList2);
        cloudBackupOptionInfo.setAppDataModule(ICBUtil.queryAppDataItem(false));
        cloudBackupOptionInfo.setThirdAppItemList(c13026e.m78399w("thirdAppData"));
        cloudBackupOptionInfo.setVirtuals(listM75297h);
        m18092r(cloudBackupOptionInfo);
        final ArrayList<BackupOptionItem> arrayListM18076t = m18076t(cloudBackupOptionInfo, this.f13092l);
        dealSplitApp(arrayListM18076t);
        C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.task.simple.s
            @Override // java.lang.Runnable
            public final void run() {
                this.f13380a.m18085Q(arrayListM18076t);
            }
        });
    }

    /* renamed from: E */
    public final boolean m18081E() {
        long jM81057e = C13465e.m81052f().m81057e(false);
        int iM75332E = new C12526j().m75332E();
        long jCurrentTimeMillis = System.currentTimeMillis() - jM81057e;
        boolean zM75158X0 = C12515a.m75110o().m75158X0(GetOptionsInfoFromCloneTask.class.getName());
        C11839m.m70686d("CloudBackupOptionTask", "isNeedObtainOptionExcludedSize clientSizeCacheTime = " + jM81057e + " , millis: " + jCurrentTimeMillis + " currentTimeMillis = " + System.currentTimeMillis() + " isOptionTaskRunning = " + zM75158X0 + " clientSizeCache = " + iM75332E);
        if (jCurrentTimeMillis > iM75332E * C5863b6.g.f26453g) {
            if (zM75158X0) {
                C11839m.m70688i("CloudBackupOptionTask", "GetOptionsInfoFromCloneTask is running");
            } else {
                C11839m.m70688i("CloudBackupOptionTask", "not use option cache, clientSizeCacheTime: " + jM81057e + " , millis: " + jCurrentTimeMillis);
                C12515a.m75110o().m75172d(new GetOptionsInfoFromCloneTask(false, false, GetOptionsInfoFromCloneTask.cloudBackupUserInfo));
            }
        }
        C11839m.m70688i("CloudBackupOptionTask", "isNeedObtainOptionExcludedSize end");
        return jM81057e <= 0;
    }

    /* renamed from: F */
    public final boolean m18082F(String str, BackupOptionItem backupOptionItem) {
        boolean zEquals = "1".equals(new SettingOperator().queryUploadTargetStrategy());
        if (TextUtils.equals(str, "huaweiBrowser") && (zEquals || C0209d.m1273k1())) {
            return true;
        }
        if (TextUtils.equals(str, HNConstants.DataType.MEDIA) && !ICBUtil.isSupportGallery(this.f13089i)) {
            return true;
        }
        if ((TextUtils.equals(str, HNConstants.DataType.CONTACT) || TextUtils.equals(str, "calllog")) && !C11829c.m70546T0(this.f13089i)) {
            return true;
        }
        if ((TextUtils.equals(str, NavigationUtils.SMS_SCHEMA_PREF) && !C11829c.m70523I0(this.f13089i)) || "thirdApp".equals(backupOptionItem.getParent()) || this.f13090j.contains(str)) {
            return true;
        }
        if (TextUtils.equals(str, "HiCreate")) {
            return (C0209d.m1184K0(this.f13089i, "com.huawei.hicreate") && C0209d.m1170F1() && RestoreUtil.isHiCreateSupportClone()) ? false : true;
        }
        return false;
    }

    /* renamed from: N */
    public final /* synthetic */ void m18083N() {
        m18085Q(this.f13092l);
    }

    /* renamed from: O */
    public final /* synthetic */ void m18084O(boolean z10, BackupOptionItem backupOptionItem) {
        if (z10) {
            BackupOptionItem backupOptionItemM78401y = this.f13093m.m78401y(backupOptionItem.getAppId());
            if (backupOptionItemM78401y == null) {
                return;
            }
            backupOptionItem.setBackupSwitch(backupOptionItemM78401y.getBackupSwitch());
            return;
        }
        if ("basic_system_data".equals(backupOptionItem.getAppId())) {
            backupOptionItem.setBackupSwitch(true);
        } else {
            backupOptionItem.setBackupSwitch(false);
        }
    }

    /* renamed from: R */
    public final void m18086R(Iterator<BackupOptionItem> it) {
        try {
            it.remove();
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupOptionTask", "safeIteratorRemove error:" + e10.getMessage());
        }
    }

    /* renamed from: S */
    public BackupCallback m18087S(BackupCallback backupCallback) {
        this.f13091k = backupCallback;
        return backupCallback;
    }

    /* renamed from: T */
    public final void m18088T() throws Resources.NotFoundException {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null || this.f13082b == null || this.f13081a == null) {
            C11839m.m70689w("CloudBackupOptionTask", "context is null");
            return;
        }
        Resources resources = contextM1377a.getResources();
        int i10 = R$plurals.backup_app_data_count;
        int i11 = this.f13086f;
        this.f13081a.setText(contextM1377a.getString(R$string.backup_option_value_no_size, Integer.valueOf(this.f13087g), resources.getQuantityString(i10, i11, Integer.valueOf(i11))));
        this.f13082b.setVisibility(0);
        this.f13083c.setVisibility(8);
        this.f13084d.setVisibility(0);
        this.f13085e.setMinimumHeight(contextM1377a.getResources().getDimensionPixelSize(R$dimen.emui10_list_min_height_64));
    }

    /* renamed from: U */
    public final void m18089U() {
        LinearLayout linearLayout;
        C11839m.m70688i("CloudBackupOptionTask", "option is empty, show empty page");
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null || (linearLayout = this.f13082b) == null || this.f13081a == null) {
            return;
        }
        linearLayout.setVisibility(8);
        this.f13085e.setMinimumHeight(contextM1377a.getResources().getDimensionPixelSize(R$dimen.emui10_list_min_height_48));
    }

    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public final void m18085Q(ArrayList<BackupOptionItem> arrayList) {
        if (arrayList == null) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) C12809f.m76831d(this.f13085e, R$id.app_data_item_icon_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f13089i, 0, false));
        BackupOptionThirdIconAdapter backupOptionThirdIconAdapter = new BackupOptionThirdIconAdapter(this.f13089i);
        backupOptionThirdIconAdapter.m24798G(true);
        recyclerView.setAdapter(backupOptionThirdIconAdapter);
        recyclerView.setVisibility(0);
        backupOptionThirdIconAdapter.m24797E(arrayList);
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        m18091q(this.f13091k);
    }

    public final void dealSplitApp(List<BackupOptionItem> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        HashMap map = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            BackupOptionItem backupOptionItem = (BackupOptionItem) it.next();
            if (SplitAppUtil.hasSplitAppSuffix(backupOptionItem.getAppId())) {
                String splitOriAppId = SplitAppUtil.getSplitOriAppId(backupOptionItem.getAppId());
                String splitAppType = SplitAppUtil.getSplitAppType(backupOptionItem.getAppId());
                if (SplitAppUtil.isTwinApp(splitAppType, splitOriAppId)) {
                    backupOptionItem.setOriBackupAppName(splitOriAppId);
                    backupOptionItem.setSplitApkType(splitAppType);
                    List arrayList2 = map.get(splitOriAppId) != null ? (List) map.get(splitOriAppId) : new ArrayList();
                    if (arrayList2 != null) {
                        arrayList2.add(backupOptionItem);
                        map.put(splitOriAppId, arrayList2);
                    }
                    it.remove();
                }
            }
        }
        if (map.isEmpty()) {
            return;
        }
        for (final String str : map.keySet()) {
            Optional optionalFindFirst = arrayList.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.task.simple.l
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return CloudBackupOptionTask.m18055G(str, (BackupOptionItem) obj);
                }
            }).findFirst();
            if (optionalFindFirst.isPresent()) {
                BackupOptionItem backupOptionItem2 = (BackupOptionItem) optionalFindFirst.get();
                List<BackupOptionItem> list2 = (List) map.get(str);
                if (list2 != null) {
                    list2.sort(new Comparator() { // from class: com.huawei.android.hicloud.task.simple.m
                        @Override // java.util.Comparator
                        public final int compare(Object obj, Object obj2) {
                            return CloudBackupOptionTask.m18056H((BackupOptionItem) obj, (BackupOptionItem) obj2);
                        }
                    });
                    backupOptionItem2.setTwinAppsList(list2);
                    list.removeAll(list2);
                    list.addAll(list.indexOf(backupOptionItem2) + 1, list2);
                }
            }
        }
    }

    /* renamed from: q */
    public void m18091q(BackupCallback backupCallback) {
        boolean zM81055c = C13465e.m81052f().m81055c("isFirstClone", false);
        long jM81058g = C13465e.m81052f().m81058g("firsOmTime", 0L);
        long jM81058g2 = C13465e.m81052f().m81058g("firstCloneTime", -1L);
        C11839m.m70688i("CloudBackupOptionTask", "call isFirstClone: " + zM81055c + " firstOmTime :" + jM81058g + " firstCloneTime :" + jM81058g2);
        if (zM81055c && jM81058g > jM81058g2) {
            if (backupCallback != null) {
                backupCallback.mo18098a();
                return;
            }
            return;
        }
        if (m18081E()) {
            C11839m.m70688i("CloudBackupOptionTask", "checkCacheInvalid isNeedObtainOptionExcludedSize:");
            C3026e0.m18291f();
        }
        long jM81061j = C13465e.m81052f().m81061j(false);
        C11839m.m70688i("CloudBackupOptionTask", "call backupOptionsTimestamp: " + jM81061j);
        if (jM81061j == 0) {
            if (backupCallback != null) {
                backupCallback.mo18098a();
                return;
            }
            return;
        }
        List<BackupOptionItem> listM18096y = m18096y(new C13026e().m78397u());
        m18095v();
        if (listM18096y.isEmpty()) {
            C11839m.m70688i("CloudBackupOptionTask", "get filterOptionsItem is empty");
            C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.task.simple.k
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13309a.m18089U();
                }
            });
            if (backupCallback != null) {
                backupCallback.onSuccess();
                return;
            }
            return;
        }
        try {
            m18078B(listM18096y);
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupOptionTask", "Init backup options failed: " + e10.getMessage());
        }
        if (backupCallback != null) {
            backupCallback.onSuccess();
        }
    }

    /* renamed from: r */
    public final void m18092r(CloudBackupOptionInfo cloudBackupOptionInfo) {
        if (C13452e.m80781L().m80887a1()) {
            C11839m.m70688i("CloudBackupOptionTask", "New business, filter AppOptionInfo.");
            final List<String> listM73271n = C12176c.m73271n(null);
            cloudBackupOptionInfo.getVirtualItemList().removeIf(new Predicate() { // from class: com.huawei.android.hicloud.task.simple.u
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return CloudBackupOptionTask.m18058J(listM73271n, (BackupOptionItem) obj);
                }
            });
            cloudBackupOptionInfo.getThirdAppItemList().removeIf(new Predicate() { // from class: com.huawei.android.hicloud.task.simple.v
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return CloudBackupOptionTask.m18059K(listM73271n, (BackupOptionItem) obj);
                }
            });
            cloudBackupOptionInfo.getSystemItemList().removeIf(new Predicate() { // from class: com.huawei.android.hicloud.task.simple.w
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return CloudBackupOptionTask.m18057I(listM73271n, (BackupOptionItem) obj);
                }
            });
        }
    }

    /* renamed from: s */
    public List<BackupOptionItem> m18093s() {
        return this.f13088h;
    }

    /* renamed from: u */
    public final List<String> m18094u() {
        final List<String> listM75386e = new C12526j().m75386e();
        ArrayList arrayList = new ArrayList(C14333b.m85482q());
        if (!C11829c.m70546T0(this.f13089i)) {
            arrayList.remove("harassment");
        }
        return (List) arrayList.parallelStream().filter(new Predicate() { // from class: com.huawei.android.hicloud.task.simple.t
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return CloudBackupOptionTask.m18061M(listM75386e, (String) obj);
            }
        }).collect(Collectors.toList());
    }

    /* renamed from: v */
    public final void m18095v() {
        C11839m.m70688i("CloudBackupOptionTask", "getBasicBackupAllCount start");
        if (!C13452e.m80781L().m80887a1()) {
            C11839m.m70688i("CloudBackupOptionTask", "old mode don't need get base modules");
            return;
        }
        this.f13094n = C12176c.m73271n(null);
        List<BackupOptionItem> backupOptionItems = GetBackupCardInfoTask.getBackupOptionItems(null);
        if (C9537b.m59560a(backupOptionItems)) {
            C11839m.m70687e("CloudBackupOptionTask", "backupOptionItems is null");
        } else if (C9537b.m59560a(this.f13094n)) {
            C11839m.m70687e("CloudBackupOptionTask", "whiteAppIds is null");
        } else {
            m18079C(GetBackupCardInfoTask.getBaseDataList(backupOptionItems, this.f13094n));
            C11839m.m70688i("CloudBackupOptionTask", "initBasicBackupOption success");
        }
    }

    /* renamed from: y */
    public final List<BackupOptionItem> m18096y(List<BackupOptionItem> list) {
        if (list == null || list.isEmpty()) {
            C11839m.m70688i("CloudBackupOptionTask", "getFilterOptionsItem backupOptionItems is empty");
            return new ArrayList();
        }
        this.f13090j = C12597u1.m76026b();
        Iterator<BackupOptionItem> it = list.iterator();
        while (it.hasNext()) {
            BackupOptionItem next = it.next();
            if (m18082F(next.getAppId(), next)) {
                m18086R(it);
            }
        }
        C11839m.m70686d("CloudBackupOptionTask", "filterOptionsItem size = " + list.size());
        return list;
    }

    /* renamed from: z */
    public int m18097z() {
        return this.f13087g;
    }
}
