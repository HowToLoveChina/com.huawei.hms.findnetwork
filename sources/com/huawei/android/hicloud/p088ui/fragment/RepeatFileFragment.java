package com.huawei.android.hicloud.p088ui.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.drive.clouddisk.model.DuplicateFileCard;
import com.huawei.android.hicloud.drive.clouddisk.model.FileModel;
import com.huawei.android.hicloud.drive.clouddisk.util.FileUtil;
import com.huawei.android.hicloud.p088ui.activity.DuplicateFileActivity;
import com.huawei.android.hicloud.p088ui.uiextend.RoundRectImageView;
import com.huawei.android.hicloud.task.simple.AbstractC3044i2;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import me.C11444a;
import me.C11445b;
import p015ak.C0209d;
import p015ak.C0223k;
import p252e9.C9428e;
import p514o9.C11829c;
import p514o9.C11839m;
import p607ra.RunnableC12484f;
import p616rk.C12515a;
import p664u0.C13108a;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p771xd.HandlerC13773q;
import p783xp.C13843a;
import pa.C12123a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class RepeatFileFragment extends Fragment implements View.OnClickListener {

    /* renamed from: a */
    public View f18142a;

    /* renamed from: b */
    public TextView f18143b;

    /* renamed from: c */
    public TextView f18144c;

    /* renamed from: d */
    public TextView f18145d;

    /* renamed from: e */
    public TextView f18146e;

    /* renamed from: f */
    public TextView f18147f;

    /* renamed from: g */
    public TextView f18148g;

    /* renamed from: h */
    public TextView f18149h;

    /* renamed from: i */
    public HwButton f18150i;

    /* renamed from: j */
    public ImageView f18151j;

    /* renamed from: k */
    public ImageView f18152k;

    /* renamed from: l */
    public RelativeLayout f18153l;

    /* renamed from: n */
    public FileModel f18155n;

    /* renamed from: o */
    public FileModel f18156o;

    /* renamed from: p */
    public RelativeLayout f18157p;

    /* renamed from: q */
    public int f18158q;

    /* renamed from: r */
    public ImageView f18159r;

    /* renamed from: s */
    public ImageView f18160s;

    /* renamed from: t */
    public RelativeLayout f18161t;

    /* renamed from: u */
    public ImageView f18162u;

    /* renamed from: v */
    public RelativeLayout f18163v;

    /* renamed from: w */
    public C3970c f18164w;

    /* renamed from: m */
    public long f18154m = 0;

    /* renamed from: x */
    public Handler f18165x = new HandlerC3968a();

    /* renamed from: com.huawei.android.hicloud.ui.fragment.RepeatFileFragment$a */
    public class HandlerC3968a extends Handler {
        public HandlerC3968a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (RepeatFileFragment.this.getActivity() == null || RepeatFileFragment.this.getActivity().isFinishing()) {
                C11839m.m70689w("RepeatFileFragment", "isFinishing");
                return;
            }
            int i10 = message.what;
            if (1001 != i10) {
                if (1002 == i10) {
                    RepeatFileFragment.this.m24224r();
                }
            } else {
                C11839m.m70688i("RepeatFileFragment", "QUERY_SUCCESS");
                RepeatFileFragment repeatFileFragment = RepeatFileFragment.this;
                repeatFileFragment.m24227u(repeatFileFragment.f18152k, RepeatFileFragment.this.f18155n, true);
                RepeatFileFragment repeatFileFragment2 = RepeatFileFragment.this;
                repeatFileFragment2.m24227u(repeatFileFragment2.f18151j, RepeatFileFragment.this.f18156o, false);
                RepeatFileFragment.this.m24232z();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.fragment.RepeatFileFragment$b */
    public class C3969b extends AbstractC3044i2 {
        public C3969b() {
        }

        /* renamed from: c */
        private void m24233c(int i10) {
            Message messageObtain = Message.obtain();
            messageObtain.what = i10;
            RepeatFileFragment.this.f18165x.sendMessage(messageObtain);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                try {
                    ArrayList<FileModel> arrayListM72692h = new C12123a().m72692h("SELECT fileId, fileName, fileSize, fileMd5, modifyTime, fileParent, fileCategory, thumbnailPath, fileParentName FROM  diskDuplicateFile order by CAST(fileSize AS LONG) desc,modifyTime desc", null);
                    RepeatFileFragment.this.m24226t(FileUtil.m16367q(RepeatFileFragment.this.getResources().getString(R$string.hidisk_my_drive), new ArrayList()));
                    C11839m.m70688i("RepeatFileFragment", "fileList size:" + arrayListM72692h.size());
                    if (arrayListM72692h.size() == 0) {
                        m24233c(1002);
                    } else {
                        RepeatFileFragment.this.m24225s(arrayListM72692h);
                        m24233c(1001);
                    }
                } catch (Exception e10) {
                    C11839m.m70687e("RepeatFileFragment", "query error:" + e10);
                    m24233c(1002);
                }
                RepeatFileFragment.this.m24230x();
            } catch (Throwable th2) {
                RepeatFileFragment.this.m24230x();
                throw th2;
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.fragment.RepeatFileFragment$c */
    public class C3970c extends BroadcastReceiver {
        public C3970c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "com.huawei.hicloud.action.ACTION_SPACE_CLEAR_DATA_REFRESH".equals(new SafeIntent(intent).getAction())) {
                C11839m.m70688i("RepeatFileFragment", "receive changed");
                if (RepeatFileFragment.this.getActivity() == null) {
                    C11839m.m70689w("RepeatFileFragment", "activity null");
                } else {
                    RepeatFileFragment.this.m24228v();
                }
            }
        }

        public /* synthetic */ C3970c(RepeatFileFragment repeatFileFragment, HandlerC3968a handlerC3968a) {
            this();
        }
    }

    /* renamed from: A */
    public final void m24218A() {
        Activity activity = getActivity();
        if (activity == null) {
            C11839m.m70689w("RepeatFileFragment", "unregisterReceiver activity null");
        } else if (this.f18164w != null) {
            C13108a.m78878b(activity).m78883f(this.f18164w);
            this.f18164w = null;
        }
    }

    /* renamed from: m */
    public final boolean m24219m() {
        return isAdded() && getActivity() != null;
    }

    /* renamed from: n */
    public final void m24220n(boolean z10, int i10) {
        if (z10) {
            this.f18159r.setVisibility(i10);
        } else {
            this.f18160s.setVisibility(i10);
        }
    }

    /* renamed from: o */
    public final void m24221o() {
        C13225d.m79490f1().m79585f0("mecloud_clouddiskmaininterception_click_repeat_file_next_delete", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "mecloud_clouddiskmaininterception_click_repeat_file_next_delete", "1", "15");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            C11839m.m70687e("RepeatFileFragment", "do not fast click");
            return;
        }
        if (view.getId() == R$id.clean_repeat_file_btn || view.getId() == R$id.repeat_file_real) {
            this.f18155n = null;
            this.f18156o = null;
            m24221o();
            getActivity().startActivity(new Intent(getActivity(), (Class<?>) DuplicateFileActivity.class));
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2;
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View view = this.f18142a;
        if (view != null && (viewGroup2 = (ViewGroup) view.getParent()) != null) {
            viewGroup2.removeView(this.f18142a);
        }
        if (C0209d.m1195O(getActivity()) >= 1.45f) {
            this.f18142a = layoutInflater.inflate(R$layout.repeat_file_fragment_layout_3dot2, viewGroup, false);
        } else {
            this.f18142a = layoutInflater.inflate(R$layout.repeat_file_fragment_layout, viewGroup, false);
        }
        m24223q();
        m24229w();
        return this.f18142a;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        m24218A();
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public void onInflate(AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(attributeSet, bundle);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        m24228v();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
    }

    /* renamed from: p */
    public final void m24222p() {
        this.f18162u.setVisibility(8);
        this.f18163v.setEnabled(false);
    }

    /* renamed from: q */
    public final void m24223q() {
        this.f18143b = (TextView) C12809f.m76831d(this.f18142a, R$id.repeat_file_total_size);
        this.f18144c = (TextView) C12809f.m76831d(this.f18142a, R$id.first_repeat_file_name);
        this.f18145d = (TextView) C12809f.m76831d(this.f18142a, R$id.first_repeat_file_path);
        this.f18146e = (TextView) C12809f.m76831d(this.f18142a, R$id.first_repeat_file_size);
        this.f18147f = (TextView) C12809f.m76831d(this.f18142a, R$id.second_repeat_file_name);
        this.f18148g = (TextView) C12809f.m76831d(this.f18142a, R$id.second_repeat_file_path);
        this.f18149h = (TextView) C12809f.m76831d(this.f18142a, R$id.second_repeat_file_size);
        HwButton hwButton = (HwButton) C12809f.m76831d(this.f18142a, R$id.clean_repeat_file_btn);
        this.f18150i = hwButton;
        hwButton.setOnClickListener(this);
        this.f18152k = (ImageView) C12809f.m76831d(this.f18142a, R$id.repeat_file_first_image);
        this.f18151j = (ImageView) C12809f.m76831d(this.f18142a, R$id.repeat_file_second_image);
        this.f18153l = (RelativeLayout) C12809f.m76831d(this.f18142a, R$id.repeat_file_first);
        this.f18157p = (RelativeLayout) C12809f.m76831d(this.f18142a, R$id.repeat_file_second);
        this.f18159r = (ImageView) C12809f.m76831d(this.f18142a, R$id.repeat_file_first_video_image);
        this.f18160s = (ImageView) C12809f.m76831d(this.f18142a, R$id.repeat_file_second_video_image);
        this.f18161t = (RelativeLayout) C12809f.m76831d(this.f18142a, R$id.repeat_btn);
        this.f18162u = (ImageView) C12809f.m76831d(this.f18142a, R$id.hicloud_item_right_arrow);
        this.f18163v = (RelativeLayout) C12809f.m76831d(this.f18142a, R$id.repeat_file_real);
    }

    /* renamed from: r */
    public final void m24224r() {
        C11839m.m70688i("RepeatFileFragment", "noDataShowView");
        this.f18153l.setVisibility(8);
        this.f18157p.setVisibility(8);
        this.f18143b.setVisibility(0);
        this.f18143b.setText(C0223k.m1524g(getActivity(), 0L));
        this.f18161t.setVisibility(8);
        m24222p();
    }

    /* renamed from: s */
    public final void m24225s(ArrayList<FileModel> arrayList) {
        this.f18155n = null;
        this.f18156o = null;
        int i10 = 0;
        boolean z10 = false;
        while (i10 < arrayList.size()) {
            FileModel fileModel = arrayList.get(i10);
            i10++;
            int i11 = i10;
            while (true) {
                if (i11 >= arrayList.size()) {
                    break;
                }
                FileModel fileModel2 = arrayList.get(i11);
                if (fileModel.getFileSize() == fileModel2.getFileSize() && !TextUtils.isEmpty(fileModel.getFileId()) && !fileModel.getFileId().equals(fileModel2.getFileId()) && !TextUtils.isEmpty(fileModel.getFileMD5()) && fileModel.getFileMD5().equals(fileModel2.getFileMD5())) {
                    this.f18155n = fileModel;
                    this.f18156o = fileModel2;
                    z10 = true;
                    break;
                }
                i11++;
            }
            if (z10) {
                break;
            }
        }
        if (this.f18155n != null && m24219m()) {
            this.f18155n.setCloudPath(C9428e.m59118h().m59127i(TextUtils.isEmpty(this.f18155n.getFileParentName()) ? getActivity().getResources().getString(R$string.hidisk_my_drive) : this.f18155n.getFileParentName()));
        }
        if (this.f18156o == null || !m24219m()) {
            return;
        }
        this.f18156o.setCloudPath(C9428e.m59118h().m59127i(TextUtils.isEmpty(this.f18156o.getFileParentName()) ? getActivity().getResources().getString(R$string.hidisk_my_drive) : this.f18156o.getFileParentName()));
    }

    /* renamed from: t */
    public final void m24226t(Map<Integer, List<DuplicateFileCard>> map) {
        this.f18158q = 0;
        this.f18154m = 0L;
        Iterator<Map.Entry<Integer, List<DuplicateFileCard>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            List<DuplicateFileCard> value = it.next().getValue();
            if (value != null && !value.isEmpty()) {
                for (DuplicateFileCard duplicateFileCard : value) {
                    List<FileModel> fileModelList = duplicateFileCard.getFileModelList();
                    if (fileModelList != null && !fileModelList.isEmpty()) {
                        this.f18154m += duplicateFileCard.getSize() * fileModelList.size();
                        this.f18158q = fileModelList.size() + this.f18158q;
                    }
                }
            }
        }
        C11839m.m70688i("RepeatFileFragment", "duplicate file duplicateTotalFileSize size: " + this.f18154m + " itemTotal:" + this.f18158q);
    }

    /* renamed from: u */
    public final void m24227u(ImageView imageView, FileModel fileModel, boolean z10) {
        if (imageView == null || fileModel == null) {
            m24220n(z10, 8);
            C11839m.m70689w("RepeatFileFragment", "item or imageview is null");
            return;
        }
        int fileCategory = fileModel.getFileCategory();
        imageView.setVisibility(0);
        if (fileCategory == 2) {
            m24220n(z10, 0);
        } else {
            m24220n(z10, 8);
        }
        C11839m.m70688i("RepeatFileFragment", "fileCategory:" + fileCategory);
        if (!C11445b.m68564a(fileCategory)) {
            RoundRectImageView.setNoBorderScaleDefault(imageView, getActivity().getDrawable(C11444a.m68560d(fileModel.getFileName(), false).m68567c()));
            return;
        }
        Bitmap bitmapM68559c = C11444a.m68559c(fileModel.getThumbnailPath());
        if (bitmapM68559c != null) {
            C11839m.m70688i("RepeatFileFragment", "bitmap != null set bitmap");
            RoundRectImageView.setBorderImageViewByBitmap(imageView, bitmapM68559c);
            if (fileCategory == 2) {
                m24220n(z10, 0);
                return;
            }
            return;
        }
        m24220n(z10, 8);
        String fileName = fileModel.getFileName();
        imageView.setTag(fileModel.getFileId());
        RoundRectImageView.setNoBorderScaleDefault(imageView, getActivity().getDrawable(C11444a.m68560d(fileModel.getFileName(), false).m68567c()));
        C11829c.m70601o(new RunnableC12484f(fileModel, new HandlerC13773q(imageView, fileModel.getFileId(), fileName, z10 ? this.f18159r : this.f18160s, fileCategory), 1));
    }

    /* renamed from: v */
    public final void m24228v() {
        C11839m.m70688i("RepeatFileFragment", "queryData");
        C12515a.m75110o().m75172d(new C3969b());
    }

    /* renamed from: w */
    public final void m24229w() {
        Activity activity = getActivity();
        if (activity == null) {
            C11839m.m70689w("RepeatFileFragment", "registerReceiver activity null");
        } else if (this.f18164w == null) {
            this.f18164w = new C3970c(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.hicloud.action.ACTION_SPACE_CLEAR_DATA_REFRESH");
            C13108a.m78878b(activity).m78880c(this.f18164w, intentFilter);
        }
    }

    /* renamed from: x */
    public final void m24230x() {
        LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("cloudspace_repeat_file_size", Long.valueOf(this.f18154m));
        linkedHashMapM79499C.put("cloudspace_repeat_file_num", Integer.valueOf(this.f18158q));
        C13225d.m79490f1().m79567R("ENTER_REPEAT_FILE", linkedHashMapM79499C);
        UBAAnalyze.m29947H("PVC", "ENTER_REPEAT_FILE", linkedHashMapM79499C);
    }

    /* renamed from: y */
    public final void m24231y() {
        this.f18162u.setVisibility(0);
        this.f18163v.setEnabled(true);
        this.f18163v.setOnClickListener(this);
    }

    /* renamed from: z */
    public final void m24232z() {
        if (this.f18155n == null) {
            C11839m.m70688i("RepeatFileFragment", "firstRepeatFileModel is null");
            m24224r();
            return;
        }
        m24231y();
        this.f18161t.setVisibility(0);
        this.f18143b.setVisibility(0);
        if (m24219m()) {
            String strM83086h = C13843a.m83086h(getActivity(), this.f18154m);
            TextView textView = this.f18143b;
            Resources resources = getResources();
            int i10 = R$plurals.backup_backing_state;
            int i11 = this.f18158q;
            textView.setText(resources.getQuantityString(i10, i11, Integer.valueOf(i11), strM83086h));
        }
        this.f18153l.setVisibility(0);
        this.f18144c.setText(this.f18155n.getFileName());
        this.f18145d.setText(this.f18155n.getCloudPath());
        if (TextUtils.isEmpty(this.f18155n.getCloudPath())) {
            this.f18145d.setVisibility(8);
        }
        if (m24219m()) {
            this.f18146e.setText(C13843a.m83086h(getActivity(), this.f18155n.getFileSize()));
        }
        if (this.f18156o == null) {
            this.f18157p.setVisibility(8);
            return;
        }
        this.f18157p.setVisibility(0);
        this.f18147f.setText(this.f18156o.getFileName());
        this.f18148g.setText(this.f18156o.getCloudPath());
        if (TextUtils.isEmpty(this.f18156o.getCloudPath())) {
            this.f18148g.setVisibility(8);
        }
        if (m24219m()) {
            this.f18149h.setText(C13843a.m83086h(getActivity(), this.f18156o.getFileSize()));
        }
    }
}
