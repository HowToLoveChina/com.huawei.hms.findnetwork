package com.huawei.android.p069cg.p071ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.location.p065a.C1529a;
import com.huawei.android.hicloud.album.service.p075vo.DayModeGroup;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.bean.MediaFileBean;
import com.huawei.android.p069cg.p071ui.RecyclerMediaAdapter;
import com.huawei.cloud.base.util.C4644l;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import p009a8.C0069g;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1132m;
import p031b7.C1138s;
import p336he.C10159j;
import p514o9.C11842p;
import p546p6.C12091d;

/* loaded from: classes2.dex */
public class EmptyLoadRecyclerMediaAdapter extends RecyclerMediaAdapter implements View.OnClickListener {

    /* renamed from: s */
    public Handler f11165s;

    /* renamed from: r */
    public int f11164r = 0;

    /* renamed from: t */
    public String f11166t = null;

    /* renamed from: u */
    public int f11167u = -1;

    /* renamed from: v */
    public int f11168v = -1;

    /* renamed from: w */
    public boolean f11169w = true;

    /* renamed from: x */
    public boolean f11170x = false;

    /* renamed from: y */
    public boolean f11171y = false;

    public EmptyLoadRecyclerMediaAdapter(Context context) {
        this.f11221e = context;
        this.f11220d = LayoutInflater.from(context);
    }

    /* renamed from: A0 */
    public int m14687A0() {
        return this.f11164r;
    }

    /* renamed from: B0 */
    public String m14688B0(String str, C4644l c4644l) {
        if (c4644l == null) {
            C1120a.m6678w("EmptyLoadRecyclerMediaAdapter", "dateTime is null");
            return null;
        }
        try {
            C1120a.m6675d("EmptyLoadRecyclerMediaAdapter", "transDateTypeList toadyStr " + C10159j.m63325a(C0213f.m1377a(), System.currentTimeMillis(), C11842p.m70828k()));
            Calendar calendar = Calendar.getInstance();
            calendar.set(6, calendar.get(6) + (-1));
            C1120a.m6675d("EmptyLoadRecyclerMediaAdapter", "transDateTypeList yesterDayStr " + C10159j.m63325a(C0213f.m1377a(), calendar.getTimeInMillis(), C11842p.m70828k()));
            return C12091d.m72280a0().m72332U(C0213f.m1377a(), new SimpleDateFormat(C1529a.f6579e).parse(str).getTime(), c4644l.m28458c());
        } catch (Exception e10) {
            C1120a.m6676e("EmptyLoadRecyclerMediaAdapter", "getWordsTitle error: " + e10.getMessage());
            return str;
        }
    }

    /* renamed from: C0 */
    public String m14689C0(String str) {
        try {
            String strM63325a = C10159j.m63325a(C0213f.m1377a(), System.currentTimeMillis(), C11842p.m70828k());
            C1120a.m6675d("EmptyLoadRecyclerMediaAdapter", "transDateTypeList toadyStr " + strM63325a);
            Calendar calendar = Calendar.getInstance();
            calendar.set(6, calendar.get(6) + (-1));
            String strM63325a2 = C10159j.m63325a(C0213f.m1377a(), calendar.getTimeInMillis(), C11842p.m70828k());
            C1120a.m6675d("EmptyLoadRecyclerMediaAdapter", "transDateTypeList yesterDayStr " + strM63325a2);
            String strM63325a3 = C10159j.m63325a(C0213f.m1377a(), new SimpleDateFormat(C1529a.f6579e).parse(str).getTime(), C11842p.m70828k());
            if (strM63325a3.equals(strM63325a)) {
                strM63325a3 = this.f11221e.getString(R$string.main_today);
            }
            return strM63325a2.equals(strM63325a3) ? this.f11221e.getString(R$string.main_yesterday) : strM63325a3;
        } catch (Exception e10) {
            C1120a.m6676e("EmptyLoadRecyclerMediaAdapter", "getWordsTitle error: " + e10.getMessage());
            return str;
        }
    }

    /* renamed from: D0 */
    public boolean mo14690D0(int i10) {
        Object objM14761R = m14761R(i10);
        if (!(objM14761R instanceof RecyclerMediaAdapter.C2356h)) {
            return false;
        }
        C12091d.m72280a0().m72329S0(this.f11221e, this.f11165s, ((RecyclerMediaAdapter.C2356h) objM14761R).m14794c(), this.f11166t);
        return true;
    }

