package com.lakooz.lpctest

import android.app.Application
import android.app.SharedElementCallback
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lakooz.lpctest.model.Pot
import com.lakooz.lpctest.networking.RestApiClient
import com.lakooz.lpctest.repositories.PotRepository
import com.lakooz.lpctest.utils.IUICallBacks
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(application: Application, potRepository: PotRepository) :
    AndroidViewModel(application) {

    private var uiCallBack: IUICallBacks? = null

    fun setParentCallBack(caller: IUICallBacks) {
        uiCallBack = caller
    }

    // need to acces repo , so maybe pass it
    private val repository = potRepository

    private val _isRefreshing = MutableLiveData<Boolean>()
    val isRefreshing: LiveData<Boolean>
        get() = _isRefreshing


    fun getPots() {

        RestApiClient.getPots()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<List<Pot>> {

                var disposable: Disposable? = null

                override fun onSubscribe(d: Disposable) {
                    disposable = d
                }

                override fun onSuccess(pots: List<Pot>) {
                    disposable?.dispose()
                    // TODO
                    uiCallBack!!.doOnSuccess("Success")
                }

                override fun onError(e: Throwable) {
                    // TODO
                    uiCallBack!!.doOnFailure("failed 4 reason")

                }

            })
    }

    fun createPot(category: Int) {

        RestApiClient.createPot(category)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<Pot> {

                var disposable: Disposable? = null

                override fun onSubscribe(d: Disposable) {
                    disposable = d
                }

                override fun onSuccess(pot: Pot) {
                    disposable?.dispose()
                    //TODO
                }

                override fun onError(e: Throwable) {
                    //TODO
                }

            }

            )
    }
}