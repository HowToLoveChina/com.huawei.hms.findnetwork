package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.view.ActionProvider;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p793y.InterfaceMenuC13895a;

/* loaded from: classes.dex */
public class MenuBuilder implements InterfaceMenuC13895a {

    /* renamed from: A */
    public static final int[] f1527A = {1, 4, 5, 3, 2, 0};

    /* renamed from: a */
    public final Context f1528a;

    /* renamed from: b */
    public final Resources f1529b;

    /* renamed from: c */
    public boolean f1530c;

    /* renamed from: d */
    public boolean f1531d;

    /* renamed from: e */
    public InterfaceC0398a f1532e;

    /* renamed from: m */
    public ContextMenu.ContextMenuInfo f1540m;

    /* renamed from: n */
    public CharSequence f1541n;

    /* renamed from: o */
    public Drawable f1542o;

    /* renamed from: p */
    public View f1543p;

    /* renamed from: x */
    public C0411h f1551x;

    /* renamed from: z */
    public boolean f1553z;

    /* renamed from: l */
    public int f1539l = 0;

    /* renamed from: q */
    public boolean f1544q = false;

    /* renamed from: r */
    public boolean f1545r = false;

    /* renamed from: s */
    public boolean f1546s = false;

    /* renamed from: t */
    public boolean f1547t = false;

    /* renamed from: u */
    public boolean f1548u = false;

    /* renamed from: v */
    public ArrayList<C0411h> f1549v = new ArrayList<>();

    /* renamed from: w */
    public CopyOnWriteArrayList<WeakReference<InterfaceC0414k>> f1550w = new CopyOnWriteArrayList<>();

    /* renamed from: y */
    public boolean f1552y = false;

    /* renamed from: f */
    public ArrayList<C0411h> f1533f = new ArrayList<>();

    /* renamed from: g */
    public ArrayList<C0411h> f1534g = new ArrayList<>();

    /* renamed from: h */
    public boolean f1535h = true;

    /* renamed from: i */
    public ArrayList<C0411h> f1536i = new ArrayList<>();

    /* renamed from: j */
    public ArrayList<C0411h> f1537j = new ArrayList<>();

    /* renamed from: k */
    public boolean f1538k = true;

    /* renamed from: androidx.appcompat.view.menu.MenuBuilder$a */
    public interface InterfaceC0398a {
        /* renamed from: a */
        boolean mo2102a(MenuBuilder menuBuilder, MenuItem menuItem);

        /* renamed from: b */
        void mo2105b(MenuBuilder menuBuilder);
    }

    /* renamed from: androidx.appcompat.view.menu.MenuBuilder$b */
    public interface InterfaceC0399b {
        /* renamed from: a */
        boolean mo2327a(C0411h c0411h);
    }

    public MenuBuilder(Context context) {
        this.f1528a = context;
        this.f1529b = context.getResources();
        m2373f0(true);
    }

    /* renamed from: D */
    public static int m2335D(int i10) {
        int i11 = ((-65536) & i10) >> 16;
        if (i11 >= 0) {
            int[] iArr = f1527A;
            if (i11 < iArr.length) {
                return (i10 & 65535) | (iArr[i11] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    /* renamed from: p */
    public static int m2336p(ArrayList<C0411h> arrayList, int i10) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).m2473f() <= i10) {
                return size + 1;
            }
        }
        return 0;
    }

    /* renamed from: A */
    public View m2337A() {
        return this.f1543p;
    }

    /* renamed from: B */
    public ArrayList<C0411h> m2338B() {
        m2388t();
        return this.f1537j;
    }

    /* renamed from: C */
    public boolean m2339C() {
        return this.f1547t;
    }

    /* renamed from: E */
    public Resources m2340E() {
        return this.f1529b;
    }

    /* renamed from: F */
    public MenuBuilder mo2341F() {
        return this;
    }

    /* renamed from: G */
    public ArrayList<C0411h> m2342G() {
        if (!this.f1535h) {
            return this.f1534g;
        }
        this.f1534g.clear();
        int size = this.f1533f.size();
        for (int i10 = 0; i10 < size; i10++) {
            C0411h c0411h = this.f1533f.get(i10);
            if (c0411h.isVisible()) {
                this.f1534g.add(c0411h);
            }
        }
        this.f1535h = false;
        this.f1538k = true;
        return this.f1534g;
    }

    /* renamed from: H */
    public boolean mo2343H() {
        return this.f1552y;
    }

