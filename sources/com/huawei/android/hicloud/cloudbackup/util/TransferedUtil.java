package com.huawei.android.hicloud.cloudbackup.util;

import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.constants.HNConstants;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p015ak.C0213f;
import p514o9.C11839m;
import p617rl.C12519c;
import p618rm.C12580p;
import p618rm.C12591s1;
import p618rm.C12597u1;
import p709vj.C13452e;
import p711vl.C13465e;
import p848zl.C14333b;
import pm.C12176c;
import tl.C13026e;

/* loaded from: classes2.dex */
public class TransferedUtil {
    private static final String BASE_LIST = "baseList";
    private static final String MEDIA_LIST = "mediaList";
    private static final String MESSAGE_LIST = "messageList";
    public static final String TAG = "TransferedUtil";
    private static final String THIRD_LIST = "thirdList";

    private static void build3rdItem(List<BackupOptionItem> list, List<BackupOptionItem> list2) {
        if (list.isEmpty()) {
            return;
        }
        Collections.sort(list, new C2736u());
        list2.add(list.get(0));
    }

    private static void buildBaseItem(List<BackupOptionItem> list, List<BackupOptionItem> list2) {
        if (list.isEmpty()) {
            return;
        }
        int itemTotal = 0;
        int i10 = 0;
        long dataBytes = 0;
        long totalIncrease = 0;
        for (BackupOptionItem backupOptionItem : list) {
            dataBytes += backupOptionItem.getDataBytes();
            itemTotal += backupOptionItem.getItemTotal();
            i10++;
            if (backupOptionItem.getTotalIncrease() > 0) {
                totalIncrease += backupOptionItem.getTotalIncrease();
            }
        }
        BackupOptionItem backupOptionItem2 = new BackupOptionItem();
        backupOptionItem2.setAppId("baseData");
        backupOptionItem2.setDataBytes(dataBytes);
        backupOptionItem2.setTotalIncrease(totalIncrease);
        backupOptionItem2.setItemTotal(itemTotal);
        backupOptionItem2.setBackupSwitch(true);
        backupOptionItem2.setSwitchCount(i10);
        list2.add(backupOptionItem2);
    }

