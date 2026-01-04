package com.huawei.uikit.hwadvancednumberpicker.widget;

import java.util.Collection;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes7.dex */
class bzrwd<E> extends LinkedBlockingQueue<E> {

    /* renamed from: a */
    private static final int f41255a = 7;

    public bzrwd() {
    }

    @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(E e10) {
        if (size() < 7) {
            return super.offer(e10);
        }
        return true;
    }

    public bzrwd(int i10) {
        super(i10);
    }

    public bzrwd(Collection<? extends E> collection) {
        super(collection);
    }
}
