 1.Springboot在启动的时候，从类路径下/meta-INF/Spring。获取指定的值因子；
 2.将这些自动配置的类导入容器，自动配置就会生效，帮我进行自动配置!
 3.以前我们需要自动配置的东西，现在Spring帮我们做了！
 4.整合javaEE,解决方案和自动配置的东西都在spring-boot-autoconfigure-2.2.0.RELEASE.jar这个包下
 5.它会把所有需要导入的组件,以类名的方式返回，这些组件就会被添加到容器;
 6.容器中也会存在非常多的xxAutoConfiguration的文件(@Bean),就是这些类给容器中导入了这个场景需要的所有组件;
 并自动配置，@Configuration ，JavaConfig!
 7.有了自动配置类，免去了我们手动编写配置文件的工作!






