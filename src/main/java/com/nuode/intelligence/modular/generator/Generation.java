package com.nuode.intelligence.modular.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @author luzhenqian luzhenqian98@gmail.com
 * @created 2018-10-11-10:27
 */
public class Generation {
    public static void main(String[] args) {
        AutoGenerator autoGenerator = new AutoGenerator();

        GlobalConfig globalConfig = new GlobalConfig();
        String path = System.getProperty("user.dir") + "/src/main/java";
        globalConfig.setOutputDir("e://ggg");
        globalConfig.setFileOverride(true);
        globalConfig.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
        globalConfig.setEnableCache(false);// XML 二级缓存
        globalConfig.setBaseResultMap(true);// XML ResultMap
        globalConfig.setBaseColumnList(false);// XML columList
        globalConfig.setAuthor("luzhenqian");// 作者

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        //globalConfig.setControllerName("%sController");
        //globalConfig.setServiceName("%sService");
        //globalConfig.setServiceImplName("%sServiceImpl");
        //globalConfig.setMapperName("%sMapper");
        //globalConfig.setXmlName("%sMapper");

        autoGenerator.setGlobalConfig(globalConfig);

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("root");
        dataSourceConfig.setUrl("jdbc:mysql://127.0.0.1:3306/springboot?serverTimezone=UTC&useSSL=false");
        autoGenerator.setDataSource(dataSourceConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //strategy.setTablePrefix(new String[] { "" });// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(new String[] { "user" }); // 需要生成的表

        //strategy.setSuperServiceClass(null);
        //strategy.setSuperServiceImplClass(null);
        //strategy.setSuperMapperClass(null);
        strategy.setEntityColumnConstant(true);

        autoGenerator.setStrategy(strategy);

        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.nuode.intelligence.modular.demo");
        packageConfig.setController("controller");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");
        packageConfig.setMapper("mapper");
        packageConfig.setEntity("entity");
        packageConfig.setXml("mapper");
        autoGenerator.setPackageInfo(packageConfig);

        // 执行生成
        autoGenerator.execute();
    }
}
