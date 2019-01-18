package freeflow.moneystuff

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

private const val TAG = "BudgetRecyclerView"
class BudgetRecyclerView : RecyclerView.Adapter<BudgetRecyclerView.BudgetViewHolder>() {


    val a = BudgetListManager.getInstance()



    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BudgetViewHolder {
        val viewHolder = LayoutInflater.from(p0.context)
            .inflate(R.layout.budget_rv_viewholder, p0, false)

        return BudgetViewHolder(viewHolder)
    }

    override fun getItemCount(): Int {
        return a.size
    }

    override fun onBindViewHolder(p0: BudgetViewHolder, p1: Int) {
        //location text shows spinner options
        //spending shows number

        p0.spendingPosition.text = a[p1].component2().toString()
        p0.locationPosition.text = a[p1].component1()
        Log.d(TAG, "onBindViewHolder: ${p0.spendingPosition} , ${p0.locationPosition}" )


    }

    class BudgetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val locationPosition = itemView.findViewById<TextView>(R.id.location)

        val spendingPosition = itemView.findViewById<TextView>(R.id.textView2)

    }
}