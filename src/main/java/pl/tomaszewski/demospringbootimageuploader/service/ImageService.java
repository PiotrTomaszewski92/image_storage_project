package pl.tomaszewski.demospringbootimageuploader.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import pl.tomaszewski.demospringbootimageuploader.configuration.CloudinaryConfig;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ImageService {

    public static void main(String[] args) throws IOException {
        Cloudinary cloudinary = new Cloudinary(CloudinaryConfig.getConfigMap());

        File file = new File("/Users/tomaszewski/Downloads/photo.jpg");
        Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
    }
}
