package ohos.ohos.ohos.ohos.ohos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.ohos.localability.R$color;
import com.huawei.ohos.localability.R$id;
import com.huawei.ohos.localability.R$layout;
import com.huawei.ohos.localability.R$string;
import com.huawei.ohos.localability.base.AlertDialogActivity;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import ohos.ohos.ohos.ohos.ohos.InterfaceC11900x;
import p625rx.C12634a;
import p625rx.C12644k;
import p625rx.C12645l;
import p625rx.C12646m;
import p625rx.HandlerC12639f;
import p625rx.RunnableC12643j;
import p625rx.ViewOnClickListenerC12640g;
import p625rx.ViewOnClickListenerC12641h;
import p625rx.ViewOnClickListenerC12642i;

/* renamed from: ohos.ohos.ohos.ohos.ohos.d */
/* loaded from: classes9.dex */
public class C11889d extends C12645l implements AlertDialogActivity.InterfaceC6826b {

    /* renamed from: A */
    public IBinder.DeathRecipient f55009A;

    /* renamed from: e */
    public View f55010e;

    /* renamed from: f */
    public Intent f55011f;

    /* renamed from: g */
    public C11885a f55012g;

    /* renamed from: h */
    public int f55013h;

    /* renamed from: i */
    public ArrayList<C11896l> f55014i;

    /* renamed from: j */
    public boolean f55015j;

    /* renamed from: k */
    public boolean f55016k;

    /* renamed from: l */
    public int f55017l;

    /* renamed from: m */
    public RelativeLayout f55018m;

    /* renamed from: n */
    public RelativeLayout f55019n;

    /* renamed from: o */
    public TextView f55020o;

    /* renamed from: p */
    public TextView f55021p;

    /* renamed from: q */
    public Button f55022q;

    /* renamed from: r */
    public Button f55023r;

    /* renamed from: s */
    public RelativeLayout f55024s;

    /* renamed from: t */
    public TextView f55025t;

    /* renamed from: u */
    public Button f55026u;

    /* renamed from: v */
    public TextView f55027v;

    /* renamed from: w */
    public TextView f55028w;

    /* renamed from: x */
    public Handler f55029x;

    /* renamed from: y */
    public HandlerThread f55030y;

    /* renamed from: z */
    public AlertDialog f55031z;

    /* renamed from: ohos.ohos.ohos.ohos.ohos.d$a */
    public class a implements IBinder.DeathRecipient {
        public a() {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Log.e("UpdateDialog", "UpdateDialog: bms died");
            C11889d.m71394b(C11889d.this, R$string.download_failed_error_info);
        }
    }

    /* renamed from: ohos.ohos.ohos.ohos.ohos.d$b */
    public class b extends InterfaceC11900x.a {
        public b() {
        }

        @Override // ohos.ohos.ohos.ohos.ohos.InterfaceC11900x
        /* renamed from: a */
        public void mo71403a(int i10, String str) {
            if (i10 == 0) {
                if (C11889d.this.f58107d.get() != null) {
                    C11889d.this.f55015j = false;
                    C11891f c11891f = C11891f.f55039a;
                    Context context = C11889d.this.f58107d.get();
                    C11889d c11889d = C11889d.this;
                    c11891f.m71414h(context, c11889d.f55012g, c11889d.f55011f, false, c11889d.f55013h);
                }
                C11889d.this.f55031z.dismiss();
                return;
            }
            Log.e("UpdateDialog", "free install update failed! resultCode = " + i10 + "resultMsg = " + str);
            if (i10 == 11 || i10 == 12) {
                C11889d.m71394b(C11889d.this, R$string.download_failed_error_info);
            } else {
                C11889d.m71394b(C11889d.this, R$string.other_error_info);
                C11889d.this.f55016k = true;
            }
        }
    }

    /* renamed from: ohos.ohos.ohos.ohos.ohos.d$c */
    public class c extends InterfaceC11900x.a {
        public c() {
        }

