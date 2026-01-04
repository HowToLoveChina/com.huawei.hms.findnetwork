package p764x6;

import com.huawei.android.hicloud.drive.cloudphoto.model.About;
import com.huawei.android.p069cg.request.response.BaseResponse;
import java.io.IOException;
import java.util.Optional;
import p031b7.C1120a;
import p031b7.C1136q;

/* renamed from: x6.g */
/* loaded from: classes2.dex */
public class C13715g extends AbstractC13710b<BaseResponse> {
    public C13715g(String str) {
        super(str);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [E, com.huawei.android.cg.request.response.BaseResponse] */
    @Override // p764x6.AbstractC13710b
    /* renamed from: k */
    public int mo82455k() throws IOException {
        this.f61705f = new BaseResponse();
        About aboutExecute = this.f61708b.m83544a().get().setFields2("dataVersion,status,user(permissionId)").execute();
        String dataVersion = aboutExecute.getDataVersion();
        int iIntValue = aboutExecute.getStatus().getV2cut().intValue();
        C1136q.d.m7124A(dataVersion);
        C1136q.d.m7135L(iIntValue);
        Optional.ofNullable(aboutExecute.getUser()).map(new C13713e()).ifPresent(new C13714f());
        C1120a.m6677i("DataVersionCheckExecutor", "dataVersion: " + dataVersion + ", v2cut: " + iIntValue);
        return 0;
    }
}
