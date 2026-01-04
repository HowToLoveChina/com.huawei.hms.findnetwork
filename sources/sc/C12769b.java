package sc;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import p514o9.C11839m;
import p517oc.C11847b;

/* renamed from: sc.b */
/* loaded from: classes3.dex */
public class C12769b extends AbstractC12775h<C11847b> {
    /* renamed from: e */
    public void m76628e(List<String> list, String str) throws Exception {
        C11839m.m70686d("ContactSyncOperator", "batchDelete begin ");
        if (list == null || list.isEmpty()) {
            return;
        }
        C11839m.m70686d("ContactSyncOperator", "batchDelete , request = " + list.size());
        ArrayList<String[]> arrayList = new ArrayList<>();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new String[]{it.next(), str});
        }
        m76677b("DELETE FROM etag WHERE luid = ? and type = ?", arrayList);
    }

    /* renamed from: f */
    public void m76629f(List<C11847b> list, String str) throws Exception {
        C11839m.m70686d("ContactSyncOperator", "batchReplace begin ");
        if (list == null || list.isEmpty()) {
            return;
        }
        C11839m.m70686d("ContactSyncOperator", "batchReplace , request = " + list.size());
        ArrayList<String[]> arrayList = new ArrayList<>();
        for (C11847b c11847b : list) {
            if (c11847b.getUuid() == null) {
                c11847b.setUuid(c11847b.m70940a().m17418L0());
            }
            arrayList.add(m76631h(c11847b, str));
        }
        m76677b("REPLACE INTO etag(luid,type,etag,uuid,guid,hash) VALUES(?,?,?,?,?,?)", arrayList);
    }

    /* renamed from: g */
    public void m76630g(String str) throws Exception {
        C11839m.m70686d("ContactSyncOperator", "deleteAll");
        m76676a("DELETE FROM etag where type = ?", new String[]{str});
    }

    /* renamed from: h */
    public final String[] m76631h(C11847b c11847b, String str) {
        String[] strArr = new String[6];
        strArr[0] = c11847b.getLuid();
        strArr[1] = str;
        strArr[2] = c11847b.getEtag();
        String uuid = c11847b.getUuid();
        if (uuid == null) {
            uuid = "";
        }
        strArr[3] = uuid;
        strArr[4] = c11847b.getGuid();
        if (c11847b.getHash() == null) {
            strArr[5] = "";
        } else {
            strArr[5] = c11847b.getHash();
        }
        return strArr;
    }

    @Override // sc.AbstractC12775h
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C11847b mo76627c(Cursor cursor) {
        C11847b c11847b = new C11847b();
        c11847b.setLuid(cursor.getString(0));
        c11847b.setEtag(cursor.getString(1));
        c11847b.setUuid(cursor.getString(2));
        c11847b.setGuid(cursor.getString(3));
        c11847b.setHash(cursor.getString(4));
        return c11847b;
    }

    /* renamed from: j */
    public ArrayList<C11847b> m76633j(List<String> list, String str) {
        ArrayList<C11847b> arrayList = new ArrayList<>();
        C11839m.m70686d("ContactSyncOperator", "query4Guid begin");
        if (list != null && !list.isEmpty()) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                arrayList.addAll(m76678d("SELECT luid,etag,uuid,guid,hash FROM  etag where luid = ? and type = ? ", new String[]{list.get(i10), str}));
            }
        }
        return arrayList;
    }

    /* renamed from: k */
    public ArrayList<C11847b> m76634k(Set<String> set, String str) {
        ArrayList<C11847b> arrayList = new ArrayList<>();
        C11839m.m70686d("ContactSyncOperator", "query4Guid begin");
        if (set != null && !set.isEmpty()) {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                arrayList.addAll(m76678d("SELECT luid,etag,uuid,guid,hash FROM  etag where uuid = ? and type = ?", new String[]{it.next(), str}));
            }
        }
        return arrayList;
    }

    /* renamed from: l */
    public ArrayList<C11847b> m76635l(String str) {
        C11839m.m70686d("ContactSyncOperator", "query4Vo");
        return m76678d("SELECT luid,etag,uuid,guid,hash FROM  etag where type = ?", new String[]{str});
    }

    /* renamed from: m */
    public ArrayList<C11847b> m76636m(Set<String> set, String str) {
        ArrayList<C11847b> arrayList = new ArrayList<>();
        C11839m.m70686d("ContactSyncOperator", "queryUuidByGuid begin");
        if (set != null && !set.isEmpty()) {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                arrayList.addAll(m76678d("SELECT luid,etag,uuid,guid,hash FROM  etag where guid = ? and type = ?", new String[]{it.next(), str}));
            }
        }
        return arrayList;
    }
}
