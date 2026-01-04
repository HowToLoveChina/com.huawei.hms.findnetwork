package com.huawei.android.hicloud.sync.wifi.datamanager;

import ad.C0100a;
import android.content.Context;
import android.net.wifi.WifiConfiguration;
import fk.C9722c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import je.C10781c0;
import p015ak.C0209d;
import p015ak.C0227m;
import p514o9.C11839m;
import tc.C13007b;

/* loaded from: classes3.dex */
public class WlanManager {
    private static final int ANDROID_VERSION_N = 24;
    private static final String CLASS_NAME = "com.huawei.android.app.PackageManagerEx";
    private static final String METHOD_NAME = "finishBackupSession";
    private static final String TAG = "WlanManager";
    private Context mContext;
    private ExtractWiFi parser;
    private Map<String, SyncWlanBean> prepareMap = null;

    public WlanManager(Context context) {
        if (C0209d.m1277l1() || isSupportPMS()) {
            C11839m.m70688i(TAG, "syncWlanPMS support pms");
            this.parser = new ExtractOWiFiByPMS(context);
        } else {
            this.parser = new ExtractOWiFi(context);
        }
        C0100a.m713m(context);
        this.mContext = context;
    }

    private HashMap<String, WifiConfiguration> getLocalWifiConfig() {
        C11839m.m70686d(TAG, "getLocalWifiConfig , put wifiConfigSet");
        HashMap<String, WifiConfiguration> map = new HashMap<>();
        List<WifiConfiguration> configuration = this.parser.getConfiguration();
        if (!configuration.isEmpty()) {
            for (WifiConfiguration wifiConfiguration : configuration) {
                map.put(wifiConfiguration.SSID, wifiConfiguration);
            }
        }
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean isSupportPMS() throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        /*
            java.lang.String r0 = "WlanManager"
            r1 = 0
            r2 = 1
            java.lang.String r3 = "com.huawei.android.app.PackageManagerEx"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.Exception -> L17 java.lang.RuntimeException -> L19
            java.lang.String r4 = "finishBackupSession"
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch: java.lang.Exception -> L17 java.lang.RuntimeException -> L19
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L17 java.lang.RuntimeException -> L19
            r5[r1] = r6     // Catch: java.lang.Exception -> L17 java.lang.RuntimeException -> L19
            java.lang.reflect.Method r3 = r3.getMethod(r4, r5)     // Catch: java.lang.Exception -> L17 java.lang.RuntimeException -> L19
            goto L4d
        L17:
            r3 = move-exception
            goto L1b
        L19:
            r3 = move-exception
            goto L34
        L1b:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Exception: "
            r4.append(r5)
            java.lang.String r3 = r3.toString()
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            p514o9.C11839m.m70687e(r0, r3)
            goto L4c
        L34:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "RuntimeException"
            r4.append(r5)
            java.lang.String r3 = r3.getMessage()
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            p514o9.C11839m.m70687e(r0, r3)
        L4c:
            r3 = 0
        L4d:
            if (r3 != 0) goto L55
            java.lang.String r2 = "not support PMS"
            p514o9.C11839m.m70688i(r0, r2)
            return r1
        L55:
            java.lang.String r1 = "support PMS"
            p514o9.C11839m.m70688i(r0, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.sync.wifi.datamanager.WlanManager.isSupportPMS():boolean");
    }

    public ArrayList<String> deleteData(List<String> list, boolean z10) {
        C11839m.m70686d(TAG, "deleteData, isExit = " + z10 + ",deleteData = " + list.toString());
        HashMap<String, WifiConfiguration> localWifiConfig = getLocalWifiConfig();
        String connectSsid = this.parser.getConnectSsid();
        ArrayList<String> arrayList = new ArrayList<>();
        List<String> listM65632b = C10781c0.m65632b(this.mContext);
        for (int i10 = 0; i10 < list.size(); i10++) {
            String str = list.get(i10);
            if (localWifiConfig.containsKey(str)) {
                C11839m.m70686d(TAG, "deleteData begin1,contacin ssid :" + str);
                if (str.equals(connectSsid)) {
                    C11839m.m70688i(TAG, "deleteData, ssid is connecting");
                    C13007b.m78205Y(this.mContext).m78275n0();
                } else {
                    C11839m.m70686d(TAG, "deleteData begin2 ssid :" + str);
                    if (z10) {
                        this.parser.forgetNetWork(localWifiConfig.get(str));
                    } else {
                        if (C10781c0.m65631a(listM65632b, str)) {
                            C11839m.m70688i(TAG, "deleteData: is vehicle ssid, filtering delete local..");
                        } else if (this.parser.deleteNetWork(localWifiConfig.get(str))) {
                        }
                        arrayList.add(str);
                    }
                }
            }
        }
        return arrayList;
    }

    public boolean isHaveChange() throws C9722c {
        C11839m.m70688i(TAG, "Enter isHaveChange");
        Map<String, SyncWlanBean> mapPrpeData = prpeData();
        Map<String, SyncWlanBean> mapM712l = C0100a.m712l();
        if (mapM712l.size() == 0 || mapPrpeData.size() == 0) {
            return true;
        }
        for (Map.Entry<String, SyncWlanBean> entry : mapPrpeData.entrySet()) {
            String key = entry.getKey();
            SyncWlanBean value = entry.getValue();
            if (!mapM712l.containsKey(key) || (mapM712l.get(key) != null && !mapM712l.get(key).getHash().equals(value.getHash()))) {
                return true;
            }
        }
        Iterator<Map.Entry<String, SyncWlanBean>> it = mapM712l.entrySet().iterator();
        while (it.hasNext()) {
            if (!mapPrpeData.containsKey(it.next().getKey())) {
                return true;
            }
        }
        return false;
    }

    public boolean localHaveData() {
        C11839m.m70686d(TAG, "localHaveData");
        return this.parser.hasLocalData();
    }

    public HashMap<String, Map<String, SyncWlanBean>> prepareLocalData() throws C9722c {
        C11839m.m70688i(TAG, "Enter prepareLocalData");
        Map<String, SyncWlanBean> mapPrpeGetLocalData = prpeGetLocalData();
        HashMap map = new HashMap(10);
        HashMap map2 = new HashMap(10);
        HashMap map3 = new HashMap(10);
        HashMap map4 = new HashMap(10);
        HashMap<String, Map<String, SyncWlanBean>> map5 = new HashMap<>();
        Map<String, SyncWlanBean> mapM709i = C0100a.m709i();
        if (mapM709i.size() == 0) {
            map.putAll(mapPrpeGetLocalData);
            map5.put("0", map);
        }
        if (mapPrpeGetLocalData.size() == 0) {
            for (Map.Entry<String, SyncWlanBean> entry : mapM709i.entrySet()) {
                map3.put(entry.getKey(), entry.getValue());
                C0100a.m718r(entry.getKey(), 1);
                map5.put("2", map3);
            }
        }
        for (Map.Entry<String, SyncWlanBean> entry2 : mapPrpeGetLocalData.entrySet()) {
            String key = entry2.getKey();
            SyncWlanBean value = entry2.getValue();
            if (mapM709i.containsKey(key)) {
                value.setGuid(mapM709i.get(key).getGuid());
                if (mapM709i.get(key) == null || mapM709i.get(key).getHash().equals(value.getHash())) {
                    map4.put(key, value);
                    C0100a.m718r(key, 0);
                } else {
                    map2.put(key, value);
                    C0100a.m718r(key, 2);
                }
            } else {
                map.put(key, value);
            }
        }
        for (Map.Entry<String, SyncWlanBean> entry3 : mapM709i.entrySet()) {
            String key2 = entry3.getKey();
            if (!mapPrpeGetLocalData.containsKey(key2)) {
                map3.put(key2, entry3.getValue());
                C0100a.m718r(key2, 1);
            }
        }
        map5.put("0", map);
        map5.put("1", map2);
        map5.put("2", map3);
        map5.put("3", map4);
        return map5;
    }

    public Map<String, SyncWlanBean> prpeData() throws C9722c {
        C11839m.m70688i(TAG, "Enter prpeData");
        List<WlanBean> localWiFis = this.parser.getLocalWiFis();
        if (localWiFis == null) {
            throw new C9722c(2005, "Prepare data, wifiList is null", "wlan", "local_pre_sync");
        }
        HashMap map = new HashMap(10);
        for (WlanBean wlanBean : localWiFis) {
            SyncWlanBean syncWlanBean = new SyncWlanBean();
            syncWlanBean.setLuid(wlanBean.getSsid());
            syncWlanBean.setHash(C0227m.m1593f(wlanBean.toString()));
            syncWlanBean.setData(wlanBean);
            map.put(wlanBean.getSsid(), syncWlanBean);
        }
        return map;
    }

    public Map<String, SyncWlanBean> prpeGetLocalData() throws C9722c {
        C11839m.m70688i(TAG, "Enter prpeGetLocalData");
        List<WlanBean> localWiFis = this.parser.getLocalWiFis();
        if (localWiFis == null) {
            throw new C9722c(2005, "Prepare data, wifiList is null", "wlan", "local_pre_sync");
        }
        this.prepareMap = new HashMap(10);
        for (WlanBean wlanBean : localWiFis) {
            SyncWlanBean syncWlanBean = new SyncWlanBean();
            syncWlanBean.setLuid(wlanBean.getSsid());
            syncWlanBean.setHash(C0227m.m1593f(wlanBean.toString()));
            syncWlanBean.setData(wlanBean);
            this.prepareMap.put(wlanBean.getSsid(), syncWlanBean);
        }
        return this.prepareMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.ArrayList<com.huawei.android.hicloud.sync.wifi.datamanager.SyncWlanBean> updateData(java.util.List<com.huawei.android.hicloud.sync.wifi.datamanager.SyncWlanBean> r10, boolean r11) {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "updateData, syncWlanList.size() = "
            r0.append(r1)
            int r1 = r10.size()
            r0.append(r1)
            java.lang.String r1 = ", isAdd = "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "WlanManager"
            p514o9.C11839m.m70686d(r1, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            if (r11 != 0) goto L32
            java.util.HashMap r2 = r9.getLocalWifiConfig()
        L32:
            r3 = 0
        L33:
            int r4 = r10.size()     // Catch: java.lang.Exception -> L56
            if (r3 >= r4) goto Ldc
            java.lang.Object r4 = r10.get(r3)     // Catch: java.lang.Exception -> L56
            com.huawei.android.hicloud.sync.wifi.datamanager.SyncWlanBean r4 = (com.huawei.android.hicloud.sync.wifi.datamanager.SyncWlanBean) r4     // Catch: java.lang.Exception -> L56
            com.huawei.android.hicloud.sync.wifi.datamanager.WlanBean r4 = r4.getData()     // Catch: java.lang.Exception -> L56
            java.lang.String r5 = r4.getSsid()     // Catch: java.lang.Exception -> L56
            java.lang.Object r6 = r2.get(r5)     // Catch: java.lang.Exception -> L56
            if (r6 == 0) goto L58
            java.lang.Object r6 = r2.get(r5)     // Catch: java.lang.Exception -> L56
            android.net.wifi.WifiConfiguration r6 = (android.net.wifi.WifiConfiguration) r6     // Catch: java.lang.Exception -> L56
            int r6 = r6.networkId     // Catch: java.lang.Exception -> L56
            goto L59
        L56:
            r9 = move-exception
            goto Lc4
        L58:
            r6 = -1
        L59:
            java.util.Map<java.lang.String, com.huawei.android.hicloud.sync.wifi.datamanager.SyncWlanBean> r7 = r9.prepareMap     // Catch: java.lang.Exception -> L56
            java.lang.String r8 = r4.getSsid()     // Catch: java.lang.Exception -> L56
            java.lang.Object r7 = r7.get(r8)     // Catch: java.lang.Exception -> L56
            if (r7 == 0) goto L7c
            java.util.Map<java.lang.String, com.huawei.android.hicloud.sync.wifi.datamanager.SyncWlanBean> r7 = r9.prepareMap     // Catch: java.lang.Exception -> L56
            java.lang.String r8 = r4.getSsid()     // Catch: java.lang.Exception -> L56
            java.lang.Object r7 = r7.get(r8)     // Catch: java.lang.Exception -> L56
            com.huawei.android.hicloud.sync.wifi.datamanager.SyncWlanBean r7 = (com.huawei.android.hicloud.sync.wifi.datamanager.SyncWlanBean) r7     // Catch: java.lang.Exception -> L56
            com.huawei.android.hicloud.sync.wifi.datamanager.WlanBean r8 = r7.getData()     // Catch: java.lang.Exception -> L56
            if (r8 == 0) goto L7c
            com.huawei.android.hicloud.sync.wifi.datamanager.WlanBean r7 = r7.getData()     // Catch: java.lang.Exception -> L56
            goto L7d
        L7c:
            r7 = 0
        L7d:
            com.huawei.android.hicloud.sync.wifi.datamanager.ExtractWiFi r8 = r9.parser     // Catch: java.lang.Exception -> L92
            java.lang.Object r5 = r2.get(r5)     // Catch: java.lang.Exception -> L92
            android.net.wifi.WifiConfiguration r5 = (android.net.wifi.WifiConfiguration) r5     // Catch: java.lang.Exception -> L92
            android.net.wifi.WifiConfiguration r4 = r8.createWifiConfig(r4, r5, r7)     // Catch: java.lang.Exception -> L92
            if (r11 == 0) goto L94
            com.huawei.android.hicloud.sync.wifi.datamanager.ExtractWiFi r5 = r9.parser     // Catch: java.lang.Exception -> L92
            boolean r4 = r5.addNetWork(r4)     // Catch: java.lang.Exception -> L92
            goto L9c
        L92:
            r4 = move-exception
            goto La8
        L94:
            r4.networkId = r6     // Catch: java.lang.Exception -> L92
            com.huawei.android.hicloud.sync.wifi.datamanager.ExtractWiFi r5 = r9.parser     // Catch: java.lang.Exception -> L92
            boolean r4 = r5.updateNetWork(r4)     // Catch: java.lang.Exception -> L92
        L9c:
            if (r4 == 0) goto Lc0
            java.lang.Object r4 = r10.get(r3)     // Catch: java.lang.Exception -> L92
            com.huawei.android.hicloud.sync.wifi.datamanager.SyncWlanBean r4 = (com.huawei.android.hicloud.sync.wifi.datamanager.SyncWlanBean) r4     // Catch: java.lang.Exception -> L92
            r0.add(r4)     // Catch: java.lang.Exception -> L92
            goto Lc0
        La8:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L56
            r5.<init>()     // Catch: java.lang.Exception -> L56
            java.lang.String r6 = "addOrUpdateNetwork error: "
            r5.append(r6)     // Catch: java.lang.Exception -> L56
            java.lang.String r4 = r4.getMessage()     // Catch: java.lang.Exception -> L56
            r5.append(r4)     // Catch: java.lang.Exception -> L56
            java.lang.String r4 = r5.toString()     // Catch: java.lang.Exception -> L56
            p514o9.C11839m.m70687e(r1, r4)     // Catch: java.lang.Exception -> L56
        Lc0:
            int r3 = r3 + 1
            goto L33
        Lc4:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "updateData Exception: "
            r10.append(r11)
            java.lang.String r9 = r9.toString()
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            p514o9.C11839m.m70687e(r1, r9)
        Ldc:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.sync.wifi.datamanager.WlanManager.updateData(java.util.List, boolean):java.util.ArrayList");
    }
}
