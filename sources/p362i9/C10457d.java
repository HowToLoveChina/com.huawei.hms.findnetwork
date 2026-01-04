package p362i9;

import android.content.Context;
import com.google.gson.Gson;
import com.huawei.android.hicloud.cloudbackup.process.task.GetOptionsInfoFromCloneTask;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0212e0;
import p015ak.C0213f;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import tl.C13026e;

/* renamed from: i9.d */
/* loaded from: classes3.dex */
public class C10457d extends AbstractC12367d {
    /* renamed from: c */
    public final void m64263c() {
        boolean z10;
        boolean z11;
        C11839m.m70688i("QueryBackupThirdAppDataTask", "queryBackupThirdAppData start");
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("QueryBackupThirdAppDataTask", "context is null");
            return;
        }
        int iM1357g = C0212e0.m1357g(contextM1377a, "sp_device_use_info", "key_backup_item_length", 0);
        C11839m.m70686d("QueryBackupThirdAppDataTask", "thirdAppDatas lastBackupAppNum  " + iM1357g);
        ArrayList arrayList = new ArrayList();
        if (iM1357g > 0) {
            for (int i10 = 0; i10 < iM1357g; i10++) {
                arrayList.add(C0212e0.m1363m(contextM1377a, "sp_device_use_info", "key_backup_app_item_info" + i10, ""));
            }
        }
        GetOptionsInfoFromCloneTask.checkCacheInvalid();
        List<BackupOptionItem> listM78399w = new C13026e().m78399w("thirdAppData");
        if (listM78399w == null || listM78399w.size() <= 0) {
            C11839m.m70687e("QueryBackupThirdAppDataTask", "thirdAppDatas is null ");
            return;
        }
        int size = listM78399w.size();
        C11839m.m70686d("QueryBackupThirdAppDataTask", "queryBackupThirdAppData thirdAppDatas size " + size);
        if (iM1357g != size) {
            z11 = false;
            z10 = true;
        } else {
            z10 = false;
            z11 = true;
        }
        C11839m.m70686d("QueryBackupThirdAppDataTask", "queryBackupThirdAppData isNeedCompare " + z11);
        C0212e0.m1368r(contextM1377a, "sp_device_use_info", "key_backup_item_length", size);
        for (int i11 = 0; i11 < size; i11++) {
            String json = new Gson().toJson(listM78399w.get(i11));
            C11839m.m70686d("QueryBackupThirdAppDataTask", "queryBackupThirdAppData item " + i11 + json);
            C0212e0.m1372v(contextM1377a, "sp_device_use_info", "key_backup_app_item_info" + i11, json);
            if (z11 && !json.equals((String) arrayList.get(i11))) {
                z11 = false;
                z10 = true;
            }
        }
        if (z10) {
            C0212e0.m1365o(contextM1377a, "sp_device_use_info", "key_has_data_change", true);
        }
        C11839m.m70688i("QueryBackupThirdAppDataTask", "queryBackupThirdAppData end");
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        m64263c();
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.COLLECT_DEVICE_INFO;
    }
}
