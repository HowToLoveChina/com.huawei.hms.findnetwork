package com.huawei.uikit.hwalphaindexerlistview.widget;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.uikit.hwalphaindexerlistview.utils.HwSectionLocaleUtils;
import com.huawei.uikit.hwalphaindexerlistview.utils.HwTextPinyinUtil;
import java.io.UnsupportedEncodingException;
import java.text.CollationKey;
import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes7.dex */
public class HwSortedTextListAdapter extends BaseAdapter {

    /* renamed from: l */
    private static final String f41402l = "HwSortedTextListAdapter";

    /* renamed from: m */
    private static final int f41403m = 16;

    /* renamed from: n */
    private static final String f41404n = "";

    /* renamed from: o */
    private static final int f41405o = -1;

    /* renamed from: a */
    private HwSectionIndexer f41406a;

    /* renamed from: b */
    private int f41407b;

    /* renamed from: c */
    private int f41408c;

    /* renamed from: d */
    private final Object f41409d;

    /* renamed from: e */
    private boolean f41410e;

    /* renamed from: f */
    private Map<String, String> f41411f;

    /* renamed from: g */
    private Map<String, CollationKey> f41412g;

    /* renamed from: h */
    private Context f41413h;

    /* renamed from: i */
    private String f41414i;

    /* renamed from: j */
    private LayoutInflater f41415j;

    /* renamed from: k */
    private List<? extends Map<String, ?>> f41416k;

    public class aauaf implements Comparator<String> {

        /* renamed from: a */
        final /* synthetic */ Collator f41417a;

        public aauaf(Collator collator) {
            this.f41417a = collator;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            int iM53974a;
            if ("".equals(str)) {
                return 1;
            }
            if ("".equals(str2)) {
                return -1;
            }
            if (HwSortedTextListAdapter.this.f41410e) {
                if ("#".equals(str)) {
                    return 1;
                }
                if ("#".equals(str2)) {
                    return -1;
                }
            }
            return (!"zh".equals(Locale.getDefault().getLanguage()) || (iM53974a = HwSortedTextListAdapter.this.m53974a(str, str2)) == 0) ? this.f41417a.compare(str, str2) : iM53974a;
        }
    }

    public class bzrwd implements Comparator<Map<String, ?>> {

        /* renamed from: a */
        final /* synthetic */ Comparator f41419a;

        public bzrwd(Comparator comparator) {
            this.f41419a = comparator;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map<String, ?> map, Map<String, ?> map2) {
            int iM53974a;
            String string = map.get(HwSortedTextListAdapter.this.f41414i).toString();
            String string2 = map2.get(HwSortedTextListAdapter.this.f41414i).toString();
            String str = (String) HwSortedTextListAdapter.this.f41411f.get(string);
            String str2 = (String) HwSortedTextListAdapter.this.f41411f.get(string2);
            if (this.f41419a == null) {
                return 0;
            }
            if ("".equals(str) && "".equals(str2)) {
                return this.f41419a.compare(string, string2);
            }
            if ("".equals(str) && !"".equals(str2)) {
                return 1;
            }
            if ("".equals(str2) && !"".equals(str)) {
                return -1;
            }
            if (HwSortedTextListAdapter.this.f41410e && !str.equals(str2)) {
                if ("#".equals(str)) {
                    return 1;
                }
                if ("#".equals(str2)) {
                    return -1;
                }
            }
            if ("zh".equals(Locale.getDefault().getLanguage()) && (iM53974a = HwSortedTextListAdapter.this.m53974a(str, str2)) != 0) {
                return iM53974a;
            }
            int iCompare = this.f41419a.compare(str, str2);
            return iCompare == 0 ? this.f41419a.compare(string, string2) : iCompare;
        }
    }

    public HwSortedTextListAdapter(Context context, int i10, List<? extends Map<String, ?>> list, String str) {
        this(context, i10, 0, list, str);
    }

    public Context getContext() {
        return this.f41413h;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f41416k.size();
    }

