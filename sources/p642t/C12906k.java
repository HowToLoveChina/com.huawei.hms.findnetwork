package p642t;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.C0583a;
import androidx.constraintlayout.widget.R$styleable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import p627s.AbstractC12657d;

/* renamed from: t.k */
/* loaded from: classes.dex */
public class C12906k extends AbstractC12899d {

    /* renamed from: A */
    public boolean f58768A;

    /* renamed from: g */
    public float f58769g = 0.1f;

    /* renamed from: h */
    public int f58770h;

    /* renamed from: i */
    public int f58771i;

    /* renamed from: j */
    public int f58772j;

    /* renamed from: k */
    public RectF f58773k;

    /* renamed from: l */
    public RectF f58774l;

    /* renamed from: m */
    public HashMap<String, Method> f58775m;

    /* renamed from: n */
    public int f58776n;

    /* renamed from: o */
    public String f58777o;

    /* renamed from: p */
    public int f58778p;

    /* renamed from: q */
    public String f58779q;

    /* renamed from: r */
    public String f58780r;

    /* renamed from: s */
    public int f58781s;

    /* renamed from: t */
    public int f58782t;

    /* renamed from: u */
    public View f58783u;

    /* renamed from: v */
    public boolean f58784v;

    /* renamed from: w */
    public boolean f58785w;

    /* renamed from: x */
    public boolean f58786x;

    /* renamed from: y */
    public float f58787y;

    /* renamed from: z */
    public float f58788z;

    /* renamed from: t.k$a */
    public static class a {

        /* renamed from: a */
        public static SparseIntArray f58789a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f58789a = sparseIntArray;
            sparseIntArray.append(R$styleable.KeyTrigger_framePosition, 8);
            f58789a.append(R$styleable.KeyTrigger_onCross, 4);
            f58789a.append(R$styleable.KeyTrigger_onNegativeCross, 1);
            f58789a.append(R$styleable.KeyTrigger_onPositiveCross, 2);
            f58789a.append(R$styleable.KeyTrigger_motionTarget, 7);
            f58789a.append(R$styleable.KeyTrigger_triggerId, 6);
            f58789a.append(R$styleable.KeyTrigger_triggerSlack, 5);
            f58789a.append(R$styleable.KeyTrigger_motion_triggerOnCollision, 9);
            f58789a.append(R$styleable.KeyTrigger_motion_postLayoutCollision, 10);
            f58789a.append(R$styleable.KeyTrigger_triggerReceiver, 11);
            f58789a.append(R$styleable.KeyTrigger_viewTransitionOnCross, 12);
            f58789a.append(R$styleable.KeyTrigger_viewTransitionOnNegativeCross, 13);
            f58789a.append(R$styleable.KeyTrigger_viewTransitionOnPositiveCross, 14);
        }

