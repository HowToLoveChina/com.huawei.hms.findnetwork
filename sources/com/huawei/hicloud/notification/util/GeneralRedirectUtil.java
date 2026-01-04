package com.huawei.hicloud.notification.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hicloud.notification.log.NotifyLogger;
import hu.C10344c;
import p015ak.C0209d;

/* loaded from: classes6.dex */
public class GeneralRedirectUtil {
    public static final String BAK_ID = "bakId";
    public static final String DEVICE_ID = "deviceId";
    public static final String IS_DELETE = "isDelete";
    private static final String MATCH_INTERIM_BACKUP = "InterimBackupActivity";
    public static final String PAGE_TYPE = "pageType";
    public static final int REPORT_FROM_NOTIFICATION = 7;
    public static final String START_APP_PAGE = "/startAppPage";
    private static final String TAG = "GeneralRedirectUtil";
    public static final String TEMP_BACKUP = "temp_backup";
    public static final String TEMP_BACKUP_CHECK_ACTIVITY = "com.huawei.android.hicloud.ui.temporarybackup.TempBackupCheckActivity";
    public static final String TEMP_BACKUP_DETAIL_STATE_ACTIVITY = "com.huawei.android.hicloud.ui.activity.CloudSpaceBackupDetailActivity";
    public static final String TEMP_BACKUP_DETAIL_STATE_ACTIVITY_NAME = "CloudSpaceBackupDetailActivity";
    public static final String TEMP_BACKUP_DEVICE_DETAIL = "temp_backup_device_detail";

    public static Intent getCommonGotoIntent(String str, String str2, boolean z10) {
        return getCommonGotoIntentWithType(str, str2, z10, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:134:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x00fc A[Catch: Exception -> 0x0036, TryCatch #0 {Exception -> 0x0036, blocks: (B:111:0x001e, B:112:0x0028, B:143:0x007e, B:144:0x0088, B:146:0x0097, B:148:0x009d, B:149:0x00a4, B:151:0x00b4, B:153:0x00c0, B:154:0x00ca, B:156:0x00d6, B:160:0x00fc, B:157:0x00e9, B:159:0x00f7, B:161:0x010b, B:162:0x0111, B:165:0x0119, B:166:0x012c, B:168:0x0134, B:169:0x0148, B:171:0x0150, B:172:0x0160, B:174:0x016c, B:176:0x0171, B:178:0x017d, B:181:0x0189, B:183:0x018f, B:185:0x0195, B:186:0x019d, B:188:0x01a3, B:190:0x01a9, B:191:0x01b1, B:193:0x01b9, B:194:0x01c0, B:196:0x01c8, B:198:0x01cf, B:114:0x002c, B:119:0x0039, B:122:0x0043, B:125:0x004d, B:128:0x0057, B:131:0x0061), top: B:203:0x001e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.Intent getCommonGotoIntentWithType(java.lang.String r16, java.lang.String r17, boolean r18, com.huawei.hicloud.notification.p106db.bean.RecommendCard r19) {
        /*
            Method dump skipped, instructions count: 520
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.notification.util.GeneralRedirectUtil.getCommonGotoIntentWithType(java.lang.String, java.lang.String, boolean, com.huawei.hicloud.notification.db.bean.RecommendCard):android.content.Intent");
    }

    public static boolean isTempBackupLink(String str) {
        Uri uri;
        if (TextUtils.isEmpty(str)) {
            NotifyLogger.m29916w(TAG, "notifyUri is empty");
            return false;
        }
        try {
            uri = Uri.parse(str);
        } catch (Exception e10) {
            NotifyLogger.m29916w(TAG, "isTempBackupLink has error:" + e10.getMessage());
        }
        if (TextUtils.equals(uri.getEncodedPath(), START_APP_PAGE) && TextUtils.equals(uri.getQueryParameter("pageType"), TEMP_BACKUP)) {
            NotifyLogger.m29915i(TAG, "is tempBackupLink");
            return true;
        }
        if (TextUtils.equals(C10344c.m63704b(uri, "path"), MATCH_INTERIM_BACKUP)) {
            return true;
        }
        NotifyLogger.m29915i(TAG, "is not tempBackupLink");
        return false;
    }

    private static void startBackupDetail(Context context, Intent intent, Uri uri, boolean z10) {
        try {
            intent.setClassName(context, TEMP_BACKUP_DETAIL_STATE_ACTIVITY);
            intent.putExtra("isFromNotifyTemp", true);
            intent.putExtra("pageType", TEMP_BACKUP_DEVICE_DETAIL);
            intent.putExtra("deviceId", uri.getQueryParameter("deviceId"));
            intent.putExtra(BAK_ID, uri.getQueryParameter(BAK_ID));
            intent.putExtra(IS_DELETE, z10);
            intent.putExtra("backup_delete_report_entry", 7);
            C0209d.m1302r2(intent, "com.huawei.hidisk");
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "startBackupDetail error :" + e10.getMessage());
        }
    }
}
