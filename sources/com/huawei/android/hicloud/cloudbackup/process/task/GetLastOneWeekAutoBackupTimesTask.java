package com.huawei.android.hicloud.cloudbackup.process.task;

import android.os.Message;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import tl.C13027f;

/* loaded from: classes2.dex */
public class GetLastOneWeekAutoBackupTimesTask extends AbstractC12367d {
    private static final String TAG = "GetLastOneWeekAutoBackupTimesTask";

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        C11839m.m70688i(TAG, "GetLastOneWeekBackupTimesTask start");
        Message messageObtain = Message.obtain();
        long jM78410h = new C13027f().m78410h(System.currentTimeMillis() - 604800000);
        int i10 = (int) (jM78410h / 60000);
        if (jM78410h > 0 && jM78410h < 60000) {
            i10 = 1;
        }
        C11839m.m70688i(TAG, "GetLastOneWeekBackupTimesTask end sumBackupTimes: " + jM78410h + " minute: " + i10);
        messageObtain.arg1 = i10;
        messageObtain.what = 3211;
        CBCallBack.getInstance().sendMessage(messageObtain);
    }
}
