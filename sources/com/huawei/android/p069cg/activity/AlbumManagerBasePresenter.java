package com.huawei.android.p069cg.activity;

import android.widget.LinearLayout;
import p514o9.C11842p;

/* loaded from: classes2.dex */
public class AlbumManagerBasePresenter extends LinearLayout {

    /* renamed from: a */
    public AlbumManageActivity f9944a;

    public AlbumManagerBasePresenter(AlbumManageActivity albumManageActivity) {
        super(albumManageActivity);
        this.f9944a = albumManageActivity;
    }

    /* renamed from: a */
    public int m13320a(int i10) {
        if (this.f9944a.getResources().getConfiguration().orientation == 2) {
            if (C11842p.m70771U0()) {
                return 6;
            }
        } else {
            if (this.f9944a.getResources().getConfiguration().orientation != 1) {
                return i10;
            }
            if (!C11842p.m70771U0()) {
                return 2;
            }
        }
        return 4;
    }
}
