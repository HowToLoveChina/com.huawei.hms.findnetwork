package sc;

import android.database.Cursor;
import com.huawei.android.hicloud.sync.service.aidl.UnstructData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p514o9.C11839m;

/* renamed from: sc.f */
/* loaded from: classes3.dex */
public class C12773f extends AbstractC12775h<UnstructData> {
    /* renamed from: e */
    public void m76663e(List<String> list, String str) throws Exception {
        if (list == null || list.isEmpty()) {
            return;
        }
        C11839m.m70686d("FileOperator", "batchDelete , request = " + list.toString());
        ArrayList<String[]> arrayList = new ArrayList<>();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new String[]{it.next(), str});
        }
        m76677b("DELETE FROM file WHERE itemid = ? and type = ?", arrayList);
    }

    /* renamed from: f */
    public void m76664f(List<UnstructData> list, String str) throws Exception {
        if (list == null || list.isEmpty()) {
            return;
        }
        C11839m.m70686d("FileOperator", "batchDelete , request = " + list.toString());
        ArrayList<String[]> arrayList = new ArrayList<>();
        for (UnstructData unstructData : list) {
            arrayList.add(new String[]{unstructData.getId(), str, unstructData.getName()});
        }
        m76677b("DELETE FROM file WHERE itemid = ? and type = ? and name = ?", arrayList);
    }

    /* renamed from: g */
    public void m76665g(String str) throws Exception {
        C11839m.m70686d("FileOperator", "deleteAll");
        m76676a("DELETE FROM file where type = ?", new String[]{str});
    }

    /* renamed from: h */
    public void m76666h() {
        C11839m.m70686d("FileOperator", "deleteAll ");
        try {
            m76676a("DELETE FROM file ", null);
        } catch (Exception e10) {
            C11839m.m70687e("FileOperator", "deleteAll: Exception = " + e10.toString());
        }
    }

    /* renamed from: i */
    public final String[] m76667i(UnstructData unstructData, String str) {
        return new String[]{unstructData.getId(), str, unstructData.getHash(), unstructData.getName()};
    }

    @Override // sc.AbstractC12775h
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public UnstructData mo76627c(Cursor cursor) {
        UnstructData unstructData = new UnstructData();
        unstructData.setId(cursor.getString(0));
        unstructData.setHash(cursor.getString(2));
        unstructData.setName(cursor.getString(3));
        return unstructData;
    }

    /* renamed from: k */
    public void m76669k(List<UnstructData> list, String str) {
        try {
            C11839m.m70686d("FileOperator", "replaceData begin");
            if (list != null && !list.isEmpty()) {
                C11839m.m70686d("FileOperator", "replaceData , request = " + list.toString());
                ArrayList<String[]> arrayList = new ArrayList<>();
                for (UnstructData unstructData : list) {
                    if (unstructData != null) {
                        arrayList.add(m76667i(unstructData, str));
                    }
                }
                m76677b("REPLACE INTO file(itemid,type,hash,name) VALUES(?,?,?,?)", arrayList);
            }
        } catch (Exception e10) {
            C11839m.m70687e("FileOperator", "replaceData , type = " + str + " exception occour = " + e10.toString());
        }
    }
}
