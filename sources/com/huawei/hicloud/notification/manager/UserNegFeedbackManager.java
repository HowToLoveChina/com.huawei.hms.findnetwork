package com.huawei.hicloud.notification.manager;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.BaseNotifyBean;
import java.util.LinkedHashMap;
import p015ak.C0213f;
import p015ak.C0214f0;

/* loaded from: classes6.dex */
public class UserNegFeedbackManager {
    private static final String KEY_PREFIX_COUNT = "count_";
    private static final String KEY_PREFIX_LIMIT = "limit_";
    private static final String KEY_PREFIX_STEP = "step_";
    private static final String TAG = "UserNegFeedbackManager";
    private static final String USER_NEGATIVE_SP_NAME = "user_negative_feedback_records";

    /* renamed from: sp */
    private SharedPreferences f22669sp;

    public static class Holder {
        private static UserNegFeedbackManager instance = new UserNegFeedbackManager();

        private Holder() {
        }
    }

    public static UserNegFeedbackManager getInstance(Context context) {
        if (Holder.instance.f22669sp == null) {
            Holder.instance.init(context);
        }
        return Holder.instance;
    }

    private void init(Context context) {
        if (context == null) {
            context = C0213f.m1377a();
        }
        this.f22669sp = C0214f0.m1382b(context, USER_NEGATIVE_SP_NAME, 0);
    }

    private void setRecordCount(String str, int i10) {
        SharedPreferences sharedPreferences = this.f22669sp;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt(KEY_PREFIX_COUNT + str, i10).commit();
        }
    }

    private void updateStepAndLimit(int i10, int i11, int i12) {
        setStep(i10, i11);
        setLimit(i10, i12);
    }

    public synchronized void addRecordCount(String str) {
        setRecordCount(str, getRecordCount(str) + 1);
    }

    public synchronized void checkConfigChange(BaseNotifyBean baseNotifyBean) {
        if (baseNotifyBean == null) {
            return;
        }
        int id2 = baseNotifyBean.getId();
        String noticeType = baseNotifyBean.getNoticeType();
        int frequencyStep = baseNotifyBean.getFrequencyStep();
        int frequencyLimit = baseNotifyBean.getFrequencyLimit();
        int step = getStep(id2);
        int limit = getLimit(id2);
        if (step != 0 && limit != 0) {
            if (frequencyStep != step || frequencyLimit != limit) {
                NotifyLogger.m29915i(TAG, "config change, clear record count, id: " + id2);
                setRecordCount(noticeType, 0);
                updateStepAndLimit(id2, frequencyStep, frequencyLimit);
            }
            return;
        }
        NotifyLogger.m29915i(TAG, "first check, update value, id: " + id2);
        updateStepAndLimit(id2, frequencyStep, frequencyLimit);
    }

    public void clearSp() {
        SharedPreferences sharedPreferences = this.f22669sp;
        if (sharedPreferences != null) {
            sharedPreferences.edit().clear().commit();
        }
    }

    public float getDayPeriod(BaseNotifyBean baseNotifyBean) {
        checkConfigChange(baseNotifyBean);
        float frequency = baseNotifyBean.getFrequency();
        int frequencyStep = baseNotifyBean.getFrequencyStep();
        int frequencyLimit = baseNotifyBean.getFrequencyLimit();
        int recordCount = getRecordCount(baseNotifyBean.getNoticeType());
        float fPow = (float) (frequency * Math.pow(frequencyStep / 10.0d, recordCount));
        NotifyLogger.m29915i(TAG, "getDayPeriod frequency: " + frequency + ", record: " + recordCount + ", step: " + frequencyStep + ", limit: " + frequencyLimit + ", calculate freq: " + fPow);
        return Math.max(Math.min(fPow, frequencyLimit), frequency);
    }

    public int getLimit(int i10) {
        SharedPreferences sharedPreferences = this.f22669sp;
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getInt(KEY_PREFIX_LIMIT + i10, 0);
    }

    public int getRecordCount(String str) {
        SharedPreferences sharedPreferences = this.f22669sp;
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getInt(KEY_PREFIX_COUNT + str, 0);
    }

    public int getStep(int i10) {
        SharedPreferences sharedPreferences = this.f22669sp;
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getInt(KEY_PREFIX_STEP + i10, 0);
    }

    public void reportNegChecked(BaseNotifyBean baseNotifyBean) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (baseNotifyBean != null) {
                String noticeType = baseNotifyBean.getNoticeType();
                linkedHashMap.put(NotifyConstants.NotificationReport.PARAM_NEG_NOTIFY_TYPE, noticeType);
                linkedHashMap.put(NotifyConstants.NotificationReport.PARAM_NEG_NOTIFY_ID, String.valueOf(baseNotifyBean.getId()));
                linkedHashMap.put(NotifyConstants.NotificationReport.PARAM_NEG_NOTIFY_COUNT, String.valueOf(getRecordCount(noticeType)));
            }
            NotificationBIReportUtil.reportNegFreqControlled(linkedHashMap);
            NotificationReportUtil.reportNegFreqControlled(linkedHashMap);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportNegChecked, exception: " + e10.toString());
        }
    }

    public void setLimit(int i10, int i11) {
        SharedPreferences sharedPreferences = this.f22669sp;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt(KEY_PREFIX_LIMIT + i10, i11).commit();
        }
    }

    public void setStep(int i10, int i11) {
        SharedPreferences sharedPreferences = this.f22669sp;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt(KEY_PREFIX_STEP + i10, i11).commit();
        }
    }

    private UserNegFeedbackManager() {
        this.f22669sp = null;
    }
}
