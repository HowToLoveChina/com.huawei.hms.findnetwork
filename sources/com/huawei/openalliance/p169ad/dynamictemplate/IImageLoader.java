package com.huawei.openalliance.p169ad.dynamictemplate;

import android.widget.ImageView;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.dynamictemplate.view.IDrawableSetter;

@OuterVisible
/* loaded from: classes2.dex */
public interface IImageLoader {
    void load(ImageView imageView, String str);

    void loadDrawable(IDrawableSetter iDrawableSetter, String str);
}
