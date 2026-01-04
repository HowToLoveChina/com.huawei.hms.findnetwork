package com.huawei.android.hicloud.sync.wifi.datamanager;

import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class ExtractOWiFiHelper {
    private static final String BOOLEN_NODE = "boolean";
    private static final String GATEWAY = "GatewayAddress";
    private static final String HIDDENSSID = "HiddenSSID";
    private static final String INT_NODE = "int";
    public static final String IPASSIGNMENT = "IpAssignment";
    public static final String IPCONFIGSTATIC = "STATIC";
    private static final String LINKADDRESS = "LinkAddress";
    private static final String LINKPREFIXLENGTH = "LinkPrefixLength";
    private static final String NETWORK_CONFIGKEY = "ConfigKey";
    private static final String NETWORK_PRESHAREDKEY = "PreSharedKey";
    private static final String NETWORK_SSID = "SSID";
    protected static final String NONE = "NONE";
    private static final String PROXYEXCLUSIONLIST = "ProxyExclusionList";
    private static final String PROXYHOST = "ProxyHost";
    private static final String PROXYPORT = "ProxyPort";
    public static final String PROXYSETTING = "ProxySettings";
    public static final String STING_NODE = "string";
    protected static final String TAG = "ExtractWiFiHelper";

    private static String getKeyMgmt(String str, String str2) {
        String strSubstring = str.substring(str2.length(), str.length());
        if (strSubstring.isEmpty() || "WEP".equalsIgnoreCase(strSubstring)) {
            strSubstring = NONE;
        }
        return strSubstring.replace("_", "-");
    }

    public static void parserBooleanNode(XmlPullParser xmlPullParser, WlanBean wlanBean) throws XmlPullParserException, IOException {
        if (BOOLEN_NODE.equalsIgnoreCase(xmlPullParser.getName()) && xmlPullParser.getAttributeCount() == 2) {
            String attributeValue = xmlPullParser.getAttributeValue(0);
            String attributeValue2 = xmlPullParser.getAttributeValue(1);
            if (HIDDENSSID.equalsIgnoreCase(attributeValue)) {
                wlanBean.setHiddenSSID(attributeValue2);
            } else if (HIDDENSSID.equalsIgnoreCase(attributeValue2)) {
                wlanBean.setHiddenSSID(attributeValue);
            }
        }
    }

    public static void parserEnd(WlanBean wlanBean, List<WlanBean> list) {
        boolean z10 = false;
        boolean z11 = (wlanBean.getPsk() == null || wlanBean.getPsk().isEmpty()) ? false : true;
        if (wlanBean.getWepKey() != null && !wlanBean.getWepKey().isEmpty()) {
            z10 = true;
        }
        if (z11 || z10) {
            wlanBean.setKeyMgmt(getKeyMgmt(wlanBean.getKeyMgmt(), wlanBean.getSsid()));
            C11839m.m70686d(TAG, "" + wlanBean.toString());
            list.add(wlanBean);
        }
    }

    public static void parserIntNode(XmlPullParser xmlPullParser, WlanBean wlanBean) throws XmlPullParserException, IOException {
        if (INT_NODE.equalsIgnoreCase(xmlPullParser.getName()) && xmlPullParser.getAttributeCount() == 2) {
            String attributeValue = xmlPullParser.getAttributeValue(0);
            String attributeValue2 = xmlPullParser.getAttributeValue(1);
            if (LINKPREFIXLENGTH.equalsIgnoreCase(attributeValue)) {
                wlanBean.setNetworkPrefixLength(attributeValue2);
                return;
            }
            if (LINKPREFIXLENGTH.equalsIgnoreCase(attributeValue2)) {
                wlanBean.setNetworkPrefixLength(attributeValue);
            } else if (PROXYPORT.equalsIgnoreCase(attributeValue)) {
                wlanBean.setPort(attributeValue2);
            } else if (PROXYPORT.equalsIgnoreCase(attributeValue2)) {
                wlanBean.setPort(attributeValue);
            }
        }
    }

    public static void parserProxy(XmlPullParser xmlPullParser, WlanBean wlanBean, boolean z10, boolean z11) throws XmlPullParserException, IOException {
        if (STING_NODE.equalsIgnoreCase(xmlPullParser.getName()) && xmlPullParser.getAttributeCount() == 1) {
            String attributeValue = xmlPullParser.getAttributeValue(0);
            if (z10 && LINKADDRESS.equalsIgnoreCase(attributeValue)) {
                wlanBean.setIp(xmlPullParser.nextText());
                return;
            }
            if (z10 && GATEWAY.equalsIgnoreCase(attributeValue)) {
                wlanBean.setGateway(xmlPullParser.nextText());
                return;
            }
            if (z11 && PROXYHOST.equalsIgnoreCase(attributeValue)) {
                wlanBean.setHost(xmlPullParser.nextText());
            } else if (z11 && PROXYEXCLUSIONLIST.equalsIgnoreCase(attributeValue)) {
                wlanBean.setExclusionList(xmlPullParser.nextText());
            }
        }
    }

    public static void parserStringNode(XmlPullParser xmlPullParser, WlanBean wlanBean) throws XmlPullParserException, IOException {
        if (STING_NODE.equalsIgnoreCase(xmlPullParser.getName()) && xmlPullParser.getAttributeCount() == 1) {
            String attributeValue = xmlPullParser.getAttributeValue(0);
            if (NETWORK_CONFIGKEY.equalsIgnoreCase(attributeValue)) {
                wlanBean.setKeyMgmt(xmlPullParser.nextText());
            } else if (NETWORK_SSID.equalsIgnoreCase(attributeValue)) {
                wlanBean.setSsid(xmlPullParser.nextText());
            } else if (NETWORK_PRESHAREDKEY.equalsIgnoreCase(attributeValue)) {
                wlanBean.setPsk(xmlPullParser.nextText());
            }
        }
    }
}
