package com.huawei.android.p069cg.activity.fragment;

import com.huawei.android.p069cg.activity.fragment.AlbumFileViewFragment;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.util.ArrayList;
import p031b7.C1120a;
import p031b7.C1132m;

/* loaded from: classes2.dex */
public class PicTabAlbumFileViewFragment extends AlbumFileViewFragment {

    /* renamed from: k0 */
    public int f10901k0 = 0;

    @Override // com.huawei.android.p069cg.activity.fragment.AlbumFileViewFragment
    /* renamed from: B0 */
    public void mo14138B0() {
        SafeIntent safeIntent = new SafeIntent(getActivity().getIntent());
        String stringExtra = safeIntent.getStringExtra("param_album_id");
        this.f10790g = stringExtra;
        if (stringExtra == null || stringExtra.equals("album_id_normal_full")) {
            this.f10790g = "";
        }
        this.f10901k0 = safeIntent.getIntExtra("param_is_viewer_sum_number", 0);
        this.f10794i = safeIntent.getBooleanExtra("param_is_only_pic", false);
        this.f10796j = safeIntent.getBooleanExtra("param_is_only_video", false);
        this.f10798k = new ArrayList();
        for (int i10 = 0; i10 < this.f10901k0; i10++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f10790g);
            sb2.append(this.f10794i ? "share_home_picture" : this.f10796j ? "share_home_vedio" : "");
            sb2.append(i10);
            String string = sb2.toString();
            if (C1132m.m6921c().m6924d(string) != null) {
                this.f10798k.add(C1132m.m6921c().m6925e(string));
            } else {
                this.f10798k.add(null);
            }
        }
        C1120a.m6677i("PicTabAlbumFileViewFragment", "initDataAndEvent end");
    }

    @Override // com.huawei.android.p069cg.activity.fragment.AlbumFileViewFragment, android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f10798k.clear();
    }

    @Override // com.huawei.android.p069cg.activity.fragment.AlbumFileViewFragment
    /* renamed from: t0 */
    public void mo14190t0(AlbumFileViewFragment.ViewOnClickListenerC2266j.d dVar) {
    }
}
