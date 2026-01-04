package p255ed;

import android.text.TextUtils;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Asset;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Attachment;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.FailRet;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Record;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import java.io.IOException;
import java.util.List;
import p015ak.C0241z;
import p514o9.C11839m;

/* renamed from: ed.b */
/* loaded from: classes3.dex */
public class C9446b extends AbstractC9454j<Asset> {

    /* renamed from: a */
    public Record f47171a;

    /* renamed from: b */
    public String f47172b;

    /* renamed from: c */
    public List<Attachment> f47173c;

    /* renamed from: d */
    public List<FailRet> f47174d;

    public C9446b(Record record, String str, List<Attachment> list, List<FailRet> list2) {
        this.f47171a = record;
        this.f47172b = str;
        this.f47173c = list;
        this.f47174d = list2;
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
        C11839m.m70687e("BatchCreateAssetRevisionCallback", "syncV2 callback create asset revision fail, recordId: " + this.f47171a.getId() + ", usage = " + this.f47172b + ", errorCode: " + iIntValue + ", errMsg: " + error.getDescription());
        FailRet failRet = new FailRet();
        failRet.setRecordId(this.f47171a.getId());
        failRet.setUsage(this.f47172b);
        failRet.setErrCode(iIntValue);
        failRet.setErrMsg(error.getDescription());
        this.f47174d.add(failRet);
    }

    @Override // p369ii.InterfaceC10510a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Asset asset, C4609l c4609l) throws IOException {
        List<Attachment> attachments;
        DriveSyncUtil.m17985b0(1, c4609l);
        if (asset == null || (attachments = this.f47171a.getAttachments()) == null || attachments.size() <= 0) {
            return;
        }
        for (Attachment attachment : attachments) {
            if (TextUtils.equals(this.f47172b, attachment.getUsage())) {
                attachment.setAsset(asset);
                this.f47173c.add(attachment);
                return;
            }
        }
    }
}
