package com.huawei.phoneservice.feedback.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.faq.base.util.ModuleConfigUtils;
import com.huawei.phoneservice.feedback.p175ui.FeedUploadActivity;
import com.huawei.phoneservice.feedback.p175ui.FeedbackDisabledActivity;
import com.huawei.phoneservice.feedback.p175ui.ProblemSuggestActivity;
import com.huawei.phoneservice.feedback.p175ui.ProblemSuggestForDeepLinkActivity;
import com.huawei.phoneservice.feedback.p175ui.ProductSuggestionActivity;
import com.huawei.phoneservice.feedbackcommon.entity.ProblemInfo;
import com.huawei.phoneservice.feedbackcommon.photolibrary.internal.entity.MediaItem;
import java.util.List;

/* loaded from: classes5.dex */
public class SdkFeedbackProblemManager implements IFeedbackProblemManager {
    private static final int HWID_FEED_BACK_REQUESTCODE = 1;
    private static final String TAG = "SdkFeedbackProblemManager";

    /* renamed from: com.huawei.phoneservice.feedback.utils.SdkFeedbackProblemManager$a */
    public static class C8593a {

        /* renamed from: a */
        public static final SdkFeedbackProblemManager f39971a = new SdkFeedbackProblemManager();
    }

    public static IFeedbackProblemManager getManager() {
        return C8593a.f39971a;
    }

    @Override // com.huawei.phoneservice.feedback.utils.IFeedbackProblemManager
    public void gotoFeedback(Activity activity, ProblemInfo problemInfo, int i10) throws Throwable {
        String str;
        if (activity == null) {
            str = "activity is null";
        } else {
            if (!FaqSdk.getISdk().hadAddress() || !ModuleConfigUtils.newFeedbackEnabled(activity)) {
                Intent intent = new Intent(activity, (Class<?>) FeedbackDisabledActivity.class);
                if (problemInfo != null) {
                    intent.putExtra("problem_info", problemInfo);
                }
                intent.putExtra("REQUEST_CODE", i10);
                activity.startActivity(intent);
                return;
            }
            Intent intent2 = new Intent(activity, (Class<?>) ProblemSuggestActivity.class);
            if (problemInfo != null) {
                intent2.putExtra("problem_info", problemInfo);
            }
            if (i10 < 0) {
                activity.startActivity(intent2);
                return;
            } else {
                if (((-65536) & i10) == 0) {
                    activity.startActivityForResult(intent2, i10);
                    return;
                }
                str = "Can only use lower 16 bits for requestCode: " + i10;
            }
        }
        FaqLogger.print(TAG, str);
    }

    @Override // com.huawei.phoneservice.feedback.utils.IFeedbackProblemManager
    public void gotoFeedbackByDeepLink(Activity activity, Bundle bundle) throws Throwable {
        if (activity == null) {
            FaqLogger.print(TAG, "activity is null");
        } else {
            if (bundle == null) {
                FaqLogger.print(TAG, "bundle is null");
                return;
            }
            Intent intent = FaqSdk.getISdk().hadAddress() ? new Intent(activity, (Class<?>) ProblemSuggestForDeepLinkActivity.class) : new Intent(activity, (Class<?>) FeedbackDisabledActivity.class);
            intent.putExtras(bundle);
            activity.startActivity(intent);
        }
    }

    @Override // com.huawei.phoneservice.feedback.utils.IFeedbackProblemManager
    public void gotoFeedbackForHwId(Activity activity, ProblemInfo problemInfo, int i10) throws Throwable {
        if (activity == null) {
            FaqLogger.print(TAG, "activity is null");
            return;
        }
        if (!FaqSdk.getISdk().hadAddress() || !ModuleConfigUtils.newFeedbackEnabled()) {
            Intent intent = new Intent(activity, (Class<?>) FeedbackDisabledActivity.class);
            if (problemInfo != null) {
                intent.putExtra("problem_info", problemInfo);
            }
            intent.putExtra("REQUEST_CODE", i10);
            activity.startActivityForResult(intent, 1);
            return;
        }
        Intent intent2 = new Intent(activity, (Class<?>) ProblemSuggestActivity.class);
        if (problemInfo != null) {
            intent2.putExtra("problem_info", problemInfo);
        }
        if (i10 >= 0) {
            activity.startActivityForResult(intent2, i10);
        } else {
            activity.startActivity(intent2);
        }
    }

    @Override // com.huawei.phoneservice.feedback.utils.IFeedbackProblemManager
    public void gotoProductSuggest(Activity activity, ProblemInfo problemInfo, int i10) throws Throwable {
        if (activity == null) {
            FaqLogger.print(TAG, "activity is null");
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) ProductSuggestionActivity.class);
        if (problemInfo != null) {
            intent.putExtra("problem_info", problemInfo);
        }
        if (i10 >= 0) {
            activity.startActivityForResult(intent, i10);
        } else {
            activity.startActivity(intent);
        }
    }

    @Override // com.huawei.phoneservice.feedback.utils.IFeedbackProblemManager
    public void gotoSelectedPreview(Activity activity, List<MediaItem> list, int i10) {
        if (activity == null || list == null) {
            return;
        }
        list.size();
    }

    @Override // com.huawei.phoneservice.feedback.utils.IFeedbackProblemManager
    public void gotoUploadFile(Activity activity) throws Throwable {
        if (activity == null) {
            FaqLogger.m51840e(TAG, "go to upload activity is null");
        } else if (FaqSdk.getISdk().hadAddress()) {
            activity.startActivity(new Intent(activity, (Class<?>) FeedUploadActivity.class));
        }
    }
}
