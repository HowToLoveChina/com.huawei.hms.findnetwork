package p227dg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.icu.util.Calendar;
import android.media.MediaPlayer;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.remotecontrol.alarm.TagLostBellDialogActivity;
import com.huawei.android.remotecontrol.sdk.R$raw;
import com.huawei.android.remotecontrol.track.C4452n;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0212e0;
import p015ak.C0213f;
import p237du.C9310c;
import p521og.C11872e;
import p521og.C11881n;
import p664u0.C13108a;
import p809yg.C13981a;
import se.C12785g;

/* renamed from: dg.b */
/* loaded from: classes4.dex */
public class C9097b {

    /* renamed from: a */
    public static int f45854a = 8;

    /* renamed from: b */
    public static MediaPlayer f45855b;

    /* renamed from: c */
    public static b f45856c;

    /* renamed from: d */
    public static String f45857d;

    /* renamed from: e */
    public static String f45858e;

    /* renamed from: f */
    public static String f45859f;

    /* renamed from: dg.b$b */
    public static class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws JSONException {
            String action = new SafeIntent(intent).getAction();
            C13981a.m83989i("TagBellUtil", "UnlockedBroadcastReceiver, action: " + action);
            if (action.equals("android.intent.action.USER_PRESENT")) {
                C9097b.m57316z(context, C9097b.f45857d, C9097b.f45858e, C9097b.f45859f, null);
            } else if (action.equals(Constants.VOLUME_CHANGED_ACTION)) {
                C9097b.m57310t(context);
            }
            C11872e.m71163a(context);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* renamed from: e */
    public static void m57295e() {
        C13981a.m83989i("TagBellUtil", "clearTagBellSP");
        C0212e0.m1351a(C0213f.m1377a(), "tag_lost_bell_sp");
    }

    /* renamed from: f */
    public static long m57296f() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(13, 0);
        calendar.set(12, 0);
        calendar.set(11, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    /* renamed from: g */
    public static String m57297g(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            C13981a.m83988e("TagBellUtil", "the deviceName is empty");
            return "";
        }
        String strM57300j = m57300j(context, str2, str, false);
        C13981a.m83989i("TagBellUtil", "getDeviceSceneName sceneName: " + strM57300j + ", deviceName: " + str);
        return TextUtils.isEmpty(strM57300j) ? str : strM57300j;
    }

