package p650t7;

import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.p075vo.FileData;
import com.huawei.android.hicloud.drive.cloudphoto.model.Change;
import com.huawei.secure.android.common.util.SafeString;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import p031b7.C1120a;
import p547p7.C12113a;
import p547p7.C12114b;
import p547p7.C12115c;
import p649t6.C12945e;
import p649t6.C12946f;
import p671u7.C13130b;

/* renamed from: t7.m */
/* loaded from: classes2.dex */
public class C12977m extends AbstractC12988v {

    /* renamed from: g */
    public long f59103g;

    /* renamed from: h */
    public int f59104h;

    /* renamed from: i */
    public String f59105i;

    /* renamed from: j */
    public boolean f59106j;

    /* renamed from: m */
    public long f59109m = 0;

    /* renamed from: k */
    public C12946f f59107k = new C12946f();

    /* renamed from: l */
    public C12945e f59108l = new C12945e();

    public C12977m(long j10, int i10, String str, boolean z10) {
        this.f59103g = j10;
        this.f59104h = i10;
        this.f59105i = str;
        this.f59106j = z10;
    }

    /* renamed from: r */
    private String m77925r(String str, int i10) {
        return TextUtils.isEmpty(str) ? "" : str.length() > i10 ? SafeString.substring(str, str.length() - i10) : str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0285 A[Catch: all -> 0x0267, TRY_LEAVE, TryCatch #7 {all -> 0x0267, blocks: (B:57:0x023b, B:65:0x0269, B:67:0x0285, B:70:0x028e), top: B:84:0x0073 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x028e A[Catch: all -> 0x0267, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x0267, blocks: (B:57:0x023b, B:65:0x0269, B:67:0x0285, B:70:0x028e), top: B:84:0x0073 }] */
    /* JADX WARN: Type inference failed for: r0v32, types: [android.os.BaseBundle, android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r15v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v19, types: [int] */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v21 */
    /* JADX WARN: Type inference failed for: r15v23 */
    /* JADX WARN: Type inference failed for: r15v25 */
    /* JADX WARN: Type inference failed for: r15v26 */
    /* JADX WARN: Type inference failed for: r15v27 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v15, types: [android.os.BaseBundle, android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r1v17, types: [android.os.BaseBundle, android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r25v0, types: [t7.m, t7.v, x6.d] */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13, types: [com.huawei.android.hicloud.drive.cloudphoto.request.Changes] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.os.BaseBundle, android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r3v4, types: [android.os.BaseBundle, android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [int] */
    /* JADX WARN: Type inference failed for: r6v8, types: [int] */
    /* JADX WARN: Type inference failed for: r6v9, types: [int] */
    @Override // p650t7.AbstractC12988v
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String mo77876l() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 703
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p650t7.C12977m.mo77876l():java.lang.String");
    }

    /* renamed from: q */
    public final void m77926q(StringBuilder sb2, ArrayList<FileData> arrayList, long j10, List<Change> list) throws JSONException {
        ArrayList<C12114b> arrayList2 = new ArrayList<>();
        ArrayList<C12113a> arrayList3 = new ArrayList<>();
        boolean zM72569j = C12115c.m72560h().m72569j();
        for (Change change : list) {
            if (change != null) {
                if (C12115c.m72560h().m72574o(change, zM72569j)) {
                    C1120a.m6675d("GetChangedFilesExecutor", "hideMediaAtIncrementalSync, mediaId=" + change.getMediaId());
                    arrayList2.add(new C12114b(change));
                    arrayList3.add(new C12113a(change.getMedia()));
                } else {
                    FileData fileDataM78986o = C13130b.m78986o(change, j10);
                    if (fileDataM78986o != null && !TextUtils.isEmpty(fileDataM78986o.getAlbumId()) && fileDataM78986o.getAlbumId().startsWith("default-album-")) {
                        if (TextUtils.isEmpty(fileDataM78986o.getAlbumId()) || TextUtils.isEmpty(fileDataM78986o.getHash())) {
                            C1120a.m6678w("GetChangedFilesExecutor", "AlbumId of Hash is empty");
                        }
                        FileData fileData = new FileData(fileDataM78986o);
                        arrayList.add(fileData);
                        sb2.append(m77925r(fileData.getUniqueId(), 6));
                        sb2.append(",");
                    }
                }
            }
        }
        this.f59108l.m77770i(arrayList2);
        this.f59109m = arrayList2.size();
        this.f59107k.m77777j(arrayList3);
    }
}
