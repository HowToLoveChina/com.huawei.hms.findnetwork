package p764x6;

import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.drive.cloudphoto.model.Lock;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import fk.C9721b;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import p031b7.C1120a;
import p237du.C9310c;
import p709vj.C13452e;

/* renamed from: x6.i */
/* loaded from: classes2.dex */
public class C13717i extends AbstractC13712d<Lock> {
    /* renamed from: k */
    public final void m82457k() throws C9721b {
        if (this.f61708b == null) {
            throw new C9721b(4001, "drive has not been initialized");
        }
    }

    /* renamed from: l */
    public void m82458l(String str, String str2, boolean z10) throws JSONException, C9721b, IOException {
        m82457k();
        String strM15201z = SyncSessionManager.m15153t().m15201z();
        String strM15199x = SyncSessionManager.m15153t().m15199x();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("traceId", strM15201z);
            jSONObject.put("prepareTraceId", strM15199x);
            C1120a.m6677i("LockExecutor", "deleteExecute: traceId, prepareTraceId:" + strM15201z + "," + strM15199x);
        } catch (JSONException unused) {
            C1120a.m6676e("LockExecutor", "deleteExecute");
        }
        this.f61708b.m83554k().delete().addHeader("x-hw-lock", (Object) str).addHeader("x-hw-channel-Id", (Object) C9310c.m58618b(C13452e.m80781L().m80954p() + "10055832")).addHeader("x-hw-trace-id", (Object) str2).addHeader("x-hw-changes-notify", (Object) Boolean.valueOf(z10)).addHeader("x-hw-context", (Object) jSONObject.toString()).execute();
    }

    /* renamed from: m */
    public void m82459m(String str, String str2, boolean z10) throws C9721b, IOException {
        C1120a.m6677i("LockExecutor", "deleteExecuteAlbumClient");
        m82457k();
        this.f61708b.m83554k().delete().addHeader("x-hw-lock", (Object) str).addHeader("x-hw-channel-Id", (Object) C9310c.m58618b(C13452e.m80781L().m80954p() + "10055832")).addHeader("x-hw-3rdapp-packagename", (Object) "com.huawei.hidisk").addHeader("x-hw-3rdapp-version", (Object) "16.0.0.300").addHeader("x-hw-trace-id", (Object) str2).addHeader("x-hw-changes-notify", (Object) Boolean.valueOf(z10)).execute();
    }

    /* renamed from: n */
    public void m82460n(String str, String str2) throws C9721b, IOException {
        C1120a.m6677i("LockExecutor", "deleteExecuteRefund");
        m82457k();
        this.f61708b.m83554k().delete().addHeader("x-hw-lock", (Object) str).addHeader("x-hw-channel-Id", (Object) C9310c.m58618b(C13452e.m80781L().m80954p() + "10055832")).addHeader("x-hw-3rdapp-packagename", (Object) "com.huawei.hidisk.refund").addHeader("x-hw-3rdapp-version", (Object) "16.0.0.300").addHeader("x-hw-trace-id", (Object) str2).addHeader("x-hw-changes-notify", (Object) Boolean.TRUE).execute();
    }

    /* renamed from: o */
    public Lock m82461o(String str) throws C9721b, IOException {
        m82457k();
        return this.f61708b.m83554k().get().addHeader("x-hw-trace-id", (Object) str).addHeader("x-hw-changes-notify", (Object) Boolean.TRUE).setFields2("sessionId,lockInterval").execute();
    }

    /* renamed from: p */
    public Lock m82462p(String str) throws C9721b, IOException {
        C1120a.m6677i("LockExecutor", "executeAlbumClient");
        m82457k();
        return this.f61708b.m83554k().get().addHeader("x-hw-trace-id", (Object) str).addHeader("x-hw-3rdapp-packagename", (Object) "com.huawei.hidisk").addHeader("x-hw-3rdapp-version", (Object) "16.0.0.300").addHeader("x-hw-changes-notify", (Object) Boolean.TRUE).setFields2("sessionId,lockInterval").execute();
    }

    /* renamed from: q */
    public Lock m82463q(String str) throws C9721b, IOException {
        C1120a.m6677i("LockExecutor", "executeRefund");
        m82457k();
        return this.f61708b.m83554k().get().addHeader("x-hw-trace-id", (Object) str).addHeader("x-hw-3rdapp-packagename", (Object) "com.huawei.hidisk.refund").addHeader("x-hw-3rdapp-version", (Object) "16.0.0.300").addHeader("x-hw-changes-notify", (Object) Boolean.TRUE).setFields2("sessionId,lockInterval").execute();
    }

    /* renamed from: r */
    public void m82464r(String str, String str2) throws C9721b, IOException {
        C1120a.m6677i("LockExecutor", "getVFCExecute");
        m82457k();
        this.f61708b.m83554k().vfc().get(SyncProtocol.Constant.ADD, str, str2).execute();
    }

    /* renamed from: s */
    public Lock m82465s(String str, String str2) throws C9721b, IOException {
        m82457k();
        return this.f61708b.m83554k().get().addHeader("x-hw-lock", (Object) str).addHeader("x-hw-lock-renew", (Object) FaqConstants.DISABLE_HA_REPORT).addHeader("x-hw-trace-id", (Object) str2).execute();
    }

    /* renamed from: t */
    public Lock m82466t(String str, String str2) throws C9721b, IOException {
        C1120a.m6677i("LockExecutor", "keepExecuteAlbumClient");
        m82457k();
        return this.f61708b.m83554k().get().addHeader("x-hw-lock", (Object) str).addHeader("x-hw-lock-renew", (Object) FaqConstants.DISABLE_HA_REPORT).addHeader("x-hw-3rdapp-packagename", (Object) "com.huawei.hidisk").addHeader("x-hw-3rdapp-version", (Object) "16.0.0.300").addHeader("x-hw-trace-id", (Object) str2).execute();
    }

    /* renamed from: u */
    public Lock m82467u(String str, String str2) throws C9721b, IOException {
        C1120a.m6677i("LockExecutor", "keepExecuteRefund");
        m82457k();
        return this.f61708b.m83554k().get().addHeader("x-hw-lock", (Object) str).addHeader("x-hw-lock-renew", (Object) FaqConstants.DISABLE_HA_REPORT).addHeader("x-hw-3rdapp-packagename", (Object) "com.huawei.hidisk.refund").addHeader("x-hw-3rdapp-version", (Object) "16.0.0.300").addHeader("x-hw-trace-id", (Object) str2).execute();
    }
}
