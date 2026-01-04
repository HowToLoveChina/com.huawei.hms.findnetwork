package ae;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import com.huawei.uikit.hwalphaindexerlistview.utils.HwSectionLocaleUtils;
import com.huawei.uikit.hwalphaindexerlistview.utils.HwTextPinyinUtil;
import com.huawei.uikit.hwalphaindexerlistview.widget.HwSectionIndexer;
import java.io.Serializable;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0223k;
import p015ak.C0241z;
import p514o9.C11839m;
import p514o9.C11842p;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p618rm.C12580p;
import p783xp.C13843a;
import p848zl.C14333b;
import sk.C12809f;

/* renamed from: ae.u0 */
/* loaded from: classes3.dex */
public class C0171u0 extends BaseAdapter {

    /* renamed from: m */
    public static final Collator f628m = Collator.getInstance();

    /* renamed from: a */
    public Context f629a;

    /* renamed from: b */
    public Resources f630b;

    /* renamed from: c */
    public LayoutInflater f631c;

    /* renamed from: d */
    public List<CloudRestoreItem> f632d;

    /* renamed from: e */
    public HwSectionIndexer f633e;

    /* renamed from: f */
    public Map<String, Integer> f634f;

    /* renamed from: g */
    public Map<String, String> f635g;

    /* renamed from: h */
    public View.OnClickListener f636h;

    /* renamed from: i */
    public View.OnTouchListener f637i;

    /* renamed from: j */
    public String f638j;

    /* renamed from: k */
    public boolean f639k;

    /* renamed from: l */
    public DisplayMetrics f640l;

    /* renamed from: ae.u0$a */
    public class a extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ Handler f641a;

