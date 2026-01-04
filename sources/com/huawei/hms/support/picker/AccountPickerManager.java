package com.huawei.hms.support.picker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.constant.AuthInternalPickerConstant;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.picker.common.AccountPickerUtil;
import com.huawei.hms.support.picker.request.AccountPickerParams;
import com.huawei.hms.support.picker.result.AccountPickerResult;
import com.huawei.hms.support.picker.result.AuthAccountPicker;
import com.huawei.hms.support.picker.service.AccountPickerService;
import com.huawei.hms.support.picker.service.AccountPickerServiceImpl;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public final class AccountPickerManager {
    public static AccountPickerService getService(Context context, AccountPickerParams accountPickerParams) {
        return new AccountPickerServiceImpl(context, accountPickerParams, AuthInternalPickerConstant.HMS_SDK_VERSION);
    }

    public static Task<AuthAccountPicker> parseAuthResultFromIntent(Intent intent) {
        C8941i c8941i = new C8941i();
        AccountPickerResult signInResultFromIntent = AccountPickerUtil.getSignInResultFromIntent(intent);
        if (signInResultFromIntent == null) {
            c8941i.m56657c(new ApiException(new Status(8)));
        } else if (!signInResultFromIntent.isSuccess() || signInResultFromIntent.getAuthAccountPicker() == null) {
            c8941i.m56657c(new ApiException(signInResultFromIntent.getStatus()));
        } else {
            c8941i.m56658d(signInResultFromIntent.getAuthAccountPicker());
        }
        return c8941i.m56656b();
    }

    public static AccountPickerService getService(Activity activity, AccountPickerParams accountPickerParams) {
        return new AccountPickerServiceImpl(activity, accountPickerParams, AuthInternalPickerConstant.HMS_SDK_VERSION);
    }

    public static AccountPickerService getService(Context context, AccountPickerParams accountPickerParams, int i10) {
        return new AccountPickerServiceImpl(context, accountPickerParams, AuthInternalPickerConstant.HMS_SDK_VERSION, i10);
    }

    public static AccountPickerService getService(Activity activity, AccountPickerParams accountPickerParams, int i10) {
        return new AccountPickerServiceImpl(activity, accountPickerParams, AuthInternalPickerConstant.HMS_SDK_VERSION, i10);
    }
}
