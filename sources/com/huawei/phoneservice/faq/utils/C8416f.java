package com.huawei.phoneservice.faq.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.FrameLayout;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.widget.BadgeHelper;
import com.huawei.phoneservice.feedback.p175ui.FeedbackDispatchActivity;
import com.huawei.phoneservice.feedback.utils.SdkFeedbackProblemManager;
import com.huawei.phoneservice.feedbackcommon.entity.ProblemInfo;
import com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.huawei.phoneservice.faq.utils.f */
/* loaded from: classes4.dex */
public class C8416f {
    /* renamed from: a */
    public static Object m52389a(Class<?> cls) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return cls.getDeclaredMethod("getManager", null).invoke(null, null);
    }

    /* renamed from: b */
    public static void m52390b(Context context) throws Throwable {
        try {
            Class<?> clsM52393e = m52393e();
            clsM52393e.getMethod("gotoUploadFile", Activity.class).invoke(m52389a(clsM52393e), context);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            FaqLogger.m51840e("ManagerInvoker", e10.getMessage());
        }
    }

    /* renamed from: c */
    public static void m52391c(Context context, BadgeHelper badgeHelper, String str, boolean z10) {
        try {
            if (FaqConstants.OPEN_TYPE_IN.equals(str) || FaqConstants.OPEN_TYPE_OUT.equals(str)) {
                FrameLayout.LayoutParams layoutParams = FeedbackDispatchActivity.f39802W;
                context.startActivity(new Intent(context, (Class<?>) FeedbackDispatchActivity.class));
            } else {
                Class<?> clsM52393e = m52393e();
                Object objM52389a = m52389a(clsM52393e);
                int i10 = ProblemInfo.FEEDBACK;
                Class<?> cls = Integer.TYPE;
                Object objNewInstance = ProblemInfo.class.getConstructor(cls).newInstance(Integer.valueOf(badgeHelper.getBadgeNumber()));
                Method method = clsM52393e.getMethod(z10 ? "gotoFeedback" : "gotoProductSuggest", Activity.class, objNewInstance.getClass(), cls);
                ProblemInfo.class.getMethod("setRefresh", cls).invoke(objNewInstance, 1);
                method.invoke(objM52389a, context, objNewInstance, -1);
                badgeHelper.setBadgeNumber(0);
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e10) {
            FaqLogger.m51840e("ManagerInvoker", e10.getMessage());
        }
    }

    /* renamed from: d */
    public static boolean m52392d() throws Throwable {
        try {
            m52394f();
            return true;
        } catch (ClassNotFoundException e10) {
            FaqLogger.m51840e("ManagerInvoker", e10.getMessage());
            return false;
        }
    }

    /* renamed from: e */
    public static Class<?> m52393e() throws ClassNotFoundException {
        return SdkFeedbackProblemManager.class;
    }

    /* renamed from: f */
    public static Class<?> m52394f() throws ClassNotFoundException {
        int i10 = SdkProblemManager.f40283c;
        return SdkProblemManager.class;
    }
}
