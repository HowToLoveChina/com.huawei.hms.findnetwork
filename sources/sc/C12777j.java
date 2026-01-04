package sc;

import android.database.Cursor;
import com.huawei.android.hicloud.sync.wifi.datamanager.SyncWlanBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p514o9.C11839m;

/* renamed from: sc.j */
/* loaded from: classes3.dex */
public class C12777j extends AbstractC12775h<SyncWlanBean> {
    /* renamed from: e */
    public void m76685e(List<String> list, String str) throws Exception {
        C11839m.m70686d("WlanSyncOperator", "batchDelete batchDeleteList begin ");
        if (list == null || list.isEmpty()) {
            return;
        }
        C11839m.m70686d("WlanSyncOperator", "batchDelete batchDeleteList, request = " + list.size());
        ArrayList<String[]> arrayList = new ArrayList<>();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new String[]{it.next(), str});
        }
        m76677b("DELETE FROM etag WHERE luid = ? and type = ?", arrayList);
    }

    /* renamed from: f */
    public void m76686f(List<SyncWlanBean> list, String str) throws Exception {
        C11839m.m70686d("WlanSyncOperator", "batchReplace begin ");
        if (list == null || list.isEmpty()) {
            return;
        }
        C11839m.m70686d("WlanSyncOperator", "batchReplace , request = " + list.size());
        ArrayList<String[]> arrayList = new ArrayList<>();
        Iterator<SyncWlanBean> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(m76688h(it.next(), str));
        }
        m76677b("REPLACE INTO etag(luid,type,etag,uuid,guid,hash) VALUES(?,?,?,?,?,?)", arrayList);
    }

    /* renamed from: g */
    public void m76687g(String str) {
        C11839m.m70686d("WlanSyncOperator", "deleteAll");
        try {
            m76676a("DELETE FROM etag where type = ?", new String[]{str});
        } catch (Exception e10) {
            C11839m.m70687e("WlanSyncOperator", "deleteAll: Exception = " + e10.toString());
        }
    }

    /* renamed from: h */
    public final String[] m76688h(SyncWlanBean syncWlanBean, String str) {
        String[] strArr = new String[6];
        strArr[0] = syncWlanBean.getLuid();
        strArr[1] = str;
        strArr[2] = syncWlanBean.getEtag();
        if (syncWlanBean.getUuid() == null) {
            strArr[3] = "";
        } else {
            strArr[3] = syncWlanBean.getUuid();
        }
        strArr[4] = syncWlanBean.getGuid();
        strArr[5] = syncWlanBean.getHash();
        return strArr;
    }

    @Override // sc.AbstractC12775h
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public SyncWlanBean mo76627c(Cursor cursor) {
        SyncWlanBean syncWlanBean = new SyncWlanBean();
        syncWlanBean.setLuid(cursor.getString(0));
        syncWlanBean.setEtag(cursor.getString(1));
        syncWlanBean.setUuid(cursor.getString(2));
        syncWlanBean.setGuid(cursor.getString(3));
        syncWlanBean.setHash(cursor.getString(4));
        return syncWlanBean;
    }

    /* renamed from: j */
    public ArrayList<SyncWlanBean> m76690j(String str) {
        C11839m.m70686d("WlanSyncOperator", "query4Vo");
        return m76678d("SELECT luid,etag,uuid,guid,hash FROM  etag where type = ?", new String[]{str});
    }
}
