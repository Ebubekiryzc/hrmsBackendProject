package kodlamaio.hrms.core.adapters.abstracts;


import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;

public interface UserImageService {
	
	DataResult<String> addJobSeekerPicture(MultipartFile file) throws IOException;

}
