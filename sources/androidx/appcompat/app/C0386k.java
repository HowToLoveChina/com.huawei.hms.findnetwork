package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.appcompat.widget.C0517b0;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p273f0.C9603h0;
import p303g.C9816d;
import p438l.C11213g;

/* renamed from: androidx.appcompat.app.k */
/* loaded from: classes.dex */
public class C0386k {

    /* renamed from: b */
    public static final Class<?>[] f1371b = {Context.class, AttributeSet.class};

    /* renamed from: c */
    public static final int[] f1372c = {R.attr.onClick};

    /* renamed from: d */
    public static final int[] f1373d = {R.attr.accessibilityHeading};

    /* renamed from: e */
    public static final int[] f1374e = {R.attr.accessibilityPaneTitle};

    /* renamed from: f */
    public static final int[] f1375f = {R.attr.screenReaderFocusable};

    /* renamed from: g */
    public static final String[] f1376g = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: h */
    public static final C11213g<String, Constructor<? extends View>> f1377h = new C11213g<>();

    /* renamed from: a */
    public final Object[] f1378a = new Object[2];

    /* renamed from: androidx.appcompat.app.k$a */
    public static class a implements View.OnClickListener {

        /* renamed from: a */
        public final View f1379a;

        /* renamed from: b */
        public final String f1380b;

        /* renamed from: c */
        public Method f1381c;

        /* renamed from: d */
        public Context f1382d;

        public a(View view, String str) {
            this.f1379a = view;
            this.f1380b = str;
        }

