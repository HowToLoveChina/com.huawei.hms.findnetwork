package com.huawei.openalliance.p169ad.download.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C7574ph;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.PermissionEntity;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7846y;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.download.app.h */
/* loaded from: classes2.dex */
public class C7049h {

    /* renamed from: com.huawei.openalliance.ad.download.app.h$a */
    public interface a {
        /* renamed from: a */
        void mo42425a();

        /* renamed from: a */
        void mo42426a(int i10);
    }

    /* renamed from: a */
    private static void m42418a(Context context, AlertDialog alertDialog) {
        Window window;
        if (!(context instanceof Activity) && (window = alertDialog.getWindow()) != null) {
            window.setType(2038);
        }
        alertDialog.show();
    }

    /* renamed from: c */
    private static void m42422c(final Context context, final AppInfo appInfo, final a aVar) {
        AlertDialog.Builder builderM48617a = AbstractC7846y.m48617a(context);
        builderM48617a.setView(LayoutInflater.from(context).inflate(C6849R.layout.hiad_loading_dialog_content, (ViewGroup) null));
        final AlertDialog alertDialogCreate = builderM48617a.create();
        m42418a(context, alertDialogCreate);
        new C7574ph(context, new C7574ph.a() { // from class: com.huawei.openalliance.ad.download.app.h.1
            @Override // com.huawei.openalliance.p169ad.C7574ph.a
            /* renamed from: a */
            public void mo42424a(final List<PermissionEntity> list) {
                AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.h.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        alertDialogCreate.dismiss();
                        if (!AbstractC7760bg.m47767a(list)) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            C7049h.m42423d(context, appInfo, aVar);
                            return;
                        }
                        Toast.makeText(context, C6849R.string.hiad_net_error, 0).show();
                        a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.mo42426a(1005);
                        }
                    }
                });
            }
        }).m46765a(appInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static void m42423d(Context context, AppInfo appInfo, final a aVar) {
        AlertDialog.Builder builderM48617a = AbstractC7846y.m48617a(context);
        builderM48617a.setTitle("");
        if (aVar != null) {
            builderM48617a.setPositiveButton(C6849R.string.hiad_dialog_accept, new DialogInterface.OnClickListener() { // from class: com.huawei.openalliance.ad.download.app.h.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i10) {
                    aVar.mo42425a();
                }
            });
            builderM48617a.setNeutralButton(C6849R.string.hiad_dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.huawei.openalliance.ad.download.app.h.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i10) {
                    aVar.mo42426a(1006);
                }
            });
        } else {
            builderM48617a.setNeutralButton(C6849R.string.hiad_dialog_close, (DialogInterface.OnClickListener) null);
        }
        View viewInflate = LayoutInflater.from(context).inflate(C6849R.layout.hiad_permission_dialog_cotent, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(C6849R.id.hiad_permissions_dialog_content_title_tv)).setText(context.getResources().getString(C6849R.string.hiad_permission_dialog_title, appInfo.getAppName()));
        ((ListView) viewInflate.findViewById(C6849R.id.hiad_permissions_dialog_content_lv)).setAdapter((ListAdapter) new C7048g(context, appInfo.getPermissions()));
        builderM48617a.setView(viewInflate);
        AlertDialog alertDialogCreate = builderM48617a.create();
        AbstractC7185ho.m43818a("AppPermissionsDialog", "show, time:%d", Long.valueOf(System.currentTimeMillis()));
        m42418a(context, alertDialogCreate);
    }

    /* renamed from: a */
    public static void m42419a(Context context, AppInfo appInfo) {
        m42420a(context, appInfo, null);
    }

    /* renamed from: a */
    public static void m42420a(Context context, AppInfo appInfo, a aVar) {
        if (appInfo == null) {
            AbstractC7185ho.m43823c("AppPermissionsDialog", "appInfo is null.");
            return;
        }
        AbstractC7185ho.m43820b("AppPermissionsDialog", "show, context:" + context);
        if (!AbstractC7760bg.m47767a(appInfo.getPermissions())) {
            m42423d(context, appInfo, aVar);
        } else {
            AbstractC7185ho.m43820b("AppPermissionsDialog", "permissions is empty");
            m42422c(context, appInfo, aVar);
        }
    }
}
