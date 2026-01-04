package p836z8;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import p514o9.C11839m;

/* renamed from: z8.g */
/* loaded from: classes3.dex */
public class C14158g {

    /* renamed from: a */
    public static final Uri f63311a = Uri.parse("content://com.huawei.android.hicloud.devicenameprovider/backup_end_time");

    /* renamed from: b */
    public static final Uri f63312b = Uri.parse("content://com.huawei.android.hicloud.devicenameprovider/backup_notAllSucess");

    /* renamed from: c */
    public static final Uri f63313c = Uri.parse("content://com.huawei.android.hicloud.devicenameprovider/recordingtimestamp");

    /* renamed from: a */
    public static String m84964a(String str, Context context) {
        C11839m.m70686d("QueryBackupEndTime", "queryBackupEndTime  syncType: " + str);
        String string = "0";
        if (context == null) {
            return "0";
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(f63311a, null, str, null, null);
                while (cursorQuery != null) {
                    if (!cursorQuery.moveToNext()) {
                        break;
                    }
                    string = cursorQuery.getString(cursorQuery.getColumnIndex(str));
                    C11839m.m70688i("QueryBackupEndTime", "backup time: " + str + " = " + string);
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return string;
            } catch (Exception e10) {
                C11839m.m70687e("QueryBackupEndTime", " is not support!" + e10.toString());
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return string;
            }
        } catch (Throwable th2) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th2;
        }
    }

    /* renamed from: b */
    public static int m84965b(String str, Context context) {
        C11839m.m70686d("QueryBackupEndTime", "updateNotAllSucess");
        ContentValues contentValues = new ContentValues();
        int iUpdate = -1;
        if (context == null) {
            C11839m.m70687e("QueryBackupEndTime", "updateNotAllSucess: context is null");
            return -1;
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            C11839m.m70687e("QueryBackupEndTime", "updateNotAllSucess: contentResolver is null");
            return -1;
        }
        try {
            iUpdate = contentResolver.update(f63312b, contentValues, str, null);
            C11839m.m70686d("QueryBackupEndTime", "result: " + iUpdate);
            return iUpdate;
        } catch (Exception e10) {
            C11839m.m70687e("QueryBackupEndTime", " is not support!" + e10.toString());
            return iUpdate;
        }
    }

    /* renamed from: c */
    public static int m84966c(long j10, Context context) {
        C11839m.m70688i("QueryBackupEndTime", "updateRecordingTimestamp");
        int iUpdate = -1;
        if (context == null) {
            C11839m.m70687e("QueryBackupEndTime", "updateRecordingTimestamp: context is null");
            return -1;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("recordingtimestamp", Long.valueOf(j10));
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            C11839m.m70687e("QueryBackupEndTime", "updateRecordingTimestamp: contentResolver is null");
            return -1;
        }
        try {
            iUpdate = contentResolver.update(f63313c, contentValues, "recordingtimestamp", null);
            C11839m.m70688i("QueryBackupEndTime", "result: " + iUpdate);
            return iUpdate;
        } catch (Exception e10) {
            C11839m.m70687e("QueryBackupEndTime", " is not support!" + e10.toString());
            return iUpdate;
        }
    }
}
