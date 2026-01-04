package com.huawei.android.hicloud.p088ui.uiextend;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Scroller;
import com.huawei.android.hicloud.p088ui.uilistener.OnDataRange;
import com.huawei.android.p073ds.R$string;
import p273f0.C9603h0;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class PullUpListView extends ListView implements AbsListView.OnScrollListener {
    private static final int SCROLL_STATE_DEFAULT = -1;
    protected static final String TAG = "PullUpListView";
    private boolean bEnableChangeLoadingView;
    private View bottomCardLayout;
    private int currScrollState;
    protected OnDataRange dataRange;
    private boolean interceptScrollOnBottom;
    private boolean interceptScrollOnTop;
    private OnLoadingListener loadingListener;
    private boolean mEnablePullRefresh;
    protected FooterView mFooterView;
    private boolean mPullRefreshing;
    private Scroller mScroller;
    private int mTotalNumber;
    private boolean needFootView;
    private AbsListView.OnScrollListener scrollListener;
    protected int totalItemCount;
    protected int visibleItemCount;

    public interface OnLoadingListener {
        void onLoadingMore();

        void onLoadingRetry();

        void onRefresh();
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.huawei.android.hicloud.ui.uiextend.PullUpListView.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        };
        private boolean bloadingFailed;

        public String toString() {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append("PullUpListView.SavedState{");
            sb2.append(Integer.toHexString(System.identityHashCode(this)));
            sb2.append(" bloadingFailed=");
            sb2.append(this.bloadingFailed);
            sb2.append("}");
            return sb2.toString();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeValue(Boolean.valueOf(this.bloadingFailed));
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            this.bloadingFailed = false;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.bloadingFailed = false;
            this.bloadingFailed = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    public PullUpListView(Context context) {
        super(context);
        this.mTotalNumber = 0;
        this.mFooterView = null;
        this.loadingListener = null;
        this.dataRange = null;
        this.bEnableChangeLoadingView = true;
        this.scrollListener = null;
        this.needFootView = true;
        this.mEnablePullRefresh = false;
        this.mPullRefreshing = false;
        this.currScrollState = -1;
        this.bottomCardLayout = null;
        this.interceptScrollOnTop = false;
        this.interceptScrollOnBottom = false;
        initView(context);
    }

    private void initView(Context context) {
        this.mScroller = new Scroller(context, new DecelerateInterpolator());
        super.setOnScrollListener(this);
    }

    public void beginLoading() {
        FooterView footerView = this.mFooterView;
        if (footerView != null) {
            footerView.reset();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            postInvalidate();
        }
        super.computeScroll();
    }

    public void doExec() {
        OnDataRange onDataRange;
        int i10;
        int footerViewsCount = getFooterViewsCount() + getHeaderViewsCount();
        int i11 = this.visibleItemCount;
        if (i11 == 0 || (onDataRange = this.dataRange) == null || (i10 = this.totalItemCount) <= footerViewsCount || i10 > i11) {
            return;
        }
        if (!onDataRange.mo24801a()) {
            this.mFooterView.hide();
            return;
        }
        if (this.mFooterView.getCurrentState() != 2) {
            this.mFooterView.changeFooterState(2);
            OnLoadingListener onLoadingListener = this.loadingListener;
            if (onLoadingListener != null) {
                onLoadingListener.onLoadingMore();
            }
        }
    }

    public View getBottomCardLayout() {
        return this.bottomCardLayout;
    }

    public View getFootView() {
        return this.mFooterView;
    }

    public OnLoadingListener getLoadingListener() {
        return this.loadingListener;
    }

    @Override // android.widget.AbsListView
    public void handleDataChanged() {
        super.handleDataChanged();
        FooterView footerView = this.mFooterView;
        if (footerView == null) {
            return;
        }
        if (this.bEnableChangeLoadingView) {
            footerView.changeFooterState(0);
        }
        if (!this.dataRange.mo24801a()) {
            this.mFooterView.hide();
        } else if (this.currScrollState != -1) {
            this.mFooterView.show();
        }
    }

    public boolean isNeedFootView() {
        return this.needFootView;
    }

    public boolean isOnBottom() {
        return !C9603h0.m59881f(this, 1);
    }

    public boolean isOnTop() {
        return !C9603h0.m59881f(this, -1);
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void layoutChildren() {
        try {
            super.layoutChildren();
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "layoutChildren error: " + e10.toString());
        }
    }

    public void loadingFailed() {
        FooterView footerView = this.mFooterView;
        if (footerView == null) {
            return;
        }
        footerView.loadingFailed(getResources().getString(R$string.net_not_avaliable_retry), new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.PullUpListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PullUpListView.this.loadingListener != null) {
                    PullUpListView.this.mFooterView.changeFooterState(2);
                    PullUpListView.this.loadingListener.onLoadingRetry();
                }
            }
        });
    }

    @Override // android.widget.AbsListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.bloadingFailed) {
            loadingFailed();
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z10;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        FooterView footerView = this.mFooterView;
        if (footerView != null && (z10 = footerView.isLoadingFailed)) {
            savedState.bloadingFailed = z10;
        }
        return savedState;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        OnDataRange onDataRange;
        this.visibleItemCount = i11;
        this.totalItemCount = i12;
        if (this.mFooterView != null) {
            doExec();
        }
        if (this.currScrollState == -1) {
            return;
        }
        if (this.mFooterView != null && (onDataRange = this.dataRange) != null && onDataRange.mo24801a()) {
            this.mFooterView.show();
        }
        this.mTotalNumber = i12;
        C11839m.m70686d(TAG, "firstVisibleItem:" + i10);
        C11839m.m70686d(TAG, "visibleItemCount:" + i11);
        C11839m.m70686d(TAG, "totalnmber:" + this.mTotalNumber);
        AbsListView.OnScrollListener onScrollListener = this.scrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i10, i11, i12);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i10) {
        FooterView footerView;
        this.currScrollState = i10;
        if (!this.mPullRefreshing && i10 == 0 && (footerView = this.mFooterView) != null && footerView.getCurrentState() != 3 && getLastVisiblePosition() >= this.mTotalNumber - 4 && this.mFooterView.getCurrentState() != 2) {
            this.mFooterView.changeFooterState(2);
            OnLoadingListener onLoadingListener = this.loadingListener;
            if (onLoadingListener != null) {
                onLoadingListener.onLoadingMore();
            }
        }
        AbsListView.OnScrollListener onScrollListener = this.scrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i10);
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mEnablePullRefresh) {
            try {
                return super.onTouchEvent(motionEvent);
            } catch (Exception e10) {
                C11839m.m70687e(TAG, "onTouchEvent error: " + e10.toString());
            }
        }
        return false;
    }

    @Override // android.view.View
    public boolean overScrollBy(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, boolean z10) {
        int i18 = (!this.interceptScrollOnTop || i11 >= 0 || !isOnTop() || isOnBottom()) ? i11 : 0;
        if (this.interceptScrollOnBottom && i18 > 0 && i13 >= 0 && isOnTop() && isOnBottom()) {
            i18 = 0;
        }
        FooterView footerView = this.mFooterView;
        return super.overScrollBy(i10, (footerView == null || footerView.getCurrentState() == 3 || !isOnBottom()) ? i18 : 0, i12, i13, i14, i15, i16, i17, z10);
    }

    public void setBottomCardLayout(View view) {
        this.bottomCardLayout = view;
    }

    public void setEnableChangeLoadingView(boolean z10) {
        this.bEnableChangeLoadingView = z10;
    }

    public void setInterceptScrollOnTop(boolean z10) {
        this.interceptScrollOnTop = z10;
    }

    public void setLoadingListener(OnLoadingListener onLoadingListener) {
        this.loadingListener = onLoadingListener;
    }

    public void setNeedFootView(boolean z10) {
        this.needFootView = z10;
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.scrollListener = onScrollListener;
    }

    public void setmPullRefreshing(boolean z10) {
        this.mPullRefreshing = z10;
    }

    public void showFooterBlankView() {
        FooterView footerView = this.mFooterView;
        if (footerView != null) {
            footerView.showBlanView();
        }
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof OnDataRange) {
            this.dataRange = (OnDataRange) listAdapter;
            if (getFooterViewsCount() == 0 && isNeedFootView()) {
                FooterView footerView = new FooterView(getContext());
                this.mFooterView = footerView;
                addFooterView(footerView);
                if (!this.dataRange.mo24801a()) {
                    this.mFooterView.hide();
                }
            }
        }
        super.setAdapter(listAdapter);
    }

    public PullUpListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTotalNumber = 0;
        this.mFooterView = null;
        this.loadingListener = null;
        this.dataRange = null;
        this.bEnableChangeLoadingView = true;
        this.scrollListener = null;
        this.needFootView = true;
        this.mEnablePullRefresh = false;
        this.mPullRefreshing = false;
        this.currScrollState = -1;
        this.bottomCardLayout = null;
        this.interceptScrollOnTop = false;
        this.interceptScrollOnBottom = false;
        initView(context);
    }

    public PullUpListView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mTotalNumber = 0;
        this.mFooterView = null;
        this.loadingListener = null;
        this.dataRange = null;
        this.bEnableChangeLoadingView = true;
        this.scrollListener = null;
        this.needFootView = true;
        this.mEnablePullRefresh = false;
        this.mPullRefreshing = false;
        this.currScrollState = -1;
        this.bottomCardLayout = null;
        this.interceptScrollOnTop = false;
        this.interceptScrollOnBottom = false;
        initView(context);
    }
}
