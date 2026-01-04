package p814yl;

import ck.C1443a;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Server;
import com.huawei.hicloud.cloudbackup.p104v3.server.batch.CloudBackupV3BatchCallback;
import com.huawei.hicloud.cloudbackup.p104v3.server.batch.CloudBackupV3BatchRequest;
import com.huawei.hicloud.dnskpr.DnsKprUtil;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.util.CheckAppStatus;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import fk.C9721b;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.List;
import javax.net.ssl.SSLException;
import p015ak.C0213f;
import p015ak.C0237v;
import p015ak.C0241z;
import p336he.C10156g;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p523oi.C11903a;
import p583qm.C12378f;
import p618rm.C12540b1;
import p709vj.C13452e;
import p712vm.C13468a;
import p746wn.C13622a;
import tm.C13040c;
import vi.C13446a;

/* renamed from: yl.c0 */
/* loaded from: classes6.dex */
public class C14000c0<T> {

    /* renamed from: a */
    public a<T> f62718a;

    /* renamed from: b */
    public ErrorResp.Error f62719b;

    /* renamed from: c */
    public String f62720c;

    /* renamed from: d */
    public C4609l f62721d;

    /* renamed from: yl.c0$a */
    public interface a<T> {
        /* renamed from: a */
        CloudBackupV3Request<T> mo1697a(CloudBackupV3Server cloudBackupV3Server) throws IOException;
    }

    public C14000c0(a<T> aVar) {
        this.f62718a = aVar;
    }

    /* renamed from: a */
    public final T m84138a(CloudBackupV3Server cloudBackupV3Server, String str, String str2, int i10) throws C9721b {
        try {
            CloudBackupV3Request<T> cloudBackupV3RequestMo1697a = this.f62718a.mo1697a(cloudBackupV3Server);
            this.f62720c = cloudBackupV3RequestMo1697a.getRequestUrl();
            C10156g.m63309f(cloudBackupV3RequestMo1697a);
            T tExecute = cloudBackupV3RequestMo1697a.setTraceId(str2).setHeader("x-hw-cmd", str).execute();
            C4609l lastResponseHeaders = cloudBackupV3RequestMo1697a.getLastResponseHeaders();
            this.f62721d = lastResponseHeaders;
            C10156g.m63310g(lastResponseHeaders);
            if (C1443a.f6214b.booleanValue()) {
                C11839m.m70688i("CloudBackupV3Request", "cloud backupV3 server request:,traceId" + str2 + "  " + C12540b1.m75485c(cloudBackupV3RequestMo1697a));
                C11839m.m70688i("CloudBackupV3Request", "cloud backupV3 server request getHeaders: ,traceId" + str2 + "  " + C12540b1.m75485c(cloudBackupV3RequestMo1697a.getHeaders()));
                C11839m.m70688i("CloudBackupV3Request", "cloud backupV3 server response:,traceId" + str2 + "response:" + C12540b1.m75485c(tExecute));
            }
            return tExecute;
        } catch (C4616s e10) {
            int iM28322f = e10.m28322f();
            int i11 = i10 + 1;
            if (m84145h(iM28322f, i10)) {
                return m84138a(cloudBackupV3Server, str, str2, i11);
            }
            String strM28319c = e10.m28319c();
            C11839m.m70687e("CloudBackupV3Request", strM28319c);
            throw m84147j(iM28322f, strM28319c, str);
        } catch (IOException e11) {
            C11839m.m70687e("CloudBackupV3Request", "cloud backupV3 server execute IOException");
            if ((e11 instanceof C13446a) && !DnsKprUtil.m29898g()) {
                C11839m.m70687e("CloudBackupV3Request", "start forceExpire");
                C13040c.m78609F().m78651i();
                C13452e.m80781L().m80988x1("from_sysConfRefresh");
            }
            C11839m.m70687e("CloudBackupV3Request", e11.getMessage());
            throw new C9721b(m84141d(e11), e11.getMessage(), str);
        } catch (Exception e12) {
            C11839m.m70687e("CloudBackupV3Request", e12.getMessage());
            throw new C9721b(3912, e12.getMessage(), str);
        }
    }

