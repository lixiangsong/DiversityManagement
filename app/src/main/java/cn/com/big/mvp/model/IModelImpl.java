package cn.com.big.mvp.model;

import java.util.ArrayList;
import java.util.List;

import cn.com.big.mvp.IModel;
import cn.com.big.mvp.IPresenter;

public class IModelImpl implements IModel {
    @Override
    public void loadData(IPresenter listener) {
        try {
            Thread.sleep(2000);
            List<String> data = new ArrayList<String>();
            data.add("imitate loading data successfully");
            listener.onSuccess(data);
        } catch (Exception e) {
            listener.onFailed();
        }
    }
}
