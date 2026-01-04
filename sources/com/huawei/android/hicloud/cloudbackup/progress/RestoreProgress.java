package com.huawei.android.hicloud.cloudbackup.progress;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.process.BackupPowerKitKeepTimer;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupLanguageUtil;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.cloudbackup.model.CloudRecoveryItem;
import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import com.huawei.hicloud.cloudbackup.model.RestoreStatus;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudRestoreStatusV3;
import com.huawei.hicloud.cloudbackup.store.database.tags.CloudRestoreStatus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0223k;
import p015ak.C0241z;
import p514o9.C11839m;
import p711vl.C13466f;
import p848zl.C14333b;
import sl.C12816g;
import tl.C13035n;

/* loaded from: classes2.dex */
public class RestoreProgress {
    public static final int MODULE_CONTRIBUTION_DEGREE_INDEX = 1;
    private static final Map<String, int[]> MODULE_RESTORE_PHASE_RATIO;
    public static final int MODULE_START_PROGRESS_INDEX = 0;
    public static final int PHASE_RATIO_ARRAY_SIZE = 2;
    private static final String TAG = "RestoreProgress";
    private static List<CloudRestoreItem> itemList = new ArrayList();

    static {
        HashMap map = new HashMap();
        MODULE_RESTORE_PHASE_RATIO = map;
        map.put("prepareDownloadBegin", new int[]{0, 1});
        map.put("prepareDownloadSnapshot", new int[]{1, 5});
        map.put("prepareDownloadInfo", new int[]{6, 3});
        map.put("prepareCreateDirs", new int[]{9, 1});
        map.put("downloadFiles", new int[]{10, 70});
        map.put("downloadApp", new int[]{80, 3});
        map.put("installer", new int[]{83, 2});
        map.put("restoreFiles", new int[]{85, 14});
        map.put("done", new int[]{100, 0});
    }

    private static void addChildListAppForSys(CloudRestoreStatus cloudRestoreStatus, int i10, List<CloudRestoreItem> list) {
        CloudRestoreItem cloudRestoreItem = new CloudRestoreItem();
        cloudRestoreItem.setAppId(cloudRestoreStatus.getAppId()).setAppName(cloudRestoreStatus.getAppName()).setAppType(i10).setBmAppDataType(cloudRestoreStatus.getBmAppDataType()).update(cloudRestoreStatus);
        cloudRestoreItem.m29213z0("thirdApp");
        cloudRestoreItem.setAction(cloudRestoreStatus.getAction() != 2 ? 0 : 2);
        list.add(cloudRestoreItem);
    }

    private static void addChildListAppForSysV3(List<CloudRestoreItem> list, CloudRestoreStatusV3 cloudRestoreStatusV3) {
        CloudRestoreItem cloudRestoreItem = new CloudRestoreItem();
        cloudRestoreItem.setAppId(cloudRestoreStatusV3.getAppId()).setUid(cloudRestoreStatusV3.getUid()).setAppName(cloudRestoreStatusV3.getAppName()).setAppType(cloudRestoreStatusV3.getAppType()).setBmAppDataType(cloudRestoreStatusV3.getBmAppDataType()).setCompatible(cloudRestoreStatusV3.isCompatible()).setHarmonyNext(cloudRestoreStatusV3.isHarmonyNext()).setAppShowType(cloudRestoreStatusV3.getAppShowType()).setAggVirtualAppId(cloudRestoreStatusV3.getAggVirtualAppId()).update(cloudRestoreStatusV3);
        cloudRestoreItem.m29213z0("thirdApp");
        cloudRestoreItem.setAction(cloudRestoreStatusV3.getAction() != 2 ? 0 : 2);
        list.add(cloudRestoreItem);
    }

    private static void addNotSupportAppDataV2(CloudRestoreStatus cloudRestoreStatus, List<CloudRestoreItem> list) {
        if (cloudRestoreStatus.m29530Q() || cloudRestoreStatus.m29549v() != -1) {
            return;
        }
        CloudRestoreItem cloudRestoreItem = new CloudRestoreItem();
        cloudRestoreItem.setAppId(cloudRestoreStatus.getAppId()).setAppName(cloudRestoreStatus.getAppName()).setBmAppDataType(cloudRestoreStatus.getBmAppDataType()).setAppType(cloudRestoreStatus.getAppType()).update(cloudRestoreStatus);
        cloudRestoreItem.setAction(2).setStatus(-1);
        list.add(cloudRestoreItem);
    }

    private static void addNotSupportAppDataV3(CloudRestoreStatusV3 cloudRestoreStatusV3, List<CloudRestoreItem> list) {
        if (cloudRestoreStatusV3.m29498s() == 0 && C0241z.m1688f(cloudRestoreStatusV3.m29496q()) == -1) {
            CloudRestoreItem cloudRestoreItem = new CloudRestoreItem();
            cloudRestoreItem.setAppId(cloudRestoreStatusV3.getAppId()).setUid(cloudRestoreStatusV3.getUid()).setAppName(cloudRestoreStatusV3.getAppName()).setAppType(cloudRestoreStatusV3.getAppType()).setBmAppDataType(cloudRestoreStatusV3.getBmAppDataType()).update(cloudRestoreStatusV3);
            cloudRestoreItem.setAction(2).setStatus(-1);
            cloudRestoreItem.m29213z0("thirdAppData");
            list.add(cloudRestoreItem);
        }
    }

