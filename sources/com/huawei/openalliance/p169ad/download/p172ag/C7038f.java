package com.huawei.openalliance.p169ad.download.p172ag;

import android.content.Context;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7483mr;
import com.huawei.openalliance.p169ad.C7484ms;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.download.app.AppDownloadTask;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.ipc.CallResult;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7819dl;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.download.ag.f */
/* loaded from: classes2.dex */
public class C7038f {
    /* renamed from: a */
    private static AppInfo m42200a(AppDownloadTask appDownloadTask) {
        if (appDownloadTask == null || appDownloadTask.m42222B() == null) {
            return null;
        }
        AppInfo appInfo = new AppInfo();
        appInfo.m44371a(appDownloadTask.m42222B().getPackageName());
        appInfo.m44423q(appDownloadTask.m42222B().m44376b(appDownloadTask.m42226F()));
        appInfo.m44355H(appDownloadTask.m42228H());
        appInfo.m44425r(appDownloadTask.m42222B().m44366a());
        return appInfo;
    }

    /* renamed from: b */
    public static <T> void m42209b(Context context, AppDownloadTask appDownloadTask, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content", AbstractC7758be.m47742b(appDownloadTask));
            AppInfo appInfoM42200a = m42200a(appDownloadTask);
            if (appInfoM42200a != null) {
                jSONObject.put(MapKeyNames.APP_INFO, AbstractC7758be.m47742b(appInfoM42200a));
            }
            C7484ms.m45854a(context).m45855a("pauseDownloadApp", jSONObject.toString(), remoteCallResultCallback, cls);
        } catch (JSONException unused) {
            m42208a(remoteCallResultCallback, "pauseDownload JSONException", "pauseDownloadApp");
        }
    }

    /* renamed from: c */
    public static <T> void m42211c(Context context, AppDownloadTask appDownloadTask, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content", AbstractC7758be.m47742b(appDownloadTask));
            AppInfo appInfoM42200a = m42200a(appDownloadTask);
            if (appInfoM42200a != null) {
                jSONObject.put(MapKeyNames.APP_INFO, AbstractC7758be.m47742b(appInfoM42200a));
            }
            C7484ms.m45854a(context).m45855a("cancelDownloadApp", jSONObject.toString(), remoteCallResultCallback, cls);
        } catch (JSONException unused) {
            m42208a(remoteCallResultCallback, "cancelDownload JSONException", "cancelDownloadApp");
        }
    }

    /* renamed from: d */
    public static <T> void m42212d(Context context, AppDownloadTask appDownloadTask, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            String strM47742b = AbstractC7758be.m47742b(appDownloadTask);
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("ApDnApi", "appDownload=%s", strM47742b);
            }
            jSONObject.put("content", strM47742b);
            ContentRecord contentRecordM42239S = appDownloadTask.m42239S();
            if (contentRecordM42239S == null) {
                return;
            }
            m42204a(context, jSONObject, appDownloadTask, contentRecordM42239S);
            C7484ms.m45854a(context).m45855a("reserveDownloadApp", jSONObject.toString(), remoteCallResultCallback, cls);
        } catch (JSONException unused) {
            m42208a(remoteCallResultCallback, "startDownload JSONException", "reserveDownloadApp");
        }
    }

    /* renamed from: a */
    public static <T> T m42201a(Context context, AppInfo appInfo, Class<T> cls) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content", AbstractC7758be.m47742b(appInfo));
            return C7483mr.m45852a(context).m45853a("getDownloadStatus", jSONObject.toString(), cls).getData();
        } catch (JSONException unused) {
            AbstractC7185ho.m43823c("ApDnApi", "queryTask JSONException");
            return null;
        }
    }

    /* renamed from: b */
    public static <T> void m42210b(Context context, boolean z10, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MapKeyNames.HAS_INSTALL_PERMISSION, z10);
            C7484ms.m45854a(context).m45855a("reportInstallPermission", jSONObject.toString(), remoteCallResultCallback, cls);
        } catch (JSONException unused) {
            AbstractC7185ho.m43823c("ApDnApi", "reportInstallPermission JSONException");
        }
    }

    /* renamed from: a */
    public static <T> void m42202a(Context context, int i10, String str, String str2, Class<T> cls) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MapKeyNames.AG_PROTOCOL_STATUS, i10);
            jSONObject.put(MapKeyNames.AG_DOWNLOAD_PACKAGE, str);
            jSONObject.put(MapKeyNames.AG_ACTION_NAME, str2);
            C7483mr.m45852a(context).m45853a("syncAgProtocolStatus", jSONObject.toString(), cls);
        } catch (JSONException unused) {
            AbstractC7185ho.m43823c("ApDnApi", "syncAgProcolAgreeStatus JSONException");
        }
    }

    /* renamed from: a */
    public static <T> void m42203a(Context context, AppDownloadTask appDownloadTask, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            String strM47742b = AbstractC7758be.m47742b(appDownloadTask);
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("ApDnApi", "appDownload=%s", strM47742b);
            }
            jSONObject.put("content", strM47742b);
            ContentRecord contentRecordM42239S = appDownloadTask.m42239S();
            if (contentRecordM42239S != null) {
                m42204a(context, jSONObject, appDownloadTask, contentRecordM42239S);
                C7484ms.m45854a(context).m45855a("startFatDownloadApp", jSONObject.toString(), remoteCallResultCallback, cls);
                return;
            }
            AbstractC7185ho.m43820b("ApDnApi", "contentRecord is empty");
            AppInfo appInfoM42200a = m42200a(appDownloadTask);
            if (appInfoM42200a != null) {
                jSONObject.put(MapKeyNames.APP_INFO, AbstractC7758be.m47742b(appInfoM42200a));
            }
            C7484ms.m45854a(context).m45855a("resumeDownloadApp", jSONObject.toString(), remoteCallResultCallback, cls);
        } catch (JSONException unused) {
            m42208a(remoteCallResultCallback, "startDownload JSONException", "startFatDownloadApp");
        }
    }

    /* renamed from: a */
    private static void m42204a(Context context, JSONObject jSONObject, AppDownloadTask appDownloadTask, ContentRecord contentRecord) throws JSONException {
        String strM41532c = contentRecord.m41532c(context);
        jSONObject.put(MapKeyNames.PARAM_FROM_SERVER, strM41532c);
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("ApDnApi", "pfs:%s", AbstractC7819dl.m48375a(strM41532c));
        }
        String strM47742b = AbstractC7758be.m47742b(contentRecord.m41435a(context));
        jSONObject.put(MapKeyNames.THIRD_MONITORS, strM47742b);
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("ApDnApi", "monitors=%s", AbstractC7819dl.m48375a(strM47742b));
        }
        String strM47742b2 = AbstractC7758be.m47742b(contentRecord);
        jSONObject.put(MapKeyNames.CONTENT_RECORD, strM47742b2);
        AbstractC7185ho.m43820b("ApDnApi", "content:" + AbstractC7819dl.m48375a(strM47742b2));
        AppInfo appInfoM42222B = appDownloadTask.m42222B();
        String uniqueId = (appInfoM42222B == null || appInfoM42222B.getUniqueId() == null) ? "" : appInfoM42222B.getUniqueId();
        jSONObject.put("unique_id", uniqueId);
        AbstractC7185ho.m43817a("ApDnApi", "unique_id:" + uniqueId);
    }

    /* renamed from: a */
    public static <T> void m42205a(Context context, boolean z10, int i10, String str, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MapKeyNames.FULL_SCREEN_NOTIFY, z10);
            jSONObject.put(MapKeyNames.ACTIVATE_NOTIFY_STYLE, i10);
            jSONObject.put(MapKeyNames.PARAM_KEY, str);
            C7484ms.m45854a(context).m45855a("reportFullScreenNotify", jSONObject.toString(), remoteCallResultCallback, cls);
        } catch (JSONException unused) {
            AbstractC7185ho.m43823c("ApDnApi", "reportFullScreenNotify JSONException");
        }
    }

    /* renamed from: a */
    public static <T> void m42206a(Context context, boolean z10, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MapKeyNames.REMOTE_SHARED_PREF_KEY, "AutoOpenForbidden");
            jSONObject.put(MapKeyNames.REMOTE_SHARED_PREF_VALUE, z10);
            C7484ms.m45854a(context).m45855a("remoteSharedPrefSet", jSONObject.toString(), remoteCallResultCallback, cls);
        } catch (JSONException unused) {
            AbstractC7185ho.m43823c("ApDnApi", "setAutoOpenForbidden JSONException");
        }
    }

    /* renamed from: a */
    public static <T> void m42207a(Context context, boolean z10, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MapKeyNames.AUTO_OPEN, z10);
            C7483mr.m45852a(context).m45853a("setAutoOpen", jSONObject.toString(), cls);
        } catch (JSONException unused) {
            AbstractC7185ho.m43823c("ApDnApi", "setAutoOpenApp JSONException");
        }
    }

    /* renamed from: a */
    private static <T> void m42208a(RemoteCallResultCallback<T> remoteCallResultCallback, String str, String str2) {
        AbstractC7185ho.m43823c("ApDnApi", str);
        if (remoteCallResultCallback != null) {
            CallResult<T> callResult = new CallResult<>();
            callResult.setCode(-1);
            callResult.setMsg(str);
            remoteCallResultCallback.onRemoteCallResult(str2, callResult);
        }
    }
}
