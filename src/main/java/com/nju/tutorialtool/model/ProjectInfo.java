package com.nju.tutorialtool.model;

import java.util.ArrayList;
import java.util.List;

public class ProjectInfo {
//    private String baseDir;
    private String groupId;
    private String artifactId;
    private List<String> dependencies;

    public ProjectInfo() {
    }

    public ProjectInfo(String groupId, String artifactId, List<String> dependencies) {
//        this.baseDir = baseDir;
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.dependencies = dependencies;
    }

    public ProjectInfo(SpringCloudInfo springCloudInfo) {
//        this.baseDir = springCloudInfo.getBaseDir();
        this.groupId = springCloudInfo.getGroupId();
        this.artifactId = springCloudInfo.getArtifactId();
        this.dependencies = new ArrayList<>();
    }

//    public String getBaseDir() {
//        return baseDir;
//    }
//
//    public void setBaseDir(String baseDir) {
//        this.baseDir = baseDir;
//    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public List<String> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<String> dependencies) {
        this.dependencies = dependencies;
    }

    public void addDependency(String dependency) {
        this.dependencies.add(dependency);
    }
}
