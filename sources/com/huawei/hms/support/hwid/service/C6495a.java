package com.huawei.hms.support.hwid.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.common.internal.constant.AuthInternalPickerConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.hwid.bean.CheckPasswordByUserIdReq;
import com.huawei.hms.support.hwid.common.cloudservice.CloudRequestHandler;
import com.huawei.hms.support.hwid.common.p145d.C6469a;
import com.huawei.hms.support.hwid.common.p146e.C6473c;
import com.huawei.hms.support.hwid.common.p146e.C6474d;
import com.huawei.hms.support.hwid.common.p146e.C6475e;
import com.huawei.hms.support.hwid.common.p146e.C6476f;
import com.huawei.hms.support.hwid.common.p146e.C6477g;
import com.huawei.hms.support.hwid.result.C6484a;
import com.huawei.hms.support.hwid.result.C6487d;
import com.huawei.hms.support.hwid.result.InterfaceC6486c;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SuppressLint({"InlinedApi"})
/* renamed from: com.huawei.hms.support.hwid.service.a */
/* loaded from: classes8.dex */
public class C6495a {

    /* renamed from: a */
    private static String f30088a = "";

    /* renamed from: b */
    private static String f30089b = "";

    /* renamed from: c */
    private static final List<Integer> f30090c = new ArrayList(Arrays.asList(1, 5, 7, 8));

    /* renamed from: com.huawei.hms.support.hwid.service.a$1 */
    public class AnonymousClass1 implements InterfaceC6486c<C6484a> {

        /* renamed from: a */
        final /* synthetic */ Context f30091a;

        /* renamed from: b */
        final /* synthetic */ CheckPasswordByUserIdReq f30092b;

        /* renamed from: c */
        final /* synthetic */ CloudRequestHandler f30093c;

        public AnonymousClass1(Context context, CheckPasswordByUserIdReq checkPasswordByUserIdReq, CloudRequestHandler cloudRequestHandler) {
            context = context;
            checkPasswordByUserIdReq = checkPasswordByUserIdReq;
            cloudRequestHandler = cloudRequestHandler;
        }

        @Override // com.huawei.hms.support.hwid.result.InterfaceC6486c
        /* renamed from: a */
        public void mo36893a(C6484a c6484a) {
            C6487d c6487dM36920a = c6484a.m36920a();
            if (c6487dM36920a.m36921a() == 0) {
                C6495a.m36944c(context, checkPasswordByUserIdReq, cloudRequestHandler);
            } else {
                cloudRequestHandler.onError(new ErrorStatus(c6487dM36920a.m36921a(), c6487dM36920a.m36922b()));
            }
        }
    }

