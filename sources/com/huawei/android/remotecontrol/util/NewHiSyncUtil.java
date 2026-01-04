package com.huawei.android.remotecontrol.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import p514o9.C11829c;
import p809yg.C13981a;

/* loaded from: classes4.dex */
public class NewHiSyncUtil {

    /* renamed from: a */
    public AlertDialog f20868a = null;

    /* renamed from: com.huawei.android.remotecontrol.util.NewHiSyncUtil$a */
    public class C4547a extends DialogInterfaceOnClickListenerC4550d {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC4549c f20869a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C4547a(InterfaceC4549c interfaceC4549c) {
            super(null);
            this.f20869a = interfaceC4549c;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            this.f20869a.mo27198b();
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.util.NewHiSyncUtil$b */
    public class C4548b extends DialogInterfaceOnClickListenerC4551e {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC4549c f20871a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C4548b(InterfaceC4549c interfaceC4549c) {
            super(null);
            this.f20871a = interfaceC4549c;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            this.f20871a.mo27197a();
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.util.NewHiSyncUtil$c */
    public interface InterfaceC4549c {
        /* renamed from: a */
        void mo27197a();

        /* renamed from: b */
        void mo27198b();
    }

    /* renamed from: com.huawei.android.remotecontrol.util.NewHiSyncUtil$d */
    public static class DialogInterfaceOnClickListenerC4550d implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC4550d() {
        }

        public /* synthetic */ DialogInterfaceOnClickListenerC4550d(C4547a c4547a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.util.NewHiSyncUtil$e */
    public static class DialogInterfaceOnClickListenerC4551e implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC4551e() {
        }

        public /* synthetic */ DialogInterfaceOnClickListenerC4551e(C4547a c4547a) {
            this();
        }
    }

    public NewHiSyncUtil(Context context) {
    }

    /* renamed from: a */
    public void m27970a() {
        AlertDialog alertDialog = this.f20868a;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f20868a = null;
        }
    }

    /* renamed from: b */
    public void m27971b(Context context, String str, String str2, String str3, String str4, InterfaceC4549c interfaceC4549c) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str).setMessage(str2).setPositiveButton(str3, new C4548b(interfaceC4549c)).setNegativeButton(str4, new C4547a(interfaceC4549c));
        AlertDialog alertDialogCreate = builder.create();
        this.f20868a = alertDialogCreate;
        C11829c.m70594l1(context, alertDialogCreate);
        this.f20868a.setCancelable(false);
        try {
            this.f20868a.show();
        } catch (Exception e10) {
            C13981a.m83988e("NewHiSyncUtil", e10.getMessage());
        }
    }
}
