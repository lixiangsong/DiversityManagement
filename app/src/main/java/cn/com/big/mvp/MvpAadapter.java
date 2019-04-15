package cn.com.big.mvp;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.com.big.R;
import cn.com.big.mvp.bean.MvpBean;

public class MvpAadapter extends BaseQuickAdapter<MvpBean, BaseViewHolder> {
    public MvpAadapter(List<MvpBean> data) {
        super(R.layout.activity_mvp_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MvpBean item) {

    }
}
