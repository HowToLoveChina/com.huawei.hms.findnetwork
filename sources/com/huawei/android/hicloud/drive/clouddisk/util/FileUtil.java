package com.huawei.android.hicloud.drive.clouddisk.util;

import android.text.TextUtils;
import com.huawei.android.hicloud.drive.clouddisk.model.DuplicateFileCard;
import com.huawei.android.hicloud.drive.clouddisk.model.FileModel;
import com.huawei.android.hicloud.drive.clouddisk.util.FileUtil;
import com.huawei.hicloud.sync.R$string;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p015ak.C0213f;
import p514o9.C11829c;
import p514o9.C11839m;
import pa.C12123a;

/* loaded from: classes3.dex */
public final class FileUtil {

    public interface CloudExist {
    }

    /* renamed from: c */
    public static String m16353c(boolean z10, String str) {
        if (z10) {
            return "/CloudDisk";
        }
        return "/CloudDisk/.../" + str;
    }

    /* renamed from: d */
    public static Map<Integer, Map<String, List<FileModel>>> m16354d(Map<String, List<FileModel>> map, Map<String, Set<Integer>> map2) {
        HashMap map3 = new HashMap();
        for (Map.Entry<String, List<FileModel>> entry : map.entrySet()) {
            String key = entry.getKey();
            Set<Integer> set = map2.get(key);
            if (set != null && !set.isEmpty()) {
                int iIntValue = 6;
                if (1 == set.size()) {
                    Iterator<Integer> it = set.iterator();
                    while (it.hasNext()) {
                        iIntValue = it.next().intValue();
                    }
                }
                Map map4 = (Map) map3.get(Integer.valueOf(iIntValue));
                List<FileModel> value = entry.getValue();
                if (map4 == null) {
                    map4 = new HashMap();
                    map4.put(key, value);
                } else {
                    List<FileModel> list = (List) map4.get(key);
                    if (list != null) {
                        list.addAll(value);
                        value = list;
                    }
                    map4.put(key, value);
                }
                map3.put(Integer.valueOf(iIntValue), map4);
            }
        }
        return map3;
    }

    /* renamed from: e */
    public static long m16355e(long j10, boolean z10) {
        float f10 = j10;
        int i10 = (z10 || !C11829c.f54756b) ? 1024 : 1000;
        float f11 = 1.0f;
        if (f10 > 900.0f) {
            float f12 = i10;
            f10 /= f12;
            f11 = 1.0f * f12;
        }
        if (f10 > 900.0f) {
            float f13 = i10;
            f10 /= f13;
            f11 *= f13;
        }
        if (f10 > 900.0f) {
            float f14 = i10;
            f10 /= f14;
            f11 *= f14;
        }
        return (long) (new BigDecimal(f10).setScale(2, 4).doubleValue() * f11);
    }

    /* renamed from: f */
    public static int m16356f(int i10) {
        if (m16361k(i10)) {
            return 7;
        }
        if (m16360j(i10)) {
            return 1;
        }
        if (m16364n(i10)) {
            return 2;
        }
        if (m16363m(i10)) {
            return 0;
        }
        if (m16362l(i10)) {
            return 3;
        }
        if (m16359i(i10)) {
            return 4;
        }
        return m16358h(i10) ? 5 : 6;
    }

    /* renamed from: g */
    public static String m16357g(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replaceFirst("/CloudDisk", C0213f.m1377a().getResources().getString(R$string.hidisk_my_drive));
    }

    /* renamed from: h */
    public static boolean m16358h(int i10) {
        return i10 == 130;
    }

    /* renamed from: i */
    public static boolean m16359i(int i10) {
        return i10 >= 110 && i10 <= 119;
    }

    /* renamed from: j */
    public static boolean m16360j(int i10) {
        return i10 >= 70 && i10 <= 100;
    }

    /* renamed from: k */
    public static boolean m16361k(int i10) {
        return i10 == 0;
    }

    /* renamed from: l */
    public static boolean m16362l(int i10) {
        return i10 >= 50 && i10 <= 58;
    }

