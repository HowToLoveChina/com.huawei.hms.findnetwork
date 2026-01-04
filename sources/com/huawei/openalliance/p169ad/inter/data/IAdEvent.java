package com.huawei.openalliance.p169ad.inter.data;

import android.view.View;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import java.util.List;

@OuterVisible
/* loaded from: classes2.dex */
public interface IAdEvent {
    void onAdClosed(List<String> list);

    void onAdShowed(View view);
}
