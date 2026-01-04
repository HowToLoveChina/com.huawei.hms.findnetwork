package p650t7;

import com.huawei.android.hicloud.drive.cloudphoto.model.Change;
import com.huawei.android.hicloud.drive.cloudphoto.model.ChangeList;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import fk.C9721b;
import java.io.IOException;
import java.util.List;
import p009a8.C0073k;
import p031b7.C1120a;
import p804ya.AbstractC13926c;

/* renamed from: t7.i0 */
/* loaded from: classes2.dex */
public class C12970i0 extends AbstractC12988v {

    /* renamed from: g */
    public boolean f59078g = false;

    /* renamed from: t7.i0$a */
    public class a extends AbstractC13926c<ChangeList> {

        /* renamed from: a */
        public List<ErrorResp.Error> f59079a;

        public a(List<ErrorResp.Error> list) {
            this.f59079a = list;
        }

        @Override // p804ya.AbstractC13926c
        /* renamed from: a */
        public void mo74862a(ErrorResp.Error error, C4609l c4609l) {
            if (error == null) {
                return;
            }
            this.f59079a.add(error);
        }

        /* renamed from: c */
        public final boolean m77916c(ChangeList changeList) {
            List<Change> changes = changeList.getChanges();
            return (changes == null || changes.isEmpty()) ? false : true;
        }

        @Override // p369ii.InterfaceC10510a
        /* renamed from: d */
        public void onSuccess(ChangeList changeList, C4609l c4609l) {
            C1120a.m6675d("ShareFversionExecutor", "changeList: " + changeList.toString());
            if (m77916c(changeList)) {
                C12970i0.this.f59078g = true;
            }
        }
    }

    /* renamed from: r */
    private void m77915r() throws C9721b, IOException {
        C1120a.m6675d("ShareFversionExecutor", "About: " + C0073k.m595d().m598c(this.f61710d, false, null).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:337:0x039e A[Catch: all -> 0x0380, TryCatch #17 {all -> 0x0380, blocks: (B:331:0x0357, B:335:0x0382, B:337:0x039e, B:338:0x03a7, B:340:0x03b8), top: B:350:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:338:0x03a7 A[Catch: all -> 0x0380, TryCatch #17 {all -> 0x0380, blocks: (B:331:0x0357, B:335:0x0382, B:337:0x039e, B:338:0x03a7, B:340:0x03b8), top: B:350:0x0023 }] */
    /* JADX WARN: Type inference failed for: r14v0, types: [android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r14v16 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v23 */
    /* JADX WARN: Type inference failed for: r14v26 */
    @Override // p650t7.AbstractC12988v
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String mo77876l() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 979
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p650t7.C12970i0.mo77876l():java.lang.String");
    }
}
