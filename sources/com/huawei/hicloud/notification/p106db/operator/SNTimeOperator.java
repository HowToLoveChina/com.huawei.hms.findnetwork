package com.huawei.hicloud.notification.p106db.operator;

import android.database.Cursor;
import android.database.SQLException;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.SNTimes;
import com.huawei.hicloud.notification.p106db.script.SpaceNotifyScript;
import fk.C9721b;
import java.util.List;
import p016an.AbstractC0315c;

/* loaded from: classes6.dex */
public class SNTimeOperator extends AbstractC0315c<SNTimes> {
    private static final String TAG = "SNTimeOperator";

    public void clear() throws SQLException {
        try {
            execSQL(SpaceNotifyScript.DELETE_TABLE_SPACE_NOTIFY);
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "clear SN time error." + e10.getMessage());
        }
    }

    public int queryCountByDay(String str, String str2, String str3) throws Throwable {
        List<SNTimes> listQueryResult4Vo;
        try {
            listQueryResult4Vo = queryResult4Vo(SpaceNotifyScript.QUERY_BY_DAY, new String[]{str, str2, str3});
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "queryCountByDay error." + e10.getMessage());
            listQueryResult4Vo = null;
        }
        if (listQueryResult4Vo == null || listQueryResult4Vo.isEmpty()) {
            return 0;
        }
        return listQueryResult4Vo.size();
    }

    public int queryCountByMonth(String str, String str2) throws Throwable {
        List<SNTimes> listQueryResult4Vo;
        try {
            listQueryResult4Vo = queryResult4Vo(SpaceNotifyScript.QUERY_BY_MONTH, new String[]{str, str2});
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "queryCountByMonth error." + e10.getMessage());
            listQueryResult4Vo = null;
        }
        if (listQueryResult4Vo == null || listQueryResult4Vo.isEmpty()) {
            return 0;
        }
        return listQueryResult4Vo.size();
    }

    public int queryCountByWeek(String str, String str2) throws Throwable {
        List<SNTimes> listQueryResult4Vo;
        try {
            listQueryResult4Vo = queryResult4Vo(SpaceNotifyScript.QUERY_BY_WEEK, new String[]{str, str2});
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "queryCountByWeek error." + e10.getMessage());
            listQueryResult4Vo = null;
        }
        if (listQueryResult4Vo == null || listQueryResult4Vo.isEmpty()) {
            return 0;
        }
        return listQueryResult4Vo.size();
    }

    public void replace(SNTimes sNTimes) throws SQLException {
        try {
            execSQL(SpaceNotifyScript.REPLACE_TIME, new String[]{String.valueOf(sNTimes.getTime()), String.valueOf(sNTimes.getDay()), String.valueOf(sNTimes.getMonth()), String.valueOf(sNTimes.getYear()), String.valueOf(sNTimes.getWeek())});
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "replace time error." + e10.getMessage());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p016an.AbstractC0315c
    public SNTimes getVo(Cursor cursor) {
        SNTimes sNTimes = new SNTimes();
        sNTimes.setTime(cursor.getLong(0));
        sNTimes.setDay(cursor.getInt(1));
        sNTimes.setMonth(cursor.getInt(2));
        sNTimes.setYear(cursor.getInt(3));
        sNTimes.setWeek(cursor.getInt(4));
        return sNTimes;
    }
}
