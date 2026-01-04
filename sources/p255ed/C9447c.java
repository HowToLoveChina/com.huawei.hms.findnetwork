package p255ed;

import android.text.TextUtils;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Asset;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Attachment;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.FailRet;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Resource;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p015ak.C0241z;
import p514o9.C11839m;

/* renamed from: ed.c */
/* loaded from: classes3.dex */
public class C9447c extends AbstractC9454j<Asset> {

    /* renamed from: a */
    public String f47175a;

    /* renamed from: b */
    public String f47176b;

    /* renamed from: c */
    public Map<String, List<Attachment>> f47177c;

    /* renamed from: d */
    public Map<String, List<Attachment>> f47178d;

    /* renamed from: e */
    public List<FailRet> f47179e;

    public C9447c(String str, String str2, Map<String, List<Attachment>> map, Map<String, List<Attachment>> map2, List<FailRet> list) {
        this.f47175a = str;
        this.f47176b = str2;
        this.f47177c = map;
        this.f47178d = map2;
        this.f47179e = list;
    }

    @Override // p255ed.AbstractC9454j
    /* renamed from: a */
    public void mo59231a(ErrorResp.Error error, C4609l c4609l) throws IOException {
        DriveSyncUtil.m17985b0(1, c4609l);
        int iIntValue = error.getCode().intValue();
        List<ErrorResp.ErrorMsg> errorDetail = error.getErrorDetail();
        if (errorDetail != null && !errorDetail.isEmpty()) {
            iIntValue = C0241z.m1685c(errorDetail.get(0).getErrorCode());
        }
        C11839m.m70687e("BatchCreateAssetRevisionSimpleCallback", "syncV2 callback create asset revision simple callback fail, recordId: " + this.f47175a + ", usage = " + this.f47176b + ", errorCode: " + iIntValue + ", errMsg: " + error.getDescription());
        FailRet failRet = new FailRet();
        failRet.setRecordId(this.f47175a);
        failRet.setUsage(this.f47176b);
        failRet.setErrCode(iIntValue);
        failRet.setErrMsg(error.getDescription());
        this.f47179e.add(failRet);
    }

    /* renamed from: c */
    public final void m59234c(Attachment attachment, Asset asset) {
        attachment.setAssetId(asset.getId());
        attachment.setAsset(asset);
        attachment.setVersionId(asset.getVersionId());
        Resource resource = asset.getResource();
        if (resource != null) {
            attachment.setLength(resource.getLength().longValue());
            attachment.setHash(resource.getHash());
            attachment.setSha256(resource.getSha256());
        }
    }

    @Override // p369ii.InterfaceC10510a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Asset asset, C4609l c4609l) throws IOException {
        DriveSyncUtil.m17985b0(1, c4609l);
        if (asset == null) {
            return;
        }
        List<Attachment> list = this.f47177c.get(this.f47175a);
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            Attachment attachment = new Attachment();
            m59234c(attachment, asset);
            arrayList.add(attachment);
            this.f47177c.put(this.f47175a, arrayList);
            return;
        }
        for (Attachment attachment2 : list) {
            if (TextUtils.equals(this.f47176b, attachment2.getUsage())) {
                m59234c(attachment2, asset);
                List<Attachment> list2 = this.f47178d.get(this.f47175a);
                if (list2 != null) {
                    list2.add(attachment2);
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(attachment2);
                this.f47178d.put(this.f47175a, arrayList2);
                return;
            }
        }
    }
}
