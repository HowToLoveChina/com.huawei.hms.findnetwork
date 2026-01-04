package sc;

import android.database.Cursor;
import com.huawei.android.hicloud.sync.bean.StatusInfo;
import java.util.ArrayList;
import java.util.Iterator;
import p514o9.C11839m;

/* renamed from: sc.i */
/* loaded from: classes3.dex */
public class C12776i extends AbstractC12775h<StatusInfo> {
    /* renamed from: e */
    public void m76679e(String str) throws Exception {
        if (str == null) {
            return;
        }
        C11839m.m70686d("StatusInfoOperator", "delete , request = " + str);
        ArrayList<String[]> arrayList = new ArrayList<>();
        arrayList.add(new String[]{str});
        m76677b("DELETE FROM status_info WHERE key = ? ", arrayList);
    }

    /* renamed from: f */
    public void m76680f() {
        try {
            m76676a("DELETE FROM status_info ", null);
        } catch (Exception e10) {
            C11839m.m70687e("StatusInfoOperator", "deleteAll exception: " + e10.toString());
        }
    }

    /* renamed from: g */
    public final String[] m76681g(StatusInfo statusInfo) {
        return new String[]{statusInfo.getKey(), statusInfo.getValue(), statusInfo.getTime()};
    }

    @Override // sc.AbstractC12775h
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public StatusInfo mo76627c(Cursor cursor) {
        StatusInfo statusInfo = new StatusInfo();
        statusInfo.setKey(cursor.getString(0));
        statusInfo.setValue(cursor.getString(1));
        statusInfo.setTime(cursor.getString(2));
        return statusInfo;
    }

    /* renamed from: i */
    public StatusInfo m76683i(String str) {
        ArrayList<StatusInfo> arrayListM76678d = m76678d("SELECT key,value,time FROM status_info WHERE key = ? ", new String[]{str});
        if (arrayListM76678d == null || arrayListM76678d.size() <= 0) {
            return null;
        }
        return arrayListM76678d.get(0);
    }

    /* renamed from: j */
    public void m76684j(StatusInfo statusInfo) throws Exception {
        C11839m.m70686d("StatusInfoOperator", "replaceData begin");
        if (statusInfo == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(statusInfo);
        C11839m.m70686d("StatusInfoOperator", "replaceData , request = " + arrayList.toString());
        ArrayList<String[]> arrayList2 = new ArrayList<>();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(m76681g((StatusInfo) it.next()));
        }
        m76677b("REPLACE INTO status_info(key,value,time) VALUES(?,?,?)", arrayList2);
    }
}
