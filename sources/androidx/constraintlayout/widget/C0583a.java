package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: androidx.constraintlayout.widget.a */
/* loaded from: classes.dex */
public class C0583a {

    /* renamed from: a */
    public boolean f3061a;

    /* renamed from: b */
    public String f3062b;

    /* renamed from: c */
    public a f3063c;

    /* renamed from: d */
    public int f3064d;

    /* renamed from: e */
    public float f3065e;

    /* renamed from: f */
    public String f3066f;

    /* renamed from: g */
    public boolean f3067g;

    /* renamed from: h */
    public int f3068h;

    /* renamed from: androidx.constraintlayout.widget.a$a */
    public enum a {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    public C0583a(String str, a aVar, Object obj, boolean z10) {
        this.f3062b = str;
        this.f3063c = aVar;
        this.f3061a = z10;
        m3593k(obj);
    }

    /* renamed from: b */
    public static HashMap<String, C0583a> m3583b(HashMap<String, C0583a> map, View view) {
        HashMap<String, C0583a> map2 = new HashMap<>();
        Class<?> cls = view.getClass();
        for (String str : map.keySet()) {
            C0583a c0583a = map.get(str);
            try {
                if (str.equals("BackgroundColor")) {
                    map2.put(str, new C0583a(c0583a, Integer.valueOf(((ColorDrawable) view.getBackground()).getColor())));
                } else {
                    map2.put(str, new C0583a(c0583a, cls.getMethod("getMap" + str, new Class[0]).invoke(view, new Object[0])));
                }
            } catch (IllegalAccessException e10) {
                Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName(), e10);
            } catch (NoSuchMethodException e11) {
                Log.e("TransitionLayout", cls.getName() + " must have a method " + str, e11);
            } catch (InvocationTargetException e12) {
                Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName(), e12);
            }
        }
        return map2;
    }

    /* renamed from: i */
    public static void m3584i(Context context, XmlPullParser xmlPullParser, HashMap<String, C0583a> map) {
        a aVar;
        Object objValueOf;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.CustomAttribute);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        String string = null;
        Object objValueOf2 = null;
        a aVar2 = null;
        boolean z10 = false;
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i10);
            if (index == R$styleable.CustomAttribute_attributeName) {
                string = typedArrayObtainStyledAttributes.getString(index);
                if (string != null && string.length() > 0) {
                    string = Character.toUpperCase(string.charAt(0)) + string.substring(1);
                }
            } else if (index == R$styleable.CustomAttribute_methodName) {
                string = typedArrayObtainStyledAttributes.getString(index);
                z10 = true;
            } else if (index == R$styleable.CustomAttribute_customBoolean) {
                objValueOf2 = Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(index, false));
                aVar2 = a.BOOLEAN_TYPE;
            } else {
                if (index == R$styleable.CustomAttribute_customColorValue) {
                    aVar = a.COLOR_TYPE;
                    objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                } else if (index == R$styleable.CustomAttribute_customColorDrawableValue) {
                    aVar = a.COLOR_DRAWABLE_TYPE;
                    objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                } else if (index == R$styleable.CustomAttribute_customPixelDimension) {
                    aVar = a.DIMENSION_TYPE;
                    objValueOf = Float.valueOf(TypedValue.applyDimension(1, typedArrayObtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                } else if (index == R$styleable.CustomAttribute_customDimension) {
                    aVar = a.DIMENSION_TYPE;
                    objValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R$styleable.CustomAttribute_customFloatValue) {
                    aVar = a.FLOAT_TYPE;
                    objValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getFloat(index, Float.NaN));
                } else if (index == R$styleable.CustomAttribute_customIntegerValue) {
                    aVar = a.INT_TYPE;
                    objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getInteger(index, -1));
                } else if (index == R$styleable.CustomAttribute_customStringValue) {
                    aVar = a.STRING_TYPE;
                    objValueOf = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == R$styleable.CustomAttribute_customReference) {
                    aVar = a.REFERENCE_TYPE;
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                    if (resourceId == -1) {
                        resourceId = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    objValueOf = Integer.valueOf(resourceId);
                }
                Object obj = objValueOf;
                aVar2 = aVar;
                objValueOf2 = obj;
            }
        }
        if (string != null && objValueOf2 != null) {
            map.put(string, new C0583a(string, aVar2, objValueOf2, z10));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    /* renamed from: j */
    public static void m3585j(View view, HashMap<String, C0583a> map) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Class<?> cls = view.getClass();
        for (String str : map.keySet()) {
            C0583a c0583a = map.get(str);
            String str2 = c0583a.f3061a ? str : "set" + str;
            try {
                switch (c0583a.f3063c) {
                    case INT_TYPE:
                        cls.getMethod(str2, Integer.TYPE).invoke(view, Integer.valueOf(c0583a.f3064d));
                        break;
                    case FLOAT_TYPE:
                        cls.getMethod(str2, Float.TYPE).invoke(view, Float.valueOf(c0583a.f3065e));
                        break;
                    case COLOR_TYPE:
                        cls.getMethod(str2, Integer.TYPE).invoke(view, Integer.valueOf(c0583a.f3068h));
                        break;
                    case COLOR_DRAWABLE_TYPE:
                        Method method = cls.getMethod(str2, Drawable.class);
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(c0583a.f3068h);
                        method.invoke(view, colorDrawable);
                        break;
                    case STRING_TYPE:
                        cls.getMethod(str2, CharSequence.class).invoke(view, c0583a.f3066f);
                        break;
                    case BOOLEAN_TYPE:
                        cls.getMethod(str2, Boolean.TYPE).invoke(view, Boolean.valueOf(c0583a.f3067g));
                        break;
                    case DIMENSION_TYPE:
                        cls.getMethod(str2, Float.TYPE).invoke(view, Float.valueOf(c0583a.f3065e));
                        break;
                    case REFERENCE_TYPE:
                        cls.getMethod(str2, Integer.TYPE).invoke(view, Integer.valueOf(c0583a.f3064d));
                        break;
                }
            } catch (IllegalAccessException e10) {
                Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName(), e10);
            } catch (NoSuchMethodException e11) {
                Log.e("TransitionLayout", cls.getName() + " must have a method " + str2, e11);
            } catch (InvocationTargetException e12) {
                Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName(), e12);
            }
        }
    }

    /* renamed from: a */
    public void m3586a(View view) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        String str;
        Class<?> cls = view.getClass();
        String str2 = this.f3062b;
        if (this.f3061a) {
            str = str2;
        } else {
            str = "set" + str2;
        }
        try {
            switch (this.f3063c) {
                case INT_TYPE:
                case REFERENCE_TYPE:
                    cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf(this.f3064d));
                    break;
                case FLOAT_TYPE:
                    cls.getMethod(str, Float.TYPE).invoke(view, Float.valueOf(this.f3065e));
                    break;
                case COLOR_TYPE:
                    cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf(this.f3068h));
                    break;
                case COLOR_DRAWABLE_TYPE:
                    Method method = cls.getMethod(str, Drawable.class);
                    ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setColor(this.f3068h);
                    method.invoke(view, colorDrawable);
                    break;
                case STRING_TYPE:
                    cls.getMethod(str, CharSequence.class).invoke(view, this.f3066f);
                    break;
                case BOOLEAN_TYPE:
                    cls.getMethod(str, Boolean.TYPE).invoke(view, Boolean.valueOf(this.f3067g));
                    break;
                case DIMENSION_TYPE:
                    cls.getMethod(str, Float.TYPE).invoke(view, Float.valueOf(this.f3065e));
                    break;
            }
        } catch (IllegalAccessException e10) {
            Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName(), e10);
        } catch (NoSuchMethodException e11) {
            Log.e("TransitionLayout", cls.getName() + " must have a method " + str, e11);
        } catch (InvocationTargetException e12) {
            Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName(), e12);
        }
    }

    /* renamed from: c */
    public String m3587c() {
        return this.f3062b;
    }

    /* renamed from: d */
    public a m3588d() {
        return this.f3063c;
    }

    /* renamed from: e */
    public float m3589e() {
        switch (this.f3063c) {
            case INT_TYPE:
                return this.f3064d;
            case FLOAT_TYPE:
            case DIMENSION_TYPE:
                return this.f3065e;
            case COLOR_TYPE:
            case COLOR_DRAWABLE_TYPE:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case STRING_TYPE:
                throw new RuntimeException("Cannot interpolate String");
            case BOOLEAN_TYPE:
                return this.f3067g ? 1.0f : 0.0f;
            default:
                return Float.NaN;
        }
    }

    /* renamed from: f */
    public void m3590f(float[] fArr) {
        switch (this.f3063c) {
            case INT_TYPE:
                fArr[0] = this.f3064d;
                return;
            case FLOAT_TYPE:
                fArr[0] = this.f3065e;
                return;
            case COLOR_TYPE:
            case COLOR_DRAWABLE_TYPE:
                int i10 = this.f3068h;
                int i11 = (i10 >> 24) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
                int i12 = (i10 >> 16) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
                int i13 = (i10 >> 8) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
                int i14 = i10 & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
                float fPow = (float) Math.pow(i12 / 255.0f, 2.2d);
                float fPow2 = (float) Math.pow(i13 / 255.0f, 2.2d);
                float fPow3 = (float) Math.pow(i14 / 255.0f, 2.2d);
                fArr[0] = fPow;
                fArr[1] = fPow2;
                fArr[2] = fPow3;
                fArr[3] = i11 / 255.0f;
                return;
            case STRING_TYPE:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case BOOLEAN_TYPE:
                fArr[0] = this.f3067g ? 1.0f : 0.0f;
                return;
            case DIMENSION_TYPE:
                fArr[0] = this.f3065e;
                return;
            default:
                return;
        }
    }

    /* renamed from: g */
    public boolean m3591g() {
        int iOrdinal = this.f3063c.ordinal();
        return (iOrdinal == 4 || iOrdinal == 5 || iOrdinal == 7) ? false : true;
    }

    /* renamed from: h */
    public int m3592h() {
        int iOrdinal = this.f3063c.ordinal();
        return (iOrdinal == 2 || iOrdinal == 3) ? 4 : 1;
    }

    /* renamed from: k */
    public void m3593k(Object obj) {
        switch (this.f3063c) {
            case INT_TYPE:
            case REFERENCE_TYPE:
                this.f3064d = ((Integer) obj).intValue();
                break;
            case FLOAT_TYPE:
                this.f3065e = ((Float) obj).floatValue();
                break;
            case COLOR_TYPE:
            case COLOR_DRAWABLE_TYPE:
                this.f3068h = ((Integer) obj).intValue();
                break;
            case STRING_TYPE:
                this.f3066f = (String) obj;
                break;
            case BOOLEAN_TYPE:
                this.f3067g = ((Boolean) obj).booleanValue();
                break;
            case DIMENSION_TYPE:
                this.f3065e = ((Float) obj).floatValue();
                break;
        }
    }

    public C0583a(C0583a c0583a, Object obj) {
        this.f3061a = false;
        this.f3062b = c0583a.f3062b;
        this.f3063c = c0583a.f3063c;
        m3593k(obj);
    }
}
