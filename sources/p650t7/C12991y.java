package p650t7;

import com.huawei.android.hicloud.album.service.hihttp.request.response.BaseResponse;
import com.huawei.android.hicloud.album.service.hihttp.request.response.LockAndVersionResponse;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.drive.cloudphoto.model.Lock;
import com.huawei.android.hicloud.drive.cloudphoto.request.CloudPhotoBatch;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;
import fk.C9721b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import p009a8.C0068f;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p429kk.C11058a;
import p429kk.C11060c;
import p546p6.C12106s;
import p546p6.EnumC12107t;
import p547p7.C12115c;
import p649t6.C12945e;
import p649t6.C12946f;
import p709vj.C13452e;
import p746wn.C13622a;
import p804ya.AbstractC13926c;

/* renamed from: t7.y */
/* loaded from: classes2.dex */
public class C12991y extends AbstractC12988v<LockAndVersionResponse> {

    /* renamed from: g */
    public final C12946f f59135g = new C12946f();

    /* renamed from: h */
    public final C12945e f59136h = new C12945e();

    /* renamed from: t7.y$a */
    public static class a extends AbstractC13926c<Album> {

        /* renamed from: a */
        public String f59137a;

        /* renamed from: b */
        public List<String> f59138b;

        /* renamed from: c */
        public List<String> f59139c;

        public a(String str, List<String> list, List<String> list2) {
            this.f59137a = str;
            this.f59138b = list;
            this.f59139c = list2;
        }

        @Override // p804ya.AbstractC13926c
        /* renamed from: a */
        public void mo74862a(ErrorResp.Error error, C4609l c4609l) {
            String description;
            int i10;
            if (error == null) {
                i10 = -1;
                description = "error is null";
            } else {
                int iIntValue = error.getCode().intValue();
                description = error.getDescription();
                i10 = iIntValue;
            }
            C1120a.m6676e("LockExecutor", "album.update for hide lost onFailure: " + i10 + ", info: " + description);
            if (404 == i10) {
                return;
            }
            this.f59139c.add(this.f59137a);
        }

        @Override // p369ii.InterfaceC10510a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Album album, C4609l c4609l) {
            this.f59138b.add(this.f59137a);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(3:(4:177|66|(3:192|68|203)(3:191|77|(4:194|81|89|200)(3:198|82|(2:88|201)(3:197|87|202)))|199)|64|188) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x02de, code lost:
    
        r3 = r18;
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x02c8, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x02c9, code lost:
    
        r3 = r18;
        r2 = r0;
        r11 = r4;
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x02cf, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x02d0, code lost:
    
        r3 = r18;
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x02d6, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x02d7, code lost:
    