        /* renamed from: a */
        public static void m77469a(C12906k c12906k, TypedArray typedArray, Context context) {
            int indexCount = typedArray.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArray.getIndex(i10);
                switch (f58789a.get(index)) {
                    case 1:
                        c12906k.f58779q = typedArray.getString(index);
                        break;
                    case 2:
                        c12906k.f58780r = typedArray.getString(index);
                        break;
                    case 3:
                    default:
                        Log.e("KeyTrigger", "unused attribute 0x" + Integer.toHexString(index) + "   " + f58789a.get(index));
                        break;
                    case 4:
                        c12906k.f58777o = typedArray.getString(index);
                        break;
                    case 5:
                        c12906k.f58769g = typedArray.getFloat(index, c12906k.f58769g);
                        break;
                    case 6:
                        c12906k.f58781s = typedArray.getResourceId(index, c12906k.f58781s);
                        break;
                    case 7:
                        if (MotionLayout.f2560E0) {
                            int resourceId = typedArray.getResourceId(index, c12906k.f58690b);
                            c12906k.f58690b = resourceId;
                            if (resourceId == -1) {
                                c12906k.f58691c = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            c12906k.f58691c = typedArray.getString(index);
                            break;
                        } else {
                            c12906k.f58690b = typedArray.getResourceId(index, c12906k.f58690b);
                            break;
                        }
                    case 8:
                        int integer = typedArray.getInteger(index, c12906k.f58689a);
                        c12906k.f58689a = integer;
                        c12906k.f58787y = (integer + 0.5f) / 100.0f;
                        break;
                    case 9:
                        c12906k.f58782t = typedArray.getResourceId(index, c12906k.f58782t);
                        break;
                    case 10:
                        c12906k.f58768A = typedArray.getBoolean(index, c12906k.f58768A);
                        break;
                    case 11:
                        c12906k.f58778p = typedArray.getResourceId(index, c12906k.f58778p);
                        break;
                    case 12:
                        c12906k.f58772j = typedArray.getResourceId(index, c12906k.f58772j);
                        break;
                    case 13:
                        c12906k.f58770h = typedArray.getResourceId(index, c12906k.f58770h);
                        break;
                    case 14:
                        c12906k.f58771i = typedArray.getResourceId(index, c12906k.f58771i);
                        break;
                }
            }
        }
    }

    public C12906k() {
        int i10 = AbstractC12899d.f58688f;
        this.f58770h = i10;
        this.f58771i = i10;
        this.f58772j = i10;
        this.f58773k = new RectF();
        this.f58774l = new RectF();
        this.f58775m = new HashMap<>();
        this.f58776n = -1;
        this.f58777o = null;
        int i11 = AbstractC12899d.f58688f;
        this.f58778p = i11;
        this.f58779q = null;
        this.f58780r = null;
        this.f58781s = i11;
        this.f58782t = i11;
        this.f58783u = null;
        this.f58784v = true;
        this.f58785w = true;
        this.f58786x = true;
        this.f58787y = Float.NaN;
        this.f58768A = false;
        this.f58692d = 5;
        this.f58693e = new HashMap<>();
    }

    /* renamed from: A */
    public final void m77465A(String str, View view) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        boolean z10 = str.length() == 1;
        if (!z10) {
            str = str.substring(1).toLowerCase(Locale.ROOT);
        }
        for (String str2 : this.f58693e.keySet()) {
            String lowerCase = str2.toLowerCase(Locale.ROOT);
            if (z10 || lowerCase.matches(str)) {
                C0583a c0583a = this.f58693e.get(str2);
                if (c0583a != null) {
                    c0583a.m3586a(view);
                }
            }
        }
    }

    /* renamed from: B */
    public final void m77466B(RectF rectF, View view, boolean z10) {
        rectF.top = view.getTop();
        rectF.bottom = view.getBottom();
        rectF.left = view.getLeft();
        rectF.right = view.getRight();
        if (z10) {
            view.getMatrix().mapRect(rectF);
        }
    }

    @Override // p642t.AbstractC12899d
    /* renamed from: a */
    public void mo77322a(HashMap<String, AbstractC12657d> map) {
    }

    @Override // p642t.AbstractC12899d
    /* renamed from: b */
    public AbstractC12899d clone() {
        return new C12906k().mo77324c(this);
    }

    @Override // p642t.AbstractC12899d
    /* renamed from: c */
    public AbstractC12899d mo77324c(AbstractC12899d abstractC12899d) {
        super.mo77324c(abstractC12899d);
        C12906k c12906k = (C12906k) abstractC12899d;
        this.f58776n = c12906k.f58776n;
        this.f58777o = c12906k.f58777o;
        this.f58778p = c12906k.f58778p;
        this.f58779q = c12906k.f58779q;
        this.f58780r = c12906k.f58780r;
        this.f58781s = c12906k.f58781s;
        this.f58782t = c12906k.f58782t;
        this.f58783u = c12906k.f58783u;
        this.f58769g = c12906k.f58769g;
        this.f58784v = c12906k.f58784v;
        this.f58785w = c12906k.f58785w;
        this.f58786x = c12906k.f58786x;
        this.f58787y = c12906k.f58787y;
        this.f58788z = c12906k.f58788z;
        this.f58768A = c12906k.f58768A;
        this.f58773k = c12906k.f58773k;
        this.f58774l = c12906k.f58774l;
        this.f58775m = c12906k.f58775m;
        return this;
    }

    @Override // p642t.AbstractC12899d
    /* renamed from: d */
    public void mo77325d(HashSet<String> hashSet) {
    }

    @Override // p642t.AbstractC12899d
    /* renamed from: e */
    public void mo77326e(Context context, AttributeSet attributeSet) {
        a.m77469a(this, context.obtainStyledAttributes(attributeSet, R$styleable.KeyTrigger), context);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00cd  */
    /* renamed from: y */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m77467y(float r10, android.view.View r11) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 353
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p642t.C12906k.m77467y(float, android.view.View):void");
    }

    /* renamed from: z */
    public final void m77468z(String str, View view) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method method;
        if (str == null) {
            return;
        }
        if (str.startsWith(".")) {
            m77465A(str, view);
            return;
        }
        if (this.f58775m.containsKey(str)) {
            method = this.f58775m.get(str);
            if (method == null) {
                return;
            }
        } else {
            method = null;
        }
        if (method == null) {
            try {
                method = view.getClass().getMethod(str, new Class[0]);
                this.f58775m.put(str, method);
            } catch (NoSuchMethodException unused) {
                this.f58775m.put(str, null);
                Log.e("KeyTrigger", "Could not find method \"" + str + "\"on class " + view.getClass().getSimpleName() + " " + C12896a.m77318d(view));
                return;
            }
        }
        try {
            method.invoke(view, new Object[0]);
        } catch (Exception unused2) {
            Log.e("KeyTrigger", "Exception in call \"" + this.f58777o + "\"on class " + view.getClass().getSimpleName() + " " + C12896a.m77318d(view));
        }
    }
}
