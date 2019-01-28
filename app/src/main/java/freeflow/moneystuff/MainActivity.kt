package freeflow.moneystuff

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.*
import java.util.*

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(){


    //private val mistakeText = "Delete Mistake?"


    private lateinit var spinner: Spinner
    private lateinit var addButton: Button
    private lateinit var spendingInput: EditText
    private lateinit var recyclerView: RecyclerView

    private val expenseDB = ExpensesRepository(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeWidgets()
        createSpinner()
        initializeRecyclerView()
    }

    private fun initializeWidgets() {
        spinner = findViewById<Spinner>(R.id.spinner)
        addButton = findViewById(R.id.add_button)
        addButton.setOnClickListener  { addToBudget() }
        spendingInput = findViewById(R.id.spending_et)
        recyclerView = findViewById(R.id.spending_rv)

    }

    private fun createSpinner() {

        ArrayAdapter.createFromResource(
            this,
            R.array.items_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
    }

    private fun initializeRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, true)
        recyclerView.adapter = BudgetRecyclerView(this)
        recyclerView.hasFixedSize()

    }


    private fun addToBudget() {

        if (spendingInput.text.isEmpty()){
            Toast.makeText(this, "Enter Money Spent, Bitch", Toast.LENGTH_LONG).show()
            return
        }else{
            val number = spendingInput.text.toString().toInt()
            val location = spinner.selectedItem.toString()
            val expenses = BudgetExpense(0, location, number)
            expenseDB.create(expenses)
            Log.d(TAG, "Location: $location, Number: $number")
            recyclerView.adapter?.notifyDataSetChanged()
        }

    }


    /*
    private fun undoCurrentInput(){
     BudgetListManager.addToList(location, number)
        val view = findViewById<View>(R.id.main_activity)

        Snackbar.make(view, mistakeText, Snackbar.LENGTH_LONG)
            .setAction("Undo",  { BudgetListManager.removeNewItem() }).show()

    }
    */



}