    /* renamed from: I */
    public boolean mo2344I() {
        return this.f1530c;
    }

    /* renamed from: J */
    public boolean mo2345J() {
        return this.f1531d;
    }

    /* renamed from: K */
    public void m2346K(C0411h c0411h) {
        this.f1538k = true;
        mo2348M(true);
    }

    /* renamed from: L */
    public void m2347L(C0411h c0411h) {
        this.f1535h = true;
        mo2348M(true);
    }

    /* renamed from: M */
    public void mo2348M(boolean z10) {
        if (this.f1544q) {
            this.f1545r = true;
            if (z10) {
                this.f1546s = true;
                return;
            }
            return;
        }
        if (z10) {
            this.f1535h = true;
            this.f1538k = true;
        }
        m2378i(z10);
    }

    /* renamed from: N */
    public boolean m2349N(MenuItem menuItem, int i10) {
        return m2350O(menuItem, null, i10);
    }

    /* renamed from: O */
    public boolean m2350O(MenuItem menuItem, InterfaceC0414k interfaceC0414k, int i10) {
        C0411h c0411h = (C0411h) menuItem;
        if (c0411h == null || !c0411h.isEnabled()) {
            return false;
        }
        boolean zM2478k = c0411h.m2478k();
        ActionProvider actionProviderMo2408b = c0411h.mo2408b();
        boolean z10 = actionProviderMo2408b != null && actionProviderMo2408b.mo2399a();
        if (c0411h.m2477j()) {
            zM2478k |= c0411h.expandActionView();
            if (zM2478k) {
                m2370e(true);
            }
        } else if (c0411h.hasSubMenu() || z10) {
            if ((i10 & 4) == 0) {
                m2370e(false);
            }
            if (!c0411h.hasSubMenu()) {
                c0411h.m2491x(new SubMenuC0419p(m2391w(), this, c0411h));
            }
            SubMenuC0419p subMenuC0419p = (SubMenuC0419p) c0411h.getSubMenu();
            if (z10) {
                actionProviderMo2408b.mo2402f(subMenuC0419p);
            }
            zM2478k |= m2381l(subMenuC0419p, interfaceC0414k);
            if (!zM2478k) {
                m2370e(true);
            }
        } else if ((i10 & 1) == 0) {
            m2370e(true);
        }
        return zM2478k;
    }

    /* renamed from: P */
    public final void m2351P(int i10, boolean z10) {
        if (i10 < 0 || i10 >= this.f1533f.size()) {
            return;
        }
        this.f1533f.remove(i10);
        if (z10) {
            mo2348M(true);
        }
    }

    /* renamed from: Q */
    public void m2352Q(InterfaceC0414k interfaceC0414k) {
        Iterator<WeakReference<InterfaceC0414k>> it = this.f1550w.iterator();
        while (it.hasNext()) {
            WeakReference<InterfaceC0414k> next = it.next();
            InterfaceC0414k interfaceC0414k2 = next.get();
            if (interfaceC0414k2 == null || interfaceC0414k2 == interfaceC0414k) {
                this.f1550w.remove(next);
            }
        }
    }

