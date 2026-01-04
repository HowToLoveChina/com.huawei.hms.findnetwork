package ohos.ohos.ohos.ohos.ohos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.util.ArrayMap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.ohos.localability.R$color;
import com.huawei.ohos.localability.R$drawable;
import com.huawei.ohos.localability.R$id;
import com.huawei.ohos.localability.R$layout;
import com.huawei.ohos.localability.R$string;
import com.huawei.ohos.localability.base.AlertDialogActivity;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import p625rx.C12634a;
import p625rx.C12636c;
import p625rx.C12645l;
import p625rx.C12646m;
import p625rx.C12650q;
import p625rx.C12651r;
import p625rx.RunnableC12649p;
import p625rx.ViewOnClickListenerC12647n;
import p625rx.ViewOnClickListenerC12648o;

/* renamed from: ohos.ohos.ohos.ohos.ohos.h */
/* loaded from: classes9.dex */
public class C11893h extends C12645l implements AlertDialogActivity.InterfaceC6826b {

    /* renamed from: e */
    public View f55044e;

    /* renamed from: f */
    public Button f55045f;

    /* renamed from: g */
    public Button f55046g;

    /* renamed from: h */
    public Button f55047h;

    /* renamed from: i */
    public TextView f55048i;

    /* renamed from: j */
    public TextView f55049j;

    /* renamed from: k */
    public TextView f55050k;

    /* renamed from: l */
    public ImageView f55051l;

    /* renamed from: m */
    public RelativeLayout f55052m;

    /* renamed from: n */
    public RelativeLayout f55053n;

    /* renamed from: o */
    public RelativeLayout f55054o;

    /* renamed from: p */
    public RelativeLayout f55055p;

    /* renamed from: q */
    public boolean f55056q;

    /* renamed from: r */
    public Intent f55057r;

    /* renamed from: s */
    public C11885a f55058s;

    /* renamed from: t */
    public C11896l f55059t;

    /* renamed from: u */
    public int f55060u;

    /* renamed from: v */
    public List<String> f55061v;

    /* renamed from: w */
    public List<String> f55062w;

    /* renamed from: x */
    public AlertDialog f55063x;

    /* renamed from: y */
    public IBinder.DeathRecipient f55064y;

    /* renamed from: ohos.ohos.ohos.ohos.ohos.h$a */
    public class a implements IBinder.DeathRecipient {
        public a() {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Log.e("FreeInstallDialog", "FreeInstallDialog: bms died");
            C11893h.m71428e(C11893h.this, R$string.download_failed_error_info);
        }
    }

    /* renamed from: ohos.ohos.ohos.ohos.ohos.h$b */
    public static class b extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: a */
        public InterfaceC11900x f55066a;

        /* renamed from: b */
        public C11896l f55067b;

        public b(InterfaceC11900x interfaceC11900x, C11896l c11896l) {
            this.f55066a = interfaceC11900x;
            this.f55067b = c11896l;
        }

