package p252e9;

import com.huawei.android.hicloud.drive.clouddisk.model.FileModel;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.json.JsonError;
import java.util.ArrayList;
import p336he.C10156g;
import p397ji.AbstractC10891a;
import p514o9.C11839m;
import sa.C12766a;

/* renamed from: e9.d */
/* loaded from: classes3.dex */
public class C9427d extends AbstractC10891a<Void> {

    /* renamed from: a */
    public FileModel f47109a;

    /* renamed from: b */
    public ArrayList<FileModel> f47110b;

    /* renamed from: c */
    public ArrayList<FileModel> f47111c;

    public C9427d(FileModel fileModel, ArrayList<FileModel> arrayList, ArrayList<FileModel> arrayList2) {
        this.f47109a = fileModel;
        this.f47110b = arrayList;
        this.f47111c = arrayList2;
    }

    @Override // p369ii.InterfaceC10510a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Void r22, C4609l c4609l) {
        C11839m.m70688i("BatchDeleteCallback", "onSuccess");
        C10156g.m63310g(c4609l);
        this.f47110b.add(this.f47109a);
        C9428e.m59118h().m59123d(this.f47109a.getFileId());
    }

    @Override // p397ji.AbstractC10891a
    public void onFailure(JsonError jsonError, C4609l c4609l) {
        C11839m.m70688i("BatchDeleteCallback", "onFailure: " + jsonError.toString());
        if (!C12766a.m76617f(404, "4041", jsonError.toString())) {
            this.f47111c.add(this.f47109a);
        } else {
            this.f47110b.add(this.f47109a);
            C9428e.m59118h().m59123d(this.f47109a.getFileId());
        }
    }
}
