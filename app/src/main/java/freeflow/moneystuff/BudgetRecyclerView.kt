package freeflow.moneystuff

import android.app.Application
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

private const val TAG = "BudgetRecyclerView"
class BudgetRecyclerView(val context: Context) : RecyclerView.Adapter<BudgetRecyclerView.BudgetViewHolder>() {



    private val expenseDBList = ExpensesRepository(context).findAll()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BudgetViewHolder {
        val viewHolder = LayoutInflater.from(p0.context)
            .inflate(R.layout.budget_rv_viewholder, p0, false)

        return BudgetViewHolder(viewHolder)
    }

    override fun getItemCount(): Int {
        return expenseDBList.size
    }

    override fun onBindViewHolder(p0: BudgetViewHolder, p1: Int) {
        //location text shows spinner options
        //spending shows number
        //val values = expenseDBList[p1]
        p0.locationPosition.text = expenseDBList[p1].location
        p0.spendingPosition.text = expenseDBList[p1].spendingAmount.toString()

        Log.d(TAG, "onBindViewHolder: ${p0.spendingPosition} , ${p0.locationPosition}" )


    }

    class BudgetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val locationPosition = itemView.findViewById<TextView>(R.id.location)

        val spendingPosition = itemView.findViewById<TextView>(R.id.textView2)

    }
}