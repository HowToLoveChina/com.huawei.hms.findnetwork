package com.huawei.android.backup.service.logic.calendar;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.provider.CalendarContract;
import com.huawei.android.backup.filelogic.utils.C2108a;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.logic.calendar.CalendarConfigTable;
import com.huawei.android.backup.service.logic.calendar.DefaultCalendarConditionBuilder;
import p386j6.C10713c;

/* loaded from: classes.dex */
public abstract class BackupCalendar extends BackupObject {
    private static final String CALENDAR_ID_WHERE = "(account_name = 'Phone' or account_name = 'PC Sync') and account_type != 'com.android.huawei.birthday'";

    /* renamed from: ID */
    private static final String f9601ID = "_id";
    private static final String TAG = "BackupCalendar";
    private int accountId = -1;
    private static final String ACCOUNT_NAME = "account_name";
    private static final String ACCOUNT_TYPE = "account_type";
    private static final String[] PROJECTION = {"_id", ACCOUNT_NAME, ACCOUNT_TYPE};

    private Bundle getBackupItemCount(Context context) {
        DefaultCalendarConditionBuilder defaultCalendarConditionBuilder = new DefaultCalendarConditionBuilder(context);
        defaultCalendarConditionBuilder.addBuilder(new DefaultCalendarConditionBuilder.GmailCalendarConditionBuilder(context, true));
        String strBuild = defaultCalendarConditionBuilder.build();
        int count = -1;
        Cursor cursorM12618d = null;
        int i10 = 0;
        try {
            try {
                C2111d.m12653i(TAG, "getBackupItemCount Calendar begin");
                cursorM12618d = C2108a.m12618d(context, CalendarConfigTable.CalendarTable.Events.URI, PROJECTION, strBuild, null, null);
                if (cursorM12618d != null) {
                    count = cursorM12618d.getCount();
                    int columnIndex = cursorM12618d.getColumnIndex(ACCOUNT_NAME);
                    while (cursorM12618d.moveToNext()) {
                        if (cursorM12618d.getString(columnIndex).contains("@gmail.com")) {
                            i10++;
                        }
                    }
                }
            } catch (IllegalArgumentException unused) {
                C2111d.m12648d(TAG, "getBackupItemCount IllegalArgumentException");
                if (cursorM12618d != null) {
                }
            } catch (Exception unused2) {
                C2111d.m12648d(TAG, "getBackupItemCount error");
                if (cursorM12618d != null) {
                }
            }
            Bundle bundle = new Bundle();
            bundle.putInt("ModuleCount", count);
            bundle.putInt("gmailCalendarCount", i10);
            return bundle;
        } finally {
            if (cursorM12618d != null) {
                cursorM12618d.close();
            }
        }
    }

    public int getAccountId() {
        return this.accountId;
    }

    public boolean getCalenderId(Context context) {
        boolean z10 = false;
        Cursor cursorM12618d = null;
        try {
            try {
                cursorM12618d = C2108a.m12618d(context, CalendarContract.Calendars.CONTENT_URI, PROJECTION, CALENDAR_ID_WHERE, null, null);
                if (cursorM12618d != null && cursorM12618d.moveToFirst()) {
                    setAccountId(cursorM12618d.getInt(cursorM12618d.getColumnIndex("_id")));
                    z10 = true;
                }
            } catch (SQLiteException unused) {
                C2111d.m12648d(TAG, "getCalenderID Error.");
                if (cursorM12618d != null) {
                }
            }
            return z10;
        } finally {
            if (cursorM12618d != null) {
                cursorM12618d.close();
            }
        }
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public Bundle onBackupModulesDataItemTotal(Context context, Long l10, int i10, String str) {
        Bundle backupItemCount = getBackupItemCount(context);
        try {
            int iM65394d = C10713c.m65394d(backupItemCount, "ModuleCount");
            C2111d.m12654j(TAG, "onBackupModulesDataItemTotal begin, moduleName:", str, ";totalNumber: ", Integer.valueOf(iM65394d), ";packageSize: ", l10);
            if (iM65394d < 0) {
                return null;
            }
            long appInfoSize = getAppInfoSize(context, l10.longValue(), iM65394d);
            Bundle bundle = new Bundle();
            bundle.putAll(backupItemCount);
            bundle.putLong("ModuleSize", appInfoSize);
            return bundle;
        } catch (BadParcelableException unused) {
            C2111d.m12648d(TAG, "Wrong data.");
            return null;
        }
    }

    public void setAccountId(int i10) {
        this.accountId = i10;
    }
}
