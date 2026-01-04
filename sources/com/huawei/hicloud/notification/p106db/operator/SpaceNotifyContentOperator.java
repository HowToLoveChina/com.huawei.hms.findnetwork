package com.huawei.hicloud.notification.p106db.operator;

import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.NoticeContent;
import com.huawei.hicloud.notification.p106db.script.NotificationScript;
import fk.C9721b;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
import p016an.AbstractC0315c;

/* loaded from: classes6.dex */
public class SpaceNotifyContentOperator extends AbstractC0315c<NoticeContent> {
    private static final String TAG = "SpaceNotifyContentOperator";

    private LinkedHashMap<String, String> getDetailLinkMap(String str) {
        LinkedHashMap<String, String> linkedHashMap;
        Exception e10;
        try {
        } catch (Exception e11) {
            linkedHashMap = null;
            e10 = e11;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        linkedHashMap = new LinkedHashMap<>();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                linkedHashMap.put(next, jSONObject.getString(next));
            }
        } catch (Exception e12) {
            e10 = e12;
            NotifyLogger.m29914e(TAG, "detaiLinkStr error:" + e10.toString());
            return linkedHashMap;
        }
        return linkedHashMap;
    }

    public void clear() throws SQLException {
        try {
            execSQL(NotificationScript.CLEAR_SPACE_NOTIFY_CONTENT);
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "clear spacenotify error." + e10.getMessage());
        }
    }

    public void insertContent(List<String[]> list) {
        try {
            execSQL4Batch(NotificationScript.INSETT_SPACE_NOTIFY_CONTENT, list);
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "insert default rules error." + e10.getMessage());
        }
    }

    public NoticeContent queryContent(int i10, int i11, String str, String str2) throws Throwable {
        List<NoticeContent> listQueryResult4Vo;
        try {
            listQueryResult4Vo = queryResult4Vo(NotificationScript.QUERY_SPACE_NOTIFY_CONTENT, new String[]{String.valueOf(i10), String.valueOf(i11), str, str2});
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "query rules error." + e10.getMessage());
            listQueryResult4Vo = null;
        }
        if (listQueryResult4Vo == null || listQueryResult4Vo.size() <= 0) {
            return null;
        }
        return listQueryResult4Vo.get(0);
    }

    public NoticeContent queryContentByLanguage(int i10, int i11, String str, String str2) throws Throwable {
        List<NoticeContent> listQueryResult4Vo;
        try {
            listQueryResult4Vo = queryResult4Vo(NotificationScript.QUERY_SPACE_NOTIFY_CONTENT_BY_LANGUAGE, new String[]{String.valueOf(i10), String.valueOf(i11), str + '%', str2});
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "query rules error." + e10.getMessage());
            listQueryResult4Vo = null;
        }
        if (listQueryResult4Vo == null || listQueryResult4Vo.size() <= 0) {
            return null;
        }
        return listQueryResult4Vo.get(0);
    }

    public NoticeContent queryPullNewContent(int i10, int i11, String str) throws Throwable {
        List<NoticeContent> listQueryResult4Vo;
        try {
            listQueryResult4Vo = queryResult4Vo(NotificationScript.QUERY_PULL_NEW_CONTENT, new String[]{String.valueOf(i10), String.valueOf(i11), str});
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "query rules error." + e10.getMessage());
            listQueryResult4Vo = null;
        }
        if (listQueryResult4Vo == null || listQueryResult4Vo.size() <= 0) {
            return null;
        }
        return listQueryResult4Vo.get(0);
    }

    public NoticeContent queryPullNewContentByLanguage(int i10, int i11, String str) throws Throwable {
        List<NoticeContent> listQueryResult4Vo;
        try {
            listQueryResult4Vo = queryResult4Vo(NotificationScript.QUERY_PULL_NEW_CONTENT_BY_LANGUAGE, new String[]{String.valueOf(i10), String.valueOf(i11), str + '%'});
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
    public NoticeContent getVo(Cursor cursor) {
        NoticeContent noticeContent = new NoticeContent();
        noticeContent.setLanguage(cursor.getString(0));
        noticeContent.setTitle(cursor.getString(1));
        noticeContent.setMainText(cursor.getString(2));
        noticeContent.setSubTitle(cursor.getString(3));
        noticeContent.setRemindMode(cursor.getString(4));
        noticeContent.setButtonFirst(cursor.getString(5));
        noticeContent.setButtonSecond(cursor.getString(6));
        noticeContent.setDescription(cursor.getString(7));
        noticeContent.setDescriptionSecond(cursor.getString(8));
        noticeContent.setMainTextSecond(cursor.getString(9));
        noticeContent.setDetailLink(getDetailLinkMap(cursor.getString(10)));
        return noticeContent;
    }
}
