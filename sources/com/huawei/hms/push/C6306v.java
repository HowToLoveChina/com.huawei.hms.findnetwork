package com.huawei.hms.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.init.AutoInitHelper;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.support.log.HMSLog;

/* renamed from: com.huawei.hms.push.v */
/* loaded from: classes8.dex */
public class C6306v {
    /* renamed from: a */
    public static ErrorEnum m36619a(Context context) {
        if (!TextUtils.isEmpty(BaseUtils.getLocalToken(context, null))) {
            return ErrorEnum.SUCCESS;
        }
        if (!AutoInitHelper.isAutoInitEnabled(context)) {
            HMSLog.m36986e("TokenUtil", "Token not exist");
            return ErrorEnum.ERROR_NO_TOKEN;
        }
        HMSLog.m36986e("TokenUtil", "Token not exist, try auto init");
        AutoInitHelper.doAutoInit(context);
        return ErrorEnum.ERROR_AUTO_INITIALIZING;
    }
}
