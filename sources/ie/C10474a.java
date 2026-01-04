package ie;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.sync.R$dimen;
import com.huawei.hms.network.p129ai.C5807k0;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.LinkedHashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Consumer;
import p015ak.C0209d;
import p020ap.C1010e;
import p292fn.C9733f;
import p514o9.C11828b;
import p514o9.C11839m;
import p514o9.C11842p;
import p684un.C13230i;
import p709vj.C13452e;
import p783xp.C13843a;

/* renamed from: ie.a */
/* loaded from: classes3.dex */
public class C10474a implements Consumer<b> {

    /* renamed from: a */
    public Context f50463a;

    /* renamed from: b */
    public Location f50464b;

    /* renamed from: c */
    public ImageView f50465c;

    /* renamed from: d */
    public Handler f50466d;

    /* renamed from: e */
    public b f50467e;

    /* renamed from: f */
    public b f50468f;

    /* renamed from: g */
    public int f50469g;

    /* renamed from: h */
    public int f50470h;

    /* renamed from: i */
    public Timer f50471i;

    /* renamed from: j */
    public long f50472j;

    /* renamed from: k */
    public boolean f50473k = false;

    /* renamed from: ie.a$a */
    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis() - C10474a.this.f50472j;
            C11839m.m70688i("DownloadMapSnapshot", "doDownLoadMapSnapshot timeOut. times: " + jCurrentTimeMillis);
            Bundle bundle = new Bundle();
            bundle.putString("operationType", "mapCardLoad");
            bundle.putString(C5807k0.f25949l, "defaultMapCard");
            bundle.putString("errorReason", "petal map download time out. downPetalTimes: " + jCurrentTimeMillis);
            C1010e.m6125b().m6129D(bundle);
            C10474a.this.f50473k = true;
            C10474a.this.f50471i = null;
        }
    }

    /* renamed from: ie.a$b */
    public static class b {

        /* renamed from: a */
        public String f50475a;

        /* renamed from: b */
        public boolean f50476b;

        /* renamed from: c */
        public boolean f50477c;

        public b(String str, boolean z10, boolean z11) {
            this.f50475a = str;
            this.f50476b = z10;
            this.f50477c = z11;
        }

        /* renamed from: a */
        public String m64370a() {
            return this.f50475a;
        }

        /* renamed from: b */
        public boolean m64371b() {
            return this.f50476b;
        }

        /* renamed from: c */
        public boolean m64372c() {
            return this.f50477c;
        }
    }

    public C10474a(Context context, Location location, ImageView imageView, Handler handler) {
        this.f50463a = context;
        this.f50464b = location;
        this.f50465c = imageView;
        this.f50466d = handler;
    }

    @Override // java.util.function.Consumer
    /* renamed from: a */
    public void accept(b bVar) {
        C11839m.m70688i("DownloadMapSnapshot", "handlerPetalMapResult");
        if (this.f50473k) {
            C11839m.m70687e("DownloadMapSnapshot", "handlerPetalMapResult petalMapTimeOut");
            return;
        }
        if (bVar.m64370a().contains("_offline.png")) {
            this.f50468f = bVar;
        } else if (bVar.m64370a().contains("_online.png")) {
            this.f50467e = bVar;
        }
        b bVar2 = this.f50468f;
        if (bVar2 == null || this.f50467e == null) {
            C11839m.m70689w("DownloadMapSnapshot", "handlerPetalMapResult offlineMapResult or onlineMapResult not ok");
            return;
        }
        if (bVar2.m64371b() && this.f50467e.m64371b()) {
            String strM64370a = this.f50467e.m64370a();
            Bitmap bitmapM64369g = m64369g(strM64370a);
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f50472j;
            C11839m.m70688i("DownloadMapSnapshot", "handlerPetalMapResult path: " + strM64370a + ", bitmap" + bitmapM64369g + ", downPetalTimes: " + jCurrentTimeMillis);
            if (!this.f50468f.m64372c() || !this.f50467e.m64372c() || bitmapM64369g == null) {
                C11839m.m70687e("DownloadMapSnapshot", "handlerPetalMapResult, petal map download fail.");
                Bundle bundle = new Bundle();
                bundle.putString("operationType", "mapCardLoad");
                bundle.putString(C5807k0.f25949l, "petalMapCard");
                bundle.putString("errorReason", "petal map download fail. downPetalTimes: " + jCurrentTimeMillis);
                C1010e.m6125b().m6129D(bundle);
            } else if (this.f50466d != null && this.f50465c != null) {
                C11839m.m70688i("DownloadMapSnapshot", "handlerPetalMapResult, petal map download success");
                this.f50466d.obtainMessage(5001, new C11828b.b(this.f50465c, null, bitmapM64369g)).sendToTarget();
                LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
                linkedHashMapM79497A.put("mapType", "petalMapCard");
                C13230i.m79504I().m79567R("mecloud_findmyphone_download_map", linkedHashMapM79497A);
                UBAAnalyze.m29947H("CKC", "mecloud_findmyphone_download_map", linkedHashMapM79497A);
                Bundle bundle2 = new Bundle();
                bundle2.putString("operationType", "mapCardLoad");
                bundle2.putString(C5807k0.f25949l, "petalMapCard");
                bundle2.putString("errorReason", "petal map download success. downPetalTimes: " + jCurrentTimeMillis);
                C1010e.m6125b().m6129D(bundle2);
            }
            if (this.f50471i != null) {
                C11839m.m70688i("DownloadMapSnapshot", "handlerPetalMapResult, downloadPetalMap cancel");
                this.f50471i.cancel();
                this.f50471i = null;
            }
        }
    }

    /* renamed from: e */
    public void m64367e() {
        C11839m.m70688i("DownloadMapSnapshot", "doDownLoadMapSnapshot");
        m64368f();
        this.f50472j = System.currentTimeMillis();
        if (this.f50464b == null || this.f50469g <= 0 || this.f50470h <= 0) {
            C11839m.m70687e("DownloadMapSnapshot", "doDownLoadMapSnapshot error");
            return;
        }
        String str = this.f50463a.getFilesDir() + "/mappic/" + (C13843a.m83067S() ? "zh" : FaqConstants.DEFAULT_ISO_LANGUAGE) + "_";
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p == null) {
            C11839m.m70687e("DownloadMapSnapshot", "hiCloudSysParamMap is null");
            return;
        }
        String padOnlineMarkerUrl = C11842p.m70762R0() ? hiCloudSysParamMapM60757p.getPadOnlineMarkerUrl() : hiCloudSysParamMapM60757p.getPhoneOnlineMarkerUrl();
        String padOfflineMarkerUrl = C11842p.m70762R0() ? hiCloudSysParamMapM60757p.getPadOfflineMarkerUrl() : hiCloudSysParamMapM60757p.getPhoneOfflineMarkerUrl();
        if (TextUtils.isEmpty(padOnlineMarkerUrl) || TextUtils.isEmpty(padOfflineMarkerUrl)) {
            C11839m.m70687e("DownloadMapSnapshot", "icon url is empty");
            return;
        }
        new C10475b(this.f50463a, this.f50464b, str + "_online.png", padOnlineMarkerUrl, this.f50465c, this.f50469g, this.f50470h, this).m64379g();
        new C10475b(this.f50463a, this.f50464b, str + "_offline.png", padOfflineMarkerUrl, this.f50465c, this.f50469g, this.f50470h, this).m64379g();
        if (this.f50471i == null) {
            this.f50471i = new Timer();
        }
        this.f50471i.schedule(new a(), 5000L);
    }

    /* renamed from: f */
    public final void m64368f() {
        C11839m.m70688i("DownloadMapSnapshot", "initMapSize");
        int iMax = Math.max(C11842p.m70746M(this.f50463a), C11842p.m70749N(this.f50463a)) - C11842p.m70840n(this.f50463a, 24);
        this.f50470h = C11842p.m70810f1(this.f50463a, r1.getResources().getDimensionPixelOffset(R$dimen.cloud_space_158_dp));
        int iM70810f1 = C11842p.m70810f1(this.f50463a, iMax);
        this.f50469g = iM70810f1;
        if (iM70810f1 > 1024) {
            this.f50470h = (this.f50470h * 1024) / iM70810f1;
            this.f50469g = 1024;
        }
    }

    /* renamed from: g */
    public final Bitmap m64369g(String str) {
        return C0209d.m1311u(str);
    }
}
