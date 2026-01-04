package com.huawei.location.crowdsourcing;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import as.C1016d;
import br.InterfaceC1273a;
import com.google.gson.annotations.SerializedName;
import com.huawei.hiar.ARImageMetadata;
import com.huawei.location.C6769i;
import com.huawei.location.lite.common.config.ConfigBaseResponse;
import es.C9549n;
import gu.C10048b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import p235ds.C9302c;
import p237du.C9310c;
import p588qr.C12390b;
import p784xq.C13850f;

/* loaded from: classes8.dex */
public final class Config implements InterfaceC1273a {

    /* renamed from: a */
    public Configurations f31244a;

    /* renamed from: b */
    public long f31245b;

    /* renamed from: c */
    public long f31246c;

    /* renamed from: d */
    public int f31247d;

    /* renamed from: e */
    public long f31248e;

    /* renamed from: f */
    public int f31249f;

    /* renamed from: g */
    public int f31250g;

    /* renamed from: h */
    public long f31251h;

    /* renamed from: i */
    public int f31252i;

    /* renamed from: j */
    public int f31253j;

    /* renamed from: k */
    public long f31254k;

    /* renamed from: l */
    public String f31255l;

    /* renamed from: m */
    public boolean f31256m;

    /* renamed from: n */
    public String f31257n;

    /* renamed from: o */
    public SharedPreferences.Editor f31258o;

    /* renamed from: p */
    public int f31259p;

    public static class Configurations extends ConfigBaseResponse {

        @SerializedName("GEO_LOCATION_COLLECT_TYPE")
        private int collectType = -1;

        @SerializedName("LOCATION_COLLECT_INTERVAL")
        private long collectInterval = 5000;

        @SerializedName("LOCATION_DISTANCE_INTERVAL")
        private int collectDistance = 5;

        @SerializedName("LOCATION_UPLOAD_TIME")
        private long uploadInterval = 1800;

        @SerializedName("LOCATION_UPLOAD_NUM")
        private int uploadNumThreshold = 5;

        @SerializedName("WIFI_COLLECT_MAX_NUM")
        private int wifiDailyLimit = 1000;

        @SerializedName("WIFI_AP_COLLCT_MAX_NUM")
        private int wifiApNumLimit = 200;

        @SerializedName("WIFI_SCANRESULT_VALID_INTERVAL")
        private long wifiValidInterval = 5000;

        @SerializedName("CELL_COLLECT_MAX_NUM")
        private int cellDailyLimit = 1000;

        @SerializedName("CELL_COLLECT_INTERVAL")
        private long cellCollectInterval = 10000;

        @SerializedName("CELL_SCANRESULT_VALID_INTERVAL")
        private long cellValidInterval = 20000;

        @SerializedName("LOCAL_RECORD_FILE_MAX_SIZE")
        private int cacheSizeLimit = 50;

        @SerializedName("LOG_SERVER_KEY")
        private String logServerKey = "";

        @SerializedName("MCC_EXCLUDE_LIST")
        private List<String> excludeMccList = new ArrayList();

        @SerializedName("UPLOAD_PUBLIC_KEY")
        private String uploadPublicKey = "";

        private Configurations() {
        }

