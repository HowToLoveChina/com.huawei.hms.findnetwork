package com.huawei.android.remotecontrol.alarm;

import android.content.Context;
import com.huawei.android.remotecontrol.alarm.AlarmObject;
import com.huawei.android.remotecontrol.alarm.C4328a;
import com.huawei.android.remotecontrol.controller.cmd.PushCmdParser;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.findnetwork.FindNetwork;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Consumer;
import p015ak.C0225l;
import p227dg.C9120m0;
import p677ue.C13168a;
import p738we.InterfaceC13594a;
import p809yg.C13981a;
import p851zp.InterfaceC14356c;
import se.C12782d;
import se.C12786h;
import ye.C13978y;

/* renamed from: com.huawei.android.remotecontrol.alarm.a */
/* loaded from: classes4.dex */
public class C4328a extends AlarmObject implements InterfaceC13594a {

    /* renamed from: r */
    public boolean f19742r;

    /* renamed from: s */
    public String f19743s;

    /* renamed from: t */
    public Timer f19744t;

    /* renamed from: u */
    public boolean f19745u;

    /* renamed from: v */
    public String f19746v;

    /* renamed from: com.huawei.android.remotecontrol.alarm.a$a */
    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (C4328a.this.f19742r) {
                return;
            }
            C13981a.m83989i("AncillaryDeviceAlarm", "ancillary alarm stop timeout");
            C12786h.m76750e(C4328a.this.f19721l);
            C4328a.this.mo25999q0(300, "-1", "perDeviceStopbell", 3079);
        }
    }

    public C4328a(PushCmdParser pushCmdParser, Context context) {
        super(pushCmdParser, context);
        this.f19742r = false;
        this.f19743s = "-1";
        this.f19745u = false;
        this.f19746v = "";
        this.f19746v = this.f5581b.getCmdParamValue("perDeviceId");
    }

    /* renamed from: z0 */
    public static /* synthetic */ void m26018z0(Exception exc) {
        C13981a.m83988e("AncillaryDeviceAlarm", "operateFinderTagDevice :" + exc.getMessage());
    }

    /* renamed from: A0 */
    public final void m26019A0() {
        if (this.f19744t == null) {
            this.f19744t = new Timer();
        }
        C13981a.m83989i("AncillaryDeviceAlarm", "register stop bell timer");
        this.f19744t.schedule(new a(), 120000L);
    }

    /* renamed from: B0 */
    public final void m26020B0(String str, String str2) {
        C13981a.m83989i("AncillaryDeviceAlarm", "reportControlDoubleResult, leftState: " + str + ", rightState: " + str2);
        if ("1".equals(str) || "1".equals(str2)) {
            C13981a.m83989i("AncillaryDeviceAlarm", "ancillary alarm success");
            this.f19726q = true;
            mo25999q0(0, "0".equals(this.f19722m) ? this.f19722m : m25989g0("1", str, str2), "perDevicebell", 3076);
        } else {
            if (this.f19726q) {
                return;
            }
            this.f19743s = "-1";
            C13981a.m83990w("AncillaryDeviceAlarm", "ancillary alarm fail, cacheCptlist:" + this.f19743s);
        }
    }

    /* renamed from: C0 */
    public final void m26021C0(boolean z10, String str, String str2) {
        C13981a.m83989i("AncillaryDeviceAlarm", "reportControlSingleResult, isControlLeft" + z10 + " , firstState: " + str + ", secondState: " + str2);
        if ("1".equals(str) && "0".equals(str2)) {
            C13981a.m83989i("AncillaryDeviceAlarm", "ancillary alarm left success");
            this.f19726q = true;
            mo25999q0(0, this.f19722m, "perDevicebell", 3076);
        } else {
            if (this.f19726q) {
                return;
            }
            if (z10) {
                this.f19743s = m26028x0(str, str2);
            } else {
                this.f19743s = m26028x0(str2, str);
            }
            C13981a.m83990w("AncillaryDeviceAlarm", "ancillary alarm fail, cacheCptlist:" + this.f19743s);
        }
    }

    /* renamed from: D0 */
    public void m26022D0(boolean z10) {
        this.f19745u = z10;
    }

    /* renamed from: E0 */
    public void m26023E0() {
        m26001s0();
        m25988f0();
        m26027w0();
    }

    @Override // p738we.InterfaceC13594a
    /* renamed from: c */
    public boolean mo26024c() {
        C13981a.m83989i("AncillaryDeviceAlarm", "operateFinderTagDevice : startSound");
        C0225l.m1577a(new InterfaceC14356c() { // from class: se.i
            @Override // p851zp.InterfaceC14356c
            public final Object execute() {
                return this.f58460a.m26029y0();
            }
        }, new Consumer() { // from class: se.j
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C4328a.m26018z0((Exception) obj);
            }
        });
        return true;
    }

    @Override // p738we.InterfaceC13594a
    /* renamed from: f */
    public boolean mo26025f() {
        if (!m25995m0(3077)) {
            return false;
        }
        m25997o0();
        C12782d.m76705h(this.f19721l, "alarm", this.f5581b.getTraceID());
        return true;
    }

    @Override // p738we.InterfaceC13594a
    /* renamed from: g */
    public boolean mo26026g() {
        C13981a.m83989i("AncillaryDeviceAlarm", "operateBluetoothDevice, perDeviceId: " + C9120m0.m57351R(this.f19746v));
        m25997o0();
        C12782d.m76704g(this.f5580a, this.f19721l, this.f19722m);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006b  */
    @Override // com.huawei.android.remotecontrol.alarm.AlarmObject
    /* renamed from: i0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo25991i0(com.huawei.secure.android.common.intent.SafeIntent r7) {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "handleBluetoothControlResult, perDeviceId: "
            r0.append(r1)
            java.lang.String r1 = r6.f19746v
            java.lang.String r1 = p227dg.C9120m0.m57351R(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "AncillaryDeviceAlarm"
            p809yg.C13981a.m83989i(r1, r0)
            java.lang.String r0 = "deviceId"
            java.lang.String r0 = r7.getStringExtra(r0)
            java.lang.String r2 = "controlType"
            r3 = -1
            int r2 = r7.getIntExtra(r2, r3)
            java.lang.String r3 = "controlState"
            java.lang.String r7 = r7.getStringExtra(r3)
            if (r0 == 0) goto Le8
            java.lang.String r3 = r6.f19721l
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L3b
            goto Le8
        L3b:
            r0 = 2
            if (r2 == r0) goto L44
            java.lang.String r6 = "controlType not match"
            p809yg.C13981a.m83988e(r1, r6)
            return
        L44:
            r0 = 0
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: org.json.JSONException -> L57
            r2.<init>(r7)     // Catch: org.json.JSONException -> L57
            java.lang.String r7 = "0x00"
            java.lang.String r7 = r6.m7435t(r2, r7)     // Catch: org.json.JSONException -> L57
            java.lang.String r3 = "0x01"
            java.lang.String r0 = r6.m7435t(r2, r3)     // Catch: org.json.JSONException -> L58
            goto L5d
        L57:
            r7 = r0
        L58:
            java.lang.String r2 = "generate jsonObject error"
            p809yg.C13981a.m83989i(r1, r2)
        L5d:
            java.lang.String r2 = r6.f19722m
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L6b
            java.lang.String r6 = "handleControlResult: alarm mCptList is empty"
            p809yg.C13981a.m83988e(r1, r6)
            return
        L6b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "alarm mCptList:"
            r2.append(r3)
            java.lang.String r3 = r6.f19722m
            r2.append(r3)
            java.lang.String r3 = ",left:"
            r2.append(r3)
            r2.append(r7)
            java.lang.String r3 = ",right:"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            p809yg.C13981a.m83989i(r1, r2)
            java.lang.String r7 = r6.m26000r0(r7)
            java.lang.String r0 = r6.m26000r0(r0)
            java.lang.String r2 = r6.f19722m
            java.lang.String r3 = ","
            java.lang.String[] r2 = r2.split(r3)
            boolean r3 = se.C12786h.m76747b(r2)
            r4 = 0
            r5 = 1
            if (r3 == 0) goto Lad
            r6.m26020B0(r7, r0)
            goto Lc0
        Lad:
            boolean r3 = se.C12786h.m76748c(r2)
            if (r3 == 0) goto Lb7
            r6.m26021C0(r5, r7, r0)
            goto Lc0
        Lb7:
            boolean r2 = se.C12786h.m76749d(r2)
            if (r2 == 0) goto Lc0
            r6.m26021C0(r4, r0, r7)
        Lc0:
            java.lang.String r2 = "0"
            boolean r7 = r2.equals(r7)
            if (r7 == 0) goto Le7
            boolean r7 = r2.equals(r0)
            if (r7 == 0) goto Le7
            boolean r7 = r6.f19726q
            if (r7 == 0) goto Le7
            java.lang.String r7 = "ancillary alarm stop"
            p809yg.C13981a.m83989i(r1, r7)
            r6.f19742r = r5
            java.lang.String r7 = r6.f19721l
            se.C12786h.m76750e(r7)
            java.lang.String r7 = r6.f19722m
            java.lang.String r0 = "perDeviceStopbell"
            r1 = 3078(0xc06, float:4.313E-42)
            r6.mo25999q0(r4, r7, r0, r1)
        Le7:
            return
        Le8:
            java.lang.String r6 = "deviceId not match"
            p809yg.C13981a.m83988e(r1, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.remotecontrol.alarm.C4328a.mo25991i0(com.huawei.secure.android.common.intent.SafeIntent):void");
    }

    @Override // com.huawei.android.remotecontrol.alarm.AlarmObject
    /* renamed from: j0 */
    public void mo25992j0(int i10) {
        C13981a.m83989i("AncillaryDeviceAlarm", "tag alarm finish respCode:" + i10);
        if (this.f19745u) {
            return;
        }
        mo25999q0(0, this.f19722m, "perDeviceStopbell", 3078);
        C12786h.m76750e(this.f19721l);
    }

    @Override // com.huawei.android.remotecontrol.alarm.AlarmObject
    /* renamed from: k0 */
    public void mo25993k0(boolean z10, int i10) {
        C13981a.m83989i("AncillaryDeviceAlarm", "tag alarm result:" + z10 + " respCode:" + i10);
        if (!this.f19726q || z10) {
            if (i10 != 907201165) {
                this.f19726q = true;
            }
            int i11 = z10 ? 3076 : 3077;
            if (z10) {
                i10 = 0;
            }
            mo25999q0(i10, this.f19722m, "perDevicebell", i11);
            if (z10) {
                return;
            }
            C12786h.m76750e(this.f19721l);
        }
    }

    @Override // com.huawei.android.remotecontrol.alarm.AlarmObject
    /* renamed from: l0 */
    public void mo25994l0(SafeIntent safeIntent) {
        boolean booleanExtra = safeIntent.getBooleanExtra("controlResult", false);
        int intExtra = safeIntent.getIntExtra(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, 1);
        C13981a.m83989i("AncillaryDeviceAlarm", "do report, alarm result:" + booleanExtra);
        if (this.f19726q) {
            mo25999q0(!booleanExtra ? 1 : 0, this.f19722m, "perDeviceStopbell", booleanExtra ? 3078 : 3079);
            if (booleanExtra) {
                C12786h.m76750e(this.f19721l);
                C13978y.m83903T().m83940B0(this.f19721l + "alarm");
                return;
            }
            return;
        }
        this.f19726q = booleanExtra;
        mo25999q0(booleanExtra ? 0 : intExtra, this.f19722m, "perDevicebell", booleanExtra ? 3076 : 3077);
        if (booleanExtra) {
            return;
        }
        C12786h.m76750e(this.f19721l);
        C13978y.m83903T().m83940B0(this.f19721l + "alarm");
    }

    @Override // com.huawei.android.remotecontrol.alarm.AlarmObject
    /* renamed from: n0 */
    public void mo25996n0() {
        C13981a.m83989i("AncillaryDeviceAlarm", "ancillary alarm timeout");
        C12786h.m76750e(this.f19721l);
        mo25999q0(1, this.f19743s, this.f5581b.getOperation(), 3077);
    }

    @Override // com.huawei.android.remotecontrol.alarm.AlarmObject
    /* renamed from: q0 */
    public void mo25999q0(int i10, String str, String str2, int i11) {
        super.mo25999q0(i10, str, str2, i11);
        if (this.f19726q) {
            m25988f0();
        }
        if (!this.f19726q || "perDeviceStopbell".equals(str2) || C13168a.m79183l(this.f19723n)) {
            return;
        }
        m26019A0();
    }

    /* renamed from: w0 */
    public final void m26027w0() {
        C13981a.m83989i("AncillaryDeviceAlarm", "cancel stop bell timer");
        Timer timer = this.f19744t;
        if (timer != null) {
            timer.cancel();
            this.f19744t = null;
        }
    }

    /* renamed from: x0 */
    public final String m26028x0(String str, String str2) {
        return ("0".equals(str) && "0".equals(str2)) ? "-1" : m25989g0("1", str, str2);
    }

    /* renamed from: y0 */
    public final /* synthetic */ Task m26029y0() throws Exception {
        return FindNetwork.getFindNetworkEngine(this.f5580a).startSound(this.f19721l, true, new AlarmObject.C4322a());
    }

    @Override // bf.AbstractC1177c
    /* renamed from: z */
    public void mo7440z() {
        if (!mo7422J()) {
            mo25999q0(9, this.f19722m, "perDevicebell", 3077);
            return;
        }
        if (!C13168a.m79182k()) {
            C13981a.m83990w("AncillaryDeviceAlarm", "bluetooth is closed");
            mo25999q0(11, this.f19722m, this.f5581b.getOperation(), 3076);
            return;
        }
        C12786h.m76750e(this.f19721l);
        C12786h.m76746a(this);
        if (m81752h(this.f19723n)) {
            m25998p0();
        }
    }
}
