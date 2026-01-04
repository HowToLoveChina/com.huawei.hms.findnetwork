package com.huawei.hms.support.hwid;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.constant.AuthInternalPickerConstant;
import com.huawei.hms.hwid.C5599ap;
import com.huawei.hms.hwid.C5602as;
import com.huawei.hms.hwid.C5626x;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.hwid.common.HuaweiIdAuthException;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthExtendedParams;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import com.huawei.hms.support.hwid.result.HuaweiIdAuthResult;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthService;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthServiceImpl;
import java.util.List;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public final class HuaweiIdAuthManager {
    /* renamed from: a */
    private static Intent m36821a(Activity activity, List<Scope> list) {
        return getService(activity, C5626x.m32962a(list)).getSignInIntent();
    }

    public static void addAuthScopes(Activity activity, int i10, HuaweiIdAuthExtendedParams huaweiIdAuthExtendedParams) {
        if (huaweiIdAuthExtendedParams == null) {
            throw new NullPointerException("HuaweiIdAuthExtendedParams should not be null");
        }
        addAuthScopes(activity, i10, huaweiIdAuthExtendedParams.getExtendedScopes());
    }

    public static boolean containScopes(AuthHuaweiId authHuaweiId, HuaweiIdAuthExtendedParams huaweiIdAuthExtendedParams) {
        if (huaweiIdAuthExtendedParams == null) {
            return false;
        }
        return containScopes(authHuaweiId, huaweiIdAuthExtendedParams.getExtendedScopes());
    }

    public static AuthHuaweiId getAuthResult() {
        return C5626x.m32966b();
    }

    public static AuthHuaweiId getAuthResultWithScopes(List<Scope> list) throws HuaweiIdAuthException {
        if (C5599ap.m32900a(list).booleanValue()) {
            throw new HuaweiIdAuthException("ScopeList should not be empty");
        }
        AuthHuaweiId authHuaweiIdM32966b = C5626x.m32966b();
        if (authHuaweiIdM32966b == null) {
            authHuaweiIdM32966b = new AuthHuaweiId();
        }
        authHuaweiIdM32966b.requestExtraScopes(list);
        return authHuaweiIdM32966b;
    }

    public static AuthHuaweiId getExtendedAuthResult(HuaweiIdAuthExtendedParams huaweiIdAuthExtendedParams) {
        if (huaweiIdAuthExtendedParams == null) {
            throw new NullPointerException("HuaweiIdAuthExtendedParams should not be null");
        }
        List<Scope> extendedScopes = huaweiIdAuthExtendedParams.getExtendedScopes();
        AuthHuaweiId authHuaweiIdM32966b = C5626x.m32966b();
        if (authHuaweiIdM32966b == null) {
            authHuaweiIdM32966b = new AuthHuaweiId();
        }
        return authHuaweiIdM32966b.requestExtraScopes(extendedScopes);
    }

    public static HuaweiIdAuthService getService(Context context, HuaweiIdAuthParams huaweiIdAuthParams) {
        return new HuaweiIdAuthServiceImpl(context, huaweiIdAuthParams, AuthInternalPickerConstant.HMS_SDK_VERSION);
    }

    public static Task<AuthHuaweiId> parseAuthResultFromIntent(Intent intent) {
        C8941i c8941i = new C8941i();
        HuaweiIdAuthResult huaweiIdAuthResultM32963a = C5626x.m32963a(intent);
        if (huaweiIdAuthResultM32963a == null) {
            c8941i.m56657c(new ApiException(new Status(8)));
        } else if (!huaweiIdAuthResultM32963a.isSuccess() || huaweiIdAuthResultM32963a.getHuaweiId() == null) {
            c8941i.m56657c(new ApiException(huaweiIdAuthResultM32963a.getStatus()));
        } else {
            c8941i.m56658d(huaweiIdAuthResultM32963a.getHuaweiId());
        }
        return c8941i.m56656b();
    }

    public static HuaweiIdAuthService getService(Activity activity, HuaweiIdAuthParams huaweiIdAuthParams) {
        return new HuaweiIdAuthServiceImpl(activity, huaweiIdAuthParams, AuthInternalPickerConstant.HMS_SDK_VERSION);
    }

    public static boolean containScopes(AuthHuaweiId authHuaweiId, List<Scope> list) {
        if (authHuaweiId == null) {
            return false;
        }
        if (C5599ap.m32900a(list).booleanValue()) {
            return true;
        }
        return authHuaweiId.getAuthorizedScopes().containsAll(list);
    }

    public static void addAuthScopes(Fragment fragment, int i10, HuaweiIdAuthExtendedParams huaweiIdAuthExtendedParams) {
        if (huaweiIdAuthExtendedParams != null) {
            addAuthScopes(fragment, i10, huaweiIdAuthExtendedParams.getExtendedScopes());
            return;
        }
        throw new NullPointerException("HuaweiIdAuthExtendedParams should not be null");
    }

    public static void addAuthScopes(Activity activity, int i10, List<Scope> list) {
        if (activity == null) {
            throw new NullPointerException("Activity should not be null");
        }
        if (list != null) {
            try {
                activity.startActivityForResult(m36821a(activity, list), i10);
                return;
            } catch (Exception e10) {
                C5602as.m32912d("HuaweiIdAuthManager", "Exception：" + e10.getClass().getSimpleName(), true);
                return;
            }
        }
        throw new NullPointerException("ScopeList should not be null");
    }

    public static void addAuthScopes(Fragment fragment, int i10, List<Scope> list) {
        if (fragment == null) {
            throw new NullPointerException("Fragment should not be null");
        }
        if (list != null) {
            try {
                fragment.startActivityForResult(m36821a(fragment.getActivity(), list), i10);
                return;
            } catch (Exception e10) {
                C5602as.m32912d("HuaweiIdAuthManager", "Exception：" + e10.getClass().getSimpleName(), true);
                return;
            }
        }
        throw new NullPointerException("ScopeList should not be null");
    }
}
