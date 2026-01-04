package wf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.remotecontrol.p093ui.widget.ListItemPatterm;
import com.huawei.android.remotecontrol.sdk.R$drawable;
import com.huawei.android.remotecontrol.sdk.R$id;
import com.huawei.android.remotecontrol.sdk.R$layout;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.android.remotecontrol.sharing.bean.SharingMemberItem;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import p015ak.C0209d;
import p514o9.C11842p;
import p521og.C11881n;
import p809yg.C13981a;
import sk.C12809f;

/* renamed from: wf.h */
/* loaded from: classes4.dex */
public class C13603h extends RecyclerView.AbstractC0838h<RecyclerView.AbstractC0833c0> {

    /* renamed from: d */
    public List<SharingMemberItem> f61175d;

    /* renamed from: e */
    public InterfaceC13596a f61176e;

    /* renamed from: g */
    public final Context f61178g;

    /* renamed from: j */
    public boolean f61181j;

    /* renamed from: h */
    public int f61179h = 0;

    /* renamed from: i */
    public int f61180i = 0;

    /* renamed from: f */
    public List<WeakReference<TextView>> f61177f = new ArrayList();

    /* renamed from: wf.h$a */
    public static class a extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public LinearLayout f61182u;

        public a(View view) {
            super(view);
            this.f61182u = (LinearLayout) C12809f.m76831d(view, R$id.add_friend_container);
        }
    }

    /* renamed from: wf.h$b */
    public class b extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public ListItemPatterm f61183u;

        /* renamed from: v */
        public TextView f61184v;

        public b(View view) {
            super(view);
            ListItemPatterm listItemPatterm = (ListItemPatterm) C12809f.m76831d(view, R$id.share_item);
            this.f61183u = listItemPatterm;
            TextView textView = (TextView) C12809f.m76831d(listItemPatterm, R$id.list_subtext);
            this.f61184v = textView;
            if (textView.getTag() == null) {
                C13603h.this.f61177f.add(new WeakReference(this.f61184v));
            }
        }
    }

    /* renamed from: wf.h$c */
    public static class c extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public RelativeLayout f61186u;

        public c(View view) {
            super(view);
            this.f61186u = (RelativeLayout) C12809f.m76831d(view, R$id.manager_container);
            if (C0209d.m1293p1()) {
                C13981a.m83989i("ShareManagerRecyclerAdapter", "isInkScreen, hide manageButton");
                C12809f.m76843p(this.f61186u, false);
            }
        }
    }

    /* renamed from: wf.h$d */
    public class d extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public ListItemPatterm f61187u;

        /* renamed from: v */
        public ImageView f61188v;

        /* renamed from: w */
        public TextView f61189w;

        public d(View view) {
            super(view);
            this.f61187u = (ListItemPatterm) C12809f.m76831d(view, R$id.share_friend_item);
            this.f61188v = (ImageView) C12809f.m76831d(view, R$id.delete_button);
            TextView textView = (TextView) C12809f.m76831d(this.f61187u, R$id.list_subtext);
            this.f61189w = textView;
            if (textView.getTag() == null) {
                C13603h.this.f61177f.add(new WeakReference(this.f61189w));
            }
        }
    }

    /* renamed from: wf.h$e */
    public static class e extends RecyclerView.AbstractC0833c0 {
        public e(View view) {
            super(view);
        }
    }

    /* renamed from: wf.h$f */
    public static class f extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public ListItemPatterm f61191u;

        public f(View view) {
            super(view);
            ListItemPatterm listItemPatterm = (ListItemPatterm) C12809f.m76831d(view, R$id.share_item);
            this.f61191u = listItemPatterm;
            listItemPatterm.setMinimumHeight(C11842p.m70840n(listItemPatterm.getContext(), 64));
            this.f61191u.setListSingleItemHeight();
        }
    }

    public C13603h(Context context, List<SharingMemberItem> list, boolean z10, InterfaceC13596a interfaceC13596a) {
        this.f61178g = context;
        this.f61175d = list;
        this.f61181j = z10;
        this.f61176e = interfaceC13596a;
    }

    /* renamed from: K */
    public final int m81760K(int i10) {
        return this.f61179h > 0 ? i10 - 3 : i10 - 2;
    }

    /* renamed from: L */
    public SharingMemberItem m81761L(int i10) {
        int i11 = this.f61179h;
        int i12 = 2;
        if (i11 > 0 && i10 - 2 >= i11) {
            i12 = i10 + (-3) >= i11 ? 3 : 0;
        }
        int i13 = i10 - i12;
        if (i13 < 0 || i13 >= this.f61175d.size()) {
            return null;
        }
        return this.f61175d.get(i13);
    }

    /* renamed from: M */
    public SharingMemberItem m81762M(int i10, int i11) {
        if (i11 != 2) {
            return this.f61175d.get(m81760K(i10));
        }
        if (this.f61179h > 0) {
            return this.f61175d.get(i10 - 2);
        }
        C13981a.m83989i("ShareManagerRecyclerAdapter", "getSharingMemberItemByIndex no family");
        return null;
    }

    /* renamed from: N */
    public List<WeakReference<TextView>> m81763N() {
        return this.f61177f;
    }

    /* renamed from: O */
    public final boolean m81764O(String str) {
        return Pattern.compile("[0-9]*").matcher(Pattern.compile("[*]").matcher(str).replaceAll("").trim()).matches();
    }

    /* renamed from: P */
    public final /* synthetic */ void m81765P(View view) {
        this.f61176e.mo26175a(view, 0, 5);
    }

    /* renamed from: Q */
    public final /* synthetic */ void m81766Q(int i10, CompoundButton compoundButton, boolean z10) {
        InterfaceC13596a interfaceC13596a = this.f61176e;
        if (interfaceC13596a == null) {
            C13981a.m83988e("ShareManagerRecyclerAdapter", "mListener is null");
        } else {
            interfaceC13596a.mo26171S(compoundButton, i10, 2, z10);
        }
    }

    /* renamed from: R */
    public final /* synthetic */ void m81767R(int i10, View view) {
        InterfaceC13596a interfaceC13596a = this.f61176e;
        if (interfaceC13596a == null) {
            C13981a.m83988e("ShareManagerRecyclerAdapter", "mListener is null");
        } else {
            interfaceC13596a.mo26175a(view, i10, 1);
        }
    }

    /* renamed from: S */
    public final /* synthetic */ void m81768S(int i10, CompoundButton compoundButton, boolean z10) {
        InterfaceC13596a interfaceC13596a = this.f61176e;
        if (interfaceC13596a == null) {
            C13981a.m83988e("ShareManagerRecyclerAdapter", "mListener is null");
        } else {
            interfaceC13596a.mo26171S(compoundButton, i10, 4, z10);
        }
    }

    /* renamed from: T */
    public final /* synthetic */ void m81769T(int i10, View view) {
        this.f61176e.mo26175a(view, i10, 4);
    }

    /* renamed from: U */
    public final /* synthetic */ void m81770U(int i10, CompoundButton compoundButton, boolean z10) {
        InterfaceC13596a interfaceC13596a = this.f61176e;
        if (interfaceC13596a == null) {
            C13981a.m83988e("ShareManagerRecyclerAdapter", "mListener is null");
        } else {
            interfaceC13596a.mo26171S(compoundButton, i10, 0, z10);
        }
    }

    /* renamed from: V */
    public void m81771V(int i10) {
        this.f61175d.remove(m81760K(i10));
        this.f61180i--;
        m5213j();
    }

    /* renamed from: W */
    public void m81772W() {
        this.f61179h = 0;
        this.f61180i = 0;
    }

    /* renamed from: X */
    public final void m81773X(a aVar) {
        aVar.f61182u.setOnClickListener(new View.OnClickListener() { // from class: wf.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f61164a.m81765P(view);
            }
        });
    }

    /* renamed from: Y */
    public final void m81774Y(b bVar, int i10) {
        int i11;
        int i12 = i10 - 1;
        if (i12 == 1 && this.f61179h > 1) {
            i11 = R$drawable.item_up_bg;
            bVar.f61183u.setListTopItemHeight();
        } else if (i12 == 1 && this.f61179h == 1) {
            i11 = R$drawable.item_single_bg;
            bVar.f61183u.setListSingleItemHeight();
        } else if (i12 <= 1 || i10 >= this.f61179h + 1) {
            i11 = R$drawable.item_down_bg;
            bVar.f61183u.setListBottomItemHeight();
        } else {
            i11 = R$drawable.item_no_corner_bg;
            bVar.f61183u.setListCenterItemHeight();
        }
        bVar.f61183u.setBackgroundResource(i11);
    }

    /* renamed from: Z */
    public final void m81775Z(b bVar, final int i10) {
        if (this.f61179h <= 0) {
            C13981a.m83989i("ShareManagerRecyclerAdapter", "setFamilyItemViewHolder,no family");
            return;
        }
        int i11 = i10 - 1;
        SharingMemberItem sharingMemberItem = this.f61175d.get(i10 - 2);
        if (sharingMemberItem.getMemberType() != 1) {
            C13981a.m83989i("ShareManagerRecyclerAdapter", "not family item:" + i10);
            return;
        }
        String strM71354d = C11881n.m71354d(this.f61178g, sharingMemberItem.getRemainingTime(), R$string.share_remain_time);
        bVar.f61183u.setMainLayoutMinHeight(strM71354d);
        bVar.f61183u.setSwitchListen(new CompoundButton.OnCheckedChangeListener() { // from class: wf.d
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                this.f61167a.m81766Q(i10, compoundButton, z10);
            }
        });
        String aliasName = sharingMemberItem.getAliasName();
        bVar.f61183u.setText(aliasName);
        if (m81764O(aliasName)) {
            bVar.f61183u.setTextDirection(3);
            bVar.f61183u.setTextAlignment(5);
        }
        bVar.f61184v.setTag(Integer.valueOf(i10));
        bVar.f61183u.initSubText((sharingMemberItem.getRemainingTime() == -1 || sharingMemberItem.getRemainingTime() == Long.MAX_VALUE) ? false : true, strM71354d);
        bVar.f61183u.setEnabled(true);
        bVar.f61183u.setSwitchStatus(sharingMemberItem.isSharingOpen());
        if (i11 == this.f61179h) {
            bVar.f61183u.setDiliverBottomVisible(false);
            bVar.f61183u.setDiliverAboveVisible(false);
        } else {
            bVar.f61183u.setDiliverBottomVisible(true);
        }
        m81774Y(bVar, i10);
    }

    /* renamed from: a0 */
    public final void m81776a0(c cVar, final int i10) {
        cVar.f61186u.setOnClickListener(new View.OnClickListener() { // from class: wf.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f61165a.m81767R(i10, view);
            }
        });
    }

    /* renamed from: b0 */
    public final void m81777b0(d dVar, int i10) {
        int i11;
        int i12 = this.f61179h;
        if (i12 > 0) {
            i10 = (i10 - 1) - i12;
        }
        int i13 = i10 - 2;
        if (i13 == 0 && this.f61180i > 1) {
            i11 = R$drawable.item_up_bg;
            dVar.f61187u.setListTopItemHeight();
        } else if (i13 == 0 && this.f61180i == 1) {
            i11 = R$drawable.item_single_bg;
            dVar.f61187u.setListSingleItemHeight();
        } else if (i13 <= 0 || i13 >= this.f61180i - 1) {
            i11 = R$drawable.item_down_bg;
            dVar.f61187u.setListBottomItemHeight();
        } else {
            i11 = R$drawable.item_no_corner_bg;
            dVar.f61187u.setListCenterItemHeight();
        }
        dVar.f61187u.setBackgroundResource(i11);
    }

    /* renamed from: c0 */
    public final void m81778c0(d dVar, final int i10) {
        if (this.f61180i <= 0) {
            C13981a.m83989i("ShareManagerRecyclerAdapter", "setFriendItemViewHolder,no family");
            return;
        }
        int iM81760K = m81760K(i10);
        SharingMemberItem sharingMemberItem = this.f61175d.get(iM81760K);
        if (sharingMemberItem.getMemberType() != 2) {
            C13981a.m83989i("ShareManagerRecyclerAdapter", "not friend item:" + i10);
            return;
        }
        String strM71354d = C11881n.m71354d(this.f61178g, sharingMemberItem.getRemainingTime(), R$string.share_remain_time);
        dVar.f61187u.setMainLayoutMinHeight(strM71354d);
        dVar.f61187u.setSwitchListen(new CompoundButton.OnCheckedChangeListener() { // from class: wf.f
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                this.f61171a.m81768S(i10, compoundButton, z10);
            }
        });
        dVar.f61188v.setOnClickListener(new View.OnClickListener() { // from class: wf.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f61173a.m81769T(i10, view);
            }
        });
        String aliasName = sharingMemberItem.getAliasName();
        dVar.f61187u.setText(aliasName);
        if (m81764O(aliasName)) {
            dVar.f61187u.setTextDirection(3);
            dVar.f61187u.setTextAlignment(5);
        }
        dVar.f61189w.setTag(Integer.valueOf(i10));
        dVar.f61187u.initSubText((sharingMemberItem.getRemainingTime() == -1 || sharingMemberItem.getRemainingTime() == Long.MAX_VALUE) ? false : true, strM71354d);
        dVar.f61187u.setEnabled(true);
        dVar.f61187u.setSwitchStatus(sharingMemberItem.isSharingOpen());
        if (iM81760K == this.f61175d.size() - 1) {
            dVar.f61187u.setDiliverBottomVisible(false);
            dVar.f61187u.setDiliverAboveVisible(false);
        } else {
            dVar.f61187u.setDiliverBottomVisible(true);
        }
        m81777b0(dVar, i10);
    }

    /* renamed from: d0 */
    public void m81779d0(List<SharingMemberItem> list) {
        this.f61175d = list;
        for (SharingMemberItem sharingMemberItem : list) {
            if (1 == sharingMemberItem.getMemberType()) {
                this.f61179h++;
            } else if (2 == sharingMemberItem.getMemberType()) {
                this.f61180i++;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        if (!this.f61181j) {
            return 1;
        }
        if (C0209d.m1205R0(this.f61175d)) {
            return 2;
        }
        int i10 = this.f61179h;
        int i11 = i10 > 0 ? i10 + 3 : 2;
        int i12 = this.f61180i;
        if (i12 > 0) {
            i11 += i12 + 1;
        }
        C13981a.m83987d("ShareManagerRecyclerAdapter", "memberItems count:" + i11);
        return i11;
    }

    /* renamed from: e0 */
    public final void m81780e0(f fVar, final int i10) {
        fVar.f61191u.setEnabled(true);
        fVar.f61191u.setSwitchStatus(this.f61181j);
        fVar.f61191u.setSwitchListen(new CompoundButton.OnCheckedChangeListener() { // from class: wf.e
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                this.f61169a.m81770U(i10, compoundButton, z10);
            }
        });
    }

    /* renamed from: f0 */
    public void m81781f0(boolean z10) {
        this.f61181j = z10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: g */
    public int mo749g(int i10) {
        if (i10 < 1) {
            return 0;
        }
        int i11 = this.f61179h;
        int i12 = i11 > 0 ? 1 : 0;
        int i13 = this.f61180i;
        int i14 = i13 > 0 ? i11 + i12 + 1 : 0;
        if (i10 == i12) {
            return 1;
        }
        if (i10 < i12 + i11 + 1) {
            return 2;
        }
        if (i10 == i14) {
            return 3;
        }
        if (i10 <= i14 || i10 >= i14 + i13 + 1) {
            return this.f61181j ? 5 : -1;
        }
        return 4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: s */
    public void mo723s(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) {
        C13981a.m83987d("ShareManagerRecyclerAdapter", "onBindViewHolder,position:" + i10);
        if (abstractC0833c0 instanceof f) {
            m81780e0((f) abstractC0833c0, i10);
        }
        if (abstractC0833c0 instanceof c) {
            m81776a0((c) abstractC0833c0, i10);
        }
        if (abstractC0833c0 instanceof b) {
            m81775Z((b) abstractC0833c0, i10);
        }
        if (abstractC0833c0 instanceof d) {
            m81778c0((d) abstractC0833c0, i10);
        }
        if (abstractC0833c0 instanceof a) {
            m81773X((a) abstractC0833c0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: u */
    public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
        C13981a.m83987d("ShareManagerRecyclerAdapter", "onCreateViewHolder,viewType:" + i10);
        if (i10 == 0) {
            View viewInflate = LayoutInflater.from(this.f61178g).inflate(R$layout.share_switch_item, viewGroup, false);
            viewInflate.setTag(0);
            return new f(viewInflate);
        }
        if (1 == i10) {
            View viewInflate2 = LayoutInflater.from(this.f61178g).inflate(R$layout.family_manage_title, viewGroup, false);
            viewInflate2.setTag(1);
            return new c(viewInflate2);
        }
        if (2 == i10) {
            View viewInflate3 = LayoutInflater.from(this.f61178g).inflate(R$layout.share_switch_item, viewGroup, false);
            viewInflate3.setTag(2);
            return new b(viewInflate3);
        }
        if (3 == i10) {
            View viewInflate4 = LayoutInflater.from(this.f61178g).inflate(R$layout.friends_title, viewGroup, false);
            viewInflate4.setTag(3);
            return new e(viewInflate4);
        }
        if (4 == i10) {
            View viewInflate5 = LayoutInflater.from(this.f61178g).inflate(R$layout.share_friends_item, viewGroup, false);
            viewInflate5.setTag(4);
            return new d(viewInflate5);
        }
        View viewInflate6 = LayoutInflater.from(this.f61178g).inflate(R$layout.add_friend_item, viewGroup, false);
        viewInflate6.setTag(5);
        return new a(viewInflate6);
    }
}
