package com.huawei.android.hicloud.cloudbackup.util;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.feedback.mail.zip.p099sp.SharedPreferencesStorage;
import com.huawei.hicloud.notification.log.NotifyLogger;
import p015ak.C0212e0;

/* loaded from: classes2.dex */
public class TipPeriodCheckUtil {
    public static final String CHECKBACKUPSUCCESSCOUNT = "check_backup_success_count";
    private static final String TAG = "TipPeriodCheckUtil";

    public boolean checkBackupSuccessNotifyCount(Context context, String str) throws NumberFormatException {
        int i10;
        if (context == null) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            i10 = 0;
        } else {
            try {
                i10 = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                NotifyLogger.m29914e(TAG, "NumberFormatException");
            }
        }
        int iM1358h = C0212e0.m1358h(context, SharedPreferencesStorage.BACKUPOPTION_SPFILE, CHECKBACKUPSUCCESSCOUNT, 0);
        NotifyLogger.m29915i(TAG, " localCount " + iM1358h);
        return iM1358h + 1 > i10 || i10 <= 1;
    }
}
