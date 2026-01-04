package com.huawei.android.remotecontrol.receiver;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import bf.AbstractC1177c;
import bf.C1175a;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.remotecontrol.bluetooth.ancillarydevice.AncillaryDeviceDBHelper;
import com.huawei.android.remotecontrol.bluetooth.ancillarydevice.AncillaryDeviceInfo;
import com.huawei.android.remotecontrol.controller.PhoneFinderEncryptData;
import com.huawei.android.remotecontrol.controller.cmd.ExecuteCmdBuilder;
import com.huawei.android.remotecontrol.controller.cmd.PushCmdParser;
import com.huawei.android.remotecontrol.notification.PhoneFinderNotificationMgr;
import com.huawei.android.remotecontrol.offlinelocate.C4375j;
import com.huawei.android.remotecontrol.p093ui.webview.WapFindPhoneActivity;
import com.huawei.android.remotecontrol.sdk.R$drawable;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hms.findnetwork.comm.request.bean.PairedDeviceInfo;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import eg.AbstractC9473b;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0238w;
import p015ak.C0241z;
import p227dg.C9097b;
import p227dg.C9120m0;
import p237du.C9310c;
import p336he.C10159j;
import p427kf.C11048b;
import p520of.C11852b;
import p520of.C11860j;
import p521og.C11869b;
import p521og.C11872e;
import p611rf.C12505m;
import p616rk.C12515a;
import p774xg.C13811a;
import p809yg.C13981a;
import p841ze.C14288b;
import pg.AbstractC12139d;
import sg.C12796a;
import sg.C12797b;

/* loaded from: classes4.dex */
public class PushCommandReceiver extends BroadcastReceiver {

    /* renamed from: com.huawei.android.remotecontrol.receiver.PushCommandReceiver$a */
    public class C4385a extends AbstractC9473b {

        /* renamed from: a */
        public final /* synthetic */ String f20032a;

        /* renamed from: b */
        public final /* synthetic */ String f20033b;

        /* renamed from: c */
        public final /* synthetic */ String f20034c;

        /* renamed from: d */
        public final /* synthetic */ PairedDeviceInfo f20035d;

        /* renamed from: e */
        public final /* synthetic */ Context f20036e;

        /* renamed from: f */
        public final /* synthetic */ String f20037f;

        /* renamed from: g */
        public final /* synthetic */ String f20038g;

        /* renamed from: h */
        public final /* synthetic */ String f20039h;

        /* renamed from: i */
        public final /* synthetic */ String f20040i;

        /* renamed from: j */
        public final /* synthetic */ int f20041j;

        /* renamed from: k */
        public final /* synthetic */ String f20042k;

        /* renamed from: l */
        public final /* synthetic */ int f20043l;

