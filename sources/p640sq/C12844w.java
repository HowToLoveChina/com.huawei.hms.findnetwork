package p640sq;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.huawei.android.hms.hwid.R$color;
import com.huawei.android.hms.hwid.R$dimen;
import com.huawei.android.hms.hwid.R$id;
import com.huawei.android.hms.hwid.R$layout;
import com.huawei.android.hms.hwid.R$string;
import com.huawei.android.os.SystemPropertiesEx;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hwidauth.p167ui.AlertDialogBuilderC6718c;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;

/* renamed from: sq.w */
/* loaded from: classes8.dex */
public class C12844w {

    /* renamed from: sq.w$a */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ Context f58583a;

        public a(Context context) {
            this.f58583a = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            C12844w.m77141m(this.f58583a);
        }
    }

    /* renamed from: sq.w$b */
    public class b implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.dismiss();
        }
    }

    /* renamed from: a */
    public static int m77129a(Context context) {
        if (!m77134f()) {
            return m77136h(context);
        }
        if (context == null) {
            C12836o.m77097b("UIUtil", "getDialogThemeId, context is null", true);
            return 3;
        }
        if (m77135g(context) != 0) {
            C12836o.m77097b("UIUtil", "getDialogThemeId, NEEDLESS_SETTING_THEME", true);
            return 0;
        }
        C12836o.m77097b("UIUtil", "getDialogThemeId, THEME_HOLO_LIGHT", true);
        return 3;
    }

    /* renamed from: b */
    public static int m77130b(Context context, String str) {
        return context.getResources().getColor(context.getResources().getIdentifier(context.getPackageName() + ":color/" + str, null, null));
    }

    /* renamed from: c */
    public static AlertDialog.Builder m77131c(Context context, String str, String str2, DialogInterface.OnClickListener onClickListener) {
        C12836o.m77097b("UIUtil", "createRefusePermissionBuild", true);
        AlertDialogBuilderC6718c alertDialogBuilderC6718c = new AlertDialogBuilderC6718c(context, m77129a(context));
        View viewInflate = View.inflate(context, R$layout.hwid_auth_refuse_permission_dialog, null);
        TextView textView = (TextView) viewInflate.findViewById(R$id.text1);
        if (C12829h.m77056a()) {
            textView.setTextSize(0, context.getResources().getDimensionPixelSize(R$dimen.emui_text_size_headline7));
        }
        textView.setText(str);
        ((TextView) viewInflate.findViewById(R$id.text2)).setText(str2);
        alertDialogBuilderC6718c.setView(viewInflate).setPositiveButton(R$string.CS_go_settings, new a(context)).setNegativeButton(R.string.cancel, onClickListener);
        return alertDialogBuilderC6718c;
    }

    /* renamed from: d */
    public static void m77132d(Dialog dialog) throws IllegalAccessException, IllegalArgumentException {
        if (C12829h.m77057b()) {
            try {
                dialog.getWindow().getAttributes().getClass().getDeclaredField(ParamConstants.Param.LAYOUT_IN_DISPLAY_CUTOUT_MODE).set(dialog.getWindow().getAttributes(), 1);
            } catch (RuntimeException e10) {
                C12836o.m77099d("UIUtil", "RuntimeException: " + e10.getClass().getSimpleName(), true);
            } catch (Exception e11) {
                C12836o.m77099d("UIUtil", "Exception: " + e11.getClass().getSimpleName(), true);
            }
        }
    }

    /* renamed from: e */
    public static void m77133e(Context context, int i10) {
        if (context == null) {
            C12836o.m77099d("UIUtil", "context is null.", true);
            return;
        }
        try {
            C12836o.m77097b("UIUtil", "gotoAppDetailForResult", true);
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            if (i10 < 0) {
                context.startActivity(intent);
            } else {
                ((Activity) context).startActivityForResult(intent, i10);
            }
        } catch (Exception e10) {
            C12836o.m77099d("UIUtil", e10.getClass().getSimpleName(), true);
        }
    }

    /* renamed from: f */
    public static boolean m77134f() {
        boolean z10 = !TextUtils.isEmpty(C12824c.m76997S());
        C12836o.m77097b("UIUtil", "isHuawei " + z10, true);
        return z10;
    }

    /* renamed from: g */
    public static int m77135g(Context context) {
        return !m77134f() ? m77136h(context) : context.getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null);
    }

    /* renamed from: h */
    public static int m77136h(Context context) {
        C12836o.m77097b("UIUtil", "getDialogThemeId, non huawei rom", true);
        if (m77138j(context)) {
            C12836o.m77097b("UIUtil", "getDialogThemeId, non huawei rom , is DarkTheme", true);
            return 4;
        }
        C12836o.m77097b("UIUtil", "getDialogThemeId, non huawei rom , is not DarkTheme", true);
        return 5;
    }

    /* renamed from: i */
    public static AlertDialog.Builder m77137i(Context context) {
        if (context == null) {
            C12836o.m77099d("UIUtil", "createNoNetDialog context is null", true);
            return null;
        }
        AlertDialogBuilderC6718c alertDialogBuilderC6718c = new AlertDialogBuilderC6718c(context, m77129a(context));
        alertDialogBuilderC6718c.setMessage(R$string.CS_network_connect_error);
        alertDialogBuilderC6718c.setNegativeButton(R.string.ok, new b());
        return alertDialogBuilderC6718c;
    }

    /* renamed from: j */
    public static boolean m77138j(Context context) {
        Resources resources;
        return (context == null || (resources = context.getResources()) == null || m77130b(context, "hwid_check_theme_color") != resources.getColor(R$color.hwid_check_theme_dark_color)) ? false : true;
    }

    /* renamed from: k */
    public static String m77139k(Context context) {
        if (m77142n(context.getApplicationContext())) {
            return "&themeName=dark";
        }
        return "&themeName=huawei";
    }

    /* renamed from: m */
    public static void m77141m(Context context) {
        if (context == null) {
            C12836o.m77099d("UIUtil", "context is null.", true);
        } else {
            m77133e(context, Integer.MIN_VALUE);
        }
    }

    /* renamed from: n */
    public static boolean m77142n(Context context) {
        boolean zM77143o = m77143o(context);
        boolean zM77138j = m77138j(context);
        boolean zM77144p = m77144p(context);
        C12836o.m77097b("UIUtil", "isHonorNight: " + zM77143o, true);
        C12836o.m77097b("UIUtil", "isDarkTheme: " + zM77138j, true);
        C12836o.m77097b("UIUtil", "isNightMode: " + zM77144p, true);
        return zM77143o || zM77138j || zM77144p;
    }

    /* renamed from: o */
    public static boolean m77143o(Context context) {
        if (C12829h.m77056a()) {
            return "honor".equalsIgnoreCase(SystemPropertiesEx.get(SystemUtils.PRODUCT_BRAND)) && !SystemPropertiesEx.getBoolean("ro.config.hw_themeInsulate", false) && ((UiModeManager) context.getSystemService(UiModeManager.class)).getNightMode() == 2;
        }
        return false;
    }

    /* renamed from: p */
    public static boolean m77144p(Context context) {
        Resources resources;
        Configuration configuration;
        return (context == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null || (configuration.uiMode & 48) != 32) ? false : true;
    }
}
