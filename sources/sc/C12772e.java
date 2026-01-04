package sc;

import android.database.Cursor;
import com.huawei.android.hicloud.sync.bean.FileInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p015ak.C0213f;
import p514o9.C11839m;
import p783xp.C13843a;

/* renamed from: sc.e */
/* loaded from: classes3.dex */
public class C12772e extends AbstractC12775h<FileInfo> {
    /* renamed from: e */
    public void m76651e(String str, String str2, String str3, List<FileInfo> list) {
        C11839m.m70686d("FileInfoOperator", "batchReplace: syncType = " + str + ", dataType = " + str2 + ", fileType = " + str3);
        if (list == null || list.isEmpty()) {
            C11839m.m70689w("FileInfoOperator", "batchReplace: fileInfos.size = 0");
            return;
        }
        C11839m.m70688i("FileInfoOperator", "batchReplace , request = " + list.size());
        ArrayList<String[]> arrayList = new ArrayList<>();
        String strM83089k = C13843a.m83089k(C0213f.m1377a(), System.currentTimeMillis());
        Iterator<FileInfo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(m76661o(str, str2, str3, strM83089k, it.next()));
        }
        try {
            m76677b("REPLACE INTO file_info(service, type, luid, uuid, name, file_type, create_time) VALUES(?,?,?,?,?,?,?)", arrayList);
        } catch (Exception e10) {
            C11839m.m70687e("FileInfoOperator", "batchReplace: Exception = " + e10.toString());
        }
    }

    /* renamed from: f */
    public void m76652f(String str, String str2, List<FileInfo> list) {
        m76651e(str, str2, "2", list);
    }

    /* renamed from: g */
    public void m76653g(String str, String str2, List<FileInfo> list) {
        m76651e(str, str2, "1", list);
    }

    /* renamed from: h */
    public final void m76654h(String str, String[] strArr) {
        C11839m.m70688i("FileInfoOperator", "delete: selection = " + str);
        try {
            m76676a(str, strArr);
        } catch (Exception e10) {
            C11839m.m70687e("FileInfoOperator", "delete: Exception = " + e10.toString());
        }
    }

    /* renamed from: i */
    public void m76655i() {
        C11839m.m70688i("FileInfoOperator", "deleteAll ");
        try {
            m76676a("DELETE FROM file_info ", null);
        } catch (Exception e10) {
            C11839m.m70687e("FileInfoOperator", "deleteAll: Exception = " + e10.toString());
        }
    }

    /* renamed from: j */
    public void m76656j(String str, String str2, List<FileInfo> list) {
        C11839m.m70688i("FileInfoOperator", "deleteCloudFileByName: syncType = " + str);
        m76657k(str, str2, "2", list);
    }

    /* renamed from: k */
    public final void m76657k(String str, String str2, String str3, List<FileInfo> list) {
        String str4;
        C11839m.m70688i("FileInfoOperator", "deleteFile: dataType = " + str2);
        if (list == null || list.size() < 1) {
            C11839m.m70689w("FileInfoOperator", "deleteFile: fileInfos.size = 0");
            return;
        }
        C11839m.m70686d("FileInfoOperator", "deleteFile: fileInfos.size = " + list.size());
        ArrayList<String[]> arrayList = new ArrayList<>();
        if ("1".equals(str3)) {
            str4 = "DELETE FROM file_info WHERE service = ? and file_type = ? and type = ? and luid = ?";
            Iterator<FileInfo> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new String[]{str, str3, str2, it.next().getLuid()});
            }
        } else if (str2 == null || str2.isEmpty()) {
            str4 = "DELETE FROM file_info WHERE service = ? and file_type = ? and name = ?";
            Iterator<FileInfo> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList.add(new String[]{str, str3, it2.next().getName()});
            }
        } else {
            str4 = "DELETE FROM file_info WHERE service = ? and file_type = ? and type = ? and name = ?";
            Iterator<FileInfo> it3 = list.iterator();
            while (it3.hasNext()) {
                arrayList.add(new String[]{str, str3, str2, it3.next().getName()});
            }
        }
        try {
            m76677b(str4, arrayList);
        } catch (Exception e10) {
            C11839m.m70687e("FileInfoOperator", "deleteFile: Exception = " + e10.toString());
        }
    }

    /* renamed from: l */
    public void m76658l(String str) {
        C11839m.m70688i("FileInfoOperator", "deleteFileByService: syncType = " + str);
        m76654h("DELETE FROM file_info WHERE service = ?", new String[]{str});
    }

    /* renamed from: m */
    public void m76659m(String str, String str2, List<FileInfo> list) {
        C11839m.m70688i("FileInfoOperator", "deleteLocalFileById: syncType = " + str + ", dataType = " + str2);
        m76657k(str, str2, "1", list);
    }

    /* renamed from: n */
    public void m76660n(String str) {
        C11839m.m70688i("FileInfoOperator", "deleteLocalFileByService: syncType = " + str);
        m76654h("DELETE FROM file_info WHERE service = ? and file_type = ?", new String[]{str, "1"});
    }

    /* renamed from: o */
    public final String[] m76661o(String str, String str2, String str3, String str4, FileInfo fileInfo) {
        return new String[]{str, str2, fileInfo.getLuid(), fileInfo.getUuid(), fileInfo.getName(), str3, str4};
    }

    @Override // sc.AbstractC12775h
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public FileInfo mo76627c(Cursor cursor) {
        FileInfo fileInfo = new FileInfo();
        fileInfo.setService(cursor.getString(0));
        fileInfo.setType(cursor.getString(1));
        fileInfo.setLuid(cursor.getString(2));
        fileInfo.setUuid(cursor.getString(3));
        fileInfo.setName(cursor.getString(4));
        fileInfo.setFileType(cursor.getString(5));
        fileInfo.setCreateTime(cursor.getString(6));
        return fileInfo;
    }
}
