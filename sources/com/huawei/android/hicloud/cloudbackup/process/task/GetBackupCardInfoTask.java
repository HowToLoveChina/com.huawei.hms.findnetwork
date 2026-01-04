package com.huawei.android.hicloud.cloudbackup.process.task;

import android.content.pm.PackageInfo;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.bean.BackupCardInfo;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupState;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.constant.BackupCardTaskOperation;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.task.BackupModuleInfoQueryLogic;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.p088ui.extend.C3948f;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import com.huawei.hicloud.cloudbackup.p104v3.omconfig.model.SyncAppBackupPolicy;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import fk.C9721b;
import gp.C10028c;
import il.C10542o;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import p015ak.C0213f;
import p015ak.C0226l0;
import p292fn.C9733f;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p618rm.C12547e;
import p618rm.C12580p;
import p618rm.C12590s0;
import p618rm.C12591s1;
import p618rm.C12597u1;
import p709vj.C13452e;
import p711vl.C13461a;
import p711vl.C13465e;
import p815ym.AbstractC14026a;
import p847zk.C14317j;
import p848zl.C14333b;
import p848zl.C14339h;
import p848zl.C14342k;
import pm.C12176c;
import tl.C13026e;

/* loaded from: classes2.dex */
public class GetBackupCardInfoTask extends AbstractC12367d {
    private static final int ITEM_SHOW_MAX_COUNT = 2;
    private static final String TAG = "GetBackupCardInfoTask";
    private CloudBackupState cloudBackupState;
    private final BackupCardInfo mainBackupItemData;
    private final EnumSet<BackupCardTaskOperation> operations;
    private final Runnable taskEndCallBack;

    public static class BaseAppComparator implements Comparator<BackupOptionItem> {
        private BaseAppComparator() {
        }

        @Override // java.util.Comparator
        public int compare(BackupOptionItem backupOptionItem, BackupOptionItem backupOptionItem2) {
            return C12547e.m75493b(backupOptionItem.getAppName(), backupOptionItem2.getAppName());
        }
    }

    public GetBackupCardInfoTask(CloudBackupState cloudBackupState, EnumSet<BackupCardTaskOperation> enumSet, BackupCardInfo backupCardInfo, Runnable runnable) {
        this.cloudBackupState = cloudBackupState;
        this.operations = enumSet;
        this.taskEndCallBack = runnable;
        if (backupCardInfo == null) {
            this.mainBackupItemData = new BackupCardInfo();
        } else {
            this.mainBackupItemData = backupCardInfo;
        }
    }

    private void dealProcessKilled(BackupCardInfo backupCardInfo) {
        int iM80916g0 = C13452e.m80781L().m80916g0();
        if (iM80916g0 == 5) {
            backupCardInfo.setState(8);
            backupCardInfo.setErrorCode(0);
            return;
        }
        if (iM80916g0 != 3) {
            backupCardInfo.setState(6);
            return;
        }
        List<CloudRestoreItem> itemList = RestoreUtil.getItemList();
        int failCount = RestoreUtil.getFailCount(0, itemList);
        C11839m.m70688i(TAG, "dealProcessKilled failedCount = " + failCount);
        int succeedCount = RestoreUtil.getSucceedCount(0, itemList);
        C11839m.m70688i(TAG, "dealProcessKilled succeedCount = " + succeedCount);
        if (failCount > 0 && succeedCount > 0) {
            backupCardInfo.setState(9);
        } else if (failCount > 0) {
            backupCardInfo.setState(8);
        }
    }

