package com.huawei.phoneservice.faq.base.util;

import android.content.Context;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.entity.ModuleConfigResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import org.json.JSONArray;

/* loaded from: classes4.dex */
public class ModuleConfigUtils {
    private static final String TAG = "ModuleConfigUtils";
    private static List<String> moduleConfigList = new Vector();
    private static List<ModuleConfigResponse.ModuleListBean> moduleListBeans = new ArrayList();
    private static String[] feedbackOpenTypeConfig = new String[2];
    private static String[] faqOpenTypeConfig = new String[2];
    private static String[] feedbackH5OpenTypeConfig = new String[2];
    private static String[] channelName = new String[1];

    public static void cleanSdkModuleList(Context context) {
        if (!FaqCommonUtils.isEmpty(moduleConfigList)) {
            try {
                moduleConfigList.clear();
            } catch (IndexOutOfBoundsException unused) {
                FaqLogger.m51840e(TAG, "IndexOutOfBoundsException");
            }
        }
        FaqSharePrefUtil.m51879d(context, "");
    }

    public static boolean contactEnabled() {
        return moduleConfigList.contains("2");
    }

    public static boolean feedbackAssessmentEnabled(boolean z10) {
        if (z10) {
            return moduleConfigList.contains("6") && moduleConfigList.contains(FaqConstants.MODULE_FEEDBACK_PS_PJ);
        }
        if (moduleConfigList.contains("3") && moduleConfigList.contains(FaqConstants.MODULE_FEEDBACK_ASSESSMENT)) {
            return true;
        }
        return moduleConfigList.contains("5") && moduleConfigList.contains(FaqConstants.MODULE_FEEDBACK_ASSESSMENT_NEW);
    }

    public static boolean feedbackContactEnabled() {
        if (moduleConfigList.contains("3") && moduleConfigList.contains(FaqConstants.MODULE_FEEDBACK_CONTACT)) {
            return true;
        }
        return moduleConfigList.contains("5") && moduleConfigList.contains(FaqConstants.MODULE_FEEDBACK_CONTACT_NEW);
    }

    public static boolean feedbackEnabled() {
        return moduleConfigList.contains("3");
    }

    public static boolean feedbackHistoryEnabled() {
        if (moduleConfigList.contains("3") && moduleConfigList.contains(FaqConstants.MODULE_FEEDBACK_HISTORY)) {
            return true;
        }
        return moduleConfigList.contains("5") && moduleConfigList.contains(FaqConstants.MODULE_FEEDBACK_HISTORY_NEW);
    }

    public static boolean feedbackLogEnabled() {
        if (moduleConfigList.contains("3") && moduleConfigList.contains(FaqConstants.MODULE_FEEDBACK_UPLOAD_LOG)) {
            return true;
        }
        return moduleConfigList.contains("5") && moduleConfigList.contains(FaqConstants.MODULE_FEEDBACK_UPLOAD_LOG_NEW);
    }

    public static boolean feedbackNoticeEnabled() {
        return moduleConfigList.contains(FaqConstants.MODULE_FEEDBACK_NOTICE) || moduleConfigList.contains(FaqConstants.MODULE_FEEDBACK_NOTICE_OUTER);
    }

    public static boolean feedbackVisible() {
        return "0".equals(FaqSdk.getSdk().getSdk(FaqConstants.FAQ_FEEDBACK_ISVISIBLE));
    }

