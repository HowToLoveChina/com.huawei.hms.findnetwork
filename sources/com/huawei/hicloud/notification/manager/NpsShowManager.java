package com.huawei.hicloud.notification.manager;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.frequency.FrequencyManager;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.phoneservice.feedbackcommon.utils.AsCache;
import java.io.File;
import java.text.SimpleDateFormat;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0241z;

/* loaded from: classes6.dex */
public class NpsShowManager {
    private static final long DAY_MILLIS = 86400000;
    private static final String ENTRY_BANNER = "banner";
    private static final String ENTRY_MENU = "menu";
    private static final Object LOCK = new Object();
    private static final long SECOND_MILLS = 1000;
    private static final String TAG = "NpsShowManager";
    private static final int TIME_HOURS = 24;
    private static final int TIME_INDEX_HOUR = 0;
    private static final int TIME_INDEX_MINUTE = 1;
    private static final int TIME_INDEX_SECOND = 2;
    private static final int TIME_LENGTH = 3;
    private static final int TIME_MINUTE = 60;
    private static final int TIME_SECONDES = 60;
    private static NpsShowManager instance;

    public static NpsShowManager getInstance() {
        NpsShowManager npsShowManager;
        synchronized (LOCK) {
            try {
                if (instance == null) {
                    instance = new NpsShowManager();
                }
                npsShowManager = instance;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return npsShowManager;
    }

    private long string2TimeStamp(String str) {
        String[] strArrSplit = str.split(":");
        if (strArrSplit.length != 3) {
            NotifyLogger.m29914e(TAG, "string2TimeStamp timeString format error");
            return 0L;
        }
        int iM1685c = C0241z.m1685c(strArrSplit[0]);
        int iM1685c2 = C0241z.m1685c(strArrSplit[1]);
        int iM1685c3 = C0241z.m1685c(strArrSplit[2]);
        if (iM1685c >= 0 && iM1685c2 >= 0 && iM1685c3 >= 0 && iM1685c <= 24 && iM1685c2 <= 60 && iM1685c3 <= 60) {
            return ((iM1685c * AsCache.TIME_HOUR) + (iM1685c2 * 60) + iM1685c3) * 1000;
        }
        NotifyLogger.m29914e(TAG, "string2TimeStamp timeString value error");
        return 0L;
    }

    public boolean checkBasicOmParams(Context context) {
        if (context == null) {
            NotifyLogger.m29915i(TAG, "checkBasicOmParams context is null");
            return false;
        }
        String strM1363m = C0212e0.m1363m(context, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_START_SHOW_DATE, "");
        String strM1363m2 = C0212e0.m1363m(context, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_END_SHOW_DATE, "");
        String strM1363m3 = C0212e0.m1363m(context, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_DAY_BEGIN_TIME, "");
        String strM1363m4 = C0212e0.m1363m(context, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_DAY_END_TIME, "");
        String strM1363m5 = C0212e0.m1363m(context, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_URL, "");
        String strM1363m6 = C0212e0.m1363m(context, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_PUSH_DATE, "");
        int iM1357g = C0212e0.m1357g(context, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_EFFECTIVE_DAY, 0);
        if (strM1363m6.isEmpty() || strM1363m.isEmpty() || strM1363m2.isEmpty() || strM1363m3.isEmpty() || strM1363m4.isEmpty() || strM1363m5.isEmpty()) {
            NotifyLogger.m29915i(TAG, "checkBasicOmParams some OM value is null");
            return false;
        }
        if (checkNpsHasClick()) {
            NotifyLogger.m29915i(TAG, "checkBasicOmParams has click");
            return false;
        }
        if (!checkDateValid(strM1363m6, iM1357g)) {
            NotifyLogger.m29915i(TAG, "checkBasicOmParams date is valid");
            return false;
        }
        if (checkTimeValid(strM1363m3, strM1363m4)) {
            NotifyLogger.m29915i(TAG, "checkBasicOmParams valid, show NPS menu");
            return true;
        }
        NotifyLogger.m29915i(TAG, "checkBasicOmParams time is valid");
        return false;
    }

    public boolean checkDateValid(String str, int i10) {
        try {
            long time = new SimpleDateFormat("yyyy-MM-dd").parse(str).getTime();
            long j10 = (i10 * 86400000) + time;
            long jCurrentTimeMillis = System.currentTimeMillis();
            return jCurrentTimeMillis >= time && jCurrentTimeMillis <= j10;
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "checkDateValid date check error: " + e10.toString());
            return false;
        }
    }

    public boolean checkIsNeedShowNPSBanner(Context context) {
        if (context == null) {
            NotifyLogger.m29915i(TAG, "checkIsNeedShowNPSBanner context is null");
            return false;
        }
        String strM1363m = C0212e0.m1363m(context, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_ENTRY, "");
        if (!ENTRY_BANNER.equals(strM1363m)) {
            NotifyLogger.m29915i(TAG, "checkIsNeedShowNPSBanner is not entry" + strM1363m);
            return false;
        }
        if (!checkBasicOmParams(context)) {
            NotifyLogger.m29915i(TAG, "checkIsNeedShowNPSBanner basic param");
            return false;
        }
        String strM1363m2 = C0212e0.m1363m(context, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_BANNER_PICTURE_SECOND_URL, "");
        if (TextUtils.isEmpty(strM1363m2)) {
            NotifyLogger.m29915i(TAG, "checkIsNeedShowNPSBanner pictureSecondUrl is null");
            return false;
        }
        String strM1364n = C0212e0.m1364n(context, RecommendCardConstants.C4910Sp.PICTURE_CACHE_FILE_NAME, strM1363m2, "");
        if (TextUtils.isEmpty(strM1364n)) {
            NotifyLogger.m29915i(TAG, "checkIsNeedShowNPSBanner pictureSecondPath is null");
            return false;
        }
        try {
            boolean zExists = new File(strM1364n).exists();
            NotifyLogger.m29915i(TAG, "checkIsNeedShowNPSBanner file is exist: " + zExists);
            return zExists;
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "checkIsNeedShowNPSBanner exception: " + e10.toString());
            return false;
        }
    }

