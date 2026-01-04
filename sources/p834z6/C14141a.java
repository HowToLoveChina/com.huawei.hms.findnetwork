package p834z6;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.drive.cloudphoto.model.BabyInfo;
import com.huawei.android.p069cg.R$dimen;
import com.huawei.android.p069cg.R$drawable;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$string;
import com.huawei.cloud.base.util.C4644l;
import java.util.Date;
import java.util.List;
import p031b7.C1140u;
import p336he.C10159j;
import p471m6.C11415a;
import p514o9.C11842p;
import p546p6.C12091d;

/* renamed from: z6.a */
/* loaded from: classes2.dex */
public class C14141a extends RecyclerView.AbstractC0838h {

    /* renamed from: d */
    public final LayoutInflater f63221d;

    /* renamed from: e */
    public final Context f63222e;

    /* renamed from: f */
    public List<C11415a> f63223f;

    /* renamed from: g */
    public View.OnClickListener f63224g;

    /* renamed from: z6.a$a */
    public static class a extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public TextView f63225u;

        /* renamed from: v */
        public ImageView f63226v;

        /* renamed from: w */
        public TextView f63227w;

        /* renamed from: x */
        public TextView f63228x;

        /* renamed from: y */
        public RadioButton f63229y;

        public a(View view) {
            super(view);
            this.f63225u = (TextView) view.findViewById(R$id.album_name);
            this.f63227w = (TextView) view.findViewById(R$id.album_time);
            this.f63226v = (ImageView) view.findViewById(R$id.share_tab_item_img);
            this.f63229y = (RadioButton) view.findViewById(R$id.album_radio);
            View viewFindViewById = view.findViewById(R$id.swith_item_tag);
            if (viewFindViewById instanceof TextView) {
                this.f63228x = (TextView) viewFindViewById;
            }
        }
    }

    public C14141a(Context context, View.OnClickListener onClickListener) {
        this.f63224g = onClickListener;
        this.f63221d = LayoutInflater.from(context);
        this.f63222e = context;
    }

    /* renamed from: D */
    public void m84905D(List<C11415a> list) {
        if (this.f63222e == null) {
            return;
        }
        this.f63223f = list;
        m5213j();
    }

    /* renamed from: E */
    public final String m84906E(C11415a c11415a, String str) {
        BabyInfo babyInfo = c11415a.m68362a().getBabyInfo();
        if (babyInfo == null) {
            return this.f63222e.getString(R$string.album_create_time, str);
        }
        C4644l birthday = babyInfo.getBirthday();
        return birthday != null ? C12091d.m72280a0().m72332U(this.f63222e, System.currentTimeMillis(), birthday.m28458c()) : "";
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        List<C11415a> list = this.f63223f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: f */
    public long mo722f(int i10) {
        return super.mo722f(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: s */
    public void mo723s(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) {
        if (abstractC0833c0 instanceof a) {
            a aVar = (a) abstractC0833c0;
            C11415a c11415a = this.f63223f.get(i10);
            aVar.f63225u.setText(c11415a.m68362a().getAlbumName());
            if (c11415a.m68362a().getShareType().intValue() == 1) {
                C1140u.m7200l(this.f63222e, c11415a.m68362a(), aVar.f63226v);
            } else if (!TextUtils.isEmpty(c11415a.m68362a().getCoverImage())) {
                C12091d.m72280a0().m72396x(c11415a.m68362a(), c11415a.m68362a().getCoverImage(), aVar.f63226v);
            } else if (!C12091d.m72280a0().m72302E(c11415a.m68362a(), aVar.f63226v)) {
                aVar.f63226v.setImageDrawable(this.f63222e.getDrawable(R$drawable.ic_share_album_tab_default));
            }
            boolean z10 = c11415a.m68362a().getShareType().intValue() == 1;
            String strM63334j = C10159j.m63334j(new Date(c11415a.m68362a().getCreatedTime().m28458c()));
            aVar.f63229y.setOnClickListener(this.f63224g);
            aVar.f63229y.setTag(Integer.valueOf(i10));
            Resources resources = this.f63222e.getResources();
            int iM70758Q = C11842p.m70758Q(this.f63222e);
            if (resources != null) {
                iM70758Q = (((iM70758Q - (resources.getDimensionPixelOffset(R$dimen.cloud_space_20_dp) * 2)) - resources.getDimensionPixelOffset(R$dimen.cloud_space_64_dp)) - resources.getDimensionPixelOffset(R$dimen.cloud_space_12_dp)) - resources.getDimensionPixelOffset(R$dimen.cloud_space_40_dp);
            }
            if (z10) {
                TextPaint paint = aVar.f63228x.getPaint();
                aVar.f63228x.setText(c11415a.m68367f());
                int desiredWidth = (iM70758Q - ((int) Layout.getDesiredWidth(c11415a.m68367f(), 0, c11415a.m68367f().length(), paint))) - resources.getDimensionPixelSize(R$dimen.cloud_space_12_dp);
                aVar.f63227w.setText(m84906E(c11415a, strM63334j));
                aVar.f63225u.setMaxWidth(desiredWidth);
                aVar.f63228x.setVisibility(0);
            } else {
                aVar.f63225u.setMaxWidth(iM70758Q);
                aVar.f63227w.setText(this.f63222e.getString(R$string.album_create_time, strM63334j));
                aVar.f63228x.setVisibility(8);
            }
            if (i10 == 0) {
                aVar.f63229y.setChecked(true);
            } else {
                aVar.f63229y.setChecked(false);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: u */
    public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
        return new a(this.f63221d.inflate(R$layout.album_switch_item, viewGroup, false));
    }
}
