package com.huawei.hicloud.notification.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.SystemParameter;
import java.util.Arrays;
import java.util.List;
import p015ak.C0213f;
import p015ak.C0214f0;

/* loaded from: classes6.dex */
public class PowerKitApplyUtil {
    public static final String ALBUM_OVER_BASE_LINE_FLAG = "albumOverBaseLineFlag";
    public static final String APPLY_TRIGGER_TYPE_AUTO = "auto";
    public static final String CLOUDBACKUP_OVER_BASE_LINE_FLAG = "cloudBackupOverBaseLineFlag";
    public static final String FINDDEVICE_OVER_BASE_LINE_FLAG = "findDeviceOverBaseLineFlag";
    public static final String OVER_BASELINE_FLAG = "over_baseline_flag_";
    public static final String OVER_BASE_LINE_DATE = "overBaseLineDate";
    public static final String POWERKITALBUMDOWNLOADMAXCOUNT = "powerKitAlbumDownloadMaxCount";
    public static final String POWERKITALBUMSYNCMAXCOUNT = "powerKitAlbumSyncMaxCount";
    public static final String POWERKITDURATION = "powerKitDuration";
    public static final String POWERKITMAXCOUNT = "powerKitMaxCount";
    public static final String POWERKIT_CLEAN_BASELINE_ACTION = "com.huawei.hicloud.notification.action.POWERKIT_CLEAN_BASELINE";
    public static final String POWERKIT_FAILED_TIME = "powerkit_failed_time_";
    private static final String TAG = "PowerKitApplyUtil";
    private SharedPreferences powerKitSp;
    private SharedPreferences.Editor powerKitSpEditor;
    public static final String GROUP_ALBUM = "album";
    public static final String GROUP_CLOUDBACKUP = "cloudBackup";
    public static final String GROUP_FINDDEVICE = "finddevice";
    private static final List<String> GROUPS = Arrays.asList(GROUP_ALBUM, GROUP_CLOUDBACKUP, GROUP_FINDDEVICE);

    public static class Holder {
        private static final PowerKitApplyUtil INSTANCE = new PowerKitApplyUtil();

        private Holder() {
        }
    }

    public static PowerKitApplyUtil getInstance() {
        if (Holder.INSTANCE.powerKitSp == null || Holder.INSTANCE.powerKitSpEditor == null) {
            Context contextM1377a = C0213f.m1377a();
            if (contextM1377a != null) {
                Holder.INSTANCE.powerKitSp = C0214f0.m1382b(contextM1377a, "powerkit_apply_sp", 0);
            }
            if (Holder.INSTANCE.powerKitSp != null) {
                Holder.INSTANCE.powerKitSpEditor = Holder.INSTANCE.powerKitSp.edit();
            }
        }
        return Holder.INSTANCE;
    }

    private String getLastPowerKitFailedTimeKey(String str) {
        return POWERKIT_FAILED_TIME + str;
    }

    private String getOverBaseLineFlagKey(String str) {
        str.hashCode();
        switch (str) {
            case "cloudBackup":
                return CLOUDBACKUP_OVER_BASE_LINE_FLAG;
            case "album":
                return ALBUM_OVER_BASE_LINE_FLAG;
            case "finddevice":
                return FINDDEVICE_OVER_BASE_LINE_FLAG;
            default:
                return "";
        }
    }

    private String getOverBaseLineFlagKeyNew(String str) {
        return OVER_BASELINE_FLAG + str;
    }

    public static boolean isInvalidGroup(String str) {
        return !GROUPS.contains(str);
    }

    public boolean getBooleanValue(String str) {
        return getBooleanValue(str, false);
    }

    public long getLastPowerKitFailedTime(String str) {
        if (this.powerKitSp != null) {
            return this.powerKitSp.getLong(getLastPowerKitFailedTimeKey(str), 0L);
        }
        NotifyLogger.m29916w(TAG, "getLastPowerKitFailedTime powerKitSp is null, key=" + str);
        return 0L;
    }

    public boolean getOverBaseLineFlag(String str) {
        return getBooleanValue(getOverBaseLineFlagKey(str));
    }

    public Boolean getOverBaseLineFlagNew(String str) {
        if (this.powerKitSp != null) {
            String overBaseLineFlagKeyNew = getOverBaseLineFlagKeyNew(str);
            if (this.powerKitSp.contains(overBaseLineFlagKeyNew)) {
                return Boolean.valueOf(this.powerKitSp.getBoolean(overBaseLineFlagKeyNew, false));
            }
            return null;
        }
        NotifyLogger.m29916w(TAG, "getOverBaseLineFlagNew powerKitSp is null, key=" + str);
        return null;
    }

    public void parseApplyConfig(SystemParameter systemParameter) {
        if (systemParameter == null) {
            NotifyLogger.m29915i(TAG, "systemParameter is null");
            return;
        }
        int powerKitDuration = systemParameter.getPowerKitDuration();
        int powerKitMaxCount = systemParameter.getPowerKitMaxCount();
        int powerKitAlbumSyncMaxCount = systemParameter.getPowerKitAlbumSyncMaxCount();
        int powerKitAlbumDownloadMaxCount = systemParameter.getPowerKitAlbumDownloadMaxCount();
        NotifyLogger.m29915i(TAG, "config:" + ("duration:" + powerKitDuration + " powerKitMaxCount:" + powerKitMaxCount + " syncApplyCount:" + powerKitAlbumSyncMaxCount + " downloadApplyCount:" + powerKitAlbumDownloadMaxCount));
        SharedPreferences.Editor editor = this.powerKitSpEditor;
        if (editor != null) {
            editor.putInt(POWERKITDURATION, powerKitDuration);
            this.powerKitSpEditor.putInt(POWERKITMAXCOUNT, powerKitMaxCount);
            this.powerKitSpEditor.putInt(POWERKITALBUMSYNCMAXCOUNT, powerKitAlbumSyncMaxCount);
            this.powerKitSpEditor.putInt(POWERKITALBUMDOWNLOADMAXCOUNT, powerKitAlbumDownloadMaxCount);
            this.powerKitSpEditor.commit();
        }
    }

    public void setLastPowerKitFailedTime(String str, long j10) {
        SharedPreferences.Editor editor = this.powerKitSpEditor;
        if (editor != null) {
            editor.putLong(getLastPowerKitFailedTimeKey(str), j10).commit();
            return;
        }
        NotifyLogger.m29916w(TAG, "setLastPowerKitFailedTime powerKitSpEditor is null, key=" + str);
    }

    public void setOverBaseLineFlagNew(String str, boolean z10) {
        SharedPreferences.Editor editor = this.powerKitSpEditor;
        if (editor != null) {
            editor.putBoolean(getOverBaseLineFlagKeyNew(str), z10).commit();
            return;
        }
        NotifyLogger.m29916w(TAG, "setOverBaseLineFlagNew powerKitSpEditor is null, key=" + str);
    }

    private PowerKitApplyUtil() {
        this.powerKitSp = null;
        this.powerKitSpEditor = null;
    }

    public boolean getBooleanValue(String str, boolean z10) {
        SharedPreferences sharedPreferences = this.powerKitSp;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(str, z10);
        }
        NotifyLogger.m29916w(TAG, "getBooleanValue powerKitSp is null, key=" + str);
        return z10;
    }
}
