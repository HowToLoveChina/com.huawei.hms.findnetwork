package im;

import android.text.TextUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.hicloud.base.bean.Md5AndHash;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Asset;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.FileCreate;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Resource;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.RevisionRefresh;
import fk.C9721b;
import hm.C10321z;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p429kk.C11058a;
import p429kk.C11060c;
import p455ll.C11308a;
import p514o9.C11839m;
import p528oo.C11978b;
import p555po.C12201a;
import p709vj.C13452e;
import pl.C12159a;

/* renamed from: im.m */
/* loaded from: classes6.dex */
public class C10563m extends C10564n {

    /* renamed from: V */
    public int f50798V;

    /* renamed from: W */
    public boolean f50799W;

    /* renamed from: X */
    public String f50800X;

    /* renamed from: Y */
    public List<C12159a> f50801Y;

    /* renamed from: Z */
    public String f50802Z;

    /* renamed from: a0 */
    public String f50803a0;

    /* renamed from: b0 */
    public String f50804b0;

    /* renamed from: c0 */
    public String f50805c0;

    public C10563m(String str, int i10, String str2, C10321z c10321z, String str3, String str4, C4879a c4879a, File file, Map<String, String> map, boolean z10, int i11, boolean z11, String str5, List<C12159a> list, String str6, String str7, String str8) {
        super(str, i10, str2, c10321z, str3, str4, c4879a, file, map, z10, null, str8);
        ArrayList arrayList = new ArrayList();
        this.f50801Y = arrayList;
        this.f50798V = i11;
        this.f50800X = str5;
        arrayList.addAll(list);
        this.f50802Z = str6;
        this.f50803a0 = str7;
        this.f50799W = z11;
        this.f50805c0 = CloudBackupConstant.Command.PMS_OPTION_ONE_FILE;
    }

    @Override // im.C10564n
    /* renamed from: a0 */
    public FileCreate mo64787a0(String str, String str2, Md5AndHash md5AndHash, int i10) throws C9721b {
        FileCreate fileCreateMo64787a0 = super.mo64787a0(str, str2, md5AndHash, i10);
        int i11 = this.f50798V;
        if (i11 == 1) {
            fileCreateMo64787a0.setDivideType(Integer.valueOf(i11));
            fileCreateMo64787a0.setDivideSha256(this.f50800X);
        }
        return fileCreateMo64787a0;
    }

    @Override // im.C10564n
    /* renamed from: l0 */
    public void mo64788l0() throws C9721b {
        RevisionRefresh revisionRefresh = new RevisionRefresh();
        revisionRefresh.setCipher(this.f50755v);
        Asset assetM64735E = m64735E("id,state,resource(id,state),divideCheckUrl", this.f50805c0, this.f50747n, this.f50745l.m67895m(), this.f50745l.m67883a(), this.f50745l.m67898p(), revisionRefresh, this.f50798V, this.f50799W);
        Resource resource = assetM64735E.getResource();
        if (resource == null) {
            throw new C9721b(3911, "asset resource is empty", "Backup.asset.revisions.refresh");
        }
        if (resource.getState().intValue() != 0) {
            mo64709d();
            throw new C9721b(3911, "resource is invalid", "Backup.asset.revisions.refresh");
        }
        String divideCheckUrl = assetM64735E.getDivideCheckUrl();
        this.f50804b0 = divideCheckUrl;
        if (this.f50799W && TextUtils.isEmpty(divideCheckUrl)) {
            throw new C9721b(3911, "isDivideCheck true, divideCheckUrl is empty", "Backup.asset.revisions.refresh");
        }
    }

    /* renamed from: n0 */
    public final void m64789n0() throws C9721b {
        C11839m.m70688i("CloudBackupV3FileDiffUploader", "requestCheckDifferenceFile start");
        if (this.f50798V != 1) {
            C11839m.m70689w("CloudBackupV3FileDiffUploader", "requestCheckDifferenceFile exist, divideType = " + this.f50798V);
            return;
        }
        C12201a c12201a = new C12201a();
        c12201a.m73352a(this.f50803a0);
        c12201a.m73353b(this.f50809M);
        JsonArray jsonArray = new JsonArray();
        int i10 = 0;
        for (C12159a c12159a : this.f50801Y) {
            if (!TextUtils.isEmpty(c12159a.m72925v()) && c12159a.m72872H() != 1) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("fileId", c12159a.m72925v());
                jsonObject.addProperty("assetId", c12159a.m72896d());
                jsonObject.addProperty("versionId", c12159a.m72873I());
                if (c12159a.m72872H() == 0) {
                    jsonObject.addProperty("orderId", (Number) 0);
                } else if (c12159a.m72872H() == 2) {
                    jsonObject.addProperty("orderId", Integer.valueOf(c12159a.m72929z() + 1));
                }
                jsonArray.add(jsonObject);
                i10++;
            }
        }
        C11308a c11308a = this.f50745l;
        if (c11308a != null && !TextUtils.isEmpty(c11308a.m67895m())) {
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("fileId", this.f50745l.m67895m());
            jsonObject2.addProperty("assetId", this.f50745l.m67883a());
            jsonObject2.addProperty("versionId", this.f50745l.m67898p());
            jsonObject2.addProperty("orderId", Integer.valueOf(i10));
            jsonArray.add(jsonObject2);
        }
        c12201a.m73354c(jsonArray);
        C11060c c11060cM66626a = C11058a.m66626a(this.f50746m, "requestCheckDifferenceFile", C13452e.m80781L().m80971t0());
        if (C11978b.m72090a().m72093d(c11060cM66626a, c12201a, this.f50804b0)) {
            return;
        }
        C11839m.m70687e("CloudBackupV3FileDiffUploader", "requestCheckDifferenceFile result fail");
        throw new C9721b(3911, "requestCheckDifferenceFile fail" + c11060cM66626a.m66652h(), "/proxy/v1/differencefile/check");
    }

    @Override // im.C10564n, im.AbstractC10554e
    /* renamed from: w */
    public void mo64744w() throws C9721b {
        super.mo64744w();
        if (this.f50799W) {
            m64789n0();
        }
    }
}
