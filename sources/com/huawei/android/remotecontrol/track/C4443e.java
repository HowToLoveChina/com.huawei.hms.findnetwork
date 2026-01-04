package com.huawei.android.remotecontrol.track;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import p015ak.C0224k0;
import p774xg.C13811a;
import p809yg.C13981a;
import tg.C13011a;

/* renamed from: com.huawei.android.remotecontrol.track.e */
/* loaded from: classes4.dex */
public class C4443e {

    /* renamed from: a */
    public static boolean f20386a = C13011a.m78314a();

    /* renamed from: b */
    public static volatile ContentObserver f20387b = null;

    /* renamed from: com.huawei.android.remotecontrol.track.e$a */
    public class a extends ContentObserver {

        /* renamed from: a */
        public final /* synthetic */ Context f20388a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Handler handler, Context context) {
            super(handler);
            this.f20388a = context;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            C13981a.m83989i("LocateTrackSubManager", "onChange");
            String string = Settings.Secure.getString(this.f20388a.getContentResolver(), "super_power_save_notification_whitelist");
            C13981a.m83989i("LocateTrackSubManager", "onChange, apps:" + string);
            if (string == null || !string.contains("com.huawei.hidisk")) {
                C4443e.m26982f(this.f20388a);
            }
        }
    }

    /* renamed from: b */
    public static void m26978b(Context context, LocateTrackEvent locateTrackEvent, String str) {
        C4441c.m26949o(context).m26951B(str);
        C4441c.m26949o(context).m26957h(locateTrackEvent);
    }

    /* renamed from: c */
    public static void m26979c(Context context, String str) {
        if (f20386a) {
            LocateTrackEventManager.m26909a().m26911c(context.getApplicationContext(), str);
        } else {
            C13981a.m83988e("LocateTrackSubManager", "obtainTrackConfig is not support track");
        }
    }

    /* renamed from: d */
    public static void m26980d(Context context) {
        if (f20386a) {
            LocateTrackEventManager.m26909a().m26910b(context);
            f20387b = new a(new Handler(), context);
        }
    }

    /* renamed from: e */
    public static void m26981e(Context context) {
        LocateTrackEventManager.m26909a().m26914f(context, true);
        LocateTrackEventManager.m26909a().m26912d(context, true);
    }

    /* renamed from: f */
    public static boolean m26982f(Context context) {
        if (context == null) {
            C13981a.m83988e("LocateTrackSubManager", "setHidiskToWhiteList context is null");
            return false;
        }
        String string = Settings.Secure.getString(context.getContentResolver(), "super_power_save_notification_whitelist");
        String str = "com.huawei.hidisk";
        if (string != null && string.contains("com.huawei.hidisk")) {
            return false;
        }
        if (!TextUtils.isEmpty(string)) {
            str = string + ";com.huawei.hidisk";
        }
        boolean zPutString = Settings.Secure.putString(context.getContentResolver(), "super_power_save_notification_whitelist", str);
        C13981a.m83989i("LocateTrackSubManager", "setHidiskToWhiteList result:" + zPutString);
        return zPutString;
    }

    /* renamed from: g */
    public static void m26983g(Context context) {
        LocateTrackEventManager.m26909a().m26912d(context, false);
    }

    /* renamed from: h */
    public static void m26984h(Context context) {
        if (!f20386a) {
            C13981a.m83988e("LocateTrackSubManager", "startLowPowerMode is not support track");
            return;
        }
        String strM1572a = C0224k0.a.m1572a("ro.config.hw_extr_close_switch");
        C13981a.m83989i("LocateTrackSubManager", "lowPowerConfig:" + strM1572a);
        if (TextUtils.isEmpty(strM1572a) || !strM1572a.contains("data")) {
            LocateTrackEventManager.m26909a().m26913e(context);
        } else {
            C13981a.m83989i("LocateTrackSubManager", "disconnected mobile do not start lowPowerMode");
        }
    }

    /* renamed from: i */
    public static void m26985i(Context context) {
        C13981a.m83989i("LocateTrackSubManager", "stopCollectTrackData begin");
        if (C4450l.m27011g(context)) {
            m26986j(context);
            LocateTrackEventManager.m26909a().m26914f(context, false);
            C4450l.m27012h(context);
        }
        if (C4450l.m27011g(context)) {
            return;
        }
        C13811a.m82793K(context);
        C13811a.m82796N(context, true);
    }

    /* renamed from: j */
    public static void m26986j(Context context) {
        C4441c.m26949o(context).m26968t();
    }
}