        /* renamed from: a */
        public final void m2239a(Context context) {
            String str;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.f1380b, View.class)) != null) {
                        this.f1381c = method;
                        this.f1382d = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            int id2 = this.f1379a.getId();
            if (id2 == -1) {
                str = "";
            } else {
                str = " with id '" + this.f1379a.getContext().getResources().getResourceEntryName(id2) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.f1380b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f1379a.getClass() + str);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (this.f1381c == null) {
                m2239a(this.f1379a.getContext());
            }
            try {
                this.f1381c.invoke(this.f1382d, view);
            } catch (IllegalAccessException e10) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e10);
            } catch (InvocationTargetException e11) {
                throw new IllegalStateException("Could not execute method for android:onClick", e11);
            }
        }
    }

    /* renamed from: u */
    public static Context m2217u(Context context, AttributeSet attributeSet, boolean z10, boolean z11) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.View, 0, 0);
        int resourceId = z10 ? typedArrayObtainStyledAttributes.getResourceId(R$styleable.View_android_theme, 0) : 0;
        if (z11 && resourceId == 0 && (resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.View_theme, 0)) != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != 0 ? ((context instanceof C9816d) && ((C9816d) context).m61006c() == resourceId) ? context : new C9816d(context, resourceId) : context;
    }

    /* renamed from: a */
    public final void m2218a(Context context, View view, AttributeSet attributeSet) {
    }

    /* renamed from: b */
    public final void m2219b(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if ((context instanceof ContextWrapper) && C9603h0.m59859O(view)) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1372c);
            String string = typedArrayObtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new a(view, string));
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* renamed from: c */
    public AppCompatAutoCompleteTextView mo2220c(Context context, AttributeSet attributeSet) {
        return new AppCompatAutoCompleteTextView(context, attributeSet);
    }

    /* renamed from: d */
    public AppCompatButton mo2221d(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }

    /* renamed from: e */
    public AppCompatCheckBox mo2222e(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckBox(context, attributeSet);
    }

    /* renamed from: f */
    public AppCompatCheckedTextView m2223f(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckedTextView(context, attributeSet);
    }

    /* renamed from: g */
    public AppCompatEditText m2224g(Context context, AttributeSet attributeSet) {
        return new AppCompatEditText(context, attributeSet);
    }

    /* renamed from: h */
    public AppCompatImageButton m2225h(Context context, AttributeSet attributeSet) {
        return new AppCompatImageButton(context, attributeSet);
    }

    /* renamed from: i */
    public AppCompatImageView m2226i(Context context, AttributeSet attributeSet) {
        return new AppCompatImageView(context, attributeSet);
    }

    /* renamed from: j */
    public AppCompatMultiAutoCompleteTextView m2227j(Context context, AttributeSet attributeSet) {
        return new AppCompatMultiAutoCompleteTextView(context, attributeSet);
    }

    /* renamed from: k */
    public AppCompatRadioButton mo2228k(Context context, AttributeSet attributeSet) {
        return new AppCompatRadioButton(context, attributeSet);
    }

    /* renamed from: l */
    public AppCompatRatingBar m2229l(Context context, AttributeSet attributeSet) {
        return new AppCompatRatingBar(context, attributeSet);
    }

    /* renamed from: m */
    public AppCompatSeekBar m2230m(Context context, AttributeSet attributeSet) {
        return new AppCompatSeekBar(context, attributeSet);
    }

    /* renamed from: n */
    public AppCompatSpinner m2231n(Context context, AttributeSet attributeSet) {
        return new AppCompatSpinner(context, attributeSet);
    }

    /* renamed from: o */
    public AppCompatTextView mo2232o(Context context, AttributeSet attributeSet) {
        return new AppCompatTextView(context, attributeSet);
    }

    /* renamed from: p */
    public AppCompatToggleButton m2233p(Context context, AttributeSet attributeSet) {
        return new AppCompatToggleButton(context, attributeSet);
    }

    /* renamed from: q */
    public View m2234q(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    /* renamed from: r */
    public final View m2235r(View view, String str, Context context, AttributeSet attributeSet, boolean z10, boolean z11, boolean z12, boolean z13) {
        Context context2;
        View viewM2229l;
        context2 = (!z10 || view == null) ? context : view.getContext();
        if (z11 || z12) {
            context2 = m2217u(context2, attributeSet, z11, z12);
        }
        if (z13) {
            context2 = C0517b0.m2916b(context2);
        }
        str.hashCode();
        switch (str) {
            case "RatingBar":
                viewM2229l = m2229l(context2, attributeSet);
                m2238v(viewM2229l, str);
                break;
            case "CheckedTextView":
                viewM2229l = m2223f(context2, attributeSet);
                m2238v(viewM2229l, str);
                break;
            case "MultiAutoCompleteTextView":
                viewM2229l = m2227j(context2, attributeSet);
                m2238v(viewM2229l, str);
                break;
            case "TextView":
                viewM2229l = mo2232o(context2, attributeSet);
                m2238v(viewM2229l, str);
                break;
            case "ImageButton":
                viewM2229l = m2225h(context2, attributeSet);
                m2238v(viewM2229l, str);
                break;
            case "SeekBar":
                viewM2229l = m2230m(context2, attributeSet);
                m2238v(viewM2229l, str);
                break;
            case "Spinner":
                viewM2229l = m2231n(context2, attributeSet);
                m2238v(viewM2229l, str);
                break;
            case "RadioButton":
                viewM2229l = mo2228k(context2, attributeSet);
                m2238v(viewM2229l, str);
                break;
            case "ToggleButton":
                viewM2229l = m2233p(context2, attributeSet);
                m2238v(viewM2229l, str);
                break;
            case "ImageView":
                viewM2229l = m2226i(context2, attributeSet);
                m2238v(viewM2229l, str);
                break;
            case "AutoCompleteTextView":
                viewM2229l = mo2220c(context2, attributeSet);
                m2238v(viewM2229l, str);
                break;
            case "CheckBox":
                viewM2229l = mo2222e(context2, attributeSet);
                m2238v(viewM2229l, str);
                break;
            case "EditText":
                viewM2229l = m2224g(context2, attributeSet);
                m2238v(viewM2229l, str);
                break;
            case "Button":
                viewM2229l = mo2221d(context2, attributeSet);
                m2238v(viewM2229l, str);
                break;
            default:
                viewM2229l = m2234q(context2, str, attributeSet);
                break;
        }
        if (viewM2229l == null && context != context2) {
            viewM2229l = m2237t(context2, str, attributeSet);
        }
        if (viewM2229l != null) {
            m2219b(viewM2229l, attributeSet);
            m2218a(context2, viewM2229l, attributeSet);
        }
        return viewM2229l;
    }

    /* renamed from: s */
    public final View m2236s(Context context, String str, String str2) throws InflateException, NoSuchMethodException, SecurityException, ClassNotFoundException {
        String str3;
        C11213g<String, Constructor<? extends View>> c11213g = f1377h;
        Constructor<? extends View> constructor = c11213g.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f1371b);
            c11213g.put(str, constructor);
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.f1378a);
    }

    /* renamed from: t */
    public final View m2237t(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            Object[] objArr = this.f1378a;
            objArr[0] = context;
            objArr[1] = attributeSet;
            if (-1 != str.indexOf(46)) {
                return m2236s(context, str, null);
            }
            int i10 = 0;
            while (true) {
                String[] strArr = f1376g;
                if (i10 >= strArr.length) {
                    return null;
                }
                View viewM2236s = m2236s(context, str, strArr[i10]);
                if (viewM2236s != null) {
                    return viewM2236s;
                }
                i10++;
            }
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr2 = this.f1378a;
            objArr2[0] = null;
            objArr2[1] = null;
        }
    }

    /* renamed from: v */
    public final void m2238v(View view, String str) {
        if (view != null) {
            return;
        }
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
    }
}
