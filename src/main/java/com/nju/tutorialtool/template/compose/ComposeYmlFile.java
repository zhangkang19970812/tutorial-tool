package com.nju.tutorialtool.template.compose;

import com.nju.tutorialtool.base.ResourceFile;
import com.nju.tutorialtool.model.Service;
import com.nju.tutorialtool.util.enums.BaseDirConstant;

import java.util.List;

public class ComposeYmlFile extends ResourceFile {
    private static final String FILE_NAME = "docker-compose.yml";

    public ComposeYmlFile(String fileDir, List<Service> list) {
        super(fileDir, FILE_NAME);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("version: '3'\n" + "services:\n");
        for (Service service : list) {
            if (service.isMysql()) {
                stringBuilder.append("  " + service.getServiceName() + ":\n" +
                        "    " + "image: " + service.getServiceName() + "\n" +
                        "    " + "volumes:\n" +
                        "      " + "- " + BaseDirConstant.volumeDir + "/" + service.getServiceName() + ":/var/lib/mysql\n");
            }
            else if (service.getPort() != "") {
                stringBuilder.append("  " + service.getServiceName() + ":\n" +
                        "    " + "image: " + service.getServiceName() + "\n" +
                        "    " + "ports:\n" +
                        "      " + "- \"" + service.getPort() + ":" + service.getPort() + "\"\n");
            }
            else {
                stringBuilder.append("  " + service.getServiceName() + ":\n" +
                        "    " + "image: " + service.getServiceName() + "\n");
            }
        }

        init(stringBuilder.toString());
    }

}
