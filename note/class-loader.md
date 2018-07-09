### 类文件结构
 
 
##### class文件结构
    文件格式： 表和无符号数

    1.头4个字节： Magic Number
    2.5，6字节 次版本号
    3.7，8字节 主版本号
    4.常量池
    5.常量池结束后两个字节代表访问标志（access_flags）
    6.类索引、父类索引（u2类型数据）  接口索引（一组u2类型的数据集合） 由这三项确定这个类的继承关系
     
#### 常量池
    
    1.常量池入口放置u2类型数据 常量池容量计数值（计数从1开始，0项空出在特殊情况表示不引用任何一个常量池项目）
      
    2.常量池主要存放的两大类 字面量和符号引用
        
         字面量：文本字符串，声明为final的常量值
        
         符号引用: 类和接口的全限定名
                   字段的名称和描述符
                   方法的名臣和描述符
         class编译无连接步骤，连接过程在虚拟机加载class文件的时候进行动态连接
         
     3.常量池的每一项常量都是一个表 11种结构不同的表结构数据
        
         表开始的第一位是一个u1类型的标志位 tag
        
#### 类索引、父类索引、接口索引集合       
      类索引和父类索引用两个u2类型的索引值表示，各自指向一个类型为CONSTANT_Class_info的类描述符常量，通过
      CONSTANT_Class_info类型的常量中的索引值可以找到定义在CONSTANT_Utf8_info类型的常量中的全限定名字符串    
      
      接口索引集合，入口第一项是接口计数器，表示索引表容量
      

### 类加载机制

##### 类的生命周期
        加载、验证、准备、解析、初始化、使用、卸载
        
        加载、验证、准备、初始化、卸载 开始的顺序确定
        
        4种情况必须对类初始化
        1.new、getstatic、putstatic、invokestatic
        2.反射调用
        3.初始化类是、其父类未被初始化
        4、虚拟机启动时的主类
        
        常量在编译阶段会存入调用类的常量池中.
        本质没有直接引用到定义常量的类
        因此不会触发常量的类的初始化
        
        通过数组定义来引用类,不会触发此类初始化
        
        通过子类引用父类的静态字段,不会导致子类初始化
      
##### 加载
        1.通过一个类的全限定名获取定义此类的二进制字节流
        2.字节流代表的静态存储结构转化为方法区的运行时数据结构
        3.在java堆中生成一个代表这个类的java.lang.Class对象，作为方法区这些数据的访问入口
 
##### 验证
        
        连接的第一步确保class文件的字节流中包含的信息符合当前虚拟机的要求，
        并不会危害虚拟机自身的安全
        
        4个检验过程
            
            1.文件格式验证
            2.原数据验证
              语义分析 类的原数据信息进行语义校验，
              保证不存在不符合java语言规范的原数据信息 
            3.字节码验证
              进行数据流和控制流分析       
            4.符号引用验证
               在虚拟机将符号引用转化为直接引用时
               转化动作在解析阶段发生 
               对类自身以外的信息进行匹配性的校验   
               
               
##### 准备
        
        正式为类变量分配内存并设置类变量初始值的阶段
        这些内存在方法区中进行分配
        进行内存分配的仅包括类变量（static） ，而不包括实例变量
        public static int value= 123；
        准备阶段初始值为0 初始化后才有123的复制操作
        如果带有final 修饰 则准备阶段直接赋值
        
##### 解析

        虚拟机将常量池内的符号引用替换为直接引用的过程
        对同一符号引用进行多次解析请求是常见的，虚拟机实现可能对第一次解析的结果进行缓存
        一次成功，都成功，一次失败，后续收到相同异常
        
        1.类与接口的解析
           1.非数组，根据全限定名区加载加载过程出现异常，解析失败
           2.数组，加载数组元素类型
           3.解析完成之前需要进行符号验证，是否具有访问权限
       
        2.字段解析
           首先对字段表内class_index项中索引的CONSTANT_Class_info符号引用进行解析，
           也就是字段所属的类或接口的符号引用。类或接口符号引用解析出现异常
           ，导致字段符号引用解析失败。成功则
              1.c本身包含相匹配字段返回这字段的直接引用，查找结束
              2.否则，c中实现了接口，按继承关系从上往下递归搜索各个接口和他的父接口
              3.否则，c不是Object对象 继承关系从上往下递归搜索其父类，如果父类匹配，返回直接引用
              4.否则，NoSuchFieldError
         
        3.类方法解析
            先进行类或接口符号引用的解析
            1.类方法和接口方法符号引用的常量类型定义是分开的，若
            类方法表中发现class_index中的所有的C是一个接口，抛出异常
            2.在类C中查找是否又匹配的方法，有返回这个方法的直接引用
            3.C父类中递归查找是否有匹配，有直接返回直接引用
            4.c的接口列表和父接口中递归查找是否有匹配的方法，存在C是抽象类，抛异常
            5.NoSuchMethodError
            6.权限验证
         
        4.接口方法解析
            
            1.类或接口符号引用解析
            2.接口方法表中索引C是类而不是接口，抛异常
            3.否则，查询c中是否有匹配，有直接返回
            4.否则，父接口递归查询，直到Object 
            5.失败，NoSuchMethodError
           
##### 初始化
        
        类加载过程最后一步
        真正执行类中定义的java程序代码（字节码） 
        
        根据程序员通过程序制定的主观计划去初始化类变量和其他资源，
        初始化阶段是执行类构造<clinit>()方法的过程
        
        <clinit>()方法是编译器自动收集类中的所有变量的赋值动作和静态语句块（static{}块）中的语句合并
        产生的，编译器收集的顺序是由语句再源文件中出现的顺序所决定的，静态语句块中只能访问到定义再静态
        语句块之前的变量，定义在他之后的变量，再前面的静态语句块中可以赋值，但是不能访问
        
        不需要显式的调用父类构造器，虚拟机会保证在子类的<clinit>()方法执行之前，父类的<clinit>()
        方法已经执行完毕。因此在虚拟机中第一个被执行的<clinit>()方法的类肯定是Object
        
        父类的<clinit>()方法先执行，意味着父类中定义的静态语句块要优先于子类的变量赋值操作
            
        <clinit>()对于类和接口非必须 无静态语句块和赋值操作
        
        接口无静态语句块，由变量初始化的赋值操作，执行接口的《clinit>()方法不需要先执行父接口的《clinit》（）方法
        接口实现类初始化也不会执行接口的<clinit>()方法
        
        虚拟机保证一个类的<clinit>()方法在多线程环境中被正确的加锁和同步。
        
### 类加载器
       
#### 双亲委派模型
     
      Bootstrap ClassLoader 启动类加载器
      存放<JAVA_HOME>\lib 或被-Xbootclasspath参数指定的路径，并且是虚拟机识别的类库加载到虚拟机内存中
      启动类加载器无法被java程序直接引用
      
      Extension ClassLoader 扩展类加载器
      
      
      
      Application ClassLoader 应用程序类加载器
             