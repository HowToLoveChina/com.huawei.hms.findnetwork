package p764x6;

import com.huawei.android.p069cg.request.response.BaseResponse;
import java.io.IOException;
import p031b7.C1120a;
import p546p6.C12106s;
import p546p6.EnumC12107t;

/* renamed from: x6.c */
/* loaded from: classes2.dex */
public class C13711c extends AbstractC13710b<BaseResponse> {
    public C13711c(String str) {
        super(str);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [E, com.huawei.android.cg.request.response.BaseResponse] */
    @Override // p764x6.AbstractC13710b
    /* renamed from: k */
    public int mo82455k() throws IOException {
        this.f61705f = new BaseResponse();
        try {
            try {
                C12106s c12106sM72509c = C12106s.m72509c();
                EnumC12107t enumC12107t = EnumC12107t.EMPTY_RECYCLE;
                this.f61708b.m83556m().emptyRecycle().addHeader("x-hw-lock", c12106sM72509c.m72513e(enumC12107t, true).getSessionId()).execute();
                C12106s.m72509c().m72520l(enumC12107t);
                return 0;
            } catch (Exception e10) {
                C1120a.m6676e("ClearRecycleExecutor", "ClearRecycleExecutor execute Exception: " + e10.toString());
                C12106s.m72509c().m72520l(EnumC12107t.EMPTY_RECYCLE);
                return 0;
            }
        } catch (Throwable th2) {
            C12106s.m72509c().m72520l(EnumC12107t.EMPTY_RECYCLE);
            throw th2;
        }
    }
}
