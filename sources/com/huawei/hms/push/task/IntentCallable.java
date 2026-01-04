package com.huawei.hms.push.task;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.PushNaming;
import java.util.concurrent.Callable;

/* loaded from: classes8.dex */
public class IntentCallable implements Callable<Void> {

    /* renamed from: a */
    private Context f29719a;

    /* renamed from: b */
    private Intent f29720b;

    /* renamed from: c */
    private String f29721c;

    public IntentCallable(Context context, Intent intent, String str) {
        this.f29719a = context;
        this.f29720b = intent;
        this.f29721c = str;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.f29719a.sendBroadcast(this.f29720b);
        PushBiUtil.reportExit(this.f29719a, PushNaming.SET_NOTIFY_FLAG, this.f29721c, ErrorEnum.SUCCESS);
        return null;
    }
}
