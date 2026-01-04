package com.huawei.hicloud.notification.util;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import gp.C10028c;

/* loaded from: classes6.dex */
public class HiCloudLink {
    private static final String PARAM_ENABLE_JS = "isEnableJs";
    private static final String PARAM_TITLE = "title";
    private static final String PARAM_URL = "url";
    private static final String TAG = "HiCloudLink";
    public static final String TYPE_WEB = "web";
    private int backupFreq = 0;
    private Context mContext;

    public HiCloudLink(Context context) {
        this.mContext = context;
    }

    public boolean checkModuleEnable(String str, String str2) {
        String str3;
        if (!"application".equals(str)) {
            return "web".equals(str) || "detail".equals(str) || NotifyConstants.TYPE_EXTRA_BANNER.equals(str);
        }
        if (NotifyConstants.BUY_MORE.equals(str2) || "manage".equals(str2) || NotifyConstants.CLOUD_STORAGE.equals(str2)) {
            str3 = "funcfg_manage_storage";
        } else if (NotifyConstants.HICLOUD_GALLERY.equals(str2)) {
            str3 = "funcfg_gallery";
        } else if (NotifyConstants.HICLOUD_BACKUP.equals(str2)) {
            str3 = "funcfg_cloud_backup";
        } else if (NotifyConstants.FIND_MY_PHONE.equals(str2)) {
            str3 = "funcfg_find_my_phone_globe";
        } else {
            if ("login".equals(str2)) {
                return true;
            }
            str3 = "";
        }
        if (TextUtils.isEmpty(str3)) {
            return false;
        }
        return C10028c.m62183d0(this.mContext).m62395t1(str3);
    }

    public void flyTo(String str, String str2) {
        try {
            Intent gotoIntent = getGotoIntent(str, str2);
            Context context = this.mContext;
            if (context == null) {
                NotifyLogger.m29914e(TAG, "flyTo context is null");
            } else {
                context.startActivity(gotoIntent);
            }
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "flyTo : " + e10.toString());
        }
    }

    public int getBackupFreq() {
        return this.backupFreq;
    }

    public Intent getGotoIntent(String str, String str2) {
        Intent intent = new Intent();
        if (!"application".equals(str)) {
            return "web".equals(str) ? NotifyUtil.getOperWebViewIntent(this.mContext, str2, 2) : NotifyConstants.TYPE_EXTRA_BANNER.equals(str) ? NotifyUtil.getDlAppWebViewIntent(this.mContext, str2) : intent;
        }
        Class<?> cls = NotifyConstants.getGotoAppMapping().get(str2);
        if (cls == null) {
            NotifyLogger.m29914e(TAG, "no uri match, return null, uri is: " + str2);
            return null;
        }
        intent.setClass(this.mContext, cls);
        if ("manage".equals(str2) || NotifyConstants.CLOUD_STORAGE.equals(str2)) {
            intent.putExtra(NotifyConstants.IS_FROM_SPACE_NOTIFY, true);
            return intent;
        }
        if (!NotifyConstants.BUY_MORE.equals(str2)) {
            return intent;
        }
        intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 8);
        return intent;
    }

    public void setBackupFreq(int i10) {
        this.backupFreq = i10;
    }
}
