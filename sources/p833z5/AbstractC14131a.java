package p833z5;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.utils.C2157a;

/* renamed from: z5.a */
/* loaded from: classes.dex */
public abstract class AbstractC14131a extends BackupObject {
    /* renamed from: a */
    public static boolean m84803a(Context context, String[] strArr) {
        try {
            Cursor cursorQuery = context.getContentResolver().query(C14139i.f63218a, strArr, null, null, null);
            if (cursorQuery == null) {
                return true;
            }
            cursorQuery.close();
            return true;
        } catch (SQLiteException unused) {
            C2111d.m12648d("BackupSms", "isDatabaseContainedColumn SQLiteException");
            return false;
        } catch (IllegalStateException unused2) {
            C2111d.m12648d("BackupSms", "isDatabaseContainedColumn IllegalStateException");
            return false;
        } catch (Exception unused3) {
            C2111d.m12648d("BackupSms", "isDatabaseContainedColumn query Exception");
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m84804b(Context context) {
        return m84803a(context, new String[]{"phone_id"});
    }

    /* renamed from: c */
    public void m84805c(Context context) {
        C2111d.m12653i("BackupSms", "send broadcast to sms after restore complete");
        if (context != null) {
            context.sendBroadcast(new Intent("com.android.mms.intent.action.SMS_RESTORE_COMPLETE"), "com.android.mms.permission.SMS_RESTORE_FINISH");
        } else {
            C2111d.m12648d("BackupSms", "sendBroadcastAfterRestoring context is null");
        }
    }

    /* renamed from: d */
    public void m84806d(Context context) {
        if (context == null) {
            C2111d.m12648d("BackupSms", "sendBroadcastToMessageAfterRestore: context is null.");
            return;
        }
        if (!C2157a.m13181P(context.getPackageManager(), "com.google.android.apps.messaging")) {
            C2111d.m12653i("BackupSms", "This phone has no google message application!");
            return;
        }
        C2111d.m12653i("BackupSms", "send broadcast to google message after restore complete");
        Intent intent = new Intent("com.hicloud.android.clone.action.SMS_RESTORE_COMPLETE");
        try {
            intent.setPackage("com.google.android.apps.messaging");
            context.sendBroadcast(intent);
        } catch (Exception e10) {
            C2111d.m12648d("BackupSms", "sendBroadcastToMessageAfterRestore setPackage error: " + e10.getMessage());
        }
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public boolean isSupported(Context context, String str) {
        return C2157a.m13182Q(context);
    }
}
