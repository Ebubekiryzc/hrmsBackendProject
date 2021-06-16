package kodlamaio.hrms.core.adapters.concretes;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.adapters.abstracts.UserImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

@Service
public class CloudinaryAdapter implements UserImageService {

	private Cloudinary cloudinary;

	public CloudinaryAdapter() {
		cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "eyprojects", "api_key", "514167183176446",
				"api_secret", "YFTJgOV0e81ybTtrQjxcLjrT-9c"));
	}

	@Override
	public DataResult<String> addJobSeekerPicture(MultipartFile file) throws IOException {
		var uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
		return new SuccessDataResult<String>(uploadResult.get("secure_url").toString(),"Picture added!");
	}

}
