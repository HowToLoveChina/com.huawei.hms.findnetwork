package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.AbstractC0735a0;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.AbstractC0791h;
import java.io.PrintWriter;
import java.util.ArrayList;

/* renamed from: androidx.fragment.app.a */
/* loaded from: classes.dex */
public final class C0734a extends AbstractC0735a0 implements FragmentManager.InterfaceC0728l {

    /* renamed from: t */
    public final FragmentManager f3886t;

    /* renamed from: u */
    public boolean f3887u;

    /* renamed from: v */
    public int f3888v;

    /* renamed from: w */
    public boolean f3889w;

    public C0734a(FragmentManager fragmentManager) {
        super(fragmentManager.m4601t0(), fragmentManager.m4607v0() != null ? fragmentManager.m4607v0().m4798i().getClassLoader() : null);
        this.f3888v = -1;
        this.f3889w = false;
        this.f3886t = fragmentManager;
    }

    /* renamed from: A */
    public void m4641A() {
        int size = this.f3892c.size();
        for (int i10 = 0; i10 < size; i10++) {
            AbstractC0735a0.a aVar = this.f3892c.get(i10);
            Fragment fragment = aVar.f3910b;
            if (fragment != null) {
                fragment.f3736n = this.f3889w;
                fragment.m4452x1(false);
                fragment.m4449w1(this.f3897h);
                fragment.m4458z1(this.f3905p, this.f3906q);
            }
            switch (aVar.f3909a) {
                case 1:
                    fragment.m4434r1(aVar.f3912d, aVar.f3913e, aVar.f3914f, aVar.f3915g);
                    this.f3886t.m4584n1(fragment, false);
                    this.f3886t.m4573j(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f3909a);
                case 3:
                    fragment.m4434r1(aVar.f3912d, aVar.f3913e, aVar.f3914f, aVar.f3915g);
                    this.f3886t.m4565f1(fragment);
                    break;
                case 4:
                    fragment.m4434r1(aVar.f3912d, aVar.f3913e, aVar.f3914f, aVar.f3915g);
                    this.f3886t.m4515F0(fragment);
                    break;
                case 5:
                    fragment.m4434r1(aVar.f3912d, aVar.f3913e, aVar.f3914f, aVar.f3915g);
                    this.f3886t.m4584n1(fragment, false);
                    this.f3886t.m4596r1(fragment);
                    break;
                case 6:
                    fragment.m4434r1(aVar.f3912d, aVar.f3913e, aVar.f3914f, aVar.f3915g);
                    this.f3886t.m4608w(fragment);
                    break;
                case 7:
                    fragment.m4434r1(aVar.f3912d, aVar.f3913e, aVar.f3914f, aVar.f3915g);
                    this.f3886t.m4584n1(fragment, false);
                    this.f3886t.m4582n(fragment);
                    break;
                case 8:
                    this.f3886t.m4590p1(fragment);
                    break;
                case 9:
                    this.f3886t.m4590p1(null);
                    break;
                case 10:
                    this.f3886t.m4587o1(fragment, aVar.f3917i);
                    break;
            }
        }
    }

