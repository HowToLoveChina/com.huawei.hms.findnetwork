package com.huawei.android.backup.filelogic.wifi;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.hwcloudjs.p164f.C6661f;
import p229di.C9157v;

/* loaded from: classes.dex */
public class WiFiUnit {

    /* renamed from: a */
    public WifiManager f9550a;

    /* renamed from: b */
    public boolean f9551b;

    /* renamed from: c */
    public ConnectivityManager f9552c;

    public WiFiUnit(Context context) {
        if (context != null) {
            this.f9550a = (WifiManager) context.getSystemService(C6661f.f30885g);
            this.f9552c = (ConnectivityManager) context.getSystemService("connectivity");
            this.f9551b = this.f9550a.isWifiEnabled();
        }
    }

    /* renamed from: a */
    public String m12667a() {
        WifiManager wifiManager = this.f9550a;
        if (wifiManager != null) {
            try {
                String strM57502a = C9157v.m57502a(wifiManager);
                C2111d.m12654j("WIFIUnit", "countryCode is ", strM57502a);
                return strM57502a;
            } catch (SecurityException unused) {
                C2111d.m12648d("WIFIUnit", "getCountryCode SecurityException !");
            }
        }
        return "";
    }
}