        public C4385a(String str, String str2, String str3, PairedDeviceInfo pairedDeviceInfo, Context context, String str4, String str5, String str6, String str7, int i10, String str8, int i11) {
            this.f20032a = str;
            this.f20033b = str2;
            this.f20034c = str3;
            this.f20035d = pairedDeviceInfo;
            this.f20036e = context;
            this.f20037f = str4;
            this.f20038g = str5;
            this.f20039h = str6;
            this.f20040i = str7;
            this.f20041j = i10;
            this.f20042k = str8;
            this.f20043l = i11;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException, InterruptedException {
            C11872e.m71177o(this.f20036e, this.f20035d.getSn(), this.f20037f, this.f20038g, C10159j.m63328d(C0241z.m1688f(this.f20039h)), PushCommandReceiver.this.m26489o(this.f20032a, this.f20033b, this.f20034c, this.f20035d.getSn(), this.f20036e), this.f20040i, this.f20041j, this.f20042k, this.f20043l);
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.receiver.PushCommandReceiver$b */
    public class C4386b extends AbstractC9473b {

        /* renamed from: a */
        public final /* synthetic */ String f20045a;

        /* renamed from: b */
        public final /* synthetic */ String f20046b;

        /* renamed from: c */
        public final /* synthetic */ String f20047c;

        /* renamed from: d */
        public final /* synthetic */ AncillaryDeviceInfo f20048d;

        /* renamed from: e */
        public final /* synthetic */ Context f20049e;

        /* renamed from: f */
        public final /* synthetic */ String f20050f;

        /* renamed from: g */
        public final /* synthetic */ String f20051g;

        /* renamed from: h */
        public final /* synthetic */ String f20052h;

        /* renamed from: i */
        public final /* synthetic */ String f20053i;

        /* renamed from: j */
        public final /* synthetic */ int f20054j;

        /* renamed from: k */
        public final /* synthetic */ String f20055k;

        /* renamed from: l */
        public final /* synthetic */ int f20056l;

        public C4386b(String str, String str2, String str3, AncillaryDeviceInfo ancillaryDeviceInfo, Context context, String str4, String str5, String str6, String str7, int i10, String str8, int i11) {
            this.f20045a = str;
            this.f20046b = str2;
            this.f20047c = str3;
            this.f20048d = ancillaryDeviceInfo;
            this.f20049e = context;
            this.f20050f = str4;
            this.f20051g = str5;
            this.f20052h = str6;
            this.f20053i = str7;
            this.f20054j = i10;
            this.f20055k = str8;
            this.f20056l = i11;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException, InterruptedException {
            C11872e.m71177o(this.f20049e, this.f20048d.getDeviceID(), this.f20050f, this.f20051g, C10159j.m63328d(C0241z.m1688f(this.f20052h)), PushCommandReceiver.this.m26489o(this.f20045a, this.f20046b, this.f20047c, this.f20048d.getDeviceID(), this.f20049e), this.f20053i, this.f20054j, this.f20055k, this.f20056l);
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.receiver.PushCommandReceiver$c */
    public class C4387c extends AbstractC9473b {

        /* renamed from: a */
        public final /* synthetic */ Context f20058a;

        /* renamed from: b */
        public final /* synthetic */ Intent f20059b;

        /* renamed from: c */
        public final /* synthetic */ String f20060c;

        /* renamed from: d */
        public final /* synthetic */ PushCmdParser f20061d;

        public C4387c(Context context, Intent intent, String str, PushCmdParser pushCmdParser) {
            this.f20058a = context;
            this.f20059b = intent;
            this.f20060c = str;
            this.f20061d = pushCmdParser;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException {
            if (C11852b.m70957b().m70959d(this.f20058a)) {
                PushCommandReceiver.this.m26482D(this.f20058a, this.f20059b);
                return;
            }
            if ("openLostPattern".equals(this.f20060c)) {
                new C11048b(this.f20061d, this.f20058a).m66604a0();
            } else if ("clear".equals(this.f20060c)) {
                new C14288b(this.f20061d, this.f20058a).m85132v0();
            }
            new C12796a().m76773f(C0213f.m1377a(), "-1", "getPushSignPK fail, operation=" + this.f20060c, "-1", this.f20061d.getOperation(), this.f20061d.getTraceID(), "pushResult_reported", null);
        }
    }

    /* renamed from: A */
    public static /* synthetic */ Boolean m26466A(String str, Context context, String str2, boolean z10, PairedDeviceInfo pairedDeviceInfo) throws JSONException {
        if (!str.equals(C9310c.m58618b(pairedDeviceInfo.getSn()))) {
            return Boolean.FALSE;
        }
        C9120m0.m57365Y(context, pairedDeviceInfo.getSn(), str2, z10);
        return Boolean.TRUE;
    }

    /* renamed from: w */
    public static /* synthetic */ void m26476w(FindNetworkResult findNetworkResult) {
        C13981a.m83989i("PushCommandReceiver", "enableGoodsDisconnectNotifyEnhanced result return, respCode = " + findNetworkResult.getRespCode());
    }

    /* renamed from: x */
    public static /* synthetic */ Boolean m26477x(String str, Context context, int i10, PairedDeviceInfo pairedDeviceInfo) {
        if (!str.equals(C9310c.m58618b(pairedDeviceInfo.getSn()))) {
            return Boolean.FALSE;
        }
        C9120m0.m57367Z(context, pairedDeviceInfo.getSn(), i10, "", new Consumer() { // from class: com.huawei.android.remotecontrol.receiver.h
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                PushCommandReceiver.m26476w((FindNetworkResult) obj);
            }
        });
        return Boolean.TRUE;
    }

    /* renamed from: y */
    public static /* synthetic */ void m26478y(FindNetworkResult findNetworkResult) {
        C13981a.m83989i("PushCommandReceiver", "enableGoodsDisconnectNotifyEnhanced result return, respCode = " + findNetworkResult.getRespCode());
    }

    /* renamed from: B */
    public final /* synthetic */ void m26480B(Context context, String str, int i10, String str2, Boolean bool) {
        C13981a.m83989i("PushCommandReceiver", "sendFindNetworkStatusToNearby result: " + bool);
        if (bool.booleanValue()) {
            m26488n(context, str, i10, str2);
        }
    }

    /* renamed from: C */
    public final void m26481C(final Context context, HiCloudSafeIntent hiCloudSafeIntent) {
        String strM26491q = m26491q(context, hiCloudSafeIntent);
        if (strM26491q == null) {
            return;
        }
        C12797b c12797b = new C12797b();
        try {
            JSONObject jSONObject = new JSONObject(strM26491q);
            c12797b.m76784j(context, "PushCommandReceiver", "0", "receive find lost push cmd", null, "01047", jSONObject.optString("x-hw-trace-id", ""), "push_received", true);
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("body"));
            final String strOptString = jSONObject2.optString("deviceIdSha256");
            final boolean zOptBoolean = jSONObject2.optBoolean("offlineNotifyEnable");
            final String strOptString2 = jSONObject2.optString("mStandbyDevice");
            String strM71136c = C11869b.m71136c(context, AncillaryDeviceDBHelper.m26045e(context).m26058y(strOptString));
            if (strM71136c == null) {
                C9120m0.m57368Z0(context, new Function() { // from class: com.huawei.android.remotecontrol.receiver.b
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return PushCommandReceiver.m26466A(strOptString, context, strOptString2, zOptBoolean, (PairedDeviceInfo) obj);
                    }
                });
            } else {
                C9120m0.m57365Y(context, ((AncillaryDeviceInfo) new Gson().fromJson(strM71136c, AncillaryDeviceInfo.class)).getDeviceID(), strOptString2, zOptBoolean);
            }
        } catch (Exception e10) {
            C13981a.m83988e("PushCommandReceiver", "processFindLost error:" + e10.getMessage());
        }
    }

    /* renamed from: D */
    public final void m26482D(Context context, Intent intent) throws JSONException {
        if (context == null) {
            C13981a.m83989i("PushCommandReceiver", "processRemoteControlMessage context is null");
            return;
        }
        PushCmdParser pushCmdParser = new PushCmdParser(intent, context);
        AbstractC1177c.m7407S(pushCmdParser, context);
        C12797b c12797b = new C12797b();
        c12797b.m76783i(context, "PushCommandReceiver", "0", "report Receive PushCmd", null, pushCmdParser, "push_received", false);
        if (!C1175a.m7389k(context)) {
            C13981a.m83990w("PushCommandReceiver", "receive push cmd,ControlObject report Client Switch off");
            c12797b.m76783i(context, "PushCommandReceiver", "001_1011", "findmyphone disable", null, pushCmdParser, "pushResult_reported", true);
        }
        if (m26484j(context, pushCmdParser, intent, c12797b)) {
            AbstractC1177c abstractC1177cExecuteCmd = ExecuteCmdBuilder.executeCmd(context, pushCmdParser);
            if (abstractC1177cExecuteCmd != null) {
                abstractC1177cExecuteCmd.mo7440z();
                return;
            }
            C13981a.m83988e("PushCommandReceiver", "Receive PushCmd,ControlObject report obj is null");
            AbstractC1177c.m7405O(pushCmdParser, context);
            c12797b.m76783i(context, "PushCommandReceiver", "001_1013", "cmd not support", null, pushCmdParser, "pushResult_reported", true);
        }
    }

    /* renamed from: E */
    public final void m26483E(final Context context, HiCloudSafeIntent hiCloudSafeIntent) {
        String strM26491q = m26491q(context, hiCloudSafeIntent);
        if (strM26491q == null) {
            return;
        }
        C12797b c12797b = new C12797b();
        try {
            JSONObject jSONObject = new JSONObject(strM26491q);
            c12797b.m76784j(context, "PushCommandReceiver", "0", "receive tag disconnect push cmd", null, "01052", jSONObject.optString("x-hw-trace-id", ""), "push_received", true);
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("body"));
            final String strOptString = jSONObject2.optString("deviceIdSha256");
            final int iOptInt = jSONObject2.optInt("status", -1);
            C9097b.m57314x(strOptString, jSONObject2.optBoolean("lostBellEnable", false));
            final String strM71136c = C11869b.m71136c(context, AncillaryDeviceDBHelper.m26045e(context).m26058y(strOptString));
            if (C4375j.m26422x(context)) {
                m26488n(context, strOptString, iOptInt, strM71136c);
            } else {
                C4375j.m26396J(context, true, new Consumer() { // from class: com.huawei.android.remotecontrol.receiver.c
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.f20071a.m26480B(context, strOptString, iOptInt, strM71136c, (Boolean) obj);
                    }
                });
            }
        } catch (Exception e10) {
            C13981a.m83988e("PushCommandReceiver", "processTagDisconnect error:" + e10.getMessage());
        }
    }

    /* renamed from: j */
    public final boolean m26484j(Context context, PushCmdParser pushCmdParser, Intent intent, C12797b c12797b) {
        if (!pushCmdParser.checkUserId(context)) {
            C13981a.m83988e("PushCommandReceiver", "Receive PushCmd,ControlObject report UserId dismatch");
            AbstractC1177c.m7409U(pushCmdParser, context);
            c12797b.m76783i(context, "PushCommandReceiver", "001_1012", "uid not match", null, pushCmdParser, "pushResult_reported", true);
            return false;
        }
        if (!C11852b.m70957b().m70960e(C0213f.m1377a())) {
            m26492r(C0213f.m1377a(), pushCmdParser, intent);
            return false;
        }
        if (pushCmdParser.checkCmdFormat() && pushCmdParser.checkSign()) {
            return true;
        }
        C13981a.m83988e("PushCommandReceiver", "Receive PushCmd is error");
        AbstractC1177c.m7406R(pushCmdParser, context);
        if (TextUtils.isEmpty(AbstractC12139d.m72766e(context).getUserID()) || TextUtils.isEmpty(AbstractC12139d.m72766e(context).getDeviceTicket())) {
            c12797b.m76783i(context, "PushCommandReceiver", "001_1003", "uid or dt is null", null, pushCmdParser, "pushResult_reported", true);
        } else {
            c12797b.m76783i(context, "PushCommandReceiver", "001_1010", "check sign error", null, pushCmdParser, "pushResult_reported", true);
        }
        if ("inactive".equals(pushCmdParser.getOperation()) || "empty".equals(pushCmdParser.getOperation())) {
            C13981a.m83989i("PushCommandReceiver", "inactive not need to update DT");
            return false;
        }
        if (!TextUtils.isEmpty(AbstractC12139d.m72766e(context).getUserID())) {
            C13981a.m83989i("PushCommandReceiver", "updateDeviceTicket: receive push");
            new C12505m(pushCmdParser.getTraceID()).m75087f();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r20v0, types: [com.huawei.hicloud.base.common.HiCloudSafeIntent] */
    /* JADX WARN: Type inference failed for: r20v3 */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARN: Type inference failed for: r20v5 */
    /* JADX WARN: Type inference failed for: r20v6 */
    /* renamed from: k */
    public final void m26485k(final Context context, HiCloudSafeIntent hiCloudSafeIntent) {
        String str;
        String strOptString = "";
        String strM26491q = m26491q(context, hiCloudSafeIntent);
        if (strM26491q == null) {
            return;
        }
        final String userKey = AbstractC12139d.m72766e(context).getUserKey();
        if (TextUtils.isEmpty(userKey)) {
            C13981a.m83988e("PushCommandReceiver", "decryptData userKey is empty");
            return;
        }
        C12797b c12797b = new C12797b();
        try {
            JSONObject jSONObject = new JSONObject(strM26491q);
            c12797b.m76784j(context, "PushCommandReceiver", "0", "receive offline locate push cmd, show notify", null, "01048", jSONObject.optString("x-hw-trace-id", ""), "pushGoodsOnline", true);
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("body"));
            final String strOptString2 = jSONObject2.optString(JsbMapKeyNames.H5_LOC);
            final String strOptString3 = jSONObject2.optString("deviceId");
            final String strOptString4 = jSONObject2.optString("deviceIdSha256");
            final String strOptString5 = jSONObject2.optString("deviceName");
            final String strOptString6 = jSONObject2.optString("locationFrom");
            final String strOptString7 = jSONObject2.optString("time");
            final String strOptString8 = jSONObject2.optString("mStandbyDevice");
            String strOptString9 = jSONObject2.optString("perDeviceTypeInfo");
            final String strOptString10 = jSONObject2.optString(VastAttribute.SEQUENCE);
            final int iOptInt = jSONObject2.optInt("componentType");
            C13981a.m83989i("PushCommandReceiver", "createFindLostGoodsNotification, componentType :" + iOptInt + ", standByDevice: " + C9120m0.m57355T(strOptString8));
            if (TextUtils.isEmpty(strOptString9)) {
                C13981a.m83988e("PushCommandReceiver", "the perDeviceTypeInfo is empty");
            } else {
                strOptString = new JSONObject(strOptString9).optString("ModelID");
            }
            final int iM57301k = C9097b.m57301k(strOptString);
            String strM71136c = C11869b.m71136c(context, AncillaryDeviceDBHelper.m26045e(context).m26058y(strOptString4));
            try {
                if (strM71136c == null) {
                    hiCloudSafeIntent = "PushCommandReceiver";
                    C9120m0.m57368Z0(context, new Function() { // from class: com.huawei.android.remotecontrol.receiver.d
                        @Override // java.util.function.Function
                        public final Object apply(Object obj) {
                            return this.f20076a.m26496v(strOptString4, strOptString6, strOptString2, userKey, context, strOptString3, strOptString5, strOptString7, strOptString10, iM57301k, strOptString8, iOptInt, (PairedDeviceInfo) obj);
                        }
                    });
                } else {
                    hiCloudSafeIntent = "PushCommandReceiver";
                    C12515a.m75110o().m75172d(new C4386b(strOptString6, strOptString2, userKey, (AncillaryDeviceInfo) new Gson().fromJson(strM71136c, AncillaryDeviceInfo.class), context, strOptString3, strOptString5, strOptString7, strOptString10, iM57301k, strOptString8, iOptInt));
                }
            } catch (Exception e10) {
                e = e10;
                str = hiCloudSafeIntent;
                C13981a.m83988e(str, "create Notification error:" + e.getMessage());
            }
        } catch (Exception e11) {
            e = e11;
            str = "PushCommandReceiver";
        }
    }

    /* renamed from: l */
    public final void m26486l(Context context, HiCloudSafeIntent hiCloudSafeIntent) {
        String strOptString = "";
        String strM26491q = m26491q(context, hiCloudSafeIntent);
        if (strM26491q == null) {
            return;
        }
        C12797b c12797b = new C12797b();
        try {
            strOptString = new JSONObject(strM26491q).optString("x-hw-trace-id", "");
        } catch (Exception e10) {
            C13981a.m83988e("PushCommandReceiver", "get push message error" + e10.getMessage());
        }
        c12797b.m76784j(context, "PushCommandReceiver", "0", "receive location share push cmd, show notify", null, "01045", strOptString, "pushShareLocate", true);
        String strM26493s = m26493s(strM26491q);
        String string = context.getString(R$string.start_finder_phone_new);
        String string2 = context.getString(R$string.share_guide_title);
        String string3 = context.getString(R$string.location_share_notification_message, strM26493s);
        Intent intent = new Intent(context, (Class<?>) WapFindPhoneActivity.class);
        intent.putExtra(RemoteMessageConst.FROM, "fromNotificationClick");
        intent.putExtra("isFromInner", true);
        intent.putExtra("isSystemAcc", true);
        intent.putExtra("isEnableJs", true);
        intent.putExtra("needShowLoading", true);
        intent.putExtra("isAutoLogin", true);
        intent.putExtra("isSupportPicker", true);
        intent.putExtra("isAddShare", true);
        int iM26495u = m26495u(strM26491q);
        C13981a.m83989i("PushCommandReceiver", "getShareNotifyId:" + iM26495u);
        new PhoneFinderNotificationMgr(context).m26378c(iM26495u, m26490p(context, string, string2, string3, C0209d.m1248e0(context, iM26495u, intent, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK)).m3804d());
    }

    /* renamed from: m */
    public final String m26487m(int i10, PhoneFinderEncryptData phoneFinderEncryptData, byte[] bArr) {
        if (1 == i10) {
            return C11869b.m71135b(phoneFinderEncryptData, bArr);
        }
        if (2 == i10) {
            return C11869b.m71138e(phoneFinderEncryptData, bArr);
        }
        String strM71138e = C11869b.m71138e(phoneFinderEncryptData, bArr);
        return TextUtils.isEmpty(strM71138e) ? C11869b.m71135b(phoneFinderEncryptData, bArr) : strM71138e;
    }

    /* renamed from: n */
    public final void m26488n(final Context context, final String str, final int i10, String str2) {
        if (str2 == null) {
            C13981a.m83989i("PushCommandReceiver", "processTagDisconnect deviceInfo is null");
            C9120m0.m57368Z0(context, new Function() { // from class: com.huawei.android.remotecontrol.receiver.f
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return PushCommandReceiver.m26477x(str, context, i10, (PairedDeviceInfo) obj);
                }
            });
            return;
        }
        try {
            C9120m0.m57367Z(context, ((AncillaryDeviceInfo) new Gson().fromJson(str2, AncillaryDeviceInfo.class)).getDeviceID(), i10, "", new Consumer() { // from class: com.huawei.android.remotecontrol.receiver.g
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    PushCommandReceiver.m26478y((FindNetworkResult) obj);
                }
            });
        } catch (JsonSyntaxException e10) {
            C13981a.m83988e("PushCommandReceiver", "JsonSyntaxException is" + e10.toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0175 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0177  */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.StringBuilder] */
    /* renamed from: o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m26489o(java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, android.content.Context r24) throws org.json.JSONException, java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 391
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.remotecontrol.receiver.PushCommandReceiver.m26489o(java.lang.String, java.lang.String, java.lang.String, java.lang.String, android.content.Context):java.lang.String");
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws JSONException {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        String action = hiCloudSafeIntent.getAction();
        if (TextUtils.isEmpty(action)) {
            C13981a.m83988e("PushCommandReceiver", "onReceive,action is null");
            return;
        }
        C13981a.m83989i("PushCommandReceiver", "PushCommandReceiver, action: " + action);
        if ("com.huawei.hidisk.remotecontrol.intent.update.active.info".equals(action)) {
            String stringExtra = hiCloudSafeIntent.getStringExtra("push_token");
            if (TextUtils.isEmpty(stringExtra)) {
                C13981a.m83988e("PushCommandReceiver", "pushToken received is null");
                return;
            } else {
                C11860j.m70996G0(stringExtra);
                return;
            }
        }
        if ("com.huawei.hidisk.remotecontrol.intent.push.message".equals(action)) {
            C13981a.m83989i("PushCommandReceiver", "receive push cmd");
            m26482D(context.getApplicationContext(), intent);
            return;
        }
        if ("com.huawei.hidisk.remotecontrol.intent.location.share.message".equals(action)) {
            C13981a.m83989i("PushCommandReceiver", "receive location share push cmd");
            m26486l(context, hiCloudSafeIntent);
            return;
        }
        if ("com.huawei.hidisk.remotecontrol.intent.offline.locate.message".equals(action)) {
            C13981a.m83989i("PushCommandReceiver", "receive offline locate push cmd");
            m26485k(context, hiCloudSafeIntent);
            return;
        }
        if ("com.huawei.hidisk.remotecontrol.intent.find.lost.message".equals(action)) {
            C13981a.m83989i("PushCommandReceiver", "receive find lost push cmd");
            m26481C(context.getApplicationContext(), hiCloudSafeIntent);
        } else if ("com.huawei.hidisk.remotecontrol.intent.tag.disconnect.message".equals(action)) {
            C13981a.m83989i("PushCommandReceiver", "receive tag disconnect push cmd");
            m26483E(context.getApplicationContext(), hiCloudSafeIntent);
        } else {
            C13981a.m83989i("PushCommandReceiver", "unknown push command,action:" + action);
        }
    }

    /* renamed from: p */
    public final NotificationCompat.Builder m26490p(Context context, String str, String str2, String str3, PendingIntent pendingIntent) {
        NotificationCompat.Builder builderM1667h = C0238w.m1663f().m1667h(context, str, 3, "location_sharing");
        Bundle bundle = new Bundle();
        bundle.putString("android.substName", str);
        bundle.putBoolean("hw_enable_small_icon", true);
        NotificationCompat.C0605b c0605b = new NotificationCompat.C0605b();
        c0605b.m3840i(str2).m3839h(str3);
        builderM1667h.m3824y(R$drawable.ic_findmyphone_new).m3811l(str2).m3810k(str3).m3821v(0).m3823x(true).m3825z(c0605b).m3817r("com.huawei.android.findphone").m3807h(true).m3809j(pendingIntent).m3803c(bundle);
        return builderM1667h;
    }

    /* renamed from: q */
    public final String m26491q(Context context, HiCloudSafeIntent hiCloudSafeIntent) {
        if (context == null) {
            C13981a.m83988e("PushCommandReceiver", "context is null");
            return null;
        }
        String stringExtra = hiCloudSafeIntent.getStringExtra("msg_data");
        if (stringExtra != null) {
            return stringExtra;
        }
        C13981a.m83988e("PushCommandReceiver", "push message is null");
        return null;
    }

    /* renamed from: r */
    public final void m26492r(Context context, PushCmdParser pushCmdParser, Intent intent) {
        C13981a.m83989i("PushCommandReceiver", "getPushPkAndRetry");
        String operation = pushCmdParser.getOperation();
        if ("openLostPattern".equals(operation)) {
            C13811a.m82805b(true, "loss_mode");
        } else if ("clear".equals(operation)) {
            C13811a.m82805b(true, "clear_locate");
        }
        C12515a.m75110o().m75175e(new C4387c(context, intent, operation, pushCmdParser), false);
    }

    /* renamed from: s */
    public final String m26493s(String str) {
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(str).optString("body"));
            return m26494t(jSONObject.optString("accountName"), jSONObject.optString("aliasName"), jSONObject.optString("name"));
        } catch (Exception e10) {
            C13981a.m83988e("PushCommandReceiver", "create Notification error:" + e10.getMessage());
            return "";
        }
    }

