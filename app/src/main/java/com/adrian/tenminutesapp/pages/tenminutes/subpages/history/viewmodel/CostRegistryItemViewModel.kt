package com.adrian.tenminutesapp.pages.tenminutes.subpages.history.viewmodel

import android.databinding.Bindable
import com.adrian.tenminutesapp.BR
import com.adrian.tenminutesapp.R
import com.adrian.tenminutesapp.base.ListItemViewModel
import com.adrian.tenminutesapp.pages.tenminutes.dto.CostRegistry
import com.adrian.tenminutesapp.pages.tenminutes.dto.SingleCostRegistry
import com.annimon.stream.Collectors
import com.annimon.stream.Stream

/**
 * Created by cadri on 2017. 09. 23..
 */

class CostRegistryItemViewModel constructor(costRegistry: CostRegistry) : ListItemViewModel() {

    @Bindable
    var singleCostRegistrieItemViewModels: List<SingleCostRegistryItemViewModel> = convertToViewModels(costRegistry.singleCostRegistries)
        set(value) {
            if (!singleCostRegistrieItemViewModels.equals(value)) {
                field = value
            }
        }

    @Bindable
    fun getItemLayoutId() = R.layout.list_item_single_cost_registry

    @Bindable
    fun getVariableId(): Int {
        return BR.viewModel
    }

    private fun convertToViewModel(singleCostRegistry: SingleCostRegistry): SingleCostRegistryItemViewModel {
        return SingleCostRegistryItemViewModel(singleCostRegistry)
    }

    private fun convertToViewModels(singleCostRegistries: List<SingleCostRegistry>): List<SingleCostRegistryItemViewModel> {
        return Stream.of(singleCostRegistries).map { singleCostRegistry -> convertToViewModel(singleCostRegistry) }.collect(Collectors.toList())
    }
}