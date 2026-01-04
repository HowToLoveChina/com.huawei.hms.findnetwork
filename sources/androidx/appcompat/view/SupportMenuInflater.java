package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.C0411h;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.widget.C0523e0;
import androidx.appcompat.widget.C0544s;
import androidx.core.view.ActionProvider;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p273f0.C9626t;
import p793y.InterfaceMenuC13895a;

/* loaded from: classes.dex */
public class SupportMenuInflater extends MenuInflater {

    /* renamed from: e */
    public static final Class<?>[] f1454e;

    /* renamed from: f */
    public static final Class<?>[] f1455f;

    /* renamed from: a */
    public final Object[] f1456a;

    /* renamed from: b */
    public final Object[] f1457b;

    /* renamed from: c */
    public Context f1458c;

    /* renamed from: d */
    public Object f1459d;

    /* renamed from: androidx.appcompat.view.SupportMenuInflater$a */
    public static class MenuItemOnMenuItemClickListenerC0394a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c */
        public static final Class<?>[] f1460c = {MenuItem.class};

        /* renamed from: a */
        public Object f1461a;

        /* renamed from: b */
        public Method f1462b;

        public MenuItemOnMenuItemClickListenerC0394a(Object obj, String str) {
            this.f1461a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f1462b = cls.getMethod(str, f1460c);
            } catch (Exception e10) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e10);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                if (this.f1462b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f1462b.invoke(this.f1461a, menuItem)).booleanValue();
                }
                this.f1462b.invoke(this.f1461a, menuItem);
                return true;
            } catch (Exception e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    /* renamed from: androidx.appcompat.view.SupportMenuInflater$b */
    public class C0395b {

        /* renamed from: A */
        public ActionProvider f1463A;

        /* renamed from: B */
        public CharSequence f1464B;

        /* renamed from: C */
        public CharSequence f1465C;

        /* renamed from: D */
        public ColorStateList f1466D = null;

        /* renamed from: E */
        public PorterDuff.Mode f1467E = null;

        /* renamed from: a */
        public Menu f1469a;

        /* renamed from: b */
        public int f1470b;

        /* renamed from: c */
        public int f1471c;

        /* renamed from: d */
        public int f1472d;

        /* renamed from: e */
        public int f1473e;

        /* renamed from: f */
        public boolean f1474f;

        /* renamed from: g */
        public boolean f1475g;

        /* renamed from: h */
        public boolean f1476h;

        /* renamed from: i */
        public int f1477i;

        /* renamed from: j */
        public int f1478j;

        /* renamed from: k */
        public CharSequence f1479k;

        /* renamed from: l */
        public CharSequence f1480l;

        /* renamed from: m */
        public int f1481m;

        /* renamed from: n */
        public char f1482n;

        /* renamed from: o */
        public int f1483o;

        /* renamed from: p */
        public char f1484p;

        /* renamed from: q */
        public int f1485q;

        /* renamed from: r */
        public int f1486r;

        /* renamed from: s */
        public boolean f1487s;

        /* renamed from: t */
        public boolean f1488t;

        /* renamed from: u */
        public boolean f1489u;

        /* renamed from: v */
        public int f1490v;

        /* renamed from: w */
        public int f1491w;

        /* renamed from: x */
        public String f1492x;

        /* renamed from: y */
        public String f1493y;

        /* renamed from: z */
        public String f1494z;

        public C0395b(Menu menu) {
            this.f1469a = menu;
            m2315h();
        }

        /* renamed from: a */
        public void m2308a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.f1476h = true;
            m2316i(this.f1469a.add(this.f1470b, this.f1477i, this.f1478j, this.f1479k));
        }

        /* renamed from: b */
        public SubMenu m2309b() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.f1476h = true;
            SubMenu subMenuAddSubMenu = this.f1469a.addSubMenu(this.f1470b, this.f1477i, this.f1478j, this.f1479k);
            m2316i(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        /* renamed from: c */
        public final char m2310c(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        /* renamed from: d */
        public boolean m2311d() {
            return this.f1476h;
        }

        /* renamed from: e */
        public final <T> T m2312e(String str, Class<?>[] clsArr, Object[] objArr) throws NoSuchMethodException, SecurityException {
            try {
                Constructor<?> constructor = Class.forName(str, false, SupportMenuInflater.this.f1458c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e10) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e10);
                return null;
            }
        }

        /* renamed from: f */
        public void m2313f(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = SupportMenuInflater.this.f1458c.obtainStyledAttributes(attributeSet, R$styleable.MenuGroup);
            this.f1470b = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MenuGroup_android_id, 0);
            this.f1471c = typedArrayObtainStyledAttributes.getInt(R$styleable.MenuGroup_android_menuCategory, 0);
            this.f1472d = typedArrayObtainStyledAttributes.getInt(R$styleable.MenuGroup_android_orderInCategory, 0);
            this.f1473e = typedArrayObtainStyledAttributes.getInt(R$styleable.MenuGroup_android_checkableBehavior, 0);
            this.f1474f = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_visible, true);
            this.f1475g = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_enabled, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        /* renamed from: g */
        public void m2314g(AttributeSet attributeSet) {
            C0523e0 c0523e0M2945u = C0523e0.m2945u(SupportMenuInflater.this.f1458c, attributeSet, R$styleable.MenuItem);
            this.f1477i = c0523e0M2945u.m2960n(R$styleable.MenuItem_android_id, 0);
            this.f1478j = (c0523e0M2945u.m2957k(R$styleable.MenuItem_android_menuCategory, this.f1471c) & (-65536)) | (c0523e0M2945u.m2957k(R$styleable.MenuItem_android_orderInCategory, this.f1472d) & 65535);
            this.f1479k = c0523e0M2945u.m2962p(R$styleable.MenuItem_android_title);
            this.f1480l = c0523e0M2945u.m2962p(R$styleable.MenuItem_android_titleCondensed);
            this.f1481m = c0523e0M2945u.m2960n(R$styleable.MenuItem_android_icon, 0);
            this.f1482n = m2310c(c0523e0M2945u.m2961o(R$styleable.MenuItem_android_alphabeticShortcut));
            this.f1483o = c0523e0M2945u.m2957k(R$styleable.MenuItem_alphabeticModifiers, 4096);
            this.f1484p = m2310c(c0523e0M2945u.m2961o(R$styleable.MenuItem_android_numericShortcut));
            this.f1485q = c0523e0M2945u.m2957k(R$styleable.MenuItem_numericModifiers, 4096);
            int i10 = R$styleable.MenuItem_android_checkable;
            if (c0523e0M2945u.m2965s(i10)) {
                this.f1486r = c0523e0M2945u.m2947a(i10, false) ? 1 : 0;
            } else {
                this.f1486r = this.f1473e;
            }
            this.f1487s = c0523e0M2945u.m2947a(R$styleable.MenuItem_android_checked, false);
            this.f1488t = c0523e0M2945u.m2947a(R$styleable.MenuItem_android_visible, this.f1474f);
            this.f1489u = c0523e0M2945u.m2947a(R$styleable.MenuItem_android_enabled, this.f1475g);
            this.f1490v = c0523e0M2945u.m2957k(R$styleable.MenuItem_showAsAction, -1);
            this.f1494z = c0523e0M2945u.m2961o(R$styleable.MenuItem_android_onClick);
            this.f1491w = c0523e0M2945u.m2960n(R$styleable.MenuItem_actionLayout, 0);
            this.f1492x = c0523e0M2945u.m2961o(R$styleable.MenuItem_actionViewClass);
            String strM2961o = c0523e0M2945u.m2961o(R$styleable.MenuItem_actionProviderClass);
            this.f1493y = strM2961o;
            boolean z10 = strM2961o != null;
            if (z10 && this.f1491w == 0 && this.f1492x == null) {
                this.f1463A = (ActionProvider) m2312e(strM2961o, SupportMenuInflater.f1455f, SupportMenuInflater.this.f1457b);
            } else {
                if (z10) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f1463A = null;
            }
            this.f1464B = c0523e0M2945u.m2962p(R$styleable.MenuItem_contentDescription);
            this.f1465C = c0523e0M2945u.m2962p(R$styleable.MenuItem_tooltipText);
            int i11 = R$styleable.MenuItem_iconTintMode;
            if (c0523e0M2945u.m2965s(i11)) {
                this.f1467E = C0544s.m3144e(c0523e0M2945u.m2957k(i11, -1), this.f1467E);
            } else {
                this.f1467E = null;
            }
            int i12 = R$styleable.MenuItem_iconTint;
            if (c0523e0M2945u.m2965s(i12)) {
                this.f1466D = c0523e0M2945u.m2949c(i12);
            } else {
                this.f1466D = null;
            }
            c0523e0M2945u.m2966w();
            this.f1476h = false;
        }

        /* renamed from: h */
        public void m2315h() {
            this.f1470b = 0;
            this.f1471c = 0;
            this.f1472d = 0;
            this.f1473e = 0;
            this.f1474f = true;
            this.f1475g = true;
        }

        /* renamed from: i */
        public final void m2316i(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            boolean z10 = false;
            menuItem.setChecked(this.f1487s).setVisible(this.f1488t).setEnabled(this.f1489u).setCheckable(this.f1486r >= 1).setTitleCondensed(this.f1480l).setIcon(this.f1481m);
            int i10 = this.f1490v;
            if (i10 >= 0) {
                menuItem.setShowAsAction(i10);
            }
            if (this.f1494z != null) {
                if (SupportMenuInflater.this.f1458c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0394a(SupportMenuInflater.this.m2306b(), this.f1494z));
            }
            if (this.f1486r >= 2) {
                if (menuItem instanceof C0411h) {
                    ((C0411h) menuItem).m2487t(true);
                } else if (menuItem instanceof MenuItemWrapperICS) {
                    ((MenuItemWrapperICS) menuItem).m2395h(true);
                }
            }
            String str = this.f1492x;
            if (str != null) {
                menuItem.setActionView((View) m2312e(str, SupportMenuInflater.f1454e, SupportMenuInflater.this.f1456a));
                z10 = true;
            }
            int i11 = this.f1491w;
            if (i11 > 0) {
                if (z10) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i11);
                }
            }
            ActionProvider actionProvider = this.f1463A;
            if (actionProvider != null) {
                C9626t.m60207a(menuItem, actionProvider);
            }
            C9626t.m60209c(menuItem, this.f1464B);
            C9626t.m60213g(menuItem, this.f1465C);
            C9626t.m60208b(menuItem, this.f1482n, this.f1483o);
            C9626t.m60212f(menuItem, this.f1484p, this.f1485q);
            PorterDuff.Mode mode = this.f1467E;
            if (mode != null) {
                C9626t.m60211e(menuItem, mode);
            }
            ColorStateList colorStateList = this.f1466D;
            if (colorStateList != null) {
                C9626t.m60210d(menuItem, colorStateList);
            }
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        f1454e = clsArr;
        f1455f = clsArr;
    }

    public SupportMenuInflater(Context context) {
        super(context);
        this.f1458c = context;
        Object[] objArr = {context};
        this.f1456a = objArr;
        this.f1457b = objArr;
    }

    /* renamed from: a */
    public final Object m2305a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? m2305a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* renamed from: b */
    public Object m2306b() {
        if (this.f1459d == null) {
            this.f1459d = m2305a(this.f1458c);
        }
        return this.f1459d;
    }

    /* renamed from: c */
    public final void m2307c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        C0395b c0395b = new C0395b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
                eventType = xmlPullParser.next();
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        boolean z10 = false;
        boolean z11 = false;
        String str = null;
        while (!z10) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != 2) {
                if (eventType == 3) {
                    String name2 = xmlPullParser.getName();
                    if (z11 && name2.equals(str)) {
                        z11 = false;
                        str = null;
                    } else if (name2.equals("group")) {
                        c0395b.m2315h();
                    } else if (name2.equals("item")) {
                        if (!c0395b.m2311d()) {
                            ActionProvider actionProvider = c0395b.f1463A;
                            if (actionProvider == null || !actionProvider.mo2399a()) {
                                c0395b.m2308a();
                            } else {
                                c0395b.m2309b();
                            }
                        }
                    } else if (name2.equals("menu")) {
                        z10 = true;
                    }
                }
            } else if (!z11) {
                String name3 = xmlPullParser.getName();
                if (name3.equals("group")) {
                    c0395b.m2313f(attributeSet);
                } else if (name3.equals("item")) {
                    c0395b.m2314g(attributeSet);
                } else if (name3.equals("menu")) {
                    m2307c(xmlPullParser, attributeSet, c0395b.m2309b());
                } else {
                    str = name3;
                    z11 = true;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // android.view.MenuInflater
    public void inflate(int i10, Menu menu) {
        if (!(menu instanceof InterfaceMenuC13895a)) {
            super.inflate(i10, menu);
            return;
        }
        XmlResourceParser layout = null;
        try {
            try {
                try {
                    layout = this.f1458c.getResources().getLayout(i10);
                    m2307c(layout, Xml.asAttributeSet(layout), menu);
                } catch (XmlPullParserException e10) {
                    throw new InflateException("Error inflating menu XML", e10);
                }
            } catch (IOException e11) {
                throw new InflateException("Error inflating menu XML", e11);
            }
        } finally {
            if (layout != null) {
                layout.close();
            }
        }
    }
}
