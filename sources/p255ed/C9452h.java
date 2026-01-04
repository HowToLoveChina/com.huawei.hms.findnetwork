package p255ed;

import com.huawei.android.hicloud.syncdrive.cloudsync.model.FailRet;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Record;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import java.util.List;
import p015ak.C0241z;
import p514o9.C11839m;

/* renamed from: ed.h */
/* loaded from: classes3.dex */
public class C9452h extends AbstractC9454j<Record> {

    /* renamed from: a */
    public String f47197a;

    /* renamed from: b */
    public List<String> f47198b;

    /* renamed from: c */
    public List<FailRet> f47199c;

    public C9452h(String str, List<String> list, List<FailRet> list2) {
        this.f47197a = str;
        this.f47198b = list;
        this.f47199c = list2;
    }

    @Override // p255ed.AbstractC9454j
    /* renamed from: a */
    public void mo59231a(ErrorResp.Error error, C4609l c4609l) {
        int iIntValue = error.getCode().intValue();
        List<ErrorResp.ErrorMsg> errorDetail = error.getErrorDetail();
        if (errorDetail != null && !errorDetail.isEmpty()) {
            iIntValue = C0241z.m1685c(errorDetail.get(0).getErrorCode());
        }
        C11839m.m70687e("BatchUpdateCallback", "syncV2 callback update fail, recordId: " + this.f47197a + ", errorCode: " + iIntValue + ", errMsg: " + error.getDescription());
        FailRet failRet = new FailRet();
        failRet.setRecordId(this.f47197a);
        failRet.setErrCode(iIntValue);
        failRet.setErrMsg(error.getDescription());
        this.f47199c.add(failRet);
    }

    @Override // p369ii.InterfaceC10510a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Record record, C4609l c4609l) {
        if (record == null) {
            C11839m.m70687e("BatchUpdateCallback", "record is null");
        } else {
            this.f47198b.add(record.getId());
        }
    }
}
