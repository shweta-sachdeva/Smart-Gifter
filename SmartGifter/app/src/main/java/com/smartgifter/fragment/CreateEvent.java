package com.smartgifter.fragment;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.smartgifter.controller.R;
import com.smartgifter.model.Event;
import java.util.Calendar;


/**
 * Created by Shweta Sachdeva on 4/9/2016.
 */
public class CreateEvent extends Fragment {

    private static final String TAG = "Create Event";
    private static final int SELECT_PICTURE = 1;
    private View view;
    private EditText eventTitle;
    private ImageView image;
    private EditText itemName;
    private EditText itemPrice;
    private EditText itemDescription;
    private EditText eventDate;
    private Calendar calendar;
    private Button saveEvent;
    private String selectedImagePath;
    private Event event;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.i(TAG, "In onCreateView");
        view = inflater.inflate(R.layout.fragment_create_event, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        Log.i(TAG, "In onActivity");
        calendar = Calendar.getInstance();
        super.onActivityCreated(savedInstanceState);

        //initialization
        event = new Event();
        eventTitle = (EditText) getView().findViewById(R.id.input_title);
        eventDate = (EditText) getView().findViewById(R.id.input_date);
        eventDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker dp, int year,
                                                  int month, int dayOfMonth) {
                                eventDate.setText(year + "-" + (month + 1) + "-"
                                        + dayOfMonth);
                            }
                        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar
                        .get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        itemName = (EditText) getView().findViewById(R.id.input_item_name);
        itemPrice = (EditText) getView().findViewById(R.id.input_price);
        itemDescription = (EditText) getView().findViewById(R.id.description);

        image = (ImageView) getView().findViewById(R.id.item_image);
        Log.i(TAG, "In image vew");
        image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Log.i(TAG, "In image view click");
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
            }
        });

        saveEvent = (Button)getView().findViewById(R.id.button_save_trip);
        saveEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Event event = createEvent();
                saveEvent(event);
            }
        });

    }
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (resultCode == Activity.RESULT_OK) {
                if (requestCode == SELECT_PICTURE) {
                    Uri selectedImageUri = data.getData();
                    selectedImagePath = getPath(selectedImageUri);
                    System.out.println("Image Path : " + selectedImagePath);
                    image.setImageURI(selectedImageUri);
                }
            }
        }

        public String getPath(Uri uri) {
            String[] projection = { MediaStore.Images.Media.DATA };
            Cursor cursor = getActivity().getContentResolver().query(uri, projection, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        }

    /**
     * This method is used to
     * instantiate a Event model object.
     *
     * @return The Event as represented
     * by the View.
     */
    public Event createEvent() {

        Log.i(TAG, "In createEvent method");

        if(TextUtils.isEmpty(eventTitle.getText().toString().trim())) {
            Toast.makeText(getActivity(), R.string.error_msg_event_name, Toast.LENGTH_LONG).show();
            return null;
        }
        event.setEventTitle(eventTitle.getText().toString().trim());

        if(TextUtils.isEmpty(itemName.getText().toString().trim())) {
            Toast.makeText(getActivity(),R.string.error_msg_item_name, Toast.LENGTH_LONG).show();
            return null;
        }
        event.setItemName(itemName.getText().toString().trim());

        if(TextUtils.isEmpty(eventDate.getText().toString().trim())) {
            Toast.makeText(getActivity(), R.string.error_msg_event_date, Toast.LENGTH_LONG).show();
            return null;
        }
        event.setEventDate(eventDate.getText().toString().trim());

        if(TextUtils.isEmpty(itemPrice.getText().toString().trim())) {
            Toast.makeText(getActivity(),R.string.error_msg_item_price, Toast.LENGTH_LONG).show();
            return null;
        }
        try {
            int price = Integer.parseInt(itemPrice.getText().toString().trim());
        } catch(NumberFormatException nfe) {
            System.out.println("Could not parse " + nfe);
        }
        event.setItemDescription(itemDescription.getText().toString().trim());

        return event;
    }

    public boolean saveEvent(Event event) {

        if(event != null) {
            Log.i(TAG, "In save event!");
            return true;
        }
        return false;
    }
}
