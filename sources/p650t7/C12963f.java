package p650t7;

import android.os.Bundle;
import com.huawei.android.hicloud.album.service.p075vo.AlbumUpdatedResult;
import com.huawei.android.hicloud.album.service.p075vo.ShareAlbumData;
import com.huawei.android.hicloud.drive.cloudphoto.request.Albums;
import com.huawei.android.hicloud.drive.cloudphoto.request.CloudPhotoBatch;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import com.huawei.hms.api.ConnectionResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p009a8.C0068f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p546p6.C12106s;
import p546p6.EnumC12107t;
import p547p7.C12115c;
import p804ya.AbstractC13926c;

/* renamed from: t7.f */
/* loaded from: classes2.dex */
public class C12963f extends AbstractC12988v {

    /* renamed from: g */
    public List<String> f59049g;

    /* renamed from: h */
    public ShareAlbumData f59050h;

    /* renamed from: i */
    public boolean f59051i;

    /* renamed from: t7.f$a */
    public static class a extends AbstractC13926c<Void> {

        /* renamed from: a */
        public String f59052a;

        /* renamed from: b */
        public ArrayList<AlbumUpdatedResult> f59053b;

        /* renamed from: c */
        public List<String> f59054c;

        /* renamed from: d */
        public boolean f59055d;

        public a(String str, ArrayList<AlbumUpdatedResult> arrayList, List<String> list, boolean z10) {
            this.f59052a = str;
            this.f59053b = arrayList;
            this.f59054c = list;
            this.f59055d = z10;
        }

        @Override // p804ya.AbstractC13926c
        /* renamed from: a */
        public void mo74862a(ErrorResp.Error error, C4609l c4609l) {
            String description;
            if (this.f59055d && C1122c.m6684B1(error, "31084085")) {
                C1120a.m6676e("BatchDeleteAlbumCallback", "album.delete onFailure, sql retry");
                this.f59054c.add(this.f59052a);
                return;
            }
            Integer code = -1;
            if (error == null) {
                description = "error is null";
            } else {
                code = error.getCode();
                description = error.getDescription();
            }
            C1120a.m6676e("BatchDeleteAlbumCallback", "album.delete onFailure: " + code + ", info: " + description);
            if (404 == code.intValue()) {
                code = 0;
            }
            this.f59053b.add(new AlbumUpdatedResult("", this.f59052a, code.intValue(), description));
        }

        @Override // p369ii.InterfaceC10510a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r32, C4609l c4609l) {
            C1120a.m6675d("BatchDeleteAlbumCallback", "album.delete onSuccess: " + this.f59052a);
            this.f59053b.add(new AlbumUpdatedResult(null, this.f59052a, 0, null));
        }
    }

    public C12963f(List<String> list) {
        this.f59049g = list;
        this.f59051i = false;
    }

    @Override // p650t7.AbstractC12988v
    /* renamed from: l */
    public String mo77876l() throws Exception {
        ArrayList<AlbumUpdatedResult> arrayList;
        String string = "OK";
        this.f59133f = new Bundle();
        int iM6802l0 = 0;
        try {
            try {
                arrayList = new ArrayList<>();
                ArrayList arrayList2 = new ArrayList();
                m77905q(this.f59049g, arrayList, arrayList2, true);
                if (!arrayList2.isEmpty()) {
                    C1122c.m6816o2(3000L);
                    m77905q(arrayList2, arrayList, new ArrayList(), false);
                }
            } catch (IOException e10) {
                if (e10 instanceof C4616s) {
                    iM6802l0 = C1122c.m6802l0((C4616s) e10);
                    string = e10.toString();
                } else {
                    iM6802l0 = C1122c.m6845x0(e10);
                    string = e10.toString();
                }
            } catch (Exception e11) {
                C1120a.m6676e("DeleteAlbumsExecutor", "DeleteAlbumsExecutor runTask Exception: " + e11.toString());
                iM6802l0 = ConnectionResult.NETWORK_ERROR;
                string = e11.toString();
            }
            if (!this.f59051i) {
                this.f59133f.putParcelableArrayList("AlbumUpdatedResultList", arrayList);
                this.f59133f.putInt("code", iM6802l0);
                this.f59133f.putInt("Code", iM6802l0);
                this.f59133f.putString("info", string);
                return null;
            }
            this.f59133f.putInt("code", 0);
            this.f59133f.putString("info", "OK");
            this.f59133f.putParcelable("ShareInfo", this.f59050h);
            this.f59133f.putInt("code", 0);
            this.f59133f.putInt("Code", 0);
            this.f59133f.putString("info", "OK");
            return null;
        } catch (Throwable th2) {
            this.f59133f.putInt("code", 0);
            this.f59133f.putInt("Code", 0);
            this.f59133f.putString("info", "OK");
            throw th2;
        }
    }

    /* renamed from: q */
    public final void m77905q(List<String> list, ArrayList<AlbumUpdatedResult> arrayList, List<String> list2, boolean z10) throws Exception {
        String sessionId;
        int size = list.size();
        CloudPhotoBatch cloudPhotoBatchM83551h = this.f61708b.m83551h();
        if (this.f59051i) {
            this.f59133f.putParcelable("ShareInfo", this.f59050h);
            sessionId = C12106s.m72509c().m72513e(EnumC12107t.SHARE_SYNC_SDK, true).getSessionId();
        } else {
            sessionId = C12106s.m72509c().m72512d(true).getSessionId();
        }
        int i10 = 0;
        for (String str : list) {
            Albums.Delete deleteMode = this.f61708b.m83547d().delete(str).addHeader("x-hw-lock", (Object) sessionId).addHeader("x-hw-trace-id", (Object) this.f61710d).setDeleteMode(this.f59051i);
            boolean zM72569j = C12115c.m72560h().m72569j();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("DeleteAlbumsExecutor isGeneral: ");
            sb2.append(!this.f59051i);
            sb2.append(", isHideLost: ");
            sb2.append(!zM72569j);
            C1120a.m6677i("DeleteAlbumsExecutor", sb2.toString());
            if (!this.f59051i && !zM72569j) {
                deleteMode.addHeader("x-hw-options", (Object) "filterLost");
            }
            deleteMode.queue(cloudPhotoBatchM83551h, new a(str, arrayList, list2, z10));
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

    public C12963f(String str, ShareAlbumData shareAlbumData) {
        ArrayList arrayList = new ArrayList();
        this.f59049g = arrayList;
        arrayList.add(str);
        this.f59050h = shareAlbumData;
        this.f59051i = true;
    }
}
