package com.huawei.android.p069cg.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.C0867f;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.album.service.p075vo.DayModeGroup;
import com.huawei.android.hicloud.album.service.p075vo.GalleryAlbum;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.p071ui.EmptyLoadNormalRecyclerMediaAdapter;
import com.huawei.android.p069cg.p071ui.EmptyLoadRecyclerMediaAdapter;
import com.huawei.android.p069cg.p071ui.ImagesGridView;
import com.huawei.android.p069cg.p071ui.RecyclerMediaAdapter;
import com.huawei.android.p069cg.utils.scrollbar.C2387a;
import com.huawei.android.p069cg.utils.scrollbar.FMScrollBar;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.secure.android.common.intent.SafeIntent;
import fk.C9721b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p020ap.C1006a;
import p031b7.C1120a;
import p031b7.C1122c;
import p471m6.C11419e;
import p471m6.C11420f;
import p471m6.C11425k;
import p514o9.C11842p;
import p546p6.C12091d;
import p581qk.AbstractC12367d;
import p604r7.C12473f;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p684un.C13224c;
import p684un.C13230i;
import p709vj.C13452e;
import p783xp.C13843a;
import p850zo.InterfaceC14351b;
import sk.C12809f;

/* loaded from: classes2.dex */
public class PicTabPresenter extends AlbumManagerBasePresenter implements View.OnClickListener {

    /* renamed from: b */
    public final Context f10259b;

    /* renamed from: c */
    public final Activity f10260c;

    /* renamed from: d */
    public TextView f10261d;

    /* renamed from: e */
    public TextView f10262e;

    /* renamed from: f */
    public SpanClickText f10263f;

    /* renamed from: g */
    public ImagesGridView f10264g;

    /* renamed from: h */
    public FMScrollBar f10265h;

    /* renamed from: i */
    public LinearLayout f10266i;

    /* renamed from: j */
    public LinearLayout f10267j;

    /* renamed from: k */
    public LinearLayout f10268k;

    /* renamed from: l */
    public EmptyLoadNormalRecyclerMediaAdapter f10269l;

    /* renamed from: m */
    public TextView f10270m;

    /* renamed from: n */
    public LinearLayout f10271n;

    /* renamed from: o */
    public TextView f10272o;

    /* renamed from: p */
    public boolean f10273p;

    /* renamed from: q */
    public boolean f10274q;

    /* renamed from: r */
    public View f10275r;

    /* renamed from: s */
    public Handler f10276s;

    /* renamed from: t */
    public Handler f10277t;

    /* renamed from: u */
    public GridLayoutManager f10278u;

    /* renamed from: v */
    public String f10279v;

    /* renamed from: w */
    public RecyclerMediaAdapter.InterfaceC2353e f10280w;

    /* renamed from: x */
    public SpanClickText.ISpanClickListener f10281x;

    /* renamed from: y */
    public SpanClickText.ISpanClickListener f10282y;

    /* renamed from: com.huawei.android.cg.activity.PicTabPresenter$a */
    public class C2208a implements RecyclerMediaAdapter.InterfaceC2353e {
        public C2208a() {
        }

        @Override // com.huawei.android.p069cg.p071ui.RecyclerMediaAdapter.InterfaceC2353e
        /* renamed from: a */
        public void mo13635a(View view, int i10) {
            if (C0209d.m1226Y0()) {
                C1120a.m6675d("PicTabPresenter", " do not fast click to show image");
                return;
            }
            Object objM14761R = PicTabPresenter.this.f10269l.m14761R(i10);
            if (objM14761R instanceof RecyclerMediaAdapter.C2356h) {
                RecyclerMediaAdapter.C2356h c2356h = (RecyclerMediaAdapter.C2356h) objM14761R;
                Intent intent = new Intent(PicTabPresenter.this.f10259b, (Class<?>) PicTabAlbumFileViewActivity.class);
                if (c2356h.m14792a() == null) {
                    C1120a.m6676e("PicTabPresenter", "data not ready");
                    return;
                }
                intent.putExtra("param_media_index", c2356h.m14794c());
                intent.putExtra("param_is_share_cloud_album", false);
                intent.putExtra("param_is_viewer_sum_number", PicTabPresenter.this.f10269l.m14687A0());
                intent.putExtra("param_album_id", "album_id_normal_full");
                PicTabPresenter.this.f10260c.startActivityForResult(intent, 306);
            }
        }