    private static void dealSplitApp(List<BackupOptionItem> list) {
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
            Optional optionalFindFirst = arrayList.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.j0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return GetBackupCardInfoTask.lambda$dealSplitApp$6(str, (BackupOptionItem) obj);
                }
            }).findFirst();
            if (optionalFindFirst.isPresent()) {
                BackupOptionItem backupOptionItem2 = (BackupOptionItem) optionalFindFirst.get();
                List<BackupOptionItem> list2 = (List) map.get(str);
                if (list2 != null) {
                    list2.sort(new Comparator() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.q
                        @Override // java.util.Comparator
                        public final int compare(Object obj, Object obj2) {
                            return GetBackupCardInfoTask.lambda$dealSplitApp$7((BackupOptionItem) obj, (BackupOptionItem) obj2);
                        }
                    });
                    backupOptionItem2.setTwinAppsList(list2);
                    list.removeAll(list2);
                    list.addAll(list.indexOf(backupOptionItem2) + 1, list2);
                }
            }
        }
    }

    private void getBackupModuleShow(boolean z10) {
        List<BackupOptionItem> backupOptionItems = getBackupOptionItems(this.mainBackupItemData);
        if (backupOptionItems == null) {
            C11839m.m70688i(TAG, "getBackupModuleShow moduleInfo is empty");
            return;
        }
        final List<String> listM73271n = C12176c.m73271n(null);
        if (!C13452e.m80781L().m80887a1()) {
            BackupModuleInfoQueryLogic backupModuleInfoQueryLogic = new BackupModuleInfoQueryLogic(C0213f.m1377a(), false, BackupModuleInfoQueryLogic.BackupType.STANDARD, "GetBackupCardInfoTask_moduleShow");
            List<BackupOptionItem> allBackupItems = backupModuleInfoQueryLogic.getAllBackupItems();
            boolean zM60720O = C9733f.m60705z().m60720O("cloudBackupSyncAppExclusive");
            Map<String, SyncAppBackupPolicy> mapM76029e = C12597u1.m76029e();
            Map<String, Integer> mapM76030f = C12597u1.m76030f();
            for (BackupOptionItem backupOptionItem : backupModuleInfoQueryLogic.getAppOptionInfo().getSystemItemList()) {
                String appId = backupOptionItem.getAppId();
                if (zM60720O && mapM76029e.containsKey(appId)) {
                    String syncAppName = mapM76029e.get(appId).getSyncAppName();
                    if (mapM76029e.get(appId).getPolicy() == 1 && mapM76030f.containsKey(syncAppName) && 1 == mapM76030f.getOrDefault(syncAppName, 0).intValue()) {
                        C11839m.m70688i(TAG, "skip appId: " + appId + ", syncAppName: " + syncAppName + " status is open");
                        allBackupItems.remove(backupOptionItem);
                    }
                }
                C11839m.m70688i(TAG, "systemappId: " + backupOptionItem.getAppId());
            }
            List<PackageInfo> installedPackages = C0213f.m1377a().getPackageManager().getInstalledPackages(64);
            if (installedPackages != null) {
                final List list = (List) installedPackages.stream().map(new Function() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.t
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return ((PackageInfo) obj).packageName;
                    }
                }).collect(Collectors.toList());
                backupOptionItems = (List) allBackupItems.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.u
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return GetBackupCardInfoTask.lambda$getBackupModuleShow$1(list, (BackupOptionItem) obj);
                    }
                }).collect(Collectors.toList());
            } else {
                backupOptionItems = (List) allBackupItems.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.v
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return GetBackupCardInfoTask.lambda$getBackupModuleShow$2((BackupOptionItem) obj);
                    }
                }).collect(Collectors.toList());
            }
        }
        if (z10) {
            backupOptionItems = (List) backupOptionItems.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.w
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return GetBackupCardInfoTask.lambda$getBackupModuleShow$3(listM73271n, (BackupOptionItem) obj);
                }
            }).collect(Collectors.toList());
        }
        final List<BackupOptionItem> baseDataList = getBaseDataList(backupOptionItems, listM73271n);
        C11839m.m70686d(TAG, "baseDataList: " + baseDataList.stream().map(new C2575c0()).collect(Collectors.toList()));
        notifyCloudMainShow(baseDataList);
        List list2 = C13452e.m80781L().m80887a1() ? (List) backupOptionItems.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.x
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return GetBackupCardInfoTask.lambda$getBackupModuleShow$4(baseDataList, (BackupOptionItem) obj);
            }
        }).sorted(Comparator.comparingLong(new C2612y()).reversed()).collect(Collectors.toList()) : (List) backupOptionItems.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.z
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return GetBackupCardInfoTask.lambda$getBackupModuleShow$5((BackupOptionItem) obj);
            }
        }).sorted(Comparator.comparingLong(new C2612y()).reversed()).collect(Collectors.toList());
        dealSplitApp(list2);
        C11839m.m70686d(TAG, "nonBaseDataList: " + list2.stream().map(new C2575c0()).collect(Collectors.toList()));
        this.mainBackupItemData.setBaseModuleCount(baseDataList.size());
        this.mainBackupItemData.setFullModuleCount(list2.size());
        List list3 = (List) baseDataList.stream().limit(2L).collect(Collectors.toList());
        if (list3.size() > 0) {
            this.mainBackupItemData.setBaseFirstAppId(((BackupOptionItem) list3.get(0)).getAppId());
        }
        if (list3.size() > 1) {
            this.mainBackupItemData.setBaseSecondAppId(((BackupOptionItem) list3.get(1)).getAppId());
        }
        List list4 = (List) list2.stream().limit(2L).collect(Collectors.toList());
        if (list4.size() > 0) {
            this.mainBackupItemData.setFullFirstAppId(((BackupOptionItem) list4.get(0)).getAppId());
        }
        if (list4.size() > 1) {
            this.mainBackupItemData.setFullSecondAppId(((BackupOptionItem) list4.get(1)).getAppId());
        }
        C13461a.m81002d(C0213f.m1377a()).m81010i(this.mainBackupItemData);
        Message messageObtain = Message.obtain();
        messageObtain.what = 34574;
        CBCallBack.getInstance().sendMessage(messageObtain);
    }

    public static List<BackupOptionItem> getBackupOptionItems(BackupCardInfo backupCardInfo) {
        boolean z10;
        List<BackupOptionItem> allBackupItems;
        boolean zM75158X0;
        boolean zM81055c = C13465e.m81052f().m81055c("isFirstInit", true);
        List<BackupOptionItem> listM78397u = new C13026e().m78397u();
        boolean zM84159a = AbstractC14026a.m84159a(listM78397u);
        if (backupCardInfo == null) {
            allBackupItems = new BackupModuleInfoQueryLogic(C0213f.m1377a(), true, BackupModuleInfoQueryLogic.BackupType.STANDARD, "GetBackupCardInfoTask_optionItemsNull").getAllBackupItems();
            zM75158X0 = false;
            z10 = false;
        } else {
            if (zM81055c) {
                z10 = new SettingOperator().queryLastCloneSuccessTime() > 0;
                if (!z10) {
                    zM75158X0 = C12515a.m75110o().m75158X0(GetOptionsInfoFromCloneTask.class.getName());
                    allBackupItems = new BackupModuleInfoQueryLogic(C0213f.m1377a(), true, BackupModuleInfoQueryLogic.BackupType.STANDARD, "GetBackupCardInfoTask_optionItems").getAllBackupItems();
                    if (zM75158X0) {
                        C11839m.m70688i(TAG, "GetOptionsInfoFromCloneTask is running");
                    } else {
                        startCloneTask();
                    }
                    if (C13452e.m80781L().m80887a1()) {
                        BackupModuleInfoQueryLogic.addNewBmBaseDataItem(allBackupItems);
                    }
                }
            } else {
                z10 = false;
            }
            final List list = (List) C0213f.m1377a().getPackageManager().getInstalledPackages(64).stream().map(new Function() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.p
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((PackageInfo) obj).packageName;
                }
            }).collect(Collectors.toList());
            List<BackupOptionItem> list2 = (List) listM78397u.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.a0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return GetBackupCardInfoTask.lambda$getBackupOptionItems$12(list, (BackupOptionItem) obj);
                }
            }).collect(Collectors.toList());
            if (C13452e.m80781L().m80887a1()) {
                BackupModuleInfoQueryLogic.addNewBmBaseDataItem(list2);
            }
            C11839m.m70686d(TAG, "moduleInfo: " + list2.stream().map(new C2575c0()).collect(Collectors.toList()));
            allBackupItems = list2;
            zM75158X0 = false;
        }
        C11839m.m70688i(TAG, "getBackupOptionItems isFirst: " + zM81055c + " ,existTask: " + zM75158X0 + " ,cloneSuccess:" + z10 + " ,isModuleInfoEmpty: " + zM84159a);
        if (AbstractC14026a.m84159a(allBackupItems)) {
            C11839m.m70687e(TAG, "moduleInfo is empty");
            return null;
        }
        final List<String> listM76026b = C12597u1.m76026b();
        List list3 = (List) allBackupItems.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.d0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return GetBackupCardInfoTask.lambda$getBackupOptionItems$13(listM76026b, (BackupOptionItem) obj);
            }
        }).filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.e0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return GetBackupCardInfoTask.lambda$getBackupOptionItems$14((BackupOptionItem) obj);
            }
        }).collect(Collectors.toList());
        if (backupCardInfo != null) {
            backupCardInfo.setLoadingModule(false);
        }
        BackupOptionItem backupOptionItem = new BackupOptionItem("thirdApp");
        backupOptionItem.setBackupSwitch(true);
        backupOptionItem.setUid(0);
        list3.add(backupOptionItem);
        return new ArrayList(((Map) list3.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.f0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return GetBackupCardInfoTask.lambda$getBackupOptionItems$15((BackupOptionItem) obj);
            }
        }).peek(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.g0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                GetBackupCardInfoTask.lambda$getBackupOptionItems$16((BackupOptionItem) obj);
            }
        }).collect(Collectors.toMap(new C2575c0(), new Function() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.h0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return GetBackupCardInfoTask.lambda$getBackupOptionItems$17((BackupOptionItem) obj);
            }
        }, new BinaryOperator() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.i0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return GetBackupCardInfoTask.lambda$getBackupOptionItems$18((BackupOptionItem) obj, (BackupOptionItem) obj2);
            }
        }))).values());
    }

    public static List<BackupOptionItem> getBaseDataList(List<BackupOptionItem> list, final List<String> list2) {
        return (List) list.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.r
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return GetBackupCardInfoTask.lambda$getBaseDataList$9(list2, (BackupOptionItem) obj);
            }
        }).peek(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.s
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                GetBackupCardInfoTask.lambda$getBaseDataList$10((BackupOptionItem) obj);
            }
        }).sorted(new BaseAppComparator()).collect(Collectors.toList());
    }

    public static BackupCardInfo getCacheBackupCardInfo() {
        BackupCardInfo backupCardInfoM81004b = C13461a.m81002d(C0213f.m1377a()).m81004b();
        if (backupCardInfoM81004b == null) {
            backupCardInfoM81004b = new BackupCardInfo();
            backupCardInfoM81004b.setLoadingModule(true);
            backupCardInfoM81004b.setState(2);
        }
        boolean zM80791C0 = C13452e.m80781L().m80791C0();
        boolean zM62388s = C10028c.m62182c0().m62388s("backup_key");
        backupCardInfoM81004b.setBasicData(zM80791C0);
        backupCardInfoM81004b.setNewBmType(C13452e.m80781L().m80887a1());
        backupCardInfoM81004b.setBackupOpen(zM62388s);
        backupCardInfoM81004b.setBaseOpen(C10028c.m62182c0().m62303a1());
        return backupCardInfoM81004b;
    }

    private void initBackupState() {
        Integer state = this.cloudBackupState.getState();
        if (!this.mainBackupItemData.isBackupOpen() || state.intValue() == 0) {
            this.mainBackupItemData.setBackupOpen(false);
            this.mainBackupItemData.setState(1);
            return;
        }
        if (C14342k.m85520a(state.intValue())) {
            this.mainBackupItemData.setState(3);
            return;
        }
        if (state.intValue() == 2) {
            this.mainBackupItemData.setState(5);
            this.mainBackupItemData.setErrorCode(this.cloudBackupState.getReturnCode());
            return;
        }
        if (state.intValue() == 3) {
            this.mainBackupItemData.setState(2);
            this.mainBackupItemData.setLastSuccessTime(this.cloudBackupState.getLastSuccessTime());
            this.mainBackupItemData.setNextBackupTime(this.cloudBackupState.getNextStartTime());
        } else if (state.intValue() == 4) {
            this.mainBackupItemData.setState(4);
            this.mainBackupItemData.setErrorCode(this.cloudBackupState.getReturnCode());
            this.mainBackupItemData.setWaitBackupSize(this.cloudBackupState.getWaitBackupSize());
            this.mainBackupItemData.setLastSuccessTime(this.cloudBackupState.getLastSuccessTime());
        }
    }

    private void initRestoreState() {
        Integer state = this.cloudBackupState.getState();
        int iM80916g0 = C13452e.m80781L().m80916g0();
        if (C14342k.m85520a(state.intValue())) {
            dealProcessKilled(this.mainBackupItemData);
            return;
        }
        if (iM80916g0 == 2 || iM80916g0 == 3) {
            List<CloudRestoreItem> itemList = RestoreUtil.getItemList();
            int failCount = RestoreUtil.getFailCount(0, itemList);
            C11839m.m70688i(TAG, "restoreSuccess failedCount = " + failCount);
            int succeedCount = RestoreUtil.getSucceedCount(0, itemList);
            C11839m.m70688i(TAG, "restoreSuccess succeedCount = " + succeedCount);
            if (failCount > 0 && succeedCount > 0) {
                this.mainBackupItemData.setState(9);
                return;
            } else {
                if (failCount > 0) {
                    this.mainBackupItemData.setState(8);
                    return;
                }
                return;
            }
        }
        if (iM80916g0 == 4 || iM80916g0 == 5) {
            if (C14339h.m85506e().contains(Integer.valueOf(this.cloudBackupState.getReturnCode()))) {
                this.mainBackupItemData.setState(7);
                this.mainBackupItemData.setErrorCode(1);
                return;
            } else {
                this.mainBackupItemData.setState(8);
                this.mainBackupItemData.setErrorCode(0);
                return;
            }
        }
        if (iM80916g0 == 7) {
            this.mainBackupItemData.setState(7);
            if (RestoreUtil.getPauseCount(0, RestoreUtil.getItemList()) == 0) {
                this.mainBackupItemData.setErrorCode(0);
                return;
            } else {
                this.mainBackupItemData.setErrorCode(2);
                return;
            }
        }
        if (this.cloudBackupState.getState().intValue() == 2) {
            this.mainBackupItemData.setState(7);
            if (C14339h.m85514m().contains(Integer.valueOf(this.cloudBackupState.getReturnCode()))) {
                this.mainBackupItemData.setErrorCode(3);
            } else {
                this.mainBackupItemData.setErrorCode(0);
            }
        }
    }

    private void initState() {
        EnumSet<BackupCardTaskOperation> enumSet = this.operations;
        BackupCardTaskOperation backupCardTaskOperation = BackupCardTaskOperation.QUERY_BACKUP_RESTORE_STATE;
        if (!enumSet.contains(backupCardTaskOperation)) {
            C11839m.m70688i(TAG, "initState false");
            return;
        }
        this.operations.remove(backupCardTaskOperation);
        int id2 = this.cloudBackupState.getId();
        if (id2 == 1) {
            initBackupState();
        } else if (id2 == 2) {
            initRestoreState();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$dealSplitApp$6(String str, BackupOptionItem backupOptionItem) {
        return str.equalsIgnoreCase(backupOptionItem.getAppId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$dealSplitApp$7(BackupOptionItem backupOptionItem, BackupOptionItem backupOptionItem2) {
        return C12580p.m75586t(backupOptionItem.getAppId(), backupOptionItem2.getAppId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getBackupModuleShow$1(List list, BackupOptionItem backupOptionItem) {
        return !"thirdAppData".equals(backupOptionItem.getParent()) || ("thirdAppData".equals(backupOptionItem.getParent()) && list.contains(backupOptionItem.getOriBackupAppName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getBackupModuleShow$2(BackupOptionItem backupOptionItem) {
        return !"thirdAppData".equals(backupOptionItem.getParent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getBackupModuleShow$3(List list, BackupOptionItem backupOptionItem) {
        return backupOptionItem.getBackupSwitch() || list.contains(backupOptionItem.getAppId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getBackupModuleShow$4(List list, BackupOptionItem backupOptionItem) {
        return !list.contains(backupOptionItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getBackupModuleShow$5(BackupOptionItem backupOptionItem) {
        return !TextUtils.equals("thirdApp", backupOptionItem.getAppId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getBackupOptionItems$12(List list, BackupOptionItem backupOptionItem) {
        return !"thirdAppData".equals(backupOptionItem.getParent()) || ("thirdAppData".equals(backupOptionItem.getParent()) && list.contains(backupOptionItem.getOriBackupAppName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getBackupOptionItems$13(List list, BackupOptionItem backupOptionItem) {
        return !list.contains(backupOptionItem.getAppId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getBackupOptionItems$14(BackupOptionItem backupOptionItem) {
        return C14333b.m85445A(backupOptionItem.getAppId()).get().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getBackupOptionItems$15(BackupOptionItem backupOptionItem) {
        return !"thirdApp".equals(backupOptionItem.getParent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getBackupOptionItems$16(BackupOptionItem backupOptionItem) {
        if (backupOptionItem.getAppId().equals("chatSms")) {
            backupOptionItem.setAppId(NavigationUtils.SMS_SCHEMA_PREF);
        } else if (backupOptionItem.getAppId().equals("callRecorder")) {
            backupOptionItem.setAppId("soundrecorder");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ BackupOptionItem lambda$getBackupOptionItems$17(BackupOptionItem backupOptionItem) {
        return backupOptionItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ BackupOptionItem lambda$getBackupOptionItems$18(BackupOptionItem backupOptionItem, BackupOptionItem backupOptionItem2) {
        backupOptionItem.setDataBytes(backupOptionItem.getDataBytes() + backupOptionItem2.getDataBytes());
        return backupOptionItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getBaseDataList$10(BackupOptionItem backupOptionItem) {
        backupOptionItem.setAppName(C12590s0.m75770M(C0213f.m1377a(), backupOptionItem.getAppId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getBaseDataList$9(List list, BackupOptionItem backupOptionItem) {
        return list.contains(backupOptionItem.getAppId()) || ("thirdApp".equals(backupOptionItem.getAppId()) && list.contains("applistStrategy"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$notifyCloudMainShow$8(boolean z10, boolean z11, List list) {
        if (z10 || !z11) {
            C3948f.m24064g().m24078r("cloudbackup", 0);
        } else {
            C3948f.m24064g().m24078r("cloudbackup", list.size());
        }
    }

    private static void notifyCloudMainShow(final List<BackupOptionItem> list) {
        final boolean zM62388s = C10028c.m62182c0().m62388s("backup_key");
        final boolean z10 = !C10028c.m62182c0().m62303a1() && C13452e.m80781L().m80858T0();
        C0226l0.m1586f(new Runnable() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.b0
            @Override // java.lang.Runnable
            public final void run() {
                GetBackupCardInfoTask.lambda$notifyCloudMainShow$8(z10, zM62388s, list);
            }
        });
    }

    private void queryBackupDeviceShow() {
        if (this.mainBackupItemData.isBasicData()) {
            EnumSet<BackupCardTaskOperation> enumSet = this.operations;
            BackupCardTaskOperation backupCardTaskOperation = BackupCardTaskOperation.QUERY_BACKUP_DEVICE_SHOW;
            if (!enumSet.contains(backupCardTaskOperation)) {
                C11839m.m70688i(TAG, "queryBackupDeviceShow false");
                return;
            }
            this.operations.remove(backupCardTaskOperation);
            C11839m.m70688i(TAG, "queryBackupDeviceShow start");
            C12515a.m75110o().m75172d(new AbstractC12367d() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.GetBackupCardInfoTask.1
                @Override // p616rk.AbstractRunnableC12516b
                public void call() throws C9721b {
                    boolean zM64676S0 = new C10542o().m64676S0(false);
                    C11839m.m70688i(GetBackupCardInfoTask.TAG, "hasSuccessBackupDevice: " + zM64676S0);
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 34573;
                    messageObtain.obj = Boolean.valueOf(zM64676S0);
                    CBCallBack.getInstance().sendMessage(messageObtain);
                }
            });
        }
    }

    private static void startCloneTask() {
        C12515a.m75110o().m75172d(new GetOptionsInfoFromCloneTask(false, true, GetOptionsInfoFromCloneTask.cloudBackupUserInfo));
        C11839m.m70688i(TAG, "start GetOptionsInfoFromCloneTask");
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        try {
            boolean zM75941k = C12591s1.m75931a().m75941k();
            C11839m.m70688i(TAG, "GetBackupCardInfoTask start: " + zM75941k + " ," + this.operations);
            if (zM75941k) {
                this.cloudBackupState = C14317j.m85300d().m85305f();
            }
            boolean zM62303a1 = C10028c.m62182c0().m62303a1();
            this.mainBackupItemData.setLoadingModule(false);
            this.mainBackupItemData.setBasicData(TextUtils.equals(C13452e.m80781L().m80790C(), CloudBackupConstant.UserPackageInfo.BASE_DATA_SERVICE));
            this.mainBackupItemData.setNewBmType(C13452e.m80781L().m80887a1());
            this.mainBackupItemData.setBackupOpen(C10028c.m62182c0().m62388s("backup_key"));
            this.mainBackupItemData.setBaseOpen(zM62303a1);
            initState();
            getBackupModuleShow(this.mainBackupItemData.isBackupOpen());
            Message messageObtain = Message.obtain();
            messageObtain.what = 34571;
            messageObtain.obj = this.mainBackupItemData;
            queryBackupDeviceShow();
            this.mainBackupItemData.setOperations(this.operations);
            C11839m.m70688i(TAG, "GetBackupCardInfoTask end: " + this.operations);
            CBCallBack.getInstance().sendMessage(messageObtain);
            C12515a.m75110o().m75165a1(this);
            this.taskEndCallBack.run();
        } catch (Throwable th2) {
            C12515a.m75110o().m75165a1(this);
            this.taskEndCallBack.run();
            throw th2;
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.BACKUP_CARD_INFO;
    }
}
