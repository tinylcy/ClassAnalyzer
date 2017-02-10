## ClassAnalyzer

Yet another Java class file disassembler.

### Purpose

The purpose of ClassAnalyzer is to help me understand Java class file thoroughly.

### Demo

**TestClass.java**

```java
package org.tinylcy.clazz;

public class TestClass implements Cloneable {

	private int m;

	public int inc() {
		return m + 1;
	}
}
```

**TestClass.class**

```byte
cafe babe 0000 0034 0015 0a00 0400 1009
0003 0011 0700 1207 0013 0700 1401 0001
6d01 0001 4901 0006 3c69 6e69 743e 0100
0328 2956 0100 0443 6f64 6501 000f 4c69
6e65 4e75 6d62 6572 5461 626c 6501 0003
696e 6301 0003 2829 4901 000a 536f 7572
6365 4669 6c65 0100 0e54 6573 7443 6c61
7373 2e6a 6176 610c 0008 0009 0c00 0600
0701 001b 6f72 672f 7469 6e79 6c63 792f
636c 617a 7a2f 5465 7374 436c 6173 7301
0010 6a61 7661 2f6c 616e 672f 4f62 6a65
6374 0100 136a 6176 612f 6c61 6e67 2f43
6c6f 6e65 6162 6c65 0021 0003 0004 0001
0005 0001 0002 0006 0007 0000 0002 0001
0008 0009 0001 000a 0000 001d 0001 0001
0000 0005 2ab7 0001 b100 0000 0100 0b00
0000 0600 0100 0000 0300 0100 0c00 0d00
0100 0a00 0000 1f00 0200 0100 0000 072a
b400 0204 60ac 0000 0001 000b 0000 0006
0001 0000 0008 0001 000e 0000 0002 000f
```

#### Running the examples

```java
public class ClassFileTest {

    @Test
    public void classfile() throws Exception {
        File file = new File("path/to/TestClass.class");
        FileInputStream inputStream = new FileInputStream(file);
        ClassReader.read(inputStream);
    }
}
```

#### Output

```java
magic = cafebabe
minorVersion = 0
majorVersion = 52
constantPoolCount = 21
cpInfo[1] = ConstantMethodRefInfo{classIndex=4, nameAndTypeIndex=16}
cpInfo[2] = ConstantFieldRefInfo{classIndex=3, nameAndTypeIndex=17}
cpInfo[3] = ConstantClassInfo{index=18}
cpInfo[4] = ConstantClassInfo{index=19}
cpInfo[5] = ConstantClassInfo{index=20}
cpInfo[6] = ConstantUtf8Info{bytesValue='m'}
cpInfo[7] = ConstantUtf8Info{bytesValue='I'}
cpInfo[8] = ConstantUtf8Info{bytesValue='<init>'}
cpInfo[9] = ConstantUtf8Info{bytesValue='()V'}
cpInfo[10] = ConstantUtf8Info{bytesValue='Code'}
cpInfo[11] = ConstantUtf8Info{bytesValue='LineNumberTable'}
cpInfo[12] = ConstantUtf8Info{bytesValue='inc'}
cpInfo[13] = ConstantUtf8Info{bytesValue='()I'}
cpInfo[14] = ConstantUtf8Info{bytesValue='SourceFile'}
cpInfo[15] = ConstantUtf8Info{bytesValue='TestClass.java'}
cpInfo[16] = ConstantNameAndTypeInfo{nameIndex=8, descriptorIndex=9}
cpInfo[17] = ConstantNameAndTypeInfo{nameIndex=6, descriptorIndex=7}
cpInfo[18] = ConstantUtf8Info{bytesValue='org/tinylcy/clazz/TestClass'}
cpInfo[19] = ConstantUtf8Info{bytesValue='java/lang/Object'}
cpInfo[20] = ConstantUtf8Info{bytesValue='java/lang/Cloneable'}
accessFlags = 21
thisClass = 3
superClass = 4
interfacesCount = 1
interfaces[0] = 5
fieldsCount = 1
fields[0] = FieldInfo{accessFlags=2, nameIndex=6, descriptorIndex=7, attributesCount=0, attributes=[]}
methodsCount = 2
methods[0] = MethodInfo{accessFlags=1, nameIndex=8, descriptorIndex=9, attributesCount=1, attributes=[Code{attributeNameIndex=10, attributeLength=29, maxStack=1, maxLocals=1, codeLength=5, code=[42, -73, 0, 1, -79], exceptionTableLength=0, exceptionTable=[], attributesCount=1, attributes=[LineNumberTable{attributeNameIndex=11, attributeLength=6, lineNumberTableLength=1, lineNumberTable=[LineNumberInfo{startPc=0, lineNumber=3}]}]}]}
methods[1] = MethodInfo{accessFlags=1, nameIndex=12, descriptorIndex=13, attributesCount=1, attributes=[Code{attributeNameIndex=10, attributeLength=31, maxStack=2, maxLocals=1, codeLength=7, code=[42, -76, 0, 2, 4, 96, -84], exceptionTableLength=0, exceptionTable=[], attributesCount=1, attributes=[LineNumberTable{attributeNameIndex=11, attributeLength=6, lineNumberTableLength=1, lineNumberTable=[LineNumberInfo{startPc=0, lineNumber=8}]}]}]}
attributesCount = 1
attributes[0] = SourceFile{attributeNameIndex=14, attributeLength=2, sourceFileIndex=15}
```

