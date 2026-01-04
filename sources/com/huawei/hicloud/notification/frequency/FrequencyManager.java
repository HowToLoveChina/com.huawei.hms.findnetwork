package com.huawei.hicloud.notification.frequency;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import com.huawei.hicloud.notification.manager.UserNegFeedbackManager;
import com.huawei.hicloud.notification.p106db.bean.BaseNotifyBean;
import com.huawei.hicloud.notification.p106db.operator.NDCOperator;
import com.huawei.hicloud.notification.p106db.operator.SpaceNotifyFrequencyOperator;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import p015ak.C0209d;
import p015ak.C0212e0;

/* loaded from: classes6.dex */
public class FrequencyManager {
    public static final String BACKUP_COUPON_SHOW_TIME = "backup_coupon_show_time";
    public static final String CHECKBACKUPCYCLENOTIFYTIME = "check_backup_cycle_notify_time";
    public static final String CHECKBACKUPFAILDIALOGTIME = "check_backup_fail_dialog_time";
    public static final String CHECKBACKUPFAILNOTIFYSP = "check_backup_fail_notify_sp";
    public static final String CHECKBACKUPFAILNOTIFYTIME = "check_backup_fail_notify_time";
    public static final String CHECKBACKUPSUCCESSTIME = "check_backup_success_notify_time";
    public static final String CHECK_GUID_H5_DATA_RECORDSP = "check_guid_h5_dialog_data_record_sp";
    public static final String CHECK_GUID_H5_DIALOG_SP = "check_guid_h5_dialog_sp";
    public static final String CHECK_GUID_H5_DIALOG_TIME = "check_guid_h5_dialog_time";
    public static final String CHECK_GUID_H5_RECOMMEND_DATA_RECORD_ACTIVEURL = "check_guid_h5_dialog_recommend_data_activeurl";
    public static final String CHECK_GUID_H5_RECOMMEND_DATA_RECORD_BEGINTIME = "check_guid_h5_dialog_recommend_data_beginTime";
    public static final String CHECK_GUID_H5_RECOMMEND_DATA_RECORD_ENDTIME = "check_guid_h5_dialog_recommend_data_endTime";
    public static final String CHECK_GUID_H5_RECOMMEND_DATA_RECORD_FREQUENCY = "check_guid_h5_dialog_recommend_data_frequency";
    public static final String CHECK_GUID_H5_RECOMMEND_DATA_RECORD_H5URL = "check_guid_h5_dialog_recommend_data_h5url";
    public static final String CHECK_GUID_H5_RECOMMEND_DATA_RECORD_INTERVAL = "check_guid_h5_dialog_recommend_data_interval";
    public static final String CHECK_GUID_H5_RECOMMEND_DATA_RECORD_NOTIFYTYPE = "check_guid_h5_dialog_recommend_data_notifytype";
    public static final String CHECK_GUID_H5_RECOMMEND_DATA_RECORD_NOTIFYURL = "check_guid_h5_dialog_recommend_data_notifyurl";
    public static final String CHECK_GUID_H5_RECOMMEND_DATA_RECORD_NUM = "check_guid_h5_dialog_recommend_data_num";
    public static final String CHECK_GUID_H5_RECOMMEND_DATA_RECORD_PACKAGEID = "check_guid_h5_dialog_recommend_data_packageid";
    public static final String CHECK_GUID_H5_RECOMMEND_DATA_RECORD_PAGETYPE = "check_guid_h5_dialog_recommend_data_pageType";
    public static final String CHECK_GUID_H5_RECOMMEND_DATA_RECORD_SCENETYPE = "check_guid_h5_dialog_recommend_data_sceneType";
    public static final String CHECK_GUID_H5_UPDATE_DATA_RECORD_ACTIVEURL = "check_guid_h5_dialog_update_data_activeurl";
    public static final String CHECK_GUID_H5_UPDATE_DATA_RECORD_BEGINTIME = "check_guid_h5_dialog_update_data_beginTime";
    public static final String CHECK_GUID_H5_UPDATE_DATA_RECORD_ENDTIME = "check_guid_h5_dialog_update_data_endTime";
    public static final String CHECK_GUID_H5_UPDATE_DATA_RECORD_FREQUENCY = "check_guid_h5_dialog_update_data_frequency";
    public static final String CHECK_GUID_H5_UPDATE_DATA_RECORD_H5URL = "check_guid_h5_dialog_update_data_h5url";
    public static final String CHECK_GUID_H5_UPDATE_DATA_RECORD_INTERVAL = "check_guid_h5_dialog_update_data_interval";
    public static final String CHECK_GUID_H5_UPDATE_DATA_RECORD_NOTIFYTYPE = "check_guid_h5_dialog_update_data_notifytype";
    public static final String CHECK_GUID_H5_UPDATE_DATA_RECORD_NOTIFYURL = "check_guid_h5_dialog_update_data_notifyurl";
    public static final String CHECK_GUID_H5_UPDATE_DATA_RECORD_NUM = "check_guid_h5_dialog_update_data_num";
    public static final String CHECK_GUID_H5_UPDATE_DATA_RECORD_PACKAGEID = "check_guid_h5_dialog_update_data_packageid";
    public static final String CHECK_GUID_H5_UPDATE_DATA_RECORD_PAGETYPE = "check_guid_h5_dialog_update_data_pageType";
    public static final String CHECK_GUID_H5_UPDATE_DATA_RECORD_SCENETYPE = "check_guid_h5_dialog_update_data_sceneType";
    public static final String CHECK_NSP_SHOW_INFO_SP = "check_nsp_show_info_sp";
    public static final String CHECK_NSP_UPDATE_DATA_BANNER_LANDSCAPE_URL = "check_nsp_update_data_banner_landscape_url";
    public static final String CHECK_NSP_UPDATE_DATA_BANNER_PICTURE_SECOND_URL = "check_nsp_update_data_banner_picture_second_url";
    public static final String CHECK_NSP_UPDATE_DATA_BANNER_URL = "check_nsp_update_data_banner_url";
    public static final String CHECK_NSP_UPDATE_DATA_BUTTON_ID = "check_nsp_update_data_button_id";
    public static final String CHECK_NSP_UPDATE_DATA_CLICK_ID = "check_nsp_update_data_click_id";
    public static final String CHECK_NSP_UPDATE_DATA_DAY_BEGIN_TIME = "check_nsp_update_data_day_begin_time";
    public static final String CHECK_NSP_UPDATE_DATA_DAY_END_TIME = "check_nsp_update_data_day_end_time";
    public static final String CHECK_NSP_UPDATE_DATA_DESCRIPTION_ID = "check_nsp_update_data_description_id";
    public static final String CHECK_NSP_UPDATE_DATA_EFFECTIVE_DAY = "check_nsp_update_data_effect_day";
    public static final String CHECK_NSP_UPDATE_DATA_END_SHOW_DATE = "check_nsp_update_data_end_show_date";
    public static final String CHECK_NSP_UPDATE_DATA_ENTRY = "check_nsp_update_data_entry";
    public static final String CHECK_NSP_UPDATE_DATA_ID = "check_nsp_update_data_id";
    public static final String CHECK_NSP_UPDATE_DATA_PUSH_DATE = "check_nsp_update_data_push_date";
    public static final String CHECK_NSP_UPDATE_DATA_REMARK_ID = "check_nsp_update_data_remark_id";
    public static final String CHECK_NSP_UPDATE_DATA_START_SHOW_DATE = "check_nsp_update_data_start_show_date";
    public static final String CHECK_NSP_UPDATE_DATA_TITLE_ID = "check_nsp_update_data_title_id";
    public static final String CHECK_NSP_UPDATE_DATA_URL = "check_nsp_update_data_url";
    public static final String CHECK_NSP_UPDATE_DATA_URL_PARAMS = "check_nsp_update_data_url_params";
    public static final String HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP = "homepage_guid_h5_dialog_entry_data_record_sp";
    public static final String HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_ACTIVEURL = "homepage_guid_h5_dialog_entry_data_activeurl";
    public static final String HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_BEGINTIME = "homepage_guid_h5_dialog_entry_data_beginTime";
    public static final String HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_ENDTIME = "homepage_guid_h5_dialog_entry_data_endTime";
    public static final String HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_FREQUENCY = "homepage_guid_h5_dialog_entry_data_frequency";
    public static final String HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_H5URL = "homepage_guid_h5_dialog_entry_data_h5url";
    public static final String HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_INTERVAL = "homepage_guid_h5_dialog_entry_data_interval";
    public static final String HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_NOTIFYTYPE = "homepage_guid_h5_dialog_entry_data_notifytype";
    public static final String HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_NOTIFYURL = "homepage_guid_h5_dialog_entry_data_notifyurl";
    public static final String HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_NUM = "homepage_guid_h5_dialog_entry_data_num";
    public static final String HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_PACKAGEID = "homepage_guid_h5_dialog_entry_data_packageid";
    public static final String HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_PAGETYPE = "homepage_guid_h5_dialog_entry_data_pageType";
    public static final String HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_SCENETYPE = "homepage_guid_h5_dialog_entry_data_sceneType";
    public static final String HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP = "homepage_guid_h5_exit_dialog_data_record_sp";
    public static final String HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_ACTIVEURL = "homepage_guid_h5_exit_dialog_data_activeurl";
    public static final String HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_BEGINTIME = "homepage_guid_h5_exit_dialog_data_beginTime";
    public static final String HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_ENDTIME = "homepage_guid_h5_exit_dialog_data_endTime";
    public static final String HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_FREQUENCY = "homepage_guid_h5_exit_dialog_data_frequency";
    public static final String HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_H5URL = "homepage_guid_h5_exit_dialog_data_h5url";
    public static final String HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_INTERVAL = "homepage_guid_h5_exit_dialog_data_interval";
    public static final String HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_NOTIFYTYPE = "homepage_guid_h5_exit_dialog_data_notifytype";
    public static final String HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_NOTIFYURL = "homepage_guid_h5_exit_dialog_data_notifyurl";
    public static final String HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_NUM = "homepage_guid_h5_exit_dialog_data_num";
    public static final String HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_PACKAGEID = "homepage_guid_h5_exit_dialog_data_packageid";
    public static final String HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_PAGETYPE = "homepage_guid_h5_exit_dialog_data_pageType";
    public static final String HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_SCENETYPE = "homepage_guid_h5_exit_dialog_data_sceneType";
    private static final String TAG = "FrequencyChecker";