    public static void genSdkModuleList(Context context, List<ModuleConfigResponse.ModuleListBean> list) {
        moduleListBeans = list;
        try {
            if (FaqCommonUtils.isEmpty(list)) {
                return;
            }
            feedbackOpenTypeConfig = new String[2];
            channelName[0] = list.get(0).m51762c();
            JSONArray jSONArray = new JSONArray();
            for (ModuleConfigResponse.ModuleListBean moduleListBean : list) {
                if ("3".equals(moduleListBean.getModuleCode())) {
                    feedbackOpenTypeConfig[0] = moduleListBean.getOpenType();
                    feedbackOpenTypeConfig[1] = moduleListBean.getLinkAddress();
                }
                if ("8".equals(moduleListBean.getModuleCode())) {
                    faqOpenTypeConfig[0] = moduleListBean.getOpenType();
                    faqOpenTypeConfig[1] = moduleListBean.getLinkAddress();
                }
                if ("11".equals(moduleListBean.getModuleCode())) {
                    feedbackH5OpenTypeConfig[0] = moduleListBean.getOpenType();
                    feedbackH5OpenTypeConfig[1] = moduleListBean.getLinkAddress();
                }
                moduleConfigList.add(moduleListBean.getModuleCode());
                jSONArray.put(moduleListBean.getModuleCode());
                List<ModuleConfigResponse.SubModuleListBean> listM51763d = moduleListBean.m51763d();
                if (!FaqCommonUtils.isEmpty(listM51763d)) {
                    for (ModuleConfigResponse.SubModuleListBean subModuleListBean : listM51763d) {
                        moduleConfigList.add(subModuleListBean.m51766c());
                        jSONArray.put(subModuleListBean.m51766c());
                    }
                }
            }
            FaqSharePrefUtil.m51879d(context, jSONArray.toString());
        } catch (Exception e10) {
            FaqLogger.m51840e(TAG, e10.getMessage());
        }
    }

    public static String getChannelName() {
        return channelName[0];
    }

    public static String[] getFaqOpenTypeConfig() {
        return (String[]) faqOpenTypeConfig.clone();
    }

    public static String[] getFeedbackH5OpenTypeConfig() {
        return (String[]) feedbackH5OpenTypeConfig.clone();
    }

    public static String[] getFeedbackOpenTypeConfig() {
        return (String[]) feedbackOpenTypeConfig.clone();
    }

    public static List<ModuleConfigResponse.ModuleListBean> getModuleConfigList() {
        return moduleListBeans;
    }

    public static boolean isEmpty() {
        return FaqCommonUtils.isEmpty(moduleConfigList);
    }

    public static boolean isHasFaq() {
        return moduleConfigList.contains("8");
    }

    public static boolean isNativeFeedback() {
        return (!newFeedbackEnabled() || FaqConstants.OPEN_TYPE_IN.equals(feedbackOpenTypeConfig[0]) || FaqConstants.OPEN_TYPE_OUT.equals(feedbackOpenTypeConfig[0])) ? false : true;
    }

    public static boolean knowledgeEnabled() {
        return moduleConfigList.contains("1");
    }

    public static boolean newFeedbackEnabled() {
        return moduleConfigList.contains("3") || moduleConfigList.contains("5");
    }

    public static boolean productSuggestEnabled() {
        return moduleConfigList.contains("6");
    }

    public static boolean productSuggestLsEnabled() {
        return moduleConfigList.contains(FaqConstants.MODULE_FEEDBACK_PRODUCT_SUGGEST_LS);
    }

    public static boolean productUploadLogEnabled() {
        return moduleConfigList.contains("7");
    }

    public static boolean relevanceKnowledgeEnabled() {
        return moduleConfigList.contains(FaqConstants.MODULE_KNOWLEDGE_RELEVANCE);
    }

    public static boolean searchHistoryEnabled() {
        return moduleConfigList.contains(FaqConstants.MODULE_KNOWLEDGE_SEARCH_HISTORY);
    }

    public static boolean searchHotEnabled() {
        return moduleConfigList.contains(FaqConstants.MODULE_KNOWLEDGE_HOTWORD);
    }

    public static boolean searchLogCollectEnabled() {
        return moduleConfigList.contains(FaqConstants.MODULE_KNOWLEDGE_SEARCH_LOG);
    }

    public static boolean searchRemindEnabled() {
        return moduleConfigList.contains(FaqConstants.MODULE_KNOWLEDGE_REMIND);
    }

    public static boolean searchViewEnabled() {
        return moduleConfigList.contains(FaqConstants.MODULE_KNOWLEDGE_SEARCH);
    }

    public static boolean newFeedbackEnabled(Context context) {
        if (!moduleConfigList.isEmpty()) {
            return moduleConfigList.contains("3") || moduleConfigList.contains("5");
        }
        String strM51878c = FaqSharePrefUtil.m51878c(context);
        return strM51878c.contains("3") || strM51878c.contains("5");
    }
}
