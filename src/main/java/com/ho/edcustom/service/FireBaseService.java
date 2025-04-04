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

    public HttpResponse uploadProfile(MultipartFile file, String namefile)
        throws IOException, FirebaseAuthException{
        Bucket bucket = StorageClient.getInstance().bucket(firebaseBucket);
        Storage storage = bucket.getStorage();

        // 저장될 파일명 (UUID 활용)
        //String fileName = "profile/" + UUID.randomUUID() + "_" + file.getOriginalFilename();
        String fileName ="profile/"+namefile;
        // Access Token 생성
        String downloadToken = UUID.randomUUID().toString();
        // 메타데이터 설정 (Access Token 추가)
        Map<String, String> metadata = new HashMap<>();
        metadata.put("firebaseStorageDownloadTokens", downloadToken);

        // 파일 정보 생성
        BlobInfo blobInfo = BlobInfo.newBuilder(bucket.getName(), fileName)
                .setContentType(file.getContentType())
                .setMetadata(metadata)
                .build();

        // Firebase Storage에 업로드
        Blob blob = storage.create(blobInfo, file.getBytes());

        // 다운로드 가능한 URL 생성
        String downloadUrl = "https://firebasestorage.googleapis.com/v0/b/" + bucket.getName() +
                "/o/" + fileName.replace("/", "%2F") + "?alt=media&token=" + downloadToken;


        return new HttpResponse(HttpStatus.CREATED, ErrorCode.CREATED, downloadUrl);
    }
    public HttpResponse uploadItem(MultipartFile file,String namefile)
            throws IOException, FirebaseAuthException{
        Bucket bucket = StorageClient.getInstance().bucket(firebaseBucket);
        Storage storage = bucket.getStorage();

        // 저장될 파일명 (UUID 활용)
        //String fileName = "keyboard/" + UUID.randomUUID() + "_" + file.getOriginalFilename();
        String fileName ="keyboard/"+namefile;
        // Access Token 생성
        String downloadToken = UUID.randomUUID().toString();
        // 메타데이터 설정 (Access Token 추가)
        Map<String, String> metadata = new HashMap<>();
        metadata.put("firebaseStorageDownloadTokens", downloadToken);

        // 파일 정보 생성
        BlobInfo blobInfo = BlobInfo.newBuilder(bucket.getName(), fileName)
                .setContentType(file.getContentType())
                .setMetadata(metadata)
                .build();

        // Firebase Storage에 업로드
        Blob blob = storage.create(blobInfo, file.getBytes());

        // 다운로드 가능한 URL 생성
        String downloadUrl = "https://firebasestorage.googleapis.com/v0/b/" + bucket.getName() +
                "/o/" + fileName.replace("/", "%2F") + "?alt=media&token=" + downloadToken;

        return new HttpResponse(HttpStatus.CREATED, ErrorCode.CREATED, downloadUrl);
    }
}
