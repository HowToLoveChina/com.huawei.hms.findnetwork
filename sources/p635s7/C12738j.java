package p635s7;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.hihttp.request.response.FileCreateResponse;
import com.huawei.android.hicloud.drive.cloudphoto.CloudPhotoMediaUploaderProgressListener;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import com.huawei.openalliance.p169ad.p171db.bean.ContentResource;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import org.json.JSONObject;
import p031b7.C1120a;
import p031b7.C1122c;
import p650t7.C12971j;
import p701v6.AbstractC13354a;
import p764x6.AbstractC13709a;
import p765x7.C13720b;

/* renamed from: s7.j */
/* loaded from: classes2.dex */
public class C12738j extends AbstractC13354a<FileCreateResponse> {

    /* renamed from: k */
    public FileInfo f58335k;

    /* renamed from: l */
    public String f58336l;

    /* renamed from: m */
    public String f58337m;

    /* renamed from: n */
    public LinkedHashMap<String, String> f58338n;

    /* renamed from: o */
    public CloudPhotoMediaUploaderProgressListener f58339o;

    public C12738j(FileInfo fileInfo, String str, String str2, String str3, Context context, String str4, LinkedHashMap<String, String> linkedHashMap) {
        this.f58335k = fileInfo;
        m76566s(str);
        this.f58336l = str2;
        this.f58337m = str3;
        this.f60186b = context;
        this.f60187c = m80109h(C13720b.m82484e());
        this.f60189e = str4;
        this.f58338n = linkedHashMap;
        if (fileInfo != null) {
            if (fileInfo.isMigratedData()) {
                m80107f();
            } else {
                m80106e();
            }
        }
    }

    /* renamed from: s */
    private void m76566s(String str) {
        if (this.f60191g == null) {
            this.f60191g = new Hashtable();
        }
        if (str == null) {
            C1120a.m6675d("FileCreateRequest", "setHeaderLockToken lockToken is null, may be share file!");
        } else {
            this.f60190f = str;
            this.f60191g.put("Lock-Token", str);
        }
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        FileInfo fileInfo = this.f58335k;
        if (fileInfo == null) {
            return;
        }
        jSONObject.put("fileId", fileInfo.getFileId());
        jSONObject.put("lcdFileId", this.f58335k.getLcdFileId());
        jSONObject.put("thumbFileId", this.f58335k.getThumbFileId());
        if (!TextUtils.isEmpty(this.f58335k.getVideoThumbId())) {
            jSONObject.put("videoThumbId", this.f58335k.getVideoThumbId());
        }
        jSONObject.put(ContentResource.FILE_NAME, this.f58335k.getFileName());
        jSONObject.put("createTime", this.f58335k.getCreateTime());
        jSONObject.put("albumId", this.f58335k.getAlbumId());
        jSONObject.put(HicloudH5ConfigManager.KEY_HASH, this.f58335k.getHash());
        jSONObject.put("size", this.f58335k.getSize());
        jSONObject.put("source", this.f58335k.getSource());
        jSONObject.put("fileType", this.f58335k.getFileType());
        if (this.f58335k.isFavorite()) {
            jSONObject.put("favorite", this.f58335k.isFavorite());
        }
        if (!TextUtils.isEmpty(this.f58335k.getExpand())) {
            JSONObject jSONObject3 = new JSONObject(this.f58335k.getExpand());
            jSONObject3.remove("fileRepeatList");
            jSONObject.put("expand", jSONObject3);
        }
        jSONObject2.put("fileInfo", jSONObject);
        String str = this.f58336l;
        if (str != null) {
            jSONObject2.put("signature", str);
        }
        if (!TextUtils.isEmpty(this.f58335k.getUserID())) {
            jSONObject2.put("ownerId", this.f58335k.getUserID());
        }
        jSONObject2.put("galleryVer", C1122c.m6833t0(this.f60186b));
        if (CloudAlbumSettings.m14363h().m14377m()) {
            jSONObject2.put(SyncProtocol.Constant.STR_GUID, this.f58337m);
            jSONObject2.put(SyncProtocol.Constant.UNSTR_GUID, this.f58337m);
            jSONObject2.put(SyncProtocol.Constant.STR_DATA_VER, "1");
            jSONObject2.put(SyncProtocol.Constant.UNSTR_DATA_VER, "1");
        }
        jSONObject2.put("cmd", "cloudphoto.file.create");
        C1120a.m6675d("FileCreateRequest", "cloudphoto.file.create");
        this.f60188d = jSONObject2.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a<FileCreateResponse> mo14591n() {
        C12971j c12971j = new C12971j(this.f58335k, this.f58338n);
        c12971j.m82456i(this.f60189e);
        c12971j.m77920s(this.f58339o);
        return c12971j;
    }

    /* renamed from: t */
    public void m76567t(CloudPhotoMediaUploaderProgressListener cloudPhotoMediaUploaderProgressListener) {
        this.f58339o = cloudPhotoMediaUploaderProgressListener;
    }
}
