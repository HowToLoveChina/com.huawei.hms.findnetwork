package p252e9;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.android.hicloud.common.task.CloudDiskFileDeleteTask;
import com.huawei.android.hicloud.drive.clouddisk.model.FileModel;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import hk.C10278a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p015ak.C0213f;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p616rk.C12515a;
import p664u0.C13108a;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;
import pa.C12123a;

/* renamed from: e9.e */
/* loaded from: classes3.dex */
public class C9428e {

    /* renamed from: a */
    public CloudDiskFileDeleteTask f47112a;

    /* renamed from: b */
    public CloudDiskFileDeleteTask f47113b;

    /* renamed from: e9.e$a */
    public class a extends CloudDiskFileDeleteTask {
        public a(List<FileModel> list, boolean z10) {
            super(list, z10);
        }

        @Override // com.huawei.android.hicloud.common.task.CloudDiskFileDeleteTask
        /* renamed from: g */
        public String mo15798g() {
            return "big_file";
        }
    }

    /* renamed from: e9.e$b */
    public class b extends CloudDiskFileDeleteTask {
        public b(List<FileModel> list, boolean z10) {
            super(list, z10);
        }

        @Override // com.huawei.android.hicloud.common.task.CloudDiskFileDeleteTask
        /* renamed from: g */
        public String mo15798g() {
            return "duplicate_file";
        }
    }

    /* renamed from: e9.e$c */
    public static class c {

        /* renamed from: a */
        public static final C9428e f47116a = new C9428e();
    }

    /* renamed from: h */
    public static C9428e m59118h() {
        return c.f47116a;
    }

    /* renamed from: l */
    public static void m59119l(String str, Map<String, String> map) {
        try {
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07039"), str, C13452e.m80781L().m80971t0());
            c11060cM66626a.m66665u("0");
            C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e("CloudDiskFileCleanManager", "omReport exception: " + e10.toString());
        }
    }