    public interface H5DialogConstant {
        public static final String ACTIVEURL = "activeurl";
        public static final String BEGIN_TIME = "beginTime";
        public static final String CHECK_GUID_H5_RECOMMEND_DATA_RECORD_PREFIX = "check_guid_h5_dialog_recommend_data";
        public static final String CHECK_GUID_H5_UPDATE_DATA_RECORD_PREFIX = "check_guid_h5_dialog_update_data";
        public static final String END_TIME = "endTime";
        public static final String ENTER_SP_NAME_SUFFIX = "h5_dialog_entry_data_sp";
        public static final String ENTRY_DATA = "entry_data";
        public static final String EXIT_DATA = "exit_data";
        public static final String EXIT_SP_NAME_SUFFIX = "h5_dialog_exit_data_sp";
        public static final String EXPIRETIME = "expireTime";
        public static final String FREQUENCY = "frequency";
        public static final String FROM_WHICH_ACTIVITY = "fromWhichAcitivity";
        public static final String GRADECODE = "gradeCode";
        public static final String H5URL = "h5url";
        public static final String H5_DIALOG = "h5_dialog";
        public static final String HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_PREFIX = "homepage_guid_h5_dialog_entry_data";
        public static final String HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_PREFIX = "homepage_guid_h5_exit_dialog_data";
        public static final String INTERVAL = "interval";
        public static final String NOTIFYTYPE = "notifytype";
        public static final String NOTIFYURL = "notifyurl";
        public static final String NUM = "num";
        public static final String PACKAGEID = "packageid";
        public static final String PAGETYPE = "pageType";
        public static final String SCENETYPE = "sceneType";
    }

