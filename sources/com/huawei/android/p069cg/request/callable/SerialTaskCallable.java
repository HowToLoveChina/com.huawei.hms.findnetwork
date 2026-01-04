package com.huawei.android.p069cg.request.callable;

import android.content.Context;
import fk.C9721b;
import p031b7.C1120a;
import p031b7.C1122c;
import p511o6.C11822d;
import p581qk.AbstractC12367d;

/* loaded from: classes2.dex */
public class SerialTaskCallable extends AbstractC12367d {
    public static final String OKHTTP_CANCEL_ALL = "okhttpCancelAll";
    public static final String REPORT_SWITCH_DATA = "reportSwitchData";
    private static final String TAG = "SerialTaskCallable";
    private Context context;
    private boolean switchOn;
    private String taskType;

    public SerialTaskCallable(String str) {
        this.taskType = str;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        C1120a.m6677i(TAG, "Execute SerialTaskCallable TaskType:" + this.taskType);
        if (!OKHTTP_CANCEL_ALL.equals(this.taskType)) {
            if (REPORT_SWITCH_DATA.equals(this.taskType)) {
                if (this.switchOn) {
                    C1122c.m6750X1(this.context, "0:1", "OK", "04002", "generalswitch_on", C1122c.m6755Z0("04002"), true);
                    return;
                } else {
                    C1122c.m6750X1(this.context, "0:1", "OK", "04003", "generalswitch_off", C1122c.m6755Z0("04003"), true);
                    return;
                }
            }
            return;
        }
        try {
            C11822d.m70437a();
        } catch (Exception e10) {
            C1120a.m6676e(TAG, "cancelAll exception: " + e10.toString());
        }
    }

    public SerialTaskCallable(Context context, boolean z10, String str) {
        this.context = context;
        this.switchOn = z10;
        this.taskType = str;
    }
}
