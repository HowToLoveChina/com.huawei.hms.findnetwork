package com.huawei.hicloud.notification.p106db.operator;

import android.database.Cursor;
import android.database.SQLException;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.script.FreqControlTimeScript;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p016an.AbstractC0315c;

/* loaded from: classes6.dex */
public class FreqControlTimeOperator extends AbstractC0315c<Long> {
    private static final String TAG = "SNTimeOperator";

    public void clear() throws SQLException {
        try {
            execSQL(FreqControlTimeScript.DELETE_TABLE_FREQ_CONTROL_TIME);
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "clear freq_control_time error." + e10.getMessage());
        }
    }

    public int queryCountByTimeInterval(String str, String str2) throws Throwable {
        List<Long> listQueryResult4Vo;
        try {
            listQueryResult4Vo = queryResult4Vo(FreqControlTimeScript.QUERY_DAY_COUNT, new String[]{str, str2});
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "queryCountByTimeInterval error." + e10.getMessage());
            listQueryResult4Vo = null;
        }
        if (listQueryResult4Vo == null || listQueryResult4Vo.isEmpty()) {
            return 0;
        }
        return listQueryResult4Vo.size();
    }

    public int queryMethodCountByTimeInterval(String str, String str2, String str3) throws Throwable {
        List<Long> listQueryResult4Vo;
        try {
            listQueryResult4Vo = queryResult4Vo(FreqControlTimeScript.QUERY_REMIND_METHOD_DAY_COUNT, new String[]{str, str2, str3});
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "queryMethodCountByTimeInterval error." + e10.getMessage());
            listQueryResult4Vo = null;
        }
        if (listQueryResult4Vo == null || listQueryResult4Vo.isEmpty()) {
            return 0;
        }
        return listQueryResult4Vo.size();
    }

    public int queryPurposeCountByTimeInterval(String str, String str2, String str3) throws Throwable {
        List<Long> listQueryResult4Vo;
        try {
            listQueryResult4Vo = queryResult4Vo(FreqControlTimeScript.QUERY_REMIND_PURPOSE_DAY_COUNT, new String[]{str, str2, str3});
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "queryPurposeCountByTimeInterval error." + e10.getMessage());
            listQueryResult4Vo = null;
        }
        if (listQueryResult4Vo == null || listQueryResult4Vo.isEmpty()) {
            return 0;
        }
        return listQueryResult4Vo.size();
    }

    public void replace(long j10) throws SQLException {
        try {
            execSQL(FreqControlTimeScript.REPLACE_TIME, new String[]{String.valueOf(j10), "", ""});
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "replace time error." + e10.getMessage());
        }
    }

    public void replaceBatch(long j10, List<String> list, String str) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            arrayList.add(new String[]{String.valueOf(j10), "", str});
        } else {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new String[]{String.valueOf(j10), it.next(), str});
            }
        }
        try {
            execSQL4Batch(FreqControlTimeScript.REPLACE_TIME, arrayList);
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "replace time error." + e10.getMessage());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p016an.AbstractC0315c
    public Long getVo(Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }
}
