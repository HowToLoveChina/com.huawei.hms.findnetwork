package com.huawei.android.hicloud.p088ui.uiextend.cloudpay;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.cloud.pay.model.AutoScrollData;
import java.util.ArrayList;
import java.util.List;
import sk.C12809f;

/* loaded from: classes3.dex */
public abstract class ScrollUpView<T> extends ListView implements AutoScrollData<T> {
    private Handler handler;
    private ScrollUpView<T>.AutoScrollAdapter mAutoScrollAdapter;
    private Context mContext;
    private List<T> mDataList;
    private int mMax;
    private OnItemClickListener mOnItemClickListener;
    private int mScrollY;
    private int mSwitchItemScrollY;
    private long mTimer;
    private int position;
    Runnable runnable;

    public class AutoScrollAdapter extends BaseAdapter {
        private AutoScrollAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = ScrollUpView.this.mDataList == null ? 0 : ScrollUpView.this.mDataList.size();
            if (size > 1) {
                return Integer.MAX_VALUE;
            }
            return size;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            return ScrollUpView.this.mDataList.get(i10 % ScrollUpView.this.mMax);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10 % ScrollUpView.this.mMax;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.widget.Adapter
        public View getView(final int i10, View view, ViewGroup viewGroup) {
            View viewInflate;
            ViewHolder viewHolder;
            if (view == null) {
                viewHolder = new ViewHolder();
                viewInflate = LayoutInflater.from(ScrollUpView.this.mContext).inflate(R$layout.pay_banner_detail_item, (ViewGroup) null);
                viewHolder.mIconView = (ImageView) C12809f.m76831d(viewInflate, R$id.banner_icon);
                viewHolder.mInfoView = (TextView) C12809f.m76831d(viewInflate, R$id.banner_info);
                viewInflate.setTag(viewHolder);
            } else {
                viewInflate = view;
                viewHolder = (ViewHolder) view.getTag();
            }
            Object obj = ScrollUpView.this.mDataList.get(i10 % ScrollUpView.this.mMax);
            if (ScrollUpView.this.getBannerPicture(obj) != null && !TextUtils.isEmpty(ScrollUpView.this.getBannerName(obj))) {
                viewHolder.mIconView.setLayoutParams(new RelativeLayout.LayoutParams(-2, ScrollUpView.this.dip2px(r3.getBannerViewHeight())));
                viewHolder.mIconView.setImageBitmap(ScrollUpView.this.getBannerPicture(obj));
                viewHolder.mInfoView.setText(ScrollUpView.this.getBannerName(obj));
                viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.cloudpay.ScrollUpView.AutoScrollAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        ScrollUpView.this.mOnItemClickListener.onItemClick(i10 % ScrollUpView.this.mMax);
                    }
                });
            }
            return viewInflate;
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int i10);
    }

    public static class ViewHolder {
        ImageView mIconView;
        TextView mInfoView;

        private ViewHolder() {
        }
    }

    public ScrollUpView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mDataList = new ArrayList();
        this.position = -1;
        this.mAutoScrollAdapter = new AutoScrollAdapter();
        this.mTimer = 5000L;
        this.handler = new Handler();
        this.runnable = new Runnable() { // from class: com.huawei.android.hicloud.ui.uiextend.cloudpay.ScrollUpView.1
            @Override // java.lang.Runnable
            public void run() {
                if (ScrollUpView.this.mContext != null) {
                    Activity activity = (Activity) ScrollUpView.this.mContext;
                    if (activity.isDestroyed() || activity.isFinishing()) {
                        return;
                    }
                    ScrollUpView.this.switchItem();
                    ScrollUpView.this.handler.postDelayed(this, ScrollUpView.this.mTimer);
                }
            }
        };
        this.mContext = context;
        this.mScrollY = dip2px(getBannerViewHeight());
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dip2px(float f10) {
        return (int) ((f10 * this.mContext.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void init() {
        setFastScrollEnabled(false);
        setDivider(null);
        setDividerHeight(0);
        setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchItem() {
        if (this.position == -1) {
            this.mSwitchItemScrollY = 0;
        } else {
            this.mSwitchItemScrollY = this.mScrollY;
        }
        smoothScrollBy(this.mSwitchItemScrollY, 1000);
        setSelection(this.position);
        this.position++;
    }

    public abstract int getBannerViewHeight();

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void refresh() {
        Context context = this.mContext;
        if (context != null) {
            Activity activity = (Activity) context;
            if (activity.isDestroyed() || activity.isFinishing()) {
                return;
            }
            setSelection(this.position);
        }
    }

    public void setData(List<T> list) {
        List<T> list2 = this.mDataList;
        if (list2 == null || this.mAutoScrollAdapter == null) {
            return;
        }
        list2.clear();
        this.mDataList.addAll(list);
        this.mMax = this.mDataList.size();
        setAdapter((ListAdapter) this.mAutoScrollAdapter);
        this.mAutoScrollAdapter.notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setTimer(long j10) {
        this.mTimer = j10;
    }

    public void start() {
        this.handler.postDelayed(this.runnable, 1000L);
    }

    public void stop() {
        this.handler.removeCallbacks(this.runnable);
    }

    public ScrollUpView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrollUpView(Context context) {
        this(context, null);
    }
}
