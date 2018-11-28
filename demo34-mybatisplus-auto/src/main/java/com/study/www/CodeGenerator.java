package com.study.www;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author : THINK.zhuyanpeng
 * @Description: : 代码生成器
 * @date :Create in  2018/11/28- 5:30
 * @Version: V1.0
 * @Modified By:
 **/
// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
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

    public static void main(String[] args) {

        // 此处 不一定是用户的工作目录有可能说当前项目路劲下
        String projectPath = System.getProperty("user.dir");
        String classPath = Class.class.getResource("/").getPath();
        System.out.println("当前的工作路劲为："+projectPath);
        System.out.println("当前的运行路劲为："+classPath);
        String scanner = scanner("请输入当前的生成根路劲(eg:E://wrokproject/demo1)若以工作路劲为标准请输入1，以运行路劲为标准请输入2，否则请自定义路劲，默认(1)");
        String rootPath = "";
        if (StringUtils.isNotEmpty(scanner)){
            if ("1".equals(scanner)){
                rootPath = projectPath;
            }
            if ("2".equals(scanner)){
                rootPath = classPath;
            }
            if (StringUtils.isEmpty(rootPath)){
                rootPath = scanner;
            }
            if (rootPath.endsWith("/")){
                rootPath = rootPath.substring(0, rootPath.length() - 1);
            }
            rootPath =rootPath+"/src/main";
        }
        System.out.println("当前文件生成目录如下=>"+rootPath);
        String modelName = scanner("模块名(eg:role)");
        String parentStr = scanner("类名(eg:com.baomidou.ant)");
        String includeStr = scanner("表名 多个以，号间隔");
        String[] split = includeStr.split(",");
        for (String include : split) {
            // 代码生成器
            AutoGenerator mpg = new AutoGenerator();

            // 全局配置
            GlobalConfig gc = new GlobalConfig();
            gc.setOutputDir(rootPath+"/java");
            gc.setAuthor("jobob");
            gc.setOpen(false);
            mpg.setGlobalConfig(gc);

            // 数据源配置
            DataSourceConfig dsc = new DataSourceConfig();
            dsc.setUrl("jdbc:mysql://118.25.230.159:3306/wisp?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai");
            dsc.setDriverName("com.mysql.jdbc.Driver");
            dsc.setUsername("root");
            dsc.setPassword("WHsunjee_2018");
            mpg.setDataSource(dsc);

            // 包配置
            PackageConfig pc = new PackageConfig();
            pc.setModuleName(modelName);
            pc.setParent(parentStr);
            mpg.setPackageInfo(pc);

            // 自定义配置
            InjectionConfig cfg = new InjectionConfig() {
                @Override
                public void initMap() {
                    // to do nothing
                }
            };
            List<FileOutConfig> focList = new ArrayList<>();
            String finalRootPath = rootPath;
            focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输入文件名称
                    return finalRootPath + "/resources/mapper/" + pc.getModuleName()
                            + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                }
            });
            cfg.setFileOutConfigList(focList);
            mpg.setCfg(cfg);
            mpg.setTemplate(new TemplateConfig().setXml(null));
            // 策略配置
            StrategyConfig strategy = new StrategyConfig();
            strategy.setNaming(NamingStrategy.underline_to_camel);
            strategy.setColumnNaming(NamingStrategy.underline_to_camel);
            strategy.setEntityLombokModel(true);
            strategy.setRestControllerStyle(true);
            strategy.setInclude(include);
            // 忽略Id
            strategy.setSuperEntityColumns("id");
            strategy.setControllerMappingHyphenStyle(true);
            strategy.setTablePrefix(pc.getModuleName() + "_");
            mpg.setStrategy(strategy);
            mpg.setTemplateEngine(new FreemarkerTemplateEngine());
            mpg.execute();
        }
    }

}
