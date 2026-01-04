package com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator;

import android.database.Cursor;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.bean.PmsMetaStatus;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.script.PmsMetaDBScript;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.script.PmsMetaStatusDBScript;
import fk.C9721b;
import java.util.List;
import java.util.Locale;
import ml.AbstractC11478a;
import p514o9.C11839m;
import p682ul.C13216j;

/* loaded from: classes2.dex */
public class PmsMetaStatusOperator extends AbstractC11478a<PmsMetaStatus> {
    private static final String TAG = "PmsMetaStatusOperator";

    public PmsMetaStatusOperator(String str) {
        super(C13216j.m79427l(C13216j.c.PMSBRIEF, str));
    }

    public void clear() throws C9721b {
        execSQL(String.format(Locale.ENGLISH, "delete from %s", PmsMetaDBScript.TABLE_NAME_META_STATUS));
    }

    public boolean isExistTable() {
        try {
            Cursor cursorRawQuery = rawQuery(PmsMetaStatusDBScript.CHECK_METASTATUS_TABLE_EXIST, null);
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        if (cursorRawQuery.getInt(0) > 0) {
                            cursorRawQuery.close();
                            return true;
                        }
                    }
                } finally {
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "check isExistTable exists error." + e10.toString());
        }
        return false;
    }

    public PmsMetaStatus query() throws C9721b {
        List<PmsMetaStatus> listQuery = query(PmsMetaStatusDBScript.QUERY_META_STATUS, null);
        if (listQuery.size() <= 0) {
            return null;
        }
        return listQuery.get(0);
    }

    public void replace(PmsMetaStatus pmsMetaStatus) throws C9721b {
        execSQL(PmsMetaStatusDBScript.REPLACE_PMSMETASTATUS, getColumns(pmsMetaStatus));
    }

    public void updateModifytime(long j10) throws C9721b {
        execSQL(PmsMetaStatusDBScript.UPDATE_MODIFYTIME, new String[]{String.valueOf(j10)});
    }

    public void updateStatus(int i10) throws C9721b {
        execSQL(PmsMetaStatusDBScript.UPDATE_STATUS, new String[]{String.valueOf(i10)});
    }

    @Override // ml.AbstractC11478a
    public String[] getColumns(PmsMetaStatus pmsMetaStatus) {
        return pmsMetaStatus.getColumns();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // ml.AbstractC11478a
    public PmsMetaStatus getObject(Cursor cursor) {
        return PmsMetaStatus.getObject(cursor);
    }
}
