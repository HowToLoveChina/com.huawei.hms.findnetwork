package androidx.appcompat.app;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.C0408e;
import androidx.appcompat.view.menu.InterfaceC0414k;
import androidx.appcompat.view.menu.InterfaceC0415l;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.C0523e0;
import androidx.appcompat.widget.C0524f;
import androidx.appcompat.widget.C0533j0;
import androidx.appcompat.widget.C0535k0;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.InterfaceC0542q;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.widget.C0668i;
import androidx.lifecycle.AbstractC0791h;
import androidx.lifecycle.InterfaceC0796l;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;
import p024b0.C1090f;
import p211d.C8968a;
import p273f0.C9603h0;
import p273f0.C9615n0;
import p273f0.C9616o;
import p273f0.C9618p;
import p273f0.C9619p0;
import p273f0.C9625s0;
import p273f0.InterfaceC9586b0;
import p303g.AbstractC9814b;
import p303g.C9816d;
import p303g.C9817e;
import p303g.C9818f;
import p303g.WindowCallbackC9820h;
import p438l.C11213g;
import p694v.C13302d;

/* loaded from: classes.dex */
public class AppCompatDelegateImpl extends AbstractC0378c implements MenuBuilder.InterfaceC0398a, LayoutInflater.Factory2 {

    /* renamed from: j0 */
    public static final C11213g<String, Integer> f1255j0 = new C11213g<>();

    /* renamed from: k0 */
    public static final boolean f1256k0 = false;

    /* renamed from: l0 */
    public static final int[] f1257l0 = {R.attr.windowBackground};

    /* renamed from: m0 */
    public static final boolean f1258m0 = !"robolectric".equals(Build.FINGERPRINT);

    /* renamed from: n0 */
    public static final boolean f1259n0 = true;

    /* renamed from: A */
    public boolean f1260A;

    /* renamed from: B */
    public ViewGroup f1261B;

    /* renamed from: C */
    public TextView f1262C;

    /* renamed from: D */
    public View f1263D;

    /* renamed from: E */
    public boolean f1264E;

    /* renamed from: F */
    public boolean f1265F;

    /* renamed from: G */
    public boolean f1266G;

    /* renamed from: H */
    public boolean f1267H;

    /* renamed from: I */
    public boolean f1268I;

    /* renamed from: J */
    public boolean f1269J;

    /* renamed from: K */
    public boolean f1270K;

    /* renamed from: L */
    public boolean f1271L;

    /* renamed from: M */
    public PanelFeatureState[] f1272M;

    /* renamed from: N */
    public PanelFeatureState f1273N;

    /* renamed from: O */
    public boolean f1274O;

    /* renamed from: P */
    public boolean f1275P;

    /* renamed from: Q */
    public boolean f1276Q;

    /* renamed from: R */
    public boolean f1277R;

    /* renamed from: S */
    public Configuration f1278S;

    /* renamed from: T */
    public int f1279T;

    /* renamed from: U */
    public int f1280U;

    /* renamed from: V */
    public int f1281V;

    /* renamed from: W */
    public boolean f1282W;

    /* renamed from: X */
    public AbstractC0371o f1283X;

    /* renamed from: Y */
    public AbstractC0371o f1284Y;

    /* renamed from: Z */
    public boolean f1285Z;

    /* renamed from: a0 */
    public int f1286a0;

    /* renamed from: b0 */
    public final Runnable f1287b0;

    /* renamed from: c0 */
    public boolean f1288c0;

    /* renamed from: d0 */
    public Rect f1289d0;

    /* renamed from: e0 */
    public Rect f1290e0;

    /* renamed from: f0 */
    public C0386k f1291f0;

    /* renamed from: g0 */
    public C0389n f1292g0;

    /* renamed from: h0 */
    public OnBackInvokedDispatcher f1293h0;

    /* renamed from: i0 */
    public OnBackInvokedCallback f1294i0;

    /* renamed from: j */
    public final Object f1295j;

    /* renamed from: k */
    public final Context f1296k;

    /* renamed from: l */
    public Window f1297l;

    /* renamed from: m */
    public C0369m f1298m;

    /* renamed from: n */
    public final InterfaceC0376a f1299n;

    /* renamed from: o */
    public ActionBar f1300o;

    /* renamed from: p */
    public MenuInflater f1301p;

    /* renamed from: q */
    public CharSequence f1302q;

    /* renamed from: r */
    public InterfaceC0542q f1303r;

    /* renamed from: s */
    public C0362f f1304s;

    /* renamed from: t */
    public C0374r f1305t;

    /* renamed from: u */
    public AbstractC9814b f1306u;

    /* renamed from: v */
    public ActionBarContextView f1307v;

    /* renamed from: w */
    public PopupWindow f1308w;

    /* renamed from: x */
    public Runnable f1309x;

    /* renamed from: y */
    public C9615n0 f1310y;

    /* renamed from: z */
    public boolean f1311z;

    public class ListMenuDecorView extends ContentFrameLayout {
        public ListMenuDecorView(Context context) {
            super(context);
        }

        /* renamed from: b */
        public final boolean m2146b(int i10, int i11) {
            return i10 < -5 || i11 < -5 || i10 > getWidth() + 5 || i11 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.m2113e0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !m2146b((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            AppCompatDelegateImpl.this.m2098Y(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i10) {
            setBackgroundDrawable(C8968a.m56743b(getContext(), i10));
        }
    }

    public static final class PanelFeatureState {

        /* renamed from: a */
        public int f1313a;

        /* renamed from: b */
        public int f1314b;

        /* renamed from: c */
        public int f1315c;

        /* renamed from: d */
        public int f1316d;

        /* renamed from: e */
        public int f1317e;

        /* renamed from: f */
        public int f1318f;

        /* renamed from: g */
        public ViewGroup f1319g;

        /* renamed from: h */
        public View f1320h;

        /* renamed from: i */
        public View f1321i;

        /* renamed from: j */
        public MenuBuilder f1322j;

        /* renamed from: k */
        public C0408e f1323k;

        /* renamed from: l */
        public Context f1324l;

        /* renamed from: m */
        public boolean f1325m;

        /* renamed from: n */
        public boolean f1326n;

        /* renamed from: o */
        public boolean f1327o;

        /* renamed from: p */
        public boolean f1328p;

        /* renamed from: q */
        public boolean f1329q = false;

        /* renamed from: r */
        public boolean f1330r;

        /* renamed from: s */
        public Bundle f1331s;

        @SuppressLint({"BanParcelableUsage"})
        public static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new C0356a();

            /* renamed from: a */
            public int f1332a;

            /* renamed from: b */
            public boolean f1333b;

            /* renamed from: c */
            public Bundle f1334c;

            /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState$SavedState$a */
            public class C0356a implements Parcelable.ClassLoaderCreator<SavedState> {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.m2151a(parcel, null);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                /* renamed from: b */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.m2151a(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: c */
                public SavedState[] newArray(int i10) {
                    return new SavedState[i10];
                }
            }

            /* renamed from: a */
            public static SavedState m2151a(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.f1332a = parcel.readInt();
                boolean z10 = parcel.readInt() == 1;
                savedState.f1333b = z10;
                if (z10) {
                    savedState.f1334c = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i10) {
                parcel.writeInt(this.f1332a);
                parcel.writeInt(this.f1333b ? 1 : 0);
                if (this.f1333b) {
                    parcel.writeBundle(this.f1334c);
                }
            }
        }

        public PanelFeatureState(int i10) {
            this.f1313a = i10;
        }

        /* renamed from: a */
        public InterfaceC0415l m2147a(InterfaceC0414k.a aVar) {
            if (this.f1322j == null) {
                return null;
            }
            if (this.f1323k == null) {
                C0408e c0408e = new C0408e(this.f1324l, R$layout.abc_list_menu_item_layout);
                this.f1323k = c0408e;
                c0408e.mo2417f(aVar);
                this.f1322j.m2364b(this.f1323k);
            }
            return this.f1323k.m2457l(this.f1319g);
        }

        /* renamed from: b */
        public boolean m2148b() {
            if (this.f1320h == null) {
                return false;
            }
            return this.f1321i != null || this.f1323k.m2456j().getCount() > 0;
        }

        /* renamed from: c */
        public void m2149c(MenuBuilder menuBuilder) {
            C0408e c0408e;
            MenuBuilder menuBuilder2 = this.f1322j;
            if (menuBuilder == menuBuilder2) {
                return;
            }
            if (menuBuilder2 != null) {
                menuBuilder2.m2352Q(this.f1323k);
            }
            this.f1322j = menuBuilder;
            if (menuBuilder == null || (c0408e = this.f1323k) == null) {
                return;
            }
            menuBuilder.m2364b(c0408e);
        }

        /* renamed from: d */
        public void m2150d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme themeNewTheme = context.getResources().newTheme();
            themeNewTheme.setTo(context.getTheme());
            themeNewTheme.resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                themeNewTheme.applyStyle(i10, true);
            }
            themeNewTheme.resolveAttribute(R$attr.panelMenuListTheme, typedValue, true);
            int i11 = typedValue.resourceId;
            if (i11 != 0) {
                themeNewTheme.applyStyle(i11, true);
            } else {
                themeNewTheme.applyStyle(R$style.Theme_AppCompat_CompactMenu, true);
            }
            C9816d c9816d = new C9816d(context, 0);
            c9816d.getTheme().setTo(themeNewTheme);
            this.f1324l = c9816d;
            TypedArray typedArrayObtainStyledAttributes = c9816d.obtainStyledAttributes(R$styleable.AppCompatTheme);
            this.f1314b = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_panelBackground, 0);
            this.f1318f = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$a */
    public class RunnableC0357a implements Runnable {
        public RunnableC0357a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl.f1286a0 & 1) != 0) {
                appCompatDelegateImpl.m2114f0(0);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl2.f1286a0 & 4096) != 0) {
                appCompatDelegateImpl2.m2114f0(108);
            }
            AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl3.f1285Z = false;
            appCompatDelegateImpl3.f1286a0 = 0;
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$b */
    public class C0358b implements InterfaceC9586b0 {
        public C0358b() {
        }

