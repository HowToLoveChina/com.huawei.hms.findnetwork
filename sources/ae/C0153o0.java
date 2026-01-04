package ae;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppDetailsInfo;
import com.huawei.uikit.hwalphaindexerlistview.utils.HwSectionLocaleUtils;
import com.huawei.uikit.hwalphaindexerlistview.utils.HwTextPinyinUtil;
import com.huawei.uikit.hwalphaindexerlistview.widget.HwSectionIndexer;
import java.io.Serializable;
import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import p015ak.C0209d;
import p015ak.C0223k;
import p514o9.C11839m;
import p514o9.C11842p;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p783xp.C13843a;
import p848zl.C14333b;
import sk.C12809f;

/* renamed from: ae.o0 */
/* loaded from: classes3.dex */
public class C0153o0 extends BaseAdapter {

    /* renamed from: i */
    public static final Collator f552i = Collator.getInstance();

    /* renamed from: a */
    public Context f553a;

    /* renamed from: b */
    public Resources f554b;

    /* renamed from: c */
    public LayoutInflater f555c;

    /* renamed from: d */
    public List<AppDetailsInfo> f556d;

    /* renamed from: e */
    public HwSectionIndexer f557e;

    /* renamed from: f */
    public Map<String, Integer> f558f;

    /* renamed from: g */
    public Map<String, String> f559g;

    /* renamed from: h */
    public boolean f560h = m861q();

    /* renamed from: ae.o0$a */
    public class a extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ Handler f561a;

