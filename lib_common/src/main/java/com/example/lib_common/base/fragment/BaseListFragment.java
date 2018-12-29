package com.example.lib_common.base.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AbsListView;

import com.example.lib_common.base.BasePresenter;
import com.example.lib_common.base.BaseView;
import com.example.lib_common.base.States;
import com.example.lib_common.base.bean.BaseItem;
import com.example.lib_common.util.ViewUtil;

import java.util.List;

/**
 * @author : 叶天华
 * @project: Monkey
 * @date : 2018/12/24
 * @time : 11:18
 * @email : 15869107730@163.com
 * @note :
 */
public abstract class BaseListFragment<V extends BaseView, T extends BasePresenter<V>> extends BaseFragment implements AbsListView.OnScrollListener {

    protected RecyclerView mRecyclerView;
    protected List<BaseItem> mItems;
    protected View mEmpty;
    protected SwipeRefreshLayout mRefreshLayout;

    private int mState;

    /**
     * 没有数据时展示
     *
     * @param visible          是否可见
     * @param netWorkException 是否为网络原因
     * @param text             提示内容
     */
    public void setEmptyViewVisible(boolean visible, boolean netWorkException, String text) {
        ViewUtil.setEmptyViewVisible(mEmpty, getContext(), visible, netWorkException, text);
    }

    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {
        if (mState == States.RECYCLER_GET_MORE && (i + i1) == i2) {
            List<BaseItem> items = mItems;
            if (items != null && items.size() > 0) {
                BaseItem baseItem = items.get(items.size() - 1);
                if (baseItem != null && baseItem.itemType == States.LOAD_MORE) {
                    onLoadMore();
                }
            }
        }
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    protected void onLoadMore() {

    }
}