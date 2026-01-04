package er;

import android.net.wifi.ScanResult;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;

/* renamed from: er.a */
/* loaded from: classes8.dex */
public final class C9533a {

    /* renamed from: a */
    @SerializedName("BSSID")
    private String f47388a;

    /* renamed from: b */
    @SerializedName("SSID")
    private String f47389b;

    /* renamed from: c */
    @SerializedName("RSSI")
    private int f47390c;

    /* renamed from: d */
    @SerializedName("Frequency")
    private int f47391d;

    /* renamed from: e */
    @SerializedName("IsConnect")
    private int f47392e;

    /* renamed from: f */
    public int f47393f;

    /* renamed from: g */
    @SerializedName("SCANTIME")
    private long f47394g;

    /* renamed from: a */
    public final long m59531a() {
        return this.f47394g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v2, types: [int] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* renamed from: b */
    public final void m59532b(ScanResult scanResult, String str) {
        String str2 = scanResult.BSSID;
        this.f47388a = str2;
        this.f47389b = scanResult.SSID;
        this.f47390c = scanResult.level;
        this.f47391d = scanResult.frequency;
        int i10 = 0;
        this.f47392e = TextUtils.isEmpty(str) ? 0 : str.equals(str2);
        if (scanResult.is80211mcResponder()) {
            i10 = 2;
        } else {
            String str3 = scanResult.capabilities;
            if (!str3.contains("PSK") && !str3.contains("WEP")) {
                i10 = 1;
            }
        }
        this.f47393f = i10;
        this.f47394g = scanResult.timestamp / 1000;
    }

    public final String toString() {
        return "LocWifiInfo{ssid='" + this.f47389b + "', rssi=" + this.f47390c + ", frequency=" + this.f47391d + ", isConnect=" + this.f47392e + ", type=" + this.f47393f + ", scanTime=" + this.f47394g + '}';
    }
}
