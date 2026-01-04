package com.huawei.android.hicloud.cloudbackup.service;

import android.content.Context;
import android.text.TextUtils;
import p015ak.C0206b0;
import p514o9.C11839m;
import p581qk.AbstractC12369f;
import p711vl.C13464d;

/* loaded from: classes2.dex */
public class CBNotifyTimer extends AbstractC12369f {
    private static final long DAY_SECONDS = 86400;
    private static final String TAG = "CBNotifyTimer";
    private Context context;

    public CBNotifyTimer(Context context) {
        super(0L, 86400L);
        this.context = context;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        if (C0206b0.m1131c("backup_key", this.context)) {
            if (TextUtils.equals(C13464d.m81030f(this.context).m81039j("backup_end_code", ""), "001_1007")) {
                C11839m.m70688i(TAG, "doNotifyCheck internal nosapce return");
            } else {
                ICBServiceProtocol.getInstance().doBackupNotify();
            }
        }
    }
}
