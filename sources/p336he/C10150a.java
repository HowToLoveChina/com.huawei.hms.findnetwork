package p336he;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.huawei.hicloud.sync.R$dimen;
import com.huawei.openalliance.p169ad.constant.OsType;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0219i;
import p514o9.C11839m;

/* renamed from: he.a */
/* loaded from: classes3.dex */
public class C10150a {

    /* renamed from: a */
    public static int f49453a = -1;

    /* renamed from: a */
    public static int m63211a(Context context) {
        if (f49453a < 0 && context != null) {
            int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", OsType.ANDROID);
            if (identifier > 0) {
                f49453a = context.getResources().getDimensionPixelSize(identifier);
            } else {
                f49453a = context.getResources().getDimensionPixelSize(R$dimen.cs_24_dp);
            }
            C11839m.m70688i("ActionBarExUtils", "getStatusBarHeightPx: " + f49453a);
        }
        return f49453a;
    }

    /* renamed from: b */
    public static boolean m63212b(ActionBar actionBar, Drawable drawable) {
        if (17 <= C0219i.m1463a()) {
            return m63213c(actionBar, drawable);
        }
        actionBar.setBackgroundDrawable(drawable);
        return true;
    }

    /* renamed from: c */
    public static boolean m63213c(ActionBar actionBar, Drawable drawable) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName("com.huawei.android.app.ActionBarEx");
            cls.getDeclaredMethod("setAppbarBackground", ActionBar.class, Drawable.class).invoke(cls, actionBar, drawable);
            return true;
        } catch (ClassNotFoundException e10) {
            C11839m.m70687e("ActionBarExUtils", "ClassNotFoundException" + e10.getMessage());
            return false;
        } catch (IllegalAccessException e11) {
            C11839m.m70687e("ActionBarExUtils", "IllegalAccessException" + e11.getMessage());
            return false;
        } catch (NoSuchMethodException e12) {
            C11839m.m70687e("ActionBarExUtils", "NoSuchMethodException" + e12.getMessage());
            return false;
        } catch (InvocationTargetException e13) {
            C11839m.m70687e("ActionBarExUtils", "InvocationTargetException" + e13.getMessage());
            return false;
        }
    }
}
