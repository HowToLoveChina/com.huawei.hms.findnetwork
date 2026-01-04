package p836z8;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import p514o9.C11839m;

/* renamed from: z8.h */
/* loaded from: classes3.dex */
public class C14159h {

    /* renamed from: a */
    public static final Uri f63314a = Uri.parse("content://com.huawei.android.hicloud.syncstate/is_sync_task_exist");

    /* renamed from: b */
    public static final Uri f63315b = Uri.parse("content://com.huawei.android.hicloud.syncstate/reset_sync_retry_time");

    /* renamed from: a */
    public static boolean m84967a(Context context, String str) {
        if (context == null) {
            C11839m.m70687e("QuerySyncStateFromProvider", "isSyncTaskExist: Context is null");
            return false;
        }
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = contentResolver.query(f63314a, null, null, new String[]{str}, null);
                while (cursorQuery != null) {
                    if (!cursorQuery.moveToNext()) {
                        break;
                    }
                    if (cursorQuery.getString(cursorQuery.getColumnIndex("is_sync_task_exist_key")).equals(FaqConstants.DISABLE_HA_REPORT)) {
                        cursorQuery.close();
                        return true;
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return false;
            } catch (Exception e10) {
                C11839m.m70687e("QuerySyncStateFromProvider", "isSyncTaskExist: " + e10.toString());
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return false;
            }
        } catch (Throwable th2) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th2;
        }
    }

    /* renamed from: b */
    public static void m84968b(Context context, String str) {
        if (context == null) {
            C11839m.m70687e("QuerySyncStateFromProvider", "resetSyncRetryTimes: Context is null");
            return;
        }
        try {
            ContentResolver contentResolver = context.getContentResolver();
            ContentValues contentValues = new ContentValues();
            if (contentResolver == null) {
                C11839m.m70687e("QuerySyncStateFromProvider", "resetSyncRetryTimes: contentResolver is null");
            } else {
                contentResolver.update(f63315b, contentValues, str, null);
            }
        } catch (Exception e10) {
            C11839m.m70687e("QuerySyncStateFromProvider", "reset Sync Retry Times failed. " + e10.toString());
        }
    }
}
