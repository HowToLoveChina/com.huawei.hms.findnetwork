package com.huawei.hicloud.base.p103ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import p015ak.C0209d;
import p399jk.AbstractC10896a;

/* loaded from: classes6.dex */
public class NewDialogUtil {

    /* renamed from: a */
    public AlertDialog f22151a = null;

    /* renamed from: com.huawei.hicloud.base.ui.NewDialogUtil$a */
    public class C4852a extends DialogInterfaceOnClickListenerC4855d {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC4854c f22152a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C4852a(InterfaceC4854c interfaceC4854c) {
            super(null);
            this.f22152a = interfaceC4854c;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            this.f22152a.mo22509b();
        }
    }

    /* renamed from: com.huawei.hicloud.base.ui.NewDialogUtil$b */
    public class C4853b extends DialogInterfaceOnClickListenerC4856e {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC4854c f22154a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C4853b(InterfaceC4854c interfaceC4854c) {
            super(null);
            this.f22154a = interfaceC4854c;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            this.f22154a.mo22508a();
        }
    }

    /* renamed from: com.huawei.hicloud.base.ui.NewDialogUtil$c */
    public interface InterfaceC4854c {
        /* renamed from: a */
        void mo22508a();

        /* renamed from: b */
        void mo22509b();
    }

    /* renamed from: com.huawei.hicloud.base.ui.NewDialogUtil$d */
    public static class DialogInterfaceOnClickListenerC4855d implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC4855d() {
        }

        public /* synthetic */ DialogInterfaceOnClickListenerC4855d(C4852a c4852a) {
            this();
        }
    }

    /* renamed from: com.huawei.hicloud.base.ui.NewDialogUtil$e */
    public static class DialogInterfaceOnClickListenerC4856e implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC4856e() {
        }

        public /* synthetic */ DialogInterfaceOnClickListenerC4856e(C4852a c4852a) {
            this();
        }
    }

    public NewDialogUtil(Context context) {
    }

    /* renamed from: a */
    public void m29116a() {
        AlertDialog alertDialog = this.f22151a;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f22151a = null;
        }
    }

    /* renamed from: b */
    public void m29117b(Context context, String str, String str2, String str3, String str4, InterfaceC4854c interfaceC4854c) throws IllegalAccessException, IllegalArgumentException {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str).setMessage(str2).setPositiveButton(str3, new C4853b(interfaceC4854c)).setNegativeButton(str4, new C4852a(interfaceC4854c));
        AlertDialog alertDialogCreate = builder.create();
        this.f22151a = alertDialogCreate;
        C0209d.m1314u2(context, alertDialogCreate);
        this.f22151a.setCancelable(false);
        try {
            this.f22151a.show();
        } catch (Exception e10) {
            AbstractC10896a.m65886e("NewDialogUtil", e10.getMessage());
        }
    }
}