    public boolean checkIsNeedShowNPSMenu(Context context) {
        if (context == null) {
            NotifyLogger.m29915i(TAG, "checkIsNeedShowNPSMenu context is null");
            return false;
        }
        if (ENTRY_MENU.equals(C0212e0.m1363m(context, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_ENTRY, ""))) {
            return checkBasicOmParams(context);
        }
        NotifyLogger.m29915i(TAG, "checkIsNeedShowNPSMenu entry is not menu");
        return false;
    }

    public boolean checkNpsHasClick() {
        Context contextM1377a = C0213f.m1377a();
        String strM1363m = C0212e0.m1363m(contextM1377a, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_ID, "");
        if (TextUtils.isEmpty(strM1363m)) {
            return true;
        }
        return strM1363m.equals(C0212e0.m1363m(contextM1377a, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_CLICK_ID, ""));
    }

    public boolean checkOpenUrl(Context context) {
        if (context == null) {
            NotifyLogger.m29915i(TAG, "checkOpenUrl context is null");
            return false;
        }
        String strM1363m = C0212e0.m1363m(context, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_START_SHOW_DATE, "");
        String strM1363m2 = C0212e0.m1363m(context, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_END_SHOW_DATE, "");
        String strM1363m3 = C0212e0.m1363m(context, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_URL, "");
        String strM1363m4 = C0212e0.m1363m(context, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_PUSH_DATE, "");
        int iM1357g = C0212e0.m1357g(context, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_EFFECTIVE_DAY, 0);
        if (strM1363m4.isEmpty() || strM1363m.isEmpty() || strM1363m2.isEmpty() || strM1363m3.isEmpty()) {
            NotifyLogger.m29915i(TAG, "checkOpenUrl some OM value is null");
            return false;
        }
        if (checkNpsHasClick()) {
            NotifyLogger.m29915i(TAG, "checkOpenUrl has click");
            return false;
        }
        if (checkDateValid(strM1363m4, iM1357g)) {
            return true;
        }
        NotifyLogger.m29915i(TAG, "checkOpenUrl date is valid");
        return false;
    }

    public boolean checkTimeValid(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            long jCurrentTimeMillis = (System.currentTimeMillis() + simpleDateFormat.getTimeZone().getRawOffset()) % 86400000;
            long jString2TimeStamp = string2TimeStamp(str);
            long jString2TimeStamp2 = string2TimeStamp(str2);
            if (jString2TimeStamp <= jCurrentTimeMillis && jString2TimeStamp2 >= jCurrentTimeMillis) {
                return true;
            }
            NotifyLogger.m29915i(TAG, "checkIsNeedShowNPSMenu time is invalid");
            return false;
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "clickVersionCode time check error: " + e10.toString());
            return false;
        }
    }
}
