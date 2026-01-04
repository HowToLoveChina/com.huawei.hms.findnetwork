package com.huawei.android.p069cg.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import com.huawei.android.hicloud.album.service.logic.callable.QueryLocalMediaTask;
import com.huawei.android.hicloud.p088ui.activity.UIActivity;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$plurals;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.bean.MediaFileBean;
import com.huawei.android.p069cg.p071ui.ImagesGridView;
import com.huawei.android.p069cg.utils.scrollbar.C2387a;
import com.huawei.android.p069cg.utils.scrollbar.FMScrollBar;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import p015ak.C0209d;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1133n;
import p292fn.C9733f;
import p514o9.C11841o;
import p604r7.HandlerC12475h;
import p616rk.C12515a;
import p783xp.C13843a;
import p834z6.C14147g;
import sk.C12809f;

/* loaded from: classes2.dex */
public class PhotoPickerActivity extends UIActivity implements View.OnClickListener, C14147g.a {

    /* renamed from: A */
    public ArrayList<MediaFileBean> f10220A;

    /* renamed from: p */
    public NotchTopFitRelativeLayout f10224p;

    /* renamed from: q */
    public NotchFitRelativeLayout f10225q;

    /* renamed from: r */
    public ImagesGridView f10226r;

    /* renamed from: s */
    public C14147g f10227s;

    /* renamed from: t */
    public TextView f10228t;

    /* renamed from: u */
    public TextView f10229u;

    /* renamed from: v */
    public TextView f10230v;

    /* renamed from: w */
    public RelativeLayout f10231w;

    /* renamed from: x */
    public HandlerC12475h f10232x;

    /* renamed from: y */
    public QueryLocalMediaTask f10233y;

    /* renamed from: z */
    public String f10234z = "";

    /* renamed from: B */
    public final C1133n f10221B = C1133n.m6927e();

    /* renamed from: C */
    public final C1133n.c f10222C = new C1133n.c();

    /* renamed from: D */
    public boolean f10223D = false;

    /* renamed from: O1 */
    private void m13610O1() throws Resources.NotFoundException {
        m13614N1();
        m13618T1();
        m13617S1();
    }