        @Override // p273f0.InterfaceC9586b0
        public C9625s0 onApplyWindowInsets(View view, C9625s0 c9625s0) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            int iM60160l = c9625s0.m60160l();
            int iM2109c1 = AppCompatDelegateImpl.this.m2109c1(c9625s0, null);
            if (iM60160l != iM2109c1) {
                c9625s0 = c9625s0.m60164q(c9625s0.m60158j(), iM2109c1, c9625s0.m60159k(), c9625s0.m60157i());
            }
            return C9603h0.m59874b0(view, c9625s0);
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$c */
    public class C0359c implements ContentFrameLayout.InterfaceC0460a {
        public C0359c() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.InterfaceC0460a
        /* renamed from: a */
        public void mo2155a() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.InterfaceC0460a
        public void onDetachedFromWindow() {
            AppCompatDelegateImpl.this.m2110d0();
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$d */
    public class RunnableC0360d implements Runnable {

        /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$d$a */
        public class a extends C9619p0 {
            public a() {
            }

            @Override // p273f0.InterfaceC9617o0
            /* renamed from: b */
            public void mo2156b(View view) {
                AppCompatDelegateImpl.this.f1307v.setAlpha(1.0f);
                AppCompatDelegateImpl.this.f1310y.m60113h(null);
                AppCompatDelegateImpl.this.f1310y = null;
            }

            @Override // p273f0.C9619p0, p273f0.InterfaceC9617o0
            /* renamed from: c */
            public void mo2157c(View view) {
                AppCompatDelegateImpl.this.f1307v.setVisibility(0);
            }
        }

        public RunnableC0360d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            appCompatDelegateImpl.f1308w.showAtLocation(appCompatDelegateImpl.f1307v, 55, 0, 0);
            AppCompatDelegateImpl.this.m2116g0();
            if (!AppCompatDelegateImpl.this.m2085R0()) {
                AppCompatDelegateImpl.this.f1307v.setAlpha(1.0f);
                AppCompatDelegateImpl.this.f1307v.setVisibility(0);
            } else {
                AppCompatDelegateImpl.this.f1307v.setAlpha(0.0f);
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl2.f1310y = C9603h0.m59879e(appCompatDelegateImpl2.f1307v).m60108b(1.0f);
                AppCompatDelegateImpl.this.f1310y.m60113h(new a());
            }
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$e */
    public class C0361e extends C9619p0 {
        public C0361e() {
        }

        @Override // p273f0.InterfaceC9617o0
        /* renamed from: b */
        public void mo2156b(View view) {
            AppCompatDelegateImpl.this.f1307v.setAlpha(1.0f);
            AppCompatDelegateImpl.this.f1310y.m60113h(null);
            AppCompatDelegateImpl.this.f1310y = null;
        }

        @Override // p273f0.C9619p0, p273f0.InterfaceC9617o0
        /* renamed from: c */
        public void mo2157c(View view) {
            AppCompatDelegateImpl.this.f1307v.setVisibility(0);
            if (AppCompatDelegateImpl.this.f1307v.getParent() instanceof View) {
                C9603h0.m59896m0((View) AppCompatDelegateImpl.this.f1307v.getParent());
            }
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$f */
    public final class C0362f implements InterfaceC0414k.a {
        public C0362f() {
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0414k.a
        /* renamed from: a */
        public void mo2158a(MenuBuilder menuBuilder, boolean z10) {
            AppCompatDelegateImpl.this.m2094W(menuBuilder);
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0414k.a
        /* renamed from: b */
        public boolean mo2159b(MenuBuilder menuBuilder) {
            Window.Callback callbackM2133s0 = AppCompatDelegateImpl.this.m2133s0();
            if (callbackM2133s0 == null) {
                return true;
            }
            callbackM2133s0.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$g */
    public class C0363g implements AbstractC9814b.a {

        /* renamed from: a */
        public AbstractC9814b.a f1342a;

        /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$g$a */
        public class a extends C9619p0 {
            public a() {
            }

            @Override // p273f0.InterfaceC9617o0
            /* renamed from: b */
            public void mo2156b(View view) {
                AppCompatDelegateImpl.this.f1307v.setVisibility(8);
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                PopupWindow popupWindow = appCompatDelegateImpl.f1308w;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (appCompatDelegateImpl.f1307v.getParent() instanceof View) {
                    C9603h0.m59896m0((View) AppCompatDelegateImpl.this.f1307v.getParent());
                }
                AppCompatDelegateImpl.this.f1307v.m2531k();
                AppCompatDelegateImpl.this.f1310y.m60113h(null);
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl2.f1310y = null;
                C9603h0.m59896m0(appCompatDelegateImpl2.f1261B);
            }
        }

        public C0363g(AbstractC9814b.a aVar) {
            this.f1342a = aVar;
        }

        @Override // p303g.AbstractC9814b.a
        /* renamed from: a */
        public boolean mo2160a(AbstractC9814b abstractC9814b, MenuItem menuItem) {
            return this.f1342a.mo2160a(abstractC9814b, menuItem);
        }

        @Override // p303g.AbstractC9814b.a
        /* renamed from: b */
        public void mo2161b(AbstractC9814b abstractC9814b) {
            this.f1342a.mo2161b(abstractC9814b);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.f1308w != null) {
                appCompatDelegateImpl.f1297l.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.f1309x);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl2.f1307v != null) {
                appCompatDelegateImpl2.m2116g0();
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl3.f1310y = C9603h0.m59879e(appCompatDelegateImpl3.f1307v).m60108b(0.0f);
                AppCompatDelegateImpl.this.f1310y.m60113h(new a());
            }
            AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl.this;
            InterfaceC0376a interfaceC0376a = appCompatDelegateImpl4.f1299n;
            if (interfaceC0376a != null) {
                interfaceC0376a.mo2036b(appCompatDelegateImpl4.f1306u);
            }
            AppCompatDelegateImpl appCompatDelegateImpl5 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl5.f1306u = null;
            C9603h0.m59896m0(appCompatDelegateImpl5.f1261B);
            AppCompatDelegateImpl.this.m2104a1();
        }

        @Override // p303g.AbstractC9814b.a
        /* renamed from: c */
        public boolean mo2162c(AbstractC9814b abstractC9814b, Menu menu) {
            C9603h0.m59896m0(AppCompatDelegateImpl.this.f1261B);
            return this.f1342a.mo2162c(abstractC9814b, menu);
        }

        @Override // p303g.AbstractC9814b.a
        /* renamed from: d */
        public boolean mo2163d(AbstractC9814b abstractC9814b, Menu menu) {
            return this.f1342a.mo2163d(abstractC9814b, menu);
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$h */
    public static class C0364h {
        /* renamed from: a */
        public static Context m2164a(Context context, Configuration configuration) {
            return context.createConfigurationContext(configuration);
        }

        /* renamed from: b */
        public static void m2165b(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i10 = configuration.densityDpi;
            int i11 = configuration2.densityDpi;
            if (i10 != i11) {
                configuration3.densityDpi = i11;
            }
        }

        /* renamed from: c */
        public static void m2166c(Configuration configuration, Locale locale) {
            configuration.setLayoutDirection(locale);
        }

        /* renamed from: d */
        public static void m2167d(Configuration configuration, Locale locale) {
            configuration.setLocale(locale);
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$i */
    public static class C0365i {
        /* renamed from: a */
        public static boolean m2168a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }

        /* renamed from: b */
        public static String m2169b(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$j */
    public static class C0366j {
        /* renamed from: a */
        public static void m2170a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (locales.equals(locales2)) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }

        /* renamed from: b */
        public static C1090f m2171b(Configuration configuration) {
            return C1090f.m6475b(configuration.getLocales().toLanguageTags());
        }

        /* renamed from: c */
        public static void m2172c(C1090f c1090f) {
            LocaleList.setDefault(LocaleList.forLanguageTags(c1090f.m6481g()));
        }

        /* renamed from: d */
        public static void m2173d(Configuration configuration, C1090f c1090f) {
            configuration.setLocales(LocaleList.forLanguageTags(c1090f.m6481g()));
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$k */
    public static class C0367k {
        /* renamed from: a */
        public static void m2174a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i10 = configuration.colorMode & 3;
            int i11 = configuration2.colorMode;
            if (i10 != (i11 & 3)) {
                configuration3.colorMode |= i11 & 3;
            }
            int i12 = configuration.colorMode & 12;
            int i13 = configuration2.colorMode;
            if (i12 != (i13 & 12)) {
                configuration3.colorMode |= i13 & 12;
            }
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$l */
    public static class C0368l {
        /* renamed from: a */
        public static OnBackInvokedDispatcher m2175a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }

        /* renamed from: b */
        public static OnBackInvokedCallback m2176b(Object obj, final AppCompatDelegateImpl appCompatDelegateImpl) {
            Objects.requireNonNull(appCompatDelegateImpl);
            OnBackInvokedCallback onBackInvokedCallback = new OnBackInvokedCallback() { // from class: androidx.appcompat.app.i
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    appCompatDelegateImpl.m2054A0();
                }
            };
            C0380e.m2212a(obj).registerOnBackInvokedCallback(Constants.MILLON, onBackInvokedCallback);
            return onBackInvokedCallback;
        }

        /* renamed from: c */
        public static void m2177c(Object obj, Object obj2) {
            C0380e.m2212a(obj).unregisterOnBackInvokedCallback(C0379d.m2211a(obj2));
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$m */
    public class C0369m extends WindowCallbackC9820h {

        /* renamed from: b */
        public boolean f1345b;

        /* renamed from: c */
        public boolean f1346c;

        /* renamed from: d */
        public boolean f1347d;

        public C0369m(Window.Callback callback) {
            super(callback);
        }

        /* renamed from: b */
        public boolean m2178b(Window.Callback callback, KeyEvent keyEvent) {
            try {
                this.f1346c = true;
                return callback.dispatchKeyEvent(keyEvent);
            } finally {
                this.f1346c = false;
            }
        }

        /* renamed from: c */
        public void m2179c(Window.Callback callback) {
            try {
                this.f1345b = true;
                callback.onContentChanged();
            } finally {
                this.f1345b = false;
            }
        }

        /* renamed from: d */
        public void m2180d(Window.Callback callback, int i10, Menu menu) {
            try {
                this.f1347d = true;
                callback.onPanelClosed(i10, menu);
            } finally {
                this.f1347d = false;
            }
        }

        @Override // p303g.WindowCallbackC9820h, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.f1346c ? m61021a().dispatchKeyEvent(keyEvent) : AppCompatDelegateImpl.this.m2113e0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // p303g.WindowCallbackC9820h, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.m2060D0(keyEvent.getKeyCode(), keyEvent);
        }

        /* renamed from: e */
        public final ActionMode m2181e(ActionMode.Callback callback) {
            C9818f.a aVar = new C9818f.a(AppCompatDelegateImpl.this.f1296k, callback);
            AbstractC9814b abstractC9814bM2091U0 = AppCompatDelegateImpl.this.m2091U0(aVar);
            if (abstractC9814bM2091U0 != null) {
                return aVar.m61010e(abstractC9814bM2091U0);
            }
            return null;
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
            if (this.f1345b) {
                m61021a().onContentChanged();
            }
        }

        @Override // p303g.WindowCallbackC9820h, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i10, Menu menu) {
            if (i10 != 0 || (menu instanceof MenuBuilder)) {
                return super.onCreatePanelMenu(i10, menu);
            }
            return false;
        }

        @Override // p303g.WindowCallbackC9820h, android.view.Window.Callback
        public View onCreatePanelView(int i10) {
            return super.onCreatePanelView(i10);
        }

        @Override // p303g.WindowCallbackC9820h, android.view.Window.Callback
        public boolean onMenuOpened(int i10, Menu menu) {
            super.onMenuOpened(i10, menu);
            AppCompatDelegateImpl.this.m2064G0(i10);
            return true;
        }

        @Override // p303g.WindowCallbackC9820h, android.view.Window.Callback
        public void onPanelClosed(int i10, Menu menu) {
            if (this.f1347d) {
                m61021a().onPanelClosed(i10, menu);
            } else {
                super.onPanelClosed(i10, menu);
                AppCompatDelegateImpl.this.m2066H0(i10);
            }
        }

        @Override // p303g.WindowCallbackC9820h, android.view.Window.Callback
        public boolean onPreparePanel(int i10, View view, Menu menu) {
            MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
            if (i10 == 0 && menuBuilder == null) {
                return false;
            }
            if (menuBuilder != null) {
                menuBuilder.m2371e0(true);
            }
            boolean zOnPreparePanel = super.onPreparePanel(i10, view, menu);
            if (menuBuilder != null) {
                menuBuilder.m2371e0(false);
            }
            return zOnPreparePanel;
        }

        @Override // p303g.WindowCallbackC9820h, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i10) {
            MenuBuilder menuBuilder;
            PanelFeatureState panelFeatureStateM2129q0 = AppCompatDelegateImpl.this.m2129q0(0, true);
            if (panelFeatureStateM2129q0 == null || (menuBuilder = panelFeatureStateM2129q0.f1322j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i10);
            } else {
                super.onProvideKeyboardShortcuts(list, menuBuilder, i10);
            }
        }

        @Override // android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        @Override // p303g.WindowCallbackC9820h, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i10) {
            return (AppCompatDelegateImpl.this.m2143y0() && i10 == 0) ? m2181e(callback) : super.onWindowStartingActionMode(callback, i10);
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$n */
    public class C0370n extends AbstractC0371o {

        /* renamed from: c */
        public final PowerManager f1349c;

        public C0370n(Context context) {
            super();
            this.f1349c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AbstractC0371o
        /* renamed from: b */
        public IntentFilter mo2182b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AbstractC0371o
        /* renamed from: c */
        public int mo2183c() {
            return C0365i.m2168a(this.f1349c) ? 2 : 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AbstractC0371o
        /* renamed from: d */
        public void mo2184d() {
            AppCompatDelegateImpl.this.m2082Q();
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$o */
    public abstract class AbstractC0371o {

        /* renamed from: a */
        public BroadcastReceiver f1351a;

        /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$o$a */
        public class a extends BroadcastReceiver {
            public a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                AbstractC0371o.this.mo2184d();
            }
        }

        public AbstractC0371o() {
        }

        /* renamed from: a */
        public void m2185a() {
            BroadcastReceiver broadcastReceiver = this.f1351a;
            if (broadcastReceiver != null) {
                try {
                    AppCompatDelegateImpl.this.f1296k.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f1351a = null;
            }
        }

        /* renamed from: b */
        public abstract IntentFilter mo2182b();

        /* renamed from: c */
        public abstract int mo2183c();

        /* renamed from: d */
        public abstract void mo2184d();

        /* renamed from: e */
        public void m2186e() {
            m2185a();
            IntentFilter intentFilterMo2182b = mo2182b();
            if (intentFilterMo2182b == null || intentFilterMo2182b.countActions() == 0) {
                return;
            }
            if (this.f1351a == null) {
                this.f1351a = new a();
            }
            AppCompatDelegateImpl.this.f1296k.registerReceiver(this.f1351a, intentFilterMo2182b);
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$p */
    public class C0372p extends AbstractC0371o {

        /* renamed from: c */
        public final C0392q f1354c;

        public C0372p(C0392q c0392q) {
            super();
            this.f1354c = c0392q;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AbstractC0371o
        /* renamed from: b */
        public IntentFilter mo2182b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AbstractC0371o
        /* renamed from: c */
        public int mo2183c() {
            return this.f1354c.m2257d() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AbstractC0371o
        /* renamed from: d */
        public void mo2184d() {
            AppCompatDelegateImpl.this.m2082Q();
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$q */
    public static class C0373q {
        /* renamed from: a */
        public static void m2187a(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$r */
    public final class C0374r implements InterfaceC0414k.a {
        public C0374r() {
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0414k.a
        /* renamed from: a */
        public void mo2158a(MenuBuilder menuBuilder, boolean z10) {
            MenuBuilder menuBuilderMo2341F = menuBuilder.mo2341F();
            boolean z11 = menuBuilderMo2341F != menuBuilder;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z11) {
                menuBuilder = menuBuilderMo2341F;
            }
            PanelFeatureState panelFeatureStateM2120j0 = appCompatDelegateImpl.m2120j0(menuBuilder);
            if (panelFeatureStateM2120j0 != null) {
                if (!z11) {
                    AppCompatDelegateImpl.this.m2100Z(panelFeatureStateM2120j0, z10);
                } else {
                    AppCompatDelegateImpl.this.m2092V(panelFeatureStateM2120j0.f1313a, panelFeatureStateM2120j0, menuBuilderMo2341F);
                    AppCompatDelegateImpl.this.m2100Z(panelFeatureStateM2120j0, true);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.InterfaceC0414k.a
        /* renamed from: b */
        public boolean mo2159b(MenuBuilder menuBuilder) {
            Window.Callback callbackM2133s0;
            if (menuBuilder != menuBuilder.mo2341F()) {
                return true;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (!appCompatDelegateImpl.f1266G || (callbackM2133s0 = appCompatDelegateImpl.m2133s0()) == null || AppCompatDelegateImpl.this.f1277R) {
                return true;
            }
            callbackM2133s0.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    public AppCompatDelegateImpl(Activity activity, InterfaceC0376a interfaceC0376a) {
        this(activity, null, interfaceC0376a, activity);
    }

    /* renamed from: k0 */
    public static Configuration m2052k0(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            float f10 = configuration.fontScale;
            float f11 = configuration2.fontScale;
            if (f10 != f11) {
                configuration3.fontScale = f11;
            }
            int i10 = configuration.mcc;
            int i11 = configuration2.mcc;
            if (i10 != i11) {
                configuration3.mcc = i11;
            }
            int i12 = configuration.mnc;
            int i13 = configuration2.mnc;
            if (i12 != i13) {
                configuration3.mnc = i13;
            }
            C0366j.m2170a(configuration, configuration2, configuration3);
            int i14 = configuration.touchscreen;
            int i15 = configuration2.touchscreen;
            if (i14 != i15) {
                configuration3.touchscreen = i15;
            }
            int i16 = configuration.keyboard;
            int i17 = configuration2.keyboard;
            if (i16 != i17) {
                configuration3.keyboard = i17;
            }
            int i18 = configuration.keyboardHidden;
            int i19 = configuration2.keyboardHidden;
            if (i18 != i19) {
                configuration3.keyboardHidden = i19;
            }
            int i20 = configuration.navigation;
            int i21 = configuration2.navigation;
            if (i20 != i21) {
                configuration3.navigation = i21;
            }
            int i22 = configuration.navigationHidden;
            int i23 = configuration2.navigationHidden;
            if (i22 != i23) {
                configuration3.navigationHidden = i23;
            }
            int i24 = configuration.orientation;
            int i25 = configuration2.orientation;
            if (i24 != i25) {
                configuration3.orientation = i25;
            }
            int i26 = configuration.screenLayout & 15;
            int i27 = configuration2.screenLayout;
            if (i26 != (i27 & 15)) {
                configuration3.screenLayout |= i27 & 15;
            }
            int i28 = configuration.screenLayout & 192;
            int i29 = configuration2.screenLayout;
            if (i28 != (i29 & 192)) {
                configuration3.screenLayout |= i29 & 192;
            }
            int i30 = configuration.screenLayout & 48;
            int i31 = configuration2.screenLayout;
            if (i30 != (i31 & 48)) {
                configuration3.screenLayout |= i31 & 48;
            }
            int i32 = configuration.screenLayout & 768;
            int i33 = configuration2.screenLayout;
            if (i32 != (i33 & 768)) {
                configuration3.screenLayout |= i33 & 768;
            }
            C0367k.m2174a(configuration, configuration2, configuration3);
            int i34 = configuration.uiMode & 15;
            int i35 = configuration2.uiMode;
            if (i34 != (i35 & 15)) {
                configuration3.uiMode |= i35 & 15;
            }
            int i36 = configuration.uiMode & 48;
            int i37 = configuration2.uiMode;
            if (i36 != (i37 & 48)) {
                configuration3.uiMode |= i37 & 48;
            }
            int i38 = configuration.screenWidthDp;
            int i39 = configuration2.screenWidthDp;
            if (i38 != i39) {
                configuration3.screenWidthDp = i39;
            }
            int i40 = configuration.screenHeightDp;
            int i41 = configuration2.screenHeightDp;
            if (i40 != i41) {
                configuration3.screenHeightDp = i41;
            }
            int i42 = configuration.smallestScreenWidthDp;
            int i43 = configuration2.smallestScreenWidthDp;
            if (i42 != i43) {
                configuration3.smallestScreenWidthDp = i43;
            }
            C0364h.m2165b(configuration, configuration2, configuration3);
        }
        return configuration3;
    }

    @Override // androidx.appcompat.app.AbstractC0378c
    /* renamed from: A */
    public void mo2053A() {
        ActionBar actionBarMo2130r = mo2130r();
        if (actionBarMo2130r != null) {
            actionBarMo2130r.mo1986s(true);
        }
    }

    /* renamed from: A0 */
    public boolean m2054A0() {
        boolean z10 = this.f1274O;
        this.f1274O = false;
        PanelFeatureState panelFeatureStateM2129q0 = m2129q0(0, false);
        if (panelFeatureStateM2129q0 != null && panelFeatureStateM2129q0.f1327o) {
            if (!z10) {
                m2100Z(panelFeatureStateM2129q0, true);
            }
            return true;
        }
        AbstractC9814b abstractC9814b = this.f1306u;
        if (abstractC9814b != null) {
            abstractC9814b.mo2285c();
            return true;
        }
        ActionBar actionBarMo2130r = mo2130r();
        return actionBarMo2130r != null && actionBarMo2130r.mo1975h();
    }

    @Override // androidx.appcompat.app.AbstractC0378c
    /* renamed from: B */
    public void mo2055B(Bundle bundle) {
    }

    /* renamed from: B0 */
    public boolean m2056B0(int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            this.f1274O = (keyEvent.getFlags() & 128) != 0;
        } else if (i10 == 82) {
            m2058C0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.AbstractC0378c
    /* renamed from: C */
    public void mo2057C() throws PackageManager.NameNotFoundException {
        m2080P(true, false);
    }

    /* renamed from: C0 */
    public final boolean m2058C0(int i10, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        PanelFeatureState panelFeatureStateM2129q0 = m2129q0(i10, true);
        if (panelFeatureStateM2129q0.f1327o) {
            return false;
        }
        return m2076M0(panelFeatureStateM2129q0, keyEvent);
    }

    @Override // androidx.appcompat.app.AbstractC0378c
    /* renamed from: D */
    public void mo2059D() {
        ActionBar actionBarMo2130r = mo2130r();
        if (actionBarMo2130r != null) {
            actionBarMo2130r.mo1986s(false);
        }
    }

    /* renamed from: D0 */
    public boolean m2060D0(int i10, KeyEvent keyEvent) {
        ActionBar actionBarMo2130r = mo2130r();
        if (actionBarMo2130r != null && actionBarMo2130r.mo1982o(i10, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.f1273N;
        if (panelFeatureState != null && m2074L0(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            PanelFeatureState panelFeatureState2 = this.f1273N;
            if (panelFeatureState2 != null) {
                panelFeatureState2.f1326n = true;
            }
            return true;
        }
        if (this.f1273N == null) {
            PanelFeatureState panelFeatureStateM2129q0 = m2129q0(0, true);
            m2076M0(panelFeatureStateM2129q0, keyEvent);
            boolean zM2074L0 = m2074L0(panelFeatureStateM2129q0, keyEvent.getKeyCode(), keyEvent, 1);
            panelFeatureStateM2129q0.f1325m = false;
            if (zM2074L0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: E0 */
    public boolean m2061E0(int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            if (i10 == 82) {
                m2062F0(0, keyEvent);
                return true;
            }
        } else if (m2054A0()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x0060  */
    /* renamed from: F0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m2062F0(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            g.b r0 = r4.f1306u
            r1 = 0
            if (r0 == 0) goto L6
            return r1
        L6:
            r0 = 1
            androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r2 = r4.m2129q0(r5, r0)
            if (r5 != 0) goto L43
            androidx.appcompat.widget.q r5 = r4.f1303r
            if (r5 == 0) goto L43
            boolean r5 = r5.mo2539d()
            if (r5 == 0) goto L43
            android.content.Context r5 = r4.f1296k
            android.view.ViewConfiguration r5 = android.view.ViewConfiguration.get(r5)
            boolean r5 = r5.hasPermanentMenuKey()
            if (r5 != 0) goto L43
            androidx.appcompat.widget.q r5 = r4.f1303r
            boolean r5 = r5.mo2537b()
            if (r5 != 0) goto L3c
            boolean r5 = r4.f1277R
            if (r5 != 0) goto L60
            boolean r5 = r4.m2076M0(r2, r6)
            if (r5 == 0) goto L60
            androidx.appcompat.widget.q r5 = r4.f1303r
            boolean r0 = r5.mo2542g()
            goto L66
        L3c:
            androidx.appcompat.widget.q r5 = r4.f1303r
            boolean r0 = r5.mo2541f()
            goto L66
        L43:
            boolean r5 = r2.f1327o
            if (r5 != 0) goto L62
            boolean r3 = r2.f1326n
            if (r3 == 0) goto L4c
            goto L62
        L4c:
            boolean r5 = r2.f1325m
            if (r5 == 0) goto L60
            boolean r5 = r2.f1330r
            if (r5 == 0) goto L5c
            r2.f1325m = r1
            boolean r5 = r4.m2076M0(r2, r6)
            if (r5 == 0) goto L60
        L5c:
            r4.m2070J0(r2, r6)
            goto L66
        L60:
            r0 = r1
            goto L66
        L62:
            r4.m2100Z(r2, r0)
            r0 = r5
        L66:
            if (r0 == 0) goto L83
            android.content.Context r4 = r4.f1296k
            android.content.Context r4 = r4.getApplicationContext()
            java.lang.String r5 = "audio"
            java.lang.Object r4 = r4.getSystemService(r5)
            android.media.AudioManager r4 = (android.media.AudioManager) r4
            if (r4 == 0) goto L7c
            r4.playSoundEffect(r1)
            goto L83
        L7c:
            java.lang.String r4 = "AppCompatDelegate"
            java.lang.String r5 = "Couldn't get audio manager"
            android.util.Log.w(r4, r5)
        L83:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.m2062F0(int, android.view.KeyEvent):boolean");
    }

    @Override // androidx.appcompat.app.AbstractC0378c
    /* renamed from: G */
    public boolean mo2063G(int i10) {
        int iM2079O0 = m2079O0(i10);
        if (this.f1270K && iM2079O0 == 108) {
            return false;
        }
        if (this.f1266G && iM2079O0 == 1) {
            this.f1266G = false;
        }
        if (iM2079O0 == 1) {
            m2095W0();
            this.f1270K = true;
            return true;
        }
        if (iM2079O0 == 2) {
            m2095W0();
            this.f1264E = true;
            return true;
        }
        if (iM2079O0 == 5) {
            m2095W0();
            this.f1265F = true;
            return true;
        }
        if (iM2079O0 == 10) {
            m2095W0();
            this.f1268I = true;
            return true;
        }
        if (iM2079O0 == 108) {
            m2095W0();
            this.f1266G = true;
            return true;
        }
        if (iM2079O0 != 109) {
            return this.f1297l.requestFeature(iM2079O0);
        }
        m2095W0();
        this.f1267H = true;
        return true;
    }

    /* renamed from: G0 */
    public void m2064G0(int i10) {
        ActionBar actionBarMo2130r;
        if (i10 != 108 || (actionBarMo2130r = mo2130r()) == null) {
            return;
        }
        actionBarMo2130r.mo1976i(true);
    }

    @Override // androidx.appcompat.app.AbstractC0378c
    /* renamed from: H */
    public void mo2065H(int i10) {
        m2117h0();
        ViewGroup viewGroup = (ViewGroup) this.f1261B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f1296k).inflate(i10, viewGroup);
        this.f1298m.m2179c(this.f1297l.getCallback());
    }

    /* renamed from: H0 */
    public void m2066H0(int i10) {
        if (i10 == 108) {
            ActionBar actionBarMo2130r = mo2130r();
            if (actionBarMo2130r != null) {
                actionBarMo2130r.mo1976i(false);
                return;
            }
            return;
        }
        if (i10 == 0) {
            PanelFeatureState panelFeatureStateM2129q0 = m2129q0(i10, true);
            if (panelFeatureStateM2129q0.f1327o) {
                m2100Z(panelFeatureStateM2129q0, false);
            }
        }
    }

    @Override // androidx.appcompat.app.AbstractC0378c
    /* renamed from: I */
    public void mo2067I(View view) {
        m2117h0();
        ViewGroup viewGroup = (ViewGroup) this.f1261B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f1298m.m2179c(this.f1297l.getCallback());
    }

    /* renamed from: I0 */
    public void m2068I0(ViewGroup viewGroup) {
    }

    @Override // androidx.appcompat.app.AbstractC0378c
    /* renamed from: J */
    public void mo2069J(View view, ViewGroup.LayoutParams layoutParams) {
        m2117h0();
        ViewGroup viewGroup = (ViewGroup) this.f1261B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f1298m.m2179c(this.f1297l.getCallback());
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:141:? A[RETURN, SYNTHETIC] */
    /* renamed from: J0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m2070J0(androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState r12, android.view.KeyEvent r13) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.m2070J0(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, android.view.KeyEvent):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x002c  */
    @Override // androidx.appcompat.app.AbstractC0378c
    /* renamed from: K */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo2071K(android.window.OnBackInvokedDispatcher r3) {
        /*
            r2 = this;
            super.mo2071K(r3)
            android.window.OnBackInvokedDispatcher r0 = r2.f1293h0
            if (r0 == 0) goto L11
            android.window.OnBackInvokedCallback r1 = r2.f1294i0
            if (r1 == 0) goto L11
            androidx.appcompat.app.AppCompatDelegateImpl.C0368l.m2177c(r0, r1)
            r0 = 0
            r2.f1294i0 = r0
        L11:
            if (r3 != 0) goto L2c
            java.lang.Object r0 = r2.f1295j
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L2c
            android.app.Activity r0 = (android.app.Activity) r0
            android.view.Window r0 = r0.getWindow()
            if (r0 == 0) goto L2c
            java.lang.Object r3 = r2.f1295j
            android.app.Activity r3 = (android.app.Activity) r3
            android.window.OnBackInvokedDispatcher r3 = androidx.appcompat.app.AppCompatDelegateImpl.C0368l.m2175a(r3)
            r2.f1293h0 = r3
            goto L2e
        L2c:
            r2.f1293h0 = r3
        L2e:
            r2.m2104a1()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.mo2071K(android.window.OnBackInvokedDispatcher):void");
    }

    /* renamed from: K0 */
    public final ActionBar m2072K0() {
        return this.f1300o;
    }

    @Override // androidx.appcompat.app.AbstractC0378c
    /* renamed from: L */
    public void mo2073L(int i10) {
        this.f1280U = i10;
    }

    /* renamed from: L0 */
    public final boolean m2074L0(PanelFeatureState panelFeatureState, int i10, KeyEvent keyEvent, int i11) {
        MenuBuilder menuBuilder;
        boolean zPerformShortcut = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.f1325m || m2076M0(panelFeatureState, keyEvent)) && (menuBuilder = panelFeatureState.f1322j) != null) {
            zPerformShortcut = menuBuilder.performShortcut(i10, keyEvent, i11);
        }
        if (zPerformShortcut && (i11 & 1) == 0 && this.f1303r == null) {
            m2100Z(panelFeatureState, true);
        }
        return zPerformShortcut;
    }

    @Override // androidx.appcompat.app.AbstractC0378c
    /* renamed from: M */
    public final void mo2075M(CharSequence charSequence) {
        this.f1302q = charSequence;
        InterfaceC0542q interfaceC0542q = this.f1303r;
        if (interfaceC0542q != null) {
            interfaceC0542q.setWindowTitle(charSequence);
            return;
        }
        if (m2072K0() != null) {
            m2072K0().mo1987t(charSequence);
            return;
        }
        TextView textView = this.f1262C;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* renamed from: M0 */
    public final boolean m2076M0(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        InterfaceC0542q interfaceC0542q;
        InterfaceC0542q interfaceC0542q2;
        InterfaceC0542q interfaceC0542q3;
        if (this.f1277R) {
            return false;
        }
        if (panelFeatureState.f1325m) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.f1273N;
        if (panelFeatureState2 != null && panelFeatureState2 != panelFeatureState) {
            m2100Z(panelFeatureState2, false);
        }
        Window.Callback callbackM2133s0 = m2133s0();
        if (callbackM2133s0 != null) {
            panelFeatureState.f1321i = callbackM2133s0.onCreatePanelView(panelFeatureState.f1313a);
        }
        int i10 = panelFeatureState.f1313a;
        boolean z10 = i10 == 0 || i10 == 108;
        if (z10 && (interfaceC0542q3 = this.f1303r) != null) {
            interfaceC0542q3.mo2538c();
        }
        if (panelFeatureState.f1321i == null) {
            if (z10) {
                m2072K0();
            }
            MenuBuilder menuBuilder = panelFeatureState.f1322j;
            if (menuBuilder == null || panelFeatureState.f1330r) {
                if (menuBuilder == null && (!m2139w0(panelFeatureState) || panelFeatureState.f1322j == null)) {
                    return false;
                }
                if (z10 && this.f1303r != null) {
                    if (this.f1304s == null) {
                        this.f1304s = new C0362f();
                    }
                    this.f1303r.mo2536a(panelFeatureState.f1322j, this.f1304s);
                }
                panelFeatureState.f1322j.m2377h0();
                if (!callbackM2133s0.onCreatePanelMenu(panelFeatureState.f1313a, panelFeatureState.f1322j)) {
                    panelFeatureState.m2149c(null);
                    if (z10 && (interfaceC0542q = this.f1303r) != null) {
                        interfaceC0542q.mo2536a(null, this.f1304s);
                    }
                    return false;
                }
                panelFeatureState.f1330r = false;
            }
            panelFeatureState.f1322j.m2377h0();
            Bundle bundle = panelFeatureState.f1331s;
            if (bundle != null) {
                panelFeatureState.f1322j.m2353R(bundle);
                panelFeatureState.f1331s = null;
            }
            if (!callbackM2133s0.onPreparePanel(0, panelFeatureState.f1321i, panelFeatureState.f1322j)) {
                if (z10 && (interfaceC0542q2 = this.f1303r) != null) {
                    interfaceC0542q2.mo2536a(null, this.f1304s);
                }
                panelFeatureState.f1322j.m2375g0();
                return false;
            }
            boolean z11 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.f1328p = z11;
            panelFeatureState.f1322j.setQwertyMode(z11);
            panelFeatureState.f1322j.m2375g0();
        }
        panelFeatureState.f1325m = true;
        panelFeatureState.f1326n = false;
        this.f1273N = panelFeatureState;
        return true;
    }

    /* renamed from: N0 */
    public final void m2077N0(boolean z10) {
        InterfaceC0542q interfaceC0542q = this.f1303r;
        if (interfaceC0542q == null || !interfaceC0542q.mo2539d() || (ViewConfiguration.get(this.f1296k).hasPermanentMenuKey() && !this.f1303r.mo2540e())) {
            PanelFeatureState panelFeatureStateM2129q0 = m2129q0(0, true);
            panelFeatureStateM2129q0.f1329q = true;
            m2100Z(panelFeatureStateM2129q0, false);
            m2070J0(panelFeatureStateM2129q0, null);
            return;
        }
        Window.Callback callbackM2133s0 = m2133s0();
        if (this.f1303r.mo2537b() && z10) {
            this.f1303r.mo2541f();
            if (this.f1277R) {
                return;
            }
            callbackM2133s0.onPanelClosed(108, m2129q0(0, true).f1322j);
            return;
        }
        if (callbackM2133s0 == null || this.f1277R) {
            return;
        }
        if (this.f1285Z && (this.f1286a0 & 1) != 0) {
            this.f1297l.getDecorView().removeCallbacks(this.f1287b0);
            this.f1287b0.run();
        }
        PanelFeatureState panelFeatureStateM2129q02 = m2129q0(0, true);
        MenuBuilder menuBuilder = panelFeatureStateM2129q02.f1322j;
        if (menuBuilder == null || panelFeatureStateM2129q02.f1330r || !callbackM2133s0.onPreparePanel(0, panelFeatureStateM2129q02.f1321i, menuBuilder)) {
            return;
        }
        callbackM2133s0.onMenuOpened(108, panelFeatureStateM2129q02.f1322j);
        this.f1303r.mo2542g();
    }

    /* renamed from: O */
    public final boolean m2078O(boolean z10) {
        return m2080P(z10, true);
    }

    /* renamed from: O0 */
    public final int m2079O0(int i10) {
        if (i10 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i10 != 9) {
            return i10;
        }
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    /* renamed from: P */
    public final boolean m2080P(boolean z10, boolean z11) throws PackageManager.NameNotFoundException {
        if (this.f1277R) {
            return false;
        }
        int iM2090U = m2090U();
        int iM2145z0 = m2145z0(this.f1296k, iM2090U);
        C1090f c1090fM2088T = Build.VERSION.SDK_INT < 33 ? m2088T(this.f1296k) : null;
        if (!z11 && c1090fM2088T != null) {
            c1090fM2088T = m2128p0(this.f1296k.getResources().getConfiguration());
        }
        boolean zM2101Z0 = m2101Z0(iM2145z0, c1090fM2088T, z10);
        if (iM2090U == 0) {
            m2126o0(this.f1296k).m2186e();
        } else {
            AbstractC0371o abstractC0371o = this.f1283X;
            if (abstractC0371o != null) {
                abstractC0371o.m2185a();
            }
        }
        if (iM2090U == 3) {
            m2125n0(this.f1296k).m2186e();
        } else {
            AbstractC0371o abstractC0371o2 = this.f1284Y;
            if (abstractC0371o2 != null) {
                abstractC0371o2.m2185a();
            }
        }
        return zM2101Z0;
    }

    /* renamed from: P0 */
    public void m2081P0(Configuration configuration, C1090f c1090f) {
        C0366j.m2173d(configuration, c1090f);
    }

    /* renamed from: Q */
    public boolean m2082Q() {
        return m2078O(true);
    }

    /* renamed from: Q0 */
    public void m2083Q0(C1090f c1090f) {
        C0366j.m2172c(c1090f);
    }

    /* renamed from: R */
    public final void m2084R() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f1261B.findViewById(R.id.content);
        View decorView = this.f1297l.getDecorView();
        contentFrameLayout.m2678a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes = this.f1296k.obtainStyledAttributes(R$styleable.AppCompatTheme);
        typedArrayObtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        typedArrayObtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        int i10 = R$styleable.AppCompatTheme_windowFixedWidthMajor;
        if (typedArrayObtainStyledAttributes.hasValue(i10)) {
            typedArrayObtainStyledAttributes.getValue(i10, contentFrameLayout.getFixedWidthMajor());
        }
        int i11 = R$styleable.AppCompatTheme_windowFixedWidthMinor;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            typedArrayObtainStyledAttributes.getValue(i11, contentFrameLayout.getFixedWidthMinor());
        }
        int i12 = R$styleable.AppCompatTheme_windowFixedHeightMajor;
        if (typedArrayObtainStyledAttributes.hasValue(i12)) {
            typedArrayObtainStyledAttributes.getValue(i12, contentFrameLayout.getFixedHeightMajor());
        }
        int i13 = R$styleable.AppCompatTheme_windowFixedHeightMinor;
        if (typedArrayObtainStyledAttributes.hasValue(i13)) {
            typedArrayObtainStyledAttributes.getValue(i13, contentFrameLayout.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    /* renamed from: R0 */
    public final boolean m2085R0() {
        ViewGroup viewGroup;
        return this.f1260A && (viewGroup = this.f1261B) != null && C9603h0.m59864T(viewGroup);
    }

    /* renamed from: S */
    public final void m2086S(Window window) {
        if (this.f1297l != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof C0369m) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        C0369m c0369m = new C0369m(callback);
        this.f1298m = c0369m;
        window.setCallback(c0369m);
        C0523e0 c0523e0M2945u = C0523e0.m2945u(this.f1296k, null, f1257l0);
        Drawable drawableM2954h = c0523e0M2945u.m2954h(0);
        if (drawableM2954h != null) {
            window.setBackgroundDrawable(drawableM2954h);
        }
        c0523e0M2945u.m2966w();
        this.f1297l = window;
        if (Build.VERSION.SDK_INT < 33 || this.f1293h0 != null) {
            return;
        }
        mo2071K(null);
    }

    /* renamed from: S0 */
    public final boolean m2087S0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f1297l.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || C9603h0.m59863S((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    /* renamed from: T */
    public C1090f m2088T(Context context) {
        C1090f c1090fM2204q;
        if (Build.VERSION.SDK_INT >= 33 || (c1090fM2204q = AbstractC0378c.m2204q()) == null) {
            return null;
        }
        C1090f c1090fM2128p0 = m2128p0(context.getApplicationContext().getResources().getConfiguration());
        C1090f c1090fM2251b = C0390o.m2251b(c1090fM2204q, c1090fM2128p0);
        return c1090fM2251b.m6479e() ? c1090fM2128p0 : c1090fM2251b;
    }

    /* renamed from: T0 */
    public boolean m2089T0() {
        if (this.f1293h0 == null) {
            return false;
        }
        PanelFeatureState panelFeatureStateM2129q0 = m2129q0(0, false);
        return (panelFeatureStateM2129q0 != null && panelFeatureStateM2129q0.f1327o) || this.f1306u != null;
    }

    /* renamed from: U */
    public final int m2090U() {
        int i10 = this.f1279T;
        return i10 != -100 ? i10 : AbstractC0378c.m2202m();
    }

    /* renamed from: U0 */
    public AbstractC9814b m2091U0(AbstractC9814b.a aVar) {
        InterfaceC0376a interfaceC0376a;
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        AbstractC9814b abstractC9814b = this.f1306u;
        if (abstractC9814b != null) {
            abstractC9814b.mo2285c();
        }
        C0363g c0363g = new C0363g(aVar);
        ActionBar actionBarMo2130r = mo2130r();
        if (actionBarMo2130r != null) {
            AbstractC9814b abstractC9814bMo1988u = actionBarMo2130r.mo1988u(c0363g);
            this.f1306u = abstractC9814bMo1988u;
            if (abstractC9814bMo1988u != null && (interfaceC0376a = this.f1299n) != null) {
                interfaceC0376a.mo2039f(abstractC9814bMo1988u);
            }
        }
        if (this.f1306u == null) {
            this.f1306u = m2093V0(c0363g);
        }
        m2104a1();
        return this.f1306u;
    }

    /* renamed from: V */
    public void m2092V(int i10, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i10 >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.f1272M;
                if (i10 < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i10];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.f1322j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.f1327o) && !this.f1277R) {
            this.f1298m.m2180d(this.f1297l.getCallback(), i10, menu);
        }
    }

    /* renamed from: V0 */
    public AbstractC9814b m2093V0(AbstractC9814b.a aVar) {
        AbstractC9814b abstractC9814bMo2037e;
        Context c9816d;
        InterfaceC0376a interfaceC0376a;
        m2116g0();
        AbstractC9814b abstractC9814b = this.f1306u;
        if (abstractC9814b != null) {
            abstractC9814b.mo2285c();
        }
        if (!(aVar instanceof C0363g)) {
            aVar = new C0363g(aVar);
        }
        InterfaceC0376a interfaceC0376a2 = this.f1299n;
        if (interfaceC0376a2 == null || this.f1277R) {
            abstractC9814bMo2037e = null;
        } else {
            try {
                abstractC9814bMo2037e = interfaceC0376a2.mo2037e(aVar);
            } catch (AbstractMethodError unused) {
            }
        }
        if (abstractC9814bMo2037e != null) {
            this.f1306u = abstractC9814bMo2037e;
        } else {
            if (this.f1307v == null) {
                if (this.f1269J) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.f1296k.getTheme();
                    theme.resolveAttribute(R$attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = this.f1296k.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        c9816d = new C9816d(this.f1296k, 0);
                        c9816d.getTheme().setTo(themeNewTheme);
                    } else {
                        c9816d = this.f1296k;
                    }
                    this.f1307v = new ActionBarContextView(c9816d);
                    PopupWindow popupWindow = new PopupWindow(c9816d, (AttributeSet) null, R$attr.actionModePopupWindowStyle);
                    this.f1308w = popupWindow;
                    C0668i.m4060b(popupWindow, 2);
                    this.f1308w.setContentView(this.f1307v);
                    this.f1308w.setWidth(-1);
                    c9816d.getTheme().resolveAttribute(R$attr.actionBarSize, typedValue, true);
                    this.f1307v.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, c9816d.getResources().getDisplayMetrics()));
                    this.f1308w.setHeight(-2);
                    this.f1309x = new RunnableC0360d();
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.f1261B.findViewById(R$id.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(m2122l0()));
                        this.f1307v = (ActionBarContextView) viewStubCompat.m2888a();
                    }
                }
            }
            if (this.f1307v != null) {
                m2116g0();
                this.f1307v.m2531k();
                C9817e c9817e = new C9817e(this.f1307v.getContext(), this.f1307v, aVar, this.f1308w == null);
                if (aVar.mo2163d(c9817e, c9817e.mo2287e())) {
                    c9817e.mo2291k();
                    this.f1307v.m2528h(c9817e);
                    this.f1306u = c9817e;
                    if (m2085R0()) {
                        this.f1307v.setAlpha(0.0f);
                        C9615n0 c9615n0M60108b = C9603h0.m59879e(this.f1307v).m60108b(1.0f);
                        this.f1310y = c9615n0M60108b;
                        c9615n0M60108b.m60113h(new C0361e());
                    } else {
                        this.f1307v.setAlpha(1.0f);
                        this.f1307v.setVisibility(0);
                        if (this.f1307v.getParent() instanceof View) {
                            C9603h0.m59896m0((View) this.f1307v.getParent());
                        }
                    }
                    if (this.f1308w != null) {
                        this.f1297l.getDecorView().post(this.f1309x);
                    }
                } else {
                    this.f1306u = null;
                }
            }
        }
        AbstractC9814b abstractC9814b2 = this.f1306u;
        if (abstractC9814b2 != null && (interfaceC0376a = this.f1299n) != null) {
            interfaceC0376a.mo2039f(abstractC9814b2);
        }
        m2104a1();
        return this.f1306u;
    }

    /* renamed from: W */
    public void m2094W(MenuBuilder menuBuilder) {
        if (this.f1271L) {
            return;
        }
        this.f1271L = true;
        this.f1303r.mo2544i();
        Window.Callback callbackM2133s0 = m2133s0();
        if (callbackM2133s0 != null && !this.f1277R) {
            callbackM2133s0.onPanelClosed(108, menuBuilder);
        }
        this.f1271L = false;
    }

    /* renamed from: W0 */
    public final void m2095W0() {
        if (this.f1260A) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    /* renamed from: X */
    public final void m2096X() {
        AbstractC0371o abstractC0371o = this.f1283X;
        if (abstractC0371o != null) {
            abstractC0371o.m2185a();
        }
        AbstractC0371o abstractC0371o2 = this.f1284Y;
        if (abstractC0371o2 != null) {
            abstractC0371o2.m2185a();
        }
    }

    /* renamed from: X0 */
    public final AppCompatActivity m2097X0() {
        for (Context baseContext = this.f1296k; baseContext != null; baseContext = ((ContextWrapper) baseContext).getBaseContext()) {
            if (baseContext instanceof AppCompatActivity) {
                return (AppCompatActivity) baseContext;
            }
            if (!(baseContext instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    /* renamed from: Y */
    public void m2098Y(int i10) {
        m2100Z(m2129q0(i10, true), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: Y0 */
    public final void m2099Y0(Configuration configuration) {
        Activity activity = (Activity) this.f1295j;
        if (activity instanceof InterfaceC0796l) {
            if (((InterfaceC0796l) activity).mo1915g().mo4949b().m4954b(AbstractC0791h.c.CREATED)) {
                activity.onConfigurationChanged(configuration);
            }
        } else {
            if (!this.f1276Q || this.f1277R) {
                return;
            }
            activity.onConfigurationChanged(configuration);
        }
    }

    /* renamed from: Z */
    public void m2100Z(PanelFeatureState panelFeatureState, boolean z10) {
        ViewGroup viewGroup;
        InterfaceC0542q interfaceC0542q;
        if (z10 && panelFeatureState.f1313a == 0 && (interfaceC0542q = this.f1303r) != null && interfaceC0542q.mo2537b()) {
            m2094W(panelFeatureState.f1322j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f1296k.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR);
        if (windowManager != null && panelFeatureState.f1327o && (viewGroup = panelFeatureState.f1319g) != null) {
            windowManager.removeView(viewGroup);
            if (z10) {
                m2092V(panelFeatureState.f1313a, panelFeatureState, null);
            }
        }
        panelFeatureState.f1325m = false;
        panelFeatureState.f1326n = false;
        panelFeatureState.f1327o = false;
        panelFeatureState.f1320h = null;
        panelFeatureState.f1329q = true;
        if (this.f1273N == panelFeatureState) {
            this.f1273N = null;
        }
        if (panelFeatureState.f1313a == 0) {
            m2104a1();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x006f  */
    /* renamed from: Z0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m2101Z0(int r9, p024b0.C1090f r10, boolean r11) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            r8 = this;
            android.content.Context r1 = r8.f1296k
            r4 = 0
            r5 = 0
            r0 = r8
            r2 = r9
            r3 = r10
            android.content.res.Configuration r0 = r0.m2103a0(r1, r2, r3, r4, r5)
            android.content.Context r1 = r8.f1296k
            int r1 = r8.m2123m0(r1)
            android.content.res.Configuration r2 = r8.f1278S
            if (r2 != 0) goto L1f
            android.content.Context r2 = r8.f1296k
            android.content.res.Resources r2 = r2.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
        L1f:
            int r3 = r2.uiMode
            r3 = r3 & 48
            int r4 = r0.uiMode
            r4 = r4 & 48
            b0.f r2 = r8.m2128p0(r2)
            r5 = 0
            if (r10 != 0) goto L30
            r0 = r5
            goto L34
        L30:
            b0.f r0 = r8.m2128p0(r0)
        L34:
            r6 = 0
            if (r3 == r4) goto L3a
            r3 = 512(0x200, float:7.17E-43)
            goto L3b
        L3a:
            r3 = r6
        L3b:
            if (r0 == 0) goto L45
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L45
            r3 = r3 | 8196(0x2004, float:1.1485E-41)
        L45:
            int r2 = ~r1
            r2 = r2 & r3
            r7 = 1
            if (r2 == 0) goto L6f
            if (r11 == 0) goto L6f
            boolean r11 = r8.f1275P
            if (r11 == 0) goto L6f
            boolean r11 = androidx.appcompat.app.AppCompatDelegateImpl.f1258m0
            if (r11 != 0) goto L58
            boolean r11 = r8.f1276Q
            if (r11 == 0) goto L6f
        L58:
            java.lang.Object r11 = r8.f1295j
            boolean r2 = r11 instanceof android.app.Activity
            if (r2 == 0) goto L6f
            android.app.Activity r11 = (android.app.Activity) r11
            boolean r11 = r11.isChild()
            if (r11 != 0) goto L6f
            java.lang.Object r11 = r8.f1295j
            android.app.Activity r11 = (android.app.Activity) r11
            p694v.C13299a.m79750b(r11)
            r11 = r7
            goto L70
        L6f:
            r11 = r6
        L70:
            if (r11 != 0) goto L7d
            if (r3 == 0) goto L7d
            r11 = r3 & r1
            if (r11 != r3) goto L79
            r6 = r7
        L79:
            r8.m2107b1(r4, r0, r6, r5)
            goto L7e
        L7d:
            r7 = r11
        L7e:
            if (r7 == 0) goto L9a
            java.lang.Object r11 = r8.f1295j
            boolean r1 = r11 instanceof androidx.appcompat.app.AppCompatActivity
            if (r1 == 0) goto L9a
            r1 = r3 & 512(0x200, float:7.17E-43)
            if (r1 == 0) goto L8f
            androidx.appcompat.app.AppCompatActivity r11 = (androidx.appcompat.app.AppCompatActivity) r11
            r11.m2044j0(r9)
        L8f:
            r9 = r3 & 4
            if (r9 == 0) goto L9a
            java.lang.Object r9 = r8.f1295j
            androidx.appcompat.app.AppCompatActivity r9 = (androidx.appcompat.app.AppCompatActivity) r9
            r9.m2043i0(r10)
        L9a:
            if (r7 == 0) goto Laf
            if (r0 == 0) goto Laf
            android.content.Context r9 = r8.f1296k
            android.content.res.Resources r9 = r9.getResources()
            android.content.res.Configuration r9 = r9.getConfiguration()
            b0.f r9 = r8.m2128p0(r9)
            r8.m2083Q0(r9)
        Laf:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.m2101Z0(int, b0.f, boolean):boolean");
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.InterfaceC0398a
    /* renamed from: a */
    public boolean mo2102a(MenuBuilder menuBuilder, MenuItem menuItem) {
        PanelFeatureState panelFeatureStateM2120j0;
        Window.Callback callbackM2133s0 = m2133s0();
        if (callbackM2133s0 == null || this.f1277R || (panelFeatureStateM2120j0 = m2120j0(menuBuilder.mo2341F())) == null) {
            return false;
        }
        return callbackM2133s0.onMenuItemSelected(panelFeatureStateM2120j0.f1313a, menuItem);
    }

    /* renamed from: a0 */
    public final Configuration m2103a0(Context context, int i10, C1090f c1090f, Configuration configuration, boolean z10) {
        int i11 = i10 != 1 ? i10 != 2 ? z10 ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i11 | (configuration2.uiMode & (-49));
        if (c1090f != null) {
            m2081P0(configuration2, c1090f);
        }
        return configuration2;
    }

    /* renamed from: a1 */
    public void m2104a1() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean zM2089T0 = m2089T0();
            if (zM2089T0 && this.f1294i0 == null) {
                this.f1294i0 = C0368l.m2176b(this.f1293h0, this);
            } else {
                if (zM2089T0 || (onBackInvokedCallback = this.f1294i0) == null) {
                    return;
                }
                C0368l.m2177c(this.f1293h0, onBackInvokedCallback);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.InterfaceC0398a
    /* renamed from: b */
    public void mo2105b(MenuBuilder menuBuilder) {
        m2077N0(true);
    }

    /* renamed from: b0 */
    public final ViewGroup m2106b0() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        ViewGroup viewGroup;
        TypedArray typedArrayObtainStyledAttributes = this.f1296k.obtainStyledAttributes(R$styleable.AppCompatTheme);
        int i10 = R$styleable.AppCompatTheme_windowActionBar;
        if (!typedArrayObtainStyledAttributes.hasValue(i10)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowNoTitle, false)) {
            mo2063G(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(i10, false)) {
            mo2063G(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionBarOverlay, false)) {
            mo2063G(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionModeOverlay, false)) {
            mo2063G(10);
        }
        this.f1269J = typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_android_windowIsFloating, false);
        typedArrayObtainStyledAttributes.recycle();
        m2118i0();
        this.f1297l.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f1296k);
        if (this.f1270K) {
            viewGroup = this.f1268I ? (ViewGroup) layoutInflaterFrom.inflate(R$layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(R$layout.abc_screen_simple, (ViewGroup) null);
        } else if (this.f1269J) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(R$layout.abc_dialog_title_material, (ViewGroup) null);
            this.f1267H = false;
            this.f1266G = false;
        } else if (this.f1266G) {
            TypedValue typedValue = new TypedValue();
            this.f1296k.getTheme().resolveAttribute(R$attr.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new C9816d(this.f1296k, typedValue.resourceId) : this.f1296k).inflate(R$layout.abc_screen_toolbar, (ViewGroup) null);
            InterfaceC0542q interfaceC0542q = (InterfaceC0542q) viewGroup.findViewById(R$id.decor_content_parent);
            this.f1303r = interfaceC0542q;
            interfaceC0542q.setWindowCallback(m2133s0());
            if (this.f1267H) {
                this.f1303r.mo2543h(109);
            }
            if (this.f1264E) {
                this.f1303r.mo2543h(2);
            }
            if (this.f1265F) {
                this.f1303r.mo2543h(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f1266G + ", windowActionBarOverlay: " + this.f1267H + ", android:windowIsFloating: " + this.f1269J + ", windowActionModeOverlay: " + this.f1268I + ", windowNoTitle: " + this.f1270K + " }");
        }
        C9603h0.m59837C0(viewGroup, new C0358b());
        if (this.f1303r == null) {
            this.f1262C = (TextView) viewGroup.findViewById(R$id.title);
        }
        C0535k0.m3057c(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R$id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.f1297l.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f1297l.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new C0359c());
        return viewGroup;
    }

    /* renamed from: b1 */
    public final void m2107b1(int i10, C1090f c1090f, boolean z10, Configuration configuration) {
        Resources resources = this.f1296k.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i10 | (resources.getConfiguration().uiMode & (-49));
        if (c1090f != null) {
            m2081P0(configuration2, c1090f);
        }
        resources.updateConfiguration(configuration2, null);
        int i11 = this.f1280U;
        if (i11 != 0) {
            this.f1296k.setTheme(i11);
            this.f1296k.getTheme().applyStyle(this.f1280U, true);
        }
        if (z10 && (this.f1295j instanceof Activity)) {
            m2099Y0(configuration2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c0 */
    public View m2108c0(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z10;
        boolean zM2087S0 = false;
        if (this.f1291f0 == null) {
            String string = this.f1296k.obtainStyledAttributes(R$styleable.AppCompatTheme).getString(R$styleable.AppCompatTheme_viewInflaterClass);
            if (string == null) {
                this.f1291f0 = new C0386k();
            } else {
                try {
                    this.f1291f0 = (C0386k) this.f1296k.getClassLoader().loadClass(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th2) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th2);
                    this.f1291f0 = new C0386k();
                }
            }
        }
        boolean z11 = f1256k0;
        if (z11) {
            if (this.f1292g0 == null) {
                this.f1292g0 = new C0389n();
            }
            if (this.f1292g0.m2249a(attributeSet)) {
                z10 = true;
            } else {
                if (!(attributeSet instanceof XmlPullParser)) {
                    zM2087S0 = m2087S0((ViewParent) view);
                } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                    zM2087S0 = true;
                }
                z10 = zM2087S0;
            }
        } else {
            z10 = zM2087S0;
        }
        return this.f1291f0.m2235r(view, str, context, attributeSet, z10, z11, true, C0533j0.m3048c());
    }

    /* renamed from: c1 */
    public final int m2109c1(C9625s0 c9625s0, Rect rect) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        boolean z10;
        boolean z11;
        int iM60160l = c9625s0 != null ? c9625s0.m60160l() : rect != null ? rect.top : 0;
        ActionBarContextView actionBarContextView = this.f1307v;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z10 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1307v.getLayoutParams();
            if (this.f1307v.isShown()) {
                if (this.f1289d0 == null) {
                    this.f1289d0 = new Rect();
                    this.f1290e0 = new Rect();
                }
                Rect rect2 = this.f1289d0;
                Rect rect3 = this.f1290e0;
                if (c9625s0 == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(c9625s0.m60158j(), c9625s0.m60160l(), c9625s0.m60159k(), c9625s0.m60157i());
                }
                C0535k0.m3055a(this.f1261B, rect2, rect3);
                int i10 = rect2.top;
                int i11 = rect2.left;
                int i12 = rect2.right;
                C9625s0 c9625s0M59846H = C9603h0.m59846H(this.f1261B);
                int iM60158j = c9625s0M59846H == null ? 0 : c9625s0M59846H.m60158j();
                int iM60159k = c9625s0M59846H == null ? 0 : c9625s0M59846H.m60159k();
                if (marginLayoutParams.topMargin == i10 && marginLayoutParams.leftMargin == i11 && marginLayoutParams.rightMargin == i12) {
                    z11 = false;
                } else {
                    marginLayoutParams.topMargin = i10;
                    marginLayoutParams.leftMargin = i11;
                    marginLayoutParams.rightMargin = i12;
                    z11 = true;
                }
                if (i10 <= 0 || this.f1263D != null) {
                    View view = this.f1263D;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        int i13 = marginLayoutParams2.height;
                        int i14 = marginLayoutParams.topMargin;
                        if (i13 != i14 || marginLayoutParams2.leftMargin != iM60158j || marginLayoutParams2.rightMargin != iM60159k) {
                            marginLayoutParams2.height = i14;
                            marginLayoutParams2.leftMargin = iM60158j;
                            marginLayoutParams2.rightMargin = iM60159k;
                            this.f1263D.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.f1296k);
                    this.f1263D = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = iM60158j;
                    layoutParams.rightMargin = iM60159k;
                    this.f1261B.addView(this.f1263D, -1, layoutParams);
                }
                View view3 = this.f1263D;
                z = view3 != null;
                if (z && view3.getVisibility() != 0) {
                    m2111d1(this.f1263D);
                }
                if (!this.f1268I && z) {
                    iM60160l = 0;
                }
                z10 = z;
                z = z11;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z10 = false;
            } else {
                z10 = false;
                z = false;
            }
            if (z) {
                this.f1307v.setLayoutParams(marginLayoutParams);
            }
        }
        View view4 = this.f1263D;
        if (view4 != null) {
            view4.setVisibility(z10 ? 0 : 8);
        }
        return iM60160l;
    }

    /* renamed from: d0 */
    public void m2110d0() {
        MenuBuilder menuBuilder;
        InterfaceC0542q interfaceC0542q = this.f1303r;
        if (interfaceC0542q != null) {
            interfaceC0542q.mo2544i();
        }
        if (this.f1308w != null) {
            this.f1297l.getDecorView().removeCallbacks(this.f1309x);
            if (this.f1308w.isShowing()) {
                try {
                    this.f1308w.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f1308w = null;
        }
        m2116g0();
        PanelFeatureState panelFeatureStateM2129q0 = m2129q0(0, false);
        if (panelFeatureStateM2129q0 == null || (menuBuilder = panelFeatureStateM2129q0.f1322j) == null) {
            return;
        }
        menuBuilder.close();
    }

    /* renamed from: d1 */
    public final void m2111d1(View view) {
        view.setBackgroundColor((C9603h0.m59854L(view) & 8192) != 0 ? ContextCompat.getColor(this.f1296k, R$color.abc_decor_view_status_guard_light) : ContextCompat.getColor(this.f1296k, R$color.abc_decor_view_status_guard));
    }

    @Override // androidx.appcompat.app.AbstractC0378c
    /* renamed from: e */
    public void mo2112e(View view, ViewGroup.LayoutParams layoutParams) {
        m2117h0();
        ((ViewGroup) this.f1261B.findViewById(R.id.content)).addView(view, layoutParams);
        this.f1298m.m2179c(this.f1297l.getCallback());
    }

    /* renamed from: e0 */
    public boolean m2113e0(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f1295j;
        if (((obj instanceof C9616o.a) || (obj instanceof AppCompatDialog)) && (decorView = this.f1297l.getDecorView()) != null && C9616o.m60120a(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f1298m.m2178b(this.f1297l.getCallback(), keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? m2056B0(keyCode, keyEvent) : m2061E0(keyCode, keyEvent);
    }

    /* renamed from: f0 */
    public void m2114f0(int i10) {
        PanelFeatureState panelFeatureStateM2129q0;
        PanelFeatureState panelFeatureStateM2129q02 = m2129q0(i10, true);
        if (panelFeatureStateM2129q02.f1322j != null) {
            Bundle bundle = new Bundle();
            panelFeatureStateM2129q02.f1322j.m2355T(bundle);
            if (bundle.size() > 0) {
                panelFeatureStateM2129q02.f1331s = bundle;
            }
            panelFeatureStateM2129q02.f1322j.m2377h0();
            panelFeatureStateM2129q02.f1322j.clear();
        }
        panelFeatureStateM2129q02.f1330r = true;
        panelFeatureStateM2129q02.f1329q = true;
        if ((i10 != 108 && i10 != 0) || this.f1303r == null || (panelFeatureStateM2129q0 = m2129q0(0, false)) == null) {
            return;
        }
        panelFeatureStateM2129q0.f1325m = false;
        m2076M0(panelFeatureStateM2129q0, null);
    }

    @Override // androidx.appcompat.app.AbstractC0378c
    /* renamed from: g */
    public Context mo2115g(Context context) {
        this.f1275P = true;
        int iM2145z0 = m2145z0(context, m2090U());
        if (AbstractC0378c.m2205u(context)) {
            AbstractC0378c.m2196N(context);
        }
        C1090f c1090fM2088T = m2088T(context);
        if (f1259n0 && (context instanceof ContextThemeWrapper)) {
            try {
                C0373q.m2187a((ContextThemeWrapper) context, m2103a0(context, iM2145z0, c1090fM2088T, null, false));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof C9816d) {
            try {
                ((C9816d) context).m61004a(m2103a0(context, iM2145z0, c1090fM2088T, null, false));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!f1258m0) {
            return super.mo2115g(context);
        }
        Configuration configuration = new Configuration();
        configuration.uiMode = -1;
        configuration.fontScale = 0.0f;
        Configuration configuration2 = C0364h.m2164a(context, configuration).getResources().getConfiguration();
        Configuration configuration3 = context.getResources().getConfiguration();
        configuration2.uiMode = configuration3.uiMode;
        Configuration configurationM2103a0 = m2103a0(context, iM2145z0, c1090fM2088T, !configuration2.equals(configuration3) ? m2052k0(configuration2, configuration3) : null, true);
        C9816d c9816d = new C9816d(context, R$style.Theme_AppCompat_Empty);
        c9816d.m61004a(configurationM2103a0);
        try {
            if (context.getTheme() != null) {
                ResourcesCompat.ThemeCompat.rebase(c9816d.getTheme());
            }
        } catch (NullPointerException unused3) {
        }
        return super.mo2115g(c9816d);
    }

    /* renamed from: g0 */
    public void m2116g0() {
        C9615n0 c9615n0 = this.f1310y;
        if (c9615n0 != null) {
            c9615n0.m60109c();
        }
    }

    /* renamed from: h0 */
    public final void m2117h0() {
        if (this.f1260A) {
            return;
        }
        this.f1261B = m2106b0();
        CharSequence charSequenceM2131r0 = m2131r0();
        if (!TextUtils.isEmpty(charSequenceM2131r0)) {
            InterfaceC0542q interfaceC0542q = this.f1303r;
            if (interfaceC0542q != null) {
                interfaceC0542q.setWindowTitle(charSequenceM2131r0);
            } else if (m2072K0() != null) {
                m2072K0().mo1987t(charSequenceM2131r0);
            } else {
                TextView textView = this.f1262C;
                if (textView != null) {
                    textView.setText(charSequenceM2131r0);
                }
            }
        }
        m2084R();
        m2068I0(this.f1261B);
        this.f1260A = true;
        PanelFeatureState panelFeatureStateM2129q0 = m2129q0(0, false);
        if (this.f1277R) {
            return;
        }
        if (panelFeatureStateM2129q0 == null || panelFeatureStateM2129q0.f1322j == null) {
            m2141x0(108);
        }
    }

    /* renamed from: i0 */
    public final void m2118i0() {
        if (this.f1297l == null) {
            Object obj = this.f1295j;
            if (obj instanceof Activity) {
                m2086S(((Activity) obj).getWindow());
            }
        }
        if (this.f1297l == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    @Override // androidx.appcompat.app.AbstractC0378c
    /* renamed from: j */
    public <T extends View> T mo2119j(int i10) {
        m2117h0();
        return (T) this.f1297l.findViewById(i10);
    }

    /* renamed from: j0 */
    public PanelFeatureState m2120j0(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.f1272M;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i10 = 0; i10 < length; i10++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i10];
            if (panelFeatureState != null && panelFeatureState.f1322j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.app.AbstractC0378c
    /* renamed from: l */
    public Context mo2121l() {
        return this.f1296k;
    }

    /* renamed from: l0 */
    public final Context m2122l0() {
        ActionBar actionBarMo2130r = mo2130r();
        Context contextMo1978k = actionBarMo2130r != null ? actionBarMo2130r.mo1978k() : null;
        return contextMo1978k == null ? this.f1296k : contextMo1978k;
    }

    /* renamed from: m0 */
    public final int m2123m0(Context context) throws PackageManager.NameNotFoundException {
        if (!this.f1282W && (this.f1295j instanceof Activity)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return 0;
            }
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, this.f1295j.getClass()), 269221888);
                if (activityInfo != null) {
                    this.f1281V = activityInfo.configChanges;
                }
            } catch (PackageManager.NameNotFoundException e10) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e10);
                this.f1281V = 0;
            }
        }
        this.f1282W = true;
        return this.f1281V;
    }

    @Override // androidx.appcompat.app.AbstractC0378c
    /* renamed from: n */
    public int mo2124n() {
        return this.f1279T;
    }

    /* renamed from: n0 */
    public final AbstractC0371o m2125n0(Context context) {
        if (this.f1284Y == null) {
            this.f1284Y = new C0370n(context);
        }
        return this.f1284Y;
    }

    /* renamed from: o0 */
    public final AbstractC0371o m2126o0(Context context) {
        if (this.f1283X == null) {
            this.f1283X = new C0372p(C0392q.m2254a(context));
        }
        return this.f1283X;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return m2108c0(view, str, context, attributeSet);
    }

    @Override // androidx.appcompat.app.AbstractC0378c
    /* renamed from: p */
    public MenuInflater mo2127p() {
        if (this.f1301p == null) {
            m2135t0();
            ActionBar actionBar = this.f1300o;
            this.f1301p = new SupportMenuInflater(actionBar != null ? actionBar.mo1978k() : this.f1296k);
        }
        return this.f1301p;
    }

    /* renamed from: p0 */
    public C1090f m2128p0(Configuration configuration) {
        return C0366j.m2171b(configuration);
    }

    /* renamed from: q0 */
    public PanelFeatureState m2129q0(int i10, boolean z10) {
        PanelFeatureState[] panelFeatureStateArr = this.f1272M;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i10) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[i10 + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.f1272M = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i10];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i10);
        panelFeatureStateArr[i10] = panelFeatureState2;
        return panelFeatureState2;
    }

    @Override // androidx.appcompat.app.AbstractC0378c
    /* renamed from: r */
    public ActionBar mo2130r() {
        m2135t0();
        return this.f1300o;
    }

    /* renamed from: r0 */
    public final CharSequence m2131r0() {
        Object obj = this.f1295j;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.f1302q;
    }

    @Override // androidx.appcompat.app.AbstractC0378c
    /* renamed from: s */
    public void mo2132s() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f1296k);
        if (layoutInflaterFrom.getFactory() == null) {
            C9618p.m60122a(layoutInflaterFrom, this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof AppCompatDelegateImpl) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    /* renamed from: s0 */
    public final Window.Callback m2133s0() {
        return this.f1297l.getCallback();
    }

    @Override // androidx.appcompat.app.AbstractC0378c
    /* renamed from: t */
    public void mo2134t() {
        if (m2072K0() == null || mo2130r().m1979l()) {
            return;
        }
        m2141x0(0);
    }

    /* renamed from: t0 */
    public final void m2135t0() {
        m2117h0();
        if (this.f1266G && this.f1300o == null) {
            Object obj = this.f1295j;
            if (obj instanceof Activity) {
                this.f1300o = new C0393r((Activity) this.f1295j, this.f1267H);
            } else if (obj instanceof Dialog) {
                this.f1300o = new C0393r((Dialog) this.f1295j);
            }
            ActionBar actionBar = this.f1300o;
            if (actionBar != null) {
                actionBar.mo1985r(this.f1288c0);
            }
        }
    }

    /* renamed from: u0 */
    public final boolean m2136u0(PanelFeatureState panelFeatureState) {
        View view = panelFeatureState.f1321i;
        if (view != null) {
            panelFeatureState.f1320h = view;
            return true;
        }
        if (panelFeatureState.f1322j == null) {
            return false;
        }
        if (this.f1305t == null) {
            this.f1305t = new C0374r();
        }
        View view2 = (View) panelFeatureState.m2147a(this.f1305t);
        panelFeatureState.f1320h = view2;
        return view2 != null;
    }

    /* renamed from: v0 */
    public final boolean m2137v0(PanelFeatureState panelFeatureState) {
        panelFeatureState.m2150d(m2122l0());
        panelFeatureState.f1319g = new ListMenuDecorView(panelFeatureState.f1324l);
        panelFeatureState.f1315c = 81;
        return true;
    }

    @Override // androidx.appcompat.app.AbstractC0378c
    /* renamed from: w */
    public void mo2138w(Configuration configuration) throws PackageManager.NameNotFoundException {
        ActionBar actionBarMo2130r;
        if (this.f1266G && this.f1260A && (actionBarMo2130r = mo2130r()) != null) {
            actionBarMo2130r.mo1980m(configuration);
        }
        C0524f.m2968b().m2975g(this.f1296k);
        this.f1278S = new Configuration(this.f1296k.getResources().getConfiguration());
        m2080P(false, false);
    }

    /* renamed from: w0 */
    public final boolean m2139w0(PanelFeatureState panelFeatureState) {
        Resources.Theme themeNewTheme;
        Context context = this.f1296k;
        int i10 = panelFeatureState.f1313a;
        if ((i10 == 0 || i10 == 108) && this.f1303r != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(R$attr.actionBarTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                themeNewTheme = context.getResources().newTheme();
                themeNewTheme.setTo(theme);
                themeNewTheme.applyStyle(typedValue.resourceId, true);
                themeNewTheme.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
                themeNewTheme = null;
            }
            if (typedValue.resourceId != 0) {
                if (themeNewTheme == null) {
                    themeNewTheme = context.getResources().newTheme();
                    themeNewTheme.setTo(theme);
                }
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            if (themeNewTheme != null) {
                C9816d c9816d = new C9816d(context, 0);
                c9816d.getTheme().setTo(themeNewTheme);
                context = c9816d;
            }
        }
        MenuBuilder menuBuilder = new MenuBuilder(context);
        menuBuilder.mo2357V(this);
        panelFeatureState.m2149c(menuBuilder);
        return true;
    }

    @Override // androidx.appcompat.app.AbstractC0378c
    /* renamed from: x */
    public void mo2140x(Bundle bundle) {
        String strM79772c;
        this.f1275P = true;
        m2078O(false);
        m2118i0();
        Object obj = this.f1295j;
        if (obj instanceof Activity) {
            try {
                strM79772c = C13302d.m79772c((Activity) obj);
            } catch (IllegalArgumentException unused) {
                strM79772c = null;
            }
            if (strM79772c != null) {
                ActionBar actionBarM2072K0 = m2072K0();
                if (actionBarM2072K0 == null) {
                    this.f1288c0 = true;
                } else {
                    actionBarM2072K0.mo1985r(true);
                }
            }
            AbstractC0378c.m2198d(this);
        }
        this.f1278S = new Configuration(this.f1296k.getResources().getConfiguration());
        this.f1276Q = true;
    }

    /* renamed from: x0 */
    public final void m2141x0(int i10) {
        this.f1286a0 = (1 << i10) | this.f1286a0;
        if (this.f1285Z) {
            return;
        }
        C9603h0.m59886h0(this.f1297l.getDecorView(), this.f1287b0);
        this.f1285Z = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0045  */
    @Override // androidx.appcompat.app.AbstractC0378c
    /* renamed from: y */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo2142y() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f1295j
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L9
            androidx.appcompat.app.AbstractC0378c.m2194E(r3)
        L9:
            boolean r0 = r3.f1285Z
            if (r0 == 0) goto L18
            android.view.Window r0 = r3.f1297l
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.f1287b0
            r0.removeCallbacks(r1)
        L18:
            r0 = 1
            r3.f1277R = r0
            int r0 = r3.f1279T
            r1 = -100
            if (r0 == r1) goto L45
            java.lang.Object r0 = r3.f1295j
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L45
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L45
            l.g<java.lang.String, java.lang.Integer> r0 = androidx.appcompat.app.AppCompatDelegateImpl.f1255j0
            java.lang.Object r1 = r3.f1295j
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.f1279T
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L54
        L45:
            l.g<java.lang.String, java.lang.Integer> r0 = androidx.appcompat.app.AppCompatDelegateImpl.f1255j0
            java.lang.Object r1 = r3.f1295j
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L54:
            androidx.appcompat.app.ActionBar r0 = r3.f1300o
            if (r0 == 0) goto L5b
            r0.m1981n()
        L5b:
            r3.m2096X()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.mo2142y():void");
    }

    /* renamed from: y0 */
    public boolean m2143y0() {
        return this.f1311z;
    }

    @Override // androidx.appcompat.app.AbstractC0378c
    /* renamed from: z */
    public void mo2144z(Bundle bundle) {
        m2117h0();
    }

    /* renamed from: z0 */
    public int m2145z0(Context context, int i10) {
        if (i10 == -100) {
            return -1;
        }
        if (i10 != -1) {
            if (i10 == 0) {
                if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                    return -1;
                }
                return m2126o0(context).mo2183c();
            }
            if (i10 != 1 && i10 != 2) {
                if (i10 == 3) {
                    return m2125n0(context).mo2183c();
                }
                throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
            }
        }
        return i10;
    }

    public AppCompatDelegateImpl(Dialog dialog, InterfaceC0376a interfaceC0376a) {
        this(dialog.getContext(), dialog.getWindow(), interfaceC0376a, dialog);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public AppCompatDelegateImpl(Context context, Window window, InterfaceC0376a interfaceC0376a, Object obj) {
        C11213g<String, Integer> c11213g;
        Integer num;
        AppCompatActivity appCompatActivityM2097X0;
        this.f1310y = null;
        this.f1311z = true;
        this.f1279T = -100;
        this.f1287b0 = new RunnableC0357a();
        this.f1296k = context;
        this.f1299n = interfaceC0376a;
        this.f1295j = obj;
        if (this.f1279T == -100 && (obj instanceof Dialog) && (appCompatActivityM2097X0 = m2097X0()) != null) {
            this.f1279T = appCompatActivityM2097X0.m2038e0().mo2124n();
        }
        if (this.f1279T == -100 && (num = (c11213g = f1255j0).get(obj.getClass().getName())) != null) {
            this.f1279T = num.intValue();
            c11213g.remove(obj.getClass().getName());
        }
        if (window != null) {
            m2086S(window);
        }
        C0524f.m2970h();
    }
}
