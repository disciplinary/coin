package com.coin;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Auther: Yi
 * @Date: 2021/4/16
 */
public class CodeGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //获取项目路径
        String projectPath = System.getProperty("user.dir");
        //输出目录
        gc.setOutputDir(projectPath + "/src/main/java");
        //覆盖文件
        gc.setFileOverride(true);
        //打开文件夹
        gc.setOpen(true);
        // XML ResultMap: mapper.xml生成查询映射结果
        gc.setBaseResultMap(true);
        // XML ColumnList: mapper.xml生成查询结果列
        gc.setBaseColumnList(true);
        //ID自增长
        gc.setIdType(IdType.AUTO);
        //作者
        gc.setAuthor("Yi");
        //实体属性 Swagger2 注解
        gc.setSwagger2(true);



        //数据库配置
        DataSourceConfig dsc = new DataSourceConfig();
        //数据库路径
        dsc.setUrl("jdbc:mysql://localhost:3306/coin?useUnicode=true&characterEncoding=utf-8&useSSL=false");
        //数据库驱动
        dsc.setDriverName("com.mysql.jdbc.Driver");
        //账号
        dsc.setUsername("root");
        //密码
        dsc.setPassword("123456");


        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("模块名"));


        // 自定义模板
        TemplateConfig template = new TemplateConfig();
        //设置模板
        template.setController("templates/controller.java");
        template.setService("templates/service.java");
        template.setServiceImpl("templates/serviceImpl.java");
        template.setMapper("templates/mapper.java");
        template.setXml("templates/mapper.xml");
        template.setEntity("templates/entity.java");


        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //命名设置，驼峰命名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //列命名设置，驼峰命名
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //实体是否是Lombok模型
        strategy.setEntityLombokModel(true);
        //生成@RestController控制器
        strategy.setRestControllerStyle(true);
        // 公共父类
//        strategy.setSuperControllerClass("com.mybatisplus.movie.common.BaseController");
//        strategy.setSuperEntityClass("com.mybatisplus.movie.common.BaseEntity");
        // 写于父类中的公共字段
//        strategy.setSuperEntityColumns("id");
        //需要生成的表,不设置默认数据库里的全部表需要生成
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        //设置控制器映射连字符样式
        strategy.setControllerMappingHyphenStyle(true);
        //设置表前缀
//        strategy.setTablePrefix(pc.getModuleName() + "_");
        //设置实体列常量
        strategy.setEntityColumnConstant(true);
        //设置实体生成器模型
        strategy.setEntityBuilderModel(true);
        //设置实体表字段注释启用
        strategy.setEntityTableFieldAnnotationEnable(true);


        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        //加入全局配置
        mpg.setGlobalConfig(gc);
        //加入数据库配置
        mpg.setDataSource(dsc);
        //加入包配置
        mpg.setPackageInfo(pc);
        //加入自定义模板配置
        mpg.setTemplate(template);
        //加入策略配置
        mpg.setStrategy(strategy);
        //加入模板引擎
        //Freemarker模板引擎后缀为ftl
//        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        //Beetl模板硬气后缀为btl
//        mpg.setTemplateEngine(new BeetlTemplateEngine());
        //Velocity模板引擎后缀为vm
        mpg.setTemplateEngine(new VelocityTemplateEngine());
        //自定义文件生成路径，包路径
        //这里调用customPackagePath方法，使用可以自己在内部灵活配置路径
        //如果不调用该方法、就会使用MyBatis-Plus默认的文件生成路径和包路径生成文件、但可以使用上面的PackageConfig做一些简单的配置
        customPackagePath(pc,mpg);
        //执行代码生成器
        mpg.execute();
    }

    /**
     * 自定义包路径，文件生成路径，这边配置更灵活
     * 虽然也可以使用InjectionConfig设置FileOutConfig的方式设置路径
     * 这里直接使用Map方式注入ConfigBuilder配置对象更加直观
     * @param pc
     * @param mpg
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static void customPackagePath(PackageConfig pc,AutoGenerator mpg) throws NoSuchFieldException, IllegalAccessException {
        //获取文件所在路径
        String projectPath = System.getProperty("user.dir");
        String mavenPath = "\\src\\main\\java\\";
        String srcPath = projectPath+mavenPath;

        String moduleName = pc.getModuleName();

        /**
         * packageInfo配置controller、service、serviceImpl、entity、mapper等文件的包路径
         * 这里包路径可以根据实际情况灵活配置
         */
        Map<String,String> packageInfo = new HashMap<>();
        packageInfo.put(ConstVal.CONTROLLER, "com.study.mybatisplus.controller."+moduleName);
        packageInfo.put(ConstVal.SERVICE, "com.study.mybatisplus.services."+moduleName+".service");
        packageInfo.put(ConstVal.SERVICE_IMPL, "com.study.mybatisplus.services."+moduleName+".service.impl");
        packageInfo.put(ConstVal.ENTITY, "com.study.mybatisplus.entity."+moduleName);
        packageInfo.put(ConstVal.MAPPER, "com.study.mybatisplus.mapper."+moduleName);

        /**
         * pathInfo配置controller、service、serviceImpl、entity、mapper、mapper.xml等文件的生成路径
         * srcPath也可以更具实际情况灵活配置
         * 后面部分的路径是和上面packageInfo包路径对应的源码文件夹路径
         * 这里你可以选择注释其中某些路径，可忽略生成该类型的文件，例如:注释掉下面pathInfo中Controller的路径，就不会生成Controller文件
         */
        Map pathInfo = new HashMap<>();
        pathInfo.put(ConstVal.CONTROLLER_PATH, srcPath + packageInfo.get(ConstVal.CONTROLLER).replaceAll("\\.", StringPool.BACK_SLASH + File.separator));
        pathInfo.put(ConstVal.SERVICE_PATH, srcPath + packageInfo.get(ConstVal.SERVICE).replaceAll("\\.", StringPool.BACK_SLASH + File.separator));
        pathInfo.put(ConstVal.SERVICE_IMPL_PATH, srcPath + packageInfo.get(ConstVal.SERVICE_IMPL).replaceAll("\\.", StringPool.BACK_SLASH + File.separator));
        pathInfo.put(ConstVal.ENTITY_PATH, srcPath + packageInfo.get(ConstVal.ENTITY).replaceAll("\\.", StringPool.BACK_SLASH + File.separator));
        pathInfo.put(ConstVal.MAPPER_PATH, srcPath + packageInfo.get(ConstVal.MAPPER).replaceAll("\\.", StringPool.BACK_SLASH + File.separator));
        pathInfo.put(ConstVal.XML_PATH, projectPath+"\\src\\main\\resources\\mapper\\"+moduleName);
        pc.setPathInfo(pathInfo);

        /**
         * 创建configBuilder对象，传入必要的参数
         * 将以上的定义的包路径packageInfo配置到赋值到configBuilder对象的packageInfo属性上
         * 因为packageInfo是私有成员变量，也没有提交提供公共的方法，所以使用反射注入
         * 为啥要这么干，看源码去吧
         */
        ConfigBuilder configBuilder = new ConfigBuilder(mpg.getPackageInfo(), mpg.getDataSource(), mpg.getStrategy(), mpg.getTemplate(), mpg.getGlobalConfig());
        Field packageInfoField = configBuilder.getClass().getDeclaredField("packageInfo");
        packageInfoField.setAccessible(true);
        packageInfoField.set(configBuilder,packageInfo);

        /**
         * 设置配置对象
         */
        mpg.setConfig(configBuilder);
    }
}
