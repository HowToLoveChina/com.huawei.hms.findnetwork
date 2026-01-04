package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.AlertController;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;

/* loaded from: classes.dex */
public class AlertDialog extends AppCompatDialog implements DialogInterface {

    /* renamed from: e */
    public final AlertController f1248e;

    public static class Builder {

        /* renamed from: a */
        public final AlertController.AlertParams f1249a;

        /* renamed from: b */
        public final int f1250b;

        public Builder(Context context) {
            this(context, AlertDialog.m2023o(context, 0));
        }

        /* renamed from: a */
        public AlertDialog mo2027a() {
            AlertDialog alertDialog = new AlertDialog(this.f1249a.f1206a, this.f1250b);
            this.f1249a.m2020a(alertDialog.f1248e);
            alertDialog.setCancelable(this.f1249a.f1223r);
            if (this.f1249a.f1223r) {
                alertDialog.setCanceledOnTouchOutside(true);
            }
            alertDialog.setOnCancelListener(this.f1249a.f1224s);
            alertDialog.setOnDismissListener(this.f1249a.f1225t);
            DialogInterface.OnKeyListener onKeyListener = this.f1249a.f1226u;
            if (onKeyListener != null) {
                alertDialog.setOnKeyListener(onKeyListener);
            }
            return alertDialog;
        }

        /* renamed from: b */
        public Context m2028b() {
            return this.f1249a.f1206a;
        }

        /* renamed from: c */
        public Builder mo2029c(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f1249a;
            alertParams.f1228w = listAdapter;
            alertParams.f1229x = onClickListener;
            return this;
        }

        /* renamed from: d */
        public Builder mo2030d(View view) {
            this.f1249a.f1212g = view;
            return this;
        }

        /* renamed from: e */
        public Builder mo2031e(Drawable drawable) {
            this.f1249a.f1209d = drawable;
            return this;
        }

        /* renamed from: f */
        public Builder mo2032f(DialogInterface.OnKeyListener onKeyListener) {
            this.f1249a.f1226u = onKeyListener;
            return this;
        }

        /* renamed from: g */
        public Builder mo2033g(ListAdapter listAdapter, int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f1249a;
            alertParams.f1228w = listAdapter;
            alertParams.f1229x = onClickListener;
            alertParams.f1199I = i10;
            alertParams.f1198H = true;
            return this;
        }

        /* renamed from: h */
        public Builder mo2034h(CharSequence charSequence) {
            this.f1249a.f1211f = charSequence;
            return this;
        }

        public Builder(Context context, int i10) {
            this.f1249a = new AlertController.AlertParams(new ContextThemeWrapper(context, AlertDialog.m2023o(context, i10)));
            this.f1250b = i10;
        }
    }

    public AlertDialog(Context context, int i10) {
        super(context, m2023o(context, i10));
        this.f1248e = new AlertController(getContext(), this, getWindow());
    }

    /* renamed from: o */
    public static int m2023o(Context context, int i10) {
        if (((i10 >>> 24) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA) >= 1) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    /* renamed from: n */
    public ListView m2024n() {
        return this.f1248e.m1999d();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1248e.m2000e();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (this.f1248e.m2001f(i10, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (this.f1248e.m2002g(i10, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i10, keyEvent);
    }

    /* renamed from: p */
    public void m2025p(int i10, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f1248e.m2005j(i10, charSequence, onClickListener, null, null);
    }

    /* renamed from: q */
    public void m2026q(CharSequence charSequence) {
        this.f1248e.m2009n(charSequence);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f1248e.m2011p(charSequence);
    }
}
