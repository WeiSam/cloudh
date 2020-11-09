package io.sam.spring;

import com.alibaba.fastjson.JSON;
import io.sam.dto.GetEnclosingClassOfClass;
import io.sam.service.LeaveApproveService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.*;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author zhuweimu
 * @classname MetaDataTest
 * @description
 * @date 2020/10/30 9:22
 */
@Slf4j
public class MetaDataTest {
    @Test
    public void testResoure() throws IOException {
        String basePackage = "io.sam.service";
        PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX +
                resolveBasePackage(basePackage) + '/' + "**/*.class";
        Resource[] resources = resourcePatternResolver.getResources(packageSearchPath);
        CachingMetadataReaderFactory cachingMetadataReaderFactory = new CachingMetadataReaderFactory();

        MetadataReader leaveApproveServiceMr = cachingMetadataReaderFactory.getMetadataReader(LeaveApproveService.class.getName());
        for (Resource resource : resources) {
            MetadataReader metadataReader = cachingMetadataReaderFactory.getMetadataReader(resource);
            Class<? extends MetadataReader> aClass = metadataReader.getClass();
            ClassMetadata classMetadata = metadataReader.getClassMetadata();
            AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
            ScannedGenericBeanDefinition sbd = new ScannedGenericBeanDefinition(metadataReader);
            sbd.setSource(resource);
            boolean b = isCandidateComponent(sbd);
            log.info("className = {},isCandidateComponent = {}",sbd.getBeanClassName(),b);
        }

        leaveApproveServiceMr = cachingMetadataReaderFactory.getMetadataReader(LeaveApproveService.class.getName());

        Arrays.stream(resources).forEach(System.out::println);
    }

    protected String resolveBasePackage(String basePackage) {
        return ClassUtils.convertClassNameToResourcePath(new StandardEnvironment().resolveRequiredPlaceholders(basePackage));
    }

    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        AnnotationMetadata metadata = beanDefinition.getMetadata();
        return (metadata.isIndependent() && (metadata.isConcrete() ||
                (metadata.isAbstract() && metadata.hasAnnotatedMethods(Lookup.class.getName()))));
    }

    @Test
    public void name() throws IOException {
        CachingMetadataReaderFactory cachingMetadataReaderFactory = new CachingMetadataReaderFactory();

        Class<GetEnclosingClassOfClass> clazz = GetEnclosingClassOfClass.class;
//        Class<GetEnclosingClassOfClass.InnerClass02> clazz = GetEnclosingClassOfClass.InnerClass02.class;
        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getCanonicalName());
        MetadataReader metadataReader = cachingMetadataReaderFactory.getMetadataReader(clazz.getName());
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        System.out.println(classMetadata.getClassName());
        System.out.println(annotationMetadata.getClassName());

        System.out.println("classMetadata.isIndependent() = "+classMetadata.isIndependent());
        System.out.println("classMetadata.isConcrete() = "+classMetadata.isConcrete());
        System.out.println("classMetadata.getSuperClassName() = "+classMetadata.getSuperClassName());
        System.out.println("classMetadata.getInterfaceNames() = "+ JSON.toJSONString(classMetadata.getInterfaceNames()));
        System.out.println("classMetadata.getMemberClassNames() = "+JSON.toJSONString(classMetadata.getMemberClassNames()));
        System.out.println(clazz.getEnclosingClass());
        System.out.println(GetEnclosingClassOfClass.InnerClass02.class.getEnclosingClass());

        ScannedGenericBeanDefinition sbd = new ScannedGenericBeanDefinition(metadataReader);
        sbd.setSource(metadataReader.getResource());
        sbd.setResource(metadataReader.getResource());
        log.info("className = {},isCandidateComponent = {}",sbd.getBeanClassName(),isCandidateComponent(sbd));
    }

    @Test
    public void testSimpleMethodMetadata() {
        GetEnclosingClassOfClass getEnclosingClassOfClass = new GetEnclosingClassOfClass();
    }
}
