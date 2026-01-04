package com.huawei.uikit.hwalphaindexerlistview.widget;

import android.content.res.Resources;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.huawei.uikit.hwalphaindexerlistview.widget.HwAlphaIndexerListView;

/* loaded from: classes7.dex */
public class HwQuickIndexController {

    /* renamed from: j */
    private static final int f41384j = 1;

    /* renamed from: k */
    private static final int f41385k = 1;

    /* renamed from: a */
    private HwSortedTextListAdapter f41386a;

    /* renamed from: b */
    private HwAlphaIndexerListView f41387b;

    /* renamed from: c */
    private ListView f41388c;

    /* renamed from: d */
    private View.OnTouchListener f41389d;

    /* renamed from: e */
    private View.OnKeyListener f41390e;

    /* renamed from: f */
    private boolean f41391f;

    /* renamed from: g */
    private boolean f41392g;

    /* renamed from: h */
    private AbsListView.OnScrollListener f41393h = new bzrwd();

    /* renamed from: i */
    private HwAlphaIndexerListView.OnItemClickListener f41394i = new aauaf();

    public class aauaf implements HwAlphaIndexerListView.OnItemClickListener {
        public aauaf() {
        }

        @Override // com.huawei.uikit.hwalphaindexerlistview.widget.HwAlphaIndexerListView.OnItemClickListener
        public void onItemClick(String str, int i10) throws Resources.NotFoundException {
            int i11;
            String str2;
            if (str == null || HwQuickIndexController.this.f41386a == null) {
                return;
            }
            HwQuickIndexController.this.f41392g = false;
            Object[] sections = HwQuickIndexController.this.f41386a.getSections();
            if (sections instanceof String[]) {
                String[] strArr = (String[]) sections;
                int i12 = 0;
                while (true) {
                    if (i12 >= strArr.length) {
                        i11 = i10;
                        str2 = null;
                        break;
                    } else {
                        if (HwQuickIndexController.this.f41387b.equalsChar(str, strArr[i12], i10)) {
                            i11 = i12;
                            str2 = strArr[i12];
                            break;
                        }
                        i12++;
                    }
                }
                if (str2 != null) {
                    HwQuickIndexController.this.m53964a(str2, i11, i10);
                    return;
                }
                if (!HwQuickIndexController.this.f41387b.needSwitchIndexer(i10)) {
                    HwQuickIndexController.this.m53965a(str, i10, strArr, i11, str2);
                } else if (HwQuickIndexController.this.f41387b.isNativeIndexerShow()) {
                    HwQuickIndexController.this.f41388c.setSelection(HwQuickIndexController.this.f41388c.getCount() - 1);
                } else {
                    HwQuickIndexController.this.f41388c.setSelection(0);
                }
            }
        }
    }

    public class bzrwd implements AbsListView.OnScrollListener {
        public bzrwd() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i10, int i11, int i12) throws Resources.NotFoundException {
            View childAt;
            if (HwQuickIndexController.this.f41386a == null) {
                return;
            }
            int i13 = i11 + i10;
            if (i13 < i12 || HwQuickIndexController.this.f41388c.getSelectedItemPosition() == i10) {
                HwQuickIndexController.this.f41392g = false;
            }
            if (i13 == i12 && (childAt = HwQuickIndexController.this.f41388c.getChildAt(HwQuickIndexController.this.f41388c.getChildCount() - 1)) != null && childAt.getBottom() != HwQuickIndexController.this.f41388c.getHeight()) {
                HwQuickIndexController.this.f41392g = false;
            }
            if (!HwQuickIndexController.this.f41392g) {
                HwQuickIndexController.this.f41387b.invalidate();
                HwQuickIndexController.this.f41387b.setOverLayInfo(HwQuickIndexController.this.m53960a(HwQuickIndexController.this.f41386a.getSectionForPosition(i10)));
            }
            if (HwQuickIndexController.this.f41391f) {
                HwQuickIndexController.this.f41387b.showPopup();
                HwQuickIndexController.this.f41388c.sendAccessibilityEvent(4096);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i10) {
            HwQuickIndexController.this.f41392g = false;
            if (i10 != 0) {
                HwQuickIndexController.this.f41391f = true;
            } else {
                HwQuickIndexController.this.f41391f = false;
                HwQuickIndexController.this.f41387b.dismissPopup();
            }
        }
    }

    public HwQuickIndexController(ListView listView, HwAlphaIndexerListView hwAlphaIndexerListView) throws Resources.NotFoundException {
        this.f41388c = listView;
        this.f41387b = hwAlphaIndexerListView;
        hwAlphaIndexerListView.setListViewAttachTo(listView);
        ListAdapter adapter = listView.getAdapter();
        if (adapter instanceof HwSortedTextListAdapter) {
            this.f41386a = (HwSortedTextListAdapter) adapter;
            this.f41387b.setSectionText(m53960a(this.f41386a.getSectionForPosition(this.f41388c.getFirstVisiblePosition())));
        }
    }

    public View.OnKeyListener getOnKeyListener() {
        return this.f41390e;
    }

    public AbsListView.OnScrollListener getOnScrollListener() {
        return this.f41393h;
    }

    public View.OnTouchListener getOnTouchListener() {
        return this.f41389d;
    }

    public void setOnKeyListener(View.OnKeyListener onKeyListener) {
        this.f41390e = onKeyListener;
    }

    public void setOnListen() {
        ListView listView = this.f41388c;
        if (listView == null || this.f41387b == null) {
            return;
        }
        listView.setOnScrollListener(getOnScrollListener());
        this.f41388c.setOnTouchListener(getOnTouchListener());
        this.f41388c.setOnKeyListener(getOnKeyListener());
        this.f41387b.setOnItemClickListener(this.f41394i);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f41393h = onScrollListener;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.f41389d = onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m53965a(String str, int i10, String[] strArr, int i11, String str2) throws Resources.NotFoundException {
        if (str == null || strArr == null || strArr.length == 0) {
            return;
        }
        int size = this.f41387b.mAlphabets.size();
        int i12 = i10 + 1;
        if (HwAlphaIndexerListView.BULLET_CHAR.equals(str) && i12 < size) {
            int i13 = 0;
            while (true) {
                if (i13 >= strArr.length) {
                    break;
                }
                if (this.f41387b.equalsChar(str, strArr[i13], i12)) {
                    str2 = strArr[i13];
                    i11 = i13;
                    break;
                }
                i13++;
            }
            this.f41387b.showPopup(this.f41387b.mAlphabets.get(i12));
            if (str2 != null) {
                m53964a(str2, i11, i10);
                return;
            }
            return;
        }
        this.f41387b.showPopup(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m53960a(int i10) {
        if (this.f41386a.getSections().length > i10 && i10 >= 0) {
            Object obj = this.f41386a.getSections()[i10];
            if (obj instanceof String) {
                return (String) obj;
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m53964a(String str, int i10, int i11) throws Resources.NotFoundException {
        int positionForSection = this.f41386a.getPositionForSection(i10);
        int lastVisiblePosition = (this.f41388c.getLastVisiblePosition() - this.f41388c.getFirstVisiblePosition()) + 1;
        if (positionForSection != -1 && positionForSection + lastVisiblePosition <= this.f41388c.getCount()) {
            this.f41388c.setSelection(positionForSection);
        }
        if (positionForSection + lastVisiblePosition > this.f41388c.getCount()) {
            this.f41392g = true;
            ListView listView = this.f41388c;
            listView.setSelection(listView.getCount() - 1);
        }
        this.f41387b.setOverLayInfo(i11, str);
        this.f41387b.showPopup(str);
    }
}
