package com.huawei.hicloud.notification.config;

import android.content.SharedPreferences;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.SNTimes;
import java.util.Calendar;
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0234s;

/* loaded from: classes6.dex */
public class HNUtil {
    private static final String TAG = "HNUtil";

    public static String getCurrentBaseLanguage() {
        return C0234s.m1636n();
    }

    public static String getCurrentLanguage() {
        return C0234s.m1631i();
    }

    public static SharedPreferences getNotificationSP() {
        return C0214f0.m1382b(C0213f.m1377a(), "notification", 0);
    }

    public static SNTimes getNowTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(2);
        int i10 = calendar.get(3);
        int i11 = calendar.get(5);
        int i12 = calendar.get(2);
        int i13 = calendar.get(1);
        long timeInMillis = calendar.getTimeInMillis();
        SNTimes sNTimes = new SNTimes();
        sNTimes.setTime(timeInMillis);
        sNTimes.setDay(i11);
        sNTimes.setMonth(i12);
        sNTimes.setWeek(i10);
        sNTimes.setYear(i13);
        NotifyLogger.m29915i(TAG, "time=" + timeInMillis + " week=" + i10 + " day=" + i11 + " month=" + i12 + " year=" + i13);
        return sNTimes;
    }
}
