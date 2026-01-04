package p526ol;

import android.database.Cursor;
import com.huawei.android.hicloud.cloudbackup.bean.BackupAppLanguageDbString;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import ml.AbstractC11478a;
import p514o9.C11839m;
import p682ul.C13216j;

/* renamed from: ol.a */
/* loaded from: classes6.dex */
public class C11960a extends AbstractC11478a<BackupAppLanguageDbString> {
    public C11960a() {
        super(C13216j.m79427l(C13216j.c.LANGUAGE, null));
    }

    /* renamed from: a */
    public void m71936a(ArrayList<BackupAppLanguageDbString> arrayList) throws C9721b {
        C11839m.m70686d("BackupAppLanguageOperator", "batchInsert begin");
        batch("insert into backup_app_language values(?, ?, ?)", arrayList);
    }

    @Override // ml.AbstractC11478a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String[] getColumns(BackupAppLanguageDbString backupAppLanguageDbString) {
        return new String[]{backupAppLanguageDbString.getLanguageName(), backupAppLanguageDbString.getTextName(), backupAppLanguageDbString.getTextValue()};
    }

    @Override // ml.AbstractC11478a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public BackupAppLanguageDbString getObject(Cursor cursor) {
        BackupAppLanguageDbString backupAppLanguageDbString = new BackupAppLanguageDbString();
        backupAppLanguageDbString.setLanguageName(cursor.getString(0));
        backupAppLanguageDbString.setTextName(cursor.getString(1));
        backupAppLanguageDbString.setTextValue(cursor.getString(2));
        return backupAppLanguageDbString;
    }

    public void clear() {
        C11839m.m70686d("BackupAppLanguageOperator", "clear ");
        try {
            execSQL("delete from backup_app_language ");
        } catch (Exception e10) {
            C11839m.m70687e("BackupAppLanguageOperator", "clear fail:" + e10.toString());
        }
    }

    /* renamed from: d */
    public List<BackupAppLanguageDbString> m71939d(String str, String str2, String str3, String str4) {
        try {
            C11839m.m70686d("BackupAppLanguageOperator", "queryString");
            return query("select languageName,textName,textValue from backup_app_language where (languageName=? or languageName like ? or languageName=?) and textName=?;", new String[]{str, str2 + '%', str3, str4});
        } catch (Exception e10) {
            C11839m.m70687e("BackupAppLanguageOperator", e10.toString());
            return new ArrayList();
        }
    }
}
