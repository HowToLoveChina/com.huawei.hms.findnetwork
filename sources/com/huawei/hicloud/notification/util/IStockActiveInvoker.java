package com.huawei.hicloud.notification.util;

/* loaded from: classes6.dex */
public interface IStockActiveInvoker {
    void activeCloud(String str);

    boolean canNotify(int i10);

    void clearNotification();

    void finishActivity();

    void trySendNotification();

    void tryShowPopup();
}