        r3 = r18;
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x02dd, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0411 A[Catch: all -> 0x03c3, TryCatch #27 {all -> 0x03c3, blocks: (B:155:0x0393, B:159:0x03c6, B:160:0x03ee, B:162:0x0411, B:163:0x041a), top: B:171:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x041a A[Catch: all -> 0x03c3, TRY_LEAVE, TryCatch #27 {all -> 0x03c3, blocks: (B:155:0x0393, B:159:0x03c6, B:160:0x03ee, B:162:0x0411, B:163:0x041a), top: B:171:0x001c }] */
    /* JADX WARN: Type inference failed for: r1v0, types: [t7.v, t7.y, x6.d] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.os.BaseBundle, android.os.Bundle] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    @Override // p650t7.AbstractC12988v
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String mo77876l() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1081
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p650t7.C12991y.mo77876l():java.lang.String");
    }

    @Override // p650t7.AbstractC12988v
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public LockAndVersionResponse mo77904k(Class<BaseResponse> cls) {
        int iM6802l0;
        String string;
        LockAndVersionResponse lockAndVersionResponse = new LockAndVersionResponse();
        try {
            try {
                Lock lockM72513e = C12106s.m72509c().m72513e(EnumC12107t.GENERAL_SYNC_SDK, false);
                C1120a.m6675d("LockExecutor", "lock run: " + lockM72513e.toString());
                String sessionId = lockM72513e.getSessionId();
                Integer lockInterval = lockM72513e.getLockInterval();
                lockAndVersionResponse.setSyncLockToken(sessionId);
                lockAndVersionResponse.setInterval(lockInterval.intValue());
            } catch (IOException e10) {
                C1120a.m6676e("LockExecutor", "LockExecutor run IOException: " + e10.toString());
                if (e10 instanceof C4616s) {
                    iM6802l0 = C1122c.m6802l0((C4616s) e10);
                    string = e10.toString();
                } else {
                    iM6802l0 = C1122c.m6845x0(e10);
                    string = e10.toString();
                }
                lockAndVersionResponse.setCode(iM6802l0);
                lockAndVersionResponse.setInfo(string);
                C0068f.m459d().m468l();
                return lockAndVersionResponse;
            } catch (Exception e11) {
                C1120a.m6676e("LockExecutor", "LockExecutor run Exception: " + e11.toString());
                iM6802l0 = ConnectionResult.NETWORK_ERROR;
                string = e11.toString();
                lockAndVersionResponse.setCode(iM6802l0);
                lockAndVersionResponse.setInfo(string);
                C0068f.m459d().m468l();
                return lockAndVersionResponse;
            }
            C0068f.m459d().m468l();
            return lockAndVersionResponse;
        } finally {
            lockAndVersionResponse.setCode(0);
            lockAndVersionResponse.setInfo("OK");
        }
    }

    /* renamed from: r */
    public final Album m77947r() {
        Album album = new Album();
        HashMap map = new HashMap();
        map.put("emptyShow", "1");
        album.setProperties(map);
        return album;
    }

    /* renamed from: s */
    public final void m77948s(String str, long j10, long j11, String str2) {
        try {
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("04021"), str, C13452e.m80781L().m80971t0());
            c11060cM66626a.m66665u("0:1");
            String str3 = "successUpdateCount: " + j10 + ", failUpdateCount: " + j11 + ",failAlbumIds: " + str2;
            c11060cM66626a.m66635A(str3);
            C1120a.m6675d("LockExecutor", "reportUpdateAlbumsForHideLost, " + str + " " + str3);
            C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, null);
        } catch (Exception e10) {
            C1120a.m6676e("LockExecutor", "reportUpdateAlbumsForHideLost Exception " + e10);
        }
    }

    /* renamed from: t */
    public final void m77949t() throws Exception {
        C1120a.m6675d("LockExecutor", "updateAlbumsForHide start");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        m77951v(this.f59135g.m77784q(), arrayList, arrayList2);
        m77948s("updateAlbumsForHide", arrayList.size(), arrayList2.size(), arrayList2.toString());
        C1120a.m6675d("LockExecutor", "updateAlbumsForHide end");
        if (arrayList2.isEmpty()) {
            C12115c.m72560h().m72582w(true);
            return;
        }
        throw new C9721b(PayStatusCodes.PAY_STATE_PARAM_ERROR, "updateAlbumsForHide, failAlbumIds: " + arrayList2.toString());
    }

    /* renamed from: u */
    public final void m77950u() throws Exception {
        C1120a.m6675d("LockExecutor", "updateAlbumsForHideChange start");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        m77951v(this.f59136h.m77775n(), arrayList, arrayList2);
        m77948s("updateAlbumsForHideChange", arrayList.size(), arrayList2.size(), arrayList2.toString());
        C1120a.m6675d("LockExecutor", "updateAlbumsForHideChange end");
        if (arrayList2.isEmpty()) {
            this.f59136h.m77771j();
            return;
        }
        throw new C9721b(PayStatusCodes.PAY_STATE_TIME_OUT, "updateAlbumsForHideChange, failAlbumIds: " + arrayList2.toString());
    }

    /* renamed from: v */
    public final void m77951v(List<String> list, List<String> list2, List<String> list3) throws Exception {
        CloudPhotoBatch cloudPhotoBatchM83551h = this.f61708b.m83551h();
        int size = list.size();
        int i10 = 0;
        for (String str : list) {
            this.f61708b.m83547d().update(str, m77947r()).addHeader("x-hw-lock", (Object) C12106s.m72509c().m72512d(true).getSessionId()).addHeader("x-hw-trace-id", (Object) this.f61710d).queue(cloudPhotoBatchM83551h, new a(str, list2, list3));
            i10++;
            if (i10 % C1136q.d.m7148l() == 0 || size == i10) {
                if (cloudPhotoBatchM83551h.size() > 0) {
                    cloudPhotoBatchM83551h.execute();
                    cloudPhotoBatchM83551h = this.f61708b.m83551h();
                    C0068f.m459d().m468l();
                }
            }
        }
    }
}
