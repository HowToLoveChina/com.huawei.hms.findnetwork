package p229di;

import android.net.wifi.WifiManager;
import p229di.C9142g;

/* renamed from: di.v */
/* loaded from: classes4.dex */
public class C9157v {
    /* renamed from: a */
    public static String m57502a(WifiManager wifiManager) {
        try {
            return (String) C9142g.a.m57467b(wifiManager, new Class[0]).m57470d("getCountryCode", new Object[0]).m57472f();
        } catch (Exception unused) {
            return "";
        }
    }
}
