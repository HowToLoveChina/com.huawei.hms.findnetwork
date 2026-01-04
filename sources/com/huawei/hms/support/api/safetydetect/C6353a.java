package com.huawei.hms.support.api.safetydetect;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.common.CommonPickerConstant;
import com.huawei.hms.support.api.entity.safetydetect.MaliciousAppsListResp;
import com.huawei.hms.support.api.entity.safetydetect.RiskTokenResponse;
import com.huawei.hms.support.api.entity.safetydetect.SysIntegrityRequest;
import com.huawei.hms.support.api.entity.safetydetect.SysIntegrityResp;
import com.huawei.hms.support.api.entity.safetydetect.UrlCheckResponse;
import com.huawei.hms.support.api.entity.safetydetect.UserDetectResponse;
import com.huawei.hms.support.api.entity.safetydetect.VerifyAppsCheckEnabledResp;
import com.huawei.hms.support.api.entity.safetydetect.WifiDetectResponse;
import com.huawei.hms.support.api.safetydetect.p860default.C6355a0;
import com.huawei.hms.support.api.safetydetect.p860default.C6356b;
import com.huawei.hms.support.api.safetydetect.p860default.C6357b0;
import com.huawei.hms.support.api.safetydetect.p860default.C6358c;
import com.huawei.hms.support.api.safetydetect.p860default.C6359c0;
import com.huawei.hms.support.api.safetydetect.p860default.C6361d0;
import com.huawei.hms.support.api.safetydetect.p860default.C6363e0;
import com.huawei.hms.support.api.safetydetect.p860default.C6364f;
import com.huawei.hms.support.api.safetydetect.p860default.C6365f0;
import com.huawei.hms.support.api.safetydetect.p860default.C6366g;
import com.huawei.hms.support.api.safetydetect.p860default.C6367h;
import com.huawei.hms.support.api.safetydetect.p860default.C6368i;
import com.huawei.hms.support.api.safetydetect.p860default.C6369j;
import com.huawei.hms.support.api.safetydetect.p860default.C6370k;
import com.huawei.hms.support.api.safetydetect.p860default.C6371l;
import com.huawei.hms.support.api.safetydetect.p860default.C6373n;
import com.huawei.hms.support.api.safetydetect.p860default.C6375p;
import com.huawei.hms.support.api.safetydetect.p860default.C6376q;
import com.huawei.hms.support.api.safetydetect.p860default.C6377r;
import com.huawei.hms.support.api.safetydetect.p860default.C6380u;
import com.huawei.hms.support.api.safetydetect.p860default.C6381v;
import com.huawei.hms.support.api.safetydetect.p860default.C6382w;
import com.huawei.hms.support.api.safetydetect.p860default.C6383x;
import com.huawei.hms.support.api.safetydetect.p860default.C6384y;
import com.huawei.hms.support.log.common.Base64;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.SHA256;
import com.tencent.p204mm.opensdk.modelmsg.WXMediaMessage;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.support.api.safetydetect.a */
/* loaded from: classes8.dex */
public class C6353a extends HuaweiApi<C6380u> implements SafetyDetectClient {

    /* renamed from: b */
    private static final String f29879b = "a";

    /* renamed from: c */
    private static final C6377r f29880c = new C6377r();

    /* renamed from: d */
    private static final Api<C6380u> f29881d = new Api<>("HuaweiSafetyDetect.API");

    /* renamed from: a */
    private Context f29882a;

    public C6353a(Activity activity, C6380u c6380u) {
        super(activity, f29881d, c6380u, (AbstractClientBuilder) f29880c, 60700305);
        this.f29882a = activity;
    }

