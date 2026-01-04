package p650t7;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.hihttp.request.response.BaseResponse;
import com.huawei.android.hicloud.album.service.hihttp.request.response.FileCreateResponse;
import com.huawei.android.hicloud.album.service.utils.CompressUtil;
import com.huawei.android.hicloud.drive.cloudphoto.CloudPhotoMediaUploaderProgressListener;
import com.huawei.android.hicloud.drive.cloudphoto.model.CompressInfo;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import fk.C9721b;
import hk.C10278a;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import p015ak.C0209d;
import p015ak.C0213f;
import p031b7.C1122c;
import p546p6.C12106s;
import p546p6.EnumC12107t;
import p671u7.C13130b;
import p709vj.C13452e;
import p804ya.C13928e;

/* renamed from: t7.j */
/* loaded from: classes2.dex */
public class C12971j extends AbstractC12988v<FileCreateResponse> {

    /* renamed from: g */
    public FileInfo f59081g;

    /* renamed from: h */
    public C13928e f59082h;

    /* renamed from: i */
    public CloudPhotoMediaUploaderProgressListener f59083i;

    /* renamed from: j */
    public LinkedHashMap<String, String> f59084j;

    public C12971j(FileInfo fileInfo, LinkedHashMap<String, String> linkedHashMap) {
        this.f59081g = fileInfo;
        this.f59084j = linkedHashMap;
    }

    @Override // p650t7.AbstractC12988v
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public FileCreateResponse mo77904k(Class<BaseResponse> cls) throws Exception {
        String string;
        HashMap<String, CompressInfo> mapM15280b = CompressUtil.m15280b(this.f59081g, this.f59084j, this.f61710d);
        FileCreateResponse fileCreateResponse = new FileCreateResponse();
        int iM6845x0 = 1;
        try {
            try {
                try {
                    this.f59082h = new C13928e(this.f61710d, C13130b.m78972a(this.f59081g, m77919r()), C10278a.m63442h(this.f59081g.getLocalRealPath()), C10278a.m63442h(this.f59081g.getLocalThumbPath()), C10278a.m63442h(this.f59081g.getLocalBigThumbPath()), mapM15280b);
                    if (TextUtils.isEmpty(this.f59081g.getShareId())) {
                        this.f59082h.m83612K(true);
                    } else {
                        C12106s.m72509c().m72513e(EnumC12107t.SHARE_SYNC_SDK, true);
                    }
                    HashMap<String, String> map = new HashMap<>();
                    String albumId = TextUtils.isEmpty(this.f59081g.getShareId()) ? this.f59081g.getAlbumId() : this.f59081g.getShareId();
                    Context contextM1377a = C0213f.m1377a();
                    map.put("thumbType", "0");
                    String lpath = this.f59081g.getLpath();
                    if (TextUtils.isEmpty(lpath)) {
                        lpath = this.f59081g.getFileUploadType();
                    }
                    map.put("fileUnique", "" + albumId + "_" + lpath + "/" + this.f59081g.getFileName());
                    map.put("battery", C1122c.m6748X(contextM1377a));
                    map.put("screen", C1122c.m6725P0(contextM1377a));
                    map.put("mobile_network", C1122c.m6851z0(contextM1377a));
                    map.put(HiAnalyticsConstant.BI_KEY_NET_TYPE, String.valueOf(C0209d.m1225Y(C0213f.m1377a())));
                    map.put("galleryVersion", C1122c.m6833t0(contextM1377a));
                    map.put("fileType", String.valueOf(this.f59081g.getFileType()));
                    map.put("dataVer", "2.0");
                    this.f59082h.m83613L(this.f59081g.getUserID());
                    this.f59082h.m83614M(this.f59083i);
                    Media mediaM83615N = this.f59082h.m83615N(map);
                    fileCreateResponse.setFileName(mediaM83615N.getFileName());
                    fileCreateResponse.setSdsctime(C1122c.m6721O(mediaM83615N.getEditedTime().m28458c()));
                    fileCreateResponse.setUniqueId(mediaM83615N.getId());
                    iM6845x0 = 0;
                    string = "OK";
                } catch (IOException e10) {
                    iM6845x0 = !(e10 instanceof C4616s) ? C1122c.m6845x0(e10) : C1122c.m6802l0((C4616s) e10);
                    string = e10.toString();
                }
            } catch (C9721b e11) {
                String strM60660d = e11.m60660d();
                iM6845x0 = "31084932".equals(strM60660d) ? 6 : "31084039".equals(strM60660d) ? 206 : "31084906".equals(strM60660d) ? 8 : ("31004933".equals(strM60660d) || "31004939".equals(strM60660d)) ? 30 : e11.m60663g() != 0 ? e11.m60663g() : e11.m60659c();
                string = e11.getMessage();
            }
            fileCreateResponse.setCode(iM6845x0);
            fileCreateResponse.setInfo(string);
            return fileCreateResponse;
        } catch (Throwable th2) {
            fileCreateResponse.setCode(iM6845x0);
            fileCreateResponse.setInfo("Fail");
            throw th2;
        }
    }

    /* renamed from: r */
    public final boolean m77919r() {
        String strM80971t0 = C13452e.m80781L().m80971t0();
        if (TextUtils.isEmpty(strM80971t0) || TextUtils.isEmpty(this.f59081g.getUserID())) {
            return true;
        }
        return strM80971t0.equals(this.f59081g.getUserID());
    }

    /* renamed from: s */
    public void m77920s(CloudPhotoMediaUploaderProgressListener cloudPhotoMediaUploaderProgressListener) {
        this.f59083i = cloudPhotoMediaUploaderProgressListener;
    }
}