    /* renamed from: E */
    public final void m14691E(RecyclerMediaAdapter.C2356h c2356h, RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) throws Resources.NotFoundException, IllegalArgumentException {
        C1120a.m6677i("EmptyLoadRecyclerMediaAdapter", "bindPictureViewHolder, position = " + i10);
        RecyclerMediaAdapter.C2357i c2357i = (RecyclerMediaAdapter.C2357i) abstractC0833c0;
        c2357i.f4327a.setTag(Integer.valueOf(i10));
        c2357i.f4327a.setOnClickListener(this);
        m14773j0(c2357i);
        mo14684M0(c2356h.m14794c(), i10);
        StringBuilder sb2 = new StringBuilder();
        String str = this.f11166t;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        sb2.append(str);
        if (this.f11170x) {
            str2 = "share_home_picture";
        } else if (this.f11171y) {
            str2 = "share_home_vedio";
        }
        sb2.append(str2);
        sb2.append(c2356h.m14794c());
        String string = sb2.toString();
        C1120a.m6677i("EmptyLoadRecyclerMediaAdapter", "bindPictureViewHolder, position = " + i10 + ", mediaFileBean null, positionUniqueId=" + string);
        if (C1132m.m6921c().m6924d(string) != null) {
            C1120a.m6677i("EmptyLoadRecyclerMediaAdapter", "bindPictureViewHolder, position = " + i10 + ", media not null");
            c2356h.m14795d(C1132m.m6921c().m6925e(string));
        }
        if (c2356h.m14792a() != null) {
            m14697J0(c2356h, c2357i);
            mo14686W(c2356h, c2357i, i10);
            return;
        }
        C1120a.m6677i("EmptyLoadRecyclerMediaAdapter", "bindPictureViewHolder, position = " + i10 + ", thumbsHolder.imageIcon.setImageDrawable null");
        c2357i.f11261u.setImageDrawable(null);
        c2357i.f11263w.setVisibility(8);
    }

