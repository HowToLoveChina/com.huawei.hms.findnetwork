package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import java.util.concurrent.Callable;

/* renamed from: com.huawei.hms.opendevice.a */
/* loaded from: classes8.dex */
public class CallableC6263a implements Callable<AAIDResult> {

    /* renamed from: a */
    private Context f29574a;

    public CallableC6263a(Context context) {
        this.f29574a = context;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AAIDResult call() throws Exception {
        Context context = this.f29574a;
        if (context == null) {
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
        String strM36413b = C6264b.m36413b(context);
        AAIDResult aAIDResult = new AAIDResult();
        aAIDResult.setId(strM36413b);
        return aAIDResult;
    }
}
