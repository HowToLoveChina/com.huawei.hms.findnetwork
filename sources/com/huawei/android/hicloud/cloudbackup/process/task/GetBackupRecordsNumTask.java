package com.huawei.android.hicloud.cloudbackup.process.task;

import com.huawei.android.hicloud.cloudbackup.p076db.bean.Settings;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.hicloud.request.cbs.bean.CBSInitParam;
import fk.C9721b;
import p400jl.C10897a;
import p429kk.C11058a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;

/* loaded from: classes2.dex */
public class GetBackupRecordsNumTask extends AbstractC12367d {
    private static final String TAG = "GetBackupTimesTask";

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws Throwable {
        try {
            SettingOperator settingOperator = new SettingOperator();
            CBSInitParam cBSInitParamM65890a = new C10897a(C11058a.m66627b("00000")).m65890a(false);
            Settings settings = new Settings("backuptimes", String.valueOf(cBSInitParamM65890a.getTimes()), "2");
            C11839m.m70686d(TAG, "times = " + cBSInitParamM65890a.getTimes());
            settingOperator.replace(new Settings[]{settings});
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "refreshBackupTimes occur exception:" + e10.m60659c() + ":" + e10.toString());
        }
    }
}
