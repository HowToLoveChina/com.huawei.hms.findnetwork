package com.huawei.android.hicloud.cloudbackup.p076db.operator;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.p076db.bean.Settings;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import ml.AbstractC11478a;
import p015ak.C0241z;
import p514o9.C11839m;
import p572qb.C12299b;
import p682ul.C13216j;
import p711vl.C13467g;

/* loaded from: classes2.dex */
public class SettingOperator extends AbstractC11478a<Settings> {
    private static final String CHECK_ATTACH_EXISTS = "select count(*) from last.sqlite_master where type = 'table' and name = 'settings'";
    private static final String DELETE_SETTINGS = "delete from settings where name = ?";
    private static final String DELETE_TABLE_SETTINGS = "delete from settings";
    private static final String REPLACE_SETTINGS = "replace into settings(name,value,type) VALUES(?,?,?);";
    private static final String SQL_QUERY_BACKUPTIMES = "select name, value, type from settings where name = 'backuptimes';";
    private static final String SQL_QUERY_BACKUP_SWITCH_TIME = "select name, value, type from settings where name = 'backupswitchtime';";
    private static final String SQL_QUERY_BAK_SOURCE_STRATEGY = "select name, value, type from settings where name = 'bakSourceStrategy';";
    private static final String SQL_QUERY_BLACK = "select name, value, type from settings where type = 3;";
    private static final String SQL_QUERY_BREAKEDTIME = "select name, value, type from settings where name = 'breakedtime';";
    private static final String SQL_QUERY_CYCLE = "select name, value, type from settings where name = 'backupCycle';";
    private static final String SQL_QUERY_DELAYEDSTARTTIME = "select name, value, type from settings where name = 'delayedstarttime';";
    private static final String SQL_QUERY_DEVICE_DELETE_STRATEGY = "select name, value, type from settings where name = 'deviceDeleteStrategy';";
    private static final String SQL_QUERY_FAILEDTIME = "select name, value, type from settings where name = 'lastfailedtime';";
    private static final String SQL_QUERY_FILE_SOURCE_STRATEGY = "select name, value, type from settings where name = 'fileSourceStrategy';";
    private static final String SQL_QUERY_INITTIME = "select name, value, type from settings where name = 'lastbackuptime';";
    private static final String SQL_QUERY_LAST_BACKUP_ID = "select name, value, type from settings where name = 'lastsuccessbackupid';";
    private static final String SQL_QUERY_LAST_CLONE_SUCCESS_TIME = "select name, value, type from settings where name = 'lastclonesuccesstime';";
    private static final String SQL_QUERY_LOCK_BY_DEL_DEVICE_STRATEGY = "select name, value, type from settings where name = 'lockByDelDeviceStrategy';";
    private static final String SQL_QUERY_MAX_ATTACHMENT_UPLOAD_SIZE = "select name, value, type from settings where name = 'maxAttachmentUploadSize';";
    private static final String SQL_QUERY_MAX_BATCH_NUMBER = "select name, value, type from settings where name = 'maxBatchNumber';";
    private static final String SQL_QUERY_NEXTTIME = "select name, value, type from settings where name = 'nextbackuptime';";
    private static final String SQL_QUERY_NOTIFY = "select name, value, type from settings where name = 'notifycycle';";
    private static final String SQL_QUERY_NOTIFYTIME = "select name, value, type from settings where name = 'lastnotifytime';";
    private static final String SQL_QUERY_SUCCESSTIME = "select name, value, type from settings where name = 'lastsuccesstime';";
    private static final String SQL_QUERY_THIRD_APP_INIT_TIME = "select name, value, type from settings where name = 'thirdAppInitTime';";
    private static final String SQL_QUERY_UPLOAD_TARGET_STRATEGY = "select name, value, type from settings where name = 'uploadTargetStrategy';";
    private static final String TAG = "SettingOperator";
    private static final String TRANSFER_OLD_DATA = "replace into settings select name, value, type from last.settings";

    public SettingOperator() {
        super(C13216j.m79427l(C13216j.c.SETTING, null));
    }

