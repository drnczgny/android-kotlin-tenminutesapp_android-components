package com.adrian.tenminutesapp.pages.tenminutes.subpages.home.viewmodel

import android.databinding.Bindable
import android.view.View
import com.adrian.tenminutesapp.BR
import com.adrian.tenminutesapp.base.BaseViewModel
import com.adrian.tenminutesapp.pages.tenminutes.dto.SingleCostRegistry
import com.adrian.tenminutesapp.pages.tenminutes.subpages.home.dto.OrderSummaryDto
import com.adrian.tenminutesapp.pages.tenminutes.subpages.home.model.HomePageModel
import com.adrian.tenminutesapp.pages.tenminutes.viewmodel.TenMinutesViewModel

/**
 * Created by cadri on 2017. 09. 21..
 */

class HomePageViewModel constructor(val model: HomePageModel) : BaseViewModel() {

    object logging {
        val TAG = TenMinutesViewModel::class.java.simpleName
    }

    @Bindable
    var balance: Long = 0
        set(value) {
            if (balance != value) {
                field = value
                notifyPropertyChanged(BR.balance)
            }
        }

    @Bindable
    var cost: String = ""
        set(value) {
            if (cost != value) {
                field = value
                notifyPropertyChanged(BR.cost)
//                notifySumCost()
                calculateCurrentCost()
            }
        }

    @Bindable
    var sumCost: String = ""
        set(value) {
            if (sumCost != value) {
                field = value
                notifyPropertyChanged(BR.sumCost)
            }
        }

    @Bindable
    var uploadBalanceAmount: String = ""
        set(value) {
            if (uploadBalanceAmount != value) {
                field = value
                notifyPropertyChanged(BR.uploadBalanceAmount)
            }
        }

    @Bindable
    var menuA: Boolean = false
        set(value) {
            if (menuA != value) {
                field = value
                notifyPropertyChanged(BR.menuA)
            }
        }

    @Bindable
    var menuB: Boolean = false
        set(value) {
            if (menuB != value) {
                field = value
                notifyPropertyChanged(BR.menuB)
            }
        }

    @Bindable
    var flavoredDressing: Boolean = false
        set(value) {
            if (flavoredDressing != value) {
                field = value
                notifyPropertyChanged(BR.flavoredDressing)
            }
        }

    @Bindable
    var moreItems: String = ""
        set(value) {
            if (moreItems != value) {
                field = value
                notifyPropertyChanged(BR.moreItems)
            }
        }

    @Bindable
    var menuACount: Int = 0
        set(value) {
            if (menuACount != value) {
                field = value
                notifyPropertyChanged(BR.menuACount)
            }
        }

    @Bindable
    var menuBCount: Int = 0
        set(value) {
            if (menuBCount != value) {
                field = value
                notifyPropertyChanged(BR.menuBCount)
            }
        }

    @Bindable
    var flavoredDressingCount: Int = 0
        set(value) {
            if (flavoredDressingCount != value) {
                field = value
                notifyPropertyChanged(BR.flavoredDressingCount)
            }
        }

    override fun onCreate() {
        balance = parseToLongFromEditText(model.findBalance())
    }

    fun onClickAdd(view: View) {
        val cost = parseToLongFromEditText(sumCost)
        addNewCost(cost)
        reset()
    }

    fun onClickUploadBalance(view: View) {
        val amount = parseToLongFromEditText(uploadBalanceAmount)
        uploadBalance(amount)
        uploadBalanceAmount = ""
    }

    fun onClickMenuA(view: View) {
//        menuA = !menuA
    }

    fun onClickMenuB(view: View) {
//        menuB = !menuB
    }

    fun onClickFlavoredDressing(view: View) {
//        flavoredDressing = !flavoredDressing
    }

    fun onClickAddMenuA(view: View) {
        menuA = true
        menuACount = increaseItemCount(menuACount)
        calculateCurrentCost()
    }

    fun onClickAddMenuB(view: View) {
        menuB = true
        menuBCount = increaseItemCount(menuBCount)
        calculateCurrentCost()
    }

    fun onClickAddFlavoredDressing(view: View) {
        flavoredDressing = true
        flavoredDressingCount = increaseItemCount(flavoredDressingCount)
        calculateCurrentCost()
    }

    fun onClickRemoveMenuA(view: View) {
        menuACount = decreaseItemCount(menuACount)
        menuA = checkSelectedState(menuACount)
        calculateCurrentCost()
    }

    fun onClickRemoveMenuB(view: View) {
        menuBCount = decreaseItemCount(menuBCount)
        menuB = checkSelectedState(menuBCount)
        calculateCurrentCost()
    }

    fun onClickRemoveFlavoredDressing(view: View) {
        flavoredDressingCount = decreaseItemCount(flavoredDressingCount)
        flavoredDressing = checkSelectedState(flavoredDressingCount)
        calculateCurrentCost()
    }

    private fun calculateCurrentCost() {
        sumCost = model.calculateCurrentCost(OrderSummaryDto(parseToLongFromEditText(cost), menuACount, menuBCount, flavoredDressingCount)).toString()
    }

    private fun addNewCost(cost: Long) {
        balance -= cost
        model.uploadBalance(balance)
        val orderSummaryDto = OrderSummaryDto(cost, menuACount, menuBCount, flavoredDressingCount)
        model.saveCostRegistry(orderSummaryDto)
    }

    private fun uploadBalance(uploadBalanceAmount: Long) {
        var discount = uploadBalanceAmount / 10
        var uploadAmountWithDiscount = uploadBalanceAmount + discount
        this.balance += uploadAmountWithDiscount

        model.uploadBalance(balance)
        this.uploadBalanceAmount = ""
    }

    private fun notifySumCost() {
        var currentCost = parseToLongFromEditText(cost)
        sumCost = (currentCost + summarizeMoreItemCost()).toString()
    }

    private fun summarizeMoreItemCost(): Long {
        var cost: Long = 0
        for (singleCostRegistry: SingleCostRegistry in model.singleCostRegistryList) {
            cost += singleCostRegistry.price
        }
        return cost
    }

    private fun reset() {
        cost = ""
        sumCost = ""
        moreItems = ""
        menuA = false;
        menuB = false;
        flavoredDressing = false
        menuACount = 0
        menuBCount = 0
        flavoredDressingCount = 0
        model.singleCostRegistryList.clear()
    }

    fun setupBalance(newBalance: String) {
        balance = parseToLongFromEditText(newBalance)
        model.uploadBalance(balance)
        uploadBalanceAmount = ""
    }

    private fun parseToLongFromEditText(text: String): Long {
        return if (!text.equals("")) {
            text.toLong()
        } else {
            0.toLong()
        }
    }

    private fun decreaseItemCount(itemCount: Int): Int
            = if (itemCount - 1 >= 0) itemCount - 1 else 0

    private fun increaseItemCount(itemCount: Int): Int
            = itemCount + 1

    private fun checkSelectedState(itemCount: Int): Boolean
            = if (itemCount > 0) true else false
}