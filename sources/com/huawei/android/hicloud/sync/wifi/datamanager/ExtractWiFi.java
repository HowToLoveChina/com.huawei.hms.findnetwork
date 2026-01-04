package com.huawei.android.hicloud.sync.wifi.datamanager;

import android.content.Context;
import android.net.LinkAddress;
import android.net.RouteInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.huawei.android.hicloud.sync.syncutil.C2976e;
import com.huawei.hwcloudjs.p164f.C6661f;
import dk.C9160a;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import je.C10781c0;
import je.C10812z;
import p015ak.C0224k0;
import p015ak.C0241z;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public abstract class ExtractWiFi {
    private static final int ANDROID_LOLLIPOP = 21;
    private static final int CAPACITY = 2048;
    private static final String[] CHAR_SETS = {"UTF-8", "GBK", "US-ASCII", "UTF-16"};
    protected static final String ENCODED_FLAG = "ENCODED_";
    protected static final String ENCODING = "UTF-8";
    protected static final String NONE = "NONE";
    private static final String STR_SHARP = "#";
    protected static final String STR_SOFT_ENTER = "\n";
    protected static final String TAG = "ExtractWiFi";
    private static final int WIFICIPHER_WEP = 2;
    protected static final String WIFI_CONFIG_STORE_PATH = "/data/misc/wifi/WifiConfigStore.xml";
    protected static final String WIFI_CONFIG_STORE_PATH_R = "/data/misc/apexdata/com.android.wifi/WifiConfigStore.xml";
    protected static final String WPA_SUPPLICANT_HISI_PATH = "/data/misc/wifi/wpa_supplicant_hisi.conf";
    protected static final String WPA_SUPPLICANT_PATH = "/data/misc/wifi/wpa_supplicant.conf";
    protected Context mContext;
    private WifiManager mWifiManager;
    protected C2976e socketUtil;

    public ExtractWiFi(Context context) {
        this.mContext = context;
        this.mWifiManager = (WifiManager) context.getSystemService(C6661f.f30885g);
    }

    private void clearLollipopStaticIpAssignment(WifiConfiguration wifiConfiguration) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException, InvocationTargetException {
        C11839m.m70686d(TAG, "clearLollipopStaticIpAssignment");
        try {
            Object objInvoke = WifiConfiguration.class.getDeclaredMethod("getIpAssignment", new Class[0]).invoke(wifiConfiguration, new Object[0]);
            WifiConfiguration.class.getDeclaredMethod("setIpAssignment", objInvoke.getClass()).invoke(wifiConfiguration, objInvoke.getClass().getDeclaredField("DHCP").get(objInvoke));
            Object objInvoke2 = wifiConfiguration.getClass().getMethod("getStaticIpConfiguration", new Class[0]).invoke(wifiConfiguration, new Object[0]);
            if (objInvoke2 != null) {
                objInvoke2.getClass().getMethod("clear", new Class[0]).invoke(objInvoke2, new Object[0]);
            }
        } catch (RuntimeException e10) {
            C11839m.m70687e(TAG, "clearLollipopStaticIpAssignment err :" + e10.getMessage());
        } catch (Exception e11) {
            C11839m.m70687e(TAG, "clearLollipopStaticIpAssignment err : " + e11.toString());
        }
    }

    private void clearStaticIpAssignment(WifiConfiguration wifiConfiguration) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName("android.net.wifi.WifiConfiguration$IpAssignment");
            wifiConfiguration.getClass().getField("ipAssignment").set(wifiConfiguration, cls.getClass().getDeclaredField("DHCP").get(cls));
            Object objInvoke = wifiConfiguration.getClass().getMethod("getStaticIpConfiguration", new Class[0]).invoke(wifiConfiguration, new Object[0]);
            if (objInvoke != null) {
                objInvoke.getClass().getMethod("clear", new Class[0]).invoke(objInvoke, new Object[0]);
            }
        } catch (RuntimeException e10) {
            C11839m.m70687e(TAG, "clearStaticIpAssignment err :" + e10.getMessage());
        } catch (Exception e11) {
            C11839m.m70687e(TAG, "clearStaticIpAssignment err : " + e11.toString());
        }
    }

    private void clearStaticIpConfig(WifiConfiguration wifiConfiguration) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (C9160a.f45951d < 21) {
            clearStaticIpAssignment(wifiConfiguration);
        } else {
            clearLollipopStaticIpAssignment(wifiConfiguration);
        }
    }

    private String encodeStringToUnicode(String str, String str2) throws UnsupportedEncodingException {
        try {
            byte[] bytes = str.substring(1, str.length() - 1).getBytes(str2);
            StringBuilder sb2 = new StringBuilder();
            for (byte b10 : bytes) {
                if (b10 >= 0) {
                    sb2.append(Integer.toHexString(b10));
                } else {
                    sb2.append(Integer.toHexString(b10).substring(6));
                }
            }
            return sb2.toString();
        } catch (UnsupportedEncodingException unused) {
            C11839m.m70687e(TAG, "UnsupportedEncodingException err");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String getSocketFileContent(long r14) throws java.lang.Throwable {
        /*
            r13 = this;
            java.lang.String r0 = "UTF-8"
            java.lang.String r1 = "getWpaSupplicationConfig close socket write error Exception"
            java.lang.String r2 = "ExtractWiFi"
            com.huawei.android.hicloud.sync.syncutil.e r3 = r13.socketUtil
            r4 = 0
            if (r3 != 0) goto Lc
            return r4
        Lc:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r5 = 2048(0x800, float:2.87E-42)
            r3.<init>(r5)
            com.huawei.android.hicloud.sync.syncutil.e r6 = r13.socketUtil
            byte[] r6 = r6.m17850f()
            java.util.Locale r7 = java.util.Locale.ENGLISH     // Catch: java.lang.Throwable -> L9c java.io.IOException -> L9e java.io.UnsupportedEncodingException -> La0
            java.lang.String r8 = "read %s 8192"
            r9 = 1
            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch: java.lang.Throwable -> L9c java.io.IOException -> L9e java.io.UnsupportedEncodingException -> La0
            java.lang.String r11 = java.lang.String.valueOf(r14)     // Catch: java.lang.Throwable -> L9c java.io.IOException -> L9e java.io.UnsupportedEncodingException -> La0
            r12 = 0
            r10[r12] = r11     // Catch: java.lang.Throwable -> L9c java.io.IOException -> L9e java.io.UnsupportedEncodingException -> La0
            java.lang.String r8 = java.lang.String.format(r7, r8, r10)     // Catch: java.lang.Throwable -> L9c java.io.IOException -> L9e java.io.UnsupportedEncodingException -> La0
            byte[] r8 = r8.getBytes(r0)     // Catch: java.lang.Throwable -> L9c java.io.IOException -> L9e java.io.UnsupportedEncodingException -> La0
            java.lang.String r10 = "close %s"
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch: java.lang.Throwable -> L9c java.io.IOException -> L9e java.io.UnsupportedEncodingException -> La0
            java.lang.Long r14 = java.lang.Long.valueOf(r14)     // Catch: java.lang.Throwable -> L9c java.io.IOException -> L9e java.io.UnsupportedEncodingException -> La0
            r9[r12] = r14     // Catch: java.lang.Throwable -> L9c java.io.IOException -> L9e java.io.UnsupportedEncodingException -> La0
            java.lang.String r14 = java.lang.String.format(r7, r10, r9)     // Catch: java.lang.Throwable -> L9c java.io.IOException -> L9e java.io.UnsupportedEncodingException -> La0
            byte[] r14 = r14.getBytes(r0)     // Catch: java.lang.Throwable -> L9c java.io.IOException -> L9e java.io.UnsupportedEncodingException -> La0
            r15 = -1
        L42:
            com.huawei.android.hicloud.sync.syncutil.e r7 = r13.socketUtil     // Catch: java.lang.Throwable -> L62 java.io.IOException -> La2 java.io.UnsupportedEncodingException -> Lb3
            int r7 = r7.m17856p(r8, r6)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> La2 java.io.UnsupportedEncodingException -> Lb3
            r9 = -100
            if (r7 != r9) goto L4d
            goto L67
        L4d:
            r9 = 4
            if (r7 < r9) goto L65
            int r15 = com.huawei.android.hicloud.sync.syncutil.C2976e.m17841a(r6, r12, r9)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> La2 java.io.UnsupportedEncodingException -> Lb3
            byte[] r7 = new byte[r15]     // Catch: java.lang.Throwable -> L62 java.io.IOException -> La2 java.io.UnsupportedEncodingException -> Lb3
            java.lang.System.arraycopy(r6, r9, r7, r12, r15)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> La2 java.io.UnsupportedEncodingException -> Lb3
            java.lang.String r9 = new java.lang.String     // Catch: java.lang.Throwable -> L62 java.io.IOException -> La2 java.io.UnsupportedEncodingException -> Lb3
            r9.<init>(r7, r0)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> La2 java.io.UnsupportedEncodingException -> Lb3
            r3.append(r9)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> La2 java.io.UnsupportedEncodingException -> Lb3
            goto L65
        L62:
            r15 = move-exception
            r4 = r14
            goto Lc4
        L65:
            if (r15 > 0) goto L42
        L67:
            if (r14 == 0) goto L72
            com.huawei.android.hicloud.sync.syncutil.e r13 = r13.socketUtil     // Catch: java.io.IOException -> L6f
            r13.m17856p(r14, r6)     // Catch: java.io.IOException -> L6f
            goto L72
        L6f:
            p514o9.C11839m.m70687e(r2, r1)
        L72:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r5)
            java.lang.String r14 = r3.toString()
            java.lang.String r15 = "\n"
            java.lang.String[] r14 = r14.split(r15)
            int r0 = r14.length
        L82:
            if (r12 >= r0) goto L97
            r1 = r14[r12]
            java.lang.String r2 = "#"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L94
            r13.append(r1)
            r13.append(r15)
        L94:
            int r12 = r12 + 1
            goto L82
        L97:
            java.lang.String r13 = r13.toString()
            return r13
        L9c:
            r15 = move-exception
            goto Lc4
        L9e:
            r14 = r4
            goto La2
        La0:
            r14 = r4
            goto Lb3
        La2:
            java.lang.String r15 = "getSocketFileContent socket write error Exception"
            p514o9.C11839m.m70687e(r2, r15)     // Catch: java.lang.Throwable -> L62
            if (r14 == 0) goto Lb2
            com.huawei.android.hicloud.sync.syncutil.e r13 = r13.socketUtil     // Catch: java.io.IOException -> Laf
            r13.m17856p(r14, r6)     // Catch: java.io.IOException -> Laf
            goto Lb2
        Laf:
            p514o9.C11839m.m70687e(r2, r1)
        Lb2:
            return r4
        Lb3:
            java.lang.String r15 = "getSocketFileContent string to byte[] Exception"
            p514o9.C11839m.m70687e(r2, r15)     // Catch: java.lang.Throwable -> L62
            if (r14 == 0) goto Lc3
            com.huawei.android.hicloud.sync.syncutil.e r13 = r13.socketUtil     // Catch: java.io.IOException -> Lc0
            r13.m17856p(r14, r6)     // Catch: java.io.IOException -> Lc0
            goto Lc3
        Lc0:
            p514o9.C11839m.m70687e(r2, r1)
        Lc3:
            return r4
        Lc4:
            if (r4 == 0) goto Lcf
            com.huawei.android.hicloud.sync.syncutil.e r13 = r13.socketUtil     // Catch: java.io.IOException -> Lcc
            r13.m17856p(r4, r6)     // Catch: java.io.IOException -> Lcc
            goto Lcf
        Lcc:
            p514o9.C11839m.m70687e(r2, r1)
        Lcf:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.sync.wifi.datamanager.ExtractWiFi.getSocketFileContent(long):java.lang.String");
    }

    private String getWifiContent() throws IOException {
        String socketFileContent = null;
        if (C2976e.m17843h()) {
            C11839m.m70689w(TAG, "getWifiContent, socket is using.");
            return null;
        }
        C2976e c2976e = new C2976e();
        this.socketUtil = c2976e;
        if (c2976e.m17847c()) {
            try {
                long fileHandle = getFileHandle();
                if (fileHandle != -1 && fileHandle != -100) {
                    socketFileContent = getSocketFileContent(fileHandle);
                }
            } finally {
                this.socketUtil.m17848d();
            }
        } else {
            C11839m.m70687e(TAG, "getWifiContent, connect socket failed.");
        }
        return socketFileContent;
    }

    private boolean isStaticIpConfig(WifiConfiguration wifiConfiguration) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objInvoke = WifiConfiguration.class.getDeclaredMethod("getIpAssignment", new Class[0]).invoke(wifiConfiguration, new Object[0]);
            Class<?> cls = Class.forName("android.net.IpConfiguration$IpAssignment");
            return objInvoke.equals(cls.getField(ExtractOWiFiHelper.IPCONFIGSTATIC).get(cls));
        } catch (RuntimeException e10) {
            C11839m.m70687e(TAG, "isStaticIpConfig err :" + e10.getMessage());
            return false;
        } catch (Exception e11) {
            C11839m.m70687e(TAG, "isStaticIpConfig Exception: " + e11.toString());
            return false;
        }
    }

    private boolean isStaticProxySettings(WifiConfiguration wifiConfiguration) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objInvoke = WifiConfiguration.class.getDeclaredMethod("getProxySettings", new Class[0]).invoke(wifiConfiguration, new Object[0]);
            Class<?> cls = Class.forName("android.net.IpConfiguration$ProxySettings");
            return objInvoke.equals(cls.getField(ExtractOWiFiHelper.IPCONFIGSTATIC).get(cls));
        } catch (RuntimeException e10) {
            C11839m.m70687e(TAG, "getStaticProxySettings Exception" + e10.getMessage());
            return false;
        } catch (Exception e11) {
            C11839m.m70687e(TAG, "isStaticProxySettings Exception: " + e11.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getLocalWiFis$0(List list, WlanBean wlanBean) {
        return !TextUtils.isEmpty(wlanBean.getSsid()) && C10781c0.m65631a(list, wlanBean.getSsid());
    }

    private String removeIPHostName(String str) {
        return str.substring(str.lastIndexOf("/") + 1);
    }

    private void setLollipopStaticIpAssignment(WlanBean wlanBean, WifiConfiguration wifiConfiguration) throws IllegalAccessException, NoSuchFieldException, InstantiationException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        C11839m.m70686d(TAG, "setLollipopStaticIpAssignment");
        try {
            Object objInvoke = WifiConfiguration.class.getDeclaredMethod("getIpAssignment", new Class[0]).invoke(wifiConfiguration, new Object[0]);
            WifiConfiguration.class.getDeclaredMethod("setIpAssignment", objInvoke.getClass()).invoke(wifiConfiguration, objInvoke.getClass().getDeclaredField(ExtractOWiFiHelper.IPCONFIGSTATIC).get(objInvoke));
            Class<?> cls = Class.forName("android.net.StaticIpConfiguration");
            Object objNewInstance = cls.newInstance();
            Field declaredField = cls.getDeclaredField("ipAddress");
            declaredField.setAccessible(true);
            declaredField.set(objNewInstance, C0224k0.m1537G(InetAddress.getByName(wlanBean.getIp()), C0241z.m1685c(wlanBean.getNetworkPrefixLength())));
            declaredField.setAccessible(false);
            Field declaredField2 = cls.getDeclaredField("gateway");
            declaredField2.setAccessible(true);
            declaredField2.set(objNewInstance, InetAddress.getByName(wlanBean.getGateway()));
            declaredField2.setAccessible(false);
            Field declaredField3 = cls.getDeclaredField("dnsServers");
            declaredField3.setAccessible(true);
            ArrayList arrayList = new ArrayList();
            String dns1 = wlanBean.getDns1();
            String dns2 = wlanBean.getDns2();
            if (dns1 != null) {
                arrayList.add(InetAddress.getByName(dns1));
            }
            if (dns2 != null) {
                arrayList.add(InetAddress.getByName(dns2));
            }
            declaredField3.set(objNewInstance, arrayList);
            declaredField3.setAccessible(false);
            WifiConfiguration.class.getDeclaredMethod("setStaticIpConfiguration", cls).invoke(wifiConfiguration, objNewInstance);
        } catch (RuntimeException e10) {
            C11839m.m70687e(TAG, "setLollipopStaticIpAssignment err :" + e10.getMessage());
        } catch (Exception e11) {
            C11839m.m70687e(TAG, "setLollipopStaticIpAssignment err : " + e11.toString());
        }
    }

    private void setStaticIpAssignment(WlanBean wlanBean, WifiConfiguration wifiConfiguration) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName("android.net.wifi.WifiConfiguration$IpAssignment");
            wifiConfiguration.getClass().getField("ipAssignment").set(wifiConfiguration, cls.getDeclaredField(ExtractOWiFiHelper.IPCONFIGSTATIC).get(cls));
            Object obj = wifiConfiguration.getClass().getField("linkProperties").get(wifiConfiguration);
            Method declaredMethod = obj.getClass().getDeclaredMethod("addDns", InetAddress.class);
            Method declaredMethod2 = obj.getClass().getDeclaredMethod("addRoute", RouteInfo.class);
            Method declaredMethod3 = obj.getClass().getDeclaredMethod("addLinkAddress", LinkAddress.class);
            String dns1 = wlanBean.getDns1();
            String dns2 = wlanBean.getDns2();
            if (dns1 != null) {
                declaredMethod.invoke(obj, InetAddress.getByName(dns1));
            }
            if (dns2 != null) {
                declaredMethod.invoke(obj, InetAddress.getByName(dns2));
            }
            declaredMethod2.invoke(obj, C0224k0.m1539I(InetAddress.getByName(wlanBean.getGateway())));
            declaredMethod3.invoke(obj, C0224k0.m1537G(InetAddress.getByName(wlanBean.getIp()), C0241z.m1685c(wlanBean.getNetworkPrefixLength())));
        } catch (RuntimeException e10) {
            C11839m.m70687e(TAG, "setStaticIpAssignment err :" + e10.getMessage());
        } catch (Exception e11) {
            C11839m.m70687e(TAG, "setStaticIpAssignment err : " + e11.toString());
        }
    }

    private void setStaticIpConfig(WlanBean wlanBean, WifiConfiguration wifiConfiguration) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InstantiationException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (C9160a.f45951d < 21) {
            setStaticIpAssignment(wlanBean, wifiConfiguration);
        } else {
            setLollipopStaticIpAssignment(wlanBean, wifiConfiguration);
        }
    }

    private void setStaticProxySettings(WifiConfiguration wifiConfiguration, String str, String str2, int i10, String str3, boolean z10) throws Exception {
        if (z10) {
            if (str3 == null) {
                str3 = "";
            }
            if (i10 == 0 && TextUtils.isEmpty(str3)) {
                C11839m.m70689w(TAG, "cloud wifi exclusionList null.");
                C10812z.m65837f(this.mContext, "wlan", 0, "", "03001", "wlan_exclusion_null", C10812z.m65832a("03001"));
                return;
            }
        }
        Class<?> cls = Class.forName("android.net.IpConfiguration$ProxySettings");
        Method declaredMethod = WifiConfiguration.class.getDeclaredMethod("setProxySettings", cls);
        Class<?> cls2 = Class.forName("android.net.ProxyInfo");
        declaredMethod.invoke(wifiConfiguration, cls.getField(str).get(cls));
        if (ExtractOWiFiHelper.IPCONFIGSTATIC.equalsIgnoreCase(str)) {
            WifiConfiguration.class.getDeclaredMethod("setHttpProxy", cls2).invoke(wifiConfiguration, cls2.getDeclaredConstructor(String.class, Integer.TYPE, String.class).newInstance(str2, Integer.valueOf(i10), str3));
        }
    }

    private void writeLVersionStaticIpConfig(WifiConfiguration wifiConfiguration, WlanBean wlanBean) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C11839m.m70686d(TAG, "writeLVersionStaticIpConfigToContentValues");
        try {
            Object objInvoke = WifiConfiguration.class.getDeclaredMethod("getStaticIpConfiguration", new Class[0]).invoke(wifiConfiguration, new Object[0]);
            LinkAddress linkAddress = (LinkAddress) objInvoke.getClass().getDeclaredField("ipAddress").get(objInvoke);
            String strRemoveIPHostName = removeIPHostName(linkAddress.getAddress().toString());
            String strValueOf = String.valueOf(linkAddress.getPrefixLength());
            String hostAddress = ((InetAddress) objInvoke.getClass().getDeclaredField("gateway").get(objInvoke)).getHostAddress();
            ArrayList arrayList = (ArrayList) objInvoke.getClass().getDeclaredField("dnsServers").get(objInvoke);
            String hostAddress2 = ((InetAddress) arrayList.get(0)).getHostAddress();
            String hostAddress3 = arrayList.size() > 1 ? ((InetAddress) arrayList.get(1)).getHostAddress() : null;
            wlanBean.setGateway(hostAddress);
            wlanBean.setNetworkPrefixLength(strValueOf);
            wlanBean.setIp(strRemoveIPHostName);
            wlanBean.setDns1(hostAddress2);
            wlanBean.setDns2(hostAddress3);
        } catch (RuntimeException e10) {
            C11839m.m70687e(TAG, "writeLVersionStaticIpConfigToContentValues Exception:" + e10.getMessage());
        } catch (Exception e11) {
            C11839m.m70687e(TAG, "writeLVersionStaticIpConfigToContentValues Exception: " + e11.toString());
        }
    }

    private void writeStaticIpConfig(WifiConfiguration wifiConfiguration, WlanBean wlanBean) throws IllegalAccessException, IllegalArgumentException {
        C11839m.m70686d(TAG, "writeStaticIpConfigToContentValues");
        try {
            Object obj = wifiConfiguration.getClass().getField("linkProperties").get(wifiConfiguration);
            Collection collection = (Collection) obj.getClass().getDeclaredMethod("getDnses", new Class[0]).invoke(obj, new Object[0]);
            Collection collection2 = (Collection) obj.getClass().getDeclaredMethod("getRoutes", new Class[0]).invoke(obj, new Object[0]);
            LinkAddress linkAddress = (LinkAddress) ((Collection) obj.getClass().getDeclaredMethod("getLinkAddresses", new Class[0]).invoke(obj, new Object[0])).iterator().next();
            String hostAddress = ((RouteInfo) collection2.iterator().next()).getGateway().getHostAddress();
            String strValueOf = String.valueOf(linkAddress.getPrefixLength());
            String strRemoveIPHostName = removeIPHostName(linkAddress.getAddress().toString());
            Iterator it = collection.iterator();
            wlanBean.setDns1(removeIPHostName(((InetAddress) it.next()).toString()));
            if (2 == collection.size()) {
                wlanBean.setDns2(removeIPHostName(((InetAddress) it.next()).toString()));
            }
            wlanBean.setGateway(hostAddress);
            wlanBean.setNetworkPrefixLength(strValueOf);
            wlanBean.setIp(strRemoveIPHostName);
        } catch (RuntimeException e10) {
            C11839m.m70687e(TAG, "writeStaticIpConfigToContentValues err :" + e10.getMessage());
        } catch (Exception e11) {
            C11839m.m70687e(TAG, "writeStaticIpConfigToContentValues err : " + e11.toString());
        }
    }

    public boolean addNetWork(WifiConfiguration wifiConfiguration) {
        C11839m.m70686d(TAG, "addNetwork begin");
        int iAddNetwork = this.mWifiManager.addNetwork(wifiConfiguration);
        C11839m.m70686d(TAG, "addNetWork result = " + iAddNetwork);
        return iAddNetwork >= 0;
    }

    public WifiConfiguration createWifiConfig(WlanBean wlanBean, WifiConfiguration wifiConfiguration, WlanBean wlanBean2) throws Exception {
        char c10;
        if (wlanBean.getPsk() != null && !wlanBean.getPsk().isEmpty()) {
            c10 = 1;
        } else if (wlanBean.getWepKey() == null || wlanBean.getWepKey().isEmpty()) {
            NONE.equals(wlanBean.getKeyMgmt());
            c10 = 0;
        } else {
            c10 = 2;
        }
        WifiConfiguration wifiConfiguration2 = new WifiConfiguration();
        wifiConfiguration2.SSID = wlanBean.getSsid();
        wifiConfiguration2.hiddenSSID = Boolean.valueOf(wlanBean.getHiddenSSID()).booleanValue();
        wifiConfiguration2.status = 2;
        if (c10 == 1) {
            wifiConfiguration2.preSharedKey = wlanBean.getPsk();
            wifiConfiguration2.allowedKeyManagement.set(1);
        } else if (c10 != 2) {
            wifiConfiguration2.allowedKeyManagement.set(0);
        } else {
            wifiConfiguration2.wepKeys[0] = wlanBean.getWepKey();
            wifiConfiguration2.allowedAuthAlgorithms.set(0);
            wifiConfiguration2.allowedAuthAlgorithms.set(1);
            wifiConfiguration2.allowedKeyManagement.set(0);
            wifiConfiguration2.wepTxKeyIndex = 0;
        }
        if (wlanBean2 == null || wlanBean2.getIp() == null) {
            clearStaticIpConfig(wifiConfiguration2);
        } else {
            setStaticIpConfig(wlanBean2, wifiConfiguration2);
        }
        if (wlanBean.getHost() != null) {
            C11839m.m70688i(TAG, "cloud wifi has host");
            setStaticProxySettings(wifiConfiguration2, ExtractOWiFiHelper.IPCONFIGSTATIC, wlanBean.getHost(), C0241z.m1685c(wlanBean.getPort()), wlanBean.getExclusionList(), true);
        } else if (wifiConfiguration != null && isStaticProxySettings(wifiConfiguration)) {
            C11839m.m70688i(TAG, "cloud wifi has no host");
            setStaticProxySettings(wifiConfiguration2, NONE, null, 0, null, false);
        }
        return wifiConfiguration2;
    }

    public boolean deleteNetWork(WifiConfiguration wifiConfiguration) {
        C11839m.m70686d(TAG, "removeNetwork netWorkId = " + wifiConfiguration.networkId);
        boolean zRemoveNetwork = this.mWifiManager.removeNetwork(wifiConfiguration.networkId);
        C11839m.m70686d(TAG, "removeNetwork result = " + zRemoveNetwork);
        return zRemoveNetwork;
    }

    public void forgetNetWork(WifiConfiguration wifiConfiguration) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C11839m.m70686d(TAG, "forget netWorkId = " + wifiConfiguration.networkId);
        C0224k0.m1551f(this.mWifiManager, wifiConfiguration.networkId);
    }

    public List<WifiConfiguration> getConfiguration() {
        List<WifiConfiguration> configuredNetworks = this.mWifiManager.getConfiguredNetworks();
        return configuredNetworks != null ? new ArrayList(configuredNetworks) : new ArrayList();
    }

    public String getConnectSsid() {
        WifiInfo connectionInfo = this.mWifiManager.getConnectionInfo();
        if (connectionInfo == null) {
            return "";
        }
        String ssid = connectionInfo.getSSID();
        C11839m.m70686d(TAG, "connectSsidconnectSsid = " + ssid);
        return ssid;
    }

    public abstract long getFileHandle();

    public List<WlanBean> getLocalWiFis() {
        Context context;
        List<WlanBean> wifiConfig = parseWifiConfig(getWifiContent());
        if (wifiConfig != null && !wifiConfig.isEmpty() && (context = this.mContext) != null) {
            final List<String> listM65632b = C10781c0.m65632b(context);
            wifiConfig.removeIf(new Predicate() { // from class: com.huawei.android.hicloud.sync.wifi.datamanager.b
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ExtractWiFi.lambda$getLocalWiFis$0(listM65632b, (WlanBean) obj);
                }
            });
        }
        return wifiConfig;
    }

    public void getStaticIPInfo(WifiConfiguration wifiConfiguration, WlanBean wlanBean) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (isStaticIpConfig(wifiConfiguration)) {
            writeLVersionStaticIpConfig(wifiConfiguration, wlanBean);
        }
    }

    public void getStaticProxySettings(WifiConfiguration wifiConfiguration, WlanBean wlanBean) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (isStaticProxySettings(wifiConfiguration)) {
            try {
                Object objInvoke = WifiConfiguration.class.getDeclaredMethod("getHttpProxy", new Class[0]).invoke(wifiConfiguration, new Object[0]);
                wlanBean.setExclusionList((String) objInvoke.getClass().getDeclaredMethod("getExclusionListAsString", new Class[0]).invoke(objInvoke, new Object[0]));
                wlanBean.setHost((String) objInvoke.getClass().getDeclaredMethod("getHost", new Class[0]).invoke(objInvoke, new Object[0]));
                wlanBean.setPort(String.valueOf(objInvoke.getClass().getDeclaredMethod("getPort", new Class[0]).invoke(objInvoke, new Object[0])));
            } catch (RuntimeException e10) {
                C11839m.m70687e(TAG, "getStaticProxySettings Exception" + e10.getMessage());
            } catch (Exception e11) {
                C11839m.m70687e(TAG, "getStaticProxySettings Exception" + e11.getMessage());
            }
        }
    }

    public boolean hasLocalData() {
        return hasValidNetwork(getWifiContent());
    }

    public abstract boolean hasValidNetwork(String str);

    public WifiConfiguration matchConfiguration(String str, List<WifiConfiguration> list) {
        boolean zStartsWith = str.startsWith(ENCODED_FLAG);
        if (zStartsWith) {
            str = str.substring(8);
        }
        for (WifiConfiguration wifiConfiguration : list) {
            if (zStartsWith) {
                for (String str2 : CHAR_SETS) {
                    if (str.equals(encodeStringToUnicode(wifiConfiguration.SSID, str2))) {
                        return wifiConfiguration;
                    }
                }
            } else if (str.equals(wifiConfiguration.SSID)) {
                return wifiConfiguration;
            }
        }
        return null;
    }

    public abstract List<WlanBean> parseWifiConfig(String str);

    public boolean updateNetWork(WifiConfiguration wifiConfiguration) {
        C11839m.m70686d(TAG, "updateNetWork begin");
        int iUpdateNetwork = this.mWifiManager.updateNetwork(wifiConfiguration);
        C11839m.m70686d(TAG, "updateNetWork result = " + iUpdateNetwork);
        return iUpdateNetwork >= 0;
    }
}
