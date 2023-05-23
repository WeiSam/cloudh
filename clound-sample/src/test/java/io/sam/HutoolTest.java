package io.sam;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.StreamProgress;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpException;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import sun.misc.Contended;

import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.HashMap;

/**
 * @author zhuweimu
 * @desc
 * @date 2022/11/29 11:02
 */
@Slf4j
public @Contended class HutoolTest {

    @Test
    public void testJson() {
        String str = "{\n" +
                "    \"coverage\": {\n" +
                "        \"name\": \"1ab5a938-afb1-4ed9-9b9c-64900c04854d\",\n" +
                "        \"nativeName\": \"1ab5a938-afb1-4ed9-9b9c-64900c04854d\",\n" +
                "        \"namespace\": {\n" +
                "            \"name\": \"CMT\",\n" +
                "            \"href\": \"http://192.168.37.163:8600/geoserver/rest/namespaces/CMT.json\"\n" +
                "        },\n" +
                "        \"title\": \"1ab5a938-afb1-4ed9-9b9c-64900c04854d\",\n" +
                "        \"description\": \"Generated from GeoTIFF\",\n" +
                "        \"keywords\": {\n" +
                "            \"string\": [\n" +
                "                \"1ab5a938-afb1-4ed9-9b9c-64900c04854d\",\n" +
                "                \"WCS\",\n" +
                "                \"GeoTIFF\"\n" +
                "            ]\n" +
                "        },\n" +
                "        \"nativeCRS\": {\n" +
                "            \"@class\": \"projected\",\n" +
                "            \"$\": \"PROJCS[\\\"WGS 84 / Pseudo-Mercator\\\", \\n  GEOGCS[\\\"WGS 84\\\", \\n    DATUM[\\\"World Geodetic System 1984\\\", \\n      SPHEROID[\\\"WGS 84\\\", 6378137.0, 298.257223563, AUTHORITY[\\\"EPSG\\\",\\\"7030\\\"]], \\n      AUTHORITY[\\\"EPSG\\\",\\\"6326\\\"]], \\n    PRIMEM[\\\"Greenwich\\\", 0.0, AUTHORITY[\\\"EPSG\\\",\\\"8901\\\"]], \\n    UNIT[\\\"degree\\\", 0.017453292519943295], \\n    AXIS[\\\"Geodetic longitude\\\", EAST], \\n    AXIS[\\\"Geodetic latitude\\\", NORTH], \\n    AUTHORITY[\\\"EPSG\\\",\\\"4326\\\"]], \\n  PROJECTION[\\\"Popular Visualisation Pseudo Mercator\\\", AUTHORITY[\\\"EPSG\\\",\\\"1024\\\"]], \\n  PARAMETER[\\\"semi_minor\\\", 6378137.0], \\n  PARAMETER[\\\"latitude_of_origin\\\", 0.0], \\n  PARAMETER[\\\"central_meridian\\\", 0.0], \\n  PARAMETER[\\\"scale_factor\\\", 1.0], \\n  PARAMETER[\\\"false_easting\\\", 0.0], \\n  PARAMETER[\\\"false_northing\\\", 0.0], \\n  UNIT[\\\"m\\\", 1.0], \\n  AXIS[\\\"Easting\\\", EAST], \\n  AXIS[\\\"Northing\\\", NORTH], \\n  AUTHORITY[\\\"EPSG\\\",\\\"3857\\\"]]\"\n" +
                "        },\n" +
                "        \"srs\": \"EPSG:3857\",\n" +
                "        \"nativeBoundingBox\": {\n" +
                "            \"minx\": 2.840909090909088,\n" +
                "            \"maxx\": 2997.4241037768347,\n" +
                "            \"miny\": -3.12235232550438,\n" +
                "            \"maxy\": 1750,\n" +
                "            \"crs\": {\n" +
                "                \"@class\": \"projected\",\n" +
                "                \"$\": \"EPSG:3857\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"latLonBoundingBox\": {\n" +
                "            \"minx\": 0.00002552032057157729,\n" +
                "            \"maxx\": 0.02692631885410989,\n" +
                "            \"miny\": -0.000028048568173031105,\n" +
                "            \"maxy\": 0.015720517274837403,\n" +
                "            \"crs\": \"EPSG:4326\"\n" +
                "        },\n" +
                "        \"projectionPolicy\": \"REPROJECT_TO_DECLARED\",\n" +
                "        \"enabled\": true,\n" +
                "        \"metadata\": {\n" +
                "            \"entry\": {\n" +
                "                \"@key\": \"dirName\",\n" +
                "                \"$\": \"1ab5a938-afb1-4ed9-9b9c-64900c04854d_null\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"store\": {\n" +
                "            \"@class\": \"coverageStore\",\n" +
                "            \"name\": \"CMT:1ab5a938-afb1-4ed9-9b9c-64900c04854d\",\n" +
                "            \"href\": \"http://192.168.37.163:8600/geoserver/rest/workspaces/CMT/coveragestores/1ab5a938-afb1-4ed9-9b9c-64900c04854d.json\"\n" +
                "        },\n" +
                "        \"serviceConfiguration\": false,\n" +
                "        \"simpleConversionEnabled\": false,\n" +
                "        \"nativeFormat\": \"GeoTIFF\",\n" +
                "        \"grid\": {\n" +
                "            \"@dimension\": \"2\",\n" +
                "            \"range\": {\n" +
                "                \"low\": \"0 0\",\n" +
                "                \"high\": \"3734 2186\"\n" +
                "            },\n" +
                "            \"transform\": {\n" +
                "                \"scaleX\": 0.8019772883465254,\n" +
                "                \"scaleY\": -0.8019772883465254,\n" +
                "                \"shearX\": 0,\n" +
                "                \"shearY\": 0,\n" +
                "                \"translateX\": 3.241897735082351,\n" +
                "                \"translateY\": 1749.5990113558266\n" +
                "            },\n" +
                "            \"crs\": \"EPSG:3857\"\n" +
                "        },\n" +
                "        \"supportedFormats\": {\n" +
                "            \"string\": [\n" +
                "                \"DTED\",\n" +
                "                \"SRP\",\n" +
                "                \"ArcGrid\",\n" +
                "                \"GIF\",\n" +
                "                \"PNG\",\n" +
                "                \"JPEG\",\n" +
                "                \"TIFF\",\n" +
                "                \"NITF\",\n" +
                "                \"ENVIHdr\",\n" +
                "                \"GEOTIFF\",\n" +
                "                \"VRT\",\n" +
                "                \"GeoPackage (mosaic)\",\n" +
                "                \"ImageMosaic\",\n" +
                "                \"ImagePyramid\",\n" +
                "                \"AIG\",\n" +
                "                \"ERDASImg\",\n" +
                "                \"EHdr\",\n" +
                "                \"RPFTOC\",\n" +
                "                \"RST\"\n" +
                "            ]\n" +
                "        },\n" +
                "        \"interpolationMethods\": {\n" +
                "            \"string\": [\n" +
                "                \"nearest neighbor\",\n" +
                "                \"bilinear\",\n" +
                "                \"bicubic\"\n" +
                "            ]\n" +
                "        },\n" +
                "        \"defaultInterpolationMethod\": \"nearest neighbor\",\n" +
                "        \"dimensions\": {\n" +
                "            \"coverageDimension\": [\n" +
                "                {\n" +
                "                    \"name\": \"RED_BAND\",\n" +
                "                    \"description\": \"GridSampleDimension[-Infinity,Infinity]\",\n" +
                "                    \"range\": {\n" +
                "                        \"min\": \"-inf\",\n" +
                "                        \"max\": \"inf\"\n" +
                "                    },\n" +
                "                    \"unit\": \"W.m-2.Sr-1\",\n" +
                "                    \"dimensionType\": {\n" +
                "                        \"name\": \"UNSIGNED_8BITS\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"GREEN_BAND\",\n" +
                "                    \"description\": \"GridSampleDimension[-Infinity,Infinity]\",\n" +
                "                    \"range\": {\n" +
                "                        \"min\": \"-inf\",\n" +
                "                        \"max\": \"inf\"\n" +
                "                    },\n" +
                "                    \"unit\": \"W.m-2.Sr-1\",\n" +
                "                    \"dimensionType\": {\n" +
                "                        \"name\": \"UNSIGNED_8BITS\"\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"BLUE_BAND\",\n" +
                "                    \"description\": \"GridSampleDimension[-Infinity,Infinity]\",\n" +
                "                    \"range\": {\n" +
                "                        \"min\": \"-inf\",\n" +
                "                        \"max\": \"inf\"\n" +
                "                    },\n" +
                "                    \"unit\": \"W.m-2.Sr-1\",\n" +
                "                    \"dimensionType\": {\n" +
                "                        \"name\": \"UNSIGNED_8BITS\"\n" +
                "                    }\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        \"requestSRS\": {\n" +
                "            \"string\": [\n" +
                "                \"EPSG:3857\"\n" +
                "            ]\n" +
                "        },\n" +
                "        \"responseSRS\": {\n" +
                "            \"string\": [\n" +
                "                \"EPSG:3857\"\n" +
                "            ]\n" +
                "        },\n" +
                "        \"parameters\": {\n" +
                "            \"entry\": [\n" +
                "                {\n" +
                "                    \"string\": [\n" +
                "                        \"InputTransparentColor\",\n" +
                "                        \"\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"string\": [\n" +
                "                        \"SUGGESTED_TILE_SIZE\",\n" +
                "                        \"512,512\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"string\": [\n" +
                "                        \"RescalePixels\",\n" +
                "                        true\n" +
                "                    ]\n" +
                "                }\n" +
                "            ],\n" +
                "            \"nativeCoverageName\": \"1ab5a938-afb1-4ed9-9b9c-64900c04854d\"\n" +
                "        }\n" +
                "    }\n" +
                "}";

        JSON json = JSONUtil.parse(str);
        String workspaceName = (String) JSONUtil.getByPath(json, "coverage.namespace.name");
        String layerName = workspaceName + ":" + JSONUtil.getByPath(json, "coverage.name");
        BigDecimal minx = (BigDecimal) JSONUtil.getByPath(json, "coverage.nativeBoundingBox.minx");
        BigDecimal miny = (BigDecimal) JSONUtil.getByPath(json, "coverage.nativeBoundingBox.miny");
        BigDecimal maxx = (BigDecimal) JSONUtil.getByPath(json, "coverage.nativeBoundingBox.maxx");
//        BigDecimal maxy = JSONUtil.getByPath(json, "coverage.nativeBoundingBox.maxy");
        Object obj = JSONUtil.getByPath(json, "coverage.nativeBoundingBox.maxy");
        System.out.println(obj.toString());
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(obj));
        System.out.println(bigDecimal);

    }

    public static void download() {
        String body = "{\"fileName\":\"/home/gosun_record/20220318/f356c9a47aaa4c39bfc26cbf83cbbd9e_20220318-034531_65.mp4\"}";
        String fileUrl = "http://192.168.78.214:15999/vcs/record/download";
        long size = downloadFile(fileUrl,body, FileUtil.file("E:/abc.mp4"),-1,null);
        System.out.println(size);
    }

    public static long downloadFile(String url, String body, File destFile, int timeout, StreamProgress streamProgress) {

        if (StrUtil.isBlank(url)) {
            throw new NullPointerException("[url] is null!");
        } else if (null == destFile) {
            throw new NullPointerException("[destFile] is null!");
        } else {
            HttpResponse response = HttpRequest.post(url)
                    .header("authorization","Auth123456")
                    .body(body,"application/json")
                    .timeout(timeout)
                    .executeAsync();
            if (!response.isOk()) {
                throw new HttpException("Server response error with status code: [{}]", new Object[]{response.getStatus()});
            } else {
                return response.writeBody(destFile, streamProgress);
            }
        }
    }

    @Test
    public void testId() {
        long id = IdUtil.getSnowflakeNextId();
        Snowflake snowflake = IdUtil.getSnowflake(2, 10);
        long id2 = snowflake.nextId();
        log.info("{}",id);
        log.info("{}",id2);
    }

    @Test
    public void testUp() {
        HashMap<String, Object> paramMap = new HashMap<>();
        //文件上传只需将参数中的键指定（默认file），值设为文件对象即可，对于使用者来说，文件上传与普通表单提交并无区别
        paramMap.put("file", FileUtil.file("E:\\IdeaProjects\\easyexcel\\easyexcel-test\\target\\test-classes\\mergeWrite1681883305409.xlsx"));
        String result= HttpUtil.post("192.168.78.193/upload", paramMap);
        log.info("{}",result);
    }
}
