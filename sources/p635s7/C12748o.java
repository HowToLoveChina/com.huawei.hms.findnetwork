package p635s7;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.hicloud.album.service.hihttp.request.response.GetFileUrlsResponse;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.p171db.bean.ContentResource;
import gp.C10028c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p031b7.C1120a;
import p031b7.C1136q;
import p511o6.C11819a;
import p650t7.C12981o;
import p701v6.AbstractC13354a;
import p764x6.AbstractC13709a;
import p765x7.C13720b;

/* renamed from: s7.o */
/* loaded from: classes2.dex */
public class C12748o extends AbstractC13354a<GetFileUrlsResponse> {

    /* renamed from: k */
    public ArrayList<FileInfo> f58369k;

    /* renamed from: l */
    public int f58370l;

    /* renamed from: m */
    public boolean f58371m;

    /* renamed from: n */
    public CallbackHandler f58372n;

    /* renamed from: o */
    public String f58373o;

    /* renamed from: p */
    public int f58374p;

    /* renamed from: q */
    public JSONObject f58375q = new JSONObject();

    /* renamed from: r */
    public boolean f58376r;

    /* renamed from: s */
    public boolean f58377s;

    public C12748o(Context context, ArrayList<FileInfo> arrayList, int i10, boolean z10, String str, CallbackHandler callbackHandler, boolean z11) {
        this.f58370l = 2;
        this.f60186b = context;
        this.f58369k = arrayList;
        this.f58370l = i10;
        this.f58371m = z10;
        this.f60187c = m80109h(C13720b.m82484e());
        this.f60189e = str;
        this.f58372n = callbackHandler;
        this.f58377s = z11;
        if (arrayList.size() <= 0 || !arrayList.get(0).isMigratedData()) {
            this.f58376r = false;
            m80106e();
        } else {
            this.f58376r = true;
            m80107f();
        }
        m80114q(false);
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONArray jSONArray = new JSONArray();
        ArrayList<FileInfo> arrayList = this.f58369k;
        if (arrayList == null) {
            C1120a.m6676e("GetFileUrlsRequest", "null == fileInfoList");
            return;
        }
        Iterator<FileInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            FileInfo next = it.next();
            next.setNotEncrypted(C10028c.m62182c0().m62420y1());
            m76573u(next);
            jSONArray.put(m76572t(next));
        }
        this.f58375q.put("srcInfoList", jSONArray);
        this.f58375q.put("cmd", "cloudphoto.file.geturl");
        C1120a.m6675d("GetFileUrlsRequest", "cloudphoto.file.geturl");
        this.f60188d = this.f58375q.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a<GetFileUrlsResponse> mo14591n() {
        C12981o c12981o = new C12981o(this.f58369k, this.f58370l, this.f58377s, this.f58371m);
        c12981o.m82456i(this.f60189e);
        return c12981o;
    }

    /* renamed from: s */
    public final String m76571s(FileInfo fileInfo, int i10) {
        if (i10 == 0) {
            return fileInfo.getFileId();
        }
        if (i10 == 1) {
            String lcdFileId = fileInfo.getLcdFileId();
            if (!TextUtils.isEmpty(lcdFileId)) {
                return lcdFileId;
            }
            String fileId = fileInfo.getFileId();
            if (fileInfo.getFileType() != 4) {
                return fileId;
            }
            if (!TextUtils.isEmpty(fileInfo.getVideoThumbId())) {
                return fileInfo.getVideoThumbId();
            }
        } else {
            String thumbFileId = fileInfo.getThumbFileId();
            if (!TextUtils.isEmpty(thumbFileId)) {
                return thumbFileId;
            }
            String fileId2 = fileInfo.getFileId();
            if (fileInfo.getFileType() != 4) {
                return fileId2;
            }
            if (!TextUtils.isEmpty(fileInfo.getVideoThumbId())) {
                return fileInfo.getVideoThumbId();
            }
        }
        return "";
    }

