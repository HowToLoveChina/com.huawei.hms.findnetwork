package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.ComponentDialog;
import androidx.lifecycle.C0790g0;
import androidx.lifecycle.C0792h0;
import androidx.lifecycle.InterfaceC0796l;
import androidx.lifecycle.InterfaceC0802r;
import p724w0.C13515e;

/* renamed from: androidx.fragment.app.c */
/* loaded from: classes.dex */
public class DialogInterfaceOnCancelListenerC0738c extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* renamed from: c0 */
    public Handler f3966c0;

    /* renamed from: l0 */
    public boolean f3975l0;

    /* renamed from: n0 */
    public Dialog f3977n0;

    /* renamed from: o0 */
    public boolean f3978o0;

    /* renamed from: p0 */
    public boolean f3979p0;

    /* renamed from: q0 */
    public boolean f3980q0;

    /* renamed from: d0 */
    public Runnable f3967d0 = new a();

    /* renamed from: e0 */
    public DialogInterface.OnCancelListener f3968e0 = new b();

    /* renamed from: f0 */
    public DialogInterface.OnDismissListener f3969f0 = new c();

    /* renamed from: g0 */
    public int f3970g0 = 0;

    /* renamed from: h0 */
    public int f3971h0 = 0;

    /* renamed from: i0 */
    public boolean f3972i0 = true;

    /* renamed from: j0 */
    public boolean f3973j0 = true;

    /* renamed from: k0 */
    public int f3974k0 = -1;

    /* renamed from: m0 */
    public InterfaceC0802r<InterfaceC0796l> f3976m0 = new d();

    /* renamed from: r0 */
    public boolean f3981r0 = false;

    /* renamed from: androidx.fragment.app.c$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        @SuppressLint({"SyntheticAccessor"})
        public void run() {
            DialogInterfaceOnCancelListenerC0738c.this.f3969f0.onDismiss(DialogInterfaceOnCancelListenerC0738c.this.f3977n0);
        }
    }

    /* renamed from: androidx.fragment.app.c$b */
    public class b implements DialogInterface.OnCancelListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        @SuppressLint({"SyntheticAccessor"})
        public void onCancel(DialogInterface dialogInterface) {
            if (DialogInterfaceOnCancelListenerC0738c.this.f3977n0 != null) {
                DialogInterfaceOnCancelListenerC0738c dialogInterfaceOnCancelListenerC0738c = DialogInterfaceOnCancelListenerC0738c.this;
                dialogInterfaceOnCancelListenerC0738c.onCancel(dialogInterfaceOnCancelListenerC0738c.f3977n0);
            }
        }
    }

    /* renamed from: androidx.fragment.app.c$c */
    public class c implements DialogInterface.OnDismissListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        @SuppressLint({"SyntheticAccessor"})
        public void onDismiss(DialogInterface dialogInterface) {
            if (DialogInterfaceOnCancelListenerC0738c.this.f3977n0 != null) {
                DialogInterfaceOnCancelListenerC0738c dialogInterfaceOnCancelListenerC0738c = DialogInterfaceOnCancelListenerC0738c.this;
                dialogInterfaceOnCancelListenerC0738c.onDismiss(dialogInterfaceOnCancelListenerC0738c.f3977n0);
            }
        }
    }

    /* renamed from: androidx.fragment.app.c$d */
    public class d implements InterfaceC0802r<InterfaceC0796l> {
        public d() {
        }

        @Override // androidx.lifecycle.InterfaceC0802r
        @SuppressLint({"SyntheticAccessor"})
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo4709a(InterfaceC0796l interfaceC0796l) {
            if (interfaceC0796l == null || !DialogInterfaceOnCancelListenerC0738c.this.f3973j0) {
                return;
            }
            View viewM4422n1 = DialogInterfaceOnCancelListenerC0738c.this.m4422n1();
            if (viewM4422n1.getParent() != null) {
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
            if (DialogInterfaceOnCancelListenerC0738c.this.f3977n0 != null) {
                if (FragmentManager.m4492I0(3)) {
                    Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + DialogInterfaceOnCancelListenerC0738c.this.f3977n0);
                }
                DialogInterfaceOnCancelListenerC0738c.this.f3977n0.setContentView(viewM4422n1);
            }
        }
    }

    /* renamed from: androidx.fragment.app.c$e */
    public class e extends AbstractC0750i {

        /* renamed from: a */
        public final /* synthetic */ AbstractC0750i f3986a;

        public e(AbstractC0750i abstractC0750i) {
            this.f3986a = abstractC0750i;
        }

        @Override // androidx.fragment.app.AbstractC0750i
        /* renamed from: d */
        public View mo4463d(int i10) {
            return this.f3986a.mo4464e() ? this.f3986a.mo4463d(i10) : DialogInterfaceOnCancelListenerC0738c.this.m4703K1(i10);
        }

        @Override // androidx.fragment.app.AbstractC0750i
        /* renamed from: e */
        public boolean mo4464e() {
            return this.f3986a.mo4464e() || DialogInterfaceOnCancelListenerC0738c.this.m4704L1();
        }
    }

    /* renamed from: F1 */
    public void m4698F1() {
        m4699G1(false, false, false);
    }

    /* renamed from: G1 */
    public final void m4699G1(boolean z10, boolean z11, boolean z12) {
        if (this.f3979p0) {
            return;
        }
        this.f3979p0 = true;
        this.f3980q0 = false;
        Dialog dialog = this.f3977n0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.f3977n0.dismiss();
            if (!z11) {
                if (Looper.myLooper() == this.f3966c0.getLooper()) {
                    onDismiss(this.f3977n0);
                } else {
                    this.f3966c0.post(this.f3967d0);
                }
            }
        }
        this.f3978o0 = true;
        if (this.f3974k0 >= 0) {
            if (z12) {
                m4341D().m4558b1(this.f3974k0, 1);
            } else {
                m4341D().m4554Z0(this.f3974k0, 1, z10);
            }
            this.f3974k0 = -1;
            return;
        }
        AbstractC0735a0 abstractC0735a0M4585o = m4341D().m4585o();
        abstractC0735a0M4585o.m4671u(true);
        abstractC0735a0M4585o.mo4655q(this);
        if (z12) {
            abstractC0735a0M4585o.mo4649j();
        } else if (z10) {
            abstractC0735a0M4585o.mo4648i();
        } else {
            abstractC0735a0M4585o.mo4647h();
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: H0 */
    public void mo4350H0(Bundle bundle) {
        super.mo4350H0(bundle);
        Dialog dialog = this.f3977n0;
        if (dialog != null) {
            Bundle bundleOnSaveInstanceState = dialog.onSaveInstanceState();
            bundleOnSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", bundleOnSaveInstanceState);
        }
        int i10 = this.f3970g0;
        if (i10 != 0) {
            bundle.putInt("android:style", i10);
        }
        int i11 = this.f3971h0;
        if (i11 != 0) {
            bundle.putInt("android:theme", i11);
        }
        boolean z10 = this.f3972i0;
        if (!z10) {
            bundle.putBoolean("android:cancelable", z10);
        }
        boolean z11 = this.f3973j0;
        if (!z11) {
            bundle.putBoolean("android:showsDialog", z11);
        }
        int i12 = this.f3974k0;
        if (i12 != -1) {
            bundle.putInt("android:backStackId", i12);
        }
    }

    /* renamed from: H1 */
    public Dialog m4700H1() {
        return this.f3977n0;
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: I0 */
    public void mo4352I0() {
        super.mo4352I0();
        Dialog dialog = this.f3977n0;
        if (dialog != null) {
            this.f3978o0 = false;
            dialog.show();
            View decorView = this.f3977n0.getWindow().getDecorView();
            C0790g0.m4947a(decorView, this);
            C0792h0.m4955a(decorView, this);
            C13515e.m81275a(decorView, this);
        }
    }

    /* renamed from: I1 */
    public int m4701I1() {
        return this.f3971h0;
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: J0 */
    public void mo4353J0() {
        super.mo4353J0();
        Dialog dialog = this.f3977n0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    /* renamed from: J1 */
    public Dialog mo4702J1(Bundle bundle) {
        if (FragmentManager.m4492I0(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new ComponentDialog(m4419m1(), m4701I1());
    }

    /* renamed from: K1 */
    public View m4703K1(int i10) {
        Dialog dialog = this.f3977n0;
        if (dialog != null) {
            return dialog.findViewById(i10);
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: L0 */
    public void mo4357L0(Bundle bundle) {
        Bundle bundle2;
        super.mo4357L0(bundle);
        if (this.f3977n0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f3977n0.onRestoreInstanceState(bundle2);
    }

    /* renamed from: L1 */
    public boolean m4704L1() {
        return this.f3981r0;
    }

    /* renamed from: M1 */
    public final void m4705M1(Bundle bundle) {
        if (this.f3973j0 && !this.f3981r0) {
            try {
                this.f3975l0 = true;
                Dialog dialogMo4702J1 = mo4702J1(bundle);
                this.f3977n0 = dialogMo4702J1;
                if (this.f3973j0) {
                    m4707O1(dialogMo4702J1, this.f3970g0);
                    Context contextM4426p = m4426p();
                    if (contextM4426p instanceof Activity) {
                        this.f3977n0.setOwnerActivity((Activity) contextM4426p);
                    }
                    this.f3977n0.setCancelable(this.f3972i0);
                    this.f3977n0.setOnCancelListener(this.f3968e0);
                    this.f3977n0.setOnDismissListener(this.f3969f0);
                    this.f3981r0 = true;
                } else {
                    this.f3977n0 = null;
                }
                this.f3975l0 = false;
            } catch (Throwable th2) {
                this.f3975l0 = false;
                throw th2;
            }
        }
    }

    /* renamed from: N1 */
    public final Dialog m4706N1() {
        Dialog dialogM4700H1 = m4700H1();
        if (dialogM4700H1 != null) {
            return dialogM4700H1;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    /* renamed from: O1 */
    public void m4707O1(Dialog dialog, int i10) {
        if (i10 != 1 && i10 != 2) {
            if (i10 != 3) {
                return;
            }
            Window window = dialog.getWindow();
            if (window != null) {
                window.addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    /* renamed from: P1 */
    public void m4708P1(FragmentManager fragmentManager, String str) {
        this.f3979p0 = false;
        this.f3980q0 = true;
        AbstractC0735a0 abstractC0735a0M4585o = fragmentManager.m4585o();
        abstractC0735a0M4585o.m4671u(true);
        abstractC0735a0M4585o.m4665e(this, str);
        abstractC0735a0M4585o.mo4647h();
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: S0 */
    public void mo4371S0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.mo4371S0(layoutInflater, viewGroup, bundle);
        if (this.f3704I != null || this.f3977n0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f3977n0.onRestoreInstanceState(bundle2);
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: b */
    public AbstractC0750i mo4388b() {
        return new e(super.mo4388b());
    }

    @Override // androidx.fragment.app.Fragment
    @Deprecated
    /* renamed from: f0 */
    public void mo4401f0(Bundle bundle) {
        super.mo4401f0(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: i0 */
    public void mo4407i0(Context context) {
        super.mo4407i0(context);
        m4372T().m4891i(this.f3976m0);
        if (this.f3980q0) {
            return;
        }
        this.f3979p0 = false;
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: l0 */
    public void mo4415l0(Bundle bundle) {
        super.mo4415l0(bundle);
        this.f3966c0 = new Handler();
        this.f3973j0 = this.f3747y == 0;
        if (bundle != null) {
            this.f3970g0 = bundle.getInt("android:style", 0);
            this.f3971h0 = bundle.getInt("android:theme", 0);
            this.f3972i0 = bundle.getBoolean("android:cancelable", true);
            this.f3973j0 = bundle.getBoolean("android:showsDialog", this.f3973j0);
            this.f3974k0 = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f3978o0) {
            return;
        }
        if (FragmentManager.m4492I0(3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        m4699G1(true, true, false);
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: s0 */
    public void mo4436s0() {
        super.mo4436s0();
        Dialog dialog = this.f3977n0;
        if (dialog != null) {
            this.f3978o0 = true;
            dialog.setOnDismissListener(null);
            this.f3977n0.dismiss();
            if (!this.f3979p0) {
                onDismiss(this.f3977n0);
            }
            this.f3977n0 = null;
            this.f3981r0 = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: t0 */
    public void mo4439t0() {
        super.mo4439t0();
        if (!this.f3980q0 && !this.f3979p0) {
            this.f3979p0 = true;
        }
        m4372T().mo4895m(this.f3976m0);
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: u0 */
    public LayoutInflater mo4442u0(Bundle bundle) {
        LayoutInflater layoutInflaterMo4442u0 = super.mo4442u0(bundle);
        if (this.f3973j0 && !this.f3975l0) {
            m4705M1(bundle);
            if (FragmentManager.m4492I0(2)) {
                Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
            }
            Dialog dialog = this.f3977n0;
            return dialog != null ? layoutInflaterMo4442u0.cloneInContext(dialog.getContext()) : layoutInflaterMo4442u0;
        }
        if (FragmentManager.m4492I0(2)) {
            String str = "getting layout inflater for DialogFragment " + this;
            if (this.f3973j0) {
                Log.d("FragmentManager", "mCreatingDialog = true: " + str);
            } else {
                Log.d("FragmentManager", "mShowsDialog = false: " + str);
            }
        }
        return layoutInflaterMo4442u0;
    }
}
