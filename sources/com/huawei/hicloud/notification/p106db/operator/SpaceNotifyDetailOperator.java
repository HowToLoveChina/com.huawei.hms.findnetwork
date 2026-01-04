package com.huawei.hicloud.notification.p106db.operator;

import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.NoticeDetail;
import com.huawei.hicloud.notification.p106db.script.NotificationScript;
import fk.C9721b;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
import p016an.AbstractC0315c;

/* loaded from: classes6.dex */
public class SpaceNotifyDetailOperator extends AbstractC0315c<NoticeDetail> {
    private static final String TAG = "SpaceNotifyDetailOperator";

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
            execSQL(NotificationScript.CLEAR_SPACE_NOTIFY_DETAIL);
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "clear spacenotify detail error." + e10.getMessage());
        }
    }

    public void insertDetail(List<String[]> list) {
        try {
            execSQL4Batch(NotificationScript.INSETT_SPACE_NOTIFY_DETAIL, list);
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "insert default rules error." + e10.getMessage());
        }
    }

    public NoticeDetail queryDetail(int i10, String str, String str2, String str3) throws Throwable {
        List<NoticeDetail> listQueryResult4Vo;
        try {
            listQueryResult4Vo = queryResult4Vo(NotificationScript.QUERY_SPACE_NOTIFY_DETAIL, new String[]{str, String.valueOf(i10), str2, str3});
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "queryDetail error." + e10.getMessage());
            listQueryResult4Vo = null;
        }
        if (listQueryResult4Vo == null || listQueryResult4Vo.size() <= 0) {
            return null;
        }
        return listQueryResult4Vo.get(0);
    }

    public NoticeDetail queryDetailByLanguage(int i10, String str, String str2, String str3) throws Throwable {
        List<NoticeDetail> listQueryResult4Vo;
        try {
            listQueryResult4Vo = queryResult4Vo(NotificationScript.QUERY_SPACE_NOTIFY_DETAIL_BY_LANGUAGE, new String[]{str, String.valueOf(i10), str2 + "%", str3});
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "queryDetailByLanguage error." + e10.getMessage());
            listQueryResult4Vo = null;
        }
        if (listQueryResult4Vo == null || listQueryResult4Vo.size() <= 0) {
            return null;
        }
        return listQueryResult4Vo.get(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p016an.AbstractC0315c
    public NoticeDetail getVo(Cursor cursor) {
        NoticeDetail noticeDetail = new NoticeDetail();
        NotifyLogger.m29915i(TAG, "cursor = " + cursor.getCount());
        noticeDetail.setLanguage(cursor.getString(0));
        noticeDetail.setTitle(cursor.getString(1));
        noticeDetail.setMainText(cursor.getString(2));
        noticeDetail.setButtonFirst(cursor.getString(3));
        noticeDetail.setDetailLink(getDetailLinkMap(cursor.getString(4)));
        return noticeDetail;
    }
}
