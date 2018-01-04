package com.ywapp.yw.discountcal;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Tab2 extends Fragment {

    // Variable Declaration
    EditText price_box_field;
    EditText discount_price_box_field;
    TextView result_text_field;
    Button cal_btn;

    double price,discounted_price,result,save;


    public Tab2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_tab2, container, false);


        final EditText price_box_field=(EditText)view.findViewById(R.id.price_box);
        final EditText discount_box_field=(EditText)view.findViewById(R.id.discount_price_box);

        final TextView result_text_field=(TextView)view.findViewById(R.id.result_text);
        Button cal_btn=(Button)view.findViewById(R.id.cal_btn);


        cal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(price_box_field.getText().length()==0) {
                    Toast.makeText(getActivity(),"Please enter the Original Price !",Toast.LENGTH_LONG).show();
                    return; //to stop the method from parsing empty values
                }

                if(discount_box_field.getText().length()==0) {
                    Toast.makeText(getActivity(),"Please enter the Discounted Price !",Toast.LENGTH_LONG).show();
                    return; //to stop the method from parsing empty values
                }

                price=Double.parseDouble(price_box_field.getText().toString());
                discounted_price=Double.parseDouble(discount_box_field.getText().toString());

                result=((discounted_price-price)*100)*-1/price;
                save=price-discounted_price;

                String result_word="Discount Rate: ";
                String result_set=result_word+String.format("%.2f", result)+" %\nYou saved $ "+String.format("%.2f", save);
                result_text_field.setText(result_set);


            }
        });
        return view;
    }



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}