    /* renamed from: b */
    public T m84139b(String str, String str2) throws C9721b {
        new CheckAppStatus().checkAllSendToFile();
        CloudBackupV3Server cloudBackupV3ServerM84037d = C13997b.m84034f().m84037d();
        if (cloudBackupV3ServerM84037d == null) {
            throw new C9721b(4001, "cloud backup client init error.");
        }
        C9721b e10 = null;
        try {
            try {
                return m84138a(cloudBackupV3ServerM84037d, str, str2, 0);
            } catch (C9721b e11) {
                e10 = e11;
                throw e10;
            }
        } finally {
            m84144g(e10, str, str2);
        }
    }

    /* renamed from: c */
    public ErrorResp.Error m84140c() {
        return this.f62719b;
    }

    /* renamed from: d */
    public final int m84141d(IOException iOException) {
        if (iOException instanceof C12378f) {
            return 3900;
        }
        if (iOException instanceof MalformedURLException) {
            return 3901;
        }
        if (iOException instanceof SocketTimeoutException) {
            return 3902;
        }
        if (iOException instanceof UnknownHostException) {
            return 3903;
        }
        if (iOException instanceof NoRouteToHostException) {
            return 3904;
        }
        if (iOException instanceof ProtocolException) {
            return 3905;
        }
        if (iOException instanceof SSLException) {
            return 3906;
        }
        if (iOException instanceof SocketException) {
            return 3907;
        }
        if (iOException instanceof InterruptedIOException) {
            return 3908;
        }
        return iOException instanceof C13446a ? 3938 : 3909;
    }

    /* renamed from: e */
    public C4609l m84142e() {
        return this.f62721d;
    }

    /* renamed from: f */
    public void m84143f(CloudBackupV3BatchRequest cloudBackupV3BatchRequest, CloudBackupV3BatchCallback<T> cloudBackupV3BatchCallback) throws C9721b {
        new CheckAppStatus().checkAllSendToFile();
        CloudBackupV3Server cloudBackupV3ServerM84037d = C13997b.m84034f().m84037d();
        if (cloudBackupV3ServerM84037d == null) {
            throw new C9721b(4001, "cloud backup client init error.");
        }
        try {
            this.f62718a.mo1697a(cloudBackupV3ServerM84037d).queue(cloudBackupV3BatchRequest, cloudBackupV3BatchCallback);
        } catch (C4616s e10) {
            int iM28322f = e10.m28322f();
            String strM28319c = e10.m28319c();
            C11839m.m70687e("CloudBackupV3Request", strM28319c);
            throw m84147j(iM28322f, strM28319c, "batch");
        } catch (IOException e11) {
            C11839m.m70687e("CloudBackupV3Request", e11.getMessage());
            throw new C9721b(m84141d(e11), e11.getMessage(), "batch");
        } catch (Exception e12) {
            C11839m.m70687e("CloudBackupV3Request", e12.getMessage());
            throw new C9721b(3912, e12.getMessage(), "batch");
        }
    }

    /* renamed from: g */
    public final void m84144g(C9721b c9721b, String str, String str2) {
        if (c9721b != null) {
            C11060c c11060cM66626a = C11058a.m66626a(str2, str, C13452e.m80781L().m80971t0());
            String str3 = this.f62720c;
            if (str3 == null) {
                str3 = "";
            }
            c11060cM66626a.m66667w(str3);
            c11060cM66626a.m66665u("102_" + c9721b.m60659c());
            c11060cM66626a.m66635A(str + " ," + c9721b.getMessage());
            C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
        }
    }

    /* renamed from: h */
    public final boolean m84145h(int i10, int i11) {
        return i11 < 1 && i10 == 504;
    }