        @Override // com.huawei.android.p069cg.p071ui.RecyclerMediaAdapter.InterfaceC2353e
        /* renamed from: b */
        public void mo13636b(View view, int i10) {
        }
    }

    /* renamed from: com.huawei.android.cg.activity.PicTabPresenter$b */
    public class C2209b extends AbstractC12367d {

        /* renamed from: a */
        public WeakReference<EmptyLoadRecyclerMediaAdapter> f10284a;

        /* renamed from: b */
        public WeakReference<List> f10285b;

        public C2209b(EmptyLoadRecyclerMediaAdapter emptyLoadRecyclerMediaAdapter, List list) {
            this.f10284a = new WeakReference<>(emptyLoadRecyclerMediaAdapter);
            this.f10285b = new WeakReference<>(list);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C1120a.m6677i("PicTabPresenter", "start calculateDiff");
            EmptyLoadRecyclerMediaAdapter emptyLoadRecyclerMediaAdapter = this.f10284a.get();
            List list = this.f10285b.get();
            if (emptyLoadRecyclerMediaAdapter == null || list == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(emptyLoadRecyclerMediaAdapter.m14760M());
            List listM14748T = RecyclerMediaAdapter.m14748T(list, 4, emptyLoadRecyclerMediaAdapter);
            C0867f.e eVarM5478b = C0867f.m5478b(new C11419e(arrayList, listM14748T), true);
            Message messageObtainMessage = PicTabPresenter.this.f10276s.obtainMessage();
            messageObtainMessage.obj = new C11420f(listM14748T, eVarM5478b);
            messageObtainMessage.what = 1038;
            PicTabPresenter.this.f10276s.sendMessage(messageObtainMessage);
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.ALBUM_SHARE_UI;
        }
    }

    /* renamed from: com.huawei.android.cg.activity.PicTabPresenter$c */
    public class C2210c implements Handler.Callback {
        public C2210c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) throws Resources.NotFoundException {
            int i10 = message.what;
            if (i10 == 1) {
                C1120a.m6675d("PicTabPresenter", "scrollbar moved, paddingTop= " + message.arg1);
                PicTabPresenter.this.m13668I(message.arg1, (String) message.obj);
                return false;
            }
            if (i10 == 2) {
                C1120a.m6675d("PicTabPresenter", "set scrollbar visible");
                PicTabPresenter.this.m13667H();
                return false;
            }
            if (i10 == 3) {
                C1120a.m6675d("PicTabPresenter", "set scrollbar gone");
                PicTabPresenter.this.m13666G();
                return false;
            }
            if (i10 == 1034) {
                ArrayList arrayList = (ArrayList) message.obj;
                if (arrayList == null || arrayList.size() <= 0) {
                    return false;
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (((GalleryAlbum) it.next()).getUploadStatus().equals("0")) {
                        PicTabPresenter.this.m13671L(3);
                        return false;
                    }
                }
                return false;
            }
            if (i10 == 1044) {
                C1120a.m6675d("PicTabPresenter", "MSG_HANDLE_PIC_TAB_FMBAR_STOP");
                int iFindFirstVisibleItemPosition = PicTabPresenter.this.f10278u.findFirstVisibleItemPosition();
                int iFindLastVisibleItemPosition = PicTabPresenter.this.f10278u.findLastVisibleItemPosition();
                C1120a.m6675d("PicTabPresenter", "firstVisible = " + iFindFirstVisibleItemPosition);
                while (iFindFirstVisibleItemPosition >= 0 && iFindFirstVisibleItemPosition <= iFindLastVisibleItemPosition && !PicTabPresenter.this.f10269l.mo14690D0(iFindFirstVisibleItemPosition)) {
                    iFindFirstVisibleItemPosition++;
                }
                return false;
            }
            if (i10 != 4369) {
                return false;
            }
            PicTabPresenter.this.f10274q = message.getData().getBoolean("haveMediaFile");
            C1120a.m6675d("PicTabPresenter", "isExistLocalFile " + PicTabPresenter.this.f10274q);
            if (PicTabPresenter.this.f10274q) {
                PicTabPresenter.this.m13675p();
                return false;
            }
            PicTabPresenter.this.m13671L(2);
            return false;
        }

