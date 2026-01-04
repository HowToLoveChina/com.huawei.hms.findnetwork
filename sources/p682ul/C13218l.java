package p682ul;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.script.PmsMetaDBScript;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.script.PmsMetaStatusDBScript;
import java.util.Locale;

/* renamed from: ul.l */
/* loaded from: classes6.dex */
public class C13218l extends SQLiteOpenHelper {
    public C13218l(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 3);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_FULL_BRIEF_FILES_INFO_SQL);
        sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_INDEX_FULL_BRIEF_FILES_SQL);
        sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_INDEX_STATUS_FULL_BRIEF_FILES_SQL);
        sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_BATCH_FILES_INFO_TO_COPY_SQL);
        sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_INDEX_BATCH_FILES_INFO_TO_COPY_SQL);
        sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_INDEX_STATUS_BATCH_FILES_INFO_TO_COPY_SQL);
        sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_BATCH_FILES_INFO_COPY_SUCCESS_SQL);
        sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_INDEX_BATCH_FILES_INFO_COPY_SUCCESS_SQL);
        sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_INDEX_STATUS_BATCH_FILES_INFO_TO_COPY_SQL);
        sQLiteDatabase.execSQL(PmsMetaStatusDBScript.CREATE_META_STATUS_SQL);
        sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_FULL_BRIEF_FILES_INFO_V3_SQL);
        sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_INDEX_FULL_BRIEF_FILES_V3_SQL);
        sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_INDEX_STATUS_FULL_BRIEF_FILES_V3_SQL);
        sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_BATCH_FILES_INFO_TO_COPY_V3_SQL);
        sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_INDEX_BATCH_FILES_INFO_TO_COPY_V3_SQL);
        sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_INDEX_STATUS_BATCH_FILES_INFO_TO_COPY_V3_SQL);
        sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_BATCH_FILES_INFO_COPY_SUCCESS_V3_SQL);
        sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_INDEX_BATCH_FILES_INFO_COPY_SUCCESS_V3_SQL);
        sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_INDEX_STATUS_BATCH_FILES_INFO_COPY_SUCCESS_V3_SQL);
        sQLiteDatabase.execSQL(PmsMetaStatusDBScript.CREATE_META_STATUS_V3_SQL);
        sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_TABLE_BATCH_PMS_FAST_TAR_V3);
        sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_INDEX_BATCH_PMS_FAST_TAR_V3);
        sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_TABLE_BATCH_PMS_FAST_TAR_SUCCESS_V3);
        sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_INDEX_BATCH_PMS_FAST_TAR_SUCCESS_V3);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        if (i10 > 3) {
            Locale locale = Locale.ENGLISH;
            sQLiteDatabase.execSQL(String.format(locale, PmsMetaDBScript.DROP_TABLE_BY_NAME, PmsMetaDBScript.TABLE_NAME_BATCH_PMS_FAST_TAR_V3));
            sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_TABLE_BATCH_PMS_FAST_TAR_V3);
            sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_INDEX_BATCH_PMS_FAST_TAR_V3);
            sQLiteDatabase.execSQL(String.format(locale, PmsMetaDBScript.DROP_TABLE_BY_NAME, PmsMetaDBScript.TABLE_NAME_BATCH_PMS_FAST_TAR_SUCCESS_V3));
            sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_TABLE_BATCH_PMS_FAST_TAR_SUCCESS_V3);
            sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_INDEX_BATCH_PMS_FAST_TAR_SUCCESS_V3);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        if (i10 < 2) {
            sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_FULL_BRIEF_FILES_INFO_V3_SQL);
            sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_INDEX_FULL_BRIEF_FILES_V3_SQL);
            sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_INDEX_STATUS_FULL_BRIEF_FILES_V3_SQL);
            sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_BATCH_FILES_INFO_TO_COPY_V3_SQL);
            sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_INDEX_BATCH_FILES_INFO_TO_COPY_V3_SQL);
            sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_INDEX_STATUS_BATCH_FILES_INFO_TO_COPY_V3_SQL);
            sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_BATCH_FILES_INFO_COPY_SUCCESS_V3_SQL);
            sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_INDEX_BATCH_FILES_INFO_COPY_SUCCESS_V3_SQL);
            sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_INDEX_STATUS_BATCH_FILES_INFO_COPY_SUCCESS_V3_SQL);
            sQLiteDatabase.execSQL(PmsMetaStatusDBScript.CREATE_META_STATUS_V3_SQL);
        }
        if (i10 < 3) {
            sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_TABLE_BATCH_PMS_FAST_TAR_V3);
            sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_INDEX_BATCH_PMS_FAST_TAR_V3);
            sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_TABLE_BATCH_PMS_FAST_TAR_SUCCESS_V3);
            sQLiteDatabase.execSQL(PmsMetaDBScript.CREATE_INDEX_BATCH_PMS_FAST_TAR_SUCCESS_V3);
        }
    }
}
