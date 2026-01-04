package com.huawei.hms.push.ups;

import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.AbstractC6285d;
import com.huawei.hms.push.HmsMessaging;
import com.huawei.hms.push.ups.entity.CodeResult;
import com.huawei.hms.push.ups.entity.TokenResult;
import com.huawei.hms.push.ups.entity.UPSRegisterCallBack;
import com.huawei.hms.push.ups.entity.UPSTurnCallBack;
import com.huawei.hms.push.ups.entity.UPSUnRegisterCallBack;
import com.huawei.hms.support.log.HMSLog;
import p208cq.InterfaceC8937e;

/* loaded from: classes8.dex */
public final class UPSService {
    private UPSService() {
    }

    public static void registerToken(Context context, String str, String str2, String str3, UPSRegisterCallBack uPSRegisterCallBack) {
        HMSLog.m36988i("UPSService", "invoke registerToken");
        Preconditions.checkNotNull(uPSRegisterCallBack);
        if (!AbstractC6285d.m36512b()) {
            uPSRegisterCallBack.onResult(new TokenResult(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.getExternalCode()));
            return;
        }
        try {
            uPSRegisterCallBack.onResult(new TokenResult(HmsInstanceId.getInstance(context).getToken(str, null)));
        } catch (ApiException e10) {
            uPSRegisterCallBack.onResult(new TokenResult(e10.getStatusCode(), e10.getMessage()));
        }
    }

    public static void turnOffPush(Context context, final UPSTurnCallBack uPSTurnCallBack) {
        HMSLog.m36988i("UPSService", "invoke turnOffPush");
        Preconditions.checkNotNull(uPSTurnCallBack);
        if (AbstractC6285d.m36512b()) {
            HmsMessaging.getInstance(context).turnOffPush().addOnCompleteListener(new InterfaceC8937e<Void>() { // from class: com.huawei.hms.push.ups.UPSService.2
                @Override // p208cq.InterfaceC8937e
                public void onComplete(Task<Void> task) {
                    if (task.isSuccessful()) {
                        uPSTurnCallBack.onResult(new CodeResult());
                    } else {
                        ApiException apiException = (ApiException) task.getException();
                        uPSTurnCallBack.onResult(new CodeResult(apiException.getStatusCode(), apiException.getMessage()));
                    }
                }
            });
        } else {
            uPSTurnCallBack.onResult(new TokenResult(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.getExternalCode()));
        }
    }

    public static void turnOnPush(Context context, final UPSTurnCallBack uPSTurnCallBack) {
        HMSLog.m36988i("UPSService", "invoke turnOnPush");
        Preconditions.checkNotNull(uPSTurnCallBack);
        if (AbstractC6285d.m36512b()) {
            HmsMessaging.getInstance(context).turnOnPush().addOnCompleteListener(new InterfaceC8937e<Void>() { // from class: com.huawei.hms.push.ups.UPSService.1
                @Override // p208cq.InterfaceC8937e
                public void onComplete(Task<Void> task) {
                    if (task.isSuccessful()) {
                        uPSTurnCallBack.onResult(new CodeResult());
                    } else {
                        ApiException apiException = (ApiException) task.getException();
                        uPSTurnCallBack.onResult(new CodeResult(apiException.getStatusCode(), apiException.getMessage()));
                    }
                }
            });
        } else {
            uPSTurnCallBack.onResult(new TokenResult(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.getExternalCode()));
        }
    }

    public static void unRegisterToken(Context context, UPSUnRegisterCallBack uPSUnRegisterCallBack) {
        HMSLog.m36988i("UPSService", "invoke unRegisterToken");
        Preconditions.checkNotNull(uPSUnRegisterCallBack);
        if (!AbstractC6285d.m36512b()) {
            uPSUnRegisterCallBack.onResult(new TokenResult(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.getExternalCode()));
            return;
        }
        try {
            HmsInstanceId.getInstance(context).deleteToken(null, null);
            uPSUnRegisterCallBack.onResult(new TokenResult());
        } catch (ApiException e10) {
            uPSUnRegisterCallBack.onResult(new TokenResult(e10.getStatusCode(), e10.getMessage()));
        }
    }
}