    private static void buildMediaItem(List<BackupOptionItem> list, List<BackupOptionItem> list2) {
        if (list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        BackupOptionItem backupOptionItem = new BackupOptionItem("soundrecorder", "soundrecorder");
        for (BackupOptionItem backupOptionItem2 : list) {
            if ("soundrecorder".equals(backupOptionItem2.getParent())) {
                mergeComponentModule(backupOptionItem, backupOptionItem2);
            } else if (backupOptionItem2.getIsDataEnable() != -1) {
                if (!"virtualApp".equals(backupOptionItem2.getParent()) || "music".equals(backupOptionItem2.getAppId())) {
                    arrayList.add(backupOptionItem2);
                } else {
                    arrayList2.add(backupOptionItem2);
                }
            }
        }
        if (backupOptionItem.getItemTotal() > 0) {
            arrayList.add(backupOptionItem);
        }
        if (arrayList.isEmpty() && arrayList2.isEmpty()) {
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(HNConstants.DataType.MEDIA);
        arrayList3.add("calendar");
        arrayList3.add("Memo");
        arrayList3.add("soundrecorder");
        arrayList3.add("music");
        sort(arrayList, arrayList3);
        Collections.sort(arrayList2, new C2736u());
        arrayList.addAll(arrayList2);
        list2.add((BackupOptionItem) arrayList.get(0));
    }

    private static void buildMessageItem(List<BackupOptionItem> list, List<BackupOptionItem> list2) {
        if (list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        BackupOptionItem backupOptionItem = new BackupOptionItem(NavigationUtils.SMS_SCHEMA_PREF, NavigationUtils.SMS_SCHEMA_PREF);
        for (BackupOptionItem backupOptionItem2 : list) {
            if (NavigationUtils.SMS_SCHEMA_PREF.equals(backupOptionItem2.getParent())) {
                mergeComponentModule(backupOptionItem, backupOptionItem2);
            } else if (backupOptionItem2.getIsDataEnable() != -1) {
                arrayList.add(backupOptionItem2);
            }
        }
        if (backupOptionItem.getItemTotal() > 0) {
            arrayList.add(backupOptionItem);
        }
        if (arrayList.isEmpty()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(HNConstants.DataType.CONTACT);
        arrayList2.add(NavigationUtils.SMS_SCHEMA_PREF);
        arrayList2.add("calllog");
        sort(arrayList, arrayList2);
        list2.add((BackupOptionItem) arrayList.get(0));
    }

    public static void dealSpecialItem(BackupOptionItem backupOptionItem) {
        String appId = backupOptionItem.getAppId();
        appId.hashCode();
        switch (appId) {
            case "callRecorder":
                BackupOptionItem backupOptionItem2 = (BackupOptionItem) C13465e.m81052f().m81059h("soundrecorder", BackupOptionItem.class);
                if (backupOptionItem2 != null) {
                    backupOptionItem.setBackupSwitch(backupOptionItem2.getBackupSwitch());
                    break;
                }
                break;
            case "sms":
                BackupOptionItem backupOptionItem3 = (BackupOptionItem) C13465e.m81052f().m81059h("chatSms", BackupOptionItem.class);
                if (backupOptionItem3 != null) {
                    long dataBytes = backupOptionItem.getDataBytes() - backupOptionItem3.getDataBytes();
                    int itemTotal = backupOptionItem.getItemTotal() - backupOptionItem3.getItemTotal();
                    backupOptionItem.setDataBytes(Math.max(dataBytes, 0L));
                    backupOptionItem.setItemTotal(Math.max(itemTotal, 0));
                    break;
                }
                break;
            case "chatSms":
                BackupOptionItem backupOptionItem4 = (BackupOptionItem) C13465e.m81052f().m81059h(NavigationUtils.SMS_SCHEMA_PREF, BackupOptionItem.class);
                if (backupOptionItem4 != null) {
                    backupOptionItem.setBackupSwitch(backupOptionItem4.getBackupSwitch());
                    break;
                }
                break;
            case "soundrecorder":
                BackupOptionItem backupOptionItem5 = (BackupOptionItem) C13465e.m81052f().m81059h("callRecorder", BackupOptionItem.class);
                if (backupOptionItem5 != null) {
                    long dataBytes2 = backupOptionItem.getDataBytes() - backupOptionItem5.getDataBytes();
                    int itemTotal2 = backupOptionItem.getItemTotal() - backupOptionItem5.getItemTotal();
                    backupOptionItem.setDataBytes(Math.max(dataBytes2, 0L));
                    backupOptionItem.setItemTotal(Math.max(itemTotal2, 0));
                    break;
                }
                break;
        }
    }

    private static BackupOptionItem getBackupOptionItem(BackupOptionItem backupOptionItem, String str, C13026e c13026e) {
        BackupOptionItem backupOptionItem2;
        if (backupOptionItem != null || (backupOptionItem2 = (BackupOptionItem) C13465e.m81052f().m81059h(str, BackupOptionItem.class)) == null) {
            return backupOptionItem;
        }
        backupOptionItem2.setParent(getItemParent(str));
        try {
            c13026e.m78370E(backupOptionItem2);
            C13465e.m81052f().m81068q(backupOptionItem2.getAppId());
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "queryItem" + e10.getMessage());
        }
        return backupOptionItem2;
    }

    private static Map<String, List<BackupOptionItem>> getBackupOptionItems() {
        HashMap map = new HashMap();
        C13026e c13026e = new C13026e(C12591s1.m75931a().m75941k());
        C14333b.m85463S(new C12519c().m75301l());
        List<BackupOptionItem> listM78397u = c13026e.m78397u();
        if (listM78397u.isEmpty()) {
            return map;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (BackupOptionItem backupOptionItem : listM78397u) {
            if (backupOptionItem.getBackupSwitch() && backupOptionItem.getIsDataEnable() != -1 && backupOptionItem.getTotalIncrease() > 0) {
                String parent = backupOptionItem.getParent();
                if ("baseData".equals(parent)) {
                    arrayList.add(backupOptionItem);
                } else if ("thirdAppData".equals(parent)) {
                    arrayList4.add(backupOptionItem);
                } else if (isMessage(parent)) {
                    arrayList2.add(backupOptionItem);
                } else if (isMedia(parent) && (!HNConstants.DataType.MEDIA.equals(backupOptionItem.getAppId()) || ICBUtil.isSupportGallery(C0213f.m1377a()))) {
                    arrayList3.add(backupOptionItem);
                }
            }
        }
        map.put(BASE_LIST, arrayList);
        map.put(MESSAGE_LIST, arrayList2);
        map.put(MEDIA_LIST, arrayList3);
        map.put(THIRD_LIST, arrayList4);
        return map;
    }

    public static String getItemParent(String str) {
        return new ArrayList(C14333b.m85482q()).contains(str) ? "baseData" : (NavigationUtils.SMS_SCHEMA_PREF.equals(str) || "chatSms".equals(str)) ? NavigationUtils.SMS_SCHEMA_PREF : ("callRecorder".equals(str) || "soundrecorder".equals(str)) ? "soundrecorder" : !new ArrayList(C14333b.m85476k()).contains(str) ? "thirdAppData" : str;
    }

    private static boolean isContains(List<BackupOptionItem> list, String str) {
        if (list.isEmpty()) {
            return false;
        }
        for (BackupOptionItem backupOptionItem : list) {
            if (backupOptionItem != null && TextUtils.equals(backupOptionItem.getAppId(), str)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isMedia(String str) {
        return HNConstants.DataType.MEDIA.equals(str) || "soundrecorder".equals(str) || "music".equals(str) || "calendar".equals(str) || "Memo".equals(str) || "virtualApp".equals(str);
    }

    private static boolean isMessage(String str) {
        return NavigationUtils.SMS_SCHEMA_PREF.equals(str) || "calllog".equals(str) || HNConstants.DataType.CONTACT.equals(str);
    }

    public static boolean isV3() {
        return "2".equals(new SettingOperator().queryUploadTargetStrategy());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$sort$1(List list, BackupOptionItem backupOptionItem, BackupOptionItem backupOptionItem2) {
        int iIndexOf = list.indexOf(backupOptionItem.getAppId());
        int iIndexOf2 = list.indexOf(backupOptionItem2.getAppId());
        if (iIndexOf < 0) {
            return 1;
        }
        if (iIndexOf2 < 0) {
            return -1;
        }
        return Integer.compare(iIndexOf, iIndexOf2);
    }

    private static void mergeComponentModule(BackupOptionItem backupOptionItem, BackupOptionItem backupOptionItem2) {
        backupOptionItem.setDataBytes(backupOptionItem.getDataBytes() + backupOptionItem2.getDataBytes());
        backupOptionItem.setTotalIncrease(backupOptionItem.getTotalIncrease() + backupOptionItem2.getTotalIncrease());
        backupOptionItem.setItemTotal(backupOptionItem.getItemTotal() + backupOptionItem2.getItemTotal());
        backupOptionItem.setBackupSwitch(true);
        backupOptionItem.setIsDataEnable(0);
        backupOptionItem.setSwitchCount(backupOptionItem.getSwitchCount() + 1);
    }

    public static BackupOptionItem queryItem(String str, boolean z10) {
        if ("baseData".equals(str) || "thirdAppData".equals(str)) {
            return null;
        }
        return queryItemByAppId(str, new C13026e(z10));
    }

    public static BackupOptionItem queryItemByAppId(String str, C13026e c13026e) {
        if ("baseData".equals(str) || "thirdAppData".equals(str)) {
            return null;
        }
        return getBackupOptionItem(c13026e.m78401y(str), str, c13026e);
    }

    public static BackupOptionItem queryMergeTwinItem(String str, boolean z10) {
        return queryItem(str, z10);
    }

    public static List<BackupOptionItem> queryRecommendOptions() {
        ArrayList arrayList = new ArrayList();
        Map<String, List<BackupOptionItem>> backupOptionItems = getBackupOptionItems();
        ArrayList arrayList2 = new ArrayList(backupOptionItems.getOrDefault(THIRD_LIST, new ArrayList()));
        ArrayList arrayList3 = new ArrayList(backupOptionItems.getOrDefault(BASE_LIST, new ArrayList()));
        ArrayList arrayList4 = new ArrayList(backupOptionItems.getOrDefault(MEDIA_LIST, new ArrayList()));
        ArrayList arrayList5 = new ArrayList(backupOptionItems.getOrDefault(MESSAGE_LIST, new ArrayList()));
        buildBaseItem(arrayList3, arrayList);
        buildMessageItem(arrayList5, arrayList);
        buildMediaItem(arrayList4, arrayList);
        build3rdItem(arrayList2, arrayList);
        return arrayList;
    }

    public static List<BackupOptionItem> querySortedBackupDataExcludeSystemApp() {
        boolean z10;
        boolean z11;
        boolean z12;
        ArrayList arrayList = new ArrayList();
        List<BackupOptionItem> listM78397u = new C13026e(C12591s1.m75931a().m75941k()).m78397u();
        List arrayList2 = new ArrayList();
        boolean zM80887a1 = C13452e.m80781L().m80887a1();
        if (zM80887a1) {
            arrayList2 = C12176c.m73271n(null);
        }
        BackupOptionItem backupOptionItem = new BackupOptionItem("soundrecorder", "soundrecorder");
        BackupOptionItem backupOptionItem2 = new BackupOptionItem(NavigationUtils.SMS_SCHEMA_PREF, NavigationUtils.SMS_SCHEMA_PREF);
        List<String> listM76026b = C12597u1.m76026b();
        boolean z13 = false;
        if (listM78397u == null || listM78397u.isEmpty()) {
            z10 = false;
            z11 = false;
            z12 = false;
        } else {
            z10 = false;
            z11 = false;
            z12 = false;
            for (BackupOptionItem backupOptionItem3 : listM78397u) {
                if (!zM80887a1 || !arrayList2.contains(backupOptionItem3.getAppId())) {
                    if (!"baseData".equals(backupOptionItem3.getParent()) && backupOptionItem3.getBackupSwitch() && !listM76026b.contains(backupOptionItem3.getAppId()) && backupOptionItem3.getDataBytes() > 0) {
                        if ("soundrecorder".equals(backupOptionItem3.getAppId())) {
                            mergeComponentModule(backupOptionItem, backupOptionItem3);
                            z13 = true;
                        } else if ("callRecorder".equals(backupOptionItem3.getAppId())) {
                            mergeComponentModule(backupOptionItem, backupOptionItem3);
                            z10 = true;
                        } else if (NavigationUtils.SMS_SCHEMA_PREF.equals(backupOptionItem3.getAppId())) {
                            mergeComponentModule(backupOptionItem2, backupOptionItem3);
                            z11 = true;
                        } else if ("chatSms".equals(backupOptionItem3.getAppId())) {
                            mergeComponentModule(backupOptionItem2, backupOptionItem3);
                            z12 = true;
                        } else {
                            arrayList.add(backupOptionItem3);
                        }
                    }
                }
            }
        }
        if (z13 || z10) {
            arrayList.add(backupOptionItem);
        }
        if (z11 || z12) {
            arrayList.add(backupOptionItem2);
        }
        arrayList.sort(new Comparator() { // from class: com.huawei.android.hicloud.cloudbackup.util.v
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C12580p.m75564B((BackupOptionItem) obj, (BackupOptionItem) obj2);
            }
        });
        return arrayList;
    }

    public static List<BackupOptionItem> queryWaitBackupOptions() {
        ArrayList arrayList = new ArrayList();
        Map<String, List<BackupOptionItem>> backupOptionItems = getBackupOptionItems();
        ArrayList arrayList2 = new ArrayList(backupOptionItems.getOrDefault(THIRD_LIST, new ArrayList()));
        ArrayList arrayList3 = new ArrayList(backupOptionItems.getOrDefault(BASE_LIST, new ArrayList()));
        ArrayList arrayList4 = new ArrayList(backupOptionItems.getOrDefault(MEDIA_LIST, new ArrayList()));
        build3rdItem(arrayList2, arrayList);
        buildBaseItem(arrayList3, arrayList);
        buildMediaItem(arrayList4, arrayList);
        return arrayList;
    }

    private static void sort(List<BackupOptionItem> list, final List<String> list2) {
        Collections.sort(list, new Comparator() { // from class: com.huawei.android.hicloud.cloudbackup.util.w
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return TransferedUtil.lambda$sort$1(list2, (BackupOptionItem) obj, (BackupOptionItem) obj2);
            }
        });
    }

    public static void transferData() {
        if (C13465e.m81052f().m81054b("baseData")) {
            C11839m.m70688i(TAG, "transfer begin");
            C13026e c13026e = new C13026e();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList(C14333b.m85477l());
            List list = (List) C13465e.m81052f().m81060i("thirdAppModule", new TypeToken<ArrayList<String>>() { // from class: com.huawei.android.hicloud.cloudbackup.util.TransferedUtil.1
            }.getType());
            ArrayList<String> arrayList3 = new ArrayList(arrayList2);
            if (list != null && !list.isEmpty()) {
                arrayList3.addAll(list);
            }
            arrayList3.add(HNConstants.DataType.MEDIA);
            arrayList3.add("music");
            for (String str : arrayList3) {
                BackupOptionItem backupOptionItem = (BackupOptionItem) C13465e.m81052f().m81059h(str, BackupOptionItem.class);
                if (backupOptionItem != null && c13026e.m78401y(backupOptionItem.getAppId()) == null) {
                    dealSpecialItem(backupOptionItem);
                    backupOptionItem.setParent(getItemParent(str));
                    arrayList.add(backupOptionItem);
                }
            }
            try {
                if (!arrayList.isEmpty()) {
                    c13026e.m78383d(arrayList);
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        C13465e.m81052f().m81068q((String) it.next());
                    }
                }
                C13465e.m81052f().m81068q("baseData");
                C13465e.m81052f().m81068q("thirdAppData");
                C13465e.m81052f().m81068q("thirdAppModule");
                C13465e.m81052f().m81068q("systemModule");
                C11839m.m70688i(TAG, "transfer end");
            } catch (C9721b e10) {
                C11839m.m70687e(TAG, "transfer item error: " + e10.getMessage());
            }
        }
    }

    public static BackupOptionItem queryItem(String str, C13026e c13026e) {
        return queryItemByAppId(str, c13026e);
    }

    public static BackupOptionItem queryItem(String str, int i10, boolean z10) {
        if ("baseData".equals(str) || "thirdAppData".equals(str)) {
            return null;
        }
        return queryItem(str, i10, new C13026e(z10));
    }

    public static BackupOptionItem queryItem(String str, int i10, C13026e c13026e) {
        if ("baseData".equals(str) || "thirdAppData".equals(str)) {
            return null;
        }
        return getBackupOptionItem(c13026e.m78401y(str), str, c13026e);
    }
}