        @Override // ohos.ohos.ohos.ohos.ohos.InterfaceC11900x
        /* renamed from: a */
        public void mo71403a(int i10, String str) {
            if (i10 == 0) {
                C11889d.this.m71402j();
                return;
            }
            Log.e("UpdateDialog", "free install update failed! resultCode = " + i10 + "resultMsg = " + str);
            if (i10 == 11 || i10 == 12) {
                C11889d.m71394b(C11889d.this, R$string.download_failed_error_info);
            } else {
                C11889d.m71394b(C11889d.this, R$string.other_error_info);
                C11889d.this.f55016k = true;
            }
        }
    }

    public C11889d(Activity activity, Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, RemoteException, IllegalArgumentException, InvocationTargetException {
        C11896l c11896l;
        StringBuilder sb2;
        String str;
        super(activity);
        this.f55015j = false;
        this.f55016k = false;
        this.f55009A = new a();
        View view = null;
        View viewInflate = LayoutInflater.from(this.f58105b).inflate(R$layout.remind_update_dialog, (ViewGroup) null);
        this.f55010e = viewInflate;
        if (viewInflate != null) {
            this.f55021p = (TextView) viewInflate.findViewById(R$id.text_update_user_agreement);
            this.f55022q = (Button) this.f55010e.findViewById(R$id.button_cancel);
            this.f55023r = (Button) this.f55010e.findViewById(R$id.button_open);
            this.f55024s = (RelativeLayout) this.f55010e.findViewById(R$id.waiting_layout);
            this.f55025t = (TextView) this.f55010e.findViewById(R$id.text_bundle_name);
            this.f55018m = (RelativeLayout) this.f55010e.findViewById(R$id.dialog_update_remind_layout);
            this.f55019n = (RelativeLayout) this.f55010e.findViewById(R$id.dialog_error_layout);
            this.f55020o = (TextView) this.f55010e.findViewById(R$id.dialog_error_reason);
            this.f55026u = (Button) this.f55010e.findViewById(R$id.button_error_confirm);
            this.f55027v = (TextView) this.f55010e.findViewById(R$id.text_bundle_size_label);
            this.f55028w = (TextView) this.f55010e.findViewById(R$id.text_bundle_version_label);
            view = this.f55010e;
        }
        this.f55010e = view;
        if (bundle == null) {
            Log.e("UpdateDialog", "bundle argument is null");
        } else {
            this.f55011f = (Intent) bundle.getParcelable("abilityIntent");
            this.f55014i = bundle.getParcelableArrayList("newVersionAbilityInfos");
            this.f55012g = (C11885a) bundle.getParcelable("abilityData");
            this.f55013h = bundle.getInt("requestCode");
            HandlerThread handlerThread = new HandlerThread("updateThread");
            this.f55030y = handlerThread;
            handlerThread.start();
            this.f55029x = new HandlerC12639f(this, this.f55030y.getLooper());
        }
        Iterator<C11896l> it = this.f55014i.iterator();
        while (true) {
            if (it.hasNext()) {
                c11896l = it.next();
                String strMo71384d = c11896l.mo71384d();
                if (!strMo71384d.isEmpty() && strMo71384d.equals(this.f55012g.f54940a.mo71384d())) {
                    break;
                }
            } else {
                ArrayList<C11896l> arrayList = this.f55014i;
                c11896l = (arrayList == null || arrayList.size() <= 0) ? C12646m.m76178f() ? new C11896l() : new C11887c() : this.f55014i.get(0);
            }
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(c11896l.mo71390l());
        spannableStringBuilder.setSpan(new C12644k(this, c11896l.mo71391m()), 0, spannableStringBuilder.length(), 33);
        spannableStringBuilder.setSpan(new TypefaceSpan(this.f58105b.getResources().getString(R$string.emui_text_font_family_medium)), 0, spannableStringBuilder.length(), 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(m76172a(R$color.emui_functional_blue)), 0, spannableStringBuilder.length(), 33);
        this.f55021p.setText(C12634a.m76167b(this.f58105b.getResources().getString(R$string.update_user_agreement), spannableStringBuilder));
        this.f55021p.setLinksClickable(true);
        this.f55021p.setMovementMethod(LinkMovementMethod.getInstance());
        this.f55025t.setText(c11896l.mo71382a());
        String string = this.f58105b.getResources().getString(R$string.bundle_size);
        Iterator<C11896l> it2 = this.f55014i.iterator();
        int iMo71388i = 0;
        while (it2.hasNext()) {
            iMo71388i += it2.next().mo71388i();
        }
        float f10 = (iMo71388i / 1024.0f) / 1024.0f;
        Locale localeM76169d = C12634a.m76169d(this.f58105b);
        if (localeM76169d == null || !"ug".equals(localeM76169d.getLanguage())) {
            sb2 = new StringBuilder();
            sb2.append(Math.round(f10 * 100.0f) / 100.0f);
            str = " MB";
        } else {
            sb2 = new StringBuilder();
            sb2.append(Math.round(f10 * 100.0f) / 100.0f);
            str = "MB";
        }
        sb2.append(str);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(sb2.toString());
        TypefaceSpan typefaceSpan = new TypefaceSpan(this.f58105b.getResources().getString(R$string.emui_text_font_family_medium));
        spannableStringBuilder2.setSpan(CharacterStyle.wrap(typefaceSpan), 0, spannableStringBuilder2.length(), 33);
        this.f55027v.setText(C12634a.m76167b(string, spannableStringBuilder2));
        String string2 = this.f58105b.getResources().getString(R$string.bundle_version);
        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(c11896l.mo71393o());
        spannableStringBuilder3.setSpan(CharacterStyle.wrap(typefaceSpan), 0, spannableStringBuilder3.length(), 33);
        this.f55028w.setText(C12634a.m76167b(string2, spannableStringBuilder3));
        this.f55022q.setOnClickListener(new ViewOnClickListenerC12640g(this));
        this.f55023r.setOnClickListener(new ViewOnClickListenerC12641h(this));
        this.f55026u.setOnClickListener(new ViewOnClickListenerC12642i(this));
        C12646m.m76175c(this.f55009A);
    }

    /* renamed from: b */
    public static /* synthetic */ void m71394b(C11889d c11889d, int i10) {
        c11889d.f58106c.runOnUiThread(new RunnableC12643j(c11889d, i10));
    }

    @Override // com.huawei.ohos.localability.base.AlertDialogActivity.InterfaceC6826b
    /* renamed from: a */
    public void mo38541a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        m71397d();
        HandlerThread handlerThread = this.f55030y;
        if (handlerThread != null) {
            handlerThread.quit();
        }
    }

    /* renamed from: d */
    public final void m71397d() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ArrayList<C11896l> arrayList;
        if (!this.f55015j || (arrayList = this.f55014i) == null || arrayList.isEmpty()) {
            return;
        }
        C11891f.f55039a.m71420o(this.f55014i.get(0));
        this.f55015j = false;
    }

