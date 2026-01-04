package p366if;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import bf.C1175a;
import com.huawei.android.remotecontrol.controller.cmd.PushCmdParser;
import com.huawei.android.remotecontrol.notification.PhoneFinderNotificationMgr;
import com.huawei.android.remotecontrol.sdk.R$drawable;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.android.remotecontrol.sharing.p091ui.ShareManagerActivity;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0216g0;
import p015ak.C0238w;
import p015ak.C0241z;
import p366if.AbstractC10482g;
import p394jf.C10813a;
import p664u0.C13108a;
import p774xg.C13811a;
import p809yg.C13981a;
import ug.C13172b;

/* renamed from: if.s */
/* loaded from: classes4.dex */
public class C10494s extends AbstractC10482g implements InterfaceC10483h {

    /* renamed from: L */
    public String f50660L;

    public C10494s(PushCmdParser pushCmdParser, Context context) {
        super(pushCmdParser, context);
        this.f50660L = "ShareLocate";
        String strM64466k0 = m64466k0("ShareLocate");
        this.f50660L = strM64466k0;
        this.f50523I = new C10492q(this, this.f5580a, strM64466k0);
    }

    /* renamed from: N0 */
    private boolean m64575N0(Message message, int i10) throws JSONException {
        int iM1685c = C0241z.m1685c(message.getData().getString("result"));
        C13981a.m83989i(this.f50660L, "handleCapabilityReportCallback result:" + iM1685c);
        if (200 == iM1685c) {
            try {
                JSONObject jSONObject = new JSONObject(message.getData().getString("response_info"));
                if (jSONObject.has(MapKeyNames.RESULT_CODE)) {
                    int i11 = jSONObject.getInt(MapKeyNames.RESULT_CODE);
                    C13981a.m83989i(this.f50660L, "handleCapabilityReportCallback resultCode:= " + i11);
                    if (i11 == 0) {
                        m7427Q(this.f50660L, "0", -1, this.f5586g + "share locate handleCapabilityReportCallback success", null, this.f50531r, "capability_reported", false, null);
                        C13172b.m79213i(this.f5580a, i10);
                        m64469n0();
                        C10481f.m64440p(this.f5580a, this);
                    } else if (401 == i11) {
                        m64583T0(1);
                        m7426P(this.f50660L, "hisync.findmyphone_locate", 1, i11, "001_3004", i11, this.f5586g + "phoneFinder ShareLocate handleCapabilityReportCallback fail,resultCode:" + i11, this.f50531r, "capability_reported", true);
                        m64470p0();
                    } else {
                        m64583T0(1);
                        m7426P(this.f50660L, "hisync.findmyphone_locate", 1, i11, "001_3004", i11, this.f5586g + "phoneFinder ShareLocate handleCapabilityReportCallback fail,resultCode:" + i11, this.f50531r, "capability_reported", true);
                    }
                }
            } catch (JSONException unused) {
                C13981a.m83988e(this.f50660L, "handleClientCapabilityReport JSONException");
                m64583T0(1);
                m7426P(this.f50660L, "hisync.findmyphone_locate", 1, iM1685c, "001_1014", -1, this.f5586g + "handleClientCapabilityReport JSONException", this.f50531r, "capability_reported", true);
            }
        } else {
            m64583T0(1);
            m7426P(this.f50660L, "hisync.findmyphone_locate", 1, iM1685c, "001_3003", -1, this.f5586g + "phoneFinder ShareLocate handleCapabilityReportCallback fail,result:" + iM1685c, this.f50531r, "capability_reported", true);
        }
        return true;
    }

