package com.nju.tutorialtool.service;

import com.nju.tutorialtool.model.ProjectInfo;
import com.nju.tutorialtool.template.common.PomXmlResourceFile;
import com.nju.tutorialtool.template.spring.ApplicationClassFile;
import com.nju.tutorialtool.template.spring.ApplicationYmlResourceFile;
import org.springframework.stereotype.Service;

@Service
public class CreateProjectService {
    public void createProject(ProjectInfo projectInfo) {
        try {
            createEmptyProject(projectInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String toPackage(String packageDir) {
        return packageDir.replaceAll("/", ".");
    }

    private static String toDir(String packageDir) {
        return packageDir.replaceAll("\\.", "/");
    }

    public void createEurekaServer(ProjectInfo projectInfo) {
        try {
            createEmptyProject(projectInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createEmptyProject(ProjectInfo projectInfo) throws Exception {
        PomXmlResourceFile pxrf = new PomXmlResourceFile(projectInfo.getBaseDir() + "/" + projectInfo.getArtifactId(), projectInfo.getGroupId(), projectInfo.getArtifactId(), projectInfo.getDependencies());
        pxrf.generate();

        ApplicationYmlResourceFile ayrf = new ApplicationYmlResourceFile(projectInfo.getBaseDir() + "/" + projectInfo.getArtifactId() + "/" + "src/main/resources");
        ayrf.generate();

        ApplicationClassFile acf = new ApplicationClassFile(projectInfo.getBaseDir() + "/" + projectInfo.getArtifactId() + "/" + "src/main/java" + "/" + toDir(projectInfo.getGroupId()) + "/" + projectInfo.getArtifactId(), toPackage(projectInfo.getGroupId() + "/" + projectInfo.getArtifactId()), projectInfo.getDependencies());
        acf.generate();
    }
}
