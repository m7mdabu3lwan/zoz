package com.example.zoz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signup extends Fragment
{
    EditText email ,password,confrimpassword;
    Button btn;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public signup() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static signup newInstance(String param1, String param2) {
        signup fragment = new signup();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup, container, false);
    }
    @Override
    public void onStart()
    {
        super.onStart();
        connectcomponents();
    }

    private void connectcomponents()
    {
        email=getView().findViewById(R.id.emailsign);
        password=getView().findViewById(R.id.passsign);
        confrimpassword=getView().findViewById(R.id.passconsign);
        btn=getView().findViewById(R.id.btnsign);
    }

    public void login(View view)
    {
        String etemail,etpassword,etconfrimpassword;
        etconfrimpassword=confrimpassword.getText().toString();
        etemail=email.getText().toString();
        etpassword=password.getText().toString();
        if(etemail.trim().isEmpty()||etpassword.trim().isEmpty())
        {
            Toast.makeText(getActivity(), "some fields are missing!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!isEmailValid(etemail))
        {
            Toast.makeText(getActivity(), "email is incorrect!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!isPasswordValid(etpassword))
        {
            Toast.makeText(getActivity(), "password is incorrect!", Toast.LENGTH_SHORT).show();
            return;
        }
    }
    public boolean isEmailValid(String str)
    {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
    public boolean isPasswordValid(String password)
    {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
}