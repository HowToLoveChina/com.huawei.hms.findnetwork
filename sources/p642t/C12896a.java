package p642t;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.nio.CharBuffer;

@SuppressLint({"LogConditional"})
/* renamed from: t.a */
/* loaded from: classes.dex */
public class C12896a {
    /* renamed from: a */
    public static String m77315a() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName() + "()";
    }

    /* renamed from: b */
    public static String m77316b() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
    }

    /* renamed from: c */
    public static String m77317c(Context context, int i10) {
        if (i10 == -1) {
            return "UNKNOWN";
        }
        try {
            return context.getResources().getResourceEntryName(i10);
        } catch (Exception unused) {
            return Constants.QUESTION_STR + i10;
        }
    }

    /* renamed from: d */
    public static String m77318d(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }

    /* renamed from: e */
    public static String m77319e(MotionLayout motionLayout, int i10) {
        return m77320f(motionLayout, i10, -1);
    }

    /* renamed from: f */
    public static String m77320f(MotionLayout motionLayout, int i10, int i11) throws Resources.NotFoundException {
        int length;
        if (i10 == -1) {
            return "UNDEFINED";
        }
        String resourceEntryName = motionLayout.getContext().getResources().getResourceEntryName(i10);
        if (i11 == -1) {
            return resourceEntryName;
        }
        if (resourceEntryName.length() > i11) {
            resourceEntryName = resourceEntryName.replaceAll("([^_])[aeiou]+", "$1");
        }
        if (resourceEntryName.length() <= i11 || (length = resourceEntryName.replaceAll("[^_]", "").length()) <= 0) {
            return resourceEntryName;
        }
        return resourceEntryName.replaceAll(CharBuffer.allocate((resourceEntryName.length() - i11) / length).toString().replace((char) 0, '.') + "_", "_");
    }

    /* renamed from: g */
    public static void m77321g(String str, String str2, int i10) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int iMin = Math.min(i10, stackTrace.length - 1);
        String str3 = " ";
        for (int i11 = 1; i11 <= iMin; i11++) {
            StackTraceElement stackTraceElement = stackTrace[i11];
            str3 = str3 + " ";
            Log.v(str, str2 + str3 + (".(" + stackTrace[i11].getFileName() + ":" + stackTrace[i11].getLineNumber() + ") " + stackTrace[i11].getMethodName()) + str3);
        }
    }
}
