package dwiyanhartono.com.loankoprasi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.FileProvider;
import dwiyanhartono.com.loankoprasi.Adapater.SpinnerAdapter1;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Complaint extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    List<String> IstSource1 = new ArrayList<>();

    SpinnerAdapter1 adapter1;
    Spinner spinner1;
    ImageView imageView;
    Bitmap bitmap = null, decoded;
    String currentPhotoPath;
    int max_resolution_image = 900;
    public final int SELECT_FILE = 1;
    CardView btnphoto;
    Uri fileUri;
    public final int REQUEST_CAMERA = 0;
    EditText edttgl,tipeaduan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);

        edttgl = findViewById(R.id.tgl);
        imageView = findViewById(R.id.imageview);
        spinner1 = findViewById(R.id.spiner1);
        tipeaduan = findViewById(R.id.tipeaduan);
        btnphoto = findViewById(R.id.takephoto);

        btnphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(0);
                final CharSequence[] items = {"Take Photo",
                        "Cancel"};

                AlertDialog.Builder builder = new AlertDialog.Builder(Complaint.this);
                builder.setTitle("Add Photo!");
                builder.setIcon(R.drawable.camera);
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        if (items[item].equals("Take Photo")) {
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

//                            File filePhoto = null;
//                            try {
//                                filePhoto = createImageFile();
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                            if (filePhoto != null) {
//                                fileUri = null;
//                                fileUri = FileProvider.getUriForFile(getApplicationContext(),
//                                        "dwiyanhartono.com.android.fileprovider",
//                                        filePhoto);
//                                intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
//                                startActivityForResult(intent, REQUEST_CAMERA);
////                        intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
////                        startActivityForResult(intent, REQUEST_TAKE_PHOTO);
//                            }
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
        spinner1.setOnItemSelectedListener(this);
        IstSource1.add("Select");
        IstSource1.add("Layanan Listrik");
        IstSource1.add("Layanan Air");
        IstSource1.add("Maintenance");
        IstSource1.add("Kebersihan");
        IstSource1.add("Lain-Lain");

        adapter1 = new SpinnerAdapter1(IstSource1, Complaint.this);
        spinner1.setAdapter(adapter1);

        String date = new SimpleDateFormat("dd-MM-yyyy ", Locale.getDefault()).format(new Date());
        edttgl.setText(date);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinner1 = (Spinner) parent;
        if (spinner1.getId() == R.id.spiner1) {
            tipeaduan.setText(IstSource1.get(position));
            //String kj = hasilkunjungan.getText().toString();

        }
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
}