    /* renamed from: t */
    public final String m26494t(String str, String str2, String str3) {
        if (!C4633d0.m28404a(str2) && !C4633d0.m28404a(str)) {
            if (str2.equals(str)) {
                return str2;
            }
            return str2 + "(" + str + ")";
        }
        if (!C4633d0.m28404a(str3) && !C4633d0.m28404a(str)) {
            return str3 + "(" + str + ")";
        }
        if (!C4633d0.m28404a(str)) {
            return str;
        }
        if (!C4633d0.m28404a(str2)) {
            return str2;
        }
        if (!C4633d0.m28404a(str3)) {
            return str3;
        }
        C13981a.m83988e("PushCommandReceiver", "getSenderMessage error, push message is empty");
        return "";
    }

    /* renamed from: u */
    public final int m26495u(String str) {
        try {
            String strOptString = new JSONObject(new JSONObject(str).optString("body")).optString("accountName");
            if (TextUtils.isEmpty(strOptString)) {
                return 565;
            }
            String strReplace = strOptString.replace("*", "");
            if (strReplace.length() >= 6) {
                strReplace = strReplace.substring(0, 5);
            }
            return Objects.hash(strReplace);
        } catch (Exception e10) {
            C13981a.m83988e("PushCommandReceiver", "getShareNotifyId error:" + e10.getMessage());
            return 565;
        }
    }

    /* renamed from: v */
    public final /* synthetic */ Boolean m26496v(String str, String str2, String str3, String str4, Context context, String str5, String str6, String str7, String str8, int i10, String str9, int i11, PairedDeviceInfo pairedDeviceInfo) {
        if (!str.equals(C9310c.m58618b(pairedDeviceInfo.getSn()))) {
            return Boolean.FALSE;
        }
        C12515a.m75110o().m75172d(new C4385a(str2, str3, str4, pairedDeviceInfo, context, str5, str6, str7, str8, i10, str9, i11));
        return Boolean.TRUE;
    }
}
