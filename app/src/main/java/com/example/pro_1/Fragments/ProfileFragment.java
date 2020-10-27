package com.example.pro_1.Fragments;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ExpandableListActivity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.pro_1.Model.Users;
import com.example.pro_1.R;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.security.Key;
import java.util.HashMap;

import static android.app.Activity.RESULT_OK;
import static com.google.firebase.storage.FirebaseStorage.getInstance;

public class ProfileFragment extends Fragment {
    TextView username;
    TextView userMBTI;

    TextView userage;
    TextView useraddr;
    ImageView imageView;
    FloatingActionButton fab;
    ProgressDialog pd;


    private static final int CAMERA_REQUEST_CODE=100;
    private static final int STORAGE_REQUEST_CODE=200;
    private static final int IMAGE_PICK_GALLERY_CODE=300;
    private static final int IMAGE_PICK_CAMERA_CODE=400;

    String cameraPermissions[];
    String storagePermissions[];



    DatabaseReference reference;
    FirebaseUser firebaseUser;
    RequestManager mRequestManager;
    DatabaseReference databaseReference;

    //Profile Image
    StorageReference storageReference;
    String storagePath = "Users_Profile_Images/";
    private static final int IMAGE_REQUEST = 1;
    private Uri imageUri;
    String profileOrCoverPhoto;

