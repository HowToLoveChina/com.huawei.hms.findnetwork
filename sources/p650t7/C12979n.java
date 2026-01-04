package p650t7;

import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.p075vo.FailRet;
import com.huawei.android.hicloud.album.service.p075vo.FileData;
import com.huawei.android.hicloud.album.service.p075vo.SimplifyInfo;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import java.util.ArrayList;
import java.util.List;
import p031b7.C1120a;
import p031b7.C1136q;
import p671u7.C13130b;
import p804ya.AbstractC13926c;

/* renamed from: t7.n */
/* loaded from: classes2.dex */
public class C12979n extends AbstractC12988v {

    /* renamed from: g */
    public List<SimplifyInfo> f59110g;

    /* renamed from: h */
    public boolean f59111h;

    /* renamed from: i */
    public int f59112i = C1136q.d.m7148l();

    /* renamed from: t7.n$a */
    public static class a extends AbstractC13926c<Media> {

        /* renamed from: a */
        public String f59113a;

        /* renamed from: b */
        public ArrayList<FileData> f59114b;

        /* renamed from: c */
        public ArrayList<FailRet> f59115c;

        /* renamed from: d */
        public boolean f59116d;

        public a(String str, ArrayList<FileData> arrayList, ArrayList<FailRet> arrayList2, boolean z10) {
            this.f59113a = str;
            this.f59114b = arrayList;
            this.f59115c = arrayList2;
            this.f59116d = z10;
        }

        @Override // p804ya.AbstractC13926c
        /* renamed from: a */
        public void mo74862a(ErrorResp.Error error, C4609l c4609l) {
            FailRet failRet = new FailRet();
            failRet.setUniqueId(this.f59113a);
            failRet.setErrCode(error.getCode().intValue());
            failRet.setErrMsg(error.getDescription());
            this.f59115c.add(failRet);
        }

        @Override // p369ii.InterfaceC10510a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Media media, C4609l c4609l) {
            if (media == null) {
                C1120a.m6676e("BatchGetDetailCallback", "media is null");
                return;
            }
            C1120a.m6675d("BatchGetDetailCallback", "media: " + media.toString());
            FileData fileDataM78987p = C13130b.m78987p(media, this.f59116d);
            if (TextUtils.isEmpty(fileDataM78987p.getAlbumId()) || TextUtils.isEmpty(fileDataM78987p.getHash())) {
                C1120a.m6678w("BatchGetDetailCallback", "AlbumId of Hash is empty");
            }
            this.f59114b.add(fileDataM78987p);
        }
    }

    public C12979n(List<SimplifyInfo> list, boolean z10) {
        this.f59110g = list;
        this.f59111h = z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0236 A[Catch: all -> 0x0217, TRY_LEAVE, TryCatch #10 {all -> 0x0217, blocks: (B:66:0x01a1, B:81:0x021a, B:83:0x0236, B:86:0x023f), top: B:108:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x023f A[Catch: all -> 0x0217, TRY_ENTER, TRY_LEAVE, TryCatch #10 {all -> 0x0217, blocks: (B:66:0x01a1, B:81:0x021a, B:83:0x0236, B:86:0x023f), top: B:108:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02a1  */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.BaseBundle, android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r10v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v30 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [int] */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.os.BaseBundle, android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.StringBuilder] */
    @Override // p650t7.AbstractC12988v
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String mo77876l() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 744
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p650t7.C12979n.mo77876l():java.lang.String");
    }
}
