package p770xc;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.hicloud.sync.contact.ContactManager;
import com.huawei.android.hicloud.sync.wifi.datamanager.WlanManager;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.notification.p106db.operator.SyncConfigOperator;
import java.util.Timer;
import java.util.TimerTask;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p675uc.C13153a;
import p783xp.C13843a;

/* renamed from: xc.g */
/* loaded from: classes3.dex */
public class C13744g extends AbstractC12367d {

    /* renamed from: a */
    public Context f61785a;

    /* renamed from: b */
    public String f61786b;

    /* renamed from: c */
    public String f61787c;

    /* renamed from: d */
    public Handler f61788d;

    /* renamed from: e */
    public boolean f61789e = true;

    /* renamed from: f */
    public int f61790f;

    /* renamed from: xc.g$a */
    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C11839m.m70688i("QueryHasLocalDataTask", "Timer.sendMessage: isNeedSendMessage = " + C13744g.this.f61789e);
            C13744g.this.m82600f(true);
        }
    }

    public C13744g(Context context, Handler handler, String str, String str2, int i10) {
        this.f61785a = context;
        this.f61788d = handler;
        this.f61786b = str;
        this.f61787c = str2;
        this.f61790f = i10;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        new Timer().schedule(new a(), 1000L);
        m82600f(m82599e());
    }

    /* renamed from: e */
    public final boolean m82599e() throws Throwable {
        if (TextUtils.isEmpty(this.f61786b)) {
            C11839m.m70687e("QueryHasLocalDataTask", "syncType is empty");
            return false;
        }
        String str = this.f61786b;
        str.hashCode();
        switch (str) {
            case "addressbook":
                return C13843a.m83073Y(this.f61785a) ? C13153a.m79135u(this.f61785a) : new ContactManager(this.f61785a).m17212O();
            case "calendar":
                return C13153a.m79134t(this.f61785a);
            case "wlan":
                try {
                    return new WlanManager(this.f61785a).localHaveData();
                } catch (Exception e10) {
                    C11839m.m70689w("QueryHasLocalDataTask", "query local data err. " + e10.toString());
                    return false;
                }
            case "browser":
                return C13153a.m79138x(this.f61785a) || C13153a.m79140z(this.f61785a);
            case "notepad":
                return C13153a.m79139y(this.f61785a);
            default:
                SyncConfigService serviceById = new SyncConfigOperator().getServiceById(this.f61786b);
                if (serviceById != null) {
                    return C13153a.m79137w(this.f61785a, serviceById.getApplications());
                }
                return false;
        }
    }

    /* renamed from: f */
    public final void m82600f(boolean z10) {
        if (this.f61789e) {
            this.f61789e = false;
            Bundle bundle = new Bundle();
            bundle.putString("trace_id_key", this.f61787c);
            bundle.putString("sync_type_key", this.f61786b);
            bundle.putInt("sync_operation_type", this.f61790f);
            Message messageObtain = Message.obtain();
            messageObtain.obj = Boolean.valueOf(z10);
            messageObtain.what = 1000007;
            messageObtain.setData(bundle);
            C11839m.m70688i("QueryHasLocalDataTask", "syncType: " + this.f61786b + ", hasLocalData: " + messageObtain.obj);
            Handler handler = this.f61788d;
            if (handler != null) {
                handler.sendMessage(messageObtain);
            }
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.QUERY_HAS_LOCAL_DATA_FIX;
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public boolean syncLock() {
        return false;
    }
}
