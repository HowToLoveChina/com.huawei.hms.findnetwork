package com.huawei.hicloud.notification.config;

import android.content.SharedPreferences;
import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.data.BaseDataCollector;
import com.huawei.hicloud.notification.frequency.FrequencyManager;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.RestoreNotifyConfig;
import com.huawei.hicloud.notification.p106db.operator.NDCOperator;
import java.util.List;

/* loaded from: classes6.dex */
public class CBPushConfigObject {
    private static final String TAG = "CBPushConfigObject";
    private String login_state;

    @SerializedName("goto")
    private CBPushGoto mGoto;
    private CBPushContent[] notice_content;
    private CBPushRule[] notice_rules;
    private String notice_type;
    private int priority;

    @SerializedName("notification_backup_restore")
    private List<RestoreNotifyConfig> restoreNotifyConfig;

    /* renamed from: id */
    private int f22628id = -1;
    private String data_type = HNConstants.DataType.f22634NA;

    @SerializedName("dayonce")
    private float frequency = -1.0f;
    private FrequencyManager frequencyChecker = new FrequencyManager();

    private Object[] calculateIncrement(Object[] objArr, Object[] objArr2) {
        Object[] objArr3 = new Object[2];
        if (objArr != null && objArr2 != null) {
            int length = objArr.length;
            int length2 = objArr2.length;
            NotifyLogger.m29915i(TAG, "calculateIncrement currentValueLength = " + length + ",currentValueLength = " + length2);
            if (length >= 1 && length2 >= 1) {
                objArr3[0] = Integer.valueOf(((Integer) objArr2[0]).intValue() - ((Integer) objArr[0]).intValue());
            }
            if (length >= 2 && length2 >= 2) {
                objArr3[1] = Long.valueOf(((Long) objArr2[1]).longValue() - ((Long) objArr[1]).longValue());
            }
        }
        return objArr3;
    }

    private boolean checkDataInfo(BaseDataCollector baseDataCollector) throws Throwable {
        NotifyLogger.m29915i(TAG, "checkDataInfo");
        NDCOperator nDCOperator = new NDCOperator();
        Object[] dataInfo = getDataInfo(baseDataCollector);
        CBPushRule rule = getRule(HNConstants.RuleType.INIT_VALUE);
        if (rule == null) {
            NotifyLogger.m29914e(TAG, "init_notice_rules is null");
            return false;
        }
        int iIntValue = ((Integer) dataInfo[0]).intValue();
        long jLongValue = ((Long) dataInfo[1]).longValue();
        int iNeedCheckInit = nDCOperator.needCheckInit(getNoticeType(), getDataType());
        NotifyLogger.m29915i(TAG, "amount=" + iIntValue + ",size=" + jLongValue + ",needCheckInit=" + iNeedCheckInit);
        if (iNeedCheckInit == 0) {
            if (!rule.check(iIntValue, jLongValue)) {
                return false;
            }
            nDCOperator.updateCheckInit(1, getNoticeType(), getDataType());
            saveDataInfoRecord(((Integer) dataInfo[0]).intValue(), ((Long) dataInfo[1]).longValue());
            return true;
        }
        if (iNeedCheckInit == 1) {
            Object[] dataInfoRecord = getDataInfoRecord();
            CBPushRule rule2 = getRule(HNConstants.RuleType.INCREMENT_VALUE);
            if (rule2 == null) {
                NotifyLogger.m29914e(TAG, "increment_notice_rules is null");
                return false;
            }
            Object[] objArrCalculateIncrement = calculateIncrement(dataInfoRecord, dataInfo);
            NotifyLogger.m29915i(TAG, "incre_amount=" + ((Integer) objArrCalculateIncrement[0]) + ",incre_size=" + ((Long) objArrCalculateIncrement[1]));
            if (rule2.check(((Integer) objArrCalculateIncrement[0]).intValue(), ((Long) objArrCalculateIncrement[1]).longValue())) {
                saveDataInfoRecord(((Integer) dataInfo[0]).intValue(), ((Long) dataInfo[1]).longValue());
                return true;
            }
        }
        return false;
    }

    private boolean checkFrequency() {
        return this.frequencyChecker.checkRuleFrequency(this.notice_type, this.data_type, this.frequency);
    }

    private Object[] getDataInfo(BaseDataCollector baseDataCollector) {
        NotifyLogger.m29915i(TAG, "checkDataInfo");
        baseDataCollector.execute();
        return new Object[]{Integer.valueOf(baseDataCollector.getmAmount()), Long.valueOf(baseDataCollector.getSize())};
    }

