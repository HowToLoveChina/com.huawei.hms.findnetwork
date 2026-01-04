package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.R$layout;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.InterfaceC0414k;
import com.tencent.p204mm.opensdk.modelmsg.WXMediaMessage;

/* renamed from: androidx.appcompat.view.menu.g */
/* loaded from: classes.dex */
public class DialogInterfaceOnKeyListenerC0410g implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, InterfaceC0414k.a {

    /* renamed from: a */
    public MenuBuilder f1653a;

    /* renamed from: b */
    public AlertDialog f1654b;

    /* renamed from: c */
    public C0408e f1655c;

    /* renamed from: d */
    public InterfaceC0414k.a f1656d;

    public DialogInterfaceOnKeyListenerC0410g(MenuBuilder menuBuilder) {
        this.f1653a = menuBuilder;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k.a
    /* renamed from: a */
    public void mo2158a(MenuBuilder menuBuilder, boolean z10) {
        if (z10 || menuBuilder == this.f1653a) {
            m2466c();
        }
        InterfaceC0414k.a aVar = this.f1656d;
        if (aVar != null) {
            aVar.mo2158a(menuBuilder, z10);
        }
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k.a
    /* renamed from: b */
    public boolean mo2159b(MenuBuilder menuBuilder) {
        InterfaceC0414k.a aVar = this.f1656d;
        if (aVar != null) {
            return aVar.mo2159b(menuBuilder);
        }
        return false;
    }

    /* renamed from: c */
    public void m2466c() {
        AlertDialog alertDialog = this.f1654b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* renamed from: d */
    public void m2467d(IBinder iBinder) {
        MenuBuilder menuBuilder = this.f1653a;
        AlertDialog.Builder builder = new AlertDialog.Builder(menuBuilder.m2391w());
        C0408e c0408e = new C0408e(builder.m2028b(), R$layout.abc_list_menu_item_layout);
        this.f1655c = c0408e;
        c0408e.mo2417f(this);
        this.f1653a.m2364b(this.f1655c);
        builder.mo2029c(this.f1655c.m2456j(), this);
        View viewM2337A = menuBuilder.m2337A();
        if (viewM2337A != null) {
            builder.mo2030d(viewM2337A);
        } else {
            builder.mo2031e(menuBuilder.m2393y()).mo2034h(menuBuilder.m2394z());
        }
        builder.mo2032f(this);
        AlertDialog alertDialogMo2027a = builder.mo2027a();
        this.f1654b = alertDialogMo2027a;
        alertDialogMo2027a.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f1654b.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
        this.f1654b.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        this.f1653a.m2349N((C0411h) this.f1655c.m2456j().getItem(i10), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f1655c.mo2413a(this.f1653a, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i10 == 82 || i10 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f1654b.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f1654b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f1653a.m2370e(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f1653a.performShortcut(i10, keyEvent, 0);
    }
}
