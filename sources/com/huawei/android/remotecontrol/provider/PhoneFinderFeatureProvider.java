package com.huawei.android.remotecontrol.provider;

import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import bf.C1175a;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.openalliance.p169ad.constant.TradeMode;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.systemserver.antitheft.IHwAntiTheftCallback;
import gp.C10028c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0226l0;
import p292fn.C9733f;
import p459lp.C11330h;
import p575qe.C12347f;
import p577qg.C12354d;
import p664u0.C13108a;
import p809yg.C13981a;

/* loaded from: classes4.dex */
public class PhoneFinderFeatureProvider extends ContentProvider {

    /* renamed from: b */
    public static final String[] f20025b = {"DZ", "EG", "CV", "ER", "ET", "GM", "GW", "LY", "ML", "MR", "NE", "SN", "TD", "TN", "YE", "ZA", "AL", "KE", "MU", "AO", "BW", "CD", "CG", "FO", "DJ", "KM", "LS", "MG", "MW", "MZ", HNConstants.DataType.f22634NA, "RE", "ST", "SZ", "TZ", "UG", "YT", "ZM", "ZW", "BD", "KH", "HK", "LA", "MO", "MV", "MM", "LK", "TH", "VN", "MX", "CO", "EC", "PE", "AI", "SD", "AW", "SY", "BO", "BS", "CR", "DO", "GD", "GF", "GP", "GT", "GY", "HN", "JM", "KY", "LC", "NI", TradeMode.f32145PA, "PR", "SV", "TT", "VE", "VG", "AR", "CL", "BR", "PY", "UY", "MY", "BN", "ID", "NZ", "PH", "SG", "BI", "AU", "CK", "FJ", "PF", "NR", "PG", "SB", "TO", "BF", "BJ", "CF", "GL", "SC", "SO", "CI", "CM", "GA", "GH", "GN", "GQ", "LR", CloudBackupConstant.UserPackageInfo.FULL_DATA_SERVICE_200GB, "SL", "AG", "AN", "TG", "BB", "NP", "AE", "BZ", "BH", "CU", "IQ", "JO", "LB", "PK", "QA", "SA", "PS", "GI", "AZ", "BY", "GE", "AM", "MQ", "MS", "KZ", "KG", "MN", "SR", "TJ", "TM", "UA", "UZ", "FI", "AT", "BA", "BG", "CZ", "DK", "EE", "RW", "GR", "HR", "HU", "IS", "LI", "LT", "LV", "MD", "ME", "MK", "NO", "PL", "RO", "RS", "SE", "SI", "SK", "RU", "AD", "BE", "CH", "CY", "DE", "ES", "HT", "FR", "GB", "IE", "IT", "LU", "MC", "MT", "NL", "PT", FaqConstants.OPEN_TYPE_IN, "SM", "AF", "VA", "KW", "OM", "MA", "CA", "IL", "CN", "TR", "JP", "TW"};

    /* renamed from: c */
    public static final UriMatcher f20026c;

    /* renamed from: d */
    public static C4383a f20027d;

    /* renamed from: a */
    public IHwAntiTheftCallback f20028a;

    /* renamed from: com.huawei.android.remotecontrol.provider.PhoneFinderFeatureProvider$a */
    public static class C4383a extends BroadcastReceiver {

        /* renamed from: a */
        public final IHwAntiTheftCallback f20029a;