    private static Map<Integer, CloudRestoreItem> buildAggItemMap(List<CloudRestoreStatusV3> list) {
        HashMap map = new HashMap();
        final HashMap map2 = new HashMap();
        for (CloudRestoreStatusV3 cloudRestoreStatusV3 : list) {
            int appShowType = cloudRestoreStatusV3.getAppShowType();
            if (appShowType >= 4) {
                ((List) map.computeIfAbsent(Integer.valueOf(appShowType), new Function() { // from class: com.huawei.android.hicloud.cloudbackup.progress.d
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return RestoreProgress.lambda$buildAggItemMap$0((Integer) obj);
                    }
                })).add(cloudRestoreStatusV3);
            }
        }
        map.forEach(new BiConsumer() { // from class: com.huawei.android.hicloud.cloudbackup.progress.e
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                RestoreProgress.lambda$buildAggItemMap$1(map2, (Integer) obj, (List) obj2);
            }
        });
        return map2;
    }

    private static CloudRestoreItem buildItemFromStatus(CloudRestoreStatusV3 cloudRestoreStatusV3) {
        CloudRestoreItem cloudRestoreItem = new CloudRestoreItem();
        cloudRestoreItem.setAppId(cloudRestoreStatusV3.getAppId()).setAppName(cloudRestoreStatusV3.getAppName()).setAppType(cloudRestoreStatusV3.getAppType()).setAppShowType(cloudRestoreStatusV3.getAppShowType()).setAggVirtualAppId(cloudRestoreStatusV3.getAggVirtualAppId()).setHarmonyNext(cloudRestoreStatusV3.isHarmonyNext()).setCompatible(cloudRestoreStatusV3.isCompatible()).setBmAppDataType(cloudRestoreStatusV3.getBmAppDataType()).update(cloudRestoreStatusV3);
        return cloudRestoreItem;
    }

    public static List<CloudRestoreItem> buildRecoveryItemHarmonyNext(List<CloudRestoreStatusV3> list, boolean z10) {
        return z10 ? buildRecoveryItemUseNewBmHarmonyNext(list) : buildRecoveryItemUseOldBmHarmonyNext(list);
    }

    private static List<CloudRestoreItem> buildRecoveryItemUseNewBm(List<CloudRestoreStatus> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int iM81077e = C13466f.m81073d().m81077e("latest_restore_record_bm_type_key", 1);
        CloudRestoreItem cloudRestoreItemMergeDefaultAppTypeModule = null;
        CloudRestoreItem cloudRestoreItemMergeDefaultAppTypeModule2 = null;
        for (CloudRestoreStatus cloudRestoreStatus : list) {
            if (cloudRestoreStatus.getStatus() < 0) {
                cloudRestoreStatus.setSubStatus("");
            }
            String appId = cloudRestoreStatus.getAppId();
            int appType = cloudRestoreStatus.getAppType();
            if (isBaseAndEmptyData(cloudRestoreStatus)) {
                cloudRestoreStatus.setBmAppDataType(1);
                if (checkBaseModuleData(cloudRestoreStatus)) {
                    addChildListAppForSys(cloudRestoreStatus, appType, arrayList3);
                } else {
                    CloudRestoreItem cloudRestoreItem = new CloudRestoreItem();
                    cloudRestoreItem.setAppId(appId).setAppName(getAppName(appId)).setAppType(appType).setBmAppDataType(1).update(cloudRestoreStatus);
                    updateName(cloudRestoreItem, cloudRestoreStatus);
                    if (RestoreUtil.isSms(appId)) {
                        cloudRestoreItemMergeDefaultAppTypeModule = mergeDefaultAppTypeModule(appId, cloudRestoreItem, cloudRestoreItemMergeDefaultAppTypeModule, appType, arrayList2);
                    } else if (RestoreUtil.isSounds(appId)) {
                        cloudRestoreItemMergeDefaultAppTypeModule2 = mergeDefaultAppTypeModule(appId, cloudRestoreItem, cloudRestoreItemMergeDefaultAppTypeModule2, appType, arrayList2);
                    } else {
                        arrayList2.add(cloudRestoreItem);
                    }
                }
            } else {
                String appName = getAppName(appId);
                CloudRestoreItem cloudRestoreItem2 = new CloudRestoreItem();
                cloudRestoreItem2.setAppId(cloudRestoreStatus.getAppId());
                if (TextUtils.isEmpty(appName)) {
                    updateName(cloudRestoreItem2, cloudRestoreStatus);
                    appName = cloudRestoreItem2.getAppName();
                }
                if (TextUtils.isEmpty(appName)) {
                    appName = cloudRestoreStatus.getAppName();
                }
                cloudRestoreItem2.setAppName(appName).setAppType(appType).setBmAppDataType(2).update(cloudRestoreStatus);
                cloudRestoreItem2.m29213z0("thirdAppData");
                if (RestoreUtil.isSms(appId)) {
                    cloudRestoreItemMergeDefaultAppTypeModule = mergeDefaultAppTypeModule(appId, cloudRestoreItem2, cloudRestoreItemMergeDefaultAppTypeModule, appType, arrayList);
                } else if (RestoreUtil.isSounds(appId)) {
                    cloudRestoreItemMergeDefaultAppTypeModule2 = mergeDefaultAppTypeModule(appId, cloudRestoreItem2, cloudRestoreItemMergeDefaultAppTypeModule2, appType, arrayList);
                } else {
                    if (cloudRestoreItem2.getAction() == 0) {
                        arrayList.add(cloudRestoreItem2);
                    }
                    if (checkFullModuleData(cloudRestoreStatus, iM81077e)) {
                        addChildListAppForSys(cloudRestoreStatus, appType, arrayList3);
                    }
                }
            }
        }
        trimRestoreItemsNewBm(arrayList, arrayList2, arrayList3, false);
        return arrayList;
    }

    private static List<CloudRestoreItem> buildRecoveryItemUseNewBmHarmonyNext(List<CloudRestoreStatusV3> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Map<Integer, CloudRestoreItem> mapBuildAggItemMap = buildAggItemMap(list);
        for (CloudRestoreStatusV3 cloudRestoreStatusV3 : list) {
            cloudRestoreStatusV3.setBmAppDataType(cloudRestoreStatusV3.m29476P() == 3 ? 1 : 2);
            int appShowType = cloudRestoreStatusV3.getAppShowType();
            if (cloudRestoreStatusV3.m29476P() != 3) {
                CloudRestoreItem cloudRestoreItemBuildItemFromStatus = mapBuildAggItemMap.containsKey(Integer.valueOf(appShowType)) ? cloudRestoreStatusV3.getAppId().equals(cloudRestoreStatusV3.getAggVirtualAppId()) ? mapBuildAggItemMap.get(Integer.valueOf(appShowType)) : null : buildItemFromStatus(cloudRestoreStatusV3);
                if (cloudRestoreItemBuildItemFromStatus != null) {
                    cloudRestoreItemBuildItemFromStatus.m29213z0("thirdAppData");
                    arrayList.add(cloudRestoreItemBuildItemFromStatus);
                }
            } else if (mapBuildAggItemMap.containsKey(Integer.valueOf(appShowType))) {
                if (cloudRestoreStatusV3.getAppId().equals(cloudRestoreStatusV3.getAggVirtualAppId())) {
                    arrayList2.add(mapBuildAggItemMap.get(Integer.valueOf(appShowType)));
                }
            } else if (appShowType != 1) {
                arrayList2.add(buildItemFromStatus(cloudRestoreStatusV3));
            } else if (!C14333b.f63655g.contains(cloudRestoreStatusV3.getAppId())) {
                addChildListAppForSysV3(arrayList3, cloudRestoreStatusV3);
            }
        }
        trimRestoreItemsNewBm(arrayList, arrayList2, arrayList3, true);
        return arrayList;
    }

    private static List<CloudRestoreItem> buildRecoveryItemUseOldBm(List<CloudRestoreStatus> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        CloudRestoreItem cloudRestoreItemMergeDefaultAppTypeModule = null;
        CloudRestoreItem cloudRestoreItemMergeDefaultAppTypeModule2 = null;
        for (CloudRestoreStatus cloudRestoreStatus : list) {
            if (cloudRestoreStatus.getStatus() < 0) {
                cloudRestoreStatus.setSubStatus("");
            }
            String appId = cloudRestoreStatus.getAppId();
            int appType = cloudRestoreStatus.getAppType();
            if (appType == -1) {
                CloudRestoreItem cloudRestoreItem = new CloudRestoreItem();
                cloudRestoreItem.setAppId(appId).setAppName(getAppName(appId)).setAppType(appType).update(cloudRestoreStatus);
                arrayList2.add(cloudRestoreItem);
            } else if (appType != 0) {
                if (cloudRestoreStatus.getAction() == 0) {
                    CloudRestoreItem cloudRestoreItem2 = new CloudRestoreItem();
                    cloudRestoreItem2.setAppId(cloudRestoreStatus.getAppId()).setAppName(cloudRestoreStatus.getAppName()).setAppType(appType).update(cloudRestoreStatus);
                    cloudRestoreItem2.m29213z0("thirdAppData");
                    arrayList3.add(cloudRestoreItem2);
                }
                addNotSupportAppDataV2(cloudRestoreStatus, arrayList3);
                addChildListAppForSys(cloudRestoreStatus, appType, arrayList4);
            } else {
                CloudRestoreItem cloudRestoreItem3 = new CloudRestoreItem();
                cloudRestoreItem3.setAppId(appId).setAppName(getAppName(appId)).setAppType(appType).update(cloudRestoreStatus);
                updateName(cloudRestoreItem3, cloudRestoreStatus);
                if (NavigationUtils.SMS_SCHEMA_PREF.equals(appId) || "chatSms".equals(appId)) {
                    cloudRestoreItemMergeDefaultAppTypeModule = mergeDefaultAppTypeModule(appId, cloudRestoreItem3, cloudRestoreItemMergeDefaultAppTypeModule, appType, arrayList);
                } else if ("soundrecorder".equals(appId) || "callRecorder".equals(appId)) {
                    cloudRestoreItemMergeDefaultAppTypeModule2 = mergeDefaultAppTypeModule(appId, cloudRestoreItem3, cloudRestoreItemMergeDefaultAppTypeModule2, appType, arrayList);
                } else {
                    arrayList.add(cloudRestoreItem3);
                }
            }
        }
        trimRestoreItems(arrayList, arrayList2, arrayList3, arrayList4, false);
        return arrayList;
    }

    private static List<CloudRestoreItem> buildRecoveryItemUseOldBmHarmonyNext(List<CloudRestoreStatusV3> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        Map<Integer, CloudRestoreItem> mapBuildAggItemMap = buildAggItemMap(list);
        for (CloudRestoreStatusV3 cloudRestoreStatusV3 : list) {
            int appShowType = cloudRestoreStatusV3.getAppShowType();
            if (appShowType == 0) {
                arrayList.add(buildItemFromStatus(cloudRestoreStatusV3));
            } else if (appShowType != 1) {
                if (appShowType == 2) {
                    arrayList2.add(buildItemFromStatus(cloudRestoreStatusV3));
                } else if (!mapBuildAggItemMap.containsKey(Integer.valueOf(appShowType))) {
                    arrayList.add(buildItemFromStatus(cloudRestoreStatusV3));
                } else if (cloudRestoreStatusV3.getAppId().equals(cloudRestoreStatusV3.getAggVirtualAppId())) {
                    arrayList.add(mapBuildAggItemMap.get(Integer.valueOf(appShowType)));
                }
            } else if (!C14333b.f63655g.contains(cloudRestoreStatusV3.getAppId())) {
                CloudRestoreItem cloudRestoreItemBuildItemFromStatus = buildItemFromStatus(cloudRestoreStatusV3);
                cloudRestoreItemBuildItemFromStatus.m29213z0("thirdApp");
                arrayList4.add(cloudRestoreItemBuildItemFromStatus);
            }
        }
        trimRestoreItems(arrayList, arrayList2, arrayList3, arrayList4, true);
        return arrayList;
    }

    public static List<CloudRestoreItem> buildRestoreItems(List<CloudRestoreStatus> list, boolean z10) {
        return z10 ? buildRecoveryItemUseNewBm(list) : buildRecoveryItemUseOldBm(list);
    }

    public static List<CloudRestoreItem> buildV3RecoveryItem(List<CloudRestoreStatusV3> list, boolean z10) {
        if (list == null) {
            return new ArrayList();
        }
        if (!list.isEmpty()) {
            for (CloudRestoreStatusV3 cloudRestoreStatusV3 : list) {
                if (cloudRestoreStatusV3 != null && cloudRestoreStatusV3.isHarmonyNext()) {
                    return buildRecoveryItemHarmonyNext(list, z10);
                }
            }
        }
        return z10 ? buildV3RecoveryItemUseNewBm(list) : buildV3RecoveryItemUseOldBm(list);
    }

    private static List<CloudRestoreItem> buildV3RecoveryItemUseNewBm(List<CloudRestoreStatusV3> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int iM81077e = C13466f.m81073d().m81077e("latest_restore_record_bm_type_key", 1);
        CloudRestoreItem cloudRestoreItemMergeDefaultAppTypeModule = null;
        CloudRestoreItem cloudRestoreItemMergeDefaultAppTypeModule2 = null;
        for (CloudRestoreStatusV3 cloudRestoreStatusV3 : list) {
            if (cloudRestoreStatusV3.getStatus() < 0) {
                cloudRestoreStatusV3.setSubStatus("");
            }
            String appId = cloudRestoreStatusV3.getAppId();
            if (isBaseAndEmptyData(cloudRestoreStatusV3)) {
                cloudRestoreStatusV3.setBmAppDataType(1);
                if (checkBaseModuleData(cloudRestoreStatusV3)) {
                    addChildListAppForSysV3(arrayList3, cloudRestoreStatusV3);
                } else {
                    CloudRestoreItem cloudRestoreItem = new CloudRestoreItem();
                    cloudRestoreItem.setAppId(appId).setAppName(getAppName(appId)).setAppType(cloudRestoreStatusV3.getAppType()).setBmAppDataType(1).update(cloudRestoreStatusV3);
                    updateName(cloudRestoreItem, cloudRestoreStatusV3);
                    if (RestoreUtil.isSms(appId)) {
                        cloudRestoreItemMergeDefaultAppTypeModule = mergeDefaultAppTypeModule(appId, cloudRestoreItem, cloudRestoreItemMergeDefaultAppTypeModule, cloudRestoreStatusV3.getAppType(), arrayList2);
                    } else if (RestoreUtil.isSounds(appId)) {
                        cloudRestoreItemMergeDefaultAppTypeModule2 = mergeDefaultAppTypeModule(appId, cloudRestoreItem, cloudRestoreItemMergeDefaultAppTypeModule2, cloudRestoreStatusV3.getAppType(), arrayList2);
                    } else {
                        arrayList2.add(cloudRestoreItem);
                    }
                }
            } else {
                String appName = getAppName(appId);
                cloudRestoreStatusV3.setBmAppDataType(2);
                CloudRestoreItem cloudRestoreItem2 = new CloudRestoreItem();
                cloudRestoreItem2.setAppId(cloudRestoreStatusV3.getAppId());
                if (TextUtils.isEmpty(appName)) {
                    updateName(cloudRestoreItem2, cloudRestoreStatusV3);
                    appName = cloudRestoreItem2.getAppName();
                }
                RestoreStatus uid = cloudRestoreItem2.setUid(cloudRestoreStatusV3.getUid());
                if (TextUtils.isEmpty(appName)) {
                    appName = cloudRestoreStatusV3.getAppName();
                }
                uid.setAppName(appName).setAppType(cloudRestoreStatusV3.getAppType()).setBmAppDataType(2).update(cloudRestoreStatusV3);
                cloudRestoreItem2.m29213z0("thirdAppData");
                if (RestoreUtil.isSms(appId)) {
                    cloudRestoreItemMergeDefaultAppTypeModule = mergeDefaultAppTypeModule(appId, cloudRestoreItem2, cloudRestoreItemMergeDefaultAppTypeModule, cloudRestoreStatusV3.getAppType(), arrayList);
                } else if (RestoreUtil.isSounds(appId)) {
                    cloudRestoreItemMergeDefaultAppTypeModule2 = mergeDefaultAppTypeModule(appId, cloudRestoreItem2, cloudRestoreItemMergeDefaultAppTypeModule2, cloudRestoreStatusV3.getAppType(), arrayList);
                } else {
                    if (cloudRestoreItem2.getAction() == 0) {
                        arrayList.add(cloudRestoreItem2);
                    }
                    if (checkFullModuleData(cloudRestoreStatusV3, iM81077e)) {
                        addChildListAppForSysV3(arrayList3, cloudRestoreStatusV3);
                    }
                }
            }
        }
        trimRestoreItemsNewBm(arrayList, arrayList2, arrayList3, false);
        return arrayList;
    }

    private static List<CloudRestoreItem> buildV3RecoveryItemUseOldBm(List<CloudRestoreStatusV3> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        CloudRestoreItem cloudRestoreItemMergeDefaultAppTypeModule = null;
        CloudRestoreItem cloudRestoreItemMergeDefaultAppTypeModule2 = null;
        for (CloudRestoreStatusV3 cloudRestoreStatusV3 : list) {
            int iM29476P = cloudRestoreStatusV3.m29476P();
            if (cloudRestoreStatusV3.getStatus() < 0) {
                cloudRestoreStatusV3.setSubStatus("");
            }
            String appId = cloudRestoreStatusV3.getAppId();
            if (iM29476P == 0) {
                CloudRestoreItem cloudRestoreItem = new CloudRestoreItem();
                cloudRestoreItem.setAppId(appId).setAppName(getAppName(appId)).setAppType(cloudRestoreStatusV3.getAppType()).update(cloudRestoreStatusV3);
                updateName(cloudRestoreItem, cloudRestoreStatusV3);
                if (RestoreUtil.isSms(appId)) {
                    cloudRestoreItemMergeDefaultAppTypeModule = mergeDefaultAppTypeModule(appId, cloudRestoreItem, cloudRestoreItemMergeDefaultAppTypeModule, cloudRestoreStatusV3.getAppType(), arrayList);
                } else if (RestoreUtil.isSounds(appId)) {
                    cloudRestoreItemMergeDefaultAppTypeModule2 = mergeDefaultAppTypeModule(appId, cloudRestoreItem, cloudRestoreItemMergeDefaultAppTypeModule2, cloudRestoreStatusV3.getAppType(), arrayList);
                } else {
                    arrayList.add(cloudRestoreItem);
                }
            } else if (iM29476P != 1) {
                if (cloudRestoreStatusV3.getAction() == 0 && cloudRestoreStatusV3.m29498s() == 1) {
                    CloudRestoreItem cloudRestoreItem2 = new CloudRestoreItem();
                    cloudRestoreItem2.setAppId(cloudRestoreStatusV3.getAppId()).setUid(cloudRestoreStatusV3.getUid()).setAppName(cloudRestoreStatusV3.getAppName()).setAppType(cloudRestoreStatusV3.getAppType()).update(cloudRestoreStatusV3);
                    cloudRestoreItem2.m29213z0("thirdAppData");
                    arrayList3.add(cloudRestoreItem2);
                }
                addNotSupportAppDataV3(cloudRestoreStatusV3, arrayList3);
                addChildListAppForSysV3(arrayList4, cloudRestoreStatusV3);
            } else {
                CloudRestoreItem cloudRestoreItem3 = new CloudRestoreItem();
                cloudRestoreItem3.setAppId(appId).setAppName(getAppName(appId)).setAppType(cloudRestoreStatusV3.getAppType()).update(cloudRestoreStatusV3);
                arrayList2.add(cloudRestoreItem3);
            }
        }
        trimRestoreItems(arrayList, arrayList2, arrayList3, arrayList4, false);
        return arrayList;
    }

    private static boolean checkBaseModuleData(CloudRestoreStatus cloudRestoreStatus) {
        return (C14333b.m85486u().containsKey(cloudRestoreStatus.getAppId()) || cloudRestoreStatus.isVirtual() || (cloudRestoreStatus.getSize() > 0 && cloudRestoreStatus.is3rdAppType())) ? false : true;
    }

    private static boolean checkFullModuleData(RestoreStatus restoreStatus, int i10) {
        return i10 == 2 && restoreStatus.is3rdAppType();
    }

    public static void clearCache() {
        itemList.clear();
    }

    public static String formatData(Context context, long j10) {
        return C0209d.m1157C0(C0223k.m1526i(context, j10, 1024, false, false));
    }

    private static String getAppName(String str) {
        return C2783d.m16079E(getContext(), str);
    }

    private static String getChildId(CloudRestoreItem cloudRestoreItem, RestoreStatus restoreStatus) {
        return ("sysdata".equals(cloudRestoreItem.getAppId()) && restoreStatus.is3rdAppType()) ? "thirdApp" : restoreStatus.getAppId();
    }

    public static List<CloudRestoreItem> getChildList(String str, List<CloudRestoreItem> list) {
        for (CloudRestoreItem cloudRestoreItem : list) {
            List<CloudRestoreItem> listM29202r = cloudRestoreItem.m29202r();
            if (listM29202r != null && !listM29202r.isEmpty()) {
                if (cloudRestoreItem.getAppId().equals(str)) {
                    return listM29202r;
                }
                List<CloudRestoreItem> childList = getChildList(str, listM29202r);
                if (!childList.isEmpty()) {
                    return childList;
                }
            }
        }
        return new ArrayList();
    }

    private static Context getContext() {
        return C0213f.m1377a();
    }

    public static CloudRestoreItem getItem(String str) {
        for (CloudRestoreItem cloudRestoreItem : itemList) {
            if (cloudRestoreItem.getAppId().equals(str)) {
                return cloudRestoreItem;
            }
        }
        return null;
    }

    public static List<CloudRestoreItem> getItemList() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(itemList);
        return arrayList;
    }

    public static long getItemSize(CloudRestoreItem cloudRestoreItem, boolean z10) {
        if (z10 && cloudRestoreItem.getBmAppDataType() == 2) {
            if ("downloadFiles".equals(cloudRestoreItem.getSubStatus())) {
                return cloudRestoreItem.getSize();
            }
            if ("downloadApp".equals(cloudRestoreItem.getSubStatus())) {
                return cloudRestoreItem.getAsize();
            }
        }
        return (1 == cloudRestoreItem.getAction() || TextUtils.equals(cloudRestoreItem.m29203s(), "thirdApp")) ? cloudRestoreItem.getAsize() : TextUtils.equals(cloudRestoreItem.m29203s(), "thirdAppData") ? cloudRestoreItem.getSize() : cloudRestoreItem.getSize() + cloudRestoreItem.getAsize();
    }

    public static int[] getRestoreModulePhaseRatio(String str) {
        return MODULE_RESTORE_PHASE_RATIO.get(str);
    }

    public static List<CloudRestoreItem> getStatusList(String str) {
        return getChildList(str, itemList);
    }

    public static synchronized void initRestoreItems() {
        if (itemList.isEmpty()) {
            C11839m.m70686d(TAG, "initRestoreItems");
            List<CloudRestoreItem> listBuildRestoreItems = buildRestoreItems(new ArrayList(new C13035n().m78553e()), RestoreUtil.isNewBmRecord());
            itemList.clear();
            itemList.addAll(listBuildRestoreItems);
        }
    }

    public static synchronized void initRestoreItemsV3() {
        if (itemList.isEmpty()) {
            C11839m.m70686d(TAG, "initRestoreItemsV3");
            List<CloudRestoreItem> listBuildV3RecoveryItem = buildV3RecoveryItem(new C12816g().m76946j(), RestoreUtil.isNewBmRecord());
            itemList.clear();
            itemList.addAll(listBuildV3RecoveryItem);
        }
    }

    private static boolean isBaseAndEmptyData(CloudRestoreStatus cloudRestoreStatus) {
        return cloudRestoreStatus.getAppType() == 3 || cloudRestoreStatus.getSize() <= 0;
    }

    public static boolean isPrepare(String str) {
        str.hashCode();
        switch (str) {
            case "prepareDownloadBegin":
            case "prepareDownloadSnapshot":
            case "prepareDownloadInfo":
            case "prepareCreateDirs":
                return true;
            default:
                return false;
        }
    }

    public static boolean isValidSubStatus(String str) {
        return MODULE_RESTORE_PHASE_RATIO.containsKey(str);
    }

    public static /* synthetic */ List lambda$buildAggItemMap$0(Integer num) {
        return new ArrayList();
    }

    public static /* synthetic */ void lambda$buildAggItemMap$1(Map map, Integer num, List list) {
        if (list.size() > 1) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            CloudRestoreItem cloudRestoreItemBuildItemFromStatus = null;
            while (it.hasNext()) {
                CloudRestoreStatusV3 cloudRestoreStatusV3 = (CloudRestoreStatusV3) it.next();
                arrayList.add(buildItemFromStatus(cloudRestoreStatusV3));
                if (cloudRestoreStatusV3.getAppId().equals(cloudRestoreStatusV3.getAggVirtualAppId())) {
                    cloudRestoreItemBuildItemFromStatus = buildItemFromStatus(cloudRestoreStatusV3);
                }
            }
            if (cloudRestoreItemBuildItemFromStatus != null) {
                cloudRestoreItemBuildItemFromStatus.m29209v0(arrayList);
                cloudRestoreItemBuildItemFromStatus.m29186L0();
                cloudRestoreItemBuildItemFromStatus.m29182J0();
                cloudRestoreItemBuildItemFromStatus.m29180H0();
                map.put(num, cloudRestoreItemBuildItemFromStatus);
            }
        }
    }

    public static CloudRestoreItem mergeDefaultAppTypeModule(String str, CloudRestoreItem cloudRestoreItem, CloudRestoreItem cloudRestoreItem2, int i10, List<CloudRestoreItem> list) {
        if (RestoreUtil.isSms(str)) {
            str = NavigationUtils.SMS_SCHEMA_PREF;
        } else if (RestoreUtil.isSounds(str)) {
            str = "soundrecorder";
        }
        if (cloudRestoreItem2 != null) {
            cloudRestoreItem2.m29202r().add(cloudRestoreItem);
            cloudRestoreItem2.m29186L0();
            cloudRestoreItem2.m29182J0();
            return cloudRestoreItem2;
        }
        CloudRestoreItem cloudRestoreItem3 = new CloudRestoreItem();
        cloudRestoreItem3.setAppId(str).setAppName(getAppName(str)).setAppType(i10);
        cloudRestoreItem3.m29209v0(new ArrayList()).m29202r().add(cloudRestoreItem);
        cloudRestoreItem3.m29186L0();
        cloudRestoreItem3.m29182J0();
        list.add(cloudRestoreItem3);
        return cloudRestoreItem3;
    }

    private static void sendOneModuleUpdateMessage(CloudRestoreItem cloudRestoreItem, String str) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 32310;
        messageObtain.obj = cloudRestoreItem;
        Bundle bundle = new Bundle();
        bundle.putString("appId", str);
        bundle.putParcelable("item", cloudRestoreItem);
        messageObtain.setData(bundle);
        CBCallBack.getInstance().sendMessage(messageObtain);
    }

    private static void trimRestoreItems(List<CloudRestoreItem> list, List<CloudRestoreItem> list2, List<CloudRestoreItem> list3, List<CloudRestoreItem> list4, boolean z10) {
        Collections.sort(list);
        if (!list4.isEmpty()) {
            CloudRestoreItem cloudRestoreItem = new CloudRestoreItem();
            cloudRestoreItem.setAppId("thirdApp").setAppName(getAppName("thirdApp")).setAppType(3).setCount(list4.size()).m29209v0(list4).setHarmonyNext(z10).m29186L0();
            if (z10) {
                cloudRestoreItem.m29181I0();
            }
            cloudRestoreItem.m29182J0();
            list2.add(cloudRestoreItem);
        }
        if (!list2.isEmpty()) {
            Collections.sort(list2);
            CloudRestoreItem cloudRestoreItem2 = new CloudRestoreItem();
            cloudRestoreItem2.setAppId("sysdata").setAppName(getAppName("sysdata")).setAppType(-1).setCount(list2.size()).m29209v0(list2).setHarmonyNext(z10).m29186L0();
            if (z10) {
                cloudRestoreItem2.m29181I0();
            }
            cloudRestoreItem2.m29182J0();
            list.add(cloudRestoreItem2);
        }
        if (list3.isEmpty()) {
            return;
        }
        Collections.sort(list3);
        CloudRestoreItem cloudRestoreItem3 = new CloudRestoreItem();
        cloudRestoreItem3.setAppId("thirdAppData").setAppName(getAppName("thirdAppData")).setAppType(3).setCount(list3.size()).m29209v0(list3).setHarmonyNext(z10).m29186L0();
        if (z10) {
            cloudRestoreItem3.m29181I0();
        }
        cloudRestoreItem3.m29182J0();
        list.add(cloudRestoreItem3);
    }

    private static void trimRestoreItemsNewBm(List<CloudRestoreItem> list, List<CloudRestoreItem> list2, List<CloudRestoreItem> list3, boolean z10) {
        Collections.sort(list);
        if (!list3.isEmpty()) {
            CloudRestoreItem cloudRestoreItem = new CloudRestoreItem();
            cloudRestoreItem.setAppId("thirdApp").setAppName(getAppName("thirdApp")).setAppType(3).setCount(list3.size()).m29209v0(list3).setHarmonyNext(z10).m29186L0();
            if (z10) {
                cloudRestoreItem.m29181I0();
            }
            cloudRestoreItem.m29182J0();
            list2.add(cloudRestoreItem);
        }
        if (list2.isEmpty()) {
            return;
        }
        Collections.sort(list2);
        CloudRestoreItem cloudRestoreItem2 = new CloudRestoreItem();
        cloudRestoreItem2.setAppId("bmBaseData").setAppName(getAppName("bmBaseData")).setAppType(-1).m29209v0(list2).setHarmonyNext(z10).m29186L0();
        if (z10) {
            cloudRestoreItem2.m29181I0();
        }
        cloudRestoreItem2.m29182J0();
        cloudRestoreItem2.setCount(list2.size());
        list.add(0, cloudRestoreItem2);
    }

    private static void updateName(CloudRestoreItem cloudRestoreItem, RestoreStatus restoreStatus) {
        if (cloudRestoreItem.getAppName().isEmpty()) {
            String virtualName = CloudBackupLanguageUtil.getVirtualName(cloudRestoreItem.getAppId());
            if (virtualName == null || virtualName.isEmpty()) {
                virtualName = restoreStatus.getAppName();
            }
            cloudRestoreItem.setAppName(virtualName);
        }
    }

    public static void updateRestoreItemsCompatibility(CloudRecoveryItem cloudRecoveryItem) {
        cloudRecoveryItem.getItemList().forEach(new C2660a());
        int size = cloudRecoveryItem.getItemList().size();
        long jCount = cloudRecoveryItem.getItemList().stream().filter(new C2661b()).count();
        boolean zAnyMatch = cloudRecoveryItem.getItemList().stream().anyMatch(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.progress.c
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((CloudRestoreItem) obj).m29183K();
            }
        });
        if (jCount == size) {
            cloudRecoveryItem.setModuleCompatibility(2);
            if (zAnyMatch) {
                cloudRecoveryItem.setModuleCompatibility(1);
                return;
            }
            return;
        }
        if (jCount == 0) {
            cloudRecoveryItem.setModuleCompatibility(0);
        } else {
            cloudRecoveryItem.setModuleCompatibility(1);
        }
    }

    public static void updateStatus(RestoreStatus restoreStatus) {
        BackupPowerKitKeepTimer.getInstance().keepAlive();
        CBAccess.keepLock();
        updateStatus(restoreStatus, itemList);
    }

    private static boolean isBaseAndEmptyData(CloudRestoreStatusV3 cloudRestoreStatusV3) {
        return cloudRestoreStatusV3.m29476P() == 3 || cloudRestoreStatusV3.getSize() <= 0;
    }

    private static boolean checkBaseModuleData(CloudRestoreStatusV3 cloudRestoreStatusV3) {
        return (C14333b.m85486u().containsKey(cloudRestoreStatusV3.getAppId()) || 5 == cloudRestoreStatusV3.getAppType() || (cloudRestoreStatusV3.getSize() > 0 && cloudRestoreStatusV3.is3rdAppType())) ? false : true;
    }

    private static boolean updateStatus(RestoreStatus restoreStatus, List<CloudRestoreItem> list) {
        String appId = restoreStatus.getAppId();
        int uid = restoreStatus.getUid();
        Iterator<CloudRestoreItem> it = list.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            CloudRestoreItem next = it.next();
            List<CloudRestoreItem> listM29202r = next.m29202r();
            if (listM29202r != null) {
                if (updateStatus(restoreStatus, listM29202r)) {
                    next.m29186L0();
                    sendOneModuleUpdateMessage(next, getChildId(next, restoreStatus));
                    z10 = true;
                }
            } else if (appId.equals(next.getAppId()) && uid == next.getUid() && next.getAction() != 2) {
                next.update(restoreStatus);
                next.m29186L0();
                if ((!"soundrecorder".equals(appId) && !"callRecorder".equals(appId) && !NavigationUtils.SMS_SCHEMA_PREF.equals(appId) && !"chatSms".equals(appId) && !next.m29190O()) || NextRestoreConstants.BUNDLE_NAME_GALLERY.equals(appId)) {
                    sendOneModuleUpdateMessage(next, appId);
                }
                return true;
            }
        }
        return z10;
    }
}
