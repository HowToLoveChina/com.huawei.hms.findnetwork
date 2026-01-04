package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.widget.SpinnerAdapter;

/* loaded from: classes.dex */
public interface ThemedSpinnerAdapter extends SpinnerAdapter {

    public static final class Helper {

        /* renamed from: a */
        public final Context f2197a;

        /* renamed from: b */
        public final LayoutInflater f2198b;

        public Helper(Context context) {
            this.f2197a = context;
            this.f2198b = LayoutInflater.from(context);
        }
    }

    Resources.Theme getDropDownViewTheme();

    void setDropDownViewTheme(Resources.Theme theme);
}