        public a(Handler handler) {
            this.f561a = handler;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(C0153o0.this.f556d);
                C0153o0.this.m860p(copyOnWriteArrayList);
                this.f561a.removeMessages(330001);
                Message messageObtain = Message.obtain();
                messageObtain.what = 330001;
                messageObtain.obj = copyOnWriteArrayList;
                this.f561a.sendMessageDelayed(messageObtain, 0L);
            } catch (Exception e10) {
                C11839m.m70688i("CloudBasicDataAdapter", "initBuildSectionIndexer error," + e10.getMessage());
            }
        }
    }

    /* renamed from: ae.o0$b */
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
            return C0153o0.f552i.compare(str, str2);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* renamed from: ae.o0$c */
    public static class c {

        /* renamed from: a */
        public ImageView f563a;

        /* renamed from: b */
        public TextView f564b;

        /* renamed from: c */
        public TextView f565c;

        /* renamed from: d */
        public View f566d;
    }

    public C0153o0(Context context, Handler handler, List<AppDetailsInfo> list) {
        this.f553a = context;
        this.f556d = list;
        Context context2 = this.f553a;
        if (context2 != null) {
            this.f554b = context2.getResources();
            this.f555c = (LayoutInflater) this.f553a.getSystemService("layout_inflater");
        }
        C12515a.m75110o().m75172d(new a(handler));
    }

    /* renamed from: i */
    public static int m848i(String str, String str2, String str3, String str4) {
        if ("".equals(str) && "".equals(str2)) {
            return f552i.compare(str3, str4);
        }
        if ("".equals(str)) {
            return 1;
        }
        return "".equals(str2) ? -1 : 0;
    }

    /* renamed from: r */
    public static /* synthetic */ int m849r(AppDetailsInfo appDetailsInfo, AppDetailsInfo appDetailsInfo2) {
        String name = appDetailsInfo.getName();
        String name2 = appDetailsInfo2.getName();
        String strM83056H = C13843a.m83056H(appDetailsInfo.getName());
        String strM83056H2 = C13843a.m83056H(appDetailsInfo2.getName());
        return ("".equals(strM83056H) || "".equals(strM83056H2)) ? m848i(strM83056H, strM83056H2, name, name2) : f552i.compare(strM83056H, strM83056H2);
    }

    /* renamed from: e */
    public final void m850e(AppDetailsInfo appDetailsInfo) {
        if (this.f558f == null) {
            this.f558f = new LinkedHashMap(16);
        }
        if (this.f559g == null) {
            this.f559g = new HashMap(16);
        }
        if (appDetailsInfo == null) {
            C11839m.m70688i("CloudBasicDataAdapter", "restoreItem in addOneFileToSectionMap is null");
            return;
        }
        String name = appDetailsInfo.getName();
        String strM855k = m855k(name);
        if (this.f560h && "#".equals(strM855k)) {
            return;
        }
        this.f559g.put(name, strM855k);
        if (!this.f558f.containsKey(strM855k)) {
            this.f558f.put(strM855k, 1);
        } else {
            Map<String, Integer> map = this.f558f;
            map.put(strM855k, Integer.valueOf(map.get(strM855k).intValue() + 1));
        }
    }

    /* renamed from: f */
    public final void m851f(c cVar, AppDetailsInfo appDetailsInfo) {
        String backupAppName = appDetailsInfo.getBackupAppName();
        Drawable drawable = C14333b.m85483r().containsKey(backupAppName) ? CloudBackup3rdIconUtil.getDrawable(backupAppName) : CloudBackup3rdIconUtil.get3rdDrawable(backupAppName);
        cVar.f563a.setTag(backupAppName);
        cVar.f563a.setImageDrawable(drawable);
    }

    /* renamed from: g */
    public final void m852g(c cVar, AppDetailsInfo appDetailsInfo, int i10) {
        cVar.f564b.setText(appDetailsInfo.getName());
        String strM1232a0 = C0209d.m1232a0(C0223k.m1524g(this.f553a, appDetailsInfo.getTotalSize()));
        if (appDetailsInfo.getTotalSize() != 0) {
            cVar.f565c.setText(strM1232a0);
        } else {
            cVar.f565c.setVisibility(8);
        }
        cVar.f566d.setVisibility(getCount() + (-1) != i10 ? 0 : 8);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f556d.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        List<AppDetailsInfo> list;
        AppDetailsInfo appDetailsInfo;
        c cVarM853h;
        View viewM76832e;
        if (this.f554b == null || (list = this.f556d) == null || i10 >= list.size() || (appDetailsInfo = this.f556d.get(i10)) == null) {
            return view;
        }
        if (view == null) {
            viewM76832e = C12809f.m76832e(this.f555c, R$layout.item_backup_basic_data_content_detail);
            cVarM853h = m853h(viewM76832e);
            viewM76832e.setTag(cVarM853h);
        } else {
            cVarM853h = (c) view.getTag();
            viewM76832e = view;
        }
        if (cVarM853h == null) {
            return view;
        }
        m851f(cVarM853h, appDetailsInfo);
        m852g(cVarM853h, appDetailsInfo, i10);
        return viewM76832e;
    }

    /* renamed from: h */
    public final c m853h(View view) {
        c cVar = new c();
        cVar.f563a = (ImageView) C12809f.m76831d(view, R$id.item_icon);
        TextView textView = (TextView) C12809f.m76831d(view, R$id.item_name);
        cVar.f564b = textView;
        C11842p.m70721D1(textView, 1.45f);
        TextView textView2 = (TextView) C12809f.m76831d(view, R$id.item_size);
        cVar.f565c = textView2;
        C11842p.m70721D1(textView2, 1.45f);
        cVar.f566d = C12809f.m76831d(view, R$id.item_divider);
        return cVar;
    }

    @Override // android.widget.Adapter
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public AppDetailsInfo getItem(int i10) {
        List<AppDetailsInfo> list = this.f556d;
        if (list == null || i10 >= list.size()) {
            return null;
        }
        return this.f556d.get(i10);
    }

    /* renamed from: k */
    public final String m855k(String str) {
        if (TextUtils.isEmpty(str)) {
            return "#";
        }
        if (!HwTextPinyinUtil.isChinaString(str)) {
            return HwSectionLocaleUtils.getInstance().getLabel(str);
        }
        return HwSectionLocaleUtils.getInstance().getLabel(C13843a.m83056H(str).toUpperCase(Locale.ENGLISH));
    }

    /* renamed from: l */
    public int m856l(int i10) {
        return this.f557e.getPositionForSection(i10);
    }

    /* renamed from: m */
    public int m857m(int i10) {
        return this.f557e.getSectionForPosition(i10);
    }

    /* renamed from: n */
    public Object m858n(int i10) {
        return this.f557e.getSections()[m857m(i10)];
    }

    /* renamed from: o */
    public Object[] m859o() {
        return this.f557e.getSections();
    }

    /* renamed from: p */
    public final void m860p(List<AppDetailsInfo> list) {
        C11839m.m70688i("CloudBasicDataAdapter", "initBuildSectionIndexer");
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            m850e(list.get(i10));
        }
        String[] strArr = (String[]) this.f558f.keySet().toArray(new String[0]);
        int length = strArr.length;
        C11839m.m70688i("CloudBasicDataAdapter", "size of sections is:" + length);
        Arrays.sort(strArr, new b(null));
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = this.f558f.get(strArr[i11]).intValue();
        }
        this.f557e = new HwSectionIndexer(strArr, iArr);
        m863t(list);
    }

    /* renamed from: q */
    public final boolean m861q() {
        Locale locale = Locale.getDefault();
        if (!locale.getLanguage().equals("zh")) {
            C11839m.m70686d("CloudBasicDataAdapter", "isTraditionalCh is not zh");
            return false;
        }
        if (locale.toLanguageTag().contains("zh-Hans")) {
            C11839m.m70686d("CloudBasicDataAdapter", "isTraditionalCh is CN_HANS");
            return false;
        }
        if (locale.toLanguageTag().contains("zh-Hant")) {
            C11839m.m70686d("CloudBasicDataAdapter", "isTraditionalCh is CN_HANT");
            return true;
        }
        String country = locale.getCountry();
        country.hashCode();
        if (country.equals("CN")) {
            C11839m.m70686d("CloudBasicDataAdapter", "isTraditionalCh is CN");
            return false;
        }
        C11839m.m70686d("CloudBasicDataAdapter", "isTraditionalCh is not CN");
        return true;
    }

    /* renamed from: s */
    public void m862s(List<AppDetailsInfo> list) {
        List<AppDetailsInfo> list2 = this.f556d;
        if (list2 != null) {
            list2.clear();
            this.f556d.addAll(list);
        } else {
            this.f556d = list;
        }
        notifyDataSetChanged();
    }

    /* renamed from: t */
    public final void m863t(List<AppDetailsInfo> list) {
        list.sort(new Comparator() { // from class: ae.n0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C0153o0.m849r((AppDetailsInfo) obj, (AppDetailsInfo) obj2);
            }
        });
    }

    /* renamed from: u */
    public void m864u(View view, int i10) {
        List<AppDetailsInfo> list;
        if (view == null) {
            C11839m.m70687e("CloudBasicDataAdapter", "updateViewIcon view is null");
        } else if (this.f554b == null || (list = this.f556d) == null || i10 >= list.size()) {
            C11839m.m70687e("CloudBasicDataAdapter", "updateViewIcon modulesList is null");
        } else {
            m851f((c) view.getTag(), this.f556d.get(i10));
        }
    }
}
