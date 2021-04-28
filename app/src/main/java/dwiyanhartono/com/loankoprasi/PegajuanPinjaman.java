package dwiyanhartono.com.loankoprasi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import dwiyanhartono.com.loankoprasi.Adapater.SpinnerAdapter1;
import dwiyanhartono.com.loankoprasi.Adapater.SpinnerAdapter2;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.security.PrivateKey;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PegajuanPinjaman extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    List<String> IstSource1 = new ArrayList<>();
    List<String> IstSource2 = new ArrayList<>();
    List<String> IstSource3 = new ArrayList<>();
    List<String> IstSource4 = new ArrayList<>();

    SpinnerAdapter1 adapter1;
    SpinnerAdapter2 adapter2;
    Spinner spinner1,spinner2,spinner3,spinner4;
    ImageView imageView;
    Bitmap bitmap = null, decoded;
    String currentPhotoPath;
    int max_resolution_image = 900;
    public final int SELECT_FILE = 1;
    CardView btnphoto;
    Uri fileUri;
    TextView tanggal;
    public final int REQUEST_CAMERA = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pegajuan_pinjaman);
        spinner4 = findViewById(R.id.spiner4);
        spinner1 = findViewById(R.id.spiner1);
        tanggal = findViewById(R.id.tanggal);
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = month + "-" + dayOfMonth +"-"+year;
                tanggal.setText(date);

            }
        };
        spinner4.setOnItemSelectedListener(this);
        IstSource1.add("Please Select");
        IstSource1.add("Personal Loan");
        IstSource1.add("Home Loan");
        IstSource1.add("Vihicle Loan");
        IstSource1.add("Creadit Card");
        IstSource1.add("Other");

        adapter1 = new SpinnerAdapter1(IstSource1, PegajuanPinjaman.this);
        spinner4.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(this);
        IstSource2.add("Please Select");
        IstSource2.add("Mr");
        IstSource2.add("Mrs");
        IstSource2.add("Ms");

        adapter2 = new SpinnerAdapter2(IstSource2, PegajuanPinjaman.this);
        spinner1.setAdapter(adapter2);


        imageView = findViewById(R.id.imageview);
        btnphoto = findViewById(R.id.takephoto);

        btnphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(0);
                final CharSequence[] items = {"Take Photo",
                        "Cancel"};

                AlertDialog.Builder builder = new AlertDialog.Builder(PegajuanPinjaman.this);
                builder.setTitle("Add Photo!");
                builder.setIcon(R.drawable.camera);
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        if (items[item].equals("Take Photo")) {
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                            startActivityForResult(intent, REQUEST_CAMERA);

                        } else if (items[item].equals("Cancel")) {
                            dialog.dismiss();
                        }
                    }
                });
                builder.show();
            }
        });
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private void dialogTanggal() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog = new DatePickerDialog(
                PegajuanPinjaman.this,
                android.R.style.Theme_Holo_Dialog_MinWidth,
                mDateSetListener,
                year,month,day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinner1 = (Spinner) parent;
        spinner2 = (Spinner) parent;
        spinner4 = (Spinner) parent;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("onActivityResult", "requestCode " + requestCode + ", resultCode " + resultCode);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_CAMERA) {
                try {
                    //Log.e("CAMERA", fileUri.getPath());

//                    bitmap = BitmapFactory.decodeFile(currentPhotoPath);
                    bitmap = (Bitmap) data.getExtras().get("data");
//                    setToImageView(getResizedBitmap(bitmap, max_resolution_image));
                    setToImageView(bitmap);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (requestCode == SELECT_FILE && data != null && data.getData() != null) {
                try {
                    // mengambil gambar dari Gallery
                    bitmap = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
                    setToImageView(getResizedBitmap(bitmap, max_resolution_image));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private void setToImageView(Bitmap bmp) {
        //compress image
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        decoded = BitmapFactory.decodeStream(new ByteArrayInputStream(bytes.toByteArray()));
        //menampilkan gambar yang dipilih dari camera/gallery ke ImageView
        imageView.setImageBitmap(bmp);
    }

    public Bitmap getResizedBitmap(Bitmap image, int maxSize) {
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float) width / (float) height;
        if (bitmapRatio > 1) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }
        return Bitmap.createScaledBitmap(image, width, height, true);
    }

    public void tanggallahir(View view) {
        dialogTanggal();
    }
}