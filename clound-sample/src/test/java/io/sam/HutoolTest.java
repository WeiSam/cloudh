package io.sam;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import org.junit.Test;
import sun.misc.Contended;

import java.math.BigDecimal;

/**
 * @author zhuweimu
 * @desc
 * @date 2022/11/29 11:02
 */
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
}
