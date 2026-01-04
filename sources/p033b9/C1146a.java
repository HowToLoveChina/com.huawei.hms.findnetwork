package p033b9;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import p015ak.C0214f0;
import p514o9.C11839m;
import p684un.C13223b;
import p709vj.C13452e;

/* renamed from: b9.a */
/* loaded from: classes3.dex */
public class C1146a {
    /* renamed from: a */
    public static void m7209a(Context context, Intent intent) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "cloud_photo_cfg", 0);
        if (sharedPreferencesM1382b.getBoolean("photo_service_login", false)) {
            sharedPreferencesM1382b.edit().putBoolean("photo_stream_switch", true).commit();
            sharedPreferencesM1382b.edit().putBoolean("share_photo_switch", true).commit();
            sharedPreferencesM1382b.edit().putBoolean("net_3g_switch", true).commit();
            sharedPreferencesM1382b.edit().putBoolean("cloud_album_switch", true).commit();
            sharedPreferencesM1382b.edit().putBoolean("cloud_photoup_switch", true).commit();
            sharedPreferencesM1382b.edit().putBoolean("cloud_videoup_switch", true).commit();
            sharedPreferencesM1382b.edit().putBoolean("cloud_screenshot_switch", true).commit();
            C13223b.m79473a(context, "CLOUDBACKUP_OPEN_CLOUDPHOTO", "1");
            UBAAnalyze.m29943D("CKC", "CLOUDBACKUP_OPEN_CLOUDPHOTO");
            C13223b.m79473a(context, "CLOUDBACKUP_OPEN_CLOUDPHOTO_SHARE", "1");
            UBAAnalyze.m29943D("CKC", "CLOUDBACKUP_OPEN_CLOUDPHOTO_SHARE");
            C13223b.m79473a(context, "CLOUDBACKUP_OPEN_CLOUDALBUM", "1");
            UBAAnalyze.m29943D("CKC", "CLOUDBACKUP_OPEN_CLOUDALBUM");
            C13223b.m79473a(context, "CLOUDBACKUP_OPEN_PHOTOUPLOAD", "1");
            UBAAnalyze.m29943D("CKC", "CLOUDBACKUP_OPEN_PHOTOUPLOAD");
            C13223b.m79473a(context, "CLOUDBACKUP_OPEN_SCREENUPLOAD", "1");
            UBAAnalyze.m29943D("CKC", "CLOUDBACKUP_OPEN_SCREENUPLOAD");
            C13223b.m79473a(context, "CLOUDBACKUP_AUTOBACKUP_OPEN_VIDEO", "1");
            UBAAnalyze.m29943D("CKC", "CLOUDBACKUP_AUTOBACKUP_OPEN_VIDEO");
            sharedPreferencesM1382b.edit().putBoolean("photo_service_login", false).commit();
        }
        boolean z10 = sharedPreferencesM1382b.getBoolean("photoStream", false) ? sharedPreferencesM1382b.getBoolean("photo_stream_switch", true) : sharedPreferencesM1382b.getBoolean("photo_stream_switch", false);
        boolean z11 = sharedPreferencesM1382b.getBoolean("share_photo_switch", false);
        boolean z12 = sharedPreferencesM1382b.getBoolean("net_3g_switch", true);
        intent.putExtra("isPhotoStreamOn", z10);
        intent.putExtra("isSharePhotoOn", z11);
        intent.putExtra("is3GAllowOn", !z12);
        C11839m.m70686d("BroadSender", "photoSteamSwitchValue:" + z10);
        C11839m.m70686d("BroadSender", "sharePhotoSwitchValue:" + z11);
        C11839m.m70686d("BroadSender", "net3GSwitchValue:" + z12);
    }

    /* renamed from: b */
    public static void m7210b(Context context) {
        C11839m.m70688i("BroadSender", "sendLoginBroadcast");
        if (context == null) {
            C11839m.m70688i("BroadSender", "sendLoginBroadcast context is null");
            return;
        }
        Intent intent = new Intent("com.huawei.hicloud.intent.action.HICLOUD_LOGON_ACTION");
        intent.putExtra(HwPayConstant.KEY_SITE_ID, String.valueOf(C13452e.m80781L().m80947n0()));
        intent.putExtra("deviceID", C13452e.m80781L().m80950o());
        intent.putExtra(JsbMapKeyNames.H5_DEVICE_TYPE, C13452e.m80781L().m80966s());
        intent.putExtra("serviceToken", C13452e.m80781L().m80931j0());
        intent.putExtra("accountName", C13452e.m80781L().m80900d());
        intent.putExtra(HwPayConstant.KEY_USER_ID, C13452e.m80781L().m80971t0());
        m7209a(context, intent);
        context.sendBroadcast(intent, "com.huawei.hicloud.permission.hicloudLogin");
    }
}
