package com.example.bootcamphw5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bootcamphw5.databinding.FragmentCalculatorBinding;

public class CalculatorFragment extends Fragment {
    private FragmentCalculatorBinding binding;
    private String curr , resultText;
    private double result;
    private boolean dotIsInserted, operatorIsInserted;
  @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCalculatorBinding.inflate(inflater, container, false);
        curr="";
        resultText ="0";
        dotIsInserted = false;
        operatorIsInserted = false;
        displayPreviousText();
        displayCurrentText();
        binding.buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "0";
                displayPreviousText();
            }
        });
      binding.buttonOne.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              curr = curr + "1";
              displayPreviousText();
          }
      });
      binding.buttonTwo.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              curr = curr + "2";
              displayPreviousText();
          }
      });
      binding.buttonThree.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              curr = curr + "3";
              displayPreviousText();
          }
      });
      binding.buttonFour.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              curr = curr + "4";
              displayPreviousText();
          }
      });
      binding.buttonFive.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              curr = curr + "5";
              displayPreviousText();
          }
      });
      binding.buttonSix.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              curr = curr + "6";
              displayPreviousText();
          }
      });
      binding.buttonSeven.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              curr = curr + "7";
              displayPreviousText();
          }
      });
      binding.buttonEight.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              curr = curr + "8";
              displayPreviousText();
          }
      });
      binding.buttonNine.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              curr = curr + "9";
              displayPreviousText();
          }
      });
      binding.buttonDot.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              if (curr.isEmpty()){
                  curr="0.";
                  dotIsInserted = true;
              }
              if (dotIsInserted == false){
                  curr = curr+".";
                  dotIsInserted = true;
              }
              displayPreviousText();
          }
      });

      binding.buttonAc.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              clearCalculator();
              displayPreviousText();
              displayCurrentText();
          }
      });
      binding.buttonBackspace.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              backspaceFunction();
              displayPreviousText();
          }
      });
      binding.buttonPlus.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            dotIsInserted =false;
            if (!curr.isEmpty()){
                if (curr.charAt(curr.length() - 1) == '.'){
                    backspaceFunction();
                }
                if(operatorIsInserted == false){
                    curr = curr + "+";
                      operatorIsInserted = true;
                }
            }
            displayPreviousText();
          }
      });
      binding.buttonEqual.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              if (operatorIsInserted == true && !curr.substring(curr.length()-1,curr.length()).equals("")){
                  String [] token = curr.split("\\+");
                          result = Double.parseDouble(token[0])+Double.parseDouble(token[1]);
                          resultText = cutDotsDecimal(Double.toString(result));
                  displayCurrentText();
              }
          }
      });

        return binding.getRoot();
    }
    public void displayPreviousText(){
        binding.previousText.setText(curr);
    }
    public void displayCurrentText(){
        binding.currentText.setText(resultText);
    }
    public void clearCalculator(){
      curr = "";
      resultText = "0";
      dotIsInserted = false;
      operatorIsInserted = false;
    }
    public void backspaceFunction(){
      if (!curr.isEmpty()){
          if (curr.charAt(curr.length() - 1) == '.'){
              dotIsInserted = false;
          }
          if (curr.substring(curr.length()-1 , curr.length()).equals("")){
                curr = curr.substring(0,curr.length()-3);
                operatorIsInserted = false;
          }else {
              curr = curr.substring(0,curr.length()-1);
          }

      }
    }
    private String cutDotsDecimal(String number){
      String temp[] = number.split("\\.");
      if (temp.length > 1){
          if (temp[1].equals("0")){
              number = temp[0];
          }
      }
      return number;
    }
}