    private Object[] getDataInfoRecord() {
        NotifyLogger.m29915i(TAG, "getDataInfoRecord data_type=" + this.data_type);
        SharedPreferences notificationSP = HNUtil.getNotificationSP();
        if (notificationSP == null) {
            return new Object[0];
        }
        if (this.data_type.equals(HNConstants.DataType.MEDIA)) {
            return new Object[]{Integer.valueOf(notificationSP.getInt(HNConstants.C4907SP.MEDIA_AMOUNT, 0)), Long.valueOf(notificationSP.getLong(HNConstants.C4907SP.MEDIA_SIZE, 0L))};
        }
        if (this.data_type.equals("application")) {
            return new Object[]{Integer.valueOf(notificationSP.getInt(HNConstants.C4907SP.APP_AMOUNT, 0)), Long.valueOf(notificationSP.getLong(HNConstants.C4907SP.APP_SIZE, 0L))};
        }
        if (this.data_type.equals(HNConstants.DataType.CONTACT)) {
            return new Object[]{Integer.valueOf(notificationSP.getInt(HNConstants.C4907SP.CONTACT_AMOUNT, 0)), Long.valueOf(notificationSP.getLong(HNConstants.C4907SP.CONTACT_SIZE, 0L))};
        }
        return null;
    }

    private CBPushRule getRule(String str) {
        CBPushRule[] cBPushRuleArr = this.notice_rules;
        if (cBPushRuleArr == null) {
            return null;
        }
        for (CBPushRule cBPushRule : cBPushRuleArr) {
            if (str.equals(cBPushRule.getRuleType())) {
                return cBPushRule;
            }
        }
        return null;
    }

    private void saveDataInfoRecord(int i10, long j10) {
        NotifyLogger.m29915i(TAG, "saveDataInfoRecord");
        SharedPreferences notificationSP = HNUtil.getNotificationSP();
        if (notificationSP == null) {
            NotifyLogger.m29914e(TAG, "notify config sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = notificationSP.edit();
        if (this.data_type.equals(HNConstants.DataType.MEDIA)) {
            editorEdit.putInt(HNConstants.C4907SP.MEDIA_AMOUNT, i10);
            editorEdit.putLong(HNConstants.C4907SP.MEDIA_SIZE, j10);
        } else if (this.data_type.equals("application")) {
            editorEdit.putInt(HNConstants.C4907SP.APP_AMOUNT, i10);
            editorEdit.putLong(HNConstants.C4907SP.APP_SIZE, j10);
        } else if (this.data_type.equals(HNConstants.DataType.CONTACT)) {
            editorEdit.putInt(HNConstants.C4907SP.CONTACT_AMOUNT, i10);
            editorEdit.putLong(HNConstants.C4907SP.CONTACT_SIZE, j10);
        }
        editorEdit.commit();
    }

    public boolean check(BaseDataCollector baseDataCollector) {
        if (!checkFrequency()) {
            return false;
        }
        NotifyLogger.m29915i(TAG, "rule frequency check success");
        return checkDataInfo(baseDataCollector);
    }

    public boolean checkRuleFrequency() {
        return checkFrequency();
    }

    public String getDataType() {
        return this.data_type;
    }

    public float getFrequency() {
        return this.frequency;
    }

    public FrequencyManager getFrequencyChecker() {
        return this.frequencyChecker;
    }

    public int getId() {
        return this.f22628id;
    }

    public String getLoginState() {
        return this.login_state;
    }

    public CBPushContent[] getNoticeContent() {
        CBPushContent[] cBPushContentArr = this.notice_content;
        return cBPushContentArr != null ? (CBPushContent[]) cBPushContentArr.clone() : new CBPushContent[0];
    }

    public CBPushRule[] getNoticeRules() {
        CBPushRule[] cBPushRuleArr = this.notice_rules;
        return cBPushRuleArr != null ? (CBPushRule[]) cBPushRuleArr.clone() : new CBPushRule[0];
    }

    public String getNoticeType() {
        return this.notice_type;
    }

    public int getPriority() {
        return this.priority;
    }

    public CBPushGoto getmGoto() {
        return this.mGoto;
    }

    public void setDataType(String str) {
        this.data_type = str;
    }

    public void setFrequency(float f10) {
        this.frequency = f10;
    }

    public void setFrequencyChecker(FrequencyManager frequencyManager) {
        this.frequencyChecker = frequencyManager;
    }

    public void setId(int i10) {
        this.f22628id = i10;
    }

    public void setLoginState(String str) {
        this.login_state = str;
    }

    public void setNoticeContent(CBPushContent[] cBPushContentArr) {
        if (cBPushContentArr != null) {
            this.notice_content = (CBPushContent[]) cBPushContentArr.clone();
        } else {
            this.notice_content = null;
        }
    }

    public void setNoticeRules(CBPushRule[] cBPushRuleArr) {
        if (cBPushRuleArr != null) {
            this.notice_rules = (CBPushRule[]) cBPushRuleArr.clone();
        } else {
            this.notice_rules = null;
        }
    }

    public void setNoticeType(String str) {
        this.notice_type = str;
    }

    public void setPriority(int i10) {
        this.priority = i10;
    }

    public void setmGoto(CBPushGoto cBPushGoto) {
        this.mGoto = cBPushGoto;
    }
}
