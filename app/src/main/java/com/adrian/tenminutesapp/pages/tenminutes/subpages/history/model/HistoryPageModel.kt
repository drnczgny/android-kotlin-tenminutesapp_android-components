package com.adrian.tenminutesapp.pages.tenminutes.subpages.history.model

import com.adrian.tenminutesapp.pages.tenminutes.dto.CostRegistry
import com.adrian.tenminutesapp.pages.tenminutes.model.TenMinutesModel
import rx.Observable
import rx.Subscriber

/**
 * Created by cadri on 2017. 09. 23..
 */

class HistoryPageModel constructor(val tenMinutesModel: TenMinutesModel) {

    object logging {
        val TAG = HistoryPageModel::class.java.simpleName
    }

    init {
        observeAddNewCostRegistry()
    }

    var costRegistryList: MutableList<CostRegistry> = tenMinutesModel.provideCostRegistryList().toMutableList()

    fun observeAddNewCostRegistryPublisher(): Observable<CostRegistry>
            = tenMinutesModel.observeAddNewCostRegistryPublisher()

    private fun observeAddNewCostRegistry() {
        tenMinutesModel.observeAddNewCostRegistryPublisher()
                .subscribe(object: Subscriber<CostRegistry>() {
                    override fun onCompleted() {
                        // Completed
                    }

                    override fun onError(e: Throwable?) {
                        // Error
                    }

                    override fun onNext(costRegistry: CostRegistry) {
                        notifyNewCostRegistryAdded(costRegistry)
                    }
                })
    }

    private fun notifyNewCostRegistryAdded(costRegistry: CostRegistry) {
        costRegistryList = tenMinutesModel.provideCostRegistryList().toMutableList()
    }
}