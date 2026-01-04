package p255ed;

import com.huawei.android.hicloud.syncdrive.cloudsync.model.FailRet;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Record;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import java.util.List;
import p015ak.C0241z;
import p514o9.C11839m;
import p572qb.C12316j0;

/* renamed from: ed.g */
/* loaded from: classes3.dex */
public class C9451g extends AbstractC9454j<Record> {

    /* renamed from: a */
    public String f47192a;

    /* renamed from: b */
    public String f47193b;

    /* renamed from: c */
    public String f47194c;

    /* renamed from: d */
    public List<Record> f47195d;

    /* renamed from: e */
    public List<FailRet> f47196e;

    public C9451g(String str, String str2, String str3, List<Record> list, List<FailRet> list2) {
        this.f47192a = str;
        this.f47193b = str2;
        this.f47194c = str3;
        this.f47195d = list;
        this.f47196e = list2;
    }

    @Override // p255ed.AbstractC9454j
    /* renamed from: a */
    public void mo59231a(ErrorResp.Error error, C4609l c4609l) {
        int iIntValue = error.getCode().intValue();
        List<ErrorResp.ErrorMsg> errorDetail = error.getErrorDetail();
        if (errorDetail != null && !errorDetail.isEmpty()) {
            iIntValue = C0241z.m1685c(errorDetail.get(0).getErrorCode());
        }
        C11839m.m70687e("BatchUpdateCallback", "syncV2 callback update fail, recordId: " + this.f47194c + ", errorCode: " + iIntValue + ", errMsg: " + error.getDescription());
        FailRet failRet = new FailRet();
        failRet.setRecordId(this.f47194c);
        failRet.setErrCode(iIntValue);
        failRet.setErrMsg(error.getDescription());
        this.f47196e.add(failRet);
        C12316j0.m74076d().m74077a(this.f47192a, this.f47193b, this.f47194c, error.getCode().intValue());
    }

    @Override // p369ii.InterfaceC10510a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Record record, C4609l c4609l) {
        if (record == null) {
            C11839m.m70687e("BatchUpdateCallback", "record is null");
        } else {
            this.f47195d.add(record);
        }
    }
}