    /* renamed from: f */
    public final void m71398f() {
        this.f55031z.dismiss();
    }

    /* renamed from: g */
    public final InterfaceC11900x m71399g() {
        return new b();
    }

    /* renamed from: h */
    public final InterfaceC11900x m71400h() {
        return new c();
    }

    /* renamed from: i */
    public final void m71401i() {
        if (!C12646m.m76178f()) {
            m71402j();
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.obj = this.f55014i;
        this.f55029x.sendMessage(messageObtain);
    }

    /* renamed from: j */
    public final void m71402j() {
        ArrayList<C11896l> arrayList = this.f55014i;
        if (arrayList == null) {
            Log.e("UpdateDialog", "updateHapOneByOne: abilityInfos is null");
            return;
        }
        if (this.f55017l == arrayList.size() && this.f58107d.get() != null) {
            this.f55015j = false;
            C11891f.f55039a.m71414h(this.f58107d.get(), this.f55012g, this.f55011f, false, this.f55013h);
            this.f55031z.dismiss();
        } else {
            C11896l c11896l = this.f55014i.get(this.f55017l);
            this.f55017l++;
            Message messageObtain = Message.obtain();
            messageObtain.what = 2;
            messageObtain.obj = c11896l;
            this.f55029x.sendMessage(messageObtain);
        }
    }
}
