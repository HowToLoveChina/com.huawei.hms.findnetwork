package p673u9;

import android.database.Cursor;
import cn.C1461a;
import com.huawei.feedback.log.BaseLogger;
import com.huawei.hicloud.request.appmashup.bean.C4987f;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import p016an.AbstractC0315c;

/* renamed from: u9.c */
/* loaded from: classes3.dex */
public class C13138c extends AbstractC0315c<C4987f> {
    /* renamed from: a */
    public void m79021a() throws Throwable {
        C1461a.m8359i("ParamsValueOperator", "deleteData enter");
        try {
            queryResult4Vo("delete from hicloud_params_value;", null);
        } catch (C9721b e10) {
            BaseLogger.m28736w("ParamsValueOperator", "deleteData error: {}", e10.getMessage());
        }
    }

    @Override // p016an.AbstractC0315c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C4987f getVo(Cursor cursor) {
        return new C4987f(cursor.getString(0), cursor.getString(1), String.valueOf(cursor.getLong(2)));
    }

    /* renamed from: c */
    public List<C4987f> m79023c(String str) {
        C1461a.m8359i("ParamsValueOperator", "queryParamsValue enter");
        try {
            return queryResult4Vo("select key,value,expireTime from hicloud_params_value where key=?;", new String[]{str});
        } catch (C9721b e10) {
            BaseLogger.m28736w("ParamsValueOperator", "queryParamsValue error: {}", e10.getMessage());
            return null;
        }
    }

    /* renamed from: d */
    public void m79024d(List<C4987f> list) {
        C1461a.m8359i("ParamsValueOperator", "replaceBatch enter");
        if (list == null || list.size() == 0) {
            C1461a.m8360w("ParamsValueOperator", "replaceBatch error, paramsValues is null or empty");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (C4987f c4987f : list) {
            arrayList.add(new String[]{c4987f.m30026b(), c4987f.m30027c(), c4987f.m30025a()});
        }
        try {
            execSQL4Batch("replace into hicloud_params_value(key,value,expireTime) values(?,?,?);", arrayList);
        } catch (C9721b e10) {
            BaseLogger.m28736w("ParamsValueOperator", "replace time error: {}", e10.getMessage());
        }
    }

    /* renamed from: e */
    public void m79025e() throws Throwable {
        C1461a.m8359i("ParamsValueOperator", "updateParamsValueExpires enter");
        try {
            queryResult4Vo("update hicloud_params_value set expireTime = 0;", null);
        } catch (C9721b e10) {
            BaseLogger.m28736w("ParamsValueOperator", "updateParamsValueExpires error: {}", e10.getMessage());
        }
    }

    /* renamed from: f */
    public void m79026f(String str) throws Throwable {
        C1461a.m8359i("ParamsValueOperator", "updateParamsValueExpires enter key:" + str);
        try {
            queryResult4Vo("update hicloud_params_value set expireTime = 0 where key=?;", new String[]{str});
        } catch (C9721b e10) {
            BaseLogger.m28736w("ParamsValueOperator", "updateParamsValueExpires error: {}", e10.getMessage());
        }
    }
}
