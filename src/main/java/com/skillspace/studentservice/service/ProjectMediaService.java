package com.skillspace.studentservice.service;

import com.skillspace.studentservice.models.ProjectMedia;
import com.skillspace.studentservice.repository.ProjectMediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProjectMediaService {
    @Autowired
    private ProjectMediaRepository projectMediaRepository;

    @Autowired
    private S3Service s3Service;

    public Map<String,String> addProjectMedia(MultipartFile[] media , String project_id) {
        Map<String,String> map = new HashMap<>();
        try{

            for(MultipartFile multipartFile : media ){
                String url = s3Service.uploadFile(multipartFile,project_id);
                projectMediaRepository.insertMedia(Integer.parseInt(project_id),url);
            }
            map.put("Message","Success");
            return map;
        }
        catch(Exception e){
            map.put("Message","Error");
            return map;
        }
    }

    public Map<String, List<ProjectMedia>> getAllProjectMedia(int project_id){
        HashMap<String,List<ProjectMedia>> map = new HashMap<>();
        map.put("media",projectMediaRepository.getProjectMediaById(project_id));
        return map;
    }

}
