package com.example.employeemanagement.util;

import lombok.SneakyThrows;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import com.example.employeemanagement.exception.UploadFileException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

public class FileUtil {

    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));

    private static final Path RESOURCES_PATH = CURRENT_FOLDER.resolve(Paths.get("src/main/resources"));

    /**
     * Lưu tệp tải lên vào folder Resources
     *
     * @param newFileName   Tên file mới để lưu
     * @param multipartFile File cần lưu
     * @return tên file mới
     */
    public static String saveFile(String newFileName, MultipartFile multipartFile) {
        try {
            Path path = RESOURCES_PATH.resolve(Paths.get("images"));
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }
            String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
            String fileType = fileName.substring(fileName.lastIndexOf("."));
            String newFile = newFileName + "_" + fileName;
            Path filePath;
            InputStream inputStream = multipartFile.getInputStream();
            filePath = path.resolve(newFile);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            return newFile;
        } catch (IOException ioe) {
            throw new UploadFileException("Could not save file image!");
        }

    }

    public static void deleteFile(String image) {
        Path path = Paths.get(RESOURCES_PATH + "/" + "images" + "/" + image);
        try {
            if (Files.exists(path)) {
                Files.delete(path);
            }
        } catch (IOException e) {
            throw new UploadFileException("Could not delete file: " + image);
        }
    }

    /**
     * Kiểm tra một folder trong Resources có tồn tại không
     *
     * @param folderPath Đường dẫn của folder (trong phạm vi folder resources), example: "upload/xxx/xxx"
     * @return boolean
     */
    public static boolean isFolderNotExists(String folderPath) {
        Path path = RESOURCES_PATH.resolve(Paths.get(folderPath));
        return !Files.exists(path);
    }

    /**
     * Lấy ra file ở trong thư mục resources theo đường dẫn
     *
     * @param pathFile Đường dẫn file cần lấy (trong phạm vi folder resources), example: "upload/xxx/fileName.xxx"
     * @return File
     */
    public static File getFileByPath(String pathFile) {
        Path path = RESOURCES_PATH.resolve(Paths.get(pathFile));
        return path.toFile();
    }

    /**
     * Lấy ra dữ liệu file ở trong thư mục resources theo đường dẫn
     *
     * @param pathFile - đường dẫn file cần lấy (trong phạm vi folder resources), example: "upload/xxx/fileName.xxx"
     * @return byte[]
     */
    @SneakyThrows
    public static byte[] getBytesFileByPath(String pathFile) {
        Path path = RESOURCES_PATH.resolve(Paths.get(pathFile));
        return Files.readAllBytes(path);
    }


}
