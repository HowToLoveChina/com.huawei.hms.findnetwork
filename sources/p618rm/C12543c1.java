package p618rm;

import com.google.gson.reflect.TypeToken;
import com.huawei.android.hicloud.cloudbackup.model.HiddenAlbumFileData;
import hk.C10278a;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p292fn.C9733f;
import p514o9.C11839m;
import p617rl.C12526j;
import p617rl.C12527k;

/* renamed from: rm.c1 */
/* loaded from: classes6.dex */
public final class C12543c1 {

    /* renamed from: rm.c1$a */
    public class a extends TypeToken<List<String>> {
    }

    /* renamed from: a */
    public static HiddenAlbumFileData m75489a(File file, HiddenAlbumFileData hiddenAlbumFileData, boolean z10) {
        if (!file.exists()) {
            return hiddenAlbumFileData;
        }
        if (z10 && file.isHidden()) {
            return hiddenAlbumFileData;
        }
        if (file.isFile()) {
            hiddenAlbumFileData.incrementFileCount();
            hiddenAlbumFileData.incrementFileSize(file.length());
        } else {
            for (File file2 : file.listFiles()) {
                m75489a(file2, hiddenAlbumFileData, z10);
            }
        }
        return hiddenAlbumFileData;
    }

    /* renamed from: b */
    public static List<String> m75490b(boolean z10, boolean z11, int i10) {
        List list;
        ArrayList arrayList = new ArrayList();
        if (z10) {
            if (!C9733f.m60705z().m60720O("cloudBackupRefurbishHiddenAlbum")) {
                C11839m.m70688i("HiddenAlbumBackupUtil", "hide album cloudBackupRefurbishHiddenAlbum is not open");
                return arrayList;
            }
        } else if (z11) {
            if (C9733f.m60705z().m60720O("disableCloudBackupTempHiddenAlbum")) {
                C11839m.m70688i("HiddenAlbumBackupUtil", "hide album cloudBackupTempHiddenAlbum is not open");
                return arrayList;
            }
        } else if (!C9733f.m60705z().m60720O("cloudBackupHiddenAlbum")) {
            C11839m.m70688i("HiddenAlbumBackupUtil", "hide album cloudBackupHiddenAlbumSwitch is not open");
            return arrayList;
        }
        C12527k c12527kM75407n = new C12526j().m75407n("hiddenAlbumPath");
        if (c12527kM75407n == null) {
            C11839m.m70688i("HiddenAlbumBackupUtil", "hide album omConfig hiddenAlbumPath key is not exist");
            return arrayList;
        }
        try {
            list = (List) C12540b1.m75484b(c12527kM75407n.m75434b(), new a().getType());
        } catch (Exception e10) {
            C11839m.m70687e("HiddenAlbumBackupUtil", "hide album parseResult error: " + e10);
            list = null;
        }
        if (list == null) {
            C11839m.m70688i("HiddenAlbumBackupUtil", "hide album parseResult is null");
            return arrayList;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String strM75973f = C12593t0.m75973f((String) it.next(), i10);
            if (C10278a.m63442h(strM75973f).exists()) {
                arrayList.add(strM75973f);
            } else {
                C11839m.m70688i("HiddenAlbumBackupUtil", "hide album hiddenAlbumFullPath: " + strM75973f + " not exist.");
            }
        }
        C11839m.m70688i("HiddenAlbumBackupUtil", "hide album hiddenAlbumPathList: " + arrayList);
        return arrayList;
    }

    /* renamed from: c */
    public static HiddenAlbumFileData m75491c(boolean z10, boolean z11, int i10) {
        HiddenAlbumFileData hiddenAlbumFileData = new HiddenAlbumFileData();
        try {
            Iterator<String> it = m75490b(z10, z11, i10).iterator();
            while (it.hasNext()) {
                m75489a(C10278a.m63442h(it.next()), hiddenAlbumFileData, true);
            }
        } catch (Exception e10) {
            C11839m.m70687e("HiddenAlbumBackupUtil", "hide album initHiddenAlbumCountAndSize error: " + e10);
        }
        return hiddenAlbumFileData;
    }
}
