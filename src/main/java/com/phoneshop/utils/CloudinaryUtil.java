package com.phoneshop.utils;

import com.cloudinary.Cloudinary;

public class CloudinaryUtil {

    public static Cloudinary cloudinary;
    public static Cloudinary getCloudinary() {
        if (cloudinary == null) {
        	
            cloudinary = new Cloudinary("cloudinary://391931337961951:bvttlQaPMA4vlqBbHOyHu96NGFs@dmuoramss");
            cloudinary.config.secure = true;
            System.out.println("Cloud name: " + cloudinary.config.cloudName);
        }
        return cloudinary;
    }
}