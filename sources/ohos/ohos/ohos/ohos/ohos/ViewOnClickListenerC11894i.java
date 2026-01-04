package ohos.ohos.ohos.ohos.ohos;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import com.huawei.ohos.localability.R$string;
import java.lang.reflect.InvocationTargetException;
import ohos.ohos.ohos.ohos.ohos.C11893h;
import ohos.ohos.ohos.ohos.ohos.InterfaceC11900x;

/* renamed from: ohos.ohos.ohos.ohos.ohos.i */
/* loaded from: classes9.dex */
public class ViewOnClickListenerC11894i implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ C11893h f55070a;

    /* renamed from: ohos.ohos.ohos.ohos.ohos.i$a */
    public class a extends InterfaceC11900x.a {
        public a() {
        }

        @Override // ohos.ohos.ohos.ohos.ohos.InterfaceC11900x
        /* renamed from: a */
        public void mo71403a(int i10, String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            C11893h c11893h;
            int i11;
            if (i10 == 0) {
                ViewOnClickListenerC11894i.this.f55070a.f55056q = false;
                C11893h.m71427d(ViewOnClickListenerC11894i.this.f55070a);
                if (ViewOnClickListenerC11894i.this.f55070a.f58107d.get() != null) {
                    C11891f c11891f = C11891f.f55039a;
                    Context context = ViewOnClickListenerC11894i.this.f55070a.f58107d.get();
                    C11893h c11893h2 = ViewOnClickListenerC11894i.this.f55070a;
                    c11891f.m71414h(context, c11893h2.f55058s, c11893h2.f55057r, false, c11893h2.f55060u);
                    return;
                }
                return;
            }
            Log.e("FreeInstallDialog", "startFreeInstallAbility install failed! resultCode = " + i10 + "resultMsg = " + str);
            if (i10 == 11 || i10 == 12) {
                c11893h = ViewOnClickListenerC11894i.this.f55070a;
                i11 = R$string.download_failed_error_info;
            } else {
                c11893h = ViewOnClickListenerC11894i.this.f55070a;
                i11 = R$string.other_error_info;
            }
            C11893h.m71428e(c11893h, i11);
        }
    }

    public ViewOnClickListenerC11894i(C11893h c11893h) {
        this.f55070a = c11893h;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f55070a.f55056q = true;
        this.f55070a.f55052m.setVisibility(0);
        this.f55070a.f55046g.setVisibility(8);
        this.f55070a.f55046g.setEnabled(false);
        new C11893h.b(new a(), this.f55070a.f55059t).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
