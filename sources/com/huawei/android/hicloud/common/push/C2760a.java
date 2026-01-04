package com.huawei.android.hicloud.common.push;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.common.push.C2760a;
import com.huawei.feedback.mail.zip.p099sp.SharedPreferencesStorage;
import com.huawei.hicloud.bean.PushBody;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import com.huawei.hicloud.messagecenter.manager.MessageCenterReportUtil;
import com.huawei.hicloud.notification.HiCloudNotification;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.receiver.CommonNotifyReceiver;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.notification.util.PowerKitApplyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.basic.bean.UserDataStateInfo;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.secure.android.common.util.SafeBase64;
import gp.C10028c;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0240y;
import p015ak.C0241z;
import p020ap.C1006a;
import p020ap.C1007b;
import p020ap.C1008c;
import p020ap.C1009d;
import p020ap.C1010e;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p232dp.InterfaceC9284c;
import p232dp.InterfaceC9287f;
import p284fb.C9681b;
import p292fn.C9736i;
import p336he.C10155f;
import p431ko.C11079e;
import p474m9.C11432a;
import p514o9.C11829c;
import p514o9.C11839m;
import p616rk.C12515a;
import p664u0.C13108a;
import p674ub.C13152i;
import p684un.C13223b;
import p709vj.C13452e;
import p742wj.C13612b;
import p746wn.C13622a;
import p836z8.C14157f;

