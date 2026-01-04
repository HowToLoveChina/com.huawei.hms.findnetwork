package com.huawei.phoneservice.feedbackcommon.p176db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Keep;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.feedbackcommon.entity.ProblemEntity;
import java.util.ArrayList;
import java.util.List;
import p408jw.C10951q;
import p692uw.C13264g;
import p692uw.C13267j;

@Keep
/* loaded from: classes5.dex */
public final class FeedbackProblemData extends SQLiteOpenHelper {
    private static final String ADDRESS_DB_NAME = "db_feedback_data";
    private static final int ADDRESS_DB_VERSION = 3;
    public static final C8602a Companion = new C8602a(null);
    private static final String LOG_TAG = "FeedbackDataManager";
    private static final String PROBLEMID = "problemId";
    private static final String TAB_CREATE = "create table if not exists table_feedback_problem(_id INTEGER primary key autoincrement,problemId String);";
    private static final String TAB_ROM = "table_feedback_problem";

    /* renamed from: db */
    private static SQLiteDatabase f40032db;
    private static FeedbackProblemData mInstance;

    /* renamed from: com.huawei.phoneservice.feedbackcommon.db.FeedbackProblemData$a */
    public static final class C8602a {
        public C8602a() {
        }

        public /* synthetic */ C8602a(C13264g c13264g) {
            this();
        }

        /* renamed from: a */
        public final FeedbackProblemData m53171a(Context context) {
            if (FeedbackProblemData.mInstance == null) {
                synchronized (FeedbackProblemData.class) {
                    try {
                        if (FeedbackProblemData.mInstance == null) {
                            FeedbackProblemData.mInstance = new FeedbackProblemData(context != null ? context.getApplicationContext() : null);
                        }
                        C10951q c10951q = C10951q.f51861a;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            return FeedbackProblemData.mInstance;
        }
    }

    public FeedbackProblemData(Context context) {
        super(context, ADDRESS_DB_NAME, (SQLiteDatabase.CursorFactory) null, 3);
        synchronized (FeedbackMediaData.class) {
            try {
                if (f40032db == null) {
                    f40032db = getWritableDatabase();
                }
                C10951q c10951q = C10951q.f51861a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static final FeedbackProblemData getInstance(Context context) {
        return Companion.m53171a(context);
    }

    private final boolean isAdd(String str) {
        SQLiteDatabase sQLiteDatabase = f40032db;
        C13267j.m79674b(sQLiteDatabase);
        Cursor cursorQuery = sQLiteDatabase.query(TAB_ROM, null, "problemId= ?", new String[]{str}, null, null, null);
        boolean z10 = false;
        while (cursorQuery.moveToFirst()) {
            z10 = true;
        }
        cursorQuery.close();
        return z10;
    }

    public final void deleteFailProblem(String str) throws Throwable {
        FaqLogger.m51841e(LOG_TAG, "deleteFailProblem", new Object[0]);
        SQLiteDatabase sQLiteDatabase = f40032db;
        C13267j.m79674b(sQLiteDatabase);
        sQLiteDatabase.delete(TAB_ROM, "problemId=?", new String[]{str});
    }

    public final List<ProblemEntity> getAllFailProblem() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = f40032db;
        Cursor cursorQuery = sQLiteDatabase != null ? sQLiteDatabase.query(TAB_ROM, null, null, null, null, null, null) : null;
        while (true) {
            Boolean boolValueOf = cursorQuery != null ? Boolean.valueOf(cursorQuery.moveToNext()) : null;
            C13267j.m79674b(boolValueOf);
            if (!boolValueOf.booleanValue()) {
                cursorQuery.close();
                return arrayList;
            }
            ProblemEntity problemEntity = new ProblemEntity();
            problemEntity.m53181c(cursorQuery.getString(cursorQuery.getColumnIndex(PROBLEMID)));
            arrayList.add(problemEntity);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        C13267j.m79677e(sQLiteDatabase, "db");
        sQLiteDatabase.execSQL(TAB_CREATE);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        if ((i10 == 1 || i10 == 2) && sQLiteDatabase != null) {
            sQLiteDatabase.execSQL(TAB_CREATE);
        }
    }

    public final void saveFailProblem(ProblemEntity problemEntity) throws Throwable {
        C13267j.m79677e(problemEntity, "data");
        FaqLogger.m51841e(LOG_TAG, "saveFailProblem", new Object[0]);
        String strM53180a = problemEntity.m53180a();
        C13267j.m79676d(strM53180a, "data.problemId");
        if (isAdd(strM53180a)) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(PROBLEMID, problemEntity.m53180a());
        SQLiteDatabase sQLiteDatabase = f40032db;
        C13267j.m79674b(sQLiteDatabase);
        sQLiteDatabase.insert(TAB_ROM, null, contentValues);
    }
}
