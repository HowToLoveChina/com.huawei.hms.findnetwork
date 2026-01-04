package md;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.huawei.android.hicloud.task.frame.RequestDispatcher;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import dk.C9160a;
import java.io.IOException;
import java.net.SocketTimeoutException;
import ke.C11046a;
import p015ak.C0214f0;
import p514o9.C11839m;

/* renamed from: md.b */
/* loaded from: classes3.dex */
public class C11439b<Result> extends AbstractC11438a<Result> {

    /* renamed from: k */
    public C11443f f53295k = C11443f.m68551b();

    /* renamed from: l */
    public boolean f53296l = false;

    /* renamed from: m */
    public C11439b<Result>.a f53297m = new a();

    /* renamed from: n */
    public int f53298n = 0;

    /* renamed from: o */
    public String f53299o = "unknown";

    /* renamed from: md.b$a */
    public class a implements Handler.Callback {
        public a() {
        }

        /* renamed from: a */
        public int m68522a() {
            return C11439b.this.m68510g();
        }

        /* renamed from: b */
        public boolean m68523b() {
            return C11439b.this.m68511i();
        }

        /* renamed from: c */
        public boolean m68524c(String str) {
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C11439b.this.f53282a, NotifyConstants.InterfaceC4909SP.USERINFO_SPFILE, 0);
            if (!"autorecordingkey".contains(str) || !sharedPreferencesM1382b.getBoolean("recording_need_wifi_condition", true)) {
                return false;
            }
            C11439b c11439b = C11439b.this;
            return !c11439b.m68518s(c11439b.f53282a);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message == null) {
                return false;
            }
            boolean zMo66493r = C11439b.this.mo66493r(message);
            C11439b.this.m68519t(message);
            return zMo66493r;
        }
    }

    @Override // md.AbstractC11438a
    /* renamed from: a */
    public void mo66488a(Result result) {
        C11443f c11443f = this.f53285d;
        if (c11443f == null) {
            throw new IllegalArgumentException("response is bad");
        }
        c11443f.m68554d(m68508e());
        c11443f.m68556f(m68515o());
        c11443f.m68553c(mo66521n(result));
        Message messageM68552a = c11443f.m68552a();
        if (messageM68552a == null) {
            throw new IllegalArgumentException("response is bad");
        }
        this.f53297m.handleMessage(messageM68552a);
    }

    @Override // md.AbstractC11438a
    /* renamed from: d */
    public Result mo66490d() throws Exception {
        return null;
    }

    /* renamed from: l */
    public void mo66492l(boolean z10) {
        this.f53287f = true;
    }

    /* renamed from: m */
    public Message m68514m(Message message) {
        Message message2 = new Message();
        message2.copyFrom(message);
        return message2;
    }

    /* renamed from: n */
    public Bundle mo66521n(Result result) {
        return null;
    }

    /* renamed from: o */
    public int m68515o() {
        if (m68511i()) {
            return -2;
        }
        Exception exc = this.f53283b;
        if (exc == null) {
            return 0;
        }
        if ((exc instanceof SocketTimeoutException) || (exc instanceof IOException)) {
            return -9;
        }
        return exc instanceof IllegalArgumentException ? -8 : -3;
    }

    /* renamed from: p */
    public String m68516p(int i10) {
        if (i10 == -14) {
            return "low battery cannot upload";
        }
        if (i10 == -13) {
            return "Server Control Reset cannot upload";
        }
        if (i10 != 1002) {
            if (i10 == 1005) {
                return "power disconnected cannot upload";
            }
            if (i10 == 2001) {
                return "Local ST invalid flag is true";
            }
            if (i10 == 2010) {
                return "Manual cancel";
            }
            if (i10 == 2017) {
                return "Sync Risk";
            }
            if (i10 == 2019) {
                return "Data migrate warn is true";
            }
            if (i10 != 2024) {
                return i10 != 2201 ? i10 != 55000018 ? "Others" : "No WIFI NetWork for backup recording" : "Forced upgrade";
            }
        }
        return "No NetWork";
    }

    /* renamed from: q */
    public String m68517q() {
        return this.f53299o;
    }

    /* renamed from: r */
    public boolean mo66493r(Message message) {
        if (message == null) {
            return false;
        }
        C11839m.m70686d("BaseCBTask", "handleMessage callback,msg.what=" + message.what + ",msg.arg1=" + message.arg1);
        int i10 = message.what;
        if (i10 == 11 || i10 == 15 || i10 == 67 || i10 == 1202 || i10 == 99001) {
            this.f53295k.m68555e(i10);
            mo66492l(false);
        }
        return false;
    }

    /* renamed from: s */
    public final boolean m68518s(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || 1 != activeNetworkInfo.getType()) {
            return false;
        }
        C11839m.m70686d("BaseCBTask", "is wifi  active ,status = " + activeNetworkInfo.isConnected());
        return activeNetworkInfo.isConnected();
    }

    /* renamed from: t */
    public final void m68519t(Message message) {
        synchronized (RequestDispatcher.m18034c()) {
            try {
                for (C11441d c11441d : RequestDispatcher.m18034c().values()) {
                    if (c11441d != null && !C9160a.m57577a().contains(Integer.valueOf(message.what))) {
                        C11046a.m66596d(c11441d.m68547b(), m68514m(message));
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: u */
    public void m68520u(int i10) {
        this.f53288g = i10;
    }

    /* renamed from: v */
    public void m68521v(String str) {
        this.f53299o = str;
    }
}
