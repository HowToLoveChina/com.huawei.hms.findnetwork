package gb;

import android.database.Cursor;
import android.database.SQLException;
import com.huawei.hicloud.router.data.FamilyShareLanguageString;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p016an.AbstractC0315c;
import p514o9.C11839m;

/* renamed from: gb.a */
/* loaded from: classes3.dex */
public class C9902a extends AbstractC0315c<FamilyShareLanguageString> {
    /* renamed from: a */
    public final String[] m61480a(FamilyShareLanguageString familyShareLanguageString) {
        return new String[]{familyShareLanguageString.getLanguage(), familyShareLanguageString.getName(), familyShareLanguageString.getValue()};
    }

    @Override // p016an.AbstractC0315c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FamilyShareLanguageString getVo(Cursor cursor) {
        FamilyShareLanguageString familyShareLanguageString = new FamilyShareLanguageString();
        familyShareLanguageString.setValue(cursor.getString(0));
        return familyShareLanguageString;
    }

    public void batchInsert(ArrayList<FamilyShareLanguageString> arrayList) {
        try {
            ArrayList arrayList2 = new ArrayList();
            Iterator<FamilyShareLanguageString> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(m61480a(it.next()));
            }
            execSQL4Batch("insert into cloud_space_usage_language values(?, ?, ?)", arrayList2);
        } catch (C9721b e10) {
            C11839m.m70689w("CloudSpaceUsageLanguageOperator", "batchInsert error." + e10.getMessage());
        }
    }

    /* renamed from: c */
    public FamilyShareLanguageString m61482c(String str, String str2) throws Throwable {
        List<FamilyShareLanguageString> listQueryResult4Vo;
        try {
            listQueryResult4Vo = queryResult4Vo("select value from cloud_space_usage_language where language=? and name=?", new String[]{str, str2});
        } catch (C9721b e10) {
            C11839m.m70689w("CloudSpaceUsageLanguageOperator", "queryLanguageValue error." + e10.getMessage());
            listQueryResult4Vo = null;
        }
        if (listQueryResult4Vo != null && listQueryResult4Vo.size() > 0) {
            return listQueryResult4Vo.get(0);
        }
        C11839m.m70689w("CloudSpaceUsageLanguageOperator", "queryLanguageValue result is null.");
        return null;
    }

    public void clearDB() throws SQLException {
        C11839m.m70688i("CloudSpaceUsageLanguageOperator", "clearDB");
        try {
            execSQL("delete from cloud_space_usage_language");
        } catch (C9721b e10) {
            C11839m.m70689w("CloudSpaceUsageLanguageOperator", "clearDB error." + e10.getMessage());
        }
    }

    /* renamed from: d */
    public FamilyShareLanguageString m61483d(String str, String str2) throws Throwable {
        List<FamilyShareLanguageString> listQueryResult4Vo;
        try {
            listQueryResult4Vo = queryResult4Vo("select value from cloud_space_usage_language where language like ? and name=?", new String[]{str + "%", str2});
        } catch (C9721b e10) {
            C11839m.m70689w("CloudSpaceUsageLanguageOperator", "queryLanguageValueByLanguage error." + e10.getMessage());
            listQueryResult4Vo = null;
        }
        if (listQueryResult4Vo != null && listQueryResult4Vo.size() > 0) {
            return listQueryResult4Vo.get(0);
        }
        C11839m.m70689w("CloudSpaceUsageLanguageOperator", "queryLanguageValueByLanguage result is null.");
        return null;
    }

    public boolean hasRecord() {
        try {
            return queryCount("select count(*) from cloud_space_usage_language;") > 0;
        } catch (C9721b e10) {
            C11839m.m70687e("CloudSpaceUsageLanguageOperator", "hasRecord exception:" + e10.toString());
            return false;
        }
    }
}
