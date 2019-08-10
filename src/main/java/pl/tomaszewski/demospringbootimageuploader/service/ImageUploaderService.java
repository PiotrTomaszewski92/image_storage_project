package pl.tomaszewski.demospringbootimageuploader.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.tomaszewski.demospringbootimageuploader.configuration.CloudinaryConfig;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class ImageUploaderService {

    private Cloudinary cloudinary;

    public ImageUploaderService() {
        this.cloudinary = new Cloudinary(CloudinaryConfig.getConfigMap());
    }

    public void uploadImage(String filePath) throws IOException {
            //"/Users/tomaszewski/Downloads/photo.jpg"
        File file = new File(filePath);
        Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
    }
}
