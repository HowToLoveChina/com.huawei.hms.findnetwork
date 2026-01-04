package com.huawei.android.hicloud.cloudbackup.process.task;

import android.os.Message;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.process.util.ICycleChecker;
import java.util.Calendar;
import java.util.function.Predicate;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p618rm.C12590s0;
import tl.C13027f;

/* loaded from: classes2.dex */
public class GetNextBackupTimesTask extends AbstractC12367d {
    private static final int DEFAULT_DATE = 1;
    private static final int DEFAULT_HOUR = 23;
    private static final int DEFAULT_MINUTE = 0;
    private static final int DEFAULT_MONTH = 1;
    private static final int DEFAULT_YEAR = 1970;
    private static final String TAG = "GetNextBackupTimesTask";

    private long getDuration(long j10, long j11) {
        long j12 = j11 % 86400000;
        long j13 = j10 % 86400000;
        ICycleChecker iCycleChecker = ICycleChecker.get(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.k0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return GetNextBackupTimesTask.lambda$getDuration$0((ICycleChecker) obj);
            }
        });
        if (iCycleChecker.getType() != "2") {
            C11839m.m70688i(TAG, "getoldDuration theDayTime:" + j12 + " ,currentDayTime: " + j13);
            return getOldDuration(j12, j13);
        }
        if (!iCycleChecker.isCycleSatisfy()) {
            long targetBackupTime = iCycleChecker.getTargetBackupTime();
            long j14 = targetBackupTime - j10;
            C11839m.m70688i(TAG, "getDuration targetBackupTime:" + targetBackupTime + " ,duration: " + j14);
            return j14;
        }
        long jM75872l0 = j12 - j13;
        long j15 = jM75872l0 > 0 ? jM75872l0 : 0L;
        long j16 = j10 + j15;
        boolean zIsCycleSatisfy = iCycleChecker.isCycleSatisfy(j16);
        if (!zIsCycleSatisfy || jM75872l0 <= 0) {
            jM75872l0 = C12590s0.m75872l0() - j10;
        }
        C11839m.m70688i(TAG, "getDuration duration:" + jM75872l0 + " ,avgDuration: " + j15 + " ,avgStartTimesExact: " + j16 + " ,satisfy: " + zIsCycleSatisfy);
        return jM75872l0;
    }

    private long getOldDuration(long j10, long j11) {
        return j10 > j11 ? j10 - j11 : 86400000 - (j11 - j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getDuration$0(ICycleChecker iCycleChecker) {
        return !"1".equals(iCycleChecker.getType());
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        C11839m.m70688i(TAG, "GetNextBackupTimesTask start");
        C13027f c13027f = new C13027f();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jM78407e = c13027f.m78407e(jCurrentTimeMillis - 604800000);
        if (jM78407e <= 0) {
            C11839m.m70686d(TAG, "GetNextBackupTimesTask avgStartTimes default time ");
            Calendar calendar = Calendar.getInstance();
            calendar.clear();
            calendar.set(DEFAULT_YEAR, 1, 1, 23, 0);
            jM78407e = calendar.getTimeInMillis();
        }
        int duration = (int) (getDuration(jCurrentTimeMillis, jM78407e) / 60000);
        if (duration <= 0) {
            duration = 1;
        }
        C11839m.m70688i(TAG, "GetNextBackupTimesTask end avgStartTime:" + jM78407e + " ,time: " + duration);
        Message messageObtain = Message.obtain();
        messageObtain.arg1 = duration;
        messageObtain.what = 3212;
        CBCallBack.getInstance().sendMessage(messageObtain);
    }
}
