package com.huawei.android.hicloud.p088ui.uiextend.cloudpay;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import com.huawei.android.hicloud.p088ui.common.HiCloudExceptionView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import java.util.ArrayList;
import p015ak.C0209d;
import p845zi.C14302a;
import sk.C12806c;
import sk.C12809f;

/* loaded from: classes3.dex */
public class PullableListViewForOrderList extends ListView implements AbsListView.OnScrollListener {
    HiCloudExceptionView exceptionView;
    HiCloudExceptionView exceptionViewServerFail;
    protected View footerView;
    protected int footerViewHeight;
    private View headerView;
    private int headerViewHeight;
    protected boolean isLoadingMore;
    protected OnRefreshListener listener;
    private Context mContext;

    public PullableListViewForOrderList(Context context) {
        this(context, null);
        this.mContext = context;
    }

    private void init() throws Resources.NotFoundException {
        initHeaderView();
        initFooterView();
        setOnScrollListener(this);
    }

    private void initHeaderView() throws Resources.NotFoundException {
        View viewInflate = View.inflate(getContext(), R$layout.pay_order_list_head, null);
        this.headerView = viewInflate;
        this.exceptionView = (HiCloudExceptionView) C12809f.m76831d(viewInflate, R$id.exception_no_intent);
        HiCloudExceptionView hiCloudExceptionView = (HiCloudExceptionView) C12809f.m76831d(this.headerView, R$id.exception_server_fail);
        this.exceptionViewServerFail = hiCloudExceptionView;
        hiCloudExceptionView.m23915b();
        this.exceptionViewServerFail.m23916c();
        this.exceptionViewServerFail.setContent(R$string.exception_connect_server_fail_msg);
        this.headerView.measure(0, 0);
        int measuredHeight = this.headerView.getMeasuredHeight() / 2;
        this.headerViewHeight = measuredHeight;
        this.headerView.setPadding(0, -measuredHeight, 0, 0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.exceptionView);
        arrayList.add(this.exceptionViewServerFail);
        C12806c.m76817h(this.mContext, arrayList);
        addHeaderView(this.headerView);
    }

    public void completeRefresh() {
        if (this.isLoadingMore) {
            this.footerView.setPadding(0, -this.footerViewHeight, 0, 0);
            this.isLoadingMore = false;
        }
    }

    public void initFooterView() {
        View viewInflate = View.inflate(getContext(), R$layout.pay_order_list_refresh, null);
        this.footerView = viewInflate;
        viewInflate.measure(0, 0);
        int measuredHeight = this.footerView.getMeasuredHeight();
        this.footerViewHeight = measuredHeight;
        this.footerView.setPadding(0, -measuredHeight, 0, 0);
        addFooterView(this.footerView);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i10) {
        if (i10 == 0 && getLastVisiblePosition() == getCount() - 1 && !this.isLoadingMore && C14302a.m85176d().m85182g()) {
            this.isLoadingMore = true;
            this.footerView.setPadding(0, 0, 0, 0);
            setSelection(getCount());
            OnRefreshListener onRefreshListener = this.listener;
            if (onRefreshListener != null) {
                onRefreshListener.onLoadingMore();
            }
        }
    }

    public void setNoNetWorkType() {
        Context context = this.mContext;
        if (context != null) {
            if (C0209d.m1333z1(context)) {
                this.headerView.setPadding(0, 0, 0, 0);
                this.exceptionView.m23914a();
            } else {
                this.headerView.setPadding(0, -this.headerViewHeight, 0, 0);
                this.exceptionView.m23919i();
            }
            this.exceptionViewServerFail.m23914a();
        }
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.listener = onRefreshListener;
    }

    public void setServerFailListener(View.OnClickListener onClickListener) {
        this.exceptionViewServerFail.setHandleClickListener(onClickListener);
        this.exceptionViewServerFail.setRetryClickListener(onClickListener);
    }

    public void setServerFailType(boolean z10) {
        if (z10) {
            this.headerView.setPadding(0, -this.headerViewHeight, 0, 0);
            this.exceptionViewServerFail.m23919i();
        } else {
            this.headerView.setPadding(0, 0, 0, 0);
            this.exceptionViewServerFail.m23914a();
        }
        this.exceptionView.m23914a();
    }

    public PullableListViewForOrderList(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        this.isLoadingMore = false;
        this.mContext = context;
        init();
    }
}