    /* renamed from: B */
    public void m4642B() {
        for (int size = this.f3892c.size() - 1; size >= 0; size--) {
            AbstractC0735a0.a aVar = this.f3892c.get(size);
            Fragment fragment = aVar.f3910b;
            if (fragment != null) {
                fragment.f3736n = this.f3889w;
                fragment.m4452x1(true);
                fragment.m4449w1(FragmentManager.m4502j1(this.f3897h));
                fragment.m4458z1(this.f3906q, this.f3905p);
            }
            switch (aVar.f3909a) {
                case 1:
                    fragment.m4434r1(aVar.f3912d, aVar.f3913e, aVar.f3914f, aVar.f3915g);
                    this.f3886t.m4584n1(fragment, true);
                    this.f3886t.m4565f1(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f3909a);
                case 3:
                    fragment.m4434r1(aVar.f3912d, aVar.f3913e, aVar.f3914f, aVar.f3915g);
                    this.f3886t.m4573j(fragment);
                    break;
                case 4:
                    fragment.m4434r1(aVar.f3912d, aVar.f3913e, aVar.f3914f, aVar.f3915g);
                    this.f3886t.m4596r1(fragment);
                    break;
                case 5:
                    fragment.m4434r1(aVar.f3912d, aVar.f3913e, aVar.f3914f, aVar.f3915g);
                    this.f3886t.m4584n1(fragment, true);
                    this.f3886t.m4515F0(fragment);
                    break;
                case 6:
                    fragment.m4434r1(aVar.f3912d, aVar.f3913e, aVar.f3914f, aVar.f3915g);
                    this.f3886t.m4582n(fragment);
                    break;
                case 7:
                    fragment.m4434r1(aVar.f3912d, aVar.f3913e, aVar.f3914f, aVar.f3915g);
                    this.f3886t.m4584n1(fragment, true);
                    this.f3886t.m4608w(fragment);
                    break;
                case 8:
                    this.f3886t.m4590p1(null);
                    break;
                case 9:
                    this.f3886t.m4590p1(fragment);
                    break;
                case 10:
                    this.f3886t.m4587o1(fragment, aVar.f3916h);
                    break;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x00b6  */
    /* renamed from: C */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.fragment.app.Fragment m4643C(java.util.ArrayList<androidx.fragment.app.Fragment> r17, androidx.fragment.app.Fragment r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = 0
        L7:
            java.util.ArrayList<androidx.fragment.app.a0$a> r5 = r0.f3892c
            int r5 = r5.size()
            if (r4 >= r5) goto Lbe
            java.util.ArrayList<androidx.fragment.app.a0$a> r5 = r0.f3892c
            java.lang.Object r5 = r5.get(r4)
            androidx.fragment.app.a0$a r5 = (androidx.fragment.app.AbstractC0735a0.a) r5
            int r6 = r5.f3909a
            r7 = 1
            if (r6 == r7) goto Lb6
            r8 = 2
            r9 = 0
            r10 = 3
            r11 = 9
            if (r6 == r8) goto L5a
            if (r6 == r10) goto L43
            r8 = 6
            if (r6 == r8) goto L43
            r8 = 7
            if (r6 == r8) goto Lb6
            r8 = 8
            if (r6 == r8) goto L31
            goto Lbb
        L31:
            java.util.ArrayList<androidx.fragment.app.a0$a> r6 = r0.f3892c
            androidx.fragment.app.a0$a r8 = new androidx.fragment.app.a0$a
            r8.<init>(r11, r3, r7)
            r6.add(r4, r8)
            r5.f3911c = r7
            int r4 = r4 + 1
            androidx.fragment.app.Fragment r3 = r5.f3910b
            goto Lbb
        L43:
            androidx.fragment.app.Fragment r6 = r5.f3910b
            r1.remove(r6)
            androidx.fragment.app.Fragment r5 = r5.f3910b
            if (r5 != r3) goto Lbb
            java.util.ArrayList<androidx.fragment.app.a0$a> r3 = r0.f3892c
            androidx.fragment.app.a0$a r6 = new androidx.fragment.app.a0$a
            r6.<init>(r11, r5)
            r3.add(r4, r6)
            int r4 = r4 + 1
            r3 = r9
            goto Lbb
        L5a:
            androidx.fragment.app.Fragment r6 = r5.f3910b
            int r8 = r6.f3747y
            int r12 = r17.size()
            int r12 = r12 - r7
            r13 = 0
        L64:
            if (r12 < 0) goto La4
            java.lang.Object r14 = r1.get(r12)
            androidx.fragment.app.Fragment r14 = (androidx.fragment.app.Fragment) r14
            int r15 = r14.f3747y
            if (r15 != r8) goto La1
            if (r14 != r6) goto L74
            r13 = r7
            goto La1
        L74:
            if (r14 != r3) goto L83
            java.util.ArrayList<androidx.fragment.app.a0$a> r3 = r0.f3892c
            androidx.fragment.app.a0$a r15 = new androidx.fragment.app.a0$a
            r15.<init>(r11, r14, r7)
            r3.add(r4, r15)
            int r4 = r4 + 1
            r3 = r9
        L83:
            androidx.fragment.app.a0$a r15 = new androidx.fragment.app.a0$a
            r15.<init>(r10, r14, r7)
            int r2 = r5.f3912d
            r15.f3912d = r2
            int r2 = r5.f3914f
            r15.f3914f = r2
            int r2 = r5.f3913e
            r15.f3913e = r2
            int r2 = r5.f3915g
            r15.f3915g = r2
            java.util.ArrayList<androidx.fragment.app.a0$a> r2 = r0.f3892c
            r2.add(r4, r15)
            r1.remove(r14)
            int r4 = r4 + r7
        La1:
            int r12 = r12 + (-1)
            goto L64
        La4:
            if (r13 == 0) goto Lae
            java.util.ArrayList<androidx.fragment.app.a0$a> r2 = r0.f3892c
            r2.remove(r4)
            int r4 = r4 + (-1)
            goto Lbb
        Lae:
            r5.f3909a = r7
            r5.f3911c = r7
            r1.add(r6)
            goto Lbb
        Lb6:
            androidx.fragment.app.Fragment r2 = r5.f3910b
            r1.add(r2)
        Lbb:
            int r4 = r4 + r7
            goto L7
        Lbe:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0734a.m4643C(java.util.ArrayList, androidx.fragment.app.Fragment):androidx.fragment.app.Fragment");
    }

    /* renamed from: D */
    public String m4644D() {
        return this.f3900k;
    }

    /* renamed from: E */
    public void m4645E() {
        if (this.f3908s != null) {
            for (int i10 = 0; i10 < this.f3908s.size(); i10++) {
                this.f3908s.get(i10).run();
            }
            this.f3908s = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x002d  */
    /* renamed from: F */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.fragment.app.Fragment m4646F(java.util.ArrayList<androidx.fragment.app.Fragment> r6, androidx.fragment.app.Fragment r7) {
        /*
            r5 = this;
            java.util.ArrayList<androidx.fragment.app.a0$a> r0 = r5.f3892c
            int r0 = r0.size()
            r1 = 1
            int r0 = r0 - r1
        L8:
            if (r0 < 0) goto L35
            java.util.ArrayList<androidx.fragment.app.a0$a> r2 = r5.f3892c
            java.lang.Object r2 = r2.get(r0)
            androidx.fragment.app.a0$a r2 = (androidx.fragment.app.AbstractC0735a0.a) r2
            int r3 = r2.f3909a
            if (r3 == r1) goto L2d
            r4 = 3
            if (r3 == r4) goto L27
            switch(r3) {
                case 6: goto L27;
                case 7: goto L2d;
                case 8: goto L25;
                case 9: goto L22;
                case 10: goto L1d;
                default: goto L1c;
            }
        L1c:
            goto L32
        L1d:
            androidx.lifecycle.h$c r3 = r2.f3916h
            r2.f3917i = r3
            goto L32
        L22:
            androidx.fragment.app.Fragment r7 = r2.f3910b
            goto L32
        L25:
            r7 = 0
            goto L32
        L27:
            androidx.fragment.app.Fragment r2 = r2.f3910b
            r6.add(r2)
            goto L32
        L2d:
            androidx.fragment.app.Fragment r2 = r2.f3910b
            r6.remove(r2)
        L32:
            int r0 = r0 + (-1)
            goto L8
        L35:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0734a.m4646F(java.util.ArrayList, androidx.fragment.app.Fragment):androidx.fragment.app.Fragment");
    }

    @Override // androidx.fragment.app.FragmentManager.InterfaceC0728l
    /* renamed from: a */
    public boolean mo4630a(ArrayList<C0734a> arrayList, ArrayList<Boolean> arrayList2) {
        if (FragmentManager.m4492I0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f3898i) {
            return true;
        }
        this.f3886t.m4570i(this);
        return true;
    }

    @Override // androidx.fragment.app.AbstractC0735a0
    /* renamed from: h */
    public int mo4647h() {
        return m4659x(false);
    }

    @Override // androidx.fragment.app.AbstractC0735a0
    /* renamed from: i */
    public int mo4648i() {
        return m4659x(true);
    }

    @Override // androidx.fragment.app.AbstractC0735a0
    /* renamed from: j */
    public void mo4649j() {
        m4668m();
        this.f3886t.m4557b0(this, false);
    }

    @Override // androidx.fragment.app.AbstractC0735a0
    /* renamed from: k */
    public void mo4650k() {
        m4668m();
        this.f3886t.m4557b0(this, true);
    }

    @Override // androidx.fragment.app.AbstractC0735a0
    /* renamed from: l */
    public AbstractC0735a0 mo4651l(Fragment fragment) {
        FragmentManager fragmentManager = fragment.f3742t;
        if (fragmentManager == null || fragmentManager == this.f3886t) {
            return super.mo4651l(fragment);
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.AbstractC0735a0
    /* renamed from: n */
    public void mo4652n(int i10, Fragment fragment, String str, int i11) {
        super.mo4652n(i10, fragment, str, i11);
        fragment.f3742t = this.f3886t;
    }

    @Override // androidx.fragment.app.AbstractC0735a0
    /* renamed from: o */
    public AbstractC0735a0 mo4653o(Fragment fragment) {
        FragmentManager fragmentManager = fragment.f3742t;
        if (fragmentManager == null || fragmentManager == this.f3886t) {
            return super.mo4653o(fragment);
        }
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.AbstractC0735a0
    /* renamed from: p */
    public boolean mo4654p() {
        return this.f3892c.isEmpty();
    }

    @Override // androidx.fragment.app.AbstractC0735a0
    /* renamed from: q */
    public AbstractC0735a0 mo4655q(Fragment fragment) {
        FragmentManager fragmentManager = fragment.f3742t;
        if (fragmentManager == null || fragmentManager == this.f3886t) {
            return super.mo4655q(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.AbstractC0735a0
    /* renamed from: t */
    public AbstractC0735a0 mo4656t(Fragment fragment, AbstractC0791h.c cVar) {
        if (fragment.f3742t != this.f3886t) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.f3886t);
        }
        if (cVar == AbstractC0791h.c.INITIALIZED && fragment.f3722a > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + cVar + " after the Fragment has been created");
        }
        if (cVar != AbstractC0791h.c.DESTROYED) {
            return super.mo4656t(fragment, cVar);
        }
        throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + cVar + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("BackStackEntry{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f3888v >= 0) {
            sb2.append(" #");
            sb2.append(this.f3888v);
        }
        if (this.f3900k != null) {
            sb2.append(" ");
            sb2.append(this.f3900k);
        }
        sb2.append("}");
        return sb2.toString();
    }

    @Override // androidx.fragment.app.AbstractC0735a0
    /* renamed from: v */
    public AbstractC0735a0 mo4657v(Fragment fragment) {
        FragmentManager fragmentManager = fragment.f3742t;
        if (fragmentManager == null || fragmentManager == this.f3886t) {
            return super.mo4657v(fragment);
        }
        throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    /* renamed from: w */
    public void m4658w(int i10) {
        if (this.f3898i) {
            if (FragmentManager.m4492I0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i10);
            }
            int size = this.f3892c.size();
            for (int i11 = 0; i11 < size; i11++) {
                AbstractC0735a0.a aVar = this.f3892c.get(i11);
                Fragment fragment = aVar.f3910b;
                if (fragment != null) {
                    fragment.f3741s += i10;
                    if (FragmentManager.m4492I0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f3910b + " to " + aVar.f3910b.f3741s);
                    }
                }
            }
        }
    }

    /* renamed from: x */
    public int m4659x(boolean z10) {
        if (this.f3887u) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManager.m4492I0(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new C0745f0("FragmentManager"));
            m4660y("  ", printWriter);
            printWriter.close();
        }
        this.f3887u = true;
        if (this.f3898i) {
            this.f3888v = this.f3886t.m4577l();
        } else {
            this.f3888v = -1;
        }
        this.f3886t.m4551Y(this, z10);
        return this.f3888v;
    }

    /* renamed from: y */
    public void m4660y(String str, PrintWriter printWriter) {
        m4661z(str, printWriter, true);
    }

    /* renamed from: z */
    public void m4661z(String str, PrintWriter printWriter, boolean z10) {
        String str2;
        if (z10) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f3900k);
            printWriter.print(" mIndex=");
            printWriter.print(this.f3888v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f3887u);
            if (this.f3897h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f3897h));
            }
            if (this.f3893d != 0 || this.f3894e != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f3893d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f3894e));
            }
            if (this.f3895f != 0 || this.f3896g != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f3895f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f3896g));
            }
            if (this.f3901l != 0 || this.f3902m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f3901l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f3902m);
            }
            if (this.f3903n != 0 || this.f3904o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f3903n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f3904o);
            }
        }
        if (this.f3892c.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f3892c.size();
        for (int i10 = 0; i10 < size; i10++) {
            AbstractC0735a0.a aVar = this.f3892c.get(i10);
            switch (aVar.f3909a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.f3909a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i10);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.f3910b);
            if (z10) {
                if (aVar.f3912d != 0 || aVar.f3913e != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f3912d));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f3913e));
                }
                if (aVar.f3914f != 0 || aVar.f3915g != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f3914f));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f3915g));
                }
            }
        }
    }
}
