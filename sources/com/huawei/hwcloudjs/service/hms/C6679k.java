package com.huawei.hwcloudjs.service.hms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.api.HuaweiApiClientImpl;
import com.huawei.hms.support.api.client.BundleResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.hwid.SignInResult;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.huawei.hwcloudjs.core.JsCallback;
import com.huawei.hwcloudjs.p164f.C6659d;
import com.huawei.hwcloudjs.service.hms.C6668a;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hwcloudjs.service.hms.k */
/* loaded from: classes8.dex */
public class C6679k {

    /* renamed from: a */
    private static final String f30969a = "HmsCoreApiHelper";

    /* renamed from: b */
    private static final int f30970b = 9004;

    /* renamed from: c */
    public static final int f30971c = 9003;

    /* renamed from: d */
    public static final int f30972d = 1;

    /* renamed from: com.huawei.hwcloudjs.service.hms.k$a */
    public static final class a implements C6668a.c {

        /* renamed from: a */
        private String f30973a;

        /* renamed from: b */
        private JsCallback f30974b;

        public a(String str, JsCallback jsCallback) {
            this.f30973a = str;
            this.f30974b = jsCallback;
        }

        @Override // com.huawei.hwcloudjs.service.hms.C6668a.c
        /* renamed from: a */
        public void mo37934a(C6668a.b bVar) throws JSONException {
            Bundle extras;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(MapKeyNames.RESULT_CODE, bVar.m37954c());
            } catch (JSONException unused) {
                C6659d.m37881b(C6679k.f30969a, "getResultFromActivityResult put json error", true);
            }
            Intent intentM37949a = bVar.m37949a();
            if (intentM37949a != null && (extras = intentM37949a.getExtras()) != null) {
                C6688t c6688tM37992a = C6689u.m37992a(2);
                JSONObject jSONObject2 = new JSONObject();
                c6688tM37992a.m37989a(this.f30973a, extras, jSONObject2);
                try {
                    jSONObject.put("result", jSONObject2);
                } catch (JSONException unused2) {
                    C6659d.m37881b(C6679k.f30969a, "InvokeResultCallback onResult JSONException", true);
                    this.f30974b.failure();
                }
            }
            this.f30974b.success(jSONObject.toString());
        }
    }

    /* renamed from: com.huawei.hwcloudjs.service.hms.k$b */
    public static final class b implements HuaweiApiClient.OnConnectionFailedListener {

        /* renamed from: a */
        private WeakReference<HuaweiApiClient> f30975a;

        /* renamed from: b */
        private JsCallback f30976b;

        /* renamed from: c */
        private WeakReference<Activity> f30977c;

        /* renamed from: com.huawei.hwcloudjs.service.hms.k$b$a */
        public static final class a implements C6668a.c {

            /* renamed from: a */
            private static final String f30978a = "intent.extra.RESULT";

            /* renamed from: b */
            private WeakReference<HuaweiApiClient> f30979b;

            /* renamed from: c */
            private WeakReference<Activity> f30980c;

            /* renamed from: d */
            private JsCallback f30981d;

            public a(WeakReference<HuaweiApiClient> weakReference, WeakReference<Activity> weakReference2, JsCallback jsCallback) {
                this.f30979b = weakReference;
                this.f30980c = weakReference2;
                this.f30981d = jsCallback;
            }

            @Override // com.huawei.hwcloudjs.service.hms.C6668a.c
            /* renamed from: a */
            public void mo37934a(C6668a.b bVar) throws JSONException {
                Intent intentM37949a;
                int intExtra = -1;
                if (bVar != null && bVar.m37954c() == -1 && (intentM37949a = bVar.m37949a()) != null) {
                    intExtra = intentM37949a.getIntExtra("intent.extra.RESULT", -1);
                }
                C6659d.m37881b(C6679k.f30969a, "ConnFailResult result:" + intExtra, true);
                if (intExtra == 0) {
                    HuaweiApiClient huaweiApiClient = this.f30979b.get();
                    if (huaweiApiClient == null || huaweiApiClient.isConnecting() || huaweiApiClient.isConnected()) {
                        return;
                    }
                    C6659d.m37882c(C6679k.f30969a, "ConnFailResult connect", true);
                    WeakReference<Activity> weakReference = this.f30980c;
                    huaweiApiClient.connect(weakReference != null ? weakReference.get() : null);
                    return;
                }
                String str = intExtra + "";
                C6659d.m37881b(C6679k.f30969a, "ConnFailResult onConnectionFailed" + str, true);
                this.f30981d.failure(str);
            }
        }

        public b(WeakReference<HuaweiApiClient> weakReference, JsCallback jsCallback, WeakReference<Activity> weakReference2) {
            this.f30975a = weakReference;
            this.f30976b = jsCallback;
            this.f30977c = weakReference2;
        }

        @Override // com.huawei.hms.api.HuaweiApiClient.OnConnectionFailedListener
        public void onConnectionFailed(ConnectionResult connectionResult) throws JSONException {
            int errorCode = connectionResult.getErrorCode();
            HuaweiApiAvailability huaweiApiAvailability = HuaweiApiAvailability.getInstance();
            if (huaweiApiAvailability.isUserResolvableError(errorCode)) {
                C6659d.m37881b(C6679k.f30969a, "InvokeResultCallback onConnectionFailed REQUEST_CODE_CONN_ERROR", true);
                C6668a.m37944a().m37945a(9004, new a(this.f30975a, this.f30977c, this.f30976b));
                new Handler(Looper.getMainLooper()).post(new RunnableC6680l(this, huaweiApiAvailability, errorCode));
                return;
            }
            String str = errorCode + "";
            C6659d.m37881b(C6679k.f30969a, "InvokeResultCallback onConnectionFailed errorCode:" + str, true);
            this.f30976b.failure(str);
        }
    }

    /* renamed from: com.huawei.hwcloudjs.service.hms.k$c */
    public static final class c implements HuaweiApiClient.ConnectionCallbacks {

        /* renamed from: a */
        private WeakReference<HuaweiApiClient> f30982a;

        /* renamed from: b */
        private JsCallback f30983b;

        /* renamed from: c */
        private String f30984c;

        /* renamed from: d */
        private JSONObject f30985d;

        public c(WeakReference<HuaweiApiClient> weakReference, JsCallback jsCallback, String str, JSONObject jSONObject) {
            this.f30982a = weakReference;
            this.f30983b = jsCallback;
            this.f30984c = str;
            this.f30985d = jSONObject;
        }

        @Override // com.huawei.hms.api.HuaweiApiClient.ConnectionCallbacks
        public void onConnected() {
            C6679k.m37964a(this.f30982a, this.f30984c, this.f30985d, this.f30983b);
        }

        @Override // com.huawei.hms.api.HuaweiApiClient.ConnectionCallbacks
        public void onConnectionSuspended(int i10) {
        }
    }

    /* renamed from: com.huawei.hwcloudjs.service.hms.k$d */
    public static final class d implements ResultCallback<BundleResult> {

        /* renamed from: a */
        private WeakReference<HuaweiApiClient> f30986a;

        /* renamed from: b */
        private JsCallback f30987b;

        public d(WeakReference<HuaweiApiClient> weakReference, JsCallback jsCallback) {
            this.f30986a = weakReference;
            this.f30987b = jsCallback;
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(BundleResult bundleResult) throws JSONException {
            HuaweiApiClient huaweiApiClient = this.f30986a.get();
            if (huaweiApiClient == null) {
                this.f30987b.failure();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("statusCode", bundleResult.getResultCode());
                if (bundleResult.getRspBody() != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    C6689u.m37992a(2).m37989a(huaweiApiClient.getAppID(), bundleResult.getRspBody(), jSONObject2);
                    jSONObject.put("result", jSONObject2);
                }
                this.f30987b.success(jSONObject.toString());
            } catch (JSONException unused) {
                C6659d.m37881b(C6679k.f30969a, "InvokeResultCallback JSONException", true);
                this.f30987b.failure();
            }
        }
    }

    /* renamed from: a */
    public static String m37962a(SignInResult signInResult, boolean z10) throws JSONException {
        String familyName;
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            if (z10) {
                familyName = signInResult.getAuthHuaweiId().getAuthorizationCode();
                str = "serverAuthCode";
            } else {
                jSONObject.put("openId", signInResult.getAuthHuaweiId().getOpenId());
                jSONObject.put("accessToken", signInResult.getAuthHuaweiId().getAccessToken());
                jSONObject.put(CommonConstant.KEY_DISPLAY_NAME, signInResult.getAuthHuaweiId().getDisplayName());
                jSONObject.put("photoUrl", signInResult.getAuthHuaweiId().getAvatarUriString());
                jSONObject.put(CommonConstant.KEY_UNION_ID, signInResult.getAuthHuaweiId().getUnionId());
                jSONObject.put("email", signInResult.getAuthHuaweiId().getEmail());
                jSONObject.put(CommonConstant.KEY_GIVEN_NAME, signInResult.getAuthHuaweiId().getGivenName());
                familyName = signInResult.getAuthHuaweiId().getFamilyName();
                str = CommonConstant.KEY_FAMILY_NAME;
            }
            jSONObject.put(str, familyName);
        } catch (JSONException unused) {
            C6659d.m37881b(f30969a, "signInRes2Json put json error", true);
        }
        return jSONObject.toString();
    }

    /* renamed from: a */
    public static void m37963a(String str, JsCallback jsCallback) {
        C6668a.m37944a().m37945a(9003, new a(str, jsCallback));
    }

    /* renamed from: a */
    public static void m37964a(WeakReference<HuaweiApiClient> weakReference, String str, JSONObject jSONObject, JsCallback jsCallback) {
        HuaweiApiClient huaweiApiClient = weakReference.get();
        if (huaweiApiClient == null || !(huaweiApiClient instanceof HuaweiApiClientImpl)) {
            jsCallback.failure();
        } else {
            ((HuaweiApiClientImpl) huaweiApiClient).asyncRequest(C6689u.m37992a(2).m37988a(jSONObject, new Bundle()), str, 2, new d(weakReference, jsCallback));
        }
    }

    /* renamed from: a */
    public static boolean m37965a(List<Scope> list, List<Scope> list2) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (Scope scope : list) {
                if (scope != null && !arrayList.contains(scope.getScopeUri())) {
                    arrayList.add(scope.getScopeUri());
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        if (list2 != null) {
            for (Scope scope2 : list2) {
                if (scope2 != null && !arrayList2.contains(scope2.getScopeUri())) {
                    arrayList2.add(scope2.getScopeUri());
                }
            }
        }
        Collections.sort(arrayList);
        Collections.sort(arrayList2);
        return arrayList.equals(arrayList2);
    }
}
