package com.huawei.android.p069cg.p071ui;

import android.content.Context;
import p031b7.C1120a;
import p031b7.C1122c;
import p546p6.C12091d;

/* loaded from: classes2.dex */
public class EmptyLoadCoverBgRecyclerMediaAdapter extends EmptyLoadNormalRecyclerMediaAdapter {
    public EmptyLoadCoverBgRecyclerMediaAdapter(Context context) {
        super(context);
    }

    @Override // com.huawei.android.p069cg.p071ui.EmptyLoadRecyclerMediaAdapter
    /* renamed from: M0 */
    public void mo14684M0(int i10, int i11) {
        if (this.f11169w) {
            int i12 = this.f11167u;
            if (i12 == -1 || i10 - i12 > C1122c.f5363q) {
                C1120a.m6677i("EmptyLoadCoverBgRecyclerMediaAdapter", "bindPictureViewHolder for lastStart, position = " + i11 + ", queryMediaDataFromPicTab");
                C12091d.m72280a0().m72325Q0(this.f11221e, this.f11165s, i10, this.f11166t);
                this.f11167u = i10;
                this.f11168v = i10 + C1122c.f5363q;
                return;
            }
            return;
        }
        int i13 = this.f11168v;
        if (i13 == -1 || i13 - i10 > C1122c.f5363q) {
            C1120a.m6677i("EmptyLoadCoverBgRecyclerMediaAdapter", "bindPictureViewHolder for lastEnd, position = " + i11 + ", queryMediaDataFromPicTab");
            C12091d.m72280a0().m72325Q0(this.f11221e, this.f11165s, i10, this.f11166t);
            this.f11168v = i10;
            this.f11167u = i10 - C1122c.f5363q;
        }
    }
}
