package nl;

import android.database.Cursor;
import com.huawei.android.hicloud.cloudbackup.bean.BlackModuleItem;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import ml.AbstractC11478a;
import p514o9.C11839m;
import p682ul.C13216j;

/* renamed from: nl.a */
/* loaded from: classes6.dex */
public class C11719a extends AbstractC11478a<BlackModuleItem> {
    public C11719a() {
        super(C13216j.m79427l(C13216j.c.TAG, null));
        if (isTableExist("t_backup_black_module")) {
            return;
        }
        try {
            C11839m.m70688i("BackupBlackModulesOperator", "table not exist, create table");
            execSQL("create table if not exists t_backup_black_module(id integer PRIMARY KEY AUTOINCREMENT,appId text not null,type integer not null default 0,flag integer not null default 0,data1 text, data2 text, data3 text);");
        } catch (C9721b e10) {
            C11839m.m70687e("BackupBlackModulesOperator", "create table error: " + e10.getMessage());
        }
    }

    /* renamed from: a */
    public void m69916a(ArrayList<BlackModuleItem> arrayList) throws C9721b {
        C11839m.m70686d("BackupBlackModulesOperator", "batchInsert begin");
        batch("replace into t_backup_black_module(type,flag,appId) values(?, ?, ?)", arrayList);
    }

    @Override // ml.AbstractC11478a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String[] getColumns(BlackModuleItem blackModuleItem) {
        return new String[]{String.valueOf(blackModuleItem.getType()), String.valueOf(blackModuleItem.getFlag()), blackModuleItem.getAppId()};
    }

    @Override // ml.AbstractC11478a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public BlackModuleItem getObject(Cursor cursor) {
        BlackModuleItem blackModuleItem = new BlackModuleItem();
        blackModuleItem.setId(cursor.getInt(0));
        blackModuleItem.setType(cursor.getInt(1));
        blackModuleItem.setFlag(cursor.getInt(2));
        blackModuleItem.setAppId(cursor.getString(3));
        return blackModuleItem;
    }

    public void clear() {
        C11839m.m70686d("BackupBlackModulesOperator", "clear ");
        try {
            execSQL("delete from t_backup_black_module");
            execSQL("update sqlite_sequence set seq=0 where name = 't_backup_black_module'");
        } catch (Exception e10) {
            C11839m.m70687e("BackupBlackModulesOperator", "clear fail:" + e10.toString());
        }
    }

    /* renamed from: d */
    public boolean m69919d() {
        try {
            return queryResult("select count(appId) from t_backup_black_module;", new String[0]) > 0;
        } catch (Exception e10) {
            C11839m.m70687e("BackupBlackModulesOperator", e10.toString());
            return false;
        }
    }

    /* renamed from: e */
    public List<BlackModuleItem> m69920e(String str) {
        try {
            return query("select id,type,flag,appId from t_backup_black_module where appId = ?;", new String[]{str});
        } catch (Exception e10) {
            C11839m.m70687e("BackupBlackModulesOperator", e10.toString());
            return new ArrayList();
        }
    }
}
