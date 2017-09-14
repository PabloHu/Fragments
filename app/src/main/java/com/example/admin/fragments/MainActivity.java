package com.example.admin.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BlueFragment.OnFragmentInteractionListener{
    TextView tvTextFromBlueFrag;
    EditText etDataForRedFrag;
    private static final String TAG = "MainActivityTAG";
private static final String RED_FRAGMENT_TAG = "redfragmentRAG";
    private static final String BLUE_FRAGMENT_TAG = "bluefragmentRAG";
    Button changeFrag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");

        //changeFrag = (Button) findViewById(R.id.changeFrag);


         tvTextFromBlueFrag = (TextView) findViewById(R.id.tvTextFromBlueFrag);
        etDataForRedFrag= (EditText) findViewById(R.id.etDataForRedFrag);

    }
    public void addFragments(View view) {
        switch (view.getId()){
            case R.id.btnAddRedFrag:
                RedFragment redFragment = new RedFragment();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.flFragHolderRed, redFragment, RED_FRAGMENT_TAG)

                        .commit();
                break;

            case R.id.btnAddBlueFrag:
                String firstArg = "John";
                String secondArg = "Doe";

                BlueFragment blueFragment = BlueFragment.newInstance(firstArg,secondArg);
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.flFragHolderBlue,blueFragment,BLUE_FRAGMENT_TAG)
                        .commit();
                break;
        }
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }




    @Override
    public void onFragmentInteraction(String uri) {

    }

    @Override
    public void sendDataToActivity(String data) {
        tvTextFromBlueFrag.setText(data);
    }



    //will send daa to red frag
    public void sendDataToRedFrag(View view) {

        String dataForRedFrag = etDataForRedFrag.getText().toString();
        RedFragment redFragment = (RedFragment) getSupportFragmentManager().findFragmentById(R.id.flFragHolderRed);


        if (redFragment != null) {
            redFragment.onDataReceived(dataForRedFrag);
        } else {
            Toast.makeText(this, "Please add the red frag first", Toast.LENGTH_SHORT).show();

            redFragment.onDataReceived(dataForRedFrag);
        }
    }
}
