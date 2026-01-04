package com.huawei.fastengine.fastview.card;

import com.huawei.fastengine.fastview.card.bean.CardInfo;

/* loaded from: classes5.dex */
public interface DownloadCardCallback {
    public static final int FAILURE = -1;
    public static final int FILE_CREATE_FAILED = -4;
    public static final int LOW_PLATFORM = -2;
    public static final int PARAMS_INVALID = -3;
    public static final int SUCCESS = 0;

    void onError(int i10);

    void onResult(CardInfo cardInfo);
}