    public static boolean checkInValidTime(Context context, String str) {
        String strM1363m;
        String strM1363m2;
        String strM1363m3;
        str.hashCode();
        switch (str) {
            case "check_guid_h5_dialog_update_data_pageType":
                strM1363m = C0212e0.m1363m(context, CHECK_GUID_H5_DATA_RECORDSP, CHECK_GUID_H5_UPDATE_DATA_RECORD_BEGINTIME, "");
                strM1363m2 = C0212e0.m1363m(context, CHECK_GUID_H5_DATA_RECORDSP, CHECK_GUID_H5_UPDATE_DATA_RECORD_ENDTIME, "");
                strM1363m3 = strM1363m;
                return checkInValidTimeCommon(strM1363m3, strM1363m2);
            case "homepage_guid_h5_dialog_entry_data_record_sp":
                strM1363m3 = C0212e0.m1363m(context, HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_BEGINTIME, "");
                strM1363m2 = C0212e0.m1363m(context, HOMEPAGE_GUID_H5_ENTRY_DATA_RECORDSP, HOMEPAGE_GUID_H5_ENTRY_DATA_RECORD_ENDTIME, "");
                return checkInValidTimeCommon(strM1363m3, strM1363m2);
            case "check_guid_h5_dialog_recommend_data_pageType":
                strM1363m = C0212e0.m1363m(context, CHECK_GUID_H5_DATA_RECORDSP, CHECK_GUID_H5_RECOMMEND_DATA_RECORD_BEGINTIME, "");
                strM1363m2 = C0212e0.m1363m(context, CHECK_GUID_H5_DATA_RECORDSP, CHECK_GUID_H5_RECOMMEND_DATA_RECORD_ENDTIME, "");
                strM1363m3 = strM1363m;
                return checkInValidTimeCommon(strM1363m3, strM1363m2);
            case "homepage_guid_h5_exit_dialog_data_record_sp":
                strM1363m3 = C0212e0.m1363m(context, HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_BEGINTIME, "");
                strM1363m2 = C0212e0.m1363m(context, HOMEPAGE_GUID_H5_EXIT_DATA_RECORDSP, HOMEPAGE_GUID_H5_EXIT_DATA_RECORD_ENDTIME, "");
                return checkInValidTimeCommon(strM1363m3, strM1363m2);
            default:
                return true;
        }
    }