        public a(Handler handler) {
            this.f641a = handler;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                ArrayList arrayList = new ArrayList(C0171u0.this.f632d);
                C0171u0.this.m921r(arrayList);
                this.f641a.removeMessages(330001);
                Message messageObtain = Message.obtain();
                messageObtain.what = 330001;
                messageObtain.obj = arrayList;
                this.f641a.sendMessageDelayed(messageObtain, 200L);
            } catch (Exception e10) {
                C11839m.m70688i("CloudRestoreChildOptionsAdapter", "initBuildSectionIndexer error," + e10.getMessage());
            }
        }
    }

    /* renamed from: ae.u0$b */
    public static class b implements Comparator<String>, Serializable {
        private static final long serialVersionUID = 3207914161137875043L;

        public b() {
        }

        @Override // java.util.Comparator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            if ("".equals(str)) {
                return 1;
            }
            if ("".equals(str2)) {
                return -1;
            }
            return C0171u0.f628m.compare(str, str2);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* renamed from: ae.u0$c */
    public static class c {

        /* renamed from: a */
        public LinearLayout f643a;

        /* renamed from: b */
        public CheckBox f644b;

        /* renamed from: c */
        public RelativeLayout f645c;

        /* renamed from: d */
        public ImageView f646d;

        /* renamed from: e */
        public ImageView f647e;

        /* renamed from: f */
        public TextView f648f;

        /* renamed from: g */
        public TextView f649g;

        /* renamed from: h */
        public ImageView f650h;

        /* renamed from: i */
        public TextView f651i;

        /* renamed from: j */
        public View f652j;

        /* renamed from: k */
        public RelativeLayout f653k;
    }

    public C0171u0(Context context, Handler handler, String str, List<CloudRestoreItem> list) {
        new ArrayList();
        this.f629a = context;
        this.f638j = str;
        this.f632d = list;
        this.f639k = m922s();
        Context context2 = this.f629a;
        if (context2 != null) {
            this.f630b = context2.getResources();
            this.f631c = (LayoutInflater) this.f629a.getSystemService("layout_inflater");
        }
        if ("bmBaseData".equals(str) || "thirdAppData".equals(str) || "thirdApp".equals(str)) {
            C12515a.m75110o().m75172d(new a(handler));
        }
        this.f640l = C11842p.m70876w(this.f629a);
    }

    /* renamed from: j */
    public static int m906j(String str, String str2, String str3, String str4) {
        if ("".equals(str) && "".equals(str2)) {
            return f628m.compare(str3, str4);
        }
        if ("".equals(str)) {
            return 1;
        }
        return "".equals(str2) ? -1 : 0;
    }

    /* renamed from: t */
    public static /* synthetic */ int m907t(CloudRestoreItem cloudRestoreItem, CloudRestoreItem cloudRestoreItem2) {
        String appName = cloudRestoreItem.getAppName();
        String appName2 = cloudRestoreItem2.getAppName();
        String strM83056H = C13843a.m83056H(cloudRestoreItem.getAppName());
        String strM83056H2 = C13843a.m83056H(cloudRestoreItem2.getAppName());
        return ("".equals(strM83056H) || "".equals(strM83056H2)) ? m906j(strM83056H, strM83056H2, appName, appName2) : f628m.compare(strM83056H, strM83056H2);
    }

    /* renamed from: A */
    public void m908A(View view, int i10) throws Resources.NotFoundException {
        List<CloudRestoreItem> list;
        if (view == null || this.f630b == null || (list = this.f632d) == null || i10 >= list.size()) {
            return;
        }
        c cVar = (c) view.getTag();
        m910f(cVar, this.f632d.get(i10));
        m911g(cVar, this.f632d.get(i10), i10);
    }

    /* renamed from: e */
    public final void m909e(CloudRestoreItem cloudRestoreItem) {
        if (this.f634f == null) {
            this.f634f = new LinkedHashMap(16);
        }
        if (this.f635g == null) {
            this.f635g = new HashMap(16);
        }
        if (cloudRestoreItem == null) {
            C11839m.m70688i("CloudRestoreChildOptionsAdapter", "restoreItem in addOneFileToSectionMap is null");
            return;
        }
        String appName = cloudRestoreItem.getAppName();
        String strM916m = m916m(appName);
        if (this.f639k && "#".equals(strM916m)) {
            return;
        }
        this.f635g.put(appName, strM916m);
        if (!this.f634f.containsKey(strM916m)) {
            this.f634f.put(strM916m, 1);
        } else {
            Map<String, Integer> map = this.f634f;
            map.put(strM916m, Integer.valueOf(map.get(strM916m).intValue() + 1));
        }
    }

    /* renamed from: f */
    public final void m910f(c cVar, CloudRestoreItem cloudRestoreItem) {
        String appId = cloudRestoreItem.getAppId();
        if (SplitAppUtil.hasSplitAppSuffix(cloudRestoreItem.getAppId())) {
            cVar.f647e.setVisibility(0);
            appId = cloudRestoreItem.getOriBackupAppName();
        } else {
            cVar.f647e.setVisibility(8);
        }
        String str = "virtual.hmos.sync.switch.status".equals(appId) ? "virtual.sync.switch.status" : appId;
        Drawable drawable = C14333b.m85483r().containsKey(str) ? CloudBackup3rdIconUtil.getDrawable(str) : CloudBackup3rdIconUtil.get3rdDrawable(str);
        cVar.f646d.setTag(appId);
        cVar.f646d.setImageDrawable(drawable);
    }

    /* renamed from: g */
    public final void m911g(c cVar, CloudRestoreItem cloudRestoreItem, int i10) throws Resources.NotFoundException {
        boolean z10;
        if ("bmBaseData".equals(this.f638j)) {
            cVar.f644b.setVisibility(8);
        }
        cVar.f644b.setChecked(cloudRestoreItem.getAction() != 2);
        String combineUid = cloudRestoreItem.getCombineUid();
        if (TextUtils.isEmpty(combineUid) || !combineUid.contains("&")) {
            z10 = false;
        } else {
            for (String str : combineUid.split("&")) {
                if (C0241z.m1685c(str) != 0) {
                    z10 = true;
                    break;
                }
            }
            z10 = false;
        }
        String appName = cloudRestoreItem.getAppName();
        boolean z11 = z10 && "thirdAppData".equals(this.f638j);
        TextView textView = cVar.f648f;
        if (z11) {
            appName = this.f629a.getString(R$string.item_contains_twin_label, appName);
        }
        textView.setText(appName);
        long size = cloudRestoreItem.getSize();
        if (cloudRestoreItem.isHarmonyNext()) {
            size += cloudRestoreItem.getAsize();
        }
        List<CloudRestoreItem> listM29202r = cloudRestoreItem.m29202r();
        if (listM29202r != null && !listM29202r.isEmpty() && cloudRestoreItem.is3rdAppType()) {
            m926x(cVar, cloudRestoreItem);
        } else if ("thirdApp".equals(this.f638j)) {
            cVar.f649g.setText(C0209d.m1232a0(C0223k.m1524g(this.f629a, cloudRestoreItem.getAsize())));
        } else {
            String strM1232a0 = C0209d.m1232a0(C0223k.m1524g(this.f629a, size));
            if (size != 0) {
                cVar.f649g.setText(strM1232a0);
            }
        }
        if (!C11842p.m70753O0(this.f629a)) {
            cVar.f649g.setMaxWidth(C11842p.m70713B(this.f629a));
            cVar.f648f.setMaxWidth(C11842p.m70713B(this.f629a));
        }
        cVar.f652j.setVisibility(getCount() - 1 != i10 ? 0 : 8);
        cVar.f644b.setAlpha((float) (!cloudRestoreItem.isCompatible() ? 0.4d : 1.0d));
        cVar.f643a.setEnabled(cloudRestoreItem.isCompatible());
        cVar.f643a.setAlpha((float) (cloudRestoreItem.isCompatible() ? 1.0d : 0.4d));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f632d.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) throws Resources.NotFoundException {
        List<CloudRestoreItem> list;
        CloudRestoreItem cloudRestoreItem;
        c cVarM912h;
        View viewM76832e;
        DisplayMetrics displayMetrics;
        if (this.f630b == null || (list = this.f632d) == null || i10 >= list.size() || (cloudRestoreItem = this.f632d.get(i10)) == null) {
            return view;
        }
        if (view == null) {
            viewM76832e = C0209d.m1195O(this.f629a) >= 1.75f ? C12809f.m76832e(this.f631c, R$layout.item_backup_content_detail_font_scale) : C12809f.m76832e(this.f631c, R$layout.item_backup_content_detail);
            cVarM912h = m912h(viewM76832e);
            viewM76832e.setTag(cVarM912h);
        } else {
            cVarM912h = (c) view.getTag();
            viewM76832e = view;
        }
        if (cVarM912h == null) {
            return view;
        }
        if (m913i(cloudRestoreItem)) {
            if (cloudRestoreItem.isCompatible()) {
                cVarM912h.f650h.setVisibility(0);
                cVarM912h.f645c.setOnClickListener(this.f636h);
                cVarM912h.f645c.setOnTouchListener(this.f637i);
            } else {
                cVarM912h.f650h.setVisibility(8);
            }
            cVarM912h.f651i.setText(this.f630b.getQuantityString(R$plurals.backup_recover_how_many_apps_not_support, cloudRestoreItem.m29205t(), Integer.valueOf(cloudRestoreItem.m29205t())));
            cVarM912h.f651i.setVisibility(cloudRestoreItem.m29183K() ? 0 : 8);
        } else {
            cVarM912h.f650h.setVisibility(8);
            if (SplitAppUtil.isTwinApp(cloudRestoreItem.getSplitApkType(), cloudRestoreItem.getOriBackupAppName())) {
                TextView textView = cVarM912h.f651i;
                int i11 = R$string.backup_recover_all_apps_not_support;
                textView.setText(i11);
                if (C0209d.m1269j1()) {
                    cVarM912h.f651i.setText(i11);
                }
            } else if ("thirdApp".equals(cloudRestoreItem.getAppId())) {
                cVarM912h.f651i.setText(R$string.backup_recover_all_apps_not_support);
            } else {
                cVarM912h.f651i.setText(R$string.backup_recover_app_not_support);
            }
            cVarM912h.f651i.setVisibility(cloudRestoreItem.isCompatible() ? 8 : 0);
        }
        if (C0209d.m1195O(this.f629a) < 1.75f && (displayMetrics = this.f640l) != null && displayMetrics.widthPixels > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) cVarM912h.f653k.getLayoutParams();
            if (cVarM912h.f651i.getVisibility() == 0) {
                layoutParams.width = this.f640l.widthPixels / 4;
            } else if (cVarM912h.f650h.getVisibility() == 0) {
                layoutParams.width = this.f640l.widthPixels / 10;
            } else {
                layoutParams.width = 0;
            }
            cVarM912h.f653k.setLayoutParams(layoutParams);
        }
        cVarM912h.f645c.setTag(Integer.valueOf(i10));
        m910f(cVarM912h, cloudRestoreItem);
        m911g(cVarM912h, cloudRestoreItem, i10);
        return viewM76832e;
    }

    /* renamed from: h */
    public final c m912h(View view) {
        c cVar = new c();
        cVar.f645c = (RelativeLayout) C12809f.m76831d(view, R$id.rl_content);
        cVar.f643a = (LinearLayout) C12809f.m76831d(view, R$id.restore_content_list_item);
        cVar.f644b = (CheckBox) C12809f.m76831d(view, R$id.restore_item_checkbox);
        cVar.f646d = (ImageView) C12809f.m76831d(view, R$id.restore_item_icon);
        cVar.f647e = (ImageView) C12809f.m76831d(view, R$id.restore_item_icon_badge);
        cVar.f648f = (TextView) C12809f.m76831d(view, R$id.restore_item_appId);
        cVar.f649g = (TextView) C12809f.m76831d(view, R$id.restore_item_description);
        cVar.f650h = (ImageView) C12809f.m76831d(view, R$id.iv_option_arrow);
        cVar.f651i = (TextView) C12809f.m76831d(view, R$id.restore_item_compatibility_text);
        cVar.f652j = C12809f.m76831d(view, R$id.list_item_divider);
        cVar.f653k = (RelativeLayout) C12809f.m76831d(view, R$id.restore_item_arrow);
        return cVar;
    }

    /* renamed from: i */
    public final boolean m913i(CloudRestoreItem cloudRestoreItem) {
        List<CloudRestoreItem> listM29202r;
        return ("bmBaseData".equals(this.f638j) || (listM29202r = cloudRestoreItem.m29202r()) == null || listM29202r.isEmpty() || !cloudRestoreItem.is3rdAppType()) ? false : true;
    }

    /* renamed from: k */
    public List<CloudRestoreItem> m914k() {
        return this.f632d;
    }

    @Override // android.widget.Adapter
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public CloudRestoreItem getItem(int i10) {
        List<CloudRestoreItem> list = this.f632d;
        if (list == null || i10 >= list.size()) {
            return null;
        }
        return this.f632d.get(i10);
    }

    /* renamed from: m */
    public final String m916m(String str) {
        if (TextUtils.isEmpty(str)) {
            return "#";
        }
        if (!HwTextPinyinUtil.isChinaString(str)) {
            return HwSectionLocaleUtils.getInstance().getLabel(str);
        }
        return HwSectionLocaleUtils.getInstance().getLabel(C13843a.m83056H(str).toUpperCase(Locale.ENGLISH));
    }

    /* renamed from: n */
    public int m917n(int i10) {
        return this.f633e.getPositionForSection(i10);
    }

    /* renamed from: o */
    public int m918o(int i10) {
        return this.f633e.getSectionForPosition(i10);
    }

    /* renamed from: p */
    public Object m919p(int i10) {
        return this.f633e.getSections()[m918o(i10)];
    }

    /* renamed from: q */
    public Object[] m920q() {
        return this.f633e.getSections();
    }

    /* renamed from: r */
    public final void m921r(List<CloudRestoreItem> list) {
        C11839m.m70688i("CloudRestoreChildOptionsAdapter", "initBuildSectionIndexer");
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            m909e(list.get(i10));
        }
        String[] strArr = (String[]) this.f634f.keySet().toArray(new String[0]);
        int length = strArr.length;
        C11839m.m70688i("CloudRestoreChildOptionsAdapter", "size of sections is:" + length);
        Arrays.sort(strArr, new b(null));
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = this.f634f.get(strArr[i11]).intValue();
        }
        this.f633e = new HwSectionIndexer(strArr, iArr);
        m927y(list);
    }

    /* renamed from: s */
    public final boolean m922s() {
        Locale locale = Locale.getDefault();
        if (!locale.getLanguage().equals("zh")) {
            C11839m.m70686d("CloudRestoreChildOptionsAdapter", "isTraditionalCh is not zh");
            return false;
        }
        if (locale.toLanguageTag().contains("zh-Hans")) {
            C11839m.m70686d("CloudRestoreChildOptionsAdapter", "isTraditionalCh is CN_HANS");
            return false;
        }
        if (locale.toLanguageTag().contains("zh-Hant")) {
            C11839m.m70686d("CloudRestoreChildOptionsAdapter", "isTraditionalCh is CN_HANT");
            return true;
        }
        String country = locale.getCountry();
        country.hashCode();
        if (country.equals("CN")) {
            C11839m.m70686d("CloudRestoreChildOptionsAdapter", "isTraditionalCh is CN");
            return false;
        }
        C11839m.m70686d("CloudRestoreChildOptionsAdapter", "isTraditionalCh is not CN");
        return true;
    }

    /* renamed from: u */
    public void m923u(List<CloudRestoreItem> list) {
        List<CloudRestoreItem> list2 = this.f632d;
        if (list2 != null) {
            list2.clear();
            this.f632d.addAll(list);
        } else {
            this.f632d = list;
        }
        notifyDataSetChanged();
    }

    /* renamed from: v */
    public void m924v(View.OnClickListener onClickListener) {
        this.f636h = onClickListener;
    }

    /* renamed from: w */
    public void m925w(View.OnTouchListener onTouchListener) {
        this.f637i = onTouchListener;
    }

    /* renamed from: x */
    public final void m926x(c cVar, CloudRestoreItem cloudRestoreItem) throws Resources.NotFoundException {
        String string;
        int size = cloudRestoreItem.m29202r().size();
        int count = cloudRestoreItem.getCount();
        long size2 = cloudRestoreItem.getSize() + cloudRestoreItem.getAsize();
        String quantityString = this.f630b.getQuantityString(R$plurals.backup_app_data_count, size, Integer.valueOf(size));
        if (size2 > 0) {
            String strM1524g = C0223k.m1524g(C0213f.m1377a(), size2);
            string = "bmBaseData".equals(this.f638j) ? C0209d.m1232a0(strM1524g) : C0213f.m1377a().getString(R$string.backup_option_third_value, Integer.valueOf(count), quantityString, strM1524g);
        } else {
            string = C0213f.m1377a().getString(R$string.backup_option_value_no_size, Integer.valueOf(count), quantityString);
        }
        cVar.f649g.setText(string);
    }

    /* renamed from: y */
    public final void m927y(List<CloudRestoreItem> list) {
        list.sort(new Comparator() { // from class: ae.t0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C0171u0.m907t((CloudRestoreItem) obj, (CloudRestoreItem) obj2);
            }
        });
        list.sort(new C12580p.a());
    }

    /* renamed from: z */
    public void m928z(View view, int i10) throws Resources.NotFoundException {
        List<CloudRestoreItem> list;
        if (view == null || this.f630b == null || (list = this.f632d) == null || i10 >= list.size()) {
            return;
        }
        m911g((c) view.getTag(), this.f632d.get(i10), i10);
    }
}