    /* renamed from: a */
    public static void m36941a(Context context, CheckPasswordByUserIdReq checkPasswordByUserIdReq, CloudRequestHandler cloudRequestHandler) {
        if (checkPasswordByUserIdReq == null || context == null || cloudRequestHandler == null) {
            C6477g.m36905b("CloudAccountImpl", "checkPasswordByUserId: request parameter is null");
            C6476f.m36901a(f30088a, "hwid.checkPasswordByUserId", 2015, f30089b);
            return;
        }
        f30089b = checkPasswordByUserIdReq.getPackageName();
        f30088a = HiAnalyticsClient.reportEntry(context, "hwid.checkPasswordByUserId", AuthInternalPickerConstant.HMS_SDK_VERSION);
        if (!m36942a(checkPasswordByUserIdReq.getUserId(), checkPasswordByUserIdReq.getPassword(), checkPasswordByUserIdReq.getPackageName(), checkPasswordByUserIdReq.getDeviceId(), checkPasswordByUserIdReq.getDeviceType(), context, checkPasswordByUserIdReq.getSiteId())) {
            C6477g.m36903a("CloudAccountImpl", "the params is invalid.");
            cloudRequestHandler.onError(new ErrorStatus(2003, "the params is invalid."));
            C6476f.m36901a(f30088a, "hwid.checkPasswordByUserId", 2003, f30089b);
            return;
        }
        if (C6473c.m36872a(checkPasswordByUserIdReq.getAccountType())) {
            cloudRequestHandler.onError(new ErrorStatus(2026, "third account is not allowed to verify password"));
            C6477g.m36903a("CloudAccountImpl", "third account is not allowed to verify password");
            C6476f.m36901a(f30088a, "hwid.checkPasswordByUserId", 2026, f30089b);
            return;
        }
        if (!C6473c.m36871a(context)) {
            cloudRequestHandler.onError(new ErrorStatus(2005, "Network is Unavailable"));
            C6477g.m36905b("CloudAccountImpl", "Network Unavailable");
            C6476f.m36901a(f30088a, "hwid.checkPasswordByUserId", 2005, f30089b);
            return;
        }
        if (!C6473c.m36877f(context)) {
            C6477g.m36903a("CloudAccountImpl", "checkIsUseHuaweiAccount false can not use hwid");
            cloudRequestHandler.onError(new ErrorStatus(ErrorStatus.ERROR_NOT_USE_APK, "checkIsUseHuaweiAccount false can not use hwid"));
            C6476f.m36901a(f30088a, "hwid.checkPasswordByUserId", ErrorStatus.ERROR_NOT_USE_APK, f30089b);
            return;
        }
        if (context.getPackageManager().checkPermission("com.huawei.android.permission.ANTITHEFT", checkPasswordByUserIdReq.getPackageName()) != 0) {
            cloudRequestHandler.onError(new ErrorStatus(27, "permission is deny"));
            C6477g.m36903a("CloudAccountImpl", "permission is deny");
            C6476f.m36901a(f30088a, "hwid.checkPasswordByUserId", 27, checkPasswordByUserIdReq.getPackageName());
            return;
        }
        int length = C6469a.m36860a(context).m36863a(String.valueOf(checkPasswordByUserIdReq.getSiteId()), "").length();
        Map<String, ?> mapM36864a = C6469a.m36860a(context).m36864a();
        if (mapM36864a == null || mapM36864a.size() == 0 || length >= 40) {
            C6477g.m36903a("CloudAccountImpl", "sp is unuseable");
            C6474d.m36879a().m36891a(context, f30088a, checkPasswordByUserIdReq.getPackageName(), new InterfaceC6486c<C6484a>() { // from class: com.huawei.hms.support.hwid.service.a.1

                /* renamed from: a */
                final /* synthetic */ Context f30091a;

                /* renamed from: b */
                final /* synthetic */ CheckPasswordByUserIdReq f30092b;

                /* renamed from: c */
                final /* synthetic */ CloudRequestHandler f30093c;

                public AnonymousClass1(Context context2, CheckPasswordByUserIdReq checkPasswordByUserIdReq2, CloudRequestHandler cloudRequestHandler2) {
                    context = context2;
                    checkPasswordByUserIdReq = checkPasswordByUserIdReq2;
                    cloudRequestHandler = cloudRequestHandler2;
                }

                @Override // com.huawei.hms.support.hwid.result.InterfaceC6486c
                /* renamed from: a */
                public void mo36893a(C6484a c6484a) {
                    C6487d c6487dM36920a = c6484a.m36920a();
                    if (c6487dM36920a.m36921a() == 0) {
                        C6495a.m36944c(context, checkPasswordByUserIdReq, cloudRequestHandler);
                    } else {
                        cloudRequestHandler.onError(new ErrorStatus(c6487dM36920a.m36921a(), c6487dM36920a.m36922b()));
                    }
                }
            });
        } else {
            C6477g.m36903a("CloudAccountImpl", "sp is useable");
            m36944c(context2, checkPasswordByUserIdReq2, cloudRequestHandler2);
            C6474d.m36879a().m36890a(context2, f30088a, checkPasswordByUserIdReq2.getPackageName());
        }
    }

    /* renamed from: c */
    public static void m36944c(Context context, CheckPasswordByUserIdReq checkPasswordByUserIdReq, CloudRequestHandler cloudRequestHandler) {
        String strM36863a = C6469a.m36860a(context).m36863a(String.valueOf(checkPasswordByUserIdReq.getSiteId()), "");
        String strM36863a2 = C6469a.m36860a(context).m36863a("public-key", "");
        C6477g.m36904a("CloudAccountImpl", "verifyPasswordRequest: siteDomainName = " + strM36863a, false);
        C6477g.m36904a("CloudAccountImpl", "verifyPasswordRequest: publicKey = " + strM36863a2, false);
        if (!TextUtils.isEmpty(strM36863a) && !TextUtils.isEmpty(strM36863a2)) {
            C6475e.m36894a().m36900a(context, checkPasswordByUserIdReq, strM36863a, strM36863a2, f30088a, cloudRequestHandler);
            return;
        }
        cloudRequestHandler.onError(new ErrorStatus(14, "siteDomainName or publicKey is null"));
        C6477g.m36903a("CloudAccountImpl", "siteDomainName or publicKey is null");
        C6476f.m36901a(f30088a, "hwid.checkPasswordByUserId", 14, f30089b);
    }

    /* renamed from: a */
    private static boolean m36942a(String str, String str2, String str3, String str4, String str5, Context context, int i10) {
        if (!f30090c.contains(Integer.valueOf(i10))) {
            C6477g.m36903a("CloudAccountImpl", "the siteId is invalid");
            return false;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!TextUtils.isEmpty(str3) && str3.equals(context.getPackageName())) {
                if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
                    return true;
                }
                C6477g.m36903a("CloudAccountImpl", "deviceId or deviceType is empty");
                return false;
            }
            C6477g.m36903a("CloudAccountImpl", "appId is empty or not equals");
            return false;
        }
        C6477g.m36903a("CloudAccountImpl", "userId or password is empty");
        return false;
    }
}
