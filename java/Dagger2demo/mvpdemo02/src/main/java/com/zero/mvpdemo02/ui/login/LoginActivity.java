package com.zero.mvpdemo02.ui.login;

import com.zero.mvpdemo02.R;
import com.zero.mvpdemo02.base.BaseActivity;
import com.zero.mvpdemo02.ui.UIUtils;


public class LoginActivity extends BaseActivity<LoginContract.Presenter>{

    @Override
    protected int layoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {

        LoginFragment loginFragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrameLayout);
        if (loginFragment == null) {
            loginFragment = LoginFragment.newInstance();
            UIUtils.addFragmentToActivity(getSupportFragmentManager(), loginFragment, R.id.contentFrameLayout);
        }
        //初始化Presenter
        mPresenter = new LoginPresenter();
        //外部注入
        ((LoginPresenter) mPresenter).setView(loginFragment);
        ((LoginPresenter) mPresenter).setModel(new LoginModel());

    }
}
