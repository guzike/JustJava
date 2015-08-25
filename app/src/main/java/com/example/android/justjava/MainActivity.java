package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int numberOfCoffees = 0;

    boolean hasWhippedCream = false;
    boolean hasChocolate = false;

    String name = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }



    /**
     * This method is called when the order button is clicked.w
     */
    public void submitOrder(View view) {
        int price = calculatePrice();

        EditText nameField = (EditText) findViewById(R.id.name_view);
        Editable nameText = nameField.getText();
        name = nameText.toString();

        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkbox_cream);
        hasWhippedCream = checkBox1.isChecked();

        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkbox_chocolate);
        hasChocolate = checkBox2.isChecked();

        displayMessage(createOrderSummary(price, hasWhippedCream, hasChocolate, name));
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void increment(View view) {
        numberOfCoffees = numberOfCoffees + 1;
        display(numberOfCoffees);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void decrement(View view) {
        numberOfCoffees = numberOfCoffees - 1;
        display(numberOfCoffees);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    private int calculatePrice(){
        
        return numberOfCoffees*5;
    }

    private String createOrderSummary(int price, boolean hasWhippedCream, boolean hasChocolate, String name){
        return "Name: " + name +
                "\nAdd whipped cream? " + hasWhippedCream +
                "\nAdd chocolate? " + hasChocolate +
                "\nQuantity: " + numberOfCoffees +
                "\nTotal: " + NumberFormat.getCurrencyInstance().format(price) +
                "\nThank you!";
    }
}