    /* renamed from: Q0 */
    private boolean m64576Q0() {
        if (this.f50534u) {
            long j10 = this.f50515A;
            if (j10 <= this.f50529p && j10 != -1) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: R0 */
    private void m64577R0() {
        if (this.f50532s.m64479a()) {
            return;
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("providerType", this.f50526m);
        linkedHashMap.put("satelliteCount", String.valueOf(this.f50527n));
        linkedHashMap.put("accuracy", String.valueOf(this.f50528o));
        linkedHashMap.put("source", "system");
        if (m64576Q0()) {
            m7427Q(this.f50660L, "0", -1, "ShareLocate success, uuid:" + C10487l.m64536b().m64547d(), null, this.f50531r, "pushShareLocate", true, linkedHashMap);
            return;
        }
        if (this.f50534u && this.f50539z > this.f50529p) {
            m7427Q(this.f50660L, "001_82", -1, "ShareLocate success but over one duration", null, this.f50531r, "pushShareLocate", true, linkedHashMap);
            return;
        }
        if (m64472s0()) {
            m7427Q(this.f50660L, "001_81", -1, "ShareLocate get location in one duration but report late", null, this.f50531r, "pushShareLocate", true, linkedHashMap);
            return;
        }
        if (!this.f50534u && this.f50535v) {
            m7427Q(this.f50660L, "001_84", -1, "ShareLocate get location over one duration and report late", null, this.f50531r, "pushShareLocate", true, linkedHashMap);
            return;
        }
        if (this.f50534u || this.f50535v) {
            m64578S0(linkedHashMap);
            return;
        }
        long j10 = this.f50537x;
        if (j10 == 0) {
            m7427Q(this.f50660L, "001_85", -1, "ShareLocate could not get cache location", null, this.f50531r, "pushShareLocate", true, linkedHashMap);
        } else if (j10 <= this.f50529p) {
            m7427Q(this.f50660L, "001_80", -1, "ShareLocate location overdue in one duration", null, this.f50531r, "pushShareLocate", true, linkedHashMap);
        } else {
            m7427Q(this.f50660L, "001_83", -1, "ShareLocate location overdue over one duration", null, this.f50531r, "pushShareLocate", true, linkedHashMap);
        }
    }

    /* renamed from: S0 */
    private void m64578S0(LinkedHashMap<String, String> linkedHashMap) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f50534u);
        sb2.append('|');
        sb2.append(this.f50535v);
        sb2.append('|');
        sb2.append(this.f50515A);
        sb2.append('|');
        sb2.append(this.f50539z);
        sb2.append('|');
        sb2.append(this.f50537x);
        m7427Q(this.f50660L, "001_1014", -1, "ShareLocate location result error: " + sb2.toString(), null, this.f50531r, "pushShareLocate", true, linkedHashMap);
    }

    @Override // p366if.AbstractC10482g
    /* renamed from: I0 */
    public void mo64403I0() {
        this.f50538y = System.currentTimeMillis();
        this.f50523I.mo64391g();
        m64473t0();
    }

    /* renamed from: L0 */
    public final void m64579L0(Context context) {
        C13981a.m83989i(this.f50660L, "createShareLocatedNotification");
        if (context == null) {
            C13981a.m83988e(this.f50660L, "context is null");
            return;
        }
        String strM64580M0 = m64580M0();
        if (C4633d0.m28404a(strM64580M0)) {
            C13981a.m83989i(this.f50660L, "sender info is empty, do not need show notification");
            return;
        }
        String string = context.getString(R$string.start_finder_phone_new);
        String string2 = context.getString(R$string.locate_share_tile);
        String string3 = context.getString(R$string.share_located_notification_message, strM64580M0);
        Intent intent = new Intent(context, (Class<?>) ShareManagerActivity.class);
        intent.setFlags(536870912);
        C0216g0.m1402e(context).m1408F(intent, "SOURCE_ID_SHARE_LOCATED_NOTIFY");
        PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(context, 0, intent, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        NotificationCompat.Builder builderM1667h = C0238w.m1663f().m1667h(context, string, 3, "location_sharing");
        Bundle bundle = new Bundle();
        bundle.putString("android.substName", string);
        bundle.putBoolean("hw_enable_small_icon", true);
        NotificationCompat.C0605b c0605b = new NotificationCompat.C0605b();
        c0605b.m3840i(string2).m3839h(string3);
        builderM1667h.m3824y(R$drawable.ic_findmyphone_new).m3811l(string2).m3810k(string3).m3821v(0).m3823x(true).m3825z(c0605b).m3817r("com.huawei.android.findphone").m3807h(true).m3809j(pendingIntentM1248e0).m3803c(bundle);
        new PhoneFinderNotificationMgr(context).m26378c(567, builderM1667h.m3804d());
    }

    /* renamed from: M0 */
    public final String m64580M0() {
        PushCmdParser pushCmdParser = this.f5581b;
        if (pushCmdParser == null) {
            C13981a.m83988e(this.f50660L, "PushCmdParser is null");
            return "";
        }
        String accountName = pushCmdParser.getAccountName();
        String name = this.f5581b.getName();
        if (C4633d0.m28404a(name) || C4633d0.m28404a(accountName)) {
            if (C4633d0.m28404a(name)) {
                if (!C4633d0.m28404a(accountName)) {
                    return accountName;
                }
                C13981a.m83988e(this.f50660L, "getUserMessage error, push message is empty");
                return "";
            }
        } else if (!name.equals(accountName)) {
            return name + "(" + accountName + ")";
        }
        return name;
    }

    /* renamed from: O0 */
    public final void m64581O0(Message message) throws JSONException {
        int iM1685c = C0241z.m1685c(message.getData().getString("result"));
        C13981a.m83989i(this.f50660L, "handleReportShareLocateCallback result:" + iM1685c);
        if (200 != iM1685c) {
            C13981a.m83989i(this.f50660L, "handleReportShareLocateCallback->report error");
            m7426P(this.f50660L, "hisync.findmyphone_locate", 1, iM1685c, "001_3003", -1, this.f5586g + "ShareLocate handleReportShareLocateCallback fail,result:" + iM1685c, this.f50531r, "pushShareLocate", false);
            this.f50536w = true;
            return;
        }
        String string = message.getData().getString("response_info");
        int iM7438x = m7438x(string);
        C13981a.m83989i(this.f50660L, "handleReportShareLocateCallback->resultCode =" + iM7438x);
        if (iM7438x == 0) {
            new C10813a(this.f5580a, new AbstractC10482g.b(3020)).m65856d();
            if (!this.f50534u) {
                this.f50515A = System.currentTimeMillis() - this.f50538y;
                this.f50534u = true;
            }
            m7424L("hisync.findmyphone_locate", 1, 0);
            m64458K0();
            String strM7439y = m7439y(string);
            C13981a.m83989i(this.f50660L, "handleReportShareLocateCallback result:" + strM7439y);
            return;
        }
        if (7 == iM7438x) {
            Intent intent = new Intent();
            intent.setAction("com.huawei.android.remotecontrol.PHONEFINDER_DEVICE_DELETE");
            C13108a.m78878b(this.f5580a).m78881d(intent);
        } else {
            if (401 == iM7438x) {
                m64470p0();
                return;
            }
            m7426P(this.f50660L, "hisync.findmyphone_locate", 1, iM7438x, "001_3004", iM7438x, this.f5586g + "ShareLocate handleReportShareLocateCallback fail,resultCode:" + iM7438x, this.f50531r, "pushShareLocate", true);
        }
    }

    /* renamed from: P0 */
    public final void m64582P0(Message message) throws JSONException {
        int iM1685c = C0241z.m1685c(message.getData().getString("result"));
        C13981a.m83989i(this.f50660L, "handleReportShareLocateFailCallback result:" + iM1685c);
        if (200 != iM1685c) {
            C13981a.m83989i(this.f50660L, "handleReportShareLocateFailCallback->report error");
            m7426P(this.f50660L, "hisync.findmyphone_locate", 1, iM1685c, "001_3003", -1, this.f5586g + "phoneFinder ShareLocate handleReportShareLocateFailCallback fail,result:" + iM1685c, this.f50531r, "pushShareLocate", true);
            return;
        }
        int iM7438x = m7438x(message.getData().getString("response_info"));
        C13981a.m83989i(this.f50660L, "handleReportShareLocateFailCallback->resultCode =" + iM7438x);
        if (iM7438x != 0) {
            m7426P(this.f50660L, "hisync.findmyphone_locate", 1, iM7438x, "001_3004", iM7438x, this.f5586g + "phonefinder ShareLocate handleReportShareLocateFailCallback fail,resultCode:" + iM7438x, this.f50531r, "pushShareLocate", true);
        }
        if (401 == iM7438x) {
            m64470p0();
        }
    }

    /* renamed from: T0 */
    public void m64583T0(int i10) {
        if (!C1175a.m7389k(this.f5580a)) {
            m7425M();
            return;
        }
        this.f5582c = i10;
        this.f5583d = null;
        m7417D(new AbstractC10482g.b(3101));
        C13981a.m83989i(this.f50660L, "reportShareFailResult, remove shareLocate task.");
        C10481f.m64440p(this.f5580a, this);
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("result", String.valueOf(i10));
        m7427Q(this.f50660L, "001_2001", 3101, this.f5586g + "ShareLocate failed", null, this.f50531r, "pushShareLocate", true, linkedHashMap);
    }

    @Override // p366if.InterfaceC10483h
    /* renamed from: b */
    public void mo64422b() {
        C13981a.m83989i(this.f50660L, "onLocateTerminate, remove shareLocate task.");
        C10481f.m64440p(this.f5580a, this);
        if (!this.f50535v && !this.f50532s.m64480b()) {
            C13981a.m83989i(this.f50660L, "get no location finally");
            this.f5582c = 68;
            this.f5583d = null;
            m7417D(null);
            m7427Q(this.f50660L, "001_2001", 68, this.f5586g + "ShareLocate get no location finally", null, this.f50531r, "pushShareLocate", true, null);
        }
        m64577R0();
        m64461f0();
    }

    @Override // p366if.InterfaceC10483h
    /* renamed from: d */
    public void mo64423d(C10488m c10488m) throws JSONException {
        if (c10488m == null || c10488m.m64550b() == null) {
            C13981a.m83988e(this.f50660L, "location info is null");
            return;
        }
        C13981a.m83989i(this.f50660L, "onLocateUpdate:" + c10488m.m64550b().getProvider() + "," + c10488m.m64550b().getAccuracy());
        C10489n.m64552d().m64553a(c10488m.m64550b());
        C10489n.m64552d().m64556e(c10488m.m64549a());
        m64475v0(c10488m.m64550b());
        m64449A0(c10488m, C13811a.m82820q(this.f5580a), System.currentTimeMillis());
    }

    @Override // p366if.InterfaceC10483h
    /* renamed from: e */
    public void mo64424e(Location location) {
        C13981a.m83989i(this.f50660L, "locateAgain");
        if (!this.f50535v && !this.f50532s.m64480b()) {
            C13981a.m83989i(this.f50660L, "get no location in 30s");
            this.f5582c = 67;
            this.f5583d = null;
            m7417D(null);
            m7427Q(this.f50660L, "001_2001", 67, this.f5586g + "ShareLocate get no location in 30s", null, this.f50531r, "pushShareLocate", false, null);
        }
        if (this.f50535v && !this.f50534u && this.f50536w && !this.f50532s.m64480b()) {
            C13981a.m83989i(this.f50660L, "has exception in 30s");
            m7427Q(this.f50660L, "001_2001", 70, this.f5586g, null, this.f50531r, "pushShareLocate", false, null);
        }
        m64451C0(location);
    }

    @Override // p366if.AbstractC10482g
    /* renamed from: o0 */
    public boolean mo64412o0(Message message, int i10, int i11) throws JSONException {
        C13981a.m83989i(this.f50660L, "HttpCallback->handleMessage:" + i10);
        if (3011 == i10) {
            return m64575N0(message, i11);
        }
        if (3020 == i10) {
            C10813a.m65855g(message, this.f5580a);
            return true;
        }
        if (3100 == i10) {
            m64581O0(message);
            return false;
        }
        if (3101 != i10) {
            return false;
        }
        m64582P0(message);
        return false;
    }

    @Override // p366if.AbstractC10482g, bf.AbstractC1177c
    /* renamed from: z */
    public void mo7440z() {
        if (!C13811a.m82828y(this.f5580a)) {
            C13981a.m83988e(this.f50660L, "The location agreement is not agreed.");
            m64583T0(72);
            return;
        }
        if (!C13811a.m82826w(this.f5580a)) {
            C13981a.m83988e(this.f50660L, "isLocationEnabled is false.");
            m64583T0(73);
            return;
        }
        if (!C13811a.m82829z(this.f5580a)) {
            C13981a.m83988e(this.f50660L, "The GPS or Network position is not agreed.");
            m7427Q(this.f50660L, "001_2001", -1, this.f5586g + "The GPS or Network position is not agreed", null, this.f50531r, "pushShareLocate", true, null);
        }
        m64579L0(this.f5580a);
        mo64413q0();
        mo64403I0();
    }

    @Override // p366if.AbstractC10482g
    /* renamed from: z0 */
    public void mo64414z0() {
        C13981a.m83988e(this.f50660L, "ShareLocate hasPermissions = false");
        C10481f.m64440p(this.f5580a, this);
        m64583T0(66);
        m7426P(this.f50660L, "hisync.findmyphone_locate", 1, 66, "001_2001", 66, this.f5586g + "phoneFinder ShareLocate fail", this.f50531r, "pushShareLocate", false);
    }
}