        private boolean checkWifiCell() {
            String str;
            if (this.wifiDailyLimit < 0) {
                str = "wifiDailyLimit error";
            } else if (this.wifiApNumLimit < 0) {
                str = "wifiApNumLimit error";
            } else if (this.wifiValidInterval < 0) {
                str = "wifiValidInterval error";
            } else if (this.cellDailyLimit < 0) {
                str = "cellDailyLimit error";
            } else if (this.cellCollectInterval < 0) {
                str = "cellCollectInterval error";
            } else {
                if (this.cellValidInterval >= 0) {
                    return true;
                }
                str = "cellValidInterval error";
            }
            C1016d.m6181a("Config", str);
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean valid() {
            String str;
            int i10 = this.collectType;
            if (i10 < -1 || i10 > 2) {
                str = "collectType error";
            } else if (this.collectInterval < 0 || this.collectDistance < 0) {
                str = "collectInterval or collectDistance error";
            } else if (this.uploadInterval < 0 || this.uploadNumThreshold < 0) {
                str = "uploadInterval or uploadNumThreshold error";
            } else {
                if (!checkWifiCell()) {
                    return false;
                }
                if (this.cacheSizeLimit < 0) {
                    str = "cacheSizeLimit error";
                } else if (this.logServerKey.isEmpty()) {
                    str = "logServer error";
                } else {
                    if (!TextUtils.isEmpty(this.uploadPublicKey)) {
                        return true;
                    }
                    str = "public key config error";
                }
            }
            C1016d.m6181a("Config", str);
            return false;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("Configurations{collectType=");
            sb2.append(this.collectType);
            sb2.append(", collectInterval=");
            sb2.append(this.collectInterval);
            sb2.append(", collectDistance=");
            sb2.append(this.collectDistance);
            sb2.append(", uploadInterval=");
            sb2.append(this.uploadInterval);
            sb2.append(", uploadNumThreshold=");
            sb2.append(this.uploadNumThreshold);
            sb2.append(", wifiDailyLimit=");
            sb2.append(this.wifiDailyLimit);
            sb2.append(", wifiApNumLimit=");
            sb2.append(this.wifiApNumLimit);
            sb2.append(", wifiValidInterval=");
            sb2.append(this.wifiValidInterval);
            sb2.append(", cellDailyLimit=");
            sb2.append(this.cellDailyLimit);
            sb2.append(", cellCollectInterval=");
            sb2.append(this.cellCollectInterval);
            sb2.append(", cellValidInterval=");
            sb2.append(this.cellValidInterval);
            sb2.append(", cacheSizeLimit=");
            return C6769i.m38373a(sb2, this.cacheSizeLimit, '}');
        }
    }

    /* renamed from: com.huawei.location.crowdsourcing.Config$a */
    public class HandlerC6743a extends Handler {
        public HandlerC6743a(Looper looper) {
            super(looper);
        }

        /* renamed from: a */
        public final void m38319a() {
            long jM38294x = Config.m38294x(Config.this) + 10000;
            Locale locale = Locale.ENGLISH;
            C1016d.m6186f("Config", "reset need wait " + jM38294x + "ms");
            sendEmptyMessageDelayed(0, jM38294x);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message.what != 0) {
                C1016d.m6183c("Config", "unknown msg:" + message.what);
                return;
            }
            long jM38294x = Config.m38294x(Config.this) + 10000;
            Locale locale = Locale.ENGLISH;
            C1016d.m6186f("Config", "reset need wait " + jM38294x + "ms");
            sendEmptyMessageDelayed(0, jM38294x);
        }
    }

    /* renamed from: com.huawei.location.crowdsourcing.Config$b */
    public static class C6744b {

        /* renamed from: a */
        public static final Config f31261a = new Config(0);
    }

    public Config() {
        this.f31259p = 1;
        this.f31249f = 0;
        this.f31250g = 0;
        this.f31251h = 0L;
        this.f31254k = 0L;
        this.f31255l = "";
        this.f31256m = false;
        this.f31257n = "";
    }

    /* renamed from: w */
    public static String m38293w() {
        C9302c c9302c = new C9302c(3);
        String strM59624b = new C9549n("crowdsourcing_config").m59624b("sp_random_key");
        if (strM59624b != null) {
            String[] strArrSplit = strM59624b.split(":");
            if (strArrSplit.length != 2) {
                C9302c c9302c2 = new C9302c(3);
                String strM62473e = C10048b.m62473e(32);
                String strMo38473b = c9302c2.mo38473b(strM62473e, "RECORD_CROWD");
                String strMo38473b2 = c9302c2.mo38473b(C9310c.m58618b(strMo38473b), "RECORD_CROWD");
                new C9549n("crowdsourcing_config").m59627e("sp_random_key", strMo38473b + ":" + strMo38473b2);
                return strM62473e;
            }
            if (!TextUtils.isEmpty(strArrSplit[0]) && C9310c.m58621e(strArrSplit[0], c9302c.mo38472a(strArrSplit[1], "RECORD_CROWD"))) {
                return c9302c.mo38472a(strArrSplit[0], "RECORD_CROWD");
            }
        }
        C9302c c9302c3 = new C9302c(3);
        String strM62473e2 = C10048b.m62473e(32);
        String strMo38473b3 = c9302c3.mo38473b(strM62473e2, "RECORD_CROWD");
        String strMo38473b4 = c9302c3.mo38473b(C9310c.m58618b(strMo38473b3), "RECORD_CROWD");
        new C9549n("crowdsourcing_config").m59627e("sp_random_key", strMo38473b3 + ":" + strMo38473b4);
        return strM62473e2;
    }

