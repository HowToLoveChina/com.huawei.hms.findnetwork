package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.customview.view.AbsSavedState;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.util.WeakHashMap;
import p273f0.C9603h0;
import p303g.InterfaceC9815c;
import p380j0.AbstractC10636a;

/* loaded from: classes.dex */
public class SearchView extends LinearLayoutCompat implements InterfaceC9815c {

    /* renamed from: n0 */
    public static final C0499o f2075n0 = null;

    /* renamed from: A */
    public Rect f2076A;

    /* renamed from: B */
    public int[] f2077B;

    /* renamed from: C */
    public int[] f2078C;

    /* renamed from: D */
    public final ImageView f2079D;

    /* renamed from: E */
    public final Drawable f2080E;

    /* renamed from: F */
    public final int f2081F;

    /* renamed from: G */
    public final int f2082G;

    /* renamed from: H */
    public final Intent f2083H;

    /* renamed from: I */
    public final Intent f2084I;

    /* renamed from: J */
    public final CharSequence f2085J;

    /* renamed from: K */
    public View.OnFocusChangeListener f2086K;

    /* renamed from: L */
    public View.OnClickListener f2087L;

    /* renamed from: M */
    public boolean f2088M;

    /* renamed from: N */
    public boolean f2089N;

    /* renamed from: O */
    public AbstractC10636a f2090O;

    /* renamed from: P */
    public boolean f2091P;

    /* renamed from: Q */
    public CharSequence f2092Q;

    /* renamed from: R */
    public boolean f2093R;

    /* renamed from: S */
    public boolean f2094S;

    /* renamed from: T */
    public int f2095T;

    /* renamed from: U */
    public boolean f2096U;

    /* renamed from: V */
    public CharSequence f2097V;

    /* renamed from: W */
    public CharSequence f2098W;

    /* renamed from: a0 */
    public boolean f2099a0;

    /* renamed from: b0 */
    public int f2100b0;

    /* renamed from: c0 */
    public SearchableInfo f2101c0;

    /* renamed from: d0 */
    public Bundle f2102d0;

    /* renamed from: e0 */
    public final Runnable f2103e0;

    /* renamed from: f0 */
    public Runnable f2104f0;

    /* renamed from: g0 */
    public final WeakHashMap<String, Drawable.ConstantState> f2105g0;

    /* renamed from: h0 */
    public final View.OnClickListener f2106h0;

    /* renamed from: i0 */
    public View.OnKeyListener f2107i0;

    /* renamed from: j0 */
    public final TextView.OnEditorActionListener f2108j0;

    /* renamed from: k0 */
    public final AdapterView.OnItemClickListener f2109k0;

    /* renamed from: l0 */
    public final AdapterView.OnItemSelectedListener f2110l0;

    /* renamed from: m0 */
    public TextWatcher f2111m0;

    /* renamed from: p */
    public final SearchAutoComplete f2112p;

    /* renamed from: q */
    public final View f2113q;

    /* renamed from: r */
    public final View f2114r;

    /* renamed from: s */
    public final View f2115s;

    /* renamed from: t */
    public final ImageView f2116t;

    /* renamed from: u */
    public final ImageView f2117u;

    /* renamed from: v */
    public final ImageView f2118v;

    /* renamed from: w */
    public final ImageView f2119w;

    /* renamed from: x */
    public final View f2120x;

    /* renamed from: y */
    public C0500p f2121y;

    /* renamed from: z */
    public Rect f2122z;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0483a();

        /* renamed from: d */
        public boolean f2123d;

