package p694v;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.Arrays;
import java.util.HashSet;
import p024b0.C1085a;

/* renamed from: v.a */
/* loaded from: classes.dex */
public class C13299a extends ContextCompat {

    /* renamed from: v.a$a */
    public static class a {
        /* renamed from: a */
        public static void m79753a(Activity activity) {
            activity.finishAffinity();
        }

        /* renamed from: b */
        public static void m79754b(Activity activity, Intent intent, int i10, Bundle bundle) {
            activity.startActivityForResult(intent, i10, bundle);
        }

        /* renamed from: c */
        public static void m79755c(Activity activity, IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) throws IntentSender.SendIntentException {
            activity.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13, bundle);
        }
    }

    /* renamed from: v.a$b */
    public static class b {
        /* renamed from: a */
        public static void m79756a(Object obj) {
            ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }

        /* renamed from: b */
        public static void m79757b(Activity activity, String[] strArr, int i10) {
            activity.requestPermissions(strArr, i10);
        }

        /* renamed from: c */
        public static boolean m79758c(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    /* renamed from: v.a$c */
    public interface c {
        /* renamed from: d */
        void mo4480d(int i10);
    }

    /* renamed from: a */
    public static void m79749a(Activity activity) {
        a.m79753a(activity);
    }

    /* renamed from: b */
    public static void m79750b(Activity activity) {
        activity.recreate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c */
    public static void m79751c(Activity activity, String[] strArr, int i10) {
        HashSet hashSet = new HashSet();
        for (int i11 = 0; i11 < strArr.length; i11++) {
            if (TextUtils.isEmpty(strArr[i11])) {
                throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
            }
            if (!C1085a.m6463c() && TextUtils.equals(strArr[i11], Constants.POST_NOTIFICATIONS)) {
                hashSet.add(Integer.valueOf(i11));
            }
        }
        int size = hashSet.size();
        String[] strArr2 = size > 0 ? new String[strArr.length - size] : strArr;
        if (size > 0) {
            if (size == strArr.length) {
                return;
            }
            int i12 = 0;
            for (int i13 = 0; i13 < strArr.length; i13++) {
                if (!hashSet.contains(Integer.valueOf(i13))) {
                    strArr2[i12] = strArr[i13];
                    i12++;
                }
            }
        }
        if (activity instanceof c) {
            ((c) activity).mo4480d(i10);
        }
        b.m79757b(activity, strArr, i10);
    }

    /* renamed from: d */
    public static boolean m79752d(Activity activity, String str) {
        if (C1085a.m6463c() || !TextUtils.equals(Constants.POST_NOTIFICATIONS, str)) {
            return b.m79758c(activity, str);
        }
        return false;
    }
}