    public LayoutInflater getInflater() {
        return this.f41415j;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return (this.f41416k != null && i10 >= 0 && i10 < getCount()) ? this.f41416k.get(i10).get(this.f41414i) : "";
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    public int getPosition(Map<String, ?> map) {
        return this.f41416k.indexOf(map);
    }

    public int getPositionForSection(int i10) {
        return this.f41406a.getPositionForSection(i10);
    }

    public int getSectionForPosition(int i10) {
        return this.f41406a.getSectionForPosition(i10);
    }

    public Object getSectionNameForPosition(int i10) {
        return this.f41406a.getSections()[getSectionForPosition(i10)];
    }

    public Object[] getSections() {
        return this.f41406a.getSections();
    }

    public String getSortKeyName() {
        return this.f41414i;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        return m53975a(i10, view, viewGroup, this.f41407b);
    }

    public boolean isDigitLast() {
        return this.f41410e;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public void setSortKeyName(String str) {
        this.f41414i = str;
    }

    public void setViewImage(ImageView imageView, String str) {
        if (imageView == null) {
            Log.w(f41402l, "setViewImage: view is null!");
            return;
        }
        try {
            imageView.setImageResource(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            imageView.setImageURI(Uri.parse(str));
        }
    }

    public void setViewText(TextView textView, String str) {
        if (textView == null) {
            Log.w(f41402l, "setViewText: view is null!");
        } else {
            textView.setText(str);
        }
    }

    public void sort(Comparator<Object> comparator) {
        synchronized (this.f41409d) {
            Collections.sort(this.f41416k, new bzrwd(comparator));
        }
        notifyDataSetChanged();
    }

    public HwSortedTextListAdapter(Context context, int i10, int i11, List<? extends Map<String, ?>> list, String str) {
        this(context, i10, i11, list, str, false);
    }

    public HwSortedTextListAdapter(Context context, int i10, int i11, List<? extends Map<String, ?>> list, String str, boolean z10) {
        this.f41408c = 0;
        this.f41409d = new Object();
        this.f41410e = false;
        this.f41413h = context;
        this.f41415j = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f41407b = i10;
        this.f41408c = i11;
        this.f41410e = z10;
        this.f41416k = list;
        this.f41414i = str;
        m53978a();
    }

    /* renamed from: a */
    private View m53975a(int i10, View view, ViewGroup viewGroup, int i11) {
        TextView textView;
        if (view == null) {
            view = this.f41415j.inflate(i11, viewGroup, false);
        }
        try {
            int i12 = this.f41408c;
            if (i12 == 0) {
                textView = view instanceof TextView ? (TextView) view : null;
            } else {
                textView = (TextView) view.findViewById(i12);
            }
            Object item = getItem(i10);
            if (textView != null) {
                if (item instanceof CharSequence) {
                    textView.setText((CharSequence) item);
                } else {
                    textView.setText(String.valueOf(item));
                }
            }
            return view;
        } catch (ClassCastException unused) {
            throw new IllegalStateException("HwSortedTextListAdapter requires the resource ID to be a TextView");
        }
    }

    public void setViewImage(ImageView imageView, int i10) {
        if (imageView == null) {
            Log.w(f41402l, "setViewImage: view is null!");
        } else {
            imageView.setImageResource(i10);
        }
    }

    /* renamed from: a */
    private void m53978a() {
        HwSectionLocaleUtils hwSectionLocaleUtils = HwSectionLocaleUtils.getInstance();
        LinkedHashMap linkedHashMap = new LinkedHashMap(16);
        this.f41411f = new HashMap(16);
        this.f41412g = new HashMap(16);
        Collator collator = Collator.getInstance();
        int size = this.f41416k.size();
        for (int i10 = 0; i10 < size; i10++) {
            String string = this.f41416k.get(i10).get(this.f41414i).toString();
            this.f41412g.put(string, collator.getCollationKey(string));
            String label = TextUtils.isEmpty(string) ? "" : hwSectionLocaleUtils.getLabel(string);
            this.f41411f.put(string, label);
            if (linkedHashMap.containsKey(label)) {
                linkedHashMap.put(label, Integer.valueOf(((Integer) linkedHashMap.get(label)).intValue() + 1));
            } else {
                linkedHashMap.put(label, 1);
            }
        }
        String[] strArr = (String[]) linkedHashMap.keySet().toArray(new String[0]);
        int length = strArr.length;
        m53979a(strArr, collator);
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = ((Integer) linkedHashMap.get(strArr[i11])).intValue();
        }
        this.f41406a = new HwSectionIndexer(strArr, iArr);
        sort(collator);
    }

    /* renamed from: a */
    private void m53979a(String[] strArr, Collator collator) {
        Arrays.sort(strArr, new aauaf(collator));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m53974a(String str, String str2) {
        if (str == null || str2 == null) {
            return 0;
        }
        int length = str.length();
        int length2 = str2.length();
        if (length > length2) {
            return 1;
        }
        return length < length2 ? -1 : 0;
    }

    /* renamed from: a */
    private String m53977a(String str) throws UnsupportedEncodingException {
        String strConvert = HwTextPinyinUtil.getInstance().convert(str);
        return (!TextUtils.isEmpty(strConvert) && strConvert.length() >= 1) ? strConvert.substring(0, 1).toUpperCase(Locale.ENGLISH) : "";
    }
}
