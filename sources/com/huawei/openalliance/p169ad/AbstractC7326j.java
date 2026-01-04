package com.huawei.openalliance.p169ad;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hms.ads.data.SearchInfo;
import com.huawei.hms.ads.jsb.inner.data.JsbCallBackData;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.TemplateData;
import com.huawei.openalliance.p169ad.beans.parameter.App;
import com.huawei.openalliance.p169ad.beans.parameter.RequestOptions;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.ipc.CallResult;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.p171db.bean.ContentTemplateRecord;
import com.huawei.openalliance.p169ad.p171db.bean.EncryptionField;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.j */
/* loaded from: classes8.dex */
public abstract class AbstractC7326j implements InterfaceC7143g {

    /* renamed from: a */
    protected String f34112a;

    /* renamed from: b */
    protected String f34113b;

    /* renamed from: c */
    protected String f34114c;

    /* renamed from: d */
    private final byte[] f34115d = new byte[0];

    /* renamed from: e */
    private WeakReference<Activity> f34116e;

    public AbstractC7326j(String str) {
        this.f34112a = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0040  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hms.ads.data.SearchInfo m45218b(org.json.JSONObject r11) {
        /*
            r10 = this;
            r10 = 0
            if (r11 == 0) goto L82
            java.lang.String r0 = "searchQry"
            java.lang.String r0 = r11.optString(r0)
            java.lang.String r1 = "searchKwsType"
            java.lang.String r1 = r11.optString(r1)
            java.lang.String r2 = "searchKwsKW"
            java.lang.String r2 = r11.optString(r2)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 != 0) goto L65
            java.lang.String r4 = ","
            java.lang.String[] r2 = r2.split(r4)
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            r6 = 0
            if (r5 != 0) goto L3a
            java.lang.String[] r4 = r1.split(r4)
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L38
            goto L3b
        L38:
            int r1 = r4.length
            goto L3c
        L3a:
            r4 = r10
        L3b:
            r1 = r6
        L3c:
            r5 = r6
        L3d:
            int r7 = r2.length
            if (r5 >= r7) goto L65
            r7 = r2[r5]
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L62
            com.huawei.hms.ads.data.Keyword r7 = new com.huawei.hms.ads.data.Keyword
            int r8 = r5 + 1
            if (r1 < r8) goto L59
            r8 = r4[r5]
            int r8 = com.huawei.openalliance.p169ad.utils.AbstractC7806cz.m48145a(r8, r6)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            goto L5a
        L59:
            r8 = r10
        L5a:
            r9 = r2[r5]
            r7.<init>(r8, r9)
            r3.add(r7)
        L62:
            int r5 = r5 + 1
            goto L3d
        L65:
            java.lang.String r1 = "searchChnl"
            java.lang.String r11 = r11.optString(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L7d
            boolean r1 = r3.isEmpty()
            if (r1 == 0) goto L7d
            boolean r1 = android.text.TextUtils.isEmpty(r11)
            if (r1 != 0) goto L82
        L7d:
            com.huawei.hms.ads.data.SearchInfo r10 = new com.huawei.hms.ads.data.SearchInfo
            r10.<init>(r0, r3, r11)
        L82:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.AbstractC7326j.m45218b(org.json.JSONObject):com.huawei.hms.ads.data.SearchInfo");
    }

    /* renamed from: i */
    public static boolean m45220i(String str) {
        return !AbstractC7806cz.m48165b(str) && AbstractC7806cz.m48145a(str.trim(), -111111) >= 10000301;
    }

    /* renamed from: a */
    public Context m45221a(Context context) {
        Activity activity;
        synchronized (this.f34115d) {
            try {
                WeakReference<Activity> weakReference = this.f34116e;
                if (weakReference == null || (activity = weakReference.get()) == null) {
                    return context;
                }
                AbstractC7185ho.m43818a("BaseJsbCmd", "cur activity: %s, hash code: %s", activity.getClass(), Integer.valueOf(activity.hashCode()));
                return activity;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: c */
    public RequestOptions m45226c(Context context, String str) {
        RequestOptions.Builder builder = new RequestOptions.Builder();
        m45212a(context, str, builder);
        return builder.build();
    }

    /* renamed from: d */
    public Integer m45227d(String str) {
        int iOptInt = new JSONObject(str).optInt("source", -111111);
        if (iOptInt != -111111) {
            return Integer.valueOf(iOptInt);
        }
        return null;
    }

    /* renamed from: e */
    public String m45228e(String str) {
        String strOptString = new JSONObject(str).optString(MapKeyNames.CREATIVE_SIZE, "");
        if (!AbstractC7806cz.m48187p(strOptString)) {
            strOptString = null;
        }
        AbstractC7185ho.m43821b("BaseJsbCmd", "getCreativeSize: %s", strOptString);
        return strOptString;
    }

    /* renamed from: f */
    public MaterialClickInfo m45229f(String str) {
        JSONObject jSONObject = new JSONObject(str);
        int iOptInt = jSONObject.optInt(MapKeyNames.CLICK_X, -111111);
        Integer numValueOf = Integer.valueOf(iOptInt);
        int iOptInt2 = jSONObject.optInt(MapKeyNames.CLICK_Y, -111111);
        Integer numValueOf2 = Integer.valueOf(iOptInt2);
        String strOptString = jSONObject.optString(MapKeyNames.CREATIVE_SIZE, "");
        Float fM48147a = AbstractC7806cz.m48147a(jSONObject.optString(MapKeyNames.DENSITY, "-111111"), Float.valueOf(-111111.0f));
        int iOptInt3 = jSONObject.optInt(MapKeyNames.UP_X, -111111);
        Integer numValueOf3 = Integer.valueOf(iOptInt3);
        int iOptInt4 = jSONObject.optInt(MapKeyNames.UP_Y, -111111);
        Integer numValueOf4 = Integer.valueOf(iOptInt4);
        int iOptInt5 = jSONObject.optInt(MapKeyNames.SLD, -111111);
        Integer numValueOf5 = Integer.valueOf(iOptInt5);
        long jOptLong = jSONObject.optLong(MapKeyNames.CLICK_DOWN_TIME);
        Long lValueOf = Long.valueOf(jOptLong);
        long jOptLong2 = jSONObject.optLong(MapKeyNames.CLICK_UP_TIME);
        Long lValueOf2 = Long.valueOf(jOptLong2);
        String strOptString2 = jSONObject.optString(MapKeyNames.SHAKE_ANGLE, "");
        if (iOptInt == -111111) {
            numValueOf = null;
        }
        if (iOptInt2 == -111111) {
            numValueOf2 = null;
        }
        if (!AbstractC7806cz.m48187p(strOptString)) {
            strOptString = null;
        }
        if (fM48147a.floatValue() == -111111.0f) {
            fM48147a = null;
        }
        if (iOptInt3 == -111111) {
            numValueOf3 = null;
        }
        if (iOptInt4 == -111111) {
            numValueOf4 = null;
        }
        if (iOptInt5 == -111111) {
            numValueOf5 = null;
        }
        if (jOptLong == 0) {
            lValueOf = null;
        }
        Long l10 = jOptLong2 == 0 ? null : lValueOf2;
        if (AbstractC7806cz.m48165b(strOptString2)) {
            strOptString2 = null;
        }
        return new MaterialClickInfo.C7296a().m44532a(numValueOf).m44536b(numValueOf2).m44538b(strOptString).m44539c(numValueOf5).m44531a(fM48147a).m44540d(numValueOf3).m44541e(numValueOf4).m44537b(lValueOf).m44533a(l10).m44534a(strOptString2).m44535a();
    }

    /* renamed from: g */
    public Location m45230g(String str) {
        JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject(JsbMapKeyNames.H5_LOC);
        if (jSONObjectOptJSONObject == null) {
            return null;
        }
        String strOptString = jSONObjectOptJSONObject.optString(JsbMapKeyNames.H5_LOC_LAT);
        String strOptString2 = jSONObjectOptJSONObject.optString(JsbMapKeyNames.H5_LOC_LON);
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || !Pattern.matches(Constants.LOC_PATTERN, strOptString) || !Pattern.matches(Constants.LOC_PATTERN, strOptString2)) {
            return null;
        }
        Location location = new Location("");
        location.setLatitude(new BigDecimal(strOptString).doubleValue());
        location.setLongitude(new BigDecimal(strOptString2).doubleValue());
        return location;
    }

    /* renamed from: h */
    public boolean m45231h(String str) {
        try {
            if (AbstractC7806cz.m48165b(str)) {
                return false;
            }
            return Integer.parseInt(str.trim()) >= 10000300;
        } catch (Throwable th2) {
            AbstractC7185ho.m43827d("H5Ad", "isSupportImpCtrl() exception: %s", th2.getClass().getSimpleName());
            return false;
        }
    }

    /* renamed from: a */
    private App m45211a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("name");
        String strOptString2 = jSONObject.optString("version");
        String strOptString3 = jSONObject.optString(JsbMapKeyNames.H5_APP_PKGNAME);
        String strOptString4 = jSONObject.optString(JsbMapKeyNames.H5_APP_HOSTPKGNAME);
        if (TextUtils.isEmpty(strOptString) && TextUtils.isEmpty(strOptString3) && TextUtils.isEmpty(strOptString2) && TextUtils.isEmpty(strOptString4)) {
            return null;
        }
        return new App(strOptString3, strOptString, strOptString2, strOptString4);
    }

    /* renamed from: c */
    private Map<String, Bundle> m45219c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map map = (Map) AbstractC7758be.m47739b(str, Map.class, Map.class);
        AbstractC7185ho.m43818a("BaseJsbCmd", "extras: %s", str);
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap map2 = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (entry != null) {
                Bundle bundle = new Bundle();
                String str2 = (String) entry.getKey();
                for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                    if (entry2 != null) {
                        bundle.putString((String) entry2.getKey(), (String) entry2.getValue());
                    }
                }
                map2.put(str2, bundle);
            }
        }
        return map2;
    }