    /* renamed from: P1 */
    private void m13611P1() {
        this.f10224p = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f10225q = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.main_all);
        this.f10226r = (ImagesGridView) C12809f.m76829b(this, R$id.photo_picker_grid);
        this.f10227s = new C14147g(this, this.f10222C);
        this.f10226r.setLayoutManager(new GridLayoutManager(this, m13612L1()));
        this.f10226r.setAdapter(this.f10227s);
        this.f10227s.m84926R(this);
        ((RelativeLayout) C12809f.m76829b(this, R$id.ic_back_hot_space)).setOnClickListener(this);
        this.f10228t = (TextView) C12809f.m76829b(this, R$id.txt_selected_count);
        this.f10229u = (TextView) C12809f.m76829b(this, R$id.txt_selected_detail);
        this.f10231w = (RelativeLayout) C12809f.m76829b(this, R$id.rel_empty);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.txt_enter);
        this.f10230v = textView;
        textView.setOnClickListener(this);
        FMScrollBar fMScrollBar = (FMScrollBar) C12809f.m76829b(this, R$id.scr_picker);
        HandlerC12475h handlerC12475h = new HandlerC12475h(this);
        this.f10232x = handlerC12475h;
        C2387a.m14962f(this.f10226r, fMScrollBar, handlerC12475h);
    }

    /* renamed from: L1 */
    public final int m13612L1() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) getSystemService(Constants.NATIVE_WINDOW_SUB_DIR);
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        int iMin = Math.min(point.x, point.y);
        float f10 = (iMin * 1.0f) / 4;
        int i10 = point.x;
        if (iMin == i10) {
            return 4;
        }
        return (int) (i10 / f10);
    }

    /* renamed from: M1 */
    public String m13613M1(String str) {
        return String.format(Locale.ENGLISH, "%s-%s-%d", str, String.valueOf(System.currentTimeMillis()), Integer.valueOf(hashCode()));
    }

    /* renamed from: N1 */
    public final void m13614N1() {
        HiCloudSysParamMap hiCloudSysParamMapM60758q = C9733f.m60705z().m60758q();
        if (hiCloudSysParamMapM60758q == null) {
            C1120a.m6677i("PhotoPickerActivity", "initConfigure fail!");
            return;
        }
        int photoPickerAmountLimit = hiCloudSysParamMapM60758q.getPhotoPickerAmountLimit();
        int photoPickerImageSizeLimit = hiCloudSysParamMapM60758q.getPhotoPickerImageSizeLimit();
        int photoPickerVideoDurationLimit = hiCloudSysParamMapM60758q.getPhotoPickerVideoDurationLimit();
        int photoPickerVideoSizeLimit = hiCloudSysParamMapM60758q.getPhotoPickerVideoSizeLimit();
        C1120a.m6677i("PhotoPickerActivity", "initConfigure:" + photoPickerAmountLimit + ";" + photoPickerImageSizeLimit + ";" + photoPickerVideoDurationLimit + ";" + photoPickerVideoSizeLimit);
        if (photoPickerAmountLimit > 0) {
            this.f10222C.f5398d = photoPickerAmountLimit;
        }
        if (photoPickerImageSizeLimit > 0) {
            this.f10222C.f5395a = photoPickerImageSizeLimit * C1133n.f5391c;
        }
        if (photoPickerVideoDurationLimit > 0) {
            this.f10222C.f5396b = photoPickerVideoDurationLimit * 60000;
        }
        if (photoPickerVideoSizeLimit > 0) {
            this.f10222C.f5397c = photoPickerVideoSizeLimit * C1133n.f5391c;
        }
    }

    /* renamed from: Q1 */
    public final void m13615Q1(int i10) {
        if (this.f10223D) {
            return;
        }
        try {
            C1122c.m6776e2(this.f10234z, this.f10227s.m84918J());
            Intent intent = new Intent(this, (Class<?>) AlbumFileViewActivity.class);
            intent.putExtra("param_media_index", i10);
            intent.putExtra("param_is_share_cloud_album", false);
            intent.putExtra("param_album_id", this.f10234z);
            intent.putExtra("param_is_from_picker", true);
            startActivityForResult(intent, 306);
            this.f10223D = true;
        } catch (Exception e10) {
            C1120a.m6676e("PhotoPickerActivity", e10.getMessage());
        }
    }

    /* renamed from: R1 */
    public void m13616R1(ArrayList<MediaFileBean> arrayList, boolean z10) {
        RelativeLayout relativeLayout;
        C14147g c14147g = this.f10227s;
        if (c14147g != null) {
            if (arrayList != null) {
                c14147g.m84927S(arrayList);
                this.f10227s.m5213j();
            }
            if (z10) {
                int iMo721e = this.f10227s.mo721e();
                C1120a.m6677i("PhotoPickerActivity", "queryComplete:size = " + iMo721e);
                if (iMo721e <= 0 && (relativeLayout = this.f10231w) != null) {
                    relativeLayout.setVisibility(0);
                }
            }
            m13618T1();
        }
    }

    /* renamed from: S1 */
    public final void m13617S1() {
        RelativeLayout relativeLayout = this.f10231w;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.f10234z)) {
            this.f10234z = m13613M1("ALL");
        }
        this.f10221B.m6928a(this.f10234z, this.f10222C);
        C1120a.m6677i("PhotoPickerActivity", "queryLocalMedias,cacheKey = " + this.f10234z);
        QueryLocalMediaTask queryLocalMediaTask = this.f10233y;
        if (queryLocalMediaTask != null) {
            queryLocalMediaTask.cancel();
            this.f10227s.m84916H();
        }
        C14147g c14147g = this.f10227s;
        if (c14147g != null) {
            c14147g.m84917I();
        }
        this.f10233y = new QueryLocalMediaTask(this.f10232x, this.f10234z, this.f10220A);
        C12515a.m75110o().m75172d(this.f10233y);
    }

    /* renamed from: T1 */
    public final void m13618T1() throws Resources.NotFoundException {
        ArrayList<MediaFileBean> arrayListM6934h = this.f10221B.m6934h(this.f10234z);
        Resources resources = getResources();
        if (resources != null) {
            Iterator<MediaFileBean> it = arrayListM6934h.iterator();
            int i10 = 0;
            int i11 = 0;
            while (it.hasNext()) {
                int iM14338j = it.next().m14338j();
                if (iM14338j == 3) {
                    i10++;
                } else if (iM14338j == 2) {
                    i11++;
                }
            }
            int i12 = i10 + i11;
            this.f10228t.setText(resources.getString(R$string.album_photo_picker_count, Integer.valueOf(i12), Integer.valueOf(this.f10222C.f5398d)));
            if (i12 <= 0) {
                this.f10229u.setVisibility(8);
                this.f10230v.setEnabled(false);
                return;
            }
            this.f10229u.setVisibility(0);
            this.f10230v.setEnabled(true);
            this.f10229u.setText(resources.getString(R$string.album_photo_picker_count_detail, resources.getQuantityString(R$plurals.album_picker_photo, i11, Integer.valueOf(i11)), resources.getQuantityString(R$plurals.album_picker_video, i10, Integer.valueOf(i10))));
        }
    }

    /* renamed from: U1 */
    public final void m13619U1() {
        ArrayList<MediaFileBean> arrayListM6934h = this.f10221B.m6934h(this.f10234z);
        if (!arrayListM6934h.isEmpty()) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Iterator<MediaFileBean> it = arrayListM6934h.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().m14340l());
            }
            Bundle bundle = new Bundle();
            bundle.putString("select-item-list-key", this.f10234z);
            bundle.putParcelableArrayList("select-item-list", arrayList);
            Intent intent = new Intent();
            intent.putExtras(bundle);
            setResult(-1, intent);
        }
        finish();
    }

    /* renamed from: V1 */
    public final void m13620V1(View view, MediaFileBean mediaFileBean) throws Resources.NotFoundException {
        CheckBox checkBox = (CheckBox) C12809f.m76831d(view, R$id.chk_img);
        View viewM76831d = C12809f.m76831d(view, R$id.view_mask);
        if (checkBox == null || viewM76831d == null) {
            return;
        }
        if (mediaFileBean.m14311N()) {
            this.f10221B.m6936j(this.f10234z, mediaFileBean);
            mediaFileBean.m14313P(false);
            checkBox.setChecked(false);
            viewM76831d.setVisibility(8);
            m13618T1();
            return;
        }
        int iM6929b = this.f10221B.m6929b(this.f10234z, mediaFileBean, this.f10222C);
        if (iM6929b == 0) {
            mediaFileBean.m14313P(true);
            checkBox.setChecked(true);
            viewM76831d.setVisibility(0);
            m13618T1();
            return;
        }
        String strM6932f = this.f10221B.m6932f(this, iM6929b, this.f10222C);
        if (!TextUtils.isEmpty(strM6932f)) {
            C11841o.m70706b(this, strM6932f, 0);
        }
        checkBox.setChecked(false);
    }

    @Override // p834z6.C14147g.a
    /* renamed from: a */
    public void mo13621a(View view, int i10, int i11) throws Resources.NotFoundException {
        C14147g c14147g = this.f10227s;
        if (c14147g != null) {
            MediaFileBean mediaFileBeanM84919K = c14147g.m84919K(i10);
            if (mediaFileBeanM84919K == null) {
                C1120a.m6677i("PhotoPickerActivity", "onItemClick:" + i10 + " is null");
                return;
            }
            C1120a.m6677i("PhotoPickerActivity", C1122c.m6818p0(mediaFileBeanM84919K.m14331f()) + " ; " + i10 + " ; " + i11);
            if (i11 == 1) {
                m13615Q1(i10);
            } else if (i11 == 2) {
                m13620V1(view, mediaFileBeanM84919K);
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f10224p);
        arrayList.add(this.f10225q);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) throws Resources.NotFoundException {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 306) {
            this.f10223D = false;
            m13618T1();
            C14147g c14147g = this.f10227s;
            if (c14147g != null) {
                c14147g.m5213j();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            C1120a.m6677i("PhotoPickerActivity", "fast click");
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.ic_back_hot_space) {
            finish();
        } else if (id2 == R$id.txt_enter) {
            m13619U1();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ImagesGridView imagesGridView = this.f10226r;
        if (imagesGridView != null) {
            imagesGridView.setLayoutManager(new GridLayoutManager(this, m13612L1()));
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        setContentView(R$layout.layout_album_photo_picker);
        m13611P1();
        SafeIntent safeIntent = new SafeIntent(getIntent());
        this.f10234z = safeIntent.getStringExtra("select-item-list-key");
        this.f10220A = safeIntent.getParcelableArrayListExtra("select-item-list");
        m13610O1();
        mo19005p1();
        m22368H1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C14147g c14147g = this.f10227s;
        if (c14147g != null) {
            c14147g.m84916H();
        }
        QueryLocalMediaTask queryLocalMediaTask = this.f10233y;
        if (queryLocalMediaTask != null) {
            queryLocalMediaTask.cancel();
        }
        String str = this.f10234z;
        if (str != null) {
            this.f10221B.m6935i(str);
        }
    }
}
