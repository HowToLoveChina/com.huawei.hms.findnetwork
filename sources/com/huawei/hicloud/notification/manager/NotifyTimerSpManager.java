package com.huawei.hicloud.notification.manager;

import android.content.SharedPreferences;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.data.BackupSpaceNotEnoughNeedData;
import com.huawei.hicloud.notification.log.NotifyLogger;
import p015ak.C0213f;
import p015ak.C0214f0;

/* loaded from: classes6.dex */
public class NotifyTimerSpManager {
    private static final String TAG = "NotifyTimerSpManager";

    public static class Holder {
        private static NotifyTimerSpManager INSTANCE = new NotifyTimerSpManager();

        private Holder() {
        }
    }

    public static NotifyTimerSpManager getInstance() {
        return Holder.INSTANCE;
    }

    public BackupSpaceNotEnoughNeedData getBackupNotiNeedData() {
        BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData = new BackupSpaceNotEnoughNeedData();
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), NotifyConstants.NotifyTimerSpValues.NOTI_TIMER_SP_NAME, 0);
        if (sharedPreferencesM1382b == null) {
            return null;
        }
        backupSpaceNotEnoughNeedData.setTotalNeedSpace(sharedPreferencesM1382b.getLong(NotifyConstants.NotifyTimerSpValues.BACKUP_TOTAL_NEED_SPACE, 0L));
        backupSpaceNotEnoughNeedData.setBackupNeedSpace(sharedPreferencesM1382b.getLong(NotifyConstants.NotifyTimerSpValues.BACKUP_TOTAL_NEED_SPACE, 0L));
        backupSpaceNotEnoughNeedData.setNotUsedSpace(sharedPreferencesM1382b.getLong(NotifyConstants.NotifyTimerSpValues.BACKUP_NOT_USED_SPACE, 0L));
        backupSpaceNotEnoughNeedData.setTotalSpace(sharedPreferencesM1382b.getLong(NotifyConstants.NotifyTimerSpValues.BACKUP_TOTAL_SPACE, 0L));
        backupSpaceNotEnoughNeedData.setUsedSpace(sharedPreferencesM1382b.getLong(NotifyConstants.NotifyTimerSpValues.BACKUP_USED_SPACE, 0L));
        backupSpaceNotEnoughNeedData.setGalleryNum(sharedPreferencesM1382b.getLong(NotifyConstants.NotifyTimerSpValues.BACKUP_GALLERY_NUM, 0L));
        backupSpaceNotEnoughNeedData.setFamilyShareMember(sharedPreferencesM1382b.getBoolean(NotifyConstants.NotifyTimerSpValues.BACKUP_IS_FAMILY_SHARE, false));
        return backupSpaceNotEnoughNeedData;
    }

    public long getBackupTotalNeedSize() {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), NotifyConstants.NotifyTimerSpValues.NOTI_TIMER_SP_NAME, 0);
        if (sharedPreferencesM1382b == null) {
            return 0L;
        }
        return sharedPreferencesM1382b.getLong(NotifyConstants.NotifyTimerSpValues.BACKUP_TOTAL_NEED_SPACE, 0L);
    }

    public boolean getSpaceNotiFromAlbum() {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), NotifyConstants.NotifyTimerSpValues.NOTI_TIMER_SP_NAME, 0);
        return sharedPreferencesM1382b != null && sharedPreferencesM1382b.getBoolean(NotifyConstants.NotifyTimerSpValues.SPACE_NOTIFY_IS_FROM_ALBUM, false);
    }

    public long getSpaceNotiTotalSpace() {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), NotifyConstants.NotifyTimerSpValues.NOTI_TIMER_SP_NAME, 0);
        if (sharedPreferencesM1382b == null) {
            return 0L;
        }
        return sharedPreferencesM1382b.getLong(NotifyConstants.NotifyTimerSpValues.SPACE_NOTIFY_TOTAL_NEED_SPACE, 0L);
    }

    public boolean isAutoBackupNotifyTimerStart() {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), NotifyConstants.NotifyTimerSpValues.NOTI_TIMER_SP_NAME, 0);
        return sharedPreferencesM1382b != null && sharedPreferencesM1382b.getBoolean(NotifyConstants.NotifyTimerSpValues.AUTO_BACKUP_NOTIFY_TIMER_START, false);
    }

    public boolean isSpaceNotifyTimerStart() {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), NotifyConstants.NotifyTimerSpValues.NOTI_TIMER_SP_NAME, 0);
        return sharedPreferencesM1382b != null && sharedPreferencesM1382b.getBoolean(NotifyConstants.NotifyTimerSpValues.SPACE_NOTIFY_TIMER_START, false);
    }

    public void recordAutoBackupNotifyTimerEnd() {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), NotifyConstants.NotifyTimerSpValues.NOTI_TIMER_SP_NAME, 0);
        if (sharedPreferencesM1382b != null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
            editorEdit.putBoolean(NotifyConstants.NotifyTimerSpValues.AUTO_BACKUP_NOTIFY_TIMER_START, false);
            editorEdit.commit();
        }
    }

    public void recordAutoBackupNotifyTimerStart(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData) {
        if (backupSpaceNotEnoughNeedData == null) {
            NotifyLogger.m29914e(TAG, "recordAutoBackupNotifyTimerStart backupSpaceNotEnoughNeedData is null");
            return;
        }
        long totalNeedSpace = backupSpaceNotEnoughNeedData.getTotalNeedSpace();
        long backupNeedSpace = backupSpaceNotEnoughNeedData.getBackupNeedSpace();
        long notUsedSpace = backupSpaceNotEnoughNeedData.getNotUsedSpace();
        long galleryNum = backupSpaceNotEnoughNeedData.getGalleryNum();
        boolean zIsFamilyShareMember = backupSpaceNotEnoughNeedData.isFamilyShareMember();
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), NotifyConstants.NotifyTimerSpValues.NOTI_TIMER_SP_NAME, 0);
        if (sharedPreferencesM1382b != null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
            editorEdit.putLong(NotifyConstants.NotifyTimerSpValues.BACKUP_TOTAL_NEED_SPACE, totalNeedSpace);
            editorEdit.putLong(NotifyConstants.NotifyTimerSpValues.BACKUP_NEED_SPACE, backupNeedSpace);
            editorEdit.putLong(NotifyConstants.NotifyTimerSpValues.BACKUP_NOT_USED_SPACE, notUsedSpace);
            editorEdit.putLong(NotifyConstants.NotifyTimerSpValues.BACKUP_TOTAL_SPACE, backupSpaceNotEnoughNeedData.getTotalSpace());
            editorEdit.putLong(NotifyConstants.NotifyTimerSpValues.BACKUP_USED_SPACE, backupSpaceNotEnoughNeedData.getUsedSpace());
            editorEdit.putLong(NotifyConstants.NotifyTimerSpValues.BACKUP_GALLERY_NUM, galleryNum);
            editorEdit.putBoolean(NotifyConstants.NotifyTimerSpValues.BACKUP_IS_FAMILY_SHARE, zIsFamilyShareMember);
            editorEdit.putBoolean(NotifyConstants.NotifyTimerSpValues.AUTO_BACKUP_NOTIFY_TIMER_START, true);
            editorEdit.commit();
        }
    }

    public void recordSpaceNotifyTimerEnd() {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), NotifyConstants.NotifyTimerSpValues.NOTI_TIMER_SP_NAME, 0);
        if (sharedPreferencesM1382b != null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
            editorEdit.putBoolean(NotifyConstants.NotifyTimerSpValues.SPACE_NOTIFY_TIMER_START, false);
            editorEdit.commit();
        }
    }

    public void recordSpaceNotifyTimerStart(long j10, boolean z10) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), NotifyConstants.NotifyTimerSpValues.NOTI_TIMER_SP_NAME, 0);
        if (sharedPreferencesM1382b != null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
            editorEdit.putBoolean(NotifyConstants.NotifyTimerSpValues.SPACE_NOTIFY_TIMER_START, true);
            editorEdit.putLong(NotifyConstants.NotifyTimerSpValues.SPACE_NOTIFY_TOTAL_NEED_SPACE, j10);
            editorEdit.putBoolean(NotifyConstants.NotifyTimerSpValues.SPACE_NOTIFY_IS_FROM_ALBUM, z10);
            editorEdit.commit();
        }
    }

    private NotifyTimerSpManager() {
    }
}
