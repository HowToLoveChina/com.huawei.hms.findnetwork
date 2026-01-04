package p521og;

import android.content.Context;
import android.content.res.Resources;
import android.view.WindowManager;
import android.widget.Toast;
import com.huawei.android.view.WindowManagerEx;
import com.huawei.android.widget.ToastEx;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0209d;
import p303g.C9816d;
import p809yg.C13981a;

/* renamed from: og.m */
/* loaded from: classes4.dex */
public class C11880m {

    /* renamed from: a */
    public static final boolean f54933a = C0209d.m1277l1();

    /* renamed from: b */
    public static volatile Toast f54934b;

    /* renamed from: a */
    public static Context m71334a(Context context) {
        int identifier;
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        return (resources == null || (identifier = resources.getIdentifier("androidhwext:style/Theme.Emui", null, null)) == 0) ? context : new C9816d(context, identifier);
    }

    /* renamed from: b */
    public static void m71335b() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            if (f54933a) {
                return;
            }
            ToastEx toastEx = new ToastEx();
            WindowManagerEx.LayoutParamsEx layoutParamsEx = new WindowManagerEx.LayoutParamsEx((WindowManager.LayoutParams) toastEx.getClass().getMethod("getWindowParams", Toast.class).invoke(toastEx, f54934b));
            layoutParamsEx.getClass().getMethod("addHwFlags", Integer.TYPE).invoke(layoutParamsEx, 128);
        } catch (Exception e10) {
            C13981a.m83988e("ToastUtil", "setAllowShowToast exception:" + e10.getMessage());
        }
    }

    /* renamed from: c */
    public static void m71336c(Context context, int i10) {
        if (context == null) {
            return;
        }
        m71337d(context, context.getString(i10));
    }

    /* renamed from: d */
    public static void m71337d(Context context, String str) {
        if (context == null) {
            return;
        }
        if (f54934b == null) {
            f54934b = Toast.makeText(m71334a(context), str, 0);
        } else {
            f54934b.setText(str);
            f54934b.setDuration(0);
        }
        m71335b();
        f54934b.show();
    }
}
