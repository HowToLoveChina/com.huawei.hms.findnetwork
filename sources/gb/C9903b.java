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

/* renamed from: gb.b */
/* loaded from: classes3.dex */
public class C9903b extends AbstractC0315c<FamilyShareLanguageString> {
    /* renamed from: a */
    private String[] m61484a(FamilyShareLanguageString familyShareLanguageString) {
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
                arrayList2.add(m61484a(it.next()));
            }
            execSQL4Batch("insert into family_share_language values(?, ?, ?)", arrayList2);
        } catch (C9721b e10) {
            C11839m.m70689w("FamilyShareLanguageOperator", "batchInsert error." + e10.getMessage());
        }
    }

    /* renamed from: c */
    public FamilyShareLanguageString m61486c(String str, String str2) throws Throwable {
        List<FamilyShareLanguageString> listQueryResult4Vo;
        try {
            listQueryResult4Vo = queryResult4Vo("select value from family_share_language where language=? and name=?", new String[]{str, str2});
        } catch (C9721b e10) {
            C11839m.m70689w("FamilyShareLanguageOperator", "queryLanguageValue error." + e10.getMessage());
            listQueryResult4Vo = null;
        }
        if (listQueryResult4Vo != null && listQueryResult4Vo.size() > 0) {
            return listQueryResult4Vo.get(0);
        }
        C11839m.m70689w("FamilyShareLanguageOperator", "queryLanguageValue result is null.");
        return null;
    }

    public void clearDB() throws SQLException {
        C11839m.m70688i("FamilyShareLanguageOperator", "clearDB");
        try {
            execSQL("delete from family_share_language");
        } catch (C9721b e10) {
            C11839m.m70689w("FamilyShareLanguageOperator", "clearDB error." + e10.getMessage());
        }
    }

    /* renamed from: d */
    public FamilyShareLanguageString m61487d(String str, String str2) throws Throwable {
        List<FamilyShareLanguageString> listQueryResult4Vo;
        try {
            listQueryResult4Vo = queryResult4Vo("select value from family_share_language where language like ? and name=?", new String[]{str + "%", str2});
        } catch (C9721b e10) {
            C11839m.m70689w("FamilyShareLanguageOperator", "queryLanguageValueByLanguage error." + e10.getMessage());
            listQueryResult4Vo = null;
        }
        if (listQueryResult4Vo != null && listQueryResult4Vo.size() > 0) {
            return listQueryResult4Vo.get(0);
        }
        C11839m.m70689w("FamilyShareLanguageOperator", "queryLanguageValueByLanguage result is null.");
        return null;
    }

    public boolean hasRecord() {
        try {
            return queryCount("select count(*) from family_share_language;") > 0;
        } catch (C9721b e10) {
            C11839m.m70687e("FamilyShareLanguageOperator", "hasRecord exception:" + e10.toString());
            return false;
        }
    }
}
