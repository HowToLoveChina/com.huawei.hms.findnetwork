package com.huawei.android.hicloud.sync.wifi.datamanager;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.hicloud.sync.syncutil.PMSUtil;
import java.util.List;
import java.util.function.Predicate;
import je.C10781c0;
import p015ak.C0209d;
import p015ak.C0221j;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class ExtractOWiFiByPMS extends ExtractOWiFi {
    private static final String DATA_PATH = "/data/data/";
    private static final String WIFI_CONFIG_STORE_FILE_DIR_IN_HIDISK = "/files/wifi";
    private static final String WIFI_CONFIG_STORE_FILE_IN_HIDISK = "/files/wifi/WifiConfigStore.xml";
    private static final String WIFI_CONFIG_STORE_PATH_IN_HIDISK = "/data/data/com.huawei.hidisk/files/wifi";

    public ExtractOWiFiByPMS(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getLocalWiFis$0(List list, WlanBean wlanBean) {
        return !TextUtils.isEmpty(wlanBean.getSsid()) && C10781c0.m65631a(list, wlanBean.getSsid());
    }

    @Override // com.huawei.android.hicloud.sync.wifi.datamanager.ExtractWiFi
    public List<WlanBean> getLocalWiFis() {
        Context context;
        if (PMSUtil.m17804e()) {
            C11839m.m70689w("ExtractWiFi", "syncWlan pms is using");
            return null;
        }
        PMSUtil.m17803d();
        String str = "/data/data/" + this.mContext.getPackageName() + WIFI_CONFIG_STORE_FILE_IN_HIDISK;
        String str2 = "/data/data/" + this.mContext.getPackageName() + WIFI_CONFIG_STORE_FILE_DIR_IN_HIDISK;
        if (!C0221j.m1499i(str2)) {
            C11839m.m70687e("ExtractWiFi", "syncWlan pms clean wifi cache file error");
            return null;
        }
        try {
            int iM17802c = PMSUtil.m17802c(C0209d.m1179I1() ? "/data/misc/apexdata/com.android.wifi/WifiConfigStore.xml" : "/data/misc/wifi/WifiConfigStore.xml", WIFI_CONFIG_STORE_PATH_IN_HIDISK);
            if (iM17802c != 0) {
                C11839m.m70687e("ExtractWiFi", "syncWlan pms backup wifi file error:" + iM17802c);
                PMSUtil.m17806g();
                C0221j.m1499i(str2);
                return null;
            }
            String strM17805f = PMSUtil.m17805f(str, this.mContext);
            if (strM17805f.isEmpty()) {
                C11839m.m70687e("ExtractWiFi", "syncWlan pms read wifi content error");
                PMSUtil.m17806g();
                C0221j.m1499i(str2);
                return null;
            }
            C0221j.m1499i(str2);
            PMSUtil.m17806g();
            List<WlanBean> wifiConfig = parseWifiConfig(strM17805f);
            if (wifiConfig != null && !wifiConfig.isEmpty() && (context = this.mContext) != null) {
                final List<String> listM65632b = C10781c0.m65632b(context);
                wifiConfig.removeIf(new Predicate() { // from class: com.huawei.android.hicloud.sync.wifi.datamanager.a
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return ExtractOWiFiByPMS.lambda$getLocalWiFis$0(listM65632b, (WlanBean) obj);
                    }
                });
            }
            C0221j.m1499i(str2);
            return wifiConfig;
        } catch (Throwable th2) {
            C0221j.m1499i(str2);
            throw th2;
        }
    }

    @Override // com.huawei.android.hicloud.sync.wifi.datamanager.ExtractWiFi
    public boolean hasLocalData() {
        List<WlanBean> localWiFis = getLocalWiFis();
        return (localWiFis == null || localWiFis.isEmpty()) ? false : true;
    }
}