    /* renamed from: R */
    public void m2353R(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(mo2390v());
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = getItem(i10);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((SubMenuC0419p) item.getSubMenu()).m2353R(bundle);
            }
        }
        int i11 = bundle.getInt("android:menu:expandedactionview");
        if (i11 <= 0 || (menuItemFindItem = findItem(i11)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    /* renamed from: S */
    public void m2354S(Bundle bundle) {
        m2379j(bundle);
    }

    /* renamed from: T */
    public void m2355T(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = getItem(i10);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((SubMenuC0419p) item.getSubMenu()).m2355T(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(mo2390v(), sparseArray);
        }
    }

    /* renamed from: U */
    public void m2356U(Bundle bundle) {
        m2380k(bundle);
    }

    /* renamed from: V */
    public void mo2357V(InterfaceC0398a interfaceC0398a) {
        this.f1532e = interfaceC0398a;
    }

    /* renamed from: W */
    public MenuBuilder m2358W(int i10) {
        this.f1539l = i10;
        return this;
    }

    /* renamed from: X */
    public void m2359X(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f1533f.size();
        m2377h0();
        for (int i10 = 0; i10 < size; i10++) {
            C0411h c0411h = this.f1533f.get(i10);
            if (c0411h.getGroupId() == groupId && c0411h.m2480m() && c0411h.isCheckable()) {
                c0411h.m2486s(c0411h == menuItem);
            }
        }
        m2375g0();
    }

    /* renamed from: Y */
    public MenuBuilder m2360Y(int i10) {
        m2363a0(0, null, i10, null, null);
        return this;
    }

    /* renamed from: Z */
    public MenuBuilder m2361Z(Drawable drawable) {
        m2363a0(0, null, 0, drawable, null);
        return this;
    }

    /* renamed from: a */
    public MenuItem mo2362a(int i10, int i11, int i12, CharSequence charSequence) {
        int iM2335D = m2335D(i12);
        C0411h c0411hM2374g = m2374g(i10, i11, i12, iM2335D, charSequence, this.f1539l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f1540m;
        if (contextMenuInfo != null) {
            c0411hM2374g.m2489v(contextMenuInfo);
        }
        ArrayList<C0411h> arrayList = this.f1533f;
        arrayList.add(m2336p(arrayList, iM2335D), c0411hM2374g);
        mo2348M(true);
        return c0411hM2374g;
    }

    /* renamed from: a0 */
    public final void m2363a0(int i10, CharSequence charSequence, int i11, Drawable drawable, View view) {
        Resources resourcesM2340E = m2340E();
        if (view != null) {
            this.f1543p = view;
            this.f1541n = null;
            this.f1542o = null;
        } else {
            if (i10 > 0) {
                this.f1541n = resourcesM2340E.getText(i10);
            } else if (charSequence != null) {
                this.f1541n = charSequence;
            }
            if (i11 > 0) {
                this.f1542o = ContextCompat.getDrawable(m2391w(), i11);
            } else if (drawable != null) {
                this.f1542o = drawable;
            }
            this.f1543p = null;
        }
        mo2348M(false);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return mo2362a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i10, int i11, int i12, ComponentName componentName, Intent[] intentArr, Intent intent, int i13, MenuItem[] menuItemArr) {
        int i14;
        PackageManager packageManager = this.f1528a.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i13 & 1) == 0) {
            removeGroup(i10);
        }
        for (int i15 = 0; i15 < size; i15++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i15);
            int i16 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i16 < 0 ? intent : intentArr[i16]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i10, i11, i12, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i14 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i14] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    /* renamed from: b */
    public void m2364b(InterfaceC0414k interfaceC0414k) {
        m2366c(interfaceC0414k, this.f1528a);
    }

    /* renamed from: b0 */
    public MenuBuilder m2365b0(int i10) {
        m2363a0(i10, null, 0, null, null);
        return this;
    }

    /* renamed from: c */
    public void m2366c(InterfaceC0414k interfaceC0414k, Context context) {
        this.f1550w.add(new WeakReference<>(interfaceC0414k));
        interfaceC0414k.mo2418g(context, this);
        this.f1538k = true;
    }

    /* renamed from: c0 */
    public MenuBuilder m2367c0(CharSequence charSequence) {
        m2363a0(0, charSequence, 0, null, null);
        return this;
    }

    @Override // android.view.Menu
    public void clear() {
        C0411h c0411h = this.f1551x;
        if (c0411h != null) {
            mo2372f(c0411h);
        }
        this.f1533f.clear();
        mo2348M(true);
    }

    public void clearHeader() {
        this.f1542o = null;
        this.f1541n = null;
        this.f1543p = null;
        mo2348M(false);
    }

    @Override // android.view.Menu
    public void close() {
        m2370e(true);
    }

    /* renamed from: d */
    public void m2368d() {
        InterfaceC0398a interfaceC0398a = this.f1532e;
        if (interfaceC0398a != null) {
            interfaceC0398a.mo2105b(this);
        }
    }

    /* renamed from: d0 */
    public MenuBuilder m2369d0(View view) {
        m2363a0(0, null, 0, null, view);
        return this;
    }

    /* renamed from: e */
    public final void m2370e(boolean z10) {
        if (this.f1548u) {
            return;
        }
        this.f1548u = true;
        Iterator<WeakReference<InterfaceC0414k>> it = this.f1550w.iterator();
        while (it.hasNext()) {
            WeakReference<InterfaceC0414k> next = it.next();
            InterfaceC0414k interfaceC0414k = next.get();
            if (interfaceC0414k == null) {
                this.f1550w.remove(next);
            } else {
                interfaceC0414k.mo2413a(this, z10);
            }
        }
        this.f1548u = false;
    }

    /* renamed from: e0 */
    public void m2371e0(boolean z10) {
        this.f1553z = z10;
    }

    /* renamed from: f */
    public boolean mo2372f(C0411h c0411h) {
        boolean zMo2415d = false;
        if (!this.f1550w.isEmpty() && this.f1551x == c0411h) {
            m2377h0();
            Iterator<WeakReference<InterfaceC0414k>> it = this.f1550w.iterator();
            while (it.hasNext()) {
                WeakReference<InterfaceC0414k> next = it.next();
                InterfaceC0414k interfaceC0414k = next.get();
                if (interfaceC0414k == null) {
                    this.f1550w.remove(next);
                } else {
                    zMo2415d = interfaceC0414k.mo2415d(this, c0411h);
                    if (zMo2415d) {
                        break;
                    }
                }
            }
            m2375g0();
            if (zMo2415d) {
                this.f1551x = null;
            }
        }
        return zMo2415d;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x001c  */
    /* renamed from: f0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m2373f0(boolean r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L1c
            android.content.res.Resources r3 = r2.f1529b
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.keyboard
            r0 = 1
            if (r3 == r0) goto L1c
            android.content.Context r3 = r2.f1528a
            android.view.ViewConfiguration r3 = android.view.ViewConfiguration.get(r3)
            android.content.Context r1 = r2.f1528a
            boolean r3 = p273f0.C9607j0.m60064c(r3, r1)
            if (r3 == 0) goto L1c
            goto L1d
        L1c:
            r0 = 0
        L1d:
            r2.f1531d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.MenuBuilder.m2373f0(boolean):void");
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i10) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            C0411h c0411h = this.f1533f.get(i11);
            if (c0411h.getItemId() == i10) {
                return c0411h;
            }
            if (c0411h.hasSubMenu() && (menuItemFindItem = c0411h.getSubMenu().findItem(i10)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    /* renamed from: g */
    public final C0411h m2374g(int i10, int i11, int i12, int i13, CharSequence charSequence, int i14) {
        return new C0411h(this, i10, i11, i12, i13, charSequence, i14);
    }

    /* renamed from: g0 */
    public void m2375g0() {
        this.f1544q = false;
        if (this.f1545r) {
            this.f1545r = false;
            mo2348M(this.f1546s);
        }
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i10) {
        return this.f1533f.get(i10);
    }

    /* renamed from: h */
    public boolean mo2376h(MenuBuilder menuBuilder, MenuItem menuItem) {
        InterfaceC0398a interfaceC0398a = this.f1532e;
        return interfaceC0398a != null && interfaceC0398a.mo2102a(menuBuilder, menuItem);
    }

    /* renamed from: h0 */
    public void m2377h0() {
        if (this.f1544q) {
            return;
        }
        this.f1544q = true;
        this.f1545r = false;
        this.f1546s = false;
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.f1553z) {
            return true;
        }
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f1533f.get(i10).isVisible()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: i */
    public final void m2378i(boolean z10) {
        if (this.f1550w.isEmpty()) {
            return;
        }
        m2377h0();
        Iterator<WeakReference<InterfaceC0414k>> it = this.f1550w.iterator();
        while (it.hasNext()) {
            WeakReference<InterfaceC0414k> next = it.next();
            InterfaceC0414k interfaceC0414k = next.get();
            if (interfaceC0414k == null) {
                this.f1550w.remove(next);
            } else {
                interfaceC0414k.mo2414b(z10);
            }
        }
        m2375g0();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i10, KeyEvent keyEvent) {
        return m2386r(i10, keyEvent) != null;
    }

    /* renamed from: j */
    public final void m2379j(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray == null || this.f1550w.isEmpty()) {
            return;
        }
        Iterator<WeakReference<InterfaceC0414k>> it = this.f1550w.iterator();
        while (it.hasNext()) {
            WeakReference<InterfaceC0414k> next = it.next();
            InterfaceC0414k interfaceC0414k = next.get();
            if (interfaceC0414k == null) {
                this.f1550w.remove(next);
            } else {
                int id2 = interfaceC0414k.getId();
                if (id2 > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id2)) != null) {
                    interfaceC0414k.mo2440h(parcelable);
                }
            }
        }
    }

    /* renamed from: k */
    public final void m2380k(Bundle bundle) {
        Parcelable parcelableMo2442k;
        if (this.f1550w.isEmpty()) {
            return;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        Iterator<WeakReference<InterfaceC0414k>> it = this.f1550w.iterator();
        while (it.hasNext()) {
            WeakReference<InterfaceC0414k> next = it.next();
            InterfaceC0414k interfaceC0414k = next.get();
            if (interfaceC0414k == null) {
                this.f1550w.remove(next);
            } else {
                int id2 = interfaceC0414k.getId();
                if (id2 > 0 && (parcelableMo2442k = interfaceC0414k.mo2442k()) != null) {
                    sparseArray.put(id2, parcelableMo2442k);
                }
            }
        }
        bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
    }

    /* renamed from: l */
    public final boolean m2381l(SubMenuC0419p subMenuC0419p, InterfaceC0414k interfaceC0414k) {
        if (this.f1550w.isEmpty()) {
            return false;
        }
        boolean zMo2419i = interfaceC0414k != null ? interfaceC0414k.mo2419i(subMenuC0419p) : false;
        Iterator<WeakReference<InterfaceC0414k>> it = this.f1550w.iterator();
        while (it.hasNext()) {
            WeakReference<InterfaceC0414k> next = it.next();
            InterfaceC0414k interfaceC0414k2 = next.get();
            if (interfaceC0414k2 == null) {
                this.f1550w.remove(next);
            } else if (!zMo2419i) {
                zMo2419i = interfaceC0414k2.mo2419i(subMenuC0419p);
            }
        }
        return zMo2419i;
    }

    /* renamed from: m */
    public boolean mo2382m(C0411h c0411h) {
        boolean zMo2416e = false;
        if (this.f1550w.isEmpty()) {
            return false;
        }
        m2377h0();
        Iterator<WeakReference<InterfaceC0414k>> it = this.f1550w.iterator();
        while (it.hasNext()) {
            WeakReference<InterfaceC0414k> next = it.next();
            InterfaceC0414k interfaceC0414k = next.get();
            if (interfaceC0414k == null) {
                this.f1550w.remove(next);
            } else {
                zMo2416e = interfaceC0414k.mo2416e(this, c0411h);
                if (zMo2416e) {
                    break;
                }
            }
        }
        m2375g0();
        if (zMo2416e) {
            this.f1551x = c0411h;
        }
        return zMo2416e;
    }

    /* renamed from: n */
    public int m2383n(int i10) {
        return m2384o(i10, 0);
    }

    /* renamed from: o */
    public int m2384o(int i10, int i11) {
        int size = size();
        if (i11 < 0) {
            i11 = 0;
        }
        while (i11 < size) {
            if (this.f1533f.get(i11).getGroupId() == i10) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i10, int i11) {
        return m2349N(findItem(i10), i11);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i10, KeyEvent keyEvent, int i11) {
        C0411h c0411hM2386r = m2386r(i10, keyEvent);
        boolean zM2349N = c0411hM2386r != null ? m2349N(c0411hM2386r, i11) : false;
        if ((i11 & 2) != 0) {
            m2370e(true);
        }
        return zM2349N;
    }

    /* renamed from: q */
    public int m2385q(int i10) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            if (this.f1533f.get(i11).getItemId() == i10) {
                return i11;
            }
        }
        return -1;
    }

    /* renamed from: r */
    public C0411h m2386r(int i10, KeyEvent keyEvent) {
        ArrayList<C0411h> arrayList = this.f1549v;
        arrayList.clear();
        m2387s(arrayList, i10, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean zMo2344I = mo2344I();
        for (int i11 = 0; i11 < size; i11++) {
            C0411h c0411h = arrayList.get(i11);
            char alphabeticShortcut = zMo2344I ? c0411h.getAlphabeticShortcut() : c0411h.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (zMo2344I && alphabeticShortcut == '\b' && i10 == 67))) {
                return c0411h;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public void removeGroup(int i10) {
        int iM2383n = m2383n(i10);
        if (iM2383n >= 0) {
            int size = this.f1533f.size() - iM2383n;
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                if (i11 >= size || this.f1533f.get(iM2383n).getGroupId() != i10) {
                    break;
                }
                m2351P(iM2383n, false);
                i11 = i12;
            }
            mo2348M(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i10) {
        m2351P(m2385q(i10), true);
    }

    /* renamed from: s */
    public void m2387s(List<C0411h> list, int i10, KeyEvent keyEvent) {
        boolean zMo2344I = mo2344I();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i10 == 67) {
            int size = this.f1533f.size();
            for (int i11 = 0; i11 < size; i11++) {
                C0411h c0411h = this.f1533f.get(i11);
                if (c0411h.hasSubMenu()) {
                    ((MenuBuilder) c0411h.getSubMenu()).m2387s(list, i10, keyEvent);
                }
                char alphabeticShortcut = zMo2344I ? c0411h.getAlphabeticShortcut() : c0411h.getNumericShortcut();
                if ((modifiers & 69647) == ((zMo2344I ? c0411h.getAlphabeticModifiers() : c0411h.getNumericModifiers()) & 69647) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (zMo2344I && alphabeticShortcut == '\b' && i10 == 67)) && c0411h.isEnabled()) {
                        list.add(c0411h);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i10, boolean z10, boolean z11) {
        int size = this.f1533f.size();
        for (int i11 = 0; i11 < size; i11++) {
            C0411h c0411h = this.f1533f.get(i11);
            if (c0411h.getGroupId() == i10) {
                c0411h.m2487t(z11);
                c0411h.setCheckable(z10);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z10) {
        this.f1552y = z10;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i10, boolean z10) {
        int size = this.f1533f.size();
        for (int i11 = 0; i11 < size; i11++) {
            C0411h c0411h = this.f1533f.get(i11);
            if (c0411h.getGroupId() == i10) {
                c0411h.setEnabled(z10);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i10, boolean z10) {
        int size = this.f1533f.size();
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            C0411h c0411h = this.f1533f.get(i11);
            if (c0411h.getGroupId() == i10 && c0411h.m2492y(z10)) {
                z11 = true;
            }
        }
        if (z11) {
            mo2348M(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z10) {
        this.f1530c = z10;
        mo2348M(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f1533f.size();
    }

    /* renamed from: t */
    public void m2388t() {
        ArrayList<C0411h> arrayListM2342G = m2342G();
        if (this.f1538k) {
            Iterator<WeakReference<InterfaceC0414k>> it = this.f1550w.iterator();
            boolean zMo2439c = false;
            while (it.hasNext()) {
                WeakReference<InterfaceC0414k> next = it.next();
                InterfaceC0414k interfaceC0414k = next.get();
                if (interfaceC0414k == null) {
                    this.f1550w.remove(next);
                } else {
                    zMo2439c |= interfaceC0414k.mo2439c();
                }
            }
            if (zMo2439c) {
                this.f1536i.clear();
                this.f1537j.clear();
                int size = arrayListM2342G.size();
                for (int i10 = 0; i10 < size; i10++) {
                    C0411h c0411h = arrayListM2342G.get(i10);
                    if (c0411h.m2479l()) {
                        this.f1536i.add(c0411h);
                    } else {
                        this.f1537j.add(c0411h);
                    }
                }
            } else {
                this.f1536i.clear();
                this.f1537j.clear();
                this.f1537j.addAll(m2342G());
            }
            this.f1538k = false;
        }
    }

    /* renamed from: u */
    public ArrayList<C0411h> m2389u() {
        m2388t();
        return this.f1536i;
    }

    /* renamed from: v */
    public String mo2390v() {
        return "android:menu:actionviewstates";
    }

    /* renamed from: w */
    public Context m2391w() {
        return this.f1528a;
    }

    /* renamed from: x */
    public C0411h m2392x() {
        return this.f1551x;
    }

    /* renamed from: y */
    public Drawable m2393y() {
        return this.f1542o;
    }

    /* renamed from: z */
    public CharSequence m2394z() {
        return this.f1541n;
    }

    @Override // android.view.Menu
    public MenuItem add(int i10) {
        return mo2362a(0, 0, 0, this.f1529b.getString(i10));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10) {
        return addSubMenu(0, 0, 0, this.f1529b.getString(i10));
    }

    @Override // android.view.Menu
    public MenuItem add(int i10, int i11, int i12, CharSequence charSequence) {
        return mo2362a(i10, i11, i12, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, CharSequence charSequence) {
        C0411h c0411h = (C0411h) mo2362a(i10, i11, i12, charSequence);
        SubMenuC0419p subMenuC0419p = new SubMenuC0419p(this.f1528a, this, c0411h);
        c0411h.m2491x(subMenuC0419p);
        return subMenuC0419p;
    }

    @Override // android.view.Menu
    public MenuItem add(int i10, int i11, int i12, int i13) {
        return mo2362a(i10, i11, i12, this.f1529b.getString(i13));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, int i13) {
        return addSubMenu(i10, i11, i12, this.f1529b.getString(i13));
    }
}
