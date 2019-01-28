package freeflow.moneystuff

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class BudgetExpense(val id: Long, val location: String, val spendingAmount: Int): Parcelable {
    var creationDate: Date = Date()
}