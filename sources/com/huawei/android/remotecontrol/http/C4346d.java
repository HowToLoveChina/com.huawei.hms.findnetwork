package com.huawei.android.remotecontrol.http;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.huawei.hicloud.request.notify.constant.NotifyErr;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import p521og.C11877j;
import p809yg.C13981a;

/* renamed from: com.huawei.android.remotecontrol.http.d */
/* loaded from: classes4.dex */
public class C4346d {
    /* renamed from: a */
    public static String m26222a(String str, Context context) {
        C13981a.m83989i("HttpRequestThread", "addActiveCredentialDomain");
        String strM71269h = C11877j.m71269h();
        if (TextUtils.isEmpty(strM71269h)) {
            return m26223b(str, context);
        }
        return strM71269h + str;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003f A[Catch: b -> 0x003d, TRY_LEAVE, TryCatch #0 {b -> 0x003d, blocks: (B:5:0x0028, B:7:0x002e, B:9:0x0034, B:12:0x003f), top: B:22:0x0028 }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m26223b(java.lang.String r5, android.content.Context r6) {
        /*
            java.lang.String r0 = "addSiteIdIntoUrl"
            java.lang.String r1 = "HttpRequestThread"
            p809yg.C13981a.m83989i(r1, r0)
            vj.e r0 = p709vj.C13452e.m80781L()
            boolean r0 = r0.m80842P0()
            boolean r2 = bf.C1175a.m7389k(r6)
            com.huawei.android.remotecontrol.util.account.bean.AccountInfo r6 = pg.AbstractC12139d.m72766e(r6)
            java.lang.String r6 = r6.getCountryCode()
            vj.e r3 = p709vj.C13452e.m80781L()
            java.lang.String r3 = r3.m80942m()
            r4 = 0
            if (r0 == 0) goto L3f
            if (r2 == 0) goto L3f
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch: fk.C9721b -> L3d
            if (r0 != 0) goto L3f
            boolean r6 = r6.equals(r3)     // Catch: fk.C9721b -> L3d
            if (r6 != 0) goto L3f
            tm.c r6 = tm.C13040c.m78609F()     // Catch: fk.C9721b -> L3d
            java.lang.String r6 = r6.m78623O()     // Catch: fk.C9721b -> L3d
            goto L61
        L3d:
            r6 = move-exception
            goto L48
        L3f:
            tm.c r6 = tm.C13040c.m78609F()     // Catch: fk.C9721b -> L3d
            java.lang.String r6 = r6.m78622N()     // Catch: fk.C9721b -> L3d
            goto L61
        L48:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "cannot get phoneFinder address from grs: "
            r0.append(r2)
            java.lang.String r6 = r6.getMessage()
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            p809yg.C13981a.m83988e(r1, r6)
            r6 = r4
        L61:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "domain is "
            r0.append(r2)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            p809yg.C13981a.m83987d(r1, r0)
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L81
            java.lang.String r5 = "domain is empty"
            p809yg.C13981a.m83988e(r1, r5)
            return r4
        L81:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r6)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.remotecontrol.http.C4346d.m26223b(java.lang.String, android.content.Context):java.lang.String");
    }

    /* renamed from: c */
    public static String m26224c(String str, Context context) {
        C13981a.m83989i("HttpRequestThread", "addSiteIdIntoUrlRedirection");
        String strM71275j = C11877j.m71275j(context);
        if (TextUtils.isEmpty(strM71275j)) {
            return m26223b(str, context);
        }
        return strM71275j + str;
    }

    /* renamed from: d */
    public static void m26225d(int i10, String str, Handler.Callback callback, Context context) {
        m26226e(i10, str, callback, context, null);
    }

    /* renamed from: e */
    public static void m26226e(int i10, String str, Handler.Callback callback, Context context, String str2) {
        m26227f(i10, str, callback, context, str2, null);
    }

    /* renamed from: f */
    public static void m26227f(int i10, String str, Handler.Callback callback, Context context, String str2, C4348f c4348f) {
        C13981a.m83989i("HttpRequestThread", "HttpRequestThread doHttpRequest with traceID start:" + i10);
        String strM26229h = m26229h(i10, context);
        if (strM26229h == null) {
            C13981a.m83988e("HttpRequestThread", "doHttpRequest->url is null");
        }
        new C4345c(str, callback, context, strM26229h, str2, i10).m26221c(c4348f);
    }

    /* renamed from: g */
    public static String m26228g(int i10, Context context) {
        if (i10 == 3032) {
            return m26223b("/RemoteControl/peripheralpushReport", context);
        }
        if (i10 == 3112) {
            return m26224c("/RemoteControl/Client/ActivationLock/Check", context);
        }
        switch (i10) {
            case 3080:
                return m26223b("/RemoteControl/QueryPerDevice", context);
            case 3081:
                return m26223b("/RemoteControl/ClientPeripheralActive", context);
            case 3082:
                return m26223b("/RemoteControl/ClientPeripheralUpdate", context);
            default:
                return null;
        }
    }

    /* renamed from: h */
    public static String m26229h(int i10, Context context) {
        if (i10 == 3) {
            return m26224c("/RemoteControl/PushResultReport", context);
        }
        if (i10 == 4) {
            return m26223b("/RemoteControl/PushResultReport/Share", context);
        }
        if (i10 == 3015 || i10 == 3016 || i10 == 3019) {
            return m26224c("/RemoteControl/Unbinding", context);
        }
        if (i10 == 3020) {
            return m26224c("/RemoteControl/StopLostPattern", context);
        }
        if (i10 != 3030 && i10 != 3031) {
            switch (i10) {
                case SNSCode.Status.GET_GROUP_LIST_FAIL /* 3003 */:
                    return m26224c("/RemoteControl/ClientActive", context);
                case SNSCode.Status.GET_USER_UNREAD_MSG_FAIL /* 3008 */:
                    return m26224c("/RemoteControl/ClientGetParameter", context);
                case SNSCode.Status.ADD_FRIEND_FAILED /* 3011 */:
                    return m26224c("/RemoteControl/ClientPutCapability", context);
                case 3036:
                case 3040:
                case 3043:
                case 3047:
                case 3050:
                case 3053:
                case 3057:
                case 3060:
                case 3063:
                    break;
                case 3083:
                    return m26223b("/RemoteControl/ClientRefreshDT", context);
                case NotifyErr.NOTIFY_MALFORMEDURL /* 3102 */:
                    return m26224c("/RemoteControl/ClientTAKeyGet", context);
                case 3107:
                    break;
                case 3111:
                    return m26222a("/RemoteControl/ClientUpdate", context);
                case 3113:
                    return m26222a("/RemoteControl/ClientGetParameter", context);
                default:
                    switch (i10) {
                        case 3071:
                            return m26224c("/RemoteControl/QueryCmdInfo", context);
                        case 3072:
                            return m26224c("/RemoteControl/Trackreport", context);
                        case 3073:
                            return m26224c("/RemoteControl/ClientAsyncQueryPushInfo", context);
                        case 3074:
                            break;
                        default:
                            return m26228g(i10, context);
                    }
            }
            return m26224c("/RemoteControl/ClientUpdate", context);
        }
        return m26223b("/RemoteControl/Control4Portal", context);
    }
}