    /* renamed from: h */
    public static String m57298h(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            C13981a.m83988e("TagBellUtil", "getDisplayName, modelId is empty");
            return "";
        }
        String strM57299i = m57299i();
        if (TextUtils.isEmpty(strM57299i)) {
            C13981a.m83988e("TagBellUtil", "getDisplayName, OM config is empty");
            return "";
        }
        C13981a.m83989i("TagBellUtil", "getDisplayName, modelId: " + str);
        try {
            JSONArray jSONArray = new JSONArray(strM57299i);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                if (str.equals(jSONObject.getString("ModelID"))) {
                    return jSONObject.optString(CommonConstant.KEY_DISPLAY_NAME);
                }
            }
        } catch (JSONException unused) {
            C13981a.m83988e("TagBellUtil", "getDisplayName JSONException!");
        }
        return "";
    }

    /* renamed from: i */
    public static String m57299i() {
        C13981a.m83989i("TagBellUtil", "getNearbyConfig");
        return C0212e0.m1363m(C0213f.m1377a(), "tag_lost_bell_sp", "tagLostBellEnable", "");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0047  */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m57300j(android.content.Context r12, java.lang.String r13, java.lang.String r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p227dg.C9097b.m57300j(android.content.Context, java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    /* renamed from: k */
    public static int m57301k(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            C13981a.m83988e("TagBellUtil", "modelId is empty");
            return 0;
        }
        String strM57299i = m57299i();
        if (TextUtils.isEmpty(strM57299i)) {
            C13981a.m83988e("TagBellUtil", "OM config is empty");
            return 0;
        }
        C13981a.m83989i("TagBellUtil", "getTabLocation, modelId: " + str);
        try {
            JSONArray jSONArray = new JSONArray(strM57299i);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                if (str.equals(jSONObject.getString("ModelID"))) {
                    return jSONObject.optInt("tabLocation", 0);
                }
            }
        } catch (JSONException unused) {
            C13981a.m83988e("TagBellUtil", "getTabLocation JSONException!");
        }
        return 0;
    }

    /* renamed from: l */
    public static long m57302l(String str) {
        return C0212e0.m1359i(C0213f.m1377a(), "tag_lost_bell_sp", "dialog_display_" + str, 0L);
    }

    /* renamed from: m */
    public static boolean m57303m(String str) {
        return C0212e0.m1354d(C0213f.m1377a(), "tag_lost_bell_sp", str, false);
    }

    /* renamed from: n */
    public static boolean m57304n(String str, String str2, String str3) {
        C13981a.m83989i("TagBellUtil", "isLostBellAlarm");
        if (C12785g.m76716u()) {
            C13981a.m83989i("TagBellUtil", "Device is alarming");
            return false;
        }
        if (!m57308r(str2, m57299i(), str3) || !m57303m(C9310c.m58618b(str)) || !m57303m("tagLostBellOMConfig")) {
            C13981a.m83989i("TagBellUtil", "isLostBellAlarm, lostBellStatus is false");
            return false;
        }
        if (System.currentTimeMillis() >= m57302l(C9310c.m58618b(str))) {
            return true;
        }
        C13981a.m83989i("TagBellUtil", "isLostBellAlarm, lostBellTimes is false");
        return false;
    }

    /* renamed from: o */
    public static boolean m57305o() {
        MediaPlayer mediaPlayer = f45855b;
        return mediaPlayer != null && mediaPlayer.isPlaying();
    }

    /* renamed from: p */
    public static boolean m57306p(JSONObject jSONObject, String str) throws JSONException {
        String strM71362l;
        C13981a.m83989i("TagBellUtil", "isMultiTypeLostBellEnable, sceneId: " + str);
        if (jSONObject == null || TextUtils.isEmpty(str) || !jSONObject.has("multiComponentScene")) {
            return false;
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("multiComponentScene");
            strM71362l = "";
            int i10 = 0;
            while (true) {
                if (i10 >= jSONArray.length()) {
                    break;
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                if (TextUtils.equals(str, C11881n.m71362l(jSONObject2, "sceneId"))) {
                    strM71362l = C11881n.m71362l(jSONObject2, "id");
                    break;
                }
                i10++;
            }
        } catch (JSONException unused) {
            C13981a.m83988e("TagBellUtil", "isOmConfigEnable JSONException!");
        } catch (Exception unused2) {
            C13981a.m83988e("TagBellUtil", "isOmConfigEnable Exception!");
        }
        if (TextUtils.isEmpty(strM71362l)) {
            return false;
        }
        JSONArray jSONArray2 = jSONObject.getJSONArray("multiFunction");
        for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
            JSONObject jSONObject3 = jSONArray2.getJSONObject(i11);
            if (TextUtils.equals(strM71362l, C11881n.m71362l(jSONObject3, "sceneId"))) {
                return C11881n.m71364n(jSONObject3, "lostBell") == 1;
            }
        }
        return false;
    }

    /* renamed from: q */
    public static boolean m57307q(StringBuilder sb2, String str, int i10) throws JSONException {
        C13981a.m83989i("TagBellUtil", "isNeedSceneName, sceneIdbuilder: " + sb2.toString() + ", standByDevice: " + C9120m0.m57355T(str) + ", componentType: " + i10);
        if (i10 != 1) {
            C13981a.m83990w("TagBellUtil", "isNeedSceneName, componentType is single");
            return false;
        }
        if (TextUtils.isEmpty(sb2.toString())) {
            C13981a.m83990w("TagBellUtil", "isNeedSceneName, the sceneId is null");
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            C13981a.m83990w("TagBellUtil", "isNeedSceneName, the standbyDevice is empty");
            return true;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() == 0) {
                return true;
            }
            int i11 = 0;
            for (int i12 = 0; i12 < jSONArray.length(); i12++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i12);
                if (jSONObject.getInt("status") == 1) {
                    sb2.append(SplitAppUtil.SPLIT_APP_SUFFIX);
                    sb2.append(jSONObject.getString(VastAttribute.SEQUENCE));
                    i11++;
                }
            }
            return i11 < jSONArray.length();
        } catch (JSONException e10) {
            C13981a.m83988e("TagBellUtil", "isNeedSceneName, parse standbyDevice exception:" + e10.getMessage());
            return false;
        }
    }

    /* renamed from: r */
    public static boolean m57308r(String str, String str2, String str3) throws JSONException {
        if (str2.equals("")) {
            C13981a.m83988e("TagBellUtil", "OM config is empty");
            return false;
        }
        C13981a.m83989i("TagBellUtil", "isOmConfigEnable, modelId: " + str + ", sceneId: " + str3);
        try {
            JSONArray jSONArray = new JSONArray(str2);
            if (str == null || str.isEmpty()) {
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    if ("OLD".equals(jSONArray.getJSONObject(i10).getString("ModelID"))) {
                        return jSONArray.getJSONObject(i10).getJSONObject("function").getInt("lostBell") == 1;
                    }
                }
            }
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                if (TextUtils.equals(str, jSONObject.getString("ModelID"))) {
                    return 1 == C11881n.m71364n(jSONObject, "multiComponentType") ? m57306p(jSONObject, str3) : C11881n.m71364n(jSONObject.getJSONObject("function"), "lostBell") == 1;
                }
            }
        } catch (JSONException unused) {
            C13981a.m83988e("TagBellUtil", "isOmConfigEnable JSONException!");
        } catch (Exception unused2) {
            C13981a.m83988e("TagBellUtil", "isOmConfigEnable Exception!");
        }
        return false;
    }

    /* renamed from: s */
    public static /* synthetic */ void m57309s(Context context, MediaPlayer mediaPlayer) throws IllegalStateException {
        try {
            if (f45854a > 0) {
                f45855b.start();
                f45854a--;
            } else {
                C13981a.m83989i("TagBellUtil", "lostBell auto end");
                C11872e.m71163a(context);
                f45854a = 8;
                C13108a.m78878b(context).m78881d(new Intent("com.huawei.hidisk.phone.finder.TAG.BELL.AUTO.END"));
            }
        } catch (Exception unused) {
            C13981a.m83988e("TagBellUtil", "lostBellStart Exception");
        }
    }

    /* renamed from: t */
    public static void m57310t(Context context) {
        C13981a.m83989i("TagBellUtil", "lostBellEnd");
        if (m57305o()) {
            f45855b.stop();
            f45855b.release();
            f45855b = null;
            f45854a = 8;
            C11872e.m71163a(context);
        } else {
            C13981a.m83989i("TagBellUtil", "lostBellEnd, lostBell already end");
        }
        b bVar = f45856c;
        if (bVar != null) {
            try {
                context.unregisterReceiver(bVar);
            } catch (IllegalArgumentException e10) {
                C13981a.m83988e("TagBellUtil", "unregisterReceiver, e: " + e10.getMessage());
            }
            f45856c = null;
        }
    }

    /* renamed from: u */
    public static void m57311u(final Context context) throws IllegalStateException {
        C13981a.m83989i("TagBellUtil", "lostBellStart");
        if (f45855b == null) {
            f45855b = MediaPlayer.create(context, R$raw.tag_lost_bell);
            C13981a.m83989i("TagBellUtil", "lostBellStart, mediaPlayer is create");
        }
        f45855b.start();
        f45855b.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: dg.a
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer) throws IllegalStateException {
                C9097b.m57309s(context, mediaPlayer);
            }
        });
    }

    /* renamed from: v */
    public static void m57312v(String str) {
        if (str.isEmpty()) {
            C13981a.m83988e("TagBellUtil", "saveNearbyConfig, nearbyConfig is null ");
        } else {
            C13981a.m83989i("TagBellUtil", "saveNearbyConfig");
            C0212e0.m1372v(C0213f.m1377a(), "tag_lost_bell_sp", "tagLostBellEnable", str);
        }
    }

    /* renamed from: w */
    public static void m57313w(String str, boolean z10) {
        C13981a.m83989i("TagBellUtil", "saveTagLostBellCloseTime, isClearRecord: " + z10);
        if (z10) {
            C0212e0.m1370t(C0213f.m1377a(), "tag_lost_bell_sp", "dialog_display_" + str, 0L);
            return;
        }
        C0212e0.m1370t(C0213f.m1377a(), "tag_lost_bell_sp", "dialog_display_" + str, m57296f() + 86400000);
    }

    /* renamed from: x */
    public static void m57314x(String str, boolean z10) {
        C0212e0.m1365o(C0213f.m1377a(), "tag_lost_bell_sp", str, z10);
    }

    /* renamed from: y */
    public static void m57315y(Context context, String str, String str2, String str3, String str4) throws IllegalStateException, JSONException {
        C13981a.m83989i("TagBellUtil", "tagLostBellAlarm");
        if (m57305o()) {
            C13981a.m83989i("TagBellUtil", "tagLostBellAlarm, lostBelling");
            return;
        }
        C4452n.m27035o(context, 5000L);
        m57311u(context);
        C9120m0.m57386f1(context, "mecloud_findmyphone_tag_lost_bell", str, str2, str3, 0, str4);
        if (!C4452n.m27030j(context)) {
            C13981a.m83989i("TagBellUtil", "tagLostBellAlarm, screen unlocked!");
            m57316z(context, str, str2, str3, str4);
            return;
        }
        C13981a.m83989i("TagBellUtil", "tagLostBellAlarm, screen locked!");
        f45857d = str;
        f45858e = str2;
        f45859f = str3;
        if (f45856c == null) {
            f45856c = new b();
        }
        IntentFilter intentFilter = new IntentFilter("android.intent.action.USER_PRESENT");
        intentFilter.addAction(Constants.VOLUME_CHANGED_ACTION);
        context.registerReceiver(f45856c, intentFilter);
        C11872e.m71164b(context, f45857d, f45858e, f45859f);
    }

    /* renamed from: z */
    public static void m57316z(Context context, String str, String str2, String str3, String str4) throws JSONException {
        C13981a.m83989i("TagBellUtil", "tagLostBellDialog");
        if (!m57305o()) {
            C13981a.m83989i("TagBellUtil", "tagLostBellDialog, lostBell end");
            return;
        }
        C9120m0.m57386f1(context, "mecloud_findmyphone_tag_lost_bell_dialog", str, str2, str3, 0, str4);
        Intent intent = new Intent(context, (Class<?>) TagLostBellDialogActivity.class);
        intent.putExtra("TagSN", str);
        intent.putExtra("itemName", str2);
        intent.putExtra("modelId", str3);
        intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        context.startActivity(intent);
    }
}
