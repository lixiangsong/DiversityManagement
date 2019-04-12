package cn.com.big.mvp;

import java.util.List;

public interface IPresenter {
    void loadData();//告诉Model开始loadData

    void onSuccess(List<String> data);

    void onFailed();

}
