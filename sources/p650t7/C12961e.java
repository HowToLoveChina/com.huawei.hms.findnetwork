package p650t7;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.album.service.p075vo.AlbumUpdatedResult;
import com.huawei.android.hicloud.album.service.p075vo.GeneralAlbumData;
import com.huawei.android.hicloud.album.service.p075vo.ShareAlbumData;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.drive.cloudphoto.request.Albums;
import com.huawei.android.hicloud.drive.cloudphoto.request.CloudPhotoBatch;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p009a8.C0068f;
import p015ak.C0227m;
import p031b7.C1120a;
import p031b7.C1136q;
import p546p6.C12106s;
import p546p6.EnumC12107t;
import p635s7.C12734h;
import p671u7.C13129a;
import p709vj.C13452e;
import p804ya.AbstractC13926c;

/* renamed from: t7.e */
/* loaded from: classes2.dex */
public class C12961e extends AbstractC12988v {

    /* renamed from: g */
    public List<GeneralAlbumData> f59042g;

    /* renamed from: h */
    public ShareAlbumData f59043h;

    /* renamed from: i */
    public String f59044i;

    /* renamed from: j */
    public boolean f59045j = true;

    /* renamed from: t7.e$a */
    public static class a extends AbstractC13926c<Album> {

        /* renamed from: a */
        public GeneralAlbumData f59046a;

        /* renamed from: b */
        public ArrayList<AlbumUpdatedResult> f59047b;

        /* renamed from: c */
        public List<String> f59048c;

        public a(GeneralAlbumData generalAlbumData, ArrayList<AlbumUpdatedResult> arrayList, List<String> list) {
            this.f59046a = generalAlbumData;
            this.f59047b = arrayList;
            this.f59048c = list;
        }

        @Override // p804ya.AbstractC13926c
        /* renamed from: a */
        public void mo74862a(ErrorResp.Error error, C4609l c4609l) {
            this.f59047b.add(new AlbumUpdatedResult(this.f59046a.getAlbumName(), this.f59046a.getAlbumId(), error.getCode().intValue(), error.getDescription()));
        }

