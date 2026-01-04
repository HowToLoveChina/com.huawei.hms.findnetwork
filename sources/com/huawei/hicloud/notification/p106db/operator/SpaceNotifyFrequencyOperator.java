package com.huawei.hicloud.notification.p106db.operator;

import android.database.Cursor;
import android.database.SQLException;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotifyFrequencyBean;
import com.huawei.hicloud.notification.p106db.script.SpaceNoticeV3Script;
import fk.C9721b;
import java.util.List;
import p015ak.C0241z;
import p016an.AbstractC0315c;

/* loaded from: classes6.dex */
public class SpaceNotifyFrequencyOperator extends AbstractC0315c<SpaceNotifyFrequencyBean> {
    private static final String TAG = "SpaceNotifyFrequencyOperator";

    private void insertDefaultRules(String str, String str2) throws SQLException {
        try {
            execSQL(SpaceNoticeV3Script.INSERT_SPACE_NOTIFY_FREQUENCY, new String[]{str, str2, "0", "0"});
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "insert default space notify error." + e10.getMessage());
        }
    }

    public void clear() throws SQLException {
        try {
            execSQL(SpaceNoticeV3Script.CLEAR_SPACE_NOTIFY_FREQUENCY);
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "clear space notify error." + e10.getMessage());
        }
    }

    public long getLastNotifyTime(String str, String str2) throws Throwable {
        List<SpaceNotifyFrequencyBean> listQueryResult4Vo;
        try {
            listQueryResult4Vo = queryResult4Vo(SpaceNoticeV3Script.QUERY_SPACE_NOTIFY_FREQUENCY, new String[]{str, str2});
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "get NDC notify time error." + e10.getMessage());
            listQueryResult4Vo = null;
        }
        if (listQueryResult4Vo != null) {
            return listQueryResult4Vo.get(0).getLastTimeStamp();
        }
        insertDefaultRules(str, str2);
        return 0L;
    }

    public void updateCount(String str, String str2) throws SQLException {
        try {
            execSQL(SpaceNoticeV3Script.UPDATE_SPACE_NOTIFY_FREQUENCY, new String[]{String.valueOf(System.currentTimeMillis()), str, str2});
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "update space notify count error." + e10.getMessage());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p016an.AbstractC0315c
    public SpaceNotifyFrequencyBean getVo(Cursor cursor) {
        SpaceNotifyFrequencyBean spaceNotifyFrequencyBean = new SpaceNotifyFrequencyBean();
        spaceNotifyFrequencyBean.setmCount(cursor.getInt(0));
        spaceNotifyFrequencyBean.setLastTimeStamp(C0241z.m1688f(cursor.getString(1)));
        return spaceNotifyFrequencyBean;
    }
}
