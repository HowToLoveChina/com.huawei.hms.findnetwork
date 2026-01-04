package com.huawei.android.hicloud.sync.wifi.datamanager;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class ExtractNWiFi extends ExtractWiFi {
    private static final String DELETED_FLAG = "-deleted";
    private static final String EAP_FLAG = "WPA-EAP";
    private static final String END_FLAG = "}";
    private static final String NETWORK_FLAG = "network={";

    public ExtractNWiFi(Context context) {
        super(context);
    }

    private String[] parseWifiNetworks(String str) {
        if (str != null && str.contains(NETWORK_FLAG)) {
            int iIndexOf = str.indexOf(NETWORK_FLAG);
            int iLastIndexOf = str.lastIndexOf(END_FLAG);
            if (iIndexOf >= 0 && iLastIndexOf >= iIndexOf) {
                return str.substring(iIndexOf, iLastIndexOf).split("\n\n");
            }
        }
        return new String[0];
    }

    private boolean setBasicParams(WlanBean wlanBean, String str) {
        boolean z10;
        boolean z11;
        String strSubstring;
        String[] strArrSplit = str.replace("\t", "").split("\n");
        int length = strArrSplit.length;
        int i10 = 0;
        while (true) {
            z10 = true;
            if (i10 >= length) {
                z11 = true;
                break;
            }
            String str2 = strArrSplit[i10];
            if (str2.startsWith("ssid")) {
                if (str2.contains("\"")) {
                    strSubstring = str2.substring(5);
                } else {
                    strSubstring = "ENCODED_" + str2.substring(5);
                }
                if (strSubstring.isEmpty()) {
                    break;
                }
                wlanBean.setSsid(strSubstring);
                i10++;
            } else if (!str2.startsWith("psk")) {
                if (str2.startsWith("key_mgmt")) {
                    if (str2.contains(EAP_FLAG)) {
                        break;
                    }
                    wlanBean.setKeyMgmt(str2.substring(9));
                } else if (str2.startsWith("wep_key0")) {
                    wlanBean.setWepKey(str2.substring(9));
                }
                i10++;
            } else {
                if (str2.contains(DELETED_FLAG)) {
                    break;
                }
                wlanBean.setPsk(str2.substring(4));
                i10++;
            }
        }
        z11 = false;
        boolean z12 = wlanBean.getPsk() == null || wlanBean.getPsk().isEmpty();
        if (wlanBean.getWepKey() != null && !wlanBean.getWepKey().isEmpty()) {
            z10 = false;
        }
        if (z12 && z10) {
            return false;
        }
        return z11;
    }

    private void setWifiConfig(List<WifiConfiguration> list, WlanBean wlanBean) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        WifiConfiguration wifiConfigurationMatchConfiguration = matchConfiguration(wlanBean.getSsid(), list);
        if (wifiConfigurationMatchConfiguration != null) {
            wlanBean.setSsid(wifiConfigurationMatchConfiguration.SSID);
            wlanBean.setHiddenSSID(String.valueOf(wifiConfigurationMatchConfiguration.hiddenSSID));
            getStaticProxySettings(wifiConfigurationMatchConfiguration, wlanBean);
            getStaticIPInfo(wifiConfigurationMatchConfiguration, wlanBean);
        }
    }

    @Override // com.huawei.android.hicloud.sync.wifi.datamanager.ExtractWiFi
    public long getFileHandle() {
        if (this.socketUtil == null) {
            return -1L;
        }
        try {
            Locale locale = Locale.ENGLISH;
            long jM17849e = this.socketUtil.m17849e(String.format(locale, "open %s 0 0", "/data/misc/wifi/wpa_supplicant.conf").getBytes(Constants.UTF_8));
            return jM17849e == -100 ? this.socketUtil.m17849e(String.format(locale, "open %s 0 0", "/data/misc/wifi/wpa_supplicant_hisi.conf").getBytes(Constants.UTF_8)) : jM17849e;
        } catch (IOException e10) {
            C11839m.m70687e("ExtractWiFi", "get FileHandle Exception " + e10.toString());
            return -1L;
        }
    }

    @Override // com.huawei.android.hicloud.sync.wifi.datamanager.ExtractWiFi
    public boolean hasValidNetwork(String str) {
        String[] wifiNetworks = parseWifiNetworks(str);
        C11839m.m70688i("ExtractWiFi", "All wifi size: " + wifiNetworks.length);
        int length = wifiNetworks.length;
        for (int i10 = 0; i10 < length; i10++) {
            String str2 = wifiNetworks[i10];
            WlanBean wlanBean = new WlanBean();
            if (setBasicParams(wlanBean, str2) && wlanBean.getSsid() != null) {
                return true;
            }
        }
        return false;
    }

    @Override // com.huawei.android.hicloud.sync.wifi.datamanager.ExtractWiFi
    public List<WlanBean> parseWifiConfig(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (str == null || str.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String[] wifiNetworks = parseWifiNetworks(str);
        List<WifiConfiguration> configuration = getConfiguration();
        for (String str2 : wifiNetworks) {
            WlanBean wlanBean = new WlanBean();
            if (setBasicParams(wlanBean, str2) && wlanBean.getSsid() != null) {
                setWifiConfig(configuration, wlanBean);
                arrayList.add(wlanBean);
            }
        }
        return arrayList;
    }
}
