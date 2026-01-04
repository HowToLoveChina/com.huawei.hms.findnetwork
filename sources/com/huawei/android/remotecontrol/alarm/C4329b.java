package com.huawei.android.remotecontrol.alarm;

import android.content.Context;
import com.huawei.android.remotecontrol.alarm.AlarmObject;
import com.huawei.android.remotecontrol.alarm.C4329b;
import com.huawei.android.remotecontrol.controller.cmd.PushCmdParser;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.findnetwork.FindNetwork;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.util.function.Consumer;
import p015ak.C0225l;
import p677ue.C13168a;
import p738we.InterfaceC13594a;
import p809yg.C13981a;
import p851zp.InterfaceC14356c;
import se.C12782d;
import se.C12786h;
import ye.C13978y;

/* renamed from: com.huawei.android.remotecontrol.alarm.b */
/* loaded from: classes4.dex */
public class C4329b extends AlarmObject implements InterfaceC13594a {
    public C4329b(PushCmdParser pushCmdParser, Context context) {
        super(pushCmdParser, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0 */
    public /* synthetic */ Task m26032v0() throws Exception {
        return FindNetwork.getFindNetworkEngine(this.f5580a).stopSound(this.f19721l, true, new AlarmObject.C4322a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0 */
    public static /* synthetic */ void m26033w0(Exception exc) {
        C13981a.m83988e("AncillaryDeviceAlarmCancel", "operateFinderTagDevice :" + exc.getMessage());
    }

    /* renamed from: x0 */
    private void m26034x0(String str, String str2) {
        if (!"0".equals(str) && !"0".equals(str2)) {
            C13981a.m83989i("AncillaryDeviceAlarmCancel", "ancillary cancel alarm fail");
            mo25999q0(1, "0".equals(this.f19722m) ? this.f19722m : m25989g0("1", str, str2), "cancelPerDevicebell", 3079);
            return;
        }
        C13981a.m83989i("AncillaryDeviceAlarmCancel", "ancillary cancel alarm success");
        if ("0".equals(str) && "0".equals(str2)) {
            this.f19726q = true;
        }
        mo25999q0(0, "0".equals(this.f19722m) ? this.f19722m : m25989g0("0", str, str2), "cancelPerDevicebell", 3078);
    }

    @Override // p738we.InterfaceC13594a
    /* renamed from: c */
    public boolean mo26024c() {
        C13981a.m83989i("AncillaryDeviceAlarmCancel", "operateFinderTagDevice : stopSound");
        C0225l.m1577a(new InterfaceC14356c() { // from class: se.k
            @Override // p851zp.InterfaceC14356c
            public final Object execute() {
                return this.f58461a.m26032v0();
            }
        }, new Consumer() { // from class: se.l
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C4329b.m26033w0((Exception) obj);
            }
        });
        return true;
    }

    @Override // p738we.InterfaceC13594a
    /* renamed from: f */
    public boolean mo26025f() {
        if (!m25995m0(3079)) {
            return false;
        }
        m25997o0();
        C12782d.m76705h(this.f19721l, "stopAlarm", this.f5581b.getTraceID());
        return true;
    }

    @Override // p738we.InterfaceC13594a
    /* renamed from: g */
    public boolean mo26026g() {
        m25997o0();
        C12782d.m76698a(this.f5580a, this.f19721l, this.f19722m);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0067  */
    @Override // com.huawei.android.remotecontrol.alarm.AlarmObject
    /* renamed from: i0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo25991i0(com.huawei.secure.android.common.intent.SafeIntent r6) {
        /*
            r5 = this;
            java.lang.String r0 = "deviceId"
            java.lang.String r0 = r6.getStringExtra(r0)
            java.lang.String r1 = "controlType"
            r2 = -1
            int r1 = r6.getIntExtra(r1, r2)
            java.lang.String r2 = "controlState"
            java.lang.String r6 = r6.getStringExtra(r2)
            r2 = 2
            java.lang.String r3 = "AncillaryDeviceAlarmCancel"
            if (r1 == r2) goto L1e
            java.lang.String r5 = "controlType not match"
            p809yg.C13981a.m83988e(r3, r5)
            return
        L1e:
            if (r0 == 0) goto Lc1
            java.lang.String r1 = r5.f19721l
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L2a
            goto Lc1
        L2a:
            r0 = 0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L3f
            r1.<init>(r6)     // Catch: org.json.JSONException -> L3f
            java.lang.String r6 = "0x00"
            java.lang.String r6 = r5.m7435t(r1, r6)     // Catch: org.json.JSONException -> L3f
            java.lang.String r2 = "0x01"
            java.lang.String r0 = r5.m7435t(r1, r2)     // Catch: org.json.JSONException -> L3d
            goto L59
        L3d:
            r1 = move-exception
            goto L41
        L3f:
            r1 = move-exception
            r6 = r0
        L41:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "handleControlResult: JSONException = "
            r2.append(r4)
            java.lang.String r1 = r1.toString()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            p809yg.C13981a.m83988e(r3, r1)
        L59:
            java.lang.String r1 = r5.f19722m
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L67
            java.lang.String r5 = "handleControlResult: cancel alarm mCptList is empty"
            p809yg.C13981a.m83988e(r3, r5)
            return
        L67:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "cancel alarm mCptList:"
            r1.append(r2)
            java.lang.String r2 = r5.f19722m
            r1.append(r2)
            java.lang.String r2 = ",left:"
            r1.append(r2)
            r1.append(r6)
            java.lang.String r2 = ",right:"
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            p809yg.C13981a.m83989i(r3, r1)
            java.lang.String r6 = r5.m26000r0(r6)
            java.lang.String r0 = r5.m26000r0(r0)
            java.lang.String r1 = r5.f19722m
            java.lang.String r2 = ","
            java.lang.String[] r1 = r1.split(r2)
            boolean r2 = se.C12786h.m76747b(r1)
            if (r2 == 0) goto La7
            r5.m26034x0(r6, r0)
            goto Lc0
        La7:
            boolean r2 = se.C12786h.m76748c(r1)
            if (r2 == 0) goto Lb1
            r5.m26035y0(r6)
            goto Lc0
        Lb1:
            boolean r6 = se.C12786h.m76749d(r1)
            if (r6 == 0) goto Lbb
            r5.m26035y0(r0)
            goto Lc0
        Lbb:
            java.lang.String r5 = "don't know which one"
            p809yg.C13981a.m83988e(r3, r5)
        Lc0:
            return
        Lc1:
            java.lang.String r5 = "deviceId not match"
            p809yg.C13981a.m83988e(r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.remotecontrol.alarm.C4329b.mo25991i0(com.huawei.secure.android.common.intent.SafeIntent):void");
    }

    @Override // com.huawei.android.remotecontrol.alarm.AlarmObject
    /* renamed from: j0 */
    public void mo25992j0(int i10) {
        C13981a.m83989i("AncillaryDeviceAlarmCancel", "tag stop alarm finish respCode:" + i10);
    }

    @Override // com.huawei.android.remotecontrol.alarm.AlarmObject
    /* renamed from: k0 */
    public void mo25993k0(boolean z10, int i10) {
        C13981a.m83989i("AncillaryDeviceAlarmCancel", "tag stop alarm result:" + z10);
        this.f19726q = true;
        int i11 = z10 ? 3078 : 3079;
        if (z10) {
            i10 = 0;
        }
        mo25999q0(i10, this.f19722m, "cancelPerDevicebell", i11);
    }

    @Override // com.huawei.android.remotecontrol.alarm.AlarmObject
    /* renamed from: l0 */
    public void mo25994l0(SafeIntent safeIntent) {
        boolean booleanExtra = safeIntent.getBooleanExtra("controlResult", false);
        int intExtra = safeIntent.getIntExtra(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, 1);
        C13981a.m83989i("AncillaryDeviceAlarmCancel", "do report, stop alarm result:" + booleanExtra);
        this.f19726q = true;
        mo25999q0(booleanExtra ? 0 : intExtra, this.f19722m, this.f5581b.getOperation(), booleanExtra ? 3078 : 3079);
        C13978y.m83903T().m83940B0(this.f19721l + "alarm");
        C13978y.m83903T().m83940B0(this.f19721l + "stopAlarm");
    }

    @Override // com.huawei.android.remotecontrol.alarm.AlarmObject
    /* renamed from: n0 */
    public void mo25996n0() {
        C13981a.m83989i("AncillaryDeviceAlarmCancel", "cancel ancillary alarm timeout");
        mo25999q0(1, "-1", "cancelPerDevicebell", 3079);
    }

    @Override // com.huawei.android.remotecontrol.alarm.AlarmObject
    /* renamed from: q0 */
    public void mo25999q0(int i10, String str, String str2, int i11) {
        super.mo25999q0(i10, str, str2, i11);
        if (this.f19726q) {
            m26036z0();
        }
    }

    /* renamed from: y0 */
    public final void m26035y0(String str) {
        int i10;
        int i11 = 1;
        if ("0".equals(str)) {
            C13981a.m83989i("AncillaryDeviceAlarmCancel", "ancillary cancel alarm single success");
            this.f19726q = true;
            i11 = 0;
            i10 = 3078;
        } else {
            C13981a.m83989i("AncillaryDeviceAlarmCancel", "ancillary cancel alarm single fail");
            i10 = 3079;
        }
        mo25999q0(i11, this.f19722m, "cancelPerDevicebell", i10);
    }

    @Override // bf.AbstractC1177c
    /* renamed from: z */
    public void mo7440z() {
        if (!mo7422J()) {
            mo25999q0(9, this.f19722m, "cancelPerDevicebell", 3079);
            return;
        }
        if (!C13168a.m79182k()) {
            C13981a.m83990w("AncillaryDeviceAlarmCancel", "bluetooth is closed");
            mo25999q0(11, this.f19722m, this.f5581b.getOperation(), 3078);
        } else {
            C12786h.m76751f(this.f19721l, true);
            if (m81752h(this.f19723n)) {
                m25998p0();
            }
        }
    }

    /* renamed from: z0 */
    public void m26036z0() {
        C13981a.m83989i("AncillaryDeviceAlarmCancel", "stop cancel alarm Task");
        m26001s0();
        m25988f0();
    }
}