    public static boolean checkInValidTimeCommon(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            NotifyLogger.m29915i(TAG, "checkValidTime TextUtils.isEmpty(beginTime) || TextUtils.isEmpty(endTime)");
            return true;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long time = simpleDateFormat.parse(str).getTime();
            long time2 = simpleDateFormat.parse(str2).getTime();
            if (time <= jCurrentTimeMillis && jCurrentTimeMillis <= time2) {
                return false;
            }
            NotifyLogger.m29915i(TAG, "checkValidTime beginTimeStamp > currentDateTime || currentDateTime > endTimeStamp");
            return true;
        } catch (Exception e10) {
            NotifyLogger.m29915i(TAG, "checkValidTime time ParseException: " + e10.toString());
            return true;
        }
    }

    private boolean checkTime(float f10, long j10) {
        if (j10 == 0) {
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - j10;
        float f11 = jCurrentTimeMillis / 3600000.0f;
        float f12 = f10 * 24.0f;
        NotifyLogger.m29915i(TAG, "check rule frequency, last:" + j10 + ", millisGap:" + jCurrentTimeMillis + ", hoursGap=" + f11 + ", hoursLimit=" + f12);
        return f11 > f12;
    }

    private boolean checkTimeForBackupFail(float f10, long j10) {
        if (j10 == 0) {
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j11 = jCurrentTimeMillis - j10;
        float f11 = j11 / 3600000.0f;
        float f12 = 24.0f * f10;
        String strM1274k2 = C0209d.m1274k2(jCurrentTimeMillis);
        String strM1274k22 = C0209d.m1274k2(j10);
        NotifyLogger.m29915i(TAG, "check rule frequency, last:" + j10 + ", millisGap:" + j11 + ", hoursGap=" + f11 + ", hoursLimit=" + f12);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("currentTime=");
        stringBuffer.append(jCurrentTimeMillis);
        stringBuffer.append(",lastTimeStamp=");
        stringBuffer.append(j10);
        stringBuffer.append(",millisGap=");
        stringBuffer.append(j11);
        stringBuffer.append(",hoursGap=");
        stringBuffer.append(f11);
        stringBuffer.append(",hoursLimit=");
        stringBuffer.append(f12);
        stringBuffer.append(",frequency=");
        stringBuffer.append(f10);
        stringBuffer.append(",currentTimeReadable=");
        stringBuffer.append(strM1274k2);
        stringBuffer.append(",lastTimeReadable=");
        stringBuffer.append(strM1274k22);
        NotificationReportUtil.reportCloudBackupFrequency(NotifyConstants.NotificationReport.KEY_BACKUP_NOTIFY_FREQUENCY_CHECK, stringBuffer.toString());
        return f11 > f12;
    }

    private boolean timeStampLessThanOneDay(long j10) {
        return Math.abs(System.currentTimeMillis() - j10) < 86400000;
    }

    public boolean checkBackupCycleNotifyFrequency(Context context, String str, float f10) {
        if (context == null || !NotifyConstants.BACKUP_CYCLE.equals(str)) {
            return false;
        }
        long jM1359i = C0212e0.m1359i(context, CHECKBACKUPFAILNOTIFYSP, CHECKBACKUPCYCLENOTIFYTIME, 0L);
        NotifyLogger.m29915i(TAG, "checkBackupCycleNotifyFrequency lastTimeStamp : " + jM1359i);
        return checkTime(f10, jM1359i);
    }

    public boolean checkBackupCycleNotifyTime(Context context) {
        if (!timeStampLessThanOneDay(C0212e0.m1359i(context, CHECKBACKUPFAILNOTIFYSP, CHECKBACKUPCYCLENOTIFYTIME, 0L))) {
            return true;
        }
        NotifyLogger.m29915i(TAG, "last show backup cycle less than one day");
        return false;
    }

    public boolean checkBackupFailDialogFrequency(Context context, BaseNotifyBean baseNotifyBean) {
        if (context == null) {
            NotifyLogger.m29914e(TAG, "checkBackupFailNotifyFrequency context is null.");
            return false;
        }
        if (baseNotifyBean == null) {
            NotifyLogger.m29914e(TAG, "checkBackupFailNotifyFrequency notifyBean is null.");
            return false;
        }
        String noticeType = baseNotifyBean.getNoticeType();
        if (!NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT.equals(noticeType)) {
            NotifyLogger.m29914e(TAG, "checkBackupFailNotifyFrequency noticeType is err. noticeType = " + noticeType);
        }
        long jM1359i = C0212e0.m1359i(context, CHECKBACKUPFAILNOTIFYSP, CHECKBACKUPFAILDIALOGTIME, 0L);
        NotifyLogger.m29915i(TAG, "checkBackupFailNotifyFrequency lastTimeStamp : " + jM1359i);
        return checkTimeForBackupFail(UserNegFeedbackManager.getInstance(context).getDayPeriod(baseNotifyBean), jM1359i);
    }

    public boolean checkBackupFailNotifyFrequency(Context context, BaseNotifyBean baseNotifyBean) {
        if (context == null) {
            NotifyLogger.m29914e(TAG, "checkBackupFailNotifyFrequency context is null.");
            return false;
        }
        if (baseNotifyBean == null) {
            NotifyLogger.m29914e(TAG, "checkBackupFailNotifyFrequency notifyBean is null.");
            return false;
        }
        String noticeType = baseNotifyBean.getNoticeType();
        if (!NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT.equals(noticeType)) {
            NotifyLogger.m29914e(TAG, "checkBackupFailNotifyFrequency noticeType is err. noticeType = " + noticeType);
        }
        long jM1359i = C0212e0.m1359i(context, CHECKBACKUPFAILNOTIFYSP, CHECKBACKUPFAILNOTIFYTIME, 0L);
        NotifyLogger.m29915i(TAG, "checkBackupFailNotifyFrequency lastTimeStamp : " + jM1359i);
        return checkTimeForBackupFail(baseNotifyBean.getFrequency(), jM1359i);
    }

    public boolean checkBackupFailedNotifyTime(Context context) {
        if (!timeStampLessThanOneDay(C0212e0.m1359i(context, CHECKBACKUPFAILNOTIFYSP, CHECKBACKUPFAILNOTIFYTIME, 0L))) {
            return true;
        }
        NotifyLogger.m29915i(TAG, "last show backup failed less than one day");
        return false;
    }

    public boolean checkBackupSuccessNotifyFrequency(Context context, String str, float f10) {
        if (context == null) {
            return false;
        }
        long jM1360j = C0212e0.m1360j(context, str, CHECKBACKUPSUCCESSTIME, 0L);
        NotifyLogger.m29915i(TAG, " dayCount " + jM1360j);
        return checkTime(f10, jM1360j);
    }

    public boolean checkCouponFrequence(Context context, float f10) {
        long jM1359i = C0212e0.m1359i(context, CHECKBACKUPFAILNOTIFYSP, BACKUP_COUPON_SHOW_TIME, 0L);
        if (jM1359i == 0) {
            return true;
        }
        return ((float) (System.currentTimeMillis() - jM1359i)) > (f10 * 24.0f) * 3600000.0f;
    }

    public boolean checkGuiH5Dialog(Context context, int i10, long j10, int i11) {
        NotifyLogger.m29915i(TAG, " QueryGuideH5Task checkGuiH5DialogFrequency lastTimeStamp: " + j10 + "  (System.currentTimeMillis() - lastTimeStamp): " + (System.currentTimeMillis() - j10));
        switch (i10) {
            case 0:
                NotifyLogger.m29915i(TAG, "QueryGuideH5Task checkGuiH5Dialog  lastIntervalTime: " + i11);
                if (System.currentTimeMillis() - j10 > i11 * 1000) {
                }
                break;
            case 1:
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                String str = simpleDateFormat.format(Long.valueOf(j10));
                String str2 = simpleDateFormat.format((Date) timestamp);
                NotifyLogger.m29915i(TAG, "QueryGuideH5Task lastTime:" + str + ", nowTime:" + str2);
                if (!str2.equals(str)) {
                }
                break;
            case 2:
            case 3:
            case 4:
                if (System.currentTimeMillis() - j10 > (i10 - 1) * 86400000) {
                }
                break;
            case 5:
                if (System.currentTimeMillis() - j10 > 604800000) {
                }
                break;
            case 6:
                if (System.currentTimeMillis() - j10 > 1296000000) {
                }
                break;
            case 7:
                if (System.currentTimeMillis() - j10 > 2592000000L) {
                }
                break;
        }
        return true;
    }

    public boolean checkGuideH5DialogFrequency(Context context, int i10, int i11, int i12) {
        if (context == null) {
            NotifyLogger.m29914e(TAG, "QueryGuideH5Task checkGuiH5DialogFrequency context is null.");
            return false;
        }
        if (i11 != 2) {
            return checkGuiH5Dialog(context, i10, C0212e0.m1359i(context, CHECK_GUID_H5_DIALOG_SP, CHECK_GUID_H5_DIALOG_TIME, 0L), i12);
        }
        NotifyLogger.m29915i(TAG, "QueryGuideH5Task checkGuideH5DialogFrequency exitPosition == 2.");
        return true;
    }

    public boolean checkRuleFrequency(String str, String str2, float f10) {
        return checkTime(f10, new NDCOperator().getLastNotifyTime(str, str2));
    }

    public boolean checkSpaceNotifyFrequency(String str, String str2, float f10) {
        return checkTime(f10, new SpaceNotifyFrequencyOperator().getLastNotifyTime(str, str2));
    }

    public static boolean checkInValidTime(Context context, String str, String str2) {
        return checkInValidTimeCommon(C0212e0.m1363m(context, str, str2 + "_" + H5DialogConstant.BEGIN_TIME, ""), C0212e0.m1363m(context, str, str2 + "_endTime", ""));
    }
}