    /* renamed from: i */
    public final C9721b m84146i(int i10, int i11, ErrorResp.ErrorMsg errorMsg, String str) {
        String errorCode;
        if (errorMsg != null && (errorCode = errorMsg.getErrorCode()) != null) {
            if (i10 == 429 && errorCode.endsWith(String.valueOf(4293))) {
                return "Backup.Lock.vbackup.get".equals(str) ? new C9721b(SNSCode.Status.GET_FRIEND_LIST_FAIL, errorMsg.toString(), str) : new C9721b(SNSCode.Status.GET_FRIEND_LIST_FAIL, "flow control", "cbs");
            }
            if (i10 == 429 && errorCode.endsWith(String.valueOf(4295))) {
                return new C9721b(3934, errorMsg.toString(), str);
            }
            if (i10 == 503 && errorCode.endsWith(String.valueOf(5031))) {
                return new C9721b(SNSCode.Status.GET_FRIEND_LIST_FAIL, "flow control", "nsp");
            }
            if (errorCode.endsWith(String.valueOf(4039))) {
                C0237v.m1661c();
                return new C9721b("2", SNSCode.Status.HWID_UNLOGIN, this.f62719b.toString(), str);
            }
            if (i10 == 400 && errorCode.endsWith(String.valueOf(4908))) {
                return new C9721b(3926, 4908, "user cipher invalid.");
            }
            if (i10 == 403) {
                if (errorCode.endsWith(String.valueOf(4080))) {
                    return new C9721b(3939, errorCode, "user free times not enough.");
                }
                if (errorCode.endsWith(String.valueOf(4081))) {
                    return new C9721b(3940, errorCode, "server free times not enough.");
                }
            }
            if (i10 == 403 && errorCode.endsWith(String.valueOf(4948))) {
                return new C9721b(3924, 4948, "uid not match.");
            }
            if (i10 == 403 && errorCode.endsWith(String.valueOf(4980))) {
                return new C9721b(3924, 4980, "server source not match.");
            }
            if (i10 == 403 && errorCode.endsWith(String.valueOf(4061))) {
                return new C9721b(3928, 4061, "second refurbish backup invalid");
            }
            if (i10 == 404 && errorCode.endsWith(String.valueOf(51000404))) {
                return new C9721b(3925, 51000404, "server request invalid.");
            }
            if (i10 == 400 && errorCode.endsWith(String.valueOf(51094004))) {
                return new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, 51094004, "keep lock error, token lock lost.");
            }
            if (i10 == 409 && errorCode.endsWith(String.valueOf(4094))) {
                return new C9721b(3935, 4094, (String) errorMsg.get("retryParams"));
            }
            if (i10 == 403 && errorCode.endsWith(String.valueOf(51004988))) {
                return new C9721b(3937, 51004988, "full service data not allowed uplod for free user");
            }
            String description = (i11 == 1201 || i11 == 1101) ? errorMsg.getDescription() : this.f62719b.toString();
            if (i11 == 1201 && !C13468a.m81100c().m81101b()) {
                C11839m.m70687e("CloudBackupV3Request", description + " network disable.");
                i11 = 3900;
            }
            return new C9721b(i11, C0241z.m1685c(errorCode), description, str);
        }
        return new C9721b(i11, this.f62719b.toString(), str);
    }

    /* renamed from: j */
    public final C9721b m84147j(int i10, String str, String str2) {
        try {
            ErrorResp.Error error = ((ErrorResp) C11903a.m71435l().mo69832e(str).m69886u(ErrorResp.class)).getError();
            this.f62719b = error;
            if (error == null) {
                return new C9721b(3911, str, str2);
            }
            int i11 = i10 == 401 ? 1201 : 3911;
            if (i10 == 402) {
                i11 = 1101;
            }
            List<ErrorResp.ErrorMsg> errorDetail = error.getErrorDetail();
            return (errorDetail == null || errorDetail.isEmpty()) ? new C9721b(i11, this.f62719b.toString(), str2) : m84146i(i10, i11, errorDetail.get(0), str2);
        } catch (Exception unused) {
            return new C9721b(3911, str, str2);
        }
    }
}
