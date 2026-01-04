package com.huawei.hms.support.account;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.constant.AuthInternalPickerConstant;
import com.huawei.hms.hwid.C5599ap;
import com.huawei.hms.hwid.C5602as;
import com.huawei.hms.hwid.C5607f;
import com.huawei.hms.support.account.common.AccountAuthException;
import com.huawei.hms.support.account.request.AccountAuthExtendedParams;
import com.huawei.hms.support.account.request.AccountAuthParams;
import com.huawei.hms.support.account.result.AccountAuthResult;
import com.huawei.hms.support.account.result.AuthAccount;
import com.huawei.hms.support.account.service.AccountAuthService;
import com.huawei.hms.support.account.service.AccountAuthServiceImpl;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.List;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public final class AccountAuthManager {
    /* renamed from: a */
    private static Intent m36625a(Activity activity, List<Scope> list) {
        return getService(activity, C5607f.m32920a(list)).getSignInIntent();
    }

    public static void addAuthScopes(Activity activity, int i10, AccountAuthExtendedParams accountAuthExtendedParams) {
        if (accountAuthExtendedParams == null) {
            throw new NullPointerException("AccountAuthExtendedParams should not be null");
        }
        addAuthScopes(activity, i10, accountAuthExtendedParams.getExtendedScopes());
    }

    public static boolean containScopes(AuthAccount authAccount, AccountAuthExtendedParams accountAuthExtendedParams) {
        if (accountAuthExtendedParams == null) {
            return false;
        }
        return containScopes(authAccount, accountAuthExtendedParams.getExtendedScopes());
    }

    public static AuthAccount getAuthResult() {
        return C5607f.m32925b();
    }

    public static AuthAccount getAuthResultWithScopes(List<Scope> list) throws AccountAuthException {
        if (C5599ap.m32900a(list).booleanValue()) {
            throw new AccountAuthException("ScopeList should not be empty");
        }
        AuthAccount authAccountM32925b = C5607f.m32925b();
        if (authAccountM32925b == null) {
            authAccountM32925b = new AuthAccount();
        }
        authAccountM32925b.requestExtraScopes(list);
        return authAccountM32925b;
    }

    public static AuthAccount getExtendedAuthResult(AccountAuthExtendedParams accountAuthExtendedParams) {
        if (accountAuthExtendedParams == null) {
            throw new NullPointerException("AccountAuthExtendedParams should not be null");
        }
        List<Scope> extendedScopes = accountAuthExtendedParams.getExtendedScopes();
        AuthAccount authAccountM32925b = C5607f.m32925b();
        if (authAccountM32925b == null) {
            authAccountM32925b = new AuthAccount();
        }
        return authAccountM32925b.requestExtraScopes(extendedScopes);
    }

    public static AccountAuthService getService(Context context, AccountAuthParams accountAuthParams) {
        return new AccountAuthServiceImpl(context, accountAuthParams, AuthInternalPickerConstant.HMS_SDK_VERSION);
    }

    public static Task<AuthAccount> parseAuthResultFromIntent(Intent intent) {
        C8941i c8941i = new C8941i();
        AccountAuthResult accountAuthResultM32921a = C5607f.m32921a(intent);
        if (accountAuthResultM32921a == null) {
            c8941i.m56657c(new ApiException(new Status(8)));
        } else if (!accountAuthResultM32921a.isSuccess() || accountAuthResultM32921a.getAccount() == null) {
            c8941i.m56657c(new ApiException(accountAuthResultM32921a.getStatus()));
        } else {
            c8941i.m56658d(accountAuthResultM32921a.getAccount());
        }
        return c8941i.m56656b();
    }

    public static AccountAuthService getService(Activity activity, AccountAuthParams accountAuthParams) {
        return new AccountAuthServiceImpl(activity, accountAuthParams, AuthInternalPickerConstant.HMS_SDK_VERSION);
    }

    public static boolean containScopes(AuthAccount authAccount, List<Scope> list) {
        if (authAccount == null) {
            return false;
        }
        if (C5599ap.m32900a(list).booleanValue()) {
            return true;
        }
        return authAccount.getAuthorizedScopes().containsAll(list);
    }

    public static void addAuthScopes(Fragment fragment, int i10, AccountAuthExtendedParams accountAuthExtendedParams) {
        if (accountAuthExtendedParams != null) {
            addAuthScopes(fragment, i10, accountAuthExtendedParams.getExtendedScopes());
            return;
        }
        throw new NullPointerException("AccountAuthExtendedParams should not be null");
    }

    public static void addAuthScopes(Activity activity, int i10, List<Scope> list) {
        if (activity == null) {
            throw new NullPointerException("Activity should not be null");
        }
        if (list != null) {
            try {
                activity.startActivityForResult(m36625a(activity, list), i10);
                return;
            } catch (Exception e10) {
                C5602as.m32912d("AccountAuthManager", "Exception：" + e10.getClass().getSimpleName(), true);
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
                fragment.startActivityForResult(m36625a(fragment.getActivity(), list), i10);
                return;
            } catch (Exception e10) {
                C5602as.m32912d("AccountAuthManager", "Exception：" + e10.getClass().getSimpleName(), true);
                return;
            }
        }
        throw new NullPointerException("ScopeList should not be null");
    }
}
