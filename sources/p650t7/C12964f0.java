package p650t7;

import android.os.Bundle;
import android.os.Parcelable;
import com.huawei.android.hicloud.album.service.p075vo.FileData;
import com.huawei.android.hicloud.album.service.p075vo.ShareFileUpdatedResult;
import com.huawei.android.hicloud.drive.cloudphoto.request.CloudPhotoBatch;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import com.huawei.hms.api.ConnectionResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p009a8.C0065c;
import p009a8.C0068f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p546p6.C12106s;
import p546p6.EnumC12107t;
import p804ya.AbstractC13926c;

/* renamed from: t7.f0 */
/* loaded from: classes2.dex */
public class C12964f0 extends AbstractC12988v {

    /* renamed from: g */
    public List<FileData> f59056g;

    /* renamed from: h */
    public String f59057h;

    /* renamed from: t7.f0$a */
    public static class a extends AbstractC13926c<Void> {

        /* renamed from: a */
        public FileData f59058a;

        /* renamed from: b */
        public ArrayList<ShareFileUpdatedResult> f59059b;

        public a(FileData fileData, ArrayList<ShareFileUpdatedResult> arrayList) {
            this.f59058a = fileData;
            this.f59059b = arrayList;
        }

        @Override // p804ya.AbstractC13926c
        /* renamed from: a */
        public void mo74862a(ErrorResp.Error error, C4609l c4609l) {
            Integer code = error.getCode();
            if (404 == code.intValue()) {
                C0065c.m432a().m434c(String.valueOf(code), this.f59058a.getFileId(), this.f59058a.getSize());
                code = 0;
            }
            this.f59059b.add(new ShareFileUpdatedResult(this.f59058a.getHash(), this.f59058a.getAlbumId(), this.f59058a.getUserID(), code.intValue(), error.getDescription()));
        }

        @Override // p369ii.InterfaceC10510a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r32, C4609l c4609l) {
            this.f59059b.add(new ShareFileUpdatedResult(this.f59058a.getHash(), this.f59058a.getAlbumId(), this.f59058a.getUserID()));
        }
    }

    public C12964f0(List<FileData> list, String str) {
        this.f59056g = list;
        this.f59057h = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v4, types: [android.os.BaseBundle, android.os.Bundle] */
    @Override // p650t7.AbstractC12988v
    /* renamed from: l */
    public String mo77876l() throws Exception {
        int iM6802l0;
        String string;
        String str = "code";
        this.f59133f = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        try {
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            try {
                CloudPhotoBatch cloudPhotoBatchM83551h = this.f61708b.m83551h();
                int size = this.f59056g.size();
                int i10 = 0;
                int i11 = 0;
                while (i10 < this.f59056g.size()) {
                    try {
                        this.f61708b.m83556m().delete(this.f59056g.get(i10).getUniqueId() != null ? this.f59056g.get(i10).getUniqueId() : this.f59056g.get(i10).getFileId()).addHeader("x-hw-media-owner-Id", (Object) this.f59057h).addHeader("x-hw-lock", (Object) C12106s.m72509c().m72513e(EnumC12107t.SHARE_SYNC_SDK, true).getSessionId()).addHeader("x-hw-trace-id", (Object) this.f61710d).queue(cloudPhotoBatchM83551h, new a(this.f59056g.get(i10), arrayList));
                        i11++;
                        if ((i11 % C1136q.d.m7148l() == 0 || size == i11) && cloudPhotoBatchM83551h.size() > 0) {
                            cloudPhotoBatchM83551h.execute();
                            cloudPhotoBatchM83551h = this.f61708b.m83551h();
                            C0068f.m459d().m468l();
                        }
                        i10++;
                    } catch (IOException e10) {
                        C1120a.m6676e("ShareFileDeleteExecutor", "getLockToken IOException: " + e10.toString());
                        while (i10 < this.f59056g.size()) {
                            FileData fileData = this.f59056g.get(i10);
                            arrayList.add(new ShareFileUpdatedResult(fileData.getHash(), fileData.getAlbumId(), fileData.getUserID(), 101, "get lock error"));
                            i10++;
                        }
                        throw e10;
                    } catch (Exception e11) {
                        C1120a.m6676e("ShareFileDeleteExecutor", "getLockToken Exception: " + e11.toString());
                        while (i10 < this.f59056g.size()) {
                            FileData fileData2 = this.f59056g.get(i10);
                            arrayList.add(new ShareFileUpdatedResult(fileData2.getHash(), fileData2.getAlbumId(), fileData2.getUserID(), 101, "get lock error"));
                            i10++;
                        }
                        throw e11;
                    }
                }
                this.f59133f.putInt("code", 0);
                this.f59133f.putString("info", "OK");
            } catch (IOException e12) {
                C1120a.m6676e("ShareFileDeleteExecutor", "ShareFileDeleteExecutor runTask IOException: " + e12.toString());
                if (e12 instanceof C4616s) {
                    iM6802l0 = C1122c.m6802l0((C4616s) e12);
                    string = e12.toString();
                } else {
                    iM6802l0 = C1122c.m6845x0(e12);
                    string = e12.toString();
                }
                this.f59133f.putInt("code", iM6802l0);
                str = this.f59133f;
                str.putString("info", string);
                this.f59133f.putParcelableArrayList("ShareFileUpdatedResult", arrayList);
                return "";
            } catch (Exception e13) {
                C1120a.m6676e("ShareFileDeleteExecutor", "ShareFileDeleteExecutor runTask Exception: " + e13.toString());
                iM6802l0 = ConnectionResult.NETWORK_ERROR;
                string = e13.toString();
                this.f59133f.putInt("code", iM6802l0);
                str = this.f59133f;
                str.putString("info", string);
                this.f59133f.putParcelableArrayList("ShareFileUpdatedResult", arrayList);
                return "";
            }
            this.f59133f.putParcelableArrayList("ShareFileUpdatedResult", arrayList);
            return "";
        } catch (Throwable th3) {
            th = th3;
            iM6802l0 = 0;
            this.f59133f.putInt(str, iM6802l0);
            this.f59133f.putString("info", "OK");
            this.f59133f.putParcelableArrayList("ShareFileUpdatedResult", arrayList);
            throw th;
        }
    }
}
