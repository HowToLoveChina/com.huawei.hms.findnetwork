package com.huawei.hms.findnetwork;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.api.HuaweiMobileServicesUtil;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.findnetwork.comm.exception.FindNetworkException;
import com.huawei.hms.findnetwork.comm.util.ErrorCode;
import com.huawei.hms.findnetwork.exception.FindNetworkNotMatchException;
import com.huawei.hms.findnetwork.sdk.C5399t;

/* loaded from: classes8.dex */
public class FindNetwork {
    private FindNetwork() {
    }

    private static boolean checkHMSCoreVersion(Context context) {
        return HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(context, 601000300) == 0;
    }

    private static FindNetworkEngine getFindNetworkApi(Context context) {
        FindNetworkEngine findNetworkEngine = context instanceof Activity ? new FindNetworkEngine((Activity) context) : new FindNetworkEngine(context);
        C5399t.m32099a().m32103a(findNetworkEngine);
        return findNetworkEngine;
    }

    public static FindNetworkEngine getFindNetworkEngine(Activity activity) throws FindNetworkException {
        Preconditions.checkNotNull(activity, "activity can not be null");
        if (checkHMSCoreVersion(activity)) {
            return getFindNetworkApi(activity);
        }
        throw new FindNetworkNotMatchException(ErrorCode.HMS_CORE_NOT_MATCH);
    }

    public static String getVersion() {
        return "6.15.2.320";
    }

    public static FindNetworkEngine getFindNetworkEngine(Context context) throws FindNetworkException {
        Preconditions.checkNotNull(context, "Context can not be null");
        if (checkHMSCoreVersion(context)) {
            return getFindNetworkApi(context);
        }
        throw new FindNetworkNotMatchException(ErrorCode.HMS_CORE_NOT_MATCH);
    }
}
