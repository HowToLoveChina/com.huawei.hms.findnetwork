package com.huawei.cloud.pay.model;

import java.util.LinkedHashMap;

/* loaded from: classes5.dex */
public interface WelfarePickAndCancelRenewalInterface {
    void backPressEvent(String str);

    void cancelRenewal();

    void checkConfirmCancelPassword();

    void pickWelfare(String str);

    void reportButtonPositiveClicked();

    void reportCancelAutoRenewalResultFailed(String str);

    void reportEventByID(String str, LinkedHashMap<String, String> linkedHashMap);

    void reportWelfare(String str);

    void retentionSuccessIAP();
}