        /* renamed from: androidx.appcompat.widget.SearchView$SavedState$a */
        public class C0483a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f2123d + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeValue(Boolean.valueOf(this.f2123d));
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2123d = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {

        /* renamed from: e */
        public int f2124e;

        /* renamed from: f */
        public SearchView f2125f;

        /* renamed from: g */
        public boolean f2126g;

        /* renamed from: h */
        public final Runnable f2127h;

        /* renamed from: androidx.appcompat.widget.SearchView$SearchAutoComplete$a */
        public class RunnableC0484a implements Runnable {
            public RunnableC0484a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchAutoComplete.this.m2810d();
            }
        }

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i10 = configuration.screenWidthDp;
            int i11 = configuration.screenHeightDp;
            if (i10 >= 960 && i11 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i10 >= 600) {
                return 192;
            }
            if (i10 < 640 || i11 < 480) {
                return RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE;
            }
            return 192;
        }

        /* renamed from: b */
        public void m2808b() {
            C0495k.m2812b(this, 1);
            if (enoughToFilter()) {
                showDropDown();
            }
        }

        /* renamed from: c */
        public boolean m2809c() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        /* renamed from: d */
        public void m2810d() {
            if (this.f2126g) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f2126g = false;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f2124e <= 0 || super.enoughToFilter();
        }

        @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f2126g) {
                removeCallbacks(this.f2127h);
                post(this.f2127h);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onFocusChanged(boolean z10, int i10, Rect rect) {
            super.onFocusChanged(z10, i10, rect);
            this.f2125f.m2792Z();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i10, KeyEvent keyEvent) {
            if (i10 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f2125f.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i10, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z10) {
            super.onWindowFocusChanged(z10);
            if (z10 && this.f2125f.hasFocus() && getVisibility() == 0) {
                this.f2126g = true;
                if (SearchView.m2768M(getContext())) {
                    m2808b();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public void replaceText(CharSequence charSequence) {
        }

        public void setImeVisibility(boolean z10) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z10) {
                this.f2126g = false;
                removeCallbacks(this.f2127h);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.f2126g = true;
                    return;
                }
                this.f2126g = false;
                removeCallbacks(this.f2127h);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        public void setSearchView(SearchView searchView) {
            this.f2125f = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i10) {
            super.setThreshold(i10);
            this.f2124e = i10;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R$attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i10) {
            super(context, attributeSet, i10);
            this.f2127h = new RunnableC0484a();
            this.f2124e = getThreshold();
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$a */
    public class C0485a implements TextWatcher {
        public C0485a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            SearchView.this.m2791Y(charSequence);
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$b */
    public class RunnableC0486b implements Runnable {
        public RunnableC0486b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchView.this.m2798f0();
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$c */
    public class RunnableC0487c implements Runnable {
        public RunnableC0487c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC10636a abstractC10636a = SearchView.this.f2090O;
            if (abstractC10636a instanceof ViewOnClickListenerC0551z) {
                abstractC10636a.mo3193a(null);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$d */
    public class ViewOnFocusChangeListenerC0488d implements View.OnFocusChangeListener {
        public ViewOnFocusChangeListenerC0488d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.f2086K;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z10);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$e */
    public class ViewOnLayoutChangeListenerC0489e implements View.OnLayoutChangeListener {
        public ViewOnLayoutChangeListenerC0489e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            SearchView.this.m2769B();
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$f */
    public class ViewOnClickListenerC0490f implements View.OnClickListener {
        public ViewOnClickListenerC0490f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.f2116t) {
                searchView.m2788V();
                return;
            }
            if (view == searchView.f2118v) {
                searchView.m2784R();
                return;
            }
            if (view == searchView.f2117u) {
                searchView.m2789W();
            } else if (view == searchView.f2119w) {
                searchView.m2793a0();
            } else if (view == searchView.f2112p) {
                searchView.m2775H();
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$g */
    public class ViewOnKeyListenerC0491g implements View.OnKeyListener {
        public ViewOnKeyListenerC0491g() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.f2101c0 == null) {
                return false;
            }
            if (searchView.f2112p.isPopupShowing() && SearchView.this.f2112p.getListSelection() != -1) {
                return SearchView.this.m2790X(view, i10, keyEvent);
            }
            if (SearchView.this.f2112p.m2809c() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i10 != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.m2782P(0, null, searchView2.f2112p.getText().toString());
            return true;
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$h */
    public class C0492h implements TextView.OnEditorActionListener {
        public C0492h() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
            SearchView.this.m2789W();
            return true;
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$i */
    public class C0493i implements AdapterView.OnItemClickListener {
        public C0493i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            SearchView.this.m2785S(i10, 0, null);
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$j */
    public class C0494j implements AdapterView.OnItemSelectedListener {
        public C0494j() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            SearchView.this.m2786T(i10);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$k */
    public static class C0495k {
        /* renamed from: a */
        public static void m2811a(AutoCompleteTextView autoCompleteTextView) {
            autoCompleteTextView.refreshAutoCompleteResults();
        }

        /* renamed from: b */
        public static void m2812b(SearchAutoComplete searchAutoComplete, int i10) {
            searchAutoComplete.setInputMethodMode(i10);
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$l */
    public interface InterfaceC0496l {
    }

    /* renamed from: androidx.appcompat.widget.SearchView$m */
    public interface InterfaceC0497m {
    }

    /* renamed from: androidx.appcompat.widget.SearchView$n */
    public interface InterfaceC0498n {
    }

    /* renamed from: androidx.appcompat.widget.SearchView$o */
    public static class C0499o {
    }

    /* renamed from: androidx.appcompat.widget.SearchView$p */
    public static class C0500p extends TouchDelegate {

        /* renamed from: a */
        public final View f2139a;

        /* renamed from: b */
        public final Rect f2140b;

        /* renamed from: c */
        public final Rect f2141c;

        /* renamed from: d */
        public final Rect f2142d;

        /* renamed from: e */
        public final int f2143e;

        /* renamed from: f */
        public boolean f2144f;

        public C0500p(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f2143e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f2140b = new Rect();
            this.f2142d = new Rect();
            this.f2141c = new Rect();
            m2813a(rect, rect2);
            this.f2139a = view;
        }

        /* renamed from: a */
        public void m2813a(Rect rect, Rect rect2) {
            this.f2140b.set(rect);
            this.f2142d.set(rect);
            Rect rect3 = this.f2142d;
            int i10 = this.f2143e;
            rect3.inset(-i10, -i10);
            this.f2141c.set(rect2);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z10;
            boolean z11;
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z12 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z11 = this.f2144f;
                    if (z11 && !this.f2142d.contains(x10, y10)) {
                        z12 = z11;
                        z10 = false;
                    }
                } else {
                    if (action == 3) {
                        z11 = this.f2144f;
                        this.f2144f = false;
                    }
                    z10 = true;
                    z12 = false;
                }
                z12 = z11;
                z10 = true;
            } else if (this.f2140b.contains(x10, y10)) {
                this.f2144f = true;
                z10 = true;
            } else {
                z10 = true;
                z12 = false;
            }
            if (!z12) {
                return false;
            }
            if (!z10 || this.f2141c.contains(x10, y10)) {
                Rect rect = this.f2141c;
                motionEvent.setLocation(x10 - rect.left, y10 - rect.top);
            } else {
                motionEvent.setLocation(this.f2139a.getWidth() / 2, this.f2139a.getHeight() / 2);
            }
            return this.f2139a.dispatchTouchEvent(motionEvent);
        }
    }

    public SearchView(Context context) {
        this(context, null);
    }

    /* renamed from: M */
    public static boolean m2768M(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R$dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R$dimen.abc_search_view_preferred_width);
    }

    private void setQuery(CharSequence charSequence) {
        this.f2112p.setText(charSequence);
        this.f2112p.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    /* renamed from: B */
    public void m2769B() {
        if (this.f2120x.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f2114r.getPaddingLeft();
            Rect rect = new Rect();
            boolean zM3056b = C0535k0.m3056b(this);
            int dimensionPixelSize = this.f2088M ? resources.getDimensionPixelSize(R$dimen.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(R$dimen.abc_dropdownitem_text_padding_left) : 0;
            this.f2112p.getDropDownBackground().getPadding(rect);
            this.f2112p.setDropDownHorizontalOffset(zM3056b ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
            this.f2112p.setDropDownWidth((((this.f2120x.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    /* renamed from: C */
    public final Intent m2770C(String str, Uri uri, String str2, String str3, int i10, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f2098W);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f2102d0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i10 != 0) {
            intent.putExtra("action_key", i10);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f2101c0.getSearchActivity());
        return intent;
    }

    /* renamed from: D */
    public final Intent m2771D(Cursor cursor, int i10, String str) {
        int position;
        String strM3189o;
        try {
            String strM3189o2 = ViewOnClickListenerC0551z.m3189o(cursor, "suggest_intent_action");
            if (strM3189o2 == null) {
                strM3189o2 = this.f2101c0.getSuggestIntentAction();
            }
            if (strM3189o2 == null) {
                strM3189o2 = "android.intent.action.SEARCH";
            }
            String str2 = strM3189o2;
            String strM3189o3 = ViewOnClickListenerC0551z.m3189o(cursor, "suggest_intent_data");
            if (strM3189o3 == null) {
                strM3189o3 = this.f2101c0.getSuggestIntentData();
            }
            if (strM3189o3 != null && (strM3189o = ViewOnClickListenerC0551z.m3189o(cursor, "suggest_intent_data_id")) != null) {
                strM3189o3 = strM3189o3 + "/" + Uri.encode(strM3189o);
            }
            return m2770C(str2, strM3189o3 == null ? null : Uri.parse(strM3189o3), ViewOnClickListenerC0551z.m3189o(cursor, "suggest_intent_extra_data"), ViewOnClickListenerC0551z.m3189o(cursor, "suggest_intent_query"), i10, str);
        } catch (RuntimeException e10) {
            try {
                position = cursor.getPosition();
            } catch (RuntimeException unused) {
                position = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + position + " returned exception.", e10);
            return null;
        }
    }

    /* renamed from: E */
    public final Intent m2772E(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f2102d0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    /* renamed from: F */
    public final Intent m2773F(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    /* renamed from: G */
    public final void m2774G() {
        this.f2112p.dismissDropDown();
    }

    /* renamed from: H */
    public void m2775H() {
        C0495k.m2811a(this.f2112p);
    }

    /* renamed from: I */
    public final void m2776I(View view, Rect rect) {
        view.getLocationInWindow(this.f2077B);
        getLocationInWindow(this.f2078C);
        int[] iArr = this.f2077B;
        int i10 = iArr[1];
        int[] iArr2 = this.f2078C;
        int i11 = i10 - iArr2[1];
        int i12 = iArr[0] - iArr2[0];
        rect.set(i12, i11, view.getWidth() + i12, view.getHeight() + i11);
    }

    /* renamed from: J */
    public final CharSequence m2777J(CharSequence charSequence) {
        if (!this.f2088M || this.f2080E == null) {
            return charSequence;
        }
        int textSize = (int) (this.f2112p.getTextSize() * 1.25d);
        this.f2080E.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f2080E), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    /* renamed from: K */
    public final boolean m2778K() {
        SearchableInfo searchableInfo = this.f2101c0;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = this.f2101c0.getVoiceSearchLaunchWebSearch() ? this.f2083H : this.f2101c0.getVoiceSearchLaunchRecognizer() ? this.f2084I : null;
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    /* renamed from: L */
    public boolean m2779L() {
        return this.f2089N;
    }

    /* renamed from: N */
    public final boolean m2780N() {
        return (this.f2091P || this.f2096U) && !m2779L();
    }

    /* renamed from: O */
    public final void m2781O(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e10) {
            Log.e("SearchView", "Failed launch activity: " + intent, e10);
        }
    }

    /* renamed from: P */
    public void m2782P(int i10, String str, String str2) {
        getContext().startActivity(m2770C("android.intent.action.SEARCH", null, null, str2, i10, str));
    }

    /* renamed from: Q */
    public final boolean m2783Q(int i10, int i11, String str) {
        Cursor cursorMo65134b = this.f2090O.mo65134b();
        if (cursorMo65134b == null || !cursorMo65134b.moveToPosition(i10)) {
            return false;
        }
        m2781O(m2771D(cursorMo65134b, i11, str));
        return true;
    }

    /* renamed from: R */
    public void m2784R() {
        if (!TextUtils.isEmpty(this.f2112p.getText())) {
            this.f2112p.setText("");
            this.f2112p.requestFocus();
            this.f2112p.setImeVisibility(true);
        } else if (this.f2088M) {
            clearFocus();
            m2803k0(true);
        }
    }

    /* renamed from: S */
    public boolean m2785S(int i10, int i11, String str) {
        m2783Q(i10, 0, null);
        this.f2112p.setImeVisibility(false);
        m2774G();
        return true;
    }

    /* renamed from: T */
    public boolean m2786T(int i10) {
        m2795c0(i10);
        return true;
    }

    /* renamed from: U */
    public void m2787U(CharSequence charSequence) {
        setQuery(charSequence);
    }

    /* renamed from: V */
    public void m2788V() {
        m2803k0(false);
        this.f2112p.requestFocus();
        this.f2112p.setImeVisibility(true);
        View.OnClickListener onClickListener = this.f2087L;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    /* renamed from: W */
    public void m2789W() {
        Editable text = this.f2112p.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        if (this.f2101c0 != null) {
            m2782P(0, null, text.toString());
        }
        this.f2112p.setImeVisibility(false);
        m2774G();
    }

    /* renamed from: X */
    public boolean m2790X(View view, int i10, KeyEvent keyEvent) {
        if (this.f2101c0 != null && this.f2090O != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i10 == 66 || i10 == 84 || i10 == 61) {
                return m2785S(this.f2112p.getListSelection(), 0, null);
            }
            if (i10 == 21 || i10 == 22) {
                this.f2112p.setSelection(i10 == 21 ? 0 : this.f2112p.length());
                this.f2112p.setListSelection(0);
                this.f2112p.clearListSelection();
                this.f2112p.m2808b();
                return true;
            }
            if (i10 == 19) {
                this.f2112p.getListSelection();
                return false;
            }
        }
        return false;
    }

    /* renamed from: Y */
    public void m2791Y(CharSequence charSequence) {
        Editable text = this.f2112p.getText();
        this.f2098W = text;
        boolean zIsEmpty = TextUtils.isEmpty(text);
        m2802j0(!zIsEmpty);
        m2804l0(zIsEmpty);
        m2797e0();
        m2801i0();
        this.f2097V = charSequence.toString();
    }

    /* renamed from: Z */
    public void m2792Z() {
        m2803k0(m2779L());
        m2794b0();
        if (this.f2112p.hasFocus()) {
            m2775H();
        }
    }

    /* renamed from: a0 */
    public void m2793a0() {
        SearchableInfo searchableInfo = this.f2101c0;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                getContext().startActivity(m2773F(this.f2083H, searchableInfo));
            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                getContext().startActivity(m2772E(this.f2084I, searchableInfo));
            }
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    /* renamed from: b0 */
    public final void m2794b0() {
        post(this.f2103e0);
    }

    @Override // p303g.InterfaceC9815c
    /* renamed from: c */
    public void mo2397c() {
        if (this.f2099a0) {
            return;
        }
        this.f2099a0 = true;
        int imeOptions = this.f2112p.getImeOptions();
        this.f2100b0 = imeOptions;
        this.f2112p.setImeOptions(imeOptions | 33554432);
        this.f2112p.setText("");
        setIconified(false);
    }

    /* renamed from: c0 */
    public final void m2795c0(int i10) {
        Editable text = this.f2112p.getText();
        Cursor cursorMo65134b = this.f2090O.mo65134b();
        if (cursorMo65134b == null) {
            return;
        }
        if (!cursorMo65134b.moveToPosition(i10)) {
            setQuery(text);
            return;
        }
        CharSequence charSequenceMo3194c = this.f2090O.mo3194c(cursorMo65134b);
        if (charSequenceMo3194c != null) {
            setQuery(charSequenceMo3194c);
        } else {
            setQuery(text);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.f2094S = true;
        super.clearFocus();
        this.f2112p.clearFocus();
        this.f2112p.setImeVisibility(false);
        this.f2094S = false;
    }

    /* renamed from: d0 */
    public void m2796d0(CharSequence charSequence, boolean z10) {
        this.f2112p.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f2112p;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f2098W = charSequence;
        }
        if (!z10 || TextUtils.isEmpty(charSequence)) {
            return;
        }
        m2789W();
    }

    /* renamed from: e0 */
    public final void m2797e0() {
        boolean z10 = true;
        boolean z11 = !TextUtils.isEmpty(this.f2112p.getText());
        if (!z11 && (!this.f2088M || this.f2099a0)) {
            z10 = false;
        }
        this.f2118v.setVisibility(z10 ? 0 : 8);
        Drawable drawable = this.f2118v.getDrawable();
        if (drawable != null) {
            drawable.setState(z11 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    @Override // p303g.InterfaceC9815c
    /* renamed from: f */
    public void mo2398f() {
        m2796d0("", false);
        clearFocus();
        m2803k0(true);
        this.f2112p.setImeOptions(this.f2100b0);
        this.f2099a0 = false;
    }

    /* renamed from: f0 */
    public void m2798f0() {
        int[] iArr = this.f2112p.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.f2114r.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f2115s.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    /* renamed from: g0 */
    public final void m2799g0() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f2112p;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(m2777J(queryHint));
    }

    public int getImeOptions() {
        return this.f2112p.getImeOptions();
    }

    public int getInputType() {
        return this.f2112p.getInputType();
    }

    public int getMaxWidth() {
        return this.f2095T;
    }

    public CharSequence getQuery() {
        return this.f2112p.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f2092Q;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f2101c0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.f2085J : getContext().getText(this.f2101c0.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.f2082G;
    }

    public int getSuggestionRowLayout() {
        return this.f2081F;
    }

    public AbstractC10636a getSuggestionsAdapter() {
        return this.f2090O;
    }

    /* renamed from: h0 */
    public final void m2800h0() {
        this.f2112p.setThreshold(this.f2101c0.getSuggestThreshold());
        this.f2112p.setImeOptions(this.f2101c0.getImeOptions());
        int inputType = this.f2101c0.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f2101c0.getSuggestAuthority() != null) {
                inputType |= 589824;
            }
        }
        this.f2112p.setInputType(inputType);
        AbstractC10636a abstractC10636a = this.f2090O;
        if (abstractC10636a != null) {
            abstractC10636a.mo3193a(null);
        }
        if (this.f2101c0.getSuggestAuthority() != null) {
            ViewOnClickListenerC0551z viewOnClickListenerC0551z = new ViewOnClickListenerC0551z(getContext(), this, this.f2101c0, this.f2105g0);
            this.f2090O = viewOnClickListenerC0551z;
            this.f2112p.setAdapter(viewOnClickListenerC0551z);
            ((ViewOnClickListenerC0551z) this.f2090O).m3209x(this.f2093R ? 2 : 1);
        }
    }

    /* renamed from: i0 */
    public final void m2801i0() {
        this.f2115s.setVisibility((m2780N() && (this.f2117u.getVisibility() == 0 || this.f2119w.getVisibility() == 0)) ? 0 : 8);
    }

    /* renamed from: j0 */
    public final void m2802j0(boolean z10) {
        this.f2117u.setVisibility((this.f2091P && m2780N() && hasFocus() && (z10 || !this.f2096U)) ? 0 : 8);
    }

    /* renamed from: k0 */
    public final void m2803k0(boolean z10) {
        this.f2089N = z10;
        int i10 = 8;
        int i11 = z10 ? 0 : 8;
        boolean zIsEmpty = TextUtils.isEmpty(this.f2112p.getText());
        this.f2116t.setVisibility(i11);
        m2802j0(!zIsEmpty);
        this.f2113q.setVisibility(z10 ? 8 : 0);
        if (this.f2079D.getDrawable() != null && !this.f2088M) {
            i10 = 0;
        }
        this.f2079D.setVisibility(i10);
        m2797e0();
        m2804l0(zIsEmpty);
        m2801i0();
    }

    /* renamed from: l0 */
    public final void m2804l0(boolean z10) {
        int i10 = 8;
        if (this.f2096U && !m2779L() && z10) {
            this.f2117u.setVisibility(8);
            i10 = 0;
        }
        this.f2119w.setVisibility(i10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f2103e0);
        post(this.f2104f0);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            m2776I(this.f2112p, this.f2122z);
            Rect rect = this.f2076A;
            Rect rect2 = this.f2122z;
            rect.set(rect2.left, 0, rect2.right, i13 - i11);
            C0500p c0500p = this.f2121y;
            if (c0500p != null) {
                c0500p.m2813a(this.f2076A, this.f2122z);
                return;
            }
            C0500p c0500p2 = new C0500p(this.f2076A, this.f2122z, this.f2112p);
            this.f2121y = c0500p2;
            setTouchDelegate(c0500p2);
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        if (m2779L()) {
            super.onMeasure(i10, i11);
            return;
        }
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode == Integer.MIN_VALUE) {
            int i13 = this.f2095T;
            size = i13 > 0 ? Math.min(i13, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.f2095T;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i12 = this.f2095T) > 0) {
            size = Math.min(i12, size);
        }
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        m2803k0(savedState.f2123d);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2123d = m2779L();
        return savedState;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        m2794b0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i10, Rect rect) {
        if (this.f2094S || !isFocusable()) {
            return false;
        }
        if (m2779L()) {
            return super.requestFocus(i10, rect);
        }
        boolean zRequestFocus = this.f2112p.requestFocus(i10, rect);
        if (zRequestFocus) {
            m2803k0(false);
        }
        return zRequestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.f2102d0 = bundle;
    }

    public void setIconified(boolean z10) {
        if (z10) {
            m2784R();
        } else {
            m2788V();
        }
    }

    public void setIconifiedByDefault(boolean z10) {
        if (this.f2088M == z10) {
            return;
        }
        this.f2088M = z10;
        m2803k0(z10);
        m2799g0();
    }

    public void setImeOptions(int i10) {
        this.f2112p.setImeOptions(i10);
    }

    public void setInputType(int i10) {
        this.f2112p.setInputType(i10);
    }

    public void setMaxWidth(int i10) {
        this.f2095T = i10;
        requestLayout();
    }

    public void setOnCloseListener(InterfaceC0496l interfaceC0496l) {
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f2086K = onFocusChangeListener;
    }

    public void setOnQueryTextListener(InterfaceC0497m interfaceC0497m) {
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f2087L = onClickListener;
    }

    public void setOnSuggestionListener(InterfaceC0498n interfaceC0498n) {
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f2092Q = charSequence;
        m2799g0();
    }

    public void setQueryRefinementEnabled(boolean z10) {
        this.f2093R = z10;
        AbstractC10636a abstractC10636a = this.f2090O;
        if (abstractC10636a instanceof ViewOnClickListenerC0551z) {
            ((ViewOnClickListenerC0551z) abstractC10636a).m3209x(z10 ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f2101c0 = searchableInfo;
        if (searchableInfo != null) {
            m2800h0();
            m2799g0();
        }
        boolean zM2778K = m2778K();
        this.f2096U = zM2778K;
        if (zM2778K) {
            this.f2112p.setPrivateImeOptions("nm");
        }
        m2803k0(m2779L());
    }

    public void setSubmitButtonEnabled(boolean z10) {
        this.f2091P = z10;
        m2803k0(m2779L());
    }

    public void setSuggestionsAdapter(AbstractC10636a abstractC10636a) {
        this.f2090O = abstractC10636a;
        this.f2112p.setAdapter(abstractC10636a);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2122z = new Rect();
        this.f2076A = new Rect();
        this.f2077B = new int[2];
        this.f2078C = new int[2];
        this.f2103e0 = new RunnableC0486b();
        this.f2104f0 = new RunnableC0487c();
        this.f2105g0 = new WeakHashMap<>();
        ViewOnClickListenerC0490f viewOnClickListenerC0490f = new ViewOnClickListenerC0490f();
        this.f2106h0 = viewOnClickListenerC0490f;
        this.f2107i0 = new ViewOnKeyListenerC0491g();
        C0492h c0492h = new C0492h();
        this.f2108j0 = c0492h;
        C0493i c0493i = new C0493i();
        this.f2109k0 = c0493i;
        C0494j c0494j = new C0494j();
        this.f2110l0 = c0494j;
        this.f2111m0 = new C0485a();
        int[] iArr = R$styleable.SearchView;
        C0523e0 c0523e0M2946v = C0523e0.m2946v(context, attributeSet, iArr, i10, 0);
        C9603h0.m59898n0(this, context, iArr, attributeSet, c0523e0M2946v.m2964r(), i10, 0);
        LayoutInflater.from(context).inflate(c0523e0M2946v.m2960n(R$styleable.SearchView_layout, R$layout.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R$id.search_src_text);
        this.f2112p = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f2113q = findViewById(R$id.search_edit_frame);
        View viewFindViewById = findViewById(R$id.search_plate);
        this.f2114r = viewFindViewById;
        View viewFindViewById2 = findViewById(R$id.submit_area);
        this.f2115s = viewFindViewById2;
        ImageView imageView = (ImageView) findViewById(R$id.search_button);
        this.f2116t = imageView;
        ImageView imageView2 = (ImageView) findViewById(R$id.search_go_btn);
        this.f2117u = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R$id.search_close_btn);
        this.f2118v = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R$id.search_voice_btn);
        this.f2119w = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R$id.search_mag_icon);
        this.f2079D = imageView5;
        C9603h0.m59910t0(viewFindViewById, c0523e0M2946v.m2953g(R$styleable.SearchView_queryBackground));
        C9603h0.m59910t0(viewFindViewById2, c0523e0M2946v.m2953g(R$styleable.SearchView_submitBackground));
        int i11 = R$styleable.SearchView_searchIcon;
        imageView.setImageDrawable(c0523e0M2946v.m2953g(i11));
        imageView2.setImageDrawable(c0523e0M2946v.m2953g(R$styleable.SearchView_goIcon));
        imageView3.setImageDrawable(c0523e0M2946v.m2953g(R$styleable.SearchView_closeIcon));
        imageView4.setImageDrawable(c0523e0M2946v.m2953g(R$styleable.SearchView_voiceIcon));
        imageView5.setImageDrawable(c0523e0M2946v.m2953g(i11));
        this.f2080E = c0523e0M2946v.m2953g(R$styleable.SearchView_searchHintIcon);
        C0531i0.m3033a(imageView, getResources().getString(R$string.abc_searchview_description_search));
        this.f2081F = c0523e0M2946v.m2960n(R$styleable.SearchView_suggestionRowLayout, R$layout.abc_search_dropdown_item_icons_2line);
        this.f2082G = c0523e0M2946v.m2960n(R$styleable.SearchView_commitIcon, 0);
        imageView.setOnClickListener(viewOnClickListenerC0490f);
        imageView3.setOnClickListener(viewOnClickListenerC0490f);
        imageView2.setOnClickListener(viewOnClickListenerC0490f);
        imageView4.setOnClickListener(viewOnClickListenerC0490f);
        searchAutoComplete.setOnClickListener(viewOnClickListenerC0490f);
        searchAutoComplete.addTextChangedListener(this.f2111m0);
        searchAutoComplete.setOnEditorActionListener(c0492h);
        searchAutoComplete.setOnItemClickListener(c0493i);
        searchAutoComplete.setOnItemSelectedListener(c0494j);
        searchAutoComplete.setOnKeyListener(this.f2107i0);
        searchAutoComplete.setOnFocusChangeListener(new ViewOnFocusChangeListenerC0488d());
        setIconifiedByDefault(c0523e0M2946v.m2947a(R$styleable.SearchView_iconifiedByDefault, true));
        int iM2952f = c0523e0M2946v.m2952f(R$styleable.SearchView_android_maxWidth, -1);
        if (iM2952f != -1) {
            setMaxWidth(iM2952f);
        }
        this.f2085J = c0523e0M2946v.m2962p(R$styleable.SearchView_defaultQueryHint);
        this.f2092Q = c0523e0M2946v.m2962p(R$styleable.SearchView_queryHint);
        int iM2957k = c0523e0M2946v.m2957k(R$styleable.SearchView_android_imeOptions, -1);
        if (iM2957k != -1) {
            setImeOptions(iM2957k);
        }
        int iM2957k2 = c0523e0M2946v.m2957k(R$styleable.SearchView_android_inputType, -1);
        if (iM2957k2 != -1) {
            setInputType(iM2957k2);
        }
        setFocusable(c0523e0M2946v.m2947a(R$styleable.SearchView_android_focusable, true));
        c0523e0M2946v.m2966w();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.f2083H = intent;
        intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f2084I = intent2;
        intent2.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        View viewFindViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f2120x = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC0489e());
        }
        m2803k0(this.f2088M);
        m2799g0();
    }
}
