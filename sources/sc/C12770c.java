package sc;

import android.database.Cursor;
import com.huawei.android.hicloud.sync.service.aidl.CtagInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p514o9.C11839m;

/* renamed from: sc.c */
/* loaded from: classes3.dex */
public class C12770c extends AbstractC12775h<CtagInfo> {
    /* renamed from: e */
    public void m76637e(String str) throws Exception {
        if (str == null) {
            return;
        }
        C11839m.m70686d("CtagOperator", "delete , request = " + str);
        ArrayList<String[]> arrayList = new ArrayList<>();
        arrayList.add(new String[]{str});
        m76677b("DELETE FROM ctag WHERE ctag_name = ? ", arrayList);
    }

    /* renamed from: f */
    public void m76638f() {
        C11839m.m70686d("CtagOperator", "deleteAll ");
        try {
            m76676a("DELETE FROM ctag ", null);
        } catch (Exception e10) {
            C11839m.m70687e("CtagOperator", "deleteAll: Exception = " + e10.toString());
        }
    }

    /* renamed from: g */
    public final String[] m76639g(CtagInfo ctagInfo) {
        return new String[]{ctagInfo.getCtagName(), ctagInfo.getCtagValue()};
    }

    @Override // sc.AbstractC12775h
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public CtagInfo mo76627c(Cursor cursor) {
        CtagInfo ctagInfo = new CtagInfo();
        ctagInfo.setCtagName(cursor.getString(0));
        ctagInfo.setCtagValue(cursor.getString(1));
        return ctagInfo;
    }

    /* renamed from: i */
    public ArrayList<CtagInfo> m76641i(String[] strArr) {
        return m76678d("SELECT ctag_name,ctag_value FROM  ctag WHERE ctag_name = ? ", strArr);
    }

    /* renamed from: j */
    public void m76642j(List<CtagInfo> list) throws Exception {
        C11839m.m70686d("CtagOperator", "replaceData begin");
        if (list == null || list.isEmpty()) {
            return;
        }
        C11839m.m70686d("CtagOperator", "replaceData , request = " + list.toString());
        ArrayList<String[]> arrayList = new ArrayList<>();
        Iterator<CtagInfo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(m76639g(it.next()));
        }
        m76677b("REPLACE INTO ctag(ctag_name,ctag_value) VALUES(?,?)", arrayList);
    }
}
