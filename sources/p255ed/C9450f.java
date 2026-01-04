package p255ed;

import com.huawei.android.hicloud.syncdrive.cloudsync.model.AssetList;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.FailRet;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p015ak.C0241z;
import p514o9.C11839m;

/* renamed from: ed.f */
/* loaded from: classes3.dex */
public class C9450f extends AbstractC9454j<AssetList> {

    /* renamed from: a */
    public String f47188a;

    /* renamed from: b */
    public String f47189b;

    /* renamed from: c */
    public Map<String, List<String>> f47190c;

    /* renamed from: d */
    public List<FailRet> f47191d;

    public C9450f(String str, String str2, Map<String, List<String>> map, List<FailRet> list) {
        this.f47188a = str;
        this.f47189b = str2;
        this.f47190c = map;
        this.f47191d = list;
    }

    @Override // p255ed.AbstractC9454j
    /* renamed from: a */
    public void mo59231a(ErrorResp.Error error, C4609l c4609l) throws IOException {
        int iIntValue = error.getCode().intValue();
        List<ErrorResp.ErrorMsg> errorDetail = error.getErrorDetail();
        if (errorDetail != null && !errorDetail.isEmpty()) {
            iIntValue = C0241z.m1685c(errorDetail.get(0).getErrorCode());
        }
        C11839m.m70687e("BatchDeleteAssetCallBack2", "syncV2 callback delete asset fail, recordId: " + this.f47188a + ", usage = " + this.f47189b + ", errorCode: " + iIntValue + ", errMsg: " + error.getDescription());
        FailRet failRet = new FailRet();
        failRet.setRecordId(this.f47188a);
        failRet.setUsage(this.f47189b);
        failRet.setErrCode(iIntValue);
        failRet.setErrMsg(error.getDescription());
        this.f47191d.add(failRet);
    }

    @Override // p369ii.InterfaceC10510a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onSuccess(AssetList assetList, C4609l c4609l) throws IOException {
        if (!this.f47190c.containsKey(this.f47188a)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f47189b);
            this.f47190c.put(this.f47188a, arrayList);
            return;
        }
        List<String> list = this.f47190c.get(this.f47188a);
        if (list == null || list.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(this.f47189b);
            this.f47190c.put(this.f47188a, arrayList2);
        } else {
            if (list.contains(this.f47189b)) {
                return;
            }
            list.add(this.f47189b);
        }
    }
}
