package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.p169ad.constant.ConfigMapKeys;
import com.huawei.openalliance.p169ad.constant.RTCMethods;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.p171db.bean.SdkCfgSha256Record;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.tm */
/* loaded from: classes8.dex */
public class C7691tm {
    /* renamed from: a */
    public static void m47256a(final Context context, final C7692tn c7692tn) {
        if (c7692tn == null) {
            return;
        }
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.tm.2
            @Override // java.lang.Runnable
            public void run() throws JSONException {
                try {
                    String strMo43070b = C7124fh.m43316b(context).mo43070b(ConfigMapKeys.REDIRECTION_APP_LIST, "");
                    AbstractC7185ho.m43818a("DcServiceCmdManager", "redirectionAppList from configMap : %s", strMo43070b);
                    List<String> listM48157a = AbstractC7806cz.m48157a(strMo43070b, ",");
                    if (!AbstractC7760bg.m47767a(listM48157a) && listM48157a.contains(c7692tn.m47264d())) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("dc_service_cmd", 10001);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(ContentRecord.TASK_ID, c7692tn.m47263c());
                        jSONObject2.put("contentId", c7692tn.m47261b());
                        jSONObject2.put(SdkCfgSha256Record.PKGNAME, c7692tn.m47264d());
                        jSONObject2.put("activityName", c7692tn.m47265e());
                        jSONObject2.put("triggerTime", System.currentTimeMillis());
                        AbstractC7185ho.m43818a("DcServiceCmdManager", "send direction match record : %s", jSONObject2.toString());
                        jSONObject.put(RemoteMessageConst.MessageBody.PARAM, jSONObject2);
                        C7691tm.m47257a(context, jSONObject);
                        return;
                    }
                    AbstractC7185ho.m43818a("DcServiceCmdManager", "%s is not in app list", c7692tn.m47264d());
                } catch (JSONException e10) {
                    AbstractC7185ho.m43827d("DcServiceCmdManager", "json exception sendRedirectionMatchRecord : %s", e10.getClass().getSimpleName());
                }
            }
        });
    }

    /* renamed from: a */
    public static void m47257a(Context context, JSONObject jSONObject) {
        C7484ms.m45854a(context).m45855a(RTCMethods.DC_BRIDGE, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.tm.1
            /* JADX WARN: Removed duplicated region for block: B:12:0x001a A[Catch: all -> 0x0018, TryCatch #0 {all -> 0x0018, blocks: (B:4:0x0004, B:6:0x000c, B:9:0x0014, B:12:0x001a), top: B:18:0x0004 }] */
            @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onRemoteCallResult(java.lang.String r1, com.huawei.openalliance.p169ad.ipc.CallResult<java.lang.String> r2) {
                /*
                    r0 = this;
                    java.lang.String r0 = "DcServiceCmdManager"
                    if (r2 == 0) goto L1a
                    int r1 = r2.getCode()     // Catch: java.lang.Throwable -> L18
                    r2 = 200(0xc8, float:2.8E-43)
                    if (r1 != r2) goto L1a
                    boolean r1 = com.huawei.openalliance.p169ad.AbstractC7185ho.m43819a()     // Catch: java.lang.Throwable -> L18
                    if (r1 == 0) goto L34
                    java.lang.String r1 = "query DC_BRIDGE from hms success!"
                L14:
                    com.huawei.openalliance.p169ad.AbstractC7185ho.m43817a(r0, r1)     // Catch: java.lang.Throwable -> L18
                    goto L34
                L18:
                    r1 = move-exception
                    goto L23
                L1a:
                    boolean r1 = com.huawei.openalliance.p169ad.AbstractC7185ho.m43819a()     // Catch: java.lang.Throwable -> L18
                    if (r1 == 0) goto L34
                    java.lang.String r1 = "failed to query DC_BRIDGE from hms"
                    goto L14
                L23:
                    java.lang.Class r1 = r1.getClass()
                    java.lang.String r1 = r1.getSimpleName()
                    java.lang.Object[] r1 = new java.lang.Object[]{r1}
                    java.lang.String r2 = "get DC_BRIDGE from hms err : %s"
                    com.huawei.openalliance.p169ad.AbstractC7185ho.m43827d(r0, r2, r1)
                L34:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.C7691tm.AnonymousClass1.onRemoteCallResult(java.lang.String, com.huawei.openalliance.ad.ipc.CallResult):void");
            }
        }, String.class);
    }
}
