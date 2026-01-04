package p764x6;

import com.huawei.android.p069cg.request.response.FileCountResponse;
import java.io.IOException;

/* renamed from: x6.h */
/* loaded from: classes2.dex */
public class C13716h extends AbstractC13710b<FileCountResponse> {
    public C13716h(String str) {
        super(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [E, com.huawei.android.cg.request.response.FileCountResponse] */
    @Override // p764x6.AbstractC13710b
    /* renamed from: k */
    public int mo82455k() throws IOException {
        this.f61705f = new FileCountResponse();
        ((FileCountResponse) this.f61705f).setResult(new FileCountResponse.Result());
        return 0;
    }
}
