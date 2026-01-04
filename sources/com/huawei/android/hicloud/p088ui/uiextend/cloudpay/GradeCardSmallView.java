package com.huawei.android.hicloud.p088ui.uiextend.cloudpay;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.p088ui.uiadapter.cloudpay.RightGridAdapter;
import com.huawei.android.hicloud.p088ui.uiadapter.cloudpay.RightGridSmallAdapter;
import com.huawei.android.p073ds.R$layout;
import com.huawei.cloud.pay.model.PackageGradeRight;
import com.huawei.cloud.pay.model.cardresourcebean.GradeCardDefaultResourceBean;
import com.huawei.cloud.pay.model.cardresourcebean.GradeCardDiamondResourceBean;
import com.huawei.cloud.pay.model.cardresourcebean.GradeCardGoldResourceBean;
import com.huawei.cloud.pay.model.cardresourcebean.GradeCardNormalResourceBean;
import com.huawei.cloud.pay.model.cardresourcebean.GradeCardPlatinumResourceBean;
import com.huawei.cloud.pay.model.cardresourcebean.GradeCardSilverResourceBean;
import com.huawei.cloud.pay.model.cardresourcebean.GradeCardTryResourceBean;
import dk.EnumC9164e;
import java.util.ArrayList;
import java.util.List;
import p459lp.C11326d;
import p514o9.C11828b;
import p709vj.C13452e;

/* loaded from: classes3.dex */
public class GradeCardSmallView extends GradeCardView {
    private static final int MAX_RIGHT_CAN_SHOW = 5;

    /* renamed from: com.huawei.android.hicloud.ui.uiextend.cloudpay.GradeCardSmallView$1 */
    public static /* synthetic */ class C41471 {

        /* renamed from: $SwitchMap$com$huawei$hicloud$base$constant$UserGradeConstants$GradeCodeLevel */
        static final /* synthetic */ int[] f19194xad5204ea;

        static {
            int[] iArr = new int[EnumC9164e.values().length];
            f19194xad5204ea = iArr;
            try {
                iArr[EnumC9164e.LEVEL_0.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19194xad5204ea[EnumC9164e.LEVEL_1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19194xad5204ea[EnumC9164e.LEVEL_2.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f19194xad5204ea[EnumC9164e.LEVEL_3.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public GradeCardSmallView(Context context) {
        super(context);
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.cloudpay.GradeCardView
    public List<PackageGradeRight> getOneRowRights(List<PackageGradeRight> list) {
        return list;
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.cloudpay.GradeCardView
    public RightGridAdapter getRightGridAdapter(Context context) {
        return new RightGridSmallAdapter(context);
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.cloudpay.GradeCardView
    public void inflateLayout(Context context) {
        View.inflate(context, R$layout.grade_card_layout_small, this);
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.cloudpay.GradeCardView
    public void refreshViewByGradeCode(String str) {
        if (C13452e.m80781L().m80887a1()) {
            setCardResource(new GradeCardDefaultResourceBean(true));
            return;
        }
        if (TextUtils.equals(str, CloudBackupConstant.UserPackageInfo.TRIAL_MEMBER)) {
            setCardResource(new GradeCardTryResourceBean(true));
            return;
        }
        if (TextUtils.equals(str, CloudBackupConstant.UserPackageInfo.ONE_T_MEMBER)) {
            setCardResource(new GradeCardPlatinumResourceBean(true));
            return;
        }
        int i10 = C41471.f19194xad5204ea[C11326d.m68044f(str).ordinal()];
        if (i10 == 1) {
            setCardResource(new GradeCardNormalResourceBean(true));
            return;
        }
        if (i10 == 2) {
            setCardResource(new GradeCardSilverResourceBean(true));
            return;
        }
        if (i10 == 3) {
            setCardResource(new GradeCardGoldResourceBean(true));
        } else if (i10 != 4) {
            setCardResource(new GradeCardDefaultResourceBean(true));
        } else {
            setCardResource(new GradeCardDiamondResourceBean(true));
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.cloudpay.GradeCardView
    public void setAdapterData(List<PackageGradeRight> list, C11828b c11828b, boolean z10) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() <= 0) {
            return;
        }
        if (list.size() >= 5) {
            for (int i10 = 0; i10 < 5; i10++) {
                arrayList.add(list.get(i10));
            }
        } else {
            arrayList.addAll(list);
        }
        this.gridAdapter.m25398g(arrayList, c11828b, this.needShowRightDescText);
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.cloudpay.GradeCardView
    public void showFolderView(List<PackageGradeRight> list) {
    }

    public GradeCardSmallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
