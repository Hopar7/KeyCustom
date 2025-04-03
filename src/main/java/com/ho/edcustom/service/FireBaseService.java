package com.ho.edcustom.service;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.cloud.StorageClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class FireBaseService {

    @Value("${app.firebase-bucket}")
    private String firebaseBucket;

    public String uploadProfile(MultipartFile file,String namefile)
        throws IOException, FirebaseAuthException{
        Bucket bucket = StorageClient.getInstance().bucket(firebaseBucket);
        InputStream content = new ByteArrayInputStream(file.getBytes());

        //Blob blob = bucket.create(namefile.toString(),content,file.getContentType());
        //String defaultUrl = blob.getMediaLink();

        Blob profileBlob = bucket.create("profile/" + namefile, content, file.getContentType());
        String profileUrl = profileBlob.getMediaLink();

        String downloadUrl = "https://firebasestorage.googleapis.com/v0/b/"
                + firebaseBucket + "/o/"
                + URLEncoder.encode("profile/" + namefile, StandardCharsets.UTF_8)
                + "?alt=media&token=" + profileBlob.getMetadata(); //여기서 token값도 나와야함.
        return downloadUrl;
    }
    public String uploadItem(MultipartFile file,String namefile)
            throws IOException, FirebaseAuthException{
        Bucket bucket = StorageClient.getInstance().bucket(firebaseBucket);
        InputStream content = new ByteArrayInputStream(file.getBytes());

        //Blob blob = bucket.create(namefile.toString(),content,file.getContentType());
        //String defaultUrl = blob.getMediaLink();

        Blob profileBlob = bucket.create("keyboard/" + namefile, content, file.getContentType());
        String profileUrl = profileBlob.getMediaLink();

        String downloadUrl = "https://firebasestorage.googleapis.com/v0/b/"
                + firebaseBucket + "/o/"
                + URLEncoder.encode("keyboard/" + namefile, StandardCharsets.UTF_8)
                + "?alt=media&token=" + profileBlob.getMetadata(); //여기서 token값도 나와야함.

        return downloadUrl;
    }
}
