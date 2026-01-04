package com.huawei.hms.framework.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.TransportInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.UserManager;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthNr;
import android.telephony.CellSignalStrengthTdscdma;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.HwTelephonyManager;
import android.telephony.SignalStrength;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.InitReport;
import com.huawei.hwcloudjs.p164f.C6661f;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.lang.reflect.Method;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import mu.C11526c;

/* loaded from: classes8.dex */
public class NetworkUtil {
    private static final int INVALID_RSSI = -127;
    private static final String STR_NSA = "5G_NSA";
    private static final String STR_SA = "5G_SA";
    private static final String TAG = "NKUtil";
    private static final int TYPE_WIFI_P2P = 13;
    public static final int UNAVAILABLE = Integer.MAX_VALUE;
    public static volatile boolean isSupportIpv6Net = true;
    public static volatile int networkTypeByReceiver;

    /* renamed from: com.huawei.hms.framework.common.NetworkUtil$1 */
    public class C54201 implements PrivilegedAction {
        final /* synthetic */ Method val$method;

        public C54201(Method method) {
            this.val$method = method;
        }

        @Override // java.security.PrivilegedAction
        public Object run() throws SecurityException {
            this.val$method.setAccessible(true);
            return null;
        }
    }

    public static final class NetType {
        public static final int TYPE_2G = 2;
        public static final int TYPE_3G = 3;
        public static final int TYPE_4G = 4;
        public static final int TYPE_4G_NSA = 7;
        public static final int TYPE_5G = 5;
        public static final int TYPE_5G_SA = 8;
        public static final int TYPE_MOBILE = 6;
        public static final int TYPE_NO_NETWORK = -1;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_WIFI = 1;
    }

    public static final class SignalType {
        public static final String LTE_CQI = "lteCqi";
        public static final String LTE_DBM = "lteDbm";
        public static final String LTE_RSRP = "lteRsrp";
        public static final String LTE_RSRQ = "lteRsrq";
        public static final String LTE_RSSI = "lteRssi";
        public static final String LTE_RSSNR = "lteRssnr";
        public static final String NR_CSIRSRP = "nrCSIRsrp";
        public static final String NR_CSIRSRQ = "nrCSIRsrq";
        public static final String NR_CSISINR = "nrCSISinr";
        public static final String NR_DBM = "nrDbm";
        public static final String NR_SSRSRP = "nrSSRsrp";
        public static final String NR_SSRSRQ = "nrSSRsrq";
        public static final String NR_SSSINR = "nrSSSinr";
    }

    public static int getCurrentNetworkType() {
        return networkTypeByReceiver;
    }

    public static String getDnsServerIps(Context context) {
        return Arrays.toString(getDnsServerIpsFromConnectionManager(context));
    }

