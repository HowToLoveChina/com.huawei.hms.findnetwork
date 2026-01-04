package p225dd;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p514o9.C11839m;

/* renamed from: dd.e */
/* loaded from: classes3.dex */
public abstract class AbstractC9069e<T> {

    /* renamed from: a */
    public SQLiteDatabase f45815a;

    public AbstractC9069e(SQLiteDatabase sQLiteDatabase) {
        this.f45815a = sQLiteDatabase;
    }

    /* renamed from: a */
    public void m57236a(String str, List<T> list) throws C9721b {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(mo57233e(it.next()));
        }
        m57239d(str, arrayList);
    }

    /* renamed from: b */
    public void m57237b(String str, String str2, String[] strArr) throws C9721b {
        SQLiteDatabase sQLiteDatabase = this.f45815a;
        if (sQLiteDatabase == null) {
            C11839m.m70689w("CloudSyncBaseOperator", "database is null.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "database is null.", "execSQL");
        }
        try {
            sQLiteDatabase.delete(str, str2, strArr);
        } catch (Exception e10) {
            C11839m.m70687e("CloudSyncBaseOperator", "exec sql error." + e10.getMessage());
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "exec sql error. " + e10.getMessage(), "delete");
        }
    }

    /* renamed from: c */
    public void m57238c(String str, String[] strArr) throws C9721b {
        ArrayList arrayList = new ArrayList();
        arrayList.add(strArr);
        m57239d(str, arrayList);
    }

    /* renamed from: d */
    public void m57239d(String str, List<String[]> list) throws C9721b {
        SQLiteDatabase sQLiteDatabase = this.f45815a;
        if (sQLiteDatabase == null) {
            C11839m.m70689w("CloudSyncBaseOperator", "database is null.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "database is null.", "doTransaction");
        }
        try {
            try {
                sQLiteDatabase.beginTransaction();
                SQLiteStatement sQLiteStatementCompileStatement = this.f45815a.compileStatement(str);
                for (String[] strArr : list) {
                    sQLiteStatementCompileStatement.clearBindings();
                    sQLiteStatementCompileStatement.bindAllArgsAsStrings(strArr);
                    sQLiteStatementCompileStatement.execute();
                }
                this.f45815a.setTransactionSuccessful();
                this.f45815a.endTransaction();
            } catch (Exception e10) {
                C11839m.m70687e("CloudSyncBaseOperator", "database transaction error. " + e10.getMessage());
                throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "database transaction error. " + e10.getMessage(), "execute");
            }
        } catch (Throwable th2) {
            this.f45815a.endTransaction();
            throw th2;
        }
    }

    /* renamed from: e */
    public abstract String[] mo57233e(T t10);
}
