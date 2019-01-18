package freeflow.moneystuff

import android.util.Log
import java.util.*

private const val TAG = "BudgetListManager"
object BudgetListManager {


    private val spendingList = ArrayList<BudgetExpense>()


    fun getInstance(): ArrayList<BudgetExpense> {

        return spendingList
    }

    fun addToList(location: String, spending: Int) {
        val budgetExpense = BudgetExpense(location, spending)
        spendingList.add(budgetExpense)
    }

    fun removeNewItem(){
        val lastIndex = spendingList.lastIndex
        spendingList.removeAt(lastIndex)
        Log.d(TAG, "removed position at: $lastIndex")
    }

}