        public C4383a(IHwAntiTheftCallback iHwAntiTheftCallback) {
            this.f20029a = iHwAntiTheftCallback;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x009c  */
        @Override // android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onReceive(android.content.Context r7, android.content.Intent r8) throws org.json.JSONException {
            /*
                r6 = this;
                java.lang.String r0 = "getActiveTokenReceiver"
                java.lang.String r1 = "PhoneFinderFeatureProvider"
                p809yg.C13981a.m83989i(r1, r0)
                if (r8 == 0) goto Lb8
                if (r7 != 0) goto Ld
                goto Lb8
            Ld:
                com.huawei.secure.android.common.intent.SafeIntent r0 = new com.huawei.secure.android.common.intent.SafeIntent
                r0.<init>(r8)
                java.lang.String r8 = "com.huawei.hicloud.phonefinder.GET_ACTIVE_TOKEN_RESULT"
                java.lang.String r2 = r0.getAction()
                boolean r8 = r8.equals(r2)
                if (r8 == 0) goto Lb7
                java.lang.String r8 = "receive ACTION_GET_ACTIVE_TOKEN_RESULT"
                p809yg.C13981a.m83989i(r1, r8)
                java.lang.String r8 = "-1"
                java.lang.String r2 = ""
                r3 = -1
                java.lang.String r4 = "errorCode"
                java.lang.String r8 = r0.getStringExtra(r4)     // Catch: java.lang.Exception -> L5b
                java.lang.String r4 = "token"
                java.lang.String r2 = r0.getStringExtra(r4)     // Catch: java.lang.Exception -> L5b
                java.lang.String r4 = "bypassTimes"
                int r0 = r0.getIntExtra(r4, r3)     // Catch: java.lang.Exception -> L5b
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L59
                r4.<init>()     // Catch: java.lang.Exception -> L59
                java.lang.String r5 = "errorCode:"
                r4.append(r5)     // Catch: java.lang.Exception -> L59
                r4.append(r8)     // Catch: java.lang.Exception -> L59
                java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L59
                p809yg.C13981a.m83989i(r1, r4)     // Catch: java.lang.Exception -> L59
                com.huawei.systemserver.antitheft.IHwAntiTheftCallback r6 = r6.f20029a     // Catch: java.lang.Exception -> L59
                int r4 = p015ak.C0241z.m1685c(r8)     // Catch: java.lang.Exception -> L59
                int r3 = r6.onTokenRequested(r2, r4)     // Catch: java.lang.Exception -> L59
                goto L75
            L59:
                r6 = move-exception
                goto L5d
            L5b:
                r6 = move-exception
                r0 = r3
            L5d:
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "callback exception:"
                r4.append(r5)
                java.lang.String r6 = r6.toString()
                r4.append(r6)
                java.lang.String r6 = r4.toString()
                p809yg.C13981a.m83989i(r1, r6)
            L75:
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r4 = "callback result:"
                r6.append(r4)
                r6.append(r3)
                java.lang.String r6 = r6.toString()
                p809yg.C13981a.m83989i(r1, r6)
                boolean r6 = android.text.TextUtils.isEmpty(r2)
                r6 = r6 ^ 1
                java.lang.String r1 = java.lang.String.valueOf(r3)
                p577qg.C12354d.m74360z(r8, r6, r1)
                com.huawei.android.remotecontrol.provider.PhoneFinderFeatureProvider$a r6 = com.huawei.android.remotecontrol.provider.PhoneFinderFeatureProvider.m26445b()
                if (r6 == 0) goto Lab
                u0.a r6 = p664u0.C13108a.m78878b(r7)
                com.huawei.android.remotecontrol.provider.PhoneFinderFeatureProvider$a r7 = com.huawei.android.remotecontrol.provider.PhoneFinderFeatureProvider.m26445b()
                r6.m78883f(r7)
                r6 = 0
                com.huawei.android.remotecontrol.provider.PhoneFinderFeatureProvider.m26446c(r6)
            Lab:
                if (r3 != 0) goto Lb7
                if (r0 <= 0) goto Lb7
                rf.j r6 = new rf.j
                r6.<init>()
                r6.m75060a()
            Lb7:
                return
            Lb8:
                java.lang.String r6 = "intent or context is empty"
                p809yg.C13981a.m83988e(r1, r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.remotecontrol.provider.PhoneFinderFeatureProvider.C4383a.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f20026c = uriMatcher;
        uriMatcher.addURI("com.huawei.android.phone.finder.provider", "is_show_phone_finder_feature", 1);
        uriMatcher.addURI("com.huawei.android.phone.finder.provider", "get_phone_finder_state", 2);
        uriMatcher.addURI("com.huawei.android.phone.finder.provider", "tokenAuthRequest", 3);
    }

    /* renamed from: d */
    public static boolean m26447d(String str) throws JSONException {
        List<String> listM26448f = m26448f();
        for (int i10 = 0; i10 < listM26448f.size(); i10++) {
            if (str != null && str.equalsIgnoreCase(listM26448f.get(i10))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public static List<String> m26448f() throws JSONException {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        String findDeviceCountryCode = hiCloudSysParamMapM60757p != null ? hiCloudSysParamMapM60757p.getFindDeviceCountryCode() : null;
        if (TextUtils.isEmpty(findDeviceCountryCode)) {
            C13981a.m83989i("PhoneFinderFeatureProvider", "use local FindDeviceCountryCode");
            return Arrays.asList(f20025b);
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(findDeviceCountryCode);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                String string = jSONArray.getString(i10);
                if (!TextUtils.isEmpty(string)) {
                    arrayList.add(string);
                }
            }
            return arrayList;
        } catch (JSONException unused) {
            C13981a.m83988e("PhoneFinderFeatureProvider", "JSONException");
            return Arrays.asList(f20025b);
        }
    }

    /* renamed from: i */
    public static boolean m26449i(String str) {
        if (TextUtils.isEmpty(str)) {
            C13981a.m83989i("PhoneFinderFeatureProvider", "countryCode is empty");
            return false;
        }
        if (!C0209d.m1166E1()) {
            C13981a.m83989i("PhoneFinderFeatureProvider", "isOwnerUser");
            return false;
        }
        if (!m26447d(str)) {
            C13981a.m83989i("PhoneFinderFeatureProvider", "not support countryCode");
            return false;
        }
        if (!C10028c.m62182c0().m62400u1("funcfg_find_my_phone_globe", true)) {
            C13981a.m83989i("PhoneFinderFeatureProvider", "not enable in server");
            return false;
        }
        if (!C11330h.m68077a()) {
            C13981a.m83989i("PhoneFinderFeatureProvider", "new honor not show");
            return false;
        }
        if (C10028c.m62182c0().m62350k1(true, str)) {
            return true;
        }
        C13981a.m83989i("PhoneFinderFeatureProvider", "isEnable false");
        return false;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        C13981a.m83989i("PhoneFinderFeatureProvider", "method:" + str);
        return "getActivationToken".equals(str) ? m26450e(bundle) : super.call(str, str2, bundle);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    /* renamed from: e */
    public final Bundle m26450e(Bundle bundle) {
        String string;
        String string2;
        IBinder binder;
        C13981a.m83989i("PhoneFinderFeatureProvider", "getActivationToken call");
        Bundle bundle2 = new Bundle();
        if (bundle == null) {
            bundle2.putInt("result", FamilyShareConstants.StatusCode.FAMILY_SHARE_NOT_OPEN);
            return bundle2;
        }
        if (C12347f.m74285n().m74301m() == null) {
            C13981a.m83989i("PhoneFinderFeatureProvider", "getActivationToken call, model not init");
            C12347f.m74285n().m74292F(getContext());
        }
        try {
            string = bundle.getString("sceneId");
            string2 = bundle.getString("modeId");
            binder = bundle.getBinder("callback");
            C13981a.m83989i("PhoneFinderFeatureProvider", "sceneId:" + string + ",modeId:" + string2);
        } catch (Exception unused) {
            C13981a.m83990w("PhoneFinderFeatureProvider", "getActivationToken exception");
            bundle2.putInt("result", FamilyShareConstants.StatusCode.FAMILY_SHARE_NOT_OPEN);
        }
        if (string != null && string2 != null && binder != null) {
            if (C1175a.m7385g(false)) {
                C13981a.m83990w("PhoneFinderFeatureProvider", "getActivationToken has auth flag");
                bundle2.putInt("result", 1003);
                C12354d.m74359y(String.valueOf(1003), false);
                return bundle2;
            }
            if (C0209d.m1333z1(getContext())) {
                C12354d.m74331G(string);
                C12354d.m74325A(string, string2);
                this.f20028a = IHwAntiTheftCallback.AbstractBinderC8691a.m53597a(binder);
                bundle2.putInt("result", 1000);
                m26454k(string, string2);
                return bundle2;
            }
            C13981a.m83990w("PhoneFinderFeatureProvider", "getActivationToken not network");
            this.f20028a = IHwAntiTheftCallback.AbstractBinderC8691a.m53597a(binder);
            if (!"1".equals(string2) || "1000".equals(string)) {
                C0226l0.m1585e(new Runnable() { // from class: pf.a
                    @Override // java.lang.Runnable
                    public final void run() throws JSONException {
                        this.f56281a.m26453j();
                    }
                }, 50L);
            } else {
                m26455l(this.f20028a);
                C12354d.m74333I();
            }
            bundle2.putInt("result", 1000);
            return bundle2;
        }
        C13981a.m83990w("PhoneFinderFeatureProvider", "getActivationToken IllegalArgument");
        bundle2.putInt("result", FamilyShareConstants.StatusCode.FAMILY_SHARE_NOT_OPEN);
        C12354d.m74359y(String.valueOf(FamilyShareConstants.StatusCode.FAMILY_SHARE_NOT_OPEN), false);
        return bundle2;
    }

    /* renamed from: g */
    public final Cursor m26451g(String str, String[] strArr) {
        C13981a.m83989i("PhoneFinderFeatureProvider", "getPhoneFinderState");
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"phoneFinderState"});
        if (str == null || strArr == null || strArr.length <= 0) {
            C13981a.m83990w("PhoneFinderFeatureProvider", "IllegalArgument selectionArgs");
        } else {
            if (C1175a.m7390l(getContext(), strArr[0])) {
                matrixCursor.addRow(new Object[]{""});
            } else if (getContext() != null) {
                matrixCursor.addRow(new Object[]{getContext().getString(R$string.sync_switch_button_close)});
            }
        }
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    /* renamed from: h */
    public final Cursor m26452h(String str, String[] strArr) {
        C13981a.m83989i("PhoneFinderFeatureProvider", "isShowPhoneFinderFeature");
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"isShowPhoneFinderFeature"});
        if (str == null || strArr == null || strArr.length <= 0) {
            C13981a.m83990w("PhoneFinderFeatureProvider", "IllegalArgument selectionArgs");
        } else if (m26449i(strArr[0])) {
            C13981a.m83989i("PhoneFinderFeatureProvider", "show phoneFinder");
            matrixCursor.addRow(new Object[]{1});
        } else {
            C13981a.m83989i("PhoneFinderFeatureProvider", "hide phoneFinder");
            matrixCursor.addRow(new Object[]{0});
        }
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    /* renamed from: j */
    public final /* synthetic */ void m26453j() throws JSONException {
        int iOnTokenRequested;
        try {
            iOnTokenRequested = this.f20028a.onTokenRequested("", 1002);
            try {
                C13981a.m83989i("PhoneFinderFeatureProvider", "not network callback result:" + iOnTokenRequested);
            } catch (Exception e10) {
                e = e10;
                C13981a.m83990w("PhoneFinderFeatureProvider", "not network callback exception:" + e.getMessage());
                C12354d.m74360z(String.valueOf(1002), false, String.valueOf(iOnTokenRequested));
            }
        } catch (Exception e11) {
            e = e11;
            iOnTokenRequested = 0;
        }
        C12354d.m74360z(String.valueOf(1002), false, String.valueOf(iOnTokenRequested));
    }

    /* renamed from: k */
    public final void m26454k(String str, String str2) {
        m26455l(this.f20028a);
        C12354d.m74352r(true, str, "1".equals(str2), null);
    }

    /* renamed from: l */
    public final void m26455l(IHwAntiTheftCallback iHwAntiTheftCallback) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            return;
        }
        if (f20027d != null) {
            m26456m();
        }
        f20027d = new C4383a(iHwAntiTheftCallback);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.hicloud.phonefinder.GET_ACTIVE_TOKEN_RESULT");
        C13108a.m78878b(contextM1377a).m78880c(f20027d, intentFilter);
    }

    /* renamed from: m */
    public final void m26456m() {
        Context contextM1377a = C0213f.m1377a();
        if (f20027d != null) {
            C13108a.m78878b(contextM1377a).m78883f(f20027d);
            f20027d = null;
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int iMatch = f20026c.match(uri);
        C0209d.m1247e(getContext());
        if (iMatch == 1) {
            return m26452h(str, strArr2);
        }
        if (iMatch == 2) {
            return m26451g(str, strArr2);
        }
        throw new IllegalArgumentException("Unknown URI " + uri);
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
