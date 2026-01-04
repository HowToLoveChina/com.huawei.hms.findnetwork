package com.huawei.android.hicloud.sync.wifi.datamanager;

import android.content.Context;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p015ak.C0209d;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class ExtractOWiFi extends ExtractWiFi {
    private static final String DNSSERVER = "DNSServers";
    private static final String NETWORK = "NetWork";
    private static final int STATUS_DEFAULT = 0;
    private static final int STATUS_DNS = 2;
    private static final int STATUS_WEBKEY = 1;
    private static final String STRING_ARRAY_NODE = "string-array";
    private static final String WEPKEYS = "WEPKeys";

    public ExtractOWiFi(Context context) {
        super(context);
    }

    private boolean parseHasIpAssign(XmlPullParser xmlPullParser, boolean z10) throws XmlPullParserException, IOException {
        if (ExtractOWiFiHelper.STING_NODE.equalsIgnoreCase(xmlPullParser.getName()) && xmlPullParser.getAttributeCount() == 1 && ExtractOWiFiHelper.IPASSIGNMENT.equalsIgnoreCase(xmlPullParser.getAttributeValue(0)) && ExtractOWiFiHelper.IPCONFIGSTATIC.equalsIgnoreCase(xmlPullParser.nextText())) {
            return true;
        }
        return z10;
    }

    private boolean parseHasProxy(XmlPullParser xmlPullParser, boolean z10) throws XmlPullParserException, IOException {
        if (ExtractOWiFiHelper.STING_NODE.equalsIgnoreCase(xmlPullParser.getName()) && xmlPullParser.getAttributeCount() == 1 && ExtractOWiFiHelper.PROXYSETTING.equalsIgnoreCase(xmlPullParser.getAttributeValue(0)) && ExtractOWiFiHelper.IPCONFIGSTATIC.equalsIgnoreCase(xmlPullParser.nextText())) {
            return true;
        }
        return z10;
    }

    private int parserArrayNode(XmlPullParser xmlPullParser, WlanBean wlanBean, int i10) throws XmlPullParserException, IOException {
        if (STRING_ARRAY_NODE.equalsIgnoreCase(xmlPullParser.getName()) && xmlPullParser.getAttributeCount() == 2) {
            String attributeValue = xmlPullParser.getAttributeValue(0);
            String attributeValue2 = xmlPullParser.getAttributeValue(1);
            if (WEPKEYS.equalsIgnoreCase(attributeValue) || WEPKEYS.equalsIgnoreCase(attributeValue2)) {
                return 1;
            }
            if (DNSSERVER.equalsIgnoreCase(attributeValue) || DNSSERVER.equalsIgnoreCase(attributeValue2)) {
                return 2;
            }
            return i10;
        }
        if (!"item".equalsIgnoreCase(xmlPullParser.getName())) {
            return i10;
        }
        String attributeValue3 = xmlPullParser.getAttributeValue(0);
        if (i10 == 1) {
            wlanBean.setWepKey(attributeValue3);
            return 0;
        }
        if (i10 != 2) {
            return i10;
        }
        if (wlanBean.getDns1() == null || wlanBean.getDns1().isEmpty()) {
            wlanBean.setDns1(attributeValue3);
            return i10;
        }
        wlanBean.setDns2(attributeValue3);
        return i10;
    }

    @Override // com.huawei.android.hicloud.sync.wifi.datamanager.ExtractWiFi
    public long getFileHandle() {
        if (this.socketUtil == null) {
            return -1L;
        }
        try {
            return this.socketUtil.m17849e(String.format(Locale.ENGLISH, "open %s 0 0", C0209d.m1179I1() ? "/data/misc/apexdata/com.android.wifi/WifiConfigStore.xml" : "/data/misc/wifi/WifiConfigStore.xml").getBytes(Constants.UTF_8));
        } catch (IOException e10) {
            C11839m.m70687e("ExtractWiFi", "get FileHandle Exception " + e10.toString());
            return -1L;
        }
    }

    @Override // com.huawei.android.hicloud.sync.wifi.datamanager.ExtractWiFi
    public boolean hasValidNetwork(String str) throws XmlPullParserException, IOException {
        List<WlanBean> wifiConfig = parseWifiConfig(str);
        return (wifiConfig == null || wifiConfig.isEmpty()) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d1  */
    @Override // com.huawei.android.hicloud.sync.wifi.datamanager.ExtractWiFi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.huawei.android.hicloud.sync.wifi.datamanager.WlanBean> parseWifiConfig(java.lang.String r13) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.sync.wifi.datamanager.ExtractOWiFi.parseWifiConfig(java.lang.String):java.util.List");
    }
}
