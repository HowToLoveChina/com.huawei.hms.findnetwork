package p521og;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.huawei.android.remotecontrol.alarm.TagLostBellDialogActivity;
import com.huawei.android.remotecontrol.notification.PhoneFinderNotificationMgr;
import com.huawei.android.remotecontrol.p093ui.webview.WapFindPhoneActivity;
import com.huawei.android.remotecontrol.sdk.R$drawable;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0227m;
import p015ak.C0238w;
import p020ap.C1009d;
import p227dg.C9097b;
import p227dg.C9120m0;
import p684un.C13230i;
import p694v.C13306h;
import p709vj.C13452e;
import p809yg.C13981a;
import sg.C12797b;

/* renamed from: og.e */
/* loaded from: classes4.dex */
public class C11872e {
    /* renamed from: a */
    public static void m71163a(Context context) {
        C13981a.m83989i("NotificationUtil", "cancelLostBellNotification");
        C13306h.m79781d(context).m79785b(571);
    }

    /* renamed from: b */
    public static void m71164b(Context context, String str, String str2, String str3) {
        C13981a.m83989i("NotificationUtil", "createAlarmNotification");
        String string = context.getString(R$string.start_finder_phone_new);
        String string2 = context.getString(R$string.alarm_msg_default_new);
        String string3 = context.getString(R$string.hicloud_service_location_change_10);
        Intent intent = new Intent(context, (Class<?>) TagLostBellDialogActivity.class);
        intent.putExtra("TagSN", str);
        intent.putExtra("itemName", str2);
        intent.putExtra("modelId", str3);
        intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(context, 104, intent, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        NotificationCompat.Builder builderM1666g = C0238w.m1663f().m1666g(context, string);
        Bundle bundle = new Bundle();
        bundle.putString("android.substName", string);
        bundle.putBoolean("hw_enable_small_icon", true);
        builderM1666g.m3824y(R$drawable.ic_findmyphone_new).m3811l(string2).m3810k(string3).m3821v(-1).m3823x(false).m3825z(new NotificationCompat.C0605b()).m3817r("com.huawei.android.findphone").m3807h(true).m3803c(bundle).m3809j(pendingIntentM1248e0);
        new PhoneFinderNotificationMgr(context).m26378c(571, builderM1666g.m3804d());
    }

    /* renamed from: c */
    public static void m71165c(Context context, int i10) {
        C13981a.m83989i("NotificationUtil", "createTagTrackedNotification");
        if (context == null) {
            C13981a.m83988e("NotificationUtil", "context is null");
            return;
        }
        String string = context.getString(R$string.start_finder_phone_new);
        String string2 = context.getString(m71172j(i10, R$string.tag_tracked_notification_title, R$string.device_tracked_notification_title));
        String string3 = context.getString(m71172j(i10, R$string.tag_tracked_notification_message, R$string.device_tracked_notification_message));
        Intent intent = new Intent(context, (Class<?>) WapFindPhoneActivity.class);
        intent.putExtra("isFromInner", true);
        intent.putExtra(RemoteMessageConst.FROM, "fromNotificationClick");
        intent.putExtra("isEnableJs", true);
        intent.putExtra("isSystemAcc", true);
        intent.putExtra("needShowLoading", true);
        intent.putExtra("isTrackedTag", true);
        intent.putExtra("tabLocation", i10);
        intent.setFlags(268468224);
        PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(context, 103, intent, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        NotificationCompat.Builder builderM1666g = C0238w.m1663f().m1666g(context, string);
        Bundle bundle = new Bundle();
        bundle.putString("android.substName", string);
        bundle.putBoolean("hw_enable_small_icon", true);
        NotificationCompat.C0605b c0605b = new NotificationCompat.C0605b();
        c0605b.m3839h(string3).m3840i(string2);
        builderM1666g.m3824y(R$drawable.ic_findmyphone_new).m3810k(string3).m3811l(string2).m3821v(0).m3823x(true).m3825z(c0605b).m3817r("com.huawei.android.findphone").m3807h(true).m3809j(pendingIntentM1248e0).m3803c(bundle);
        new PhoneFinderNotificationMgr(context).m26378c(568, builderM1666g.m3804d());
        C9120m0.m57380d1(context, "mecloud_findmyphone_tag_tracked_notify", "", "", 0);
    }

    /* renamed from: d */
    public static void m71166d(Context context, String str, String str2, String str3, String str4, String str5) {
        C12797b c12797b = new C12797b();
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("perDeviceId", C9120m0.m57351R(str));
        linkedHashMap.put("standbyDevice", C9120m0.m57355T(str5));
        c12797b.m76785k(context, "NotificationUtil", str2, str3, null, str4, null, "finderTagSendNotify", true, linkedHashMap);
    }

    /* renamed from: e */
    public static PendingIntent m71167e(Context context, String str, int i10, int i11) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.huawei.hidisk", "com.huawei.android.remotecontrol.ui.webview.WapFindPhoneActivity"));
        intent.putExtra("DISCONNECT_NOTIFICATION", true);
        intent.putExtra("isFromInner", true);
        intent.putExtra("isSystemAcc", true);
        intent.putExtra("isEnableJs", true);
        intent.putExtra("needShowLoading", true);
        intent.putExtra("deviceId", str);
        intent.putExtra(RemoteMessageConst.FROM, "fromNotificationClick");
        intent.putExtra("tabLocation", i11);
        intent.setFlags(268468224);
        return C0209d.m1248e0(context, i10, intent, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
    }

    /* renamed from: f */
    public static String m71168f(Context context, String str, String str2, boolean z10, String str3) {
        String strM71171i = z10 ? m71171i(context, str, str2, str3, null) : null;
        C13981a.m83989i("NotificationUtil", "getFindLostNotificationDetail, isSceneName: " + z10 + ", sceneName: " + strM71171i + ", deviceName: " + str2);
        return !TextUtils.isEmpty(strM71171i) ? strM71171i : context.getString(R$string.find_lost_goods_detail2, str3, str2);
    }

    /* renamed from: g */
    public static String m71169g(Context context, String str, String str2, boolean z10, String str3, String str4) {
        String strM71171i = z10 ? m71171i(context, str, str2, str3, str4) : null;
        C13981a.m83989i("NotificationUtil", "getFindLostNotificationDetailWithAddress, isSceneName: " + z10 + ", sceneName: " + strM71171i + ", deviceName: " + str2);
        return !TextUtils.isEmpty(strM71171i) ? strM71171i : context.getString(R$string.find_lost_goods_detail, str3, str4, str2);
    }

    /* renamed from: h */
    public static String m71170h(Context context, String str, String str2, boolean z10) {
        C13981a.m83989i("NotificationUtil", "getFindLostNotificationTitle");
        String strM57300j = z10 ? C9097b.m57300j(context, str, str2, true) : null;
        C13981a.m83989i("NotificationUtil", "getFindLostNotificationTitle, deviceName: " + str2 + ", sceneName: " + strM57300j);
        return !TextUtils.isEmpty(strM57300j) ? strM57300j : context.getString(R$string.find_lost_goods_notify, str2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0032  */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m71171i(android.content.Context r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p521og.C11872e.m71171i(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    /* renamed from: j */
    public static int m71172j(int i10, int i11, int i12) {
        return 2 == i10 ? i12 : i11;
    }

    /* renamed from: k */
    public static PendingIntent m71173k(Context context, String str, int i10, int i11) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.huawei.hidisk", "com.huawei.android.remotecontrol.ui.webview.WapFindPhoneActivity"));
        intent.putExtra("FIND_LOST_NOTIFICATION", true);
        intent.putExtra("isFromInner", true);
        intent.putExtra("isSystemAcc", true);
        intent.putExtra("isEnableJs", true);
        intent.putExtra("needShowLoading", true);
        intent.putExtra("deviceId", str);
        intent.putExtra(RemoteMessageConst.FROM, "fromNotificationClick");
        intent.putExtra("tabLocation", i11);
        intent.setFlags(268468224);
        return C0209d.m1248e0(context, i10, intent, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
    }

    /* renamed from: l */
    public static int m71174l(String str, String str2) {
        C13981a.m83989i("NotificationUtil", "getRequestCode, deviceId: " + C9120m0.m57351R(str));
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int iHashCode = (str + m71175m(str2)).hashCode();
        C13981a.m83989i("NotificationUtil", "getRequestCode, requestCode: " + iHashCode);
        return iHashCode;
    }

    /* renamed from: m */
    public static String m71175m(String str) {
        StringBuilder sb2 = new StringBuilder("");
        if (TextUtils.isEmpty(str)) {
            return sb2.toString();
        }
        try {
            JSONArray jSONArray = new JSONArray(str.replace("\\\"", "\""));
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i10);
                if (jSONObjectOptJSONObject.optInt("status") == 1) {
                    sb2.append(jSONObjectOptJSONObject.optString("fid", ""));
                }
            }
            return sb2.toString();
        } catch (JSONException unused) {
            C13981a.m83988e("NotificationUtil", "getSnFromStandByDevice, JSONException");
            return "";
        } catch (Exception unused2) {
            C13981a.m83988e("NotificationUtil", "getSnFromStandByDevice, Exception");
            return "";
        }
    }

    /* renamed from: n */
    public static void m71176n(Context context, String str, String str2, String str3, String str4, String str5, String str6, boolean z10) throws JSONException {
        LinkedHashMap linkedHashMap;
        String str7 = str5;
        C13981a.m83989i("NotificationUtil", "showDisconnectNotify, deviceName: " + str + ", sceneId: " + str7 + ", isFullText: " + z10);
        String strM1593f = C0227m.m1593f(str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("perDeviceId", C9120m0.m57351R(str3));
        if (C1009d.m6109e().m6118j(context)) {
            C13981a.m83989i("NotificationUtil", "showDisconnectNotification has permission!");
            String string = context.getString(R$string.start_finder_phone_new);
            String string2 = z10 ? str : context.getString(R$string.disconnect_goods_notify, str);
            int iM57301k = C9097b.m57301k(str4);
            C13981a.m83989i("NotificationUtil", "showDisconnectNotification, modelId: " + str4 + ", tabLocation: " + iM57301k);
            String string3 = str2 == null ? context.getString(m71172j(iM57301k, R$string.disconnect_goods_detail2, R$string.disconnect_device_detail2)) : context.getString(m71172j(iM57301k, R$string.disconnect_goods_detail_1, R$string.disconnect_device_detail_1), str2);
            PendingIntent pendingIntentM71167e = m71167e(context, str3, m71174l(str3, str6) + 102, C9097b.m57301k(str4));
            NotificationCompat.C0605b c0605b = new NotificationCompat.C0605b();
            c0605b.m3840i(string2).m3839h(string3);
            NotificationCompat.Builder builderM1666g = C0238w.m1663f().m1666g(context, string);
            Bundle bundle = new Bundle();
            linkedHashMap = linkedHashMap2;
            bundle.putString("android.substName", string);
            bundle.putBoolean("hw_enable_small_icon", true);
            builderM1666g.m3824y(R$drawable.ic_findmyphone_new).m3811l(string2).m3810k(string3).m3823x(true).m3817r("com.huawei.android.findphone").m3807h(true).m3825z(c0605b).m3809j(pendingIntentM71167e).m3803c(bundle);
            if (str7 == null) {
                str7 = "";
            }
            String str8 = str7;
            new PhoneFinderNotificationMgr(context).m26379d(strM1593f + str8, 569, builderM1666g.m3804d());
            m71166d(context, str3, "0", "showDisconnectNotification success!", "01056", str6);
            if (C9097b.m57304n(str3, str4, str8)) {
                try {
                    C9097b.m57315y(context, str3, str, str4, str6);
                } catch (Exception e10) {
                    C13981a.m83988e("NotificationUtil", "showDisconnectNotification Exception, e: " + e10.getMessage());
                }
            }
        } else {
            linkedHashMap = linkedHashMap2;
            C13981a.m83989i("NotificationUtil", "showDisconnectNotify no permission!");
            m71166d(context, str3, "001_1015", "showDisconnectNotification no permission!", "01056", str6);
        }
        LinkedHashMap linkedHashMap3 = linkedHashMap;
        linkedHashMap3.put("gradeCode", C13452e.m80781L().m80790C());
        C13230i.m79504I().m79590k0("mecloud_findmyphone_notify_goods_disconnect", "2", "", C13452e.m80781L().m80971t0(), linkedHashMap3);
        UBAAnalyze.m29979g0("CKP", "mecloud_findmyphone_notify_goods_disconnect", "5", "101", "2", "", linkedHashMap3);
    }

    /* renamed from: o */
    public static void m71177o(Context context, String str, String str2, String str3, String str4, String str5, String str6, int i10, String str7, int i11) throws JSONException {
        C13981a.m83989i("NotificationUtil", "showFindLostNotification, deviceId: " + C9120m0.m57351R(str) + ", sceneId: " + str6 + ", deviceName: " + str3);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("perDeviceId", C9120m0.m57351R(str));
        if (C1009d.m6109e().m6118j(context)) {
            C13981a.m83989i("NotificationUtil", "showFindLostNotification has permission");
            StringBuilder sb2 = new StringBuilder(str6);
            boolean zM57307q = C9097b.m57307q(sb2, str7, i11);
            String strM71170h = m71170h(context, sb2.toString(), str3, zM57307q);
            String strM1593f = C0227m.m1593f(str);
            String string = context.getString(R$string.start_finder_phone_new);
            String strM71168f = TextUtils.isEmpty(str5) ? m71168f(context, sb2.toString(), str3, zM57307q, str4) : m71169g(context, sb2.toString(), str3, zM57307q, str4, str5);
            PendingIntent pendingIntentM71173k = m71173k(context, str2, m71174l(str, str7) + 101, i10);
            NotificationCompat.C0605b c0605b = new NotificationCompat.C0605b();
            c0605b.m3840i(strM71170h).m3839h(strM71168f);
            NotificationCompat.Builder builderM1666g = C0238w.m1663f().m1666g(context, string);
            Bundle bundle = new Bundle();
            bundle.putString("android.substName", string);
            bundle.putBoolean("hw_enable_small_icon", true);
            builderM1666g.m3824y(R$drawable.ic_findmyphone_new).m3811l(strM71170h).m3810k(strM71168f).m3821v(0).m3823x(true).m3817r("com.huawei.android.findphone").m3807h(true).m3825z(c0605b).m3809j(pendingIntentM71173k).m3803c(bundle);
            new PhoneFinderNotificationMgr(context).m26379d(strM1593f + str6, 570, builderM1666g.m3804d());
            m71166d(context, str, "0", "showFindLostNotification success!", "01055", str7);
        } else {
            C13981a.m83989i("NotificationUtil", "showFindLostNotification no permission");
            m71166d(context, str, "001_1015", "showFindLostNotification no permission!", "01055", str7);
        }
        linkedHashMap.put("gradeCode", C13452e.m80781L().m80790C());
        C13230i.m79504I().m79590k0("mecloud_findmyphone_notify_goods_connect", "2", "", C13452e.m80781L().m80971t0(), linkedHashMap);
        UBAAnalyze.m29979g0("CKP", "mecloud_findmyphone_notify_goods_connect", "2", "101", "2", "", linkedHashMap);
    }
}
