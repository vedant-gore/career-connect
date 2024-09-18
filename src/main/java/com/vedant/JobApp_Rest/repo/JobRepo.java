package com.vedant.JobApp_Rest.repo;

import com.vedant.JobApp_Rest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);
}

//List<JobPost> jobs = new ArrayList<>(List.of(
//        new JobPost(1, "Java Developer", "Must have good experience in core Java", 1, Arrays.asList("Java", "SpringBoot"))
//));
//
//public List<JobPost> getAllJobs() {
//    return jobs;
//}
//
//public void addJobs(JobPost job) {
//    jobs.add(job);
//    System.out.println(jobs);
//}
//
//public JobPost getJob(int postId) {
//    for (JobPost job : jobs) {
//        if (job.getPostId() == postId) {  // Corrected line
//            return job;
//        }
//    }
//    return null;
//}
//
//public void updateJob(JobPost jobPost) {
//    for(JobPost jobPost1 : jobs){
//        if(jobPost1.getPostId() == jobPost.getPostId()) {
//            jobPost1.setPostProfile(jobPost.getPostProfile());
//            jobPost1.setPostDesc(jobPost.getPostDesc());
//            jobPost1.setReqExperience(jobPost.getReqExperience());
//            jobPost1.setPostTechStack(jobPost.getPostTechStack());
//        }
//    }
//}
//
//public void deleteJob(int postId) {
//    for(JobPost jobPost : jobs){
//        if(jobPost.getPostId() == postId){
//            jobs.remove(jobPost);
//        }
//    }
//    // jobs.removeIf(jobPost -> jobPost.getPostId() == postId);
//}