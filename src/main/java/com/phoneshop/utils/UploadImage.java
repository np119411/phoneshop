package com.phoneshop.utils;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.Part;
import java.io.InputStreamReader;
import java.util.Map;

public class UploadImage {
	public static Map uploadAvatarImage(String imageName, Part file) {
		Cloudinary cloudinary = CloudinaryUtil.getCloudinary();

		try {
			byte[] sourceBytes = IOUtils.toByteArray(file.getInputStream());

			Base64 base64 = new Base64();
			String encodedString = base64.encodeToString(sourceBytes);

			// Upload the image
			Map params1 = ObjectUtils.asMap("folder", Constant.STORAGE_IMAGE_LOCATION, "public_id", imageName,
					"use_filename", true, "unique_filename", false, "overwrite", true);

			Map result = cloudinary.uploader().upload("data:image/png;base64," + encodedString, params1);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Map deleteAvatarImage(String imageName) {
		Cloudinary cloudinary = CloudinaryUtil.getCloudinary();

		try {
			// Destroy the image
			Map params1 = ObjectUtils.asMap("resource_type", "image", "folder", "type",
					"upload", "invalidate", true);

			Map result = cloudinary.uploader().destroy(Constant.STORAGE_IMAGE_LOCATION + "/" + imageName, params1);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}