    /* renamed from: a */
    public final void m59120a(String str, LinkedHashMap<String, String> linkedHashMap) {
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            if (linkedHashMap != null) {
                linkedHashMapM79497A.putAll(linkedHashMap);
            }
            C13225d.m79490f1().m79567R(str, linkedHashMapM79497A);
            UBAAnalyze.m29947H("PVC", str, linkedHashMapM79497A);
        } catch (Exception e10) {
            NotifyLogger.m29914e("CloudDiskFileCleanManager", "biReport exception: " + e10.toString());
        }
    }

    /* renamed from: b */
    public final void m59121b(Map<Integer, Map<String, List<FileModel>>> map, List<FileModel> list, HashSet<String> hashSet) {
        List<FileModel> arrayList;
        if (list == null) {
            return;
        }
        for (FileModel fileModel : list) {
            if (fileModel != null && !hashSet.contains(fileModel.getFileId())) {
                hashSet.add(fileModel.getFileId());
                Map<String, List<FileModel>> map2 = map.get(Integer.valueOf(fileModel.getFileCategory()));
                if (map2 == null) {
                    map2 = new HashMap<>();
                    arrayList = new ArrayList<>();
                } else {
                    arrayList = map2.get(fileModel.getFileMD5());
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                }
                arrayList.add(fileModel);
                map2.put(fileModel.getFileMD5(), arrayList);
                map.put(Integer.valueOf(fileModel.getFileCategory()), map2);
            }
        }
    }

    /* renamed from: c */
    public final void m59122c(String str, int i10) {
        try {
            C11839m.m70686d("CloudDiskFileCleanManager", "clearLocalRecord start: " + i10);
            if (TextUtils.isEmpty(str)) {
                C11839m.m70686d("CloudDiskFileCleanManager", "clearLocalRecord fileId is null.");
                return;
            }
            C12123a c12123a = new C12123a();
            ArrayList<FileModel> arrayListM72692h = i10 == 0 ? c12123a.m72692h("SELECT fileId, fileName, fileSize, fileMd5, modifyTime, fileParent, fileCategory, thumbnailPath, fileParentName FROM  diskBigFile WHERE fileId = ?", new String[]{str}) : c12123a.m72692h("SELECT fileId, fileName, fileSize, fileMd5, modifyTime, fileParent, fileCategory, thumbnailPath, fileParentName FROM  diskDuplicateFile WHERE fileId = ?", new String[]{str});
            if (arrayListM72692h == null || arrayListM72692h.size() <= 0) {
                return;
            }
            m59124e(arrayListM72692h.get(0));
            c12123a.m72689e(arrayListM72692h, i10);
        } catch (Exception e10) {
            C11839m.m70686d("CloudDiskFileCleanManager", "clearLocalRecord clear file error: " + e10.toString());
        }
    }

    /* renamed from: d */
    public void m59123d(String str) {
        m59122c(str, 0);
        m59122c(str, 1);
    }

    /* renamed from: e */
    public final void m59124e(FileModel fileModel) {
        if (fileModel == null) {
            return;
        }
        String thumbnailPath = fileModel.getThumbnailPath();
        if (TextUtils.isEmpty(thumbnailPath)) {
            return;
        }
        File fileM63442h = C10278a.m63442h(thumbnailPath);
        if (fileM63442h.exists()) {
            fileM63442h.delete();
        }
    }

    /* renamed from: f */
    public void m59125f(List<FileModel> list, CloudDiskFileDeleteTask.Callback callback, boolean z10) {
        a aVar = new a(list, z10);
        this.f47112a = aVar;
        aVar.m15803m(callback);
        C12515a.m75110o().m75172d(this.f47112a);
    }

    /* renamed from: g */
    public void m59126g(List<FileModel> list, CloudDiskFileDeleteTask.Callback callback, boolean z10) {
        b bVar = new b(list, z10);
        this.f47113b = bVar;
        bVar.m15803m(callback);
        C12515a.m75110o().m75172d(this.f47113b);
    }

    /* renamed from: i */
    public String m59127i(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replaceFirst("/CloudDisk", C0213f.m1377a().getResources().getString(R$string.hidisk_my_drive));
    }

    /* renamed from: j */
    public boolean m59128j() {
        if (this.f47112a == null) {
            return false;
        }
        return !r0.m15802l();
    }

    /* renamed from: k */
    public void m59129k(Context context) {
        if (context == null) {
            C11839m.m70688i("CloudDiskFileCleanManager", "notifySpaceSizeChanged context is null");
            return;
        }
        C11839m.m70688i("CloudDiskFileCleanManager", "notifySpaceSizeChanged");
        Intent intent = new Intent();
        intent.setAction("com.huawei.cg.action.SPACE_DELETED_CHANGED");
        C13108a.m78878b(context).m78881d(intent);
    }

    /* renamed from: m */
    public final long m59130m(ArrayList<FileModel> arrayList, HashSet<String> hashSet) {
        long fileSize = 0;
        if (arrayList == null) {
            return 0L;
        }
        Iterator<FileModel> it = arrayList.iterator();
        while (it.hasNext()) {
            FileModel next = it.next();
            if (!hashSet.contains(next.getFileId())) {
                hashSet.add(next.getFileId());
                fileSize += next.getFileSize();
            }
        }
        return fileSize;
    }

    /* renamed from: n */
    public final long m59131n(Map<Integer, Map<String, List<FileModel>>> map) {
        long fileSize = 0;
        if (map == null) {
            return 0L;
        }
        Iterator<Map.Entry<Integer, Map<String, List<FileModel>>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Iterator<Map.Entry<String, List<FileModel>>> it2 = it.next().getValue().entrySet().iterator();
            while (it2.hasNext()) {
                fileSize += it2.next().getValue().get(0).getFileSize() * (r2.size() - 1);
            }
        }
        return fileSize;
    }

    /* renamed from: o */
    public long m59132o() {
        C12123a c12123a = new C12123a();
        ArrayList<FileModel> arrayListM72692h = c12123a.m72692h("SELECT fileId, fileName, fileSize, fileMd5, modifyTime, fileParent, fileCategory, thumbnailPath, fileParentName FROM  diskDuplicateFile", null);
        HashSet<String> hashSet = new HashSet<>();
        long jM59130m = m59130m(c12123a.m72692h("SELECT fileId, fileName, fileSize, fileMd5, modifyTime, fileParent, fileCategory, thumbnailPath, fileParentName FROM  diskBigFile", null), hashSet);
        HashMap map = new HashMap();
        m59121b(map, arrayListM72692h, hashSet);
        return jM59130m + m59131n(map);
    }

    /* renamed from: p */
    public void m59133p(CloudDiskFileDeleteTask.Callback callback) {
        CloudDiskFileDeleteTask cloudDiskFileDeleteTask = this.f47112a;
        if (cloudDiskFileDeleteTask == null) {
            C11839m.m70686d("CloudDiskFileCleanManager", "refreshBigFileDeleteTaskCallBack task is null.");
        } else {
            cloudDiskFileDeleteTask.m15803m(callback);
        }
    }

    /* renamed from: q */
    public void m59134q(String str, LinkedHashMap<String, String> linkedHashMap) {
        m59120a(str, linkedHashMap);
        m59119l(str, linkedHashMap);
    }

    /* renamed from: r */
    public void m59135r(String str, String str2, LinkedHashMap<String, String> linkedHashMap) {
        try {
            C11060c c11060cM66626a = C11058a.m66626a(str2, str, C13452e.m80781L().m80971t0());
            c11060cM66626a.m66665u("0");
            C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, linkedHashMap);
        } catch (Exception e10) {
            NotifyLogger.m29914e("CloudDiskFileCleanManager", "omReport exception: " + e10.toString());
        }
    }
}
