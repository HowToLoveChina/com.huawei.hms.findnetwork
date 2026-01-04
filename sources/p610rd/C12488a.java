package p610rd;

import android.text.TextUtils;
import com.huawei.android.hicloud.drive.clouddisk.model.FileModel;
import fk.C9721b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import p252e9.C9428e;
import p514o9.C11835i;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import sa.C12766a;

/* renamed from: rd.a */
/* loaded from: classes3.dex */
public class C12488a extends AbstractC12367d {

    /* renamed from: a */
    public List<FileModel> f57496a;

    /* renamed from: b */
    public HashMap<String, String> f57497b = new HashMap<>();

    /* renamed from: c */
    public int f57498c;

    public C12488a(List<FileModel> list, int i10) {
        this.f57498c = i10;
        this.f57496a = list;
    }

    /* renamed from: c */
    public void mo19674c() {
        C11839m.m70688i("GetCloudFileParentNameTask", "queryAfterRefershUI");
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        C11839m.m70688i("GetCloudFileParentNameTask", "task start.");
        List<FileModel> list = this.f57496a;
        if (list == null || list.isEmpty()) {
            C11839m.m70688i("GetCloudFileParentNameTask", "list is null.");
            return;
        }
        Iterator<FileModel> it = this.f57496a.iterator();
        while (it.hasNext()) {
            this.f57497b.put(it.next().getFileParent(), "");
        }
        C12766a.m76613b(this.f57498c, this.f57497b);
        for (FileModel fileModel : this.f57496a) {
            String str = this.f57497b.get(fileModel.getFileParent());
            if (!TextUtils.isEmpty(str)) {
                fileModel.setFileParentName(str);
                fileModel.setCloudPath(C9428e.m59118h().m59127i(C11835i.m70637a(false, str)));
            }
        }
        mo19674c();
        C11839m.m70688i("GetCloudFileParentNameTask", "task end.");
    }
}
