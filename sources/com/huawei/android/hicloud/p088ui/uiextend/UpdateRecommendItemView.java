package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.extend.HiCloudRoundRectImageView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.notification.p106db.bean.RecommendCard;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes3.dex */
public class UpdateRecommendItemView extends RecommendItemView {
    public UpdateRecommendItemView(Context context, RecommendCard recommendCard) {
        super(context, recommendCard, 0, false);
    }

    public int getRecommendTitleMaxLength() {
        int iMin;
        if (C11842p.m70753O0(this.myContext)) {
            iMin = Math.min(C11842p.m70771U0() ? C11842p.m70840n(this.myContext, ErrorCode.ERROR_SIGTOOL_FAIL) : C11842p.m70747M0(this.myContext) ? C11842p.m70840n(this.myContext, 540) : C11842p.m70840n(this.myContext, 472), C11842p.m70752O(this.myContext));
        } else {
            iMin = Math.min(C11842p.m70771U0() ? C11842p.m70840n(this.myContext, 466) : C11842p.m70747M0(this.myContext) ? C11842p.m70840n(this.myContext, 472) : C11842p.m70758Q(this.myContext), C11842p.m70758Q(this.myContext));
        }
        return iMin - (C11842p.m70771U0() ? TextUtils.isEmpty(this.card.getButton()) ? C11842p.m70840n(this.myContext, 76) : C11842p.m70840n(this.myContext, 172) : TextUtils.isEmpty(this.card.getButton()) ? C11842p.m70840n(this.myContext, 60) : C11842p.m70840n(this.myContext, 130));
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.RecommendItemView
    public void initView() {
        if (C11842p.m70771U0()) {
            this.mView = LayoutInflater.from(this.myContext).inflate(R$layout.update_recommend_item_pad, this);
        } else {
            this.mView = LayoutInflater.from(this.myContext).inflate(R$layout.update_recommend_item, this);
        }
        this.imageView = (HiCloudRoundRectImageView) C12809f.m76831d(this.mView, R$id.recommend_item_bg);
        this.title = (TextView) C12809f.m76831d(this.mView, R$id.recommend_title);
        this.subTitle = (TextView) C12809f.m76831d(this.mView, R$id.recommend_intrudation);
        this.recommendButton = (TextView) C12809f.m76831d(this.mView, R$id.recommend_button);
        int recommendTitleMaxLength = getRecommendTitleMaxLength();
        TextView textView = this.subTitle;
        if (textView != null) {
            textView.setMaxWidth(recommendTitleMaxLength);
        }
        TextView textView2 = this.title;
        if (textView2 != null) {
            textView2.setMaxWidth(recommendTitleMaxLength);
            this.title.setMaxLines(1);
        }
    }

    public void setSubTitle(String str) {
        TextView textView = this.subTitle;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.RecommendItemView
    public void setSubTitleVisible(boolean z10) {
        TextView textView = this.subTitle;
        if (textView != null) {
            if (z10) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
    }
}
