package ph;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.RequestBean;
import com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.ResponseBean;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.Executor;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;
import p613rh.AbstractC12511b;
import p679uh.C13174b;
import p679uh.C13175c;
import p775xh.InterfaceC13814b;
import th.C13012a;

/* renamed from: ph.b */
/* loaded from: classes4.dex */
public class AsyncTaskC12142b extends AsyncTask<RequestBean, Void, ResponseBean> {

    /* renamed from: a */
    public RequestBean f56286a;

    /* renamed from: b */
    public InterfaceC13814b f56287b;

    /* renamed from: c */
    public C13174b f56288c = null;

    public AsyncTaskC12142b(RequestBean requestBean, InterfaceC13814b interfaceC13814b) {
        this.f56286a = requestBean;
        this.f56287b = interfaceC13814b;
    }

    /* renamed from: a */
    public final ResponseBean m72780a(Context context) {
        ResponseBean responseBeanM72787h = m72787h(context);
        m72788i(responseBeanM72787h);
        return responseBeanM72787h;
    }

    @Override // android.os.AsyncTask
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ResponseBean doInBackground(RequestBean... requestBeanArr) {
        ResponseBean responseBeanM72780a = m72780a(this.f56286a.getContext());
        InterfaceC13814b interfaceC13814b = this.f56287b;
        if (interfaceC13814b != null) {
            interfaceC13814b.mo68600b(this.f56286a, responseBeanM72780a);
        }
        return responseBeanM72780a;
    }

    /* renamed from: c */
    public final void m72782c(Context context, ResponseBean responseBean, String str) {
        String strGenBody = this.f56286a.genBody();
        C13012a.m78315a("StoreAgent", "callStore, method:" + this.f56286a.getMethod() + ", url:" + str);
        C13174b c13174b = new C13174b();
        this.f56288c = c13174b;
        String str2 = new String(c13174b.m79217c(context, str, strGenBody, Constants.UTF_8), Constants.UTF_8);
        if (AbstractC12511b.m75109b(str2)) {
            C13012a.m78318d("StoreAgent", "getServerData success");
            m72785f(str2, responseBean);
        } else {
            C13012a.m78317c("StoreAgent", "resData error,res==null or res is not JSONString!");
            responseBean.setResponseCode(1);
            responseBean.setErrCause(ResponseBean.EnumC4573a.JSON_ERROR);
        }
    }

    /* renamed from: d */
    public void m72783d(ResponseBean responseBean) {
        ResponseBean.EnumC4573a enumC4573a;
        if (isCancelled() || this.f56287b == null) {
            return;
        }
        if (responseBean == null) {
            C13012a.m78317c("StoreAgent", "notifyResult, response is null");
            responseBean = this.f56286a.getResponseBean();
            if (responseBean == null) {
                responseBean = new ResponseBean();
                enumC4573a = ResponseBean.EnumC4573a.PARAM_ERROR;
            } else {
                enumC4573a = ResponseBean.EnumC4573a.UNKNOWN_EXCEPTION;
            }
            responseBean.setErrCause(enumC4573a);
            responseBean.setResponseCode(1);
        }
        this.f56287b.mo68599a(this.f56286a, responseBean);
    }

    /* renamed from: e */
    public final void m72784e(ResponseBean responseBean, int i10, ResponseBean.EnumC4573a enumC4573a) {
        if (responseBean != null) {
            responseBean.setResponseCode(i10);
            responseBean.setErrCause(enumC4573a);
        }
        C13012a.m78317c("StoreAgent", "invoke Store error method:" + this.f56286a.getMethod());
    }

