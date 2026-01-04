package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.util.Pair;
import com.huawei.hms.network.embedded.C5927g2;
import com.huawei.hms.network.httpclient.HttpClient;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.inter.HiAd;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.utils.bv */
/* loaded from: classes2.dex */
public class C7775bv {
    /* renamed from: a */
    private static int m47821a(int i10) {
        switch (i10) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return 4;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return 5;
            case 13:
            case 18:
                return 6;
            case 19:
            default:
                return 0;
            case 20:
                return 7;
        }
    }

    /* renamed from: b */
    public static boolean m47827b() {
        return AbstractC7791ck.m48069b(C5927g2.f26802h) || AbstractC7791ck.m48070c(C5927g2.f26802h);
    }

    /* renamed from: c */
    public static boolean m47829c(Context context) {
        return m47826a(context) || m47828b(context);
    }

    /* renamed from: d */
    public static int m47830d(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || m47834h(context) == null || (connectivityManager = (ConnectivityManager) m47834h(context).getSystemService("connectivity")) == null) {
            return 0;
        }
        try {
            NetworkInfo networkInfoM47822a = m47822a(connectivityManager);
            if (networkInfoM47822a != null) {
                int type = networkInfoM47822a.getType();
                if (type == 0) {
                    return m47821a(networkInfoM47822a.getSubtype());
                }
                if (9 == type) {
                    return 1;
                }
                if (1 == type) {
                    return 2;
                }
            }
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("NetworkUtil", "fail to get network info");
        }
        return 0;
    }

    /* renamed from: e */
    public static boolean m47831e(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || m47834h(context) == null || (connectivityManager = (ConnectivityManager) m47834h(context).getSystemService("connectivity")) == null) {
            return false;
        }
        try {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(connectivityManager.getActiveNetwork());
            if (networkInfo != null) {
                return networkInfo.isConnected();
            }
            return false;
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("NetworkUtil", "fail to check network connection");
            return false;
        }
    }

    /* renamed from: f */
    public static Pair<Integer, Pair<String, String>> m47832f(Context context) {
        Pair<Integer, Pair<String, String>> pairMo47812a = null;
        if (!HiAd.getInstance(context).isEnableUserInfo()) {
            return null;
        }
        if (!AbstractC7807d.m48232d() && C7770bq.m47815b(context)) {
            AbstractC7185ho.m43820b("NetworkUtil", "multicard device");
            InterfaceC7769bp interfaceC7769bpM47813a = C7770bq.m47813a(context);
            pairMo47812a = interfaceC7769bpM47813a.mo47812a(interfaceC7769bpM47813a.mo47811a());
        }
        return pairMo47812a == null ? m47833g(context) : pairMo47812a;
    }

    /* renamed from: g */
    private static Pair<Integer, Pair<String, String>> m47833g(Context context) {
        String strSubstring;
        String strSubstring2;
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                String networkOperator = telephonyManager.getNetworkOperator();
                int networkType = 0;
                if (networkOperator == null || "null".equalsIgnoreCase(networkOperator) || networkOperator.length() <= 3) {
                    strSubstring = null;
                    strSubstring2 = null;
                } else {
                    strSubstring2 = networkOperator.substring(0, 3);
                    strSubstring = networkOperator.substring(3);
                }
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                    networkType = activeNetworkInfo.getSubtype();
                }
                if (networkType == 0) {
                    networkType = telephonyManager.getNetworkType();
                }
                return m47823a(strSubstring2, strSubstring, networkType);
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("NetworkUtil", "getDefaultNetworkOperatorInfo error: %s", th2.getClass().getSimpleName());
        }
        return null;
    }

    /* renamed from: h */
    private static Context m47834h(Context context) {
        if (context == null) {
            return null;
        }
        return context.getApplicationContext();
    }

    /* renamed from: a */
    public static NetworkInfo m47822a(ConnectivityManager connectivityManager) {
        if (connectivityManager == null) {
            return null;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(connectivityManager.getActiveNetwork());
        return (networkInfo == null || 17 != networkInfo.getType()) ? networkInfo : connectivityManager.getActiveNetworkInfo();
    }

    /* renamed from: b */
    public static boolean m47828b(Context context) {
        return context != null && 1 == m47830d(context);
    }

    /* renamed from: a */
    private static Pair<Integer, Pair<String, String>> m47823a(String str, String str2, int i10) {
        return new Pair<>(Integer.valueOf(i10), new Pair(str, str2));
    }

    /* renamed from: a */
    public static HttpClient.Builder m47824a(Context context, boolean z10) throws JSONException {
        HttpClient.Builder builder = new HttpClient.Builder();
        if (!z10) {
            return builder;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("smallpkt_fec", true);
            jSONObject.put("tls_zero_rtt", true);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(AbstractC7803cw.m48131b(C7845x.m48571i(context)));
            String str = File.separator;
            sb2.append(str);
            sb2.append(Constants.PPS_ROOT_PATH);
            sb2.append(str);
            sb2.append(C5927g2.QUIC);
            String string = sb2.toString();
            AbstractC7731ae.m47468g(new File(string));
            jSONObject.put("storage_path", string);
            jSONObject.put("max_server_configs_stored_properties", 10);
        } catch (JSONException unused) {
            Log.w("NetworkUtil", "jsonObject catch a JSONException");
        }
        builder.enableQuic(true).options(jSONObject.toString());
        return builder;
    }

    /* renamed from: a */
    public static boolean m47825a() {
        try {
            C7774bu.m47820a();
            return true;
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("NetworkUtil", "isNetWorKkitSupported Exception:" + th2.getClass().getSimpleName());
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m47826a(Context context) {
        return context != null && 2 == m47830d(context);
    }
}
