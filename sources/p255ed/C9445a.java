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
import p572qb.C12316j0;

/* renamed from: ed.a */
/* loaded from: classes3.dex */
public class C9445a extends AbstractC9454j<Asset> {

    /* renamed from: a */
    public String f47165a;

    /* renamed from: b */
    public String f47166b;

    /* renamed from: c */
    public Record f47167c;

    /* renamed from: d */
    public String f47168d;

    /* renamed from: e */
    public List<Attachment> f47169e;

    /* renamed from: f */
    public List<FailRet> f47170f;

    public C9445a(String str, String str2, Record record, String str3, List<Attachment> list, List<FailRet> list2) {
        this.f47165a = str;
        this.f47166b = str2;
        this.f47167c = record;
        this.f47168d = str3;
        this.f47169e = list;
        this.f47170f = list2;
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
        C11839m.m70687e("BatchCreateAssetCallback", "syncV2 callback create asset fail, recordId: " + this.f47167c.getId() + ", usage = " + this.f47168d + ", errorCode: " + iIntValue + ", errMsg: " + error.getDescription());
        FailRet failRet = new FailRet();
        failRet.setRecordId(this.f47167c.getId());
        failRet.setUsage(this.f47168d);
        failRet.setErrCode(iIntValue);
        failRet.setErrMsg(error.getDescription());
        this.f47170f.add(failRet);
        C12316j0.m74076d().m74077a(this.f47165a, this.f47166b, this.f47167c.getId(), error.getCode().intValue());
    }

    @Override // p369ii.InterfaceC10510a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Asset asset, C4609l c4609l) throws IOException {
        DriveSyncUtil.m17985b0(1, c4609l);
        List<Attachment> attachments = this.f47167c.getAttachments();
        if (attachments == null || attachments.size() <= 0) {
            return;
        }
        for (Attachment attachment : attachments) {
            if (TextUtils.equals(attachment.getUsage(), this.f47168d)) {
                attachment.setAsset(asset);
                this.f47169e.add(attachment);
                return;
            }
        }
    }
}