        public /* synthetic */ C2210c(PicTabPresenter picTabPresenter, C2208a c2208a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.cg.activity.PicTabPresenter$d */
    public class HandlerC2211d extends Handler {
        public HandlerC2211d() {
            super(PicTabPresenter.this.f9944a.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Resources.NotFoundException, IllegalArgumentException {
            int i10 = message.what;
            if (i10 == 1037) {
                List list = (List) message.obj;
                if (list.size() == 0) {
                    return;
                }
                C1120a.m6677i("PicTabPresenter", "start setDiffData");
                PicTabPresenter picTabPresenter = PicTabPresenter.this;
                C12515a.m75110o().m75175e(picTabPresenter.new C2209b(picTabPresenter.f10269l, list), true);
                return;
            }
            if (i10 == 1038) {
                C1120a.m6677i("PicTabPresenter", "start dispatchUpdatesTo");
                if (PicTabPresenter.this.f10272o.getVisibility() == 0) {
                    PicTabPresenter.this.f10272o.setVisibility(8);
                }
                C11420f c11420f = (C11420f) message.obj;
                c11420f.m68414a().m5495c(PicTabPresenter.this.f10269l);
                PicTabPresenter.this.f10269l.m14771f0(c11420f.m68415b());
                return;
            }
            if (i10 == 1042) {
                int iFindFirstVisibleItemPosition = PicTabPresenter.this.f10278u.findFirstVisibleItemPosition();
                int iFindLastVisibleItemPosition = PicTabPresenter.this.f10278u.findLastVisibleItemPosition();
                C1120a.m6675d("PicTabPresenter", "set pic, firstVisible = " + iFindFirstVisibleItemPosition + ", lastVisible = " + iFindLastVisibleItemPosition);
                while (iFindFirstVisibleItemPosition >= 0 && iFindFirstVisibleItemPosition <= iFindLastVisibleItemPosition) {
                    PicTabPresenter.this.f10269l.mo723s(PicTabPresenter.this.f10264g.findViewHolderForLayoutPosition(iFindFirstVisibleItemPosition), iFindFirstVisibleItemPosition);
                    iFindFirstVisibleItemPosition++;
                }
            }
        }
    }

    /* renamed from: com.huawei.android.cg.activity.PicTabPresenter$e */
    public class C2212e extends RecyclerView.AbstractC0850t {

        /* renamed from: c0 */
        public ImagesGridView f10289c0;

        /* renamed from: d0 */
        public int f10290d0;

        public C2212e(ImagesGridView imagesGridView) {
            this.f10289c0 = imagesGridView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0850t
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            super.onScrollStateChanged(recyclerView, i10);
            if (i10 != 0) {
                if (i10 == 1 || i10 == 2) {
                    C1120a.m6675d("PicTabPresenter", "scrolling, skip bind holder, curDy = " + this.f10290d0);
                    if (Math.abs(this.f10290d0) > 180) {
                        C1120a.m6675d("PicTabPresenter", "scrolling speed more than DY_SPEED");
                        return;
                    }
                    return;
                }
                return;
            }
            if (!this.f10289c0.canScrollVertically(-1)) {
                PicTabPresenter.this.f10267j.getVisibility();
                return;
            }
            if (this.f10289c0.canScrollVertically(1)) {
                return;
            }
            boolean zM74867d = C12473f.m74865c().m74867d();
            C1120a.m6675d("PicTabPresenter", "haveSyncComplete " + zM74867d);
            if (zM74867d) {
                C1120a.m6675d("PicTabPresenter", "haveSyncComplete  no data load more");
            } else if (PicTabPresenter.this.f10272o.getVisibility() == 0) {
                C1120a.m6675d("PicTabPresenter", "is loading more data");
            } else {
                PicTabPresenter.this.f10272o.setVisibility(0);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0850t
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            super.onScrolled(recyclerView, i10, i11);
            if (i11 < 0) {
                PicTabPresenter.this.f10269l.m14698K0(false);
            } else if (i11 > 0) {
                PicTabPresenter.this.f10269l.m14698K0(true);
            }
            this.f10290d0 = i11;
            C2387a.m14965i(PicTabPresenter.this.f10278u.findFirstVisibleItemPosition());
        }
    }

    public PicTabPresenter(AlbumManageActivity albumManageActivity) {
        super(albumManageActivity);
        this.f10273p = false;
        this.f10274q = false;
        this.f10280w = new C2208a();
        this.f10281x = new SpanClickText.ISpanClickListener() { // from class: k6.m
            @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
            public final void onClick() {
                this.f52067a.m13685z();
            }
        };
        this.f10282y = new SpanClickText.ISpanClickListener() { // from class: k6.n
            @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
            public final void onClick() {
                this.f52068a.m13660A();
            }
        };
        this.f10260c = albumManageActivity;
        this.f10259b = albumManageActivity;
        this.f10277t = new Handler(new C2210c(this, null));
        this.f10276s = new HandlerC2211d();
        m13682w();
    }

    private int getSpanCount() {
        return C11842p.m70771U0() ? C11842p.m70753O0(this.f10259b) ? 10 : 6 : C11842p.m70753O0(this.f10259b) ? 7 : 4;
    }

    /* renamed from: A */
    public final /* synthetic */ void m13660A() {
        C13224c.m79487f1().m79593q0("CLICK_PIC_TO_OPEN_ALBUM_SWITCH");
        m13678s();
    }

    /* renamed from: B */
    public void m13661B() {
        this.f10269l.m14775l0(getSpanCount());
        this.f10264g.setLayoutManager(this.f10278u);
        this.f10264g.setAdapter(this.f10269l);
        this.f10265h.m14922A();
        this.f10269l.m5213j();
    }

    /* renamed from: C */
    public void m13662C() {
        C1120a.m6675d("PicTabPresenter", "onPicListQueryFinish");
        List<DayModeGroup> listM72401z0 = C12091d.m72280a0().m72401z0("");
        this.f10269l.m14694G0(listM72401z0, 4, this.f10279v);
        boolean z10 = listM72401z0 == null || listM72401z0.size() == 0;
        this.f10268k.setVisibility(z10 ? 8 : 0);
        this.f10266i.setVisibility(z10 ? 0 : 8);
    }

    /* renamed from: D */
    public void m13663D(SafeIntent safeIntent) {
        String stringExtra = safeIntent.getStringExtra("param_pic_and_video_content");
        C1120a.m6675d("PicTabPresenter", "picAndViedoStr " + stringExtra);
        if (TextUtils.isEmpty(stringExtra)) {
            m13669J();
        } else {
            m13673N(stringExtra);
        }
    }

    /* renamed from: E */
    public void m13664E() {
        if (this.f10278u != null) {
            C12091d.m72280a0().m72327R0(this.f10259b, this.f10276s, this.f10278u.findFirstVisibleItemPosition(), "");
        }
    }

    /* renamed from: F */
    public void m13665F() {
        List<C11425k> listM72372o0 = C12091d.m72280a0().m72372o0();
        if (listM72372o0.size() == 0) {
            return;
        }
        this.f10269l.m14766a0(listM72372o0, 4);
        C12091d.m72280a0().m72380r();
        if (C0212e0.m1354d(C0213f.m1377a(), "sp_pic_tab_info", "key_pic_tab_show_all", true)) {
            this.f10272o.setVisibility(8);
        } else {
            this.f10272o.setVisibility(0);
        }
    }

    /* renamed from: G */
    public void m13666G() {
        this.f10271n.setVisibility(8);
    }

    /* renamed from: H */
    public void m13667H() {
        this.f10271n.setVisibility(0);
    }

    /* renamed from: I */
    public void m13668I(int i10, String str) {
        LinearLayout linearLayout = this.f10271n;
        linearLayout.setPadding(linearLayout.getPaddingStart(), i10, this.f10271n.getPaddingEnd(), this.f10271n.getPaddingBottom());
        if (str.isEmpty()) {
            return;
        }
        this.f10270m.setText(str);
    }

    /* renamed from: J */
    public final void m13669J() throws Resources.NotFoundException {
        if (this.f10273p) {
            m13676q();
        } else {
            m13671L(1);
        }
    }

    /* renamed from: K */
    public void m13670K() {
        this.f10267j.setVisibility(8);
    }

    /* renamed from: L */
    public void m13671L(int i10) throws Resources.NotFoundException {
        if (i10 == 1) {
            String string = this.f10259b.getResources().getString(R$string.click_to_open_sync);
            String string2 = this.f10259b.getResources().getString(R$string.sync_not_open, string);
            this.f10263f.m15931c(string, this.f10281x);
            this.f10263f.m15934g(string2, false);
            return;
        }
        if (i10 == 2) {
            this.f10263f.m15934g(this.f10259b.getResources().getString(R$string.no_photo_video), false);
        } else if (i10 == 3) {
            String string3 = this.f10259b.getResources().getString(R$string.click_to_open);
            String string4 = this.f10259b.getResources().getString(R$string.have_album_sync, string3);
            this.f10263f.m15931c(string3, this.f10282y);
            this.f10263f.m15934g(string4, false);
        }
    }

    /* renamed from: M */
    public void m13672M() {
        this.f10267j.setVisibility(0);
    }

    /* renamed from: N */
    public final void m13673N(String str) {
        setCloudPicDesc(str);
        if (this.f10273p) {
            m13670K();
            return;
        }
        long jM1359i = C0212e0.m1359i(this.f10259b, "sp_have_show_cloud_photo", "KEY_open_sync_guide", 0L);
        long jM1359i2 = C0212e0.m1359i(this.f10259b, "sp_have_show_cloud_photo", "key_show_next_guide_mills", 0L);
        int iM1357g = C0212e0.m1357g(this.f10259b, "sp_have_show_cloud_photo", "key_show_next_seven_day_times", 0);
        if (System.currentTimeMillis() - jM1359i >= jM1359i2) {
            m13672M();
            C0212e0.m1370t(this.f10259b, "sp_have_show_cloud_photo", "KEY_open_sync_guide", System.currentTimeMillis());
            if (iM1357g >= 2) {
                C0212e0.m1370t(this.f10259b, "sp_have_show_cloud_photo", "key_show_next_guide_mills", 2592000000L);
                return;
            }
            C0212e0.m1368r(this.f10259b, "sp_have_show_cloud_photo", "key_show_next_seven_day_times", iM1357g + 1);
            C0212e0.m1370t(this.f10259b, "sp_have_show_cloud_photo", "key_show_next_guide_mills", 604800000L);
        }
    }

    /* renamed from: O */
    public final void m13674O() {
        try {
            Intent intent = new Intent();
            C0209d.m1302r2(intent, C13843a.m83054F(this.f10259b));
            intent.setAction("com.huawei.gallery.action.VIEW_UPLOAD_ALBUM");
            Bundle extras = intent.getExtras();
            Context applicationContext = this.f10259b.getApplicationContext();
            if (extras == null) {
                extras = new Bundle();
            }
            extras.putString("album_data_sync", applicationContext.getString(R$string.mecloud_gallery_data_sync_title));
            extras.putString("sync_data_merge_confirm", applicationContext.getString(R$string.sync_data_merge_confirm_tips, applicationContext.getString(R$string.gallery_item_title)));
            extras.putString("dialog_cancel", applicationContext.getString(R$string.sync_data_merge_btn_confirm));
            extras.putString("dialog_merge", applicationContext.getString(R$string.notepad_switch_open_dialog_merge));
            extras.putString("dialog_close", applicationContext.getString(R$string.dialog_disable));
            extras.putString("close_album_data_sync", applicationContext.getString(R$string.gallery_shelve_close_switch));
            extras.putString("close_album_switch_confirm", applicationContext.getString(R$string.close_switch_dialog_msg));
            extras.putBoolean("key-support-cloud-sync-switch", true);
            intent.putExtras(extras);
            intent.addCategory("android.intent.category.DEFAULT");
            this.f10259b.startActivity(intent);
            C13224c.m79487f1().m79585f0("action_code_cloud_photos_pic_tab", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "action_code_cloud_photos_pic_tab", "1", "from_cloud_photos_pic_tab");
        } catch (Exception unused) {
            C1120a.m6676e("PicTabPresenter", "not found gallery other activity");
        }
    }

    public void getDeleteRequestCodeRsult() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R$id.tv_known) {
            C13224c.m79487f1().m79593q0("CLICK_PIC_TAB_TIPS_KNOWN");
            m13677r();
        } else if (id2 == R$id.tv_open_now) {
            C13224c.m79487f1().m79593q0("CLICK_PIC_TAB_TIPS_OPEN");
            m13679t();
        }
    }

    /* renamed from: p */
    public final void m13675p() {
        C12091d.m72280a0().m72342Z(this.f10277t);
    }

    /* renamed from: q */
    public final void m13676q() {
        C1006a.m5936k().m5956b(this.f10259b, new InterfaceC14351b() { // from class: k6.l
            @Override // p850zo.InterfaceC14351b
            public final void onResult(Bundle bundle) {
                this.f52066a.m13684y(bundle);
            }
        });
    }

    /* renamed from: r */
    public final void m13677r() {
        m13670K();
    }

    /* renamed from: s */
    public final void m13678s() {
        boolean zM13683x = m13683x();
        C1120a.m6677i("PicTabPresenter", "handleOpenAlbumSync isSupportSetting " + zM13683x);
        if (zM13683x) {
            m13674O();
        } else {
            C1120a.m6677i("PicTabPresenter", "not support setting");
        }
    }

    public void setCloudPicDesc(String str) {
        C1120a.m6675d("PicTabPresenter", "setCloudPicDesc picAndViedoStr " + str);
        this.f10279v = this.f10259b.getString(R$string.cloud_stored_pic_and_video, str);
        C1120a.m6675d("PicTabPresenter", "setCloudPicDesc cloudPicDescStr " + this.f10279v);
        EmptyLoadNormalRecyclerMediaAdapter emptyLoadNormalRecyclerMediaAdapter = this.f10269l;
        if (emptyLoadNormalRecyclerMediaAdapter == null || emptyLoadNormalRecyclerMediaAdapter.mo721e() <= 0) {
            return;
        }
        Object objM14761R = this.f10269l.m14761R(0);
        if (objM14761R instanceof RecyclerMediaAdapter.C2355g) {
            ((RecyclerMediaAdapter.C2355g) objM14761R).m14791b(this.f10279v);
            this.f10269l.m5215l(0, new Object());
        }
    }

    /* renamed from: t */
    public final void m13679t() {
        Intent intent = new Intent(this.f10259b, (Class<?>) GalleryMainActivity.class);
        intent.putExtra(FamilyShareConstants.ENTRY_TYPE, 4113);
        C13230i.m79525e1(intent, "1", "action_code_cloud_photos_pic_tab");
        this.f10259b.startActivity(intent);
    }

    /* renamed from: u */
    public void m13680u() {
        this.f10273p = C1122c.m6807m1(this.f10259b);
        C1120a.m6675d("PicTabPresenter", "isGallerySynOn " + this.f10273p);
        if (this.f10269l.mo721e() == 0) {
            m13662C();
        }
        C12091d.m72280a0().m72375p0();
        boolean zM14382r = CloudAlbumSettings.m14363h().m14382r();
        C1120a.m6675d("PicTabPresenter", "isShowManager " + zM14382r);
        if (zM14382r) {
            C12091d.m72280a0().m72393v0(this.f10259b, "", false, false);
        }
    }

    /* renamed from: v */
    public final void m13681v() {
        this.f10269l = new EmptyLoadNormalRecyclerMediaAdapter(this.f10259b);
        int spanCount = getSpanCount();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f10259b, spanCount);
        this.f10278u = gridLayoutManager;
        this.f10264g.setLayoutManager(gridLayoutManager);
        this.f10269l.m14775l0(spanCount);
        this.f10269l.m14699L0(this.f10276s);
        this.f10269l.m14772i0(this.f10280w);
        this.f10264g.setAdapter(this.f10269l);
        this.f10265h.m14922A();
    }

    /* renamed from: w */
    public void m13682w() {
        View viewInflate = LayoutInflater.from(this.f10260c).inflate(R$layout.album_manager_pic, this);
        this.f10275r = viewInflate;
        if (viewInflate == null) {
            return;
        }
        this.f10268k = (LinearLayout) C12809f.m76831d(viewInflate, R$id.llay_container);
        this.f10267j = (LinearLayout) C12809f.m76831d(this.f10275r, R$id.llay_root_tips);
        TextView textView = (TextView) C12809f.m76831d(this.f10275r, R$id.tv_known);
        this.f10261d = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) C12809f.m76831d(this.f10275r, R$id.tv_open_now);
        this.f10262e = textView2;
        textView2.setOnClickListener(this);
        this.f10264g = (ImagesGridView) C12809f.m76831d(this.f10275r, R$id.rv_tab_photo);
        this.f10265h = (FMScrollBar) C12809f.m76831d(this.f10275r, R$id.scroll_bar);
        this.f10272o = (TextView) C12809f.m76831d(this.f10275r, R$id.tv_loading_more);
        C2387a.m14962f(this.f10264g, this.f10265h, this.f10277t);
        this.f10266i = (LinearLayout) C12809f.m76831d(this.f10275r, R$id.llayout_root_empty);
        this.f10263f = (SpanClickText) C12809f.m76831d(this.f10275r, R$id.tv_empty_desc);
        this.f10270m = (TextView) C12809f.m76831d(this.f10275r, R$id.scroll_bar_textview);
        this.f10271n = (LinearLayout) C12809f.m76831d(this.f10275r, R$id.scroll_bar_textview_ll);
        m13681v();
        ImagesGridView imagesGridView = this.f10264g;
        imagesGridView.addOnScrollListener(new C2212e(imagesGridView));
        m13680u();
    }

    /* renamed from: x */
    public final boolean m13683x() {
        Bundle bundleM6836u0 = C1122c.m6836u0(this.f10259b);
        return (bundleM6836u0 == null || TextUtils.isEmpty(bundleM6836u0.getString("string_sync_album"))) ? false : true;
    }

    /* renamed from: y */
    public final /* synthetic */ void m13684y(Bundle bundle) {
        Message messageObtain = Message.obtain();
        messageObtain.setData(bundle);
        messageObtain.what = 4369;
        this.f10277t.sendMessage(messageObtain);
    }

    /* renamed from: z */
    public final /* synthetic */ void m13685z() {
        C13224c.m79487f1().m79593q0("CLICK_PIC_TO_OPEN_SYNC_SWITCH");
        m13679t();
    }
}
