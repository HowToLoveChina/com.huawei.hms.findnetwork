package p650t7;

import com.huawei.android.hicloud.album.service.hihttp.request.response.BaseResponse;
import com.huawei.android.hicloud.album.service.hihttp.request.response.GetFileUrlsResponse;
import com.huawei.android.hicloud.drive.cloudphoto.model.Asset;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.cloud.base.http.C4616s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import p031b7.C1120a;
import p031b7.C1122c;
import p804ya.C13927d;

/* renamed from: t7.o */
/* loaded from: classes2.dex */
public class C12981o extends AbstractC12988v<GetFileUrlsResponse> {

    /* renamed from: g */
    public ArrayList<FileInfo> f59119g;

    /* renamed from: h */
    public int f59120h;

    /* renamed from: i */
    public boolean f59121i;

    /* renamed from: j */
    public final boolean f59122j;

    public C12981o(ArrayList<FileInfo> arrayList, int i10, boolean z10, boolean z11) {
        this.f59119g = arrayList;
        this.f59120h = i10;
        this.f59121i = z10;
        this.f59122j = z11;
    }

    @Override // p650t7.AbstractC12988v
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public GetFileUrlsResponse mo77904k(Class<BaseResponse> cls) {
        int iM28322f;
        String string;
        GetFileUrlsResponse getFileUrlsResponse = new GetFileUrlsResponse();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        try {
            try {
                C13927d c13927d = new C13927d(this.f61710d);
                c13927d.m83587p(this.f59121i);
                c13927d.m83579h(this.f59119g, this.f59120h, map, map2, this.f59122j);
                Iterator<FileInfo> it = this.f59119g.iterator();
                while (it.hasNext()) {
                    FileInfo next = it.next();
                    if (next != null) {
                        String strM6814o0 = C1122c.m6814o0(next);
                        Asset asset = (Asset) map.get(strM6814o0);
                        String str = (String) map2.get(strM6814o0);
                        if (this.f59120h == 0) {
                            next.setFileUrl(str);
                        } else {
                            next.setThumbUrl(str);
                        }
                        next.setAsset(asset);
                    }
                }
                getFileUrlsResponse.setCode(0);
                getFileUrlsResponse.setInfo("OK");
            } catch (IOException e10) {
                C1120a.m6676e("GetFileUrlExecutor", "GetFileUrlExecutor run IOException: " + e10.toString());
                if (e10 instanceof C4616s) {
                    C4616s c4616s = (C4616s) e10;
                    iM28322f = c4616s.m28322f();
                    if (iM28322f != 404) {
                        iM28322f = C1122c.m6802l0(c4616s);
                    }
                    string = e10.toString();
                } else {
                    iM28322f = C1122c.m6845x0(e10);
                    string = e10.toString();
                }
                getFileUrlsResponse.setCode(iM28322f);
                getFileUrlsResponse.setInfo(string);
                return getFileUrlsResponse;
            } catch (Exception e11) {
                C1120a.m6676e("GetFileUrlExecutor", "GetFileUrlExecutor run Exception: " + e11.toString());
                iM28322f = 4001;
                string = e11.toString();
                getFileUrlsResponse.setCode(iM28322f);
                getFileUrlsResponse.setInfo(string);
                return getFileUrlsResponse;
            }
            return getFileUrlsResponse;
        } catch (Throwable th2) {
            getFileUrlsResponse.setCode(0);
            getFileUrlsResponse.setInfo("OK");
            throw th2;
        }
    }
}
