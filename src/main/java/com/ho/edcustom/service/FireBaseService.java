package com.ho.edcustom.service;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.cloud.StorageClient;
import com.ho.edcustom.DTO.Response.HttpResponse;
import com.ho.edcustom.enumSet.ErrorCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class FireBaseService {

    @Value("${app.firebase-bucket}")
    private String firebaseBucket;
    public String uploadItem(String file){
//        if(file==null||file.trim().isEmpty())
//        {
//            String downloadUrl = "https://firebasestorage.googleapis.com/v0/b/cuskey-44d99.firebasestorage.app/o/profile%2Fdefault?alt=media&token=default";
//            return downloadUrl;
//        }
        Bucket bucket = StorageClient.getInstance().bucket(firebaseBucket);
        Storage storage = bucket.getStorage();

        String fileName = "keyboard/" + UUID.randomUUID();

        String downloadToken = UUID.randomUUID().toString();

        Map<String, String> metadata = new HashMap<>();
        metadata.put("firebaseStorageDownloadTokens", downloadToken);

        BlobInfo blobInfo = BlobInfo.newBuilder(bucket.getName(), fileName)
                .setContentType(file)
                .setMetadata(metadata)
                .build();

        Blob blob = storage.create(blobInfo, file.getBytes());

        String downloadUrl = "https://firebasestorage.googleapis.com/v0/b/" + bucket.getName() +
                "/o/" + fileName.replace("/", "%2F") + "?alt=media&token=" + downloadToken;

        return downloadUrl;
    }
    public String uploadProfile(String file){
        if(file==null||file.trim().isEmpty())
        {
            String downloadUrl = "https://firebasestorage.googleapis.com/v0/b/cuskey-44d99.firebasestorage.app/o/profile%2Fdefault?alt=media&token=default";
            return downloadUrl;
        }

        Bucket bucket = StorageClient.getInstance().bucket(firebaseBucket);
        Storage storage = bucket.getStorage();

        String fileName = "profile/" + UUID.randomUUID();

        String downloadToken = UUID.randomUUID().toString();

        Map<String, String> metadata = new HashMap<>();
        metadata.put("firebaseStorageDownloadTokens", downloadToken);


        BlobInfo blobInfo = BlobInfo.newBuilder(bucket.getName(), fileName)
                .setContentType(file)
                .setMetadata(metadata)
                .build();


        Blob blob = storage.create(blobInfo, file.getBytes());

        String downloadUrl = "https://firebasestorage.googleapis.com/v0/b/" + bucket.getName() +
                "/o/" + fileName.replace("/", "%2F") + "?alt=media&token=" + downloadToken;

        return  downloadUrl;
    }
}
