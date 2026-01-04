package sc;

import android.database.Cursor;
import com.huawei.android.hicloud.sync.service.aidl.SyncData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p514o9.C11839m;

/* renamed from: sc.d */
/* loaded from: classes3.dex */
public class C12771d extends AbstractC12775h<SyncData> {
    /* renamed from: e */
    public void m76643e(List<String> list, String str) throws Exception {
        C11839m.m70686d("EtagOperator", "batchDelete batDeleteList begin ");
        if (list == null || list.isEmpty()) {
            return;
        }
        C11839m.m70686d("EtagOperator", "batchDelete batDeleteList , request = " + list.size());
        ArrayList<String[]> arrayList = new ArrayList<>();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new String[]{it.next(), str});
        }
        m76677b("DELETE FROM etag WHERE luid = ? and type = ?", arrayList);
    }

    /* renamed from: f */
    public void m76644f(List<SyncData> list, String str) throws Exception {
        C11839m.m70686d("EtagOperator", "batchReplace begin ");
        if (list == null || list.isEmpty()) {
            return;
        }
        C11839m.m70686d("EtagOperator", "batchReplace , request = " + list.size());
        ArrayList<String[]> arrayList = new ArrayList<>();
        Iterator<SyncData> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(m76647i(it.next(), str));
        }
        m76677b("REPLACE INTO etag(luid,type,etag,uuid,guid,hash) VALUES(?,?,?,?,?,?)", arrayList);
    }

    /* renamed from: g */
    public void m76645g(String str) throws Exception {
        C11839m.m70686d("EtagOperator", "deleteAll");
        m76676a("DELETE FROM etag where type = ?", new String[]{str});
    }

    /* renamed from: h */
    public void m76646h() {
        C11839m.m70686d("EtagOperator", "deleteAll ");
        try {
            m76676a("DELETE FROM etag ", null);
        } catch (Exception e10) {
            C11839m.m70687e("EtagOperator", "deleteAll: Exception = " + e10.toString());
        }
    }

    /* renamed from: i */
    public final String[] m76647i(SyncData syncData, String str) {
        String[] strArr = new String[6];
        strArr[0] = syncData.getLuid();
        strArr[1] = str;
        strArr[2] = syncData.getEtag();
        if (syncData.getUuid() == null) {
            strArr[3] = "";
        } else {
            strArr[3] = syncData.getUuid();
        }
        strArr[4] = syncData.getGuid();
        if (syncData.getHash() == null) {
            strArr[5] = "";
        } else {
            strArr[5] = syncData.getHash();
        }
        return strArr;
    }

    @Override // sc.AbstractC12775h
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public SyncData mo76627c(Cursor cursor) {
        SyncData syncData = new SyncData();
        syncData.setLuid(cursor.getString(0));
        syncData.setEtag(cursor.getString(1));
        syncData.setUuid(cursor.getString(2));
        syncData.setGuid(cursor.getString(3));
        syncData.setHash(cursor.getString(4));
        return syncData;
    }

    /* renamed from: k */
    public ArrayList<SyncData> m76649k(List<String> list, String str) {
        ArrayList<SyncData> arrayList = new ArrayList<>();
        C11839m.m70686d("EtagOperator", "query4Guid begin");
        if (list != null && !list.isEmpty()) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                arrayList.addAll(m76678d("SELECT luid,etag,uuid,guid,hash FROM  etag where luid = ? and type = ? ", new String[]{list.get(i10), str}));
            }
        }
        return arrayList;
    }

    /* renamed from: l */
    public ArrayList<SyncData> m76650l(String str) {
        C11839m.m70686d("EtagOperator", "query4Vo");
        return m76678d("SELECT luid,etag,uuid,guid,hash FROM  etag where type = ?", new String[]{str});
    }
}
