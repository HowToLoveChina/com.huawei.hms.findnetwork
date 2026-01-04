package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.uiextend.cloudpay.OnRefreshListener;
import com.huawei.android.hicloud.p088ui.uiextend.cloudpay.PullableListViewForOrderList;
import com.huawei.android.p073ds.R$id;
import sk.C12809f;

/* loaded from: classes3.dex */
public class PullableListViewForVoucherList extends PullableListViewForOrderList {
    private boolean hasMoreData;

    public PullableListViewForVoucherList(Context context) {
        super(context);
        this.hasMoreData = true;
    }

    public boolean hasMoreData() {
        return this.hasMoreData;
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.cloudpay.PullableListViewForOrderList
    public void initFooterView() {
        super.initFooterView();
        TextView textView = (TextView) C12809f.m76831d(this.footerView, R$id.cloudpay_loading_text);
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.cloudpay.PullableListViewForOrderList, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i10) {
        if (i10 == 0 && getLastVisiblePosition() == getCount() - 1 && !this.isLoadingMore && this.hasMoreData) {
            this.isLoadingMore = true;
            this.footerView.setPadding(0, 0, 0, 0);
            setSelection(getCount());
            OnRefreshListener onRefreshListener = this.listener;
            if (onRefreshListener != null) {
                onRefreshListener.onLoadingMore();
            }
        }
    }

    public void setHasMoreData(boolean z10) {
        this.hasMoreData = z10;
    }

    public PullableListViewForVoucherList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hasMoreData = true;
    }
}
