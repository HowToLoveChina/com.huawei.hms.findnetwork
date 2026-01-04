package com.huawei.hicloud.notification.p106db.operator;

import android.database.Cursor;
import android.database.SQLException;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.CommonNoticeContent;
import com.huawei.hicloud.notification.p106db.script.NoticeContentScript;
import fk.C9721b;
import java.util.List;
import p016an.AbstractC0315c;

/* loaded from: classes6.dex */
public class CommonNotifyContentOperator extends AbstractC0315c<CommonNoticeContent> {
    private static final String TAG = "CommonNotifyContentOperator";

    public void clear() throws SQLException {
        try {
            execSQL(NoticeContentScript.CLEAR_SPACE_NOTIFY_CONTENT);
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "clear spacenotify error." + e10.getMessage());
        }
    }

    public void insertContent(List<String[]> list) {
        try {
            execSQL4Batch(NoticeContentScript.INSETT_SPACE_NOTIFY_CONTENT, list);
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "insert default rules error." + e10.getMessage());
        }
    }

    public CommonNoticeContent queryContent(int i10, int i11, String str, String str2, String str3) throws Throwable {
        List<CommonNoticeContent> listQueryResult4Vo;
        try {
            listQueryResult4Vo = queryResult4Vo(NoticeContentScript.QUERY_SPACE_NOTIFY_CONTENT, new String[]{String.valueOf(i10), String.valueOf(i11), str, str2, str3});
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "query rules error." + e10.getMessage());
            listQueryResult4Vo = null;
        }
        if (listQueryResult4Vo == null || listQueryResult4Vo.size() <= 0) {
            return null;
        }
        return listQueryResult4Vo.get(0);
    }

    public CommonNoticeContent queryContentByLanguage(int i10, int i11, String str, String str2, String str3) throws Throwable {
        List<CommonNoticeContent> listQueryResult4Vo;
        try {
            listQueryResult4Vo = queryResult4Vo(NoticeContentScript.QUERY_SPACE_NOTIFY_CONTENT_BY_LANGUAGE, new String[]{String.valueOf(i10), String.valueOf(i11), str + '%', str2, str3});
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "query rules error." + e10.getMessage());
            listQueryResult4Vo = null;
        }
        if (listQueryResult4Vo == null || listQueryResult4Vo.size() <= 0) {
            return null;
        }
        return listQueryResult4Vo.get(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p016an.AbstractC0315c
    public CommonNoticeContent getVo(Cursor cursor) {
        CommonNoticeContent commonNoticeContent = new CommonNoticeContent();
        commonNoticeContent.setLanguage(cursor.getString(0));
        commonNoticeContent.setTitle(cursor.getString(1));
        commonNoticeContent.setMainText(cursor.getString(2));
        commonNoticeContent.setSubTitle(cursor.getString(3));
        commonNoticeContent.setRemindMode(cursor.getString(4));
        commonNoticeContent.setButtonFirst(cursor.getString(5));
        commonNoticeContent.setButtonSecond(cursor.getString(6));
        commonNoticeContent.setDescription(cursor.getString(7));
        commonNoticeContent.setDescriptionSecond(cursor.getString(8));
        commonNoticeContent.setMainTextSecond(cursor.getString(9));
        commonNoticeContent.setContentType(cursor.getString(10));
        return commonNoticeContent;
    }
}
