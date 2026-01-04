package cn.com.miaozhen.mobile.tracking.viewability.origin;

import java.io.Serializable;

/* loaded from: classes.dex */
public interface MzCallBack extends Serializable {
    void onFailed(String str);

    void onSuccess(String str);
}