    /* renamed from: f */
    public final void m72785f(String str, ResponseBean responseBean) {
        StringBuilder sb2;
        String str2;
        try {
            responseBean.fromJson(new JSONObject(str));
            responseBean.setResponseCode(0);
        } catch (ClassNotFoundException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str2 = "parse json error ClassNotFoundException, json";
            sb2.append(str2);
            sb2.append(e.getMessage());
            C13012a.m78317c("StoreAgent", sb2.toString());
        } catch (IllegalAccessException e11) {
            e = e11;
            sb2 = new StringBuilder();
            str2 = "parse json error IllegalAccessException, json";
            sb2.append(str2);
            sb2.append(e.getMessage());
            C13012a.m78317c("StoreAgent", sb2.toString());
        } catch (IllegalArgumentException e12) {
            e = e12;
            sb2 = new StringBuilder();
            str2 = "parse json error IllegalArgumentException, json";
            sb2.append(str2);
            sb2.append(e.getMessage());
            C13012a.m78317c("StoreAgent", sb2.toString());
        } catch (InstantiationException e13) {
            e = e13;
            sb2 = new StringBuilder();
            str2 = "parse json error InstantiationException, json";
            sb2.append(str2);
            sb2.append(e.getMessage());
            C13012a.m78317c("StoreAgent", sb2.toString());
        } catch (JSONException e14) {
            e = e14;
            sb2 = new StringBuilder();
            str2 = "parse json error JSONException, json";
            sb2.append(str2);
            sb2.append(e.getMessage());
            C13012a.m78317c("StoreAgent", sb2.toString());
        }
    }

    /* renamed from: g */
    public final void m72786g(Executor executor) {
        executeOnExecutor(executor, this.f56286a);
    }

    /* renamed from: h */
    public final ResponseBean m72787h(Context context) {
        ResponseBean.EnumC4573a enumC4573a;
        ResponseBean.EnumC4573a enumC4573a2;
        ResponseBean.EnumC4573a enumC4573a3;
        int i10 = 5;
        ResponseBean responseBean = null;
        try {
            responseBean = this.f56286a.getResponseBean();
        } catch (FileNotFoundException unused) {
            enumC4573a2 = ResponseBean.EnumC4573a.RESPONSE_EXCEPTION;
            i10 = 7;
            m72784e(null, i10, enumC4573a2);
            return m72790k(responseBean);
        } catch (SocketTimeoutException | ConnectTimeoutException unused2) {
            enumC4573a2 = ResponseBean.EnumC4573a.CONNECT_EXCEPTION;
            i10 = 2;
            m72784e(null, i10, enumC4573a2);
            return m72790k(responseBean);
        } catch (IOException unused3) {
            enumC4573a = ResponseBean.EnumC4573a.IO_EXCEPTION;
            m72784e(null, 1, enumC4573a);
            return m72790k(responseBean);
        } catch (IllegalArgumentException unused4) {
            enumC4573a2 = ResponseBean.EnumC4573a.PARAM_ERROR;
            m72784e(null, i10, enumC4573a2);
            return m72790k(responseBean);
        } catch (ConnectException unused5) {
            enumC4573a = ResponseBean.EnumC4573a.CONNECT_EXCEPTION;
            m72784e(null, 1, enumC4573a);
            return m72790k(responseBean);
        } catch (Throwable unused6) {
            enumC4573a = ResponseBean.EnumC4573a.UNKNOWN_EXCEPTION;
            m72784e(null, 1, enumC4573a);
            return m72790k(responseBean);
        }
        if (C13175c.m79222e(context)) {
            String serviceUrl = this.f56286a.getServiceUrl();
            if (!TextUtils.isEmpty(serviceUrl)) {
                m72782c(context, responseBean, serviceUrl);
                return m72790k(responseBean);
            }
            responseBean.setResponseCode(5);
            enumC4573a3 = ResponseBean.EnumC4573a.PARAM_ERROR;
        } else {
            responseBean.setResponseCode(3);
            enumC4573a3 = ResponseBean.EnumC4573a.NO_NETWORK;
        }
        responseBean.setErrCause(enumC4573a3);
        return m72790k(responseBean);
    }

    /* renamed from: i */
    public void m72788i(ResponseBean responseBean) {
    }

    @Override // android.os.AsyncTask
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(ResponseBean responseBean) {
        m72783d(responseBean);
    }

    /* renamed from: k */
    public final ResponseBean m72790k(ResponseBean responseBean) {
        if (responseBean != null) {
            return responseBean;
        }
        ResponseBean responseBean2 = new ResponseBean();
        responseBean2.setResponseCode(5);
        responseBean2.setErrCause(ResponseBean.EnumC4573a.PARAM_ERROR);
        return responseBean2;
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        super.onCancelled();
    }
}