    /* renamed from: b */
    public ContentRecord m45224b(Context context, String str) {
        ContentRecord contentRecordMo43098a;
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("contentId");
        String strOptString2 = jSONObject.optString("slotid");
        String strOptString3 = jSONObject.optString("templateId", "");
        int iOptInt = jSONObject.optInt("apiVer", 2);
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
            if (TextUtils.isEmpty(strOptString)) {
                AbstractC7185ho.m43823c("BaseJsbCmd", "content id is null");
                contentRecordMo43098a = null;
            } else {
                contentRecordMo43098a = C7103es.m43094a(context).mo43098a(strOptString);
            }
        } else if (iOptInt == 3) {
            contentRecordMo43098a = C7104et.m43127b(context).mo43102a(strOptString, strOptString3, strOptString2);
            ContentTemplateRecord contentTemplateRecordMo43146a = C7106ev.m43144a(context).mo43146a(contentRecordMo43098a.m41588n(), contentRecordMo43098a.m41463aO());
            if (contentTemplateRecordMo43146a != null) {
                contentRecordMo43098a.m41584l(contentTemplateRecordMo43146a.m41646c());
                contentRecordMo43098a.m41477aa(contentTemplateRecordMo43146a.m41650g());
                contentRecordMo43098a.m41440a(new TemplateData(contentTemplateRecordMo43146a.m41647d(), contentTemplateRecordMo43146a.m41648e(), contentTemplateRecordMo43146a.m41649f()));
            }
        } else {
            contentRecordMo43098a = C7103es.m43094a(context).mo43100a(strOptString, strOptString2);
        }
        m45214a(contentRecordMo43098a, str);
        return contentRecordMo43098a;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public AbstractC7834m.a mo43561a() {
        return AbstractC7834m.a.IO;
    }