    /* renamed from: E0 */
    public void m14692E0(List<DayModeGroup> list, int i10) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.f11232p = i10;
        this.f11224h.clear();
        int i11 = 0;
        for (DayModeGroup dayModeGroup : list) {
            String strM14689C0 = m14689C0(dayModeGroup.getDayMode());
            for (int i12 = 0; i12 < dayModeGroup.getCount(); i12++) {
                RecyclerMediaAdapter.C2356h c2356h = new RecyclerMediaAdapter.C2356h();
                c2356h.m14799h(i11);
                c2356h.m14798g(i12);
                i11++;
                c2356h.m14796e(dayModeGroup.getDayMode());
                c2356h.m14797f(strM14689C0);
                this.f11224h.add(c2356h);
            }
        }
        this.f11164r = i11;
        C1120a.m6677i("EmptyLoadRecyclerMediaAdapter", "refreshNoDataNoTitleRecentCardList success");
        m5213j();
    }

    /* renamed from: F0 */
    public void m14693F0(List<DayModeGroup> list, int i10, C4644l c4644l) {
        if (list == null || list.size() == 0) {
            C1120a.m6677i("EmptyLoadRecyclerMediaAdapter", "refreshNoDataTitleRecentCardList empty success");
            this.f11224h.clear();
            m5213j();
            return;
        }
        this.f11232p = i10;
        this.f11224h.clear();
        int i11 = 0;
        for (DayModeGroup dayModeGroup : list) {
            RecyclerMediaAdapter.C2358j c2358j = new RecyclerMediaAdapter.C2358j();
            String dayMode = dayModeGroup.getDayMode();
            String strM14689C0 = m14689C0(dayMode);
            String strM14688B0 = m14688B0(dayMode, c4644l);
            c2358j.m14806f(strM14689C0);
            if (m14763X()) {
                c2358j.m14806f(strM14688B0);
                c2358j.m14805e(strM14689C0);
                c2358j.m14804d(true);
            } else {
                c2358j.m14806f(strM14689C0);
            }
            this.f11224h.add(c2358j);
            for (int i12 = 0; i12 < dayModeGroup.getCount(); i12++) {
                RecyclerMediaAdapter.C2356h c2356h = new RecyclerMediaAdapter.C2356h();
                c2356h.m14799h(i11);
                c2356h.m14798g(i12);
                i11++;
                c2356h.m14796e(dayModeGroup.getDayMode());
                this.f11224h.add(c2356h);
            }
        }
        this.f11164r = i11;
        C1120a.m6677i("EmptyLoadRecyclerMediaAdapter", "refreshNoDataTitleRecentCardList success");
        m5213j();
    }

    /* renamed from: G0 */
    public void m14694G0(List<DayModeGroup> list, int i10, String str) {
        if (list == null || list.size() == 0) {
            C1120a.m6677i("EmptyLoadRecyclerMediaAdapter", "refreshNoDataTitleRecentCardList empty success");
            this.f11224h.clear();
            m5213j();
            return;
        }
        this.f11232p = i10;
        this.f11224h.clear();
        if (4 == i10) {
            this.f11224h.add(new RecyclerMediaAdapter.C2355g(str));
        }
        int i11 = 0;
        for (DayModeGroup dayModeGroup : list) {
            RecyclerMediaAdapter.C2358j c2358j = new RecyclerMediaAdapter.C2358j();
            String strM14689C0 = m14689C0(dayModeGroup.getDayMode());
            c2358j.m14806f(strM14689C0);
            this.f11224h.add(c2358j);
            for (int i12 = 0; i12 < dayModeGroup.getCount(); i12++) {
                RecyclerMediaAdapter.C2356h c2356h = new RecyclerMediaAdapter.C2356h();
                c2356h.m14799h(i11);
                c2356h.m14798g(i12);
                i11++;
                c2356h.m14796e(dayModeGroup.getDayMode());
                c2356h.m14797f(strM14689C0);
                this.f11224h.add(c2356h);
            }
        }
        this.f11164r = i11;
        C1120a.m6677i("EmptyLoadRecyclerMediaAdapter", "refreshNoDataTitleRecentCardList success");
        m5213j();
    }

    /* renamed from: H0 */
    public void m14695H0() {
        this.f11169w = true;
        this.f11167u = -1;
        this.f11168v = -1;
    }

    /* renamed from: I0 */
    public void m14696I0(String str) {
        this.f11166t = str;
    }

    /* renamed from: J0 */
    public void m14697J0(RecyclerMediaAdapter.C2356h c2356h, RecyclerMediaAdapter.C2357i c2357i) throws IllegalArgumentException {
        MediaFileBean mediaFileBeanM14792a = c2356h.m14792a();
        if (mediaFileBeanM14792a == null) {
            return;
        }
        Media mediaM14352t = mediaFileBeanM14792a.m14352t();
        Bitmap bitmapM14750V = null;
        if (mediaM14352t != null) {
            Object tag = c2357i.f11261u.getTag();
            if (tag != null && String.valueOf(tag).equals(mediaFileBeanM14792a.m14306A())) {
                C1120a.m6677i("EmptyLoadRecyclerMediaAdapter", "bindPictureViewHolder, tagObj equal");
                return;
            }
            C1120a.m6677i("EmptyLoadRecyclerMediaAdapter", "bindPictureViewHolder, tagObj not equal");
            c2357i.f11261u.setTag(mediaFileBeanM14792a.m14306A());
            C1120a.m6677i("EmptyLoadRecyclerMediaAdapter", "bindPictureViewHolder, realMedia not null");
            Bitmap bitmapM7184c = C1138s.m7181d().m7184c(C0069g.m479y().m480A(mediaM14352t));
            if (!TextUtils.isEmpty(mediaM14352t.getId()) && bitmapM7184c == null) {
                C1120a.m6677i("EmptyLoadRecyclerMediaAdapter", "media id ok, get cache with id");
                bitmapM7184c = C1138s.m7181d().m7184c(mediaM14352t.getId());
            }
            if (bitmapM7184c == null) {
                C1120a.m6677i("EmptyLoadRecyclerMediaAdapter", "bitMapCache is null, start get thumb");
                c2357i.f11261u.setImageDrawable(null);
                c2357i.f11263w.setVisibility(8);
                bitmapM14750V = m14770e0(mediaM14352t, mediaFileBeanM14792a, c2357i.f11261u);
            } else {
                bitmapM14750V = bitmapM7184c;
            }
        } else {
            C1120a.m6676e("EmptyLoadRecyclerMediaAdapter", "realMedia is null, perhaps native pic");
            if (mediaFileBeanM14792a.m14338j() == 2) {
                bitmapM14750V = RecyclerMediaAdapter.m14747Q(this.f11221e, mediaFileBeanM14792a.m14327d());
            } else if (mediaFileBeanM14792a.m14338j() == 3) {
                bitmapM14750V = RecyclerMediaAdapter.m14750V(this.f11221e, mediaFileBeanM14792a.m14327d());
            }
        }
        if (bitmapM14750V != null) {
            C1120a.m6677i("EmptyLoadRecyclerMediaAdapter", "bindPictureViewHolder cache exist, use cache");
            if (mediaM14352t == null || TextUtils.isEmpty(mediaM14352t.getId())) {
                c2357i.f11261u.setTag(Long.valueOf(mediaFileBeanM14792a.m14327d()));
            } else {
                C1120a.m6675d("EmptyLoadRecyclerMediaAdapter", "realMedia id is not null");
                c2357i.f11261u.setTag(mediaM14352t.getId());
            }
            c2357i.f11261u.setImageDrawable(new BitmapDrawable(bitmapM14750V));
        }
        if (mediaFileBeanM14792a.m14338j() == 3 || mediaFileBeanM14792a.m14338j() == 5) {
            C1120a.m6675d("EmptyLoadRecyclerMediaAdapter", "start set videoDuration");
            c2357i.f11264x.setTag(mediaFileBeanM14792a.m14333g().toString());
            RecyclerMediaAdapter.m14751g0(mediaFileBeanM14792a, c2357i.f11264x);
        }
    }

    /* renamed from: K0 */
    public void m14698K0(boolean z10) {
        this.f11169w = z10;
    }

    /* renamed from: L0 */
    public void m14699L0(Handler handler) {
        this.f11165s = handler;
    }

    /* renamed from: M0 */
    public void mo14684M0(int i10, int i11) {
        if (this.f11169w) {
            int i12 = this.f11167u;
            if (i12 == -1 || i10 - i12 > C1122c.f5363q) {
                C1120a.m6677i("EmptyLoadRecyclerMediaAdapter", "bindPictureViewHolder for lastStart, position = " + i11 + ", queryMediaDataFromPicTab");
                C12091d.m72280a0().m72327R0(this.f11221e, this.f11165s, i10, this.f11166t);
                this.f11167u = i10;
                this.f11168v = i10 + C1122c.f5363q;
                return;
            }
            return;
        }
        int i13 = this.f11168v;
        if (i13 == -1 || i13 - i10 > C1122c.f5363q) {
            C1120a.m6677i("EmptyLoadRecyclerMediaAdapter", "bindPictureViewHolder for lastEnd, position = " + i11 + ", queryMediaDataFromPicTab");
            C12091d.m72280a0().m72327R0(this.f11221e, this.f11165s, i10, this.f11166t);
            this.f11168v = i10;
            this.f11167u = i10 - C1122c.f5363q;
        }
    }

    @Override // com.huawei.android.p069cg.p071ui.RecyclerMediaAdapter, androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: s */
    public void mo723s(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) throws Resources.NotFoundException, IllegalArgumentException {
        Object objM14761R = m14761R(i10);
        if ((objM14761R instanceof RecyclerMediaAdapter.C2358j) && (abstractC0833c0 instanceof RecyclerMediaAdapter.C2359k)) {
            m14754F((RecyclerMediaAdapter.C2358j) objM14761R, abstractC0833c0, i10);
        } else if ((objM14761R instanceof RecyclerMediaAdapter.C2356h) && (abstractC0833c0 instanceof RecyclerMediaAdapter.C2357i)) {
            m14691E((RecyclerMediaAdapter.C2356h) objM14761R, abstractC0833c0, i10);
        } else {
            super.mo723s(abstractC0833c0, i10);
        }
    }

    @Override // com.huawei.android.p069cg.p071ui.RecyclerMediaAdapter, androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: u */
    public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
        C1120a.m6675d("EmptyLoadRecyclerMediaAdapter", "onCreateViewHolder");
        return i10 != 1 ? i10 != 2 ? i10 != 9 ? super.mo724u(viewGroup, i10) : m14756H(viewGroup) : mo14685I(viewGroup) : m14757J(viewGroup);
    }

    /* renamed from: z0 */
    public String m14700z0(String str) {
        try {
            C1120a.m6675d("EmptyLoadRecyclerMediaAdapter", "transDateTypeList toadyStr " + C10159j.m63325a(C0213f.m1377a(), System.currentTimeMillis(), C11842p.m70828k()));
            Calendar calendar = Calendar.getInstance();
            calendar.set(6, calendar.get(6) + (-1));
            C1120a.m6675d("EmptyLoadRecyclerMediaAdapter", "transDateTypeList yesterDayStr " + C10159j.m63325a(C0213f.m1377a(), calendar.getTimeInMillis(), C11842p.m70828k()));
            return C10159j.m63325a(C0213f.m1377a(), new SimpleDateFormat(C1529a.f6579e).parse(str).getTime(), C11842p.m70828k());
        } catch (Exception e10) {
            C1120a.m6676e("EmptyLoadRecyclerMediaAdapter", "getWordsTitle error: " + e10.getMessage());
            return str;
        }
    }
}