    /* renamed from: m */
    public static boolean m16363m(int i10) {
        return i10 >= 1 && i10 <= 14;
    }

    /* renamed from: n */
    public static boolean m16364n(int i10) {
        return i10 >= 21 && i10 <= 39;
    }

    /* renamed from: o */
    public static /* synthetic */ int m16365o(FileModel fileModel, FileModel fileModel2) {
        return fileModel2.getModifyTime().compareTo(fileModel.getModifyTime());
    }

    /* renamed from: p */
    public static /* synthetic */ int m16366p(DuplicateFileCard duplicateFileCard, DuplicateFileCard duplicateFileCard2) {
        return (int) (duplicateFileCard2.getSize() - duplicateFileCard.getSize());
    }

    /* renamed from: q */
    public static Map<Integer, List<DuplicateFileCard>> m16367q(String str, ArrayList<FileModel> arrayList) {
        ArrayList<FileModel> arrayListM72692h = new C12123a().m72692h("SELECT fileId, fileName, fileSize, fileMd5, modifyTime, fileParent, fileCategory, thumbnailPath, fileParentName FROM  diskDuplicateFile", null);
        C11839m.m70688i("FileUtil", "duplicate file db file size: " + arrayListM72692h.size());
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        Iterator<FileModel> it = arrayListM72692h.iterator();
        while (it.hasNext()) {
            FileModel next = it.next();
            if (next != null && !TextUtils.isEmpty(next.getFileMD5())) {
                next.setFileSize(m16355e(next.getFileSize(), true));
                int fileCategory = next.getFileCategory();
                if (fileCategory == 5) {
                    fileCategory = 6;
                    next.setFileCategory(6);
                }
                if (TextUtils.isEmpty(next.getFileParentName())) {
                    arrayList.add(next);
                    next.setCloudPath(str);
                } else {
                    next.setCloudPath(m16357g(next.getFileParentName()));
                }
                List arrayList2 = (List) map.get(next.getFileMD5());
                Set hashSet = (Set) map2.get(next.getFileMD5());
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                if (hashSet == null) {
                    hashSet = new HashSet();
                }
                arrayList2.add(next);
                hashSet.add(Integer.valueOf(fileCategory));
                map.put(next.getFileMD5(), arrayList2);
                map2.put(next.getFileMD5(), hashSet);
            }
        }
        Map<Integer, Map<String, List<FileModel>>> mapM16354d = m16354d(map, map2);
        HashMap map3 = new HashMap();
        for (Map.Entry<Integer, Map<String, List<FileModel>>> entry : mapM16354d.entrySet()) {
            ArrayList arrayList3 = new ArrayList();
            Iterator<Map.Entry<String, List<FileModel>>> it2 = entry.getValue().entrySet().iterator();
            while (it2.hasNext()) {
                List<FileModel> value = it2.next().getValue();
                if (value.size() > 1) {
                    FileModel fileModel = value.get(0);
                    DuplicateFileCard duplicateFileCard = new DuplicateFileCard();
                    duplicateFileCard.setSize(fileModel.getFileSize());
                    duplicateFileCard.setMd5(fileModel.getFileMD5());
                    value.sort(new Comparator() { // from class: va.a
                        @Override // java.util.Comparator
                        public final int compare(Object obj, Object obj2) {
                            return FileUtil.m16365o((FileModel) obj, (FileModel) obj2);
                        }
                    });
                    duplicateFileCard.setFileModelList(value);
                    arrayList3.add(duplicateFileCard);
                }
            }
            if (!arrayList3.isEmpty()) {
                arrayList3.sort(new Comparator() { // from class: va.b
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return FileUtil.m16366p((DuplicateFileCard) obj, (DuplicateFileCard) obj2);
                    }
                });
                map3.put(entry.getKey(), arrayList3);
            }
        }
        C11839m.m70688i("FileUtil", "duplicate file categoryCardMap size: " + map3.size());
        return map3;
    }
}
