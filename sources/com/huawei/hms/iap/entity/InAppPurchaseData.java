package com.huawei.hms.iap.entity;

import android.text.TextUtils;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.hms.support.feature.result.CommonConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class InAppPurchaseData {
    public static final int NOT_PRESENT = Integer.MIN_VALUE;

    /* renamed from: A */
    private int f25381A;

    /* renamed from: B */
    private long f25382B;

    /* renamed from: C */
    private int f25383C;

    /* renamed from: D */
    private String f25384D;

    /* renamed from: E */
    private int f25385E;

    /* renamed from: F */
    private int f25386F;

    /* renamed from: G */
    private int f25387G;

    /* renamed from: H */
    private long f25388H;

    /* renamed from: I */
    private boolean f25389I;

    /* renamed from: J */
    private int f25390J;

    /* renamed from: K */
    private int f25391K;

    /* renamed from: L */
    private String f25392L;

    /* renamed from: M */
    private int f25393M;

    /* renamed from: N */
    private String f25394N;

    /* renamed from: O */
    private String f25395O;

    /* renamed from: P */
    private int f25396P;

    /* renamed from: Q */
    private String f25397Q;

    /* renamed from: R */
    private int f25398R;

    /* renamed from: S */
    private long f25399S;

    /* renamed from: T */
    private long f25400T;

    /* renamed from: U */
    private int f25401U;

    /* renamed from: V */
    private long f25402V;

    /* renamed from: a */
    private String f25403a;

    /* renamed from: b */
    private boolean f25404b;

    /* renamed from: c */
    private String f25405c;

    /* renamed from: d */
    private String f25406d;

    /* renamed from: e */
    private String f25407e;

    /* renamed from: f */
    private String f25408f;

    /* renamed from: g */
    private long f25409g;

    /* renamed from: h */
    private int f25410h;

    /* renamed from: i */
    private String f25411i;

    /* renamed from: j */
    private String f25412j;

    /* renamed from: k */
    private int f25413k;

    /* renamed from: l */
    private String f25414l;

    /* renamed from: m */
    private long f25415m;

    /* renamed from: n */
    private String f25416n;

    /* renamed from: o */
    private String f25417o;

    /* renamed from: p */
    private String f25418p;

    /* renamed from: q */
    private long f25419q;

    /* renamed from: r */
    private String f25420r;

    /* renamed from: s */
    private int f25421s;

    /* renamed from: t */
    private long f25422t;

    /* renamed from: u */
    private long f25423u;

    /* renamed from: v */
    private long f25424v;

    /* renamed from: w */
    private long f25425w;

    /* renamed from: x */
    private int f25426x;

    /* renamed from: y */
    private int f25427y;

    /* renamed from: z */
    private int f25428z;

    public interface PurchaseState {
        public static final int CANCELED = 1;
        public static final int INITIALIZED = Integer.MIN_VALUE;
        public static final int PENDING = 3;
        public static final int PURCHASED = 0;
        public static final int REFUNDED = 2;
    }

    public InAppPurchaseData(String str) throws JSONException {
        JSONObject jSONObject = TextUtils.isEmpty(str) ? new JSONObject() : new JSONObject(str);
        this.f25403a = jSONObject.optString("applicationId");
        this.f25404b = jSONObject.optBoolean("autoRenewing");
        this.f25405c = jSONObject.optString("orderId");
        this.f25406d = jSONObject.optString("packageName", null);
        this.f25407e = jSONObject.optString("productId");
        this.f25408f = jSONObject.optString(HwPayConstant.KEY_PRODUCTNAME, null);
        this.f25409g = jSONObject.optLong("purchaseTime", -2147483648L);
        this.f25410h = jSONObject.optInt("purchaseState");
        this.f25411i = jSONObject.optString("developerPayload", null);
        this.f25412j = jSONObject.optString("purchaseToken");
        this.f25413k = jSONObject.optInt("purchaseType", Integer.MIN_VALUE);
        this.f25414l = jSONObject.optString(HwPayConstant.KEY_CURRENCY);
        this.f25415m = jSONObject.optLong("price");
        this.f25416n = jSONObject.optString("country");
        this.f25417o = jSONObject.optString("lastOrderId", null);
        this.f25418p = jSONObject.optString("productGroup", null);
        this.f25419q = jSONObject.optLong("oriPurchaseTime", -2147483648L);
        this.f25420r = jSONObject.optString("subscriptionId", null);
        this.f25421s = jSONObject.optInt("quantity", Integer.MIN_VALUE);
        this.f25422t = jSONObject.optLong("daysLasted", -2147483648L);
        this.f25423u = jSONObject.optLong("numOfPeriods", -2147483648L);
        this.f25424v = jSONObject.optLong("numOfDiscount", -2147483648L);
        this.f25425w = jSONObject.optLong("expirationDate", -2147483648L);
        this.f25426x = jSONObject.optInt("expirationIntent", Integer.MIN_VALUE);
        this.f25427y = jSONObject.optInt("retryFlag", Integer.MIN_VALUE);
        this.f25428z = jSONObject.optInt("introductoryFlag", Integer.MIN_VALUE);
        this.f25381A = jSONObject.optInt("trialFlag", Integer.MIN_VALUE);
        this.f25382B = jSONObject.optLong("cancelTime", -2147483648L);
        this.f25383C = jSONObject.optInt("cancelReason", Integer.MIN_VALUE);
        this.f25384D = jSONObject.optString("appInfo", null);
        this.f25385E = jSONObject.optInt("notifyClosed", Integer.MIN_VALUE);
        this.f25386F = jSONObject.optInt("renewStatus", Integer.MIN_VALUE);
        this.f25387G = jSONObject.optInt("priceConsentStatus", Integer.MIN_VALUE);
        this.f25388H = jSONObject.optLong("renewPrice", -2147483648L);
        this.f25389I = jSONObject.optBoolean("subIsvalid", false);
        this.f25390J = jSONObject.optInt("cancelledSubKeepDays", Integer.MIN_VALUE);
        this.f25391K = jSONObject.optInt("kind", Integer.MIN_VALUE);
        this.f25392L = jSONObject.optString("developerChallenge", null);
        this.f25393M = jSONObject.optInt("consumptionState", Integer.MIN_VALUE);
        this.f25394N = jSONObject.optString("payOrderId", null);
        this.f25395O = jSONObject.optString("payType", null);
        this.f25396P = jSONObject.optInt("deferFlag", Integer.MIN_VALUE);
        this.f25397Q = jSONObject.optString("oriSubscriptionId", null);
        this.f25398R = jSONObject.optInt("cancelWay", Integer.MIN_VALUE);
        this.f25399S = jSONObject.optLong("cancellationTime", -2147483648L);
        this.f25400T = jSONObject.optLong("resumeTime", -2147483648L);
        this.f25402V = jSONObject.optLong("graceExpirationTime", -2147483648L);
        this.f25401U = jSONObject.optInt(CommonConstant.KEY_ACCOUNT_FLAG, Integer.MIN_VALUE);
    }

    public int getAccountFlag() {
        return this.f25401U;
    }

    public String getAppInfo() {
        return this.f25384D;
    }

    public String getApplicationId() {
        return this.f25403a;
    }

    public int getCancelReason() {
        return this.f25383C;
    }

    public long getCancelTime() {
        return this.f25382B;
    }

    public int getCancelWay() {
        return this.f25398R;
    }

    public long getCancellationTime() {
        return this.f25399S;
    }

    public int getCancelledSubKeepDays() {
        return this.f25390J;
    }

    public int getConsumptionState() {
        return this.f25393M;
    }

    public String getCountry() {
        return this.f25416n;
    }

    public String getCurrency() {
        return this.f25414l;
    }

    public long getDaysLasted() {
        return this.f25422t;
    }

    public int getDeferFlag() {
        return this.f25396P;
    }

    public String getDeveloperChallenge() {
        return this.f25392L;
    }

    public String getDeveloperPayload() {
        return this.f25411i;
    }

    public long getExpirationDate() {
        return this.f25425w;
    }

    public int getExpirationIntent() {
        return this.f25426x;
    }

    public long getGraceExpirationTime() {
        return this.f25402V;
    }

    public int getIntroductoryFlag() {
        return this.f25428z;
    }

    public int getKind() {
        return this.f25391K;
    }

    public String getLastOrderId() {
        return this.f25417o;
    }

    public int getNotifyClosed() {
        return this.f25385E;
    }

    public long getNumOfDiscount() {
        return this.f25424v;
    }

    public long getNumOfPeriods() {
        return this.f25423u;
    }

    public String getOrderID() {
        return this.f25405c;
    }

    public long getOriPurchaseTime() {
        return this.f25419q;
    }

    public String getOriSubscriptionId() {
        return this.f25397Q;
    }

    public String getPackageName() {
        return this.f25406d;
    }

    public String getPayOrderId() {
        return this.f25394N;
    }

    public String getPayType() {
        return this.f25395O;
    }

    public long getPrice() {
        return this.f25415m;
    }

    public int getPriceConsentStatus() {
        return this.f25387G;
    }

    public String getProductGroup() {
        return this.f25418p;
    }

    public String getProductId() {
        return this.f25407e;
    }

    public String getProductName() {
        return this.f25408f;
    }

    public int getPurchaseState() {
        return this.f25410h;
    }

    public long getPurchaseTime() {
        return this.f25409g;
    }

    public String getPurchaseToken() {
        return this.f25412j;
    }

    public int getPurchaseType() {
        return this.f25413k;
    }

    public int getQuantity() {
        return this.f25421s;
    }

    public long getRenewPrice() {
        return this.f25388H;
    }

    public int getRenewStatus() {
        return this.f25386F;
    }

    public long getResumeTime() {
        return this.f25400T;
    }

    public int getRetryFlag() {
        return this.f25427y;
    }

    public String getSubscriptionId() {
        return this.f25420r;
    }

    public int getTrialFlag() {
        return this.f25381A;
    }

    public boolean isAutoRenewing() {
        return this.f25404b;
    }

    public boolean isSubValid() {
        return this.f25389I;
    }
}