    private StorageTask uploadTask;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mRequestManager = Glide.with(this);
    }




    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        imageView = view.findViewById(R.id.profile_image2);
        mRequestManager.load(R.drawable.ic_add_image).circleCrop().into(imageView);

        username = view.findViewById(R.id.username_profile); //fragment_profile
        userMBTI = view.findViewById(R.id.profile_MBTI);
        userage = view.findViewById(R.id.profile_age);
        useraddr = view.findViewById(R.id.profile_addr);
        fab = view.findViewById(R.id.fab);
        pd = new ProgressDialog(getActivity());

        //init arrays of permissions
        cameraPermissions = new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        storagePermissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};


        //Profile Image
        storageReference = FirebaseStorage.getInstance().getReference("uploads");

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("MyUsers");
                //.child(firebaseUser.getUid());
        Query query = reference.orderByChild("email").equalTo(firebaseUser.getEmail());
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String name = "" + ds.child("username").getValue();
                    String mbti = "" + ds.child("mbti").getValue();
                    String addr = "" + ds.child("addr").getValue();
                    String age = "" + ds.child("age").getValue();
                    String image = "" + ds.child("imageURL").getValue();

                    username.setText(name);
                    userMBTI.setText("MBTI: "+mbti);
                    userage.setText("나이: "+age);
                    useraddr.setText("주소: "+addr);


                    if (image.equals("default")) {
                        imageView.setImageResource(R.drawable.ic_add_holo);

                    } else {
                        mRequestManager
                                .load(image)
                                .circleCrop()
                                .into(imageView);
                    }
                }




            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditProfileDialog();
            }

        });
        return view;


    }

    private  boolean checkStoragePermission(){
        boolean result = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == (PackageManager.PERMISSION_GRANTED);
        return result;
    }

    private void requestStoragePermission(){
        requestPermissions(storagePermissions, STORAGE_REQUEST_CODE);
    }


    private  boolean checkCameraPermission(){
        boolean result = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA)
                == (PackageManager.PERMISSION_GRANTED);

        boolean result1 = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == (PackageManager.PERMISSION_GRANTED);
        return result && result1;
    }

    private void requestCameraPermission(){
        requestPermissions(cameraPermissions, CAMERA_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case CAMERA_REQUEST_CODE:{
                if (grantResults.length>0){
                    boolean cameraAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean writesStorageAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                    if(cameraAccepted && writesStorageAccepted){
                        pickFromCamera();
                    }
                    else {
                        Toast.makeText(getActivity(), "카메라 권한을 허용해주십시오.",Toast.LENGTH_SHORT).show();

                    }
                }
            }
            break;
            case STORAGE_REQUEST_CODE:{
                if (grantResults.length>0){
                    boolean writesStorageAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                    if(writesStorageAccepted){
                        pickFromGallery();
                    }
                    else {
                        Toast.makeText(getActivity(), "저장소 권한을 허용해주십시오.",Toast.LENGTH_SHORT).show();

                    }
                }
            }
            break;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void showEditProfileDialog() {
        String options[] = {"프로필 사진 수정","MBTI 수정", "닉네임 수정", "주소 수정", "나이 수정"};

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("수정할 항목을 선택하세요");

        builder.setItems(options, (dialog, which) -> {
            if (which == 0) {
                pd.setMessage("사진 업데이트 중입니다");
                SelectImage();
            }else if (which == 1) {
                pd.setMessage("MBTI 업데이트 중입니다");
                showNameAddrAgeUpdateDialog("mbti");
            }else if (which == 2) {
                pd.setMessage("이름 업데이트 중입니다");
                showNameAddrAgeUpdateDialog("username");
            } else if (which == 3) {
                pd.setMessage("주소 업데이트 중입니다");
                showNameAddrAgeUpdateDialog("addr");
            } else if (which == 4) {
                pd.setMessage("나이 업데이트 중입니다");
                showNameAddrAgeUpdateDialog("age");
            }

        });
        builder.create().show();
    }

    private void showNameAddrAgeUpdateDialog(String key) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Update " + key);

        LinearLayout linearLayout = new LinearLayout(getActivity());
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setPadding(10,10,10,10);

        EditText editText = new EditText(getActivity());
        editText.setHint("Enter "+key);
        linearLayout.addView(editText);

        builder.setView(linearLayout);

        builder.setPositiveButton("Update", (dialog, which) -> {

            String value = editText.getText().toString().trim();

            if(!TextUtils.isEmpty(value)) {
                pd.show();
                HashMap<String , Object> result = new HashMap<>();
                result.put(key, value);

                reference.child(firebaseUser.getUid()).updateChildren(result)
                        .addOnSuccessListener(aVoid -> {
                            pd.dismiss();
                            Toast.makeText(getActivity(), "업데이트 중입니다...", Toast.LENGTH_SHORT).show();

                        })
                        .addOnFailureListener(e -> {
                            pd.dismiss();
                            Toast.makeText(getActivity(), ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                        });


            }
                else{
                    Toast.makeText(getActivity(), "Enter "+key, Toast.LENGTH_SHORT).show();
                }

            });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show();


    }

    private void showImagePicDialog() {
        String options[] = {"카메라", "갤러리"};

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("이미지 업로드 방법을 선택해주세요.");

        builder.setItems(options, (dialog, which) -> {
            if (which == 0) {
                if(!checkCameraPermission()){
                    requestCameraPermission();
                }
                else{
                    pickFromCamera();
                }
            } else if (which == 1) {
                if (!checkStoragePermission()){
                    requestStoragePermission();
                }
                else
                    pickFromGallery();
            }

        });
        builder.create().show();
    }


    private void SelectImage() {

        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(i, IMAGE_REQUEST);

    }

    private String getFileExtension(Uri uri){

        ContentResolver contentResolver = getContext().getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();

        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));

    }


    private void UploadMyImage(){
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("업로드 중");
        progressDialog.show();

        if(imageUri != null) {
            final StorageReference fileReference = storageReference.child(System.currentTimeMillis()
                    + "." + getFileExtension(imageUri));

            uploadTask = fileReference.putFile(imageUri);
            uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                @Override
                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {

                    if (!task.isSuccessful()) {
                        throw task.getException();
                    }

                    return fileReference.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    if (task.isSuccessful()) {
                        Uri downLoadUri = task.getResult();
                        String mUri = downLoadUri.toString();
                        reference = FirebaseDatabase.getInstance().getReference("MyUsers").child(firebaseUser.getUid());

                        HashMap<String, Object> map = new HashMap<>();
                        map.put("imageURL", mUri);

                        reference.updateChildren(map);

                        progressDialog.dismiss();

                    } else {
                        Toast.makeText(getContext(), "실패하였습니다.!!", Toast.LENGTH_SHORT).show();

                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }

            });

        }else{
            Toast.makeText(getContext(), "선택된 이미지가 없습니다.",Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null){

            imageUri = data.getData();

            if(uploadTask != null && uploadTask.isInProgress()){
                Toast.makeText(getContext(), "업로드 하는 중 입니다...", Toast.LENGTH_SHORT).show();

            }else{
                UploadMyImage();;
            }
        }

    }


    private void uploadProfileCoverPhoto(Uri imageUri) {
        pd.show();

        String filePathAndName = storagePath+""+profileOrCoverPhoto+"_"+firebaseUser.getUid();
        StorageReference storageReference1 = storageReference.child(filePathAndName);
        storageReference1.putFile(imageUri)
                .addOnSuccessListener(taskSnapshot -> {
                    Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                    while (!uriTask.isSuccessful());
                    Uri downloadUri = uriTask.getResult();

                    if(uriTask.isSuccessful()){
                        HashMap<String, Object> results = new HashMap<>();
                        results.put(profileOrCoverPhoto, downloadUri.toString());


                        databaseReference.child(firebaseUser.getUid()).updateChildren(results)
                                .addOnSuccessListener(aVoid -> {
                                    pd.dismiss();
                                    Toast.makeText(getActivity(), "이미지 업로드중...", Toast.LENGTH_SHORT).show();
                                })
                                .addOnFailureListener(e -> {
                                    pd.dismiss();
                                    Toast.makeText(getContext(),"이미지 업로드에 실패하였습니다.",Toast.LENGTH_SHORT).show();
                                });
                    }
                    else{
                        pd.dismiss();
                        Toast.makeText(getActivity(),"오류 발생", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(e -> {
                    pd.dismiss();
                    Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_SHORT).show();

                });
    }

    private void pickFromCamera(){

        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE,"Temp Pic");
        values.put(MediaStore.Images.Media.DESCRIPTION,"Temp Description");
        imageUri = getActivity().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

        //intent to start camera
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(cameraIntent, IMAGE_PICK_CAMERA_CODE);
    }

    private void pickFromGallery(){
        Intent galleryIntent = new Intent(Intent.ACTION_PICK);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent, IMAGE_PICK_GALLERY_CODE);
    }

}
