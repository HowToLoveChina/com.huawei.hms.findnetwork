package com.huawei.hicloud.notification.task;

import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.RecommendCardManager;
import com.huawei.hicloud.notification.p106db.bean.CommonPicture;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;

/* loaded from: classes6.dex */
public class QueryHiCloudBannerPicturesTask extends AbstractC12367d {
    private static final String TAG = "QueryHiCloudBannerPicturesTask";
    private CommonPicture[] pictures;

    public QueryHiCloudBannerPicturesTask(CommonPicture[] commonPictureArr) {
        this.pictures = commonPictureArr;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws InterruptedException {
        if (this.pictures == null) {
            NotifyLogger.m29914e(TAG, "pictures is null");
            return;
        }
        for (int i10 = 0; i10 < this.pictures.length && i10 < 2; i10++) {
            RecommendCardManager.getInstance().downloadPicture(this.pictures[i10]);
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.RECOMMEND_CARD;
    }
}
