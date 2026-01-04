package p617rl;

import android.database.Cursor;
import com.huawei.android.hicloud.cloudbackup.bean.RestoreSequence;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import ml.AbstractC11478a;
import p514o9.C11839m;
import p682ul.C13216j;

/* renamed from: rl.e */
/* loaded from: classes6.dex */
public class C12521e extends AbstractC11478a<RestoreSequence> {
    public C12521e() {
        super(C13216j.m79427l(C13216j.c.SETTING, null));
    }

    @Override // ml.AbstractC11478a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String[] getColumns(RestoreSequence restoreSequence) {
        return new String[]{restoreSequence.getAppId(), String.valueOf(restoreSequence.getSequence())};
    }

    @Override // ml.AbstractC11478a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RestoreSequence getObject(Cursor cursor) {
        RestoreSequence restoreSequence = new RestoreSequence();
        restoreSequence.setAppId(cursor.getString(0));
        restoreSequence.setSequence(cursor.getInt(1));
        return restoreSequence;
    }

    /* renamed from: c */
    public List<String> m75314c() {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorRawQuery = rawQuery("select appId from app_restore_sequence order by CAST(sequence AS INTEGER);", null);
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        do {
                            arrayList.add(cursorRawQuery.getString(0));
                        } while (cursorRawQuery.moveToNext());
                    }
                } finally {
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (Exception e10) {
            C11839m.m70687e("AppRestoreSequenceOperator", "getRestoreSequence error: " + e10.toString());
        }
        return arrayList;
    }

    public void clear() {
        try {
            execSQL("delete from app_restore_sequence");
        } catch (C9721b e10) {
            C11839m.m70687e("AppRestoreSequenceOperator", "execSQL clear error: " + e10.toString());
        }
    }

    /* renamed from: d */
    public void m75315d(List<RestoreSequence> list) throws C9721b {
        if (list == null) {
            C11839m.m70687e("AppRestoreSequenceOperator", "updateRestoreSequence error: restoreSequenceList is null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (RestoreSequence restoreSequence : list) {
            arrayList.add(new String[]{restoreSequence.getAppId(), String.valueOf(restoreSequence.getSequence())});
        }
        try {
            execute("replace into app_restore_sequence(appId, sequence) VALUES(?,?);", arrayList);
        } catch (C9721b e10) {
            C11839m.m70687e("AppRestoreSequenceOperator", "updateAppRestoreConfig error: " + e10.toString());
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "update restore sequence exec error. " + e10.getMessage(), "execSQL");
        }
    }
}