    @SuppressLint({"MissingPermission"})
    private static String[] getDnsServerIpsFromConnectionManager(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo networkInfo;
        LinkProperties linkProperties;
        LinkedList linkedList = new LinkedList();
        if (context != null && (connectivityManager = (ConnectivityManager) ContextCompat.getSystemService(context, "connectivity")) != null) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    for (Network network : connectivityManager.getAllNetworks()) {
                        if (network != null && (networkInfo = connectivityManager.getNetworkInfo(network)) != null && networkInfo.getType() == activeNetworkInfo.getType() && (linkProperties = connectivityManager.getLinkProperties(network)) != null) {
                            Iterator<InetAddress> it = linkProperties.getDnsServers().iterator();
                            while (it.hasNext()) {
                                linkedList.add(it.next().getHostAddress());
                            }
                        }
                    }
                }
            } catch (SecurityException e10) {
                Logger.m32141i(TAG, "getActiveNetworkInfo failed, exception:" + e10.getClass().getSimpleName());
            } catch (RuntimeException e11) {
                Logger.m32141i(TAG, "getActiveNetworkInfo failed, exception:" + e11.getClass().getSimpleName());
            }
        }
        return linkedList.isEmpty() ? new String[0] : (String[]) linkedList.toArray(new String[linkedList.size()]);
    }

    public static String getHost(String str) {
        return TextUtils.isEmpty(str) ? "" : C11526c.m68805b(str);
    }

    public static int getInfoWithReflect(SignalStrength signalStrength, String str) {
        return Integer.MAX_VALUE;
    }

    public static int getLteCqi(Context context) {
        SignalStrength signalStrength = getSignalStrength(context);
        if (signalStrength == null) {
            return Integer.MAX_VALUE;
        }
        try {
            List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthLte.class);
            if (cellSignalStrengths.size() > 0) {
                return ((CellSignalStrengthLte) cellSignalStrengths.get(0)).getCqi();
            }
        } catch (Throwable th2) {
            Logger.m32141i(TAG, "getLteCqi: throwable:" + th2.getClass());
        }
        return Integer.MAX_VALUE;
    }

    public static int getLteRsrp(Context context) {
        SignalStrength signalStrength = getSignalStrength(context);
        if (signalStrength == null) {
            return Integer.MAX_VALUE;
        }
        try {
            List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthLte.class);
            if (cellSignalStrengths.size() > 0) {
                return ((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRsrp();
            }
        } catch (Throwable th2) {
            Logger.m32141i(TAG, "getLteRsrp: throwable:" + th2.getClass());
        }
        return Integer.MAX_VALUE;
    }

    public static int getLteRsrq(Context context) {
        SignalStrength signalStrength = getSignalStrength(context);
        if (signalStrength == null) {
            return Integer.MAX_VALUE;
        }
        try {
            List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthLte.class);
            if (cellSignalStrengths.size() > 0) {
                return ((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRsrq();
            }
        } catch (Throwable th2) {
            Logger.m32141i(TAG, "getLteRsrq: throwable:" + th2.getClass());
        }
        return Integer.MAX_VALUE;
    }

    public static int getLteRssi(Context context) {
        SignalStrength signalStrength = getSignalStrength(context);
        if (signalStrength == null) {
            return Integer.MAX_VALUE;
        }
        try {
            List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthLte.class);
            if (cellSignalStrengths.size() > 0) {
                return ((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRssi();
            }
        } catch (Throwable th2) {
            Logger.m32141i(TAG, "getLteRssi: throwable:" + th2.getClass());
        }
        return Integer.MAX_VALUE;
    }

    public static int getLteRssnr(Context context) {
        SignalStrength signalStrength = getSignalStrength(context);
        if (signalStrength == null) {
            return Integer.MAX_VALUE;
        }
        try {
            List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthLte.class);
            if (cellSignalStrengths.size() > 0) {
                return ((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRssnr();
            }
        } catch (Throwable th2) {
            Logger.m32141i(TAG, "getLteRssnr: throwable:" + th2.getClass());
        }
        return Integer.MAX_VALUE;
    }

    public static Map<String, Integer> getLteSignalInfo(Context context) {
        HashMap map = new HashMap();
        SignalStrength signalStrength = getSignalStrength(context);
        if (signalStrength == null) {
            return map;
        }
        try {
            List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthLte.class);
            if (cellSignalStrengths.size() > 0) {
                map.put(SignalType.LTE_DBM, Integer.valueOf(((CellSignalStrengthLte) cellSignalStrengths.get(0)).getDbm()));
                map.put(SignalType.LTE_RSRP, Integer.valueOf(((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRsrp()));
                map.put(SignalType.LTE_RSRQ, Integer.valueOf(((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRsrq()));
                map.put(SignalType.LTE_RSSNR, Integer.valueOf(((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRssnr()));
                map.put(SignalType.LTE_CQI, Integer.valueOf(((CellSignalStrengthLte) cellSignalStrengths.get(0)).getCqi()));
                map.put(SignalType.LTE_RSSI, Integer.valueOf(((CellSignalStrengthLte) cellSignalStrengths.get(0)).getRssi()));
            }
        } catch (Throwable th2) {
            Logger.m32141i(TAG, "getLteRssi: throwable:" + th2.getClass());
        }
        return map;
    }

    public static String getMNC(Context context) {
        if (context == null || !isSimReady(context)) {
            return "unknown";
        }
        Object systemService = ContextCompat.getSystemService(context, "phone");
        TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
        if (telephonyManager == null) {
            Logger.m32138e(TAG, "getSubscriptionOperatorType: other error!");
            return "unknown";
        }
        String networkOperator = telephonyManager.getNetworkOperator();
        return ("46001".equals(networkOperator) || "46006".equals(networkOperator) || "46009".equals(networkOperator)) ? "China_Unicom" : ("46000".equals(networkOperator) || "46002".equals(networkOperator) || "46004".equals(networkOperator) || "46007".equals(networkOperator)) ? "China_Mobile" : ("46003".equals(networkOperator) || "46005".equals(networkOperator) || "46011".equals(networkOperator)) ? "China_Telecom" : "other";
    }

    public static int getMobileRsrp(Context context) {
        if (getSignalStrength(context) == null) {
            return Integer.MAX_VALUE;
        }
        try {
            return getMobileSingalStrengthUpPPlatfrom(context);
        } catch (Throwable th2) {
            Logger.m32141i(TAG, "getDbm: throwable:" + th2.getClass());
            return Integer.MAX_VALUE;
        }
    }

    private static int getMobileSingalStrengthUpPPlatfrom(Context context) {
        SignalStrength signalStrength = getSignalStrength(context);
        int dbm = Integer.MAX_VALUE;
        if (signalStrength == null) {
            return Integer.MAX_VALUE;
        }
        int networkType = getNetworkType(context);
        try {
        } catch (Throwable th2) {
            Logger.m32141i(TAG, "getMobileSingalStrength: throwable:" + th2.getClass());
        }
        if (networkType == 3) {
            List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthCdma.class);
            if (cellSignalStrengths.size() > 0) {
                dbm = ((CellSignalStrengthCdma) cellSignalStrengths.get(0)).getDbm();
            } else {
                List cellSignalStrengths2 = signalStrength.getCellSignalStrengths(CellSignalStrengthTdscdma.class);
                if (cellSignalStrengths2.size() > 0) {
                    dbm = ((CellSignalStrengthTdscdma) cellSignalStrengths2.get(0)).getDbm();
                } else {
                    List cellSignalStrengths3 = signalStrength.getCellSignalStrengths(CellSignalStrengthWcdma.class);
                    if (cellSignalStrengths3.size() > 0) {
                        dbm = ((CellSignalStrengthWcdma) cellSignalStrengths3.get(0)).getDbm();
                    }
                }
            }
        } else {
            if (networkType != 4) {
                if (networkType == 5) {
                    List cellSignalStrengths4 = signalStrength.getCellSignalStrengths(CellSignalStrengthNr.class);
                    if (cellSignalStrengths4.size() > 0) {
                        dbm = ((CellSignalStrengthNr) cellSignalStrengths4.get(0)).getDbm();
                    }
                }
                return dbm;
            }
            List cellSignalStrengths5 = signalStrength.getCellSignalStrengths(CellSignalStrengthLte.class);
            if (cellSignalStrengths5.size() > 0) {
                dbm = ((CellSignalStrengthLte) cellSignalStrengths5.get(0)).getDbm();
            }
        }
        return dbm;
    }

    public static String getNetWorkNSAorSA() {
        try {
            HwTelephonyManager hwTelephonyManager = HwTelephonyManager.getDefault();
            int default4GSlotId = hwTelephonyManager.getDefault4GSlotId();
            Logger.m32143v(TAG, "phoneId " + default4GSlotId);
            boolean zIsNsaState = hwTelephonyManager.isNsaState(default4GSlotId);
            Logger.m32143v(TAG, "isNsa " + zIsNsaState);
            return zIsNsaState ? STR_NSA : STR_SA;
        } catch (Throwable unused) {
            Logger.m32143v(TAG, "isNsaState error");
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static NetworkInfo getNetworkInfo(Context context) {
        ConnectivityManager connectivityManager;
        if (!ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = (ConnectivityManager) ContextCompat.getSystemService(context, "connectivity")) == null) {
            return null;
        }
        try {
            return connectivityManager.getActiveNetworkInfo();
        } catch (RuntimeException e10) {
            Logger.m32141i(TAG, "getActiveNetworkInfo failed, exception:" + e10.getClass().getSimpleName() + e10.getMessage());
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static NetworkInfo.DetailedState getNetworkStatus(Context context) {
        NetworkInfo.DetailedState detailedState = NetworkInfo.DetailedState.IDLE;
        if (context != null) {
            Object systemService = ContextCompat.getSystemService(context, "connectivity");
            if (systemService instanceof ConnectivityManager) {
                try {
                    if (!ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                        return detailedState;
                    }
                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
                    if (activeNetworkInfo != null) {
                        detailedState = activeNetworkInfo.getDetailedState();
                    } else {
                        Logger.m32141i(TAG, "getNetworkStatus networkIsConnected netInfo is null!");
                    }
                } catch (RuntimeException e10) {
                    Logger.m32141i(TAG, "getNetworkStatus exception" + e10.getClass().getSimpleName() + e10.getMessage());
                }
            } else {
                Logger.m32141i(TAG, "getNetworkStatus ConnectivityManager is null!");
            }
        }
        return detailedState;
    }

    public static int getNetworkType(Context context) {
        if (context != null) {
            return getNetworkType(getNetworkInfo(context), context);
        }
        return 0;
    }

    public static int getNrCsiRsrp(Context context) {
        SignalStrength signalStrength;
        try {
            signalStrength = getSignalStrength(context);
        } catch (Throwable th2) {
            Logger.m32141i(TAG, "getNrCsiRsrp: throwable:" + th2.getClass());
        }
        if (signalStrength == null) {
            return Integer.MAX_VALUE;
        }
        List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthNr.class);
        if (cellSignalStrengths.size() > 0) {
            return ((CellSignalStrengthNr) cellSignalStrengths.get(0)).getCsiRsrp();
        }
        return Integer.MAX_VALUE;
    }

    public static int getNrCsiRsrq(Context context) {
        SignalStrength signalStrength;
        try {
            signalStrength = getSignalStrength(context);
        } catch (Throwable th2) {
            Logger.m32141i(TAG, "getNrCsiRsrq: throwable:" + th2.getClass());
        }
        if (signalStrength == null) {
            return Integer.MAX_VALUE;
        }
        List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthNr.class);
        if (cellSignalStrengths.size() > 0) {
            return ((CellSignalStrengthNr) cellSignalStrengths.get(0)).getCsiRsrq();
        }
        return Integer.MAX_VALUE;
    }

    public static int getNrCsiSinr(Context context) {
        SignalStrength signalStrength;
        try {
            signalStrength = getSignalStrength(context);
        } catch (Throwable th2) {
            Logger.m32141i(TAG, "getNrCsiSinr: throwable:" + th2.getClass());
        }
        if (signalStrength == null) {
            return Integer.MAX_VALUE;
        }
        List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthNr.class);
        if (cellSignalStrengths.size() > 0) {
            return ((CellSignalStrengthNr) cellSignalStrengths.get(0)).getCsiSinr();
        }
        return Integer.MAX_VALUE;
    }

    public static Map<String, Integer> getNrSignalInfo(Context context) {
        HashMap map = new HashMap();
        SignalStrength signalStrength = getSignalStrength(context);
        if (signalStrength == null) {
            return map;
        }
        try {
            List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthNr.class);
            if (cellSignalStrengths.size() > 0) {
                map.put(SignalType.NR_DBM, Integer.valueOf(((CellSignalStrengthNr) cellSignalStrengths.get(0)).getDbm()));
                map.put(SignalType.NR_CSIRSRP, Integer.valueOf(((CellSignalStrengthNr) cellSignalStrengths.get(0)).getCsiRsrp()));
                map.put(SignalType.NR_CSIRSRQ, Integer.valueOf(((CellSignalStrengthNr) cellSignalStrengths.get(0)).getCsiRsrq()));
                map.put(SignalType.NR_CSISINR, Integer.valueOf(((CellSignalStrengthNr) cellSignalStrengths.get(0)).getCsiSinr()));
                map.put(SignalType.NR_SSRSRP, Integer.valueOf(((CellSignalStrengthNr) cellSignalStrengths.get(0)).getSsRsrp()));
                map.put(SignalType.NR_SSRSRQ, Integer.valueOf(((CellSignalStrengthNr) cellSignalStrengths.get(0)).getSsRsrq()));
                map.put(SignalType.NR_SSSINR, Integer.valueOf(((CellSignalStrengthNr) cellSignalStrengths.get(0)).getSsSinr()));
            }
        } catch (Throwable th2) {
            Logger.m32141i(TAG, "getLteRssi: throwable:" + th2.getClass());
        }
        return map;
    }

    public static int getNrSsRsrp(Context context) {
        SignalStrength signalStrength;
        try {
            signalStrength = getSignalStrength(context);
        } catch (Throwable th2) {
            Logger.m32141i(TAG, "getNrSsRsrp: throwable:" + th2.getClass());
        }
        if (signalStrength == null) {
            return Integer.MAX_VALUE;
        }
        List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthNr.class);
        if (cellSignalStrengths.size() > 0) {
            return ((CellSignalStrengthNr) cellSignalStrengths.get(0)).getSsRsrp();
        }
        return Integer.MAX_VALUE;
    }

    public static int getNrSsRsrq(Context context) {
        SignalStrength signalStrength;
        try {
            signalStrength = getSignalStrength(context);
        } catch (Throwable th2) {
            Logger.m32141i(TAG, "getNrSsRsrq: throwable:" + th2.getClass());
        }
        if (signalStrength == null) {
            return Integer.MAX_VALUE;
        }
        List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthNr.class);
        if (cellSignalStrengths.size() > 0) {
            return ((CellSignalStrengthNr) cellSignalStrengths.get(0)).getSsRsrq();
        }
        return Integer.MAX_VALUE;
    }

    public static int getNrSsSinr(Context context) {
        SignalStrength signalStrength;
        try {
            signalStrength = getSignalStrength(context);
        } catch (Throwable th2) {
            Logger.m32141i(TAG, "getNrSsSinr: throwable:" + th2.getClass());
        }
        if (signalStrength == null) {
            return Integer.MAX_VALUE;
        }
        List cellSignalStrengths = signalStrength.getCellSignalStrengths(CellSignalStrengthNr.class);
        if (cellSignalStrengths.size() > 0) {
            return ((CellSignalStrengthNr) cellSignalStrengths.get(0)).getSsSinr();
        }
        return Integer.MAX_VALUE;
    }

    public static int getPrimaryNetworkType(Context context) {
        return groupNetworkType(getNetworkType(getNetworkInfo(context), context));
    }

    private static SignalStrength getSignalStrength(Context context) {
        if (context != null) {
            return getTrafficCardTelephonyManager(context).getSignalStrength();
        }
        return null;
    }

    public static TelephonyManager getTrafficCardTelephonyManager(Context context) {
        if (context == null) {
            return null;
        }
        Object systemService = ContextCompat.getSystemService(context, "phone");
        if (systemService instanceof TelephonyManager) {
            return ((TelephonyManager) systemService).createForSubscriptionId(SubscriptionManager.getDefaultDataSubscriptionId());
        }
        return null;
    }

    public static String getWifiGatewayIp(Context context) {
        if (context == null) {
            return " ";
        }
        Object systemService = ContextCompat.getSystemService(context.getApplicationContext(), C6661f.f30885g);
        if (!(systemService instanceof WifiManager)) {
            return " ";
        }
        try {
            int i10 = ((WifiManager) systemService).getDhcpInfo().gateway;
            return InetAddress.getByAddress(new byte[]{(byte) (i10 & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA), (byte) ((i10 >> 8) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA), (byte) ((i10 >> 16) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA), (byte) ((i10 >> 24) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA)}).getHostAddress();
        } catch (RuntimeException | UnknownHostException e10) {
            Logger.m32141i(TAG, "getWifiGatewayIp error!" + e10.getClass().getSimpleName() + e10.getMessage());
            return " ";
        }
    }

    public static int getWifiRssi(Context context) {
        TransportInfo transportInfo;
        int rssi = -127;
        if (context != null && Build.VERSION.SDK_INT >= 31) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                for (Network network : connectivityManager.getAllNetworks()) {
                    NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
                    if (networkCapabilities != null && networkCapabilities.hasTransport(1) && (transportInfo = networkCapabilities.getTransportInfo()) != null && (transportInfo instanceof WifiInfo)) {
                        rssi = ((WifiInfo) transportInfo).getRssi();
                    }
                }
            } catch (RuntimeException e10) {
                Logger.m32141i(TAG, "getWifiRssiLevel did not has permission!" + e10.getClass().getSimpleName() + e10.getMessage());
            }
        }
        return rssi;
    }

    public static int getWifiRssiLevel(Context context) {
        return WifiManager.calculateSignalLevel(getWifiRssi(context), 5);
    }

    private static int groupNetworkType(int i10) {
        if (i10 == -1) {
            return -1;
        }
        if (i10 != 1) {
            return (i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5) ? 6 : 0;
        }
        return 1;
    }

    public static boolean isChangeToConnected(NetworkInfo networkInfo, NetworkInfo networkInfo2) {
        if ((networkInfo != null && networkInfo.isConnected()) || !networkInfo2.isConnected()) {
            return false;
        }
        Logger.m32143v(TAG, "Find network state changed to connected");
        return true;
    }

    public static boolean isConnectTypeChange(NetworkInfo networkInfo, NetworkInfo networkInfo2) {
        if (networkInfo == null || !networkInfo.isConnected() || !networkInfo2.isConnected() || getPrimaryNetworkType(networkInfo) == getPrimaryNetworkType(networkInfo2)) {
            return false;
        }
        Logger.m32143v(TAG, "Find activity network changed");
        return true;
    }

    @Deprecated
    public static boolean isForeground(Context context) {
        return ActivityUtil.isForeground(context);
    }

    public static boolean isNetworkAvailable(Context context) {
        if (!ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        NetworkInfo networkInfo = getNetworkInfo(context);
        return networkInfo != null && networkInfo.isConnected();
    }

    public static boolean isSimReady(Context context) {
        Object systemService = ContextCompat.getSystemService(context, "phone");
        TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
        return telephonyManager != null && telephonyManager.getSimState() == 5;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean isSupportIpv6Net(Context context, int i10) {
        boolean z10 = i10 > 1;
        if (context == null) {
            return z10;
        }
        if (!ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            Logger.m32143v(TAG, "has no network state permission");
            return z10;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            Logger.m32138e(TAG, "mConnectivityManager is null");
            return z10;
        }
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null) {
            Logger.m32138e(TAG, "network is null");
            return z10;
        }
        LinkProperties linkProperties = connectivityManager.getLinkProperties(activeNetwork);
        if (linkProperties == null) {
            Logger.m32138e(TAG, "ipInfo is null");
            return z10;
        }
        List<LinkAddress> linkAddresses = linkProperties.getLinkAddresses();
        for (int i11 = 0; i11 < linkAddresses.size(); i11++) {
            InetAddress address = linkAddresses.get(i11).getAddress();
            if ((address instanceof Inet6Address) && !address.isLinkLocalAddress() && !address.isLoopbackAddress()) {
                Logger.m32143v(TAG, "has ipv6 interface");
                return true;
            }
        }
        Logger.m32143v(TAG, "has not ipv6 interface");
        return false;
    }

    public static boolean isUserUnlocked(Context context) {
        UserManager userManager = (UserManager) ContextCompat.getSystemService(context, "user");
        if (userManager == null) {
            return true;
        }
        try {
            return userManager.isUserUnlocked();
        } catch (RuntimeException e10) {
            Logger.m32139e(TAG, "dealType rethrowFromSystemServer:", e10);
            return true;
        }
    }

    public static int netWork(Context context) {
        int networkType = getNetworkType(context);
        Logger.m32143v(TAG, "networkType " + networkType);
        if (networkType == 4) {
            if (TextUtils.equals(STR_NSA, getNetWorkNSAorSA())) {
                return 7;
            }
            return networkType;
        }
        if (networkType == 5 && TextUtils.equals(STR_SA, getNetWorkNSAorSA())) {
            return 8;
        }
        return networkType;
    }

    @Deprecated
    public static NetworkInfo.DetailedState networkStatus(Context context) {
        return getNetworkStatus(context);
    }

    @SuppressLint({"MissingPermission"})
    public static int readDataSaverMode(Context context) {
        int restrictBackgroundStatus = 0;
        if (context != null && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            Object systemService = ContextCompat.getSystemService(context, "connectivity");
            if (systemService instanceof ConnectivityManager) {
                ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
                try {
                    if (connectivityManager.isActiveNetworkMetered()) {
                        restrictBackgroundStatus = connectivityManager.getRestrictBackgroundStatus();
                    } else {
                        Logger.m32143v(TAG, "ConnectType is not Mobile Network!");
                    }
                } catch (RuntimeException e10) {
                    Logger.m32139e(TAG, "SystemServer error:", e10);
                }
            }
        }
        return restrictBackgroundStatus;
    }

    public static void updateCurrentNetworkType() {
        networkTypeByReceiver = netWork(ContextHolder.getResourceContext());
        if (InitReport.isHasConnectNet()) {
            isSupportIpv6Net = isSupportIpv6Net(ContextHolder.getResourceContext(), networkTypeByReceiver);
            Logger.m32141i(TAG, "update currentNetworkType: " + networkTypeByReceiver + ", isSupportIpv6Net:" + isSupportIpv6Net);
        }
    }

    public static boolean isForeground() {
        return ActivityUtil.getInstance().isForeground();
    }

    public static int getNetworkType(NetworkInfo networkInfo, Context context) {
        int i10;
        if (networkInfo == null || !networkInfo.isConnected()) {
            return -1;
        }
        int type = networkInfo.getType();
        if (1 == type || 13 == type) {
            return 1;
        }
        if (type != 0) {
            return 0;
        }
        int subtype = networkInfo.getSubtype();
        Logger.m32143v(TAG, "getHwNetworkType return is: " + subtype);
        if (subtype == 0) {
            subtype = networkInfo.getSubtype();
        }
        if (subtype != 20) {
            switch (subtype) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    i10 = 2;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    i10 = 3;
                    break;
                case 13:
                    i10 = 4;
                    break;
                default:
                    i10 = 0;
                    break;
            }
        } else {
            i10 = 5;
        }
        if (i10 != 0) {
            return i10;
        }
        if (subtype != 16) {
            return subtype != 17 ? 0 : 3;
        }
        return 2;
    }

    public static int getPrimaryNetworkType(NetworkInfo networkInfo) {
        return groupNetworkType(getNetworkType(networkInfo));
    }

    public static int getNetworkType(NetworkInfo networkInfo) {
        return getNetworkType(networkInfo, null);
    }

    public static boolean isSupportIpv6Net() {
        return isSupportIpv6Net;
    }
}