        @Override // android.os.AsyncTask
        public Boolean doInBackground(Void[] voidArr) {
            ArrayList<C11896l> arrayList = new ArrayList<>();
            arrayList.add(this.f55067b);
            return Boolean.valueOf(C12646m.m76178f() ? C11891f.f55039a.m71419n(arrayList, false, this.f55066a) : C11891f.f55039a.m71421p(this.f55067b, false, this.f55066a));
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue()) {
                return;
            }
            Log.e("FreeInstallDialog", "downloadAndInstall call return false");
        }
    }

    /* renamed from: ohos.ohos.ohos.ohos.ohos.h$c */
    public static class c extends AsyncTask<String, Void, BitmapDrawable> {

        /* renamed from: a */
        public WeakReference<ImageView> f55068a;

        /* renamed from: b */
        public WeakReference<Context> f55069b;

        public c(ImageView imageView, Context context) {
            this.f55068a = new WeakReference<>(imageView);
            this.f55069b = new WeakReference<>(context);
        }

        /* renamed from: a */
        public final void m71432a(Closeable closeable) throws IOException {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException unused) {
                    Log.e("FreeInstallDialog", "close icon resource IOException occur");
                }
            }
        }

        @Override // android.os.AsyncTask
        public BitmapDrawable doInBackground(String[] strArr) throws Throwable {
            InputStream inputStream;
            String str = strArr[0];
            Closeable closeable = null;
            bitmapDrawable = null;
            bitmapDrawable = null;
            BitmapDrawable bitmapDrawable = null;
            try {
            } catch (IOException unused) {
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                m71432a(closeable);
                throw th;
            }
            if (TextUtils.isEmpty(str)) {
                Log.e("FreeInstallDialog", "WRONG URL WHEN LOAD ICON");
            } else {
                URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
                if (uRLConnectionOpenConnection instanceof HttpURLConnection) {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                    httpURLConnection.setConnectTimeout(3000);
                    httpURLConnection.setReadTimeout(3000);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.connect();
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        try {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inJustDecodeBounds = false;
                            Context context = this.f55069b.get();
                            if (context != null) {
                                bitmapDrawable = new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(inputStream, null, options));
                            }
                        } catch (Throwable th3) {
                            closeable = inputStream;
                            th = th3;
                            m71432a(closeable);
                            throw th;
                        }
                    } catch (IOException unused2) {
                        Log.e("FreeInstallDialog", "IOExceptionIOException");
                        m71432a(inputStream);
                        return bitmapDrawable;
                    }
                    m71432a(inputStream);
                    return bitmapDrawable;
                }
            }
            m71432a(null);
            return bitmapDrawable;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(BitmapDrawable bitmapDrawable) {
            BitmapDrawable bitmapDrawable2 = bitmapDrawable;
            ImageView imageView = this.f55068a.get();
            if (imageView == null) {
                Log.e("FreeInstallDialog", "Can't get Icon ImageView reference");
            } else if (bitmapDrawable2 != null) {
                imageView.setImageDrawable(bitmapDrawable2);
            } else {
                Log.e("FreeInstallDialog", "onPostExecute WRONG URL WHEN LOAD ICON");
                imageView.setImageResource(R$drawable.default_tapped_icon);
            }
        }
    }

    public C11893h(Activity activity, Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, RemoteException, IllegalArgumentException, InvocationTargetException {
        View view;
        String strM76168c;
        super(activity);
        this.f55056q = false;
        this.f55061v = new ArrayList();
        this.f55062w = new ArrayList();
        this.f55064y = new a();
        Log.e("FreeInstallDialog", "initView start");
        View viewInflate = LayoutInflater.from(this.f58105b).inflate(R$layout.taped_dialog, (ViewGroup) null);
        this.f55044e = viewInflate;
        if (viewInflate == null) {
            view = null;
        } else {
            this.f55053n = (RelativeLayout) viewInflate.findViewById(R$id.dialog_outer_layout);
            this.f55054o = (RelativeLayout) this.f55044e.findViewById(R$id.dialog_tapped_layout);
            this.f55055p = (RelativeLayout) this.f55044e.findViewById(R$id.dialog_error_layout);
            this.f55052m = (RelativeLayout) this.f55044e.findViewById(R$id.waiting_layout);
            this.f55047h = (Button) this.f55044e.findViewById(R$id.button_error_cancel);
            this.f55045f = (Button) this.f55044e.findViewById(R$id.button_cancel);
            this.f55046g = (Button) this.f55044e.findViewById(R$id.button_open);
            this.f55048i = (TextView) this.f55044e.findViewById(R$id.dialog_title);
            this.f55049j = (TextView) this.f55044e.findViewById(R$id.dialog_description);
            this.f55051l = (ImageView) this.f55044e.findViewById(R$id.dialog_icon);
            this.f55050k = (TextView) this.f55044e.findViewById(R$id.dialog_error_reason);
            Log.e("FreeInstallDialog", "initView end");
            view = this.f55044e;
        }
        this.f55044e = view;
        this.f55057r = (Intent) bundle.getParcelable("abilityIntent");
        this.f55058s = (C11885a) bundle.getParcelable("abilityData");
        this.f55060u = bundle.getInt("requestCode");
        C11896l c11896l = this.f55058s.f54940a;
        this.f55059t = c11896l;
        String strMo71387g = c11896l.mo71387g();
        TypefaceSpan typefaceSpan = new TypefaceSpan(this.f58105b.getResources().getString(R$string.emui_text_font_family_medium));
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(m76172a(R$color.emui_text_primary));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f58105b.getResources().getString(R$string.network_connect_1));
        m71430b(spannableStringBuilder, typefaceSpan, foregroundColorSpan);
        SpannableStringBuilder spannableStringBuilderM76167b = C12634a.m76167b(this.f58105b.getResources().getString(R$string.alert_info_1), this.f55059t.mo71387g(), this.f55059t.mo71382a(), spannableStringBuilder, this.f55059t.mo71382a());
        List<String> listMo71389j = this.f55059t.mo71389j();
        ArrayList<String> arrayList = new ArrayList();
        ArrayMap<String, String> arrayMap = C12636c.f58083a;
        ArrayMap<String, Integer> arrayMap2 = C12636c.f58086d;
        for (String str : listMo71389j) {
            String str2 = arrayMap.get(str);
            if ("android.permission-group.PHONE".equals(str2)) {
                this.f55062w.add(this.f58105b.getResources().getString(arrayMap2.get(str).intValue()));
            }
            if (!TextUtils.isEmpty(str2) && !arrayList.contains(str2)) {
                arrayList.add(str2);
            }
        }
        if (!this.f55062w.isEmpty()) {
            HashSet hashSet = new HashSet(this.f55062w);
            this.f55062w.clear();
            this.f55062w.addAll(hashSet);
        }
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList, new C12651r(this));
        }
        for (String str3 : arrayList) {
            ArrayMap<String, Integer> arrayMap3 = C12636c.f58084b;
            int size = this.f55062w.size();
            int iIntValue = arrayMap3.get(str3).intValue();
            if (!"android.permission-group.PHONE".equals(str3)) {
                strM76168c = this.f58105b.getResources().getString(iIntValue);
            } else if (size != 0) {
                strM76168c = C12634a.m76168c(this.f58105b, this.f55062w);
            } else {
                Log.e("FreeInstallDialog", "CAN NOT GET PERMISSION LABEL");
                strM76168c = null;
            }
            if (!TextUtils.isEmpty(strM76168c) && !this.f55061v.contains(strM76168c)) {
                this.f55061v.add(strM76168c);
            }
        }
        if (this.f55061v.size() != 0) {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.f58105b.getResources().getString(R$string.network_connect_2));
            m71430b(spannableStringBuilder2, typefaceSpan, foregroundColorSpan);
            spannableStringBuilderM76167b.append((CharSequence) C12634a.m76166a(this.f58105b, this.f55061v, spannableStringBuilder2, typefaceSpan, foregroundColorSpan));
        }
        String strMo71391m = this.f55059t.mo71391m();
        String strMo71390l = this.f55059t.mo71390l();
        if (!TextUtils.isEmpty(strMo71391m) && !TextUtils.isEmpty(strMo71390l)) {
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(strMo71390l);
            C12650q c12650q = new C12650q(this, strMo71391m);
            C11899v c11899v = new C11899v(this);
            spannableStringBuilder3.setSpan(c12650q, 0, spannableStringBuilder3.length(), 33);
            spannableStringBuilder3.setSpan(c11899v, 0, spannableStringBuilder3.length(), 33);
            spannableStringBuilder3.setSpan(CharacterStyle.wrap(typefaceSpan), 0, spannableStringBuilder3.length(), 33);
            spannableStringBuilderM76167b.append((CharSequence) C12634a.m76167b(this.f58105b.getResources().getString(R$string.alert_info_3), this.f58105b.getResources().getString(R$string.alert_info_connect), spannableStringBuilder3));
        }
        this.f55048i.setText(strMo71387g);
        this.f55049j.setText(spannableStringBuilderM76167b);
        this.f55049j.setLinksClickable(true);
        this.f55049j.setMovementMethod(LinkMovementMethod.getInstance());
        new c(this.f55051l, this.f58105b).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f55059t.mo71386f());
        this.f55047h.setOnClickListener(new ViewOnClickListenerC12647n(this));
        this.f55045f.setOnClickListener(new ViewOnClickListenerC12648o(this));
        this.f55046g.setOnClickListener(new ViewOnClickListenerC11894i(this));
        C12646m.m76175c(this.f55064y);
    }

    /* renamed from: d */
    public static /* synthetic */ void m71427d(C11893h c11893h) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (c11893h.f55056q) {
            C11891f.f55039a.m71420o(c11893h.f55059t);
            c11893h.f55056q = false;
        }
        c11893h.f55063x.dismiss();
    }

    /* renamed from: e */
    public static /* synthetic */ void m71428e(C11893h c11893h, int i10) {
        c11893h.f58106c.runOnUiThread(new RunnableC12649p(c11893h, i10));
    }

    @Override // com.huawei.ohos.localability.base.AlertDialogActivity.InterfaceC6826b
    /* renamed from: a */
    public void mo38541a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.f55056q) {
            C11891f.f55039a.m71420o(this.f55059t);
            this.f55056q = false;
        }
    }

    /* renamed from: b */
    public final void m71430b(SpannableStringBuilder spannableStringBuilder, TypefaceSpan typefaceSpan, ForegroundColorSpan foregroundColorSpan) {
        spannableStringBuilder.setSpan(CharacterStyle.wrap(typefaceSpan), 0, spannableStringBuilder.length(), 33);
        spannableStringBuilder.setSpan(CharacterStyle.wrap(foregroundColorSpan), 0, spannableStringBuilder.length(), 33);
    }

    /* renamed from: c */
    public final void m71431c(String str) {
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            str = "https://" + str;
        }
        Uri uri = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        this.f58105b.startActivity(intent);
    }
}