        @Override // p369ii.InterfaceC10510a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Album album, C4609l c4609l) {
            String albumId = this.f59046a.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(album.getId())) {
                this.f59048c.add(album.getId());
                return;
            }
            AlbumUpdatedResult albumUpdatedResult = new AlbumUpdatedResult(this.f59046a.getAlbumName(), albumId, 21, "lpath exist");
            albumUpdatedResult.setExistAlbumId(album.getId());
            this.f59047b.add(albumUpdatedResult);
        }
    }

    public C12961e(List<GeneralAlbumData> list, String str) {
        this.f59042g = list;
        this.f59044i = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00b8  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    @Override // p650t7.AbstractC12988v
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String mo77876l() throws java.lang.Exception {
        /*
            r9 = this;
            java.lang.String r0 = "info"
            java.lang.String r1 = "code"
            java.lang.String r2 = "OK"
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            r9.f59133f = r3
            java.lang.String r3 = "CreateAlbumExecutor start"
            java.lang.String r4 = "CreateAlbumExecutor"
            p031b7.C1120a.m6675d(r4, r3)
            r3 = 0
            boolean r5 = r9.f59045j     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L20 java.io.IOException -> L22
            if (r5 == 0) goto L56
            r9.m77902r()     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L20 java.io.IOException -> L22 com.huawei.cloud.base.http.C4616s -> L26
            goto L59
        L1d:
            r4 = move-exception
            goto Lb4
        L20:
            r5 = move-exception
            goto L71
        L22:
            r4 = move-exception
            r5 = r3
            goto L94
        L26:
            r5 = move-exception
            java.lang.String r6 = bb.C1160a.m7253d(r5)     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L20 java.io.IOException -> L22
            java.lang.String r7 = "31044002"
            boolean r7 = r6.equals(r7)     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L20 java.io.IOException -> L22
            if (r7 == 0) goto L3e
            wj.b r5 = p742wj.C13612b.m81829B()     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L20 java.io.IOException -> L22
            r5.m81897y0()     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L20 java.io.IOException -> L22
            r9.m77902r()     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L20 java.io.IOException -> L22
            goto L59
        L3e:
            java.lang.String r7 = "31084932"
            boolean r6 = r7.equals(r6)     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L20 java.io.IOException -> L22
            if (r6 == 0) goto L55
            r5 = 7
            java.lang.String r2 = "albumName repeat"
            r3 = r5
            goto L59
        L4b:
            r4 = move-exception
            r3 = r5
            goto Lb4
        L4e:
            r3 = move-exception
            r8 = r5
            r5 = r3
            r3 = r8
            goto L71
        L53:
            r4 = move-exception
            goto L94
        L55:
            throw r5     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L20 java.io.IOException -> L22
        L56:
            r9.m77901q()     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L20 java.io.IOException -> L22
        L59:
            boolean r4 = r9.f59045j
            if (r4 == 0) goto L66
        L5d:
            p6.s r4 = p546p6.C12106s.m72509c()
            p6.t r5 = p546p6.EnumC12107t.SHARE_CREATE_ALBUM
            r4.m72520l(r5)
        L66:
            android.os.Bundle r4 = r9.f59133f
            r4.putInt(r1, r3)
            android.os.Bundle r9 = r9.f59133f
            r9.putString(r0, r2)
            goto Lb1
        L71:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1d
            r6.<init>()     // Catch: java.lang.Throwable -> L1d
            java.lang.String r7 = "CreateAlbumExecutor runTask Exception: "
            r6.append(r7)     // Catch: java.lang.Throwable -> L1d
            java.lang.String r7 = r5.toString()     // Catch: java.lang.Throwable -> L1d
            r6.append(r7)     // Catch: java.lang.Throwable -> L1d
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L1d
            p031b7.C1120a.m6676e(r4, r6)     // Catch: java.lang.Throwable -> L1d
            r3 = 9000(0x2328, float:1.2612E-41)
            java.lang.String r2 = r5.toString()     // Catch: java.lang.Throwable -> L1d
            boolean r4 = r9.f59045j
            if (r4 == 0) goto L66
            goto L5d
        L94:
            boolean r6 = r4 instanceof com.huawei.cloud.base.http.C4616s     // Catch: java.lang.Throwable -> L4b
            if (r6 != 0) goto La1
            int r3 = p031b7.C1122c.m6845x0(r4)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r2 = r4.toString()     // Catch: java.lang.Throwable -> L1d
            goto Lac
        La1:
            r6 = r4
            com.huawei.cloud.base.http.s r6 = (com.huawei.cloud.base.http.C4616s) r6     // Catch: java.lang.Throwable -> L4b
            int r3 = p031b7.C1122c.m6806m0(r6, r3)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r2 = r4.toString()     // Catch: java.lang.Throwable -> L1d
        Lac:
            boolean r4 = r9.f59045j
            if (r4 == 0) goto L66
            goto L5d
        Lb1:
            java.lang.String r9 = ""
            return r9
        Lb4:
            boolean r5 = r9.f59045j
            if (r5 == 0) goto Lc1
            p6.s r5 = p546p6.C12106s.m72509c()
            p6.t r6 = p546p6.EnumC12107t.SHARE_CREATE_ALBUM
            r5.m72520l(r6)
        Lc1:
            android.os.Bundle r5 = r9.f59133f
            r5.putInt(r1, r3)
            android.os.Bundle r9 = r9.f59133f
            r9.putString(r0, r2)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p650t7.C12961e.mo77876l():java.lang.String");
    }

    @Override // p650t7.AbstractC12988v
    /* renamed from: m */
    public Bundle mo77877m() {
        List<GeneralAlbumData> list = this.f59042g;
        if (list == null || list.isEmpty()) {
            return super.mo77877m();
        }
        try {
            ArrayList parcelableArrayList = this.f59133f.getParcelableArrayList("AlbumUpdatedResultList");
            if (parcelableArrayList != null) {
                Iterator it = parcelableArrayList.iterator();
                while (it.hasNext()) {
                    AlbumUpdatedResult albumUpdatedResult = (AlbumUpdatedResult) it.next();
                    if (albumUpdatedResult.getErrCode() == 21 || albumUpdatedResult.getErrCode() == 4) {
                        SyncSessionManager.m15153t().m15177a("cloudphoto.album.batchcreate", this.f59044i, albumUpdatedResult.getAlbumId());
                    }
                }
            }
            return this.f59133f;
        } catch (Exception e10) {
            C1120a.m6676e("CreateAlbumExecutor", "CreateAlbumExecutor getResponseBundle Exception: " + e10);
            return this.f59133f;
        }
    }

    /* renamed from: q */
    public final void m77901q() throws Throwable {
        CloudPhotoBatch cloudPhotoBatchM83551h = this.f61708b.m83551h();
        int size = this.f59042g.size();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        int i10 = 0;
        for (int i11 = 0; i11 < this.f59042g.size(); i11++) {
            this.f61708b.m83547d().create(C13129a.m78960a(this.f59042g.get(i11)), "id").addHeader("x-hw-lock", (Object) C12106s.m72509c().m72512d(true).getSessionId()).addHeader("x-hw-trace-id", (Object) this.f59044i).queue(cloudPhotoBatchM83551h, new a(this.f59042g.get(i11), arrayList, arrayList2));
            i10++;
            if ((i10 % C1136q.d.m7148l() == 0 || size == i10) && cloudPhotoBatchM83551h.size() > 0) {
                cloudPhotoBatchM83551h.execute();
                cloudPhotoBatchM83551h = this.f61708b.m83551h();
                C0068f.m459d().m468l();
            }
        }
        if (arrayList2.size() > 0) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(new AlbumUpdatedResult(null, (String) it.next(), 0, null));
            }
        }
        C12734h.m76557A(arrayList, this.f59042g);
        this.f59133f.putParcelableArrayList("AlbumUpdatedResultList", arrayList);
    }

    /* renamed from: r */
    public final void m77902r() throws Exception {
        String str = "/Photoshare/" + this.f59043h.getShareName() + System.currentTimeMillis();
        this.f59043h.setShareId("md5" + C0227m.m1592e(str));
        Album albumM78961b = C13129a.m78961b(this.f59043h);
        albumM78961b.setLocalPath(str);
        Albums.Create createAddHeader = this.f61708b.m83547d().create(albumM78961b, "id").addHeader("x-hw-lock", (Object) C12106s.m72509c().m72513e(EnumC12107t.SHARE_CREATE_ALBUM, true).getSessionId()).addHeader("x-hw-trace-id", (Object) this.f59044i).addHeader("x-hw-options", (Object) "verifyDupName");
        createAddHeader.setRiskToken();
        Album albumExecute = createAddHeader.execute();
        String strM80971t0 = C13452e.m80781L().m80971t0();
        String strM80900d = C13452e.m80781L().m80900d();
        this.f59043h.setOwnerId(strM80971t0);
        this.f59043h.setOwnerAcc(strM80900d);
        C1120a.m6675d("CreateAlbumExecutor", "album:" + albumExecute.toString());
        this.f59043h.setShareId(albumExecute.getId());
        this.f59133f.putParcelable("ShareInfo", this.f59043h);
    }

    public C12961e(ShareAlbumData shareAlbumData) {
        this.f59043h = shareAlbumData;
    }
}
