此包包含了配置文件的解析。

### 配置文件示例

```html
<session>
	<datasource>
		<url></url>
		<driver></driver>
		<user></user>
		<password></password>
	</datasource>
    <!-- session表的映射 -->
	<mapping table="">
		<id>jsessionid</id>
		<property name="" column=""/>
		<property name="" column="" class=""/>
		<property name="" column="" class=""/>
	</mapping>
  	<!-- 自定义类的映射-->
  	<class name="" table="">
       <property name="" column=""/>
       <property name="" column="" class=""/>
    </class>
</session>
```

关键是mapping的设计。

在session中可能保存各种各样的数据类型，可能是**基础类型** (包括String) 、**集合** 、**自定义类**。

### 问题

1. session中的数据那些需要保存？

   需要保存的数据配置在配置文件中，在保存时，根据key查看此数据是否需要保存。

2. 怎么保存数据？

   对于基础类型，只需要保存对应的数据即可。

   对于String类型，同样只需要保存数据即可。

   对于集合类型，使用单独的表保存，表中的数据有jessionid、value。其中jsessionid可以重符，这样就可以实现集合类型的保存。

   对于自定义类型，也需要使用单独的表，可类中可能有**嵌套类**等。

3. 怎么保存这些类？

   ​	使用orm框架事情就变得十分简单，如使用**hibernate** ，可以将类保存到数据中，我们只需要做少量的工作即可。但是Hibernate是一个重量级的框架，为了这点功能不至于使用这个框架。

    	mybatis与hibernate在使用上的区别是需要自己创建表和自己创建sql语句，它是半自动的。

   ​	一种方法是让需要保存的类**实现指定的接口**，而这个接口里面的函数就是用来保存数据，将自定义类的保存工作交给用户来完成。这样做的好处是实现较为简单，缺点是用户使用时比较麻烦。

   ​	另一种方法就是配置类的映射，利用这些映射来完成session与数据库的对应。

   ​

   ​