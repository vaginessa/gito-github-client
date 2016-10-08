package com.dmitrymalkovich.android.githubanalytics.basicauthorization;

import android.support.annotation.NonNull;
import android.support.v4.app.LoaderManager;

import com.dmitrymalkovich.android.githubanalytics.data.source.GithubRepository;
import com.dmitrymalkovich.android.githubanalytics.data.source.LoaderProvider;

import static com.google.common.base.Preconditions.checkNotNull;

class BasicAuthorizationPresenter implements BasicAuthorizationContract.Presenter {

    @NonNull
    private final LoaderProvider mLoaderProvider;

    @NonNull
    private final LoaderManager mLoaderManager;

    @NonNull
    private GithubRepository mGithubRepository;

    @NonNull
    private BasicAuthorizationContract.View mLoginView;

    BasicAuthorizationPresenter(@NonNull GithubRepository githubRepository,
                                       @NonNull BasicAuthorizationContract.View view,
                                       @NonNull LoaderProvider loaderProvider,
                                       @NonNull LoaderManager loaderManager) {
        mGithubRepository = checkNotNull(githubRepository);
        mLoginView = checkNotNull(view);
        mLoaderProvider = checkNotNull(loaderProvider);
        mLoaderManager = checkNotNull(loaderManager, "loaderManager cannot be null!");

        mLoginView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void login(String username, String password) {
        mGithubRepository.login(username, password);
    }
}
