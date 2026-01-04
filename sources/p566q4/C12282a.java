package p566q4;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.huawei.android.backup.filelogic.utils.C2111d;
import java.io.File;
import p699v4.C13334c;

/* renamed from: q4.a */
/* loaded from: classes.dex */
public class C12282a extends ContextWrapper {

    /* renamed from: a */
    public String f56917a;

    public C12282a(Context context, String str) {
        super(context);
        this.f56917a = str;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        File file = new File(this.f56917a + File.separator + str);
        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            C2111d.m12648d("CustomDbPathContext", "create folder fail: " + C13334c.m79991x(file));
        }
        return file;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i10, SQLiteDatabase.CursorFactory cursorFactory) {
        try {
            return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str), cursorFactory);
        } catch (SQLiteException unused) {
            C2111d.m12648d("CustomDbPathContext", "openOrCreateDatabase fail ");
            return null;
        } catch (Exception unused2) {
            C2111d.m12648d("CustomDbPathContext", "openOrCreateDatabase fail,Exception");
            return null;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i10, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        try {
            return SQLiteDatabase.openOrCreateDatabase(C13334c.m79991x(getDatabasePath(str)), cursorFactory, databaseErrorHandler);
        } catch (SQLiteException unused) {
            C2111d.m12648d("CustomDbPathContext", "SQLiteDatabase openOrCreateDatabase fail");
            return null;
        } catch (Exception unused2) {
            C2111d.m12648d("CustomDbPathContext", "SQLiteDatabase openOrCreateDatabase fail,Exception");
            return null;
        }
    }
}