    /* renamed from: x */
    public static long m38294x(Config config) {
        config.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Math.abs(jCurrentTimeMillis - config.f31251h) > 86400000) {
            C1016d.m6186f("Config", "checkReset reset");
            config.f31251h = jCurrentTimeMillis;
            config.f31258o.putLong("RESET_TIMESTAMP", jCurrentTimeMillis).apply();
            C1016d.m6186f("Config", "reset Counters");
            config.f31249f = 0;
            config.f31250g = 0;
            config.f31258o.putInt("WIFI_NUM", 0).putInt("CELL_NUM", config.f31250g).apply();
        }
        return (config.f31251h + 86400000) - jCurrentTimeMillis;
    }

    /* renamed from: A */
    public final long m38295A() {
        return this.f31244a.collectInterval;
    }

    @Override // br.InterfaceC1273a
    /* renamed from: a */
    public final void mo7544a() {
        C1016d.m6190j("Config", "Stop");
    }

    /* renamed from: b */
    public final long m38296b() {
        return this.f31246c;
    }

    /* renamed from: c */
    public final long m38297c() {
        return this.f31244a.wifiValidInterval;
    }

    /* renamed from: d */
    public final boolean m38298d() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z10 = Math.abs(jCurrentTimeMillis - this.f31254k) >= (this.f31245b << this.f31252i);
        if (z10) {
            this.f31254k = jCurrentTimeMillis;
            this.f31258o.putLong("UPLOAD_TIMESTAMP", jCurrentTimeMillis).apply();
        }
        return z10;
    }

    /* renamed from: e */
    public final void m38299e() {
        int i10 = this.f31249f + 1;
        this.f31249f = i10;
        this.f31258o.putInt("WIFI_NUM", i10).apply();
    }

    /* renamed from: f */
    public final String m38300f() {
        return this.f31255l;
    }

    /* renamed from: g */
    public final int m38301g() {
        return this.f31247d;
    }

    /* renamed from: h */
    public final long m38302h() {
        return this.f31248e;
    }

    /* renamed from: i */
    public final String m38303i() {
        return this.f31257n;
    }

    /* renamed from: j */
    public final boolean m38304j() {
        return this.f31259p == 1;
    }

    /* renamed from: k */
    public final void m38305k() {
        int i10 = this.f31250g + 1;
        this.f31250g = i10;
        this.f31258o.putInt("CELL_NUM", i10).apply();
    }

    /* renamed from: l */
    public final void m38306l(String str) {
        this.f31258o.putString("PATCH_POLICY", str).apply();
    }

    /* renamed from: m */
    public final int m38307m() {
        return this.f31244a.wifiApNumLimit;
    }

    /* renamed from: n */
    public final int m38308n() {
        return this.f31244a.uploadNumThreshold;
    }

    /* renamed from: o */
    public final boolean m38309o() {
        int i10 = this.f31259p;
        return (i10 == 1 || i10 == 4 || this.f31249f >= this.f31244a.wifiDailyLimit) ? false : true;
    }

    /* renamed from: p */
    public final int m38310p() {
        return this.f31244a.collectDistance;
    }

    /* renamed from: q */
    public final long m38311q() {
        return this.f31244a.cellCollectInterval;
    }

    /* renamed from: r */
    public final String m38312r() {
        return this.f31244a.uploadPublicKey;
    }

    /* renamed from: s */
    public final void m38313s() {
        int i10 = this.f31252i;
        int i11 = this.f31253j;
        if (i10 != i11) {
            if (i10 < i11) {
                this.f31252i = i10 + 1;
            } else {
                this.f31252i = i11;
            }
            this.f31258o.putInt("CONTINUOUS_UPLOAD_FAIL_NUM", this.f31252i).apply();
        }
        C13850f.m83120a(new StringBuilder("continuous upload failed num:"), this.f31252i, "Config");
    }

    /* renamed from: t */
    public final void m38314t() {
        if (this.f31252i == 0) {
            return;
        }
        this.f31252i = 0;
        this.f31258o.putInt("CONTINUOUS_UPLOAD_FAIL_NUM", 0).apply();
    }

    /* renamed from: u */
    public final String m38315u() {
        return this.f31244a.logServerKey;
    }

    /* renamed from: v */
    public final boolean m38316v() {
        int i10 = this.f31259p;
        return (i10 == 1 || i10 == 3 || this.f31250g >= this.f31244a.cellDailyLimit) ? false : true;
    }

    /* renamed from: y */
    public final boolean m38317y(Context context, Looper looper) {
        Configurations configurations = (Configurations) C12390b.m74456g().m74460d("crowdsourcing", Configurations.class);
        this.f31244a = configurations;
        if (configurations == null) {
            C1016d.m6183c("Config", "failed to get config");
            return false;
        }
        if (!configurations.valid()) {
            C1016d.m6183c("Config", "config not valid");
            return false;
        }
        C1016d.m6181a("Config", "configurations:" + this.f31244a.toString());
        this.f31245b = this.f31244a.uploadInterval * 1000;
        this.f31247d = this.f31244a.cacheSizeLimit * ARImageMetadata.SHADING_MODE;
        this.f31246c = this.f31244a.cellValidInterval * 1000000;
        this.f31248e = this.f31244a.wifiValidInterval * 1000;
        int i10 = this.f31244a.collectType;
        this.f31259p = i10 != 0 ? i10 == 1 ? 3 : i10 == 2 ? 4 : 1 : 2;
        long j10 = this.f31245b;
        if (j10 == 0) {
            this.f31253j = 0;
        } else {
            this.f31253j = (int) (Math.log(1.728E8d / j10) / Math.log(2.0d));
        }
        C13850f.m83120a(new StringBuilder("upload fail max num:"), this.f31253j, "Config");
        SharedPreferences sharedPreferences = context.createDeviceProtectedStorageContext().getSharedPreferences("crowdsourcing_config", 0);
        if (sharedPreferences == null) {
            C1016d.m6183c("Config", "create sharedPreferences failed");
            return false;
        }
        this.f31249f = sharedPreferences.getInt("WIFI_NUM", 0);
        this.f31250g = sharedPreferences.getInt("CELL_NUM", 0);
        this.f31251h = sharedPreferences.getLong("RESET_TIMESTAMP", 0L);
        this.f31254k = sharedPreferences.getLong("UPLOAD_TIMESTAMP", 0L);
        this.f31252i = sharedPreferences.getInt("CONTINUOUS_UPLOAD_FAIL_NUM", 0);
        this.f31256m = sharedPreferences.getBoolean("MCC_CHECK_RESULT", false);
        this.f31257n = sharedPreferences.getString("PATCH_POLICY", "");
        this.f31255l = sharedPreferences.getString("SERIAL_NUMBER", "");
        Locale locale = Locale.ENGLISH;
        C1016d.m6186f("Config", "wifiNum:" + this.f31249f + ", cellNum:" + this.f31250g + ", resetTimeStamp:" + this.f31251h + ", uploadTimeStamp:" + this.f31254k + ", uploadContinuousFailNum:" + this.f31252i);
        this.f31258o = sharedPreferences.edit();
        if (this.f31255l.isEmpty()) {
            this.f31255l = UUID.randomUUID().toString();
            C1016d.m6186f("Config", "create serial number:" + this.f31255l);
            this.f31258o.putString("SERIAL_NUMBER", this.f31255l);
        }
        this.f31258o.apply();
        new HandlerC6743a(looper).m38319a();
        return true;
    }

    /* renamed from: z */
    public final boolean m38318z(String str) {
        boolean z10;
        if (str.isEmpty()) {
            C1016d.m6181a("Config", "no mcc, use last mcc result:" + this.f31256m);
        } else {
            Iterator it = this.f31244a.excludeMccList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z10 = true;
                    break;
                }
                if (str.equals((String) it.next())) {
                    z10 = false;
                    break;
                }
            }
            if (this.f31256m != z10) {
                this.f31256m = z10;
                this.f31258o.putBoolean("MCC_CHECK_RESULT", z10);
                this.f31258o.apply();
            }
            C1016d.m6186f("Config", "got mcc, check result:" + this.f31256m);
        }
        return this.f31256m;
    }

    public /* synthetic */ Config(int i10) {
        this();
    }
}
