package tl;

import android.database.Cursor;
import com.huawei.android.hicloud.cloudbackup.bean.BaseServiceAppItem;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import ml.AbstractC11478a;
import p514o9.C11839m;
import p682ul.C13216j;

/* renamed from: tl.j */
/* loaded from: classes6.dex */
public class C13031j extends AbstractC11478a<BaseServiceAppItem> {
    public C13031j() {
        super(C13216j.m79427l(C13216j.c.TAG, null));
        if (isTableExist("t_cloudbackup_base_service_app")) {
            return;
        }
        try {
            C11839m.m70688i("BaseServiceAppOperator", "t_cloudbackup_base_service_app table not exist, create table");
            execSQL("create table if not exists t_cloudbackup_base_service_app(appId text not null,type integer not null default 0,data1 text, data2 text, data3 text,primary key (appId));");
        } catch (C9721b e10) {
            C11839m.m70687e("BaseServiceAppOperator", "create t_cloudbackup_base_service_app table error: " + e10.getMessage());
        }
    }

    /* renamed from: a */
    public void m78500a(List<BaseServiceAppItem> list) throws C9721b {
        C11839m.m70686d("BaseServiceAppOperator", "batchInsert begin");
        batch("replace into t_cloudbackup_base_service_app(appId,type) values(?, ?)", list);
        C11839m.m70686d("BaseServiceAppOperator", "batchInsert end");
    }

    @Override // ml.AbstractC11478a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String[] getColumns(BaseServiceAppItem baseServiceAppItem) {
        return new String[]{baseServiceAppItem.getAppId(), String.valueOf(baseServiceAppItem.getType())};
    }

    @Override // ml.AbstractC11478a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public BaseServiceAppItem getObject(Cursor cursor) {
        BaseServiceAppItem baseServiceAppItem = new BaseServiceAppItem();
        baseServiceAppItem.setAppId(cursor.getString(0));
        baseServiceAppItem.setType(cursor.getInt(1));
        return baseServiceAppItem;
    }

    public void clear() {
        C11839m.m70688i("BaseServiceAppOperator", "clear t_cloudbackup_base_service_app");
        try {
            execSQL("delete from t_cloudbackup_base_service_app");
        } catch (Exception e10) {
            C11839m.m70687e("BaseServiceAppOperator", "clear fail:" + e10);
        }
    }

    /* renamed from: d */
    public List<BaseServiceAppItem> m78503d() {
        try {
            return query("select appId,type,data1,data2,data3 from t_cloudbackup_base_service_app;", new String[0]);
        } catch (Exception e10) {
            C11839m.m70687e("BaseServiceAppOperator", e10.toString());
            return new ArrayList();
        }
    }
}