    /* renamed from: t */
    public final JSONObject m76572t(FileInfo fileInfo) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (fileInfo == null) {
            C1120a.m6678w("GetFileUrlsRequest", "fileInfo is null");
            return jSONObject;
        }
        if (this.f58371m) {
            jSONObject.put("ownerId", fileInfo.getUserID());
            jSONObject.put("albumId", fileInfo.getShareId());
        } else if (fileInfo.getFileAttribute() == 1) {
            jSONObject.put("albumId", "default-album-3");
        } else {
            jSONObject.put("albumId", fileInfo.getAlbumId());
        }
        if (TextUtils.isEmpty(fileInfo.getUniqueId())) {
            jSONObject.put(HicloudH5ConfigManager.KEY_HASH, fileInfo.getHash());
        } else {
            jSONObject.put(ContentRecord.UNIQUE_ID, fileInfo.getUniqueId());
        }
        jSONObject.put("fileIdType", this.f58374p);
        jSONObject.put("fileId", this.f58373o);
        jSONObject.put(ContentResource.FILE_NAME, fileInfo.getFileName());
        return jSONObject;
    }

    /* renamed from: u */
    public final void m76573u(FileInfo fileInfo) throws JSONException {
        if (fileInfo == null) {
            C1120a.m6675d("GetFileUrlsRequest", " when initData fileInfo is null");
            return;
        }
        int i10 = this.f58370l;
        this.f58374p = i10;
        if (i10 == 0) {
            this.f58373o = fileInfo.getFileId();
        } else if (i10 == 1) {
            this.f58373o = fileInfo.getLcdFileId();
            m76576x(fileInfo);
        } else {
            this.f58373o = fileInfo.getThumbFileId();
            m76577y(fileInfo);
        }
    }

    /* renamed from: v */
    public int m76574v(ArrayList<FileInfo> arrayList, GetFileUrlsResponse getFileUrlsResponse, int i10) {
        if (this.f58376r) {
            return 0;
        }
        if (arrayList == null || getFileUrlsResponse == null) {
            return 101;
        }
        if (getFileUrlsResponse.getCode() == 401) {
            CallbackHandler callbackHandler = this.f58372n;
            if (callbackHandler != null) {
                callbackHandler.stInvalid(true);
            } else {
                C11819a.m70393a(true);
            }
            C1120a.m6676e("GetFileUrlsRequest", "getDownloadFileUrl fail, code: " + getFileUrlsResponse.getCode() + ", info: " + getFileUrlsResponse.getInfo());
            return getFileUrlsResponse.getCode();
        }
        Map urlList = getFileUrlsResponse.getUrlList();
        if (urlList == null || urlList.isEmpty()) {
            return 141;
        }
        Iterator<FileInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            FileInfo next = it.next();
            String strM76571s = m76571s(next, i10);
            if (urlList.get(strM76571s) != null) {
                String str = (String) urlList.get(strM76571s);
                if (i10 == 0) {
                    next.setFileUrl(str);
                } else {
                    next.setThumbUrl(str);
                }
            }
        }
        return 0;
    }

    /* renamed from: w */
    public final void m76575w(FileInfo fileInfo) {
        if (fileInfo == null) {
            C1120a.m6678w("GetFileUrlsRequest", "when setFileIdAndThumbType fileInfo is null");
            return;
        }
        if (fileInfo.getFileType() != 4 || TextUtils.isEmpty(fileInfo.getVideoThumbId())) {
            this.f58373o = fileInfo.getFileId();
            this.f58374p = 0;
        } else {
            this.f58373o = fileInfo.getVideoThumbId();
            this.f58374p = 3;
        }
    }

    /* renamed from: x */
    public final void m76576x(FileInfo fileInfo) throws JSONException {
        if (fileInfo == null) {
            C1120a.m6678w("GetFileUrlsRequest", "when setLcdData fileInfo is null");
        } else if (TextUtils.isEmpty(this.f58373o)) {
            m76575w(fileInfo);
            this.f58375q.put("width", C1136q.c.m7118a(this.f60186b).getLcdWidth());
            this.f58375q.put("height", C1136q.c.m7118a(this.f60186b).getLcdHeight());
        }
    }

    /* renamed from: y */
    public final void m76577y(FileInfo fileInfo) throws JSONException {
        if (fileInfo == null) {
            C1120a.m6678w("GetFileUrlsRequest", "when setThumbData fileInfo is null");
        } else if (TextUtils.isEmpty(this.f58373o)) {
            m76575w(fileInfo);
            this.f58375q.put("width", C1136q.c.m7118a(this.f60186b).getThumbWidth());
            this.f58375q.put("height", C1136q.c.m7118a(this.f60186b).getThumbHeight());
        }
    }
}
