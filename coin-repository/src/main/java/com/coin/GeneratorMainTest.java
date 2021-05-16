package com.coin;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName GeneratorMain
 * @Author shiyawei
 * @Date 2021/5/11
 * @Version V1.0
 **/
public class GeneratorMainTest {


    //要生成的表名
    private static String[] tables = {
            "t_config"};


    public static void main(String[] args) {

        AutoGenerator autoGenerator = new AutoGenerator();
        //配置数据库信息
        autoGenerator.setDataSource(getDataSource());
        //生成策略
        autoGenerator.setStrategy(getStrategy());
         //
        //autoGenerator.setGlobalConfig(getGlobalConfig());
        //
        autoGenerator.setPackageInfo(getPackageInfo());
        // 指定模板引擎 默认是VelocityTemplateEngine ，需要引入相关引擎依赖
        autoGenerator.setTemplateEngine(new VelocityTemplateEngine());
        //autoGenerator.setTemplate(getTemplateConfig());
       // autoGenerator.setCfg(getInjectionConfig());


        // 执行生成
        autoGenerator.execute();
    }

    /**
     * 模板配置
     */
    private static TemplateConfig getTemplateConfig() {
        return new TemplateConfig()
                // 自定义模板配置，模板可以参考源码 /mybatis-plus/src/main/resources/template 使用 copy
                // 至您项目 src/main/resources/template 目录下，模板名称也可自定义如下配置：
                .setController(null)
                .setEntity(null)
                .setMapper(null)
                .setXml(null)
                .setService(null)
                .setServiceImpl(null);
    }
    /**
     * 包配置
     */
    private static PackageConfig getPackageInfo() {
        String projectPath = System.getProperty("user.dir");
        String mavenPath = "\\src\\main\\java\\";
        String srcPath = projectPath+mavenPath;

        PackageConfig pc= new PackageConfig()
                .setModuleName("com/coin")
                .setParent("com")// 自定义包路径
                .setController("controller")// 这里是控制器包名，默认 web
                .setEntity("entity")
                .setMapper("mapper")
                .setService("service")
                .setServiceImpl("service.impl")
                .setXml("mapper" );
        String moduleName = pc.getModuleName();
        Map<String,String> packageInfo = new HashMap<>();
        packageInfo.put(ConstVal.CONTROLLER, "com.study.mybatisplus.controller."+moduleName);
        packageInfo.put(ConstVal.SERVICE, "com.study.mybatisplus.services."+moduleName+".service");
        packageInfo.put(ConstVal.SERVICE_IMPL, "com.study.mybatisplus.services."+moduleName+".service.impl");
        packageInfo.put(ConstVal.ENTITY, "com.study.mybatisplus.entity."+moduleName);
        packageInfo.put(ConstVal.MAPPER, "com.study.mybatisplus.mapper."+moduleName);
        Map pathInfo = new HashMap<>();
        pathInfo.put(ConstVal.CONTROLLER_PATH, "/Users/shiyawei/IdeaProjects/coin/coin-repository/" + packageInfo.get(ConstVal.CONTROLLER).replaceAll("\\.", StringPool.BACK_SLASH + File.separator));
        pathInfo.put(ConstVal.SERVICE_PATH, srcPath +  packageInfo.get(ConstVal.SERVICE).replaceAll("\\.", StringPool.BACK_SLASH + File.separator));
        pathInfo.put(ConstVal.SERVICE_IMPL_PATH, srcPath +  packageInfo.get(ConstVal.SERVICE_IMPL).replaceAll("\\.", StringPool.BACK_SLASH + File.separator));
        pathInfo.put(ConstVal.ENTITY_PATH, srcPath +  packageInfo.get(ConstVal.ENTITY).replaceAll("\\.", StringPool.BACK_SLASH + File.separator));
        pathInfo.put(ConstVal.MAPPER_PATH, srcPath +  packageInfo.get(ConstVal.MAPPER).replaceAll("\\.", StringPool.BACK_SLASH + File.separator));
       // pathInfo.put(ConstVal.XML_PATH, projectPath+"\\src\\main\\resources\\mapper\\"+moduleName);
        pc.setPathInfo(pathInfo);


return pc;
      /*  //获取文件所在路径
        String projectPath = System.getProperty("user.dir");
        String mavenPath = "\\src\\main\\java\\";
        String srcPath = projectPath+mavenPath;

        String moduleName = pc.getModuleName();

        *//**
         * packageInfo配置controller、service、serviceImpl、entity、mapper等文件的包路径
         * 这里包路径可以根据实际情况灵活配置
         *//*
        Map<String,String> packageInfo = new HashMap<>();
        packageInfo.put(ConstVal.CONTROLLER, "com.study.mybatisplus.controller."+moduleName);
        packageInfo.put(ConstVal.SERVICE, "com.study.mybatisplus.services."+moduleName+".service");
        packageInfo.put(ConstVal.SERVICE_IMPL, "com.study.mybatisplus.services."+moduleName+".service.impl");
        packageInfo.put(ConstVal.ENTITY, "com.study.mybatisplus.entity."+moduleName);
        packageInfo.put(ConstVal.MAPPER, "com.study.mybatisplus.mapper."+moduleName);

        *//**
         * pathInfo配置controller、service、serviceImpl、entity、mapper、mapper.xml等文件的生成路径
         * srcPath也可以更具实际情况灵活配置
         * 后面部分的路径是和上面packageInfo包路径对应的源码文件夹路径
         * 这里你可以选择注释其中某些路径，可忽略生成该类型的文件，例如:注释掉下面pathInfo中Controller的路径，就不会生成Controller文件
         *//*
        Map pathInfo = new HashMap<>();
        pathInfo.put(ConstVal.CONTROLLER_PATH, srcPath + packageInfo.get(ConstVal.CONTROLLER).replaceAll("\\.", StringPool.BACK_SLASH + File.separator));
        pathInfo.put(ConstVal.SERVICE_PATH, srcPath + packageInfo.get(ConstVal.SERVICE).replaceAll("\\.", StringPool.BACK_SLASH + File.separator));
        pathInfo.put(ConstVal.SERVICE_IMPL_PATH, srcPath + packageInfo.get(ConstVal.SERVICE_IMPL).replaceAll("\\.", StringPool.BACK_SLASH + File.separator));
        pathInfo.put(ConstVal.ENTITY_PATH, srcPath + packageInfo.get(ConstVal.ENTITY).replaceAll("\\.", StringPool.BACK_SLASH + File.separator));
        pathInfo.put(ConstVal.MAPPER_PATH, srcPath + packageInfo.get(ConstVal.MAPPER).replaceAll("\\.", StringPool.BACK_SLASH + File.separator));
        pathInfo.put(ConstVal.XML_PATH, projectPath+"\\src\\main\\resources\\mapper\\"+moduleName);
        pc.setPathInfo(pathInfo);

        *//**
         * 创建configBuilder对象，传入必要的参数
         * 将以上的定义的包路径packageInfo配置到赋值到configBuilder对象的packageInfo属性上
         * 因为packageInfo是私有成员变量，也没有提交提供公共的方法，所以使用反射注入
         * 为啥要这么干，看源码去吧
         *//*
        ConfigBuilder configBuilder = new ConfigBuilder(mpg.getPackageInfo(), mpg.getDataSource(), mpg.getStrategy(), mpg.getTemplate(), mpg.getGlobalConfig());
        Field packageInfoField = configBuilder.getClass().getDeclaredField("packageInfo");
        packageInfoField.setAccessible(true);
        packageInfoField.set(configBuilder,packageInfo);*/
    }
    /**
     * 策略配置
     */
    private static StrategyConfig getStrategy() {
        List<TableFill> tableFillList = new ArrayList<>();
        tableFillList.add(new TableFill("create_by",   FieldFill.INSERT));
        tableFillList.add(new TableFill("create_time", FieldFill.INSERT));
        tableFillList.add(new TableFill("update_by",   FieldFill.INSERT_UPDATE));
        tableFillList.add(new TableFill("update_time", FieldFill.INSERT_UPDATE));

        return new StrategyConfig()
                .setCapitalMode(true) // 全局大写命名
                .setTablePrefix(new String[]{"t_"})// 此处可以修改为您的表前缀
                .setNaming(NamingStrategy.underline_to_camel)// 表名生成策略
                .setInclude(tables) // 需要生成的表
                .setRestControllerStyle(true)
                .setTableFillList(tableFillList)
                .setEntityLombokModel(true); //【实体】是否为lombok模型（默认 false

        //.setExclude(new String[]{"test"}) // 排除生成的表
        // 自定义实体父类
        // .setSuperEntityClass("com.baomidou.demo.TestEntity")
        // 自定义实体，公共字段
        //.setSuperEntityColumns(new String[]{"test_id"})
        //.setTableFillList(tableFillList)
        // 自定义 mapper 父类 默认BaseMapper
        //.setSuperMapperClass("com.baomidou.mybatisplus.mapper.BaseMapper")
        // 自定义 service 父类 默认IService
        // .setSuperServiceClass("com.baomidou.demo.TestService")
        // 自定义 service 实现类父类 默认ServiceImpl
        // .setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl")
        // 自定义 controller 父类
        //.setSuperControllerClass("com.kichun."+packageName+".controller.AbstractController")
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // .setEntityColumnConstant(true)
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        // .setEntityBuilderModel(true)
        // Boolean类型字段是否移除is前缀处理
        // .setEntityBooleanColumnRemoveIsPref  ix(true)
        // .setRestControllerStyle(true)
        // .setControllerMappingHyphenStyle(true)
    }
    /**
     * 数据库配置
     */
    private static DataSourceConfig getDataSource() {
        return new DataSourceConfig()
                .setUrl("jdbc:mysql://localhost:3306/coin?useUnicode=true&characterEncoding=utf-8&useSSL=false")
                .setDriverName("com.mysql.jdbc.Driver")
                .setUsername("root")
                //密码
                .setPassword("123456")
                .setDbType(DbType.MYSQL)
                .setTypeConvert(new MySqlTypeConvert());
    }

}
