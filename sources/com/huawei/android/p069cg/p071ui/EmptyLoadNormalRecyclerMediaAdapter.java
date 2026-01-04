package com.huawei.android.p069cg.p071ui;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.bean.MediaFileBean;
import com.huawei.android.p069cg.p071ui.RecyclerMediaAdapter;
import p031b7.C1120a;
import p471m6.C11417c;

/* loaded from: classes2.dex */
public class EmptyLoadNormalRecyclerMediaAdapter extends EmptyLoadRecyclerMediaAdapter {
    public EmptyLoadNormalRecyclerMediaAdapter(Context context) {
        super(context);
    }

    @Override // com.huawei.android.p069cg.p071ui.RecyclerMediaAdapter
    /* renamed from: I */
    public RecyclerView.AbstractC0833c0 mo14685I(ViewGroup viewGroup) {
        return new RecyclerMediaAdapter.C2357i(this.f11220d.inflate(R$layout.pic_tab_recycler_media_thumbs_item, viewGroup, false));
    }

    @Override // com.huawei.android.p069cg.p071ui.RecyclerMediaAdapter
    /* renamed from: W */
    public void mo14686W(RecyclerMediaAdapter.C2356h c2356h, RecyclerMediaAdapter.C2357i c2357i, int i10) {
        C1120a.m6677i("EmptyLoadNormalRecyclerMediaAdapter", "initThumbsIcon start, position = " + i10);
        MediaFileBean mediaFileBeanM14792a = c2356h.m14792a();
        if (mediaFileBeanM14792a == null) {
            C1120a.m6676e("EmptyLoadNormalRecyclerMediaAdapter", "data not ready");
            return;
        }
        C11417c c11417cM14343n = mediaFileBeanM14792a.m14343n();
        if (c11417cM14343n == null) {
            return;
        }
        m14788y0(c2357i, c11417cM14343n);
        m14778o0(c2357i, c11417cM14343n);
    }
}
