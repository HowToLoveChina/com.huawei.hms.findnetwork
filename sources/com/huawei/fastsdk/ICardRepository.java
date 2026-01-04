package com.huawei.fastsdk;

import android.util.Pair;

/* loaded from: classes5.dex */
public interface ICardRepository {
    void clearMemory();

    Pair<Integer, String> downloadCard(String str);

    boolean hasCache(String str);

    boolean hasCard(String str);

    int preloadCard(String str);

    void removeAllCard();

    void removeCard(String str);

    void removeMemoryCard(String str);

    void setCardThreshold(int i10);
}
