package co;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.hicloud.request.agreement.request.QueryAgreementRsp;
import com.huawei.hicloud.request.agreement.request.SignInfo;
import gp.C10028c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import p514o9.C11839m;
import p681uj.C13192i;

/* renamed from: co.a */
/* loaded from: classes6.dex */
public abstract class AbstractHandlerC1512a extends Handler {

    /* renamed from: a */
    public WeakReference<Activity> f6498a;

    public AbstractHandlerC1512a(Activity activity) {
        super(Looper.getMainLooper());
        this.f6498a = new WeakReference<>(activity);
    }

    /* renamed from: a */
    public final void m8604a() {
        mo8607d();
    }

    /* renamed from: b */
    public final void m8605b(QueryAgreementRsp queryAgreementRsp) {
        ArrayList<SignInfo> signInfo = queryAgreementRsp.getSignInfo();
        if (signInfo == null || signInfo.isEmpty()) {
            C11839m.m70688i("AgreementHandler", "signInfo is null. doNoSign()");
            mo8612i();
        } else {
            C11839m.m70686d("AgreementHandler", "doNext.");
            mo8611h(signInfo);
        }
    }

    /* renamed from: c */
    public final void m8606c(Message message) {
        int i10 = message.arg1;
        C11839m.m70688i("AgreementHandler", "query agreeState success:" + i10);
        if (i10 == 1) {
            mo8608e(message.obj.toString());
            C10028c.m62182c0().m62377p3("hms_agr_force_query", true);
        } else if (i10 == -1) {
            m8609f();
        } else if (i10 == 0) {
            mo8610g();
        }
    }

    /* renamed from: d */
    public abstract void mo8607d();

    /* renamed from: e */
    public abstract void mo8608e(String str);

    /* renamed from: f */
    public final void m8609f() {
        C11839m.m70687e("AgreementHandler", "doHmsNotLogin");
        m8604a();
    }

    /* renamed from: g */
    public abstract void mo8610g();

    /* renamed from: h */
    public abstract void mo8611h(List<SignInfo> list);

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int iIntValue;
        C11839m.m70688i("AgreementHandler", "handleMessage, msg.what: " + message.what);
        switch (message.what) {
            case 31000:
                Object obj = message.obj;
                if (obj != null && (obj instanceof QueryAgreementRsp)) {
                    m8605b((QueryAgreementRsp) obj);
                    break;
                } else {
                    m8604a();
                    break;
                }
                break;
            case 31001:
                Object obj2 = message.obj;
                if (obj2 != null && (iIntValue = ((Integer) obj2).intValue()) == 2) {
                    int iMo8613j = mo8613j();
                    C11839m.m70688i("AgreementHandler", "HmsApiConnector failed");
                    Activity activity = this.f6498a.get();
                    if (activity == null || activity.isFinishing()) {
                        C11839m.m70688i("AgreementHandler", "activity is finished!");
                        break;
                    } else {
                        C13192i.m79258g().m79265k(activity, 10019, iIntValue, iMo8613j);
                    }
                }
                m8604a();
                break;
            case 31002:
                m8606c(message);
                break;
        }
    }

    /* renamed from: i */
    public abstract void mo8612i();

    /* renamed from: j */
    public int mo8613j() {
        return 2;
    }
}