    public void clear() {
        try {
            execSQL(DELETE_TABLE_SETTINGS);
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "clear settings error." + e10.getMessage());
        }
    }

    public void delete(Settings[] settingsArr) {
        if (settingsArr == null || settingsArr.length == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Settings settings : settingsArr) {
            arrayList.add(new String[]{settings.getName()});
        }
        try {
            execute(DELETE_SETTINGS, arrayList);
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "delete settings error." + e10.getMessage());
        }
    }

    public long queryBackupSwitchTime() {
        try {
            List<Settings> listQuery = query(SQL_QUERY_BACKUP_SWITCH_TIME, null);
            if (listQuery.isEmpty()) {
                return 0L;
            }
            return C0241z.m1688f(listQuery.get(0).getValue());
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "queryBackupSwitchTime error." + e10.getMessage());
            return 0L;
        }
    }

    public int queryBackupTimes() {
        try {
            List<Settings> listQuery = query(SQL_QUERY_BACKUPTIMES, null);
            if (!listQuery.isEmpty()) {
                return C0241z.m1685c(listQuery.get(0).getValue());
            }
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "queryBackupTimes error." + e10.getMessage());
        }
        return 0;
    }

    public String queryBakSourceStrategy() {
        try {
            List<Settings> listQuery = query(SQL_QUERY_BAK_SOURCE_STRATEGY, null);
            return !listQuery.isEmpty() ? listQuery.get(0).getValue() : "1";
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "queryBakSourceStrategy error." + e10.getMessage());
            return "1";
        }
    }

    public String queryDeviceDeleteStrategy() {
        try {
            List<Settings> listQuery = query(SQL_QUERY_DEVICE_DELETE_STRATEGY, null);
            return !listQuery.isEmpty() ? listQuery.get(0).getValue() : "1";
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "queryBakSourceStrategy error." + e10.getMessage());
            return "1";
        }
    }

    public String queryFileSourceStrategy() {
        try {
            List<Settings> listQuery = query(SQL_QUERY_FILE_SOURCE_STRATEGY, null);
            return !listQuery.isEmpty() ? listQuery.get(0).getValue() : "1";
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "queryFileSourceStrategy error." + e10.getMessage());
            return "1";
        }
    }

    public int queryFinalBackupCycle() {
        int iQuerybackupcycle = (int) querybackupcycle();
        int iM81089d = C13467g.m81086c().m81089d("backup_frequency", 0);
        return iM81089d == 0 ? iQuerybackupcycle : iM81089d;
    }

    public String queryLastBackupId() {
        try {
            List<Settings> listQuery = query(SQL_QUERY_LAST_BACKUP_ID, null);
            if (!listQuery.isEmpty()) {
                return listQuery.get(0).getValue();
            }
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "queryBackupTimes error." + e10.getMessage());
        }
        return null;
    }

    public long queryLastCloneSuccessTime() {
        try {
            List<Settings> listQuery = query(SQL_QUERY_LAST_CLONE_SUCCESS_TIME, null);
            if (listQuery.isEmpty()) {
                return 0L;
            }
            return C0241z.m1688f(listQuery.get(0).getValue());
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "querylastclonesuccesstime error." + e10.getMessage());
            return System.currentTimeMillis();
        }
    }

    public String queryLockByDelDeviceStrategy() {
        try {
            List<Settings> listQuery = query(SQL_QUERY_LOCK_BY_DEL_DEVICE_STRATEGY, null);
            return !listQuery.isEmpty() ? listQuery.get(0).getValue() : "0";
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "queryLockByDelDevice error." + e10.getMessage());
            return "0";
        }
    }

    public long queryMaxAttachmentUploadSize() {
        try {
            List<Settings> listQuery = query(SQL_QUERY_MAX_ATTACHMENT_UPLOAD_SIZE, null);
            if (listQuery.isEmpty()) {
                return 2147483648L;
            }
            return C0241z.m1688f(listQuery.get(0).getValue());
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "queryMaxAttachmentUploadSize error." + e10.getMessage());
            return 2147483648L;
        }
    }

    public int queryMaxBatchNumber() {
        try {
            List<Settings> listQuery = query(SQL_QUERY_MAX_BATCH_NUMBER, null);
            if (listQuery.isEmpty()) {
                return 1;
            }
            return C0241z.m1685c(listQuery.get(0).getValue());
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "query maxBatchNumber error." + e10.getMessage());
            return 1;
        }
    }

    public long queryThirdAppInitTime() {
        try {
            List<Settings> listQuery = query(SQL_QUERY_THIRD_APP_INIT_TIME, null);
            if (listQuery.isEmpty()) {
                return 0L;
            }
            return C0241z.m1688f(listQuery.get(0).getValue());
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "queryThirdAppInitTime error." + e10.getMessage());
            return 0L;
        }
    }

    public String queryUploadTargetStrategy() {
        String strQueryUploadTargetStrategyConfig = queryUploadTargetStrategyConfig();
        return !TextUtils.isEmpty(strQueryUploadTargetStrategyConfig) ? strQueryUploadTargetStrategyConfig : "1";
    }

    public String queryUploadTargetStrategyConfig() {
        try {
            List<Settings> listQuery = query(SQL_QUERY_UPLOAD_TARGET_STRATEGY, null);
            if (!listQuery.isEmpty()) {
                return listQuery.get(0).getValue();
            }
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "queryUploadTargetStrategy error." + e10.getMessage());
        }
        return null;
    }

    public long querybackupcycle() {
        try {
            List<Settings> listQuery = query(SQL_QUERY_CYCLE, null);
            if (!listQuery.isEmpty()) {
                return C0241z.m1689g(listQuery.get(0).getValue(), 7L);
            }
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "querybackupcycle error." + e10.getMessage());
        }
        return 7L;
    }

    public List<String> queryblacklist() {
        ArrayList arrayList = new ArrayList();
        try {
            List<Settings> listQuery = query(SQL_QUERY_BLACK, null);
            if (!listQuery.isEmpty()) {
                for (Settings settings : listQuery) {
                    if ("false".equals(settings.getValue())) {
                        arrayList.add(settings.getName());
                    }
                }
            }
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "queryblacklist error." + e10.getMessage());
        }
        return arrayList;
    }

    public long querybreakedtime() {
        try {
            List<Settings> listQuery = query(SQL_QUERY_BREAKEDTIME, null);
            if (!listQuery.isEmpty()) {
                return C0241z.m1689g(listQuery.get(0).getValue(), 300000L);
            }
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "querybreakedtime error." + e10.getMessage());
        }
        return 300000L;
    }

    public long querydelayedstarttime() {
        try {
            List<Settings> listQuery = query(SQL_QUERY_DELAYEDSTARTTIME, null);
            if (!listQuery.isEmpty()) {
                return C0241z.m1689g(listQuery.get(0).getValue(), 600000L);
            }
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "querydelayedstarttime error." + e10.getMessage());
        }
        return 600000L;
    }

    public long queryinitopentime() {
        try {
            List<Settings> listQuery = query(SQL_QUERY_INITTIME, null);
            if (!listQuery.isEmpty()) {
                return C0241z.m1689g(listQuery.get(0).getValue(), System.currentTimeMillis());
            }
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "queryinitopentime error." + e10.getMessage());
        }
        return System.currentTimeMillis();
    }

    public long querylastfailedtime() {
        try {
            List<Settings> listQuery = query(SQL_QUERY_FAILEDTIME, null);
            if (listQuery.isEmpty()) {
                return 0L;
            }
            return C0241z.m1688f(listQuery.get(0).getValue());
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "querylastfailedtime error." + e10.getMessage());
            return System.currentTimeMillis();
        }
    }

    public long querylastnotifytime() {
        try {
            List<Settings> listQuery = query(SQL_QUERY_NOTIFYTIME, null);
            if (!listQuery.isEmpty()) {
                return C0241z.m1689g(listQuery.get(0).getValue(), System.currentTimeMillis());
            }
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "querylastnotifytime error." + e10.getMessage());
        }
        return System.currentTimeMillis();
    }

    public long querylastsuccesstime() {
        try {
            List<Settings> listQuery = query(SQL_QUERY_SUCCESSTIME, null);
            if (listQuery.isEmpty()) {
                return 0L;
            }
            return C0241z.m1688f(listQuery.get(0).getValue());
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "querylastsuccesstime error." + e10.getMessage());
            return 0L;
        }
    }

    public long querynextbackuptime() {
        try {
            List<Settings> listQuery = query(SQL_QUERY_NEXTTIME, null);
            if (listQuery.isEmpty()) {
                return 0L;
            }
            return C0241z.m1688f(listQuery.get(0).getValue());
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "querynextbackuptime error." + e10.getMessage());
            return 0L;
        }
    }

    public long querynotifycycle() {
        try {
            List<Settings> listQuery = query(SQL_QUERY_NOTIFY, null);
            if (!listQuery.isEmpty()) {
                return C0241z.m1689g(listQuery.get(0).getValue(), 14L);
            }
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "querynotifycycle error." + e10.getMessage());
        }
        return 14L;
    }

    public void replace(Settings[] settingsArr) {
        if (settingsArr == null || settingsArr.length == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ContentValues contentValues = new ContentValues();
        for (Settings settings : settingsArr) {
            String[] strArr = {settings.getName(), settings.getValue(), settings.getType()};
            contentValues.put(settings.getName(), Long.valueOf(C0241z.m1688f(settings.getValue())));
            arrayList.add(strArr);
        }
        C12299b.m73937s(contentValues);
        try {
            execute(REPLACE_SETTINGS, arrayList);
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "replace settings error." + e10.getMessage());
        }
    }

    public void transfer() {
        try {
            Cursor cursorRawQuery = rawQuery(CHECK_ATTACH_EXISTS, null);
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst() && cursorRawQuery.getInt(0) > 0) {
                        C11839m.m70686d(TAG, "onDatabaseSettingUpgrade data migration start.");
                        execSQL(TRANSFER_OLD_DATA);
                        C11839m.m70686d(TAG, "onDatabaseSettingUpgrade data migration end.");
                    }
                } finally {
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "check old db tag exists error." + e10.toString());
        }
    }

    @Override // ml.AbstractC11478a
    public String[] getColumns(Settings settings) {
        return new String[]{settings.getName(), settings.getValue(), settings.getType()};
    }

    @Override // ml.AbstractC11478a
    public Settings getObject(Cursor cursor) {
        Settings settings = new Settings();
        settings.setName(cursor.getString(0));
        settings.setValue(cursor.getString(1));
        settings.setType(cursor.getString(2));
        return settings;
    }
}
