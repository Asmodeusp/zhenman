package com.zhenman.asus.zhenman.view.adapter.serialization;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.zhenman.asus.zhenman.model.bean.ShelfCollectionBean;

import java.util.List;

public class ShelfCollection extends BaseExpandableListAdapter {
    private List<ShelfCollectionBean.DataBean.ResultBean> resultBeanList;
    private Context context;
    public static final String EDITING = "编辑";
    public static final String FINISH_EDITING = "完成";

    public ShelfCollection(List<ShelfCollectionBean.DataBean.ResultBean> resultBeanList, Context context) {
        this.resultBeanList = resultBeanList;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return resultBeanList.isEmpty() ? 0 : resultBeanList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
