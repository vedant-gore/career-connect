package com.vedant.JobApp_Rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

// it will create the getter-setters/toString method/etc
@NoArgsConstructor // default constructor
@AllArgsConstructor // constructor which will take all the parameters
@Component
@Data
@Entity
public class JobPost {
    @Id
    private int postId;
    private String postProfile;
    private String postDesc;
    private int reqExperience;
    private List<String> postTechStack;

    // READ THIS ERROR
    /* SINCE ANNOTATION PROCESSING WAS DISABLED IN INTELLIJ WE HAD TO CREATE THIS CONSTRUCTOR BECAUSE WE WERE GETTING THE FOLLOWING ERROR:
    java: name clash: JobPost(int,java.lang.String,java.lang.String,int,java.util.List<java.lang.String>) and <T>JobPost(int,java.lang.String,java.lang.String,int,java.util.List<java.lang.String>) have the same erasure

     The error names  have the same erasure is indicating that you have two methods or constructors with the same erasure, which means that after type erasure, the signatures of these methods or constructors are the same. This is not allowed in Java.

    Understanding Type Erasure
    Java's type erasure process removes all generic type information during compilation, which can result in different generic methods or constructors having the same signature. For example, List<String> and List<Integer> both become List after type erasure.
    If you really need a constructor with different parameter types, keep this one.

     public JobPost(int id, String title, String description, int experience, List<Object> techStack, boolean isGeneric) {
        this.postId = id;
        this.postProfile = title;
        this.postDesc = description;
        this.reqExperience = experience;
        // This constructor would likely need to handle techStack differently.
        // Since it's of type List<Object>, consider converting it or handling it as needed.
     } */
}
