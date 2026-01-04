package p650t7;

import android.database.SQLException;
import android.text.TextUtils;
import com.huawei.android.p069cg.logic.manager.CloudAlbumManager;
import fk.C9721b;
import java.io.IOException;
import p009a8.C0073k;
import p015ak.C0213f;
import p015ak.C0241z;
import p031b7.C1120a;
import p031b7.C1136q;
import p765x7.C13719a;

/* renamed from: t7.s */
/* loaded from: classes2.dex */
public class C12985s extends AbstractC12988v {
    public C12985s(String str) {
        super(str);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(3:(4:342|241|(3:360|243|369)(3:357|251|(4:362|255|266|366)(3:364|256|(2:265|367)(5:363|261|(1:263)|264|368)))|365)|350|239) */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x030c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x030d, code lost:
    
        r3 = r17;
        r5 = r18;
        r2 = r0;
        r11 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x0315, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x0316, code lost:
    
        r3 = r17;
        r5 = r18;
        r2 = r0;
        r12 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x031e, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x031f, code lost:
    
        r3 = r17;
        r5 = r18;
        r11 = r4;
     */
    /* JADX WARN: Removed duplicated region for block: B:319:0x03f3 A[Catch: all -> 0x03fc, TryCatch #11 {all -> 0x03fc, blocks: (B:317:0x03d7, B:319:0x03f3, B:322:0x03ff, B:324:0x0410), top: B:331:0x03d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:322:0x03ff A[Catch: all -> 0x03fc, TryCatch #11 {all -> 0x03fc, blocks: (B:317:0x03d7, B:319:0x03f3, B:322:0x03ff, B:324:0x0410), top: B:331:0x03d7 }] */
    @Override // p650t7.AbstractC12988v
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String mo77876l() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1074
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p650t7.C12985s.mo77876l():java.lang.String");
    }

    /* renamed from: q */
    public final void m77937q(String str) throws InterruptedException, C9721b, SQLException {
        C1120a.m6677i("GetVersionExecutor", "checkFullUploadCursor fullUploadCursor: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strM6962c = C1136q.m6962c();
        C1120a.m6677i("GetVersionExecutor", "getFullUploadCursor localUploadCursor: " + strM6962c);
        if (TextUtils.isEmpty(strM6962c) || C0241z.m1688f(str) > C0241z.m1688f(strM6962c)) {
            C1136q.m6983x(str);
            C1136q.m6952J(false);
        }
        String strM6971l = C1136q.m6971l();
        if (TextUtils.isEmpty(strM6971l)) {
            C1120a.m6675d("GetVersionExecutor", "localLatestVersion is empty");
            return;
        }
        if (C1136q.m6979t()) {
            C1120a.m6675d("GetVersionExecutor", "upload cursor is used");
            return;
        }
        long jM1688f = C0241z.m1688f(C13719a.m82477e(strM6971l));
        long jM1688f2 = C0241z.m1688f(C1136q.m6962c());
        C1120a.m6677i("GetVersionExecutor", "checkFullUploadCursor localLatestVersion: " + jM1688f + ", uploadCursor: " + jM1688f2);
        if (jM1688f >= jM1688f2) {
            return;
        }
        CloudAlbumManager.m14456v().m14480Z(C0213f.m1377a(), this.f61710d);
        C1136q.m6952J(true);
        C1136q.m6946D("");
        throw new C9721b(4001, "fullUploadCursor bigger restartSync");
    }

    /* renamed from: r */
    public final void m77938r() throws C9721b, IOException {
        C1120a.m6675d("GetVersionExecutor", "About: " + C0073k.m595d().m598c(this.f61710d, false, null).toString());
    }
}
