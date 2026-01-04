package com.huawei.hicloud.notification.util;

import android.content.SharedPreferences;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import p015ak.C0213f;
import p015ak.C0214f0;

/* loaded from: classes6.dex */
public class SpaceNoticeCommonSpUtil {
    private static final String SPFILE_NAME = "space_notice_with_activity_sp";
    private static final String TAG = "SpaceNoticeCommonSpUtil";
    private static SpaceNoticeCommonSpUtil spUtil;

    /* renamed from: sp */
    private SharedPreferences f22683sp = C0214f0.m1382b(C0213f.m1377a(), "space_notice_with_activity_sp", 0);

    private SpaceNoticeCommonSpUtil() {
    }

    public static synchronized SpaceNoticeCommonSpUtil getInstance() {
        try {
            if (spUtil == null) {
                spUtil = new SpaceNoticeCommonSpUtil();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return spUtil;
    }

    public synchronized void clear(String str) {
        SharedPreferences sharedPreferences = this.f22683sp;
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (editorEdit == null) {
            return;
        }
        editorEdit.remove(str + NotifyConstants.SpaceNoticeSp.POP_GOTO_BUTTON_COUNT).commit();
        editorEdit.remove(str + NotifyConstants.SpaceNoticeSp.ACTIVITY_TYPE).commit();
        editorEdit.remove(str + NotifyConstants.SpaceNoticeSp.ACTIVITY_CID).commit();
        editorEdit.remove(str + NotifyConstants.SpaceNoticeSp.ACTIVITY_AD_ID).commit();
        editorEdit.remove(str + NotifyConstants.SpaceNoticeSp.CAMPAIGN_QUOTA).commit();
    }

    public synchronized void clearAll() {
        SharedPreferences sharedPreferences = this.f22683sp;
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (editorEdit == null) {
            return;
        }
        editorEdit.clear().commit();
    }

    public synchronized void clearSpaceRemiderFailSP() {
        SharedPreferences sharedPreferences = this.f22683sp;
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (editorEdit == null) {
            return;
        }
        editorEdit.remove(NotifyConstants.SpaceNoticeSp.SPACE_REMINDER_FAIL_TIME).commit();
        editorEdit.remove(NotifyConstants.SpaceNoticeSp.SPACE_REMINDER_FAIL_TIMES).commit();
    }

    public synchronized String getActivityId(String str) {
        if (this.f22683sp == null) {
            return "";
        }
        return this.f22683sp.getString(str + NotifyConstants.SpaceNoticeSp.ACTIVITY_CID, "");
    }

    public synchronized String getAdId(String str) {
        if (this.f22683sp == null) {
            return "";
        }
        return this.f22683sp.getString(str + NotifyConstants.SpaceNoticeSp.ACTIVITY_AD_ID, "");
    }

    public synchronized int getCType(String str) {
        if (this.f22683sp == null) {
            return -1;
        }
        return this.f22683sp.getInt(str + NotifyConstants.SpaceNoticeSp.ACTIVITY_TYPE, -1);
    }

    public synchronized int getCampaignQuota(String str) {
        if (this.f22683sp == null) {
            return -1;
        }
        return this.f22683sp.getInt(str + NotifyConstants.SpaceNoticeSp.CAMPAIGN_QUOTA, -1);
    }

    public synchronized int getPopGotoCount(String str) {
        if (this.f22683sp == null) {
            return -1;
        }
        return this.f22683sp.getInt(str + NotifyConstants.SpaceNoticeSp.POP_GOTO_BUTTON_COUNT, -1);
    }

    public synchronized long getSpaceReminderFailTime() {
        SharedPreferences sharedPreferences = this.f22683sp;
        if (sharedPreferences == null) {
            return -1L;
        }
        return sharedPreferences.getLong(NotifyConstants.SpaceNoticeSp.SPACE_REMINDER_FAIL_TIME, -1L);
    }

    public synchronized int getSpaceReminderFailTimes() {
        SharedPreferences sharedPreferences = this.f22683sp;
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getInt(NotifyConstants.SpaceNoticeSp.SPACE_REMINDER_FAIL_TIMES, 0);
    }

    public synchronized boolean isShownAlready() {
        SharedPreferences sharedPreferences = this.f22683sp;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.getBoolean(NotifyConstants.SpaceNoticeSp.CALIM_DIALOG_IS_SHOWN_ALREADY, false);
    }

    public synchronized boolean isSupport() {
        SharedPreferences sharedPreferences = this.f22683sp;
        if (sharedPreferences == null) {
            return true;
        }
        return sharedPreferences.getBoolean(NotifyConstants.SpaceNoticeSp.CALIM_DIALOG_IS_SUPPORT, true);
    }

    public synchronized boolean setAdId(String str, String str2) {
        SharedPreferences sharedPreferences = this.f22683sp;
        if (sharedPreferences == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (editorEdit == null) {
            return false;
        }
        return editorEdit.putString(str + NotifyConstants.SpaceNoticeSp.ACTIVITY_AD_ID, str2).commit();
    }

    public synchronized boolean setCId(String str, String str2) {
        SharedPreferences sharedPreferences = this.f22683sp;
        if (sharedPreferences == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (editorEdit == null) {
            return false;
        }
        return editorEdit.putString(str + NotifyConstants.SpaceNoticeSp.ACTIVITY_CID, str2).commit();
    }

    public synchronized boolean setCType(String str, int i10) {
        SharedPreferences sharedPreferences = this.f22683sp;
        if (sharedPreferences == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (editorEdit == null) {
            return false;
        }
        return editorEdit.putInt(str + NotifyConstants.SpaceNoticeSp.ACTIVITY_TYPE, i10).commit();
    }

    public synchronized boolean setCampaignQuota(String str, int i10) {
        SharedPreferences sharedPreferences = this.f22683sp;
        if (sharedPreferences == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (editorEdit == null) {
            return false;
        }
        return editorEdit.putInt(str + NotifyConstants.SpaceNoticeSp.CAMPAIGN_QUOTA, i10).commit();
    }

    public synchronized boolean setPopGotoCount(String str, int i10) {
        SharedPreferences sharedPreferences = this.f22683sp;
        if (sharedPreferences == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (editorEdit == null) {
            return false;
        }
        return editorEdit.putInt(str + NotifyConstants.SpaceNoticeSp.POP_GOTO_BUTTON_COUNT, i10).commit();
    }

    public synchronized boolean setShownAlready(boolean z10) {
        SharedPreferences sharedPreferences = this.f22683sp;
        if (sharedPreferences == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (editorEdit == null) {
            return false;
        }
        return editorEdit.putBoolean(NotifyConstants.SpaceNoticeSp.CALIM_DIALOG_IS_SHOWN_ALREADY, z10).commit();
    }

    public synchronized void setSpaceReminderFailTime(long j10) {
        SharedPreferences sharedPreferences = this.f22683sp;
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (editorEdit == null) {
            return;
        }
        if (!editorEdit.putLong(NotifyConstants.SpaceNoticeSp.SPACE_REMINDER_FAIL_TIME, j10).commit()) {
            NotifyLogger.m29914e(TAG, "setSpaceReminderFailTime edit error.");
        }
    }

    public synchronized void setSpaceReminderFailTimes() {
        if (this.f22683sp == null) {
            return;
        }
        int spaceReminderFailTimes = getSpaceReminderFailTimes();
        SharedPreferences.Editor editorEdit = this.f22683sp.edit();
        if (editorEdit == null) {
            return;
        }
        if (!editorEdit.putInt(NotifyConstants.SpaceNoticeSp.SPACE_REMINDER_FAIL_TIMES, spaceReminderFailTimes + 1).commit()) {
            NotifyLogger.m29914e(TAG, "setSpaceReminderFailTime edit error.");
        }
    }

    public synchronized boolean setSupport(boolean z10) {
        SharedPreferences sharedPreferences = this.f22683sp;
        if (sharedPreferences == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (editorEdit == null) {
            return false;
        }
        return editorEdit.putBoolean(NotifyConstants.SpaceNoticeSp.CALIM_DIALOG_IS_SUPPORT, z10).commit();
    }
}
