package sc;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p514o9.C11839m;
import p517oc.C11848c;

/* renamed from: sc.g */
/* loaded from: classes3.dex */
public class C12774g extends AbstractC12775h<C11848c> {
    /* renamed from: e */
    public void m76670e(List<String> list, String str) {
        C11839m.m70686d("GroupSyncOperator", "batchDelete baDeleteList begin ");
        if (list == null || list.isEmpty()) {
            return;
        }
        C11839m.m70686d("GroupSyncOperator", "batchDelete baDeleteList , request = " + list.size());
        ArrayList<String[]> arrayList = new ArrayList<>();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new String[]{it.next(), str});
        }
        try {
            m76677b("DELETE FROM etag WHERE luid = ? and type = ?", arrayList);
        } catch (Exception e10) {
            C11839m.m70687e("GroupSyncOperator", "batchDelete: Exception = " + e10.toString());
        }
    }

    /* renamed from: f */
    public void m76671f(List<C11848c> list, String str) {
        C11839m.m70686d("GroupSyncOperator", "batchReplace begin ");
        if (list == null || list.isEmpty()) {
            return;
        }
        C11839m.m70686d("GroupSyncOperator", "batchReplace , request = " + list.size());
        ArrayList<String[]> arrayList = new ArrayList<>();
        for (C11848c c11848c : list) {
            if (c11848c.getUuid() == null) {
                c11848c.setUuid(c11848c.m70942a().m17671d());
            }
            arrayList.add(m76673h(c11848c, str));
        }
        try {
            m76677b("REPLACE INTO etag(luid,type,etag,uuid,guid,hash) VALUES(?,?,?,?,?,?)", arrayList);
        } catch (Exception e10) {
            C11839m.m70687e("GroupSyncOperator", "batchReplace: Exception = " + e10.toString());
        }
    }

    /* renamed from: g */
    public void m76672g(String str) throws Exception {
        C11839m.m70686d("GroupSyncOperator", "deleteAll");
        m76676a("DELETE FROM etag where type = ?", new String[]{str});
    }

    /* renamed from: h */
    public final String[] m76673h(C11848c c11848c, String str) {
        String[] strArr = new String[6];
        strArr[0] = c11848c.getLuid();
        strArr[1] = str;
        strArr[2] = c11848c.getEtag();
        String uuid = c11848c.getUuid();
        if (uuid == null) {
            uuid = "";
        }
        strArr[3] = uuid;
        strArr[4] = c11848c.getGuid();
        strArr[5] = c11848c.getHash();
        return strArr;
    }

    @Override // sc.AbstractC12775h
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C11848c mo76627c(Cursor cursor) {
        C11848c c11848c = new C11848c();
        c11848c.setLuid(cursor.getString(0));
        c11848c.setEtag(cursor.getString(1));
        c11848c.setUuid(cursor.getString(2));
        c11848c.setGuid(cursor.getString(3));
        c11848c.setHash(cursor.getString(4));
        return c11848c;
    }

    /* renamed from: j */
    public ArrayList<C11848c> m76675j(String str) {
        C11839m.m70686d("GroupSyncOperator", "query4Vo");
        return m76678d("SELECT luid,etag,uuid,guid,hash FROM  etag where type = ?", new String[]{str});
    }
}
