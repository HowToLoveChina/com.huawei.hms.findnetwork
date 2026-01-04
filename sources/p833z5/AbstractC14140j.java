package p833z5;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteCursor;
import android.os.Bundle;
import android.os.Handler;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.logic.InterfaceC2155n;
import p006a5.AbstractC0048c;

/* renamed from: z5.j */
/* loaded from: classes.dex */
public abstract class AbstractC14140j extends BackupObject {

    /* renamed from: a */
    public InterfaceC2155n f63220a;

    public AbstractC14140j(InterfaceC2155n interfaceC2155n) {
        this.f63220a = interfaceC2155n;
    }

    /* renamed from: a */
    public ContentValues m84903a(SQLiteCursor sQLiteCursor) {
        ContentValues contentValues = new ContentValues();
        int columnCount = sQLiteCursor.getColumnCount();
        for (int i10 = 0; i10 < columnCount; i10++) {
            String columnName = sQLiteCursor.getColumnName(i10);
            if (sQLiteCursor.isNull(i10)) {
                contentValues.putNull(columnName);
            } else if (sQLiteCursor.getType(i10) == 4) {
                contentValues.put(columnName, sQLiteCursor.getBlob(i10));
            } else if (sQLiteCursor.getType(i10) == 1) {
                contentValues.put(columnName, Long.valueOf(sQLiteCursor.getLong(i10)));
            } else if (sQLiteCursor.getType(i10) == 2) {
                contentValues.put(columnName, Float.valueOf(sQLiteCursor.getFloat(i10)));
            } else if (sQLiteCursor.getType(i10) == 3) {
                contentValues.put(columnName, sQLiteCursor.getString(i10));
            } else {
                C2111d.m12646b("SubImp", "this type do not need.");
            }
        }
        return contentValues;
    }

    /* renamed from: b */
    public abstract boolean mo84855b();

    /* renamed from: c */
    public abstract boolean mo84856c();

    /* renamed from: d */
    public abstract int mo84857d();

    /* renamed from: e */
    public abstract boolean mo84858e();

    /* renamed from: f */
    public abstract boolean mo84859f();

    /* renamed from: g */
    public abstract int mo84860g();

    /* renamed from: h */
    public abstract int mo84861h();

    /* renamed from: i */
    public abstract String mo84862i();

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public boolean isSupported(Context context, String str) {
        return false;
    }

    /* renamed from: j */
    public abstract int mo84863j();

    /* renamed from: k */
    public InterfaceC2155n m84904k() {
        return this.f63220a;
    }

    /* renamed from: l */
    public abstract int mo84864l();

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int onBackup(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        return 0;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public Bundle onBackupModulesDataItemTotal(Context context, Long l10, int i10, String str) {
        return null;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int onRestore(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        return 0;
    }
}
