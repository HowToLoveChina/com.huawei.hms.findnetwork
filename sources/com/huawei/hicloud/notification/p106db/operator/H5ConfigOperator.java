package com.huawei.hicloud.notification.p106db.operator;

import android.database.Cursor;
import android.database.SQLException;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.H5ConfigBean;
import com.huawei.hicloud.notification.p106db.script.H5ConfigScript;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import p016an.AbstractC0315c;

/* loaded from: classes6.dex */
public class H5ConfigOperator extends AbstractC0315c<H5ConfigBean> {
    private static final String TAG = "H5ConfigOperator";

    public void clear() throws SQLException {
        try {
            execSQL(H5ConfigScript.CLEAR_H5_CONFIG_CONTENT);
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "clear spacenotify error." + e10.getMessage());
        }
    }

    public void insertContent(List<String[]> list) {
        try {
            execSQL4Batch(H5ConfigScript.INSETT_H5_CONFIG_CONTENT, list);
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "insert default rules error." + e10.getMessage());
        }
    }

    public H5ConfigBean queryH5Config(String str, String str2) throws Throwable {
        List<H5ConfigBean> listQueryResult4Vo;
        try {
            listQueryResult4Vo = queryResult4Vo(H5ConfigScript.QUERY_H5_CONFIG_CONTENT, new String[]{str, str2});
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "query rules error." + e10.getMessage());
            listQueryResult4Vo = null;
        }
        if (listQueryResult4Vo == null || listQueryResult4Vo.size() <= 0) {
            return null;
        }
        return listQueryResult4Vo.get(0);
    }

    public void saveConfigs(List<H5ConfigBean> list) {
        ArrayList arrayList = new ArrayList();
        for (H5ConfigBean h5ConfigBean : list) {
            arrayList.add(new String[]{h5ConfigBean.getResourceId(), h5ConfigBean.getKey(), h5ConfigBean.getValue()});
        }
        insertContent(arrayList);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p016an.AbstractC0315c
    public H5ConfigBean getVo(Cursor cursor) {
        H5ConfigBean h5ConfigBean = new H5ConfigBean();
        h5ConfigBean.setResourceId(cursor.getString(0));
        h5ConfigBean.setKey(cursor.getString(1));
        h5ConfigBean.setValue(cursor.getString(2));
        return h5ConfigBean;
    }
}
