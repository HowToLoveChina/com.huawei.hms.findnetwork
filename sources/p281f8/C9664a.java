package p281f8;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import p009a8.C0070h;
import p031b7.C1120a;
import p031b7.C1136q;

/* renamed from: f8.a */
/* loaded from: classes2.dex */
public class C9664a {

    /* renamed from: a */
    public int f47835a = 100;

    /* renamed from: b */
    public int f47836b = 1;

    /* renamed from: c */
    public boolean f47837c = false;

    /* renamed from: d */
    public Context f47838d;

    /* renamed from: e */
    public C9674k f47839e;

    public C9664a(Context context, C9674k c9674k) {
        this.f47838d = context;
        this.f47839e = c9674k;
    }

    /* renamed from: a */
    public void m60340a(SafeIntent safeIntent) {
        int intExtra = safeIntent.getIntExtra(FaqConstants.FAQ_LEVEL, 100);
        this.f47835a = intExtra;
        C1136q.b.m7103u1(this.f47838d, intExtra);
        C1120a.m6675d("BatteryProcessor", "checkLevel battery level now:" + this.f47835a);
        if (this.f47835a < 10 && !this.f47839e.m60428r()) {
            this.f47839e.m60398D(true);
            C1136q.b.m7096s0(this.f47838d, true);
            C1136q.b.m7093r0(this.f47838d, true);
        }
        if (this.f47835a >= 10 && this.f47839e.m60428r()) {
            this.f47839e.m60398D(false);
        }
        if (this.f47835a >= 30 && C1136q.b.m7057f0(this.f47838d)) {
            C1120a.m6677i("BatteryProcessor", "resume upload and sync");
            C9665b.m60347d(2, 122);
            C1136q.b.m7096s0(this.f47838d, false);
        }
        if (this.f47835a >= 30 && C1136q.b.m7054e0(this.f47838d)) {
            C1120a.m6677i("BatteryProcessor", "resume download");
            C9665b.m60346c();
            C1136q.b.m7093r0(this.f47838d, false);
        }
        int i10 = this.f47836b;
        this.f47836b = safeIntent.getIntExtra("status", 1);
        int intExtra2 = safeIntent.getIntExtra("plugged", -1);
        C1120a.m6677i("BatteryProcessor", "chargePlug: " + intExtra2 + ", battery status change: oldBatteryStatus=" + i10 + ",newBatteryStatus=" + this.f47836b);
        C1136q.b.m7106v1(this.f47838d, this.f47836b);
        C1136q.b.m7109w1(this.f47838d, intExtra2);
        int i11 = this.f47836b;
        if (i10 != i11 && i11 == 2) {
            C0070h.m527v().m548U("power_control_exemption", "other_no_stop_report");
        }
        int i12 = this.f47836b;
        if (i10 == i12 || i12 == 1 || this.f47835a < 10) {
            return;
        }
        C1120a.m6677i("BatteryProcessor", "batteryStatus: " + this.f47836b);
        this.f47839e.m60427q(256, this.f47836b == 3);
        this.f47839e.m60395A(63);
    }

    /* renamed from: b */
    public final void m60341b(String str) {
        if ("android.intent.action.SCREEN_OFF".equals(str)) {
            this.f47837c = true;
        } else if ("android.intent.action.SCREEN_ON".equals(str)) {
            this.f47837c = false;
        }
        C1136q.b.m7115y1(this.f47838d, Boolean.valueOf(!this.f47837c));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("checkScreenState screen:");
        sb2.append(!this.f47837c);
        sb2.append(" battery level while screen now level:");
        sb2.append(this.f47835a);
        C1120a.m6677i("BatteryProcessor", sb2.toString());
    }

    /* renamed from: c */
    public void m60342c() {
        C1120a.m6677i("BatteryProcessor", "init");
        this.f47835a = 100;
        boolean z10 = true;
        this.f47836b = 1;
        try {
            Context context = this.f47838d;
            if (context == null) {
                C1120a.m6676e("BatteryProcessor", "init context is null");
                return;
            }
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterReceiver == null) {
                C1120a.m6676e("BatteryProcessor", "init intent is null");
                return;
            }
            int intExtra = intentRegisterReceiver.getIntExtra(FaqConstants.FAQ_LEVEL, 100);
            this.f47835a = intExtra;
            boolean z11 = intExtra < 10;
            if (z11) {
                this.f47839e.m60398D(true);
                C1136q.b.m7096s0(this.f47838d, true);
            } else {
                this.f47839e.m60427q(4, z11);
            }
            this.f47839e.m60427q(8, false);
            this.f47836b = intentRegisterReceiver.getIntExtra("status", 1);
            C1136q.b.m7103u1(this.f47838d, this.f47835a);
            C1136q.b.m7106v1(this.f47838d, this.f47836b);
            C1136q.b.m7115y1(this.f47838d, Boolean.valueOf(!this.f47837c));
            int intExtra2 = intentRegisterReceiver.getIntExtra("plugged", -1);
            C1136q.b.m7109w1(this.f47838d, intExtra2);
            C1120a.m6677i("BatteryProcessor", "init batteryStatus: " + this.f47836b + ", chargePlug: " + intExtra2);
            C9674k c9674k = this.f47839e;
            if (this.f47836b != 3) {
                z10 = false;
            }
            c9674k.m60427q(256, z10);
        } catch (Exception e10) {
            C1120a.m6677i("BatteryProcessor", "init battery exception : " + e10);
        }
    }

    /* renamed from: d */
    public void m60343d(Context context, Intent intent, String str) {
        if ("android.intent.action.BATTERY_CHANGED".equals(str)) {
            m60340a(new SafeIntent(intent));
        } else {
            m60341b(str);
        }
    }
}
