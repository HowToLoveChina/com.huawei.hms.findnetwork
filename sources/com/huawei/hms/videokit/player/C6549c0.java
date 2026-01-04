package com.huawei.hms.videokit.player;

import android.content.Context;
import android.os.Build;
import com.huawei.appmarket.service.externalservice.distribution.download.request.StartDownloadV2IPCRequest;
import com.huawei.hms.common.util.AGCUtils;
import com.huawei.openalliance.p169ad.p171db.bean.UserCloseRecord;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;

/* renamed from: com.huawei.hms.videokit.player.c0 */
/* loaded from: classes8.dex */
public final class C6549c0 {
    /* renamed from: a */
    public static C6592p m37249a(Context context) {
        C6592p c6592p = new C6592p();
        c6592p.m37591a(UserCloseRecord.TIME_STAMP, C6600t0.m37678b());
        c6592p.m37591a("appPackageName", C6600t0.m37679b(context));
        c6592p.m37591a("appVersion", C6600t0.m37682c(context));
        c6592p.m37591a("devAppId", AGCUtils.getAppId(context));
        c6592p.m37591a("packageName", "com.huawei.hms.videokit.player");
        c6592p.m37591a("kitAPKVersion", C6580j.m37436a());
        c6592p.m37591a("kitSDKVersion", C6580j.m37449e());
        c6592p.m37591a("emuiVerison", C6600t0.m37687e());
        c6592p.m37591a("androidVersion", C6600t0.m37671a());
        c6592p.m37591a(FaqConstants.FAQ_MODEL, Build.MODEL);
        c6592p.m37591a("deviceId", C6580j.m37442b());
        c6592p.m37590a(StartDownloadV2IPCRequest.KEY_DEVICE_ID_TYPE, C6580j.m37445c());
        c6592p.m37591a("service", "VideoKit");
        c6592p.m37591a("isFullSdk", C6581j0.m37456b());
        return c6592p;
    }
}
