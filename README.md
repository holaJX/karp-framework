# karp-framework
项目结构图如下：

├─.idea
│  ├─inspectionProfiles
│  └─libraries
├─.mvn
│  └─wrapper
└─src
    ├─main
    │  ├─java
    │  │  └─com
    │  │      └─framework
    │  │          └─core
    │  │              ├─cache
    │  │              ├─common
    │  │              ├─config
    │  │              ├─enums
    │  │              ├─listener
    │  │              ├─schedule
    │  │              └─usercore
    │  │                  ├─controller
    │  │                  ├─entity
    │  │                  ├─mapper
    │  │                  │  └─manpping
    │  │                  ├─service
    │  │                  │  └─impl
    │  │                  └─vo
    │  └─resources
    └─test
        └─java
            └─com
                └─framework
                    └─core
1.mybatis-plus代码自动生成
2.导出excel
3.通用工具类
4.项目启动是往Redis中写缓存