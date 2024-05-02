package com.rfrey.book.file;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
public class FileUtils {
    public static byte[] readFileFromLocation(String fileUrl) {
        if (StringUtils.isBlank(fileUrl)) {
            return null;
        }
        try {
            return Files.readAllBytes(Paths.get(fileUrl));
        } catch (IOException e) {
            log.warn("Error reading file from location: {}", fileUrl, e);
        }
        return null;
    }
}
