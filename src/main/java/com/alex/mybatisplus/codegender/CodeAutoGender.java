package com.alex.mybatisplus.codegender;

import com.baomidou.mybatisplus.annotation.DbType;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;



public class CodeAutoGender {
  public static void main(String[] args) {
    //
//构建一个代码生成器对象
      AutoGenerator mpg = new AutoGenerator();
      //配置策略

    //1 全局配置
      GlobalConfig gc = new GlobalConfig();
      gc.setOutputDir(System.getProperty("user.dir") + "/src/main/java");  //在项目的那个路径下生成文件
      gc.setAuthor("alexge");  //是否生成作者
      gc.setOpen(false);//生成完毕是否打开资源管理器
      gc.setFileOverride(false);//是否需要覆盖原来的位置
      gc.setServiceName("%sService");//去Service的I前缀
      gc.setIdType(IdType.AUTO);  //自动生成主键策略，有四种
      gc.setDateType(DateType.ONLY_DATE); //设置日期的策略

      gc.setBaseResultMap(true);  //是否开启xml映射
      gc.setActiveRecord(true);   //自己查看官网配置文件
      // gc.setKotlin(true); // 这个不太了解，但是不能开

      gc.setSwagger2(true);  //自动生成swagger
    gc.setEnableCache(true);  //开启mybatis的二级缓存
      mpg.setGlobalConfig(gc);

      // 2设置数据源
      DataSourceConfig dc = new DataSourceConfig();
        dc.setUrl("jdbc:mysql://localhost:3306/db2?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8");
        dc.setDriverName("com.mysql.cj.jdbc.Driver");
        dc.setUsername("root");
        dc.setPassword("root");
        dc.setDbType(DbType.MYSQL);  //配置数据库的格式，可以是orcal

        mpg.setDataSource(dc);


      //3包的配置
      PackageConfig packageConfig = new PackageConfig();
      packageConfig.setEntity("pojo");  //实体类的名字
      packageConfig.setMapper("mapper");  //mapper接口
      packageConfig.setController("controller");//controller
      packageConfig.setParent("com.alex"); //到那个指定的父路径
      packageConfig.setModuleName("autogender1"); //在父路径下生成的包命
      mpg.setPackageInfo(packageConfig);


      //4策略配置

      StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setInclude("person"); //设置要映射的表名
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);  //设置命名为统一下划线小写，有其他的格式也可以设置
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityLombokModel(true);  //是否使用lombok
        strategyConfig.setRestControllerStyle(true); //开启链式编程
      strategyConfig.setEnableSqlFilter(true);   //不太明白
      strategyConfig.setFieldPrefix("123");//不太明白
      strategyConfig.setChainModel(true);//不太明白
      strategyConfig.setEntitySerialVersionUID(true);//设置实体类的序列化唯一id,有其他策略可以自己配置

         // strategyConfig.setLogicDeleteFieldName("deleted")//逻辑删除的名字,没有的话不用配置


      //自动填充配置
  TableFill gmt_create = new TableFill("gmt_create", FieldFill.INSERT);  //国际标准插入时间

     TableFill gmt_modified = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);//修改和插入式的时间

      List<TableFill> tableFills = new ArrayList<>();
      tableFills.add(gmt_modified);
      tableFills.add(gmt_create);
      strategyConfig.setTableFillList(tableFills);


      //乐观锁配置

     strategyConfig.setVersionFieldName("version"); //开启乐观锁
      strategyConfig.setRestControllerStyle(true); //开启retful的驼峰命名
      strategyConfig.setControllerMappingHyphenStyle(true); //开启下划线url

      mpg.setStrategy(strategyConfig);
      //执行代码构造器
      mpg.execute();

  }
}
