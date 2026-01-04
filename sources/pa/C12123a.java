package pa;

import android.database.Cursor;
import com.huawei.android.hicloud.drive.clouddisk.model.FileModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import p015ak.C0241z;
import p514o9.C11839m;

/* renamed from: pa.a */
/* loaded from: classes3.dex */
public class C12123a extends AbstractC12124b<FileModel> {
    /* renamed from: e */
    public void m72689e(ArrayList<FileModel> arrayList, int i10) throws Exception {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList<String[]> arrayList2 = new ArrayList<>();
        Iterator<FileModel> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new String[]{String.valueOf(it.next().getFileId())});
        }
        if (i10 == 1) {
            m72702b("DELETE FROM diskDuplicateFile WHERE fileId = ?", arrayList2);
        } else {
            m72702b("DELETE FROM diskBigFile WHERE fileId = ?", arrayList2);
        }
    }

    /* renamed from: f */
    public void m72690f() {
        C11839m.m70686d("CloudDiskDbOperator", "clear DiskBigFile db");
        try {
            m72701a("DELETE FROM diskBigFile", null);
        } catch (Exception e10) {
            C11839m.m70687e("CloudDiskDbOperator", "clear DiskBigFile db fail:" + e10.toString());
        }
    }

    /* renamed from: g */
    public void m72691g() {
        C11839m.m70686d("CloudDiskDbOperator", "clear DiskDuplicateFile db");
        try {
            m72701a("DELETE FROM diskDuplicateFile", null);
        } catch (Exception e10) {
            C11839m.m70687e("CloudDiskDbOperator", "clear DiskDuplicateFile db fail:" + e10.toString());
        }
    }

    /* renamed from: h */
    public ArrayList<FileModel> m72692h(String str, String[] strArr) {
        return m72703d(str, strArr);
    }

    /* renamed from: i */
    public void m72693i(String str) {
        C11839m.m70686d("CloudDiskDbOperator", "executeSql");
        try {
            m72701a(str, null);
        } catch (Exception e10) {
            C11839m.m70687e("CloudDiskDbOperator", "executeSql: Exception = " + e10.toString());
        }
    }

    /* renamed from: j */
    public void m72694j(String str, String[] strArr) {
        C11839m.m70686d("CloudDiskDbOperator", "executeSql");
        try {
            m72701a(str, strArr);
        } catch (Exception e10) {
            C11839m.m70687e("CloudDiskDbOperator", "executeSql: Exception = " + e10.toString());
        }
    }

    /* renamed from: k */
    public final String[] m72695k(FileModel fileModel) {
        return new String[]{fileModel.getFileId(), fileModel.getFileName(), fileModel.getFileSize() + "", fileModel.getFileMD5(), fileModel.getModifyTime(), fileModel.getFileParent(), fileModel.getFileCategory() + "", fileModel.getIsCloudExist(), fileModel.getFileParentName(), fileModel.getThumbnailPath()};
    }

    @Override // pa.AbstractC12124b
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public FileModel mo72688c(Cursor cursor) {
        FileModel fileModel = new FileModel();
        fileModel.setFileId(cursor.getString(0));
        fileModel.setFileName(cursor.getString(1));
        fileModel.setFileSize(C0241z.m1688f(cursor.getString(2)));
        fileModel.setFileMD5(cursor.getString(3));
        fileModel.setModifyTime(cursor.getString(4));
        fileModel.setFileParent(cursor.getString(5));
        fileModel.setFileCategory(C0241z.m1685c(cursor.getString(6)));
        fileModel.setThumbnailPath(cursor.getString(7));
        fileModel.setFileParentName(cursor.getString(8));
        return fileModel;
    }

    /* renamed from: m */
    public HashMap<String, FileModel> m72697m(int i10) {
        HashMap<String, FileModel> map = new HashMap<>();
        Iterator<FileModel> it = (i10 == 1 ? m72692h("SELECT fileId, fileName, fileSize, fileMd5, modifyTime, fileParent, fileCategory, thumbnailPath, fileParentName FROM  diskDuplicateFile order by CAST(fileSize AS LONG) desc,modifyTime desc", null) : m72692h("SELECT fileId, fileName, fileSize, fileMd5, modifyTime, fileParent, fileCategory, thumbnailPath, fileParentName FROM  diskBigFile order by CAST(fileSize AS LONG) desc,modifyTime desc", null)).iterator();
        while (it.hasNext()) {
            FileModel next = it.next();
            map.put(next.getFileId(), next);
        }
        return map;
    }

    /* renamed from: n */
    public String m72698n(int i10, String str) {
        FileModel fileModel;
        String[] strArr = {str};
        ArrayList<FileModel> arrayListM72703d = i10 == 1 ? m72703d("SELECT fileId, fileName, fileSize, fileMd5, modifyTime, fileParent, fileCategory, thumbnailPath, fileParentName FROM diskDuplicateFile where fileId = ?", strArr) : m72703d("SELECT fileId, fileName, fileSize, fileMd5, modifyTime, fileParent, fileCategory, thumbnailPath, fileParentName FROM diskBigFile where fileId = ?", strArr);
        if (arrayListM72703d == null || arrayListM72703d.isEmpty() || (fileModel = arrayListM72703d.get(0)) == null) {
            return null;
        }
        return fileModel.getThumbnailPath();
    }

    /* renamed from: o */
    public void m72699o(List<FileModel> list, int i10) throws Exception {
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList<String[]> arrayList = new ArrayList<>();
        Iterator<FileModel> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(m72695k(it.next()));
        }
        if (i10 == 1) {
            m72702b("REPLACE INTO diskDuplicateFile (fileId, fileName, fileSize, fileMd5, modifyTime, fileParent, fileCategory, isCloudExist, fileParentName, thumbnailPath) VALUES(?,?,?,?,?,?,?,?,?,?)", arrayList);
        } else {
            m72702b("REPLACE INTO diskBigFile (fileId, fileName, fileSize, fileMd5, modifyTime, fileParent, fileCategory, isCloudExist, fileParentName, thumbnailPath) VALUES(?,?,?,?,?,?,?,?,?,?)", arrayList);
        }
    }

    /* renamed from: p */
    public void m72700p(int i10, String str, String str2) throws Exception {
        if (str == null) {
            return;
        }
        ArrayList<String[]> arrayList = new ArrayList<>();
        arrayList.add(new String[]{str2, str});
        if (i10 == 1) {
            m72702b("UPDATE diskDuplicateFile SET fileParentName = ? WHERE fileParent = ?", arrayList);
        } else {
            m72702b("UPDATE diskBigFile SET fileParentName = ? WHERE fileParent = ?", arrayList);
        }
    }
}
