package com.huawei.hms.videokit.player;

import android.content.Context;
import android.os.Build;
import com.huawei.appmarket.service.externalservice.distribution.download.request.StartDownloadV2IPCRequest;
import com.huawei.hms.common.util.AGCUtils;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.openalliance.p169ad.p171db.bean.UserCloseRecord;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;

/* renamed from: com.huawei.hms.videokit.player.b0 */
/* loaded from: classes8.dex */
public class C6544b0 {

    /* renamed from: a */
    private Context f30311a;

    public C6544b0(Context context) {
        this.f30311a = context;
    }

    /* renamed from: a */
    private String m37212a() {
        return C6600t0.m37671a();
    }

    /* renamed from: b */
    private String m37213b() {
        return C6600t0.m37679b(this.f30311a);
    }

    /* renamed from: c */
    private String m37214c() {
        return C6600t0.m37682c(this.f30311a);
    }

    /* renamed from: d */
    private String m37215d() {
        return String.valueOf(C6600t0.m37687e());
    }

    /* renamed from: e */
    private String m37216e() {
        return Build.MODEL;
    }

    /* renamed from: f */
    private String m37217f() {
        return C6589n0.m37567c(this.f30311a);
    }

    /* renamed from: a */
    public void m37218a(C6592p c6592p) {
        c6592p.m37591a("appVersion", m37214c());
        c6592p.m37591a("packageName", "com.huawei.hms.videokit.player");
        c6592p.m37591a(UserCloseRecord.TIME_STAMP, C6600t0.m37678b());
        c6592p.m37591a("appPackageName", m37213b());
        c6592p.m37591a("kitAPKVersion", C6580j.m37436a());
        c6592p.m37591a("kitSDKVersion", C6580j.m37449e());
        c6592p.m37591a("androidVersion", m37212a());
        c6592p.m37591a(FaqConstants.FAQ_MODEL, m37216e());
        c6592p.m37591a("emuiVerison", m37215d());
        c6592p.m37591a("devAppId", AGCUtils.getAppId(this.f30311a));
        c6592p.m37591a("deviceId", C6580j.m37442b());
        c6592p.m37590a(StartDownloadV2IPCRequest.KEY_DEVICE_ID_TYPE, C6580j.m37445c());
        c6592p.m37591a("service", "VideoKit");
        c6592p.m37591a("isFullSdk", C6581j0.m37456b());
    }

    /* renamed from: b */
    public void m37219b(C6592p c6592p) {
        c6592p.m37591a("version", C6580j.m37449e());
        c6592p.m37591a("service", "VideoKit");
        c6592p.m37591a("package", m37213b());
        c6592p.m37590a("statusCode", 0L);
        c6592p.m37591a("networkType", m37217f());
        c6592p.m37591a(FaqConstants.FAQ_MODEL, m37216e());
        c6592p.m37591a(WiseOpenHianalyticsData.UNION_APP_VERSION, m37214c());
        c6592p.m37591a("uuid", C6598s0.m37646c(this.f30311a));
        c6592p.m37591a("isFullSdk", C6581j0.m37456b());
    }
}