/* renamed from: com.huawei.android.hicloud.common.push.a */
/* loaded from: classes3.dex */
public class C2760a {
    /* renamed from: A */
    public static void m15738A(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("ProcessPushMessage", "DeviceToken is null, receive from PushAgent.");
            return;
        }
        C11839m.m70688i("ProcessPushMessage", "get push token successfully");
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            interfaceC9282a.mo58371H0(str);
        } else {
            C11839m.m70688i("ProcessPushMessage", "cloudAlbumRouter is null");
        }
        boolean z10 = !TextUtils.equals(C1010e.m6125b().m6153s(context), str);
        boolean zM6138d = C1010e.m6125b().m6138d(context);
        int iM6140f = C1010e.m6125b().m6140f(context);
        C11839m.m70688i("ProcessPushMessage", "processOnToken status:" + iM6140f + ", isOpen:" + zM6138d + ", changed:" + z10);
        Intent intent = new Intent();
        intent.setAction("com.huawei.hidisk.remotecontrol.intent.update.active.info");
        intent.putExtra("push_token", str);
        C13108a.m78878b(context.getApplicationContext()).m78881d(intent);
        if (zM6138d && z10) {
            C11839m.m70688i("ProcessPushMessage", "pushToken has changed,so update");
        } else if (-1 == iM6140f) {
            m15751N(context, str);
        } else {
            C1010e.m6125b().m6134I(context, false);
        }
    }

    /* renamed from: B */
    public static void m15739B(Context context, String str) {
        if (((C0241z.m1685c(C0240y.m1679a(context, NextRestoreConstants.PKG_NAME_FILE_MANAGER, "campaignTask")) >> 1) & 1) != 1) {
            C11839m.m70687e("ProcessPushMessage", "fileManager not support push msg");
            return;
        }
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(Uri.parse("content://com.huawei.hidisk.provider.cloudDiskProvider"));
        if (contentProviderClientAcquireUnstableContentProviderClient == null) {
            C11839m.m70687e("ProcessPushMessage", "processPushMsgToFileManager error: client is null");
            return;
        }
        try {
            try {
                contentProviderClientAcquireUnstableContentProviderClient.call("com.huawei.hidisk.provider.cloudDiskProvider", "pushMsgHiDiskFM", str, null);
            } catch (RemoteException e10) {
                C11839m.m70687e("ProcessPushMessage", "query cloud disk data error" + e10.getMessage());
            }
        } finally {
            contentProviderClientAcquireUnstableContentProviderClient.close();
        }
    }

    /* renamed from: C */
    public static void m15740C(Context context, String str) {
        if (context == null) {
            C11839m.m70688i("ProcessPushMessage", "processRemoteControlMessage context is null");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.huawei.hidisk.remotecontrol.intent.push.message");
        intent.putExtra("msg_data", str);
        InterfaceC9287f interfaceC9287f = (InterfaceC9287f) C1270a.m7534b().m7535a(InterfaceC9287f.class);
        if (interfaceC9287f == null) {
            C11839m.m70688i("ProcessPushMessage", "phoneFinderRouterImpl is null");
        } else {
            interfaceC9287f.mo58547J(context, intent);
        }
    }

    /* renamed from: D */
    public static void m15741D(String str) {
        try {
            if (m15754c(new JSONObject(str))) {
                C1009d.m6109e().m6122n(str);
            }
        } catch (Exception e10) {
            C11839m.m70687e("ProcessPushMessage", "processServerControlPushMsg exception: " + e10.toString());
        }
    }

    /* renamed from: E */
    public static void m15742E(Context context, String str) {
        try {
            if (m15754c(new JSONObject(str))) {
                C1006a.m5936k().m5946J(context, str);
            }
        } catch (Exception e10) {
            C11839m.m70687e("ProcessPushMessage", "processShareAlbumNotify exception: " + e10.toString());
        }
    }

    /* renamed from: F */
    public static void m15743F(Context context, String str) throws Throwable {
        C11839m.m70688i("ProcessPushMessage", "spaceChange: start ");
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(JsbMapKeyNames.H5_USER_ID) && !m15760i(jSONObject)) {
                String strOptString = jSONObject.optString("source");
                String strOptString2 = jSONObject.optString("x-hw-trace-id");
                String strOptString3 = jSONObject.optString("body");
                C13622a.m81964j(context, strOptString, 0, "", "03012", "local_receive_push", strOptString2);
                if (!m15754c(jSONObject)) {
                    C11839m.m70687e("ProcessPushMessage", "processSpaceChangeMessage, verify failed");
                    return;
                }
                m15753b(context, strOptString3);
                m15758g(context, str, 4100);
                m15764m();
                m15763l();
                m15762k();
                return;
            }
            C11839m.m70689w("ProcessPushMessage", "spaceChange: Do not need check push msg !");
        } catch (UnsupportedEncodingException e10) {
            C11839m.m70687e("ProcessPushMessage", "spaceChange support error: " + e10.toString());
        } catch (JSONException e11) {
            C11839m.m70687e("ProcessPushMessage", "spaceChange message error: " + e11.toString());
        }
    }

    /* renamed from: G */
    public static void m15744G(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (m15754c(jSONObject)) {
                C1008c.m6035v().m6088n(jSONObject.optString("body"));
            }
        } catch (Exception e10) {
            C11839m.m70687e("ProcessPushMessage", "processCloseAfterCloudClean exception: " + e10);
        }
    }

    /* renamed from: H */
    public static void m15745H(Context context, String str) {
        try {
            if (m15754c(new JSONObject(str))) {
                C1006a.m5936k().m5946J(context, str);
            }
        } catch (Exception e10) {
            C11839m.m70687e("ProcessPushMessage", "processSyncCloudAlbum exception: " + e10.toString());
        }
    }

    /* renamed from: I */
    public static void m15746I(Context context, String str) {
        if (context == null) {
            C11839m.m70688i("ProcessPushMessage", "processTagDisconnectNotify context is null");
            return;
        }
        try {
            if (!m15754c(new JSONObject(str))) {
                C11839m.m70687e("ProcessPushMessage", "processFindLostNotify signV2 failed");
                return;
            }
            Intent intent = new Intent();
            intent.setAction("com.huawei.hidisk.remotecontrol.intent.tag.disconnect.message");
            intent.putExtra("msg_data", str);
            C13108a.m78878b(context.getApplicationContext()).m78881d(intent);
        } catch (Exception e10) {
            C11839m.m70687e("ProcessPushMessage", "processTagDisconnectNotify exception: " + e10.toString());
        }
    }

    /* renamed from: J */
    public static void m15747J(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        C11839m.m70688i("ProcessPushMessage", "pushData=" + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(JsbMapKeyNames.H5_USER_ID) && !m15760i(jSONObject)) {
                C13622a.m81964j(context, jSONObject.optString("source"), 0, "", "03014", "local_receive_push", jSONObject.optString("x-hw-trace-id"));
                if (!m15754c(jSONObject)) {
                    C11839m.m70687e("ProcessPushMessage", "processSpaceChangeMessage, verify failed");
                    return;
                } else {
                    C13152i.m79070o().m79077F(jSONObject.optString("body"));
                    return;
                }
            }
            C11839m.m70689w("ProcessPushMessage", "processUrgencyMessage no userId or sign");
        } catch (UnsupportedEncodingException e10) {
            C11839m.m70687e("ProcessPushMessage", "spaceChange support error: " + e10.toString());
        } catch (JSONException e11) {
            C11839m.m70687e("ProcessPushMessage", "spaceChange message error: " + e11.toString());
        }
    }

    /* renamed from: K */
    public static void m15748K(Context context, String str) {
        C11839m.m70688i("ProcessPushMessage", "refreshFullDataListStatus");
        if (CloudBackupConstant.UserPackageInfo.BASE_DATA_SERVICE.equals(str)) {
            C1008c.m6035v().m6060Y(context, "push");
        }
        String strM80814I = C13452e.m80781L().m80814I();
        if (!CloudBackupConstant.UserPackageInfo.BASE_DATA_SERVICE.equals(strM80814I) || CloudBackupConstant.UserPackageInfo.BASE_DATA_SERVICE.equals(str)) {
            return;
        }
        List<String> listM6037B = C1008c.m6035v().m6037B(context);
        listM6037B.retainAll(((InterfaceC9284c) C1270a.m7534b().m7535a(InterfaceC9284c.class)).mo17148s());
        C11839m.m70688i("ProcessPushMessage", "refreshFullDataListStatus, grade: " + str + ",HisGrade: " + strM80814I + ",fullAppNames.size:" + listM6037B.size());
        if (listM6037B.size() < 1) {
            C1008c.m6035v().m6072f(context, "push");
            return;
        }
        for (String str2 : listM6037B) {
            if (!TextUtils.equals(str2, "atlas")) {
                int iM62286W = C10028c.m62182c0().m62286W(str2);
                boolean z10 = iM62286W != 0;
                C10028c.m62182c0().m62336h2(str2, z10);
                C11839m.m70688i("ProcessPushMessage", "setAutoListBackupOn appName: " + str2 + ", switchStatus:" + z10);
                if (z10) {
                    C11839m.m70688i("ProcessPushMessage", "refreshFullDataListStatus sendBroadcast");
                    Intent intent = new Intent();
                    intent.setAction("com.huawei.hicloud.action.ACTION_OPEN_FULL_SWITCH");
                    intent.putExtra("open_switch_app_name", str2);
                    C13108a.m78878b(context).m78881d(intent);
                }
                if (iM62286W == 2) {
                    C13223b.m79477e(context, NotifyUtil.HI_NOTE_SYNC_TYPE, z10, 1);
                    UBAAnalyze.m29975e0("PVC", "mecloud_main_click_" + str2, "1", "29", "1", "1", 2, 1);
                }
            }
        }
        C1008c.m6035v().m6072f(context, "push");
    }

    /* renamed from: L */
    public static void m15749L() {
        C13108a.m78878b(C0213f.m1377a()).m78881d(new Intent("com.huawei.hicloud.intent.action.ACTION_GRADE_CODE_PUSH"));
    }

    /* renamed from: M */
    public static void m15750M(Context context, String str) {
        C13612b.m81829B().m81869j0(context, str);
        C13612b.m81829B().m81868i0(context, System.currentTimeMillis());
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, SharedPreferencesStorage.BACKUPOPTION_SPFILE, 0);
        if (sharedPreferencesM1382b != null) {
            sharedPreferencesM1382b.edit().putLong("last_report_push_token_time", System.currentTimeMillis()).apply();
        }
    }

    /* renamed from: N */
    public static void m15751N(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            C11839m.m70688i("ProcessPushMessage", "pushRegistration parameter is invalid");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("push_token", str);
        intent.setAction("com.huawei.remotecontrol.intent.action.REGISTRATION");
        C13108a.m78878b(context.getApplicationContext()).m78881d(intent);
    }

    /* renamed from: b */
    public static void m15753b(Context context, String str) {
        C11839m.m70688i("ProcessPushMessage", "checkPushMembershipLevel, body:" + str);
        if (str == null) {
            return;
        }
        try {
            PushBody pushBody = (PushBody) new Gson().fromJson(str, PushBody.class);
            String bmType = pushBody.getBmType();
            String grade = pushBody.getGrade();
            C13452e.m80781L().m80940l1(grade);
            C13452e.m80781L().m80985w2("1".equals(bmType));
            if (pushBody.getFromRegretDay() == 1) {
                C13452e.m80781L().m80981v2(true);
                C13452e.m80781L().m80883Z1(System.currentTimeMillis());
            }
            C11839m.m70688i("ProcessPushMessage", "autoShutdown bmType: " + bmType + ", gradeCode: " + grade);
            if (C13452e.m80781L().m80887a1()) {
                m15748K(context, grade);
                C13452e.m80781L().m80918g2(grade);
                C1008c.m6035v().m6051P(context, null, true);
            }
            m15749L();
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("ProcessPushMessage", "autoShutdown json exception is: " + e10.toString());
        }
    }

    /* renamed from: c */
    public static boolean m15754c(JSONObject jSONObject) throws UnsupportedEncodingException {
        int iOptInt = jSONObject.optInt(CommonNotifyReceiver.COMMAND_KEY, 0);
        String strOptString = jSONObject.optString("body");
        String strOptString2 = jSONObject.optString("source");
        String strOptString3 = jSONObject.optString(JsbMapKeyNames.H5_USER_ID);
        return m15756e(jSONObject, iOptInt + strOptString2 + strOptString3 + strOptString, jSONObject.optString(HwPayConstant.KEY_SIGN), strOptString3);
    }

    /* renamed from: d */
    public static boolean m15755d(String str, String str2, String str3, String str4) throws InvalidKeySpecException, NoSuchAlgorithmException, SignatureException, InvalidKeyException, UnsupportedEncodingException {
        if (TextUtils.isEmpty(str2)) {
            C11839m.m70689w("ProcessPushMessage", "checkSign: sync is empty");
            return false;
        }
        boolean zM70518G1 = C11829c.m70518G1(str.getBytes("utf-8"), C11829c.m70566c0(str2), C11829c.m70566c0(str3));
        boolean zM70602o0 = C11829c.m70602o0(str4);
        C11839m.m70688i("ProcessPushMessage", "checkSign: verify=" + zM70518G1 + ", isCurrentUser=" + zM70602o0);
        return zM70518G1 && zM70602o0;
    }

    /* renamed from: e */
    public static boolean m15756e(JSONObject jSONObject, String str, String str2, String str3) throws UnsupportedEncodingException {
        boolean zM15757f;
        if (jSONObject != null) {
            C11839m.m70688i("ProcessPushMessage", "checkSignCompatible");
            Context contextM1377a = C0213f.m1377a();
            zM15757f = jSONObject.has("signV2") ? m15757f(str, C9736i.m60781c().m60784d(contextM1377a, "syncV2"), jSONObject.optString("signV2"), str3) : m15755d(str, C9736i.m60781c().m60784d(contextM1377a, "sync"), str2, str3);
        } else {
            zM15757f = false;
        }
        C11839m.m70688i("ProcessPushMessage", "checkSignCompatible result:" + zM15757f);
        return zM15757f;
    }

    /* renamed from: f */
    public static boolean m15757f(String str, String str2, String str3, String str4) throws InvalidKeySpecException, NoSuchAlgorithmException, SignatureException, InvalidKeyException, UnsupportedEncodingException {
        if (TextUtils.isEmpty(str2)) {
            C11839m.m70689w("ProcessPushMessage", "checkSignV2: syncV2 is empty");
            return false;
        }
        boolean zM70521H1 = C11829c.m70521H1(str.getBytes("utf-8"), C11829c.m70566c0(str2), C11829c.m70566c0(str3));
        boolean zM70602o0 = C11829c.m70602o0(str4);
        C11839m.m70688i("ProcessPushMessage", "checkSignV2: verify=" + zM70521H1 + ", isCurrentUser=" + zM70602o0);
        return zM70521H1 && zM70602o0;
    }

    /* renamed from: g */
    public static void m15758g(Context context, String str, int i10) {
        if (!C10155f.m63259L(context)) {
            C11839m.m70687e("ProcessPushMessage", "dealPushMessage, user is unlocked, ignore push message");
            return;
        }
        if (context == null) {
            C11839m.m70688i("ProcessPushMessage", "dealPushMessage context is null");
            return;
        }
        InterfaceC9284c interfaceC9284c = (InterfaceC9284c) C1270a.m7534b().m7535a(InterfaceC9284c.class);
        if (interfaceC9284c == null) {
            C11839m.m70688i("ProcessPushMessage", "cloudSyncRouterImpl is null");
        } else if (interfaceC9284c.mo17084C0(context)) {
            C11839m.m70688i("ProcessPushMessage", "hasSyncSwitchOn deal pushReceiveMsg");
            interfaceC9284c.mo17122f(context, str, i10);
        }
    }

    /* renamed from: h */
    public static void m15759h(Context context, String str) throws Throwable {
        try {
            JSONObject jSONObject = new JSONObject(str);
            C11839m.m70686d("ProcessPushMessage", "receive msg from cloud.msg:" + jSONObject.toString());
            int iOptInt = jSONObject.optInt(CommonNotifyReceiver.COMMAND_KEY, 0);
            C11839m.m70688i("ProcessPushMessage", "Receive push message, command = " + iOptInt);
            C1007b.m5980s().m5987G(str);
            if (iOptInt == 0) {
                m15740C(context, str);
            } else if (iOptInt > 100 && iOptInt <= 200) {
                m15765n(jSONObject, context, str);
            } else if (300 == iOptInt) {
                m15770s(str);
            } else if (301 == iOptInt) {
                m15739B(context, str);
                m15741D(str);
            } else if (303 == iOptInt) {
                m15743F(context, str);
            } else if (304 == iOptInt) {
                m15747J(context, str);
            } else if (305 == iOptInt) {
                m15772u(context, str);
            } else if (306 == iOptInt) {
                m15768q(str);
            } else if (307 == iOptInt) {
                m15745H(context, str);
            } else if (308 == iOptInt) {
                m15774w(context, str);
            } else if (310 == iOptInt) {
                m15776y(context, str);
            } else if (312 == iOptInt) {
                m15771t(context, str);
            } else if (314 == iOptInt) {
                m15775x(str);
            } else if (315 == iOptInt) {
                m15742E(context, str);
            } else if (316 == iOptInt) {
                m15746I(context, str);
            } else if (319 == iOptInt) {
                m15739B(context, str);
                m15767p(context, str);
            } else if (320 == iOptInt) {
                m15769r(context, str);
                m15739B(context, str);
            } else if (321 == iOptInt) {
                m15744G(str);
            } else {
                m15773v(context, str);
            }
        } catch (JSONException e10) {
            C11839m.m70687e("ProcessPushMessage", "push message error: " + e10.toString());
        }
    }

    /* renamed from: i */
    public static boolean m15760i(JSONObject jSONObject) {
        return (jSONObject == null || jSONObject.has(HwPayConstant.KEY_SIGN) || jSONObject.has("signV2")) ? false : true;
    }

    /* renamed from: j */
    public static /* synthetic */ void m15761j(Context context, UserDataStateInfo userDataStateInfo) {
        if (userDataStateInfo == null) {
            return;
        }
        C13452e.m80781L().m80940l1(userDataStateInfo.getBsGrade());
        if (C13452e.m80781L().m80791C0()) {
            HiCloudNotification.getInstance().sendDataRetentionNotify(context, userDataStateInfo.getDataRetentionDays() > -1 ? userDataStateInfo.getDataRetentionDays() : 30);
        } else {
            C11839m.m70687e("ProcessPushMessage", "DataRetentionNotify but not basic user");
        }
    }

    /* renamed from: k */
    public static void m15762k() {
        Intent intent = new Intent();
        intent.setAction("com.huawei.cloud.pay.action.updatespace");
        C13108a.m78878b(C0213f.m1377a()).m78881d(intent);
    }

    /* renamed from: l */
    public static void m15763l() {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            interfaceC9282a.mo58434i1();
        } else {
            C11839m.m70687e("ProcessPushMessage", "cloudAlbumRouter is null");
        }
    }

    /* renamed from: m */
    public static void m15764m() throws Throwable {
        C14157f.m84942g().m84957t();
    }

    /* renamed from: n */
    public static void m15765n(JSONObject jSONObject, Context context, String str) {
        if (!jSONObject.has(JsbMapKeyNames.H5_USER_ID) || m15760i(jSONObject)) {
            C11839m.m70688i("ProcessPushMessage", "Album do not need check push msg !");
            C1006a.m5936k().m5945I(context, str);
            return;
        }
        try {
            String strOptString = jSONObject.optString(JsbMapKeyNames.H5_USER_ID);
            boolean zM15766o = m15766o(jSONObject, C9736i.m60781c().m60784d(context, "syncV2"), C9736i.m60781c().m60784d(context, PowerKitApplyUtil.GROUP_ALBUM));
            boolean zM70602o0 = C11829c.m70602o0(strOptString);
            if (zM15766o && zM70602o0) {
                C1006a.m5936k().m5945I(context, str);
            }
        } catch (UnsupportedEncodingException e10) {
            C11839m.m70687e("ProcessPushMessage", "album message error: " + e10.toString());
        }
    }

    /* renamed from: o */
    public static boolean m15766o(JSONObject jSONObject, String str, String str2) throws UnsupportedEncodingException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C11839m.m70689w("ProcessPushMessage", "processAlbumVerify: syncV2 or album is empty");
            return false;
        }
        if (jSONObject == null) {
            return false;
        }
        String strOptString = jSONObject.optString(JsbMapKeyNames.H5_USER_ID);
        String strOptString2 = jSONObject.optString("info");
        int iOptInt = jSONObject.optInt(CommonNotifyReceiver.COMMAND_KEY, 0);
        String strOptString3 = jSONObject.optString(HwPayConstant.KEY_SIGN);
        byte[] bytes = (iOptInt + strOptString2 + strOptString).getBytes("utf-8");
        if (!jSONObject.has("signV2")) {
            return C11829c.m70518G1(bytes, C11829c.m70566c0(str2), C11829c.m70566c0(strOptString3));
        }
        return C11829c.m70521H1(bytes, C11829c.m70566c0(str), C11829c.m70566c0(jSONObject.optString("signV2")));
    }

    /* renamed from: p */
    public static void m15767p(Context context, String str) {
        try {
            if (m15754c(new JSONObject(str))) {
                C1008c.m6035v().m6086m(context, "push");
                C1006a.m5936k().m5961g();
            }
        } catch (Exception e10) {
            C11839m.m70687e("ProcessPushMessage", "processCloseAfterCloudClean exception: " + e10);
        }
    }

    /* renamed from: q */
    public static void m15768q(String str) {
        C11839m.m70688i("ProcessPushMessage", "processComplimentaryPackage pushData = " + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (m15754c(jSONObject)) {
                C1007b.m5980s().m6002V(new JSONObject(jSONObject.optString("body")).optString("requestId"));
            }
        } catch (Exception e10) {
            C11839m.m70687e("ProcessPushMessage", "processComplimentaryPackage exception: " + e10.toString());
        }
    }

    /* renamed from: r */
    public static void m15769r(final Context context, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("bs.grade");
        arrayList.add("bs.userdata.overdue.days");
        C12515a.m75110o().m75172d(new C11079e(new C11079e.a() { // from class: h9.a
            @Override // p431ko.C11079e.a
            /* renamed from: a */
            public final void mo14511a(UserDataStateInfo userDataStateInfo) {
                C2760a.m15761j(context, userDataStateInfo);
            }
        }, true, arrayList, "dateRetentionNotify"));
    }

    /* renamed from: s */
    public static void m15770s(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (m15754c(jSONObject)) {
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString("body"));
                int iOptInt = jSONObject2.optInt("type");
                String strOptString = jSONObject2.optString(FamilyShareConstants.Push.KEY_NICK_NAME);
                long jOptLong = jSONObject2.optLong(FamilyShareConstants.Push.KEY_PACKAGE_CAPACITY);
                if (iOptInt == 2) {
                    C9681b.m60470l().m60504y(strOptString, jOptLong);
                } else if (iOptInt == 1 || iOptInt == 4) {
                    C9681b.m60470l().m60505z(strOptString, jOptLong);
                } else if (iOptInt == 5) {
                    C9681b.m60470l().m60471A();
                }
            }
        } catch (Exception e10) {
            C11839m.m70687e("ProcessPushMessage", "processFamilySharePushMsg exception: " + e10.toString());
        }
    }

    /* renamed from: t */
    public static void m15771t(Context context, String str) {
        if (context == null) {
            C11839m.m70688i("ProcessPushMessage", "processFindLostNotify context is null");
            return;
        }
        try {
            if (!m15754c(new JSONObject(str))) {
                C11839m.m70687e("ProcessPushMessage", "processFindLostNotify signV2 failed");
                return;
            }
            Intent intent = new Intent();
            intent.setAction("com.huawei.hidisk.remotecontrol.intent.find.lost.message");
            intent.putExtra("msg_data", str);
            C13108a.m78878b(context.getApplicationContext()).m78881d(intent);
        } catch (Exception e10) {
            C11839m.m70687e("ProcessPushMessage", "processFindLostNotify exception: " + e10.toString());
        }
    }

    /* renamed from: u */
    public static void m15772u(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(JsbMapKeyNames.H5_USER_ID) && !m15760i(jSONObject)) {
                C13622a.m81964j(context, jSONObject.optString("source"), 0, "", "03013", "local_receive_push", jSONObject.optString("x-hw-trace-id"));
                if (!m15754c(jSONObject)) {
                    C11839m.m70687e("ProcessPushMessage", "processHiCloudDataAnalyze, verify failed");
                    return;
                } else {
                    C11432a.m68479d().m68487h(new JSONObject(jSONObject.optString("body")).optString("clientLogReport"));
                    return;
                }
            }
            C11839m.m70689w("ProcessPushMessage", "processHiCloudDataAnalyze: Do not need check push msg !");
        } catch (UnsupportedEncodingException e10) {
            C11839m.m70687e("ProcessPushMessage", "processHiCloudDataAnalyze support error: " + e10.toString());
        } catch (JSONException e11) {
            C11839m.m70687e("ProcessPushMessage", "processHiCloudDataAnalyzeort message error: " + e11.toString());
        }
    }

    /* renamed from: v */
    public static void m15773v(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(JsbMapKeyNames.H5_USER_ID) && !m15760i(jSONObject)) {
                C13622a.m81964j(context, jSONObject.optString("source"), 0, "", "03002", "local_receive_push", jSONObject.optString("x-hw-trace-id"));
                if (m15754c(jSONObject)) {
                    m15758g(context, str, 4099);
                    return;
                } else {
                    C11839m.m70687e("ProcessPushMessage", "processHiSyncMessage, verify failed");
                    return;
                }
            }
            C11839m.m70688i("ProcessPushMessage", "HiSync do not need check push msg !");
            m15758g(context, str, 4099);
        } catch (UnsupportedEncodingException e10) {
            C11839m.m70687e("ProcessPushMessage", "processHiSyncMessage: support error: " + e10.toString());
        } catch (JSONException e11) {
            C11839m.m70687e("ProcessPushMessage", "hisync message error: " + e11.toString());
        }
    }

    /* renamed from: w */
    public static void m15774w(Context context, String str) {
        if (context == null) {
            C11839m.m70688i("ProcessPushMessage", "processLocationShareMessage context is null");
            return;
        }
        try {
            if (!m15754c(new JSONObject(str))) {
                C11839m.m70687e("ProcessPushMessage", "processLocationShareMessage signV2 failed");
                return;
            }
            Intent intent = new Intent();
            intent.setAction("com.huawei.hidisk.remotecontrol.intent.location.share.message");
            intent.putExtra("msg_data", str);
            C13108a.m78878b(context.getApplicationContext()).m78881d(intent);
        } catch (Exception e10) {
            C11839m.m70687e("ProcessPushMessage", "processLocationShareMessage exception: " + e10.toString());
        }
    }

    /* renamed from: x */
    public static void m15775x(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!m15754c(jSONObject)) {
                MessageCenterReportUtil.reportMsgProcInterrupted("push_sign_check_failed");
            } else {
                C1009d.m6109e().m6121m(new String(SafeBase64.decode(jSONObject.optString("body"), 2), StandardCharsets.UTF_8));
            }
        } catch (Exception e10) {
            C11839m.m70687e("ProcessPushMessage", "processMessageCenterMessage exception: " + e10.toString());
        }
    }

    /* renamed from: y */
    public static void m15776y(Context context, String str) {
        if (context == null) {
            C11839m.m70688i("ProcessPushMessage", "processOfflineLocateMessage context is null");
            return;
        }
        try {
            if (!m15754c(new JSONObject(str))) {
                C11839m.m70687e("ProcessPushMessage", "processOfflineLocateMessage signV2 failed");
                return;
            }
            Intent intent = new Intent();
            intent.setAction("com.huawei.hidisk.remotecontrol.intent.offline.locate.message");
            intent.putExtra("msg_data", str);
            C13108a.m78878b(context.getApplicationContext()).m78881d(intent);
        } catch (Exception e10) {
            C11839m.m70687e("ProcessPushMessage", "processOfflineLocateMessage exception: " + e10.toString());
        }
    }

    /* renamed from: z */
    public static void m15777z(Context context, String str) throws Throwable {
        m15759h(context, str);
    }
}
