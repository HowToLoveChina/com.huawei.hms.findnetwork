package p276f3;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Build;
import p827z.C14059a;

/* renamed from: f3.h */
/* loaded from: classes.dex */
public class C9654h {
    /* renamed from: a */
    public static Typeface m60293a(Context context, Typeface typeface) {
        return m60294b(context.getResources().getConfiguration(), typeface);
    }

    /* renamed from: b */
    public static Typeface m60294b(Configuration configuration, Typeface typeface) {
        if (Build.VERSION.SDK_INT < 31 || configuration.fontWeightAdjustment == Integer.MAX_VALUE || configuration.fontWeightAdjustment == 0) {
            return null;
        }
        return Typeface.create(typeface, C14059a.m84263b(typeface.getWeight() + configuration.fontWeightAdjustment, 1, 1000), typeface.isItalic());
    }
}
