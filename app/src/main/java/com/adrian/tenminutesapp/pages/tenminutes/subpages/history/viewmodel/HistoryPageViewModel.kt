package com.adrian.tenminutesapp.pages.tenminutes.subpages.history.viewmodel

import android.databinding.Bindable
import com.adrian.tenminutesapp.BR
import com.adrian.tenminutesapp.R
import com.adrian.tenminutesapp.base.BaseViewModel
import com.adrian.tenminutesapp.pages.tenminutes.dto.CostRegistry
import com.adrian.tenminutesapp.pages.tenminutes.subpages.history.model.HistoryPageModel
import com.adrian.tenminutesapp.pages.tenminutes.subpages.history.view.HistoryPageRouter
import com.annimon.stream.Collectors
import com.annimon.stream.Stream
import rx.Subscriber


/**
 * Created by cadri on 2017. 09. 23..
 */

class HistoryPageViewModel constructor(val router: HistoryPageRouter, val model: HistoryPageModel) : BaseViewModel() {

    object logging {
        val TAG = HistoryPageViewModel::class.java.simpleName
    }

    @Bindable
    var costRegistryItemViewModels: List<CostRegistryItemViewModel> = convertToViewModels(model.costRegistryList)
        set(value) {
            if (costRegistryItemViewModels != value) {
                field = value
                notifyPropertyChanged(BR.costRegistryItemViewModels)
            }
        }

    @Bindable
    fun getItemLayoutId() = R.layout.list_item_cost_registry

    @Bindable
    fun getVariableId(): Int {
        return BR.viewModel
    }

    init {
        observeAddNewCostRegistry()
    }

    override fun onCreate() {

    }

    private fun observeAddNewCostRegistry() {
        model.observeAddNewCostRegistryPublisher()
                .subscribe(object: Subscriber<CostRegistry>() {
                    override fun onCompleted() {
                        // Completed
                    }

                    override fun onError(e: Throwable?) {
                        // Error
                    }

                    override fun onNext(costRegistry: CostRegistry) {
//                        Log.e(logging.TAG, "asd")
                        notifyNewCostRegistryAdded(costRegistry)
                    }
                })
    }

    private fun notifyNewCostRegistryAdded(costRegistry: CostRegistry) {
        costRegistryItemViewModels = convertToViewModels(model.costRegistryList)
//        costRegistryList = tenMinutesModel.provideCostRegistryList().toMutableList()
    }

    private fun convertToViewModel(costRegistry: CostRegistry): CostRegistryItemViewModel {
        return CostRegistryItemViewModel(costRegistry)
    }

    private fun convertToViewModels(costRegistries: List<CostRegistry>): List<CostRegistryItemViewModel> {
        return Stream.of(costRegistries).map { costRegistry -> convertToViewModel(costRegistry) }.collect(Collectors.toList())
    }

}