    /* renamed from: b */
    public void m45225b(RemoteCallResultCallback<String> remoteCallResultCallback, boolean z10) {
        m45216a(remoteCallResultCallback, this.f34112a, 1000, "ok", z10);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public Object mo43562a(Context context, String str) {
        AbstractC7185ho.m43823c("BaseJsbCmd", "direct call is not implemented!");
        throw new IllegalStateException("direct call is not implemented!");
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: b */
    public void mo43565b(String str) {
        this.f34114c = str;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo43563a(Activity activity) {
        synchronized (this.f34115d) {
            if (activity != null) {
                try {
                    this.f34116e = new WeakReference<>(activity);
                    AbstractC7185ho.m43818a("BaseJsbCmd", "cur activity: %s, hash code: %s", activity.getClass(), Integer.valueOf(activity.hashCode()));
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* renamed from: a */
    private void m45212a(Context context, String str, RequestOptions.Builder builder) {
        JSONObject jSONObject = new JSONObject(str);
        int iOptInt = jSONObject.optInt(JsbMapKeyNames.H5_BRAND, -111111);
        boolean zOptBoolean = jSONObject.optBoolean(JsbMapKeyNames.H5_APPINSTALLEDNOTIFY, true);
        int iOptInt2 = jSONObject.optInt(JsbMapKeyNames.H5_APPACTIVATESTYLE, 0);
        Integer numValueOf = Integer.valueOf(iOptInt2);
        boolean zOptBoolean2 = jSONObject.optBoolean(JsbMapKeyNames.H5_APPAUTOOPENFORBIDDEN, false);
        String strOptString = jSONObject.optString(JsbMapKeyNames.H5_BELONG_COUNTRY);
        if (-111111 != iOptInt) {
            HiAd.getInstance(context).setBrand(iOptInt);
        }
        HiAd.getInstance(context).setAppInstalledNotify(zOptBoolean);
        AbstractC7185ho.m43821b("BaseJsbCmd", "appActivateStyle: %s", numValueOf);
        if (iOptInt2 != 0) {
            HiAd.getInstance(context).setAppActivateStyle(iOptInt2);
        }
        HiAd.getInstance(context).setAppAutoOpenForbidden(zOptBoolean2);
        if (!TextUtils.isEmpty(strOptString)) {
            HiAd.getInstance(context).setCountryCode(strOptString);
        }
        if (builder != null) {
            m45213a(builder, jSONObject);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo38573a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        AbstractC7185ho.m43823c("BaseJsbCmd", "async execute is not implemented!");
        throw new IllegalStateException("async execute is not implemented!");
    }

    /* renamed from: a */
    private void m45213a(RequestOptions.Builder builder, JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt(JsbMapKeyNames.H5_CHILD_PROTECTION_TAG, -111111);
        Integer numValueOf = Integer.valueOf(iOptInt);
        int iOptInt2 = jSONObject.optInt(JsbMapKeyNames.H5_QUE, -111111);
        Integer numValueOf2 = Integer.valueOf(iOptInt2);
        int iOptInt3 = jSONObject.optInt(JsbMapKeyNames.H5_UNDER_AGE_OF_PROMISE_TAG, -111111);
        Integer numValueOf3 = Integer.valueOf(iOptInt3);
        int iOptInt4 = jSONObject.optInt(JsbMapKeyNames.H5_NPA, -111111);
        Integer numValueOf4 = Integer.valueOf(iOptInt4);
        int iOptInt5 = jSONObject.optInt(JsbMapKeyNames.HW_DSP_NPA, -111111);
        Integer numValueOf5 = Integer.valueOf(iOptInt5);
        int iOptInt6 = jSONObject.optInt(JsbMapKeyNames.THIRD_DSP_NPA, -111111);
        Integer numValueOf6 = Integer.valueOf(iOptInt6);
        String strOptString = jSONObject.optString(JsbMapKeyNames.H5_AD_CONTENT_CLASSIFICATION);
        Boolean boolValueOf = Boolean.valueOf(jSONObject.optBoolean(JsbMapKeyNames.H5_REQUESTLOCATION, true));
        String strOptString2 = jSONObject.optString(JsbMapKeyNames.H5_CONSENT);
        String strOptString3 = jSONObject.optString(JsbMapKeyNames.H5_SEARCHTERM);
        String strOptString4 = jSONObject.optString(JsbMapKeyNames.H5_APPLANG);
        String strOptString5 = jSONObject.optString(JsbMapKeyNames.H5_APPCOUNTRY);
        Map<String, Bundle> mapM45219c = m45219c(jSONObject.optString(JsbMapKeyNames.H5_EXTRAS));
        App appM45211a = m45211a(jSONObject.optJSONObject("app"));
        SearchInfo searchInfoM45218b = m45218b(jSONObject.optJSONObject(JsbMapKeyNames.H5_SEARCHINFO));
        if (!jSONObject.isNull(JsbMapKeyNames.H5_USE_CONSENT_NPA)) {
            builder.setUseConsentNpa(jSONObject.optBoolean(JsbMapKeyNames.H5_USE_CONSENT_NPA));
        }
        if (-111111 != iOptInt) {
            builder.setTagForChildProtection(numValueOf);
        }
        if (-111111 != iOptInt3) {
            builder.setTagForUnderAgeOfPromise(numValueOf3);
        }
        if (!TextUtils.isEmpty(strOptString)) {
            builder.setAdContentClassification(strOptString);
        }
        if (-111111 != iOptInt2) {
            builder.setIsQueryUseEnabled(numValueOf2);
        }
        if (-111111 != iOptInt4) {
            builder.setNonPersonalizedAd(numValueOf4);
        }
        if (-111111 != iOptInt5) {
            builder.setHwNonPersonalizedAd(numValueOf5);
        }
        if (-111111 != iOptInt6) {
            builder.setThirdNonPersonalizedAd(numValueOf6);
        }
        if (!TextUtils.isEmpty(strOptString2)) {
            builder.setConsent(strOptString2);
        }
        if (!TextUtils.isEmpty(strOptString3)) {
            builder.setSearchTerm(strOptString3);
        }
        builder.setRequestLocation(boolValueOf);
        if (appM45211a != null) {
            builder.setApp(appM45211a);
        }
        if (!TextUtils.isEmpty(strOptString4)) {
            builder.setAppLang(strOptString4);
        }
        if (!TextUtils.isEmpty(strOptString5)) {
            builder.setAppCountry(strOptString5);
        }
        if (mapM45219c != null) {
            builder.setExtras(mapM45219c);
        }
        if (searchInfoM45218b != null) {
            builder.setSearchInfo(searchInfoM45218b);
        }
    }

    /* renamed from: a */
    private void m45214a(ContentRecord contentRecord, String str) {
        if (contentRecord != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String strOptString = TextUtils.isEmpty(jSONObject.optString(JsbMapKeyNames.H5_SHOW_ID)) ? "" : jSONObject.optString(JsbMapKeyNames.H5_SHOW_ID);
                if (!TextUtils.isEmpty(strOptString)) {
                    contentRecord.m41536c(strOptString);
                }
                if (!TextUtils.isEmpty(jSONObject.optString("requestId"))) {
                    contentRecord.m41618y(jSONObject.optString("requestId"));
                }
                long jOptLong = jSONObject.optLong(JsbMapKeyNames.START_SHOW_TIME);
                Long lValueOf = Long.valueOf(jOptLong);
                if (jOptLong == 0) {
                    lValueOf = Long.valueOf(AbstractC7806cz.m48146a(strOptString, 0L));
                }
                if (lValueOf.longValue() != 0) {
                    contentRecord.m41560g(lValueOf.longValue());
                }
                String strOptString2 = jSONObject.optString(JsbMapKeyNames.H5_CUSTOM_DATA);
                String strOptString3 = jSONObject.optString(JsbMapKeyNames.H5_USER_ID);
                String strOptString4 = jSONObject.optString("adId");
                if (strOptString2 != null) {
                    contentRecord.m41396G(strOptString2);
                }
                if (strOptString3 != null) {
                    contentRecord.m41398H(strOptString3);
                }
                if (TextUtils.isEmpty(strOptString4)) {
                    return;
                }
                contentRecord.m41612v(strOptString4);
            } catch (Throwable unused) {
                AbstractC7185ho.m43823c("BaseJsbCmd", "update content failed");
            }
        }
    }

    /* renamed from: a */
    public static void m45215a(RemoteCallResultCallback<String> remoteCallResultCallback, String str, int i10, JsbCallBackData jsbCallBackData) {
        if (remoteCallResultCallback != null) {
            CallResult<String> callResult = new CallResult<>();
            callResult.setCode(i10);
            try {
                callResult.setData(AbstractC7758be.m47742b(jsbCallBackData));
            } catch (Throwable th2) {
                AbstractC7185ho.m43823c("BaseJsbCmd", "onCallResult " + th2.getClass().getSimpleName());
            }
            remoteCallResultCallback.onRemoteCallResult(str, callResult);
        }
    }

    /* renamed from: a */
    public static <T> void m45216a(RemoteCallResultCallback<String> remoteCallResultCallback, String str, int i10, T t10, boolean z10) {
        m45215a(remoteCallResultCallback, str, i10, new JsbCallBackData(t10, z10, null));
    }

    /* renamed from: a */
    public static void m45217a(RemoteCallResultCallback<String> remoteCallResultCallback, String str, int i10, JSONObject jSONObject) {
        if (remoteCallResultCallback != null) {
            CallResult<String> callResult = new CallResult<>();
            callResult.setCode(i10);
            try {
                callResult.setData(jSONObject.toString());
            } catch (Throwable th2) {
                AbstractC7185ho.m43823c("BaseJsbCmd", "onCallResult by callBackJson " + th2.getClass().getSimpleName());
            }
            remoteCallResultCallback.onRemoteCallResult(str, callResult);
        }
    }

    /* renamed from: a */
    public void m45222a(RemoteCallResultCallback<String> remoteCallResultCallback, boolean z10) {
        m45216a(remoteCallResultCallback, this.f34112a, FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "", z10);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo43564a(String str) {
        this.f34113b = str;
    }

    /* renamed from: a */
    public boolean m45223a(Context context, ContentRecord contentRecord) {
        if (contentRecord == null) {
            return false;
        }
        EncryptionField<String> encryptionFieldM41453aE = contentRecord.m41453aE();
        return AbstractC7806cz.m48171d(this.f34113b, encryptionFieldM41453aE != null ? encryptionFieldM41453aE.m41652a(context) : null) && AbstractC7558os.m46472k(contentRecord.m41427W());
    }
}
