package p650t7;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.hihttp.request.response.BaseResponse;
import com.huawei.android.hicloud.album.service.hihttp.request.response.DisableStateResponse;
import com.huawei.android.hicloud.drive.cloudphoto.model.About;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.services.drive.DriveRequest;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.io.IOException;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;

/* renamed from: t7.h */
/* loaded from: classes2.dex */
public class C12967h extends AbstractC12988v<DisableStateResponse> {

    /* renamed from: g */
    public int f59072g;

    public C12967h(int i10) {
        this.f59072g = i10;
    }

    @Override // p650t7.AbstractC12988v
    /* renamed from: l */
    public String mo77876l() {
        int iM6802l0;
        String string;
        Bundle bundle = new Bundle();
        this.f59133f = bundle;
        bundle.putInt("DisableQueryType", this.f59072g);
        try {
            try {
                try {
                    DriveRequest<About> fields2 = this.f61708b.m83544a().get().setFields2("status");
                    fields2.getHeaders().set("x-hw-trace-id", this.f61710d);
                    About aboutExecute = fields2.execute();
                    C1120a.m6675d("DisableStateExecutor", "About: " + aboutExecute.toString());
                    About.Status status = aboutExecute.getStatus();
                    C4644l suspendTime = status.getSuspendTime();
                    C4644l deleteTime = status.getDeleteTime();
                    int iM77913r = m77913r(status.getSuspend());
                    C1136q.b.m6992B0(C0213f.m1377a(), iM77913r);
                    long jM28458c = 0;
                    C1136q.b.m7097s1(C0213f.m1377a(), iM77913r, deleteTime == null ? 0L : deleteTime.m28458c());
                    C1136q.b.m7024R0(C0213f.m1377a(), status.getCountdownDays() == null ? 0 : status.getCountdownDays().intValue());
                    this.f59133f.putInt("disableStatus", iM77913r);
                    Bundle bundle2 = this.f59133f;
                    if (suspendTime != null) {
                        jM28458c = suspendTime.m28458c();
                    }
                    bundle2.putLong("DisableTime", jM28458c);
                    this.f59133f.putInt("Remain", C1122c.m6683B0(C0213f.m1377a()));
                    return "";
                } catch (Exception e10) {
                    C1120a.m6676e("DisableStateExecutor", "DisableStateExecutor runTask Exception: " + e10.toString());
                    iM6802l0 = ConnectionResult.NETWORK_ERROR;
                    string = e10.toString();
                    this.f59133f.putInt("code", iM6802l0);
                    this.f59133f.putString("info", string);
                    return "";
                }
            } catch (IOException e11) {
                C1120a.m6676e("DisableStateExecutor", "DisableStateExecutor runTask IOException: " + e11.toString());
                if (e11 instanceof C4616s) {
                    iM6802l0 = C1122c.m6802l0((C4616s) e11);
                    string = e11.toString();
                } else {
                    iM6802l0 = C1122c.m6845x0(e11);
                    string = e11.toString();
                }
                this.f59133f.putInt("code", iM6802l0);
                this.f59133f.putString("info", string);
                return "";
            }
        } finally {
            this.f59133f.putInt("code", 0);
            this.f59133f.putString("info", "OK");
        }
    }

    @Override // p650t7.AbstractC12988v
    /* renamed from: q */
    public DisableStateResponse mo77904k(Class<BaseResponse> cls) {
        int iM6802l0;
        String string;
        C1120a.m6675d("DisableStateExecutor", "DisableStateResponse start");
        DisableStateResponse disableStateResponse = new DisableStateResponse();
        try {
            try {
                About aboutExecute = this.f61708b.m83544a().get().setFields2("status").execute();
                C1120a.m6675d("DisableStateExecutor", "About: " + aboutExecute.toString());
                About.Status status = aboutExecute.getStatus();
                int iM77913r = m77913r(status.getSuspend());
                C1120a.m6675d("DisableStateExecutor", "disableStatus:" + iM77913r);
                C1136q.b.m6992B0(C0213f.m1377a(), iM77913r);
                long jM28458c = 0;
                C1136q.b.m7097s1(C0213f.m1377a(), iM77913r, status.getDeleteTime() == null ? 0L : status.getDeleteTime().m28458c());
                C1136q.b.m7024R0(C0213f.m1377a(), status.getCountdownDays() == null ? 0 : status.getCountdownDays().intValue());
                disableStateResponse.setStatus(iM77913r);
                disableStateResponse.setDeleteTime(status.getDeleteTime() == null ? 0L : status.getDeleteTime().m28458c());
                if (status.getSuspendTime() != null) {
                    jM28458c = status.getSuspendTime().m28458c();
                }
                disableStateResponse.setDisableTime(jM28458c);
                disableStateResponse.setRemain(status.getCountdownDays() == null ? 0 : status.getCountdownDays().intValue());
            } catch (IOException e10) {
                C1120a.m6676e("DisableStateExecutor", "DisableStateExecutor runTask IOException: " + e10.toString());
                if (e10 instanceof C4616s) {
                    iM6802l0 = C1122c.m6802l0((C4616s) e10);
                    string = e10.toString();
                } else {
                    iM6802l0 = C1122c.m6845x0(e10);
                    string = e10.toString();
                }
                disableStateResponse.setCode(iM6802l0);
                disableStateResponse.setInfo(string);
                return disableStateResponse;
            } catch (Exception e11) {
                C1120a.m6676e("DisableStateExecutor", "DisableStateExecutor runTask Exception: " + e11.toString());
                iM6802l0 = ConnectionResult.NETWORK_ERROR;
                string = e11.toString();
                disableStateResponse.setCode(iM6802l0);
                disableStateResponse.setInfo(string);
                return disableStateResponse;
            }
            return disableStateResponse;
        } finally {
            disableStateResponse.setCode(0);
            disableStateResponse.setInfo("OK");
        }
    }

    /* renamed from: r */
    public final int m77913r(String str) {
        if (TextUtils.isEmpty(str) || !"disable".equals(str)) {
            return (TextUtils.isEmpty(str) || !FaqConstants.DISABLE_HA_REPORT.equals(str)) ? 0 : 1;
        }
        return -1;
    }
}
