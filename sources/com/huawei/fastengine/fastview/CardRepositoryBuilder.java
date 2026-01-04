package com.huawei.fastengine.fastview;

import com.huawei.fastengine.internal.FastSdkLoader;
import com.huawei.fastsdk.ICardRepository;

/* loaded from: classes5.dex */
public class CardRepositoryBuilder {
    public ICardRepository build() {
        FastSdkLoader fastSdkLoader = FastSdkLoader.getInstance();
        if (fastSdkLoader != null) {
            return fastSdkLoader.getCardRepository();
        }
        return null;
    }
}
