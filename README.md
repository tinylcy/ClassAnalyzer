## ClassAnalyzer

Yet another Java class file disassembler.

### Purpose

The purpose of ClassAnalyzer is to help me understand Java class file thoroughly.

More details: [如何实现一个 Java Class 解析器](http://tinylcy.me/2017/02/12/%E5%A6%82%E4%BD%95%E5%AE%9E%E7%8E%B0%E4%B8%80%E4%B8%AAJava-Class%E8%A7%A3%E6%9E%90%E5%99%A8/).

### Demo

**TestClass.java**

```java
package org.tinylcy;

public class TestClass implements Cloneable {

    public static final String TAG = "tinylcy";
    private int num;

    public void inc() {
        num++;
    }

    public int exception() {
        int x;
        try {
            x = 1;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }
    }

    public static void showTag() {
        System.out.println(TAG);
    }
}
```

**TestClass.class**

```byte
cafe babe 0000 0031 0030 0a00 0800 1f09
0005 0020 0700 2109 0022 0023 0700 2408
0025 0a00 2600 2707 0028 0700 2901 0003
5441 4701 0012 4c6a 6176 612f 6c61 6e67
2f53 7472 696e 673b 0100 0d43 6f6e 7374
616e 7456 616c 7565 0100 036e 756d 0100
0149 0100 063c 696e 6974 3e01 0003 2829
5601 0004 436f 6465 0100 0f4c 696e 654e
756d 6265 7254 6162 6c65 0100 124c 6f63
616c 5661 7269 6162 6c65 5461 626c 6501
0004 7468 6973 0100 174c 6f72 672f 7469
6e79 6c63 792f 5465 7374 436c 6173 733b
0100 0369 6e63 0100 0965 7863 6570 7469
6f6e 0100 0328 2949 0100 0178 0100 0165
0100 154c 6a61 7661 2f6c 616e 672f 4578
6365 7074 696f 6e3b 0100 0773 686f 7754
6167 0100 0a53 6f75 7263 6546 696c 6501
000e 5465 7374 436c 6173 732e 6a61 7661
0c00 0f00 100c 000d 000e 0100 136a 6176
612f 6c61 6e67 2f45 7863 6570 7469 6f6e
0700 2a0c 002b 002c 0100 156f 7267 2f74
696e 796c 6379 2f54 6573 7443 6c61 7373
0100 0774 696e 796c 6379 0700 2d0c 002e
002f 0100 106a 6176 612f 6c61 6e67 2f4f
626a 6563 7401 0013 6a61 7661 2f6c 616e
672f 436c 6f6e 6561 626c 6501 0010 6a61
7661 2f6c 616e 672f 5379 7374 656d 0100
036f 7574 0100 154c 6a61 7661 2f69 6f2f
5072 696e 7453 7472 6561 6d3b 0100 136a
6176 612f 696f 2f50 7269 6e74 5374 7265
616d 0100 0770 7269 6e74 6c6e 0100 1528
4c6a 6176 612f 6c61 6e67 2f53 7472 696e
673b 2956 0021 0005 0008 0001 0009 0002
0019 000a 000b 0001 000c 0000 0002 0006
0002 000d 000e 0000 0004 0001 000f 0010
0001 0011 0000 002f 0001 0001 0000 0005
2ab7 0001 b100 0000 0200 1200 0000 0600
0100 0000 0600 1300 0000 0c00 0100 0000
0500 1400 1500 0000 0100 1600 1000 0100
1100 0000 3900 0300 0100 0000 0b2a 59b4
0002 0460 b500 02b1 0000 0002 0012 0000
000a 0002 0000 000c 000a 000d 0013 0000
000c 0001 0000 000b 0014 0015 0000 0001
0017 0018 0001 0011 0000 00ae 0001 0005
0000 0018 043c 1b3d 063c 1cac 4d05 3c1b
3e06 3c1d ac3a 0406 3c19 04bf 0004 0000
0004 0008 0003 0000 0004 0011 0000 0008
000d 0011 0000 0011 0013 0011 0000 0002
0012 0000 002a 000a 0000 0012 0002 0013
0004 0018 0006 0013 0008 0014 0009 0015
000b 0016 000d 0018 000f 0016 0011 0018
0013 0000 0034 0005 0002 0006 0019 000e
0001 0009 0008 001a 001b 0002 000b 0006
0019 000e 0001 0000 0018 0014 0015 0000
0015 0003 0019 000e 0001 0009 001c 0010
0001 0011 0000 0025 0002 0000 0000 0009
b200 0412 06b6 0007 b100 0000 0100 1200
0000 0a00 0200 0000 1d00 0800 1e00 0100
1d00 0000 0200 1e
```

#### Running the examples

```java
public class ClassFileTest {

    @Test
    public void classfile() throws Exception {
        File file = new File("/path/to/TestClass.class");
        FileInputStream inputStream = new FileInputStream(file);
        ClassReader.analyze(inputStream);
    }
}
```

#### Output

```markdown
magic = cafebabe
minorVersion = 0
majorVersion = 49
constantPoolCount = 48
cpInfo[1] = ConstantMethodRefInfo{classIndex=8, nameAndTypeIndex=31}
cpInfo[2] = ConstantFieldRefInfo{classIndex=5, nameAndTypeIndex=32}
cpInfo[3] = ConstantClassInfo{index=33}
cpInfo[4] = ConstantFieldRefInfo{classIndex=34, nameAndTypeIndex=35}
cpInfo[5] = ConstantClassInfo{index=36}
cpInfo[6] = ConstantClassInfo{index=37}
cpInfo[7] = ConstantMethodRefInfo{classIndex=38, nameAndTypeIndex=39}
cpInfo[8] = ConstantClassInfo{index=40}
cpInfo[9] = ConstantClassInfo{index=41}
cpInfo[10] = ConstantUtf8Info{bytesValue='TAG'}
cpInfo[11] = ConstantUtf8Info{bytesValue='Ljava/lang/String;'}
cpInfo[12] = ConstantUtf8Info{bytesValue='ConstantValue'}
cpInfo[13] = ConstantUtf8Info{bytesValue='num'}
cpInfo[14] = ConstantUtf8Info{bytesValue='I'}
cpInfo[15] = ConstantUtf8Info{bytesValue='<init>'}
cpInfo[16] = ConstantUtf8Info{bytesValue='()V'}
cpInfo[17] = ConstantUtf8Info{bytesValue='Code'}
cpInfo[18] = ConstantUtf8Info{bytesValue='LineNumberTable'}
cpInfo[19] = ConstantUtf8Info{bytesValue='LocalVariableTable'}
cpInfo[20] = ConstantUtf8Info{bytesValue='this'}
cpInfo[21] = ConstantUtf8Info{bytesValue='Lorg/tinylcy/TestClass;'}
cpInfo[22] = ConstantUtf8Info{bytesValue='inc'}
cpInfo[23] = ConstantUtf8Info{bytesValue='exception'}
cpInfo[24] = ConstantUtf8Info{bytesValue='()I'}
cpInfo[25] = ConstantUtf8Info{bytesValue='x'}
cpInfo[26] = ConstantUtf8Info{bytesValue='e'}
cpInfo[27] = ConstantUtf8Info{bytesValue='Ljava/lang/Exception;'}
cpInfo[28] = ConstantUtf8Info{bytesValue='showTag'}
cpInfo[29] = ConstantUtf8Info{bytesValue='SourceFile'}
cpInfo[30] = ConstantUtf8Info{bytesValue='TestClass.java'}
cpInfo[31] = ConstantNameAndTypeInfo{nameIndex=15, descriptorIndex=16}
cpInfo[32] = ConstantNameAndTypeInfo{nameIndex=13, descriptorIndex=14}
cpInfo[33] = ConstantUtf8Info{bytesValue='java/lang/Exception'}
cpInfo[34] = ConstantClassInfo{index=42}
cpInfo[35] = ConstantNameAndTypeInfo{nameIndex=43, descriptorIndex=44}
cpInfo[36] = ConstantUtf8Info{bytesValue='org/tinylcy/TestClass'}
cpInfo[37] = ConstantUtf8Info{bytesValue='tinylcy'}
cpInfo[38] = ConstantClassInfo{index=45}
cpInfo[39] = ConstantNameAndTypeInfo{nameIndex=46, descriptorIndex=47}
cpInfo[40] = ConstantUtf8Info{bytesValue='java/lang/Object'}
cpInfo[41] = ConstantUtf8Info{bytesValue='java/lang/Cloneable'}
cpInfo[42] = ConstantUtf8Info{bytesValue='java/lang/System'}
cpInfo[43] = ConstantUtf8Info{bytesValue='out'}
cpInfo[44] = ConstantUtf8Info{bytesValue='Ljava/io/PrintStream;'}
cpInfo[45] = ConstantUtf8Info{bytesValue='java/io/PrintStream'}
cpInfo[46] = ConstantUtf8Info{bytesValue='println'}
cpInfo[47] = ConstantUtf8Info{bytesValue='(Ljava/lang/String;)V'}
accessFlags = 21, public super 
thisClass = 5, this class name = org/tinylcy/TestClass
superClass = 8, super class name = java/lang/Object
interfacesCount = 1
interfaces[0] = 9, interface name = java/lang/Cloneable
fieldsCount = 2
fields[0] = FieldInfo{accessFlags=25: public static final , nameIndex=10 [name = TAG], descriptorIndex=11 [descriptor = Ljava/lang/String;], attributesCount=1, attributes=[]}
fields[1] = FieldInfo{accessFlags=2: private , nameIndex=13 [name = num], descriptorIndex=14 [descriptor = I], attributesCount=0, attributes=[]}
methodsCount = 4
methods[0] = MethodInfo{accessFlags=1: public , nameIndex=15 [name = <init>], descriptorIndex=16 [descriptor = ()V], attributesCount=1, attributes=[Code{attributeNameIndex=17 [attribute name = Code], attributeLength=47, maxStack=1, maxLocals=1, codeLength=5, code=[42, -73, 0, 1, -79], exceptionTableLength=0, exceptionTable=[], attributesCount=2, attributes=[LineNumberTable{attributeNameIndex=18 [attribute name = LineNumberTable], attributeLength=6, lineNumberTableLength=1, lineNumberTable=[LineNumberInfo{startPc=0, lineNumber=6}]}, LocalVariableTable{attributeNameIndex=19 [attribute name = LocalVariableTable], attributeLength=12, localVariableTableLength=1}]}]}
methods[1] = MethodInfo{accessFlags=1: public , nameIndex=22 [name = inc], descriptorIndex=16 [descriptor = ()V], attributesCount=1, attributes=[Code{attributeNameIndex=17 [attribute name = Code], attributeLength=57, maxStack=3, maxLocals=1, codeLength=11, code=[42, 89, -76, 0, 2, 4, 96, -75, 0, 2, -79], exceptionTableLength=0, exceptionTable=[], attributesCount=2, attributes=[LineNumberTable{attributeNameIndex=18 [attribute name = LineNumberTable], attributeLength=10, lineNumberTableLength=2, lineNumberTable=[LineNumberInfo{startPc=0, lineNumber=12}, LineNumberInfo{startPc=10, lineNumber=13}]}, LocalVariableTable{attributeNameIndex=19 [attribute name = LocalVariableTable], attributeLength=12, localVariableTableLength=1}]}]}
methods[2] = MethodInfo{accessFlags=1: public , nameIndex=23 [name = exception], descriptorIndex=24 [descriptor = ()I], attributesCount=1, attributes=[Code{attributeNameIndex=17 [attribute name = Code], attributeLength=174, maxStack=1, maxLocals=5, codeLength=24, code=[4, 60, 27, 61, 6, 60, 28, -84, 77, 5, 60, 27, 62, 6, 60, 29, -84, 58, 4, 6, 60, 25, 4, -65], exceptionTableLength=4, exceptionTable=[ExceptionInfo{startPc=0, endPc=4, handlerPc=8, catchType=3}, ExceptionInfo{startPc=0, endPc=4, handlerPc=17, catchType=0}, ExceptionInfo{startPc=8, endPc=13, handlerPc=17, catchType=0}, ExceptionInfo{startPc=17, endPc=19, handlerPc=17, catchType=0}], attributesCount=2, attributes=[LineNumberTable{attributeNameIndex=18 [attribute name = LineNumberTable], attributeLength=42, lineNumberTableLength=10, lineNumberTable=[LineNumberInfo{startPc=0, lineNumber=18}, LineNumberInfo{startPc=2, lineNumber=19}, LineNumberInfo{startPc=4, lineNumber=24}, LineNumberInfo{startPc=6, lineNumber=19}, LineNumberInfo{startPc=8, lineNumber=20}, LineNumberInfo{startPc=9, lineNumber=21}, LineNumberInfo{startPc=11, lineNumber=22}, LineNumberInfo{startPc=13, lineNumber=24}, LineNumberInfo{startPc=15, lineNumber=22}, LineNumberInfo{startPc=17, lineNumber=24}]}, LocalVariableTable{attributeNameIndex=19 [attribute name = LocalVariableTable], attributeLength=52, localVariableTableLength=5}]}]}
methods[3] = MethodInfo{accessFlags=9: public static , nameIndex=28 [name = showTag], descriptorIndex=16 [descriptor = ()V], attributesCount=1, attributes=[Code{attributeNameIndex=17 [attribute name = Code], attributeLength=37, maxStack=2, maxLocals=0, codeLength=9, code=[-78, 0, 4, 18, 6, -74, 0, 7, -79], exceptionTableLength=0, exceptionTable=[], attributesCount=1, attributes=[LineNumberTable{attributeNameIndex=18 [attribute name = LineNumberTable], attributeLength=10, lineNumberTableLength=2, lineNumberTable=[LineNumberInfo{startPc=0, lineNumber=29}, LineNumberInfo{startPc=8, lineNumber=30}]}]}]}
attributesCount = 1
attributes[0] = SourceFile{attributeNameIndex=29 [attribute name = SourceFile], attributeLength=2, sourceFileIndex=30}
```

#### Bytes analysis

```markdow
cafe babe : magic
0000 : minor version
0034 : major version

0030 : constant pool count
0a : tag
00 08 : class index
00 1f : nameAndType index
09 : tag
0005 : class index
0020 : nameAndType index
07 : tag
00 21 : index
09 : tag
0022 : class index
0023 : nameAndType index
07 : tag
00 24 : index
08 : tag
0025 : index
0a : tag
0026 : class index
0027 : nameAndType index
07 : tag
0028 : index
07 : tag
00 29 : index
01 : tag
0003 : length
5441 47 : bytes
01 : tag
0012 : length
4c6a 6176 612f 6c61 6e67 2f53 7472 696e 673b : bytes
01 : tag
00 0d : 13
43 6f6e 7374 616e 7456 616c 7565 : bytes
01 : tag
00 03 : length
6e 756d : bytes
01 : tag
00 01 : length
49 : bytes
01 : tag
00 06 : length
3c 696e 6974 3e : bytes
01 : tag
0003 : length
2829 56 : bytes
01 : tag
0004 : length
436f 6465 : bytes
01 : tag
00 0f : length
4c 696e 654e 756d 6265 7254 6162 6c65 : bytes
01 : tag
00 12 : length
4c 6f63 616c 5661 7269 6162 6c65 5461 626c 65 : bytes
01 : tag
0004 : length
7468 6973 : bytes
01 : tag
00 17 : length
4c 6f72 672f 7469 6e79 6c63 792f 5465 7374 436c 6173 733b : bytes
01 : tag
00 03 : length
69 6e63 : bytes
01 : tag
00 09 : length
65 7863 6570 7469 6f6e : bytes
01 : tag
00 03 : length
28 2949 : bytes
01 : tag
00 01 : length
78 : bytes
01 : tag
00 01 : length
65 : bytes
01 : tag
00 15 : length
4c 6a61 7661 2f6c 616e 672f 4578 6365 7074 696f 6e3b : bytes
01 : tag
00 07 : length
73 686f 7754 6167 : bytes
01 : tag
00 0a : length
53 6f75 7263 6546 696c 65 : bytes
01 : tag
000e : length
5465 7374 436c 6173 732e 6a61 7661 : byte
0c : tag
00 0f : name index
00 10 : descriptor index
0c : tag
000d : name index
000e : descriptor index
01 : tag
00 13 : length
6a 6176 612f 6c61 6e67 2f45 7863 6570 7469 6f6e : bytes
07 : tag
00 2a : index
0c : tag
002b : name index
002c : descriptor index
01 : tag
00 15 : length
6f 7267 2f74 696e 796c 6379 2f54 6573 7443 6c61 7373 : bytes
01 : tag
00 07 : length
74 696e 796c 6379 : bytes
07 : tag
00 2d : index
0c : tag
002e : name index
002f : descriptor index
01 : tag
00 10 : length
6a 6176 612f 6c61 6e67 2f4f 626a 6563 74 : bytes
01 : tag
0013 : length
6a61 7661 2f6c 616e 672f 436c 6f6e 6561 626c 65 : bytes
01 : tag
0010 : length
6a61 7661 2f6c 616e 672f 5379 7374 656d : bytes
01 : tag
00 03 : length
6f 7574 : bytes
01 : tag
00 15 : length
4c 6a61 7661 2f69 6f2f 5072 696e 7453 7472 6561 6d3b : bytes
01 : tag
00 13 : length
6a 6176 612f 696f 2f50 7269 6e74 5374 7265 616d : bytes
01 : tag
00 07 : length
70 7269 6e74 6c6e : bytes
01 : tag
00 15 : length
28 4c6a 6176 612f 6c61 6e67 2f53 7472 696e 673b 2956 bytes

0021 : access flags
0005 : this class
0008 : super class

0001 : interfaces count
0009 : interfaces

0002 : fields count
0019 : access flags
000a : name index
000b : descriptor index
0001 : attributes count
000c : attribute name index
0000 0002 : attribute length
0006 : constant value index
0002 : access flags
000d : name index
000e : descriptor index
0000 : attribute count

0004 : methods count
0001 : access flags
000f : name index
0010 : descriptor index
0001 : attributes count
0011 : attribute name index
0000 002f : attribute length
0001 : max stack
0001 : max locals
0000 0005 : code length
2ab7 0001 b1 : code
00 00 : exception table length
00 02 : attributes count
00 12 : attribute name index
00 0000 06 : attribute length
00 01 : line number table length
00 00 : start pc
00 06 : line number
00 13 : attribute name index
00 0000 0c : attribute length
00 01 : local variable table length
00 00 : start pc
00 05 : length
00 14 : name index
00 15 : descriptor index
00 00 : index
00 01 : access flags
00 16 : name index
00 10 : descriptor index
00 01 : attributes count
00 11 : attribute name index
00 0000 39 : attribute length
00 03 : max stack
00 01 : max locals
00 0000 0b : code length
2a 59b4 0002 0460 b500 02b1 : code
0000 : exception table length
0002 : attributes count
0012 : attribute name index
0000 000a : attribute length
0002 : line number table length
0000 : start pc
000c : line number
000a : start pc
000d : line number
0013 : attribute name index
0000 000c : attribute length
0001 : local variable table length
0000 : start pc
000b : length
0014 : name index
0015 : descriptor index
0000 : index
0001 : access flags
0017 : name index
0018 : descriptor index
0001 : attributes count
0011 : attribute name index
0000 00ae : attribute length
0001 : max stack
0005 : max locals
0000 0018 : code length
043c 1b3d 063c 1cac 4d05 3c1b 3e06 3c1d ac3a 0406 3c19 04bf : code
0004 : exception table length
0000 : start pc
0004 : end pc
0008 : handler pc
0003 : catch type
0000 : start pc
0004 : end pc
0011 : handler pc
0000 : catch type
0008 : start pc
000d : end pc
0011 : handler pc
0000 : catch type
0011 : start pc
0013 : end pc
0011 : handler pc
0000 : catch type
0002 : attributes count
0012 : attribute name index
0000 002a : attribute length
000a : line number table length
0000 : start pc
0012 : line number
0002 : start pc
0013 : line number
0004 : start pc
0018 : line number
0006 : start pc
0013 : line number
0008 : start pc
0014 : line number
0009 : start pc
0015 : line number
000b : start pc
0016 : line number
000d : start pc
0018 : line number
000f : start pc
0016 : line number
0011 : start pc
0018 : line number
0013 : attribute name index
0000 0034 : attribute length
0005 : local variable table length
0002 : start pc
0006 : length
0019 : name index
000e : descriptor index
0001 : index
0009 : start pc
0008 : length
001a : name index
001b : descriptor index
0002 : index
000b : start pc
0006 : length
0019 : name index
000e : descriptor index
0001 : index
0000 : start pc
0018 : length
0014 : name index
0015 : descriptor index
0000 : index
0015 : start pc
0003 : length
0019 : name index
000e : descriptor index
0001 : index
0009 : access flags
001c : name index
0010 : descriptor index
0001 : attributes count
0011 : attribute name index
0000 0025 : attribute length
0002 : max stack
0000 : max locals
0000 0009 : code length
b200 0412 06b6 0007 b1 : code
00 00 : exception table length
00 01 : attributes count
00 12 : attribute name index
00 0000 0a : attribute length
00 02 : line number table
00 00 : start pc
00 1d : line number
00 08 : start pc
00 1e : line number

00 01 : attributes count    
00 1d : attribute name index
00 0000 02 : attribute length
00 1e : source file index
```

