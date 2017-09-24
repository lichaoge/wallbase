package tv.wallbase.service.impl;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tv.wallbase.gateway.model.Wallpaper;
import tv.wallbase.gateway.service.OssService;
import tv.wallbase.gateway.service.WallpaperService;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 阿里云对象存储
 * Created by wangkun23 on 2017/9/24.
 * {
 * "ApertureValue": {"value": "3356144/1000000"},
 * "BodySerialNumber": {"value": "9082736"},
 * "CFAPattern": {"value": "2 0 2 0 0 1 1 2"},
 * "ColorSpace": {"value": "1"},
 * "Compression": {"value": "6"},
 * "Contrast": {"value": "0"},
 * "CustomRendered": {"value": "0"},
 * "DateTime": {"value": "2017:07:15 11:00:43"},
 * "DateTimeDigitized": {"value": "2017:06:09 10:10:12"},
 * "DateTimeOriginal": {"value": "2017:06:09 10:10:12"},
 * "DigitalZoomRatio": {"value": "1/1"},
 * "ExifTag": {"value": "209"},
 * "ExifVersion": {"value": "48 50 51 48"},
 * "ExposureBiasValue": {"value": "0/6"},
 * "ExposureMode": {"value": "1"},
 * "ExposureProgram": {"value": "1"},
 * "ExposureTime": {"value": "1/100"},
 * "FNumber": {"value": "32/10"},
 * "FileSize": {"value": "926928"},
 * "FileSource": {"value": "3"},
 * "Flash": {"value": "16"},
 * "FocalLength": {"value": "310/10"},
 * "FocalLengthIn35mmFilm": {"value": "31"},
 * "FocalPlaneResolutionUnit": {"value": "3"},
 * "FocalPlaneXResolution": {"value": "67122044/32768"},
 * "FocalPlaneYResolution": {"value": "67122044/32768"},
 * "Format": {"value": "jpg"},
 * "GainControl": {"value": "0"},
 * "ISOSpeedRatings": {"value": "250"},
 * "ImageHeight": {"value": "2208"},
 * "ImageWidth": {"value": "1474"},
 * "JPEGInterchangeFormat": {"value": "960"},
 * "JPEGInterchangeFormatLength": {"value": "5905"},
 * "LensModel": {"value": "24.0-70.0 mm f/2.8"},
 * "LensSpecification": {"value": "240/10 700/10 28/10 28/10"},
 * "LightSource": {"value": "0"},
 * "Make": {"value": "NIKON CORPORATION"},
 * "MaxApertureValue": {"value": "30/10"},
 * "MeteringMode": {"value": "3"},
 * "Model": {"value": "NIKON D810"},
 * "Orientation": {"value": "1"},
 * "PixelXDimension": {"value": "1474"},
 * "PixelYDimension": {"value": "2208"},
 * "ResolutionUnit": {"value": "2"},
 * "Saturation": {"value": "0"},
 * "SceneCaptureType": {"value": "0"},
 * "SceneType": {"value": "1"},
 * "SensingMethod": {"value": "2"},
 * "SensitivityType": {"value": "2"},
 * "Sharpness": {"value": "2"},
 * "ShutterSpeedValue": {"value": "6643856/1000000"},
 * "Software": {"value": "ACDSee 18"},
 * "SubSecTime": {"value": "543"},
 * "SubSecTimeDigitized": {"value": "99"},
 * "SubSecTimeOriginal": {"value": "99"},
 * "SubjectDistanceRange": {"value": "0"},
 * "WhiteBalance": {"value": "1"},
 * "XResolution": {"value": "3000000/10000"},
 * "YCbCrPositioning": {"value": "1"},
 * "YResolution": {"value": "3000000/10000"}
 * }
 */
@Service
public class OssServiceImpl implements OssService {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private OSSClient ossClient;

    @Resource
    WallpaperService wallpaperService;


    private String bucketName = "wallbasetv";

    public void updateWallpaperMetadataInfo(Wallpaper wallpaper) {
        // 图片信息
        String style = "image/info";
        GetObjectRequest request = new GetObjectRequest(bucketName, wallpaper.getImageUrl());
        request.setProcess(style);
        OSSObject ossObject = ossClient.getObject(request);

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, HashMap<String, String>> wallpaperInfo = null;
        try {
            wallpaperInfo = objectMapper.readValue(ossObject.getObjectContent(), Map.class);

            logger.info("FileSize {}", wallpaperInfo.get("FileSize").get("value"));
            logger.info("ImageWidth {}", wallpaperInfo.get("ImageWidth").get("value"));
            logger.info("ImageHeight{}", wallpaperInfo.get("ImageHeight").get("value"));

            Double size = Double.parseDouble(wallpaperInfo.get("FileSize").get("value"));
            Integer width = Integer.parseInt(wallpaperInfo.get("ImageWidth").get("value"));
            Integer height = Integer.parseInt(wallpaperInfo.get("ImageHeight").get("value"));

            Wallpaper update = new Wallpaper();
            update.setId(wallpaper.getId());
            update.setSize(size);
            update.setWidth(width);
            update.setHeight(height);

            wallpaperService.update(update);
        } catch (IOException e) {
            logger.error("{}", e);
        }
    }


}
