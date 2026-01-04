package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.huawei.android.hicloud.p088ui.extend.HiCloudRoundRectImageView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.notification.manager.RecommendCardManager;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.views.PPSNativeView;
import p514o9.C11839m;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes3.dex */
public class RecommendPpsView extends LinearLayout {
    private static final String TAG = "RecommendPpsView";

    /* renamed from: ad */
    private INativeAd f19177ad;
    private String entrance;
    private HiCloudRoundRectImageView imageView;
    private View mView;
    protected Context myContext;

    public RecommendPpsView(Context context, String str, INativeAd iNativeAd) throws Resources.NotFoundException {
        super(context);
        this.myContext = context;
        this.f19177ad = iNativeAd;
        this.entrance = str;
        initView();
    }

    private void initView() throws Resources.NotFoundException {
        View viewInflate = LayoutInflater.from(this.myContext).inflate(R$layout.recommend_pps_item, this);
        this.mView = viewInflate;
        this.imageView = (HiCloudRoundRectImageView) C12809f.m76831d(viewInflate, R$id.recommend_item_bg);
        ((PPSNativeView) C12809f.m76831d(this.mView, R$id.recommend_pps)).register(this.f19177ad);
        String strM70812g = C11842p.m70812g(this.myContext, this.f19177ad.getImageInfos());
        C11839m.m70688i(TAG, " initView url :" + strM70812g);
        String ppsPicturePathFromSp = RecommendCardManager.getInstance().getPpsPicturePathFromSp(strM70812g, this.entrance);
        C11839m.m70688i(TAG, " initView path :" + ppsPicturePathFromSp);
        if (TextUtils.isEmpty(ppsPicturePathFromSp)) {
            return;
        }
        this.imageView.setImageBitmap(RecommendCardManager.getInstance().getPictureBitmapUserCache(ppsPicturePathFromSp));
    }
}
