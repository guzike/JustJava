package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int numberOfCoffees = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.w
     */
    public void submitOrder(View view) {
        //display(numberOfCoffees);
        //displayPrice(numberOfCoffees * 5);
        int price = calculatePrice();
        String priceMessage = "Total: "+NumberFormat.getCurrencyInstance().format(price) + "\nThank you!";
        displayMessage(createOrderSummary(price));
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
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(message);
    }

    private int calculatePrice(){
        
        return numberOfCoffees*5;
    }

    private String createOrderSummary(int price){
        return "Name: Eugene Guzik" +
                "\nQuantity: "+numberOfCoffees+
                "\nTotal: "+NumberFormat.getCurrencyInstance().format(price)+
                "\nThank you!";
    }
}