    /* renamed from: a */
    private C6383x m36718a(byte[] bArr, String str, String str2, Context context) throws PackageManager.NameNotFoundException {
        C6383x c6383x = new C6383x();
        String str3 = context.getApplicationInfo().sourceDir;
        c6383x.m36765d(Base64.encode(bArr));
        c6383x.m36764c(str);
        c6383x.m36766e(context.getApplicationInfo().packageName);
        c6383x.m36761a(str2);
        c6383x.m36763b(m36719a(str3));
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            String[] strArr = new String[packageInfo.signatures.length];
            int i10 = 0;
            while (true) {
                Signature[] signatureArr = packageInfo.signatures;
                if (i10 >= signatureArr.length) {
                    break;
                }
                strArr[i10] = Base64.encode(SHA256.digest(signatureArr[i10].toByteArray()));
                i10++;
            }
            c6383x.m36762a(strArr);
        } catch (PackageManager.NameNotFoundException unused) {
            c6383x.m36762a((String[]) null);
        }
        return c6383x;
    }

    @Override // com.huawei.hms.support.api.safetydetect.SafetyDetectClient
    public Task<VerifyAppsCheckEnabledResp> enableAppsCheck() {
        return doWrite(new C6366g(getContext(), "safetydetect.enableAppsCheck", new C6364f().m36733a(), true));
    }

    @Override // com.huawei.hms.support.api.safetydetect.SafetyDetectClient
    public Task<MaliciousAppsListResp> getMaliciousAppsList() {
        return doWrite(new C6367h(getContext(), "safetydetect.getHarmfulAppsList", new C6373n().m36744a(), true));
    }

    @Override // com.huawei.hms.support.api.safetydetect.SafetyDetectClient
    public Task<RiskTokenResponse> getRiskToken() {
        String strM36749a = C6376q.m36749a(this.f29882a);
        if (!TextUtils.isEmpty(strM36749a)) {
            try {
                C8941i c8941i = new C8941i();
                c8941i.m56658d(new RiskTokenResponse(strM36749a));
                return c8941i.m56656b();
            } catch (JSONException e10) {
                Log.e(f29879b, "Json conversion exception! " + e10.getMessage());
            }
        }
        return this.doWrite(new C6368i(this.getContext(), "safetydetect.getRiskToken", "", true));
    }

    @Override // com.huawei.hms.support.api.safetydetect.SafetyDetectClient
    public Task<WifiDetectResponse> getWifiDetectStatus() {
        return doWrite(new C6369j(getContext(), "safetydetect.getWifiDetectStatus", "", true));
    }

    @Override // com.huawei.hms.support.api.safetydetect.SafetyDetectClient
    public Task<Void> initAntiFraud(String str) throws JSONException {
        Checker.checkNonNull(str);
        return doWrite(new C6370k(getContext(), "safetydetect.initAntiFraud", new C6358c(str).m36728a(), true));
    }

    @Override // com.huawei.hms.support.api.safetydetect.SafetyDetectClient
    public Task<Void> initUrlCheck() {
        return doWrite(new C6356b(getContext(), "safetydetect.initUrlChecker", "", true));
    }

    @Override // com.huawei.hms.support.api.safetydetect.SafetyDetectClient
    public Task<Void> initUserDetect() {
        return doWrite(new C6371l(getContext(), "safetydetect.initUserDetect", "", true));
    }

    @Override // com.huawei.hms.support.api.safetydetect.SafetyDetectClient
    public Task<VerifyAppsCheckEnabledResp> isVerifyAppsCheck() {
        return doWrite(new C6365f0(getContext(), "safetydetect.isVerifyAppsCheck", new C6363e0().m36732a(), true));
    }

    @Override // com.huawei.hms.support.api.safetydetect.SafetyDetectClient
    public Task<Void> releaseAntiFraud() {
        return doWrite(new C6375p(getContext(), "safetydetect.releaseAntiFraud", "", true));
    }

    @Override // com.huawei.hms.support.api.safetydetect.SafetyDetectClient
    public Task<Void> shutdownUrlCheck() {
        return doWrite(new C6382w(getContext(), "safetydetect.shutdownUrlChecker", "", true));
    }

    @Override // com.huawei.hms.support.api.safetydetect.SafetyDetectClient
    public Task<Void> shutdownUserDetect() {
        return doWrite(new C6381v(getContext(), "safetydetect.shutdownUserDetect", "", true));
    }

    @Override // com.huawei.hms.support.api.safetydetect.SafetyDetectClient
    public Task<SysIntegrityResp> sysIntegrity(SysIntegrityRequest sysIntegrityRequest) throws ApiException {
        ApiException e10;
        C8941i c8941i = new C8941i();
        if (sysIntegrityRequest != null) {
            try {
                if (!TextUtils.isEmpty(sysIntegrityRequest.getAlg()) && !TextUtils.isEmpty(sysIntegrityRequest.getAppId()) && sysIntegrityRequest.getNonce() != null) {
                    String alg = sysIntegrityRequest.getAlg();
                    byte[] nonce = sysIntegrityRequest.getNonce();
                    String appId = sysIntegrityRequest.getAppId();
                    m36720a(nonce);
                    if (!CommonPickerConstant.IdTokenSupportAlg.RS_256.equals(alg) && !"PS256".equals(alg)) {
                        throw new ApiException(new Status(SafetyDetectStatusCodes.PARAM_ERROR_INVALID, SafetyDetectStatusCodes.getStatusCodeString(SafetyDetectStatusCodes.PARAM_ERROR_INVALID)));
                    }
                    return doWrite(new C6384y(getContext(), "safetydetect.sysIntegrity", m36718a(nonce, appId, alg, this.f29882a).m36760a(), true));
                }
            } catch (ApiException e11) {
                e10 = e11;
                c8941i.m56657c(e10);
                return c8941i.m56656b();
            } catch (Exception unused) {
                e10 = new ApiException(new Status(SafetyDetectStatusCodes.SDK_INTERNAL_ERROR, SafetyDetectStatusCodes.getStatusCodeString(SafetyDetectStatusCodes.SDK_INTERNAL_ERROR)));
                c8941i.m56657c(e10);
                return c8941i.m56656b();
            }
        }
        throw new ApiException(new Status(SafetyDetectStatusCodes.PARAM_ERROR_EMPTY, SafetyDetectStatusCodes.getStatusCodeString(SafetyDetectStatusCodes.PARAM_ERROR_EMPTY)));
    }

    @Override // com.huawei.hms.support.api.safetydetect.SafetyDetectClient
    public Task<UrlCheckResponse> urlCheck(String str, String str2, int... iArr) throws JSONException {
        Checker.checkNonNull(str);
        Checker.checkNonNull(str2);
        return doWrite(new C6355a0(getContext(), "safetydetect.urlCheck", new C6357b0(str, str2, iArr).m36727a(), true));
    }

    @Override // com.huawei.hms.support.api.safetydetect.SafetyDetectClient
    public Task<UserDetectResponse> userDetection(String str) throws JSONException {
        Checker.checkNonNull(str);
        return doWrite(new C6359c0(getContext(), "safetydetect.userDetection", new C6361d0(str).m36731a(), true));
    }

    public C6353a(Context context, C6380u c6380u) {
        super(context, f29881d, c6380u, f29880c, 60700305);
        this.f29882a = context;
    }

    /* renamed from: a */
    private static String m36719a(String str) throws NoSuchAlgorithmException, IOException {
        try {
            DigestInputStream digestInputStream = new DigestInputStream(new FileInputStream(str), MessageDigest.getInstance("SHA-256"));
            try {
                while (digestInputStream.read(new byte[WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT]) > 0) {
                }
                String strEncode = Base64.encode(digestInputStream.getMessageDigest().digest());
                digestInputStream.close();
                return strEncode;
            } finally {
            }
        } catch (IOException | NoSuchAlgorithmException unused) {
            return "";
        }
    }

    @Override // com.huawei.hms.support.api.safetydetect.SafetyDetectClient
    public Task<SysIntegrityResp> sysIntegrity(byte[] bArr, String str) {
        SysIntegrityRequest sysIntegrityRequest = new SysIntegrityRequest();
        sysIntegrityRequest.setAlg(CommonPickerConstant.IdTokenSupportAlg.RS_256);
        sysIntegrityRequest.setAppId(str);
        sysIntegrityRequest.setNonce(bArr);
        return sysIntegrity(sysIntegrityRequest);
    }

    /* renamed from: a */
    private void m36720a(byte[] bArr) throws ApiException {
        if (bArr == null || bArr.length < 16 || bArr.length > 66) {
            throw new ApiException(new Status(SafetyDetectStatusCodes.PARAM_ERROR_INVALID, SafetyDetectStatusCodes.getStatusCodeString(SafetyDetectStatusCodes.PARAM_ERROR_INVALID)));
        }
    }
}
