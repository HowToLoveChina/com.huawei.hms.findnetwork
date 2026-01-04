package sk;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.huawei.openalliance.p169ad.constant.OsType;
import java.io.IOException;
import p399jk.AbstractC10896a;

/* renamed from: sk.f */
/* loaded from: classes6.dex */
public class C12809f {
    /* renamed from: a */
    public static <T extends Fragment> T m76828a(FragmentManager fragmentManager, int i10) {
        if (fragmentManager != null) {
            return (T) fragmentManager.findFragmentById(i10);
        }
        return null;
    }

    /* renamed from: b */
    public static <T extends View> T m76829b(Activity activity, int i10) {
        if (activity != null) {
            return (T) activity.findViewById(i10);
        }
        return null;
    }

    /* renamed from: c */
    public static <T extends View> T m76830c(AlertDialog alertDialog, int i10) {
        if (alertDialog != null) {
            return (T) alertDialog.findViewById(i10);
        }
        return null;
    }

    /* renamed from: d */
    public static <T extends View> T m76831d(View view, int i10) {
        if (view != null) {
            return (T) view.findViewById(i10);
        }
        return null;
    }

    /* renamed from: e */
    public static <T extends View> T m76832e(LayoutInflater layoutInflater, int i10) {
        if (layoutInflater != null) {
            return (T) layoutInflater.inflate(i10, (ViewGroup) null);
        }
        return null;
    }

    /* renamed from: f */
    public static Activity m76833f(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    /* renamed from: g */
    public static <T extends ViewGroup.LayoutParams> T m76834g(View view) {
        if (view != null) {
            return (T) view.getLayoutParams();
        }
        return null;
    }

    /* renamed from: h */
    public static int m76835h(Context context) {
        Resources resources;
        if (context == null || (resources = context.getResources()) == null || resources.getIdentifier("config_showNavigationBar", "bool", OsType.ANDROID) == 0) {
            return 0;
        }
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", OsType.ANDROID));
    }

    /* renamed from: i */
    public static boolean m76836i(View view) {
        return view != null && view.getVisibility() == 0;
    }

    /* renamed from: j */
    public static Bitmap m76837j(Bitmap bitmap, String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 0);
            if (attributeInt == 1) {
                return bitmap;
            }
            Matrix matrix = new Matrix();
            if (attributeInt == 3) {
                matrix.postRotate(180.0f);
            } else if (attributeInt == 6) {
                matrix.postRotate(90.0f);
            } else if (attributeInt == 8) {
                matrix.postRotate(270.0f);
            }
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (IOException e10) {
            AbstractC10896a.m65886e("ViewUtil", "rotateBitmapForJPG err: " + e10.toString());
            return bitmap;
        } catch (NumberFormatException e11) {
            AbstractC10896a.m65886e("ViewUtil", "rotateBitmapForJPG NumberFormatException err: " + e11.toString());
            return bitmap;
        }
    }

    /* renamed from: k */
    public static void m76838k(View view, ViewGroup.LayoutParams layoutParams) {
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: l */
    public static void m76839l(TextView textView, int i10) {
        if (textView != null) {
            textView.setMaxWidth(i10);
        }
    }

    /* renamed from: m */
    public static void m76840m(TextView textView, int i10) {
        if (textView != null) {
            textView.setText(i10);
        }
    }

    /* renamed from: n */
    public static void m76841n(TextView textView, CharSequence charSequence) {
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* renamed from: o */
    public static void m76842o(View view, View... viewArr) {
        m76843p(view, true);
        for (View view2 : viewArr) {
            m76843p(view2, false);
        }
    }

    /* renamed from: p */
    public static void m76843p(View view, boolean z10) {
        if (view != null) {
            view.setVisibility(z10 ? 0 : 8);
        }
    }
}
